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
import com.tencent.mm.ai.x;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class m
  extends u
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  public c odA;
  public View odh;
  public LinearLayout odi;
  private LinkedList<a> odj;
  private final g<a> odk;
  public View odu;
  public ImageView odv;
  public TextView odw;
  public View odx;
  public WeImageView ody;
  public f odz;
  
  public m(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(209757);
    this.obC = paramb;
    this.context = paramContext;
    this.odj = new LinkedList();
    this.odk = new g((d.g.a.a)new g(this));
    this.odz = new f(this.context, this.obC);
    this.odA = new c(this.context, this.obC);
    AppMethodBeat.o(209757);
  }
  
  public static boolean a(dlt paramdlt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(209756);
    Object localObject1 = m.c.odI;
    d.g.a.b localb = (d.g.a.b)m.b.odH;
    if (paramdlt != null) {}
    for (localObject1 = paramdlt.HAd;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = localObject2;
        if (paramdlt != null)
        {
          dlo localdlo = paramdlt.HAd;
          localObject1 = localObject2;
          if (localdlo != null) {
            localObject1 = localdlo.HzY;
          }
        }
        if ((localObject1 != null) && (paramdlt.HAf != null)) {
          break;
        }
      }
      AppMethodBeat.o(209756);
      return false;
    }
    if (bt.hj((List)paramdlt.HAf.FHP))
    {
      AppMethodBeat.o(209756);
      return false;
    }
    paramdlt = paramdlt.HAf.FHP;
    p.g(paramdlt, "wrapper.extraInfo.BizInfo");
    paramdlt = ((Iterable)paramdlt).iterator();
    while (paramdlt.hasNext())
    {
      localObject1 = (ok)paramdlt.next();
      p.g(localObject1, "info");
      if (!((Boolean)localb.invoke(localObject1)).booleanValue())
      {
        AppMethodBeat.o(209756);
        return false;
      }
    }
    AppMethodBeat.o(209756);
    return true;
  }
  
  public final void a(com.tencent.mm.storage.w paramw, ok paramok)
  {
    AppMethodBeat.i(209755);
    Object localObject1 = ((Iterable)this.odj).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      locala = (a)((Iterator)localObject1).next();
      localObject2 = this.odi;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(locala.odl);
      }
      this.odk.cS(locala);
    }
    this.odj.clear();
    if (paramok.FJV.size() <= 1)
    {
      AppMethodBeat.o(209755);
      return;
    }
    a locala = (a)this.odk.get();
    localObject1 = this.odi;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).addView(locala.odl);
    }
    this.odj.add(locala);
    localObject1 = paramok.FJV.get(1);
    p.g(localObject1, "bizInfo.AppMsg[1]");
    Object localObject2 = (oj)localObject1;
    p.h(paramw, "info");
    p.h(paramok, "bizInfo");
    p.h(localObject2, "appMsg");
    localObject1 = ((oj)localObject2).Title;
    Object localObject3 = ((oj)localObject2).FFW;
    int i = ((oj)localObject2).hCZ;
    String str1 = ((oj)localObject2).FFY;
    String str2 = ((oj)localObject2).FFZ;
    locala.oeR.ar((CharSequence)localObject1);
    locala.odl.setBackgroundResource(2131231256);
    locala.odl.setOnClickListener((View.OnClickListener)new m.a.a(locala, paramw, paramok, (oj)localObject2));
    if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!bt.isNullOrNil((String)localObject3))) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, i, 90, new Object[0]);
    }
    locala.ocq.type = i;
    locala.ocq.hDm = str1;
    locala.ocq.hDD = str2;
    locala.ocq.url = ((String)localObject3);
    localObject1 = locala.ocG;
    p.g(localObject1, "statLayout");
    ((View)localObject1).setVisibility(0);
    localObject3 = locala.ocH;
    p.g(localObject3, "friendReadTv");
    if (!bt.isNullOrNil(((oj)localObject2).uhr)) {}
    for (localObject1 = (CharSequence)String.valueOf(((oj)localObject2).uhr);; localObject1 = (CharSequence)"")
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = locala.oeW;
      p.g(localObject1, "playIcon");
      ((ImageView)localObject1).setVisibility(8);
      locala.oeW.setImageResource(2131231270);
      localObject1 = locala.oeU;
      p.g(localObject1, "voicePlayIconContainer");
      ((View)localObject1).setVisibility(8);
      if (locala.ocq.type != 7) {
        break label945;
      }
      locala.ocn.setVisibility(8);
      p.h(paramw, "info");
      p.h(paramok, "appMsgBizInfo");
      p.h(localObject2, "appMsg");
      paramok = locala.oeW;
      p.g(paramok, "playIcon");
      paramok.setVisibility(8);
      paramok = locala.oeU;
      p.g(paramok, "voicePlayIconContainer");
      paramok.setVisibility(0);
      paramok = locala.oeV;
      p.g(paramok, "voicePlayIcon");
      paramok = paramok.getDrawable();
      if (((paramok instanceof AnimationDrawable)) && (((AnimationDrawable)paramok).isRunning())) {
        ((AnimationDrawable)paramok).stop();
      }
      if (!p.i(String.valueOf(paramw.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.bSj())) {
        break label843;
      }
      locala.oeV.setImageResource(2131231272);
      paramok = locala.oeV;
      p.g(paramok, "voicePlayIcon");
      if (!(paramok.getDrawable() instanceof AnimationDrawable)) {
        break label730;
      }
      paramok = locala.oeV;
      p.g(paramok, "voicePlayIcon");
      paramok = paramok.getDrawable();
      if (paramok != null) {
        break;
      }
      paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AppMethodBeat.o(209755);
      throw paramw;
    }
    ((AnimationDrawable)paramok).start();
    label730:
    paramok = ((oj)localObject2).FJP;
    if (bt.isNullOrNil(paramok)) {
      ad.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
    }
    for (;;)
    {
      paramw = (d.g.a.m)m.a.c.odF;
      paramok = (s)m.a.d.odG;
      localObject1 = locala.oeQ;
      p.g(localObject1, "content");
      paramok.a(localObject1, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oaj), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oag));
      paramok = locala.iCM;
      p.g(paramok, "topLine");
      paramw.p(paramok, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oak));
      AppMethodBeat.o(209755);
      return;
      label843:
      locala.oeV.setImageResource(2131231271);
      break;
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)locala.oeV, String.valueOf(paramw.field_msgId) + "_1", ((oj)localObject2).Title, paramok, "", ((oj)localObject2).FFY);
      locala.oeV.setOnClickListener((View.OnClickListener)new m.a.e(locala, paramw, (oj)localObject2));
      continue;
      label945:
      if (!bt.isNullOrNil(locala.ocq.hDm))
      {
        locala.ocn.setVisibility(0);
        paramok = locala.ofm.oas;
        long l = paramw.field_msgId;
        localObject1 = locala.ocq;
        localObject2 = com.tencent.mm.ai.m.a(locala.ocq);
        localObject3 = locala.ocn;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
        paramok.a(l, 1, (com.tencent.mm.ai.v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (com.tencent.mm.pluginsdk.ui.applet.m.a)new m.a.b(locala, paramw), paramw.ofe + 1, 2.0F);
        if (locala.ocq.type == 5)
        {
          paramw = locala.oeW;
          p.g(paramw, "playIcon");
          paramw.setVisibility(0);
        }
      }
      else if ((locala.ocq.type == 5) || (locala.ocq.type == 6))
      {
        paramok = locala.oeW;
        p.g(paramok, "playIcon");
        paramok.setVisibility(0);
        locala.ocn.setVisibility(0);
        paramok = locala.ofm.oas;
        localObject1 = locala.ocn;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
        paramok.a("2131231674", (ImageView)localObject1, i, i, paramw.ofe + 1);
      }
      else
      {
        locala.oeT.setVisibility(8);
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209754);
    View localView = this.odh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(209754);
      return;
    }
    AppMethodBeat.o(209754);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends w
  {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
    final com.tencent.mm.ai.v ocq;
    final View odl;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(209745);
      this.obC = paramContext;
      this.context = localObject;
      this.odl = View.inflate(this.context, 2131496383, null);
      this.ocq = new com.tencent.mm.ai.v();
      this.iCM = this.odl.findViewById(2131306012);
      this.oeQ = this.odl.findViewById(2131298764);
      this$1 = this.odl.findViewById(2131305938);
      if (m.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(209745);
        throw m.this;
      }
      this.oeR = ((MMNeat7extView)m.this);
      this.oeS = ((TextView)this.odl.findViewById(2131305546));
      this.oeT = this.odl.findViewById(2131298814);
      this.ocn = ((ImageView)this.odl.findViewById(2131298824));
      this.oeU = this.odl.findViewById(2131297330);
      this.oeV = ((ImageView)this.odl.findViewById(2131297370));
      this.oeW = ((ImageView)this.odl.findViewById(2131303284));
      this.ocG = this.odl.findViewById(2131305184);
      this$1 = this.odl.findViewById(2131300305);
      if (m.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(209745);
        throw m.this;
      }
      this.ocH = ((TextView)m.this);
      this.oeX = this.odl.findViewById(2131303255);
      this.oeY = this.odl.findViewById(2131303254);
      this.oeZ = ((TextView)this.odl.findViewById(2131303263));
      AppMethodBeat.o(209745);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(m.a parama, com.tencent.mm.storage.w paramw, ok paramok, oj paramoj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209738);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = this.odC;
        com.tencent.mm.storage.w localw = this.ocJ;
        ok localok = this.odD;
        oj localoj = this.oct;
        int k = this.odE;
        p.h(localw, "info");
        p.h(localok, "appMsgBizInfo");
        if ((localoj != null) && (localw.fpl() != null))
        {
          localObject2 = localw.fpl();
          if (localObject2 == null) {
            p.gfZ();
          }
          if (((dlo)localObject2).HzY != null) {}
        }
        else
        {
          ad.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209738);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 4L, 1L, false);
        ad.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localoj.FFW });
        Intent localIntent = new Intent();
        Object localObject2 = com.tencent.mm.ai.m.d(localoj.FFW, 169, 10000, 0);
        localIntent.putExtra("rawUrl", (String)localObject2);
        localIntent.putExtra("geta8key_scene", 56);
        localIntent.putExtra("geta8key_username", localok.nDo);
        localIntent.putExtra("srcUsername", localok.nDo);
        localIntent.putExtra("srcDisplayname", localok.nEt);
        localIntent.putExtra("prePublishId", "rec_card");
        localIntent.putExtra("KPublisherId", "rec_card");
        int i;
        int j;
        if (localoj.hCZ == 5)
        {
          Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
          p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
          if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).bNg())
          {
            localIntent.putExtra(e.b.IUn, 169);
            localIntent.putExtra(e.b.IUo, 10000);
            localIntent.putExtra("biz_video_session_id", y.getSessionId());
            localObject3 = new x();
            ((x)localObject3).hDf = localIntent.getStringExtra("KPublisherId");
            ((x)localObject3).doK = localok.nDo;
            ((x)localObject3).hDe = localok.nEt;
            ((x)localObject3).hDg.url = ((String)localObject2);
            ((x)localObject3).hDg.title = localoj.Title;
            ((x)localObject3).hDg.hDo = localoj.FFU;
            ((x)localObject3).hDg.hDm = localoj.FFY;
            ((x)localObject3).hDg.type = localoj.hCZ;
            ((x)localObject3).hDg.time = localoj.CreateTime;
            ((x)localObject3).hDg.hDq = localoj.FGk;
            ((x)localObject3).hDg.videoWidth = localoj.FGi;
            ((x)localObject3).hDg.videoHeight = localoj.FGj;
            ((x)localObject3).hDg.hzm = localoj.FGh;
            ((x)localObject3).t(localIntent);
            ad.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((m.a)localObject1).context, (String)localObject2, localoj.hCZ, 169, 10000, localIntent))) {
          ad.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = localw.fpm();
          if (paramView != null)
          {
            j = 0;
            i = j;
          }
          try
          {
            localObject2 = Uri.parse((String)localObject2);
            i = j;
            j = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            i = j;
            l = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l = 0L;
            }
          }
          ((m.a)localObject1).obC.oaB.a(localok.nDo, l, i, 15, paramView.Hki, "", k, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, localoj.FJR, paramView.style, localoj.FJS);
          ((m.a)localObject1).obC.b(localw, k);
          break;
          com.tencent.mm.bs.d.b(((m.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements com.tencent.mm.pluginsdk.ui.applet.m.a
    {
      b(com.tencent.mm.storage.w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(209739);
        this.odC.a(this.odC.ocq, true);
        this.odC.ofm.oas.p(this.ocJ.field_msgId, this.odq);
        AppMethodBeat.o(209739);
      }
      
      public final void onStart() {}
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(m.a parama, com.tencent.mm.storage.w paramw, oj paramoj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209744);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.odC.oeV);
        if (this.ocJ.fpm() != null) {}
        try
        {
          paramView = Uri.parse(this.oct.FFW);
          bt.getInt(paramView.getQueryParameter("idx"), 0);
          bt.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209744);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(m paramm, com.tencent.mm.storage.w paramw, ok paramok, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(209750);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.ocJ.fpm();
      this.odB.obC.oaB.a(this.odD.nDo, 0L, 0, 16, paramView.Hki, "", 0, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, 0, paramView.style, "");
      ((d)new d(this.odB.context, this.ocJ, this.odB.obC, this.odD, this.odJ).hc((View)this.odB.ody)).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209750);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(m paramm, com.tencent.mm.storage.w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(209751);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      paramView = this.ocJ.field_talker;
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.ocJ.field_talker);
      if ((localObject1 != null) && (!((am)localObject1).adh()))
      {
        localObject1 = this.odB;
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramView);
        ((Intent)localObject2).putExtra("Contact_Scene", 174);
        ((Intent)localObject2).putExtra("force_get_contact", true);
        ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.bs.d.b(((m)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
        localObject2 = this.ocJ.fpm();
        ((m)localObject1).obC.oaB.a(paramView, 0L, 0, 13, ((dlt)localObject2).Hki, "", 0, ((dlt)localObject2).HAf.FHY, ((dlt)localObject2).dln, ((dlt)localObject2).HAf.FHU, 0, ((dlt)localObject2).style, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209751);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Chat_User", paramView);
        ((Intent)localObject1).putExtra("finish_direct", true);
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 90);
        ((Intent)localObject1).putExtra("specific_chat_from_scene", 2);
        ((Intent)localObject1).putExtra("preChatTYPE", 11);
        com.tencent.mm.bs.d.f(this.odB.context, ".ui.chatting.ChattingUI", (Intent)localObject1);
        localObject1 = com.tencent.mm.plugin.brandservice.b.c.nWy;
        com.tencent.mm.plugin.brandservice.b.c.s(3, paramView, "");
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  public static final class f
    implements View.OnLongClickListener
  {
    public f(m paramm, com.tencent.mm.storage.w paramw, ok paramok) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(209752);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      this.odB.obC.oap = this.ocJ;
      paramView = this.ocJ.fpm();
      int j;
      long l1;
      int i;
      if (paramView != null)
      {
        localObject = (oj)this.odD.FJV.get(0);
        j = 0;
        l1 = 0L;
        i = j;
      }
      try
      {
        Uri localUri = Uri.parse(((oj)localObject).FFW);
        i = j;
        j = bt.getInt(localUri.getQueryParameter("idx"), 0);
        i = j;
        long l2 = bt.getLong(localUri.getQueryParameter("mid"), 0L);
        l1 = l2;
        i = j;
      }
      catch (Exception localException)
      {
        label131:
        break label131;
      }
      this.odB.obC.oaB.a(this.odD.nDo, l1, i, 15, paramView.Hki, "", 0, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, ((oj)localObject).FJR, paramView.style, "");
      this.odB.obC.bOj();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(209752);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "invoke"})
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