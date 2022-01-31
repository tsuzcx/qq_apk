package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.c;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  private boolean mStarted = false;
  ArrayList<Transition> sE = new ArrayList();
  private boolean sF = true;
  private int sG;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rJ);
    V(c.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void C(View paramView)
  {
    super.C(paramView);
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.sE.get(i)).C(paramView);
      i += 1;
    }
  }
  
  public final void D(View paramView)
  {
    super.D(paramView);
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.sE.get(i)).D(paramView);
      i += 1;
    }
  }
  
  public final TransitionSet V(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + paramInt);
    case 1: 
      this.sF = false;
      return this;
    }
    this.sF = true;
    return this;
  }
  
  public final Transition W(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.sE.size())) {
      return null;
    }
    return (Transition)this.sE.get(paramInt);
  }
  
  public final void a(Transition.b paramb)
  {
    super.a(paramb);
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.sE.get(i)).a(paramb);
      i += 1;
    }
  }
  
  public final void a(ag paramag)
  {
    super.a(paramag);
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.sE.get(i)).a(paramag);
      i += 1;
    }
  }
  
  public final void a(ai paramai)
  {
    if (z(paramai.view))
    {
      Iterator localIterator = this.sE.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.z(paramai.view))
        {
          localTransition.a(paramai);
          paramai.sM.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, aj paramaj1, aj paramaj2, ArrayList<ai> paramArrayList1, ArrayList<ai> paramArrayList2)
  {
    long l1 = this.rO;
    int j = this.sE.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.sE.get(i);
      if ((l1 > 0L) && ((this.sF) || (i == 0)))
      {
        long l2 = localTransition.rO;
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.h(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramaj1, paramaj2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label104:
        localTransition.h(l1);
      }
    }
  }
  
  public final TransitionSet b(TimeInterpolator paramTimeInterpolator)
  {
    return (TransitionSet)super.a(paramTimeInterpolator);
  }
  
  public final void b(ai paramai)
  {
    if (z(paramai.view))
    {
      Iterator localIterator = this.sE.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.z(paramai.view))
        {
          localTransition.b(paramai);
          paramai.sM.add(localTransition);
        }
      }
    }
  }
  
  public final Transition bA()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.bA();
    localTransitionSet.sE = new ArrayList();
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.d(((Transition)this.sE.get(i)).bA());
      i += 1;
    }
    return localTransitionSet;
  }
  
  protected final void bz()
  {
    if (this.sE.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new TransitionSet.a(this);
      Iterator localIterator = this.sE.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.c)localObject);
      }
      this.sG = this.sE.size();
      if (!this.sF)
      {
        int i = 1;
        while (i < this.sE.size())
        {
          ((Transition)this.sE.get(i - 1)).a(new TransitionSet.1(this, (Transition)this.sE.get(i)));
          i += 1;
        }
        localObject = (Transition)this.sE.get(0);
        if (localObject != null) {
          ((Transition)localObject).bz();
        }
      }
      else
      {
        localObject = this.sE.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).bz();
        }
      }
    }
  }
  
  public final TransitionSet d(Transition paramTransition)
  {
    this.sE.add(paramTransition);
    paramTransition.se = this;
    if (this.mDuration >= 0L) {
      paramTransition.g(this.mDuration);
    }
    return this;
  }
  
  final void d(ai paramai)
  {
    super.d(paramai);
    int j = this.sE.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.sE.get(i)).d(paramai);
      i += 1;
    }
  }
  
  public final TransitionSet i(long paramLong)
  {
    super.g(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.sE.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.sE.get(i)).g(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.sE.size())
    {
      str = str + "\n" + ((Transition)this.sE.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */