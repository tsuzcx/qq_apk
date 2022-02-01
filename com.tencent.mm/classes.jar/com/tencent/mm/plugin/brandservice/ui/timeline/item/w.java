package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends ab
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private TextView vJB;
  private View vJC;
  private WeImageView vJD;
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  private View vKe;
  private g vKh;
  private d vKi;
  private boolean vKj;
  private TextView vLf;
  private int vLg;
  
  public w(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(302700);
    this.vHY = paramb;
    this.context = paramContext;
    this.vJW = new LinkedList();
    this.vJX = new i((kotlin.g.a.a)new d(this));
    this.vKh = new g(this.context, this.vHY);
    this.vKi = new d(this.context, this.vHY);
    this.vLg = -1;
    AppMethodBeat.o(302700);
  }
  
  private static final void a(w paramw, flj paramflj)
  {
    AppMethodBeat.i(302727);
    kotlin.g.b.s.u(paramw, "this$0");
    kotlin.g.b.s.u(paramflj, "$wrapper");
    Object localObject1 = paramw.vJB;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((TextView)localObject1).getLayout();
      if (localObject2 != null)
      {
        localObject1 = paramw.vLf;
        if (localObject1 != null) {
          if ((((Layout)localObject2).getLineCount() <= 0) || (((Layout)localObject2).getEllipsisCount(((Layout)localObject2).getLineCount() - 1) <= 0)) {
            break label141;
          }
        }
        label141:
        for (paramflj = (CharSequence)paramw.context.getString(d.i.biz_timeline_unfollow_recommend);; paramflj = (CharSequence)paramflj.abLM.Zxn)
        {
          ((TextView)localObject1).setText(paramflj);
          paramflj = paramw.vJB;
          if (paramflj == null) {
            break label277;
          }
          if ((paramflj.getText() != null) && (paramflj.getText().length() >= 2))
          {
            localObject1 = paramflj.getText();
            kotlin.g.b.s.s(localObject1, "text");
            if (n.e((CharSequence)localObject1, (CharSequence)"#")) {
              break;
            }
          }
          AppMethodBeat.o(302727);
          return;
        }
        localObject1 = paramw.vKe;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          paramw = paramw.vLf;
          if (paramw != null) {
            break label283;
          }
        }
      }
    }
    label277:
    label283:
    for (paramw = null;; paramw = paramw.getText())
    {
      paramw = ((StringBuilder)localObject2).append(paramw).append(65292);
      localObject2 = am.aixg;
      localObject2 = paramflj.getContext().getResources().getString(d.i.biz_timeline_topic);
      kotlin.g.b.s.s(localObject2, "context.resources.getStr…tring.biz_timeline_topic)");
      paramflj = String.format((String)localObject2, Arrays.copyOf(new Object[] { paramflj.getText().subSequence(1, paramflj.getText().length()) }, 1));
      kotlin.g.b.s.s(paramflj, "java.lang.String.format(format, *args)");
      ((View)localObject1).setContentDescription((CharSequence)paramflj);
      AppMethodBeat.o(302727);
      return;
    }
  }
  
  private static final void a(com.tencent.mm.storage.ab paramab, w paramw, int paramInt, View paramView)
  {
    AppMethodBeat.i(302717);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramw, "this$0");
    paramView = paramab.iYp();
    if (paramw.vLg == -1)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302717);
      return;
    }
    localObject1 = (qo)paramab.iYp().abLM.YSB.get(paramw.vLg);
    localObject2 = (qn)((qo)localObject1).YVI.get(0);
    Object localObject3 = ((qn)localObject2).YQK;
    int j = 0;
    int i = 0;
    l2 = 0L;
    l1 = l2;
    if (!Util.isNullOrNil((String)localObject3)) {
      i = j;
    }
    try
    {
      localObject3 = Uri.parse((String)localObject3);
      i = j;
      j = Util.getInt(((Uri)localObject3).getQueryParameter("idx"), 0);
      i = j;
      l1 = Util.getLong(((Uri)localObject3).getQueryParameter("mid"), 0L);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    paramw.vHY.vFK.a(((qo)localObject1).UserName, l1, i, 16, paramView.abry, "", 0, paramView.abLM.YSJ, paramView.event, paramView.abLM.YSF, ((qn)localObject2).YVE, paramView.style, ((qn)localObject2).YVF);
    ((e)new e(paramw.context, paramab, paramw.vHY, (qo)localObject1, paramInt).mj((View)paramw.vJD)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302717);
  }
  
  private static final boolean a(w paramw, com.tencent.mm.storage.ab paramab, View paramView)
  {
    AppMethodBeat.i(302707);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramw, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    paramw.vHY.vFJ = paramab;
    paramw.vHY.dcM();
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(302707);
    return false;
  }
  
  private static final void c(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(302734);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$funJump");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302734);
  }
  
  public final void a(final com.tencent.mm.storage.ab paramab, int paramInt, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(302811);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView1, "convertView");
    kotlin.g.b.s.u(paramView2, "parent");
    kotlin.g.b.s.u(paramView2, "parent");
    Object localObject;
    if (this.vJU == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.viewstub_multiaccount)).inflate();
      this.vJC = paramView2.findViewById(d.e.close_layout);
      this.vJD = ((WeImageView)paramView2.findViewById(d.e.close_iv));
      this.vJV = ((LinearLayout)paramView2.findViewById(d.e.biz_rec_card_common_slot));
      this.vKe = paramView2.findViewById(d.e.biz_time_line_rec_card_multiaccount_header_words);
      this.vLf = ((TextView)paramView2.findViewById(d.e.nick_name_tv));
      this.vJB = ((TextView)paramView2.findViewById(d.e.jump_link));
      localObject = ah.aiuX;
      this.vJU = paramView2;
    }
    this.vLg = -1;
    paramView2 = paramab.iYp().abLM.YSB;
    kotlin.g.b.s.s(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView2 = ((Iterable)p.c((Iterable)paramView2, 2)).iterator();
    int i = 0;
    int j = 0;
    if (paramView2.hasNext())
    {
      localObject = paramView2.next();
      if (i < 0) {
        p.kkW();
      }
      if (((qo)localObject).YFu != 0) {
        break label1061;
      }
      int k = j + 1;
      if (this.vLg == -1)
      {
        j = i;
        label260:
        this.vLg = j;
        j = k;
      }
    }
    label906:
    label1061:
    for (;;)
    {
      i += 1;
      break;
      j = this.vLg;
      break label260;
      if ((j <= 0) || (this.vLg == -1))
      {
        AppMethodBeat.o(302811);
        return;
      }
      paramView1.setVisibility(0);
      paramView1 = this.vJU;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      this.vKj = false;
      paramView1 = (kotlin.g.a.b)new b(this, paramab);
      switch (j)
      {
      default: 
        paramView1 = this.vLf;
        if (paramView1 != null) {
          paramView1.setText((CharSequence)paramab.acFD.abLM.Zxn);
        }
        paramView1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vLf);
        paramView1 = this.vKe;
        if (paramView1 != null) {
          paramView1.setOnLongClickListener(new w..ExternalSyntheticLambda2(this, paramab));
        }
        if ((!Util.isNullOrNil((List)paramab.iYp().abLM.YVA)) && (paramab.iYp().abLM.YVB == 1))
        {
          paramView1 = this.vJC;
          if (paramView1 != null) {
            paramView1.setVisibility(0);
          }
          paramView1 = this.vJC;
          if (paramView1 != null) {
            paramView1.setOnClickListener(new w..ExternalSyntheticLambda0(paramab, this, paramInt));
          }
        }
        break;
      }
      for (;;)
      {
        paramView1 = paramab.iYp();
        kotlin.g.b.s.s(paramView1, "info.tlRecCardWrapper");
        paramView2 = paramView1.abLM;
        if (!Util.isNullOrNil(paramView2.Zxr)) {
          break label906;
        }
        paramab = this.vJB;
        if (paramab != null) {
          paramab.setVisibility(8);
        }
        paramab = this.vKe;
        if (paramab != null) {
          paramab.setOnClickListener(null);
        }
        AppMethodBeat.o(302811);
        return;
        paramView2 = paramab.iYp().abLM.YSB.get(this.vLg);
        kotlin.g.b.s.s(paramView2, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
        paramView1.invoke(paramView2);
        paramView1 = ((Iterable)this.vJW).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject = this.vJV;
          if (localObject != null) {
            ((LinearLayout)localObject).removeView(paramView2.vJY);
          }
          this.vJX.et(paramView2);
        }
        this.vJW.clear();
        break;
        paramView2 = paramab.iYp().abLM.YSB.get(0);
        kotlin.g.b.s.s(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
        paramView1.invoke(paramView2);
        paramView1 = paramab.iYp().abLM.YSB.get(1);
        kotlin.g.b.s.s(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
        paramView1 = (qo)paramView1;
        paramView2 = ((Iterable)this.vJW).iterator();
        while (paramView2.hasNext())
        {
          localObject = (a)paramView2.next();
          LinearLayout localLinearLayout = this.vJV;
          if (localLinearLayout != null) {
            localLinearLayout.removeView(((a)localObject).vJY);
          }
          this.vJX.et(localObject);
        }
        this.vJW.clear();
        paramView2 = (a)this.vJX.get();
        localObject = this.vJV;
        if (localObject != null) {
          ((LinearLayout)localObject).addView(paramView2.vJY);
        }
        this.vJW.add(paramView2);
        localObject = paramView1.YVI.get(0);
        kotlin.g.b.s.s(localObject, "bizInfo.AppMsg[0]");
        paramView2.d(paramab, paramView1, (qn)localObject);
        break;
        paramView1 = this.vJC;
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
      }
      localObject = this.vJB;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.vJB;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramView2.Zxr);
      }
      localObject = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vJB);
      if (Util.isNullOrNil(paramView2.Zxq))
      {
        paramab = this.vKe;
        if (paramab != null) {
          paramab.setClickable(false);
        }
        AppMethodBeat.o(302811);
        return;
      }
      localObject = this.vJB;
      if (localObject != null) {
        ((TextView)localObject).post(new w..ExternalSyntheticLambda3(this, paramView1));
      }
      paramab = (kotlin.g.a.a)new c(paramView2, this, paramView1, paramab);
      paramView1 = this.vKe;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new w..ExternalSyntheticLambda1(paramab));
      }
      AppMethodBeat.o(302811);
      return;
    }
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, ab paramab1)
  {
    AppMethodBeat.i(302818);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramab1, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramab1);
    AppMethodBeat.o(302818);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    AppMethodBeat.i(302826);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramString);
    AppMethodBeat.o(302826);
  }
  
  public final boolean ddC()
  {
    return this.vKj;
  }
  
  public final View getVideoView()
  {
    return this.vKh.vJg;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302815);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302815);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends ag
  {
    private final Context context;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
    final v vIN;
    final View vJY;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(302590);
      this.vHY = paramContext;
      this.context = localObject;
      this.vJY = View.inflate(this.context, d.f.biz_time_line_rec_card_common_slotv2, null);
      this.vIN = new v();
      this.plj = this.vJY.findViewById(d.e.top_line);
      this.uoA = ((ViewGroup)this.vJY.findViewById(d.e.content_ll));
      this$1 = this.vJY.findViewById(d.e.title_neat_tv);
      if (w.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302590);
        throw w.this;
      }
      this.vMn = ((MMNeat7extView)w.this);
      this.vMo = ((TextView)this.vJY.findViewById(d.e.summary));
      this.vMp = this.vJY.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vJY.findViewById(d.e.cover_iv));
      this.vMq = this.vJY.findViewById(d.e.biz_slot_voice_layout);
      this.vMr = ((ImageView)this.vJY.findViewById(d.e.biz_time_line_voice_play_icon));
      this.vMs = ((ImageView)this.vJY.findViewById(d.e.play_icon));
      this.vJc = this.vJY.findViewById(d.e.stat_layout);
      this$1 = this.vJY.findViewById(d.e.friends_read_tv);
      if (w.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(302590);
        throw w.this;
      }
      this.vJd = ((TextView)w.this);
      this.vMt = this.vJY.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vJY.findViewById(d.e.pic_cover_mask);
      this.vJJ = ((TextView)this.vJY.findViewById(d.e.pic_num));
      AppMethodBeat.o(302590);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qn paramqn, View paramView)
    {
      AppMethodBeat.i(302616);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.cH(paramqn);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramab, "$info");
      kotlin.g.b.s.u(paramqn, "$appMsg");
      ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).eA((View)parama.vMr);
      if (paramab.iYp() != null) {}
      try
      {
        parama = Uri.parse(paramqn.YQK);
        Util.getInt(parama.getQueryParameter("idx"), 0);
        Util.getLong(parama.getQueryParameter("mid"), 0L);
        label149:
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302616);
        return;
      }
      catch (Exception parama)
      {
        break label149;
      }
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn, int paramInt, View paramView)
    {
      AppMethodBeat.i(302606);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqo);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqn);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramab, "$info");
      kotlin.g.b.s.u(paramqo, "$bizInfo");
      kotlin.g.b.s.u(paramqn, "$appMsg");
      kotlin.g.b.s.u(paramab, "info");
      kotlin.g.b.s.u(paramqo, "appMsgBizInfo");
      if ((paramqn != null) && (paramab.iYo() != null))
      {
        paramView = paramab.iYo();
        kotlin.g.b.s.checkNotNull(paramView);
        if (paramView.abLF != null) {}
      }
      else
      {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302606);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 4L, 1L, false);
      Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramqn.YQK });
      localObject1 = new Intent();
      paramView = com.tencent.mm.message.m.e(paramqn.YQK, 169, 10000, (int)System.currentTimeMillis() / 1000);
      ((Intent)localObject1).putExtra("rawUrl", paramView);
      ((Intent)localObject1).putExtra("geta8key_scene", 56);
      ((Intent)localObject1).putExtra("geta8key_username", paramqo.UserName);
      ((Intent)localObject1).putExtra("srcUsername", paramqo.UserName);
      ((Intent)localObject1).putExtra("srcDisplayname", paramqo.vhX);
      ((Intent)localObject1).putExtra("prePublishId", "rec_card");
      ((Intent)localObject1).putExtra("KPublisherId", "rec_card");
      w.this.a(paramab, "PAUSE_FOR_RESUME");
      if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.context, paramView, paramqn.nUA, 169, 10000, (Intent)localObject1))) {
        Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        localObject1 = paramab.iYp();
        int j;
        int i;
        if (localObject1 != null)
        {
          j = 0;
          i = j;
        }
        try
        {
          localObject2 = Uri.parse(paramView);
          i = j;
          j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
          i = j;
          l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
          i = j;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
        localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramab, paramView, a.a.vNT);
        parama.vHY.vFK.a(paramqo.UserName, l, i, 15, ((flj)localObject1).abry, "", paramInt, ((flj)localObject1).abLM.YSJ, ((flj)localObject1).event, ((flj)localObject1).abLM.YSF, paramqn.YVE, ((flj)localObject1).style, paramqn.YVF);
        parama.vHY.b(paramab, paramInt);
        break;
        com.tencent.mm.br.c.b(parama.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
    
    public final void d(final com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn)
    {
      AppMethodBeat.i(302646);
      kotlin.g.b.s.u(paramab, "info");
      kotlin.g.b.s.u(paramqo, "bizInfo");
      kotlin.g.b.s.u(paramqn, "appMsg");
      Object localObject3 = paramqn.hAP;
      Object localObject1 = paramqn.YQK;
      int i = paramqn.nUA;
      Object localObject2 = paramqn.YQM;
      String str = paramqn.YQN;
      this.vMn.aZ((CharSequence)localObject3);
      localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vMn);
      }
      this.vJY.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
      this.vJY.setOnClickListener(new w.a..ExternalSyntheticLambda1(this, paramab, paramqo, paramqn, 1));
      if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (!Util.isNullOrNil((String)localObject1))) {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((String)localObject1, i, 90, new Object[0]);
      }
      this.vIN.type = i;
      this.vIN.nUM = ((String)localObject2);
      this.vIN.nVd = str;
      this.vIN.url = ((String)localObject1);
      this.vJc.setVisibility(0);
      localObject2 = this.vJd;
      if (!Util.isNullOrNil(paramqn.IJA)) {}
      for (localObject1 = (CharSequence)String.valueOf(paramqn.IJA);; localObject1 = (CharSequence)"")
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.vMs.setVisibility(8);
        this.vMs.setImageResource(d.d.biz_time_line_item_video_play_selector);
        this.vMq.setVisibility(8);
        if (this.vIN.type != 7) {
          break label676;
        }
        this.vIK.setVisibility(8);
        kotlin.g.b.s.u(paramab, "info");
        kotlin.g.b.s.u(paramqo, "appMsgBizInfo");
        kotlin.g.b.s.u(paramqn, "appMsg");
        this.vMs.setVisibility(8);
        this.vMq.setVisibility(0);
        paramqo = this.vMr.getDrawable();
        if (((paramqo instanceof AnimationDrawable)) && (((AnimationDrawable)paramqo).isRunning())) {
          ((AnimationDrawable)paramqo).stop();
        }
        if (!kotlin.g.b.s.p(paramab.field_msgId + '_' + 1, com.tencent.mm.plugin.brandservice.ui.b.d.dhS())) {
          break label584;
        }
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_playing_selector);
        if (!(this.vMr.getDrawable() instanceof AnimationDrawable)) {
          break label476;
        }
        paramqo = this.vMr.getDrawable();
        if (paramqo != null) {
          break;
        }
        paramab = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(302646);
        throw paramab;
      }
      ((AnimationDrawable)paramqo).start();
      label476:
      paramqo = paramqn.YVC;
      if (Util.isNullOrNil(paramqo)) {
        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
      }
      for (;;)
      {
        paramab = (kotlin.g.a.m)w.a.b.vLj;
        paramqo = (kotlin.g.a.s)w.a.c.vLk;
        paramqn = this.uoA;
        kotlin.g.b.s.s(paramqn, "content");
        paramqo.a(paramqn, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf));
        paramqo = this.plj;
        kotlin.g.b.s.s(paramqo, "topLine");
        paramab.invoke(paramqo, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj));
        AppMethodBeat.o(302646);
        return;
        label584:
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_play_selector);
        break;
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a((View)this.vMr, paramab.field_msgId + '_' + 1, paramqn.hAP, paramqo, "", paramqn.YQM);
        this.vMr.setOnClickListener(new w.a..ExternalSyntheticLambda0(this, paramab, paramqn));
        continue;
        label676:
        if (!Util.isNullOrNil(this.vIN.nUM))
        {
          this.vIK.setVisibility(0);
          long l = paramab.field_msgId;
          paramqo = this.vIN;
          paramqn = com.tencent.mm.message.m.a(this.vIN);
          localObject1 = this.vIK;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(l, 1, paramqo, paramqn, (ImageView)localObject1, i, i, false, (m.a)new a(this, paramab), paramab.vMB + 1, 2.0F);
          if (this.vIN.type == 5) {
            this.vMs.setVisibility(0);
          }
        }
        else if ((this.vIN.type == 5) || (this.vIN.type == 6))
        {
          this.vMs.setVisibility(0);
          this.vIK.setVisibility(0);
          paramqo = d.d.chatting_item_biz_play_icon_bg;
          paramqn = this.vIK;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramqo, paramqn, i, i, paramab.vMB + 1);
        }
        else
        {
          this.vMp.setVisibility(8);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(w.a parama, com.tencent.mm.storage.ab paramab) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302793);
        this.vLi.a(this.vLi.vIN, true);
        this.vLi.vMC.vFN.y(paramab.field_msgId, this.vKb);
        AppMethodBeat.o(302793);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<qo, ah>
  {
    b(w paramw, com.tencent.mm.storage.ab paramab)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(apx paramapx, w paramw, flj paramflj, com.tencent.mm.storage.ab paramab)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<w.a>
  {
    d(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w
 * JD-Core Version:    0.7.0.1
 */