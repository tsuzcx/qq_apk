package androidx.compose.runtime.d;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.runtime.x;
import androidx.compose.ui.platform.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"observeAsState", "Landroidx/compose/runtime/State;", "T", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "R", "initial", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-livedata_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final <R, T extends R> bm<R> a(LiveData<T> paramLiveData, final R paramR, h paramh)
  {
    AppMethodBeat.i(202273);
    s.u(paramLiveData, "<this>");
    paramh.bx(-2027639486);
    final q localq = (q)paramh.a((p)j.yK());
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = bj.T(paramR);
      paramh.F(localObject1);
    }
    paramh.od();
    paramR = (an)localObject1;
    aa.a(paramLiveData, localq, (b)new a(paramLiveData, localq, paramR), paramh);
    paramh.od();
    paramLiveData = (bm)paramR;
    AppMethodBeat.o(202273);
    return paramLiveData;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<androidx.compose.runtime.y, x>
  {
    a(LiveData<T> paramLiveData, q paramq, an<R> paraman)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(LiveData paramLiveData, androidx.lifecycle.y paramy) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(202265);
        this.arG.b(this.arH);
        AppMethodBeat.o(202265);
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b<T>
      implements androidx.lifecycle.y
    {
      b(an<R> paraman) {}
      
      public final void onChanged(T paramT)
      {
        AppMethodBeat.i(202259);
        this.arF.setValue(paramT);
        AppMethodBeat.o(202259);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.d.a
 * JD-Core Version:    0.7.0.1
 */