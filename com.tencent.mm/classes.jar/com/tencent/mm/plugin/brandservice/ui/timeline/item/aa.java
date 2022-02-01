package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "firstIndex", "", "item", "Landroid/view/View;", "jumpMore", "Landroid/widget/RelativeLayout;", "longClick", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "time", "Landroid/widget/TextView;", "txtJumpLink", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "hide", "inflate", "refreshCommonSlot", "refreshHead", "refreshJumpLink", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "BizRecCardCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends ab
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private TextView vJB;
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  private RelativeLayout vLH;
  private RelativeLayout vLI;
  private TextView vLJ;
  private int vLg;
  
  public aa(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(302489);
    this.vHY = paramb;
    this.context = paramContext;
    this.vJW = new LinkedList();
    this.vJX = new i((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(302489);
  }
  
  private static final boolean a(aa paramaa, com.tencent.mm.storage.ab paramab, View paramView)
  {
    AppMethodBeat.i(302494);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaa);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramaa, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    paramaa.vHY.vFJ = paramab;
    paramaa.vHY.dcM();
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(302494);
    return false;
  }
  
  private static final void b(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302501);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(24));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302501);
  }
  
  private static final void c(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302512);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(25));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302512);
  }
  
  private static final void d(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302520);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(24));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302520);
  }
  
  public final void a(final com.tencent.mm.storage.ab paramab, int paramInt, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(302583);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView1, "convertView");
    kotlin.g.b.s.u(paramView2, "parent");
    kotlin.g.b.s.u(paramView2, "parent");
    Object localObject1;
    if (this.vJU == null)
    {
      paramView2 = ((ViewStub)paramView2.findViewById(d.e.viewstub_subscribe)).inflate();
      this.vJV = ((LinearLayout)paramView2.findViewById(d.e.biz_rec_card_common_slot));
      this.vJB = ((TextView)paramView2.findViewById(d.e.jump_link));
      this.vLH = ((RelativeLayout)paramView2.findViewById(d.e.long_click));
      this.vLI = ((RelativeLayout)paramView2.findViewById(d.e.more));
      this.vLJ = ((TextView)paramView2.findViewById(d.e.time));
      localObject1 = ah.aiuX;
      this.vJU = paramView2;
    }
    paramView1.setVisibility(0);
    paramView1 = this.vJU;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = this.vLH;
    if (paramView1 != null) {
      paramView1.setOnLongClickListener(new aa..ExternalSyntheticLambda3(this, paramab));
    }
    paramView1 = this.vLJ;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.c.f(this.context, paramab.field_createTime));
    }
    paramView1 = paramab.iYp();
    kotlin.g.b.s.s(paramView1, "info.tlRecCardWrapper");
    paramView2 = paramView1.abLM;
    if (Util.isNullOrNil(paramView2.Zxr))
    {
      paramView1 = this.vJB;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.vJB;
      if (paramView1 != null) {
        paramView1.setText((CharSequence)"");
      }
      paramView1 = this.vJB;
      if (paramView1 != null) {
        paramView1.setContentDescription((CharSequence)"");
      }
    }
    Object localObject2;
    for (;;)
    {
      paramView1 = ((Iterable)this.vJW).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        localObject1 = this.vJV;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).removeView(paramView2.vJY);
        }
        this.vJX.et(paramView2);
      }
      localObject1 = this.vJB;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.vJB;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramView2.Zxr);
      }
      localObject1 = this.vJB;
      if ((localObject1 != null) && (!Util.isNullOrNil(((TextView)localObject1).getText())))
      {
        if (((TextView)localObject1).getText().length() >= 2)
        {
          localObject2 = ((TextView)localObject1).getText();
          kotlin.g.b.s.s(localObject2, "text");
          if (n.e((CharSequence)localObject2, (CharSequence)"#")) {
            break label527;
          }
        }
        ((TextView)localObject1).setContentDescription(((TextView)localObject1).getText());
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vJB);
        if (!Util.isNullOrNil(paramView2.Zxq)) {
          break label616;
        }
        paramView1 = this.vJB;
        if (paramView1 != null) {
          paramView1.setOnClickListener(null);
        }
        paramView1 = this.vLI;
        if (paramView1 == null) {
          break;
        }
        paramView1.setOnClickListener(null);
        break;
        label527:
        localObject2 = am.aixg;
        localObject2 = ((TextView)localObject1).getContext().getResources().getString(d.i.biz_timeline_topic);
        kotlin.g.b.s.s(localObject2, "context.resources.getStr…tring.biz_timeline_topic)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { ((TextView)localObject1).getText().subSequence(1, ((TextView)localObject1).getText().length()) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setContentDescription((CharSequence)localObject2);
      }
      label616:
      paramView1 = (kotlin.g.a.b)new b(paramView2, this, paramab, paramView1);
      paramView2 = this.vLH;
      if (paramView2 != null) {
        paramView2.setOnClickListener(new aa..ExternalSyntheticLambda1(paramView1));
      }
      paramView2 = this.vLI;
      if (paramView2 != null) {
        paramView2.setOnClickListener(new aa..ExternalSyntheticLambda2(paramView1));
      }
      paramView2 = this.vJB;
      if (paramView2 != null) {
        paramView2.setOnClickListener(new aa..ExternalSyntheticLambda0(paramView1));
      }
    }
    this.vJW.clear();
    paramView1 = paramab.iYp().abLM.YSB;
    kotlin.g.b.s.s(paramView1, "info.tlRecCardWrapper.extraInfo.BizInfo");
    paramView1 = ((Iterable)paramView1).iterator();
    paramInt = 0;
    while (paramView1.hasNext())
    {
      paramView2 = paramView1.next();
      if (paramInt < 0) {
        p.kkW();
      }
      paramView2 = (qo)paramView2;
      localObject1 = (a)this.vJX.get();
      localObject2 = this.vJV;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).addView(((a)localObject1).vJY);
      }
      this.vJW.add(localObject1);
      kotlin.g.b.s.s(paramView2, "bizInfo");
      localObject2 = paramView2.YVI.get(0);
      kotlin.g.b.s.s(localObject2, "bizInfo.AppMsg[0]");
      ((a)localObject1).a(paramab, paramView2, (qn)localObject2, paramInt, paramInt);
      paramInt += 1;
    }
    AppMethodBeat.o(302583);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302589);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302589);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends ag
  {
    private final Context context;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
    final v vIN;
    final View vJY;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(302738);
      this.vHY = paramContext;
      this.context = localObject;
      this.vJY = View.inflate(this.context, d.f.biz_time_line_rec_card_common_slotv2, null);
      this.vIN = new v();
      this.plj = this.vJY.findViewById(d.e.top_line);
      this.uoA = ((ViewGroup)this.vJY.findViewById(d.e.content_ll));
      this$1 = this.vJY.findViewById(d.e.title_neat_tv);
      if (aa.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(302738);
        throw aa.this;
      }
      this.vMn = ((MMNeat7extView)aa.this);
      this.vMo = ((TextView)this.vJY.findViewById(d.e.summary));
      this.vMp = this.vJY.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vJY.findViewById(d.e.cover_iv));
      this.vMq = this.vJY.findViewById(d.e.biz_slot_voice_layout);
      this.vMr = ((ImageView)this.vJY.findViewById(d.e.biz_time_line_voice_play_icon));
      this.vMs = ((ImageView)this.vJY.findViewById(d.e.play_icon));
      this.vJc = this.vJY.findViewById(d.e.stat_layout);
      this$1 = this.vJY.findViewById(d.e.friends_read_tv);
      if (aa.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(302738);
        throw aa.this;
      }
      this.vJd = ((TextView)aa.this);
      this.vMt = this.vJY.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vJY.findViewById(d.e.pic_cover_mask);
      this.vJJ = ((TextView)this.vJY.findViewById(d.e.pic_num));
      AppMethodBeat.o(302738);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qn paramqn, View paramView)
    {
      AppMethodBeat.i(302757);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.cH(paramqn);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramab, "$info");
      kotlin.g.b.s.u(paramqn, "$appMsg");
      ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).eA((View)parama.vMr);
      if (paramab.iYp() != null) {}
      try
      {
        parama = Uri.parse(paramqn.YQK);
        Util.getInt(parama.getQueryParameter("idx"), 0);
        Util.getLong(parama.getQueryParameter("mid"), 0L);
        label149:
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302757);
        return;
      }
      catch (Exception parama)
      {
        break label149;
      }
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn, int paramInt, View paramView)
    {
      AppMethodBeat.i(302752);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqo);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqn);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramab, "$info");
      kotlin.g.b.s.u(paramqo, "$bizInfo");
      kotlin.g.b.s.u(paramqn, "$appMsg");
      kotlin.g.b.s.u(paramab, "info");
      kotlin.g.b.s.u(paramqo, "appMsgBizInfo");
      if ((paramqn != null) && (paramab.iYo() != null))
      {
        paramView = paramab.iYo();
        kotlin.g.b.s.checkNotNull(paramView);
        if (paramView.abLF != null) {}
      }
      else
      {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302752);
        return;
      }
      localObject1 = null;
      if (paramqn.YVG != null)
      {
        paramView = paramqn.YVG;
        kotlin.g.b.s.s(paramView, "appMsg.finderXmlContent");
        if (n.U(paramView, "<finder_feed>", false))
        {
          paramView = XmlParser.parseXml(paramqn.YVG, "finder_feed", null);
          localObject1 = "";
        }
      }
      for (;;)
      {
        if (paramView != null)
        {
          localObject2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(26, 2, 25, null);
          if (((br)com.tencent.mm.kernel.h.ax(br.class)).a(parama.context, (String)localObject1, paramView, (String)localObject2))
          {
            Log.i("MicroMsg.BizTimeLineItem", "open finder success!");
            parama.vHY.b(paramab, paramInt);
            break;
            paramView = paramqn.YVG;
            kotlin.g.b.s.s(paramView, "appMsg.finderXmlContent");
            if (!n.U(paramView, "~SEMI_XML~", false)) {
              break label794;
            }
            localObject1 = SemiXml.decode(paramqn.YVG);
            if (paramInt == 0) {}
            for (paramView = "";; paramView = String.valueOf(paramInt))
            {
              localObject2 = ".sysmsg.BizAccountRecommend.BizAccount" + paramView + ".AppMsg";
              paramView = (View)localObject1;
              localObject1 = localObject2;
              break;
            }
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 4L, 1L, false);
        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramqn.YQK });
        paramView = new Intent();
        localObject1 = com.tencent.mm.message.m.e(paramqn.YQK, 183, 10000, (int)System.currentTimeMillis() / 1000);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("geta8key_scene", 56);
        paramView.putExtra("geta8key_username", paramqo.UserName);
        paramView.putExtra("srcUsername", paramqo.UserName);
        paramView.putExtra("srcDisplayname", paramqo.vhX);
        paramView.putExtra("prePublishId", "rec_card");
        paramView.putExtra("KPublisherId", "rec_card");
        if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.context, (String)localObject1, paramqn.nUA, 183, 10000, paramView))) {
          Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = paramab.iYp();
          int j;
          int i;
          if (paramView != null)
          {
            j = 0;
            i = j;
          }
          try
          {
            localObject1 = Uri.parse((String)localObject1);
            i = j;
            j = Util.getInt(((Uri)localObject1).getQueryParameter("idx"), 0);
            i = j;
            l = Util.getLong(((Uri)localObject1).getQueryParameter("mid"), 0L);
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l = 0L;
            }
          }
          parama.vHY.vFK.a(paramqo.UserName, l, i, 15, paramView.abry, "", paramInt, paramView.abLM.YSJ, paramView.event, paramView.abLM.YSF, paramqn.YVE, paramView.style, paramqn.YVF);
          parama.vHY.b(paramab, paramInt);
          break;
          com.tencent.mm.br.c.b(parama.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
        label794:
        paramView = null;
      }
    }
    
    public final void a(final com.tencent.mm.storage.ab paramab, qo paramqo, qn paramqn, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(302789);
      kotlin.g.b.s.u(paramab, "info");
      kotlin.g.b.s.u(paramqo, "bizInfo");
      kotlin.g.b.s.u(paramqn, "appMsg");
      Object localObject3 = paramqn.hAP;
      Object localObject1 = paramqn.YQK;
      int j = paramqn.nUA;
      Object localObject2 = paramqn.YQM;
      String str = paramqn.YQN;
      this.vMn.aZ((CharSequence)localObject3);
      localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vMn);
      }
      localObject3 = this.vJY;
      int i;
      if ((paramInt1 == 0) && (paramInt2 <= 0))
      {
        i = d.d.biz_time_line_item_middle_bg;
        ((View)localObject3).setBackgroundResource(i);
        this.vJY.setOnClickListener(new aa.a..ExternalSyntheticLambda1(this, paramab, paramqo, paramqn, paramInt1));
        if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (!Util.isNullOrNil((String)localObject1))) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((String)localObject1, j, 90, new Object[0]);
        }
        this.vIN.type = j;
        this.vIN.nUM = ((String)localObject2);
        this.vIN.nVd = str;
        this.vIN.url = ((String)localObject1);
        this.vJc.setVisibility(0);
        localObject2 = this.vJd;
        if (Util.isNullOrNil(paramqn.IJA)) {
          break label486;
        }
      }
      label486:
      for (localObject1 = (CharSequence)String.valueOf(paramqn.IJA);; localObject1 = (CharSequence)"")
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        this.vMs.setVisibility(8);
        this.vMs.setImageResource(d.d.biz_time_line_item_video_play_selector);
        this.vMq.setVisibility(8);
        if (this.vIN.type != 7) {
          break label699;
        }
        this.vIK.setVisibility(8);
        kotlin.g.b.s.u(paramab, "info");
        kotlin.g.b.s.u(paramqo, "appMsgBizInfo");
        kotlin.g.b.s.u(paramqn, "appMsg");
        this.vMs.setVisibility(8);
        this.vMq.setVisibility(0);
        paramqo = this.vMr.getDrawable();
        if (((paramqo instanceof AnimationDrawable)) && (((AnimationDrawable)paramqo).isRunning())) {
          ((AnimationDrawable)paramqo).stop();
        }
        if (!kotlin.g.b.s.p(paramab.field_msgId + '_' + paramInt1, com.tencent.mm.plugin.brandservice.ui.b.d.dhS())) {
          break label606;
        }
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_playing_selector);
        if (!(this.vMr.getDrawable() instanceof AnimationDrawable)) {
          break label504;
        }
        paramqo = this.vMr.getDrawable();
        if (paramqo != null) {
          break label497;
        }
        paramab = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(302789);
        throw paramab;
        i = d.d.biz_time_line_item_bottom_bg;
        break;
      }
      label497:
      ((AnimationDrawable)paramqo).start();
      label504:
      paramqo = paramqn.YVC;
      if (Util.isNullOrNil(paramqo))
      {
        Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
        label525:
        paramqo = (kotlin.g.a.m)aa.a.b.vLM;
        paramab = (kotlin.g.a.s)aa.a.c.vLN;
        switch (paramInt1)
        {
        }
      }
      for (;;)
      {
        if (this.vIN.type == 5)
        {
          paramab = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(this.vIN.url, this.vIN.type, "");
        }
        AppMethodBeat.o(302789);
        return;
        label606:
        this.vMr.setImageResource(d.d.biz_time_line_item_voice_play_selector);
        break;
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a((View)this.vMr, paramab.field_msgId + '_' + paramInt1, paramqn.hAP, paramqo, "", paramqn.YQM);
        this.vMr.setOnClickListener(new aa.a..ExternalSyntheticLambda0(this, paramab, paramqn));
        break label525;
        label699:
        if (!Util.isNullOrNil(this.vIN.nUM))
        {
          this.vIK.setVisibility(0);
          long l = paramab.field_msgId;
          paramqo = this.vIN;
          paramqn = com.tencent.mm.message.m.a(this.vIN);
          localObject1 = this.vIK;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(l, paramInt1, paramqo, paramqn, (ImageView)localObject1, i, i, false, (m.a)new a(this, paramab, paramInt1), paramab.vMB + 1, 2.0F);
          if (this.vIN.type != 5) {
            break label525;
          }
          this.vMs.setVisibility(0);
          break label525;
        }
        if ((this.vIN.type == 5) || (this.vIN.type == 6))
        {
          this.vMs.setVisibility(0);
          this.vIK.setVisibility(0);
          paramqo = d.d.chatting_item_biz_play_icon_bg;
          paramqn = this.vIK;
          i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramqo, paramqn, i, i, paramab.vMB + 1);
          break label525;
        }
        this.vMp.setVisibility(8);
        break label525;
        if (paramInt2 > 0)
        {
          paramqo = this.uoA;
          kotlin.g.b.s.s(paramqo, "content");
          paramab.a(paramqo, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGm), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf));
        }
        for (;;)
        {
          this.plj.setVisibility(8);
          break;
          paramqo = this.uoA;
          kotlin.g.b.s.s(paramqo, "content");
          paramab.a(paramqo, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGm), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi));
        }
        paramqn = this.uoA;
        kotlin.g.b.s.s(paramqn, "content");
        paramab.a(paramqn, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi));
        paramab = this.plj;
        kotlin.g.b.s.s(paramab, "topLine");
        paramqo.invoke(paramab, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj));
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(aa.a parama, com.tencent.mm.storage.ab paramab, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302462);
        this.vLL.a(this.vLL.vIN, true);
        this.vLL.vMC.vFN.y(paramab.field_msgId, paramInt1);
        AppMethodBeat.o(302462);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "opType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    b(apx paramapx, aa paramaa, com.tencent.mm.storage.ab paramab, flj paramflj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<aa.a>
  {
    c(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aa
 * JD-Core Version:    0.7.0.1
 */