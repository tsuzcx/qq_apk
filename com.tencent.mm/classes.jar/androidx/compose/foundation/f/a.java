package androidx.compose.foundation.f;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.f;
import androidx.compose.ui.k.n;
import androidx.compose.ui.m.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(androidx.compose.ui.m.a parama, final f paramf, final androidx.compose.ui.m.u paramu, final b<? super q, ah> paramb, final int paramInt1, final boolean paramBoolean, final int paramInt2, final Map<String, d> paramMap, androidx.compose.runtime.h paramh, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(203727);
    s.u(parama, "text");
    androidx.compose.runtime.h localh = paramh.by(959238322);
    if ((paramInt4 & 0x1) != 0) {
      i = 6;
    }
    label138:
    label808:
    label938:
    for (int i = paramInt3 | i;; i = paramInt3)
    {
      int j;
      label51:
      label58:
      label94:
      int k;
      if ((paramInt4 & 0x2) != 0)
      {
        j = 48;
        j = i | j;
        i = j;
        if ((paramInt3 & 0x380) == 0)
        {
          if (((paramInt4 & 0x4) != 0) || (!localh.G(paramu))) {
            break label716;
          }
          i = 256;
          i = j | i;
        }
        j = i;
        if ((paramInt3 & 0x1C00) == 0)
        {
          if (((paramInt4 & 0x8) != 0) || (!localh.G(paramb))) {
            break label724;
          }
          j = 2048;
          j = i | j;
        }
        i = j;
        if ((paramInt4 & 0x10) != 0) {
          i = j | 0x2000;
        }
        if ((paramInt4 & 0x20) == 0) {
          break label732;
        }
        j = 196608;
        label177:
        j = i | j;
        label184:
        if ((paramInt4 & 0x40) == 0) {
          break label770;
        }
        i = 1572864;
        label196:
        k = j | i;
        label203:
        i = k;
        if ((paramInt4 & 0x80) != 0) {
          i = k | 0x400000;
        }
        if ((((paramInt4 ^ 0xFFFFFFFF) & 0x90) == 0) && ((0x16DB6DB & i ^ 0x492492) == 0) && (localh.nZ())) {
          break label901;
        }
        if (((paramInt3 & 0x1) != 0) && (!localh.oa())) {
          break label808;
        }
        localh.of();
        if ((paramInt4 & 0x2) != 0) {
          paramf = (f)f.aud;
        }
        j = i;
        if ((paramInt4 & 0x4) != 0)
        {
          paramu = androidx.compose.ui.m.u.baB;
          paramu = androidx.compose.ui.m.u.AT();
          j = i & 0xFFFFFC7F;
        }
        i = j;
        if ((paramInt4 & 0x8) != 0)
        {
          paramb = (b)a.a.agJ;
          i = j & 0xFFFFE3FF;
        }
        if ((paramInt4 & 0x10) == 0) {
          break label935;
        }
        paramh = androidx.compose.ui.m.f.h.beA;
        paramInt1 = androidx.compose.ui.m.f.h.Cd();
        i = 0xFFFF1FFF & i;
      }
      for (;;)
      {
        if ((paramInt4 & 0x20) != 0) {
          paramBoolean = true;
        }
        if ((paramInt4 & 0x40) != 0) {
          paramInt2 = 2147483647;
        }
        j = i;
        if ((paramInt4 & 0x80) != 0)
        {
          paramMap = ak.kkZ();
          j = i & 0xFE3FFFFF;
        }
        localh.og();
        i = j;
        paramh = paramMap;
        paramMap = paramb;
        paramb = paramh;
        localh.bx(-3686930);
        boolean bool = localh.G(parama);
        paramh = localh.or();
        if (!bool)
        {
          h.a locala = androidx.compose.runtime.h.alD;
          if (paramh != h.a.ox()) {}
        }
        else
        {
          paramh = (b)new a.b(parama);
          localh.F(paramh);
          label509:
          localh.od();
          c.a(parama, n.a(paramf, false, (b)paramh), paramu, paramBoolean, paramInt1, paramInt2, paramb, paramMap, localh, i << 12 & 0x1C00000 | 0x208000 | i & 0xE | i & 0x380 | i >> 6 & 0x1C00 | 0x70000 & i >> 3, 0);
          paramh = paramMap;
          paramMap = paramb;
          paramb = paramh;
          label595:
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((m)new c(parama, paramf, paramu, paramb, paramInt1, paramBoolean, paramInt2, paramMap, paramInt3, paramInt4));
          }
          AppMethodBeat.o(203727);
          return;
          if ((paramInt3 & 0xE) != 0) {
            break label938;
          }
          if (localh.G(parama))
          {
            i = 4;
            break;
          }
          i = 2;
          break;
          j = i;
          if ((paramInt3 & 0x70) != 0) {
            break label58;
          }
          if (localh.G(paramf))
          {
            j = 32;
            break label51;
          }
          j = 16;
          break label51;
          label716:
          i = 128;
          break label94;
          label724:
          j = 1024;
          break label138;
          label732:
          j = i;
          if ((0x70000 & paramInt3) != 0) {
            break label184;
          }
          if (localh.am(paramBoolean))
          {
            j = 131072;
            break label177;
          }
          j = 65536;
          break label177;
          k = j;
          if ((0x380000 & paramInt3) != 0) {
            break label203;
          }
          if (localh.bz(paramInt2))
          {
            i = 1048576;
            break label196;
          }
          i = 524288;
          break label196;
          localh.oj();
          if ((paramInt4 & 0x4) == 0) {
            break label928;
          }
        }
        for (j = i & 0xFFFFFC7F;; j = i)
        {
          i = j;
          if ((paramInt4 & 0x8) != 0) {
            i = j & 0xFFFFE3FF;
          }
          j = i;
          if ((paramInt4 & 0x10) != 0) {
            j = i & 0xFFFF1FFF;
          }
          if ((paramInt4 & 0x80) != 0)
          {
            i = j & 0xFE3FFFFF;
            paramh = paramb;
            paramb = paramMap;
            paramMap = paramh;
            break;
            break label509;
            localh.oi();
            break label595;
          }
          i = j;
          paramh = paramb;
          paramb = paramMap;
          paramMap = paramh;
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    c(androidx.compose.ui.m.a parama, f paramf, androidx.compose.ui.m.u paramu, b<? super q, ah> paramb, int paramInt1, boolean paramBoolean, int paramInt2, Map<String, d> paramMap, int paramInt3, int paramInt4)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.a
 * JD-Core Version:    0.7.0.1
 */