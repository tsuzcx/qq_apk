package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.a.s;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "item", "Landroid/view/View;", "jumpMore", "Landroid/widget/RelativeLayout;", "longClick", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "time", "Landroid/widget/TextView;", "txtJumpLink", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshCommonSlot", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class u
  extends v
{
  public final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  public View oiV;
  public LinearLayout oiW;
  private LinkedList<a> oiX;
  private final g<a> oiY;
  public RelativeLayout okJ;
  public RelativeLayout okK;
  public TextView okL;
  public TextView oki;
  int okk;
  
  public u(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(208800);
    this.ohs = paramb;
    this.context = paramContext;
    this.oiX = new LinkedList();
    this.oiY = new g((d.g.a.a)new f(this));
    AppMethodBeat.o(208800);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208798);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208798);
      return;
    }
    AppMethodBeat.o(208798);
  }
  
  public final void i(w paramw)
  {
    AppMethodBeat.i(208799);
    Object localObject1 = ((Iterable)this.oiX).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      localObject3 = this.oiW;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).removeView(((a)localObject2).oiZ);
      }
      this.oiY.cT(localObject2);
    }
    this.oiX.clear();
    localObject1 = paramw.ftk().HTS.Gal;
    p.g(localObject1, "info.tlRecCardWrapper.extraInfo.BizInfo");
    localObject1 = (Iterable)localObject1;
    int i = 0;
    Object localObject2 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      Object localObject5 = (om)localObject1;
      localObject3 = (a)this.oiY.get();
      localObject1 = this.oiW;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).addView(((a)localObject3).oiZ);
      }
      this.oiX.add(localObject3);
      p.g(localObject5, "bizInfo");
      localObject1 = ((om)localObject5).Gcu.get(0);
      p.g(localObject1, "bizInfo.AppMsg[0]");
      Object localObject4 = (ol)localObject1;
      p.h(paramw, "info");
      p.h(localObject5, "bizInfo");
      p.h(localObject4, "appMsg");
      Object localObject7 = ((ol)localObject4).Title;
      localObject1 = ((ol)localObject4).FYs;
      int m = ((ol)localObject4).hFR;
      Object localObject6 = ((ol)localObject4).FYu;
      String str = ((ol)localObject4).FYv;
      ((a)localObject3).okR.aq((CharSequence)localObject7);
      localObject7 = ((a)localObject3).oiZ;
      int k;
      if ((i == 0) && (i <= 0))
      {
        k = 2131231262;
        ((View)localObject7).setBackgroundResource(k);
        ((a)localObject3).oiZ.setOnClickListener((View.OnClickListener)new u.a.a((a)localObject3, paramw, (om)localObject5, (ol)localObject4, i));
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil((String)localObject1))) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject1, m, 90, new Object[0]);
        }
        ((a)localObject3).oif.type = m;
        ((a)localObject3).oif.hGe = ((String)localObject6);
        ((a)localObject3).oif.hGv = str;
        ((a)localObject3).oif.url = ((String)localObject1);
        localObject1 = ((a)localObject3).oiv;
        p.g(localObject1, "statLayout");
        ((View)localObject1).setVisibility(0);
        localObject6 = ((a)localObject3).oiw;
        p.g(localObject6, "friendReadTv");
        if (bu.isNullOrNil(((ol)localObject4).usP)) {
          break label828;
        }
      }
      label828:
      for (localObject1 = (CharSequence)String.valueOf(((ol)localObject4).usP);; localObject1 = (CharSequence)"")
      {
        ((TextView)localObject6).setText((CharSequence)localObject1);
        localObject1 = ((a)localObject3).okW;
        p.g(localObject1, "playIcon");
        ((ImageView)localObject1).setVisibility(8);
        ((a)localObject3).okW.setImageResource(2131231270);
        localObject1 = ((a)localObject3).okU;
        p.g(localObject1, "voicePlayIconContainer");
        ((View)localObject1).setVisibility(8);
        if (((a)localObject3).oif.type != 7) {
          break label1024;
        }
        ((a)localObject3).oic.setVisibility(8);
        p.h(paramw, "info");
        p.h(localObject5, "appMsgBizInfo");
        p.h(localObject4, "appMsg");
        localObject1 = ((a)localObject3).okW;
        p.g(localObject1, "playIcon");
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = ((a)localObject3).okU;
        p.g(localObject1, "voicePlayIconContainer");
        ((View)localObject1).setVisibility(0);
        localObject1 = ((a)localObject3).okV;
        p.g(localObject1, "voicePlayIcon");
        localObject1 = ((ImageView)localObject1).getDrawable();
        if (((localObject1 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject1).isRunning())) {
          ((AnimationDrawable)localObject1).stop();
        }
        if (!p.i(String.valueOf(paramw.field_msgId) + "_" + i, com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
          break label917;
        }
        ((a)localObject3).okV.setImageResource(2131231272);
        localObject1 = ((a)localObject3).okV;
        p.g(localObject1, "voicePlayIcon");
        if (!(((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
          break label847;
        }
        localObject1 = ((a)localObject3).okV;
        p.g(localObject1, "voicePlayIcon");
        localObject1 = ((ImageView)localObject1).getDrawable();
        if (localObject1 != null) {
          break label839;
        }
        paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(208799);
        throw paramw;
        k = 2131231256;
        break;
      }
      label839:
      ((AnimationDrawable)localObject1).start();
      label847:
      localObject1 = ((ol)localObject4).Gco;
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        label871:
        localObject4 = (d.g.a.m)u.a.c.okO;
        localObject1 = (s)u.a.d.okP;
        switch (i)
        {
        }
      }
      for (;;)
      {
        i = j;
        break;
        label917:
        ((a)localObject3).okV.setImageResource(2131231271);
        break label847;
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject3).okV, String.valueOf(paramw.field_msgId) + "_" + i, ((ol)localObject4).Title, (String)localObject1, "", ((ol)localObject4).FYu);
        ((a)localObject3).okV.setOnClickListener((View.OnClickListener)new u.a.e((a)localObject3, paramw, (ol)localObject4));
        break label871;
        label1024:
        if (!bu.isNullOrNil(((a)localObject3).oif.hGe))
        {
          ((a)localObject3).oic.setVisibility(0);
          localObject1 = ((a)localObject3).oll.ogi;
          long l = paramw.field_msgId;
          localObject4 = ((a)localObject3).oif;
          localObject5 = com.tencent.mm.ah.m.a(((a)localObject3).oif);
          localObject6 = ((a)localObject3).oic;
          k = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject1).a(l, i, (com.tencent.mm.ah.v)localObject4, (String)localObject5, (ImageView)localObject6, k, k, false, (m.a)new u.a.b((a)localObject3, paramw, i), paramw.ole + 1, 2.0F);
          if (((a)localObject3).oif.type != 5) {
            break label871;
          }
          localObject1 = ((a)localObject3).okW;
          p.g(localObject1, "playIcon");
          ((ImageView)localObject1).setVisibility(0);
          break label871;
        }
        if ((((a)localObject3).oif.type == 5) || (((a)localObject3).oif.type == 6))
        {
          localObject1 = ((a)localObject3).okW;
          p.g(localObject1, "playIcon");
          ((ImageView)localObject1).setVisibility(0);
          ((a)localObject3).oic.setVisibility(0);
          localObject1 = ((a)localObject3).oll.ogi;
          localObject4 = ((a)localObject3).oic;
          k = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject1).a("2131231674", (ImageView)localObject4, k, k, paramw.ole + 1);
          break label871;
        }
        ((a)localObject3).okT.setVisibility(8);
        break label871;
        if (i > 0)
        {
          localObject4 = ((a)localObject3).okQ;
          p.g(localObject4, "content");
          ((s)localObject1).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ogd), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW));
        }
        for (;;)
        {
          localObject1 = ((a)localObject3).iFF;
          p.g(localObject1, "topLine");
          ((View)localObject1).setVisibility(8);
          i = j;
          break;
          localObject4 = ((a)localObject3).okQ;
          p.g(localObject4, "content");
          ((s)localObject1).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ));
        }
        localObject5 = ((a)localObject3).okQ;
        p.g(localObject5, "content");
        ((s)localObject1).a(localObject5, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ));
        localObject1 = ((a)localObject3).iFF;
        p.g(localObject1, "topLine");
        ((d.g.a.m)localObject4).p(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oga));
      }
    }
    AppMethodBeat.o(208799);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends x
  {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
    final View oiZ;
    final com.tencent.mm.ah.v oif;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(208792);
      this.ohs = paramContext;
      this.context = localObject;
      this.oiZ = View.inflate(this.context, 2131496383, null);
      this.oif = new com.tencent.mm.ah.v();
      this.iFF = this.oiZ.findViewById(2131306012);
      this.okQ = this.oiZ.findViewById(2131298764);
      this$1 = this.oiZ.findViewById(2131305938);
      if (u.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208792);
        throw u.this;
      }
      this.okR = ((MMNeat7extView)u.this);
      this.okS = ((TextView)this.oiZ.findViewById(2131305546));
      this.okT = this.oiZ.findViewById(2131298814);
      this.oic = ((ImageView)this.oiZ.findViewById(2131298824));
      this.okU = this.oiZ.findViewById(2131297330);
      this.okV = ((ImageView)this.oiZ.findViewById(2131297370));
      this.okW = ((ImageView)this.oiZ.findViewById(2131303284));
      this.oiv = this.oiZ.findViewById(2131305184);
      this$1 = this.oiZ.findViewById(2131300305);
      if (u.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(208792);
        throw u.this;
      }
      this.oiw = ((TextView)u.this);
      this.okX = this.oiZ.findViewById(2131303255);
      this.okY = this.oiZ.findViewById(2131303254);
      this.okZ = ((TextView)this.oiZ.findViewById(2131303263));
      AppMethodBeat.o(208792);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(u.a parama, w paramw, om paramom, ol paramol, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208785);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = this.okN;
        w localw = this.oiy;
        om localom = this.ojr;
        ol localol = this.oii;
        int k = this.ojs;
        p.h(localw, "info");
        p.h(localom, "appMsgBizInfo");
        if ((localol != null) && (localw.ftj() != null))
        {
          localObject2 = localw.ftj();
          if (localObject2 == null) {
            p.gkB();
          }
          if (((dml)localObject2).HTL != null) {}
        }
        else
        {
          ae.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208785);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 4L, 1L, false);
        ae.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localol.FYs });
        Intent localIntent = new Intent();
        Object localObject2 = com.tencent.mm.ah.m.d(localol.FYs, 183, 10000, 0);
        localIntent.putExtra("rawUrl", (String)localObject2);
        localIntent.putExtra("geta8key_scene", 56);
        localIntent.putExtra("geta8key_username", localom.nIJ);
        localIntent.putExtra("srcUsername", localom.nIJ);
        localIntent.putExtra("srcDisplayname", localom.nJO);
        localIntent.putExtra("prePublishId", "rec_card");
        localIntent.putExtra("KPublisherId", "rec_card");
        int i;
        int j;
        if (localol.hFR == 5)
        {
          Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
          p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
          if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).bOe())
          {
            localIntent.putExtra(e.b.JoV, 183);
            localIntent.putExtra(e.b.JoW, 10000);
            localIntent.putExtra("biz_video_session_id", y.getSessionId());
            localObject3 = new com.tencent.mm.ah.x();
            ((com.tencent.mm.ah.x)localObject3).hFX = localIntent.getStringExtra("KPublisherId");
            ((com.tencent.mm.ah.x)localObject3).dpP = localom.nIJ;
            ((com.tencent.mm.ah.x)localObject3).hFW = localom.nJO;
            ((com.tencent.mm.ah.x)localObject3).hFY.url = ((String)localObject2);
            ((com.tencent.mm.ah.x)localObject3).hFY.title = localol.Title;
            ((com.tencent.mm.ah.x)localObject3).hFY.hGg = localol.FYq;
            ((com.tencent.mm.ah.x)localObject3).hFY.hGe = localol.FYu;
            ((com.tencent.mm.ah.x)localObject3).hFY.type = localol.hFR;
            ((com.tencent.mm.ah.x)localObject3).hFY.time = localol.CreateTime;
            ((com.tencent.mm.ah.x)localObject3).hFY.hGi = localol.FYG;
            ((com.tencent.mm.ah.x)localObject3).hFY.videoWidth = localol.FYE;
            ((com.tencent.mm.ah.x)localObject3).hFY.videoHeight = localol.FYF;
            ((com.tencent.mm.ah.x)localObject3).hFY.hCa = localol.FYD;
            ((com.tencent.mm.ah.x)localObject3).t(localIntent);
            ae.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((u.a)localObject1).context, (String)localObject2, localol.hFR, 183, 10000, localIntent))) {
          ae.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = localw.ftk();
          if (paramView != null)
          {
            j = 0;
            i = j;
          }
          try
          {
            localObject2 = Uri.parse((String)localObject2);
            i = j;
            j = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            i = j;
            l = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l = 0L;
            }
          }
          ((u.a)localObject1).ohs.ogr.a(localom.nIJ, l, i, 15, paramView.HDI, "", k, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, localol.Gcq, paramView.style, localol.Gcr);
          ((u.a)localObject1).ohs.b(localw, k);
          break;
          d.b(((u.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(208786);
        this.okN.a(this.okN.oif, true);
        this.okN.oll.ogi.p(this.oiy.field_msgId, this.oje);
        AppMethodBeat.o(208786);
      }
      
      public final void onStart() {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(u.a parama, w paramw, ol paramol) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.okN.okV);
        if (this.oiy.ftk() != null) {}
        try
        {
          paramView = Uri.parse(this.oii.FYs);
          bu.getInt(paramView.getQueryParameter("idx"), 0);
          bu.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208791);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  public static final class b
    implements View.OnLongClickListener
  {
    public b(u paramu, w paramw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(208793);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      this.okM.ohs.ogf = this.oiy;
      this.okM.ohs.bPg();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(208793);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "opType", "", "invoke"})
  public static final class e
    extends q
    implements d.g.a.b<Integer, z>
  {
    public e(u paramu, aiq paramaiq, dmq paramdmq)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<u.a>
  {
    f(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.u
 * JD-Core Version:    0.7.0.1
 */