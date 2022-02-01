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
import com.tencent.mm.am.ag;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import com.tencent.mm.ui.widget.happybubble.b.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final a.a oci;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  private final w obf;
  private final b och;
  private final int pos;
  
  static
  {
    AppMethodBeat.i(6546);
    oci = new a.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public a(Context paramContext, w paramw, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.obf = paramw;
    this.obC = paramb;
    this.pos = paramInt;
    a(new b.a[] { b.a.KYb, b.a.KXZ });
    paramw = new BubbleLayout(paramContext);
    paramw.setBubbleColor(paramContext.getResources().getColor(2131099666));
    paramw.setBubbleRadius(com.tencent.mm.cc.a.fromDPToPix(paramContext, 8));
    paramw.setShadowColor(0);
    paramw.setLookWidth(com.tencent.mm.cc.a.fromDPToPix(paramContext, 14));
    paramw.setLookLength(com.tencent.mm.cc.a.fromDPToPix(paramContext, 7));
    a(paramw);
    paramb = LayoutInflater.from(paramContext).inflate(2131493216, null);
    p.g(paramb, "rootView");
    this.och = new b(paramb);
    paramw = paramb.findViewById(2131298771);
    p.g(paramw, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cc.a.ip(paramContext);
    int i = com.tencent.mm.cc.a.iq(paramContext);
    Object localObject1 = paramw.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cc.a.fromDPToPix(paramContext, 82));
      paramw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.obf;
      paramw = new ArrayList();
      paramContext = ((w)localObject1).fpm();
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HAd;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HzZ;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HAc;
      if (paramContext == null) {
        break label371;
      }
    }
    label371:
    for (paramContext = paramContext.FJN;; paramContext = null)
    {
      localObject2 = ((w)localObject1).fpm();
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject2 = ((dlt)localObject2).HAe;
      if (bt.hj((List)paramContext)) {
        break label376;
      }
      paramInt = 0;
      if (paramContext == null) {
        p.gfZ();
      }
      i = ((Collection)paramContext).size();
      while (paramInt < i)
      {
        paramw.add(new b((String)paramContext.get(paramInt), paramInt));
        paramInt += 1;
      }
      paramInt = i;
      break;
    }
    label376:
    paramInt = 0;
    p.g(localObject2, "negativeFeedbackReason");
    i = ((Collection)localObject2).size();
    while (paramInt < i)
    {
      paramw.add(new b((String)((LinkedList)localObject2).get(paramInt), paramInt));
      paramInt += 1;
    }
    this.och.ocj.a((List)paramw, (LabelsView.a)c.ocl);
    this.och.ocj.fMv();
    this.och.ocj.setOnLabelClickListener((LabelsView.b)new d(this));
    paramContext = "";
    Object localObject2 = ((Iterable)paramw).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      paramw = paramContext;
      if (!bt.isNullOrNil(paramContext)) {
        paramw = paramContext + "#";
      }
      paramContext = paramw + localb.getName();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(18644, new Object[] { ((w)localObject1).fpl().HzY.nDo, Long.valueOf(((w)localObject1).fpm().Hki), paramContext, Integer.valueOf(y.getSessionId()), Integer.valueOf(this.pos) });
    hd(paramb);
    this.och.gUt.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    p.h(paramView, "v");
    if (paramView.getId() == 2131302999)
    {
      Object localObject2 = this.och.ocj.getSelectLabelDatas();
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
          b localb = (b)((Iterator)localObject2).next();
          localObject1 = paramView;
          if (!bt.isNullOrNil(paramView)) {
            localObject1 = paramView + "#";
          }
          paramView = new StringBuilder().append((String)localObject1);
          p.g(localb, "tag");
          paramView = localb.getName();
        }
      }
      this.obC.oaB.f(this.obf.fpl().HzY.nDo, this.obf.fpm().Hki, (String)localObject1);
      ag.aGf().Dv(this.obf.field_msgId);
      dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6544);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button gUt;
    LabelsView ocj;
    private TextView ock;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(2131302999);
      p.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.gUt = ((Button)localView);
      localView = paramView.findViewById(2131305628);
      p.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.ocj = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297297);
      p.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.ock = ((TextView)paramView);
      paramView = this.ock.getPaint();
      p.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<b>
  {
    public static final c ocl;
    
    static
    {
      AppMethodBeat.i(6542);
      ocl = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(a parama) {}
    
    public final void bOw()
    {
      AppMethodBeat.i(6543);
      Button localButton = a.a(this.ocm).gUt;
      if (a.a(this.ocm).ocj.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(6543);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.a
 * JD-Core Version:    0.7.0.1
 */