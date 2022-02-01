package androidx.compose.b;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.d.k;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.aa.a;
import androidx.compose.ui.e.ad;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.h.d.a;
import androidx.compose.ui.k.n;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final f aiE;
  
  static
  {
    AppMethodBeat.i(201741);
    aiE = androidx.compose.foundation.c.ab.f((f)f.aud, g.ai(24.0F));
    AppMethodBeat.o(201741);
  }
  
  public static final void a(androidx.compose.ui.e.c.c paramc, final String paramString, final f paramf, final long paramLong, h paramh, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201737);
    s.u(paramc, "painter");
    h localh = paramh.by(1547384967);
    if ((paramInt2 & 0x4) != 0) {
      paramf = (f)f.aud;
    }
    for (;;)
    {
      if ((paramInt2 & 0x8) != 0) {
        paramLong = z.g(((z)localh.a((p)e.nv())).value, ((Number)localh.a((p)d.nu())).floatValue());
      }
      paramh = z.awK;
      f localf;
      Object localObject1;
      label193:
      label220:
      int i;
      if (z.e(paramLong, z.sw()))
      {
        paramh = null;
        if (paramString == null) {
          break label430;
        }
        localh.bx(1547385352);
        localf = (f)f.aud;
        localh.bx(-3686930);
        boolean bool = localh.G(paramString);
        localObject1 = localh.or();
        if (!bool)
        {
          localObject2 = h.alD;
          if (localObject1 != h.a.ox()) {
            break label427;
          }
        }
        localObject1 = (b)new j.b(paramString);
        localh.F(localObject1);
        localh.od();
        localObject1 = n.a(localf, false, (b)localObject1);
        localh.od();
        s.u(paramf, "<this>");
        if (!androidx.compose.ui.platform.ab.zi()) {
          break label458;
        }
        localf = paramf.a(ad.a((f)f.aud, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L, null, false, 8191));
        label260:
        long l = paramc.uM();
        localObject2 = k.avA;
        if (!k.e(l, k.sw()))
        {
          l = paramc.uM();
          if ((!Float.isInfinite(k.Q(l))) || (!Float.isInfinite(k.R(l)))) {
            break label464;
          }
          i = 1;
          label313:
          if (i == 0) {
            break label470;
          }
        }
      }
      label427:
      label430:
      label458:
      label464:
      label470:
      for (Object localObject2 = aiE;; localObject2 = (f)f.aud)
      {
        localf = localf.a((f)localObject2);
        localObject2 = androidx.compose.ui.h.d.aMF;
        androidx.compose.foundation.c.c.a(androidx.compose.ui.b.m.a(localf, paramc, false, null, d.a.wG(), 0.0F, paramh, 22).a((f)localObject1), localh, 0);
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramc, paramString, paramf, paramLong, paramInt1, paramInt2));
        }
        AppMethodBeat.o(201737);
        return;
        paramh = aa.awX;
        paramh = aa.a.ae(paramLong);
        break;
        break label193;
        localh.bx(1547385496);
        localh.od();
        localObject1 = (f)f.aud;
        break label220;
        localf = paramf;
        break label260;
        i = 0;
        break label313;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(androidx.compose.ui.e.c.c paramc, String paramString, f paramf, long paramLong, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.j
 * JD-Core Version:    0.7.0.1
 */