package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends m
{
  private int nQm;
  private int viewId;
  
  public l(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302711);
    this.viewId = d.e.viewstub_top_article_slot;
    AppMethodBeat.o(302711);
  }
  
  public final void a(ddb paramddb)
  {
    AppMethodBeat.i(302739);
    s.u(paramddb, "itemInfo");
    super.a(paramddb);
    paramddb = paramddb.YQO;
    if (paramddb != null) {
      ddy().nUM = paramddb;
    }
    AppMethodBeat.o(302739);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302731);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView2 = (enp)paramab.acFJ.abrC.get(0);
    paramView1 = paramView2.abse;
    MMNeat7extView localMMNeat7extView = ddw();
    if (localMMNeat7extView != null) {
      localMMNeat7extView.aZ((CharSequence)paramView1.hAP);
    }
    s.s(paramView2, "itemMsg");
    int i;
    if ((ah.e(paramView2)) && (!Util.isNullOrNil(paramView1.YQI)))
    {
      paramView2 = ddx();
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = ddx();
      if (paramView2 != null) {
        paramView2.aZ((CharSequence)paramView1.YQI);
      }
      i = b.vGb;
      ab(this.vJg, i);
      paramView2 = (CharSequence)paramView1.YQO;
      if ((paramView2 != null) && (!n.bp(paramView2))) {
        break label296;
      }
      paramInt = 1;
      label181:
      if (paramInt == 0) {
        break label301;
      }
    }
    label296:
    label301:
    for (paramView1 = paramView1.YQM;; paramView1 = paramView1.YQO)
    {
      ddo();
      d.ajs(paramab.getId());
      ddo().vFN.a(paramab.field_orderFlag, 0, ddy(), paramView1, getCoverIv(), getWidth(), i, false, (m.a)new a(), false, paramab.vMB);
      AppMethodBeat.o(302731);
      return;
      paramView2 = ddx();
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      paramView2 = ddx();
      if (paramView2 == null) {
        break;
      }
      paramView2.aZ((CharSequence)"");
      break;
      paramInt = 0;
      break label181;
    }
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302744);
    View localView = getItemView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302744);
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.l
 * JD-Core Version:    0.7.0.1
 */