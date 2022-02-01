package com.tencent.mm.mj_template.album_template.multi_template.a;

import android.content.Context;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.lazy.w;
import androidx.compose.foundation.lazy.y;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.ui.a.b;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.z;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

@Metadata(d1={""}, d2={"MaasLoadingItem", "", "(Landroidx/compose/runtime/Composer;I)V", "MaasTemplateItem", "selected", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "name", "", "onClick", "Lkotlin/Function0;", "bgColor", "Landroidx/compose/ui/graphics/Color;", "MaasTemplateItem-M8YrEPQ", "(ZLandroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "TemplateList", "templateState", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;", "templateListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "TemplateListItem", "itemInfo", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "Lkotlin/Function1;", "(Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final void a(d paramd, final androidx.compose.foundation.lazy.aa paramaa, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240684);
    s.u(paramd, "templateState");
    s.u(paramaa, "templateListState");
    paramh = paramh.by(1462685500);
    Object localObject1 = androidx.compose.ui.a.atD;
    localObject1 = androidx.compose.ui.a.a.se();
    Object localObject3 = ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud);
    paramh.bx(-1113031299);
    Object localObject2 = androidx.compose.foundation.c.a.abN;
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
      if (paramd.bwZ()) {
        break label576;
      }
      paramh.bx(603244357);
      localObject1 = MMApplicationContext.getString(com.tencent.mm.mj_template.plugin.c.g.odc);
      float f = androidx.compose.ui.n.g.ai(15.0F);
      long l1 = ((androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f);
      int i = com.tencent.mm.mj_template.plugin.c.a.BW_100_Alpha_0_6;
      localObject2 = MMApplicationContext.getContext();
      s.s(localObject2, "getContext()");
      long l2 = com.tencent.mm.aj.a.c(i, (Context)localObject2);
      s.s(localObject1, "str");
      androidx.compose.b.t.a((String)localObject1, null, l2, l1, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, paramh, 3072, 64, 65522);
      paramh.od();
    }
    for (;;)
    {
      androidx.compose.runtime.aa.a(Integer.valueOf(paramaa.afS.mM()), paramd.bwY(), (kotlin.g.a.m)new e(paramd, paramaa, null), paramh);
      localObject1 = androidx.compose.foundation.c.r.D(androidx.compose.ui.n.g.ai(14.0F));
      androidx.compose.foundation.lazy.g.a(ab.c(androidx.compose.foundation.c.r.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, androidx.compose.ui.n.g.ai(24.0F), 0.0F, 0.0F, 13)), paramaa, (androidx.compose.foundation.c.t)localObject1, false, null, null, null, (kotlin.g.a.b)new f(paramd), paramh, paramInt & 0x70 | 0x186, 120);
      paramh.od();
      paramh.od();
      paramh.on();
      paramh.od();
      paramh.od();
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new g(paramd, paramaa, paramInt));
      }
      AppMethodBeat.o(240684);
      return;
      paramh.om();
      break;
      label576:
      paramh.bx(603244555);
      paramh.od();
    }
  }
  
  static final void a(boolean paramBoolean, final androidx.compose.ui.e.c.c paramc, final String paramString, final kotlin.g.a.a<ah> parama, final z paramz, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(240706);
    androidx.compose.runtime.h localh = paramh.by(1419757746);
    if ((paramInt2 & 0x10) != 0) {
      paramz = null;
    }
    paramh = androidx.compose.ui.a.atD;
    paramh = androidx.compose.ui.a.a.se();
    Object localObject2 = ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(84.0F));
    localh.bx(-1113031299);
    Object localObject1 = androidx.compose.foundation.c.a.abN;
    Object localObject3 = androidx.compose.foundation.c.f.a(androidx.compose.foundation.c.a.mw(), paramh, localh);
    localh.bx(1376089335);
    localObject1 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
    paramh = (n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
    Object localObject4 = androidx.compose.ui.i.a.aNC;
    localObject4 = androidx.compose.ui.i.a.a.xb();
    localObject2 = androidx.compose.ui.h.m.i((androidx.compose.ui.f)localObject2);
    if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
      androidx.compose.runtime.g.nW();
    }
    localh.ol();
    long l;
    label332:
    float f;
    int i;
    if (localh.nY())
    {
      localh.a((kotlin.g.a.a)localObject4);
      localh.op();
      s.u(localh, "composer");
      localObject4 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject3, androidx.compose.ui.i.a.a.xe());
      localObject3 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject1, androidx.compose.ui.i.a.a.xd());
      localObject1 = androidx.compose.ui.i.a.aNC;
      br.a(localh, paramh, androidx.compose.ui.i.a.a.xf());
      localh.oq();
      s.u(localh, "composer");
      ((kotlin.g.a.q)localObject2).invoke(bc.p(localh), localh, Integer.valueOf(0));
      localh.bx(2058660585);
      localh.bx(276693241);
      paramh = androidx.compose.foundation.c.h.acw;
      localObject1 = androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(6.0F));
      if (paramz != null) {
        break label655;
      }
      paramh = z.awK;
      l = z.tz();
      if (!paramBoolean) {
        break label665;
      }
      localh.bx(-336403970);
      f = androidx.compose.ui.n.g.ai(2.0F);
      i = com.tencent.mm.mj_template.plugin.c.a.Orange;
      paramh = MMApplicationContext.getContext();
      s.s(paramh, "getContext()");
      paramh = androidx.compose.foundation.f.a(f, com.tencent.mm.aj.a.c(i, paramh));
      localh.od();
    }
    for (;;)
    {
      localObject2 = androidx.compose.foundation.c.r.b((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(10.0F));
      i = com.tencent.mm.mj_template.plugin.c.b.ocL;
      i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
      f = androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i));
      i = com.tencent.mm.mj_template.plugin.c.b.ocK;
      i = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), i);
      androidx.compose.b.q.a(androidx.compose.foundation.g.a(ab.b((androidx.compose.ui.f)localObject2, f, androidx.compose.ui.n.g.ai(com.tencent.mm.cd.a.K(MMApplicationContext.getContext(), i))), false, parama, 7), (ay)localObject1, l, 0L, paramh, 0.0F, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819901395, new b(paramz, paramc)), localh, 1572864, 40);
      androidx.compose.a.h.a(Boolean.valueOf(paramBoolean), null, null, (kotlin.g.a.q)androidx.compose.runtime.c.c.a(localh, -819901551, new c(paramString, paramInt1)), localh, paramInt1 & 0xE | 0xC00, 6);
      localh.od();
      localh.od();
      localh.on();
      localh.od();
      localh.od();
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new d(paramBoolean, paramc, paramString, parama, paramz, paramInt1, paramInt2));
      }
      AppMethodBeat.o(240706);
      return;
      localh.om();
      break;
      label655:
      l = paramz.value;
      break label332;
      label665:
      localh.bx(-1838586989);
      localh.od();
      paramh = null;
    }
  }
  
  private static final boolean a(an<Boolean> paraman)
  {
    AppMethodBeat.i(240715);
    boolean bool = ((Boolean)((bm)paraman).getValue()).booleanValue();
    AppMethodBeat.o(240715);
    return bool;
  }
  
  static final void c(androidx.compose.runtime.h paramh, int paramInt)
  {
    AppMethodBeat.i(240694);
    paramh = paramh.by(1443828047);
    if ((paramInt != 0) || (!paramh.nZ()))
    {
      Object localObject1 = androidx.compose.ui.a.atD;
      localObject1 = androidx.compose.ui.a.a.se();
      Object localObject3 = ab.d((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(84.0F));
      paramh.bx(-1113031299);
      Object localObject2 = androidx.compose.foundation.c.a.abN;
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
        localObject2 = androidx.compose.foundation.e.g.G(androidx.compose.ui.n.g.ai(6.0F));
        int i = com.tencent.mm.mj_template.plugin.c.a.BW_BG_30;
        localObject1 = MMApplicationContext.getContext();
        s.s(localObject1, "getContext()");
        long l = com.tencent.mm.aj.a.c(i, (Context)localObject1);
        localObject1 = ab.b(androidx.compose.foundation.c.r.b((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(10.0F)), androidx.compose.ui.n.g.ai(64.0F), androidx.compose.ui.n.g.ai(74.800003F));
        localObject2 = (ay)localObject2;
        localObject3 = a.nXc;
        androidx.compose.b.q.a((androidx.compose.ui.f)localObject1, (ay)localObject2, l, 0L, null, 0.0F, a.bwW(), paramh, 6, 56);
        float f1 = androidx.compose.ui.n.g.ai(14.0F);
        l = ((androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU())).x(f1);
        localObject1 = androidx.compose.ui.f.aud;
        f1 = androidx.compose.ui.n.g.ai(12.0F);
        float f2 = androidx.compose.ui.n.g.ai(2.0F);
        float f3 = androidx.compose.ui.n.g.ai(2.0F);
        androidx.compose.b.t.a("", ab.e(androidx.compose.foundation.c.r.a((androidx.compose.ui.f)localObject1, f2, f1, f3, 0.0F, 8), androidx.compose.ui.n.g.ai(40.0F)), 0L, l, null, null, null, 0L, null, null, 0L, 0, false, 2, null, null, paramh, 3078, 3136, 57332);
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
        paramh.b((kotlin.g.a.m)new a(paramInt));
      }
      AppMethodBeat.o(240694);
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
    a(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(z paramz, androidx.compose.ui.e.c.c paramc)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.q<Boolean, androidx.compose.runtime.h, Integer, ah>
  {
    c(String paramString, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(boolean paramBoolean, androidx.compose.ui.e.c.c paramc, String paramString, kotlin.g.a.a<ah> parama, z paramz, int paramInt1, int paramInt2)
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
    
    e(d paramd, androidx.compose.foundation.lazy.aa paramaa, kotlin.d.d<? super e> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240687);
      paramObject = (kotlin.d.d)new e(this.nWV, paramaa, paramd);
      AppMethodBeat.o(240687);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240681);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240681);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.nWV;
      Object localObject2 = (Iterable)paramaa.mQ().mE();
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(Integer.valueOf(((androidx.compose.foundation.lazy.m)((Iterator)localObject2).next()).getIndex()));
      }
      paramObject.bM((List)localObject1);
      paramObject = ah.aiuX;
      AppMethodBeat.o(240681);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<w, ah>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    g(d paramd, androidx.compose.foundation.lazy.aa paramaa, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(b paramb, kotlin.g.a.b<? super b, ah> paramb1, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.a.c
 * JD-Core Version:    0.7.0.1
 */