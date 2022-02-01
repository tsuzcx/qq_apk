package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.storage.ab;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "picIconAndNum", "Landroid/view/View;", "getPicIconAndNum", "()Landroid/view/View;", "setPicIconAndNum", "(Landroid/view/View;)V", "picNumTv", "Landroid/widget/TextView;", "getPicNumTv", "()Landroid/widget/TextView;", "setPicNumTv", "(Landroid/widget/TextView;)V", "viewId", "getViewId", "setViewId", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "onInflate", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends m
{
  private int nQm;
  private TextView vJJ;
  private View vJK;
  private int viewId;
  
  public o(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302751);
    this.nQm = 8;
    this.viewId = d.e.viewstub_top_pic_slot;
    AppMethodBeat.o(302751);
  }
  
  public final void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302788);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    super.a(paramab, paramInt, paramView1, paramView2);
    paramView2 = ((enp)paramab.acFJ.abrC.get(0)).abse;
    paramView1 = paramView2.aaIF;
    if (paramView1 == null)
    {
      paramInt = 0;
      if (paramInt <= 0) {
        break label289;
      }
      paramView1 = this.vJJ;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      Object localObject = this.vJJ;
      if (localObject != null)
      {
        paramView1 = paramView2.aaIF;
        if (paramView1 != null) {
          break label278;
        }
        paramView1 = null;
        label105:
        ((TextView)localObject).setText((CharSequence)String.valueOf(paramView1));
      }
      paramView1 = this.vJK;
      if (paramView1 != null)
      {
        localObject = am.aixg;
        localObject = this.context.getResources().getString(d.i.biz_timeline_msg_img_multi);
        s.s(localObject, "context.resources.getStr…z_timeline_msg_img_multi)");
        localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
        s.s(localObject, "java.lang.String.format(format, *args)");
        paramView1.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      paramInt = b.vGd;
      ab(this.vJg, paramInt);
      ddo();
      d.ajs(paramab.getId());
      ddo().vFN.a(paramab.field_orderFlag, 0, ddy(), paramView2.YQM, getCoverIv(), getWidth(), paramInt, false, (m.a)new a(), false, paramab.vMB);
      AppMethodBeat.o(302788);
      return;
      paramInt = paramView1.lwJ;
      break;
      label278:
      paramView1 = Integer.valueOf(paramView1.lwJ);
      break label105;
      label289:
      paramView1 = this.vJJ;
      if (paramView1 != null) {
        paramView1.setText((CharSequence)"");
      }
      paramView1 = this.vJJ;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.vJK;
      if (paramView1 != null) {
        paramView1.setContentDescription((CharSequence)this.context.getResources().getString(d.i.biz_timeline_msg_img_single));
      }
    }
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302803);
    View localView = getItemView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302803);
  }
  
  public final void ddz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(302794);
    Object localObject1 = getItemView();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.vJJ = ((TextView)localObject1);
      localObject1 = getItemView();
      if (localObject1 != null) {
        break label61;
      }
    }
    label61:
    for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(d.e.rec_pic_icon_and_num))
    {
      this.vJK = ((View)localObject1);
      AppMethodBeat.o(302794);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(d.e.pic_num_tv);
      break;
    }
  }
  
  public final int getItemShowType()
  {
    return this.nQm;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic$filling$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.o
 * JD-Core Version:    0.7.0.1
 */