package androidx.activity.a;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.platform.j;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(final boolean paramBoolean, final kotlin.g.a.a<ah> parama, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(199207);
    s.u(parama, "onBack");
    h localh = paramh.by(-971160336);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label458:
    label468:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0) {
        j = 48;
      }
      Object localObject2;
      for (;;)
      {
        j = i | j;
        do
        {
          if (((j & 0x5B ^ 0x12) == 0) && (localh.nZ())) {
            break label458;
          }
          if ((paramInt2 & 0x1) != 0) {
            paramBoolean = true;
          }
          localObject2 = bj.b(parama, localh);
          localh.bx(-3687241);
          localObject1 = localh.or();
          paramh = h.alD;
          paramh = (h)localObject1;
          if (localObject1 == h.a.ox())
          {
            paramh = new d((bm)localObject2, paramBoolean);
            localh.F(paramh);
          }
          localh.od();
          localObject2 = (d)paramh;
          localh.bx(-3686552);
          boolean bool1 = localh.G(localObject2);
          boolean bool2 = localh.G(Boolean.valueOf(paramBoolean));
          localObject1 = localh.or();
          if (!(bool1 | bool2))
          {
            paramh = h.alD;
            paramh = (h)localObject1;
            if (localObject1 != h.a.ox()) {}
          }
          else
          {
            paramh = (kotlin.g.a.a)new a((d)localObject2, paramBoolean);
            localh.F(paramh);
          }
          localh.od();
          aa.a((kotlin.g.a.a)paramh, localh);
          paramh = b.eL;
          paramh = b.a(localh);
          if (paramh != null) {
            break label365;
          }
          parama = (Throwable)new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
          AppMethodBeat.o(199207);
          throw parama;
          if ((paramInt1 & 0xE) != 0) {
            break label468;
          }
          if (localh.am(paramBoolean))
          {
            i = 4;
            break;
          }
          i = 2;
          break;
          j = i;
        } while ((paramInt1 & 0x70) != 0);
        if (localh.G(parama)) {
          j = 32;
        } else {
          j = 16;
        }
      }
      label365:
      paramh = paramh.getOnBackPressedDispatcher();
      s.s(paramh, "checkNotNull(LocalOnBack…}.onBackPressedDispatcher");
      Object localObject1 = (q)localh.a((p)j.yK());
      aa.a(localObject1, paramh, (kotlin.g.a.b)new b(paramh, (q)localObject1, (d)localObject2), localh);
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((m)new c(paramBoolean, parama, paramInt1, paramInt2));
        }
        AppMethodBeat.o(199207);
        return;
        localh.oi();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a.d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<y, x>
  {
    b(OnBackPressedDispatcher paramOnBackPressedDispatcher, q paramq, a.d paramd)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(a.d paramd) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(199205);
        this.eG.remove();
        AppMethodBeat.o(199205);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, ah>
  {
    c(boolean paramBoolean, kotlin.g.a.a<ah> parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends androidx.activity.b
  {
    d(bm<? extends kotlin.g.a.a<ah>> parambm, boolean paramBoolean)
    {
      super();
    }
    
    public final void handleOnBackPressed()
    {
      AppMethodBeat.i(199214);
      ((kotlin.g.a.a)this.eK.getValue()).invoke();
      AppMethodBeat.o(199214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.activity.a.a
 * JD-Core Version:    0.7.0.1
 */