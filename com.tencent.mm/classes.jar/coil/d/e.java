package coil.d;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.runtime.r;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.af;
import androidx.compose.ui.platform.ac;
import coil.j.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"rememberImagePainter", "Lcoil/compose/ImagePainter;", "request", "Lcoil/request/ImageRequest;", "imageLoader", "Lcoil/ImageLoader;", "onExecute", "Lcoil/compose/ImagePainter$ExecuteCallback;", "(Lcoil/request/ImageRequest;Lcoil/ImageLoader;Lcoil/compose/ImagePainter$ExecuteCallback;Landroidx/compose/runtime/Composer;II)Lcoil/compose/ImagePainter;", "data", "", "builder", "Lkotlin/Function1;", "Lcoil/request/ImageRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lcoil/ImageLoader;Lcoil/compose/ImagePainter$ExecuteCallback;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcoil/compose/ImagePainter;", "requireSupportedData", "unsupportedData", "", "name", "", "updatePainter", "imagePainter", "(Lcoil/compose/ImagePainter;Lcoil/request/ImageRequest;Lcoil/ImageLoader;Landroidx/compose/runtime/Composer;I)V", "toPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroid/graphics/drawable/Drawable;", "toState", "Lcoil/compose/ImagePainter$State;", "Lcoil/request/ImageResult;", "coil-compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  static final androidx.compose.ui.e.c.c C(Drawable paramDrawable)
  {
    AppMethodBeat.i(188064);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      s.s(paramDrawable, "bitmap");
      paramDrawable = (androidx.compose.ui.e.c.c)new androidx.compose.ui.e.c.a(androidx.compose.ui.e.f.h(paramDrawable));
      AppMethodBeat.o(188064);
      return paramDrawable;
    }
    if ((paramDrawable instanceof ColorDrawable))
    {
      paramDrawable = (androidx.compose.ui.e.c.c)new androidx.compose.ui.e.c.b(ab.cH(((ColorDrawable)paramDrawable).getColor()), (byte)0);
      AppMethodBeat.o(188064);
      return paramDrawable;
    }
    paramDrawable = paramDrawable.mutate();
    s.s(paramDrawable, "mutate()");
    paramDrawable = (androidx.compose.ui.e.c.c)new com.google.a.a.a(paramDrawable);
    AppMethodBeat.o(188064);
    return paramDrawable;
  }
  
  public static final d a(coil.j.h paramh, coil.d paramd, d.a parama, androidx.compose.runtime.h paramh1)
  {
    AppMethodBeat.i(188036);
    s.u(paramh, "request");
    s.u(paramd, "imageLoader");
    paramh1.bx(604402625);
    Object localObject1 = paramh.cpt;
    if ((localObject1 instanceof af))
    {
      aV("ImageBitmap");
      paramh = new kotlin.f();
      AppMethodBeat.o(188036);
      throw paramh;
    }
    if ((localObject1 instanceof androidx.compose.ui.e.d.d))
    {
      aV("ImageVector");
      paramh = new kotlin.f();
      AppMethodBeat.o(188036);
      throw paramh;
    }
    if ((localObject1 instanceof androidx.compose.ui.e.c.c))
    {
      aV("Painter");
      paramh = new kotlin.f();
      AppMethodBeat.o(188036);
      throw paramh;
    }
    if (paramh.com == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramh = (Throwable)new IllegalArgumentException("request.target must be null.".toString());
      AppMethodBeat.o(188036);
      throw paramh;
    }
    paramh1.bx(-723524056);
    paramh1.bx(-3687241);
    Object localObject2 = paramh1.or();
    localObject1 = androidx.compose.runtime.h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = new r(aa.a((kotlin.d.f)bg.kCh().kCK(), paramh1));
      paramh1.F(localObject1);
    }
    paramh1.od();
    aq localaq = ((r)localObject1).coroutineScope;
    paramh1.od();
    paramh1.bx(-3686930);
    boolean bool = paramh1.G(localaq);
    localObject2 = paramh1.or();
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new d(localaq, paramh, paramd);
      paramh1.F(localObject1);
    }
    paramh1.od();
    localObject1 = (d)localObject1;
    s.u(paramh, "<set-?>");
    ((d)localObject1).cmx.setValue(paramh);
    s.u(paramd, "<set-?>");
    ((d)localObject1).cmy.setValue(paramd);
    s.u(parama, "<set-?>");
    ((d)localObject1).cmv = parama;
    ((d)localObject1).isPreview = ((Boolean)paramh1.a((p)ac.zj())).booleanValue();
    a((d)localObject1, paramh, paramd, paramh1, 576);
    paramh1.od();
    AppMethodBeat.o(188036);
    return localObject1;
  }
  
  private static final void a(d paramd, final coil.j.h paramh, final coil.d paramd1, androidx.compose.runtime.h paramh1, final int paramInt)
  {
    AppMethodBeat.i(188047);
    androidx.compose.runtime.h localh = paramh1.by(-234146095);
    if (paramd.isPreview)
    {
      paramh1 = paramh.MZ();
      if (paramh1 == null) {}
      for (paramh1 = null;; paramh1 = C(paramh1))
      {
        paramd.a(paramh1);
        paramh1 = localh.oh();
        if (paramh1 != null) {
          paramh1.b((kotlin.g.a.m)new a(paramd, paramh, paramd1, paramInt));
        }
        AppMethodBeat.o(188047);
        return;
      }
    }
    d.c localc = paramd.MM();
    localh.bx(-3686930);
    boolean bool = localh.G(localc);
    Object localObject1 = localh.or();
    if (!bool)
    {
      paramh1 = androidx.compose.runtime.h.alD;
      paramh1 = (androidx.compose.runtime.h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      paramh1 = localc.MN();
      localh.F(paramh1);
    }
    localh.od();
    androidx.compose.ui.e.c.c localc1 = (androidx.compose.ui.e.c.c)paramh1;
    localObject1 = paramh.cpG.cpj;
    paramh1 = (androidx.compose.runtime.h)localObject1;
    if (localObject1 == null) {
      paramh1 = paramd1.MB().cpj;
    }
    if (!(paramh1 instanceof coil.l.a))
    {
      paramd.a(localc1);
      paramh1 = localh.oh();
      if (paramh1 != null) {
        paramh1.b((kotlin.g.a.m)new b(paramd, paramh, paramd1, paramInt));
      }
      AppMethodBeat.o(188047);
      return;
    }
    localh.bx(-3686930);
    bool = localh.G(paramh);
    Object localObject2 = localh.or();
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new g();
      localh.F(localObject1);
    }
    localh.od();
    localObject1 = (g)localObject1;
    if ((localc instanceof d.c.c)) {
      ((g)localObject1).value = localc.MN();
    }
    if ((!(localc instanceof d.c.d)) || (((d.c.d)localc).cmH.coM.cnH == coil.e.b.cmU))
    {
      paramd.a(localc1);
      paramh1 = localh.oh();
      if (paramh1 != null) {
        paramh1.b((kotlin.g.a.m)new c(paramd, paramh, paramd1, paramInt));
      }
      AppMethodBeat.o(188047);
      return;
    }
    androidx.compose.ui.e.c.c localc2 = (androidx.compose.ui.e.c.c)((g)localObject1).value;
    localObject2 = paramh.cpG.cmi;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = coil.size.e.cpZ;
    }
    int i = ((coil.l.a)paramh1).WN;
    if (!((d.c.d)localc).cmH.coM.cpM) {}
    for (bool = true;; bool = false)
    {
      paramd.a(b.a(localc, localc2, localc1, (coil.size.e)localObject1, i, bool, localh));
      paramh1 = localh.oh();
      if (paramh1 != null) {
        paramh1.b((kotlin.g.a.m)new d(paramd, paramh, paramd1, paramInt));
      }
      AppMethodBeat.o(188047);
      return;
    }
  }
  
  private static final Void aV(String paramString)
  {
    AppMethodBeat.i(188056);
    paramString = new IllegalArgumentException("Unsupported type: " + paramString + ". If you wish to display this " + paramString + ", use androidx.compose.foundation.Image.");
    AppMethodBeat.o(188056);
    throw paramString;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(d paramd, coil.j.h paramh, coil.d paramd1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(d paramd, coil.j.h paramh, coil.d paramd1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    c(d paramd, coil.j.h paramh, coil.d paramd1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(d paramd, coil.j.h paramh, coil.d paramd1, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d.e
 * JD-Core Version:    0.7.0.1
 */