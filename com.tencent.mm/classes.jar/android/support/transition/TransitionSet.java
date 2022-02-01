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
  boolean mStarted = false;
  ArrayList<Transition> zU = new ArrayList();
  private boolean zV = true;
  int zW;
  private int zX = 0;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.za);
    ao(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  public final void J(View paramView)
  {
    super.J(paramView);
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.zU.get(i)).J(paramView);
      i += 1;
    }
  }
  
  public final void K(View paramView)
  {
    super.K(paramView);
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.zU.get(i)).K(paramView);
      i += 1;
    }
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    super.a(paramPathMotion);
    this.zX |= 0x4;
    int i = 0;
    while (i < this.zU.size())
    {
      ((Transition)this.zU.get(i)).a(paramPathMotion);
      i += 1;
    }
  }
  
  public final void a(Transition.b paramb)
  {
    super.a(paramb);
    this.zX |= 0x8;
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.zU.get(i)).a(paramb);
      i += 1;
    }
  }
  
  public final void a(s params)
  {
    super.a(params);
    this.zX |= 0x2;
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.zU.get(i)).a(params);
      i += 1;
    }
  }
  
  public final void a(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.zU.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.a(paramu);
          paramu.Ag.add(localTransition);
        }
      }
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, v paramv1, v paramv2, ArrayList<u> paramArrayList1, ArrayList<u> paramArrayList2)
  {
    long l1 = this.zf;
    int j = this.zU.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.zU.get(i);
      if ((l1 > 0L) && ((this.zV) || (i == 0)))
      {
        long l2 = localTransition.zf;
        if (l2 <= 0L) {
          break label104;
        }
        localTransition.e(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramv1, paramv2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label104:
        localTransition.e(l1);
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
      this.zV = false;
      return this;
    }
    this.zV = true;
    return this;
  }
  
  public final Transition ap(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zU.size())) {
      return null;
    }
    return (Transition)this.zU.get(paramInt);
  }
  
  public final void b(u paramu)
  {
    if (G(paramu.view))
    {
      Iterator localIterator = this.zU.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.G(paramu.view))
        {
          localTransition.b(paramu);
          paramu.Ag.add(localTransition);
        }
      }
    }
  }
  
  public final TransitionSet c(TimeInterpolator paramTimeInterpolator)
  {
    this.zX |= 0x1;
    if (this.zU != null)
    {
      int j = this.zU.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.zU.get(i)).b(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.b(paramTimeInterpolator);
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    this.zU.add(paramTransition);
    paramTransition.zw = this;
    if (this.mDuration >= 0L) {
      paramTransition.d(this.mDuration);
    }
    if ((this.zX & 0x1) != 0) {
      paramTransition.b(this.zg);
    }
    if ((this.zX & 0x2) != 0) {
      paramTransition.a(this.zG);
    }
    if ((this.zX & 0x4) != 0) {
      paramTransition.a(this.zJ);
    }
    if ((this.zX & 0x8) != 0) {
      paramTransition.a(this.zH);
    }
    return this;
  }
  
  final void d(u paramu)
  {
    super.d(paramu);
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.zU.get(i)).d(paramu);
      i += 1;
    }
  }
  
  protected final void dp()
  {
    if (this.zU.isEmpty())
    {
      start();
      end();
    }
    for (;;)
    {
      return;
      Object localObject = new a(this);
      Iterator localIterator = this.zU.iterator();
      while (localIterator.hasNext()) {
        ((Transition)localIterator.next()).a((Transition.c)localObject);
      }
      this.zW = this.zU.size();
      if (!this.zV)
      {
        int i = 1;
        while (i < this.zU.size())
        {
          ((Transition)this.zU.get(i - 1)).a(new q()
          {
            public final void a(Transition paramAnonymousTransition)
            {
              this.zY.dp();
              paramAnonymousTransition.b(this);
            }
          });
          i += 1;
        }
        localObject = (Transition)this.zU.get(0);
        if (localObject != null) {
          ((Transition)localObject).dp();
        }
      }
      else
      {
        localObject = this.zU.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).dp();
        }
      }
    }
  }
  
  public final Transition dq()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.dq();
    localTransitionSet.zU = new ArrayList();
    int j = this.zU.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.zU.get(i)).dq());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public final TransitionSet f(long paramLong)
  {
    super.d(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.zU.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.zU.get(i)).d(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  final String toString(String paramString)
  {
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.zU.size())
    {
      str = str + "\n" + ((Transition)this.zU.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    return str;
  }
  
  static final class a
    extends q
  {
    TransitionSet Aa;
    
    a(TransitionSet paramTransitionSet)
    {
      this.Aa = paramTransitionSet;
    }
    
    public final void a(Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.Aa;
      localTransitionSet.zW -= 1;
      if (this.Aa.zW == 0)
      {
        this.Aa.mStarted = false;
        this.Aa.end();
      }
      paramTransition.b(this);
    }
    
    public final void dl()
    {
      if (!this.Aa.mStarted)
      {
        this.Aa.start();
        this.Aa.mStarted = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */