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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "Landroid/view/View;", "jumpLinkClick", "Landroid/widget/LinearLayout;", "slotContainer", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "txtJumpLink", "Landroid/widget/TextView;", "txtTitle", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshClose", "showPos", "refreshCommonSlot", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class r
  extends v
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  View oiV;
  private LinearLayout oiW;
  private LinkedList<a> oiX;
  private final g<a> oiY;
  private View oji;
  private View ojl;
  WeImageView ojm;
  f ojn;
  c ojo;
  private TextView okh;
  private TextView oki;
  private LinearLayout okj;
  int okk;
  
  public r(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(208781);
    this.ohs = paramb;
    this.context = paramContext;
    this.oiX = new LinkedList();
    this.oiY = new g((d.g.a.a)new h(this));
    this.ojn = new f(this.context, this.ohs);
    this.ojo = new c(this.context, this.ohs);
    this.okk = -1;
    AppMethodBeat.o(208781);
  }
  
  public final void a(final w paramw, final int paramInt, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(208779);
    p.h(paramw, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.oiV == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(2131308463)).inflate();
      this.ojl = paramView2.findViewById(2131298374);
      this.ojm = ((WeImageView)paramView2.findViewById(2131298373));
      this.oiW = ((LinearLayout)paramView2.findViewById(2131307153));
      this.oji = paramView2.findViewById(2131297276);
      this.okh = ((TextView)paramView2.findViewById(2131302860));
      this.oki = ((TextView)paramView2.findViewById(2131308342));
      this.okj = ((LinearLayout)paramView2.findViewById(2131306031));
      this.oiV = paramView2;
    }
    this.okk = -1;
    paramView2 = paramw.ftk().HTS.Gal;
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
        j.gkd();
      }
      if (((om)localObject1).FNv != 0) {
        break label2111;
      }
      int k = j + 1;
      if (this.okk == -1)
      {
        j = i;
        label260:
        this.okk = j;
        j = k;
      }
    }
    label1431:
    label2111:
    for (;;)
    {
      i += 1;
      break;
      j = this.okk;
      break label260;
      if ((j <= 0) || (this.okk == -1))
      {
        AppMethodBeat.o(208779);
        return;
      }
      paramView1.setVisibility(0);
      paramView1 = this.oiV;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = (d.g.a.b)new b(this, paramw);
      switch (j)
      {
      default: 
        paramView1 = this.okh;
        if (paramView1 != null) {
          paramView1.setText((CharSequence)paramw.IIG.HTS.Gys);
        }
        paramView1 = this.oji;
        if (paramView1 != null) {
          paramView1.setOnLongClickListener((View.OnLongClickListener)new d(this, paramw));
        }
        if ((!bu.ht((List)paramw.ftk().HTS.Gcm)) && (paramw.ftk().HTS.Gcn == 1))
        {
          paramView1 = this.ojl;
          if (paramView1 != null) {
            paramView1.setVisibility(0);
          }
          paramView1 = this.ojl;
          if (paramView1 != null) {
            paramView1.setOnClickListener((View.OnClickListener)new c(this, paramw, paramInt));
          }
        }
        break;
      }
      for (;;)
      {
        paramw = paramw.ftk();
        p.g(paramw, "info.tlRecCardWrapper");
        paramView1 = paramw.HTS;
        if (!bu.isNullOrNil(paramView1.Gyw)) {
          break label1918;
        }
        paramw = this.okj;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.oki;
        if (paramw != null) {
          paramw.setVisibility(8);
        }
        paramw = this.oji;
        if (paramw == null) {
          break label1912;
        }
        paramw.setOnClickListener(null);
        AppMethodBeat.o(208779);
        return;
        paramView2 = paramw.ftk().HTS.Gal.get(this.okk);
        p.g(paramView2, "info.tlRecCardWrapper.ex…aInfo.BizInfo[firstIndex]");
        paramView1.invoke(paramView2);
        paramView1 = ((Iterable)this.oiX).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.oiW;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.oiZ);
          }
          this.oiY.cT(paramView2);
        }
        this.oiX.clear();
        break;
        paramView2 = paramw.ftk().HTS.Gal.get(0);
        p.g(paramView2, "info.tlRecCardWrapper.extraInfo.BizInfo[0]");
        paramView1.invoke(paramView2);
        paramView1 = paramw.ftk().HTS.Gal.get(1);
        p.g(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo[1]");
        Object localObject2 = (om)paramView1;
        paramView1 = ((Iterable)this.oiX).iterator();
        while (paramView1.hasNext())
        {
          paramView2 = (a)paramView1.next();
          localObject1 = this.oiW;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).removeView(paramView2.oiZ);
          }
          this.oiY.cT(paramView2);
        }
        this.oiX.clear();
        paramView2 = (a)this.oiY.get();
        paramView1 = this.oiW;
        if (paramView1 != null) {
          paramView1.addView(paramView2.oiZ);
        }
        this.oiX.add(paramView2);
        paramView1 = ((om)localObject2).Gcu.get(0);
        p.g(paramView1, "bizInfo.AppMsg[0]");
        localObject1 = (ol)paramView1;
        p.h(paramw, "info");
        p.h(localObject2, "bizInfo");
        p.h(localObject1, "appMsg");
        paramView1 = ((ol)localObject1).Title;
        Object localObject3 = ((ol)localObject1).FYs;
        i = ((ol)localObject1).hFR;
        String str1 = ((ol)localObject1).FYu;
        String str2 = ((ol)localObject1).FYv;
        paramView2.okR.aq((CharSequence)paramView1);
        paramView2.oiZ.setBackgroundResource(2131231256);
        paramView2.oiZ.setOnClickListener((View.OnClickListener)new r.a.a(paramView2, paramw, (om)localObject2, (ol)localObject1));
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil((String)localObject3))) {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, i, 90, new Object[0]);
        }
        paramView2.oif.type = i;
        paramView2.oif.hGe = str1;
        paramView2.oif.hGv = str2;
        paramView2.oif.url = ((String)localObject3);
        paramView1 = paramView2.oiv;
        p.g(paramView1, "statLayout");
        paramView1.setVisibility(0);
        localObject3 = paramView2.oiw;
        p.g(localObject3, "friendReadTv");
        if (!bu.isNullOrNil(((ol)localObject1).usP)) {}
        for (paramView1 = (CharSequence)String.valueOf(((ol)localObject1).usP);; paramView1 = (CharSequence)"")
        {
          ((TextView)localObject3).setText(paramView1);
          paramView1 = paramView2.okW;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(8);
          paramView2.okW.setImageResource(2131231270);
          paramView1 = paramView2.okU;
          p.g(paramView1, "voicePlayIconContainer");
          paramView1.setVisibility(8);
          if (paramView2.oif.type != 7) {
            break label1648;
          }
          paramView2.oic.setVisibility(8);
          p.h(paramw, "info");
          p.h(localObject2, "appMsgBizInfo");
          p.h(localObject1, "appMsg");
          paramView1 = paramView2.okW;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(8);
          paramView1 = paramView2.okU;
          p.g(paramView1, "voicePlayIconContainer");
          paramView1.setVisibility(0);
          paramView1 = paramView2.okV;
          p.g(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
            ((AnimationDrawable)paramView1).stop();
          }
          if (!p.i(String.valueOf(paramw.field_msgId) + "_1", com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
            break label1546;
          }
          paramView2.okV.setImageResource(2131231272);
          paramView1 = paramView2.okV;
          p.g(paramView1, "voicePlayIcon");
          if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
            break label1431;
          }
          paramView1 = paramView2.okV;
          p.g(paramView1, "voicePlayIcon");
          paramView1 = paramView1.getDrawable();
          if (paramView1 != null) {
            break;
          }
          paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(208779);
          throw paramw;
        }
        ((AnimationDrawable)paramView1).start();
        paramView1 = ((ol)localObject1).Gco;
        if (bu.isNullOrNil(paramView1)) {
          ae.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        }
        for (;;)
        {
          paramView1 = (d.g.a.m)r.a.c.okn;
          localObject1 = (s)r.a.d.oko;
          localObject2 = paramView2.okQ;
          p.g(localObject2, "content");
          ((s)localObject1).a(localObject2, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW));
          paramView2 = paramView2.iFF;
          p.g(paramView2, "topLine");
          paramView1.p(paramView2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oga));
          break;
          paramView2.okV.setImageResource(2131231271);
          break label1431;
          ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)paramView2.okV, String.valueOf(paramw.field_msgId) + "_1", ((ol)localObject1).Title, paramView1, "", ((ol)localObject1).FYu);
          paramView2.okV.setOnClickListener((View.OnClickListener)new r.a.e(paramView2, paramw, (ol)localObject1));
          continue;
          label1648:
          if (!bu.isNullOrNil(paramView2.oif.hGe))
          {
            paramView2.oic.setVisibility(0);
            paramView1 = paramView2.oll.ogi;
            long l = paramw.field_msgId;
            localObject1 = paramView2.oif;
            localObject2 = com.tencent.mm.ah.m.a(paramView2.oif);
            localObject3 = paramView2.oic;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
            paramView1.a(l, 1, (com.tencent.mm.ah.v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new r.a.b(paramView2, paramw), paramw.ole + 1, 2.0F);
            if (paramView2.oif.type == 5)
            {
              paramView1 = paramView2.okW;
              p.g(paramView1, "playIcon");
              paramView1.setVisibility(0);
            }
          }
          else if ((paramView2.oif.type == 5) || (paramView2.oif.type == 6))
          {
            paramView1 = paramView2.okW;
            p.g(paramView1, "playIcon");
            paramView1.setVisibility(0);
            paramView2.oic.setVisibility(0);
            paramView1 = paramView2.oll.ogi;
            localObject1 = paramView2.oic;
            i = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
            paramView1.a("2131231674", (ImageView)localObject1, i, i, paramw.ole + 1);
          }
          else
          {
            paramView2.okT.setVisibility(8);
          }
        }
        paramView1 = this.ojl;
        if (paramView1 != null) {
          paramView1.setVisibility(8);
        }
      }
      label1912:
      AppMethodBeat.o(208779);
      return;
      label1918:
      paramView2 = this.okj;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.oki;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.oki;
      if (paramView2 != null) {
        paramView2.setText((CharSequence)paramView1.Gyw);
      }
      paramView2 = com.tencent.mm.plugin.brandservice.ui.b.d.oyS;
      com.tencent.mm.plugin.brandservice.ui.b.d.h(this.oki);
      if (bu.isNullOrNil(paramView1.Gyv))
      {
        paramw = this.oji;
        if (paramw != null) {
          paramw.setClickable(false);
        }
        paramw = this.okj;
        if (paramw != null)
        {
          paramw.setClickable(false);
          AppMethodBeat.o(208779);
          return;
        }
        AppMethodBeat.o(208779);
        return;
      }
      paramw = (d.g.a.a)new g(this, paramView1, paramw);
      paramView1 = this.okj;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new r.e(paramw));
      }
      paramView1 = this.oji;
      if (paramView1 != null)
      {
        paramView1.setOnClickListener((View.OnClickListener)new r.f(paramw));
        AppMethodBeat.o(208779);
        return;
      }
      AppMethodBeat.o(208779);
      return;
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208780);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208780);
      return;
    }
    AppMethodBeat.o(208780);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
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
      AppMethodBeat.i(208771);
      this.ohs = paramContext;
      this.context = localObject;
      this.oiZ = View.inflate(this.context, 2131496383, null);
      this.oif = new com.tencent.mm.ah.v();
      this.iFF = this.oiZ.findViewById(2131306012);
      this.okQ = this.oiZ.findViewById(2131298764);
      this$1 = this.oiZ.findViewById(2131305938);
      if (r.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208771);
        throw r.this;
      }
      this.okR = ((MMNeat7extView)r.this);
      this.okS = ((TextView)this.oiZ.findViewById(2131305546));
      this.okT = this.oiZ.findViewById(2131298814);
      this.oic = ((ImageView)this.oiZ.findViewById(2131298824));
      this.okU = this.oiZ.findViewById(2131297330);
      this.okV = ((ImageView)this.oiZ.findViewById(2131297370));
      this.okW = ((ImageView)this.oiZ.findViewById(2131303284));
      this.oiv = this.oiZ.findViewById(2131305184);
      this$1 = this.oiZ.findViewById(2131300305);
      if (r.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(208771);
        throw r.this;
      }
      this.oiw = ((TextView)r.this);
      this.okX = this.oiZ.findViewById(2131303255);
      this.okY = this.oiZ.findViewById(2131303254);
      this.okZ = ((TextView)this.oiZ.findViewById(2131303263));
      AppMethodBeat.o(208771);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(r.a parama, w paramw, om paramom, ol paramol) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208764);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = this.okm;
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208764);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((r.a)localObject1).context, (String)localObject2, localol.hFR, 169, 10000, localIntent))) {
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
          ((r.a)localObject1).ohs.ogr.a(localom.nIJ, l, i, 15, paramView.HDI, "", k, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, localol.Gcq, paramView.style, localol.Gcr);
          ((r.a)localObject1).ohs.b(localw, k);
          break;
          com.tencent.mm.br.d.b(((r.a)localObject1).context, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(208765);
        this.okm.a(this.okm.oif, true);
        this.okm.oll.ogi.p(this.oiy.field_msgId, this.oje);
        AppMethodBeat.o(208765);
      }
      
      public final void onStart() {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(r.a parama, w paramw, ol paramol) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208770);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.okm.okV);
        if (this.oiy.ftk() != null) {}
        try
        {
          paramView = Uri.parse(this.oii.FYs);
          bu.getInt(paramView.getQueryParameter("idx"), 0);
          bu.getLong(paramView.getQueryParameter("mid"), 0L);
          label101:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208770);
          return;
        }
        catch (Exception paramView)
        {
          break label101;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<om, z>
  {
    b(r paramr, w paramw)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(r paramr, w paramw, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208773);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = paramw.ftk();
      if (this.okl.okk == -1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208773);
        return;
      }
      localObject1 = (om)paramw.ftk().HTS.Gal.get(this.okl.okk);
      ol localol = (ol)((om)localObject1).Gcu.get(0);
      Object localObject2 = localol.FYs;
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
      this.okl.ohs.ogr.a(((om)localObject1).nIJ, l1, i, 16, paramView.HDI, "", 0, paramView.HTS.Gau, paramView.dmp, paramView.HTS.Gaq, localol.Gcq, paramView.style, localol.Gcr);
      ((d)new d(this.okl.context, paramw, this.okl.ohs, (om)localObject1, paramInt).hh((View)this.okl.ojm)).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208773);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class d
    implements View.OnLongClickListener
  {
    d(r paramr, w paramw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(208774);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      this.okl.ohs.ogf = paramw;
      this.okl.ohs.bPg();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$refreshHead$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(208774);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(r paramr, aiq paramaiq, dmq paramdmq)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<r.a>
  {
    h(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.r
 * JD-Core Version:    0.7.0.1
 */