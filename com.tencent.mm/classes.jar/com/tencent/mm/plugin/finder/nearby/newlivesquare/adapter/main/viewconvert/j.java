package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.b.a.c;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.en;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.nearby.f.c;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/NoticeConvertData;", "()V", "doReserveInternal", "", "context", "Landroid/content/Context;", "anchorFinderUsername", "", "liveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "getLayoutId", "handleNoticeReport", "op", "activity", "Landroid/app/Activity;", "item", "position", "jumpProfile", "username", "commentScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k>
{
  public static final a EOw;
  
  static
  {
    AppMethodBeat.i(340554);
    EOw = new a((byte)0);
    AppMethodBeat.o(340554);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k paramk, j paramj, com.tencent.mm.view.recyclerview.j paramj1, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(370561);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramk);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramk, "$item");
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramj1, "$holder");
    kotlin.g.b.s.u(paramView1, "$view");
    paramj = paramk.ENv.contact;
    int i;
    if (paramj == null)
    {
      paramj = "";
      localObject2 = paramk.ENv.ZFA;
      if (localObject2 != null)
      {
        if (((bkk)localObject2).status != 0) {
          break label690;
        }
        i = 2;
        label144:
        Context localContext = paramj1.context;
        kotlin.g.b.s.s(localContext, "holder.context");
        kotlin.g.b.s.u(localContext, "context");
        kotlin.g.b.s.u(paramj, "anchorFinderUsername");
        kotlin.g.b.s.u(localObject2, "liveNoticeInfo");
        switch (i)
        {
        default: 
          label200:
          localObject1 = h.ax(g.class);
          kotlin.g.b.s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
          g localg = (g)localObject1;
          localObject1 = ((bkk)localObject2).hAR;
          label313:
          label330:
          label472:
          label479:
          if (localObject1 == null)
          {
            localObject1 = "";
            label237:
            com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
            localObject1 = g.a.a(localg, paramj, (String)localObject1, i, ((as)com.tencent.mm.ui.component.k.nq(localContext).q(as.class)).fou());
            h.aZW().a((p)localObject1, 0);
            if (((g)h.ax(g.class)).Sv(paramj) != null) {
              break label717;
            }
            ((g)h.ax(g.class)).a(paramj, (bkk)localObject2);
            if (i != 1) {
              break label748;
            }
            paramj = paramj1.context.getString(f.h.finder_live_reserved_toast);
            kotlin.g.b.s.s(paramj, "if (op == FinderAudience…st)\n                    }");
            aa.db(paramj1.context, paramj);
            a(paramk, paramj1, paramView1);
            paramj = paramView2.getContext();
            if (!(paramj instanceof Activity)) {
              break label762;
            }
            paramj = (Activity)paramj;
            label369:
            if (paramj != null)
            {
              paramj1 = com.tencent.mm.ui.component.k.aeZF;
              paramj = com.tencent.mm.ui.component.k.nq((Context)paramj).q(com.tencent.mm.plugin.finder.nearby.report.f.class);
              kotlin.g.b.s.s(paramj, "UICProvider.of(it).get(N…eReporterUIC::class.java)");
              paramView2 = (com.tencent.mm.plugin.finder.nearby.report.f)paramj;
              localObject1 = new i();
              ((i)localObject1).n("column_id", paramk.ENs.name);
              ((i)localObject1).n("card_index", String.valueOf(paramInt));
              paramj = paramk.ENv;
              if (paramj != null) {
                break label767;
              }
              paramj = "";
              ((i)localObject1).n("Noticeid", paramj);
              if (i != 1) {
                break label799;
              }
              paramj1 = q.cg.DFs;
              if (paramk != null) {
                break label806;
              }
              paramj = "";
              if (paramk != null) {
                break label856;
              }
              paramk = "";
            }
          }
          label452:
          break;
        }
      }
    }
    for (;;)
    {
      paramView1 = ((i)localObject1).toString();
      kotlin.g.b.s.s(paramView1, "chnlExtra.toString()");
      localObject1 = n.bV(paramView1, ",", ";");
      kotlin.g.b.s.u(paramj1, "action");
      localObject2 = new en();
      paramView1 = paramj;
      if (paramj == null) {
        paramView1 = "";
      }
      ((en)localObject2).oY(paramView1);
      ((en)localObject2).eO(System.currentTimeMillis());
      ((en)localObject2).ioV = paramj1.action;
      paramj1 = paramView2.Dol;
      paramj = paramj1;
      if (paramj1 == null) {
        paramj = "";
      }
      ((en)localObject2).oZ(paramj);
      paramj1 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      paramj = paramj1;
      if (paramj1 == null) {
        paramj = "";
      }
      ((en)localObject2).pa(paramj);
      paramj = paramk;
      if (paramk == null) {
        paramj = "";
      }
      ((en)localObject2).pb(paramj);
      ((en)localObject2).iEt = ((en)localObject2).F("chnlExtra", (String)localObject1, true);
      ((en)localObject2).bMH();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370561);
      return;
      paramj = paramj.username;
      if (paramj == null)
      {
        paramj = "";
        break;
      }
      break;
      label690:
      i = 1;
      break label144;
      ((bkk)localObject2).status = 0;
      break label200;
      ((bkk)localObject2).status = 1;
      break label200;
      break label237;
      label717:
      paramj = ((g)h.ax(g.class)).Sv(paramj);
      if (paramj == null) {
        break label313;
      }
      paramj.status = ((bkk)localObject2).status;
      break label313;
      label748:
      paramj = paramj1.context.getString(f.h.finder_live_reserve_cancel_toast);
      break label330;
      label762:
      paramj = null;
      break label369;
      label767:
      paramj = paramj.ZFA;
      if (paramj == null)
      {
        paramj = "";
        break label452;
      }
      paramj1 = paramj.hAR;
      paramj = paramj1;
      if (paramj1 != null) {
        break label452;
      }
      paramj = "";
      break label452;
      label799:
      paramj1 = q.cg.DFt;
      break label472;
      label806:
      paramj = paramk.ENv;
      if (paramj == null)
      {
        paramj = "";
        break label479;
      }
      paramj = paramj.contact;
      if (paramj == null)
      {
        paramj = "";
        break label479;
      }
      paramView1 = paramj.username;
      paramj = paramView1;
      if (paramView1 != null) {
        break label479;
      }
      paramj = "";
      break label479;
      label856:
      paramk = paramk.ENv;
      if (paramk == null)
      {
        paramk = "";
      }
      else
      {
        paramk = paramk.ZFA;
        if (paramk == null)
        {
          paramk = "";
        }
        else
        {
          paramView1 = paramk.hAR;
          paramk = paramView1;
          if (paramView1 == null) {
            paramk = "";
          }
        }
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k paramk, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(370558);
    g localg = (g)h.ax(g.class);
    paramk = paramk.ENv.contact;
    Object localObject;
    if (paramk == null)
    {
      paramk = "";
      paramk = localg.Sv(paramk);
      if (paramk == null) {
        break label150;
      }
      localObject = paramj.UH(f.d.icon_fill_done);
      paramj = (TextView)paramj.UH(f.d.EGr);
      if (paramk.status != 0) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label129;
      }
      paramView.setBackgroundResource(f.c.shape_new_entrance_subscribe_btn_bg_2);
      ((View)localObject).setVisibility(0);
      paramj.setText(f.h.finder_live_live_notice_subscribe_done);
      AppMethodBeat.o(370558);
      return;
      localObject = paramk.username;
      paramk = (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k)localObject;
      if (localObject != null) {
        break;
      }
      paramk = "";
      break;
    }
    label129:
    paramView.setBackgroundResource(f.c.shape_new_entrance_subscribe_btn_bg);
    ((View)localObject).setVisibility(8);
    paramj.setText(f.h.finder_live_live_notice_subscribe);
    label150:
    AppMethodBeat.o(370558);
  }
  
  private static final void a(j paramj, com.tencent.mm.view.recyclerview.j paramj1, String paramString, View paramView)
  {
    AppMethodBeat.i(370556);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramj1);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramj1, "$holder");
    kotlin.g.b.s.u(paramString, "$name");
    paramj = paramj1.context;
    kotlin.g.b.s.s(paramj, "holder.context");
    paramj1 = new Intent();
    paramj1.putExtra("key_click_tab_context_id", ((e)h.az(e.class)).getNearbyTabLifecycleReporter().eGM());
    paramj1.putExtra("finder_username", paramString);
    paramj1.putExtra("key_from_comment_scene", 0);
    ((cn)h.az(cn.class)).fillContextIdToIntent(((e)h.az(e.class)).getNearbyTabLifecycleReporter().eeL(), paramj1);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramj, paramj1);
    paramj = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.eFx();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370556);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(340584);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    AppMethodBeat.o(340584);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGY;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/NoticeConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.j
 * JD-Core Version:    0.7.0.1
 */