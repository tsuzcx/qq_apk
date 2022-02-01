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
import com.tencent.mm.ao.af;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class b
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final b.a sCM;
  private final int pos;
  private final z sBt;
  private final b sCL;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  
  static
  {
    AppMethodBeat.i(6546);
    sCM = new b.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public b(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.sBt = paramz;
    this.sCg = paramb;
    this.pos = paramInt;
    a(new com.tencent.mm.ui.widget.happybubble.b.a[] { com.tencent.mm.ui.widget.happybubble.b.a.YoS, com.tencent.mm.ui.widget.happybubble.b.a.YoQ });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(d.b.BW_100));
    paramz.setBubbleRadius(com.tencent.mm.ci.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.ci.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(d.f.stV, null);
    p.j(paramb, "rootView");
    this.sCL = new b(paramb);
    paramz = paramb.findViewById(d.e.srK);
    p.j(paramz, "rootView.findViewById(R.id.content_root_layout)");
    Object localObject1 = com.tencent.mm.plugin.bizui.a.a.shG;
    paramInt = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
    int i = com.tencent.mm.ci.a.ks(paramContext);
    localObject1 = paramz.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.ci.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.sBt;
      paramz = new ArrayList();
      paramContext = ((z)localObject1).hwL();
      if (paramContext == null) {
        break label379;
      }
      paramContext = paramContext.UsD;
      if (paramContext == null) {
        break label379;
      }
      paramContext = paramContext.Usz;
      if (paramContext == null) {
        break label379;
      }
      paramContext = paramContext.UsC;
      if (paramContext == null) {
        break label379;
      }
    }
    label379:
    for (paramContext = paramContext.RXF;; paramContext = null)
    {
      localObject2 = ((z)localObject1).hwL();
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((eqg)localObject2).UsE;
      if (Util.isNullOrNil((List)paramContext)) {
        break label384;
      }
      paramInt = 0;
      if (paramContext == null) {
        p.iCn();
      }
      i = ((Collection)paramContext).size();
      while (paramInt < i)
      {
        paramz.add(new c((String)paramContext.get(paramInt), paramInt));
        paramInt += 1;
      }
      paramInt = i;
      break;
    }
    label384:
    paramInt = 0;
    p.j(localObject2, "negativeFeedbackReason");
    i = ((Collection)localObject2).size();
    while (paramInt < i)
    {
      paramz.add(new c((String)((LinkedList)localObject2).get(paramInt), paramInt));
      paramInt += 1;
    }
    this.sCL.sCN.a((List)paramz, (LabelsView.a)c.sCP);
    this.sCL.sCN.icV();
    this.sCL.sCN.setOnLabelClickListener((LabelsView.b)new d(this));
    paramContext = "";
    Object localObject2 = ((Iterable)paramz).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      c localc = (c)((Iterator)localObject2).next();
      paramz = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramz = paramContext + "#";
      }
      paramContext = paramz + localc.getName();
    }
    h.IzE.a(18644, new Object[] { ((z)localObject1).hwK().Usy.UserName, Long.valueOf(((z)localObject1).hwL().Uaw), paramContext, Integer.valueOf(ab.getSessionId()), Integer.valueOf(this.pos) });
    iN(paramb);
    this.sCL.kEt.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.k(paramView, "v");
    if (paramView.getId() == d.e.ok_btn)
    {
      Object localObject2 = this.sCL.sCN.getSelectLabelDatas();
      paramView = "";
      localObject1 = paramView;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          localObject1 = paramView;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          c localc = (c)((Iterator)localObject2).next();
          localObject1 = paramView;
          if (!Util.isNullOrNil(paramView)) {
            localObject1 = paramView + "#";
          }
          paramView = new StringBuilder().append((String)localObject1);
          p.j(localc, "tag");
          paramView = localc.getName();
        }
      }
      this.sCg.szZ.f(this.sBt.hwK().Usy.UserName, this.sBt.hwL().Uaw, (String)localObject1);
      af.bjB().UI(this.sBt.field_msgId);
      dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6544);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button kEt;
    LabelsView sCN;
    private TextView sCO;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(d.e.ok_btn);
      p.j(localView, "rootView.findViewById(R.id.ok_btn)");
      this.kEt = ((Button)localView);
      localView = paramView.findViewById(d.e.std);
      p.j(localView, "rootView.findViewById(R.id.tag_layout)");
      this.sCN = ((LabelsView)localView);
      paramView = paramView.findViewById(d.e.sqi);
      p.j(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.sCO = ((TextView)paramView);
      paramView = this.sCO.getPaint();
      p.j(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<c>
  {
    public static final c sCP;
    
    static
    {
      AppMethodBeat.i(6542);
      sCP = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(b paramb) {}
    
    public final void n(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(266838);
      paramObject = b.a(this.sCQ).kEt;
      if (b.a(this.sCQ).sCN.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(266838);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.b
 * JD-Core Version:    0.7.0.1
 */