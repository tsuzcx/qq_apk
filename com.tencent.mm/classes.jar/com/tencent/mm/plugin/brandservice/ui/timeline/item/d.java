package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f
{
  private ImageView vIK;
  private View vIL;
  private ImageView vIM;
  private final v vIN;
  
  public d(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(302630);
    this.vIN = new v();
    AppMethodBeat.o(302630);
  }
  
  private static void eD(View paramView)
  {
    AppMethodBeat.i(302634);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = b.vGa;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(302634);
  }
  
  public final void a(final View paramView, final ab paramab, qo paramqo)
  {
    AppMethodBeat.i(302641);
    s.u(paramView, "parent");
    s.u(paramab, "info");
    s.u(paramqo, "bizInfo");
    aa(paramView, d.e.viewstub_top_article_slot);
    if (getItemView() == null)
    {
      AppMethodBeat.o(302641);
      return;
    }
    paramView = getItemView();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (qn)paramqo.YVI.get(0);
    s.s(paramView, "appMsg");
    a(paramab, paramqo, paramView);
    Object localObject1 = this.vIL;
    s.checkNotNull(localObject1);
    eD((View)localObject1);
    localObject1 = this.vIK;
    s.checkNotNull(localObject1);
    eD((View)localObject1);
    localObject1 = new ah.a();
    boolean bool;
    switch (paramab.iYp().style)
    {
    default: 
      this.vIN.type = paramView.nUA;
      this.vIN.nUM = paramView.YQM;
      this.vIN.nVd = paramView.YQM;
      this.vIN.url = paramView.YQK;
      localObject2 = a.vtB;
      i = a.fK(this.context);
      j = b.vGg;
      ddo().vFN.a(paramab.field_msgId, 0, this.vIN, paramView.YQM, this.vIK, i - j, b.vGa, false, (m.a)new a(this, (ah.a)localObject1, paramab, paramView), false, paramab.vMB);
      b(paramab, paramqo, paramView);
      AppMethodBeat.o(302641);
      return;
    case 101: 
      if (paramqo.YVI.size() <= 1) {}
      for (bool = true;; bool = false)
      {
        ((ah.a)localObject1).aiwY = bool;
        break;
      }
    }
    Object localObject2 = paramab.iYp().abLM.YSB;
    s.s(localObject2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    localObject2 = (Iterable)p.c((Iterable)localObject2, 2);
    int j = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    label367:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (j < 0) {
        p.kkW();
      }
      if (((qo)localObject3).YFu != 0) {
        break label445;
      }
      i += 1;
    }
    label445:
    for (;;)
    {
      j += 1;
      break label367;
      if (i < 2) {}
      for (bool = true;; bool = false)
      {
        ((ah.a)localObject1).aiwY = bool;
        break;
      }
    }
  }
  
  public final void aa(View paramView, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(302649);
    s.u(paramView, "parent");
    if (getItemView() == null)
    {
      super.aa(paramView, paramInt);
      this.vIK = ((ImageView)paramView.findViewById(d.e.cover_iv));
      this.vIL = paramView.findViewById(d.e.cover_layout);
      this.vIM = ((ImageView)paramView.findViewById(d.e.cover_mask_iv));
      ddp();
      eE(paramView.findViewById(d.e.topSlot_click_view));
      paramView = getItemView();
      if (paramView == null) {}
      for (paramView = null; paramView == null; paramView = (MMNeat7extView)paramView.findViewById(d.e.title_tv))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302649);
        throw paramView;
      }
      this.vIW = paramView;
      paramView = getItemView();
      if (paramView == null) {}
      for (paramView = null; paramView == null; paramView = (ImageView)paramView.findViewById(d.e.press_mask_iv))
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(302649);
        throw paramView;
      }
      this.vIX = paramView;
      paramView = getItemView();
      if (paramView != null) {
        break label258;
      }
      paramView = null;
      a(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label272;
      }
      paramView = null;
      label214:
      b(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label286;
      }
      paramView = null;
      label230:
      c(paramView);
      paramView = getItemView();
      if (paramView != null) {
        break label300;
      }
    }
    label258:
    label272:
    label286:
    label300:
    for (paramView = localObject;; paramView = (MMNeat7extView)paramView.findViewById(d.e.single_digest_tv))
    {
      d(paramView);
      AppMethodBeat.o(302649);
      return;
      paramView = (LinearLayout)paramView.findViewById(d.e.biz_time_line_top_title_layout);
      break;
      paramView = (LinearLayout)paramView.findViewById(d.e.single_top_slot_title_layout);
      break label214;
      paramView = (MMNeat7extView)paramView.findViewById(d.e.single_title_tv);
      break label230;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m.a
  {
    a(d paramd, ah.a parama, ab paramab, qn paramqn) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(302607);
      Object localObject = this.vIO.vJd;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.vIO.context.getResources().getColor(d.b.BW_100_Alpha_0_9));
      }
      localObject = this.vIO.vIX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      if (!this.vIP.aiwY)
      {
        localObject = this.vIO.vIW;
        if (localObject != null) {
          ((MMNeat7extView)localObject).setTextColor(this.vIO.context.getResources().getColor(d.b.white_text_color));
        }
      }
      this.vIO.a(paramab, paramView);
      AppMethodBeat.o(302607);
    }
    
    public final void onStart() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.d
 * JD-Core Version:    0.7.0.1
 */