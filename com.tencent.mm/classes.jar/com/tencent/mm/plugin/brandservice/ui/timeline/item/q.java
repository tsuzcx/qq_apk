package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.fxo;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "playTimeShadow", "Landroid/view/View;", "getPlayTimeShadow", "()Landroid/view/View;", "setPlayTimeShadow", "(Landroid/view/View;)V", "playTimeTv", "Landroid/widget/TextView;", "getPlayTimeTv", "()Landroid/widget/TextView;", "setPlayTimeTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "getViewContainer", "gone", "onInflate", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends m
{
  private int nQm;
  TextView vJf;
  private View vJi;
  private int viewId;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302645);
    this.nQm = 5;
    this.viewId = d.e.viewstub_top_video_slot;
    AppMethodBeat.o(302645);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302669);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView2 = (enp)paramab.acFJ.abrC.get(0);
    paramView1 = ((enp)paramab.acFJ.abrC.get(0)).abse;
    Object localObject = ddw();
    if (localObject != null) {
      ((MMNeat7extView)localObject).aZ((CharSequence)paramView1.hAP);
    }
    paramView2 = paramView2.abse.aaID;
    if (paramView2.YQY > 0)
    {
      localObject = this.vJi;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.vJf;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      com.tencent.mm.message.m.uD(paramView2.YQY);
      localObject = this.vJf;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.message.m.uD(paramView2.YQY));
      }
    }
    for (;;)
    {
      paramView2 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vJf);
      paramView2 = this.vJf;
      if (paramView2 != null) {
        paramView2.setShadowLayer(10.0F, 0.0F, 1.0F, this.context.getResources().getColor(d.b.BW_0_Alpha_0_3));
      }
      paramInt = b.vGd;
      ab(this.vJg, paramInt);
      ddo();
      d.ajs(paramab.getId());
      ddo().vFN.a(paramab.field_orderFlag, 0, ddy(), paramView1.YQM, getCoverIv(), getWidth(), paramInt, false, (m.a)new a(this), false, paramab.vMB);
      paramab = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(ddy().url, ddy().type, "");
      AppMethodBeat.o(302669);
      return;
      paramView2 = this.vJf;
      if (paramView2 != null) {
        paramView2.setText((CharSequence)"");
      }
      paramView2 = this.vJf;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      paramView2 = this.vJi;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
    }
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302680);
    View localView = getItemView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302680);
  }
  
  public final void ddz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(302676);
    Object localObject1 = getItemView();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.vJf = ((TextView)localObject1);
      localObject1 = getItemView();
      if (localObject1 != null) {
        break label61;
      }
    }
    label61:
    for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(d.e.play_time_tv_shadow))
    {
      this.vJi = ((View)localObject1);
      AppMethodBeat.o(302676);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(d.e.play_time_tv);
      break;
    }
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    a(q paramq) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(302781);
      TextView localTextView = this.vJM.vJf;
      if (localTextView != null) {
        localTextView.setTextColor(this.vJM.context.getResources().getColor(d.b.white_text_color));
      }
      AppMethodBeat.o(302781);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q
 * JD-Core Version:    0.7.0.1
 */