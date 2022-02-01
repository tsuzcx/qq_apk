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
import com.tencent.mm.al.ag;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class d
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final w ogW;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  private final a oij;
  private final om oik;
  private final int oil;
  
  public d(Context paramContext, w paramw, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, om paramom, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(208662);
    this.ogW = paramw;
    this.ohs = paramb;
    this.oik = paramom;
    this.oil = paramInt;
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
    this.oij = new a(paramb);
    paramw = paramb.findViewById(2131298771);
    p.g(paramw, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cb.a.iu(paramContext);
    int i = com.tencent.mm.cb.a.iv(paramContext);
    paramom = paramw.getLayoutParams();
    if (paramInt < i) {}
    for (;;)
    {
      paramom.width = (paramInt - com.tencent.mm.cb.a.fromDPToPix(paramContext, 82));
      paramw.setLayoutParams(paramom);
      paramContext = new LinkedList();
      switch (this.ogW.ftk().style)
      {
      default: 
        paramw = this.oik;
        if (paramw == null) {
          break label437;
        }
        paramw = paramw.Gcm;
        if (paramw == null) {
          break label437;
        }
        paramw = (Iterable)paramw;
        paramInt = 0;
        paramw = paramw.iterator();
        while (paramw.hasNext())
        {
          paramom = paramw.next();
          if (paramInt < 0) {
            d.a.j.gkd();
          }
          paramContext.add(new b((String)paramom, paramInt));
          paramInt += 1;
        }
        paramInt = i;
      }
    }
    paramw = this.ogW.ftk().HTS.Gcm;
    p.g(paramw, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
    paramw = (Iterable)paramw;
    paramInt = 0;
    paramw = paramw.iterator();
    while (paramw.hasNext())
    {
      paramom = paramw.next();
      if (paramInt < 0) {
        d.a.j.gkd();
      }
      paramContext.add(new b((String)paramom, paramInt));
      paramInt += 1;
    }
    label437:
    this.oij.ohY.a((List)paramContext, (LabelsView.a)b.oim);
    this.oij.ohY.fQP();
    this.oij.ohY.setOnLabelClickListener((LabelsView.b)new c(this));
    paramom = ((Iterable)paramContext).iterator();
    b localb;
    for (paramContext = ""; paramom.hasNext(); paramContext = paramw + localb.getName())
    {
      localb = (b)paramom.next();
      paramw = paramContext;
      if (!bu.isNullOrNil(paramContext)) {
        paramw = paramContext + "#";
      }
    }
    paramom = com.tencent.mm.plugin.report.service.g.yxI;
    paramw = this.oik;
    if (paramw != null) {}
    for (paramw = paramw.nIJ;; paramw = null)
    {
      paramom.f(18644, new Object[] { paramw, Long.valueOf(this.ogW.ftk().HDI), paramContext, Integer.valueOf(y.getSessionId()), Integer.valueOf(this.oil) });
      hi(paramb);
      this.oij.gXc.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(208662);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208661);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    p.h(paramView, "v");
    LinkedList localLinkedList;
    Object localObject3;
    dmq localdmq;
    label253:
    int j;
    label265:
    int i;
    if (paramView.getId() == 2131302999)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.oij.ohY.getSelectLabelDatas();
      paramView = "";
      if (localObject1 == null) {
        break label539;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        localObject1 = paramView;
        if (!bu.isNullOrNil(paramView)) {
          localObject1 = paramView + "#";
        }
        paramView = new StringBuilder().append((String)localObject1);
        p.g(localObject3, "tag");
        paramView = ((b)localObject3).getName();
        localLinkedList.add(((b)localObject3).getName());
      }
      localdmq = this.ogW.ftk();
      localObject3 = localdmq.HTS;
      localObject1 = this.oik;
      if (localObject1 == null) {
        break label546;
      }
      localObject1 = ((om)localObject1).Gcu;
      if (localObject1 == null) {
        break label546;
      }
      localObject1 = (ol)((LinkedList)localObject1).get(0);
      if (localObject1 == null) {
        break label552;
      }
      localObject2 = ((ol)localObject1).FYs;
      j = 0;
      i = 0;
      l2 = 0L;
      l1 = l2;
      if (!bu.isNullOrNil((String)localObject2)) {
        i = j;
      }
    }
    try
    {
      localObject2 = Uri.parse((String)localObject2);
      i = j;
      j = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      i = j;
      l1 = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.g localg;
        label353:
        String str1;
        String str2;
        String str3;
        label392:
        int k;
        label539:
        label546:
        label552:
        label564:
        l1 = l2;
      }
    }
    localg = this.ohs.ogr;
    Object localObject2 = this.oik;
    if (localObject2 != null)
    {
      localObject2 = ((om)localObject2).nIJ;
      l2 = localdmq.HDI;
      str1 = ((aiq)localObject3).Gau;
      str2 = localdmq.dmp;
      str3 = ((aiq)localObject3).Gaq;
      if (localObject1 == null) {
        break label564;
      }
      j = ((ol)localObject1).Gcq;
      k = localdmq.style;
      if (localObject1 != null)
      {
        localObject3 = ((ol)localObject1).Gcr;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localg.a((String)localObject2, l1, i, 17, l2, paramView, 0, str1, str2, str3, j, k, (String)localObject1);
      switch (this.ogW.ftk().style)
      {
      default: 
        p.g(localdmq, "wrapper");
        j.a(1, localdmq, (List)localLinkedList);
      }
    }
    for (;;)
    {
      ag.aGv().DU(this.ogW.field_msgId);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208661);
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
      p.g(localdmq, "wrapper");
      j.a(3, localdmq, (List)localLinkedList);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button gXc;
    LabelsView ohY;
    private TextView ohZ;
    
    public a(View paramView)
    {
      AppMethodBeat.i(208657);
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
      AppMethodBeat.o(208657);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<b>
  {
    public static final b oim;
    
    static
    {
      AppMethodBeat.i(208659);
      oim = new b();
      AppMethodBeat.o(208659);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(d paramd) {}
    
    public final void bPu()
    {
      AppMethodBeat.i(208660);
      Button localButton = d.a(this.oin).gXc;
      if (d.a(this.oin).ohY.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(208660);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.d
 * JD-Core Version:    0.7.0.1
 */