package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidUiDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "choreographer", "Landroid/view/Choreographer;", "handler", "Landroid/os/Handler;", "(Landroid/view/Choreographer;Landroid/os/Handler;)V", "getChoreographer", "()Landroid/view/Choreographer;", "dispatchCallback", "androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1;", "frameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "lock", "", "scheduledFrameDispatch", "", "scheduledTrampolineDispatch", "spareToRunOnFrame", "", "Landroid/view/Choreographer$FrameCallback;", "toRunOnFrame", "toRunTrampolined", "Lkotlin/collections/ArrayDeque;", "Ljava/lang/Runnable;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "nextTask", "performFrameDispatch", "frameTimeNanos", "", "performTrampolineDispatch", "postFrameCallback", "callback", "postFrameCallback$ui_release", "removeFrameCallback", "removeFrameCallback$ui_release", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends kotlinx.coroutines.al
{
  public static final int Ue;
  public static final a aTa;
  private static final kotlin.j<f> aTh;
  private static final ThreadLocal<f> aTi;
  private final kotlin.a.j<Runnable> aTb;
  List<Choreographer.FrameCallback> aTc;
  private List<Choreographer.FrameCallback> aTd;
  private boolean aTe;
  boolean aTf;
  final d aTg;
  final androidx.compose.runtime.al aox;
  final Choreographer choreographer;
  private final Handler handler;
  final Object lock;
  
  static
  {
    AppMethodBeat.i(206956);
    aTa = new a((byte)0);
    Ue = 8;
    aTh = kotlin.k.cm((kotlin.g.a.a)b.aTj);
    aTi = (ThreadLocal)new c();
    AppMethodBeat.o(206956);
  }
  
  private m(Choreographer paramChoreographer, Handler paramHandler)
  {
    AppMethodBeat.i(206904);
    this.choreographer = paramChoreographer;
    this.handler = paramHandler;
    this.lock = new Object();
    this.aTb = new kotlin.a.j();
    this.aTc = ((List)new ArrayList());
    this.aTd = ((List)new ArrayList());
    this.aTg = new d(this);
    this.aox = ((androidx.compose.runtime.al)new o(this.choreographer));
    AppMethodBeat.o(206904);
  }
  
  private final Runnable yM()
  {
    AppMethodBeat.i(206909);
    synchronized (this.lock)
    {
      Runnable localRunnable = (Runnable)this.aTb.kkV();
      AppMethodBeat.o(206909);
      return localRunnable;
    }
  }
  
  public final void a(f arg1, Runnable paramRunnable)
  {
    AppMethodBeat.i(206964);
    s.u(???, "context");
    s.u(paramRunnable, "block");
    synchronized (this.lock)
    {
      this.aTb.hr(paramRunnable);
      if (!this.aTe)
      {
        this.aTe = true;
        this.handler.post((Runnable)this.aTg);
        if (!this.aTf)
        {
          this.aTf = true;
          this.choreographer.postFrameCallback((Choreographer.FrameCallback)this.aTg);
        }
      }
      paramRunnable = ah.aiuX;
      AppMethodBeat.o(206964);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidUiDispatcher$Companion;", "", "()V", "CurrentThread", "Lkotlin/coroutines/CoroutineContext;", "getCurrentThread", "()Lkotlin/coroutines/CoroutineContext;", "Main", "getMain", "Main$delegate", "Lkotlin/Lazy;", "currentThread", "Ljava/lang/ThreadLocal;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f yP()
    {
      AppMethodBeat.i(206741);
      f localf = (f)m.yN().getValue();
      AppMethodBeat.o(206741);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<f>
  {
    public static final b aTj;
    
    static
    {
      AppMethodBeat.i(206735);
      aTj = new b();
      AppMethodBeat.o(206735);
    }
    
    b()
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, d<? super Choreographer>, Object>
    {
      int label;
      
      a(d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(206648);
        paramObject = (d)new a(paramd);
        AppMethodBeat.o(206648);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(206646);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(206646);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = Choreographer.getInstance();
        AppMethodBeat.o(206646);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/AndroidUiDispatcher$Companion$currentThread$1", "Ljava/lang/ThreadLocal;", "Lkotlin/coroutines/CoroutineContext;", "initialValue", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ThreadLocal<f>
  {}
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "doFrame", "", "frameTimeNanos", "", "run", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Choreographer.FrameCallback, Runnable
  {
    d(m paramm) {}
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(206736);
      m.c(this.aTk).removeCallbacks((Runnable)this);
      m.a(this.aTk);
      m.a(this.aTk, paramLong);
      AppMethodBeat.o(206736);
    }
    
    public final void run()
    {
      AppMethodBeat.i(206733);
      m.a(this.aTk);
      Object localObject1 = m.b(this.aTk);
      Object localObject2 = this.aTk;
      try
      {
        if (m.d((m)localObject2).isEmpty())
        {
          ((m)localObject2).choreographer.removeFrameCallback((Choreographer.FrameCallback)this);
          m.e((m)localObject2);
        }
        localObject2 = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(206733);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.m
 * JD-Core Version:    0.7.0.1
 */