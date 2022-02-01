package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.biz.b.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.r;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getContext", "()Landroid/content/Context;", "hasProcessCrash", "", "item", "Landroid/view/View;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "show", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends ab
{
  private final String TAG;
  private final Context context;
  private int style;
  private final b vHY;
  private View vJU;
  private BizTLRecCardCanvasView vKq;
  private boolean vKr;
  
  public ac(b paramb, Context paramContext)
  {
    AppMethodBeat.i(302496);
    this.vHY = paramb;
    this.context = paramContext;
    this.TAG = "MicroMsg.BizTLRecFeedCanvas";
    this.style = 2003;
    AppMethodBeat.o(302496);
  }
  
  public final int TY()
  {
    return this.style;
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302506);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    String str = s.X("__rec_feed_", paramab.acFJ.YSF);
    Object localObject = j.WkY;
    j.xC(71L);
    Log.i(this.TAG, "filling#" + str + " msgId=" + paramab.field_orderFlag);
    localObject = r.acDM;
    if (!r.iXo())
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(302506);
      return;
    }
    if (!this.vKr)
    {
      localObject = c.vtp;
      if (!c.e(str, paramView1))
      {
        paramab = j.WkY;
        j.xC(73L);
        AppMethodBeat.o(302506);
        return;
      }
    }
    this.vKr = true;
    s.u(paramView2, "parent");
    if (this.vJU == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.viewstub_feed_canvas)).inflate();
      this.vKq = ((BizTLRecCardCanvasView)paramView1.findViewById(d.e.rec_feed_canvas));
      paramView2 = ah.aiuX;
      this.vJU = paramView1;
    }
    paramView1 = this.vJU;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = this.vKq;
    if (paramView1 != null) {
      paramView1.setBizTimeLineInfo(paramab);
    }
    paramView1 = this.vKq;
    if (paramView1 != null)
    {
      long l = paramab.field_orderFlag;
      paramab = paramab.iYv();
      s.s(paramab, "info.recFeedData");
      paramView1.a(l, str, "rec-feed", paramab);
    }
    paramab = j.WkY;
    j.xC(72L);
    paramab = c.vtp;
    c.ail(str);
    AppMethodBeat.o(302506);
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302513);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302513);
  }
  
  public final void show()
  {
    AppMethodBeat.i(302518);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(302518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac
 * JD-Core Version:    0.7.0.1
 */