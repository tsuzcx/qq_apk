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
import com.tencent.mm.ai.x;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.a.j;
import d.g.a.s;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class r
  extends u
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  c odA;
  View odh;
  private LinearLayout odi;
  private LinkedList<a> odj;
  private final g<a> odk;
  private View odu;
  private View odx;
  WeImageView ody;
  f odz;
  private TextView oer;
  private TextView oes;
  int oet;
  private LinearLayout vJF;
  
  public r(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(209805);
    this.obC = paramb;
    this.context = paramContext;
    this.odj = new LinkedList();
    this.odk = new g((d.g.a.a)new f(this));
    this.odz = new f(this.context, this.obC);
    this.odA = new c(this.context, this.obC);
    this.oet = -1;
    AppMethodBeat.o(209805);
  }
  
  public final void a(final com.tencent.mm.storage.w paramw, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(209803);
    p.h(paramw, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.odh == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(2131308463)).inflate();
      this.odx = paramView2.findViewById(2131298374);
      this.ody = ((WeImageView)paramView2.findViewById(2131298373));
      this.odi = ((LinearLayout)paramView2.findViewById(2131307153));
      this.odu = paramView2.findViewById(2131297276);
      this.oer = ((TextView)paramView2.findViewById(2131302860));
      this.oes = ((TextView)paramView2.findViewById(2131308342));
      this.vJF = ((LinearLayout)paramView2.findViewById(2131306031));
      this.odh = paramView2;
    }
    this.oet = -1;
    paramView2 = paramw.fpm().HAf.FHP;
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
        j.gfB();
      }
      if (((ok)localObject1).FuX != 0) {
        break label2071;
      }
      int k = j + 1;
      if (this.oet == -1)
      {
        j = i;
        label260:
        this.oet = j;
        j = k;
      }
    }
    label1556:
    label2071:
    for (;;)
    {
      i += 1;
      break;
      j = this.oet;
      break label260;
      if ((j <= 0) || (this.oet == -1))
      {
        AppMethodBeat.o(209803);
        return;
      }
      paramView1.setVisibility(0);
      paramView1 = this.odh;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = (d.g.a.b)new b(this, paramw);
      switch (j)
      {
      default: 
        paramView1 = this.oer;
        if (paramView1 != null) {
          paramView1.setText((CharSequence)paramw.Ioq.HAf.GfK);
        }
        paramView1 = this.odu;
        if (paramView1 != null) {
          paramView1.setOnLongClickListener((View.OnLongClickListener)new d(this, paramw));
        }
        if ((!bt.hj((List)paramw.fpm().HAf.FJN)) && (paramw.fpm().HAf.FJO == 1))
        {
          paramView1 = this.odx;
          if (paramView1 != null) {
            paramView1.setVisibility(0);
          }
          paramView1 = this.odx;
          if (paramView1 != null) {
            paramView1.setOnClickListener((View.OnClickListener)new c(this, paramw, paramInt));
          }
        }
        break;
      }
      for (;;)
      {
        paramw = paramw.fpm();
        p.g(paramw, "info.tlRecCardWrapper");
        paramView1 = paramw.HAf;
        if ((!bt.isNullOrNil(paramView1.GfO)) && (!bt.isNullOrNil(paramView1.GfN))) {
          break label1928;
        }
        paramw = this.vJF;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.oes;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.odu;
        if (paramw == null) {
          break label1922;
        }
        paramw.setOnClickListener(null);
        AppMethodBeat.o(209803);
        return;
        paramView2 = paramw.fpm().HAf.FHP.get(this.oet);
        p.g(paramView2, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
        paramView1.invoke(paramView2);
        paramView1 = ((Iterable)this.odj).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.odi;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.odl);
          }
          this.odk.cS(paramView2);
        }
        this.odj.clear();
        break;
        paramView2 = paramw.fpm().HAf.FHP.get(0);
        p.g(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
        paramView1.invoke(paramView2);
        paramView1 = paramw.fpm().HAf.FHP.get(1);
        p.g(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
        Object localObject2 = (ok)paramView1;
        paramView1 = ((Iterable)this.odj).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.odi;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.odl);
          }
          this.odk.cS(paramView2);
        }
        this.odj.clear();
        paramView2 = (a)this.odk.get();
        paramView1 = this.odi;
        if (paramView1 != null) {
          paramView1.addView(paramView2.odl);
        }
        this.odj.add(paramView2);
        paramView1 = ((ok)localObject2).FJV.get(0);
        p.g(paramView1, "bizInfo.AppMsg[0]");
        localObject1 = (oj)paramView1;
        p.h(paramw, "info");
        p.h(localObject2, "bizInfo");
        p.h(localObject1, "appMsg");
        paramView1 = ((oj)localObject1).Title;
        Object localObject3 = ((oj)localObject1).FFW;
        i = ((oj)localObject1).hCZ;
        String str1 = ((oj)localObject1).FFY;
        String str2 = ((oj)localObject1).FFZ;
        paramView2.oeR.ar((CharSequence)paramView1);
        paramView2.odl.setBackgroundResource(2131231256);
        paramView2.odl.setOnClickListener((View.OnClickListener)new r.a.a(paramView2, paramw, (ok)localObject2, (oj)localObject1));
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!bt.isNullOrNil((String)localObject3))) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, i, 90, new Object[0]);
        }
        paramView2.ocq.type = i;
        paramView2.ocq.hDm = str1;
        paramView2.ocq.hDD = str2;
        paramView2.ocq.url = ((String)localObject3);
        paramView1 = paramView2.ocG;
        p.g(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject3 = paramView2.ocH;
        p.g(localObject3, "friendReadTv");
        if (!bt.isNullOrNil(((oj)localObject1).uhr)) {}
        for (paramView1 = (CharSequence)String.valueOf(((oj)localObject1).uhr);; paramView1 = (CharSequence)"")
        {
          ((TextView)localObject3).setText(paramView1);
          paramView1 = paramView2.oeW;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(8);
          paramView2.oeW.setImageResource(2131231270);
          paramView1 = paramView2.oeU;
          p.g(paramView1, "voicePlayIconContainer");
          paramView1.setVisibility(8);
          if (paramView2.ocq.type != 7) {
            break label1658;
          }
          paramView2.ocn.setVisibility(8);
          p.h(paramw, "info");
          p.h(localObject2, "appMsgBizInfo");
          p.h(localObject1, "appMsg");
          paramView1 = paramView2.oeW;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(8);
          paramView1 = paramView2.oeU;
          p.g(paramView1, "voicePlayIconContainer");
          paramView1.setVisibility(0);
          paramView1 = paramView2.oeV;
          p.g(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
            ((AnimationDrawable)paramView1).stop();
          }
          if (!p.i(String.valueOf(paramw.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.bSj())) {
            break label1556;
          }
          paramView2.oeV.setImageResource(2131231272);
          paramView1 = paramView2.oeV;
          p.g(paramView1, "voicePlayIcon");
          if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
            break label1441;
          }
          paramView1 = paramView2.oeV;
          p.g(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (paramView1 != null) {
            break;
          }
          paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(209803);
          throw paramw;
        }
        ((AnimationDrawable)paramView1).start();
        label1441:
        paramView1 = ((oj)localObject1).FJP;
        if (bt.isNullOrNil(paramView1)) {
          ad.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        }
        for (;;)
        {
          paramView1 = (d.g.a.m)r.a.c.oew;
          localObject1 = (s)r.a.d.oex;
          localObject2 = paramView2.oeQ;
          p.g(localObject2, "content");
          ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oaj), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oag));
          paramView2 = paramView2.iCM;
          p.g(paramView2, "topLine");
          paramView1.p(paramView2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oak));
          break;
          paramView2.oeV.setImageResource(2131231271);
          break label1441;
          ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)paramView2.oeV, String.valueOf(paramw.field_msgId) + "_1", ((oj)localObject1).Title, paramView1, "", ((oj)localObject1).FFY);
          paramView2.oeV.setOnClickListener((View.OnClickListener)new r.a.e(paramView2, paramw, (oj)localObject1));
          continue;
          label1658:
          if (!bt.isNullOrNil(paramView2.ocq.hDm))
          {
            paramView2.ocn.setVisibility(0);
            paramView1 = paramView2.ofm.oas;
            long l = paramw.field_msgId;
            localObject1 = paramView2.ocq;
            localObject2 = com.tencent.mm.ai.m.a(paramView2.ocq);
            localObject3 = paramView2.ocn;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
            paramView1.a(l, 1, (com.tencent.mm.ai.v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new r.a.b(paramView2, paramw), paramw.ofe + 1, 2.0F);
            if (paramView2.ocq.type == 5)
            {
              paramView1 = paramView2.oeW;
              p.g(paramView1, "playIcon");
              paramView1.setVisibility(0);
            }
          }
          else if ((paramView2.ocq.type == 5) || (paramView2.ocq.type == 6))
          {
            paramView1 = paramView2.oeW;
            p.g(paramView1, "playIcon");
            paramView1.setVisibility(0);
            paramView2.ocn.setVisibility(0);
            paramView1 = paramView2.ofm.oas;
            localObject1 = paramView2.ocn;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
            paramView1.a("2131231674", (ImageView)localObject1, i, i, paramw.ofe + 1);
          }
          else
          {
            paramView2.oeT.setVisibility(8);
          }
        }
        paramView1 = this.odx;
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
      }
      AppMethodBeat.o(209803);
      return;
      paramView2 = this.vJF;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.oes;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.oes;
      if (paramView2 != null) {
        paramView2.setText((CharSequence)paramView1.GfO);
      }
      paramView2 = com.tencent.mm.plugin.brandservice.ui.b.d.osr;
      com.tencent.mm.plugin.brandservice.ui.b.d.i(this.oes);
      paramw = (d.g.a.a)new r.h(this, paramView1, paramw);
      paramView1 = this.vJF;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new e(paramw));
      }
      paramView1 = this.odu;
      if (paramView1 != null)
      {
        paramView1.setOnClickListener((View.OnClickListener)new r.g(paramw));
        AppMethodBeat.o(209803);
        return;
      }
      AppMethodBeat.o(209803);
      return;
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209804);
    View localView = this.odh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(209804);
      return;
    }
    AppMethodBeat.o(209804);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(209797);
      this.obC = paramContext;
      this.context = localObject;
      this.odl = View.inflate(this.context, 2131496383, null);
      this.ocq = new com.tencent.mm.ai.v();
      this.iCM = this.odl.findViewById(2131306012);
      this.oeQ = this.odl.findViewById(2131298764);
      this$1 = this.odl.findViewById(2131305938);
      if (r.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(209797);
        throw r.this;
      }
      this.oeR = ((MMNeat7extView)r.this);
      this.oeS = ((TextView)this.odl.findViewById(2131305546));
      this.oeT = this.odl.findViewById(2131298814);
      this.ocn = ((ImageView)this.odl.findViewById(2131298824));
      this.oeU = this.odl.findViewById(2131297330);
      this.oeV = ((ImageView)this.odl.findViewById(2131297370));
      this.oeW = ((ImageView)this.odl.findViewById(2131303284));
      this.ocG = this.odl.findViewById(2131305184);
      this$1 = this.odl.findViewById(2131300305);
      if (r.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(209797);
        throw r.this;
      }
      this.ocH = ((TextView)r.this);
      this.oeX = this.odl.findViewById(2131303255);
      this.oeY = this.odl.findViewById(2131303254);
      this.oeZ = ((TextView)this.odl.findViewById(2131303263));
      AppMethodBeat.o(209797);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(r.a parama, com.tencent.mm.storage.w paramw, ok paramok, oj paramoj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209790);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = this.oev;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209790);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((r.a)localObject1).context, (String)localObject2, localoj.hCZ, 169, 10000, localIntent))) {
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
          ((r.a)localObject1).obC.oaB.a(localok.nDo, l, i, 15, paramView.Hki, "", k, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, localoj.FJR, paramView.style, localoj.FJS);
          ((r.a)localObject1).obC.b(localw, k);
          break;
          com.tencent.mm.bs.d.b(((r.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(com.tencent.mm.storage.w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(209791);
        this.oev.a(this.oev.ocq, true);
        this.oev.ofm.oas.p(this.ocJ.field_msgId, this.odq);
        AppMethodBeat.o(209791);
      }
      
      public final void onStart() {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(r.a parama, com.tencent.mm.storage.w paramw, oj paramoj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209796);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.oev.oeV);
        if (this.ocJ.fpm() != null) {}
        try
        {
          paramView = Uri.parse(this.oct.FFW);
          bt.getInt(paramView.getQueryParameter("idx"), 0);
          bt.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209796);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<ok, z>
  {
    b(r paramr, com.tencent.mm.storage.w paramw)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(r paramr, com.tencent.mm.storage.w paramw, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(209799);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = paramw.fpm();
      if (this.oeu.oet == -1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209799);
        return;
      }
      localObject = (ok)paramw.fpm().HAf.FHP.get(this.oeu.oet);
      this.oeu.obC.oaB.a(((ok)localObject).nDo, 0L, 0, 16, paramView.Hki, "", 0, paramView.HAf.FHY, paramView.dln, paramView.HAf.FHU, 0, paramView.style, "");
      ((d)new d(this.oeu.context, paramw, this.oeu.obC, (ok)localObject, paramInt).hc((View)this.oeu.ody)).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209799);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(r paramr, com.tencent.mm.storage.w paramw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(209800);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      this.oeu.obC.oap = paramw;
      this.oeu.obC.bOj();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(209800);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(d.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(209801);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.vJG.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209801);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<r.a>
  {
    f(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.r
 * JD-Core Version:    0.7.0.1
 */