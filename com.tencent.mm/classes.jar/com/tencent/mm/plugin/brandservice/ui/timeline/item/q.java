package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "MAX_LINE_NUM", "", "getMAX_LINE_NUM", "()I", "itemShowType", "getItemShowType", "setItemShowType", "(I)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "plugin-brandservice_release"})
public final class q
  extends n
{
  private int llp;
  private final int sDZ;
  private int viewId;
  
  public q(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(264575);
    this.llp = 10;
    this.viewId = d.e.dZz;
    this.sDZ = 4;
    AppMethodBeat.o(264575);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    int i = 0;
    AppMethodBeat.i(264573);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramz = ((dur)paramz.Ven.UaA.get(0)).UaX;
    paramView1 = cAw();
    if (paramView1 != null)
    {
      paramView2 = this.context;
      CharSequence localCharSequence = (CharSequence)paramz.fwr;
      paramz = cAw();
      if (paramz != null)
      {
        paramz = Float.valueOf(paramz.getTextSize());
        if (paramz == null) {
          p.iCn();
        }
        paramView1.aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.k(paramView2, localCharSequence, (int)paramz.floatValue()));
      }
    }
    else
    {
      paramz = cAw();
      if (paramz == null) {
        break label231;
      }
      paramz = paramz.nH(getWidth(), 2147483647);
      label141:
      paramInt = i;
      if (paramz != null) {
        paramInt = paramz.ikp();
      }
      paramz = cAw();
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
      if (paramInt >= this.sDZ) {
        break label241;
      }
      if (paramz != null) {
        paramz.gravity = 17;
      }
    }
    for (;;)
    {
      paramView1 = cAw();
      if (paramView1 == null) {
        break label254;
      }
      paramView1.setLayoutParams((ViewGroup.LayoutParams)paramz);
      AppMethodBeat.o(264573);
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
    AppMethodBeat.o(264573);
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(264574);
    View localView = getItemView();
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(264574);
      return;
    }
    AppMethodBeat.o(264574);
  }
  
  public final int getItemShowType()
  {
    return this.llp;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q
 * JD-Core Version:    0.7.0.1
 */