package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.text.Layout;
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
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "hide", "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class y
  extends ad
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private TextView puA;
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  private View pvb;
  private View pve;
  private WeImageView pvf;
  private g pvg;
  private d pvh;
  private boolean pvi;
  private TextView pwh;
  private int pwi;
  
  public y(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(195441);
    this.psQ = paramb;
    this.context = paramContext;
    this.puQ = new LinkedList();
    this.puR = new i((kotlin.g.a.a)new h(this));
    this.pvg = new g(this.context, this.psQ);
    this.pvh = new d(this.context, this.psQ);
    this.pwi = -1;
    AppMethodBeat.o(195441);
  }
  
  public final void a(final z paramz, final int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(195437);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.puO == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(2131309882)).inflate();
      this.pve = paramView2.findViewById(2131298783);
      this.pvf = ((WeImageView)paramView2.findViewById(2131298782));
      this.puP = ((LinearLayout)paramView2.findViewById(2131297485));
      this.pvb = paramView2.findViewById(2131297433);
      this.pwh = ((TextView)paramView2.findViewById(2131305433));
      this.puA = ((TextView)paramView2.findViewById(2131302933));
      this.puO = paramView2;
    }
    this.pwi = -1;
    paramView2 = paramz.gAD().Nga.KUf;
    p.g(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView2 = (Iterable)j.b((Iterable)paramView2, 2);
    int i = 0;
    paramView2 = paramView2.iterator();
    int j = 0;
    Object localObject1;
    if (paramView2.hasNext())
    {
      localObject1 = paramView2.next();
      if (i < 0) {
        j.hxH();
      }
      if (((pj)localObject1).KHa != 0) {
        break label2101;
      }
      int k = j + 1;
      if (this.pwi == -1)
      {
        j = i;
        label246:
        this.pwi = j;
        j = k;
      }
    }
    label1443:
    label2101:
    for (;;)
    {
      i += 1;
      break;
      j = this.pwi;
      break label246;
      if ((j <= 0) || (this.pwi == -1))
      {
        AppMethodBeat.o(195437);
        return;
      }
      paramView1.setVisibility(0);
      paramView1 = this.puO;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      this.pvi = false;
      paramView1 = (kotlin.g.a.b)new b(this, paramz);
      switch (j)
      {
      default: 
        paramView1 = this.pwh;
        if (paramView1 != null) {
          paramView1.setText((CharSequence)paramz.NQn.Nga.Lug);
        }
        paramView1 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(this.pwh);
        paramView1 = this.pvb;
        if (paramView1 != null) {
          paramView1.setOnLongClickListener((View.OnLongClickListener)new d(this, paramz));
        }
        if ((!Util.isNullOrNil((List)paramz.gAD().Nga.KWr)) && (paramz.gAD().Nga.KWs == 1))
        {
          paramView1 = this.pve;
          if (paramView1 != null) {
            paramView1.setVisibility(0);
          }
          paramView1 = this.pve;
          if (paramView1 != null) {
            paramView1.setOnClickListener((View.OnClickListener)new c(this, paramz, paramInt));
          }
        }
        break;
      }
      for (;;)
      {
        paramView1 = paramz.gAD();
        p.g(paramView1, "info.tlRecCardWrapper");
        paramView2 = paramView1.Nga;
        if (!Util.isNullOrNil(paramView2.Luk)) {
          break label1930;
        }
        paramz = this.puA;
        if (paramz != null) {
          paramz.setVisibility(8);
        }
        paramz = this.pvb;
        if (paramz == null) {
          break label1924;
        }
        paramz.setOnClickListener(null);
        AppMethodBeat.o(195437);
        return;
        paramView2 = paramz.gAD().Nga.KUf.get(this.pwi);
        p.g(paramView2, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
        paramView1.invoke(paramView2);
        paramView1 = ((Iterable)this.puQ).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.puP;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.puS);
          }
          this.puR.da(paramView2);
        }
        this.puQ.clear();
        break;
        paramView2 = paramz.gAD().Nga.KUf.get(0);
        p.g(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
        paramView1.invoke(paramView2);
        paramView1 = paramz.gAD().Nga.KUf.get(1);
        p.g(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
        Object localObject2 = (pj)paramView1;
        paramView1 = ((Iterable)this.puQ).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.puP;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.puS);
          }
          this.puR.da(paramView2);
        }
        this.puQ.clear();
        paramView2 = (a)this.puR.get();
        paramView1 = this.puP;
        if (paramView1 != null) {
          paramView1.addView(paramView2.puS);
        }
        this.puQ.add(paramView2);
        paramView1 = ((pj)localObject2).KWy.get(0);
        p.g(paramView1, "bizInfo.AppMsg[0]");
        localObject1 = (pi)paramView1;
        p.h(paramz, "info");
        p.h(localObject2, "bizInfo");
        p.h(localObject1, "appMsg");
        Object localObject4 = ((pi)localObject1).Title;
        paramView1 = ((pi)localObject1).KSj;
        i = ((pi)localObject1).iAb;
        Object localObject3 = ((pi)localObject1).KSl;
        String str = ((pi)localObject1).KSm;
        paramView2.pxp.aw((CharSequence)localObject4);
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
        {
          localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
          com.tencent.mm.plugin.brandservice.ui.b.d.c(paramView2.pxp);
        }
        paramView2.puS.setBackgroundResource(2131231316);
        paramView2.puS.setOnClickListener((View.OnClickListener)new y.a.a(paramView2, paramz, (pj)localObject2, (pi)localObject1));
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil(paramView1))) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramView1, i, 90, new Object[0]);
        }
        paramView2.ptH.type = i;
        paramView2.ptH.iAo = ((String)localObject3);
        paramView2.ptH.iAD = str;
        paramView2.ptH.url = paramView1;
        paramView1 = paramView2.ptX;
        p.g(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject3 = paramView2.ptY;
        p.g(localObject3, "friendReadTv");
        if (!Util.isNullOrNil(((pi)localObject1).xLi)) {}
        for (paramView1 = (CharSequence)String.valueOf(((pi)localObject1).xLi);; paramView1 = (CharSequence)"")
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
            break label1660;
          }
          paramView2.ptE.setVisibility(8);
          p.h(paramz, "info");
          p.h(localObject2, "appMsgBizInfo");
          p.h(localObject1, "appMsg");
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
            break label1558;
          }
          paramView2.pxt.setImageResource(2131231332);
          paramView1 = paramView2.pxt;
          p.g(paramView1, "voicePlayIcon");
          if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
            break label1443;
          }
          paramView1 = paramView2.pxt;
          p.g(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (paramView1 != null) {
            break;
          }
          paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(195437);
          throw paramz;
        }
        ((AnimationDrawable)paramView1).start();
        paramView1 = ((pi)localObject1).KWt;
        if (Util.isNullOrNil(paramView1)) {
          Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        }
        for (;;)
        {
          paramView1 = (kotlin.g.a.m)y.a.c.pwl;
          localObject1 = (s)y.a.d.pwm;
          localObject2 = paramView2.pxo;
          p.g(localObject2, "content");
          ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
          paramView2 = paramView2.jBI;
          p.g(paramView2, "topLine");
          paramView1.invoke(paramView2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
          break;
          paramView2.pxt.setImageResource(2131231331);
          break label1443;
          ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)paramView2.pxt, String.valueOf(paramz.field_msgId) + "_1", ((pi)localObject1).Title, paramView1, "", ((pi)localObject1).KSl);
          paramView2.pxt.setOnClickListener((View.OnClickListener)new y.a.e(paramView2, paramz, (pi)localObject1));
          continue;
          label1660:
          if (!Util.isNullOrNil(paramView2.ptH.iAo))
          {
            paramView2.ptE.setVisibility(0);
            paramView1 = paramView2.pxE.prc;
            long l = paramz.field_msgId;
            localObject1 = paramView2.ptH;
            localObject2 = com.tencent.mm.ag.m.a(paramView2.ptH);
            localObject3 = paramView2.ptE;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
            paramView1.a(l, 1, (v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new y.a.b(paramView2, paramz), paramz.pxD + 1, 2.0F);
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
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
            paramView1.a("2131231740", (ImageView)localObject1, i, i, paramz.pxD + 1);
          }
          else
          {
            paramView2.pxr.setVisibility(8);
          }
        }
        paramView1 = this.pve;
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
      }
      AppMethodBeat.o(195437);
      return;
      localObject1 = this.puA;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.puA;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramView2.Luk);
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      com.tencent.mm.plugin.brandservice.ui.b.d.i(this.puA);
      if (Util.isNullOrNil(paramView2.Luj))
      {
        paramz = this.pvb;
        if (paramz != null)
        {
          paramz.setClickable(false);
          AppMethodBeat.o(195437);
          return;
        }
        AppMethodBeat.o(195437);
        return;
      }
      localObject1 = this.puA;
      if (localObject1 != null) {
        ((TextView)localObject1).post((Runnable)new e(this, paramView1));
      }
      paramz = (kotlin.g.a.a)new g(this, paramView2, paramView1, paramz);
      paramView1 = this.pvb;
      if (paramView1 != null)
      {
        paramView1.setOnClickListener((View.OnClickListener)new y.f(paramz));
        AppMethodBeat.o(195437);
        return;
      }
      AppMethodBeat.o(195437);
      return;
    }
  }
  
  public final void a(z paramz, ad paramad)
  {
    AppMethodBeat.i(195439);
    p.h(paramz, "info");
    p.h(paramad, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramad);
    AppMethodBeat.o(195439);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(195440);
    p.h(paramz, "info");
    p.h(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(195440);
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
    AppMethodBeat.i(195438);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195438);
      return;
    }
    AppMethodBeat.o(195438);
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(195428);
      this.psQ = paramContext;
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493270, null);
      this.ptH = new v();
      this.jBI = this.puS.findViewById(2131309322);
      this.pxo = this.puS.findViewById(2131299208);
      this$1 = this.puS.findViewById(2131309237);
      if (y.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195428);
        throw y.this;
      }
      this.pxp = ((MMNeat7extView)y.this);
      this.pxq = ((TextView)this.puS.findViewById(2131308767));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxs = this.puS.findViewById(2131297533);
      this.pxt = ((ImageView)this.puS.findViewById(2131297588));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.ptX = this.puS.findViewById(2131308374);
      this$1 = this.puS.findViewById(2131301796);
      if (y.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195428);
        throw y.this;
      }
      this.ptY = ((TextView)y.this);
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      this.puD = ((TextView)this.puS.findViewById(2131305934));
      AppMethodBeat.o(195428);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(y.a parama, z paramz, pj parampj, pi parampi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195421);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = this.pwk;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195421);
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
        ((y.a)localObject1).pwj.a(localz, "PAUSE_FOR_RESUME");
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((y.a)localObject1).context, (String)localObject2, localpi.iAb, 169, 10000, localIntent))) {
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
          ((y.a)localObject1).psQ.pqZ.a(localpj.UserName, l, i, 15, paramView.MOC, "", k, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, localpi.KWv, paramView.style, localpi.KWw);
          ((y.a)localObject1).psQ.b(localz, k);
          break;
          com.tencent.mm.br.c.b(((y.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195422);
        this.pwk.a(this.pwk.ptH, true);
        this.pwk.pxE.prc.m(this.prL.field_msgId, this.puX);
        AppMethodBeat.o(195422);
      }
      
      public final void onStart() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(y.a parama, z paramz, pi parampi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195427);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq((View)this.pwk.pxt);
        if (this.prL.gAD() != null) {}
        try
        {
          paramView = Uri.parse(this.ptK.KSj);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195427);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<pj, kotlin.x>
  {
    b(y paramy, z paramz)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(y paramy, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195431);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      paramView = paramz.gAD();
      if (y.e(this.pwj) == -1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195431);
        return;
      }
      localObject1 = (pj)paramz.gAD().Nga.KUf.get(y.e(this.pwj));
      pi localpi = (pi)((pj)localObject1).KWy.get(0);
      Object localObject2 = localpi.KSj;
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
      this.pwj.psQ.pqZ.a(((pj)localObject1).UserName, l1, i, 16, paramView.MOC, "", 0, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, localpi.KWv, paramView.style, localpi.KWw);
      ((e)new e(this.pwj.context, paramz, this.pwj.psQ, (pj)localObject1, paramInt).hw((View)y.f(this.pwj))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195431);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(y paramy, z paramz) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(195432);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      this.pwj.psQ.pqY = paramz;
      this.pwj.psQ.cmn();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(195432);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(y paramy, ege paramege) {}
    
    public final void run()
    {
      AppMethodBeat.i(195433);
      Object localObject = y.g(this.pwj);
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getLayout();
        if (localObject != null)
        {
          TextView localTextView = y.h(this.pwj);
          if (localTextView != null)
          {
            if ((((Layout)localObject).getLineCount() > 0) && (((Layout)localObject).getEllipsisCount(((Layout)localObject).getLineCount() - 1) > 0)) {}
            for (localObject = (CharSequence)this.pwj.context.getString(2131756799);; localObject = (CharSequence)paramView1.Nga.Lug)
            {
              localTextView.setText((CharSequence)localObject);
              AppMethodBeat.o(195433);
              return;
            }
          }
          AppMethodBeat.o(195433);
          return;
        }
      }
      AppMethodBeat.o(195433);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    g(y paramy, ale paramale, ege paramege, z paramz)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<y.a>
  {
    h(y paramy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y
 * JD-Core Version:    0.7.0.1
 */