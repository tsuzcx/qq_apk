package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"})
public final class d
  extends f
{
  private ImageView sCR;
  private View sCS;
  private ImageView sCT;
  private final v sCU;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(265451);
    this.sCU = new v();
    AppMethodBeat.o(265451);
  }
  
  private static void dQ(View paramView)
  {
    AppMethodBeat.i(265450);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = b.sAo;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(265450);
  }
  
  public final void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(265449);
    p.k(paramView, "parent");
    if (getItemView() == null)
    {
      super.W(paramView, paramInt);
      this.sCR = ((ImageView)paramView.findViewById(d.e.cover_iv));
      this.sCS = paramView.findViewById(d.e.cover_layout);
      this.sCT = ((ImageView)paramView.findViewById(d.e.dCV));
      cAo();
      dR(paramView.findViewById(d.e.sti));
      paramView = getItemView();
      if (paramView != null) {}
      for (paramView = (MMNeat7extView)paramView.findViewById(d.e.title_tv); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(265449);
        throw paramView;
      }
      this.sDe = paramView;
      paramView = getItemView();
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(d.e.dRn); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(265449);
        throw paramView;
      }
      this.sDf = paramView;
      paramView = getItemView();
      if (paramView == null) {
        break label286;
      }
      paramView = (LinearLayout)paramView.findViewById(d.e.srq);
      a(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label291;
      }
      paramView = (LinearLayout)paramView.findViewById(d.e.ssU);
      label225:
      b(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label296;
      }
      paramView = (MMNeat7extView)paramView.findViewById(d.e.ssT);
      label250:
      c(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label301;
      }
    }
    label286:
    label291:
    label296:
    label301:
    for (paramView = (MMNeat7extView)paramView.findViewById(d.e.dVp);; paramView = null)
    {
      d(paramView);
      AppMethodBeat.o(265449);
      return;
      paramView = null;
      break;
      paramView = null;
      break label225;
      paramView = null;
      break label250;
    }
  }
  
  public final void a(final View paramView, final z paramz, pf parampf)
  {
    AppMethodBeat.i(265448);
    p.k(paramView, "parent");
    p.k(paramz, "info");
    p.k(parampf, "bizInfo");
    W(paramView, d.e.sty);
    if (getItemView() == null)
    {
      AppMethodBeat.o(265448);
      return;
    }
    paramView = getItemView();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (pe)parampf.RXM.get(0);
    p.j(paramView, "appMsg");
    a(paramz, parampf, paramView);
    Object localObject1 = this.sCS;
    if (localObject1 == null) {
      p.iCn();
    }
    dQ((View)localObject1);
    localObject1 = this.sCR;
    if (localObject1 == null) {
      p.iCn();
    }
    dQ((View)localObject1);
    localObject1 = new aa.a();
    ((aa.a)localObject1).aaBx = false;
    boolean bool;
    switch (paramz.hwL().style)
    {
    default: 
      this.sCU.type = paramView.lpx;
      this.sCU.lpK = paramView.RTm;
      this.sCU.lqb = paramView.RTm;
      this.sCU.url = paramView.RTk;
      localObject2 = a.shG;
      i = a.eO(this.context);
      j = b.sAu;
      this.sCg.sAc.a(paramz.field_msgId, 0, this.sCU, paramView.RTm, this.sCR, i - j, b.sAo, false, (m.a)new a(this, (aa.a)localObject1, paramz, paramView), false, paramz.sHe);
      b(paramz, parampf, paramView);
      AppMethodBeat.o(265448);
      return;
    case 101: 
      if (parampf.RXM.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        ((aa.a)localObject1).aaBx = bool;
        break;
      }
    }
    Object localObject2 = paramz.hwL().UsF.RVd;
    p.j(localObject2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    localObject2 = (Iterable)j.c((Iterable)localObject2, 2);
    int j = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    label379:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (j < 0) {
        j.iBO();
      }
      if (((pf)localObject3).RIs != 0) {
        break label457;
      }
      i += 1;
    }
    label457:
    for (;;)
    {
      j += 1;
      break label379;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        ((aa.a)localObject1).aaBx = bool;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(aa.a parama, z paramz, pe parampe) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(267018);
      Object localObject = this.sCV.sDl;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.sCV.context.getResources().getColor(d.b.BW_100_Alpha_0_9));
      }
      localObject = this.sCV.sDf;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.sCW.aaBx)
      {
        localObject = this.sCV.sDe;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.sCV.context.getResources().getColor(d.b.white_text_color));
        }
      }
      this.sCV.a(paramz, paramView);
      AppMethodBeat.o(267018);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.d
 * JD-Core Version:    0.7.0.1
 */