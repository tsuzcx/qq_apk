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
import com.tencent.mm.al.ag;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final a.a ohX;
  private final w ogW;
  private final b ohW;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  private final int pos;
  
  static
  {
    AppMethodBeat.i(6546);
    ohX = new a.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public a(Context paramContext, w paramw, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.ogW = paramw;
    this.ohs = paramb;
    this.pos = paramInt;
    a(new b.a[] { b.a.Luz, b.a.Lux });
    paramw = new BubbleLayout(paramContext);
    paramw.setBubbleColor(paramContext.getResources().getColor(2131099666));
    paramw.setBubbleRadius(com.tencent.mm.cb.a.fromDPToPix(paramContext, 8));
    paramw.setShadowColor(0);
    paramw.setLookWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    paramw.setLookLength(com.tencent.mm.cb.a.fromDPToPix(paramContext, 7));
    a(paramw);
    paramb = LayoutInflater.from(paramContext).inflate(2131493216, null);
    p.g(paramb, "rootView");
    this.ohW = new b(paramb);
    paramw = paramb.findViewById(2131298771);
    p.g(paramw, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cb.a.iu(paramContext);
    int i = com.tencent.mm.cb.a.iv(paramContext);
    Object localObject1 = paramw.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cb.a.fromDPToPix(paramContext, 82));
      paramw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.ogW;
      paramw = new ArrayList();
      paramContext = ((w)localObject1).ftk();
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HTQ;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HTM;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.HTP;
      if (paramContext == null) {
        break label371;
      }
    }
    label371:
    for (paramContext = paramContext.Gcm;; paramContext = null)
    {
      localObject2 = ((w)localObject1).ftk();
      if (localObject2 == null) {
        p.gkB();
      }
      localObject2 = ((dmq)localObject2).HTR;
      if (bu.ht((List)paramContext)) {
        break label376;
      }
      paramInt = 0;
      if (paramContext == null) {
        p.gkB();
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
    this.ohW.ohY.a((List)paramw, (LabelsView.a)c.oia);
    this.ohW.ohY.fQP();
    this.ohW.ohY.setOnLabelClickListener((LabelsView.b)new d(this));
    paramContext = "";
    Object localObject2 = ((Iterable)paramw).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      paramw = paramContext;
      if (!bu.isNullOrNil(paramContext)) {
        paramw = paramContext + "#";
      }
      paramContext = paramw + localb.getName();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(18644, new Object[] { ((w)localObject1).ftj().HTL.nIJ, Long.valueOf(((w)localObject1).ftk().HDI), paramContext, Integer.valueOf(y.getSessionId()), Integer.valueOf(this.pos) });
    hi(paramb);
    this.ohW.gXc.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    p.h(paramView, "v");
    if (paramView.getId() == 2131302999)
    {
      Object localObject2 = this.ohW.ohY.getSelectLabelDatas();
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
          if (!bu.isNullOrNil(paramView)) {
            localObject1 = paramView + "#";
          }
          paramView = new StringBuilder().append((String)localObject1);
          p.g(localb, "tag");
          paramView = localb.getName();
        }
      }
      this.ohs.ogr.f(this.ogW.ftj().HTL.nIJ, this.ogW.ftk().HDI, (String)localObject1);
      ag.aGv().DU(this.ogW.field_msgId);
      dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6544);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button gXc;
    LabelsView ohY;
    private TextView ohZ;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(2131302999);
      p.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.gXc = ((Button)localView);
      localView = paramView.findViewById(2131305628);
      p.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.ohY = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297297);
      p.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.ohZ = ((TextView)paramView);
      paramView = this.ohZ.getPaint();
      p.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<b>
  {
    public static final c oia;
    
    static
    {
      AppMethodBeat.i(6542);
      oia = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(a parama) {}
    
    public final void bPu()
    {
      AppMethodBeat.i(6543);
      Button localButton = a.a(this.oib).gXc;
      if (a.a(this.oib).ohY.getSelectLabels().size() > 0) {}
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