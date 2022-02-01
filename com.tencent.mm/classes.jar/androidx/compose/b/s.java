package androidx.compose.b;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s ajk;
  private static final float ajl;
  private static final float ajm;
  private static final float ajn;
  
  static
  {
    AppMethodBeat.i(201739);
    ajk = new s();
    ajl = androidx.compose.ui.n.g.ai(1.0F);
    ajm = androidx.compose.ui.n.g.ai(2.0F);
    ajn = androidx.compose.ui.n.g.ai(52.0F);
    AppMethodBeat.o(201739);
  }
  
  public static float nz()
  {
    return ajn;
  }
  
  public final void a(final f paramf, final float paramFloat, final long paramLong, h paramh, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201746);
    paramh = paramh.by(-2003284867);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label68:
    label471:
    label487:
    label494:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      i = j;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (paramh.H(paramFloat)))
        {
          i = 32;
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt1 & 0x380) == 0)
        {
          if (((paramInt2 & 0x4) != 0) || (!paramh.y(paramLong))) {
            break label384;
          }
          j = 256;
          label111:
          j = i | j;
        }
        if ((paramInt2 & 0x8) == 0) {
          break label392;
        }
        i = 3072;
        i = j | i;
        if (((i & 0x16DB ^ 0x492) == 0) && (paramh.nZ())) {
          break label471;
        }
        if (((paramInt1 & 0x1) != 0) && (!paramh.oa())) {
          break label432;
        }
        paramh.of();
        if ((paramInt2 & 0x1) != 0) {
          paramf = (f)f.aud;
        }
        j = i;
        if ((paramInt2 & 0x2) != 0)
        {
          paramFloat = ajl;
          j = i & 0xFFFFFF8F;
        }
        if ((paramInt2 & 0x4) == 0) {
          break label487;
        }
        paramLong = z.g(((z)paramh.a((p)e.nv())).value, 0.12F);
      }
      for (i = j & 0xFFFFFC7F;; i = j)
      {
        paramh.og();
        g.a(paramf, paramLong, paramFloat, 0.0F, paramh, i & 0xE | i >> 3 & 0x70 | i << 3 & 0x380, 8);
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((m)new a(this, paramf, paramFloat, paramLong, paramInt1, paramInt2));
        }
        AppMethodBeat.o(201746);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label494;
        }
        if (paramh.G(paramf))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = 16;
        break label68;
        j = 128;
        break label111;
        i = j;
        if ((paramInt1 & 0x1C00) != 0) {
          break label138;
        }
        if (paramh.G(this))
        {
          i = 2048;
          break label131;
        }
        i = 1024;
        break label131;
        paramh.oj();
        if ((paramInt2 & 0x2) != 0) {
          i &= 0xFFFFFF8F;
        }
        for (;;)
        {
          if ((paramInt2 & 0x4) != 0)
          {
            i &= 0xFFFFFC7F;
            break;
            paramh.oi();
            break label301;
          }
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    a(s params, f paramf, float paramFloat, long paramLong, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.s
 * JD-Core Version:    0.7.0.1
 */