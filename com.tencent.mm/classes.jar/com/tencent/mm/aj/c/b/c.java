package com.tencent.mm.aj.c.b;

import androidx.compose.foundation.a.i;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.a.l;
import androidx.compose.foundation.c.t;
import androidx.compose.foundation.lazy.w;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.a.a;
import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.q;

@Metadata(d1={""}, d2={"DebugLog", "", "HorizontalPager", "", "count", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/tencent/mm/mm_compose/widget/pager/PagerState;", "reverseLayout", "itemSpacing", "Landroidx/compose/ui/unit/Dp;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "page", "", "content", "Lkotlin/Function2;", "Lcom/tencent/mm/mm_compose/widget/pager/PagerScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-Fsagccs", "(ILandroidx/compose/ui/Modifier;Lcom/tencent/mm/mm_compose/widget/pager/PagerState;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Pager", "isVertical", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Pager-05tvjtU", "(ILandroidx/compose/ui/Modifier;Lcom/tencent/mm/mm_compose/widget/pager/PagerState;ZFZLandroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "VerticalPager-Fsagccs", "(ILandroidx/compose/ui/Modifier;Lcom/tencent/mm/mm_compose/widget/pager/PagerState;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateCurrentOffsetForPage", "", "consume", "Landroidx/compose/ui/geometry/Offset;", "consumeHorizontal", "consumeVertical", "consume-9KIMszo", "(JZZ)J", "Landroidx/compose/ui/unit/Velocity;", "consume-BMRW4eQ", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final void a(int paramInt1, final androidx.compose.ui.f paramf, final f paramf1, final boolean paramBoolean, final float paramFloat, final t paramt, final a.c paramc, final i parami, final kotlin.g.a.b<? super Integer, ? extends Object> paramb, final kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, androidx.compose.runtime.h paramh, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(238811);
    s.u(paramr, "content");
    androidx.compose.runtime.h localh = paramh.by(-1821944112);
    if ((paramInt3 & 0x1) != 0) {
      i = 6;
    }
    label52:
    label59:
    label197:
    label1105:
    label1112:
    for (int i = paramInt2 | i;; i = paramInt2)
    {
      if ((paramInt3 & 0x2) != 0)
      {
        j = 48;
        j = i | j;
        i = j;
        if ((paramInt2 & 0x380) == 0)
        {
          if (((paramInt3 & 0x4) != 0) || (!localh.G(paramf1))) {
            break label773;
          }
          i = 256;
          label95:
          i = j | i;
        }
        if ((paramInt3 & 0x8) == 0) {
          break label781;
        }
        j = 3072;
        label115:
        j = i | j;
        label122:
        if ((paramInt3 & 0x10) == 0) {
          break label821;
        }
        i = 24576;
        i = j | i;
        if ((paramInt3 & 0x20) == 0) {
          break label861;
        }
        j = 196608;
        j = i | j;
        int k = j;
        if ((0x380000 & paramInt2) == 0)
        {
          if (((paramInt3 & 0x40) != 0) || (!localh.G(paramc))) {
            break label899;
          }
          i = 1048576;
          k = j | i;
        }
        i = k;
        if ((0x1C00000 & paramInt2) == 0)
        {
          if (((paramInt3 & 0x80) != 0) || (!localh.G(parami))) {
            break label906;
          }
          i = 8388608;
          label241:
          i = k | i;
        }
        if ((paramInt3 & 0x100) == 0) {
          break label913;
        }
        j = 100663296;
        j = i | j;
        if ((paramInt3 & 0x200) == 0) {
          break label951;
        }
        i = 805306368;
        i = j | i;
        if (((0x5B6DB6DB & i ^ 0x12492492) == 0) && (localh.nZ())) {
          break label1069;
        }
        if (((paramInt2 & 0x1) != 0) && (!localh.oa())) {
          break label989;
        }
        localh.of();
        if ((paramInt3 & 0x2) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if ((paramInt3 & 0x4) == 0) {
          break label1105;
        }
        paramf1 = g.r(localh);
      }
      for (int j = i & 0xFFFFFC7F;; j = i)
      {
        if ((paramInt3 & 0x8) != 0) {
          paramBoolean = false;
        }
        if ((paramInt3 & 0x10) != 0) {
          paramFloat = androidx.compose.ui.n.g.ai(0.0F);
        }
        if ((paramInt3 & 0x20) != 0) {
          paramt = androidx.compose.foundation.c.r.C(androidx.compose.ui.n.g.ai(0.0F));
        }
        i = j;
        if ((paramInt3 & 0x40) != 0)
        {
          paramc = androidx.compose.ui.a.atD;
          paramc = a.a.sc();
          i = j & 0xFFC7FFFF;
        }
        j = i;
        if ((paramInt3 & 0x80) != 0)
        {
          parami = b.ohT;
          parami = b.a(paramf1, androidx.compose.foundation.c.r.a(paramt, n.beP), localh);
          j = i & 0xFE3FFFFF;
        }
        if ((paramInt3 & 0x100) != 0) {
          paramb = null;
        }
        localh.og();
        paramh = paramb;
        Object localObject = parami;
        paramb = paramc;
        paramc = paramt;
        parami = paramh;
        paramt = (t)localObject;
        a(paramInt1, paramf, paramf1, paramBoolean, paramFloat, false, paramt, parami, paramc, paramb, null, paramr, localh, 0x70000000 & j << 9 | 0x30000 | j & 0xE | j & 0x70 | j & 0x380 | j & 0x1C00 | 0xE000 & j | 0x380000 & j >> 3 | 0x1C00000 & j >> 3 | 0xE000000 & j << 9, j >> 24 & 0x70, 1024);
        paramh = paramb;
        localObject = paramc;
        paramb = parami;
        parami = paramt;
        paramc = paramh;
        paramt = (t)localObject;
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramInt1, paramf, paramf1, paramBoolean, paramFloat, paramt, paramc, parami, paramb, paramr, paramInt2, paramInt3));
        }
        AppMethodBeat.o(238811);
        return;
        if ((paramInt2 & 0xE) != 0) {
          break label1112;
        }
        if (localh.bz(paramInt1))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        j = i;
        if ((paramInt2 & 0x70) != 0) {
          break label59;
        }
        if (localh.G(paramf))
        {
          j = 32;
          break label52;
        }
        j = 16;
        break label52;
        i = 128;
        break label95;
        j = i;
        if ((paramInt2 & 0x1C00) != 0) {
          break label122;
        }
        if (localh.am(paramBoolean))
        {
          j = 2048;
          break label115;
        }
        j = 1024;
        break label115;
        i = j;
        if ((0xE000 & paramInt2) != 0) {
          break label142;
        }
        if (localh.H(paramFloat))
        {
          i = 16384;
          break label135;
        }
        i = 8192;
        break label135;
        label861:
        j = i;
        if ((0x70000 & paramInt2) != 0) {
          break label161;
        }
        if (localh.G(paramt))
        {
          j = 131072;
          break label154;
        }
        j = 65536;
        break label154;
        i = 524288;
        break label197;
        i = 4194304;
        break label241;
        j = i;
        if ((0xE000000 & paramInt2) != 0) {
          break label268;
        }
        if (localh.G(paramb))
        {
          j = 67108864;
          break label261;
        }
        j = 33554432;
        break label261;
        i = j;
        if ((0x70000000 & paramInt2) != 0) {
          break label288;
        }
        if (localh.G(paramr))
        {
          i = 536870912;
          break label281;
        }
        i = 268435456;
        break label281;
        label989:
        localh.oj();
        if ((paramInt3 & 0x4) != 0) {
          i &= 0xFFFFFC7F;
        }
        for (;;)
        {
          j = i;
          if ((paramInt3 & 0x40) != 0) {
            j = i & 0xFFC7FFFF;
          }
          if ((paramInt3 & 0x80) != 0)
          {
            j &= 0xFE3FFFFF;
            paramh = paramc;
            paramc = paramt;
            paramt = parami;
            parami = paramb;
            paramb = paramh;
            break;
            localh.oi();
            break label648;
          }
          paramh = paramc;
          paramc = paramt;
          paramt = parami;
          parami = paramb;
          paramb = paramh;
          break;
        }
      }
    }
  }
  
  public static final void a(final int paramInt1, final androidx.compose.ui.f paramf, final f paramf1, final boolean paramBoolean1, final float paramFloat, final boolean paramBoolean2, final i parami, final kotlin.g.a.b<? super Integer, ? extends Object> paramb, final t paramt, final a.c paramc, final a.b paramb1, final kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, androidx.compose.runtime.h paramh, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(238830);
    s.u(paramf, "modifier");
    s.u(paramf1, "state");
    s.u(parami, "flingBehavior");
    s.u(paramt, "contentPadding");
    s.u(paramr, "content");
    androidx.compose.runtime.h localh = paramh.by(-264485857);
    final int i;
    if ((paramInt4 & 0x1) != 0) {
      i = 6;
    }
    label84:
    label91:
    label103:
    label110:
    label2033:
    label2036:
    label2039:
    for (int j = paramInt2 | i;; j = paramInt2)
    {
      if ((paramInt4 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt4 & 0x4) == 0) {
          break label566;
        }
        j = 384;
        j = i | j;
        if ((paramInt4 & 0x8) == 0) {
          break label606;
        }
        i = 3072;
        label123:
        i = j | i;
        if ((paramInt4 & 0x10) == 0) {
          break label646;
        }
        j = 24576;
        j = i | j;
        if ((paramInt4 & 0x20) == 0) {
          break label686;
        }
        i = 196608;
        i = j | i;
        if ((paramInt4 & 0x40) == 0) {
          break label724;
        }
        j = 1572864;
        j = i | j;
        if ((paramInt4 & 0x80) == 0) {
          break label762;
        }
        i = 12582912;
        i = j | i;
        if ((paramInt4 & 0x100) == 0) {
          break label800;
        }
        j = 100663296;
      }
      label762:
      label2046:
      for (j = i | j;; j = i)
      {
        i = j;
        if ((0x70000000 & paramInt2) == 0)
        {
          if (((paramInt4 & 0x200) == 0) && (localh.G(paramc)))
          {
            i = 536870912;
            i = j | i;
          }
        }
        else
        {
          if ((paramInt3 & 0xE) != 0) {
            break label2039;
          }
          if (((paramInt4 & 0x400) != 0) || (!localh.G(paramb1))) {
            break label841;
          }
          j = 4;
        }
        for (j = paramInt3 | j;; j = paramInt3)
        {
          int k;
          if ((paramInt4 & 0x800) != 0)
          {
            k = 48;
            j = k | j;
          }
          for (;;)
          {
            if (((0x5B6DB6DB & i ^ 0x12492492) != 0) || ((j & 0x5B ^ 0x12) != 0) || (!localh.nZ())) {
              if (((paramInt2 & 0x1) == 0) || (localh.oa()))
              {
                localh.of();
                if ((paramInt4 & 0x200) == 0) {
                  break label2033;
                }
                paramc = androidx.compose.ui.a.atD;
                paramc = a.a.sc();
                i = 0x8FFFFFFF & i;
              }
            }
            for (;;)
            {
              k = j;
              if ((paramInt4 & 0x400) != 0)
              {
                paramb1 = androidx.compose.ui.a.atD;
                paramb1 = a.a.se();
                k = j & 0xFFFFFFF1;
              }
              localh.og();
              j = i;
              i = k;
              if (paramInt1 >= 0)
              {
                k = 1;
                if (k != 0) {
                  break label938;
                }
                paramf = (Throwable)new IllegalArgumentException("pageCount must be >= 0".toString());
                AppMethodBeat.o(238830);
                throw paramf;
                if ((paramInt2 & 0xE) != 0) {
                  break label2053;
                }
                if (localh.bz(paramInt1))
                {
                  i = 4;
                  break;
                }
                i = 2;
                break;
                i = j;
                if ((paramInt2 & 0x70) != 0) {
                  break label91;
                }
                if (localh.G(paramf))
                {
                  i = 32;
                  break label84;
                }
                i = 16;
                break label84;
                j = i;
                if ((paramInt2 & 0x380) != 0) {
                  break label110;
                }
                if (localh.G(paramf1))
                {
                  j = 256;
                  break label103;
                }
                j = 128;
                break label103;
                i = j;
                if ((paramInt2 & 0x1C00) != 0) {
                  break label130;
                }
                if (localh.am(paramBoolean1))
                {
                  i = 2048;
                  break label123;
                }
                i = 1024;
                break label123;
                j = i;
                if ((0xE000 & paramInt2) != 0) {
                  break label150;
                }
                if (localh.H(paramFloat))
                {
                  j = 16384;
                  break label143;
                }
                j = 8192;
                break label143;
                i = j;
                if ((0x70000 & paramInt2) != 0) {
                  break label169;
                }
                if (localh.am(paramBoolean2))
                {
                  i = 131072;
                  break label162;
                }
                i = 65536;
                break label162;
                j = i;
                if ((0x380000 & paramInt2) != 0) {
                  break label189;
                }
                if (localh.G(parami))
                {
                  j = 1048576;
                  break label182;
                }
                j = 524288;
                break label182;
                i = j;
                if ((0x1C00000 & paramInt2) != 0) {
                  break label210;
                }
                if (localh.G(paramb))
                {
                  i = 8388608;
                  break label203;
                }
                i = 4194304;
                break label203;
                if ((0xE000000 & paramInt2) != 0) {
                  break label2046;
                }
                if (localh.G(paramt))
                {
                  j = 67108864;
                  break label223;
                }
                j = 33554432;
                break label223;
                i = 268435456;
                break label267;
                j = 2;
                break label306;
                if ((paramInt3 & 0x70) != 0) {
                  break label2036;
                }
                if (localh.G(paramr))
                {
                  k = 32;
                  break label326;
                }
                k = 16;
                break label326;
                localh.oj();
                if ((paramInt4 & 0x200) == 0) {
                  break label2030;
                }
                i = 0x8FFFFFFF & i;
              }
              for (;;)
              {
                if ((paramInt4 & 0x400) != 0)
                {
                  k = j & 0xFFFFFFF1;
                  j = i;
                  i = k;
                  break;
                  k = 0;
                  break label468;
                  localh.bx(-3686930);
                  boolean bool1 = localh.G(parami);
                  paramh = localh.or();
                  final e locale;
                  if (!bool1)
                  {
                    localObject1 = androidx.compose.runtime.h.alD;
                    if (paramh != h.a.ox()) {}
                  }
                  else
                  {
                    paramh = (kotlin.g.a.a)new b(parami);
                    localh.F(paramh);
                    localh.od();
                    paramf1.ac((kotlin.g.a.a)paramh);
                    localh.bx(-3686552);
                    bool1 = localh.G(paramf1);
                    boolean bool2 = localh.G(Integer.valueOf(paramInt1));
                    localObject1 = localh.or();
                    if (!(bool1 | bool2))
                    {
                      paramh = androidx.compose.runtime.h.alD;
                      paramh = (androidx.compose.runtime.h)localObject1;
                      if (localObject1 != h.a.ox()) {}
                    }
                    else
                    {
                      paramh = (kotlin.g.a.m)new c(paramf1, paramInt1, null);
                      localh.F(paramh);
                    }
                    localh.od();
                    androidx.compose.runtime.aa.a(Integer.valueOf(paramInt1), (kotlin.g.a.m)paramh, localh);
                    localh.bx(-3686930);
                    bool1 = localh.G(paramf1);
                    paramh = localh.or();
                    if (!bool1)
                    {
                      localObject1 = androidx.compose.runtime.h.alD;
                      if (paramh != h.a.ox()) {
                        break label1537;
                      }
                    }
                    paramh = (kotlin.g.a.m)new d(paramf1, null);
                    localh.F(paramh);
                    localh.od();
                    androidx.compose.runtime.aa.a(paramf1, (kotlin.g.a.m)paramh, localh);
                    localh.bx(-3686930);
                    bool1 = localh.G(paramf1);
                    paramh = localh.or();
                    if (!bool1)
                    {
                      localObject1 = androidx.compose.runtime.h.alD;
                      if (paramh != h.a.ox()) {
                        break label1540;
                      }
                    }
                    paramh = (kotlin.g.a.m)new e(paramf1, null);
                    localh.F(paramh);
                    localh.od();
                    androidx.compose.runtime.aa.a(paramf1, (kotlin.g.a.m)paramh, localh);
                    localh.bx(-3686930);
                    bool1 = localh.G(paramf1);
                    localObject1 = localh.or();
                    if (!bool1)
                    {
                      paramh = androidx.compose.runtime.h.alD;
                      paramh = (androidx.compose.runtime.h)localObject1;
                      if (localObject1 != h.a.ox()) {}
                    }
                    else
                    {
                      paramh = new e(paramf1);
                      localh.F(paramh);
                    }
                    localh.od();
                    locale = (e)paramh;
                    if (paramBoolean2) {
                      break label1543;
                    }
                  }
                  final a locala;
                  androidx.compose.foundation.lazy.aa localaa;
                  Object localObject2;
                  int m;
                  for (bool1 = true;; bool1 = false)
                  {
                    locala = new a(bool1, paramBoolean2);
                    if (!paramBoolean2) {
                      break label1752;
                    }
                    localh.bx(-264483715);
                    localaa = paramf1.afi;
                    paramh = androidx.compose.foundation.c.a.abN;
                    localObject2 = androidx.compose.foundation.c.a.a(paramFloat, paramc);
                    localh.bx(-3685570);
                    k = 0;
                    m = 0;
                    while (m < 5)
                    {
                      paramh = new Object[] { Integer.valueOf(paramInt1), paramb, locala, paramr, locale }[m];
                      m += 1;
                      k |= localh.G(paramh);
                    }
                    break;
                    break label1207;
                    break label1295;
                  }
                  Object localObject1 = localh.or();
                  if (k == 0)
                  {
                    paramh = androidx.compose.runtime.h.alD;
                    paramh = (androidx.compose.runtime.h)localObject1;
                    if (localObject1 != h.a.ox()) {}
                  }
                  else
                  {
                    paramh = (kotlin.g.a.b)new f(paramInt1, paramb, locala, paramr, locale, i);
                    localh.F(paramh);
                  }
                  localh.od();
                  androidx.compose.foundation.lazy.g.a(paramf, localaa, paramt, paramBoolean1, (a.l)localObject2, paramb1, parami, (kotlin.g.a.b)paramh, localh, j >> 3 & 0xE | j >> 18 & 0x380 | j & 0x1C00 | 0x70000 & i << 15 | 0x380000 & j, 0);
                  localh.od();
                  for (;;)
                  {
                    paramh = localh.oh();
                    if (paramh != null) {
                      paramh.b((kotlin.g.a.m)new h(paramInt1, paramf, paramf1, paramBoolean1, paramFloat, paramBoolean2, parami, paramb, paramt, paramc, paramb1, paramr, paramInt2, paramInt3, paramInt4));
                    }
                    AppMethodBeat.o(238830);
                    return;
                    localh.bx(-264482559);
                    localaa = paramf1.afi;
                    paramh = androidx.compose.foundation.c.a.abN;
                    localObject2 = androidx.compose.foundation.c.a.a(paramFloat, paramb1);
                    localh.bx(-3685570);
                    k = 0;
                    m = 0;
                    while (m < 5)
                    {
                      paramh = new Object[] { Integer.valueOf(paramInt1), paramb, locala, paramr, locale }[m];
                      m += 1;
                      k |= localh.G(paramh);
                    }
                    localObject1 = localh.or();
                    if (k == 0)
                    {
                      paramh = androidx.compose.runtime.h.alD;
                      paramh = (androidx.compose.runtime.h)localObject1;
                      if (localObject1 != h.a.ox()) {}
                    }
                    else
                    {
                      paramh = (kotlin.g.a.b)new g(paramInt1, paramb, locala, paramr, locale, i);
                      localh.F(paramh);
                    }
                    localh.od();
                    androidx.compose.foundation.lazy.g.a(paramf, localaa, paramt, paramBoolean1, (a.d)localObject2, paramc, parami, (kotlin.g.a.b)paramh, localh, j >> 3 & 0xE | j >> 18 & 0x380 | j & 0x1C00 | 0x70000 & j >> 12 | 0x380000 & j, 0);
                    localh.od();
                    continue;
                    localh.oi();
                  }
                }
                k = i;
                i = j;
                j = k;
                break;
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(int paramInt1, androidx.compose.ui.f paramf, f paramf1, boolean paramBoolean, float paramFloat, t paramt, a.c paramc, i parami, kotlin.g.a.b<? super Integer, ? extends Object> paramb, kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, int paramInt2, int paramInt3)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(f paramf, int paramInt, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(238829);
      paramObject = (kotlin.d.d)new c(this.ohW, paramInt1, paramd);
      AppMethodBeat.o(238829);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238825);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238825);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.ohW.uS(kotlin.k.k.qu(Math.min(paramInt1 - 1, this.ohW.bzk()), 0));
      paramObject = ah.aiuX;
      AppMethodBeat.o(238825);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(f paramf, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(238840);
      paramObject = (kotlin.d.d)new d(this.ohW, paramd);
      AppMethodBeat.o(238840);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238832);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238832);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = q.b((kotlinx.coroutines.b.g)new b(bj.g((kotlin.g.a.a)new u(this.ohW) {})), 1);
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.ohW);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(238832);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(238832);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Boolean>
    {
      public a(f paramf) {}
      
      public final Object a(Boolean paramBoolean, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(238812);
        ((Boolean)paramBoolean).booleanValue();
        this.ohZ.bzr();
        paramBoolean = ah.aiuX;
        AppMethodBeat.o(238812);
        return paramBoolean;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.g<Boolean>
    {
      public b(kotlinx.coroutines.b.g paramg) {}
      
      public final Object a(kotlinx.coroutines.b.h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(238814);
        paramh = this.bLp.a((kotlinx.coroutines.b.h)new kotlinx.coroutines.b.h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(238818);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(238804);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.oia.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(238804);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(238818);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            int i;
            if (!((Boolean)paramAnonymousObject).booleanValue()) {
              i = 1;
            }
            while (i != 0)
            {
              paramAnonymousd.label = 1;
              if (((kotlinx.coroutines.b.h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
              {
                AppMethodBeat.o(238818);
                return localObject1;
                i = 0;
                continue;
                ResultKt.throwOnFailure(localObject2);
              }
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(238818);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(238814);
          return paramh;
        }
        paramh = ah.aiuX;
        AppMethodBeat.o(238814);
        return paramh;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(f paramf, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(238819);
      paramObject = (kotlin.d.d)new e(this.ohW, paramd);
      AppMethodBeat.o(238819);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238816);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238816);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)new b(bj.g((kotlin.g.a.a)new u(this.ohW) {}), this.ohW);
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.ohW);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(238816);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(238816);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<androidx.compose.foundation.lazy.m>
    {
      public a(f paramf) {}
      
      public final Object a(androidx.compose.foundation.lazy.m paramm, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(238770);
        this.ohZ.bzq();
        paramm = ah.aiuX;
        AppMethodBeat.o(238770);
        return paramm;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.g<androidx.compose.foundation.lazy.m>
    {
      public b(kotlinx.coroutines.b.g paramg, f paramf) {}
      
      public final Object a(kotlinx.coroutines.b.h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(238772);
        paramh = this.bLp.a((kotlinx.coroutines.b.h)new kotlinx.coroutines.b.h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(238810);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(238767);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.oib.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(238767);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(238810);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            int i;
            if (!this.ohZ.afi.ml()) {
              i = 1;
            }
            while (i != 0)
            {
              paramAnonymousd.label = 1;
              if (((kotlinx.coroutines.b.h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
              {
                AppMethodBeat.o(238810);
                return localObject1;
                i = 0;
                continue;
                ResultKt.throwOnFailure(localObject2);
              }
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(238810);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(238772);
          return paramh;
        }
        paramh = ah.aiuX;
        AppMethodBeat.o(238772);
        return paramh;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<w, ah>
  {
    f(int paramInt1, kotlin.g.a.b<? super Integer, ? extends Object> paramb, a parama, kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, e parame, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<w, ah>
  {
    g(int paramInt1, kotlin.g.a.b<? super Integer, ? extends Object> paramb, a parama, kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, e parame, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(int paramInt1, androidx.compose.ui.f paramf, f paramf1, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, i parami, kotlin.g.a.b<? super Integer, ? extends Object> paramb, t paramt, a.c paramc, a.b paramb1, kotlin.g.a.r<? super d, ? super Integer, ? super androidx.compose.runtime.h, ? super Integer, ah> paramr, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.b.c
 * JD-Core Version:    0.7.0.1
 */