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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
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
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "item", "Landroid/view/View;", "jumpMore", "Landroid/widget/RelativeLayout;", "longClick", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "time", "Landroid/widget/TextView;", "txtJumpLink", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshCommonSlot", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class ac
  extends ad
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private TextView puA;
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  private RelativeLayout pwM;
  private RelativeLayout pwN;
  private TextView pwO;
  private int pwi;
  
  public ac(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(195469);
    this.psQ = paramb;
    this.context = paramContext;
    this.puQ = new LinkedList();
    this.puR = new i((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(195469);
  }
  
  public final void a(final z paramz, int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(195467);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.puO == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(2131309887)).inflate();
      this.puP = ((LinearLayout)paramView2.findViewById(2131297485));
      this.puA = ((TextView)paramView2.findViewById(2131302933));
      this.pwM = ((RelativeLayout)paramView2.findViewById(2131303823));
      this.pwN = ((RelativeLayout)paramView2.findViewById(2131304855));
      this.pwO = ((TextView)paramView2.findViewById(2131309086));
      this.puO = paramView2;
    }
    paramView1.setVisibility(0);
    paramView1 = this.puO;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = this.pwM;
    if (paramView1 != null) {
      paramView1.setOnLongClickListener((View.OnLongClickListener)new b(this, paramz));
    }
    paramView1 = this.pwO;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f(this.context, paramz.field_createTime));
    }
    paramView1 = paramz.gAD();
    p.g(paramView1, "info.tlRecCardWrapper");
    paramView2 = paramView1.Nga;
    if (Util.isNullOrNil(paramView2.Luk))
    {
      paramView1 = this.puA;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
    Object localObject1;
    for (;;)
    {
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
        paramView1 = this.puA;
        if (paramView1 != null) {
          paramView1.setOnClickListener(null);
        }
        paramView1 = this.pwN;
        if (paramView1 != null) {
          paramView1.setOnClickListener(null);
        }
      }
      else
      {
        paramView1 = (kotlin.g.a.b)new f(this, paramView2, paramView1, paramz);
        paramView2 = this.pwM;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ac.c(paramView1));
        }
        paramView2 = this.pwN;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ac.d(paramView1));
        }
        paramView2 = this.puA;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ac.e(paramView1));
        }
      }
    }
    this.puQ.clear();
    paramView1 = paramz.gAD().Nga.KUf;
    p.g(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView1 = (Iterable)paramView1;
    paramInt = 0;
    paramView2 = paramView1.iterator();
    if (paramView2.hasNext())
    {
      paramView1 = paramView2.next();
      if (paramInt < 0) {
        j.hxH();
      }
      Object localObject3 = (pj)paramView1;
      localObject1 = (a)this.puR.get();
      paramView1 = this.puP;
      if (paramView1 != null) {
        paramView1.addView(((a)localObject1).puS);
      }
      this.puQ.add(localObject1);
      p.g(localObject3, "bizInfo");
      paramView1 = ((pj)localObject3).KWy.get(0);
      p.g(paramView1, "bizInfo.AppMsg[0]");
      Object localObject2 = (pi)paramView1;
      p.h(paramz, "info");
      p.h(localObject3, "bizInfo");
      p.h(localObject2, "appMsg");
      Object localObject5 = ((pi)localObject2).Title;
      paramView1 = ((pi)localObject2).KSj;
      int j = ((pi)localObject2).iAb;
      Object localObject4 = ((pi)localObject2).KSl;
      String str = ((pi)localObject2).KSm;
      ((a)localObject1).pxp.aw((CharSequence)localObject5);
      localObject5 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
      {
        localObject5 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.c(((a)localObject1).pxp);
      }
      localObject5 = ((a)localObject1).puS;
      int i;
      if ((paramInt == 0) && (paramInt <= 0))
      {
        i = 2131231322;
        ((View)localObject5).setBackgroundResource(i);
        ((a)localObject1).puS.setOnClickListener((View.OnClickListener)new ac.a.a((a)localObject1, paramz, (pj)localObject3, (pi)localObject2, paramInt));
        if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil(paramView1))) {
          ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramView1, j, 90, new Object[0]);
        }
        ((a)localObject1).ptH.type = j;
        ((a)localObject1).ptH.iAo = ((String)localObject4);
        ((a)localObject1).ptH.iAD = str;
        ((a)localObject1).ptH.url = paramView1;
        paramView1 = ((a)localObject1).ptX;
        p.g(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject4 = ((a)localObject1).ptY;
        p.g(localObject4, "friendReadTv");
        if (Util.isNullOrNil(((pi)localObject2).xLi)) {
          break label1236;
        }
      }
      label1236:
      for (paramView1 = (CharSequence)String.valueOf(((pi)localObject2).xLi);; paramView1 = (CharSequence)"")
      {
        ((TextView)localObject4).setText(paramView1);
        paramView1 = ((a)localObject1).pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(8);
        ((a)localObject1).pxu.setImageResource(2131231330);
        paramView1 = ((a)localObject1).pxs;
        p.g(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(8);
        if (((a)localObject1).ptH.type != 7) {
          break label1463;
        }
        ((a)localObject1).ptE.setVisibility(8);
        p.h(paramz, "info");
        p.h(localObject3, "appMsgBizInfo");
        p.h(localObject2, "appMsg");
        paramView1 = ((a)localObject1).pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView1 = ((a)localObject1).pxs;
        p.g(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(0);
        paramView1 = ((a)localObject1).pxt;
        p.g(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
          ((AnimationDrawable)paramView1).stop();
        }
        if (!p.j(String.valueOf(paramz.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.crh())) {
          break label1357;
        }
        ((a)localObject1).pxt.setImageResource(2131231332);
        paramView1 = ((a)localObject1).pxt;
        p.g(paramView1, "voicePlayIcon");
        if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
          break label1253;
        }
        paramView1 = ((a)localObject1).pxt;
        p.g(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (paramView1 != null) {
          break label1246;
        }
        paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(195467);
        throw paramz;
        i = 2131231316;
        break;
      }
      label1246:
      ((AnimationDrawable)paramView1).start();
      label1253:
      paramView1 = ((pi)localObject2).KWt;
      if (Util.isNullOrNil(paramView1))
      {
        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        label1275:
        localObject2 = (kotlin.g.a.m)ac.a.c.pwR;
        paramView1 = (s)ac.a.d.pwS;
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        if (((a)localObject1).ptH.type == 5)
        {
          paramView1 = e.pAN;
          e.F(((a)localObject1).ptH.url, ((a)localObject1).ptH.type, "");
        }
        paramInt += 1;
        break;
        label1357:
        ((a)localObject1).pxt.setImageResource(2131231331);
        break label1253;
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject1).pxt, String.valueOf(paramz.field_msgId) + "_" + paramInt, ((pi)localObject2).Title, paramView1, "", ((pi)localObject2).KSl);
        ((a)localObject1).pxt.setOnClickListener((View.OnClickListener)new ac.a.e((a)localObject1, paramz, (pi)localObject2));
        break label1275;
        label1463:
        if (!Util.isNullOrNil(((a)localObject1).ptH.iAo))
        {
          ((a)localObject1).ptE.setVisibility(0);
          paramView1 = ((a)localObject1).pxE.prc;
          long l = paramz.field_msgId;
          localObject2 = ((a)localObject1).ptH;
          localObject3 = com.tencent.mm.ag.m.a(((a)localObject1).ptH);
          localObject4 = ((a)localObject1).ptE;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
          paramView1.a(l, paramInt, (v)localObject2, (String)localObject3, (ImageView)localObject4, i, i, false, (m.a)new ac.a.b((a)localObject1, paramz, paramInt), paramz.pxD + 1, 2.0F);
          if (((a)localObject1).ptH.type != 5) {
            break label1275;
          }
          paramView1 = ((a)localObject1).pxu;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(0);
          break label1275;
        }
        if ((((a)localObject1).ptH.type == 5) || (((a)localObject1).ptH.type == 6))
        {
          paramView1 = ((a)localObject1).pxu;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(0);
          ((a)localObject1).ptE.setVisibility(0);
          paramView1 = ((a)localObject1).pxE.prc;
          localObject2 = ((a)localObject1).ptE;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
          paramView1.a("2131231740", (ImageView)localObject2, i, i, paramz.pxD + 1);
          break label1275;
        }
        ((a)localObject1).pxr.setVisibility(8);
        break label1275;
        if (paramInt > 0)
        {
          localObject2 = ((a)localObject1).pxo;
          p.g(localObject2, "content");
          paramView1.a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
        }
        for (;;)
        {
          paramView1 = ((a)localObject1).jBI;
          p.g(paramView1, "topLine");
          paramView1.setVisibility(8);
          break;
          localObject2 = ((a)localObject1).pxo;
          p.g(localObject2, "content");
          paramView1.a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
        }
        localObject3 = ((a)localObject1).pxo;
        p.g(localObject3, "content");
        paramView1.a(localObject3, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
        paramView1 = ((a)localObject1).jBI;
        p.g(paramView1, "topLine");
        ((kotlin.g.a.m)localObject2).invoke(paramView1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
      }
    }
    AppMethodBeat.o(195467);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195468);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195468);
      return;
    }
    AppMethodBeat.o(195468);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(195460);
      this.psQ = paramContext;
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493270, null);
      this.ptH = new v();
      this.jBI = this.puS.findViewById(2131309322);
      this.pxo = this.puS.findViewById(2131299208);
      this$1 = this.puS.findViewById(2131309237);
      if (ac.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195460);
        throw ac.this;
      }
      this.pxp = ((MMNeat7extView)ac.this);
      this.pxq = ((TextView)this.puS.findViewById(2131308767));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxs = this.puS.findViewById(2131297533);
      this.pxt = ((ImageView)this.puS.findViewById(2131297588));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.ptX = this.puS.findViewById(2131308374);
      this$1 = this.puS.findViewById(2131301796);
      if (ac.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195460);
        throw ac.this;
      }
      this.ptY = ((TextView)ac.this);
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      this.puD = ((TextView)this.puS.findViewById(2131305934));
      AppMethodBeat.o(195460);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ac.a parama, z paramz, pj parampj, pi parampi, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195453);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = this.pwQ;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195453);
          return;
        }
        h.CyF.idkeyStat(1149L, 4L, 1L, false);
        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpi.KSj });
        Intent localIntent = new Intent();
        Object localObject2 = com.tencent.mm.ag.m.d(localpi.KSj, 183, 10000, 0);
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
          Object localObject3 = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
          p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
          if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).cld())
          {
            localIntent.putExtra(e.b.OyQ, 183);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((ac.a)localObject1).context, (String)localObject2, localpi.iAb, 183, 10000, localIntent))) {
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
          ((ac.a)localObject1).psQ.pqZ.a(localpj.UserName, l, i, 15, paramView.MOC, "", k, paramView.Nga.KUo, paramView.event, paramView.Nga.KUk, localpi.KWv, paramView.style, localpi.KWw);
          ((ac.a)localObject1).psQ.b(localz, k);
          break;
          com.tencent.mm.br.c.b(((ac.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195454);
        this.pwQ.a(this.pwQ.ptH, true);
        this.pwQ.pxE.prc.m(this.prL.field_msgId, this.puX);
        AppMethodBeat.o(195454);
      }
      
      public final void onStart() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(ac.a parama, z paramz, pi parampi) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195459);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq((View)this.pwQ.pxt);
        if (this.prL.gAD() != null) {}
        try
        {
          paramView = Uri.parse(this.ptK.KSj);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195459);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(ac paramac, z paramz) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(195461);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      this.pwP.psQ.pqY = paramz;
      this.pwP.psQ.cmn();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(195461);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "opType", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    f(ac paramac, ale paramale, ege paramege, z paramz)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ac.a>
  {
    g(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac
 * JD-Core Version:    0.7.0.1
 */