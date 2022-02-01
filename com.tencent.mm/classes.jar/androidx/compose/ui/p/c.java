package androidx.compose.ui.p;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.br;
import androidx.compose.runtime.e.f.a;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.e;
import androidx.compose.ui.i.ac;
import androidx.compose.ui.i.ag;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final b<View, ah> bfp = (b)c.j.bfx;
  
  public static final b<View, ah> Ck()
  {
    return bfp;
  }
  
  public static final <T extends View> void a(final b<? super Context, ? extends T> paramb, final androidx.compose.ui.f paramf, final b<? super T, ah> paramb1, final androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(204433);
    s.u(paramb, "factory");
    androidx.compose.runtime.h localh = paramh.by(-88762710);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label50:
    label57:
    label703:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label623;
        }
        j = 384;
        label69:
        j = i | j;
        label76:
        if (((j & 0x2DB ^ 0x92) == 0) && (localh.nZ())) {
          break label693;
        }
        if ((paramInt2 & 0x2) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramb1 = bfp;
        }
        Context localContext = (Context)localh.a((p)j.yJ());
        androidx.compose.ui.f localf = e.a(localh, androidx.compose.ui.k.n.a(paramf, true, (b)c.i.bfw));
        androidx.compose.ui.n.d locald = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
        androidx.compose.ui.n.n localn = (androidx.compose.ui.n.n)localh.a((p)androidx.compose.ui.platform.u.yW());
        final l locall = g.m(localh);
        final androidx.compose.runtime.e.f localf1 = (androidx.compose.runtime.e.f)localh.a((p)androidx.compose.runtime.e.h.rd());
        final String str = String.valueOf(localh.oc());
        localh.bx(-3687241);
        Object localObject = localh.or();
        paramh = androidx.compose.runtime.h.alD;
        paramh = (androidx.compose.runtime.h)localObject;
        if (localObject == h.a.ox())
        {
          paramh = new ac();
          localh.F(paramh);
        }
        localh.od();
        paramh = (ac)paramh;
        localObject = (a)new b(localContext, locall, paramb, localf1, str, paramh);
        localh.bx(-2103251527);
        if (!(localh.nX() instanceof ag)) {
          g.nW();
        }
        localh.ok();
        if (!localh.nY()) {
          break label663;
        }
        localh.a((a)new c.a((a)localObject));
        label377:
        s.u(localh, "composer");
        br.a(localh, localf, (m)new c(paramh));
        br.a(localh, locald, (m)new d(paramh));
        br.a(localh, paramb1, (m)new e(paramh));
        br.a(localh, localn, (m)new f(paramh));
        localh.on();
        localh.od();
        if (localf1 == null) {
          break label673;
        }
        localh.bx(-88760705);
        aa.a(localf1, str, (b)new g(localf1, str, paramh), localh);
        localh.od();
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((m)new h(paramb, paramf, paramb1, paramInt1, paramInt2));
        }
        AppMethodBeat.o(204433);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label703;
        }
        if (localh.G(paramb))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = j;
        if ((paramInt1 & 0x70) != 0) {
          break label57;
        }
        if (localh.G(paramf))
        {
          i = 32;
          break label50;
        }
        i = 16;
        break label50;
        label623:
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label76;
        }
        if (localh.G(paramb1))
        {
          j = 256;
          break label69;
        }
        j = 128;
        break label69;
        localh.om();
        break label377;
        localh.bx(-88760250);
        localh.od();
        continue;
        localh.oi();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements a<androidx.compose.ui.i.f>
  {
    b(Context paramContext, l paraml, b<? super Context, ? extends T> paramb, androidx.compose.runtime.e.f paramf, String paramString, ac<d<T>> paramac)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<androidx.compose.ui.i.f, androidx.compose.ui.f, ah>
  {
    c(ac<d<T>> paramac)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<androidx.compose.ui.i.f, androidx.compose.ui.n.d, ah>
  {
    d(ac<d<T>> paramac)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements m<androidx.compose.ui.i.f, b<? super T, ? extends ah>, ah>
  {
    e(ac<d<T>> paramac)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<androidx.compose.ui.i.f, androidx.compose.ui.n.n, ah>
  {
    f(ac<d<T>> paramac)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements b<y, x>
  {
    g(androidx.compose.runtime.e.f paramf, String paramString, ac<d<T>> paramac)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(f.a parama) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(204424);
        this.arM.unregister();
        AppMethodBeat.o(204424);
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements a<SparseArray<Parcelable>>
    {
      b(ac<d<T>> paramac)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    h(b<? super Context, ? extends T> paramb, androidx.compose.ui.f paramf, b<? super T, ah> paramb1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.p.c
 * JD-Core Version:    0.7.0.1
 */