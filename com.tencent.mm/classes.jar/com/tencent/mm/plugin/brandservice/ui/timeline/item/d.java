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
import com.tencent.mm.am.ag;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class d
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  private final w obf;
  private final a ocu;
  private final ok ocv;
  private final int ocw;
  
  public d(Context paramContext, w paramw, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, ok paramok, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(209688);
    this.obf = paramw;
    this.obC = paramb;
    this.ocv = paramok;
    this.ocw = paramInt;
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
    this.ocu = new a(paramb);
    paramw = paramb.findViewById(2131298771);
    p.g(paramw, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cc.a.ip(paramContext);
    int i = com.tencent.mm.cc.a.iq(paramContext);
    paramok = paramw.getLayoutParams();
    if (paramInt < i) {}
    for (;;)
    {
      paramok.width = (paramInt - com.tencent.mm.cc.a.fromDPToPix(paramContext, 82));
      paramw.setLayoutParams(paramok);
      paramContext = new LinkedList();
      switch (this.obf.fpm().style)
      {
      default: 
        paramw = this.ocv;
        if (paramw == null) {
          break label437;
        }
        paramw = paramw.FJN;
        if (paramw == null) {
          break label437;
        }
        paramw = (Iterable)paramw;
        paramInt = 0;
        paramw = paramw.iterator();
        while (paramw.hasNext())
        {
          paramok = paramw.next();
          if (paramInt < 0) {
            d.a.j.gfB();
          }
          paramContext.add(new b((String)paramok, paramInt));
          paramInt += 1;
        }
        paramInt = i;
      }
    }
    paramw = this.obf.fpm().HAf.FJN;
    p.g(paramw, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
    paramw = (Iterable)paramw;
    paramInt = 0;
    paramw = paramw.iterator();
    while (paramw.hasNext())
    {
      paramok = paramw.next();
      if (paramInt < 0) {
        d.a.j.gfB();
      }
      paramContext.add(new b((String)paramok, paramInt));
      paramInt += 1;
    }
    label437:
    this.ocu.ocj.a((List)paramContext, (LabelsView.a)b.ocx);
    this.ocu.ocj.fMv();
    this.ocu.ocj.setOnLabelClickListener((LabelsView.b)new c(this));
    paramok = ((Iterable)paramContext).iterator();
    b localb;
    for (paramContext = ""; paramok.hasNext(); paramContext = paramw + localb.getName())
    {
      localb = (b)paramok.next();
      paramw = paramContext;
      if (!bt.isNullOrNil(paramContext)) {
        paramw = paramContext + "#";
      }
    }
    paramok = com.tencent.mm.plugin.report.service.g.yhR;
    paramw = this.ocv;
    if (paramw != null) {}
    for (paramw = paramw.nDo;; paramw = null)
    {
      paramok.f(18644, new Object[] { paramw, Long.valueOf(this.obf.fpm().Hki), paramContext, Integer.valueOf(y.getSessionId()), Integer.valueOf(this.ocw) });
      hd(paramb);
      this.ocu.gUt.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(209688);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209687);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    p.h(paramView, "v");
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject3;
    label265:
    int j;
    int i;
    if (paramView.getId() == 2131302999)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.ocu.ocj.getSelectLabelDatas();
      paramView = "";
      if (localObject1 == null) {
        break label455;
      }
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        localObject1 = paramView;
        if (!bt.isNullOrNil(paramView)) {
          localObject1 = paramView + "#";
        }
        paramView = new StringBuilder().append((String)localObject1);
        p.g(localObject3, "tag");
        paramView = ((b)localObject3).getName();
        localLinkedList.add(((b)localObject3).getName());
      }
      localObject2 = this.obf.fpm();
      localObject3 = ((dlt)localObject2).HAf;
      localObject1 = this.ocv;
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = ((ok)localObject1).FJV;
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = (oj)((LinkedList)localObject1).get(0);
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = ((oj)localObject1).FFW;
      j = 0;
      i = 0;
      l2 = 0L;
      l1 = l2;
      if (!bt.isNullOrNil((String)localObject1)) {
        i = j;
      }
    }
    try
    {
      localObject1 = Uri.parse((String)localObject1);
      i = j;
      j = bt.getInt(((Uri)localObject1).getQueryParameter("idx"), 0);
      i = j;
      l1 = bt.getLong(((Uri)localObject1).getQueryParameter("mid"), 0L);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.g localg;
        label455:
        label462:
        l1 = l2;
      }
    }
    localg = this.obC.oaB;
    localObject1 = this.ocv;
    if (localObject1 != null) {}
    for (localObject1 = ((ok)localObject1).nDo;; localObject1 = null)
    {
      localg.a((String)localObject1, l1, i, 17, ((dlt)localObject2).Hki, paramView, 0, ((aig)localObject3).FHY, ((dlt)localObject2).dln, ((aig)localObject3).FHU, 0, ((dlt)localObject2).style, "");
      p.g(localObject2, "wrapper");
      j.a(1, (dlt)localObject2, (List)localLinkedList);
      ag.aGf().Dv(this.obf.field_msgId);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209687);
      return;
      paramView = "";
      break;
      localObject1 = null;
      break label265;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button gUt;
    LabelsView ocj;
    private TextView ock;
    
    public a(View paramView)
    {
      AppMethodBeat.i(209683);
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
      AppMethodBeat.o(209683);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<b>
  {
    public static final b ocx;
    
    static
    {
      AppMethodBeat.i(209685);
      ocx = new b();
      AppMethodBeat.o(209685);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(d paramd) {}
    
    public final void bOw()
    {
      AppMethodBeat.i(209686);
      Button localButton = d.a(this.ocy).gUt;
      if (d.a(this.ocy).ocj.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setEnabled(bool);
        AppMethodBeat.o(209686);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.d
 * JD-Core Version:    0.7.0.1
 */