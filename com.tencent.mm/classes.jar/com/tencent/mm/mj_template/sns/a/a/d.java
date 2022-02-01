package com.tencent.mm.mj_template.sns.a.a;

import android.content.Context;
import androidx.compose.b.t;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.aa;
import androidx.compose.foundation.c.ab;
import androidx.compose.foundation.c.y;
import androidx.compose.foundation.j;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.ae;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.a;
import com.tencent.mm.mj_template.plugin.c.f;
import com.tencent.mm.mj_template.plugin.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"ROW_ITEM_SIZE", "", "Header", "", "canConfirm", "", "onClose", "Lkotlin/Function0;", "onConfirm", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MainContent", "moreTemplateBottomSheetState", "Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;", "(Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;Landroidx/compose/runtime/Composer;I)V", "MoreTemplateBottomSheet", "TabLayout", "TabPageContent", "templateDataList", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "(Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "tabIndicatorOffset", "Landroidx/compose/ui/Modifier;", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void a(b paramb, h paramh, final int paramInt)
  {
    AppMethodBeat.i(240371);
    s.u(paramb, "moreTemplateBottomSheetState");
    paramh = paramh.by(833287846);
    ae.a(null, (kotlin.g.a.m)new f(paramb), paramh, 0, 1);
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((kotlin.g.a.m)new g(paramb, paramInt));
    }
    AppMethodBeat.o(240371);
  }
  
  static final void a(boolean paramBoolean, final kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2, h paramh, final int paramInt)
  {
    AppMethodBeat.i(240400);
    paramh = paramh.by(-1604799801);
    if ((paramInt & 0xE) == 0) {
      if (paramh.am(paramBoolean)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(parama1))
        {
          j = 32;
          label68:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label836;
        }
        if (!paramh.G(parama2)) {
          break label765;
        }
        i = 256;
        label99:
        i |= j;
      }
      for (;;)
      {
        Object localObject1;
        label285:
        long l1;
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ()))
        {
          localObject1 = androidx.compose.ui.a.atD;
          localObject1 = androidx.compose.ui.a.a.sc();
          Object localObject2 = androidx.compose.foundation.c.a.abN;
          localObject2 = androidx.compose.foundation.c.a.mz();
          Object localObject3 = ab.e(ab.c((androidx.compose.ui.f)androidx.compose.ui.f.aud), androidx.compose.ui.n.g.ai(64.0F));
          paramh.bx(-1989997546);
          Object localObject4 = y.a((a.d)localObject2, (a.c)localObject1, paramh);
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
            localObject1 = aa.adE;
            i = c.f.icons_filled_close;
            j = c.a.BW_100_Alpha_0_8;
            localObject1 = MMApplicationContext.getContext();
            s.s(localObject1, "getContext()");
            j.a(com.tencent.mm.aj.a.a(i, com.tencent.mm.aj.a.c(j, (Context)localObject1), paramh), "close_icon", androidx.compose.foundation.g.a(ab.f(androidx.compose.foundation.c.r.c((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(16.0F)), androidx.compose.ui.n.g.ai(24.0F)), false, parama1, 7), null, null, 0.0F, null, paramh, 56, 120);
            localObject1 = MMApplicationContext.getString(c.g.odb);
            float f = androidx.compose.ui.n.g.ai(15.0F);
            l1 = ((androidx.compose.ui.n.d)paramh.a((p)androidx.compose.ui.platform.u.yU())).x(f);
            i = c.a.BW_100_Alpha_0_8;
            localObject2 = MMApplicationContext.getContext();
            s.s(localObject2, "getContext()");
            long l2 = com.tencent.mm.aj.a.c(i, (Context)localObject2);
            s.s(localObject1, "str");
            t.a((String)localObject1, null, l2, l1, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, paramh, 3072, 64, 65522);
            i = c.f.icons_filled_done;
            if (!paramBoolean) {
              break label782;
            }
            paramh.bx(-1447843619);
            j = c.a.Brand;
            localObject1 = MMApplicationContext.getContext();
            s.s(localObject1, "getContext()");
            l1 = com.tencent.mm.aj.a.c(j, (Context)localObject1);
            paramh.od();
            label630:
            j.a(com.tencent.mm.aj.a.a(i, l1, paramh), "close_icon", androidx.compose.foundation.g.a(ab.f(androidx.compose.foundation.c.r.c((androidx.compose.ui.f)androidx.compose.ui.f.aud, androidx.compose.ui.n.g.ai(16.0F)), androidx.compose.ui.n.g.ai(24.0F)), paramBoolean, parama2, 6), null, null, 0.0F, null, paramh, 56, 120);
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
            paramh.b((kotlin.g.a.m)new a(paramBoolean, parama1, parama2, paramInt));
          }
          AppMethodBeat.o(240400);
          return;
          i = 2;
          break;
          j = 16;
          break label68;
          label765:
          i = 128;
          break label99;
          paramh.om();
          break label285;
          label782:
          paramh.bx(-1447843583);
          j = c.a.BW_100_Alpha_0_3;
          localObject1 = MMApplicationContext.getContext();
          s.s(localObject1, "getContext()");
          l1 = com.tencent.mm.aj.a.c(j, (Context)localObject1);
          paramh.od();
          break label630;
          paramh.oi();
        }
        label836:
        i = j;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(boolean paramBoolean, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.q<Boolean, h, Integer, ah>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    e(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.m<ag, androidx.compose.ui.n.b, androidx.compose.ui.h.q>
  {
    f(b paramb)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.m<h, Integer, ah>
    {
      a(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    g(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    h(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.q<List<? extends com.tencent.mm.aj.c.c>, h, Integer, ah>
  {
    i(com.tencent.mm.aj.c.b.f paramf)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    j(List<c> paramList, com.tencent.mm.aj.c.b.f paramf, aq paramaq)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(aq paramaq, com.tencent.mm.aj.c.b.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.q<androidx.compose.foundation.c.g, h, Integer, ah>
    {
      b(com.tencent.mm.aj.c.b.f paramf, int paramInt, c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.r<com.tencent.mm.aj.c.b.d, Integer, h, Integer, ah>
  {
    k(b paramb, List<c> paramList)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    l(b paramb, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.d
 * JD-Core Version:    0.7.0.1
 */