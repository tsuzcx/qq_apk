package androidx.compose.ui.platform;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.compose.runtime.al;
import androidx.compose.runtime.al.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "choreographer", "Landroid/view/Choreographer;", "(Landroid/view/Choreographer;)V", "getChoreographer", "()Landroid/view/Choreographer;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements al
{
  public static final int Ue = 8;
  final Choreographer choreographer;
  
  public o(Choreographer paramChoreographer)
  {
    AppMethodBeat.i(206923);
    this.choreographer = paramChoreographer;
    AppMethodBeat.o(206923);
  }
  
  public final <R> Object b(kotlin.g.a.b<? super Long, ? extends R> arg1, d<? super R> paramd)
  {
    AppMethodBeat.i(206938);
    Object localObject = paramd.getContext().get((f.c)e.aiwc);
    q localq;
    p localp;
    final Choreographer.FrameCallback localFrameCallback;
    if ((localObject instanceof m))
    {
      localObject = (m)localObject;
      localq = new q(kotlin.d.a.b.au(paramd), 1);
      localq.kBA();
      localp = (p)localq;
      localFrameCallback = (Choreographer.FrameCallback)new c(localp, this, ???);
      if ((localObject == null) || (!s.p(((m)localObject).choreographer, this.choreographer))) {
        break label215;
      }
      s.u(localFrameCallback, "callback");
    }
    for (;;)
    {
      synchronized (((m)localObject).lock)
      {
        ((m)localObject).aTc.add(localFrameCallback);
        if (!((m)localObject).aTf)
        {
          ((m)localObject).aTf = true;
          ((m)localObject).choreographer.postFrameCallback((Choreographer.FrameCallback)((m)localObject).aTg);
        }
        ah localah = ah.aiuX;
        localp.bg((kotlin.g.a.b)new a((m)localObject, localFrameCallback));
        ??? = localq.getResult();
        if (??? == a.aiwj) {
          s.u(paramd, "frame");
        }
        AppMethodBeat.o(206938);
        return ???;
        localObject = null;
      }
      label215:
      this.choreographer.postFrameCallback(localFrameCallback);
      localp.bg((kotlin.g.a.b)new b(this, localFrameCallback));
    }
  }
  
  public final <R> R fold(R paramR, kotlin.g.a.m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(206960);
    paramR = al.a.a((al)this, paramR, paramm);
    AppMethodBeat.o(206960);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(206949);
    paramc = al.a.a((al)this, paramc);
    AppMethodBeat.o(206949);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    AppMethodBeat.i(206987);
    f.c localc = al.a.a(this);
    AppMethodBeat.o(206987);
    return localc;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(206968);
    paramc = al.a.b((al)this, paramc);
    AppMethodBeat.o(206968);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(206975);
    paramf = al.a.a((al)this, paramf);
    AppMethodBeat.o(206975);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(m paramm, Choreographer.FrameCallback paramFrameCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    b(o paramo, Choreographer.FrameCallback paramFrameCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "frameTimeNanos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    implements Choreographer.FrameCallback
  {
    c(p<? super R> paramp, o paramo, kotlin.g.a.b<? super Long, ? extends R> paramb) {}
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(206757);
      p localp = this.anM;
      Object localObject1 = paramb;
      try
      {
        localCompanion = Result.Companion;
        localObject1 = Result.constructor-impl(((kotlin.g.a.b)localObject1).invoke(Long.valueOf(paramLong)));
        localp.resumeWith(localObject1);
        AppMethodBeat.o(206757);
        return;
      }
      finally
      {
        for (;;)
        {
          Result.Companion localCompanion = Result.Companion;
          Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.o
 * JD-Core Version:    0.7.0.1
 */