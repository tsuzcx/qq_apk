package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class u
  extends ae
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private View sDP;
  private WeImageView sDQ;
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  private View sEu;
  private ImageView sEv;
  private TextView sEw;
  private g sEx;
  private d sEy;
  private boolean sEz;
  
  public u(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(264596);
    this.sCg = paramb;
    this.context = paramContext;
    this.sEk = new LinkedList();
    this.sEl = new i((kotlin.g.a.a)new h(this));
    this.sEx = new g(this.context, this.sCg);
    this.sEy = new d(this.context, this.sCg);
    AppMethodBeat.o(264596);
  }
  
  public final void a(final z paramz, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(264589);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.stp)).inflate();
      this.sEu = paramView2.findViewById(d.e.spQ);
      this.sEv = ((ImageView)paramView2.findViewById(d.e.avatar_iv));
      this.sEw = ((TextView)paramView2.findViewById(d.e.nick_name_tv));
      this.sDP = paramView2.findViewById(d.e.close_layout);
      this.sDQ = ((WeImageView)paramView2.findViewById(d.e.close_iv));
      this.sEj = ((LinearLayout)paramView2.findViewById(d.e.spU));
      this.sEi = paramView2;
    }
    Object localObject2 = paramz.hwL();
    p.j(localObject2, "info.tlRecCardWrapper");
    paramView2 = u.c.sEG;
    Object localObject1 = (kotlin.g.a.b)u.b.sEF;
    label211:
    int i;
    if (localObject2 != null)
    {
      paramView2 = ((eqg)localObject2).UsD;
      if (paramView2 != null)
      {
        if (localObject2 == null) {
          break label244;
        }
        paramView2 = ((eqg)localObject2).UsD;
        if (paramView2 == null) {
          break label244;
        }
        paramView2 = paramView2.Usy;
        if ((paramView2 != null) && (((eqg)localObject2).UsF != null)) {
          break label250;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label362;
      }
      AppMethodBeat.o(264589);
      return;
      paramView2 = null;
      break;
      label244:
      paramView2 = null;
      break label211;
      label250:
      if (Util.isNullOrNil((List)((eqg)localObject2).UsF.RVd))
      {
        i = 0;
      }
      else
      {
        paramView2 = ((eqg)localObject2).UsF.RVd;
        p.j(paramView2, "wrapper.extraInfo.BizInfo");
        paramView2 = ((Iterable)paramView2).iterator();
        for (;;)
        {
          if (paramView2.hasNext())
          {
            localObject2 = (pf)paramView2.next();
            p.j(localObject2, "info");
            if (!((Boolean)((kotlin.g.a.b)localObject1).invoke(localObject2)).booleanValue())
            {
              i = 0;
              break;
            }
          }
        }
        i = 1;
      }
    }
    label362:
    paramView1.setVisibility(0);
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    localObject1 = (pf)paramz.hwL().UsF.RVd.get(0);
    p.j(localObject1, "bizInfo");
    a.b.d(this.sEv, ((pf)localObject1).UserName);
    paramView1 = this.sEw;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)((pf)localObject1).rWI);
    }
    paramView1 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
    com.tencent.mm.plugin.brandservice.ui.b.d.l(this.sEw);
    paramView1 = this.sEu;
    if (paramView1 != null) {
      paramView1.setOnClickListener((View.OnClickListener)new f(this, paramz));
    }
    paramView1 = this.sEu;
    if (paramView1 != null) {
      paramView1.setOnLongClickListener((View.OnLongClickListener)new g(this, paramz, (pf)localObject1));
    }
    if ((!Util.isNullOrNil((List)((pf)localObject1).RXF)) && (((pf)localObject1).RXG == 1))
    {
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new e(this, paramz, (pf)localObject1, paramInt));
      }
      this.sEz = false;
      switch (((pe)((pf)localObject1).RXM.get(0)).lpx)
      {
      default: 
        paramView1 = this.sEy;
        paramView2 = this.sEi;
        if (paramView2 == null) {
          p.iCn();
        }
        paramView1.a(paramView2, paramz, (pf)localObject1);
        this.sEx.hide();
      }
    }
    for (;;)
    {
      paramView1 = ((Iterable)this.sEk).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        localObject2 = this.sEj;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).removeView(paramView2.sEm);
        }
        this.sEl.cX(paramView2);
      }
      paramView1 = this.sDP;
      if (paramView1 == null) {
        break;
      }
      paramView1.setVisibility(8);
      break;
      this.sEz = true;
      paramView1 = this.sEx;
      paramView2 = this.sEi;
      if (paramView2 == null) {
        p.iCn();
      }
      paramView1.a(paramView2, paramz, (pf)localObject1);
      this.sEy.hide();
      a(paramz, (ae)this);
      paramView1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.q(paramz);
      this.sEx.sDm = ((kotlin.g.a.a)new d(this, paramz));
    }
    this.sEk.clear();
    Object localObject3;
    if (((pf)localObject1).RXM.size() > 1)
    {
      paramView2 = (a)this.sEl.get();
      paramView1 = this.sEj;
      if (paramView1 != null) {
        paramView1.addView(paramView2.sEm);
      }
      this.sEk.add(paramView2);
      paramView1 = ((pf)localObject1).RXM.get(1);
      p.j(paramView1, "bizInfo.AppMsg[1]");
      localObject2 = (pe)paramView1;
      p.k(paramz, "info");
      p.k(localObject1, "bizInfo");
      p.k(localObject2, "appMsg");
      Object localObject4 = ((pe)localObject2).fwr;
      paramView1 = ((pe)localObject2).RTk;
      paramInt = ((pe)localObject2).lpx;
      localObject3 = ((pe)localObject2).RTm;
      String str = ((pe)localObject2).RTn;
      paramView2.sGQ.aL((CharSequence)localObject4);
      localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
      {
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.e(paramView2.sGQ);
      }
      paramView2.sEm.setBackgroundResource(d.d.spE);
      paramView2.sEm.setOnClickListener((View.OnClickListener)new u.a.a(paramView2, paramz, (pf)localObject1, (pe)localObject2));
      if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil(paramView1))) {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView1, paramInt, 90, new Object[0]);
      }
      paramView2.sCU.type = paramInt;
      paramView2.sCU.lpK = ((String)localObject3);
      paramView2.sCU.lqb = str;
      paramView2.sCU.url = paramView1;
      paramView1 = paramView2.sDk;
      p.j(paramView1, "statLayout");
      paramView1.setVisibility(0);
      localObject3 = paramView2.sDl;
      p.j(localObject3, "friendReadTv");
      if (!Util.isNullOrNil(((pe)localObject2).CPq)) {}
      for (paramView1 = (CharSequence)String.valueOf(((pe)localObject2).CPq);; paramView1 = (CharSequence)"")
      {
        ((TextView)localObject3).setText(paramView1);
        paramView1 = paramView2.sGV;
        p.j(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView2.sGV.setImageResource(d.d.dmx);
        paramView1 = paramView2.sGT;
        p.j(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(8);
        if (paramView2.sCU.type != 7) {
          break label1725;
        }
        paramView2.sCR.setVisibility(8);
        p.k(paramz, "info");
        p.k(localObject1, "appMsgBizInfo");
        p.k(localObject2, "appMsg");
        paramView1 = paramView2.sGV;
        p.j(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView1 = paramView2.sGT;
        p.j(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(0);
        paramView1 = paramView2.sGU;
        p.j(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
          ((AnimationDrawable)paramView1).stop();
        }
        if (!p.h(String.valueOf(paramz.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.cEq())) {
          break label1623;
        }
        paramView2.sGU.setImageResource(d.d.dmz);
        paramView1 = paramView2.sGU;
        p.j(paramView1, "voicePlayIcon");
        if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
          break label1463;
        }
        paramView1 = paramView2.sGU;
        p.j(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (paramView1 != null) {
          break;
        }
        paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(264589);
        throw paramz;
      }
      ((AnimationDrawable)paramView1).start();
      label1463:
      paramView1 = ((pe)localObject2).RXH;
      if (!Util.isNullOrNil(paramView1)) {
        break label1637;
      }
      Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
    }
    for (;;)
    {
      paramView1 = (kotlin.g.a.m)u.a.c.sED;
      localObject1 = (s)u.a.d.sEE;
      localObject2 = paramView2.rgA;
      p.j(localObject2, "content");
      ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt));
      localObject1 = paramView2.mrE;
      p.j(localObject1, "topLine");
      paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx));
      if (paramView2.sCU.type == 5)
      {
        paramView1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.sKW;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.G(paramView2.sCU.url, paramView2.sCU.type, "");
      }
      com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
      AppMethodBeat.o(264589);
      return;
      label1623:
      paramView2.sGU.setImageResource(d.d.dmy);
      break;
      label1637:
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a((View)paramView2.sGU, String.valueOf(paramz.field_msgId) + "_1", ((pe)localObject2).fwr, paramView1, "", ((pe)localObject2).RTm);
      paramView2.sGU.setOnClickListener((View.OnClickListener)new u.a.e(paramView2, paramz, (pe)localObject2));
      continue;
      label1725:
      if (!Util.isNullOrNil(paramView2.sCU.lpK))
      {
        paramView2.sCR.setVisibility(0);
        paramView1 = paramView2.sHf.sAc;
        long l = paramz.field_msgId;
        localObject1 = paramView2.sCU;
        localObject2 = com.tencent.mm.aj.m.a(paramView2.sCU);
        localObject3 = paramView2.sCR;
        paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
        paramView1.a(l, 1, (v)localObject1, (String)localObject2, (ImageView)localObject3, paramInt, paramInt, false, (m.a)new u.a.b(paramView2, paramz), paramz.sHe + 1, 2.0F);
        if (paramView2.sCU.type == 5)
        {
          paramView1 = paramView2.sGV;
          p.j(paramView1, "playIcon");
          paramView1.setVisibility(0);
        }
      }
      else if ((paramView2.sCU.type == 5) || (paramView2.sCU.type == 6))
      {
        paramView1 = paramView2.sGV;
        p.j(paramView1, "playIcon");
        paramView1.setVisibility(0);
        paramView2.sCR.setVisibility(0);
        paramView1 = paramView2.sHf.sAc;
        localObject1 = String.valueOf(d.d.chatting_item_biz_play_icon_bg);
        localObject2 = paramView2.sCR;
        paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
        paramView1.a((String)localObject1, (ImageView)localObject2, paramInt, paramInt, paramz.sHe + 1);
      }
      else
      {
        paramView2.sGS.setVisibility(8);
      }
    }
  }
  
  public final void a(z paramz, ae paramae)
  {
    AppMethodBeat.i(264591);
    p.k(paramz, "info");
    p.k(paramae, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramae);
    AppMethodBeat.o(264591);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(264595);
    p.k(paramz, "info");
    p.k(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(264595);
  }
  
  public final boolean cAC()
  {
    return this.sEz;
  }
  
  public final View getVideoView()
  {
    return this.sEx.sDp;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(264590);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(264590);
      return;
    }
    AppMethodBeat.o(264590);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends aj
  {
    final Context context;
    final v sCU;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
    final View sEm;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(265677);
      this.sCg = paramContext;
      this.context = localObject;
      this.sEm = View.inflate(this.context, d.f.stT, null);
      this.sCU = new v();
      this.mrE = this.sEm.findViewById(d.e.top_line);
      this.rgA = ((ViewGroup)this.sEm.findViewById(d.e.content_ll));
      this$1 = this.sEm.findViewById(d.e.stf);
      if (u.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(265677);
        throw u.this;
      }
      this.sGQ = ((MMNeat7extView)u.this);
      this.sGR = ((TextView)this.sEm.findViewById(d.e.summary));
      this.sGS = this.sEm.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sEm.findViewById(d.e.cover_iv));
      this.sGT = this.sEm.findViewById(d.e.dum);
      this.sGU = ((ImageView)this.sEm.findViewById(d.e.srt));
      this.sGV = ((ImageView)this.sEm.findViewById(d.e.play_icon));
      this.sDk = this.sEm.findViewById(d.e.sta);
      this$1 = this.sEm.findViewById(d.e.srT);
      if (u.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(265677);
        throw u.this;
      }
      this.sDl = ((TextView)u.this);
      this.sGW = this.sEm.findViewById(d.e.ssl);
      this.sGX = this.sEm.findViewById(d.e.ssk);
      this.sDY = ((TextView)this.sEm.findViewById(d.e.dRg));
      AppMethodBeat.o(265677);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(u.a parama, z paramz, pf parampf, pe parampe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(265580);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramView = this.sEB;
        localObject1 = this.sAV;
        pf localpf = this.sEC;
        pe localpe = this.sCX;
        int k = this.sAW;
        p.k(localObject1, "info");
        p.k(localpf, "appMsgBizInfo");
        if ((localpe != null) && (((z)localObject1).hwK() != null))
        {
          localObject2 = ((z)localObject1).hwK();
          if (localObject2 == null) {
            p.iCn();
          }
          if (((eqb)localObject2).Usy != null) {}
        }
        else
        {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265580);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 4L, 1L, false);
        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpe.RTk });
        Object localObject2 = new Intent();
        Object localObject3 = com.tencent.mm.aj.m.e(localpe.RTk, 169, 10000, 0);
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject2).putExtra("geta8key_scene", 56);
        ((Intent)localObject2).putExtra("geta8key_username", localpf.UserName);
        ((Intent)localObject2).putExtra("srcUsername", localpf.UserName);
        ((Intent)localObject2).putExtra("srcDisplayname", localpf.rWI);
        ((Intent)localObject2).putExtra("prePublishId", "rec_card");
        ((Intent)localObject2).putExtra("KPublisherId", "rec_card");
        paramView.sEA.a((z)localObject1, "PAUSE_FOR_RESUME");
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView.context, (String)localObject3, localpe.lpx, 169, 10000, (Intent)localObject2))) {
          Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          localObject2 = ((z)localObject1).hwL();
          int j;
          int i;
          if (localObject2 != null)
          {
            j = 0;
            i = j;
          }
          try
          {
            localObject3 = Uri.parse((String)localObject3);
            i = j;
            j = Util.getInt(((Uri)localObject3).getQueryParameter("idx"), 0);
            i = j;
            l = Util.getLong(((Uri)localObject3).getQueryParameter("mid"), 0L);
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l = 0L;
            }
          }
          f.a((eqg)localObject2);
          paramView.sCg.szZ.a(localpf.UserName, l, i, 15, ((eqg)localObject2).Uaw, "", k, ((eqg)localObject2).UsF.RVm, ((eqg)localObject2).event, ((eqg)localObject2).UsF.RVi, localpe.RXJ, ((eqg)localObject2).style, localpe.RXK);
          paramView.sCg.b((z)localObject1, k);
          break;
          com.tencent.mm.by.c.b(paramView.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(265420);
        this.sEB.a(this.sEB.sCU, true);
        this.sEB.sHf.sAc.p(this.sAV.field_msgId, this.sEq);
        AppMethodBeat.o(265420);
      }
      
      public final void onStart() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(u.a parama, z paramz, pe parampe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(263703);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN((View)this.sEB.sGU);
        if (this.sAV.hwL() != null) {}
        try
        {
          paramView = Uri.parse(this.sCX.RTk);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263703);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(u paramu, z paramz)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(u paramu, z paramz, pf parampf, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(258182);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = paramz.hwL();
      localObject1 = (pe)this.sEC.RXM.get(0);
      Object localObject2 = ((pe)localObject1).RTk;
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
      this.sEA.sCg.szZ.a(this.sEC.UserName, l1, i, 16, paramView.Uaw, "", 0, paramView.UsF.RVm, paramView.event, paramView.UsF.RVi, ((pe)localObject1).RXJ, paramView.style, ((pe)localObject1).RXK);
      ((e)new e(this.sEA.context, paramz, this.sEA.sCg, this.sEC, paramInt).iM((View)u.a(this.sEA))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(258182);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(u paramu, z paramz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(262092);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = paramz.field_talker;
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramz.field_talker);
      if ((localObject1 != null) && (!((as)localObject1).axZ()))
      {
        localObject1 = this.sEA;
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Scene", 174);
        ((Intent)localObject2).putExtra("force_get_contact", true);
        ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.by.c.b(((u)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        localObject2 = paramz.hwL();
        ((u)localObject1).sCg.szZ.a(paramView, 0L, 0, 13, ((eqg)localObject2).Uaw, "", 0, ((eqg)localObject2).UsF.RVm, ((eqg)localObject2).event, ((eqg)localObject2).UsF.RVi, 0, ((eqg)localObject2).style, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(262092);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Chat_User", paramView);
        ((Intent)localObject1).putExtra("finish_direct", true);
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 90);
        ((Intent)localObject1).putExtra("specific_chat_from_scene", 2);
        ((Intent)localObject1).putExtra("preChatTYPE", 11);
        com.tencent.mm.by.c.f(this.sEA.context, ".ui.chatting.ChattingUI", (Intent)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.b.d.swc;
        com.tencent.mm.plugin.brandservice.b.d.t(3, paramView, "");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(u paramu, z paramz, pf parampf) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(264888);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      this.sEA.sCg.szY = paramz;
      paramView = paramz.hwL();
      int j;
      long l1;
      int i;
      if (paramView != null)
      {
        localObject = (pe)this.sEC.RXM.get(0);
        j = 0;
        l1 = 0L;
        i = j;
      }
      try
      {
        Uri localUri = Uri.parse(((pe)localObject).RTk);
        i = j;
        j = Util.getInt(localUri.getQueryParameter("idx"), 0);
        i = j;
        long l2 = Util.getLong(localUri.getQueryParameter("mid"), 0L);
        l1 = l2;
        i = j;
      }
      catch (Exception localException)
      {
        label131:
        break label131;
      }
      this.sEA.sCg.szZ.a(this.sEC.UserName, l1, i, 15, paramView.Uaw, "", 0, paramView.UsF.RVm, paramView.event, paramView.UsF.RVi, ((pe)localObject).RXJ, paramView.style, "");
      this.sEA.sCg.czS();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(264888);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<u.a>
  {
    h(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.u
 * JD-Core Version:    0.7.0.1
 */