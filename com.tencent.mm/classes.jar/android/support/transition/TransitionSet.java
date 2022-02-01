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
  ArrayList<Transition> AS = new ArrayList();
  private boolean AT = true;
  int AU;
  private int AV = 0;
  boolean mStarted = false;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.Aa);
    ao(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void J(View paramView)
  {
    super.J(paramView);
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.AS.get(i)).J(paramView);
      i += 1;
    }
  }
  
  public final void K(View paramView)
  {
    super.K(paramView);
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.AS.get(i)).K(paramView);
      i += 1;
    }
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    super.a(paramPathMotion);
    this.AV |= 0x4;
    int i = 0;
    while (i < this.AS.size())
    {
      ((Transition)this.AS.get(i)).a(paramPathMotion);
      i += 1;
    }
  }
  
  public final void a(Transition.b paramb)
  {
    super.a(paramb);
    this.AV |= 0x8;
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.AS.get(i)).a(paramb);
      i += 1;
    }
  }
  
  public final void a(s params)
  {
    super.a(params);
    this.AV |= 0x2;
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.AS.get(i)).a(params);
      i += 1;
    }
  }
  
  public final void a(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.AS.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.a(paramu);
          paramu.Be.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, v paramv1, v paramv2, ArrayList<u> paramArrayList1, ArrayList<u> paramArrayList2)
  {
    long l1 = this.Af;
    int j = this.AS.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.AS.get(i);
      if ((l1 > 0L) && ((this.AT) || (i == 0)))
      {
        long l2 = localTransition.Af;
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
      this.AT = false;
      return this;
    }
    this.AT = true;
    return this;
  }
  
  public final Transition ap(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.AS.size())) {
      return null;
    }
    return (Transition)this.AS.get(paramInt);
  }
  
  public final void b(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.AS.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.b(paramu);
          paramu.Be.add(localTransition);
        }
      }
    }
  }
  
  public final TransitionSet c(TimeInterpolator paramTimeInterpolator)
  {
    this.AV |= 0x1;
    if (this.AS != null)
    {
      int j = this.AS.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.AS.get(i)).b(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.b(paramTimeInterpolator);
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    this.AS.add(paramTransition);
    paramTransition.Au = this;
    if (this.mDuration >= 0L) {
      paramTransition.f(this.mDuration);
    }
    if ((this.AV & 0x1) != 0) {
      paramTransition.b(this.Ag);
    }
    if ((this.AV & 0x2) != 0) {
      paramTransition.a(this.AE);
    }
    if ((this.AV & 0x4) != 0) {
      paramTransition.a(this.AH);
    }
    if ((this.AV & 0x8) != 0) {
      paramTransition.a(this.AF);
    }
    return this;
  }
  
  final void d(u paramu)
  {
    super.d(paramu);
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.AS.get(i)).d(paramu);
      i += 1;
    }
  }
  
  protected final void dw()
  {
    if (this.AS.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new a(this);
      Iterator localIterator = this.AS.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.c)localObject);
      }
      this.AU = this.AS.size();
      if (!this.AT)
      {
        int i = 1;
        while (i < this.AS.size())
        {
          ((Transition)this.AS.get(i - 1)).a(new q()
          {
            public final void a(Transition paramAnonymousTransition)
            {
              this.AW.dw();
              paramAnonymousTransition.b(this);
            }
          });
          i += 1;
        }
        localObject = (Transition)this.AS.get(0);
        if (localObject != null) {
          ((Transition)localObject).dw();
        }
      }
      else
      {
        localObject = this.AS.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).dw();
        }
      }
    }
  }
  
  public final Transition dx()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.dx();
    localTransitionSet.AS = new ArrayList();
    int j = this.AS.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.AS.get(i)).dx());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public final TransitionSet h(long paramLong)
  {
    super.f(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.AS.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.AS.get(i)).f(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.AS.size())
    {
      str = str + "\n" + ((Transition)this.AS.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
  
  static final class a
    extends q
  {
    TransitionSet AY;
    
    a(TransitionSet paramTransitionSet)
    {
      this.AY = paramTransitionSet;
    }
    
    public final void a(Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.AY;
      localTransitionSet.AU -= 1;
      if (this.AY.AU == 0)
      {
        this.AY.mStarted = false;
        this.AY.end();
      }
      paramTransition.b(this);
    }
    
    public final void ds()
    {
      if (!this.AY.mStarted)
      {
        this.AY.start();
        this.AY.mStarted = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */