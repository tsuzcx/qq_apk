package com.tencent.mm.plugin.brandservice.ui.timeline.a;

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
import com.tencent.mm.al.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import com.tencent.mm.ui.widget.happybubble.b.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final a.a nAZ;
  private final b nAY;
  private final t nAa;
  private final c nAv;
  private final int pos;
  
  static
  {
    AppMethodBeat.i(6546);
    nAZ = new a.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public a(Context paramContext, t paramt, c paramc, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.nAa = paramt;
    this.nAv = paramc;
    this.pos = paramInt;
    a(new b.a[] { b.a.JgN, b.a.JgL });
    paramt = new BubbleLayout(paramContext);
    paramt.setBubbleColor(paramContext.getResources().getColor(2131099666));
    paramt.setBubbleRadius(com.tencent.mm.cc.a.fromDPToPix(paramContext, 8));
    paramt.setShadowColor(0);
    paramt.setLookWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    paramt.setLookLength(com.tencent.mm.cc.a.fromDPToPix(paramContext, 7));
    a(paramt);
    paramc = LayoutInflater.from(paramContext).inflate(2131493216, null);
    k.g(paramc, "rootView");
    this.nAY = new b(paramc);
    paramt = paramc.findViewById(2131298771);
    k.g(paramt, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cc.a.ig(paramContext);
    int i = com.tencent.mm.cc.a.ih(paramContext);
    Object localObject1 = paramt.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cc.a.fromDPToPix(paramContext, 82));
      paramt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.nAa;
      paramt = new ArrayList();
      paramContext = ((t)localObject1).eZq();
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.FPB;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.FPt;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.FPA;
      if (paramContext == null) {
        break label371;
      }
    }
    label371:
    for (paramContext = paramContext.EDf;; paramContext = null)
    {
      localObject2 = ((t)localObject1).eZq();
      if (localObject2 == null) {
        k.fOy();
      }
      localObject2 = ((dgg)localObject2).FPD;
      if (bs.gY((List)paramContext)) {
        break label376;
      }
      paramInt = 0;
      if (paramContext == null) {
        k.fOy();
      }
      i = ((Collection)paramContext).size();
      while (paramInt < i)
      {
        paramt.add(new b((String)paramContext.get(paramInt), paramInt));
        paramInt += 1;
      }
      paramInt = i;
      break;
    }
    label376:
    paramInt = 0;
    k.g(localObject2, "negativeFeedbackReason");
    i = ((Collection)localObject2).size();
    while (paramInt < i)
    {
      paramt.add(new b((String)((LinkedList)localObject2).get(paramInt), paramInt));
      paramInt += 1;
    }
    this.nAY.nBa.a((List)paramt, (LabelsView.a)c.nBc);
    this.nAY.nBa.fvH();
    this.nAY.nBa.setOnLabelClickListener((LabelsView.b)new d(this));
    paramContext = "";
    Object localObject2 = ((Iterable)paramt).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      paramt = paramContext;
      if (!bs.isNullOrNil(paramContext)) {
        paramt = paramContext + "#";
      }
      paramContext = paramt + localb.getName();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(18644, new Object[] { ((t)localObject1).eZp().FPo.ncR, Long.valueOf(((t)localObject1).eZq().FPC), paramContext, Integer.valueOf(v.getSessionId()), Integer.valueOf(this.pos) });
    gM(paramc);
    this.nAY.gAJ.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    k.h(paramView, "v");
    if (paramView.getId() == 2131302999)
    {
      Object localObject2 = this.nAY.nBa.getSelectLabelDatas();
      paramView = "";
      Object localObject1 = paramView;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          localObject1 = paramView;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          b localb = (b)((Iterator)localObject2).next();
          localObject1 = paramView;
          if (!bs.isNullOrNil(paramView)) {
            localObject1 = paramView + "#";
          }
          paramView = new StringBuilder().append((String)localObject1);
          k.g(localb, "tag");
          paramView = localb.getName();
        }
      }
      this.nAv.nzw.f(this.nAa.eZp().FPo.ncR, this.nAa.eZq().FPC, (String)localObject1);
      af.aDc().AF(this.nAa.field_msgId);
      dismiss();
    }
    AppMethodBeat.o(6544);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button gAJ;
    LabelsView nBa;
    private TextView nBb;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(2131302999);
      k.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.gAJ = ((Button)localView);
      localView = paramView.findViewById(2131305628);
      k.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.nBa = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297297);
      k.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.nBb = ((TextView)paramView);
      paramView = this.nBb.getPaint();
      k.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<b>
  {
    public static final c nBc;
    
    static
    {
      AppMethodBeat.i(6542);
      nBc = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(a parama) {}
    
    public final void bKc()
    {
      AppMethodBeat.i(6543);
      Button localButton = a.a(this.nBd).gAJ;
      if (a.a(this.nBd).nBa.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(6543);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */