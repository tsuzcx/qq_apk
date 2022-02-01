package com.tencent.mm.aj.b;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.a.a.ag;
import androidx.compose.a.a.ai;
import androidx.compose.a.a.x;
import androidx.compose.a.a.z;
import androidx.compose.foundation.c.ab;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"MMLoading", "", "modifier", "Landroidx/compose/ui/Modifier;", "size", "Lcom/tencent/mm/mm_compose/weui/MMLoadingSize;", "color", "Lcom/tencent/mm/mm_compose/weui/MMLoadingColor;", "(Landroidx/compose/ui/Modifier;Lcom/tencent/mm/mm_compose/weui/MMLoadingSize;Lcom/tencent/mm/mm_compose/weui/MMLoadingColor;Landroidx/compose/runtime/Composer;II)V", "compose-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final void a(androidx.compose.ui.f paramf, final f paramf1, final e parame, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(238685);
    androidx.compose.runtime.h localh = paramh.by(2044101605);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label44:
    label51:
    label63:
    label70:
    label209:
    label738:
    label741:
    label751:
    label761:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label698;
        }
        j = 384;
        j = i | j;
        if (((j & 0x2DB ^ 0x92) == 0) && (localh.nZ())) {
          break label751;
        }
        if ((paramInt2 & 0x1) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if ((paramInt2 & 0x2) != 0) {
          paramf1 = f.ogN;
        }
        if ((paramInt2 & 0x4) != 0) {
          parame = e.ogI;
        }
        Object localObject1 = (Context)localh.a((p)androidx.compose.ui.platform.j.yJ());
        localh.bx(-3687241);
        paramh = localh.or();
        Object localObject2 = androidx.compose.runtime.h.alD;
        if (paramh != h.a.ox()) {
          break label738;
        }
        paramh = ((Context)localObject1).getResources().getDrawable(paramf1.a(parame));
        s.s(paramh, "context.resources.getDrawable(size.getRes(color))");
        paramh = com.tencent.mm.aj.a.c.C(paramh);
        localh.F(paramh);
        localh.od();
        paramh = (androidx.compose.ui.e.c.c)paramh;
        localObject1 = ai.c(localh);
        localObject2 = androidx.compose.a.a.h.a((x)androidx.compose.a.a.h.a(1000, z.lM(), 2));
        i = androidx.compose.a.a.ah.Ue;
        i = ag.Ue;
        localObject1 = ai.a((androidx.compose.a.a.ah)localObject1, (ag)localObject2, localh);
        Object localObject5 = ab.f(paramf, paramf1.value);
        localh.bx(-1990474327);
        localObject2 = androidx.compose.ui.a.atD;
        Object localObject4 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, localh);
        localh.bx(1376089335);
        Object localObject3 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
        localObject2 = (androidx.compose.ui.n.n)localh.a((p)androidx.compose.ui.platform.u.yW());
        Object localObject6 = androidx.compose.ui.i.a.aNC;
        localObject6 = androidx.compose.ui.i.a.a.xb();
        localObject5 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject5);
        if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
          g.nW();
        }
        localh.ol();
        if (!localh.nY()) {
          break label741;
        }
        localh.a((kotlin.g.a.a)localObject6);
        localh.op();
        s.u(localh, "composer");
        localObject6 = androidx.compose.ui.i.a.aNC;
        br.a(localh, localObject4, androidx.compose.ui.i.a.a.xe());
        localObject4 = androidx.compose.ui.i.a.aNC;
        br.a(localh, localObject3, androidx.compose.ui.i.a.a.xd());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(localh, localObject2, androidx.compose.ui.i.a.a.xf());
        localh.oq();
        s.u(localh, "composer");
        ((q)localObject5).invoke(bc.p(localh), localh, Integer.valueOf(0));
        localh.bx(2058660585);
        localh.bx(-1253629305);
        localObject2 = androidx.compose.foundation.c.e.acr;
        androidx.compose.foundation.j.a(paramh, "loading", androidx.compose.ui.b.n.i((androidx.compose.ui.f)androidx.compose.ui.f.aud, g((bm)localObject1)), null, null, 0.0F, null, localh, 56, 120);
        localh.od();
        localh.od();
        localh.on();
        localh.od();
        localh.od();
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramf, paramf1, parame, paramInt1, paramInt2));
        }
        AppMethodBeat.o(238685);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label761;
        }
        if (localh.G(paramf))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = j;
        if ((paramInt1 & 0x70) != 0) {
          break label51;
        }
        if (localh.G(paramf1))
        {
          i = 32;
          break label44;
        }
        i = 16;
        break label44;
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label70;
        }
        if (localh.G(parame))
        {
          j = 256;
          break label63;
        }
        j = 128;
        break label63;
        break label209;
        localh.om();
        break label406;
        localh.oi();
      }
    }
  }
  
  private static final float g(bm<Float> parambm)
  {
    AppMethodBeat.i(238690);
    float f = ((Number)parambm.getValue()).floatValue();
    AppMethodBeat.o(238690);
    return f;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, kotlin.ah>
  {
    a(androidx.compose.ui.f paramf, f paramf1, e parame, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.b.b
 * JD-Core Version:    0.7.0.1
 */