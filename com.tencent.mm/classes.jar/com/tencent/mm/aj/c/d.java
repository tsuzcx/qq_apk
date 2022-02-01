package com.tencent.mm.aj.c;

import androidx.compose.a.a.z;
import androidx.compose.runtime.ba;
import androidx.compose.ui.f;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRowWithOutMinWidth", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Lcom/tencent/mm/mm_compose/widget/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRowWithOutMinWidth-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "fastForEach", "T", "action", "fastMap", "R", "transform", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final float ogZ;
  private static final androidx.compose.a.a.g<Float> oha;
  
  static
  {
    AppMethodBeat.i(238798);
    ogZ = androidx.compose.ui.n.g.ai(90.0F);
    oha = (androidx.compose.a.a.g)androidx.compose.a.a.h.a(250, z.lL(), 2);
    AppMethodBeat.o(238798);
  }
  
  public static final void a(final int paramInt1, final f paramf, final long paramLong1, long paramLong2, final float paramFloat, final kotlin.g.a.q<? super List<c>, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2, androidx.compose.runtime.h paramh, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(238779);
    kotlin.g.b.s.u(paramm2, "tabs");
    androidx.compose.runtime.h localh = paramh.by(-1393222825);
    if ((paramInt3 & 0x1) != 0) {
      i = 6;
    }
    label140:
    label270:
    label290:
    label934:
    label941:
    label944:
    for (final int i = paramInt2 | i;; i = paramInt2)
    {
      int j;
      if ((paramInt3 & 0x2) != 0)
      {
        j = 48;
        label52:
        j = i | j;
        label59:
        i = j;
        if ((paramInt2 & 0x380) == 0)
        {
          if (((paramInt3 & 0x4) != 0) || (!localh.y(paramLong1))) {
            break label723;
          }
          i = 256;
          label95:
          i = j | i;
        }
        j = i;
        if ((paramInt2 & 0x1C00) == 0)
        {
          if (((paramInt3 & 0x8) != 0) || (!localh.y(paramLong2))) {
            break label731;
          }
          j = 2048;
          j = i | j;
        }
        i = j;
        if ((0xE000 & paramInt2) == 0)
        {
          if (((paramInt3 & 0x10) != 0) || (!localh.H(paramFloat))) {
            break label739;
          }
          i = 16384;
          label184:
          i = j | i;
        }
        j = i;
        if ((0x70000 & paramInt2) == 0)
        {
          if (((paramInt3 & 0x20) != 0) || (!localh.G(paramq))) {
            break label747;
          }
          j = 131072;
          label227:
          j = i | j;
        }
        i = j;
        if ((0x380000 & paramInt2) == 0)
        {
          if (((paramInt3 & 0x40) != 0) || (!localh.G(paramm1))) {
            break label754;
          }
          i = 1048576;
          i = j | i;
        }
        if ((paramInt3 & 0x80) == 0) {
          break label761;
        }
        j = 12582912;
        i |= j;
      }
      for (;;)
      {
        if (((0x16DB6DB & i ^ 0x492492) != 0) || (!localh.nZ())) {
          if (((paramInt2 & 0x1) == 0) || (localh.oa()))
          {
            localh.of();
            if ((paramInt3 & 0x2) != 0) {
              paramf = (f)f.aud;
            }
            if ((paramInt3 & 0x4) == 0) {
              break label934;
            }
            paramh = androidx.compose.b.m.aiH;
            paramLong1 = androidx.compose.b.b.a(androidx.compose.b.m.j(localh));
          }
        }
        for (j = i & 0xFFFFFC7F;; j = i)
        {
          i = j;
          if ((paramInt3 & 0x8) != 0)
          {
            paramLong2 = androidx.compose.b.b.a(paramLong1, localh);
            i = j & 0xFFFFE3FF;
          }
          j = i;
          if ((paramInt3 & 0x10) != 0)
          {
            paramh = androidx.compose.b.s.ajk;
            paramFloat = androidx.compose.b.s.nz();
            j = i & 0xFFFF1FFF;
          }
          i = j;
          if ((paramInt3 & 0x20) != 0)
          {
            paramq = a.ogR;
            paramq = a.byU();
            i = j & 0xFFF8FFFF;
          }
          j = i;
          if ((paramInt3 & 0x40) != 0)
          {
            paramm1 = a.ogR;
            paramm1 = a.byV();
            j = i & 0xFFC7FFFF;
          }
          localh.og();
          i = j;
          paramh = paramm1;
          paramm1 = paramq;
          paramq = paramh;
          for (;;)
          {
            androidx.compose.b.q.a(paramf, null, paramLong1, paramLong2, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819890829, new a(paramFloat, paramm2, paramq, paramInt1, paramm1, i)), localh, 0x180000 | i >> 3 & 0xE | i & 0x380 | i & 0x1C00, 50);
            paramh = paramm1;
            paramm1 = paramq;
            paramq = paramh;
            for (;;)
            {
              paramh = localh.oh();
              if (paramh != null) {
                paramh.b((kotlin.g.a.m)new b(paramInt1, paramf, paramLong1, paramLong2, paramFloat, paramq, paramm1, paramm2, paramInt2, paramInt3));
              }
              AppMethodBeat.o(238779);
              return;
              if ((paramInt2 & 0xE) != 0) {
                break label944;
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
              label723:
              i = 128;
              break label95;
              label731:
              j = 1024;
              break label140;
              label739:
              i = 8192;
              break label184;
              label747:
              j = 65536;
              break label227;
              label754:
              i = 524288;
              break label270;
              label761:
              if ((0x1C00000 & paramInt2) != 0) {
                break label941;
              }
              if (localh.G(paramm2))
              {
                j = 8388608;
                break label290;
              }
              j = 4194304;
              break label290;
              localh.oj();
              j = i;
              if ((paramInt3 & 0x4) != 0) {
                j = i & 0xFFFFFC7F;
              }
              i = j;
              if ((paramInt3 & 0x8) != 0) {
                i = j & 0xFFFFE3FF;
              }
              j = i;
              if ((paramInt3 & 0x10) != 0) {
                j = i & 0xFFFF1FFF;
              }
              i = j;
              if ((paramInt3 & 0x20) != 0) {
                i = j & 0xFFF8FFFF;
              }
              if ((paramInt3 & 0x40) == 0) {
                break label919;
              }
              i &= 0xFFC7FFFF;
              paramh = paramq;
              paramq = paramm1;
              paramm1 = paramh;
              break label523;
              localh.oi();
            }
            paramh = paramq;
            paramq = paramm1;
            paramm1 = paramh;
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
    a(float paramFloat, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2, int paramInt1, kotlin.g.a.q<? super List<c>, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(int paramInt1, f paramf, long paramLong1, long paramLong2, float paramFloat, kotlin.g.a.q<? super List<c>, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.d
 * JD-Core Version:    0.7.0.1
 */