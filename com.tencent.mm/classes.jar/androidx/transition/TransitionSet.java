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
  ArrayList<Transition> asl;
  private boolean asm;
  int asn;
  private int aso;
  boolean mStarted;
  
  public TransitionSet()
  {
    AppMethodBeat.i(192893);
    this.asl = new ArrayList();
    this.asm = true;
    this.mStarted = false;
    this.aso = 0;
    AppMethodBeat.o(192893);
  }
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192897);
    this.asl = new ArrayList();
    this.asm = true;
    this.mStarted = false;
    this.aso = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.arq);
    dz(g.a(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
    AppMethodBeat.o(192897);
  }
  
  public final Transition a(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(192921);
    int i = 0;
    while (i < this.asl.size())
    {
      ((Transition)this.asl.get(i)).a(paramClass, paramBoolean);
      i += 1;
    }
    paramClass = super.a(paramClass, paramBoolean);
    AppMethodBeat.o(192921);
    return paramClass;
  }
  
  protected final void a(ViewGroup paramViewGroup, x paramx1, x paramx2, ArrayList<w> paramArrayList1, ArrayList<w> paramArrayList2)
  {
    AppMethodBeat.i(192929);
    long l1 = no();
    int j = this.asl.size();
    int i = 0;
    if (i < j)
    {
      Transition localTransition = (Transition)this.asl.get(i);
      if ((l1 > 0L) && ((this.asm) || (i == 0)))
      {
        long l2 = localTransition.no();
        if (l2 <= 0L) {
          break label109;
        }
        localTransition.q(l2 + l1);
      }
      for (;;)
      {
        localTransition.a(paramViewGroup, paramx1, paramx2, paramArrayList1, paramArrayList2);
        i += 1;
        break;
        label109:
        localTransition.q(l1);
      }
    }
    AppMethodBeat.o(192929);
  }
  
  public final void a(PathMotion paramPathMotion)
  {
    AppMethodBeat.i(192924);
    super.a(paramPathMotion);
    this.aso |= 0x4;
    int i = 0;
    while (i < this.asl.size())
    {
      ((Transition)this.asl.get(i)).a(paramPathMotion);
      i += 1;
    }
    AppMethodBeat.o(192924);
  }
  
  public final void a(Transition.c paramc)
  {
    AppMethodBeat.i(192973);
    super.a(paramc);
    this.aso |= 0x8;
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.asl.get(i)).a(paramc);
      i += 1;
    }
    AppMethodBeat.o(192973);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(192971);
    super.a(paramu);
    this.aso |= 0x2;
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.asl.get(i)).a(paramu);
      i += 1;
    }
    AppMethodBeat.o(192971);
  }
  
  public final TransitionSet b(TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(192909);
    this.aso |= 0x1;
    if (this.asl != null)
    {
      int j = this.asl.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.asl.get(i)).a(paramTimeInterpolator);
        i += 1;
      }
    }
    paramTimeInterpolator = (TransitionSet)super.a(paramTimeInterpolator);
    AppMethodBeat.o(192909);
    return paramTimeInterpolator;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(192952);
    if (bE(paramw.view))
    {
      Iterator localIterator = this.asl.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.bE(paramw.view))
        {
          localTransition.b(paramw);
          paramw.asx.add(localTransition);
        }
      }
    }
    AppMethodBeat.o(192952);
  }
  
  public final void bH(View paramView)
  {
    AppMethodBeat.i(192965);
    super.bH(paramView);
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.asl.get(i)).bH(paramView);
      i += 1;
    }
    AppMethodBeat.o(192965);
  }
  
  public final void bI(View paramView)
  {
    AppMethodBeat.i(192969);
    super.bI(paramView);
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.asl.get(i)).bI(paramView);
      i += 1;
    }
    AppMethodBeat.o(192969);
  }
  
  public final Transition c(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(192913);
    int i = 0;
    while (i < this.asl.size())
    {
      ((Transition)this.asl.get(i)).c(paramString, paramBoolean);
      i += 1;
    }
    paramString = super.c(paramString, paramBoolean);
    AppMethodBeat.o(192913);
    return paramString;
  }
  
  public final TransitionSet c(Transition.d paramd)
  {
    AppMethodBeat.i(192911);
    paramd = (TransitionSet)super.a(paramd);
    AppMethodBeat.o(192911);
    return paramd;
  }
  
  public final TransitionSet c(Transition paramTransition)
  {
    AppMethodBeat.i(192901);
    this.asl.add(paramTransition);
    paramTransition.arL = this;
    if (this.mDuration >= 0L) {
      paramTransition.p(this.mDuration);
    }
    if ((this.aso & 0x1) != 0) {
      paramTransition.a(np());
    }
    if ((this.aso & 0x2) != 0) {
      paramTransition.a(this.arV);
    }
    if ((this.aso & 0x4) != 0) {
      paramTransition.a(ns());
    }
    if ((this.aso & 0x8) != 0) {
      paramTransition.a(nt());
    }
    AppMethodBeat.o(192901);
    return this;
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(192958);
    if (bE(paramw.view))
    {
      Iterator localIterator = this.asl.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.bE(paramw.view))
        {
          localTransition.c(paramw);
          paramw.asx.add(localTransition);
        }
      }
    }
    AppMethodBeat.o(192958);
  }
  
  final void d(w paramw)
  {
    AppMethodBeat.i(192960);
    super.d(paramw);
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.asl.get(i)).d(paramw);
      i += 1;
    }
    AppMethodBeat.o(192960);
  }
  
  public final Transition dA(int paramInt)
  {
    AppMethodBeat.i(192904);
    if ((paramInt < 0) || (paramInt >= this.asl.size()))
    {
      AppMethodBeat.o(192904);
      return null;
    }
    Transition localTransition = (Transition)this.asl.get(paramInt);
    AppMethodBeat.o(192904);
    return localTransition;
  }
  
  public final TransitionSet dz(int paramInt)
  {
    AppMethodBeat.i(192899);
    switch (paramInt)
    {
    default: 
      AndroidRuntimeException localAndroidRuntimeException = new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(192899);
      throw localAndroidRuntimeException;
    }
    for (this.asm = false;; this.asm = true)
    {
      AppMethodBeat.o(192899);
      return this;
    }
  }
  
  public final Transition l(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192917);
    int i = 0;
    while (i < this.asl.size())
    {
      ((Transition)this.asl.get(i)).l(paramInt, paramBoolean);
      i += 1;
    }
    Transition localTransition = super.l(paramInt, paramBoolean);
    AppMethodBeat.o(192917);
    return localTransition;
  }
  
  protected final void nr()
  {
    AppMethodBeat.i(192948);
    if (this.asl.isEmpty())
    {
      start();
      end();
      AppMethodBeat.o(192948);
      return;
    }
    Object localObject = new a(this);
    Iterator localIterator = this.asl.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).a((Transition.d)localObject);
    }
    this.asn = this.asl.size();
    if (!this.asm)
    {
      int i = 1;
      while (i < this.asl.size())
      {
        ((Transition)this.asl.get(i - 1)).a(new s()
        {
          public final void a(Transition paramAnonymousTransition)
          {
            AppMethodBeat.i(192880);
            this.asp.nr();
            paramAnonymousTransition.b(this);
            AppMethodBeat.o(192880);
          }
        });
        i += 1;
      }
      localObject = (Transition)this.asl.get(0);
      if (localObject != null) {
        ((Transition)localObject).nr();
      }
      AppMethodBeat.o(192948);
      return;
    }
    localObject = this.asl.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Transition)((Iterator)localObject).next()).nr();
    }
    AppMethodBeat.o(192948);
  }
  
  public final Transition nv()
  {
    AppMethodBeat.i(192976);
    TransitionSet localTransitionSet = (TransitionSet)super.nv();
    localTransitionSet.asl = new ArrayList();
    int j = this.asl.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.c(((Transition)this.asl.get(i)).nv());
      i += 1;
    }
    AppMethodBeat.o(192976);
    return localTransitionSet;
  }
  
  public final TransitionSet r(long paramLong)
  {
    AppMethodBeat.i(192906);
    super.p(paramLong);
    if (this.mDuration >= 0L)
    {
      int j = this.asl.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.asl.get(i)).p(paramLong);
        i += 1;
      }
    }
    AppMethodBeat.o(192906);
    return this;
  }
  
  final String toString(String paramString)
  {
    AppMethodBeat.i(192975);
    String str = super.toString(paramString);
    int i = 0;
    while (i < this.asl.size())
    {
      str = str + "\n" + ((Transition)this.asl.get(i)).toString(new StringBuilder().append(paramString).append("  ").toString());
      i += 1;
    }
    AppMethodBeat.o(192975);
    return str;
  }
  
  static final class a
    extends s
  {
    TransitionSet asr;
    
    a(TransitionSet paramTransitionSet)
    {
      this.asr = paramTransitionSet;
    }
    
    public final void a(Transition paramTransition)
    {
      AppMethodBeat.i(192889);
      TransitionSet localTransitionSet = this.asr;
      localTransitionSet.asn -= 1;
      if (this.asr.asn == 0)
      {
        this.asr.mStarted = false;
        this.asr.end();
      }
      paramTransition.b(this);
      AppMethodBeat.o(192889);
    }
    
    public final void nl()
    {
      AppMethodBeat.i(192885);
      if (!this.asr.mStarted)
      {
        this.asr.start();
        this.asr.mStarted = true;
      }
      AppMethodBeat.o(192885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */