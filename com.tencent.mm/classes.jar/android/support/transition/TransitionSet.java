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
  ArrayList<Transition> CT = new ArrayList();
  private boolean CU = true;
  int CV;
  private int CW = 0;
  boolean mStarted = false;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.BY);
    ao(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void K(View paramView)
  {
    super.K(paramView);
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CT.get(i)).K(paramView);
      i += 1;
    }
  }
  
  public final void L(View paramView)
  {
    super.L(paramView);
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CT.get(i)).L(paramView);
      i += 1;
    }
  }
  
  public final Transition a(Class paramClass, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.CT.size())
    {
      ((Transition)this.CT.get(i)).a(paramClass, paramBoolean);
      i += 1;
    }
    return super.a(paramClass, paramBoolean);
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    super.a(paramPathMotion);
    this.CW |= 0x4;
    int i = 0;
    while (i < this.CT.size())
    {
      ((Transition)this.CT.get(i)).a(paramPathMotion);
      i += 1;
    }
  }
  
  public final void a(Transition.c paramc)
  {
    super.a(paramc);
    this.CW |= 0x8;
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CT.get(i)).a(paramc);
      i += 1;
    }
  }
  
  public final void a(t paramt)
  {
    super.a(paramt);
    this.CW |= 0x2;
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CT.get(i)).a(paramt);
      i += 1;
    }
  }
  
  public final void a(v paramv)
  {
    if (H(paramv.view))
    {
      Iterator localIterator = this.CT.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.H(paramv.view))
        {
          localTransition.a(paramv);
          paramv.Df.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, w paramw1, w paramw2, ArrayList<v> paramArrayList1, ArrayList<v> paramArrayList2)
  {
    long l1 = this.Cd;
    int j = this.CT.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.CT.get(i);
      if ((l1 > 0L) && ((this.CU) || (i == 0)))
      {
        long l2 = localTransition.Cd;
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.g(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramw1, paramw2, paramArrayList1, paramArrayList2);
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
      this.CU = false;
      return this;
    }
    this.CU = true;
    return this;
  }
  
  public final Transition ap(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.CT.size())) {
      return null;
    }
    return (Transition)this.CT.get(paramInt);
  }
  
  public final Transition b(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.CT.size())
    {
      ((Transition)this.CT.get(i)).b(paramString, paramBoolean);
      i += 1;
    }
    return super.b(paramString, paramBoolean);
  }
  
  public final void b(v paramv)
  {
    if (H(paramv.view))
    {
      Iterator localIterator = this.CT.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.H(paramv.view))
        {
          localTransition.b(paramv);
          paramv.Df.add(localTransition);
        }
      }
    }
  }
  
  public final TransitionSet c(TimeInterpolator paramTimeInterpolator)
  {
    this.CW |= 0x1;
    if (this.CT != null)
    {
      int j = this.CT.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.CT.get(i)).b(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.b(paramTimeInterpolator);
  }
  
  public final TransitionSet c(Transition.d paramd)
  {
    return (TransitionSet)super.a(paramd);
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    this.CT.add(paramTransition);
    paramTransition.Cs = this;
    if (this.mDuration >= 0L) {
      paramTransition.f(this.mDuration);
    }
    if ((this.CW & 0x1) != 0) {
      paramTransition.b(this.Ce);
    }
    if ((this.CW & 0x2) != 0) {
      paramTransition.a(this.CC);
    }
    if ((this.CW & 0x4) != 0) {
      paramTransition.a(this.CF);
    }
    if ((this.CW & 0x8) != 0) {
      paramTransition.a(this.CD);
    }
    return this;
  }
  
  final void d(v paramv)
  {
    super.d(paramv);
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.CT.get(i)).d(paramv);
      i += 1;
    }
  }
  
  protected final void dO()
  {
    if (this.CT.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new a(this);
      Iterator localIterator = this.CT.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.d)localObject);
      }
      this.CV = this.CT.size();
      if (!this.CU)
      {
        int i = 1;
        while (i < this.CT.size())
        {
          ((Transition)this.CT.get(i - 1)).a(new r()
          {
            public final void a(Transition paramAnonymousTransition)
            {
              this.CX.dO();
              paramAnonymousTransition.b(this);
            }
          });
          i += 1;
        }
        localObject = (Transition)this.CT.get(0);
        if (localObject != null) {
          ((Transition)localObject).dO();
        }
      }
      else
      {
        localObject = this.CT.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).dO();
        }
      }
    }
  }
  
  public final Transition dP()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.dP();
    localTransitionSet.CT = new ArrayList();
    int j = this.CT.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.CT.get(i)).dP());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public final Transition f(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.CT.size())
    {
      ((Transition)this.CT.get(i)).f(paramInt, paramBoolean);
      i += 1;
    }
    return super.f(paramInt, paramBoolean);
  }
  
  public final TransitionSet h(long paramLong)
  {
    super.f(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.CT.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.CT.get(i)).f(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.CT.size())
    {
      str = str + "\n" + ((Transition)this.CT.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
  
  static final class a
    extends r
  {
    TransitionSet CZ;
    
    a(TransitionSet paramTransitionSet)
    {
      this.CZ = paramTransitionSet;
    }
    
    public final void a(Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.CZ;
      localTransitionSet.CV -= 1;
      if (this.CZ.CV == 0)
      {
        this.CZ.mStarted = false;
        this.CZ.end();
      }
      paramTransition.b(this);
    }
    
    public final void dK()
    {
      if (!this.CZ.mStarted)
      {
        this.CZ.start();
        this.CZ.mStarted = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */