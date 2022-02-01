package androidx.compose.b;

import androidx.compose.foundation.b;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.c;
import androidx.compose.foundation.c.r;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final void a(f paramf, final long paramLong, float paramFloat1, final float paramFloat2, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201710);
    h localh = paramh.by(1228913708);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label68:
    label87:
    label94:
    label107:
    label494:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      i = j;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (localh.y(paramLong)))
        {
          i = 32;
          i = j | i;
        }
      }
      else
      {
        if ((paramInt2 & 0x4) == 0) {
          break label376;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label416;
        }
        i = 3072;
        i = j | i;
        label114:
        if (((i & 0x16DB ^ 0x492) == 0) && (localh.nZ())) {
          break label484;
        }
        if (((paramInt1 & 0x1) != 0) && (!localh.oa())) {
          break label457;
        }
        localh.of();
        if ((paramInt2 & 0x1) != 0) {
          paramf = (f)f.aud;
        }
        if ((paramInt2 & 0x2) != 0)
        {
          paramh = m.aiH;
          paramLong = z.g(m.j(localh).np(), 0.12F);
        }
        if ((paramInt2 & 0x4) != 0) {
          paramFloat1 = androidx.compose.ui.n.g.ai(1.0F);
        }
        if ((paramInt2 & 0x8) != 0) {
          paramFloat2 = androidx.compose.ui.n.g.ai(0.0F);
        }
        localh.og();
        if (paramFloat2 != 0.0F) {
          break label467;
        }
        i = 1;
        label244:
        if (i != 0) {
          break label473;
        }
        paramh = r.a((f)f.aud, paramFloat2, 0.0F, 0.0F, 0.0F, 14);
        c.a(b.a(ab.e(ab.c(paramf.a(paramh)), paramFloat1), paramLong), localh, 0);
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramf, paramLong, paramFloat1, paramFloat2, paramInt1, paramInt2));
        }
        AppMethodBeat.o(201710);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label494;
        }
        if (localh.G(paramf))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = 16;
        break label68;
        label376:
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label94;
        }
        if (localh.H(paramFloat1))
        {
          j = 256;
          break label87;
        }
        j = 128;
        break label87;
        i = j;
        if ((paramInt1 & 0x1C00) != 0) {
          break label114;
        }
        if (localh.H(paramFloat2))
        {
          i = 2048;
          break label107;
        }
        i = 1024;
        break label107;
        localh.oj();
        break label234;
        i = 0;
        break label244;
        paramh = (f)f.aud;
        break label267;
        localh.oi();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(f paramf, long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.g
 * JD-Core Version:    0.7.0.1
 */