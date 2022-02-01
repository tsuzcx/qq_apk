package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "playTimeTv", "Landroid/widget/TextView;", "getPlayTimeTv", "()Landroid/widget/TextView;", "setPlayTimeTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "getViewContainer", "gone", "onInflate", "plugin-brandservice_release"})
public final class r
  extends n
{
  private int llp;
  TextView sDo;
  private int viewId;
  
  public r(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(257692);
    this.llp = 5;
    this.viewId = d.e.dZA;
    AppMethodBeat.o(257692);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(257689);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = (dur)paramz.Ven.UaA.get(0);
    paramView1 = ((dur)paramz.Ven.UaA.get(0)).UaX;
    Object localObject = cAw();
    if (localObject != null) {
      ((MMNeat7extView)localObject).aL((CharSequence)paramView1.fwr);
    }
    paramView2 = paramView2.UaX.Tua;
    if (paramView2.RTy > 0)
    {
      localObject = this.sDo;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      m.uD(paramView2.RTy);
      localObject = this.sDo;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)m.uD(paramView2.RTy));
      }
      paramView2 = this.sDo;
      if (paramView2 != null) {
        paramView2.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(d.b.BW_0_Alpha_0_5));
      }
    }
    for (;;)
    {
      paramInt = b.sAr;
      X(this.sDp, paramInt);
      d.apR(paramz.getId());
      this.sCg.sAc.a(paramz.field_orderFlag, 0, cAy(), paramView1.RTm, getCoverIv(), getWidth(), paramInt, false, (m.a)new a(this), false, paramz.sHe);
      paramz = e.sKW;
      e.G(cAy().url, cAy().type, "");
      AppMethodBeat.o(257689);
      return;
      paramView2 = this.sDo;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
    }
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(257691);
    View localView = getItemView();
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(257691);
      return;
    }
    AppMethodBeat.o(257691);
  }
  
  public final void cAz()
  {
    AppMethodBeat.i(257690);
    Object localObject = getItemView();
    if (localObject != null) {}
    for (localObject = (TextView)((View)localObject).findViewById(d.e.sss);; localObject = null)
    {
      this.sDo = ((TextView)localObject);
      AppMethodBeat.o(257690);
      return;
    }
  }
  
  public final int getItemShowType()
  {
    return this.llp;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    public final void onFinish()
    {
      AppMethodBeat.i(265294);
      TextView localTextView = this.sEa.sDo;
      if (localTextView != null)
      {
        localTextView.setTextColor(this.sEa.context.getResources().getColor(d.b.white_text_color));
        AppMethodBeat.o(265294);
        return;
      }
      AppMethodBeat.o(265294);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.r
 * JD-Core Version:    0.7.0.1
 */