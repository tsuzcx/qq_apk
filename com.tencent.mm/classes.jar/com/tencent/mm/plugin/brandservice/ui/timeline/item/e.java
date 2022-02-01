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
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final String TAG;
  private final ab vGS;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private final qo vIS;
  private final int vIT;
  private final a vIU;
  
  public e(Context paramContext, ab paramab, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, qo paramqo, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(302643);
    this.vGS = paramab;
    this.vHY = paramb;
    this.vIS = paramqo;
    this.vIT = paramInt;
    this.TAG = "MicroMsg.BizTLRecCardUtil";
    a(new b.a[] { b.a.aghf, b.a.aghd });
    paramab = new BubbleLayout(paramContext);
    paramab.setBubbleColor(paramContext.getResources().getColor(d.b.BW_100));
    paramab.setBubbleRadius(com.tencent.mm.cd.a.fromDPToPix(paramContext, 8));
    paramab.setShadowColor(0);
    paramab.setLookWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    paramab.setLookLength(com.tencent.mm.cd.a.fromDPToPix(paramContext, 7));
    a(paramab);
    paramb = LayoutInflater.from(paramContext).inflate(d.f.biz_time_line_rec_card_un_like_dialog, null);
    s.s(paramb, "rootView");
    this.vIU = new a(paramb);
    paramab = paramb.findViewById(d.e.content_root_layout);
    s.s(paramab, "rootView.findViewById(R.id.content_root_layout)");
    paramqo = com.tencent.mm.plugin.bizui.a.a.vtB;
    paramInt = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
    int i = com.tencent.mm.cd.a.mt(paramContext);
    paramqo = paramab.getLayoutParams();
    if (paramInt < i) {}
    for (;;)
    {
      paramqo.width = (paramInt - com.tencent.mm.cd.a.fromDPToPix(paramContext, 82));
      paramab.setLayoutParams(paramqo);
      paramContext = new LinkedList();
      if (this.vGS.iYp().style != 102) {
        break;
      }
      paramab = this.vGS.iYp().abLM.YVA;
      s.s(paramab, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
      paramab = (Iterable)paramab;
      paramInt = 0;
      paramab = paramab.iterator();
      while (paramab.hasNext())
      {
        paramqo = paramab.next();
        if (paramInt < 0) {
          p.kkW();
        }
        paramContext.add(new c((String)paramqo, paramInt));
        paramInt += 1;
      }
      paramInt = i;
    }
    paramab = this.vIS;
    if (paramab != null)
    {
      paramab = paramab.YVA;
      if (paramab != null)
      {
        paramab = (Iterable)paramab;
        paramInt = 0;
        paramab = paramab.iterator();
        while (paramab.hasNext())
        {
          paramqo = paramab.next();
          if (paramInt < 0) {
            p.kkW();
          }
          paramContext.add(new c((String)paramqo, paramInt));
          paramInt += 1;
        }
      }
    }
    this.vIU.vII.a((List)paramContext, e..ExternalSyntheticLambda0.INSTANCE);
    this.vIU.vII.jIh();
    this.vIU.vII.setOnLabelClickListener(new e..ExternalSyntheticLambda1(this));
    paramqo = ((Iterable)paramContext).iterator();
    c localc;
    for (paramContext = ""; paramqo.hasNext(); paramContext = s.X(paramab, localc.name))
    {
      localc = (c)paramqo.next();
      paramab = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramab = s.X(paramContext, "#");
      }
    }
    paramqo = com.tencent.mm.plugin.report.service.h.OAn;
    paramab = this.vIS;
    if (paramab == null) {}
    for (paramab = null;; paramab = paramab.UserName)
    {
      paramqo.b(18644, new Object[] { paramab, Long.valueOf(this.vGS.iYp().abry), paramContext, Integer.valueOf(ad.getSessionId()), Integer.valueOf(this.vIT) });
      mk(paramb);
      this.vIU.nhC.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(302643);
      return;
    }
  }
  
  private static final void a(e parame, TextView paramTextView, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(302654);
    s.u(parame, "this$0");
    paramTextView = parame.vIU.nhC;
    if (parame.vIU.vII.getSelectLabels().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramTextView.setEnabled(bool);
      AppMethodBeat.o(302654);
      return;
    }
  }
  
  private static final CharSequence b(TextView paramTextView, int paramInt, c paramc)
  {
    return (CharSequence)paramc.name;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(302682);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    s.u(paramView, "v");
    LinkedList localLinkedList;
    Object localObject3;
    flj localflj;
    label207:
    int j;
    int i;
    if (paramView.getId() == d.e.ok_btn)
    {
      localLinkedList = new LinkedList();
      localObject2 = this.vIU.vII.getSelectLabelDatas();
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
          localObject3 = (c)((Iterator)localObject2).next();
          localObject1 = paramView;
          if (!Util.isNullOrNil(paramView)) {
            localObject1 = s.X(paramView, "#");
          }
          paramView = s.X((String)localObject1, ((c)localObject3).name);
          localLinkedList.add(((c)localObject3).name);
        }
      }
      localflj = this.vGS.iYp();
      localObject3 = localflj.abLM;
      paramView = this.vIS;
      if (paramView != null) {
        break label502;
      }
      paramView = null;
      if (paramView != null) {
        break label528;
      }
      localObject2 = null;
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
        String str1;
        String str2;
        String str3;
        int k;
        l1 = l2;
      }
    }
    new StringBuilder("onClick msgId = ").append(this.vGS.field_msgId).append(", cardId=").append(((apx)localObject3).YSF).append(", style=").append(this.vGS.iYp().style);
    com.tencent.e.f.h.jXD();
    localf = this.vHY.vFK;
    Object localObject2 = this.vIS;
    if (localObject2 == null)
    {
      localObject2 = null;
      label348:
      l2 = localflj.abry;
      str1 = ((apx)localObject3).YSJ;
      str2 = localflj.event;
      str3 = ((apx)localObject3).YSF;
      if (paramView != null) {
        break label547;
      }
      j = 0;
      label382:
      k = localflj.style;
      if (paramView != null) {
        break label555;
      }
      paramView = "";
      label397:
      localf.a((String)localObject2, l1, i, 17, l2, (String)localObject1, 0, str1, str2, str3, j, k, paramView);
      if (this.vGS.iYp().style != 102) {
        break label576;
      }
      s.s(localflj, "wrapper");
      k.a(3, localflj, (List)localLinkedList, this.vGS);
    }
    for (;;)
    {
      af.bHl().yQ(this.vGS.field_msgId);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302682);
      return;
      label502:
      paramView = paramView.YVI;
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = (qn)paramView.get(0);
      break;
      label528:
      localObject2 = paramView.YQK;
      break label207;
      localObject2 = ((qo)localObject2).UserName;
      break label348;
      label547:
      j = paramView.YVE;
      break label382;
      label555:
      localObject3 = paramView.YVF;
      paramView = (View)localObject3;
      if (localObject3 != null) {
        break label397;
      }
      paramView = "";
      break label397;
      label576:
      s.s(localflj, "wrapper");
      k.a(1, localflj, (List)localLinkedList, this.vGS);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    Button nhC;
    LabelsView vII;
    private TextView vIJ;
    
    public a(View paramView)
    {
      AppMethodBeat.i(302834);
      View localView = paramView.findViewById(d.e.ok_btn);
      s.s(localView, "rootView.findViewById(R.id.ok_btn)");
      this.nhC = ((Button)localView);
      localView = paramView.findViewById(d.e.tag_layout);
      s.s(localView, "rootView.findViewById(R.id.tag_layout)");
      this.vII = ((LabelsView)localView);
      paramView = paramView.findViewById(d.e.biz_rec_card_reason_tv);
      s.s(paramView, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
      this.vIJ = ((TextView)paramView);
      this.vIJ.getPaint().setFakeBoldText(true);
      AppMethodBeat.o(302834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.e
 * JD-Core Version:    0.7.0.1
 */