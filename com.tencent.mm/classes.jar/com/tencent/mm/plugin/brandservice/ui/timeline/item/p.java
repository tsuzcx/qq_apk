package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import java.util.LinkedList;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "MAX_LINE_NUM", "", "getMAX_LINE_NUM", "()I", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "plugin-brandservice_release"})
public final class p
  extends n
{
  private int iwc;
  private final int puE;
  private int viewId;
  
  public p(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195313);
    this.iwc = 10;
    this.viewId = 2131309897;
    this.puE = 4;
    AppMethodBeat.o(195313);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    int i = 0;
    AppMethodBeat.i(195311);
    kotlin.g.b.p.h(paramz, "info");
    kotlin.g.b.p.h(paramView1, "convertView");
    kotlin.g.b.p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramz = ((dlb)paramz.NQr.MOG.get(0)).MOY;
    paramView1 = this.ptR;
    if (paramView1 != null)
    {
      paramView2 = this.context;
      CharSequence localCharSequence = (CharSequence)paramz.Title;
      paramz = this.ptR;
      if (paramz != null)
      {
        paramz = Float.valueOf(paramz.getTextSize());
        if (paramz == null) {
          kotlin.g.b.p.hyc();
        }
        paramView1.aw((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.j(paramView2, localCharSequence, (int)paramz.floatValue()));
      }
    }
    else
    {
      paramz = this.ptR;
      if (paramz == null) {
        break label231;
      }
      paramz = paramz.mq(this.width, 2147483647);
      label141:
      paramInt = i;
      if (paramz != null) {
        paramInt = paramz.hiG();
      }
      paramz = this.ptR;
      if (paramz == null) {
        break label236;
      }
      paramz = paramz.getLayoutParams();
      label169:
      paramView1 = paramz;
      if (!(paramz instanceof LinearLayout.LayoutParams)) {
        paramView1 = null;
      }
      paramz = (LinearLayout.LayoutParams)paramView1;
      if (paramInt >= this.puE) {
        break label241;
      }
      if (paramz != null) {
        paramz.gravity = 17;
      }
    }
    for (;;)
    {
      paramView1 = this.ptR;
      if (paramView1 == null) {
        break label254;
      }
      paramView1.setLayoutParams((ViewGroup.LayoutParams)paramz);
      AppMethodBeat.o(195311);
      return;
      paramz = null;
      break;
      label231:
      paramz = null;
      break label141;
      label236:
      paramz = null;
      break label169;
      label241:
      if (paramz != null) {
        paramz.gravity = 8388627;
      }
    }
    label254:
    AppMethodBeat.o(195311);
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195312);
    View localView = this.aus;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195312);
      return;
    }
    AppMethodBeat.o(195312);
  }
  
  public final int getItemShowType()
  {
    return this.iwc;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p
 * JD-Core Version:    0.7.0.1
 */