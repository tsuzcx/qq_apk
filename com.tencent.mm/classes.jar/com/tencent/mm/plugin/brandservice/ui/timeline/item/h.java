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
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "recCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getRecCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private final ab vGS;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private final int vIT;
  private final a vJk;
  private final ene vJl;
  
  public h(Context paramContext, ab paramab, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(302713);
    this.vGS = paramab;
    this.vHY = paramb;
    this.vIT = paramInt;
    paramab = this.vGS.acFJ;
    s.s(paramab, "info.recFeed");
    this.vJl = paramab;
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
    this.vJk = new a(paramb);
    paramab = paramb.findViewById(d.e.content_root_layout);
    s.s(paramab, "rootView.findViewById(R.id.content_root_layout)");
    Object localObject = com.tencent.mm.plugin.bizui.a.a.vtB;
    paramInt = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
    int j = com.tencent.mm.cd.a.mt(paramContext);
    localObject = paramab.getLayoutParams();
    if (paramInt < j) {}
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = (paramInt - com.tencent.mm.cd.a.fromDPToPix(paramContext, 82));
      paramab.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramContext = new LinkedList();
      paramab = this.vJl.YVA;
      if (paramab == null) {
        break;
      }
      paramab = ((Iterable)paramab).iterator();
      paramInt = i;
      while (paramab.hasNext())
      {
        localObject = paramab.next();
        if (paramInt < 0) {
          kotlin.a.p.kkW();
        }
        paramContext.add(new c((String)localObject, paramInt));
        paramInt += 1;
      }
      paramInt = j;
    }
    this.vJk.vII.a((List)paramContext, h..ExternalSyntheticLambda0.INSTANCE);
    this.vJk.vII.jIh();
    this.vJk.vII.setOnLabelClickListener(new h..ExternalSyntheticLambda1(this));
    localObject = ((Iterable)paramContext).iterator();
    c localc;
    for (paramContext = ""; ((Iterator)localObject).hasNext(); paramContext = s.X(paramab, localc.name))
    {
      localc = (c)((Iterator)localObject).next();
      paramab = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramab = s.X(paramContext, "#");
      }
    }
    mk(paramb);
    this.vJk.nhC.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(302713);
  }
  
  private static final void a(h paramh, TextView paramTextView, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(302719);
    s.u(paramh, "this$0");
    paramTextView = paramh.vJk.nhC;
    if (paramh.vJk.vII.getSelectLabels().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramTextView.setEnabled(bool);
      AppMethodBeat.o(302719);
      return;
    }
  }
  
  private static final CharSequence c(TextView paramTextView, int paramInt, c paramc)
  {
    return (CharSequence)paramc.name;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(302747);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    s.u(paramView, "v");
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject3;
    long l;
    int i;
    if (paramView.getId() == d.e.ok_btn)
    {
      localLinkedList = new LinkedList();
      localObject2 = this.vJk.vII.getSelectLabelDatas();
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
      localObject2 = (enp)this.vJl.abrC.get(0);
      localObject3 = ((enp)localObject2).abse;
      paramView = ((enp)localObject2).absd;
      localObject3 = ((ddb)localObject3).YQK;
      s.s(localObject3, "appMsg.ContentUrl");
      localObject3 = ah.bvH((String)localObject3);
      l = Util.getLong(localObject3[0], 0L);
      i = Util.getInt(localObject3[1], 0);
      localObject3 = this.vHY.vFK;
      if (paramView != null) {
        break label485;
      }
    }
    label485:
    for (paramView = null;; paramView = paramView.UserName)
    {
      String str = this.vJl.YSF;
      int j = this.vJl.bcb;
      localObject2 = ((enp)localObject2).YVF;
      int k = ah.K(this.vGS);
      int m = (int)(System.currentTimeMillis() / 1000L);
      com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { paramView, Long.valueOf(l), Integer.valueOf(16), Integer.valueOf(m), Integer.valueOf(((f)localObject3).hBm), Integer.valueOf(i), Long.valueOf(0L), localObject1, Integer.valueOf(k), Integer.valueOf(0), "", "", str, Integer.valueOf(0), Integer.valueOf(j), localObject2 });
      paramView = com.tencent.mm.model.p.ojc;
      p.a.a(this.vGS, localLinkedList);
      this.vHY.d(this.vGS);
      dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302747);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    Button nhC;
    LabelsView vII;
    private TextView vIJ;
    
    public a(View paramView)
    {
      AppMethodBeat.i(302602);
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
      AppMethodBeat.o(302602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.h
 * JD-Core Version:    0.7.0.1
 */