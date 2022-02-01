package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.b.t;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.y;
import androidx.compose.foundation.j;
import androidx.compose.foundation.lazy.w;
import androidx.compose.runtime.an;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.ae;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.n.n;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c.a.i;
import com.tencent.mm.mj_template.plugin.c.f;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"MusicSelectorThemeProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;", "CheckBoxWithText", "", "text", "", "checkedState", "Landroidx/compose/runtime/State;", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CheckButton", "selected", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MusicCardItem", "cardWidthDp", "Landroidx/compose/ui/unit/Dp;", "mjMusicInfo", "Lcom/tencent/maas/model/MJMusicInfo;", "lyricInfoGetter", "", "Lcom/tencent/maas/model/MJLyricInfo;", "animating", "MusicCardItem-Kz89ssw", "(FLcom/tencent/maas/model/MJMusicInfo;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "MusicCardList", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "stateSelectedMusicId", "onMusicSelected", "Lkotlin/Function1;", "(Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MusicChecker", "onMusicClick", "originState", "onOriginClick", "(Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MusicSelectorExpand", "musicSelectorTheme", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;Landroidx/compose/runtime/Composer;I)V", "MusicSelectorExpandImpl", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/Composer;I)V", "MusicSelectorFold", "(Lcom/tencent/maas/model/MJMusicInfo;Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MusicSelectorFoldImpl", "(Lcom/tencent/maas/model/MJMusicInfo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final as<f> nYm;
  
  static
  {
    AppMethodBeat.i(240798);
    nYm = androidx.compose.runtime.q.e((kotlin.g.a.a)t.nYI);
    AppMethodBeat.o(240798);
  }
  
  public static final void a(bm<Boolean> parambm1, final kotlin.g.a.a<ah> parama1, final bm<Boolean> parambm2, final kotlin.g.a.a<ah> parama2, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240648);
    s.u(parambm1, "musicState");
    s.u(parama1, "onMusicClick");
    s.u(parambm2, "originState");
    s.u(parama2, "onOriginClick");
    paramh = paramh.by(1256644079);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(parambm1)) {
        i = 4;
      }
    }
    for (int j = paramInt | i;; j = paramInt)
    {
      i = j;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(parama1))
        {
          i = 32;
          label102:
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt & 0x380) == 0)
        {
          if (!paramh.G(parambm2)) {
            break label680;
          }
          j = 256;
          label138:
          j = i | j;
        }
        if ((paramInt & 0x1C00) != 0) {
          break label716;
        }
        if (!paramh.G(parama2)) {
          break label688;
        }
        i = 2048;
        label170:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x16DB ^ 0x492) != 0) || (!paramh.nZ()))
        {
          Object localObject1 = androidx.compose.foundation.c.a.abN;
          localObject1 = androidx.compose.foundation.c.a.mz();
          Object localObject2 = androidx.compose.foundation.c.r.a(androidx.compose.foundation.c.ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), ((f)paramh.a((p)nYm)).nYR, androidx.compose.ui.n.g.ai(16.0F));
          paramh.bx(-1989997546);
          Object localObject3 = androidx.compose.ui.a.atD;
          localObject3 = androidx.compose.ui.a.a.sb();
          Object localObject4 = y.a((a.d)localObject1, (a.c)localObject3, paramh);
          paramh.bx(1376089335);
          localObject3 = (androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU());
          localObject1 = (n)paramh.a((p)androidx.compose.ui.platform.u.yW());
          Object localObject5 = androidx.compose.ui.i.a.aNC;
          localObject5 = androidx.compose.ui.i.a.a.xb();
          localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
          if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          paramh.ol();
          if (paramh.nY())
          {
            paramh.a((kotlin.g.a.a)localObject5);
            label387:
            paramh.op();
            s.u(paramh, "composer");
            localObject5 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((kotlin.g.a.q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(-326682743);
            localObject1 = androidx.compose.foundation.c.aa.adE;
            localObject1 = MMApplicationContext.getString(c.g.odv);
            s.s(localObject1, "mj_template_template_music.str");
            a((String)localObject1, parambm1, parama1, paramh, i << 3 & 0x70 | i << 3 & 0x380);
            localObject1 = MMApplicationContext.getString(c.g.odq);
            s.s(localObject1, "mj_template_origin_music.str");
            a((String)localObject1, parambm2, parama2, paramh, i >> 3 & 0x70 | i >> 3 & 0x380);
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
            paramh.b((kotlin.g.a.m)new i(parambm1, parama1, parambm2, parama2, paramInt));
          }
          AppMethodBeat.o(240648);
          return;
          i = 2;
          break;
          i = 16;
          break label102;
          label680:
          j = 128;
          break label138;
          label688:
          i = 1024;
          break label170;
          paramh.om();
          break label387;
          paramh.oi();
        }
        label716:
        i = j;
      }
    }
  }
  
  public static final void a(MJMusicInfo paramMJMusicInfo, final f paramf, final kotlin.g.a.a<ah> parama, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240606);
    s.u(paramMJMusicInfo, "mjMusicInfo");
    s.u(paramf, "musicSelectorTheme");
    s.u(parama, "onClick");
    paramh = paramh.by(-481261428);
    at localat = nYm.N(paramf);
    kotlin.g.a.m localm = (kotlin.g.a.m)c.a(paramh, -819893539, new p(paramMJMusicInfo, parama, paramInt));
    androidx.compose.runtime.q.a(new at[] { localat }, localm, paramh, 56);
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((kotlin.g.a.m)new q(paramMJMusicInfo, paramf, parama, paramInt));
    }
    AppMethodBeat.o(240606);
  }
  
  private static final void a(final g paramg, final bm<String> parambm, final kotlin.g.a.b<? super String, ah> paramb, final androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240669);
    androidx.compose.runtime.h localh = paramh.by(-360949863);
    if ((paramInt & 0xE) == 0) {
      if (localh.G(paramg)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (localh.G(parambm))
        {
          j = 32;
          label73:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label602;
        }
        if (!localh.G(paramb)) {
          break label584;
        }
        i = 256;
        label105:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!localh.nZ()))
        {
          final float f = ((androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU())).mn();
          final bm localbm = paramg.nYV;
          localh.bx(-3687241);
          Object localObject = localh.or();
          paramh = androidx.compose.runtime.h.alD;
          paramh = localObject;
          if (localObject == h.a.ox())
          {
            paramh = bj.T(androidx.compose.ui.n.g.al(androidx.compose.ui.n.g.ai(0.0F)));
            localh.F(paramh);
          }
          localh.od();
          final an localan = (an)paramh;
          f localf = (f)localh.a((p)nYm);
          final androidx.compose.foundation.lazy.aa localaa = androidx.compose.foundation.lazy.ab.f(localh);
          final com.tencent.mm.aj.c.a.b localb = com.tencent.mm.aj.c.a.a.a(localaa, null, localf.nYR, localh, 2);
          Boolean localBoolean = Boolean.TRUE;
          localh.bx(-3686095);
          boolean bool1 = localh.G(localbm);
          boolean bool2 = localh.G(parambm);
          boolean bool3 = localh.G(localaa);
          localObject = localh.or();
          if (!(bool3 | bool1 | bool2))
          {
            paramh = androidx.compose.runtime.h.alD;
            paramh = localObject;
            if (localObject != h.a.ox()) {}
          }
          else
          {
            paramh = (kotlin.g.a.m)new e(localaa, localbm, parambm, null);
            localh.F(paramh);
          }
          localh.od();
          androidx.compose.runtime.aa.a(localBoolean, (kotlin.g.a.m)paramh, localh);
          localh.bx(-3687241);
          localObject = localh.or();
          paramh = androidx.compose.runtime.h.alD;
          paramh = localObject;
          if (localObject == h.a.ox())
          {
            paramh = bj.T(Boolean.FALSE);
            localh.F(paramh);
          }
          localh.od();
          paramh = (an)paramh;
          androidx.compose.runtime.aa.a(Boolean.valueOf(localaa.ml()), (kotlin.g.a.m)new f(localaa, localb, paramh, paramb, localbm, parambm, null), localh);
          ae.a(androidx.compose.foundation.c.ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), (kotlin.g.a.m)new g(localf, localb, localaa, localbm, localan, paramg, parambm, f), localh, 6, 0);
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new h(paramg, parambm, paramb, paramInt));
          }
          AppMethodBeat.o(240669);
          return;
          i = 2;
          break;
          j = 16;
          break label73;
          label584:
          i = 128;
          break label105;
          localh.oi();
        }
        label602:
        i = j;
      }
    }
  }
  
  private static final void a(String paramString, final bm<Boolean> parambm, final kotlin.g.a.a<ah> parama, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240688);
    paramh = paramh.by(920910089);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramString)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(parambm))
        {
          j = 32;
          label70:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label658;
        }
        if (!paramh.G(parama)) {
          break label626;
        }
        i = 256;
        label101:
        i |= j;
      }
      for (;;)
      {
        label278:
        boolean bool;
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ()))
        {
          Object localObject1 = androidx.compose.ui.a.atD;
          localObject1 = androidx.compose.ui.a.a.sc();
          Object localObject3 = androidx.compose.foundation.g.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, false, parama, 7);
          paramh.bx(-1989997546);
          Object localObject2 = androidx.compose.foundation.c.a.abN;
          Object localObject4 = y.a(androidx.compose.foundation.c.a.mt(), (a.c)localObject1, paramh);
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
            ((kotlin.g.a.q)localObject3).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(-326682743);
            localObject1 = androidx.compose.foundation.c.aa.adE;
            if (((Boolean)parambm.getValue()).booleanValue()) {
              break label643;
            }
            bool = true;
            label404:
            a(bool, parama, androidx.compose.foundation.c.ab.f((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(16.0F)), paramh, i >> 3 & 0x70 | 0x180, 0);
            float f = androidx.compose.ui.n.g.ai(17.0F);
            long l1 = ((androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU())).x(f);
            long l2 = ((f)paramh.a((p)nYm)).nYP;
            t.a(paramString, androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(4.0F), 0.0F, 0.0F, 0.0F, 14), l2, l1, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, paramh, i & 0xE | 0xC30, 64, 65520);
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
            paramh.b((kotlin.g.a.m)new a(paramString, parambm, parama, paramInt));
          }
          AppMethodBeat.o(240688);
          return;
          i = 2;
          break;
          j = 16;
          break label70;
          label626:
          i = 128;
          break label101;
          paramh.om();
          break label278;
          label643:
          bool = false;
          break label404;
          paramh.oi();
        }
        label658:
        i = j;
      }
    }
  }
  
  public static final void a(kotlin.g.a.a<ah> parama, final g paramg, final f paramf, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240621);
    s.u(parama, "onClick");
    s.u(paramg, "musicState");
    s.u(paramf, "musicSelectorTheme");
    paramh = paramh.by(735280953);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(parama)) {
        i = 4;
      }
    }
    for (final int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(paramg))
        {
          j = 32;
          label91:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label269;
        }
        if (!paramh.G(paramf)) {
          break label252;
        }
        i = 256;
        label122:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ()))
        {
          at localat = nYm.N(paramf);
          kotlin.g.a.m localm = (kotlin.g.a.m)c.a(paramh, -819893257, new j(parama, paramg, i));
          androidx.compose.runtime.q.a(new at[] { localat }, localm, paramh, 56);
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new k(parama, paramg, paramf, paramInt));
          }
          AppMethodBeat.o(240621);
          return;
          i = 2;
          break;
          j = 16;
          break label91;
          label252:
          i = 128;
          break label122;
          paramh.oi();
        }
        label269:
        i = j;
      }
    }
  }
  
  private static final void a(boolean paramBoolean, final kotlin.g.a.a<ah> parama, final androidx.compose.ui.f paramf, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(240701);
    paramh = paramh.by(-1560795459);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label386:
    label395:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        label45:
        i = j | i;
        label52:
        if ((paramInt2 & 0x4) == 0) {
          break label281;
        }
        j = 384;
        label64:
        j = i | j;
        label71:
        if (((j & 0x2DB ^ 0x92) == 0) && (paramh.nZ())) {
          break label386;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if (!paramBoolean) {
          break label320;
        }
        paramh.bx(-1560795340);
        j.a(com.tencent.mm.aj.a.a(c.f.ui_rescoures_checkbox_selected, ((f)paramh.a((p)nYm)).nYP, paramh), "", androidx.compose.foundation.g.a(paramf, false, parama, 7), null, null, 0.0F, null, paramh, 56, 120);
        paramh.od();
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new b(paramBoolean, parama, paramf, paramInt1, paramInt2));
        }
        AppMethodBeat.o(240701);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label395;
        }
        if (paramh.am(paramBoolean))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = j;
        if ((paramInt1 & 0x70) != 0) {
          break label52;
        }
        if (paramh.G(parama))
        {
          i = 32;
          break label45;
        }
        i = 16;
        break label45;
        label281:
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label71;
        }
        if (paramh.G(paramf))
        {
          j = 256;
          break label64;
        }
        j = 128;
        break label64;
        label320:
        paramh.bx(-1560795032);
        j.a(com.tencent.mm.aj.a.a(c.f.ui_rescoures_checkbox_unselected, ((f)paramh.a((p)nYm)).nYP, paramh), "", androidx.compose.foundation.g.a(paramf, false, parama, 7), null, null, 0.0F, null, paramh, 56, 120);
        paramh.od();
        continue;
        paramh.oi();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(String paramString, bm<Boolean> parambm, kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(boolean paramBoolean, kotlin.g.a.a<ah> parama, androidx.compose.ui.f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    c(MJMusicInfo paramMJMusicInfo, boolean paramBoolean, int paramInt, long paramLong, kotlin.g.a.a<? extends List<? extends MJLyricInfo>> parama)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(float paramFloat, MJMusicInfo paramMJMusicInfo, kotlin.g.a.a<? extends List<? extends MJLyricInfo>> parama, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(androidx.compose.foundation.lazy.aa paramaa, bm<? extends List<? extends MJMusicInfo>> parambm, bm<String> parambm1, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240535);
      paramObject = (kotlin.d.d)new e(this.afu, localbm, parambm, paramd);
      AppMethodBeat.o(240535);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240529);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240529);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (Iterable)e.e(localbm);
        Object localObject = parambm;
        Iterator localIterator = paramObject.iterator();
        while (localIterator.hasNext())
        {
          paramObject = localIterator.next();
          if (s.p(((MJMusicInfo)paramObject).getMusicID(), e.f((bm)localObject)))
          {
            paramObject = (MJMusicInfo)paramObject;
            if (paramObject != null) {
              break label168;
            }
          }
        }
        label168:
        for (int i = 0;; i = e.e(localbm).indexOf(paramObject))
        {
          paramObject = this.afu;
          localObject = (kotlin.d.d)this;
          this.label = 1;
          if (androidx.compose.foundation.lazy.aa.a(paramObject, i, (kotlin.d.d)localObject) != locala) {
            break label189;
          }
          AppMethodBeat.o(240529);
          return locala;
          paramObject = null;
          break;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label189:
      paramObject = ah.aiuX;
      AppMethodBeat.o(240529);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    f(androidx.compose.foundation.lazy.aa paramaa, com.tencent.mm.aj.c.a.b paramb, an<Boolean> paraman, kotlin.g.a.b<? super String, ah> paramb1, bm<? extends List<? extends MJMusicInfo>> parambm, bm<String> parambm1, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240536);
      paramObject = (kotlin.d.d)new f(this.afu, localb, paramh, paramb, localbm, parambm, paramd);
      AppMethodBeat.o(240536);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240531);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240531);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((!this.afu.ml()) && (e.d(paramh)))
      {
        Object localObject2 = localb.bza();
        if (localObject2 != null)
        {
          paramObject = paramb;
          bm localbm = localbm;
          localObject1 = parambm;
          localObject2 = ((MJMusicInfo)e.e(localbm).get(((i)localObject2).getIndex())).getMusicID();
          s.s(localObject2, "musicInfos[it.index].musicID");
          paramObject.invoke(localObject2);
          Log.i("MusicSelectorExpand", s.X("select to ", e.f((bm)localObject1)));
        }
        e.d(paramh, false);
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(240531);
        return paramObject;
        e.d(paramh, true);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<ag, androidx.compose.ui.n.b, androidx.compose.ui.h.q>
  {
    g(f paramf, com.tencent.mm.aj.c.a.b paramb, androidx.compose.foundation.lazy.aa paramaa, bm<? extends List<? extends MJMusicInfo>> parambm, an<androidx.compose.ui.n.g> paraman, g paramg, bm<String> parambm1, float paramFloat)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
    {
      a(long paramLong, f paramf, com.tencent.mm.aj.c.a.b paramb, androidx.compose.foundation.lazy.aa paramaa, bm<? extends List<? extends MJMusicInfo>> parambm, an<androidx.compose.ui.n.g> paraman, g paramg, bm<String> parambm1, float paramFloat)
      {
        super();
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.b<w, ah>
      {
        a(bm<? extends List<? extends MJMusicInfo>> parambm, g paramg, an<androidx.compose.ui.n.g> paraman, bm<String> parambm1)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(g paramg, bm<String> parambm, kotlin.g.a.b<? super String, ah> paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    i(bm<Boolean> parambm1, kotlin.g.a.a<ah> parama1, bm<Boolean> parambm2, kotlin.g.a.a<ah> parama2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    j(kotlin.g.a.a<ah> parama, g paramg, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    k(kotlin.g.a.a<ah> parama, g paramg, f paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    m(g paramg)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    n(g paramg)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    o(kotlin.g.a.a<ah> parama, g paramg, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    p(MJMusicInfo paramMJMusicInfo, kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    q(MJMusicInfo paramMJMusicInfo, f paramf, kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    r(MJMusicInfo paramMJMusicInfo, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    s(MJMusicInfo paramMJMusicInfo, kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/mj_template/album_template/widget/MusicSelectorTheme;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<f>
  {
    public static final t nYI;
    
    static
    {
      AppMethodBeat.i(240618);
      nYI = new t();
      AppMethodBeat.o(240618);
    }
    
    t()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.e
 * JD-Core Version:    0.7.0.1
 */