package com.tencent.mm.aj.b;

import androidx.compose.b.q;
import androidx.compose.foundation.c.ab;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"MMButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Lcom/tencent/mm/mm_compose/weui/MMButtonColor;", "size", "Lcom/tencent/mm/mm_compose/weui/MMButtonSize;", "enable", "", "text", "", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lcom/tencent/mm/mm_compose/weui/MMButtonColor;Lcom/tencent/mm/mm_compose/weui/MMButtonSize;ZLjava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(kotlin.g.a.a<ah> parama, final f paramf, final c paramc, final d paramd, final boolean paramBoolean, final String paramString, final m<? super h, ? super Integer, ah> paramm, final h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(238704);
    s.u(parama, "onClick");
    h localh = paramh.by(1633211834);
    final int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label70:
    label77:
    label846:
    label849:
    label852:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label539;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label579;
        }
        i = 3072;
        label90:
        i = j | i;
        label97:
        if ((paramInt2 & 0x10) == 0) {
          break label619;
        }
        j = 24576;
        label110:
        j = i | j;
        label117:
        if ((paramInt2 & 0x20) == 0) {
          break label659;
        }
        i = 196608;
        i = j | i;
        if ((paramInt2 & 0x40) == 0) {
          break label697;
        }
        j = 1572864;
        i |= j;
      }
      for (;;)
      {
        if (((0x2DB6DB & i ^ 0x92492) != 0) || (!localh.nZ()))
        {
          if ((paramInt2 & 0x2) != 0) {
            paramf = (f)f.aud;
          }
          if ((paramInt2 & 0x4) == 0) {
            break label846;
          }
          paramc = (c)c.a.ogy;
        }
        for (;;)
        {
          if ((paramInt2 & 0x8) != 0) {}
          for (paramh = (d)d.b.ogG;; paramh = paramd)
          {
            if ((paramInt2 & 0x10) != 0) {
              paramBoolean = true;
            }
            for (;;)
            {
              if ((paramInt2 & 0x20) != 0) {}
              for (paramd = "";; paramd = paramString)
              {
                if ((paramInt2 & 0x40) != 0) {}
                for (paramString = null;; paramString = paramm)
                {
                  long l;
                  if ((paramh instanceof d.a))
                  {
                    paramm = ab.c(paramf);
                    j = paramh.ogB;
                    j = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), j);
                    paramm = ab.g(paramm, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), j)));
                    if (!paramBoolean) {
                      break label802;
                    }
                    l = paramc.ayn;
                    j = paramh.ogC;
                    j = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), j);
                    q.a(parama, paramm, (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), j))), l, 0L, null, 0.0F, null, null, paramBoolean, null, null, (m)androidx.compose.runtime.c.c.a(localh, -819894010, new a(paramString, i, paramBoolean, paramc, paramh, paramd)), localh, i & 0xE | i << 15 & 0x70000000, 384, 3568);
                    paramm = paramString;
                    paramString = paramd;
                  }
                  for (;;)
                  {
                    paramd = localh.oh();
                    if (paramd != null) {
                      paramd.b((m)new b(parama, paramf, paramc, paramh, paramBoolean, paramString, paramm, paramInt1, paramInt2));
                    }
                    AppMethodBeat.o(238704);
                    return;
                    if ((paramInt1 & 0xE) != 0) {
                      break label852;
                    }
                    if (localh.G(parama))
                    {
                      i = 4;
                      break;
                    }
                    i = 2;
                    break;
                    i = j;
                    if ((paramInt1 & 0x70) != 0) {
                      break label58;
                    }
                    if (localh.G(paramf))
                    {
                      i = 32;
                      break label51;
                    }
                    i = 16;
                    break label51;
                    j = i;
                    if ((paramInt1 & 0x380) != 0) {
                      break label77;
                    }
                    if (localh.G(paramc))
                    {
                      j = 256;
                      break label70;
                    }
                    j = 128;
                    break label70;
                    i = j;
                    if ((paramInt1 & 0x1C00) != 0) {
                      break label97;
                    }
                    if (localh.G(paramd))
                    {
                      i = 2048;
                      break label90;
                    }
                    i = 1024;
                    break label90;
                    label619:
                    j = i;
                    if ((0xE000 & paramInt1) != 0) {
                      break label117;
                    }
                    if (localh.am(paramBoolean))
                    {
                      j = 16384;
                      break label110;
                    }
                    j = 8192;
                    break label110;
                    i = j;
                    if ((0x70000 & paramInt1) != 0) {
                      break label136;
                    }
                    if (localh.G(paramString))
                    {
                      i = 131072;
                      break label129;
                    }
                    i = 65536;
                    break label129;
                    if ((0x380000 & paramInt1) != 0) {
                      break label849;
                    }
                    if (localh.G(paramm))
                    {
                      j = 1048576;
                      break label148;
                    }
                    j = 524288;
                    break label148;
                    j = paramh.ogA;
                    j = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), j);
                    float f = androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), j));
                    j = paramh.ogB;
                    j = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), j);
                    paramm = ab.c(paramf, f, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), j)));
                    break label303;
                    l = paramc.ogw;
                    break label314;
                    localh.oi();
                    paramh = paramd;
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
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    a(m<? super h, ? super Integer, ah> paramm, int paramInt, boolean paramBoolean, c paramc, d paramd, String paramString)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(kotlin.g.a.a<ah> parama, f paramf, c paramc, d paramd, boolean paramBoolean, String paramString, m<? super h, ? super Integer, ah> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.a
 * JD-Core Version:    0.7.0.1
 */