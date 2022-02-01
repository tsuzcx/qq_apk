package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.k;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$initView$6
  implements d.c
{
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(198765);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    paramInt -= ((com.tencent.mm.view.recyclerview.d)parama).Ibl.size();
    if ((paramInt >= 0) && (paramInt < FinderMsgContract.MsgViewCallback.b(this.qFe).dataList.size()))
    {
      parama = ((com.tencent.mm.plugin.finder.model.a)FinderMsgContract.MsgViewCallback.b(this.qFe).dataList.get(paramInt)).qDo;
      ad.i(FinderMsgContract.MsgViewCallback.c(this.qFe), "onClick " + paramInt + " id:" + parama.field_id + " commentId:" + parama.field_commentId);
      paramView = FinderMsgContract.MsgViewCallback.e(this.qFe);
      if (paramView != null) {
        paramView.a(parama);
      }
      if ((FinderMsgContract.MsgViewCallback.b(this.qFe).scene == 1) && (FinderMsgContract.MsgViewCallback.b(this.qFe).KJH == 1) && (paramInt == 0))
      {
        parama = g.afB();
        k.g(parama, "MMKernel.storage()");
        paramInt = parama.afk().getInt(ae.a.LBo, 0);
        parama = b.qFq;
        hy localhy = new hy();
        paramView = ((c)g.ab(c.class)).cbk();
        parama = paramView;
        if (paramView == null) {
          parama = "";
        }
        localhy.aSC(parama);
        localhy.zq(paramInt);
        localhy.aBj();
        b.a((com.tencent.mm.plugin.report.a)localhy);
        parama = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.lz((Context)this.qFe.imP);
        if (paramInt > 0)
        {
          parama = b.qFq;
          parama = FinderReporterUIC.Ljl;
          parama = FinderReporterUIC.a.lB((Context)FinderMsgContract.MsgViewCallback.g(this.qFe));
          if (parama != null) {}
          for (parama = parama.fXs();; parama = null)
          {
            b.a("5", 4, 2, 5, 0, paramInt, null, null, 0L, parama, 0, 1472);
            AppMethodBeat.o(198765);
            return;
          }
        }
      }
      else
      {
        if (parama.field_type == 1)
        {
          paramView = b.qFq;
          i = parama.field_type;
          if (parama.isOverlap()) {}
          for (paramInt = 1;; paramInt = 0)
          {
            b.aa(i, paramInt, parama.fVb());
            parama = com.tencent.mm.plugin.finder.utils.a.qSb;
            com.tencent.mm.plugin.finder.utils.a.lA((Context)this.qFe.imP);
            AppMethodBeat.o(198765);
            return;
          }
        }
        if (parama.field_type != 4)
        {
          paramView = b.qFq;
          i = parama.field_type;
          if (parama.isOverlap()) {}
          for (paramInt = 1;; paramInt = 0)
          {
            b.aa(i, paramInt, parama.fVb());
            paramView = FinderMsgContract.MsgViewCallback.f(this.qFe);
            if (paramView != null) {
              paramView.cancel();
            }
            FinderMsgContract.MsgViewCallback.a(this.qFe, parama);
            AppMethodBeat.o(198765);
            return;
          }
        }
        paramView = b.qFq;
        int i = parama.field_type;
        if (parama.isOverlap())
        {
          paramInt = 1;
          b.aa(i, paramInt, parama.fVb());
          parama = parama.field_notify;
          if (parama == null) {
            break label647;
          }
          switch (parama.subType)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(198765);
          return;
          paramInt = 0;
          break;
          ((n)g.ab(n.class)).a((Context)FinderMsgContract.MsgViewCallback.g(this.qFe), parama.DlU, "", 0, 0, parama.link, new AppBrandStatObject());
          AppMethodBeat.o(198765);
          return;
          paramView = new Intent();
          paramView.putExtra("rawUrl", parama.link);
          com.tencent.mm.bs.d.b((Context)FinderMsgContract.MsgViewCallback.g(this.qFe), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
    label647:
    AppMethodBeat.o(198765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.initView.6
 * JD-Core Version:    0.7.0.1
 */