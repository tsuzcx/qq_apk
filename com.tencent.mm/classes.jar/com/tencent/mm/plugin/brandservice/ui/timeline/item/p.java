package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "MAX_LINE_NUM", "", "getMAX_LINE_NUM", "()I", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends m
{
  private int nQm;
  private final int vJL;
  private int viewId;
  
  public p(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302721);
    this.nQm = 10;
    this.viewId = d.e.viewstub_top_text_slot;
    this.vJL = 4;
    AppMethodBeat.o(302721);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302746);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramab = ((enp)paramab.acFJ.abrC.get(0)).abse;
    paramView1 = ddw();
    if (paramView1 != null)
    {
      paramView2 = this.context;
      CharSequence localCharSequence = (CharSequence)paramab.hAP;
      paramab = ddw();
      if (paramab == null)
      {
        paramab = null;
        s.checkNotNull(paramab);
        paramView1.aZ((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.j(paramView2, localCharSequence, (int)paramab.floatValue()));
      }
    }
    else
    {
      paramab = ddw();
      if (paramab != null) {
        break label201;
      }
      paramab = null;
      label120:
      if (paramab != null) {
        break label215;
      }
      paramInt = 0;
      label126:
      paramab = ddw();
      if (paramab != null) {
        break label225;
      }
      paramab = null;
      label137:
      if (!(paramab instanceof LinearLayout.LayoutParams)) {
        break label233;
      }
      paramab = (LinearLayout.LayoutParams)paramab;
      label149:
      if (paramInt >= this.vJL) {
        break label238;
      }
      if (paramab != null) {
        paramab.gravity = 17;
      }
    }
    for (;;)
    {
      paramView1 = ddw();
      if (paramView1 != null) {
        paramView1.setLayoutParams((ViewGroup.LayoutParams)paramab);
      }
      AppMethodBeat.o(302746);
      return;
      paramab = Float.valueOf(paramab.getTextSize());
      break;
      label201:
      paramab = paramab.pE(getWidth(), 2147483647);
      break label120;
      label215:
      paramInt = paramab.jQH();
      break label126;
      label225:
      paramab = paramab.getLayoutParams();
      break label137;
      label233:
      paramab = null;
      break label149;
      label238:
      if (paramab != null) {
        paramab.gravity = 8388627;
      }
    }
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302750);
    View localView = getItemView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302750);
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p
 * JD-Core Version:    0.7.0.1
 */