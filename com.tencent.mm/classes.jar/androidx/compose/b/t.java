package androidx.compose.b;

import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.m.b.g;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.f.c;
import androidx.compose.ui.n.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  private static final as<androidx.compose.ui.m.u> ajp;
  
  static
  {
    AppMethodBeat.i(201796);
    ajp = androidx.compose.runtime.q.a(bj.qi(), (kotlin.g.a.a)a.ajq);
    AppMethodBeat.o(201796);
  }
  
  public static final void a(androidx.compose.ui.m.a parama, final f paramf, final long paramLong1, long paramLong2, g paramg, i parami, final androidx.compose.ui.m.b.d paramd, long paramLong3, final androidx.compose.ui.m.f.d paramd1, final c paramc, final long paramLong4, final int paramInt1, final boolean paramBoolean, final int paramInt2, Map<String, androidx.compose.foundation.f.d> paramMap, final b<? super androidx.compose.ui.m.q, ah> paramb, final androidx.compose.ui.m.u paramu, final androidx.compose.runtime.h paramh, final int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(201768);
    s.u(parama, "text");
    androidx.compose.runtime.h localh = paramh.by(1557616910);
    if ((paramInt5 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label1340:
    for (int i = paramInt3 | i;; i = paramInt3)
    {
      int j;
      if ((paramInt5 & 0x2) != 0)
      {
        j = 48;
        j = i | j;
        i = j;
        if ((paramInt3 & 0x380) == 0)
        {
          if (((paramInt5 & 0x4) != 0) || (!localh.y(paramLong1))) {
            break label1286;
          }
          i = 256;
          label94:
          i = j | i;
        }
        j = i;
        if ((paramInt3 & 0x1C00) == 0)
        {
          if (((paramInt5 & 0x8) != 0) || (!localh.y(paramLong2))) {
            break label1294;
          }
          j = 2048;
          j = i | j;
        }
        i = j;
        if ((paramInt5 & 0x10) != 0) {
          i = j | 0x2000;
        }
        if ((paramInt5 & 0x20) == 0) {
          break label1302;
        }
        j = 196608;
        j = i | j;
        if ((paramInt5 & 0x40) == 0) {
          break label1340;
        }
        i = 1572864;
        label197:
        i = j | i;
        label204:
        j = i;
        if ((0x1C00000 & paramInt3) == 0)
        {
          if (((paramInt5 & 0x80) != 0) || (!localh.y(paramLong3))) {
            break label1379;
          }
          j = 8388608;
          label241:
          j = i | j;
        }
        if ((paramInt5 & 0x100) == 0) {
          break label1387;
        }
        i = 100663296;
        j |= i;
      }
      label446:
      label1471:
      for (;;)
      {
        i = j;
        if ((paramInt5 & 0x200) != 0) {
          i = j | 0x10000000;
        }
        if ((paramInt4 & 0xE) == 0) {
          if (((paramInt5 & 0x400) == 0) && (localh.y(paramLong4))) {
            j = 4;
          }
        }
        label320:
        for (int k = paramInt4 | j;; k = paramInt4)
        {
          j = k;
          if ((paramInt5 & 0x800) != 0) {
            j = k | 0x10;
          }
          label361:
          label368:
          label382:
          int m;
          if ((paramInt5 & 0x1000) != 0)
          {
            k = 384;
            k = j | k;
            if ((paramInt5 & 0x2000) == 0) {
              break label1471;
            }
            j = 3072;
            m = k | j;
            j = m;
            if ((paramInt5 & 0x4000) != 0) {
              j = m | 0x2000;
            }
            k = j;
            if ((0x70000 & paramInt4) == 0)
            {
              if (((0x8000 & paramInt5) != 0) || (!localh.G(paramb))) {
                break label1512;
              }
              k = 131072;
              k = j | k;
            }
            j = k;
            if ((0x380000 & paramInt4) == 0)
            {
              if (((0x10000 & paramInt5) != 0) || (!localh.G(paramu))) {
                break label1519;
              }
              j = 1048576;
              label489:
              j = k | j;
            }
            if ((((paramInt5 ^ 0xFFFFFFFF) & 0x4A10) == 0) && ((0x5B6DB6DB & i ^ 0x12492492) == 0) && ((0x2DB6DB & j ^ 0x92492) == 0) && (localh.nZ())) {
              break label1835;
            }
            if (((paramInt3 & 0x1) != 0) && (!localh.oa())) {
              break label1527;
            }
            localh.of();
            if ((paramInt5 & 0x2) != 0) {
              paramf = (f)f.aud;
            }
            k = i;
            if ((paramInt5 & 0x4) != 0)
            {
              paramh = z.awK;
              paramLong1 = z.sw();
              k = i & 0xFFFFFC7F;
            }
            m = k;
            if ((paramInt5 & 0x8) != 0)
            {
              paramh = o.beS;
              paramLong2 = o.sw();
              m = k & 0xFFFFE3FF;
            }
            if ((paramInt5 & 0x10) != 0) {
              paramg = null;
            }
            if ((paramInt5 & 0x20) != 0) {
              parami = null;
            }
            if ((paramInt5 & 0x40) != 0) {
              paramd = null;
            }
            i = m;
            if ((paramInt5 & 0x80) != 0)
            {
              paramh = o.beS;
              paramLong3 = o.sw();
              i = m & 0xFE3FFFFF;
            }
            if ((paramInt5 & 0x100) != 0) {
              paramd1 = null;
            }
            if ((paramInt5 & 0x200) != 0) {
              paramc = null;
            }
            k = j;
            if ((paramInt5 & 0x400) != 0)
            {
              paramh = o.beS;
              paramLong4 = o.sw();
              k = j & 0xFFFFFFF1;
            }
            j = k;
            if ((paramInt5 & 0x800) != 0)
            {
              paramh = androidx.compose.ui.m.f.h.beA;
              paramInt1 = androidx.compose.ui.m.f.h.Cd();
              j = k & 0xFFFFFF8F;
            }
            if ((paramInt5 & 0x1000) != 0) {
              paramBoolean = true;
            }
            if ((paramInt5 & 0x2000) != 0) {
              paramInt2 = 2147483647;
            }
            k = j;
            if ((paramInt5 & 0x4000) != 0)
            {
              paramMap = ak.kkZ();
              k = j & 0xFFFF1FFF;
            }
            j = k;
            if ((0x8000 & paramInt5) != 0)
            {
              paramb = (b)t.e.ajC;
              j = k & 0xFFF8FFFF;
            }
            if ((0x10000 & paramInt5) == 0) {
              break label1937;
            }
            paramu = (androidx.compose.ui.m.u)localh.a((p)ajp);
            j &= 0xFFC7FFFF;
          }
          for (;;)
          {
            localh.og();
            k = j;
            paramh = paramb;
            Object localObject1 = paramc;
            Object localObject2 = paramg;
            long l = paramLong2;
            j = i;
            i = k;
            paramb = paramMap;
            paramMap = paramh;
            paramc = paramf;
            paramLong2 = paramLong4;
            paramg = (g)localObject1;
            paramf = paramd1;
            paramLong4 = paramLong3;
            paramd1 = paramd;
            paramd = (androidx.compose.ui.m.b.d)localObject2;
            paramLong3 = l;
            localh.bx(1557617653);
            paramh = z.awK;
            if (paramLong1 != z.sw())
            {
              k = 1;
              label990:
              if (k == 0) {
                break label1754;
              }
              l = paramLong1;
              label998:
              localh.od();
              androidx.compose.foundation.f.a.a(parama, paramc, paramu.a(new androidx.compose.ui.m.u(l, paramLong3, parami, paramd, paramd1, paramLong4, 0L, paramf, paramg, paramLong2, 175952)), paramMap, paramInt1, paramBoolean, paramInt2, paramb, localh, 0x1008000 | j & 0xE | j & 0x70 | i >> 6 & 0x1C00 | 0x70000 & i << 9 | 0x380000 & i << 9, 0);
              paramh = paramb;
              localObject2 = paramd;
              localObject1 = paramc;
              paramb = paramMap;
              paramMap = paramh;
              paramd = paramd1;
              paramh = (androidx.compose.runtime.h)localObject2;
              l = paramLong3;
              paramLong3 = paramLong2;
              paramc = paramg;
              paramd1 = paramf;
              paramf = (f)localObject1;
              label1144:
              paramg = localh.oh();
              if (paramg != null) {
                paramg.b((m)new f(parama, paramf, paramLong1, l, paramh, parami, paramd, paramLong4, paramd1, paramc, paramLong3, paramInt1, paramBoolean, paramInt2, paramMap, paramb, paramu, paramInt3, paramInt4, paramInt5));
              }
              AppMethodBeat.o(201768);
              return;
              if ((paramInt3 & 0xE) != 0) {
                break label1950;
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
              i = 128;
              break label94;
              j = 1024;
              break label139;
              j = i;
              if ((0x70000 & paramInt3) != 0) {
                break label185;
              }
              if (localh.G(parami))
              {
                j = 131072;
                break label178;
              }
              j = 65536;
              break label178;
              i = j;
              if ((0x380000 & paramInt3) != 0) {
                break label204;
              }
              if (localh.G(paramd))
              {
                i = 1048576;
                break label197;
              }
              i = 524288;
              break label197;
              label1379:
              j = 4194304;
              break label241;
              label1387:
              if ((0xE000000 & paramInt3) != 0) {
                break label1947;
              }
              if (localh.G(paramd1))
              {
                i = 67108864;
                break label261;
              }
              i = 33554432;
              break label261;
              j = 2;
              break label320;
              k = j;
              if ((paramInt4 & 0x380) != 0) {
                break label368;
              }
              if (localh.am(paramBoolean))
              {
                k = 256;
                break label361;
              }
              k = 128;
              break label361;
              m = k;
              if ((paramInt4 & 0x1C00) != 0) {
                break label389;
              }
              if (localh.bz(paramInt2))
              {
                j = 2048;
                break label382;
              }
              j = 1024;
              break label382;
              label1512:
              k = 65536;
              break label446;
              label1519:
              j = 524288;
              break label489;
              label1527:
              localh.oj();
              if ((paramInt5 & 0x4) == 0) {
                break label1934;
              }
              i &= 0xFFFFFC7F;
            }
            for (;;)
            {
              k = i;
              if ((paramInt5 & 0x8) != 0) {
                k = i & 0xFFFFE3FF;
              }
              i = k;
              if ((paramInt5 & 0x80) != 0) {
                i = k & 0xFE3FFFFF;
              }
              k = j;
              if ((paramInt5 & 0x400) != 0) {
                k = j & 0xFFFFFFF1;
              }
              j = k;
              if ((paramInt5 & 0x800) != 0) {
                j = k & 0xFFFFFF8F;
              }
              k = j;
              if ((paramInt5 & 0x4000) != 0) {
                k = j & 0xFFFF1FFF;
              }
              j = k;
              if ((0x8000 & paramInt5) != 0) {
                j = k & 0xFFF8FFFF;
              }
              if ((0x10000 & paramInt5) != 0)
              {
                k = j & 0xFFC7FFFF;
                j = i;
                paramh = paramMap;
                l = paramLong4;
                paramMap = paramd1;
                paramLong4 = paramLong3;
                paramd1 = paramd;
                localObject1 = paramf;
                paramLong3 = paramLong2;
                paramd = paramg;
                paramf = paramMap;
                paramg = paramc;
                paramLong2 = l;
                paramc = (c)localObject1;
                paramMap = paramb;
                paramb = paramh;
                i = k;
                break;
                k = 0;
                break label990;
                label1754:
                l = paramu.ayn;
                paramh = z.awK;
                if (l != z.sw()) {}
                for (k = 1;; k = 0)
                {
                  if (k != 0) {
                    break label1833;
                  }
                  l = z.g(((z)localh.a((p)e.nv())).value, ((Number)localh.a((p)d.nu())).floatValue());
                  break;
                }
                break label998;
                localh.oi();
                l = paramLong4;
                paramLong4 = paramLong3;
                paramLong3 = l;
                l = paramLong2;
                paramh = paramg;
                break label1144;
              }
              k = i;
              paramh = paramMap;
              l = paramLong4;
              paramMap = paramd1;
              paramLong4 = paramLong3;
              paramd1 = paramd;
              localObject1 = paramf;
              paramLong3 = paramLong2;
              paramd = paramg;
              paramf = paramMap;
              paramg = paramc;
              paramLong2 = l;
              paramc = (c)localObject1;
              paramMap = paramb;
              paramb = paramh;
              i = j;
              j = k;
              break;
            }
          }
        }
      }
    }
  }
  
  public static final void a(androidx.compose.ui.m.u paramu, final m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(201788);
    s.u(paramu, "value");
    s.u(paramm, "content");
    paramh = paramh.by(1919620117);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramu)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(paramm))
        {
          j = 32;
          label81:
          j |= i;
        }
      }
      else
      {
        if (((j & 0x5B ^ 0x12) == 0) && (paramh.nZ())) {
          break label207;
        }
        androidx.compose.ui.m.u localu = ((androidx.compose.ui.m.u)paramh.a((p)ajp)).a(paramu);
        androidx.compose.runtime.q.a(new at[] { ajp.N(localu) }, paramm, paramh, j & 0x70 | 0x8);
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((m)new b(paramu, paramm, paramInt));
        }
        AppMethodBeat.o(201788);
        return;
        i = 2;
        break;
        j = 16;
        break label81;
        label207:
        paramh.oi();
      }
    }
  }
  
  public static final void a(String paramString, f paramf, final long paramLong1, long paramLong2, final g paramg, i parami, final androidx.compose.ui.m.b.d paramd, final long paramLong3, final androidx.compose.ui.m.f.d paramd1, final c paramc, long paramLong4, final int paramInt1, final boolean paramBoolean, final int paramInt2, b<? super androidx.compose.ui.m.q, ah> paramb, final androidx.compose.ui.m.u paramu, final androidx.compose.runtime.h paramh, final int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(201750);
    s.u(paramString, "text");
    androidx.compose.runtime.h localh = paramh.by(1557612414);
    if ((paramInt5 & 0x1) != 0) {
      i = 6;
    }
    label53:
    label187:
    label1723:
    for (int i = paramInt3 | i;; i = paramInt3)
    {
      int j;
      if ((paramInt5 & 0x2) != 0)
      {
        j = 48;
        j = i | j;
        label60:
        i = j;
        if ((paramInt3 & 0x380) == 0)
        {
          if (((paramInt5 & 0x4) != 0) || (!localh.y(paramLong1))) {
            break label1209;
          }
          i = 256;
          label96:
          i = j | i;
        }
        j = i;
        if ((paramInt3 & 0x1C00) == 0)
        {
          if (((paramInt5 & 0x8) != 0) || (!localh.y(paramLong2))) {
            break label1217;
          }
          j = 2048;
          j = i | j;
        }
        i = j;
        if ((paramInt5 & 0x10) != 0) {
          i = j | 0x2000;
        }
        if ((paramInt5 & 0x20) == 0) {
          break label1225;
        }
        j = 196608;
        j = i | j;
        if ((paramInt5 & 0x40) == 0) {
          break label1263;
        }
        i = 1572864;
        label199:
        i = j | i;
        label206:
        j = i;
        if ((0x1C00000 & paramInt3) == 0)
        {
          if (((paramInt5 & 0x80) != 0) || (!localh.y(paramLong3))) {
            break label1302;
          }
          j = 8388608;
          label243:
          j = i | j;
        }
        if ((paramInt5 & 0x100) == 0) {
          break label1310;
        }
        i = 100663296;
        j |= i;
      }
      label1217:
      for (;;)
      {
        i = j;
        if ((paramInt5 & 0x200) != 0) {
          i = j | 0x10000000;
        }
        if ((paramInt4 & 0xE) == 0) {
          if (((paramInt5 & 0x400) == 0) && (localh.y(paramLong4))) {
            j = 4;
          }
        }
        label322:
        for (int k = paramInt4 | j;; k = paramInt4)
        {
          j = k;
          if ((paramInt5 & 0x800) != 0) {
            j = k | 0x10;
          }
          if ((paramInt5 & 0x1000) != 0)
          {
            k = 384;
            label363:
            k = j | k;
            label370:
            if ((paramInt5 & 0x2000) == 0) {
              break label1394;
            }
            j = 3072;
          }
          for (j = k | j;; j = k)
          {
            k = j;
            if ((0xE000 & paramInt4) == 0)
            {
              if (((paramInt5 & 0x4000) == 0) && (localh.G(paramb)))
              {
                k = 16384;
                k = j | k;
              }
            }
            else
            {
              j = k;
              if ((0x70000 & paramInt4) == 0)
              {
                if (((0x8000 & paramInt5) != 0) || (!localh.G(paramu))) {
                  break label1439;
                }
                j = 131072;
                label473:
                j = k | j;
              }
              if ((((paramInt5 ^ 0xFFFFFFFF) & 0xA10) == 0) && ((0x5B6DB6DB & i ^ 0x12492492) == 0) && ((0x5B6DB & j ^ 0x12492) == 0) && (localh.nZ())) {
                break label1624;
              }
              if (((paramInt3 & 0x1) != 0) && (!localh.oa())) {
                break label1446;
              }
              localh.of();
              if ((paramInt5 & 0x2) != 0) {
                paramf = (f)f.aud;
              }
              if ((paramInt5 & 0x4) == 0) {
                break label1703;
              }
              paramh = z.awK;
              paramLong1 = z.sw();
              i &= 0xFFFFFC7F;
            }
            for (;;)
            {
              k = i;
              if ((paramInt5 & 0x8) != 0)
              {
                paramh = o.beS;
                paramLong2 = o.sw();
                k = i & 0xFFFFE3FF;
              }
              if ((paramInt5 & 0x10) != 0) {
                paramg = null;
              }
              if ((paramInt5 & 0x20) != 0) {
                parami = null;
              }
              if ((paramInt5 & 0x40) != 0) {
                paramd = null;
              }
              i = k;
              if ((paramInt5 & 0x80) != 0)
              {
                paramh = o.beS;
                paramLong3 = o.sw();
                i = k & 0xFE3FFFFF;
              }
              if ((paramInt5 & 0x100) != 0) {
                paramd1 = null;
              }
              if ((paramInt5 & 0x200) != 0) {
                paramc = null;
              }
              if ((paramInt5 & 0x400) != 0)
              {
                paramh = o.beS;
                paramLong4 = o.sw();
              }
              for (k = j & 0xFFFFFFF1;; k = j)
              {
                j = k;
                if ((paramInt5 & 0x800) != 0)
                {
                  paramh = androidx.compose.ui.m.f.h.beA;
                  paramInt1 = androidx.compose.ui.m.f.h.Cd();
                  j = k & 0xFFFFFF8F;
                }
                if ((paramInt5 & 0x1000) != 0) {
                  paramBoolean = true;
                }
                if ((paramInt5 & 0x2000) != 0) {
                  paramInt2 = 2147483647;
                }
                k = j;
                if ((paramInt5 & 0x4000) != 0)
                {
                  paramb = (b)t.c.ajs;
                  k = j & 0xFFFF1FFF;
                }
                if ((0x8000 & paramInt5) != 0) {
                  paramu = (androidx.compose.ui.m.u)localh.a((p)ajp);
                }
                for (j = k & 0xFFF8FFFF;; j = k)
                {
                  localh.og();
                  paramh = parami;
                  Object localObject = paramf;
                  parami = paramu;
                  paramf = paramb;
                  paramu = paramc;
                  paramb = paramd1;
                  paramc = paramd;
                  paramd1 = paramh;
                  paramd = paramg;
                  paramg = (g)localObject;
                  a(new androidx.compose.ui.m.a(paramString, null, null, 6), paramg, paramLong1, paramLong2, paramd, paramd1, paramc, paramLong3, paramb, paramu, paramLong4, paramInt1, paramBoolean, paramInt2, ak.kkZ(), paramf, parami, localh, i & 0xE000000 | 0x40008000 | i & 0x70 | i & 0x380 | i & 0x1C00 | 0x70000 & i | 0x380000 & i | 0x1C00000 & i, j << 3 & 0x380000 | 0x8040 | j & 0xE | j & 0x380 | j & 0x1C00 | 0x70000 & j << 3, 0);
                  paramh = paramc;
                  localObject = paramd1;
                  androidx.compose.ui.m.b.d locald = paramd;
                  g localg = paramg;
                  paramc = paramu;
                  paramd1 = paramb;
                  paramd = paramh;
                  paramg = locald;
                  paramh = localg;
                  paramu = parami;
                  paramb = paramf;
                  paramf = localh.oh();
                  if (paramf != null) {
                    paramf.b((m)new d(paramString, paramh, paramLong1, paramLong2, paramg, (i)localObject, paramd, paramLong3, paramd1, paramc, paramLong4, paramInt1, paramBoolean, paramInt2, paramb, paramu, paramInt3, paramInt4, paramInt5));
                  }
                  AppMethodBeat.o(201750);
                  return;
                  if ((paramInt3 & 0xE) != 0) {
                    break label1723;
                  }
                  if (localh.G(paramString))
                  {
                    i = 4;
                    break;
                  }
                  i = 2;
                  break;
                  j = i;
                  if ((paramInt3 & 0x70) != 0) {
                    break label60;
                  }
                  if (localh.G(paramf))
                  {
                    j = 32;
                    break label53;
                  }
                  j = 16;
                  break label53;
                  i = 128;
                  break label96;
                  j = 1024;
                  break label141;
                  label1225:
                  j = i;
                  if ((0x70000 & paramInt3) != 0) {
                    break label187;
                  }
                  if (localh.G(parami))
                  {
                    j = 131072;
                    break label180;
                  }
                  j = 65536;
                  break label180;
                  label1263:
                  i = j;
                  if ((0x380000 & paramInt3) != 0) {
                    break label206;
                  }
                  if (localh.G(paramd))
                  {
                    i = 1048576;
                    break label199;
                  }
                  i = 524288;
                  break label199;
                  j = 4194304;
                  break label243;
                  if ((0xE000000 & paramInt3) != 0) {
                    break label1720;
                  }
                  if (localh.G(paramd1))
                  {
                    i = 67108864;
                    break label263;
                  }
                  i = 33554432;
                  break label263;
                  j = 2;
                  break label322;
                  k = j;
                  if ((paramInt4 & 0x380) != 0) {
                    break label370;
                  }
                  if (localh.am(paramBoolean))
                  {
                    k = 256;
                    break label363;
                  }
                  k = 128;
                  break label363;
                  label1394:
                  if ((paramInt4 & 0x1C00) != 0) {
                    break label1706;
                  }
                  if (localh.bz(paramInt2))
                  {
                    j = 2048;
                    break label384;
                  }
                  j = 1024;
                  break label384;
                  k = 8192;
                  break label430;
                  j = 65536;
                  break label473;
                  localh.oj();
                  if ((paramInt5 & 0x4) != 0) {
                    i &= 0xFFFFFC7F;
                  }
                  for (;;)
                  {
                    k = i;
                    if ((paramInt5 & 0x8) != 0) {
                      k = i & 0xFFFFE3FF;
                    }
                    i = k;
                    if ((paramInt5 & 0x80) != 0) {
                      i = k & 0xFE3FFFFF;
                    }
                    k = j;
                    if ((paramInt5 & 0x400) != 0) {
                      k = j & 0xFFFFFFF1;
                    }
                    j = k;
                    if ((paramInt5 & 0x800) != 0) {
                      j = k & 0xFFFFFF8F;
                    }
                    k = j;
                    if ((paramInt5 & 0x4000) != 0) {
                      k = j & 0xFFFF1FFF;
                    }
                    if ((0x8000 & paramInt5) != 0)
                    {
                      j = k & 0xFFF8FFFF;
                      paramh = paramu;
                      localObject = paramb;
                      paramu = paramc;
                      paramb = paramd1;
                      paramc = paramd;
                      paramd = paramg;
                      paramg = paramf;
                      paramd1 = parami;
                      paramf = (f)localObject;
                      parami = paramh;
                      break;
                      label1624:
                      localh.oi();
                      paramh = paramf;
                      localObject = parami;
                      break label1070;
                    }
                    j = k;
                    paramh = paramu;
                    localObject = paramb;
                    paramu = paramc;
                    paramb = paramd1;
                    paramc = paramd;
                    paramd = paramg;
                    paramg = paramf;
                    paramd1 = parami;
                    paramf = (f)localObject;
                    parami = paramh;
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static final as<androidx.compose.ui.m.u> nA()
  {
    return ajp;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/TextStyle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<androidx.compose.ui.m.u>
  {
    public static final a ajq;
    
    static
    {
      AppMethodBeat.i(201657);
      ajq = new a();
      AppMethodBeat.o(201657);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    b(androidx.compose.ui.m.u paramu, m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    d(String paramString, f paramf, long paramLong1, long paramLong2, g paramg, i parami, androidx.compose.ui.m.b.d paramd, long paramLong3, androidx.compose.ui.m.f.d paramd1, c paramc, long paramLong4, int paramInt1, boolean paramBoolean, int paramInt2, b<? super androidx.compose.ui.m.q, ah> paramb, androidx.compose.ui.m.u paramu, int paramInt3, int paramInt4, int paramInt5)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    f(androidx.compose.ui.m.a parama, f paramf, long paramLong1, long paramLong2, g paramg, i parami, androidx.compose.ui.m.b.d paramd, long paramLong3, androidx.compose.ui.m.f.d paramd1, c paramc, long paramLong4, int paramInt1, boolean paramBoolean, int paramInt2, Map<String, androidx.compose.foundation.f.d> paramMap, b<? super androidx.compose.ui.m.q, ah> paramb, androidx.compose.ui.m.u paramu, int paramInt3, int paramInt4, int paramInt5)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.t
 * JD-Core Version:    0.7.0.1
 */