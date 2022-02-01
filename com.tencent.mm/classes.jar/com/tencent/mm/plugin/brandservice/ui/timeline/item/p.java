package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "picNumTv", "Landroid/widget/TextView;", "getPicNumTv", "()Landroid/widget/TextView;", "setPicNumTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "Landroid/view/View;", "parent", "gone", "onInflate", "plugin-brandservice_release"})
public final class p
  extends n
{
  private int llp;
  private TextView sDY;
  private int viewId;
  
  public p(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(265927);
    this.llp = 8;
    this.viewId = d.e.dZx;
    AppMethodBeat.o(265927);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(265924);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramView1, "convertView");
    kotlin.g.b.p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = ((dur)paramz.Ven.UaA.get(0)).UaX;
    paramView1 = paramView2.Tuc;
    if (paramView1 != null)
    {
      paramInt = paramView1.iUE;
      if (paramInt <= 0) {
        break label210;
      }
      paramView1 = this.sDY;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      TextView localTextView = this.sDY;
      if (localTextView != null)
      {
        paramView1 = paramView2.Tuc;
        if (paramView1 == null) {
          break label205;
        }
        paramView1 = Integer.valueOf(paramView1.iUE);
        label114:
        localTextView.setText((CharSequence)String.valueOf(paramView1));
      }
    }
    for (;;)
    {
      paramInt = b.sAr;
      X(this.sDp, paramInt);
      d.apR(paramz.getId());
      this.sCg.sAc.a(paramz.field_orderFlag, 0, cAy(), paramView2.RTm, getCoverIv(), getWidth(), paramInt, false, (m.a)new a(), false, paramz.sHe);
      AppMethodBeat.o(265924);
      return;
      paramInt = 0;
      break;
      label205:
      paramView1 = null;
      break label114;
      label210:
      paramView1 = this.sDY;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(265926);
    View localView = getItemView();
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(265926);
      return;
    }
    AppMethodBeat.o(265926);
  }
  
  public final void cAz()
  {
    AppMethodBeat.i(265925);
    Object localObject = getItemView();
    if (localObject != null) {}
    for (localObject = (TextView)((View)localObject).findViewById(d.e.ssq);; localObject = null)
    {
      this.sDY = ((TextView)localObject);
      AppMethodBeat.o(265925);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p
 * JD-Core Version:    0.7.0.1
 */