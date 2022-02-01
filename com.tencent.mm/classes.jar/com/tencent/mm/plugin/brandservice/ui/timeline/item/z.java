package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.text.Layout;
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
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class z
  extends ae
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private TextView sDO;
  private View sDP;
  private WeImageView sDQ;
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  private View sEu;
  private g sEx;
  private d sEy;
  private boolean sEz;
  private TextView sFD;
  private int sFE;
  
  public z(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(266749);
    this.sCg = paramb;
    this.context = paramContext;
    this.sEk = new LinkedList();
    this.sEl = new i((kotlin.g.a.a)new h(this));
    this.sEx = new g(this.context, this.sCg);
    this.sEy = new d(this.context, this.sCg);
    this.sFE = -1;
    AppMethodBeat.o(266749);
  }
  
  public final void a(final com.tencent.mm.storage.z paramz, final int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(266744);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.stv)).inflate();
      this.sDP = paramView2.findViewById(d.e.close_layout);
      this.sDQ = ((WeImageView)paramView2.findViewById(d.e.close_iv));
      this.sEj = ((LinearLayout)paramView2.findViewById(d.e.spU));
      this.sEu = paramView2.findViewById(d.e.spQ);
      this.sFD = ((TextView)paramView2.findViewById(d.e.nick_name_tv));
      this.sDO = ((TextView)paramView2.findViewById(d.e.srV));
      this.sEi = paramView2;
    }
    this.sFE = -1;
    paramView2 = paramz.hwL().UsF.RVd;
    p.j(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView2 = (Iterable)j.c((Iterable)paramView2, 2);
    int i = 0;
    paramView2 = paramView2.iterator();
    int j = 0;
    Object localObject1;
    if (paramView2.hasNext())
    {
      localObject1 = paramView2.next();
      if (i < 0) {
        j.iBO();
      }
      if (((pf)localObject1).RIs != 0) {
        break label2129;
      }
      int k = j + 1;
      if (this.sFE == -1)
      {
        j = i;
        label254:
        this.sFE = j;
        j = k;
      }
    }
    label1451:
    label2129:
    for (;;)
    {
      i += 1;
      break;
      j = this.sFE;
      break label254;
      if ((j <= 0) || (this.sFE == -1))
      {
        AppMethodBeat.o(266744);
        return;
      }
      paramView1.setVisibility(0);
      paramView1 = this.sEi;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      this.sEz = false;
      paramView1 = (kotlin.g.a.b)new b(this, paramz);
      switch (j)
      {
      default: 
        paramView1 = this.sFD;
        if (paramView1 != null) {
          paramView1.setText((CharSequence)paramz.Vei.UsF.SwE);
        }
        paramView1 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.l(this.sFD);
        paramView1 = this.sEu;
        if (paramView1 != null) {
          paramView1.setOnLongClickListener((View.OnLongClickListener)new d(this, paramz));
        }
        if ((!Util.isNullOrNil((List)paramz.hwL().UsF.RXF)) && (paramz.hwL().UsF.RXG == 1))
        {
          paramView1 = this.sDP;
          if (paramView1 != null) {
            paramView1.setVisibility(0);
          }
          paramView1 = this.sDP;
          if (paramView1 != null) {
            paramView1.setOnClickListener((View.OnClickListener)new c(this, paramz, paramInt));
          }
        }
        break;
      }
      for (;;)
      {
        paramView1 = paramz.hwL();
        p.j(paramView1, "info.tlRecCardWrapper");
        paramView2 = paramView1.UsF;
        if (!Util.isNullOrNil(paramView2.SwI)) {
          break label1958;
        }
        paramz = this.sDO;
        if (paramz != null) {
          paramz.setVisibility(8);
        }
        paramz = this.sEu;
        if (paramz == null) {
          break label1952;
        }
        paramz.setOnClickListener(null);
        AppMethodBeat.o(266744);
        return;
        paramView2 = paramz.hwL().UsF.RVd.get(this.sFE);
        p.j(paramView2, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
        paramView1.invoke(paramView2);
        paramView1 = ((Iterable)this.sEk).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.sEj;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.sEm);
          }
          this.sEl.cX(paramView2);
        }
        this.sEk.clear();
        break;
        paramView2 = paramz.hwL().UsF.RVd.get(0);
        p.j(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
        paramView1.invoke(paramView2);
        paramView1 = paramz.hwL().UsF.RVd.get(1);
        p.j(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
        Object localObject2 = (pf)paramView1;
        paramView1 = ((Iterable)this.sEk).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.sEj;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.sEm);
          }
          this.sEl.cX(paramView2);
        }
        this.sEk.clear();
        paramView2 = (a)this.sEl.get();
        paramView1 = this.sEj;
        if (paramView1 != null) {
          paramView1.addView(paramView2.sEm);
        }
        this.sEk.add(paramView2);
        paramView1 = ((pf)localObject2).RXM.get(0);
        p.j(paramView1, "bizInfo.AppMsg[0]");
        localObject1 = (pe)paramView1;
        p.k(paramz, "info");
        p.k(localObject2, "bizInfo");
        p.k(localObject1, "appMsg");
        Object localObject4 = ((pe)localObject1).fwr;
        paramView1 = ((pe)localObject1).RTk;
        i = ((pe)localObject1).lpx;
        Object localObject3 = ((pe)localObject1).RTm;
        String str = ((pe)localObject1).RTn;
        paramView2.sGQ.aL((CharSequence)localObject4);
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
        {
          localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
          com.tencent.mm.plugin.brandservice.ui.b.d.e(paramView2.sGQ);
        }
        paramView2.sEm.setBackgroundResource(d.d.spE);
        paramView2.sEm.setOnClickListener((View.OnClickListener)new z.a.a(paramView2, paramz, (pf)localObject2, (pe)localObject1));
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil(paramView1))) {
          ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView1, i, 90, new Object[0]);
        }
        paramView2.sCU.type = i;
        paramView2.sCU.lpK = ((String)localObject3);
        paramView2.sCU.lqb = str;
        paramView2.sCU.url = paramView1;
        paramView1 = paramView2.sDk;
        p.j(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject3 = paramView2.sDl;
        p.j(localObject3, "friendReadTv");
        if (!Util.isNullOrNil(((pe)localObject1).CPq)) {}
        for (paramView1 = (CharSequence)String.valueOf(((pe)localObject1).CPq);; paramView1 = (CharSequence)"")
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
            break label1668;
          }
          paramView2.sCR.setVisibility(8);
          p.k(paramz, "info");
          p.k(localObject2, "appMsgBizInfo");
          p.k(localObject1, "appMsg");
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
            break label1566;
          }
          paramView2.sGU.setImageResource(d.d.dmz);
          paramView1 = paramView2.sGU;
          p.j(paramView1, "voicePlayIcon");
          if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
            break label1451;
          }
          paramView1 = paramView2.sGU;
          p.j(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (paramView1 != null) {
            break;
          }
          paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(266744);
          throw paramz;
        }
        ((AnimationDrawable)paramView1).start();
        paramView1 = ((pe)localObject1).RXH;
        if (Util.isNullOrNil(paramView1)) {
          Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        }
        for (;;)
        {
          paramView1 = (kotlin.g.a.m)z.a.c.sFH;
          localObject1 = (s)z.a.d.sFI;
          localObject2 = paramView2.rgA;
          p.j(localObject2, "content");
          ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt));
          paramView2 = paramView2.mrE;
          p.j(paramView2, "topLine");
          paramView1.invoke(paramView2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx));
          break;
          paramView2.sGU.setImageResource(d.d.dmy);
          break label1451;
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a((View)paramView2.sGU, String.valueOf(paramz.field_msgId) + "_1", ((pe)localObject1).fwr, paramView1, "", ((pe)localObject1).RTm);
          paramView2.sGU.setOnClickListener((View.OnClickListener)new z.a.e(paramView2, paramz, (pe)localObject1));
          continue;
          if (!Util.isNullOrNil(paramView2.sCU.lpK))
          {
            paramView2.sCR.setVisibility(0);
            paramView1 = paramView2.sHf.sAc;
            long l = paramz.field_msgId;
            localObject1 = paramView2.sCU;
            localObject2 = com.tencent.mm.aj.m.a(paramView2.sCU);
            localObject3 = paramView2.sCR;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
            paramView1.a(l, 1, (v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new z.a.b(paramView2, paramz), paramz.sHe + 1, 2.0F);
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
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
            paramView1.a((String)localObject1, (ImageView)localObject2, i, i, paramz.sHe + 1);
          }
          else
          {
            paramView2.sGS.setVisibility(8);
          }
        }
        paramView1 = this.sDP;
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
      }
      AppMethodBeat.o(266744);
      return;
      localObject1 = this.sDO;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.sDO;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramView2.SwI);
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.l(this.sDO);
      if (Util.isNullOrNil(paramView2.SwH))
      {
        paramz = this.sEu;
        if (paramz != null)
        {
          paramz.setClickable(false);
          AppMethodBeat.o(266744);
          return;
        }
        AppMethodBeat.o(266744);
        return;
      }
      localObject1 = this.sDO;
      if (localObject1 != null) {
        ((TextView)localObject1).post((Runnable)new e(this, paramView1));
      }
      paramz = (kotlin.g.a.a)new g(this, paramView2, paramView1, paramz);
      paramView1 = this.sEu;
      if (paramView1 != null)
      {
        paramView1.setOnClickListener((View.OnClickListener)new z.f(paramz));
        AppMethodBeat.o(266744);
        return;
      }
      AppMethodBeat.o(266744);
      return;
    }
  }
  
  public final void a(com.tencent.mm.storage.z paramz, ae paramae)
  {
    AppMethodBeat.i(266746);
    p.k(paramz, "info");
    p.k(paramae, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramae);
    AppMethodBeat.o(266746);
  }
  
  public final void a(com.tencent.mm.storage.z paramz, String paramString)
  {
    AppMethodBeat.i(266748);
    p.k(paramz, "info");
    p.k(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(266748);
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
    AppMethodBeat.i(266745);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(266745);
      return;
    }
    AppMethodBeat.o(266745);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(265750);
      this.sCg = paramContext;
      this.context = localObject;
      this.sEm = View.inflate(this.context, d.f.stT, null);
      this.sCU = new v();
      this.mrE = this.sEm.findViewById(d.e.top_line);
      this.rgA = ((ViewGroup)this.sEm.findViewById(d.e.content_ll));
      this$1 = this.sEm.findViewById(d.e.stf);
      if (z.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(265750);
        throw z.this;
      }
      this.sGQ = ((MMNeat7extView)z.this);
      this.sGR = ((TextView)this.sEm.findViewById(d.e.summary));
      this.sGS = this.sEm.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sEm.findViewById(d.e.cover_iv));
      this.sGT = this.sEm.findViewById(d.e.dum);
      this.sGU = ((ImageView)this.sEm.findViewById(d.e.srt));
      this.sGV = ((ImageView)this.sEm.findViewById(d.e.play_icon));
      this.sDk = this.sEm.findViewById(d.e.sta);
      this$1 = this.sEm.findViewById(d.e.srT);
      if (z.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(265750);
        throw z.this;
      }
      this.sDl = ((TextView)z.this);
      this.sGW = this.sEm.findViewById(d.e.ssl);
      this.sGX = this.sEm.findViewById(d.e.ssk);
      this.sDY = ((TextView)this.sEm.findViewById(d.e.dRg));
      AppMethodBeat.o(265750);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(z.a parama, com.tencent.mm.storage.z paramz, pf parampf, pe parampe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(257826);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramView = this.sFG;
        localObject1 = this.sAV;
        pf localpf = this.sEC;
        pe localpe = this.sCX;
        int k = this.sAW;
        p.k(localObject1, "info");
        p.k(localpf, "appMsgBizInfo");
        if ((localpe != null) && (((com.tencent.mm.storage.z)localObject1).hwK() != null))
        {
          localObject2 = ((com.tencent.mm.storage.z)localObject1).hwK();
          if (localObject2 == null) {
            p.iCn();
          }
          if (((eqb)localObject2).Usy != null) {}
        }
        else
        {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(257826);
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
        paramView.sFF.a((com.tencent.mm.storage.z)localObject1, "PAUSE_FOR_RESUME");
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView.context, (String)localObject3, localpe.lpx, 169, 10000, (Intent)localObject2))) {
          Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.storage.z)localObject1).hwL();
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
          paramView.sCg.szZ.a(localpf.UserName, l, i, 15, ((eqg)localObject2).Uaw, "", k, ((eqg)localObject2).UsF.RVm, ((eqg)localObject2).event, ((eqg)localObject2).UsF.RVi, localpe.RXJ, ((eqg)localObject2).style, localpe.RXK);
          paramView.sCg.b((com.tencent.mm.storage.z)localObject1, k);
          break;
          com.tencent.mm.by.c.b(paramView.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(com.tencent.mm.storage.z paramz) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(266101);
        this.sFG.a(this.sFG.sCU, true);
        this.sFG.sHf.sAc.p(this.sAV.field_msgId, this.sEq);
        AppMethodBeat.o(266101);
      }
      
      public final void onStart() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(z.a parama, com.tencent.mm.storage.z paramz, pe parampe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(264430);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN((View)this.sFG.sGU);
        if (this.sAV.hwL() != null) {}
        try
        {
          paramView = Uri.parse(this.sCX.RTk);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(264430);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<pf, x>
  {
    b(z paramz, com.tencent.mm.storage.z paramz1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(z paramz, com.tencent.mm.storage.z paramz1, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(260297);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = paramz.hwL();
      if (z.e(this.sFF) == -1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260297);
        return;
      }
      localObject1 = (pf)paramz.hwL().UsF.RVd.get(z.e(this.sFF));
      pe localpe = (pe)((pf)localObject1).RXM.get(0);
      Object localObject2 = localpe.RTk;
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
      this.sFF.sCg.szZ.a(((pf)localObject1).UserName, l1, i, 16, paramView.Uaw, "", 0, paramView.UsF.RVm, paramView.event, paramView.UsF.RVi, localpe.RXJ, paramView.style, localpe.RXK);
      ((e)new e(this.sFF.context, paramz, this.sFF.sCg, (pf)localObject1, paramInt).iM((View)z.f(this.sFF))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(260297);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(z paramz, com.tencent.mm.storage.z paramz1) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(257939);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      this.sFF.sCg.szY = paramz;
      this.sFF.sCg.czS();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(257939);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(z paramz, eqg parameqg) {}
    
    public final void run()
    {
      AppMethodBeat.i(257560);
      Object localObject = z.g(this.sFF);
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getLayout();
        if (localObject != null)
        {
          TextView localTextView = z.h(this.sFF);
          if (localTextView != null)
          {
            if ((((Layout)localObject).getLineCount() > 0) && (((Layout)localObject).getEllipsisCount(((Layout)localObject).getLineCount() - 1) > 0)) {}
            for (localObject = (CharSequence)this.sFF.context.getString(d.i.svc);; localObject = (CharSequence)paramView1.UsF.SwE)
            {
              localTextView.setText((CharSequence)localObject);
              AppMethodBeat.o(257560);
              return;
            }
          }
          AppMethodBeat.o(257560);
          return;
        }
      }
      AppMethodBeat.o(257560);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(z paramz, amf paramamf, eqg parameqg, com.tencent.mm.storage.z paramz1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<z.a>
  {
    h(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.z
 * JD-Core Version:    0.7.0.1
 */