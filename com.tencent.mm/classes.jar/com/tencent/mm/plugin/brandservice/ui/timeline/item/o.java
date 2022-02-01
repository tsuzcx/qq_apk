package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "picNumTv", "Landroid/widget/TextView;", "getPicNumTv", "()Landroid/widget/TextView;", "setPicNumTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "onInflate", "plugin-brandservice_release"})
public final class o
  extends n
{
  private int iwc;
  private TextView puD;
  private int viewId;
  
  public o(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195310);
    this.iwc = 8;
    this.viewId = 2131309894;
    AppMethodBeat.o(195310);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195307);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = ((dlb)paramz.NQr.MOG.get(0)).MOY;
    paramView1 = paramView2.Mjo;
    if (paramView1 != null)
    {
      paramInt = paramView1.gqw;
      if (paramInt <= 0) {
        break label214;
      }
      paramView1 = this.puD;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      TextView localTextView = this.puD;
      if (localTextView != null)
      {
        paramView1 = paramView2.Mjo;
        if (paramView1 == null) {
          break label209;
        }
        paramView1 = Integer.valueOf(paramView1.gqw);
        label114:
        localTextView.setText((CharSequence)String.valueOf(paramView1));
      }
    }
    for (;;)
    {
      paramInt = b.prt;
      V(this.puc, paramInt);
      V((View)this.ptS, paramInt);
      this.psQ.prc.a(paramz.field_msgId, 0, this.ptH, paramView2.KSl, this.puw, this.width, paramInt, false, (m.a)new a(), false, paramz.pxD);
      AppMethodBeat.o(195307);
      return;
      paramInt = 0;
      break;
      label209:
      paramView1 = null;
      break label114;
      label214:
      paramView1 = this.puD;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195309);
    View localView = this.aus;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195309);
      return;
    }
    AppMethodBeat.o(195309);
  }
  
  public final void cmP()
  {
    AppMethodBeat.i(195308);
    Object localObject = this.aus;
    if (localObject != null) {}
    for (localObject = (TextView)((View)localObject).findViewById(2131305935);; localObject = null)
    {
      this.puD = ((TextView)localObject);
      AppMethodBeat.o(195308);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.o
 * JD-Core Version:    0.7.0.1
 */