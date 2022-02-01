package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.m;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeShadow", "getPlayTimeShadow", "()Landroid/view/View;", "setPlayTimeShadow", "(Landroid/view/View;)V", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getVideoViewContainer", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
{
  private ImageView dpM;
  private ImageView vIK;
  private final v vIN;
  TextView vJf;
  View vJg;
  private View vJh;
  private View vJi;
  
  public g(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302636);
    this.vIN = new v();
    AppMethodBeat.o(302636);
  }
  
  private final void c(final ab paramab, qo paramqo, final qn paramqn)
  {
    AppMethodBeat.i(302644);
    final ah.a locala = new ah.a();
    label99:
    Object localObject;
    int i;
    int j;
    boolean bool;
    switch (paramab.iYp().style)
    {
    default: 
      this.vIN.type = paramqn.nUA;
      this.vIN.nUM = paramqn.YQM;
      this.vIN.nVd = paramqn.YQM;
      this.vIN.url = paramqn.YQK;
      paramqo = this.vJg;
      if (paramqo == null)
      {
        paramqo = null;
        if (paramqo != null) {
          paramqo.height = b.vGc;
        }
        localObject = this.vJg;
        if (localObject != null) {
          ((View)localObject).setLayoutParams(paramqo);
        }
        paramqo = com.tencent.mm.plugin.bizui.a.a.vtB;
        i = com.tencent.mm.plugin.bizui.a.a.fK(this.context);
        j = b.vGg;
        ddo().vFN.a(paramab.field_msgId, 0, this.vIN, paramqn.YQM, this.vIK, i - j, b.vGc, false, (m.a)new a(this, locala, paramab, paramqn), false, paramab.vMB);
        AppMethodBeat.o(302644);
        return;
      }
      break;
    case 101: 
      if (paramqo.YVI.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        locala.aiwY = bool;
        break;
      }
    case 102: 
      paramqo = paramab.iYp().abLM.YSB;
      s.s(paramqo, "info.tlRecCardWrapper.extraInfo.BizInfo");
      paramqo = (Iterable)p.c((Iterable)paramqo, 2);
      j = 0;
      paramqo = paramqo.iterator();
      i = 0;
      label279:
      if (paramqo.hasNext())
      {
        localObject = paramqo.next();
        if (j < 0) {
          p.kkW();
        }
        if (((qo)localObject).YFu != 0) {
          break label363;
        }
        i += 1;
      }
      break;
    }
    label363:
    for (;;)
    {
      j += 1;
      break label279;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        locala.aiwY = bool;
        break;
      }
      paramqo = paramqo.getLayoutParams();
      break label99;
    }
  }
  
  public final void a(View paramView, ab paramab, qo paramqo)
  {
    AppMethodBeat.i(302656);
    s.u(paramView, "parent");
    s.u(paramab, "info");
    s.u(paramqo, "bizInfo");
    aa(paramView, d.e.viewstub_top_video_slot);
    if (getItemView() == null)
    {
      AppMethodBeat.o(302656);
      return;
    }
    paramView = getItemView();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    qn localqn = (qn)paramqo.YVI.get(0);
    s.s(localqn, "appMsg");
    a(paramab, paramqo, localqn);
    float f = 0.5F;
    paramView = this.vIW;
    int i;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label264;
      }
      paramView = com.tencent.mm.plugin.bizui.a.a.vtB;
      i = com.tencent.mm.plugin.bizui.a.a.fK(this.context);
      int j = com.tencent.mm.cd.a.fromDPToPix(this.context, 48);
      paramView = this.vIW;
      if (paramView != null) {
        paramView.measure(i - j, 0);
      }
      paramView = this.vJg;
      s.checkNotNull(paramView);
      i = paramView.getLayoutParams().height;
      paramView = this.vIW;
      s.checkNotNull(paramView);
      j = paramView.getMeasuredHeight();
      int k = b.vGm;
      f = 0.56F;
      i = i - j - k;
      label217:
      if (this.vJh == null) {
        break label320;
      }
      paramView = this.vJh;
      if (paramView != null) {
        break label285;
      }
    }
    label264:
    label285:
    for (paramView = null;; paramView = paramView.getLayoutParams())
    {
      if (paramView != null) {
        break label293;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(302656);
      throw paramView;
      i = 0;
      break;
      paramView = this.vJg;
      s.checkNotNull(paramView);
      i = paramView.getLayoutParams().height;
      break label217;
    }
    label293:
    ((RelativeLayout.LayoutParams)paramView).topMargin = ((int)(i * f - com.tencent.mm.cd.a.fromDPToPix(this.context, 48) / 2));
    label320:
    paramView = m.uD(localqn.YQY);
    if (!TextUtils.isEmpty((CharSequence)paramView))
    {
      Object localObject = this.vJi;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.vJf;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.vJf;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramView);
      }
      paramView = this.vJf;
      if (paramView != null) {
        paramView.setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
      }
    }
    for (;;)
    {
      paramView = this.vJf;
      if (paramView != null) {
        paramView.setShadowLayer(10.0F, 0.0F, 1.0F, this.context.getResources().getColor(d.b.BW_0_Alpha_0_3));
      }
      c(paramab, paramqo, localqn);
      b(paramab, paramqo, localqn);
      paramView = e.vQH;
      e.I(this.vIN.url, this.vIN.type, "");
      AppMethodBeat.o(302656);
      return;
      paramView = this.vJf;
      if (paramView != null) {
        paramView.setText((CharSequence)"");
      }
      paramView = this.vJi;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = this.vJf;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public final void aa(View paramView, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(302670);
    s.u(paramView, "parent");
    if (getItemView() == null)
    {
      super.aa(paramView, paramInt);
      Object localObject1 = getItemView();
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (ImageView)((View)localObject1).findViewById(d.e.cover))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(302670);
        throw paramView;
      }
      this.vIK = ((ImageView)localObject1);
      localObject1 = getItemView();
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (ImageView)((View)localObject1).findViewById(d.e.video_icon))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(302670);
        throw paramView;
      }
      this.dpM = ((ImageView)localObject1);
      localObject1 = getItemView();
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (TextView)((View)localObject1).findViewById(d.e.play_time_tv))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(302670);
        throw paramView;
      }
      this.vJf = ((TextView)localObject1);
      localObject1 = getItemView();
      if (localObject1 == null)
      {
        localObject1 = null;
        this.vJi = ((View)localObject1);
        localObject1 = getItemView();
        if (localObject1 != null) {
          break label296;
        }
        localObject1 = null;
        label215:
        this.vJg = ((View)localObject1);
        localObject1 = getItemView();
        if (localObject1 != null) {
          break label307;
        }
        localObject1 = null;
        label231:
        this.vJh = ((View)localObject1);
        ddp();
        eE(paramView.findViewById(d.e.chatting_item_biz_video_click_view));
        paramView = getItemView();
        if (paramView != null) {
          break label318;
        }
      }
      label296:
      label307:
      label318:
      for (paramView = null;; paramView = (MMNeat7extView)paramView.findViewById(d.e.title_tv))
      {
        if (paramView != null) {
          break label332;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302670);
        throw paramView;
        localObject1 = ((View)localObject1).findViewById(d.e.play_time_tv_shadow);
        break;
        localObject1 = ((View)localObject1).findViewById(d.e.chatting_video_cover_ll);
        break label215;
        localObject1 = ((View)localObject1).findViewById(d.e.video_icon_container);
        break label231;
      }
      label332:
      this.vIW = paramView;
      paramView = getItemView();
      if (paramView == null) {}
      for (paramView = null; paramView == null; paramView = (ImageView)paramView.findViewById(d.e.press_mask_iv))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(302670);
        throw paramView;
      }
      this.vIX = paramView;
      paramView = getItemView();
      if (paramView != null) {
        break label462;
      }
      paramView = null;
      a(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label476;
      }
      paramView = null;
      label417:
      b(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label490;
      }
      paramView = null;
      label433:
      c(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label504;
      }
    }
    label462:
    label476:
    label490:
    label504:
    for (paramView = localObject2;; paramView = (MMNeat7extView)paramView.findViewById(d.e.single_digest_tv))
    {
      d(paramView);
      AppMethodBeat.o(302670);
      return;
      paramView = (LinearLayout)paramView.findViewById(d.e.biz_time_line_top_title_layout);
      break;
      paramView = (LinearLayout)paramView.findViewById(d.e.single_top_video_slot_title_layout);
      break label417;
      paramView = (MMNeat7extView)paramView.findViewById(d.e.single_title_tv);
      break label433;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    a(g paramg, ah.a parama, ab paramab, qn paramqn) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(302853);
      Object localObject = this.vJj.vJd;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.vJj.context.getResources().getColor(d.b.BW_100_Alpha_0_9));
      }
      localObject = this.vJj.vIX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!locala.aiwY)
      {
        localObject = this.vJj.vIW;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.vJj.context.getResources().getColor(d.b.white_text_color));
        }
      }
      this.vJj.a(paramab, paramqn);
      localObject = this.vJj.vJf;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.vJj.context.getResources().getColor(d.b.white_text_color));
      }
      AppMethodBeat.o(302853);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.g
 * JD-Core Version:    0.7.0.1
 */