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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "item", "Landroid/view/View;", "jumpMore", "Landroid/widget/RelativeLayout;", "longClick", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "time", "Landroid/widget/TextView;", "txtJumpLink", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshCommonSlot", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class ad
  extends ae
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private TextView sDO;
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  private int sFE;
  private RelativeLayout sGi;
  private RelativeLayout sGj;
  private TextView sGk;
  
  public ad(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(266903);
    this.sCg = paramb;
    this.context = paramContext;
    this.sEk = new LinkedList();
    this.sEl = new i((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(266903);
  }
  
  public final void a(final z paramz, int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(266900);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.stx)).inflate();
      this.sEj = ((LinearLayout)paramView2.findViewById(d.e.spU));
      this.sDO = ((TextView)paramView2.findViewById(d.e.srV));
      this.sGi = ((RelativeLayout)paramView2.findViewById(d.e.srW));
      this.sGj = ((RelativeLayout)paramView2.findViewById(d.e.srX));
      this.sGk = ((TextView)paramView2.findViewById(d.e.time));
      this.sEi = paramView2;
    }
    paramView1.setVisibility(0);
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = this.sGi;
    if (paramView1 != null) {
      paramView1.setOnLongClickListener((View.OnLongClickListener)new b(this, paramz));
    }
    paramView1 = this.sGk;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f(this.context, paramz.field_createTime));
    }
    paramView1 = paramz.hwL();
    p.j(paramView1, "info.tlRecCardWrapper");
    paramView2 = paramView1.UsF;
    if (Util.isNullOrNil(paramView2.SwI))
    {
      paramView1 = this.sDO;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
    Object localObject1;
    for (;;)
    {
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
        paramView1 = this.sDO;
        if (paramView1 != null) {
          paramView1.setOnClickListener(null);
        }
        paramView1 = this.sGj;
        if (paramView1 != null) {
          paramView1.setOnClickListener(null);
        }
      }
      else
      {
        paramView1 = (kotlin.g.a.b)new f(this, paramView2, paramView1, paramz);
        paramView2 = this.sGi;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ad.c(paramView1));
        }
        paramView2 = this.sGj;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ad.d(paramView1));
        }
        paramView2 = this.sDO;
        if (paramView2 != null) {
          paramView2.setOnClickListener((View.OnClickListener)new ad.e(paramView1));
        }
      }
    }
    this.sEk.clear();
    paramView1 = paramz.hwL().UsF.RVd;
    p.j(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView1 = (Iterable)paramView1;
    paramInt = 0;
    paramView2 = paramView1.iterator();
    if (paramView2.hasNext())
    {
      paramView1 = paramView2.next();
      if (paramInt < 0) {
        j.iBO();
      }
      Object localObject3 = (pf)paramView1;
      localObject1 = (a)this.sEl.get();
      paramView1 = this.sEj;
      if (paramView1 != null) {
        paramView1.addView(((a)localObject1).sEm);
      }
      this.sEk.add(localObject1);
      p.j(localObject3, "bizInfo");
      paramView1 = ((pf)localObject3).RXM.get(0);
      p.j(paramView1, "bizInfo.AppMsg[0]");
      Object localObject2 = (pe)paramView1;
      p.k(paramz, "info");
      p.k(localObject3, "bizInfo");
      p.k(localObject2, "appMsg");
      Object localObject5 = ((pe)localObject2).fwr;
      paramView1 = ((pe)localObject2).RTk;
      int j = ((pe)localObject2).lpx;
      Object localObject4 = ((pe)localObject2).RTm;
      String str = ((pe)localObject2).RTn;
      ((a)localObject1).sGQ.aL((CharSequence)localObject5);
      localObject5 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
      {
        localObject5 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.e(((a)localObject1).sGQ);
      }
      localObject5 = ((a)localObject1).sEm;
      int i;
      if ((paramInt == 0) && (paramInt <= 0))
      {
        i = d.d.spF;
        ((View)localObject5).setBackgroundResource(i);
        ((a)localObject1).sEm.setOnClickListener((View.OnClickListener)new ad.a.a((a)localObject1, paramz, (pf)localObject3, (pe)localObject2, paramInt));
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil(paramView1))) {
          ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView1, j, 90, new Object[0]);
        }
        ((a)localObject1).sCU.type = j;
        ((a)localObject1).sCU.lpK = ((String)localObject4);
        ((a)localObject1).sCU.lqb = str;
        ((a)localObject1).sCU.url = paramView1;
        paramView1 = ((a)localObject1).sDk;
        p.j(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject4 = ((a)localObject1).sDl;
        p.j(localObject4, "friendReadTv");
        if (Util.isNullOrNil(((pe)localObject2).CPq)) {
          break label1242;
        }
      }
      label1242:
      for (paramView1 = (CharSequence)String.valueOf(((pe)localObject2).CPq);; paramView1 = (CharSequence)"")
      {
        ((TextView)localObject4).setText(paramView1);
        paramView1 = ((a)localObject1).sGV;
        p.j(paramView1, "playIcon");
        paramView1.setVisibility(8);
        ((a)localObject1).sGV.setImageResource(d.d.dmx);
        paramView1 = ((a)localObject1).sGT;
        p.j(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(8);
        if (((a)localObject1).sCU.type != 7) {
          break label1471;
        }
        ((a)localObject1).sCR.setVisibility(8);
        p.k(paramz, "info");
        p.k(localObject3, "appMsgBizInfo");
        p.k(localObject2, "appMsg");
        paramView1 = ((a)localObject1).sGV;
        p.j(paramView1, "playIcon");
        paramView1.setVisibility(8);
        paramView1 = ((a)localObject1).sGT;
        p.j(paramView1, "voicePlayIconContainer");
        paramView1.setVisibility(0);
        paramView1 = ((a)localObject1).sGU;
        p.j(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
          ((AnimationDrawable)paramView1).stop();
        }
        if (!p.h(String.valueOf(paramz.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.cEq())) {
          break label1365;
        }
        ((a)localObject1).sGU.setImageResource(d.d.dmz);
        paramView1 = ((a)localObject1).sGU;
        p.j(paramView1, "voicePlayIcon");
        if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
          break label1259;
        }
        paramView1 = ((a)localObject1).sGU;
        p.j(paramView1, "voicePlayIcon");
        paramView1 = paramView1.getDrawable();
        if (paramView1 != null) {
          break label1252;
        }
        paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(266900);
        throw paramz;
        i = d.d.spE;
        break;
      }
      label1252:
      ((AnimationDrawable)paramView1).start();
      label1259:
      paramView1 = ((pe)localObject2).RXH;
      if (Util.isNullOrNil(paramView1))
      {
        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        label1281:
        localObject2 = (kotlin.g.a.m)ad.a.c.sGn;
        paramView1 = (s)ad.a.d.sGo;
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        if (((a)localObject1).sCU.type == 5)
        {
          paramView1 = e.sKW;
          e.G(((a)localObject1).sCU.url, ((a)localObject1).sCU.type, "");
        }
        paramInt += 1;
        break;
        label1365:
        ((a)localObject1).sGU.setImageResource(d.d.dmy);
        break label1259;
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a((View)((a)localObject1).sGU, String.valueOf(paramz.field_msgId) + "_" + paramInt, ((pe)localObject2).fwr, paramView1, "", ((pe)localObject2).RTm);
        ((a)localObject1).sGU.setOnClickListener((View.OnClickListener)new ad.a.e((a)localObject1, paramz, (pe)localObject2));
        break label1281;
        label1471:
        if (!Util.isNullOrNil(((a)localObject1).sCU.lpK))
        {
          ((a)localObject1).sCR.setVisibility(0);
          paramView1 = ((a)localObject1).sHf.sAc;
          long l = paramz.field_msgId;
          localObject2 = ((a)localObject1).sCU;
          localObject3 = com.tencent.mm.aj.m.a(((a)localObject1).sCU);
          localObject4 = ((a)localObject1).sCR;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
          paramView1.a(l, paramInt, (v)localObject2, (String)localObject3, (ImageView)localObject4, i, i, false, (m.a)new ad.a.b((a)localObject1, paramz, paramInt), paramz.sHe + 1, 2.0F);
          if (((a)localObject1).sCU.type != 5) {
            break label1281;
          }
          paramView1 = ((a)localObject1).sGV;
          p.j(paramView1, "playIcon");
          paramView1.setVisibility(0);
          break label1281;
        }
        if ((((a)localObject1).sCU.type == 5) || (((a)localObject1).sCU.type == 6))
        {
          paramView1 = ((a)localObject1).sGV;
          p.j(paramView1, "playIcon");
          paramView1.setVisibility(0);
          ((a)localObject1).sCR.setVisibility(0);
          paramView1 = ((a)localObject1).sHf.sAc;
          localObject2 = String.valueOf(d.d.chatting_item_biz_play_icon_bg);
          localObject3 = ((a)localObject1).sCR;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
          paramView1.a((String)localObject2, (ImageView)localObject3, i, i, paramz.sHe + 1);
          break label1281;
        }
        ((a)localObject1).sGS.setVisibility(8);
        break label1281;
        if (paramInt > 0)
        {
          localObject2 = ((a)localObject1).rgA;
          p.j(localObject2, "content");
          paramView1.a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAA), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt));
        }
        for (;;)
        {
          paramView1 = ((a)localObject1).mrE;
          p.j(paramView1, "topLine");
          paramView1.setVisibility(8);
          break;
          localObject2 = ((a)localObject1).rgA;
          p.j(localObject2, "content");
          paramView1.a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAA), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw));
        }
        localObject3 = ((a)localObject1).rgA;
        p.j(localObject3, "content");
        paramView1.a(localObject3, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw));
        paramView1 = ((a)localObject1).mrE;
        p.j(paramView1, "topLine");
        ((kotlin.g.a.m)localObject2).invoke(paramView1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx));
      }
    }
    AppMethodBeat.o(266900);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(266901);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(266901);
      return;
    }
    AppMethodBeat.o(266901);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(263657);
      this.sCg = paramContext;
      this.context = localObject;
      this.sEm = View.inflate(this.context, d.f.stT, null);
      this.sCU = new v();
      this.mrE = this.sEm.findViewById(d.e.top_line);
      this.rgA = ((ViewGroup)this.sEm.findViewById(d.e.content_ll));
      this$1 = this.sEm.findViewById(d.e.stf);
      if (ad.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(263657);
        throw ad.this;
      }
      this.sGQ = ((MMNeat7extView)ad.this);
      this.sGR = ((TextView)this.sEm.findViewById(d.e.summary));
      this.sGS = this.sEm.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sEm.findViewById(d.e.cover_iv));
      this.sGT = this.sEm.findViewById(d.e.dum);
      this.sGU = ((ImageView)this.sEm.findViewById(d.e.srt));
      this.sGV = ((ImageView)this.sEm.findViewById(d.e.play_icon));
      this.sDk = this.sEm.findViewById(d.e.sta);
      this$1 = this.sEm.findViewById(d.e.srT);
      if (ad.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(263657);
        throw ad.this;
      }
      this.sDl = ((TextView)ad.this);
      this.sGW = this.sEm.findViewById(d.e.ssl);
      this.sGX = this.sEm.findViewById(d.e.ssk);
      this.sDY = ((TextView)this.sEm.findViewById(d.e.dRg));
      AppMethodBeat.o(263657);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ad.a parama, z paramz, pf parampf, pe parampe, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(265739);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramView = this.sGm;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(265739);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 4L, 1L, false);
        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localpe.RTk });
        Object localObject2 = new Intent();
        Object localObject3 = com.tencent.mm.aj.m.e(localpe.RTk, 183, 10000, 0);
        ((Intent)localObject2).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject2).putExtra("geta8key_scene", 56);
        ((Intent)localObject2).putExtra("geta8key_username", localpf.UserName);
        ((Intent)localObject2).putExtra("srcUsername", localpf.UserName);
        ((Intent)localObject2).putExtra("srcDisplayname", localpf.rWI);
        ((Intent)localObject2).putExtra("prePublishId", "rec_card");
        ((Intent)localObject2).putExtra("KPublisherId", "rec_card");
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramView.context, (String)localObject3, localpe.lpx, 183, 10000, (Intent)localObject2))) {
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
          paramView.sCg.szZ.a(localpf.UserName, l, i, 15, ((eqg)localObject2).Uaw, "", k, ((eqg)localObject2).UsF.RVm, ((eqg)localObject2).event, ((eqg)localObject2).UsF.RVi, localpe.RXJ, ((eqg)localObject2).style, localpe.RXK);
          paramView.sCg.b((z)localObject1, k);
          break;
          com.tencent.mm.by.c.b(paramView.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(260111);
        this.sGm.a(this.sGm.sCU, true);
        this.sGm.sHf.sAc.p(this.sAV.field_msgId, this.sEq);
        AppMethodBeat.o(260111);
      }
      
      public final void onStart() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(ad.a parama, z paramz, pe parampe) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(263505);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN((View)this.sGm.sGU);
        if (this.sAV.hwL() != null) {}
        try
        {
          paramView = Uri.parse(this.sCX.RTk);
          Util.getInt(paramView.getQueryParameter("idx"), 0);
          Util.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263505);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class b
    implements View.OnLongClickListener
  {
    b(ad paramad, z paramz) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(263008);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      this.sGl.sCg.szY = paramz;
      this.sGl.sCg.czS();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(263008);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "opType", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    f(ad paramad, amf paramamf, eqg parameqg, z paramz)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ad.a>
  {
    g(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
 * JD-Core Version:    0.7.0.1
 */