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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.s;
import d.g.b.p;
import d.g.b.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class m
  extends v
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  public View oiV;
  public LinearLayout oiW;
  private LinkedList<a> oiX;
  private final g<a> oiY;
  public View oji;
  public ImageView ojj;
  public TextView ojk;
  public View ojl;
  public WeImageView ojm;
  public f ojn;
  public c ojo;
  
  public m(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(208731);
    this.ohs = paramb;
    this.context = paramContext;
    this.oiX = new LinkedList();
    this.oiY = new g((d.g.a.a)new g(this));
    this.ojn = new f(this.context, this.ohs);
    this.ojo = new c(this.context, this.ohs);
    AppMethodBeat.o(208731);
  }
  
  public static boolean a(dmq paramdmq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(208730);
    Object localObject1 = m.c.ojw;
    d.g.a.b localb = (d.g.a.b)m.b.ojv;
    if (paramdmq != null) {}
    for (localObject1 = paramdmq.HTQ;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = localObject2;
        if (paramdmq != null)
        {
          dml localdml = paramdmq.HTQ;
          localObject1 = localObject2;
          if (localdml != null) {
            localObject1 = localdml.HTL;
          }
        }
        if ((localObject1 != null) && (paramdmq.HTS != null)) {
          break;
        }
      }
      AppMethodBeat.o(208730);
      return false;
    }
    if (bu.ht((List)paramdmq.HTS.Gal))
    {
      AppMethodBeat.o(208730);
      return false;
    }
    paramdmq = paramdmq.HTS.Gal;
    p.g(paramdmq, "wrapper.extraInfo.BizInfo");
    paramdmq = ((Iterable)paramdmq).iterator();
    while (paramdmq.hasNext())
    {
      localObject1 = (om)paramdmq.next();
      p.g(localObject1, "info");
      if (!((Boolean)localb.invoke(localObject1)).booleanValue())
      {
        AppMethodBeat.o(208730);
        return false;
      }
    }
    AppMethodBeat.o(208730);
    return true;
  }
  
  public final void a(w paramw, om paramom)
  {
    AppMethodBeat.i(208729);
    Object localObject1 = ((Iterable)this.oiX).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      locala = (a)((Iterator)localObject1).next();
      localObject2 = this.oiW;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(locala.oiZ);
      }
      this.oiY.cT(locala);
    }
    this.oiX.clear();
    if (paramom.Gcu.size() <= 1)
    {
      AppMethodBeat.o(208729);
      return;
    }
    a locala = (a)this.oiY.get();
    localObject1 = this.oiW;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).addView(locala.oiZ);
    }
    this.oiX.add(locala);
    localObject1 = paramom.Gcu.get(1);
    p.g(localObject1, "bizInfo.AppMsg[1]");
    Object localObject2 = (ol)localObject1;
    p.h(paramw, "info");
    p.h(paramom, "bizInfo");
    p.h(localObject2, "appMsg");
    localObject1 = ((ol)localObject2).Title;
    Object localObject3 = ((ol)localObject2).FYs;
    int i = ((ol)localObject2).hFR;
    String str1 = ((ol)localObject2).FYu;
    String str2 = ((ol)localObject2).FYv;
    locala.okR.aq((CharSequence)localObject1);
    locala.oiZ.setBackgroundResource(2131231256);
    locala.oiZ.setOnClickListener((View.OnClickListener)new m.a.a(locala, paramw, paramom, (ol)localObject2));
    if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil((String)localObject3))) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, i, 90, new Object[0]);
    }
    locala.oif.type = i;
    locala.oif.hGe = str1;
    locala.oif.hGv = str2;
    locala.oif.url = ((String)localObject3);
    localObject1 = locala.oiv;
    p.g(localObject1, "statLayout");
    ((View)localObject1).setVisibility(0);
    localObject3 = locala.oiw;
    p.g(localObject3, "friendReadTv");
    if (!bu.isNullOrNil(((ol)localObject2).usP)) {}
    for (localObject1 = (CharSequence)String.valueOf(((ol)localObject2).usP);; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = locala.okW;
      p.g(localObject1, "playIcon");
      ((ImageView)localObject1).setVisibility(8);
      locala.okW.setImageResource(2131231270);
      localObject1 = locala.okU;
      p.g(localObject1, "voicePlayIconContainer");
      ((View)localObject1).setVisibility(8);
      if (locala.oif.type != 7) {
        break label945;
      }
      locala.oic.setVisibility(8);
      p.h(paramw, "info");
      p.h(paramom, "appMsgBizInfo");
      p.h(localObject2, "appMsg");
      paramom = locala.okW;
      p.g(paramom, "playIcon");
      paramom.setVisibility(8);
      paramom = locala.okU;
      p.g(paramom, "voicePlayIconContainer");
      paramom.setVisibility(0);
      paramom = locala.okV;
      p.g(paramom, "voicePlayIcon");
      paramom = paramom.getDrawable();
      if (((paramom instanceof AnimationDrawable)) && (((AnimationDrawable)paramom).isRunning())) {
        ((AnimationDrawable)paramom).stop();
      }
      if (!p.i(String.valueOf(paramw.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
        break label843;
      }
      locala.okV.setImageResource(2131231272);
      paramom = locala.okV;
      p.g(paramom, "voicePlayIcon");
      if (!(paramom.getDrawable() instanceof AnimationDrawable)) {
        break label730;
      }
      paramom = locala.okV;
      p.g(paramom, "voicePlayIcon");
      paramom = paramom.getDrawable();
      if (paramom != null) {
        break;
      }
      paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AppMethodBeat.o(208729);
      throw paramw;
    }
    ((AnimationDrawable)paramom).start();
    label730:
    paramom = ((ol)localObject2).Gco;
    if (bu.isNullOrNil(paramom)) {
      ae.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
    }
    for (;;)
    {
      paramw = (d.g.a.m)m.a.c.ojt;
      paramom = (s)m.a.d.oju;
      localObject1 = locala.okQ;
      p.g(localObject1, "content");
      paramom.a(localObject1, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW));
      paramom = locala.iFF;
      p.g(paramom, "topLine");
      paramw.p(paramom, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oga));
      AppMethodBeat.o(208729);
      return;
      label843:
      locala.okV.setImageResource(2131231271);
      break;
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)locala.okV, String.valueOf(paramw.field_msgId) + "_1", ((ol)localObject2).Title, paramom, "", ((ol)localObject2).FYu);
      locala.okV.setOnClickListener((View.OnClickListener)new m.a.e(locala, paramw, (ol)localObject2));
      continue;
      label945:
      if (!bu.isNullOrNil(locala.oif.hGe))
      {
        locala.oic.setVisibility(0);
        paramom = locala.oll.ogi;
        long l = paramw.field_msgId;
        localObject1 = locala.oif;
        localObject2 = com.tencent.mm.ah.m.a(locala.oif);
        localObject3 = locala.oic;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
        paramom.a(l, 1, (com.tencent.mm.ah.v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (com.tencent.mm.pluginsdk.ui.applet.m.a)new m.a.b(locala, paramw), paramw.ole + 1, 2.0F);
        if (locala.oif.type == 5)
        {
          paramw = locala.okW;
          p.g(paramw, "playIcon");
          paramw.setVisibility(0);
        }
      }
      else if ((locala.oif.type == 5) || (locala.oif.type == 6))
      {
        paramom = locala.okW;
        p.g(paramom, "playIcon");
        paramom.setVisibility(0);
        locala.oic.setVisibility(0);
        paramom = locala.oll.ogi;
        localObject1 = locala.oic;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
        paramom.a("2131231674", (ImageView)localObject1, i, i, paramw.ole + 1);
      }
      else
      {
        locala.okT.setVisibility(8);
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208728);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208728);
      return;
    }
    AppMethodBeat.o(208728);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(208719);
      this.ohs = paramContext;
      this.context = localObject;
      this.oiZ = View.inflate(this.context, 2131496383, null);
      this.oif = new com.tencent.mm.ah.v();
      this.iFF = this.oiZ.findViewById(2131306012);
      this.okQ = this.oiZ.findViewById(2131298764);
      this$1 = this.oiZ.findViewById(2131305938);
      if (m.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208719);
        throw m.this;
      }
      this.okR = ((MMNeat7extView)m.this);
      this.okS = ((TextView)this.oiZ.findViewById(2131305546));
      this.okT = this.oiZ.findViewById(2131298814);
      this.oic = ((ImageView)this.oiZ.findViewById(2131298824));
      this.okU = this.oiZ.findViewById(2131297330);
      this.okV = ((ImageView)this.oiZ.findViewById(2131297370));
      this.okW = ((ImageView)this.oiZ.findViewById(2131303284));
      this.oiv = this.oiZ.findViewById(2131305184);
      this$1 = this.oiZ.findViewById(2131300305);
      if (m.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(208719);
        throw m.this;
      }
      this.oiw = ((TextView)m.this);
      this.okX = this.oiZ.findViewById(2131303255);
      this.okY = this.oiZ.findViewById(2131303254);
      this.okZ = ((TextView)this.oiZ.findViewById(2131303263));
      AppMethodBeat.o(208719);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(m.a parama, w paramw, om paramom, ol paramol) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208712);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = this.ojq;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208712);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 4L, 1L, false);
        ae.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localol.FYs });
        Intent localIntent = new Intent();
        Object localObject2 = com.tencent.mm.ah.m.d(localol.FYs, 169, 10000, 0);
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
            localIntent.putExtra(e.b.JoV, 169);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((m.a)localObject1).context, (String)localObject2, localol.hFR, 169, 10000, localIntent))) {
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
          com.tencent.mm.plugin.brandservice.ui.timeline.g.f(paramView);
          ((m.a)localObject1).ohs.ogr.a(localom.nIJ, l, i, 15, paramView.HDI, "", k, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, localol.Gcq, paramView.style, localol.Gcr);
          ((m.a)localObject1).ohs.b(localw, k);
          break;
          com.tencent.mm.br.d.b(((m.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements com.tencent.mm.pluginsdk.ui.applet.m.a
    {
      b(w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(208713);
        this.ojq.a(this.ojq.oif, true);
        this.ojq.oll.ogi.p(this.oiy.field_msgId, this.oje);
        AppMethodBeat.o(208713);
      }
      
      public final void onStart() {}
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(m.a parama, w paramw, ol paramol) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.ojq.okV);
        if (this.oiy.ftk() != null) {}
        try
        {
          paramView = Uri.parse(this.oii.FYs);
          bu.getInt(paramView.getQueryParameter("idx"), 0);
          bu.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208718);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(m paramm, w paramw, om paramom, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208724);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = this.oiy.ftk();
      localObject1 = (ol)this.ojr.Gcu.get(0);
      Object localObject2 = ((ol)localObject1).FYs;
      int j = 0;
      int i = 0;
      l2 = 0L;
      l1 = l2;
      if (!bu.isNullOrNil((String)localObject2)) {
        i = j;
      }
      try
      {
        localObject2 = Uri.parse((String)localObject2);
        i = j;
        j = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        i = j;
        l1 = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = l2;
        }
      }
      this.ojp.ohs.ogr.a(this.ojr.nIJ, l1, i, 16, paramView.HDI, "", 0, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, ((ol)localObject1).Gcq, paramView.style, ((ol)localObject1).Gcr);
      ((d)new d(this.ojp.context, this.oiy, this.ojp.ohs, this.ojr, this.ojx).hh((View)this.ojp.ojm)).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208724);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(m paramm, w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208725);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = this.oiy.field_talker;
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.oiy.field_talker);
      if ((localObject1 != null) && (!((an)localObject1).ads()))
      {
        localObject1 = this.ojp;
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Scene", 174);
        ((Intent)localObject2).putExtra("force_get_contact", true);
        ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.br.d.b(((m)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        localObject2 = this.oiy.ftk();
        ((m)localObject1).ohs.ogr.a(paramView, 0L, 0, 13, ((dmq)localObject2).HDI, "", 0, ((dmq)localObject2).HTS.Gau, ((dmq)localObject2).dmp, ((dmq)localObject2).HTS.Gaq, 0, ((dmq)localObject2).style, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208725);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Chat_User", paramView);
        ((Intent)localObject1).putExtra("finish_direct", true);
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 90);
        ((Intent)localObject1).putExtra("specific_chat_from_scene", 2);
        ((Intent)localObject1).putExtra("preChatTYPE", 11);
        com.tencent.mm.br.d.f(this.ojp.context, ".ui.chatting.ChattingUI", (Intent)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.b.c.och;
        com.tencent.mm.plugin.brandservice.b.c.s(3, paramView, "");
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  public static final class f
    implements View.OnLongClickListener
  {
    public f(m paramm, w paramw, om paramom) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(208726);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      this.ojp.ohs.ogf = this.oiy;
      paramView = this.oiy.ftk();
      int j;
      long l1;
      int i;
      if (paramView != null)
      {
        localObject = (ol)this.ojr.Gcu.get(0);
        j = 0;
        l1 = 0L;
        i = j;
      }
      try
      {
        Uri localUri = Uri.parse(((ol)localObject).FYs);
        i = j;
        j = bu.getInt(localUri.getQueryParameter("idx"), 0);
        i = j;
        long l2 = bu.getLong(localUri.getQueryParameter("mid"), 0L);
        l1 = l2;
        i = j;
      }
      catch (Exception localException)
      {
        label131:
        break label131;
      }
      this.ojp.ohs.ogr.a(this.ojr.nIJ, l1, i, 15, paramView.HDI, "", 0, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, ((ol)localObject).Gcq, paramView.style, "");
      this.ojp.ohs.bPg();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(208726);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<m.a>
  {
    g(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.m
 * JD-Core Version:    0.7.0.1
 */