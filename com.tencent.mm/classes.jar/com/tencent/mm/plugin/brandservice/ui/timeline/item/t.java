package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends ab
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private View vJC;
  private WeImageView vJD;
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  private View vKe;
  private ImageView vKf;
  private TextView vKg;
  private g vKh;
  private d vKi;
  private boolean vKj;
  
  public t(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(302657);
    this.vHY = paramb;
    this.context = paramContext;
    this.vJW = new LinkedList();
    this.vJX = new i((kotlin.g.a.a)new e(this));
    this.vKh = new g(this.context, this.vHY);
    this.vKi = new d(this.context, this.vHY);
    AppMethodBeat.o(302657);
  }
  
  private static final void a(com.tencent.mm.storage.ab paramab, t paramt, View paramView)
  {
    AppMethodBeat.i(302674);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramab);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramt, "this$0");
    paramView = paramab.field_talker;
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramab.field_talker);
    if ((localObject != null) && (!com.tencent.mm.contact.d.rs(((az)localObject).field_type)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramView);
      ((Intent)localObject).putExtra("Contact_Scene", 174);
      ((Intent)localObject).putExtra("force_get_contact", true);
      ((Intent)localObject).putExtra("key_use_new_contact_profile", true);
      com.tencent.mm.br.c.b(paramt.context, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      paramab = paramab.iYp();
      paramt.vHY.vFK.a(paramView, 0L, 0, 13, paramab.abry, "", 0, paramab.abLM.YSJ, paramab.event, paramab.abLM.YSF, 0, paramab.style, "");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302674);
      return;
      paramab = new Intent();
      paramab.putExtra("Chat_User", paramView);
      paramab.putExtra("finish_direct", true);
      paramab.putExtra("KOpenArticleSceneFromScene", 90);
      paramab.putExtra("specific_chat_from_scene", 2);
      paramab.putExtra("preChatTYPE", 11);
      com.tencent.mm.br.c.g(paramt.context, ".ui.chatting.ChattingUI", paramab);
      paramab = com.tencent.mm.plugin.brandservice.model.d.vBI;
      com.tencent.mm.plugin.brandservice.model.d.w(3, paramView, "");
    }
  }
  
  private static final void a(com.tencent.mm.storage.ab paramab, qo paramqo, t paramt, int paramInt, View paramView)
  {
    AppMethodBeat.i(302690);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqo);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramqo, "$bizInfo");
    kotlin.g.b.s.u(paramt, "this$0");
    paramView = paramab.iYp();
    localObject1 = (qn)paramqo.YVI.get(0);
    localObject2 = ((qn)localObject1).YQK;
    int j = 0;
    int i = 0;
    l2 = 0L;
    l1 = l2;
    if (!Util.isNullOrNil((String)localObject2)) {
      i = j;
    }
    try
    {
      localObject2 = Uri.parse((String)localObject2);
      i = j;
      j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      i = j;
      l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    paramt.vHY.vFK.a(paramqo.UserName, l1, i, 16, paramView.abry, "", 0, paramView.abLM.YSJ, paramView.event, paramView.abLM.YSF, ((qn)localObject1).YVE, paramView.style, ((qn)localObject1).YVF);
    ((e)new e(paramt.context, paramab, paramt.vHY, paramqo, paramInt).mj((View)paramt.vJD)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302690);
  }
  
  private static final boolean a(t paramt, com.tencent.mm.storage.ab paramab, qo paramqo, View paramView)
  {
    AppMethodBeat.i(302685);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramt);
    localb.cH(paramab);
    localb.cH(paramqo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramt, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramqo, "$bizInfo");
    paramt.vHY.vFJ = paramab;
    paramab = paramab.iYp();
    int j;
    long l1;
    int i;
    if (paramab != null)
    {
      paramView = (qn)paramqo.YVI.get(0);
      j = 0;
      l1 = 0L;
      i = j;
    }
    try
    {
      localObject = Uri.parse(paramView.YQK);
      i = j;
      j = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
      i = j;
      long l2 = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
      l1 = l2;
      i = j;
    }
    catch (Exception localException)
    {
      label180:
      break label180;
    }
    paramt.vHY.vFK.a(paramqo.UserName, l1, i, 15, paramab.abry, "", 0, paramab.abLM.YSJ, paramab.event, paramab.abLM.YSF, paramView.YVE, paramab.style, "");
    paramt.vHY.dcM();
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(302685);
    return false;
  }
  
  public final void a(final com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(302725);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView1, "convertView");
    kotlin.g.b.s.u(paramView2, "parent");
    kotlin.g.b.s.u(paramView2, "parent");
    if (this.vJU == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.viewstub_bizcontentv2)).inflate();
      this.vKe = paramView2.findViewById(d.e.biz_avatar_layout);
      this.vKf = ((ImageView)paramView2.findViewById(d.e.avatar_iv));
      this.vKg = ((TextView)paramView2.findViewById(d.e.nick_name_tv));
      this.vJC = paramView2.findViewById(d.e.close_layout);
      this.vJD = ((WeImageView)paramView2.findViewById(d.e.close_iv));
      this.vJV = ((LinearLayout)paramView2.findViewById(d.e.biz_rec_card_common_slot));
      localObject2 = ah.aiuX;
      this.vJU = paramView2;
    }
    flj localflj = paramab.iYp();
    kotlin.g.b.s.s(localflj, "info.tlRecCardWrapper");
    paramView2 = t.c.vKp;
    Object localObject2 = (kotlin.g.a.b)t.b.vKo;
    label206:
    int i;
    if (localflj == null)
    {
      paramView2 = null;
      if (paramView2 != null)
      {
        if (localflj != null) {
          break label244;
        }
        paramView2 = (View)localObject1;
        if ((paramView2 != null) && (localflj.abLM != null)) {
          break label270;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label383;
      }
      AppMethodBeat.o(302725);
      return;
      paramView2 = localflj.abLK;
      break;
      label244:
      fle localfle = localflj.abLK;
      paramView2 = (View)localObject1;
      if (localfle == null) {
        break label206;
      }
      paramView2 = localfle.abLF;
      break label206;
      label270:
      if (Util.isNullOrNil((List)localflj.abLM.YSB))
      {
        i = 0;
      }
      else
      {
        paramView2 = localflj.abLM.YSB;
        kotlin.g.b.s.s(paramView2, "wrapper.extraInfo.BizInfo");
        paramView2 = ((Iterable)paramView2).iterator();
        for (;;)
        {
          if (paramView2.hasNext())
          {
            localObject1 = (qo)paramView2.next();
            kotlin.g.b.s.s(localObject1, "info");
            if (!((Boolean)((kotlin.g.a.b)localObject2).invoke(localObject1)).booleanValue())
            {
              i = 0;
              break;
            }
          }
        }
        i = 1;
      }
    }
    label383:
    paramView1.setVisibility(0);
    paramView1 = this.vJU;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = (qo)paramab.iYp().abLM.YSB.get(0);
    kotlin.g.b.s.s(paramView1, "bizInfo");
    a.b.h(this.vKf, paramView1.UserName);
    paramView2 = this.vKg;
    if (paramView2 != null) {
      paramView2.setText((CharSequence)paramView1.vhX);
    }
    paramView2 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
    com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vKg);
    paramView2 = this.vKe;
    if (paramView2 != null) {
      paramView2.setOnClickListener(new t..ExternalSyntheticLambda0(paramab, this));
    }
    paramView2 = this.vKe;
    if (paramView2 != null) {
      paramView2.setOnLongClickListener(new t..ExternalSyntheticLambda2(this, paramab, paramView1));
    }
    if ((!Util.isNullOrNil((List)paramView1.YVA)) && (paramView1.YVB == 1))
    {
      paramView2 = this.vJC;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.vJC;
      if (paramView2 != null) {
        paramView2.setOnClickListener(new t..ExternalSyntheticLambda1(paramab, paramView1, this, paramInt));
      }
      this.vKj = false;
      if (((qn)paramView1.YVI.get(0)).nUA != 5) {
        break label776;
      }
      this.vKj = true;
      paramView2 = this.vKh;
      localObject1 = this.vJU;
      kotlin.g.b.s.checkNotNull(localObject1);
      paramView2.a((View)localObject1, paramab, paramView1);
      this.vKi.hide();
      a(paramab, (ab)this);
      MPVideoPreviewMgr.vXs.p(paramab);
      this.vKh.vJe = ((kotlin.g.a.a)new d(this, paramab));
    }
    for (;;)
    {
      paramView2 = ((Iterable)this.vJW).iterator();
      while (paramView2.hasNext())
      {
        localObject1 = (a)paramView2.next();
        localObject2 = this.vJV;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).removeView(((a)localObject1).vJY);
        }
        this.vJX.et(localObject1);
      }
      paramView2 = this.vJC;
      if (paramView2 == null) {
        break;
      }
      paramView2.setVisibility(8);
      break;
      label776:
      paramView2 = this.vKi;
      localObject1 = this.vJU;
      kotlin.g.b.s.checkNotNull(localObject1);
      paramView2.a((View)localObject1, paramab, paramView1);
      this.vKh.hide();
    }
    this.vJW.clear();
    if (paramView1.YVI.size() > 1)
    {
      paramView2 = (a)this.vJX.get();
      localObject1 = this.vJV;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).addView(paramView2.vJY);
      }
      this.vJW.add(paramView2);
      localObject1 = paramView1.YVI.get(1);
      kotlin.g.b.s.s(localObject1, "bizInfo.AppMsg[1]");
      paramView2.d(paramab, paramView1, (qn)localObject1);
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.w(paramab);
    AppMethodBeat.o(302725);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, ab paramab1)
  {
    AppMethodBeat.i(302741);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramab1, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramab1);
    AppMethodBeat.o(302741);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    AppMethodBeat.i(302755);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramString);
    AppMethodBeat.o(302755);
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
    AppMethodBeat.i(302733);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302733);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(302816);
      this.vHY = paramContext;
      this.context = localObject;
      this.vJY = View.inflate(this.context, d.f.biz_time_line_rec_card_common_slotv2, null);
      this.vIN = new v();
      this.plj = this.vJY.findViewById(d.e.top_line);
      this.uoA = ((ViewGroup)this.vJY.findViewById(d.e.content_ll));
      this$1 = this.vJY.findViewById(d.e.title_neat_tv);
      if (t.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302816);
        throw t.this;
      }
      this.vMn = ((MMNeat7extView)t.this);
      this.vMo = ((TextView)this.vJY.findViewById(d.e.summary));
      this.vMp = this.vJY.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vJY.findViewById(d.e.cover_iv));
      this.vMq = this.vJY.findViewById(d.e.biz_slot_voice_layout);
      this.vMr = ((ImageView)this.vJY.findViewById(d.e.biz_time_line_voice_play_icon));
      this.vMs = ((ImageView)this.vJY.findViewById(d.e.play_icon));
      this.vJc = this.vJY.findViewById(d.e.stat_layout);
      this$1 = this.vJY.findViewById(d.e.friends_read_tv);
      if (t.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(302816);
        throw t.this;
      }
      this.vJd = ((TextView)t.this);
      this.vMt = this.vJY.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vJY.findViewById(d.e.pic_cover_mask);
      this.vJJ = ((TextView)this.vJY.findViewById(d.e.pic_num));
      AppMethodBeat.o(302816);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qn paramqn, View paramView)
    {
      AppMethodBeat.i(302825);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.cH(paramqn);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
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
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302825);
        return;
      }
      catch (Exception parama)
      {
        break label149;
      }
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn, int paramInt, View paramView)
    {
      AppMethodBeat.i(302822);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqo);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqn);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
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
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302822);
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
      t.this.a(paramab, "PAUSE_FOR_RESUME");
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
        f.a((flj)localObject1);
        parama.vHY.vFK.a(paramqo.UserName, l, i, 15, ((flj)localObject1).abry, "", paramInt, ((flj)localObject1).abLM.YSJ, ((flj)localObject1).event, ((flj)localObject1).abLM.YSF, paramqn.YVE, ((flj)localObject1).style, paramqn.YVF);
        parama.vHY.b(paramab, paramInt);
        break;
        com.tencent.mm.br.c.b(parama.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
    
    public final void d(final com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn)
    {
      AppMethodBeat.i(302840);
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
      this.vJY.setOnClickListener(new t.a..ExternalSyntheticLambda1(this, paramab, paramqo, paramqn, 1));
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
          break label711;
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
          break label619;
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
        AppMethodBeat.o(302840);
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
        paramab = (kotlin.g.a.m)t.a.b.vKm;
        paramqo = (kotlin.g.a.s)t.a.c.vKn;
        paramqn = this.uoA;
        kotlin.g.b.s.s(paramqn, "content");
        paramqo.a(paramqn, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf));
        paramqo = this.plj;
        kotlin.g.b.s.s(paramqo, "topLine");
        paramab.invoke(paramqo, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj));
        if (this.vIN.type == 5)
        {
          paramab = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(this.vIN.url, this.vIN.type, "");
        }
        AppMethodBeat.o(302840);
        return;
        label619:
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_play_selector);
        break;
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a((View)this.vMr, paramab.field_msgId + '_' + 1, paramqn.hAP, paramqo, "", paramqn.YQM);
        this.vMr.setOnClickListener(new t.a..ExternalSyntheticLambda0(this, paramab, paramqn));
        continue;
        label711:
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
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(t.a parama, com.tencent.mm.storage.ab paramab) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302730);
        this.vKl.a(this.vKl.vIN, true);
        this.vKl.vMC.vFN.y(paramab.field_msgId, this.vKb);
        AppMethodBeat.o(302730);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(t paramt, com.tencent.mm.storage.ab paramab)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<t.a>
  {
    e(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.t
 * JD-Core Version:    0.7.0.1
 */