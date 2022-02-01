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
import com.tencent.mm.am.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class a
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final a.a mYA;
  private final s mXB;
  private final c mXW;
  private final b mYz;
  private final int pos;
  
  static
  {
    AppMethodBeat.i(6546);
    mYA = new a.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public a(Context paramContext, s params, c paramc, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.mXB = params;
    this.mXW = paramc;
    this.pos = paramInt;
    a(new b.a[] { b.a.HGq, b.a.HGo });
    params = new BubbleLayout(paramContext);
    params.setBubbleColor(paramContext.getResources().getColor(2131099666));
    params.setBubbleRadius(com.tencent.mm.cd.a.fromDPToPix(paramContext, 8));
    params.setShadowColor(0);
    params.setLookWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    params.setLookLength(com.tencent.mm.cd.a.fromDPToPix(paramContext, 7));
    a(params);
    paramc = LayoutInflater.from(paramContext).inflate(2131493216, null);
    k.g(paramc, "rootView");
    this.mYz = new b(paramc);
    params = paramc.findViewById(2131298771);
    k.g(params, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cd.a.hV(paramContext);
    int i = com.tencent.mm.cd.a.hW(paramContext);
    Object localObject1 = params.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cd.a.fromDPToPix(paramContext, 82));
      params.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.mXB;
      params = new ArrayList();
      paramContext = ((s)localObject1).eJS();
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.Esz;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.Esr;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.Esy;
      if (paramContext == null) {
        break label371;
      }
    }
    label371:
    for (paramContext = paramContext.DjZ;; paramContext = null)
    {
      localObject2 = ((s)localObject1).eJS();
      if (localObject2 == null) {
        k.fvU();
      }
      localObject2 = ((dau)localObject2).EsB;
      if (bt.gL((List)paramContext)) {
        break label376;
      }
      paramInt = 0;
      if (paramContext == null) {
        k.fvU();
      }
      i = ((Collection)paramContext).size();
      while (paramInt < i)
      {
        params.add(new b((String)paramContext.get(paramInt), paramInt));
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
      params.add(new b((String)((LinkedList)localObject2).get(paramInt), paramInt));
      paramInt += 1;
    }
    this.mYz.mYB.a((List)params, (LabelsView.a)c.mYD);
    this.mYz.mYB.ffI();
    this.mYz.mYB.setOnLabelClickListener((LabelsView.b)new d(this));
    paramContext = "";
    Object localObject2 = ((Iterable)params).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      params = paramContext;
      if (!bt.isNullOrNil(paramContext)) {
        params = paramContext + "#";
      }
      paramContext = params + localb.getName();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(18644, new Object[] { ((s)localObject1).eJR().Esm.mAQ, Long.valueOf(((s)localObject1).eJS().EsA), paramContext, Integer.valueOf(u.getSessionId()), Integer.valueOf(this.pos) });
    gw(paramc);
    this.mYz.hJh.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    k.h(paramView, "v");
    if (paramView.getId() == 2131302999)
    {
      Object localObject2 = this.mYz.mYB.getSelectLabelDatas();
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
          if (!bt.isNullOrNil(paramView)) {
            localObject1 = paramView + "#";
          }
          paramView = new StringBuilder().append((String)localObject1);
          k.g(localb, "tag");
          paramView = localb.getName();
        }
      }
      this.mXW.mWX.e(this.mXB.eJR().Esm.mAQ, this.mXB.eJS().EsA, (String)localObject1);
      af.awk().wc(this.mXB.field_msgId);
      dismiss();
    }
    AppMethodBeat.o(6544);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button hJh;
    LabelsView mYB;
    private TextView mYC;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(2131302999);
      k.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.hJh = ((Button)localView);
      localView = paramView.findViewById(2131305628);
      k.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.mYB = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297297);
      k.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.mYC = ((TextView)paramView);
      paramView = this.mYC.getPaint();
      k.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<b>
  {
    public static final c mYD;
    
    static
    {
      AppMethodBeat.i(6542);
      mYD = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(a parama) {}
    
    public final void bCU()
    {
      AppMethodBeat.i(6543);
      Button localButton = a.a(this.mYE).hJh;
      if (a.a(this.mYE).mYB.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(6543);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */