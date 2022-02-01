package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.model.p.a.b;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import com.tencent.mm.ui.widget.happybubble.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "recCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getRecCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class h
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final z sBt;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private final int sDa;
  private final a sDs;
  private final dug sDt;
  
  public h(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(258995);
    this.sBt = paramz;
    this.sCg = paramb;
    this.sDa = paramInt;
    paramz = this.sBt.Ven;
    kotlin.g.b.p.j(paramz, "info.recFeed");
    this.sDt = paramz;
    a(new b.a[] { b.a.YoS, b.a.YoQ });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(d.b.BW_100));
    paramz.setBubbleRadius(com.tencent.mm.ci.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.ci.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(d.f.stV, null);
    kotlin.g.b.p.j(paramb, "rootView");
    this.sDs = new a(paramb);
    paramz = paramb.findViewById(d.e.srK);
    kotlin.g.b.p.j(paramz, "rootView.findViewById(R.id.content_root_layout)");
    Object localObject = com.tencent.mm.plugin.bizui.a.a.shG;
    paramInt = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
    int j = com.tencent.mm.ci.a.ks(paramContext);
    localObject = paramz.getLayoutParams();
    if (paramInt < j) {}
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = (paramInt - com.tencent.mm.ci.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramContext = new LinkedList();
      paramz = this.sDt.RXF;
      if (paramz == null) {
        break;
      }
      paramz = ((Iterable)paramz).iterator();
      paramInt = i;
      while (paramz.hasNext())
      {
        localObject = paramz.next();
        if (paramInt < 0) {
          j.iBO();
        }
        paramContext.add(new c((String)localObject, paramInt));
        paramInt += 1;
      }
      paramInt = j;
    }
    this.sDs.sCN.a((List)paramContext, (LabelsView.a)b.sDu);
    this.sDs.sCN.icV();
    this.sDs.sCN.setOnLabelClickListener((LabelsView.b)new c(this));
    localObject = ((Iterable)paramContext).iterator();
    c localc;
    for (paramContext = ""; ((Iterator)localObject).hasNext(); paramContext = paramz + localc.getName())
    {
      localc = (c)((Iterator)localObject).next();
      paramz = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramz = paramContext + "#";
      }
    }
    iN(paramb);
    this.sDs.kEt.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(258995);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258993);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    kotlin.g.b.p.k(paramView, "v");
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject3;
    long l;
    int i;
    if (paramView.getId() == d.e.ok_btn)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.sDs.sCN.getSelectLabelDatas();
      paramView = "";
      if (localObject1 == null) {
        break label551;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c)((Iterator)localObject2).next();
        localObject1 = paramView;
        if (!Util.isNullOrNil(paramView)) {
          localObject1 = paramView + "#";
        }
        paramView = new StringBuilder().append((String)localObject1);
        kotlin.g.b.p.j(localObject3, "tag");
        paramView = ((c)localObject3).getName();
        localLinkedList.add(((c)localObject3).getName());
      }
      localObject2 = (dur)this.sDt.UaA.get(0);
      localObject3 = ((dur)localObject2).UaX;
      localObject1 = ((dur)localObject2).UaW;
      localObject3 = ((cmo)localObject3).RTk;
      kotlin.g.b.p.j(localObject3, "appMsg.ContentUrl");
      localObject3 = af.bvx((String)localObject3);
      l = Util.getLong(localObject3[0], 0L);
      i = Util.getInt(localObject3[1], 0);
      localObject3 = this.sCg.szZ;
      if (localObject1 == null) {
        break label558;
      }
    }
    label551:
    label558:
    for (localObject1 = ((mh)localObject1).UserName;; localObject1 = null)
    {
      ((f)localObject3).a((String)localObject1, l, i, paramView, this.sDt.RVi, this.sDt.RVf, ((dur)localObject2).RXK, af.L(this.sBt));
      paramView = com.tencent.mm.model.p.lrH;
      paramView = this.sBt;
      kotlin.g.b.p.k(paramView, "info");
      kotlin.g.b.p.k(localLinkedList, "negativeFeedbackReason");
      localObject1 = new d.a();
      localObject2 = new dul();
      ((dul)localObject2).Tkd = new LinkedList();
      localObject3 = ((dul)localObject2).Tkd;
      duf localduf = new duf();
      localduf.RXF = localLinkedList;
      localduf.RXO = paramView.Ven.RXO;
      localduf.Uaz = paramView.field_orderFlag;
      ((LinkedList)localObject3).add(localduf);
      ((d.a)localObject1).c((com.tencent.mm.cd.a)localObject2);
      ((d.a)localObject1).d((com.tencent.mm.cd.a)new cbt());
      ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/timeline/recommendfeedsfeedback");
      ((d.a)localObject1).vD(5198);
      aa.a(((d.a)localObject1).bgN(), (aa.a)p.a.b.lrO);
      paramView = this.sCg;
      localObject1 = this.sBt;
      kotlin.g.b.p.k(localObject1, "info");
      Log.i("MicroMsg.BizTimeLineAdapter", "onFeedBack");
      paramView.c((z)localObject1);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(258993);
      return;
      paramView = "";
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button kEt;
    LabelsView sCN;
    private TextView sCO;
    
    public a(View paramView)
    {
      AppMethodBeat.i(265646);
      View localView = paramView.findViewById(d.e.ok_btn);
      kotlin.g.b.p.j(localView, "rootView.findViewById(R.id.ok_btn)");
      this.kEt = ((Button)localView);
      localView = paramView.findViewById(d.e.std);
      kotlin.g.b.p.j(localView, "rootView.findViewById(R.id.tag_layout)");
      this.sCN = ((LabelsView)localView);
      paramView = paramView.findViewById(d.e.sqi);
      kotlin.g.b.p.j(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.sCO = ((TextView)paramView);
      paramView = this.sCO.getPaint();
      kotlin.g.b.p.j(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(265646);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<c>
  {
    public static final b sDu;
    
    static
    {
      AppMethodBeat.i(259774);
      sDu = new b();
      AppMethodBeat.o(259774);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(h paramh) {}
    
    public final void n(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(258865);
      paramObject = h.a(this.sDv).kEt;
      if (h.a(this.sDv).sCN.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(258865);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.h
 * JD-Core Version:    0.7.0.1
 */