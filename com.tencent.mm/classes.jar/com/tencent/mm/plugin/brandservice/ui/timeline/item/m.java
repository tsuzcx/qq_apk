package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "plugin-brandservice_release"})
public final class m
  extends n
{
  private int llp;
  private int viewId;
  
  public m(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(258139);
    this.viewId = d.e.sty;
    AppMethodBeat.o(258139);
  }
  
  public final void a(cmo paramcmo)
  {
    AppMethodBeat.i(258136);
    p.k(paramcmo, "itemInfo");
    super.a(paramcmo);
    paramcmo = paramcmo.RTo;
    if (paramcmo != null)
    {
      cAy().lpK = paramcmo;
      AppMethodBeat.o(258136);
      return;
    }
    AppMethodBeat.o(258136);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(258135);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = (dur)paramz.Ven.UaA.get(0);
    paramView1 = paramView2.UaX;
    MMNeat7extView localMMNeat7extView = cAw();
    if (localMMNeat7extView != null) {
      localMMNeat7extView.aL((CharSequence)paramView1.fwr);
    }
    p.j(paramView2, "itemMsg");
    int i;
    if ((af.e(paramView2)) && (!Util.isNullOrNil(paramView1.RTi)))
    {
      paramView2 = cAx();
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = cAx();
      if (paramView2 != null) {
        paramView2.aL((CharSequence)paramView1.RTi);
      }
      i = b.sAp;
      X(this.sDp, i);
      paramView2 = (CharSequence)paramView1.RTo;
      if ((paramView2 != null) && (!kotlin.n.n.ba(paramView2))) {
        break label270;
      }
      paramInt = 1;
      label181:
      if (paramInt == 0) {
        break label275;
      }
    }
    label270:
    label275:
    for (paramView1 = paramView1.RTm;; paramView1 = paramView1.RTo)
    {
      d.apR(paramz.getId());
      this.sCg.sAc.a(paramz.field_orderFlag, 0, cAy(), paramView1, getCoverIv(), getWidth(), i, false, (com.tencent.mm.pluginsdk.ui.applet.m.a)new a(), false, paramz.sHe);
      AppMethodBeat.o(258135);
      return;
      paramView2 = cAx();
      if (paramView2 == null) {
        break;
      }
      paramView2.setVisibility(8);
      break;
      paramInt = 0;
      break label181;
    }
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(258138);
    View localView = getItemView();
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(258138);
      return;
    }
    AppMethodBeat.o(258138);
  }
  
  public final int getItemShowType()
  {
    return this.llp;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements com.tencent.mm.pluginsdk.ui.applet.m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.m
 * JD-Core Version:    0.7.0.1
 */