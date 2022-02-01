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
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.ui.widget.happybubble.b
  implements View.OnClickListener
{
  private static final String TAG;
  public static final b.a vIG;
  private final int pos;
  private final ab vGS;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private final b vIH;
  
  static
  {
    AppMethodBeat.i(6546);
    vIG = new b.a((byte)0);
    TAG = "MicroMsg.BizTimeLineItem";
    AppMethodBeat.o(6546);
  }
  
  public b(Context paramContext, ab paramab, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(6545);
    this.vGS = paramab;
    this.vHY = paramb;
    this.pos = paramInt;
    a(new com.tencent.mm.ui.widget.happybubble.b.a[] { com.tencent.mm.ui.widget.happybubble.b.a.aghf, com.tencent.mm.ui.widget.happybubble.b.a.aghd });
    paramab = new BubbleLayout(paramContext);
    paramab.setBubbleColor(paramContext.getResources().getColor(d.b.BW_100));
    paramab.setBubbleRadius(com.tencent.mm.cd.a.fromDPToPix(paramContext, 8));
    paramab.setShadowColor(0);
    paramab.setLookWidth(com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    paramab.setLookLength(com.tencent.mm.cd.a.fromDPToPix(paramContext, 7));
    a(paramab);
    paramb = LayoutInflater.from(paramContext).inflate(d.f.biz_time_line_rec_card_un_like_dialog, null);
    s.s(paramb, "rootView");
    this.vIH = new b(paramb);
    paramab = paramb.findViewById(d.e.content_root_layout);
    s.s(paramab, "rootView.findViewById(R.id.content_root_layout)");
    Object localObject1 = com.tencent.mm.plugin.bizui.a.a.vtB;
    paramInt = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
    int i = com.tencent.mm.cd.a.mt(paramContext);
    localObject1 = paramab.getLayoutParams();
    label250:
    Object localObject2;
    int j;
    if (paramInt < i)
    {
      ((ViewGroup.LayoutParams)localObject1).width = (paramInt - com.tencent.mm.cd.a.fromDPToPix(paramContext, 82));
      paramab.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.vGS;
      paramab = new ArrayList();
      paramContext = ((ab)localObject1).iYp();
      if (paramContext != null) {
        break label454;
      }
      paramContext = null;
      localObject2 = ((ab)localObject1).iYp();
      s.checkNotNull(localObject2);
      localObject2 = ((flj)localObject2).abLL;
      if (Util.isNullOrNil((List)paramContext)) {
        break label504;
      }
      s.checkNotNull(paramContext);
      j = paramContext.size() - 1;
      if (j < 0) {}
    }
    for (paramInt = 0;; paramInt = i)
    {
      i = paramInt + 1;
      paramab.add(new c((String)paramContext.get(paramInt), paramInt));
      if (i > j)
      {
        label454:
        label504:
        do
        {
          this.vIH.vII.a((List)paramab, b..ExternalSyntheticLambda0.INSTANCE);
          this.vIH.vII.jIh();
          this.vIH.vII.setOnLabelClickListener(new b..ExternalSyntheticLambda1(this));
          paramContext = "";
          localObject2 = ((Iterable)paramab).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            c localc = (c)((Iterator)localObject2).next();
            paramab = paramContext;
            if (!Util.isNullOrNil(paramContext)) {
              paramab = s.X(paramContext, "#");
            }
            paramContext = s.X(paramab, localc.name);
          }
          paramInt = i;
          break;
          paramContext = paramContext.abLK;
          if (paramContext == null)
          {
            paramContext = null;
            break label250;
          }
          paramContext = paramContext.abLG;
          if (paramContext == null)
          {
            paramContext = null;
            break label250;
          }
          paramContext = paramContext.abLJ;
          if (paramContext == null)
          {
            paramContext = null;
            break label250;
          }
          paramContext = paramContext.YVA;
          break label250;
          j = ((LinkedList)localObject2).size() - 1;
        } while (j < 0);
        for (paramInt = 0;; paramInt = i)
        {
          i = paramInt + 1;
          paramab.add(new c((String)((LinkedList)localObject2).get(paramInt), paramInt));
          if (i > j) {
            break;
          }
        }
        h.OAn.b(18644, new Object[] { ((ab)localObject1).iYo().abLF.UserName, Long.valueOf(((ab)localObject1).iYp().abry), paramContext, Integer.valueOf(ad.getSessionId()), Integer.valueOf(this.pos) });
        mk(paramb);
        this.vIH.nhC.setOnClickListener((View.OnClickListener)this);
        AppMethodBeat.o(6545);
        return;
      }
    }
  }
  
  private static final CharSequence a(TextView paramTextView, int paramInt, c paramc)
  {
    return (CharSequence)paramc.name;
  }
  
  private static final void a(b paramb, TextView paramTextView, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(302648);
    s.u(paramb, "this$0");
    paramTextView = paramb.vIH.nhC;
    if (paramb.vIH.vII.getSelectLabels().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramTextView.setEnabled(bool);
      AppMethodBeat.o(302648);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6544);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    s.u(paramView, "v");
    if (paramView.getId() == d.e.ok_btn)
    {
      Object localObject2 = this.vIH.vII.getSelectLabelDatas();
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
            localObject1 = s.X(paramView, "#");
          }
          paramView = s.X((String)localObject1, localc.name);
        }
      }
      paramView = this.vHY.vFK;
      localObject2 = this.vGS.iYo().abLF.UserName;
      long l = this.vGS.iYp().abry;
      int i = (int)(System.currentTimeMillis() / 1000L);
      h.OAn.b(15721, new Object[] { localObject2, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(paramView.hBm), Integer.valueOf(0), Long.valueOf(l), localObject1, Integer.valueOf(1), Integer.valueOf(0) });
      af.bHl().yQ(this.vGS.field_msgId);
      dismiss();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6544);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    Button nhC;
    LabelsView vII;
    private TextView vIJ;
    
    public b(View paramView)
    {
      AppMethodBeat.i(6540);
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
      AppMethodBeat.o(6540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.b
 * JD-Core Version:    0.7.0.1
 */