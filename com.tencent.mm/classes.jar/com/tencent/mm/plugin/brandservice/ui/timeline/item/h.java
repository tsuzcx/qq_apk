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
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.p.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.mr;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "recCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getRecCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class h
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private final z psm;
  private final int ptN;
  private final a puf;
  private final dkr pug;
  
  public h(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(195281);
    this.psm = paramz;
    this.psQ = paramb;
    this.ptN = paramInt;
    paramz = this.psm.NQr;
    kotlin.g.b.p.g(paramz, "info.recFeed");
    this.pug = paramz;
    a(new b.a[] { b.a.QQh, b.a.QQf });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(2131099672));
    paramz.setBubbleRadius(com.tencent.mm.cb.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.cb.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(2131493277, null);
    kotlin.g.b.p.g(paramb, "rootView");
    this.puf = new a(paramb);
    paramz = paramb.findViewById(2131299215);
    kotlin.g.b.p.g(paramz, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cb.a.jn(paramContext);
    int j = com.tencent.mm.cb.a.jo(paramContext);
    Object localObject = paramz.getLayoutParams();
    if (paramInt < j) {}
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = (paramInt - com.tencent.mm.cb.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramContext = new LinkedList();
      paramz = this.pug.KWr;
      if (paramz == null) {
        break;
      }
      paramz = ((Iterable)paramz).iterator();
      paramInt = i;
      while (paramz.hasNext())
      {
        localObject = paramz.next();
        if (paramInt < 0) {
          j.hxH();
        }
        paramContext.add(new c((String)localObject, paramInt));
        paramInt += 1;
      }
      paramInt = j;
    }
    this.puf.ptA.a((List)paramContext, (LabelsView.a)b.puh);
    this.puf.ptA.hbO();
    this.puf.ptA.setOnLabelClickListener((LabelsView.b)new c(this));
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
    hx(paramb);
    this.puf.hPX.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(195281);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195280);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    kotlin.g.b.p.h(paramView, "v");
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject3;
    long l;
    int i;
    if (paramView.getId() == 2131305592)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.puf.ptA.getSelectLabelDatas();
      paramView = "";
      if (localObject1 == null) {
        break label529;
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
        kotlin.g.b.p.g(localObject3, "tag");
        paramView = ((c)localObject3).getName();
        localLinkedList.add(((c)localObject3).getName());
      }
      localObject2 = (dlb)this.pug.MOG.get(0);
      localObject3 = ((dlb)localObject2).MOY;
      localObject1 = ((dlb)localObject2).MOX;
      localObject3 = ((cdu)localObject3).KSj;
      kotlin.g.b.p.g(localObject3, "appMsg.ContentUrl");
      localObject3 = af.bjc((String)localObject3);
      l = Util.getLong(localObject3[0], 0L);
      i = Util.getInt(localObject3[1], 0);
      localObject3 = this.psQ.pqZ;
      if (localObject1 == null) {
        break label536;
      }
    }
    label529:
    label536:
    for (localObject1 = ((mr)localObject1).UserName;; localObject1 = null)
    {
      ((f)localObject3).a((String)localObject1, l, i, paramView, this.pug.KUk, this.pug.KUh, ((dlb)localObject2).KWw, af.G(this.psm));
      paramView = com.tencent.mm.model.p.iCa;
      paramView = this.psm;
      kotlin.g.b.p.h(paramView, "info");
      kotlin.g.b.p.h(localLinkedList, "negativeFeedbackReason");
      localObject1 = new d.a();
      localObject2 = new dkv();
      ((dkv)localObject2).MaI = new LinkedList();
      localObject3 = ((dkv)localObject2).MaI;
      dkq localdkq = new dkq();
      localdkq.KWr = localLinkedList;
      localdkq.KWA = paramView.NQr.KWA;
      localdkq.MOF = paramView.field_orderFlag;
      ((LinkedList)localObject3).add(localdkq);
      ((d.a)localObject1).c((com.tencent.mm.bw.a)localObject2);
      ((d.a)localObject1).d((com.tencent.mm.bw.a)new bub());
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/timeline/recommendfeedsfeedback");
      ((d.a)localObject1).sG(5198);
      aa.a(((d.a)localObject1).aXF(), (aa.a)p.a.b.iCe);
      this.psQ.c(this.psm);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195280);
      return;
      paramView = "";
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button hPX;
    LabelsView ptA;
    private TextView ptB;
    
    public a(View paramView)
    {
      AppMethodBeat.i(195276);
      View localView = paramView.findViewById(2131305592);
      kotlin.g.b.p.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.hPX = ((Button)localView);
      localView = paramView.findViewById(2131308869);
      kotlin.g.b.p.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.ptA = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297499);
      kotlin.g.b.p.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.ptB = ((TextView)paramView);
      paramView = this.ptB.getPaint();
      kotlin.g.b.p.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(195276);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<c>
  {
    public static final b puh;
    
    static
    {
      AppMethodBeat.i(195278);
      puh = new b();
      AppMethodBeat.o(195278);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(h paramh) {}
    
    public final void j(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(195279);
      paramObject = h.a(this.pui).hPX;
      if (h.a(this.pui).ptA.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(195279);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.h
 * JD-Core Version:    0.7.0.1
 */