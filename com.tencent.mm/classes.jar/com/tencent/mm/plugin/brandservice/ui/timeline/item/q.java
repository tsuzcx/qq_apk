package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "playTimeTv", "Landroid/widget/TextView;", "getPlayTimeTv", "()Landroid/widget/TextView;", "setPlayTimeTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "getViewContainer", "gone", "onInflate", "plugin-brandservice_release"})
public final class q
  extends n
{
  private int iwc;
  TextView pub;
  private int viewId;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195318);
    this.iwc = 5;
    this.viewId = 2131309898;
    AppMethodBeat.o(195318);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195315);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = (dlb)paramz.NQr.MOG.get(0);
    paramView1 = ((dlb)paramz.NQr.MOG.get(0)).MOY;
    Object localObject = this.ptR;
    if (localObject != null) {
      ((MMNeat7extView)localObject).aw((CharSequence)paramView1.Title);
    }
    paramView2 = paramView2.MOY.Mjm;
    if (paramView2.KSx > 0)
    {
      localObject = this.pub;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      m.rJ(paramView2.KSx);
      localObject = this.pub;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)m.rJ(paramView2.KSx));
      }
      paramView2 = this.pub;
      if (paramView2 != null) {
        paramView2.setShadowLayer(10.0F, 0.0F, 0.0F, this.context.getResources().getColor(2131099665));
      }
    }
    for (;;)
    {
      paramInt = b.prt;
      V(this.puc, paramInt);
      V((View)this.ptS, paramInt);
      this.psQ.prc.a(paramz.field_msgId, 0, this.ptH, paramView1.KSl, this.puw, this.width, paramInt, false, (m.a)new a(this), false, paramz.pxD);
      paramz = e.pAN;
      e.F(this.ptH.url, this.ptH.type, "");
      AppMethodBeat.o(195315);
      return;
      paramView2 = this.pub;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
    }
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195317);
    View localView = this.aus;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195317);
      return;
    }
    AppMethodBeat.o(195317);
  }
  
  public final void cmP()
  {
    AppMethodBeat.i(195316);
    Object localObject = this.aus;
    if (localObject != null) {}
    for (localObject = (TextView)((View)localObject).findViewById(2131305961);; localObject = null)
    {
      this.pub = ((TextView)localObject);
      AppMethodBeat.o(195316);
      return;
    }
  }
  
  public final int getItemShowType()
  {
    return this.iwc;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    public final void onFinish()
    {
      AppMethodBeat.i(195314);
      TextView localTextView = this.puF.pub;
      if (localTextView != null)
      {
        localTextView.setTextColor(this.puF.context.getResources().getColor(2131101427));
        AppMethodBeat.o(195314);
        return;
      }
      AppMethodBeat.o(195314);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q
 * JD-Core Version:    0.7.0.1
 */