package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
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
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class e
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final z sBt;
  private final a sCY;
  private final pf sCZ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private final int sDa;
  
  public e(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, pf parampf, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(265540);
    this.sBt = paramz;
    this.sCg = paramb;
    this.sCZ = parampf;
    this.sDa = paramInt;
    a(new b.a[] { b.a.YoS, b.a.YoQ });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(d.b.BW_100));
    paramz.setBubbleRadius(com.tencent.mm.ci.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.ci.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(d.f.stV, null);
    p.j(paramb, "rootView");
    this.sCY = new a(paramb);
    paramz = paramb.findViewById(d.e.srK);
    p.j(paramz, "rootView.findViewById(R.id.content_root_layout)");
    parampf = com.tencent.mm.plugin.bizui.a.a.shG;
    paramInt = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
    int i = com.tencent.mm.ci.a.ks(paramContext);
    parampf = paramz.getLayoutParams();
    if (paramInt < i) {}
    for (;;)
    {
      parampf.width = (paramInt - com.tencent.mm.ci.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams(parampf);
      paramContext = new LinkedList();
      switch (this.sBt.hwL().style)
      {
      default: 
        paramz = this.sCZ;
        if (paramz == null) {
          break label446;
        }
        paramz = paramz.RXF;
        if (paramz == null) {
          break label446;
        }
        paramz = (Iterable)paramz;
        paramInt = 0;
        paramz = paramz.iterator();
        while (paramz.hasNext())
        {
          parampf = paramz.next();
          if (paramInt < 0) {
            j.iBO();
          }
          paramContext.add(new c((String)parampf, paramInt));
          paramInt += 1;
        }
        paramInt = i;
      }
    }
    paramz = this.sBt.hwL().UsF.RXF;
    p.j(paramz, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
    paramz = (Iterable)paramz;
    paramInt = 0;
    paramz = paramz.iterator();
    while (paramz.hasNext())
    {
      parampf = paramz.next();
      if (paramInt < 0) {
        j.iBO();
      }
      paramContext.add(new c((String)parampf, paramInt));
      paramInt += 1;
    }
    label446:
    this.sCY.sCN.a((List)paramContext, (LabelsView.a)b.sDb);
    this.sCY.sCN.icV();
    this.sCY.sCN.setOnLabelClickListener((LabelsView.b)new c(this));
    parampf = ((Iterable)paramContext).iterator();
    c localc;
    for (paramContext = ""; parampf.hasNext(); paramContext = paramz + localc.getName())
    {
      localc = (c)parampf.next();
      paramz = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramz = paramContext + "#";
      }
    }
    parampf = h.IzE;
    paramz = this.sCZ;
    if (paramz != null) {}
    for (paramz = paramz.UserName;; paramz = null)
    {
      parampf.a(18644, new Object[] { paramz, Long.valueOf(this.sBt.hwL().Uaw), paramContext, Integer.valueOf(ab.getSessionId()), Integer.valueOf(this.sDa) });
      iN(paramb);
      this.sCY.kEt.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(265540);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265539);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.k(paramView, "v");
    LinkedList localLinkedList;
    Object localObject3;
    eqg localeqg;
    label253:
    int j;
    label265:
    int i;
    if (paramView.getId() == d.e.ok_btn)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.sCY.sCN.getSelectLabelDatas();
      paramView = "";
      if (localObject1 == null) {
        break label543;
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
        p.j(localObject3, "tag");
        paramView = ((c)localObject3).getName();
        localLinkedList.add(((c)localObject3).getName());
      }
      localeqg = this.sBt.hwL();
      localObject3 = localeqg.UsF;
      localObject1 = this.sCZ;
      if (localObject1 == null) {
        break label550;
      }
      localObject1 = ((pf)localObject1).RXM;
      if (localObject1 == null) {
        break label550;
      }
      localObject1 = (pe)((LinkedList)localObject1).get(0);
      if (localObject1 == null) {
        break label556;
      }
      localObject2 = ((pe)localObject1).RTk;
      j = 0;
      i = 0;
      l2 = 0L;
      l1 = l2;
      if (!Util.isNullOrNil((String)localObject2)) {
        i = j;
      }
    }
    try
    {
      localObject2 = Uri.parse((String)localObject2);
      i = j;
      j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      i = j;
      l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f localf;
        label353:
        String str1;
        String str2;
        String str3;
        label392:
        int k;
        label543:
        label550:
        label556:
        label568:
        l1 = l2;
      }
    }
    localf = this.sCg.szZ;
    Object localObject2 = this.sCZ;
    if (localObject2 != null)
    {
      localObject2 = ((pf)localObject2).UserName;
      l2 = localeqg.Uaw;
      str1 = ((amf)localObject3).RVm;
      str2 = localeqg.event;
      str3 = ((amf)localObject3).RVi;
      if (localObject1 == null) {
        break label568;
      }
      j = ((pe)localObject1).RXJ;
      k = localeqg.style;
      if (localObject1 != null)
      {
        localObject3 = ((pe)localObject1).RXK;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localf.a((String)localObject2, l1, i, 17, l2, paramView, 0, str1, str2, str3, j, k, (String)localObject1);
      switch (this.sBt.hwL().style)
      {
      default: 
        p.j(localeqg, "wrapper");
        l.a(1, localeqg, (List)localLinkedList, this.sBt);
      }
    }
    for (;;)
    {
      af.bjB().UI(this.sBt.field_msgId);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265539);
      return;
      paramView = "";
      break;
      localObject1 = null;
      break label253;
      localObject2 = null;
      break label265;
      localObject2 = null;
      break label353;
      j = 0;
      break label392;
      p.j(localeqg, "wrapper");
      l.a(3, localeqg, (List)localLinkedList, this.sBt);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button kEt;
    LabelsView sCN;
    private TextView sCO;
    
    public a(View paramView)
    {
      AppMethodBeat.i(259283);
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
      AppMethodBeat.o(259283);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<c>
  {
    public static final b sDb;
    
    static
    {
      AppMethodBeat.i(265855);
      sDb = new b();
      AppMethodBeat.o(265855);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(e parame) {}
    
    public final void n(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(265768);
      paramObject = e.a(this.sDc).kEt;
      if (e.a(this.sDc).sCN.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(265768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.e
 * JD-Core Version:    0.7.0.1
 */