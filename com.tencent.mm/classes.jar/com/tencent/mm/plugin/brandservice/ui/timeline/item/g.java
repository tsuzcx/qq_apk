package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getVideoViewContainer", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"})
public final class g
  extends f
{
  private ImageView bwJ;
  private ImageView sCR;
  private final v sCU;
  TextView sDo;
  View sDp;
  private View sDq;
  
  public g(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(266586);
    this.sCU = new v();
    AppMethodBeat.o(266586);
  }
  
  public final void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(266585);
    p.k(paramView, "parent");
    if (getItemView() == null)
    {
      super.W(paramView, paramInt);
      Object localObject = getItemView();
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(d.e.cover); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(266585);
        throw paramView;
      }
      this.sCR = ((ImageView)localObject);
      localObject = getItemView();
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(d.e.video_icon); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(266585);
        throw paramView;
      }
      this.bwJ = ((ImageView)localObject);
      localObject = getItemView();
      if (localObject != null) {}
      for (localObject = (TextView)((View)localObject).findViewById(d.e.sss); localObject == null; localObject = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(266585);
        throw paramView;
      }
      this.sDo = ((TextView)localObject);
      localObject = getItemView();
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(d.e.dzy);
        this.sDp = ((View)localObject);
        localObject = getItemView();
        if (localObject == null) {
          break label282;
        }
        localObject = ((View)localObject).findViewById(d.e.stn);
        label216:
        this.sDq = ((View)localObject);
        cAo();
        dR(paramView.findViewById(d.e.srA));
        paramView = getItemView();
        if (paramView == null) {
          break label287;
        }
      }
      label282:
      label287:
      for (paramView = (MMNeat7extView)paramView.findViewById(d.e.title_tv);; paramView = null)
      {
        if (paramView != null) {
          break label292;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(266585);
        throw paramView;
        localObject = null;
        break;
        localObject = null;
        break label216;
      }
      label292:
      this.sDe = paramView;
      paramView = getItemView();
      if (paramView != null) {}
      for (paramView = (ImageView)paramView.findViewById(d.e.dRn); paramView == null; paramView = null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(266585);
        throw paramView;
      }
      this.sDf = paramView;
      paramView = getItemView();
      if (paramView == null) {
        break label454;
      }
      paramView = (LinearLayout)paramView.findViewById(d.e.srq);
      a(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label459;
      }
      paramView = (LinearLayout)paramView.findViewById(d.e.ssV);
      label393:
      b(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label464;
      }
      paramView = (MMNeat7extView)paramView.findViewById(d.e.ssT);
      label418:
      c(paramView);
      paramView = getItemView();
      if (paramView == null) {
        break label469;
      }
    }
    label454:
    label459:
    label464:
    label469:
    for (paramView = (MMNeat7extView)paramView.findViewById(d.e.dVp);; paramView = null)
    {
      d(paramView);
      AppMethodBeat.o(266585);
      return;
      paramView = null;
      break;
      paramView = null;
      break label393;
      paramView = null;
      break label418;
    }
  }
  
  public final void a(View paramView, final z paramz, pf parampf)
  {
    AppMethodBeat.i(266583);
    p.k(paramView, "parent");
    p.k(paramz, "info");
    p.k(parampf, "bizInfo");
    W(paramView, d.e.dZA);
    if (getItemView() == null)
    {
      AppMethodBeat.o(266583);
      return;
    }
    paramView = getItemView();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    final pe localpe = (pe)parampf.RXM.get(0);
    p.j(localpe, "appMsg");
    a(paramz, parampf, localpe);
    float f = 0.5F;
    paramView = this.sDe;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramView = com.tencent.mm.plugin.bizui.a.a.shG;
      i = com.tencent.mm.plugin.bizui.a.a.eO(this.context);
      j = com.tencent.mm.ci.a.fromDPToPix(this.context, 48);
      paramView = this.sDe;
      if (paramView != null) {
        paramView.measure(i - j, 0);
      }
      paramView = this.sDp;
      if (paramView == null) {
        p.iCn();
      }
      i = paramView.getLayoutParams().height;
      paramView = this.sDe;
      if (paramView == null) {
        p.iCn();
      }
      j = paramView.getMeasuredHeight();
      int k = b.sAA;
      f = 0.56F;
      i = i - j - k;
      if (this.sDq == null) {
        break label307;
      }
      paramView = this.sDq;
      if (paramView == null) {
        break label275;
      }
    }
    label275:
    for (paramView = paramView.getLayoutParams();; paramView = null)
    {
      if (paramView != null) {
        break label280;
      }
      paramView = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(266583);
      throw paramView;
      paramView = this.sDp;
      if (paramView == null) {
        p.iCn();
      }
      i = paramView.getLayoutParams().height;
      break;
    }
    label280:
    ((RelativeLayout.LayoutParams)paramView).topMargin = ((int)(i * f - com.tencent.mm.ci.a.fromDPToPix(this.context, 48) / 2));
    label307:
    paramView = m.uD(localpe.RTy);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)paramView))
    {
      localObject1 = this.sDo;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.sDo;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramView);
      }
      paramView = this.sDo;
      if (paramView != null) {
        paramView.setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
      }
    }
    label526:
    Object localObject2;
    for (;;)
    {
      paramView = this.sDo;
      if (paramView != null) {
        paramView.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(d.b.BW_0_Alpha_0_5));
      }
      localObject1 = new aa.a();
      ((aa.a)localObject1).aaBx = false;
      switch (paramz.hwL().style)
      {
      default: 
        this.sCU.type = localpe.lpx;
        this.sCU.lpK = localpe.RTm;
        this.sCU.lqb = localpe.RTm;
        this.sCU.url = localpe.RTk;
        paramView = this.sDp;
        if (paramView == null) {
          break label835;
        }
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
          paramView.height = b.sAq;
        }
        localObject2 = this.sDp;
        if (localObject2 != null) {
          ((View)localObject2).setLayoutParams(paramView);
        }
        paramView = com.tencent.mm.plugin.bizui.a.a.shG;
        i = com.tencent.mm.plugin.bizui.a.a.eO(this.context);
        j = b.sAu;
        this.sCg.sAc.a(paramz.field_msgId, 0, this.sCU, localpe.RTm, this.sCR, i - j, b.sAq, false, (m.a)new a(this, (aa.a)localObject1, paramz, localpe), false, paramz.sHe);
        b(paramz, parampf, localpe);
        paramView = e.sKW;
        e.G(this.sCU.url, this.sCU.type, "");
        AppMethodBeat.o(266583);
        return;
        paramView = this.sDo;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        break;
      }
    }
    if (parampf.RXM.size() <= 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((aa.a)localObject1).aaBx = bool;
      break;
    }
    paramView = paramz.hwL().UsF.RVd;
    p.j(paramView, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView = (Iterable)j.c((Iterable)paramView, 2);
    int j = 0;
    paramView = paramView.iterator();
    int i = 0;
    label759:
    if (paramView.hasNext())
    {
      localObject2 = paramView.next();
      if (j < 0) {
        j.iBO();
      }
      if (((pf)localObject2).RIs != 0) {
        break label840;
      }
      i += 1;
    }
    label835:
    label840:
    for (;;)
    {
      j += 1;
      break label759;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        ((aa.a)localObject1).aaBx = bool;
        break;
      }
      paramView = null;
      break label526;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    a(aa.a parama, z paramz, pe parampe) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(265140);
      Object localObject = this.sDr.sDl;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.sDr.context.getResources().getColor(d.b.BW_100_Alpha_0_9));
      }
      localObject = this.sDr.sDf;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.sCW.aaBx)
      {
        localObject = this.sDr.sDe;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.sDr.context.getResources().getColor(d.b.white_text_color));
        }
      }
      this.sDr.a(paramz, localpe);
      localObject = this.sDr.sDo;
      if (localObject != null)
      {
        ((TextView)localObject).setTextColor(this.sDr.context.getResources().getColor(d.b.white_text_color));
        AppMethodBeat.o(265140);
        return;
      }
      AppMethodBeat.o(265140);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.g
 * JD-Core Version:    0.7.0.1
 */