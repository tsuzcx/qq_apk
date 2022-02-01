package com.tencent.mm.mj_template.sns.a.a;

import android.content.Context;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.lazy.w;
import androidx.compose.foundation.lazy.y;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.ui.a.b;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.z;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.a;
import com.tencent.mm.mj_template.plugin.c.b;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"RoundCornerWrapper", "", "modifier", "Landroidx/compose/ui/Modifier;", "selected", "", "gapDp", "Landroidx/compose/ui/unit/Dp;", "bgColor", "Landroidx/compose/ui/graphics/Color;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "RoundCornerWrapper-_UE9MAk", "(Landroidx/compose/ui/Modifier;ZFJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SnsTemplateItem", "snsTemplateListData", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "onSelect", "Lkotlin/Function1;", "(Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SnsTemplateItemDivider", "(Landroidx/compose/runtime/Composer;I)V", "SnsTemplateItemLoading", "SnsTemplateItemMiaoJian", "SnsTemplateItemMore", "onClick", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SnsTemplateItemTemplate", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "(Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SnsTemplateList", "snsTemplateListState", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  static final void a(androidx.compose.ui.f paramf, final boolean paramBoolean, final float paramFloat, final long paramLong, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(240441);
    paramh = paramh.by(-1273973358);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label897:
    label900:
    label903:
    for (final int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      label45:
      int k;
      label52:
      label89:
      label109:
      label116:
      Object localObject1;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        k = i | j;
        j = k;
        if ((paramInt1 & 0x1C00) == 0)
        {
          if (((paramInt2 & 0x8) != 0) || (!paramh.y(paramLong))) {
            break label782;
          }
          i = 2048;
          j = k | i;
        }
        if ((paramInt2 & 0x10) == 0) {
          break label790;
        }
        i = 24576;
        i = j | i;
        if (((0xB45B & i ^ 0x2412) == 0) && (paramh.nZ())) {
          break label887;
        }
        if (((paramInt1 & 0x1) != 0) && (!paramh.oa())) {
          break label831;
        }
        paramh.of();
        if ((paramInt2 & 0x1) != 0) {
          paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        }
        if ((paramInt2 & 0x2) != 0) {
          paramBoolean = false;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramFloat = androidx.compose.ui.n.g.ai(1.0F);
        }
        if ((paramInt2 & 0x8) == 0) {
          break label900;
        }
        localObject1 = z.awK;
        paramLong = z.tv();
        i &= 0xFFFFE3FF;
      }
      for (;;)
      {
        paramh.og();
        for (;;)
        {
          label229:
          localObject1 = androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F));
          paramh.bx(-1990474327);
          Object localObject5 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
          Object localObject2 = androidx.compose.ui.a.atD;
          Object localObject4 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
          paramh.bx(1376089335);
          Object localObject3 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
          localObject2 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
          Object localObject6 = androidx.compose.ui.i.a.aNC;
          localObject6 = androidx.compose.ui.i.a.a.xb();
          localObject5 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject5);
          if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
            androidx.compose.runtime.g.nW();
          }
          paramh.ol();
          if (paramh.nY())
          {
            paramh.a((kotlin.g.a.a)localObject6);
            label376:
            paramh.op();
            s.u(paramh, "composer");
            localObject6 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xd());
            localObject3 = androidx.compose.ui.i.a.aNC;
            br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xf());
            paramh.oq();
            s.u(paramh, "composer");
            ((kotlin.g.a.q)localObject5).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
            paramh.bx(2058660585);
            paramh.bx(-1253629305);
            localObject2 = androidx.compose.foundation.c.e.acr;
            if (!paramBoolean) {
              break label867;
            }
            paramh.bx(1688864183);
            float f = androidx.compose.ui.n.g.ai(1.0F);
            j = c.a.BW_100_Alpha_0_8;
            localObject2 = MMApplicationContext.getContext();
            s.s(localObject2, "getContext()");
            androidx.compose.foundation.c.c.a(androidx.compose.foundation.d.a(paramf, androidx.compose.foundation.f.a(f, com.tencent.mm.aj.a.c(j, (Context)localObject2)), (ay)androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(12.0F))), paramh, 0);
            paramh.od();
            label572:
            androidx.compose.b.q.a(androidx.compose.foundation.c.r.c(paramf, androidx.compose.ui.n.g.ai(4.0F)), (ay)localObject1, paramLong, 0L, null, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819897370, new a(paramm, i)), paramh, i >> 3 & 0x380 | 0x180000, 56);
            paramh.od();
            paramh.od();
            paramh.on();
            paramh.od();
            paramh.od();
          }
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new b(paramf, paramBoolean, paramFloat, paramLong, paramm, paramInt1, paramInt2));
            }
            AppMethodBeat.o(240441);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label903;
            }
            if (paramh.G(paramf))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            k = i;
            if ((paramInt1 & 0x70) != 0) {
              break label52;
            }
            if (paramh.am(paramBoolean))
            {
              j = 32;
              break label45;
            }
            j = 16;
            break label45;
            label782:
            i = 1024;
            break label89;
            label790:
            i = j;
            if ((0xE000 & paramInt1) != 0) {
              break label116;
            }
            if (paramh.G(paramm))
            {
              i = 16384;
              break label109;
            }
            i = 8192;
            break label109;
            label831:
            paramh.oj();
            if ((paramInt2 & 0x8) == 0) {
              break label897;
            }
            i &= 0xFFFFE3FF;
            break label229;
            paramh.om();
            break label376;
            label867:
            paramh.bx(1688864392);
            paramh.od();
            break label572;
            label887:
            paramh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(final e.e parame, final kotlin.g.a.a<ah> parama, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240381);
    s.u(parame, "snsTemplateListData");
    s.u(parama, "onClick");
    androidx.compose.runtime.h localh = paramh.by(-1647549122);
    if ((paramInt & 0xE) == 0) {
      if (localh.G(parame)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (localh.G(parama))
        {
          j = 32;
          label80:
          i = j | i;
        }
      }
      for (;;)
      {
        label352:
        long l1;
        if (((i & 0x5B ^ 0x12) != 0) || (!localh.nZ()))
        {
          boolean bool = ((Boolean)parame.oeN.getValue()).booleanValue();
          paramh = com.tencent.mm.mj_template.album_template.a.b.a(parame.oeS, localh);
          Object localObject1 = androidx.compose.ui.a.atD;
          localObject1 = androidx.compose.ui.a.a.se();
          Object localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
          i = c.b.ocM;
          i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
          localObject2 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)localObject2, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
          i = c.b.ocN;
          i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
          Object localObject3 = ab.d((androidx.compose.ui.f)localObject2, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
          localh.bx(-1113031299);
          localObject2 = androidx.compose.foundation.c.a.abN;
          Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (a.b)localObject1, localh);
          localh.bx(1376089335);
          localObject2 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
          localObject1 = (n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
          Object localObject5 = androidx.compose.ui.i.a.aNC;
          localObject5 = androidx.compose.ui.i.a.a.xb();
          localObject3 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject3);
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
            br.a(localh, localObject4, androidx.compose.ui.i.a.a.xe());
            localObject4 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject2, androidx.compose.ui.i.a.a.xd());
            localObject2 = androidx.compose.ui.i.a.aNC;
            br.a(localh, localObject1, androidx.compose.ui.i.a.a.xf());
            localh.oq();
            s.u(localh, "composer");
            ((kotlin.g.a.q)localObject3).invoke(bc.p(localh), localh, Integer.valueOf(0));
            localh.bx(2058660585);
            localh.bx(276693241);
            localObject1 = androidx.compose.foundation.c.h.acw;
            localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
            i = c.b.ocN;
            i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
            a(ab.f((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i))), bool, 0.0F, 0L, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819904474, new k(paramh, parame, parama)), localh, 24576, 12);
            localObject1 = parame.name;
            float f = androidx.compose.ui.n.g.ai(12.0F);
            long l2 = ((androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f);
            if (!bool) {
              break label813;
            }
            localh.bx(326639662);
            i = c.a.BW_100_Alpha_0_8;
            paramh = MMApplicationContext.getContext();
            s.s(paramh, "getContext()");
            l1 = com.tencent.mm.aj.a.c(i, paramh);
            localh.od();
            label629:
            if (!bool) {
              break label857;
            }
            paramh = i.bcc;
            paramh = i.Bh();
            label642:
            localObject2 = androidx.compose.ui.m.f.c.beg;
            i = androidx.compose.ui.m.f.c.BP();
            androidx.compose.b.t.a((String)localObject1, ab.e(androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(6.0F), 0.0F, 0.0F, 13), androidx.compose.ui.n.g.ai(34.0F)), l1, l2, null, paramh, null, 0L, null, androidx.compose.ui.m.f.c.dD(i), 0L, 0, false, 2, null, null, localh, 1073744944, 3136, 56784);
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
            paramh.b((kotlin.g.a.m)new l(parame, parama, paramInt));
          }
          AppMethodBeat.o(240381);
          return;
          i = 2;
          break;
          j = 16;
          break label80;
          localh.om();
          break label352;
          label813:
          localh.bx(326639698);
          i = c.a.BW_100_Alpha_0_5;
          paramh = MMApplicationContext.getContext();
          s.s(paramh, "getContext()");
          l1 = com.tencent.mm.aj.a.c(i, paramh);
          localh.od();
          break label629;
          label857:
          paramh = i.bcc;
          paramh = i.Bg();
          break label642;
          localh.oi();
        }
      }
    }
  }
  
  public static final void a(final g paramg, final androidx.compose.foundation.lazy.aa paramaa, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240365);
    s.u(paramg, "snsTemplateListState");
    s.u(paramaa, "lazyListState");
    paramh = paramh.by(-223834004);
    List localList = paramg.byC();
    androidx.compose.runtime.aa.a(Integer.valueOf(paramaa.afS.mM()), localList, (kotlin.g.a.m)new m(paramg, paramaa, null), paramh);
    androidx.compose.foundation.c.t localt = androidx.compose.foundation.c.r.D(androidx.compose.ui.n.g.ai(6.0F));
    androidx.compose.foundation.lazy.g.a(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), paramaa, localt, false, null, null, null, (kotlin.g.a.b)new n(localList, paramg), paramh, paramInt & 0x70 | 0x186, 120);
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((kotlin.g.a.m)new o(paramg, paramaa, paramInt));
    }
    AppMethodBeat.o(240365);
  }
  
  static final void a(kotlin.g.a.a<ah> parama, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240415);
    paramh = paramh.by(-2043970283);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(parama))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject1 = androidx.compose.ui.a.atD;
        localObject1 = androidx.compose.ui.a.a.se();
        Object localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        i = c.b.ocM;
        i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
        Object localObject3 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)localObject2, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
        paramh.bx(-1113031299);
        localObject2 = androidx.compose.foundation.c.a.abN;
        Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (a.b)localObject1, paramh);
        paramh.bx(1376089335);
        localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
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
          label235:
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
          paramh.bx(276693241);
          localObject1 = androidx.compose.foundation.c.h.acw;
          localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
          i = c.b.ocN;
          i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
          a(ab.f((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i))), false, 0.0F, 0L, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(paramh, -819899759, new i(parama)), paramh, 24576, 14);
          localObject1 = MMApplicationContext.getString(c.g.ody);
          localObject2 = androidx.compose.ui.m.f.c.beg;
          i = androidx.compose.ui.m.f.c.BP();
          float f = androidx.compose.ui.n.g.ai(12.0F);
          long l1 = ((androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f);
          int j = c.a.BW_100_Alpha_0_8;
          localObject2 = MMApplicationContext.getContext();
          s.s(localObject2, "getContext()");
          long l2 = com.tencent.mm.aj.a.c(j, (Context)localObject2);
          localObject2 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(6.0F), 0.0F, 0.0F, 13);
          s.s(localObject1, "str");
          androidx.compose.b.t.a((String)localObject1, (androidx.compose.ui.f)localObject2, l2, l1, null, null, null, 0L, null, androidx.compose.ui.m.f.c.dD(i), 0L, 0, false, 0, null, null, paramh, 1073744944, 64, 65008);
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
          paramh.b((kotlin.g.a.m)new j(parama, paramInt));
        }
        AppMethodBeat.o(240415);
        return;
        i = 2;
        break;
        paramh.om();
        break label235;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  static final void d(androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(240402);
    paramh = paramh.by(-1323911621);
    if ((paramInt != 0) || (!paramh.nZ()))
    {
      Object localObject1 = androidx.compose.ui.a.atD;
      localObject1 = androidx.compose.ui.a.a.se();
      Object localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
      int i = c.b.ocM;
      i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
      Object localObject3 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)localObject2, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
      paramh.bx(-1113031299);
      localObject2 = androidx.compose.foundation.c.a.abN;
      Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (a.b)localObject1, paramh);
      paramh.bx(1376089335);
      localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
      localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
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
        paramh.bx(276693241);
        localObject1 = androidx.compose.foundation.c.h.acw;
        paramh.bx(-1990474327);
        localObject4 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        localObject1 = androidx.compose.ui.a.atD;
        localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
        paramh.bx(1376089335);
        localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
        localObject5 = androidx.compose.ui.i.a.aNC;
        localObject5 = androidx.compose.ui.i.a.a.xb();
        localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        paramh.ol();
        if (!paramh.nY()) {
          break label1248;
        }
        paramh.a((kotlin.g.a.a)localObject5);
        label433:
        paramh.op();
        s.u(paramh, "composer");
        localObject5 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1253629305);
        localObject2 = (androidx.compose.foundation.c.d)androidx.compose.foundation.c.e.acr;
        localObject1 = androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(8.0F));
        i = c.a.BW_100_Alpha_0_1;
        localObject3 = MMApplicationContext.getContext();
        s.s(localObject3, "getContext()");
        long l1 = com.tencent.mm.aj.a.c(i, (Context)localObject3);
        localObject3 = ab.f((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(56.0F));
        localObject4 = androidx.compose.ui.a.atD;
        localObject2 = ((androidx.compose.foundation.c.d)localObject2).a((androidx.compose.ui.f)localObject3, androidx.compose.ui.a.a.rX());
        localObject1 = (ay)localObject1;
        localObject3 = a.oem;
        androidx.compose.b.q.a((androidx.compose.ui.f)localObject2, (ay)localObject1, l1, 0L, null, 0.0F, a.bwW(), paramh, 0, 56);
        localObject4 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, 0.0F, androidx.compose.ui.n.g.ai(8.0F), 0.0F, 11);
        paramh.bx(-1990474327);
        localObject1 = androidx.compose.ui.a.atD;
        localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
        paramh.bx(1376089335);
        localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
        localObject5 = androidx.compose.ui.i.a.aNC;
        localObject5 = androidx.compose.ui.i.a.a.xb();
        localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          androidx.compose.runtime.g.nW();
        }
        paramh.ol();
        if (!paramh.nY()) {
          break label1257;
        }
        paramh.a((kotlin.g.a.a)localObject5);
        label785:
        paramh.op();
        s.u(paramh, "composer");
        localObject5 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1253629305);
        localObject1 = androidx.compose.foundation.c.e.acr;
        localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        i = c.b.ocN;
        i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
        localObject1 = ab.f((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
        i = c.a.Dark_4;
        localObject2 = MMApplicationContext.getContext();
        s.s(localObject2, "getContext()");
        l1 = com.tencent.mm.aj.a.c(i, (Context)localObject2);
        localObject2 = a.oem;
        a((androidx.compose.ui.f)localObject1, false, 0.0F, l1, a.byx(), paramh, 0, 6);
        paramh.od();
        paramh.od();
        paramh.on();
        paramh.od();
        paramh.od();
        paramh.od();
        paramh.od();
        paramh.on();
        paramh.od();
        paramh.od();
        localObject1 = MMApplicationContext.getString(c.g.odf);
        localObject2 = androidx.compose.ui.m.f.c.beg;
        i = androidx.compose.ui.m.f.c.BP();
        float f = androidx.compose.ui.n.g.ai(12.0F);
        l1 = ((androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f);
        int j = c.a.BW_100_Alpha_0_5;
        localObject2 = MMApplicationContext.getContext();
        s.s(localObject2, "getContext()");
        long l2 = com.tencent.mm.aj.a.c(j, (Context)localObject2);
        localObject2 = androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(6.0F), 0.0F, 0.0F, 13);
        s.s(localObject1, "str");
        androidx.compose.b.t.a((String)localObject1, (androidx.compose.ui.f)localObject2, l2, l1, null, null, null, 0L, null, androidx.compose.ui.m.f.c.dD(i), 0L, 0, false, 0, null, null, paramh, 1073744944, 64, 65008);
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
        paramh.b((kotlin.g.a.m)new h(paramInt));
      }
      AppMethodBeat.o(240402);
      return;
      paramh.om();
      break;
      label1248:
      paramh.om();
      break label433;
      label1257:
      paramh.om();
      break label785;
      paramh.oi();
    }
  }
  
  static final void e(androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(240428);
    paramh = paramh.by(-487584449);
    if ((paramInt != 0) || (!paramh.nZ()))
    {
      Object localObject1 = androidx.compose.ui.a.atD;
      localObject1 = androidx.compose.ui.a.a.se();
      Object localObject2 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
      int i = c.b.ocM;
      i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
      Object localObject3 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)localObject2, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
      paramh.bx(-1113031299);
      localObject2 = androidx.compose.foundation.c.a.abN;
      Object localObject4 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), (a.b)localObject1, paramh);
      paramh.bx(1376089335);
      localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
      localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
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
        paramh.bx(276693241);
        localObject1 = androidx.compose.foundation.c.h.acw;
        localObject1 = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
        i = c.b.ocN;
        i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
        localObject1 = ab.f((androidx.compose.ui.f)localObject1, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i)));
        i = c.a.BW_100_Alpha_0_1_2;
        localObject2 = MMApplicationContext.getContext();
        s.s(localObject2, "getContext()");
        long l = com.tencent.mm.aj.a.c(i, (Context)localObject2);
        localObject2 = a.oem;
        a((androidx.compose.ui.f)localObject1, false, 0.0F, l, a.byy(), paramh, 0, 6);
        float f = androidx.compose.ui.n.g.ai(12.0F);
        l = ((androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f);
        localObject1 = androidx.compose.ui.m.f.c.beg;
        i = androidx.compose.ui.m.f.c.BP();
        androidx.compose.b.t.a("", ab.e(androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(6.0F), 0.0F, 0.0F, 13), androidx.compose.ui.n.g.ai(34.0F)), 0L, l, null, null, null, 0L, null, androidx.compose.ui.m.f.c.dD(i), 0L, 0, false, 2, null, null, paramh, 1073744950, 3136, 56820);
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
        paramh.b((kotlin.g.a.m)new g(paramInt));
      }
      AppMethodBeat.o(240428);
      return;
      paramh.om();
      break;
      paramh.oi();
    }
  }
  
  static final void f(androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(240450);
    paramh = paramh.by(-1969545691);
    if ((paramInt != 0) || (!paramh.nZ()))
    {
      Object localObject1 = androidx.compose.ui.f.aud;
      float f1 = androidx.compose.ui.n.g.ai(20.0F);
      int i = c.b.ocM;
      i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
      float f2 = androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i));
      localObject1 = ab.b(androidx.compose.foundation.c.r.a((androidx.compose.ui.f)localObject1, f2, f1), androidx.compose.ui.n.g.ai(1.0F), androidx.compose.ui.n.g.ai(24.0F));
      i = c.a.BW_100_Alpha_0_8;
      Object localObject2 = MMApplicationContext.getContext();
      s.s(localObject2, "getContext()");
      Object localObject4 = androidx.compose.foundation.b.a((androidx.compose.ui.f)localObject1, com.tencent.mm.aj.a.c(i, (Context)localObject2));
      paramh.bx(-1990474327);
      localObject1 = androidx.compose.ui.a.atD;
      Object localObject3 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, paramh);
      paramh.bx(1376089335);
      localObject2 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
      localObject1 = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
      Object localObject5 = androidx.compose.ui.i.a.aNC;
      localObject5 = androidx.compose.ui.i.a.a.xb();
      localObject4 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject4);
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
        br.a(paramh, localObject3, androidx.compose.ui.i.a.a.xe());
        localObject3 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject2, androidx.compose.ui.i.a.a.xd());
        localObject2 = androidx.compose.ui.i.a.aNC;
        br.a(paramh, localObject1, androidx.compose.ui.i.a.a.xf());
        paramh.oq();
        s.u(paramh, "composer");
        ((kotlin.g.a.q)localObject4).invoke(bc.p(paramh), paramh, Integer.valueOf(0));
        paramh.bx(2058660585);
        paramh.bx(-1253629305);
        localObject1 = androidx.compose.foundation.c.e.acr;
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
        paramh.b((kotlin.g.a.m)new f(paramInt));
      }
      AppMethodBeat.o(240450);
      return;
      paramh.om();
      break;
      paramh.oi();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    a(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(androidx.compose.ui.f paramf, boolean paramBoolean, float paramFloat, long paramLong, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    e(e parame, kotlin.g.a.b<? super e, ah> paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    f(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    g(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    i(kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    j(kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    k(com.tencent.mm.mj_template.album_template.a.a parama, e.e parame, kotlin.g.a.a<ah> parama1)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    l(e.e parame, kotlin.g.a.a<ah> parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    m(g paramg, androidx.compose.foundation.lazy.aa paramaa, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240341);
      paramObject = (kotlin.d.d)new m(this.oea, paramaa, paramd);
      AppMethodBeat.o(240341);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240334);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240334);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.oea;
      Object localObject2 = (Iterable)paramaa.mQ().mE();
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(Integer.valueOf(((androidx.compose.foundation.lazy.m)((Iterator)localObject2).next()).getIndex()));
      }
      paramObject.bM((List)localObject1);
      paramObject = ah.aiuX;
      AppMethodBeat.o(240334);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<w, ah>
  {
    n(List<? extends e> paramList, g paramg)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    o(g paramg, androidx.compose.foundation.lazy.aa paramaa, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.f
 * JD-Core Version:    0.7.0.1
 */