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
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class e
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private final z psm;
  private final a ptL;
  private final pj ptM;
  private final int ptN;
  
  public e(Context paramContext, z paramz, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, pj parampj, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(195270);
    this.psm = paramz;
    this.psQ = paramb;
    this.ptM = parampj;
    this.ptN = paramInt;
    a(new b.a[] { b.a.QQh, b.a.QQf });
    paramz = new BubbleLayout(paramContext);
    paramz.setBubbleColor(paramContext.getResources().getColor(2131099672));
    paramz.setBubbleRadius(com.tencent.mm.cb.a.fromDPToPix(paramContext, 8));
    paramz.setShadowColor(0);
    paramz.setLookWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 14));
    paramz.setLookLength(com.tencent.mm.cb.a.fromDPToPix(paramContext, 7));
    a(paramz);
    paramb = LayoutInflater.from(paramContext).inflate(2131493277, null);
    p.g(paramb, "rootView");
    this.ptL = new a(paramb);
    paramz = paramb.findViewById(2131299215);
    p.g(paramz, "rootView.findViewById(R.id.content_root_layout)");
    paramInt = com.tencent.mm.cb.a.jn(paramContext);
    int i = com.tencent.mm.cb.a.jo(paramContext);
    parampj = paramz.getLayoutParams();
    if (paramInt < i) {}
    for (;;)
    {
      parampj.width = (paramInt - com.tencent.mm.cb.a.fromDPToPix(paramContext, 82));
      paramz.setLayoutParams(parampj);
      paramContext = new LinkedList();
      switch (this.psm.gAD().style)
      {
      default: 
        paramz = this.ptM;
        if (paramz == null) {
          break label437;
        }
        paramz = paramz.KWr;
        if (paramz == null) {
          break label437;
        }
        paramz = (Iterable)paramz;
        paramInt = 0;
        paramz = paramz.iterator();
        while (paramz.hasNext())
        {
          parampj = paramz.next();
          if (paramInt < 0) {
            j.hxH();
          }
          paramContext.add(new c((String)parampj, paramInt));
          paramInt += 1;
        }
        paramInt = i;
      }
    }
    paramz = this.psm.gAD().Nga.KWr;
    p.g(paramz, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
    paramz = (Iterable)paramz;
    paramInt = 0;
    paramz = paramz.iterator();
    while (paramz.hasNext())
    {
      parampj = paramz.next();
      if (paramInt < 0) {
        j.hxH();
      }
      paramContext.add(new c((String)parampj, paramInt));
      paramInt += 1;
    }
    label437:
    this.ptL.ptA.a((List)paramContext, (LabelsView.a)b.ptO);
    this.ptL.ptA.hbO();
    this.ptL.ptA.setOnLabelClickListener((LabelsView.b)new c(this));
    parampj = ((Iterable)paramContext).iterator();
    c localc;
    for (paramContext = ""; parampj.hasNext(); paramContext = paramz + localc.getName())
    {
      localc = (c)parampj.next();
      paramz = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramz = paramContext + "#";
      }
    }
    parampj = h.CyF;
    paramz = this.ptM;
    if (paramz != null) {}
    for (paramz = paramz.UserName;; paramz = null)
    {
      parampj.a(18644, new Object[] { paramz, Long.valueOf(this.psm.gAD().MOC), paramContext, Integer.valueOf(ab.getSessionId()), Integer.valueOf(this.ptN) });
      hx(paramb);
      this.ptL.hPX.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(195270);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195269);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    p.h(paramView, "v");
    LinkedList localLinkedList;
    Object localObject3;
    ege localege;
    label253:
    int j;
    label265:
    int i;
    if (paramView.getId() == 2131305592)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.ptL.ptA.getSelectLabelDatas();
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
        p.g(localObject3, "tag");
        paramView = ((c)localObject3).getName();
        localLinkedList.add(((c)localObject3).getName());
      }
      localege = this.psm.gAD();
      localObject3 = localege.Nga;
      localObject1 = this.ptM;
      if (localObject1 == null) {
        break label550;
      }
      localObject1 = ((pj)localObject1).KWy;
      if (localObject1 == null) {
        break label550;
      }
      localObject1 = (pi)((LinkedList)localObject1).get(0);
      if (localObject1 == null) {
        break label556;
      }
      localObject2 = ((pi)localObject1).KSj;
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
    localf = this.psQ.pqZ;
    Object localObject2 = this.ptM;
    if (localObject2 != null)
    {
      localObject2 = ((pj)localObject2).UserName;
      l2 = localege.MOC;
      str1 = ((ale)localObject3).KUo;
      str2 = localege.event;
      str3 = ((ale)localObject3).KUk;
      if (localObject1 == null) {
        break label568;
      }
      j = ((pi)localObject1).KWv;
      k = localege.style;
      if (localObject1 != null)
      {
        localObject3 = ((pi)localObject1).KWw;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localf.a((String)localObject2, l1, i, 17, l2, paramView, 0, str1, str2, str3, j, k, (String)localObject1);
      switch (this.psm.gAD().style)
      {
      default: 
        p.g(localege, "wrapper");
        l.a(1, localege, (List)localLinkedList, this.psm);
      }
    }
    for (;;)
    {
      ag.ban().MX(this.psm.field_msgId);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195269);
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
      p.g(localege, "wrapper");
      l.a(3, localege, (List)localLinkedList, this.psm);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
  static final class a
  {
    Button hPX;
    LabelsView ptA;
    private TextView ptB;
    
    public a(View paramView)
    {
      AppMethodBeat.i(195265);
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
      AppMethodBeat.o(195265);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
  static final class b<T>
    implements LabelsView.a<c>
  {
    public static final b ptO;
    
    static
    {
      AppMethodBeat.i(195267);
      ptO = new b();
      AppMethodBeat.o(195267);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
  static final class c
    implements LabelsView.b
  {
    c(e parame) {}
    
    public final void j(Object paramObject, int paramInt)
    {
      AppMethodBeat.i(195268);
      paramObject = e.a(this.ptP).hPX;
      if (e.a(this.ptP).ptA.getSelectLabels().size() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramObject.setEnabled(bool);
        AppMethodBeat.o(195268);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.e
 * JD-Core Version:    0.7.0.1
 */