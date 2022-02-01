package com.tencent.mm.aj.b;

import androidx.compose.b.t;
import androidx.compose.runtime.ba;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.f.c;
import androidx.compose.ui.m.q;
import androidx.compose.ui.n.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"INLINE_CONTENT_TAG", "", "MMClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "MMClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "MMText", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "MMText-fLXpl1I", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "emojiProcess", "Lkotlin/Pair;", "", "Landroidx/compose/foundation/text/InlineTextContent;", "emojiProcess-r9BaKPg", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final void b(String paramString, final f paramf, final long paramLong1, long paramLong2, final androidx.compose.ui.m.b.g paramg, i parami, final androidx.compose.ui.m.b.d paramd, final long paramLong3, final androidx.compose.ui.m.f.d paramd1, final c paramc, long paramLong4, final int paramInt1, final boolean paramBoolean, final int paramInt2, b<? super q, ah> paramb, final androidx.compose.ui.m.u paramu, androidx.compose.runtime.h paramh, final int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(238707);
    s.u(paramString, "text");
    paramh = paramh.by(786565435);
    if ((paramInt5 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label1339:
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
          if (((paramInt5 & 0x4) != 0) || (!paramh.y(paramLong1))) {
            break label1081;
          }
          i = 256;
          label94:
          i = j | i;
        }
        if ((paramInt5 & 0x8) == 0) {
          break label1089;
        }
        j = 3072;
        label114:
        j = i | j;
        label121:
        i = j;
        if ((paramInt5 & 0x10) != 0) {
          i = j | 0x2000;
        }
        if ((paramInt5 & 0x20) == 0) {
          break label1130;
        }
        j = 196608;
        j = i | j;
        if ((paramInt5 & 0x40) == 0) {
          break label1168;
        }
        i = 1572864;
        i = j | i;
        j = i;
        if ((0x1C00000 & paramInt3) == 0)
        {
          if (((paramInt5 & 0x80) != 0) || (!paramh.y(paramLong3))) {
            break label1206;
          }
          j = 8388608;
          label216:
          j = i | j;
        }
        if ((paramInt5 & 0x100) == 0) {
          break label1213;
        }
        i = 100663296;
        label236:
        j |= i;
      }
      label1213:
      for (;;)
      {
        i = j;
        if ((paramInt5 & 0x200) != 0) {
          i = j | 0x10000000;
        }
        if ((paramInt4 & 0xE) == 0) {
          if (((paramInt5 & 0x400) == 0) && (paramh.y(paramLong4))) {
            j = 4;
          }
        }
        label445:
        label1089:
        label1346:
        label1474:
        for (int k = paramInt4 | j;; k = paramInt4)
        {
          j = k;
          if ((paramInt5 & 0x800) != 0) {
            j = k | 0x10;
          }
          if ((paramInt5 & 0x1000) != 0)
          {
            k = 384;
            label336:
            k = j | k;
            label343:
            if ((paramInt5 & 0x2000) == 0) {
              break label1294;
            }
            j = 3072;
          }
          label357:
          label1130:
          label1516:
          label1523:
          for (j = k | j;; j = k)
          {
            k = j;
            Object localObject;
            if ((0xE000 & paramInt4) == 0)
            {
              if (((paramInt5 & 0x4000) == 0) && (paramh.G(paramb)))
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
                if (((0x8000 & paramInt5) != 0) || (!paramh.G(paramu))) {
                  break label1339;
                }
                j = 131072;
                j = k | j;
              }
              if ((((paramInt5 ^ 0xFFFFFFFF) & 0xA10) == 0) && ((0x5B6DB6DB & i ^ 0x12492492) == 0) && ((0x5B6DB & j ^ 0x12492) == 0) && (paramh.nZ())) {
                break label1474;
              }
              if (((paramInt3 & 0x1) != 0) && (!paramh.oa())) {
                break label1346;
              }
              paramh.of();
              if ((paramInt5 & 0x2) != 0) {
                paramf = (f)f.aud;
              }
              if ((paramInt5 & 0x4) == 0) {
                break label1516;
              }
              localObject = z.awK;
              paramLong1 = z.sw();
            }
            for (k = i & 0xFFFFFC7F;; k = i)
            {
              if ((paramInt5 & 0x8) != 0) {
                paramLong2 = androidx.compose.ui.n.p.dG(18);
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
                localObject = o.beS;
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
                localObject = o.beS;
                paramLong4 = o.sw();
              }
              for (k = j & 0xFFFFFFF1;; k = j)
              {
                j = k;
                if ((paramInt5 & 0x800) != 0)
                {
                  localObject = androidx.compose.ui.m.f.h.beA;
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
                  paramb = (b)g.a.ogQ;
                  k = j & 0xFFFF1FFF;
                }
                if ((0x8000 & paramInt5) != 0) {
                  paramu = (androidx.compose.ui.m.u)paramh.a((androidx.compose.runtime.p)t.nA());
                }
                for (j = k & 0xFFF8FFFF;; j = k)
                {
                  paramh.og();
                  k = j;
                  j = i;
                  i = k;
                  t.a(paramString, paramf, paramLong1, paramLong2, paramg, parami, paramd, paramLong3, paramd1, paramc, paramLong4, paramInt1, paramBoolean, paramInt2, paramb, paramu, paramh, 0xE000000 & j | 0x40008000 | j & 0xE | j & 0x70 | j & 0x380 | j & 0x1C00 | 0x70000 & j | 0x380000 & j | 0x1C00000 & j, i & 0x70000 | i & 0xE | 0x40 | i & 0x380 | i & 0x1C00 | 0xE000 & i, 0);
                  paramh = paramh.oh();
                  if (paramh != null) {
                    paramh.b((m)new b(paramString, paramf, paramLong1, paramLong2, paramg, parami, paramd, paramLong3, paramd1, paramc, paramLong4, paramInt1, paramBoolean, paramInt2, paramb, paramu, paramInt3, paramInt4, paramInt5));
                  }
                  AppMethodBeat.o(238707);
                  return;
                  if ((paramInt3 & 0xE) != 0) {
                    break label1540;
                  }
                  if (paramh.G(paramString))
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
                  if (paramh.G(paramf))
                  {
                    j = 32;
                    break label51;
                  }
                  j = 16;
                  break label51;
                  i = 128;
                  break label94;
                  j = i;
                  if ((paramInt3 & 0x1C00) != 0) {
                    break label121;
                  }
                  if (paramh.y(paramLong2))
                  {
                    j = 2048;
                    break label114;
                  }
                  j = 1024;
                  break label114;
                  j = i;
                  if ((0x70000 & paramInt3) != 0) {
                    break label160;
                  }
                  if (paramh.G(parami))
                  {
                    j = 131072;
                    break label153;
                  }
                  j = 65536;
                  break label153;
                  i = j;
                  if ((0x380000 & paramInt3) != 0) {
                    break label179;
                  }
                  if (paramh.G(paramd))
                  {
                    i = 1048576;
                    break label172;
                  }
                  i = 524288;
                  break label172;
                  j = 4194304;
                  break label216;
                  if ((0xE000000 & paramInt3) != 0) {
                    break label1537;
                  }
                  if (paramh.G(paramd1))
                  {
                    i = 67108864;
                    break label236;
                  }
                  i = 33554432;
                  break label236;
                  j = 2;
                  break label295;
                  k = j;
                  if ((paramInt4 & 0x380) != 0) {
                    break label343;
                  }
                  if (paramh.am(paramBoolean))
                  {
                    k = 256;
                    break label336;
                  }
                  k = 128;
                  break label336;
                  if ((paramInt4 & 0x1C00) != 0) {
                    break label1523;
                  }
                  if (paramh.bz(paramInt2))
                  {
                    j = 2048;
                    break label357;
                  }
                  j = 1024;
                  break label357;
                  k = 8192;
                  break label402;
                  j = 65536;
                  break label445;
                  paramh.oj();
                  if ((paramInt5 & 0x4) != 0) {}
                  for (k = i & 0xFFFFFC7F;; k = i)
                  {
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
                      k &= 0xFFF8FFFF;
                      j = i;
                      i = k;
                      break;
                      paramh.oi();
                      break label941;
                    }
                    j = i;
                    i = k;
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
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    b(String paramString, f paramf, long paramLong1, long paramLong2, androidx.compose.ui.m.b.g paramg, i parami, androidx.compose.ui.m.b.d paramd, long paramLong3, androidx.compose.ui.m.f.d paramd1, c paramc, long paramLong4, int paramInt1, boolean paramBoolean, int paramInt2, b<? super q, ah> paramb, androidx.compose.ui.m.u paramu, int paramInt3, int paramInt4, int paramInt5)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.g
 * JD-Core Version:    0.7.0.1
 */