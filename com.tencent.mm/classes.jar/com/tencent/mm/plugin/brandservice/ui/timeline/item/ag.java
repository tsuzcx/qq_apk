package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "viewMultiPicArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle;", "viewPic", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewText", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "clearSlotView", "", "clickCard", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "BizRecFeedCommonSlot", "plugin-brandservice_release"})
public final class ag
  extends ae
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  private boolean sEz;
  private m sGr;
  private o sGs;
  private r sGt;
  private p sGu;
  private q sGv;
  private final n[] sGw;
  private int style;
  
  public ag(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(264558);
    this.sCg = paramb;
    this.context = paramContext;
    this.sEk = new LinkedList();
    this.sGr = new m(this.context, this.sCg);
    this.sGs = new o(this.context, this.sCg);
    this.sGt = new r(this.context, this.sCg);
    this.sGu = new p(this.context, this.sCg);
    this.sGv = new q(this.context, this.sCg);
    this.style = 2001;
    this.sEl = new i((kotlin.g.a.a)new d(this));
    this.sGw = new n[] { (n)this.sGr, (n)this.sGt, (n)this.sGu, (n)this.sGv, (n)this.sGs };
    AppMethodBeat.o(264558);
  }
  
  public final void a(final z paramz, final int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(264553);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramView1, "convertView");
    kotlin.g.b.p.k(paramView2, "parent");
    kotlin.g.b.p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      localObject1 = ((ViewStub)paramView2.findViewById(d.e.sts)).inflate();
      this.sEj = ((LinearLayout)((View)localObject1).findViewById(d.e.sqk));
      this.sEi = ((View)localObject1);
    }
    this.sEz = false;
    Object localObject1 = this.sEj;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.sEk).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      this.sEl.cX(localObject2);
    }
    this.sEk.clear();
    localObject1 = paramz.Ven;
    kotlin.g.b.p.j(localObject1, "info.recFeed");
    if (!af.a((dug)localObject1))
    {
      localObject1 = paramz.Ven;
      kotlin.g.b.p.j(localObject1, "info.recFeed");
      kotlin.g.b.p.k(localObject1, "$this$isShowThreePic");
      localObject1 = ((dug)localObject1).UaA.get(0);
      kotlin.g.b.p.j(localObject1, "this.RecommendItem[0]");
      if (!af.b((dur)localObject1)) {}
    }
    else
    {
      localObject1 = this.sGw;
      j = localObject1.length;
      i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!((n)localObject2).a((dur)paramz.Ven.UaA.get(0))) {
          ((n)localObject2).cAv();
        }
        for (;;)
        {
          i += 1;
          break;
          ((n)localObject2).a(paramz, paramInt, paramView1, paramView2);
          if ((localObject2 instanceof r))
          {
            this.sEz = true;
            a(paramz, (ae)this);
            localObject2 = MPVideoPreviewMgr.sSn;
            MPVideoPreviewMgr.q(paramz);
            this.sGt.sDm = ((kotlin.g.a.a)new b(this, paramz, paramInt, paramView1, paramView2));
          }
          else
          {
            this.sGt.sDm = ((kotlin.g.a.a)new c(this, paramz, paramInt, paramView1, paramView2));
          }
        }
      }
      AppMethodBeat.o(264553);
      return;
    }
    paramView1 = this.sGw;
    int j = paramView1.length;
    int i = 0;
    while (i < j)
    {
      paramView1[i].cAv();
      i += 1;
    }
    paramView2 = (a)this.sEl.get();
    paramView1 = this.sEj;
    if (paramView1 != null) {
      paramView1.addView((View)paramView2.sGx);
    }
    this.sEk.add(paramView2);
    paramView1 = paramz.Ven.UaA.get(0);
    kotlin.g.b.p.j(paramView1, "info.recFeed.RecommendItem[0]");
    paramView1 = (dur)paramView1;
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramView1, "itemMsg");
    localObject1 = (Collection)paramz.Ven.RXF;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label846;
      }
      localObject1 = paramView2.sDP;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = paramView2.sDP;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new ag.a.a(paramView2, paramz, paramInt));
      }
      localObject2 = paramView1.UaX;
      localObject3 = ((cmo)localObject2).fwr;
      localObject1 = ((cmo)localObject2).RTk;
      j = ((cmo)localObject2).lpx;
      if ((!af.f(paramView1)) || (Util.isNullOrNil(((cmo)localObject2).RTi))) {
        break label1601;
      }
      localObject4 = paramView2.sGQ;
      kotlin.g.b.p.j(localObject4, "titleNeatTv");
      ((MMNeat7extView)localObject4).setVisibility(8);
      localObject4 = paramView2.sGA;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).setVisibility(0);
      }
      localObject4 = paramView2.sDM;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).setVisibility(0);
      }
      localObject4 = paramView2.sGA;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).aL((CharSequence)localObject3);
      }
      localObject3 = paramView2.sDM;
      if (localObject3 != null) {
        ((MMNeat7extView)localObject3).aL((CharSequence)((cmo)localObject2).RTi);
      }
      paramView2.sGx.setPadding(0, 0, 0, com.tencent.mm.ci.a.fromDPToPix(paramView2.context, 14));
      paramView2.rgA.setPadding(0, com.tencent.mm.ci.a.fromDPToPix(paramView2.context, 4), 0, 0);
      localObject3 = paramView2.sGS;
      kotlin.g.b.p.j(localObject3, "coverArea");
      localObject4 = paramView2.sGS;
      kotlin.g.b.p.j(localObject4, "coverArea");
      localObject4 = ((View)localObject4).getLayoutParams();
      if (localObject4 != null) {
        break label867;
      }
      paramz = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(264553);
      throw paramz;
      i = 0;
      break;
      label846:
      localObject1 = paramView2.sDP;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    label867:
    Object localObject4 = (LinearLayout.LayoutParams)localObject4;
    ((LinearLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.ci.a.fromDPToPix(paramView2.context, 4);
    ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    Object localObject3 = paramView2.sDg;
    if (localObject3 != null) {
      ((LinearLayout)localObject3).setPadding(0, 0, 0, 0);
    }
    localObject3 = paramView2.sDg;
    if ((localObject3 == null) || (((LinearLayout)localObject3).indexOfChild((View)paramView2.sDN) != -1))
    {
      localObject3 = paramView2.sDg;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).removeView((View)paramView2.sDN);
      }
      localObject3 = paramView2.sGz;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).addView((View)paramView2.sDN);
      }
    }
    localObject3 = (CharSequence)paramView1.UaC;
    if ((localObject3 == null) || (kotlin.n.n.ba((CharSequence)localObject3)))
    {
      i = 1;
      label1023:
      if (i == 0) {
        break label1916;
      }
      localObject3 = paramView2.sGy;
      if (localObject3 != null) {
        ((MMNeat7extView)localObject3).setVisibility(8);
      }
      label1047:
      localObject3 = paramView2.sDO;
      if (localObject3 != null)
      {
        localObject4 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView2.sCg.szZ, paramInt, paramz, paramView1, (TextView)localObject3, paramView2.context);
      }
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView1.UaD, paramView2.sDR);
      localObject3 = (CharSequence)paramView1.UaC;
      if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
        break label1961;
      }
      i = 1;
      label1127:
      if (i == 0) {
        break label1979;
      }
      localObject3 = (CharSequence)paramView1.SwI;
      if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
        break label1967;
      }
      i = 1;
      label1157:
      if (i == 0)
      {
        localObject3 = (CharSequence)paramView1.SwH;
        if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
          break label1973;
        }
        i = 1;
        label1187:
        if (i == 0) {
          break label1979;
        }
      }
      localObject3 = paramView2.sDN;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).setVisibility(8);
      }
      label1211:
      localObject3 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.e(paramView2.sGQ);
      }
      paramView2.sGx.setOnClickListener((View.OnClickListener)new ag.a.b(paramView2, paramz, paramView1, paramInt));
      if ((((c)com.tencent.mm.kernel.h.ae(c.class)).Gw(1)) && (!Util.isNullOrNil((String)localObject1))) {
        ((c)com.tencent.mm.kernel.h.ae(c.class)).a((String)localObject1, j, 90, new Object[0]);
      }
      paramView2.sCU.type = j;
      localObject3 = paramView2.sCU;
      paramView1 = (CharSequence)((cmo)localObject2).RTn;
      if ((paramView1 != null) && (!kotlin.n.n.ba(paramView1))) {
        break label2000;
      }
      i = 1;
      label1348:
      if (i == 0) {
        break label2006;
      }
      paramView1 = ((cmo)localObject2).RTm;
      label1359:
      ((v)localObject3).lpK = paramView1;
      paramView2.sCU.url = ((String)localObject1);
      if (paramView2.sCU.type != 5) {
        break label2015;
      }
      paramView1 = paramView2.sGV;
      kotlin.g.b.p.j(paramView1, "playIcon");
      paramView1.setVisibility(0);
      paramView2.sGV.setImageResource(d.d.dmx);
      paramView1 = e.sKW;
      e.G(paramView2.sCU.url, paramView2.sCU.type, "");
      label1442:
      if (paramView2.sCU.type != 8) {
        break label2037;
      }
      paramView1 = paramView2.sGW;
      kotlin.g.b.p.j(paramView1, "coverMaskLayout");
      paramView1.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.apR(paramz.getId());
      if (Util.isNullOrNil(paramView2.sCU.lpK)) {
        break label2059;
      }
      paramView1 = paramView2.sGS;
      kotlin.g.b.p.j(paramView1, "coverArea");
      paramView1.setVisibility(0);
      paramView1 = paramView2.sCg.sAc;
      long l = paramz.field_orderFlag;
      localObject1 = paramView2.sCU;
      localObject2 = paramView2.sCU.lpK;
      localObject3 = paramView2.sCR;
      i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
      paramView1.a(l, paramInt, (v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new ag.a.c(paramView2, paramz, paramInt), paramz.sHe + 1, 2.0F);
      AppMethodBeat.o(264553);
      return;
      label1601:
      localObject4 = paramView2.sGQ;
      kotlin.g.b.p.j(localObject4, "titleNeatTv");
      ((MMNeat7extView)localObject4).setVisibility(0);
      localObject4 = paramView2.sGA;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).setVisibility(8);
      }
      localObject4 = paramView2.sDM;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).setVisibility(8);
      }
      paramView2.sGQ.aL((CharSequence)localObject3);
      paramView2.sGx.setPadding(0, 0, 0, 0);
      paramView2.rgA.setPadding(0, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAu, 0, 0);
      localObject3 = paramView2.sGS;
      kotlin.g.b.p.j(localObject3, "coverArea");
      localObject4 = paramView2.sGS;
      kotlin.g.b.p.j(localObject4, "coverArea");
      localObject4 = ((View)localObject4).getLayoutParams();
      if (localObject4 == null)
      {
        paramz = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(264553);
        throw paramz;
      }
      localObject4 = (LinearLayout.LayoutParams)localObject4;
      ((LinearLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.ci.a.fromDPToPix(paramView2.context, 4);
      ((LinearLayout.LayoutParams)localObject4).bottomMargin = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt;
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject3 = paramView2.sDg;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).setPadding(0, 0, 0, com.tencent.mm.ci.a.fromDPToPix(paramView2.context, 14));
      }
      localObject3 = paramView2.sGz;
      if ((localObject3 != null) && (((LinearLayout)localObject3).indexOfChild((View)paramView2.sDN) == -1)) {
        break;
      }
      localObject3 = paramView2.sGz;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).removeView((View)paramView2.sDN);
      }
      localObject3 = paramView2.sDg;
      if (localObject3 == null) {
        break;
      }
      ((LinearLayout)localObject3).addView((View)paramView2.sDN);
      break;
      i = 0;
      break label1023;
      label1916:
      localObject3 = paramView2.sGy;
      if (localObject3 != null) {
        ((MMNeat7extView)localObject3).setVisibility(0);
      }
      localObject3 = paramView2.sGy;
      if (localObject3 == null) {
        break label1047;
      }
      ((MMNeat7extView)localObject3).aL((CharSequence)paramView1.UaC);
      break label1047;
      label1961:
      i = 0;
      break label1127;
      label1967:
      i = 0;
      break label1157;
      label1973:
      i = 0;
      break label1187;
      label1979:
      localObject3 = paramView2.sDN;
      if (localObject3 == null) {
        break label1211;
      }
      ((LinearLayout)localObject3).setVisibility(0);
      break label1211;
      label2000:
      i = 0;
      break label1348;
      label2006:
      paramView1 = ((cmo)localObject2).RTn;
      break label1359;
      label2015:
      paramView1 = paramView2.sGV;
      kotlin.g.b.p.j(paramView1, "playIcon");
      paramView1.setVisibility(8);
      break label1442;
      label2037:
      paramView1 = paramView2.sGW;
      kotlin.g.b.p.j(paramView1, "coverMaskLayout");
      paramView1.setVisibility(8);
    }
    label2059:
    if (paramView2.sCU.type == 5)
    {
      paramView1 = paramView2.sGS;
      kotlin.g.b.p.j(paramView1, "coverArea");
      paramView1.setVisibility(0);
      paramView1 = paramView2.sCg.sAc;
      localObject1 = String.valueOf(d.d.chatting_item_biz_play_icon_bg);
      paramView2 = paramView2.sCR;
      paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
      paramView1.a((String)localObject1, paramView2, paramInt, paramInt, paramz.sHe + 1);
      AppMethodBeat.o(264553);
      return;
    }
    paramz = paramView2.sGS;
    kotlin.g.b.p.j(paramz, "coverArea");
    paramz.setVisibility(8);
    AppMethodBeat.o(264553);
  }
  
  public final void a(z paramz, ae paramae)
  {
    AppMethodBeat.i(264556);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramae, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramae);
    AppMethodBeat.o(264556);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(264557);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(264557);
  }
  
  public final boolean cAC()
  {
    return this.sEz;
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(264554);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(264554);
      return;
    }
    AppMethodBeat.o(264554);
  }
  
  public final View getVideoView()
  {
    return this.sGt.sDp;
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  public final void show()
  {
    AppMethodBeat.i(264555);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(264555);
      return;
    }
    AppMethodBeat.o(264555);
  }
  
  public final int uv()
  {
    return this.style;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "articleContentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getArticleContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setArticleContentTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "articleTopTitleTv", "getArticleTopTitleTv", "setArticleTopTitleTv", "getContext", "()Landroid/content/Context;", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "digestOutLayout", "getDigestOutLayout", "setDigestOutLayout", "digetst", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/ViewGroup;", "getSlotView", "()Landroid/view/ViewGroup;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "titleLayout", "txtJumpLink", "Landroid/widget/TextView;", "viewClose", "Landroid/view/View;", "initFeedBack", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "initUI", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "loadFinish", "", "plugin-brandservice_release"})
  public final class a
    extends aj
  {
    final Context context;
    final v sCU;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
    MMNeat7extView sDM;
    LinearLayout sDN;
    TextView sDO;
    View sDP;
    WeImageView sDQ;
    BizRecTagTextView sDR;
    LinearLayout sDg;
    MMNeat7extView sGA;
    final ViewGroup sGx;
    MMNeat7extView sGy;
    LinearLayout sGz;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(266088);
      this.sCg = paramContext;
      this.context = localObject;
      this$1 = View.inflate(this.context, d.f.stW, null);
      if (ag.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(266088);
        throw ag.this;
      }
      this.sGx = ((ViewGroup)ag.this);
      this.sCU = new v();
      this.rgA = ((ViewGroup)this.sGx.findViewById(d.e.content_ll));
      this.sGQ = ((MMNeat7extView)this.sGx.findViewById(d.e.stf));
      this.sGA = ((MMNeat7extView)this.sGx.findViewById(d.e.stk));
      this.sDM = ((MMNeat7extView)this.sGx.findViewById(d.e.spO));
      this.sGy = ((MMNeat7extView)this.sGx.findViewById(d.e.srH));
      this.sGS = this.sGx.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sGx.findViewById(d.e.cover_iv));
      this.sGV = ((ImageView)this.sGx.findViewById(d.e.play_icon));
      this.sGW = this.sGx.findViewById(d.e.ssl);
      this.sGX = this.sGx.findViewById(d.e.ssk);
      this.sDO = ((TextView)this.sGx.findViewById(d.e.srV));
      this.sDN = ((LinearLayout)this.sGx.findViewById(d.e.srF));
      this.sGz = ((LinearLayout)this.sGx.findViewById(d.e.srG));
      this$1 = this.sGz;
      if (ag.this != null) {
        ag.this.setVisibility(0);
      }
      this.sDP = this.sGx.findViewById(d.e.close_layout);
      this.sDQ = ((WeImageView)this.sGx.findViewById(d.e.close_iv));
      this.sDR = ((BizRecTagTextView)this.sGx.findViewById(d.e.ssF));
      this.sDg = ((LinearLayout)this.sGx.findViewById(d.e.title_layout));
      AppMethodBeat.o(266088);
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(266087);
      kotlin.g.b.p.k(paramv, "item");
      if (paramv.type == 8)
      {
        paramv = this.sGW;
        kotlin.g.b.p.j(paramv, "coverMaskLayout");
        paramv.setVisibility(0);
        if (paramBoolean)
        {
          this.sGX.setBackgroundResource(d.d.dmA);
          AppMethodBeat.o(266087);
          return;
        }
        this.sGX.setBackgroundResource(d.d.mm_trans);
        AppMethodBeat.o(266087);
        return;
      }
      paramv = this.sGW;
      kotlin.g.b.p.j(paramv, "coverMaskLayout");
      paramv.setVisibility(8);
      AppMethodBeat.o(266087);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ag.a parama, z paramz, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(257230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initFeedBack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((h)new h(this.sGC.context, this.sAV, this.sGC.sCg, this.jEN).iM((View)this.sGC.sDQ)).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initFeedBack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257230);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(ag.a parama, z paramz, dur paramdur, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(257303);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = this.sGC;
        localObject = this.sAV;
        dur localdur = this.sDT;
        int i = this.nmX;
        if ((localdur == null) || (((z)localObject).Ven == null) || (localdur.UaW == null) || (localdur.UaX == null)) {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(257303);
          return;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdur);
          paramView.sGB.a((z)localObject, "PAUSE_FOR_RESUME");
          paramView.sCg.szZ.a((z)localObject, i, (int)(System.currentTimeMillis() / 1000L));
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$5", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class c
      implements m.a
    {
      c(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(265940);
        this.sGC.a(this.sGC.sCU, true);
        AppMethodBeat.o(265940);
      }
      
      public final void onStart() {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(ag paramag, z paramz, int paramInt, View paramView1, View paramView2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$2"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(ag paramag, z paramz, int paramInt, View paramView1, View paramView2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ag.a>
  {
    d(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ag
 * JD-Core Version:    0.7.0.1
 */