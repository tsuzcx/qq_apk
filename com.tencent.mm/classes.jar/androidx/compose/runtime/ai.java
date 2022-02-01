package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Latch;", "", "()V", "_isOpen", "", "awaiters", "", "Lkotlin/coroutines/Continuation;", "", "isOpen", "()Z", "lock", "spareList", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeLatch", "openLatch", "withClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public List<d<ah>> alt;
  public List<d<ah>> alu;
  public boolean aop;
  public final Object lock;
  
  public ai()
  {
    AppMethodBeat.i(201901);
    this.lock = new Object();
    this.alt = ((List)new ArrayList());
    this.alu = ((List)new ArrayList());
    this.aop = true;
    AppMethodBeat.o(201901);
  }
  
  public final Object e(d<? super ah> paramd)
  {
    AppMethodBeat.i(201916);
    if (isOpen())
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(201916);
      return paramd;
    }
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    final p localp = (p)localq;
    synchronized (this.lock)
    {
      this.alt.add(localp);
      localp.bg((kotlin.g.a.b)new a(this, localp));
      ??? = localq.getResult();
      if (??? == a.aiwj) {
        s.u(paramd, "frame");
      }
      if (??? == a.aiwj)
      {
        AppMethodBeat.o(201916);
        return ???;
      }
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(201916);
    return paramd;
  }
  
  public final boolean isOpen()
  {
    synchronized (this.lock)
    {
      boolean bool = this.aop;
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(ai paramai, p<? super ah> paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ai
 * JD-Core Version:    0.7.0.1
 */