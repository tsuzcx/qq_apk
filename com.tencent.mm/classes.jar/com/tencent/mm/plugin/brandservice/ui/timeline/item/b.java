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
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class b
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG = "MicroMsg.BizTimeLineItem";
  public static final b.a ptz;
  private final int pos;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private final z psm;
  private final b pty;
  
  static
  {
    AppMethodBeat.i(6546);
    ptz = new b.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public b(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.psm = paramz;
    this.psQ = paramb;
    this.pos = paramInt;
    a(new com.tencent.mm.ui.widget.happybubble.b.a[] { com.tencent.mm.ui.widget.happybubble.b.a.QQh, com.tencent.mm.ui.widget.happybubble.b.a.QQf });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(2131099672));
    paramz.setBubbleRadius(com.tencent.mm.cb.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.cb.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(2131493277, null);
    p.g(paramb, "rootView");
    this.pty = new b(paramb);
    paramz = paramb.findViewById(2131299215);
    p.g(paramz, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cb.a.jn(paramContext);
    int i = com.tencent.mm.cb.a.jo(paramContext);
    Object localObject1 = paramz.getLayoutParams();
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cb.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.psm;
      paramz = new ArrayList();
      paramContext = ((z)localObject1).gAD();
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.NfY;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.NfU;
      if (paramContext == null) {
        break label371;
      }
      paramContext = paramContext.NfX;
      if (paramContext == null) {
        break label371;
      }
    }
    label371:
    for (paramContext = paramContext.KWr;; paramContext = null)
    {
      localObject2 = ((z)localObject1).gAD();
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((ege)localObject2).NfZ;
      if (Util.isNullOrNil((List)paramContext)) {
        break label376;
      }
      paramInt = 0;
      if (paramContext == null) {
        p.hyc();
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
    label376:
    paramInt = 0;
    p.g(localObject2, "negativeFeedbackReason");
    i = ((Collection)localObject2).size();
    while (paramInt < i)
    {
      paramz.add(new c((String)((LinkedList)localObject2).get(paramInt), paramInt));
      paramInt += 1;
    }
    this.pty.ptA.a((List)paramz, (LabelsView.a)c.ptC);
    this.pty.ptA.hbO();
    this.pty.ptA.setOnLabelClickListener((LabelsView.b)new d(this));
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
    h.CyF.a(18644, new Object[] { ((z)localObject1).gAC().NfT.UserName, Long.valueOf(((z)localObject1).gAD().MOC), paramContext, Integer.valueOf(ab.getSessionId()), Integer.valueOf(this.pos) });
    hx(paramb);
    this.pty.hPX.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(6545);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    p.h(paramView, "v");
    if (paramView.getId() == 2131305592)
    {
      Object localObject2 = this.pty.ptA.getSelectLabelDatas();
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
          p.g(localc, "tag");
          paramView = localc.getName();
        }
      }
      this.psQ.pqZ.f(this.psm.gAC().NfT.UserName, this.psm.gAD().MOC, (String)localObject1);
      ag.ban().MX(this.psm.field_msgId);
      dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6544);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class b
  {
    Button hPX;
    LabelsView ptA;
    private TextView ptB;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
      View localView = paramView.findViewById(2131305592);
      p.g(localView, "rootView.findViewById(R.id.ok_btn)");
      this.hPX = ((Button)localView);
      localView = paramView.findViewById(2131308869);
      p.g(localView, "rootView.findViewById(R.id.tag_layout)");
      this.ptA = ((LabelsView)localView);
      paramView = paramView.findViewById(2131297499);
      p.g(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.ptB = ((TextView)paramView);
      paramView = this.ptB.getPaint();
      p.g(paramView, "unLikeTv.paint");
      paramView.setFakeBoldText(true);
      AppMethodBeat.o(6540);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class c<T>
    implements LabelsView.a<c>
  {
    public static final c ptC;
    
    static
    {
      AppMethodBeat.i(6542);
      ptC = new c();
      AppMethodBeat.o(6542);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class d
    implements LabelsView.b
  {
    d(b paramb) {}
    
    public final void j(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(195259);
      paramObject = b.a(this.ptD).hPX;
      if (b.a(this.ptD).ptA.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(195259);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.b
 * JD-Core Version:    0.7.0.1
 */