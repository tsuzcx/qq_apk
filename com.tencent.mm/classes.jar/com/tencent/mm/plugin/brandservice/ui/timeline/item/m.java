package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "plugin-brandservice_release"})
public final class m
  extends n
{
  private int iwc;
  private int viewId;
  
  public m(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195305);
    this.viewId = 2131309892;
    AppMethodBeat.o(195305);
  }
  
  public final void a(cdu paramcdu)
  {
    AppMethodBeat.i(195303);
    p.h(paramcdu, "itemInfo");
    super.a(paramcdu);
    paramcdu = paramcdu.KSn;
    if (paramcdu != null)
    {
      this.ptH.iAo = paramcdu;
      AppMethodBeat.o(195303);
      return;
    }
    AppMethodBeat.o(195303);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195302);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView1 = ((dlb)paramz.NQr.MOG.get(0)).MOY;
    paramView2 = this.ptR;
    if (paramView2 != null) {
      paramView2.aw((CharSequence)paramView1.Title);
    }
    int i = b.prr;
    V(this.puc, i);
    V((View)this.ptS, i);
    paramView2 = (CharSequence)paramView1.KSn;
    if ((paramView2 == null) || (kotlin.n.n.aL(paramView2)))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label190;
      }
    }
    label190:
    for (paramView1 = paramView1.KSl;; paramView1 = paramView1.KSn)
    {
      this.psQ.prc.a(paramz.field_msgId, 0, this.ptH, paramView1, this.puw, this.width, i, false, (com.tencent.mm.pluginsdk.ui.applet.m.a)new a(), false, paramz.pxD);
      AppMethodBeat.o(195302);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195304);
    View localView = this.aus;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195304);
      return;
    }
    AppMethodBeat.o(195304);
  }
  
  public final int getItemShowType()
  {
    return this.iwc;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements com.tencent.mm.pluginsdk.ui.applet.m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.m
 * JD-Core Version:    0.7.0.1
 */