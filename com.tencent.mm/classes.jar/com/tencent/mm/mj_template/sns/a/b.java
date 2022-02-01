package com.tencent.mm.mj_template.sns.a;

import android.view.SurfaceView;
import androidx.compose.a.j;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.h.ae;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.sns.a.a.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"BottomSheetWrapper", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "PreviewPageStructure", "listCompose", "previewCompose", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TemplateList", "snsTemplateListState", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;", "navigationBarHeight", "Landroidx/compose/ui/unit/Dp;", "TemplateList-ziNgDLE", "(Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;FLandroidx/compose/runtime/Composer;I)V", "TemplateUIPage", "viewVisible", "", "previewView", "Landroid/view/SurfaceView;", "onNextClick", "onBackClick", "templateListState", "moreTemplateBottomSheetState", "Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;", "musicState", "Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "TemplateUIPage-AFY4PWA", "(ZLandroid/view/SurfaceView;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;Lcom/tencent/mm/mj_template/album_template/widget/MusicState;Landroidx/compose/runtime/Composer;I)V", "Toolbar", "centerContent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  static final void a(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240312);
    androidx.compose.runtime.h localh = paramh.by(-660035129);
    if ((paramInt & 0xE) == 0) {
      if (localh.G(paramm1)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      final int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (localh.G(paramm2))
        {
          j = 32;
          label70:
          j |= i;
        }
      }
      else
      {
        if (((j & 0x5B ^ 0x12) == 0) && (localh.nZ())) {
          break label253;
        }
        localh.bx(-3686552);
        boolean bool1 = localh.G(paramm1);
        boolean bool2 = localh.G(paramm2);
        Object localObject = localh.or();
        if (!(bool2 | bool1))
        {
          paramh = androidx.compose.runtime.h.alD;
          paramh = localObject;
          if (localObject != h.a.ox()) {}
        }
        else
        {
          paramh = (kotlin.g.a.m)new c(paramm1, j, paramm2);
          localh.F(paramh);
        }
        localh.od();
        ae.a(null, (kotlin.g.a.m)paramh, localh, 0, 1);
      }
      for (;;)
      {
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new d(paramm1, paramm2, paramInt));
        }
        AppMethodBeat.o(240312);
        return;
        i = 2;
        break;
        j = 16;
        break label70;
        label253:
        localh.oi();
      }
    }
  }
  
  public static final void a(boolean paramBoolean, final SurfaceView paramSurfaceView, final float paramFloat, final kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2, final com.tencent.mm.mj_template.sns.a.a.g paramg, final com.tencent.mm.mj_template.sns.a.a.b paramb, final com.tencent.mm.mj_template.album_template.a.g paramg1, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(240297);
    s.u(parama1, "onNextClick");
    s.u(parama2, "onBackClick");
    s.u(paramg, "templateListState");
    s.u(paramb, "moreTemplateBottomSheetState");
    s.u(paramg1, "musicState");
    androidx.compose.runtime.h localh = paramh.by(162400157);
    localh.bx(-3687241);
    Object localObject1 = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramh = bj.T(a.odQ);
      localh.F(paramh);
    }
    localh.od();
    final an localan1 = (an)paramh;
    localh.bx(-3687241);
    localObject1 = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramh = bj.T(Boolean.FALSE);
      localh.F(paramh);
    }
    localh.od();
    final an localan2 = (an)paramh;
    androidx.compose.runtime.aa.a(paramg, (kotlin.g.a.m)new f(paramg, paramb, localan1, localan2, null), localh);
    localh.bx(-3686552);
    boolean bool1 = localh.G(localan2);
    boolean bool2 = localh.G(localan1);
    localObject1 = localh.or();
    if (!(bool2 | bool1))
    {
      paramh = androidx.compose.runtime.h.alD;
      paramh = (androidx.compose.runtime.h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      paramh = (kotlin.g.a.a)new o(localan2, localan1);
      localh.F(paramh);
    }
    localh.od();
    kotlin.g.a.a locala = (kotlin.g.a.a)paramh;
    bool1 = g(localan2);
    localh.bx(-3686930);
    bool2 = localh.G(locala);
    localObject1 = localh.or();
    if (!bool2)
    {
      paramh = androidx.compose.runtime.h.alD;
      paramh = (androidx.compose.runtime.h)localObject1;
      if (localObject1 != h.a.ox()) {}
    }
    else
    {
      paramh = (kotlin.g.a.a)new b.g(locala);
      localh.F(paramh);
    }
    localh.od();
    androidx.activity.a.a.a(bool1, (kotlin.g.a.a)paramh, localh, 0, 0);
    paramh = (f)f.aud;
    long l;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (paramBoolean)
    {
      localObject1 = z.awK;
      l = z.tv();
      localObject3 = androidx.compose.foundation.b.a(paramh, l);
      localh.bx(-1990474327);
      paramh = androidx.compose.ui.a.atD;
      localObject2 = androidx.compose.foundation.c.c.a(androidx.compose.ui.a.a.rU(), false, localh);
      localh.bx(1376089335);
      localObject1 = (androidx.compose.ui.n.d)localh.a((p)androidx.compose.ui.platform.u.yU());
      paramh = (n)localh.a((p)androidx.compose.ui.platform.u.yW());
      localObject4 = androidx.compose.ui.i.a.aNC;
      localObject4 = androidx.compose.ui.i.a.a.xb();
      localObject3 = androidx.compose.ui.h.m.i((f)localObject3);
      if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
        androidx.compose.runtime.g.nW();
      }
      localh.ol();
      if (!localh.nY()) {
        break label1093;
      }
      localh.a((kotlin.g.a.a)localObject4);
      label586:
      localh.op();
      s.u(localh, "composer");
      localObject4 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject2, androidx.compose.ui.i.a.a.xe());
      localObject2 = androidx.compose.ui.i.a.aNC;
      br.a(localh, localObject1, androidx.compose.ui.i.a.a.xd());
      localObject1 = androidx.compose.ui.i.a.aNC;
      br.a(localh, paramh, androidx.compose.ui.i.a.a.xf());
      localh.oq();
      s.u(localh, "composer");
      ((kotlin.g.a.q)localObject3).invoke(bc.p(localh), localh, Integer.valueOf(0));
      localh.bx(2058660585);
      localh.bx(-1253629305);
      paramh = androidx.compose.foundation.c.e.acr;
      a((kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819893442, new h(paramBoolean, paramInt, paramg, paramFloat)), (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819894219, new i(paramSurfaceView)), localh, 54);
      if ((g(localan2)) || (!paramBoolean)) {
        break label1103;
      }
    }
    label1093:
    label1103:
    for (bool1 = true;; bool1 = false)
    {
      androidx.compose.a.b.a(bool1, null, j.lr(), j.ls(), (kotlin.g.a.q)androidx.compose.runtime.c.c.a(localh, -819893950, new j(parama1, parama2, paramInt, paramg1, paramg)), localh, 28032, 2);
      bool1 = g(localan2);
      localObject2 = j.a((kotlin.g.a.b)b.k.oej, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6));
      localObject3 = j.b((kotlin.g.a.b)b.l.oek, (androidx.compose.a.a.aa)androidx.compose.a.a.h.a(300, null, 6));
      localObject4 = (f)f.aud;
      localh.bx(-3687241);
      localObject1 = localh.or();
      paramh = androidx.compose.runtime.h.alD;
      paramh = (androidx.compose.runtime.h)localObject1;
      if (localObject1 == h.a.ox())
      {
        paramh = androidx.compose.foundation.b.d.ms();
        localh.F(paramh);
      }
      localh.od();
      androidx.compose.a.b.a(bool1, androidx.compose.foundation.g.a((f)localObject4, (androidx.compose.foundation.b.e)paramh, null, false, null, locala, 28), (androidx.compose.a.k)localObject2, (androidx.compose.a.m)localObject3, (kotlin.g.a.q)androidx.compose.runtime.c.c.a(localh, -819890803, new m(paramg, paramb, localan1, localan2, paramg1, paramInt)), localh, 24576, 0);
      localh.od();
      localh.od();
      localh.on();
      localh.od();
      localh.od();
      paramh = localh.oh();
      if (paramh != null) {
        paramh.b((kotlin.g.a.m)new n(paramBoolean, paramSurfaceView, paramFloat, parama1, parama2, paramg, paramb, paramg1, paramInt));
      }
      AppMethodBeat.o(240297);
      return;
      localObject1 = z.awK;
      l = z.tz();
      break;
      localh.om();
      break label586;
    }
  }
  
  static final boolean g(an<Boolean> paraman)
  {
    AppMethodBeat.i(240323);
    boolean bool = ((Boolean)((bm)paraman).getValue()).booleanValue();
    AppMethodBeat.o(240323);
    return bool;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<ag, androidx.compose.ui.n.b, androidx.compose.ui.h.q>
  {
    c(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, int paramInt, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2)
    {
      super();
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
      b(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm1, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    e(com.tencent.mm.mj_template.sns.a.a.g paramg, float paramFloat, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    f(com.tencent.mm.mj_template.sns.a.a.g paramg, com.tencent.mm.mj_template.sns.a.a.b paramb, an<a> paraman, an<Boolean> paraman1, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240245);
      paramObject = (kotlin.d.d)new f(this.oec, paramb, localan1, localan2, paramd);
      AppMethodBeat.o(240245);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240241);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240241);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.oec;
      localObject1 = localan1;
      Object localObject2 = localan2;
      kotlin.g.a.a locala = (kotlin.g.a.a)new a((an)localObject1, (an)localObject2);
      s.u(locala, "<set-?>");
      paramObject.ofe = locala;
      localObject1 = (kotlin.g.a.a)new b((an)localObject1, (an)localObject2);
      s.u(localObject1, "<set-?>");
      paramObject.ofg = ((kotlin.g.a.a)localObject1);
      paramObject = paramb;
      localObject2 = localan2;
      localObject1 = this.oec;
      localObject2 = (kotlin.g.a.a)new c((an)localObject2);
      s.u(localObject2, "<set-?>");
      paramObject.oes = ((kotlin.g.a.a)localObject2);
      localObject1 = (kotlin.g.a.b)new d((com.tencent.mm.mj_template.sns.a.a.g)localObject1);
      s.u(localObject1, "<set-?>");
      paramObject.oet = ((kotlin.g.a.b)localObject1);
      paramObject = ah.aiuX;
      AppMethodBeat.o(240241);
      return paramObject;
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(an<a> paraman, an<Boolean> paraman1)
      {
        super();
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(an<a> paraman, an<Boolean> paraman1)
      {
        super();
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      c(an<Boolean> paraman)
      {
        super();
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.b<e.e, ah>
    {
      d(com.tencent.mm.mj_template.sns.a.a.g paramg)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    h(boolean paramBoolean, int paramInt, com.tencent.mm.mj_template.sns.a.a.g paramg, float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    i(SurfaceView paramSurfaceView)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    j(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, int paramInt, com.tencent.mm.mj_template.album_template.a.g paramg, com.tencent.mm.mj_template.sns.a.a.g paramg1)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.q<androidx.compose.a.c, androidx.compose.runtime.h, Integer, ah>
  {
    m(com.tencent.mm.mj_template.sns.a.a.g paramg, com.tencent.mm.mj_template.sns.a.a.b paramb, an<a> paraman, an<Boolean> paraman1, com.tencent.mm.mj_template.album_template.a.g paramg1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    n(boolean paramBoolean, SurfaceView paramSurfaceView, float paramFloat, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, com.tencent.mm.mj_template.sns.a.a.g paramg, com.tencent.mm.mj_template.sns.a.a.b paramb, com.tencent.mm.mj_template.album_template.a.g paramg1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    o(an<Boolean> paraman, an<a> paraman1)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    p(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.b
 * JD-Core Version:    0.7.0.1
 */