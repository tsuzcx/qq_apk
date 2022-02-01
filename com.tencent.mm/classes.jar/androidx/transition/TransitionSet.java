package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet
  extends Transition
{
  ArrayList<Transition> cgU;
  private boolean cgV;
  int cgW;
  private int cgX;
  boolean mStarted;
  
  public TransitionSet()
  {
    AppMethodBeat.i(201400);
    this.cgU = new ArrayList();
    this.cgV = true;
    this.mStarted = false;
    this.cgX = 0;
    AppMethodBeat.o(201400);
  }
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201409);
    this.cgU = new ArrayList();
    this.cgV = true;
    this.mStarted = false;
    this.cgX = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfZ);
    gJ(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
    AppMethodBeat.o(201409);
  }
  
  protected final void LU()
  {
    AppMethodBeat.i(201516);
    if (this.cgU.isEmpty())
    {
      start();
      end();
      AppMethodBeat.o(201516);
      return;
    }
    Object localObject = new a(this);
    Iterator localIterator = this.cgU.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).a((Transition.d)localObject);
    }
    this.cgW = this.cgU.size();
    if (!this.cgV)
    {
      int i = 1;
      while (i < this.cgU.size())
      {
        ((Transition)this.cgU.get(i - 1)).a(new s()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            AppMethodBeat.i(201226);
            this.cgY.LU();
            paramAnonymousTransition.b(this);
            AppMethodBeat.o(201226);
          }
        });
        i += 1;
      }
      localObject = (Transition)this.cgU.get(0);
      if (localObject != null) {
        ((Transition)localObject).LU();
      }
      AppMethodBeat.o(201516);
      return;
    }
    localObject = this.cgU.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Transition)((Iterator)localObject).next()).LU();
    }
    AppMethodBeat.o(201516);
  }
  
  public final Transition LY()
  {
    AppMethodBeat.i(201581);
    TransitionSet localTransitionSet = (TransitionSet)super.LY();
    localTransitionSet.cgU = new ArrayList();
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.cgU.get(i)).LY());
      i += 1;
    }
    AppMethodBeat.o(201581);
    return localTransitionSet;
  }
  
  public final Transition a(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(201488);
    int i = 0;
    while (i < this.cgU.size())
    {
      ((Transition)this.cgU.get(i)).a(paramClass, paramBoolean);
      i += 1;
    }
    paramClass = super.a(paramClass, paramBoolean);
    AppMethodBeat.o(201488);
    return paramClass;
  }
  
  protected final void a(ViewGroup paramViewGroup, x paramx1, x paramx2, ArrayList<w> paramArrayList1, ArrayList<w> paramArrayList2)
  {
    AppMethodBeat.i(201503);
    long l1 = LR();
    int j = this.cgU.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.cgU.get(i);
      if ((l1 > 0L) && ((this.cgV) || (i == 0)))
      {
        long l2 = localTransition.LR();
        if (l2 <= 0L) {
          break label109;
        }
        localTransition.bC(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramx1, paramx2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label109:
        localTransition.bC(l1);
      }
    }
    AppMethodBeat.o(201503);
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    AppMethodBeat.i(201494);
    super.a(paramPathMotion);
    this.cgX |= 0x4;
    int i = 0;
    while (i < this.cgU.size())
    {
      ((Transition)this.cgU.get(i)).a(paramPathMotion);
      i += 1;
    }
    AppMethodBeat.o(201494);
  }
  
  public final void a(Transition.c paramc)
  {
    AppMethodBeat.i(201569);
    super.a(paramc);
    this.cgX |= 0x8;
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.cgU.get(i)).a(paramc);
      i += 1;
    }
    AppMethodBeat.o(201569);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(201560);
    super.a(paramu);
    this.cgX |= 0x2;
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.cgU.get(i)).a(paramu);
      i += 1;
    }
    AppMethodBeat.o(201560);
  }
  
  public final TransitionSet b(TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(201454);
    this.cgX |= 0x1;
    if (this.cgU != null)
    {
      int j = this.cgU.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.cgU.get(i)).a(paramTimeInterpolator);
        i += 1;
      }
    }
    paramTimeInterpolator = (TransitionSet)super.a(paramTimeInterpolator);
    AppMethodBeat.o(201454);
    return paramTimeInterpolator;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201526);
    if (bY(paramw.view))
    {
      Iterator localIterator = this.cgU.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.bY(paramw.view))
        {
          localTransition.b(paramw);
          paramw.chg.add(localTransition);
        }
      }
    }
    AppMethodBeat.o(201526);
  }
  
  public final TransitionSet bD(long paramLong)
  {
    AppMethodBeat.i(201445);
    super.bB(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.cgU.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.cgU.get(i)).bB(paramLong);
        i += 1;
      }
    }
    AppMethodBeat.o(201445);
    return this;
  }
  
  public final Transition c(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(201469);
    int i = 0;
    while (i < this.cgU.size())
    {
      ((Transition)this.cgU.get(i)).c(paramString, paramBoolean);
      i += 1;
    }
    paramString = super.c(paramString, paramBoolean);
    AppMethodBeat.o(201469);
    return paramString;
  }
  
  public final TransitionSet c(Transition.d paramd)
  {
    AppMethodBeat.i(201462);
    paramd = (TransitionSet)super.a(paramd);
    AppMethodBeat.o(201462);
    return paramd;
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    AppMethodBeat.i(201427);
    this.cgU.add(paramTransition);
    paramTransition.cgu = this;
    if (this.mDuration >= 0L) {
      paramTransition.bB(this.mDuration);
    }
    if ((this.cgX & 0x1) != 0) {
      paramTransition.a(LS());
    }
    if ((this.cgX & 0x2) != 0) {
      paramTransition.a(this.cgE);
    }
    if ((this.cgX & 0x4) != 0) {
      paramTransition.a(LV());
    }
    if ((this.cgX & 0x8) != 0) {
      paramTransition.a(LW());
    }
    AppMethodBeat.o(201427);
    return this;
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201534);
    if (bY(paramw.view))
    {
      Iterator localIterator = this.cgU.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.bY(paramw.view))
        {
          localTransition.c(paramw);
          paramw.chg.add(localTransition);
        }
      }
    }
    AppMethodBeat.o(201534);
  }
  
  public final void cb(View paramView)
  {
    AppMethodBeat.i(201546);
    super.cb(paramView);
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.cgU.get(i)).cb(paramView);
      i += 1;
    }
    AppMethodBeat.o(201546);
  }
  
  public final void cc(View paramView)
  {
    AppMethodBeat.i(201553);
    super.cc(paramView);
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.cgU.get(i)).cc(paramView);
      i += 1;
    }
    AppMethodBeat.o(201553);
  }
  
  final void d(w paramw)
  {
    AppMethodBeat.i(201541);
    super.d(paramw);
    int j = this.cgU.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.cgU.get(i)).d(paramw);
      i += 1;
    }
    AppMethodBeat.o(201541);
  }
  
  public final TransitionSet gJ(int paramInt)
  {
    AppMethodBeat.i(201419);
    switch (paramInt)
    {
    default: 
      AndroidRuntimeException localAndroidRuntimeException = new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(201419);
      throw localAndroidRuntimeException;
    }
    for (this.cgV = false;; this.cgV = true)
    {
      AppMethodBeat.o(201419);
      return this;
    }
  }
  
  public final Transition gK(int paramInt)
  {
    AppMethodBeat.i(201435);
    if ((paramInt < 0) || (paramInt >= this.cgU.size()))
    {
      AppMethodBeat.o(201435);
      return null;
    }
    Transition localTransition = (Transition)this.cgU.get(paramInt);
    AppMethodBeat.o(201435);
    return localTransition;
  }
  
  final String toString(String paramString)
  {
    AppMethodBeat.i(201576);
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.cgU.size())
    {
      str = str + "\n" + ((Transition)this.cgU.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    AppMethodBeat.o(201576);
    return str;
  }
  
  public final Transition z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201478);
    int i = 0;
    while (i < this.cgU.size())
    {
      ((Transition)this.cgU.get(i)).z(paramInt, paramBoolean);
      i += 1;
    }
    Transition localTransition = super.z(paramInt, paramBoolean);
    AppMethodBeat.o(201478);
    return localTransition;
  }
  
  static final class a
    extends s
  {
    TransitionSet cha;
    
    a(TransitionSet paramTransitionSet)
    {
      this.cha = paramTransitionSet;
    }
    
    public final void LO()
    {
      AppMethodBeat.i(201236);
      if (!this.cha.mStarted)
      {
        this.cha.start();
        this.cha.mStarted = true;
      }
      AppMethodBeat.o(201236);
    }
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(201244);
      TransitionSet localTransitionSet = this.cha;
      localTransitionSet.cgW -= 1;
      if (this.cha.cgW == 0)
      {
        this.cha.mStarted = false;
        this.cha.end();
      }
      paramTransition.b(this);
      AppMethodBeat.o(201244);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */