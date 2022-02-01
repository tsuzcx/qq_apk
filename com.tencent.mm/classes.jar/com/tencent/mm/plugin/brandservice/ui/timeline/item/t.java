package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class t
  extends ad
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  private View pvb;
  private ImageView pvc;
  private TextView pvd;
  private View pve;
  private WeImageView pvf;
  private g pvg;
  private d pvh;
  private boolean pvi;
  
  public t(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(195372);
    this.psQ = paramb;
    this.context = paramContext;
    this.puQ = new LinkedList();
    this.puR = new i((kotlin.g.a.a)new h(this));
    this.pvg = new g(this.context, this.psQ);
    this.pvh = new d(this.context, this.psQ);
    AppMethodBeat.o(195372);
  }
  
  public final void a(final z paramz, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195368);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.puO == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(2131309870)).inflate();
      this.pvb = paramView2.findViewById(2131297433);
      this.pvc = ((ImageView)paramView2.findViewById(2131297134));
      this.pvd = ((TextView)paramView2.findViewById(2131305433));
      this.pve = paramView2.findViewById(2131298783);
      this.pvf = ((WeImageView)paramView2.findViewById(2131298782));
      this.puP = ((LinearLayout)paramView2.findViewById(2131297485));
      this.puO = paramView2;
    }
    Object localObject2 = paramz.gAD();
    p.g(localObject2, "info.tlRecCardWrapper");
    paramView2 = t.c.pvp;
    Object localObject1 = (kotlin.g.a.b)t.b.pvo;
    label204:
    int i;
    if (localObject2 != null)
    {
      paramView2 = ((ege)localObject2).NfY;
      if (paramView2 != null)
      {
        if (localObject2 == null) {
          break label237;
        }
        paramView2 = ((ege)localObject2).NfY;
        if (paramView2 == null) {
          break label237;
        }
        paramView2 = paramView2.NfT;
        if ((paramView2 != null) && (((ege)localObject2).Nga != null)) {
          break label243;
        }
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label355;
      }
      AppMethodBeat.o(195368);
      return;
      paramView2 = null;
      break;
      label237:
      paramView2 = null;
      break label204;
      label243:
      if (Util.isNullOrNil((List)((ege)localObject2).Nga.KUf))
      {
        i = 0;
      }
      else
      {
        paramView2 = ((ege)localObject2).Nga.KUf;
        p.g(paramView2, "wrapper.extraInfo.BizInfo");
        paramView2 = ((Iterable)paramView2).iterator();
        for (;;)
        {
          if (paramView2.hasNext())
          {
            localObject2 = (pj)paramView2.next();
            p.g(localObject2, "info");
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
    label355:
    paramView1.setVisibility(0);
    paramView1 = this.puO;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    localObject1 = (pj)paramz.gAD().Nga.KUf.get(0);
    p.g(localObject1, "bizInfo");
    a.b.d(this.pvc, ((pj)localObject1).UserName);
    paramView1 = this.pvd;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)((pj)localObject1).oUJ);
    }
    paramView1 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    com.tencent.mm.plugin.brandservice.ui.b.d.i(this.pvd);
    paramView1 = this.pvb;
    if (paramView1 != null) {
      paramView1.setOnClickListener((View.OnClickListener)new f(this, paramz));
    }
    paramView1 = this.pvb;
    if (paramView1 != null) {
      paramView1.setOnLongClickListener((View.OnLongClickListener)new g(this, paramz, (pj)localObject1));
    }
    if ((!Util.isNullOrNil((List)((pj)localObject1).KWr)) && (((pj)localObject1).KWs == 1))
    {
      paramView1 = this.pve;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.pve;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new e(this, paramz, (pj)localObject1, paramInt));
      }
      this.pvi = false;
      switch (((pi)((pj)localObject1).KWy.get(0)).iAb)
      {
      default: 
        paramView1 = this.pvh;
        paramView2 = this.puO;
        if (paramView2 == null) {
          p.hyc();
        }
        paramView1.a(paramView2, paramz, (pj)localObject1);
        this.pvg.hide();
      }
    }
    for (;;)
    {
      paramView1 = ((Iterable)this.puQ).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        localObject2 = this.puP;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).removeView(paramView2.puS);
        }
        this.puR.da(paramView2);
      }
      paramView1 = this.pve;
      if (paramView1 == null) {
        break;
      }
      paramView1.setVisibility(8);
      break;
      this.pvi = true;
      paramView1 = this.pvg;
      paramView2 = this.puO;
      if (paramView2 == null) {
        p.hyc();
      }
      paramView1.a(paramView2, paramz, (pj)localObject1);
      this.pvh.hide();
      a(paramz, (ad)this);
      paramView1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.q(paramz);
      this.pvg.ptZ = ((kotlin.g.a.a)new d(this, paramz));
    }
    this.puQ.clear();
    Object localObject3;
    if (((pj)localObject1).KWy.size() > 1)
    {
      paramView2 = (a)this.puR.get();
      paramView1 = this.puP;
      if (paramView1 != null) {
        paramView1.addView(paramView2.puS);
      }
      this.puQ.add(paramView2);
      paramView1 = ((pj)localObject1).KWy.get(1);
      p.g(paramView1, "bizInfo.AppMsg[1]");
      localObject2 = (pi)paramView1;
      p.h(paramz, "info");
      p.h(localObject1, "bizInfo");
      p.h(localObject2, "appMsg");
      Object localObject4 = ((pi)localObject2).Title;
      paramView1 = ((pi)localObject2).KSj;
      paramInt = ((pi)localObject2).iAb;
      localObject3 = ((pi)localObject2).KSl;
      String str = ((pi)localObject2).KSm;
      paramView2.pxp.aw((CharSequence)localObject4);
      localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
      {
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.c(paramView2.pxp);
      }
      paramView2.puS.setBackgroundResource(2131231316);
      paramView2.puS.setOnClickListener((View.OnClickListener)new t.a.a(paramView2, paramz, (pj)localObject1, (pi)localObject2));
      if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil(paramView1))) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramView1, paramInt, 90, new Object[0]);
      }
      paramView2.ptH.type = paramInt;
      paramView2.ptH.iAo = ((String)localObject3);
      paramView2.ptH.iAD = str;
      paramView2.ptH.url = paramView1;
      paramView1 = paramView2.ptX;
      p.g(paramView1, "statLayout");
      paramView1.setVisibility(0);
      localObject3 = paramView2.ptY;
      p.g(localObject3, "friendReadTv");
      if (!Util.isNullOrNil(((pi)localObject2).xLi)) {}
      for (paramView1 = (CharSequence)String.valueOf(((pi)localObject2).xLi);; paramView1 = (CharSequence)"")
      {
        ((TextView)localObject3).setText(paramView1);
        paramView1 = paramView2.pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView2.pxu.setImageResource(2131231330);
        paramView1 = paramView2.pxs;
        p.g(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(8);
        if (paramView2.ptH.type != 7) {
          break label1717;
        }
        paramView2.ptE.setVisibility(8);
        p.h(paramz, "info");
        p.h(localObject1, "appMsgBizInfo");
        p.h(localObject2, "appMsg");
        paramView1 = paramView2.pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView1 = paramView2.pxs;
        p.g(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(0);
        paramView1 = paramView2.pxt;
        p.g(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
          ((AnimationDrawable)paramView1).stop();
        }
        if (!p.j(String.valueOf(paramz.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.crh())) {
          break label1615;
        }
        paramView2.pxt.setImageResource(2131231332);
        paramView1 = paramView2.pxt;
        p.g(paramView1, "voicePlayIcon");
        if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
          break label1455;
        }
        paramView1 = paramView2.pxt;
        p.g(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (paramView1 != null) {
          break;
        }
        paramz = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(195368);
        throw paramz;
      }
      ((AnimationDrawable)paramView1).start();
      label1455:
      paramView1 = ((pi)localObject2).KWt;
      if (!Util.isNullOrNil(paramView1)) {
        break label1629;
      }
      Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
    }
    for (;;)
    {
      paramView1 = (kotlin.g.a.m)t.a.c.pvm;
      localObject1 = (s)t.a.d.pvn;
      localObject2 = paramView2.pxo;
      p.g(localObject2, "content");
      ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
      localObject1 = paramView2.jBI;
      p.g(localObject1, "topLine");
      paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
      if (paramView2.ptH.type == 5)
      {
        paramView1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(paramView2.ptH.url, paramView2.ptH.type, "");
      }
      com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
      AppMethodBeat.o(195368);
      return;
      label1615:
      paramView2.pxt.setImageResource(2131231331);
      break;
      label1629:
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)paramView2.pxt, String.valueOf(paramz.field_msgId) + "_1", ((pi)localObject2).Title, paramView1, "", ((pi)localObject2).KSl);
      paramView2.pxt.setOnClickListener((View.OnClickListener)new t.a.e(paramView2, paramz, (pi)localObject2));
      continue;
      label1717:
      if (!Util.isNullOrNil(paramView2.ptH.iAo))
      {
        paramView2.ptE.setVisibility(0);
        paramView1 = paramView2.pxE.prc;
        long l = paramz.field_msgId;
        localObject1 = paramView2.ptH;
        localObject2 = com.tencent.mm.ag.m.a(paramView2.ptH);
        localObject3 = paramView2.ptE;
        paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
        paramView1.a(l, 1, (v)localObject1, (String)localObject2, (ImageView)localObject3, paramInt, paramInt, false, (m.a)new t.a.b(paramView2, paramz), paramz.pxD + 1, 2.0F);
        if (paramView2.ptH.type == 5)
        {
          paramView1 = paramView2.pxu;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(0);
        }
      }
      else if ((paramView2.ptH.type == 5) || (paramView2.ptH.type == 6))
      {
        paramView1 = paramView2.pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(0);
        paramView2.ptE.setVisibility(0);
        paramView1 = paramView2.pxE.prc;
        localObject1 = paramView2.ptE;
        paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
        paramView1.a("2131231740", (ImageView)localObject1, paramInt, paramInt, paramz.pxD + 1);
      }
      else
      {
        paramView2.pxr.setVisibility(8);
      }
    }
  }
  
  public final void a(z paramz, ad paramad)
  {
    AppMethodBeat.i(195370);
    p.h(paramz, "info");
    p.h(paramad, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramad);
    AppMethodBeat.o(195370);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(195371);
    p.h(paramz, "info");
    p.h(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(195371);
  }
  
  public final boolean cmS()
  {
    return this.pvi;
  }
  
  public final View getVideoView()
  {
    return this.pvg.puc;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195369);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195369);
      return;
    }
    AppMethodBeat.o(195369);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends ah
  {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    final v ptH;
    final View puS;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(195358);
      this.psQ = paramContext;
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493270, null);
      this.ptH = new v();
      this.jBI = this.puS.findViewById(2131309322);
      this.pxo = this.puS.findViewById(2131299208);
      this$1 = this.puS.findViewById(2131309237);
      if (t.this == null)
      {
        this$1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195358);
        throw t.this;
      }
      this.pxp = ((MMNeat7extView)t.this);
      this.pxq = ((TextView)this.puS.findViewById(2131308767));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxs = this.puS.findViewById(2131297533);
      this.pxt = ((ImageView)this.puS.findViewById(2131297588));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.ptX = this.puS.findViewById(2131308374);
      this$1 = this.puS.findViewById(2131301796);
      if (t.this == null)
      {
        this$1 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195358);
        throw t.this;
      }
      this.ptY = ((TextView)t.this);
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      this.puD = ((TextView)this.puS.findViewById(2131305934));
      AppMethodBeat.o(195358);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(t.a parama, z paramz, pj parampj, pi parampi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195351);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = this.pvk;
        z localz = this.prL;
        pj localpj = this.pvl;
        pi localpi = this.ptK;
        int k = this.prP;
        p.h(localz, "info");
        p.h(localpj, "appMsgBizInfo");
        if ((localpi != null) && (localz.gAC() != null))
        {
          localObject2 = localz.gAC();
          if (localObject2 == null) {
            p.hyc();
          }
          if (((efz)localObject2).NfT != null) {}
        }
        else
        {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195351);
          return;
        }
        h.CyF.idkeyStat(1149L, 4L, 1L, false);
        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpi.KSj });
        Intent localIntent = new Intent();
        Object localObject2 = com.tencent.mm.ag.m.d(localpi.KSj, 169, 10000, 0);
        localIntent.putExtra("rawUrl", (String)localObject2);
        localIntent.putExtra("geta8key_scene", 56);
        localIntent.putExtra("geta8key_username", localpj.UserName);
        localIntent.putExtra("srcUsername", localpj.UserName);
        localIntent.putExtra("srcDisplayname", localpj.oUJ);
        localIntent.putExtra("prePublishId", "rec_card");
        localIntent.putExtra("KPublisherId", "rec_card");
        int i;
        int j;
        if (localpi.iAb == 5)
        {
          Object localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
          p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
          if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).cld())
          {
            localIntent.putExtra(e.b.OyQ, 169);
            localIntent.putExtra(e.b.OyR, 10000);
            localIntent.putExtra("biz_video_session_id", ab.getSessionId());
            localObject3 = new com.tencent.mm.ag.x();
            ((com.tencent.mm.ag.x)localObject3).iAh = localIntent.getStringExtra("KPublisherId");
            ((com.tencent.mm.ag.x)localObject3).dHc = localpj.UserName;
            ((com.tencent.mm.ag.x)localObject3).iAg = localpj.oUJ;
            ((com.tencent.mm.ag.x)localObject3).iAi.url = ((String)localObject2);
            ((com.tencent.mm.ag.x)localObject3).iAi.title = localpi.Title;
            ((com.tencent.mm.ag.x)localObject3).iAi.iAq = localpi.KSh;
            ((com.tencent.mm.ag.x)localObject3).iAi.iAo = localpi.KSl;
            ((com.tencent.mm.ag.x)localObject3).iAi.type = localpi.iAb;
            ((com.tencent.mm.ag.x)localObject3).iAi.time = localpi.CreateTime;
            ((com.tencent.mm.ag.x)localObject3).iAi.iAs = localpi.KSx;
            ((com.tencent.mm.ag.x)localObject3).iAi.videoWidth = localpi.KSv;
            ((com.tencent.mm.ag.x)localObject3).iAi.videoHeight = localpi.KSw;
            ((com.tencent.mm.ag.x)localObject3).iAi.vid = localpi.KSu;
            ((com.tencent.mm.ag.x)localObject3).t(localIntent);
            Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
            localObject3 = new int[2];
            if (paramView != null)
            {
              i = paramView.getWidth();
              j = paramView.getHeight();
              paramView.getLocationInWindow((int[])localObject3);
              localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", localObject3[0]).putExtra("img_gallery_top", localObject3[1]);
            }
            localIntent.addFlags(268435456);
          }
        }
        ((t.a)localObject1).pvj.a(localz, "PAUSE_FOR_RESUME");
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((t.a)localObject1).context, (String)localObject2, localpi.iAb, 169, 10000, localIntent))) {
          Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = localz.gAD();
          if (paramView != null)
          {
            j = 0;
            i = j;
          }
          try
          {
            localObject2 = Uri.parse((String)localObject2);
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
          f.a(paramView);
          ((t.a)localObject1).psQ.pqZ.a(localpj.UserName, l, i, 15, paramView.MOC, "", k, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, localpi.KWv, paramView.style, localpi.KWw);
          ((t.a)localObject1).psQ.b(localz, k);
          break;
          com.tencent.mm.br.c.b(((t.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195352);
        this.pvk.a(this.pvk.ptH, true);
        this.pvk.pxE.prc.m(this.prL.field_msgId, this.puX);
        AppMethodBeat.o(195352);
      }
      
      public final void onStart() {}
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(t.a parama, z paramz, pi parampi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195357);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq((View)this.pvk.pxt);
        if (this.prL.gAD() != null) {}
        try
        {
          paramView = Uri.parse(this.ptK.KSj);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195357);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(t paramt, z paramz)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(t paramt, z paramz, pj parampj, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195364);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = paramz.gAD();
      localObject1 = (pi)this.pvl.KWy.get(0);
      Object localObject2 = ((pi)localObject1).KSj;
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
      this.pvj.psQ.pqZ.a(this.pvl.UserName, l1, i, 16, paramView.MOC, "", 0, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, ((pi)localObject1).KWv, paramView.style, ((pi)localObject1).KWw);
      ((e)new e(this.pvj.context, paramz, this.pvj.psQ, this.pvl, paramInt).hw((View)t.a(this.pvj))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195364);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(t paramt, z paramz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195365);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = paramz.field_talker;
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramz.field_talker);
      if ((localObject1 != null) && (!((as)localObject1).arv()))
      {
        localObject1 = this.pvj;
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Scene", 174);
        ((Intent)localObject2).putExtra("force_get_contact", true);
        ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.br.c.b(((t)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        localObject2 = paramz.gAD();
        ((t)localObject1).psQ.pqZ.a(paramView, 0L, 0, 13, ((ege)localObject2).MOC, "", 0, ((ege)localObject2).Nga.KUo, ((ege)localObject2).event, ((ege)localObject2).Nga.KUk, 0, ((ege)localObject2).style, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195365);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Chat_User", paramView);
        ((Intent)localObject1).putExtra("finish_direct", true);
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 90);
        ((Intent)localObject1).putExtra("specific_chat_from_scene", 2);
        ((Intent)localObject1).putExtra("preChatTYPE", 11);
        com.tencent.mm.br.c.f(this.pvj.context, ".ui.chatting.ChattingUI", (Intent)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.b.c.pne;
        com.tencent.mm.plugin.brandservice.b.c.t(3, paramView, "");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(t paramt, z paramz, pj parampj) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(195366);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      this.pvj.psQ.pqY = paramz;
      paramView = paramz.gAD();
      int j;
      long l1;
      int i;
      if (paramView != null)
      {
        localObject = (pi)this.pvl.KWy.get(0);
        j = 0;
        l1 = 0L;
        i = j;
      }
      try
      {
        Uri localUri = Uri.parse(((pi)localObject).KSj);
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
      this.pvj.psQ.pqZ.a(this.pvl.UserName, l1, i, 15, paramView.MOC, "", 0, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, ((pi)localObject).KWv, paramView.style, "");
      this.pvj.psQ.cmn();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(195366);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<t.a>
  {
    h(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.t
 * JD-Core Version:    0.7.0.1
 */