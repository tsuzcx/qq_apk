package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.g;
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
  ArrayList<Transition> tG = new ArrayList();
  private boolean tH = true;
  private int tI;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sK);
    U(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void F(View paramView)
  {
    super.F(paramView);
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.tG.get(i)).F(paramView);
      i += 1;
    }
  }
  
  public final void G(View paramView)
  {
    super.G(paramView);
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.tG.get(i)).G(paramView);
      i += 1;
    }
  }
  
  public final TransitionSet U(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(paramInt)));
    case 1: 
      this.tH = false;
      return this;
    }
    this.tH = true;
    return this;
  }
  
  public final Transition V(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.tG.size())) {
      return null;
    }
    return (Transition)this.tG.get(paramInt);
  }
  
  public final void a(Transition.b paramb)
  {
    super.a(paramb);
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.tG.get(i)).a(paramb);
      i += 1;
    }
  }
  
  public final void a(af paramaf)
  {
    super.a(paramaf);
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.tG.get(i)).a(paramaf);
      i += 1;
    }
  }
  
  public final void a(ah paramah)
  {
    if (C(paramah.view))
    {
      Iterator localIterator = this.tG.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.C(paramah.view))
        {
          localTransition.a(paramah);
          paramah.tO.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, ai paramai1, ai paramai2, ArrayList<ah> paramArrayList1, ArrayList<ah> paramArrayList2)
  {
    long l1 = this.sP;
    int j = this.tG.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.tG.get(i);
      if ((l1 > 0L) && ((this.tH) || (i == 0)))
      {
        long l2 = localTransition.sP;
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.e(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramai1, paramai2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label104:
        localTransition.e(l1);
      }
    }
  }
  
  public final TransitionSet b(TimeInterpolator paramTimeInterpolator)
  {
    return (TransitionSet)super.a(paramTimeInterpolator);
  }
  
  public final void b(ah paramah)
  {
    if (C(paramah.view))
    {
      Iterator localIterator = this.tG.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.C(paramah.view))
        {
          localTransition.b(paramah);
          paramah.tO.add(localTransition);
        }
      }
    }
  }
  
  protected final void cn()
  {
    if (this.tG.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new TransitionSet.a(this);
      Iterator localIterator = this.tG.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.c)localObject);
      }
      this.tI = this.tG.size();
      if (!this.tH)
      {
        int i = 1;
        while (i < this.tG.size())
        {
          ((Transition)this.tG.get(i - 1)).a(new TransitionSet.1(this, (Transition)this.tG.get(i)));
          i += 1;
        }
        localObject = (Transition)this.tG.get(0);
        if (localObject != null) {
          ((Transition)localObject).cn();
        }
      }
      else
      {
        localObject = this.tG.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).cn();
        }
      }
    }
  }
  
  public final Transition co()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.co();
    localTransitionSet.tG = new ArrayList();
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.d(((Transition)this.tG.get(i)).co());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public final TransitionSet d(Transition paramTransition)
  {
    this.tG.add(paramTransition);
    paramTransition.te = this;
    if (this.mDuration >= 0L) {
      paramTransition.d(this.mDuration);
    }
    return this;
  }
  
  final void d(ah paramah)
  {
    super.d(paramah);
    int j = this.tG.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.tG.get(i)).d(paramah);
      i += 1;
    }
  }
  
  public final TransitionSet f(long paramLong)
  {
    super.d(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.tG.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.tG.get(i)).d(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.tG.size())
    {
      str = str + "\n" + ((Transition)this.tG.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */