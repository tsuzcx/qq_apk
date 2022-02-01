package com.tencent.mm.mj_template.album_template.single_template;

import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.ae;
import androidx.compose.foundation.c.e;
import androidx.compose.foundation.c.g.a;
import androidx.compose.foundation.c.r;
import androidx.compose.foundation.c.y;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.n.n;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b.c.b;
import com.tencent.mm.mj_template.plugin.c.f;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "Header", "", "onNextClick", "Lkotlin/Function0;", "Lcom/tencent/mm/mj_template/album_template/single_template/OnClick;", "onBackClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MusicSelector", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "(Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/Composer;I)V", "PreviewPage", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/Composer;I)V", "OnClick", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  static final void a(final com.tencent.mm.mj_template.album_template.a.g paramg, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240549);
    androidx.compose.runtime.h localh = paramh.by(-1996314020);
    final int i;
    if ((paramInt & 0xE) == 0) {
      if (localh.G(paramg))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      label255:
      boolean bool;
      if (((i & 0xB ^ 0x2) != 0) || (!localh.nZ()))
      {
        localh.bx(-3687241);
        Object localObject1 = localh.or();
        paramh = androidx.compose.runtime.h.alD;
        paramh = (androidx.compose.runtime.h)localObject1;
        if (localObject1 == h.a.ox())
        {
          paramh = bj.T(Boolean.FALSE);
          localh.F(paramh);
        }
        localh.od();
        paramh = (an)paramh;
        localh.bx(-1990474327);
        Object localObject4 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        localObject1 = androidx.compose.ui.a.atD;
        Object localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, localh);
        localh.bx(1376089335);
        Object localObject2 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
        Object localObject5 = androidx.compose.ui.i.a.aNC;
        localObject5 = androidx.compose.ui.i.a.a.xb();
        localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
        if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        localh.ol();
        if (localh.nY())
        {
          localh.a((kotlin.g.a.a)localObject5);
          localh.op();
          s.u(localh, "composer");
          localObject5 = androidx.compose.ui.i.a.aNC;
          br.a(localh, localObject3, androidx.compose.ui.i.a.a.xe());
          localObject3 = androidx.compose.ui.i.a.aNC;
          br.a(localh, localObject2, androidx.compose.ui.i.a.a.xd());
          localObject2 = androidx.compose.ui.i.a.aNC;
          br.a(localh, localObject1, androidx.compose.ui.i.a.a.xf());
          localh.oq();
          s.u(localh, "composer");
          ((q)localObject4).invoke(bc.p(localh), localh, Integer.valueOf(0));
          localh.bx(2058660585);
          localh.bx(-1253629305);
          localObject1 = (androidx.compose.foundation.c.d)e.acr;
          localObject2 = paramg.nYW;
          if (b(paramh)) {
            break label612;
          }
          bool = true;
          label389:
          localObject3 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
          localObject4 = androidx.compose.ui.a.atD;
          androidx.compose.a.b.a(bool, ((androidx.compose.foundation.c.d)localObject1).a((androidx.compose.ui.f)localObject3, androidx.compose.ui.a.a.rZ()), null, null, (q)androidx.compose.runtime.c.c.a(localh, -819892857, new b(paramh, (bm)localObject2)), localh, 24576, 12);
          androidx.compose.a.b.a(b(paramh), null, androidx.compose.a.j.a((kotlin.g.a.b)a.c.nXF, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6)), androidx.compose.a.j.b((kotlin.g.a.b)a.d.nXG, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6)), (q)androidx.compose.runtime.c.c.a(localh, -819893337, new e(paramh, paramg, i)), localh, 24576, 2);
          localh.od();
          localh.od();
          localh.on();
          localh.od();
          localh.od();
        }
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new f(paramg, paramInt));
        }
        AppMethodBeat.o(240549);
        return;
        i = 2;
        break;
        localh.om();
        break label255;
        label612:
        bool = false;
        break label389;
        localh.oi();
      }
      i = paramInt;
    }
  }
  
  public static final void a(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2, final com.tencent.mm.mj_template.album_template.a.g paramg, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240520);
    s.u(parama1, "onNextClick");
    s.u(parama2, "onBackClick");
    s.u(paramg, "musicState");
    paramh = paramh.by(-1340019553);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(parama1)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(parama2))
        {
          j = 32;
          label91:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label557;
        }
        if (!paramh.G(paramg)) {
          break label531;
        }
        i = 256;
        label122:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ()))
        {
          Object localObject1 = androidx.compose.ui.a.atD;
          localObject1 = androidx.compose.ui.a.a.se();
          Object localObject3 = ab.e((androidx.compose.ui.f)androidx.compose.ui.f.aud);
          paramh.bx(-1113031299);
          Object localObject2 = androidx.compose.foundation.c.a.abN;
          Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (androidx.compose.ui.a.b)localObject1, paramh);
          paramh.bx(1376089335);
          localObject2 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
          localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject5 = androidx.compose.ui.i.a.aNC;
          localObject5 = androidx.compose.ui.i.a.a.xb();
          localObject3 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject3);
          if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          paramh.ol();
          if (paramh.nY())
          {
            paramh.a((kotlin.g.a.a)localObject5);
            label294:
            paramh.op();
            s.u(paramh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
            localObject2 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((q)localObject3).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(276693241);
            localObject1 = (androidx.compose.foundation.c.g)androidx.compose.foundation.c.h.acw;
            b(parama1, parama2, paramh, i & 0xE | i & 0x70);
            ae.b(g.a.a((androidx.compose.foundation.c.g)localObject1, (androidx.compose.ui.f)androidx.compose.ui.f.aud, 1.0F), paramh, 0);
            a(paramg, paramh, i >> 6 & 0xE);
            paramh.od();
            paramh.od();
            paramh.on();
            paramh.od();
            paramh.od();
          }
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new g(parama1, parama2, paramg, paramInt));
          }
          AppMethodBeat.o(240520);
          return;
          i = 2;
          break;
          j = 16;
          break label91;
          label531:
          i = 128;
          break label122;
          paramh.om();
          break label294;
          paramh.oi();
        }
        label557:
        i = j;
      }
    }
  }
  
  static final void b(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240538);
    paramh = paramh.by(-1541404569);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(parama1)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (paramh.G(parama2))
        {
          j = 32;
          label63:
          i = j | i;
        }
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!paramh.nZ()))
        {
          Object localObject1 = androidx.compose.ui.a.atD;
          localObject1 = androidx.compose.ui.a.a.sc();
          Object localObject3 = r.b(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), androidx.compose.ui.n.g.ai(16.0F));
          paramh.bx(-1989997546);
          Object localObject2 = androidx.compose.foundation.c.a.abN;
          Object localObject4 = y.a(androidx.compose.foundation.c.a.mt(), (androidx.compose.ui.a.c)localObject1, paramh);
          paramh.bx(1376089335);
          localObject2 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
          localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject5 = androidx.compose.ui.i.a.aNC;
          localObject5 = androidx.compose.ui.i.a.a.xb();
          localObject3 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject3);
          if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          paramh.ol();
          if (paramh.nY())
          {
            paramh.a((kotlin.g.a.a)localObject5);
            label242:
            paramh.op();
            s.u(paramh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
            localObject2 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((q)localObject3).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(-326682743);
            localObject1 = (androidx.compose.foundation.c.z)androidx.compose.foundation.c.aa.adE;
            j = c.f.icons_filled_back;
            localObject2 = androidx.compose.ui.e.z.awK;
            androidx.compose.foundation.j.a(com.tencent.mm.aj.a.a(j, androidx.compose.ui.e.z.tw(), paramh), "close_icon", androidx.compose.foundation.g.a(ab.b(r.c((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(8.0F)), androidx.compose.ui.n.g.ai(12.0F), androidx.compose.ui.n.g.ai(24.0F)), false, parama2, 7), null, null, 0.0F, null, paramh, 56, 120);
            ae.b(((androidx.compose.foundation.c.z)localObject1).b((androidx.compose.ui.f)androidx.compose.ui.f.aud), paramh, 0);
            localObject1 = (com.tencent.mm.aj.b.c)c.b.ogz;
            localObject2 = MMApplicationContext.getString(c.g.app_nextstep);
            s.s(localObject2, "app_nextstep.str");
            com.tencent.mm.aj.b.a.a(parama1, null, (com.tencent.mm.aj.b.c)localObject1, null, false, (String)localObject2, null, paramh, i & 0xE | 0x200, 90);
            paramh.od();
            paramh.od();
            paramh.on();
            paramh.od();
            paramh.od();
          }
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new a(parama1, parama2, paramInt));
          }
          AppMethodBeat.o(240538);
          return;
          i = 2;
          break;
          j = 16;
          break label63;
          paramh.om();
          break label242;
          paramh.oi();
        }
      }
    }
  }
  
  private static final boolean b(an<Boolean> paraman)
  {
    AppMethodBeat.i(240555);
    boolean bool = ((Boolean)((bm)paraman).getValue()).booleanValue();
    AppMethodBeat.o(240555);
    return bool;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    b(an<Boolean> paraman, bm<? extends MJMusicInfo> parambm)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(an<Boolean> paraman)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    e(an<Boolean> paraman, com.tencent.mm.mj_template.album_template.a.g paramg, int paramInt)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(an<Boolean> paraman)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    f(com.tencent.mm.mj_template.album_template.a.g paramg, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    g(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, com.tencent.mm.mj_template.album_template.a.g paramg, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.single_template.a
 * JD-Core Version:    0.7.0.1
 */