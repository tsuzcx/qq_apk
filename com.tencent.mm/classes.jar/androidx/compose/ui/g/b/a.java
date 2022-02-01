package androidx.compose.ui.g.b;

import androidx.compose.ui.d.e;
import androidx.compose.ui.n.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract long a(long paramLong1, long paramLong2, int paramInt);
  
  public abstract Object a(long paramLong1, long paramLong2, d<? super r> paramd);
  
  public abstract Object a(long paramLong, d<? super r> paramd);
  
  public abstract long b(long paramLong, int paramInt);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long a(a parama)
    {
      AppMethodBeat.i(205723);
      s.u(parama, "this");
      parama = e.avo;
      long l = e.su();
      AppMethodBeat.o(205723);
      return l;
    }
    
    public static Object vT()
    {
      AppMethodBeat.i(205726);
      Object localObject = r.beY;
      localObject = r.bs(r.su());
      AppMethodBeat.o(205726);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.a
 * JD-Core Version:    0.7.0.1
 */