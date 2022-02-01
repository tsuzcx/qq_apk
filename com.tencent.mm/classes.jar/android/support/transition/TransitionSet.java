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
  ArrayList<Transition> CJ = new ArrayList();
  private boolean CK = true;
  int CL;
  private int CM = 0;
  boolean mStarted = false;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BR);
    ao(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void J(View paramView)
  {
    super.J(paramView);
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CJ.get(i)).J(paramView);
      i += 1;
    }
  }
  
  public final void K(View paramView)
  {
    super.K(paramView);
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CJ.get(i)).K(paramView);
      i += 1;
    }
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    super.a(paramPathMotion);
    this.CM |= 0x4;
    int i = 0;
    while (i < this.CJ.size())
    {
      ((Transition)this.CJ.get(i)).a(paramPathMotion);
      i += 1;
    }
  }
  
  public final void a(Transition.b paramb)
  {
    super.a(paramb);
    this.CM |= 0x8;
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CJ.get(i)).a(paramb);
      i += 1;
    }
  }
  
  public final void a(s params)
  {
    super.a(params);
    this.CM |= 0x2;
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CJ.get(i)).a(params);
      i += 1;
    }
  }
  
  public final void a(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.CJ.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.a(paramu);
          paramu.CW.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, v paramv1, v paramv2, ArrayList<u> paramArrayList1, ArrayList<u> paramArrayList2)
  {
    long l1 = this.BW;
    int j = this.CJ.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.CJ.get(i);
      if ((l1 > 0L) && ((this.CK) || (i == 0)))
      {
        long l2 = localTransition.BW;
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.g(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramv1, paramv2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label104:
        localTransition.g(l1);
      }
    }
  }
  
  public final TransitionSet ao(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(paramInt)));
    case 1: 
      this.CK = false;
      return this;
    }
    this.CK = true;
    return this;
  }
  
  public final Transition ap(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.CJ.size())) {
      return null;
    }
    return (Transition)this.CJ.get(paramInt);
  }
  
  public final void b(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.CJ.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.b(paramu);
          paramu.CW.add(localTransition);
        }
      }
    }
  }
  
  public final TransitionSet c(TimeInterpolator paramTimeInterpolator)
  {
    this.CM |= 0x1;
    if (this.CJ != null)
    {
      int j = this.CJ.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.CJ.get(i)).b(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.b(paramTimeInterpolator);
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    this.CJ.add(paramTransition);
    paramTransition.Cl = this;
    if (this.mDuration >= 0L) {
      paramTransition.f(this.mDuration);
    }
    if ((this.CM & 0x1) != 0) {
      paramTransition.b(this.BX);
    }
    if ((this.CM & 0x2) != 0) {
      paramTransition.a(this.Cv);
    }
    if ((this.CM & 0x4) != 0) {
      paramTransition.a(this.Cy);
    }
    if ((this.CM & 0x8) != 0) {
      paramTransition.a(this.Cw);
    }
    return this;
  }
  
  final void d(u paramu)
  {
    super.d(paramu);
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CJ.get(i)).d(paramu);
      i += 1;
    }
  }
  
  protected final void dL()
  {
    if (this.CJ.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new a(this);
      Iterator localIterator = this.CJ.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.c)localObject);
      }
      this.CL = this.CJ.size();
      if (!this.CK)
      {
        int i = 1;
        while (i < this.CJ.size())
        {
          ((Transition)this.CJ.get(i - 1)).a(new q()
          {
            public final void a(Transition paramAnonymousTransition)
            {
              this.CN.dL();
              paramAnonymousTransition.b(this);
            }
          });
          i += 1;
        }
        localObject = (Transition)this.CJ.get(0);
        if (localObject != null) {
          ((Transition)localObject).dL();
        }
      }
      else
      {
        localObject = this.CJ.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).dL();
        }
      }
    }
  }
  
  public final Transition dM()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.dM();
    localTransitionSet.CJ = new ArrayList();
    int j = this.CJ.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.CJ.get(i)).dM());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public final TransitionSet h(long paramLong)
  {
    super.f(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.CJ.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.CJ.get(i)).f(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.CJ.size())
    {
      str = str + "\n" + ((Transition)this.CJ.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
  
  static final class a
    extends q
  {
    TransitionSet CQ;
    
    a(TransitionSet paramTransitionSet)
    {
      this.CQ = paramTransitionSet;
    }
    
    public final void a(Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.CQ;
      localTransitionSet.CL -= 1;
      if (this.CQ.CL == 0)
      {
        this.CQ.mStarted = false;
        this.CQ.end();
      }
      paramTransition.b(this);
    }
    
    public final void dH()
    {
      if (!this.CQ.mStarted)
      {
        this.CQ.start();
        this.CQ.mStarted = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */