package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.a.a.ai;
import androidx.compose.a.a.am;
import androidx.compose.a.a.aw;
import androidx.compose.a.a.ay;
import androidx.compose.b.t;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.f;
import androidx.compose.ui.h.ae;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.m.b.g;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.n.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"GradientEdge", "", "startColor", "Landroidx/compose/ui/graphics/Color;", "endColor", "GradientEdge-RFnl5yQ", "(JJLandroidx/compose/runtime/Composer;I)V", "MarqueeText", "text", "", "animating", "", "gradientEdgeColor", "modifier", "Landroidx/compose/ui/Modifier;", "shortTextNotAnim", "color", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "MarqueeText-P6GhujE", "(Ljava/lang/String;ZJLandroidx/compose/ui/Modifier;ZJJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;IJIZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void a(String paramString, final boolean paramBoolean1, final long paramLong1, f paramf, final boolean paramBoolean2, final long paramLong2, final long paramLong3, final g paramg, final i parami, final androidx.compose.ui.m.b.d paramd, final long paramLong4, final androidx.compose.ui.m.f.d paramd1, final int paramInt1, final long paramLong5, final int paramInt2, final boolean paramBoolean3, final kotlin.g.a.b<? super androidx.compose.ui.m.q, kotlin.ah> paramb, final androidx.compose.ui.m.u paramu, androidx.compose.runtime.h paramh, int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(240611);
    s.u(paramString, "text");
    androidx.compose.runtime.h localh = paramh.by(-1907422731);
    final int i;
    if ((paramInt5 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label70:
    label77:
    label90:
    label97:
    label110:
    label117:
    label382:
    int m;
    label153:
    label295:
    label2344:
    for (final int j = paramInt3 | i;; m = paramInt3)
    {
      if ((paramInt5 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt5 & 0x4) == 0) {
          break label1584;
        }
        j = 384;
        j = i | j;
        if ((paramInt5 & 0x8) == 0) {
          break label1624;
        }
        i = 3072;
        i = j | i;
        if ((paramInt5 & 0x10) == 0) {
          break label1665;
        }
        j = 24576;
        j = i | j;
        i = j;
        if ((0x70000 & paramInt3) == 0)
        {
          if (((paramInt5 & 0x20) != 0) || (!localh.y(paramLong2))) {
            break label1706;
          }
          i = 131072;
          i = j | i;
        }
        j = i;
        if ((0x380000 & paramInt3) == 0)
        {
          if (((paramInt5 & 0x40) != 0) || (!localh.y(paramLong3))) {
            break label1714;
          }
          j = 1048576;
          label196:
          j = i | j;
        }
        i = j;
        if ((paramInt5 & 0x80) != 0) {
          i = j | 0x400000;
        }
        if ((paramInt5 & 0x100) == 0) {
          break label1722;
        }
        j = 100663296;
        label236:
        j = i | j;
        label243:
        if ((paramInt5 & 0x200) == 0) {
          break label1763;
        }
        i = 805306368;
      }
      for (i = j | i;; i = m)
      {
        if ((paramInt4 & 0xE) == 0) {
          if (((paramInt5 & 0x400) == 0) && (localh.y(paramLong4))) {
            j = 4;
          }
        }
        for (j = paramInt4 | j;; m = paramInt4)
        {
          int n;
          if ((paramInt5 & 0x800) != 0)
          {
            n = 48;
            label315:
            n = j | n;
            label322:
            j = n;
            if ((paramInt5 & 0x1000) != 0) {
              j = n | 0x80;
            }
            n = j;
            if ((paramInt4 & 0x1C00) == 0)
            {
              if (((paramInt5 & 0x2000) != 0) || (!localh.y(paramLong5))) {
                break label1844;
              }
              n = 2048;
              n = j | n;
            }
            j = n;
            if ((paramInt5 & 0x4000) != 0) {
              j = n | 0x2000;
            }
            if ((0x8000 & paramInt5) == 0) {
              break label1852;
            }
            n = 196608;
            label424:
            j |= n;
          }
          for (;;)
          {
            n = j;
            if ((0x380000 & paramInt4) == 0)
            {
              if (((0x10000 & paramInt5) == 0) && (localh.G(paramb)))
              {
                n = 1048576;
                label468:
                n = j | n;
              }
            }
            else
            {
              j = n;
              if ((0x1C00000 & paramInt4) == 0)
              {
                if (((0x20000 & paramInt5) != 0) || (!localh.G(paramu))) {
                  break label1895;
                }
                j = 8388608;
                j = n | j;
              }
              if ((((paramInt5 ^ 0xFFFFFFFF) & 0x5080) == 0) && ((0x5B6DB6DB & i ^ 0x12492492) == 0) && ((0x16DB6DB & j ^ 0x492492) == 0) && (localh.nZ())) {
                break label2292;
              }
              if (((paramInt3 & 0x1) != 0) && (!localh.oa())) {
                break label1902;
              }
              localh.of();
              if ((paramInt5 & 0x8) != 0) {
                paramf = (f)f.aud;
              }
              if ((paramInt5 & 0x10) != 0) {
                paramBoolean2 = false;
              }
              n = i;
              if ((paramInt5 & 0x20) != 0)
              {
                paramh = androidx.compose.ui.e.z.awK;
                paramLong2 = androidx.compose.ui.e.z.sw();
                n = i & 0xFFF8FFFF;
              }
              i = n;
              if ((paramInt5 & 0x40) != 0)
              {
                paramh = o.beS;
                paramLong3 = o.sw();
                i = n & 0xFFC7FFFF;
              }
              if ((paramInt5 & 0x80) != 0) {
                paramg = null;
              }
              if ((paramInt5 & 0x100) != 0) {
                parami = null;
              }
              if ((paramInt5 & 0x200) != 0) {
                paramd = null;
              }
              if ((paramInt5 & 0x400) == 0) {
                break label2324;
              }
              paramh = o.beS;
              paramLong4 = o.sw();
              j &= 0xFFFFFFF1;
            }
            for (;;)
            {
              if ((paramInt5 & 0x800) != 0) {
                paramd1 = null;
              }
              n = j;
              if ((paramInt5 & 0x1000) != 0)
              {
                paramh = androidx.compose.ui.m.f.c.beg;
                paramInt1 = androidx.compose.ui.m.f.c.BP();
                n = j & 0xFFFFFC7F;
              }
              j = n;
              if ((paramInt5 & 0x2000) != 0)
              {
                paramh = o.beS;
                paramLong5 = o.sw();
                j = n & 0xFFFFE3FF;
              }
              n = j;
              if ((paramInt5 & 0x4000) != 0)
              {
                paramh = androidx.compose.ui.m.f.h.beA;
                paramInt2 = androidx.compose.ui.m.f.h.Cd();
                n = j & 0xFFFF1FFF;
              }
              if ((0x8000 & paramInt5) != 0) {
                paramBoolean3 = true;
              }
              j = n;
              if ((0x10000 & paramInt5) != 0)
              {
                paramb = (kotlin.g.a.b)d.b.nYa;
                j = n & 0xFFC7FFFF;
              }
              if ((0x20000 & paramInt5) != 0)
              {
                paramu = (androidx.compose.ui.m.u)localh.a((p)t.nA());
                j &= 0xFE3FFFFF;
              }
              for (;;)
              {
                localh.og();
                final boolean bool = paramBoolean3;
                paramBoolean3 = paramBoolean2;
                paramBoolean2 = bool;
                for (;;)
                {
                  label939:
                  final kotlin.g.a.q localq = (kotlin.g.a.q)androidx.compose.runtime.c.c.a(localh, -819895993, new e(paramString, paramLong2, paramLong3, paramg, parami, paramd, paramLong4, paramd1, paramInt1, paramLong5, paramInt2, paramBoolean2, paramb, paramu, i, j));
                  localh.bx(-3686930);
                  bool = localh.G(paramString);
                  Object localObject1 = localh.or();
                  if (!bool)
                  {
                    paramh = androidx.compose.runtime.h.alD;
                    paramh = (androidx.compose.runtime.h)localObject1;
                    if (localObject1 != h.a.ox()) {}
                  }
                  else
                  {
                    paramh = bj.T(Integer.valueOf(0));
                    localh.F(paramh);
                  }
                  localh.od();
                  final an localan1 = (an)paramh;
                  localh.bx(-3686930);
                  bool = localh.G(paramString);
                  localObject1 = localh.or();
                  if (!bool)
                  {
                    paramh = androidx.compose.runtime.h.alD;
                    paramh = (androidx.compose.runtime.h)localObject1;
                    if (localObject1 != h.a.ox()) {}
                  }
                  else
                  {
                    paramh = bj.T(null);
                    localh.F(paramh);
                  }
                  localh.od();
                  final an localan2 = (an)paramh;
                  Object localObject2 = (h)localan2.getValue();
                  if ((paramBoolean1) && (localObject2 != null))
                  {
                    localh.bx(-1907421132);
                    if ((((h)localObject2).nZc >= ((h)localObject2).nZd) && (((h)localObject2).nZd != 0))
                    {
                      localh.bx(-1907421021);
                      localh.bx(-3686930);
                      bool = localh.G(localObject2);
                      localObject1 = localh.or();
                      if (!bool)
                      {
                        paramh = androidx.compose.runtime.h.alD;
                        paramh = (androidx.compose.runtime.h)localObject1;
                        if (localObject1 != h.a.ox()) {}
                      }
                      else
                      {
                        paramh = Integer.valueOf(((h)localObject2).nZc * 7500 / ((h)localObject2).nZd);
                        localh.F(paramh);
                      }
                      localh.od();
                      n = ((Number)paramh).intValue();
                      paramh = ai.c(localh);
                      j = -((h)localObject2).nZc;
                      localObject1 = ay.a(kotlin.g.b.r.aiwW);
                      localObject2 = androidx.compose.a.a.h.a((androidx.compose.a.a.x)androidx.compose.a.a.h.a(n, androidx.compose.a.a.z.lM(), 2), am.VG);
                      n = androidx.compose.a.a.ah.Ue;
                      n = androidx.compose.a.a.ag.Ue;
                      localan1.setValue(Integer.valueOf(((Number)ai.a(paramh, Integer.valueOf(0), Integer.valueOf(j), (aw)localObject1, (androidx.compose.a.a.ag)localObject2, localh).getValue()).intValue()));
                      localh.od();
                      localh.od();
                    }
                  }
                  for (;;)
                  {
                    localObject2 = androidx.compose.ui.b.d.h(paramf);
                    paramh = androidx.compose.ui.e.z.ad(paramLong1);
                    localh.bx(-3685570);
                    n = 0;
                    int k;
                    for (j = 0; n < 5; k = localh.G(localObject1) | j)
                    {
                      localObject1 = new Object[] { localq, java.lang.Boolean.valueOf(paramBoolean3), localan2, localan1, paramh }[n];
                      n += 1;
                    }
                    if ((paramInt3 & 0xE) != 0) {
                      break label2344;
                    }
                    if (localh.G(paramString))
                    {
                      i = 4;
                      break;
                    }
                    i = 2;
                    break;
                    i = k;
                    if ((paramInt3 & 0x70) != 0) {
                      break label58;
                    }
                    if (localh.am(paramBoolean1))
                    {
                      i = 32;
                      break label51;
                    }
                    i = 16;
                    break label51;
                    label1584:
                    m = i;
                    if ((paramInt3 & 0x380) != 0) {
                      break label77;
                    }
                    if (localh.y(paramLong1))
                    {
                      m = 256;
                      break label70;
                    }
                    m = 128;
                    break label70;
                    label1624:
                    i = m;
                    if ((paramInt3 & 0x1C00) != 0) {
                      break label97;
                    }
                    if (localh.G(paramf))
                    {
                      i = 2048;
                      break label90;
                    }
                    i = 1024;
                    break label90;
                    m = i;
                    if ((0xE000 & paramInt3) != 0) {
                      break label117;
                    }
                    if (localh.am(paramBoolean2))
                    {
                      m = 16384;
                      break label110;
                    }
                    m = 8192;
                    break label110;
                    label1706:
                    i = 65536;
                    break label153;
                    label1714:
                    m = 524288;
                    break label196;
                    label1722:
                    m = i;
                    if ((0xE000000 & paramInt3) != 0) {
                      break label243;
                    }
                    if (localh.G(parami))
                    {
                      m = 67108864;
                      break label236;
                    }
                    m = 33554432;
                    break label236;
                    label1763:
                    if ((0x70000000 & paramInt3) != 0) {
                      break label2337;
                    }
                    if (localh.G(paramd))
                    {
                      i = 536870912;
                      break label256;
                    }
                    i = 268435456;
                    break label256;
                    m = 2;
                    break label295;
                    n = m;
                    if ((paramInt4 & 0x70) != 0) {
                      break label322;
                    }
                    if (localh.G(paramd1))
                    {
                      n = 32;
                      break label315;
                    }
                    n = 16;
                    break label315;
                    label1844:
                    n = 1024;
                    break label382;
                    label1852:
                    if ((0x70000 & paramInt4) != 0) {
                      break label2327;
                    }
                    if (localh.am(paramBoolean3))
                    {
                      n = 131072;
                      break label424;
                    }
                    n = 65536;
                    break label424;
                    n = 524288;
                    break label468;
                    label1895:
                    m = 4194304;
                    break label513;
                    label1902:
                    localh.oj();
                    n = i;
                    if ((paramInt5 & 0x20) != 0) {
                      n = i & 0xFFF8FFFF;
                    }
                    i = n;
                    if ((paramInt5 & 0x40) != 0) {
                      i = n & 0xFFC7FFFF;
                    }
                    n = m;
                    if ((paramInt5 & 0x400) != 0) {
                      n = m & 0xFFFFFFF1;
                    }
                    m = n;
                    if ((paramInt5 & 0x1000) != 0) {
                      m = n & 0xFFFFFC7F;
                    }
                    n = m;
                    if ((paramInt5 & 0x2000) != 0) {
                      n = m & 0xFFFFE3FF;
                    }
                    int i1 = n;
                    if ((paramInt5 & 0x4000) != 0) {
                      i1 = n & 0xFFFF1FFF;
                    }
                    m = i1;
                    if ((0x10000 & paramInt5) != 0) {
                      m = i1 & 0xFFC7FFFF;
                    }
                    if ((0x20000 & paramInt5) == 0) {
                      break label2306;
                    }
                    m &= 0xFE3FFFFF;
                    bool = paramBoolean2;
                    paramBoolean2 = paramBoolean3;
                    paramBoolean3 = bool;
                    break label939;
                    localh.bx(-1907420270);
                    localh.od();
                    break label1414;
                    localh.bx(-1907420264);
                    localh.od();
                  }
                  localObject1 = localh.or();
                  if (m == 0)
                  {
                    paramh = androidx.compose.runtime.h.alD;
                    paramh = (androidx.compose.runtime.h)localObject1;
                    if (localObject1 != h.a.ox()) {}
                  }
                  else
                  {
                    paramh = (m)new c(paramBoolean3, localan2, localq, localan1, paramLong1, i);
                    localh.F(paramh);
                  }
                  localh.od();
                  ae.a((f)localObject2, (m)paramh, localh, 0, 0);
                  bool = paramBoolean3;
                  paramBoolean3 = paramBoolean2;
                  for (;;)
                  {
                    paramh = localh.oh();
                    if (paramh != null) {
                      paramh.b((m)new d(paramString, paramBoolean1, paramLong1, paramf, bool, paramLong2, paramLong3, paramg, parami, paramd, paramLong4, paramd1, paramInt1, paramLong5, paramInt2, paramBoolean3, paramb, paramu, paramInt3, paramInt4, paramInt5));
                    }
                    AppMethodBeat.o(240611);
                    return;
                    label2292:
                    localh.oi();
                    bool = paramBoolean2;
                  }
                  bool = paramBoolean2;
                  paramBoolean2 = paramBoolean3;
                  paramBoolean3 = bool;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, kotlin.ah>
  {
    a(long paramLong1, long paramLong2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<androidx.compose.ui.h.ag, androidx.compose.ui.n.b, androidx.compose.ui.h.q>
  {
    c(boolean paramBoolean, an<h> paraman, kotlin.g.a.q<? super f, ? super androidx.compose.runtime.h, ? super Integer, kotlin.ah> paramq, an<Integer> paraman1, long paramLong, int paramInt)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements m<androidx.compose.runtime.h, Integer, kotlin.ah>
    {
      a(kotlin.g.a.q<? super f, ? super androidx.compose.runtime.h, ? super Integer, kotlin.ah> paramq)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements m<androidx.compose.runtime.h, Integer, kotlin.ah>
  {
    d(String paramString, boolean paramBoolean1, long paramLong1, f paramf, boolean paramBoolean2, long paramLong2, long paramLong3, g paramg, i parami, androidx.compose.ui.m.b.d paramd, long paramLong4, androidx.compose.ui.m.f.d paramd1, int paramInt1, long paramLong5, int paramInt2, boolean paramBoolean3, kotlin.g.a.b<? super androidx.compose.ui.m.q, kotlin.ah> paramb, androidx.compose.ui.m.u paramu, int paramInt3, int paramInt4, int paramInt5)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.q<f, androidx.compose.runtime.h, Integer, kotlin.ah>
  {
    e(String paramString, long paramLong1, long paramLong2, g paramg, i parami, androidx.compose.ui.m.b.d paramd, long paramLong3, androidx.compose.ui.m.f.d paramd1, int paramInt1, long paramLong4, int paramInt2, boolean paramBoolean, kotlin.g.a.b<? super androidx.compose.ui.m.q, kotlin.ah> paramb, androidx.compose.ui.m.u paramu, int paramInt3, int paramInt4)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.d
 * JD-Core Version:    0.7.0.1
 */