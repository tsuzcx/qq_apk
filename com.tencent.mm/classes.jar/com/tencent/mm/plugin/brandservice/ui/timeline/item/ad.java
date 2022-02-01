package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "viewMultiPicArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedMultiPicArticle;", "viewPic", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewText", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "clearSlotView", "", "clickCard", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "BizRecFeedCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends ab
{
  final Context context;
  private int style;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  private boolean vKj;
  private l vLP;
  private n vLQ;
  private q vLR;
  private o vLS;
  private p vLT;
  private final m[] vLU;
  
  public ad(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(302504);
    this.vHY = paramb;
    this.context = paramContext;
    this.vJW = new LinkedList();
    this.vLP = new l(this.context, this.vHY);
    this.vLQ = new n(this.context, this.vHY);
    this.vLR = new q(this.context, this.vHY);
    this.vLS = new o(this.context, this.vHY);
    this.vLT = new p(this.context, this.vHY);
    this.style = 2001;
    this.vJX = new i((kotlin.g.a.a)new d(this));
    this.vLU = new m[] { (m)this.vLP, (m)this.vLR, (m)this.vLS, (m)this.vLT, (m)this.vLQ };
    AppMethodBeat.o(302504);
  }
  
  public final int TY()
  {
    return this.style;
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302522);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    s.u(paramView2, "parent");
    Object localObject2;
    if (this.vJU == null)
    {
      localObject1 = ((ViewStub)paramView2.findViewById(d.e.viewstub_feed_content)).inflate();
      this.vJV = ((LinearLayout)((View)localObject1).findViewById(d.e.biz_rec_feed_common_slot));
      localObject2 = kotlin.ah.aiuX;
      this.vJU = ((View)localObject1);
    }
    this.vKj = false;
    Object localObject1 = this.vJV;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.vJW).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      this.vJX.et(localObject2);
    }
    this.vJW.clear();
    localObject1 = paramab.acFJ;
    s.s(localObject1, "info.recFeed");
    if (!com.tencent.mm.storage.ah.a((ene)localObject1))
    {
      localObject1 = paramab.acFJ;
      s.s(localObject1, "info.recFeed");
      s.u(localObject1, "<this>");
      localObject1 = ((ene)localObject1).abrC.get(0);
      s.s(localObject1, "this.RecommendItem[0]");
      if (!com.tencent.mm.storage.ah.b((enp)localObject1)) {}
    }
    else
    {
      localObject1 = this.vLU;
      j = localObject1.length;
      i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!((m)localObject2).a((enp)paramab.acFJ.abrC.get(0))) {
          ((m)localObject2).ddv();
        }
        for (;;)
        {
          i += 1;
          break;
          ((m)localObject2).a(paramab, paramInt, paramView1, paramView2);
          if ((localObject2 instanceof q))
          {
            this.vKj = true;
            a(paramab, (ab)this);
            MPVideoPreviewMgr.vXs.p(paramab);
            this.vLR.vJe = ((kotlin.g.a.a)new ad.b(this, paramab));
          }
          else
          {
            this.vLR.vJe = ((kotlin.g.a.a)new ad.c(this, paramab));
          }
        }
      }
      AppMethodBeat.o(302522);
      return;
    }
    paramView1 = this.vLU;
    int j = paramView1.length;
    int i = 0;
    while (i < j)
    {
      paramView1[i].ddv();
      i += 1;
    }
    paramView1 = (a)this.vJX.get();
    paramView2 = this.vJV;
    if (paramView2 != null) {
      paramView2.addView((View)paramView1.vLV);
    }
    this.vJW.add(paramView1);
    paramView2 = paramab.acFJ.abrC.get(0);
    s.s(paramView2, "info.recFeed.RecommendItem[0]");
    paramView1.a(paramab, (enp)paramView2, paramInt);
    AppMethodBeat.o(302522);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, ab paramab1)
  {
    AppMethodBeat.i(302536);
    s.u(paramab, "info");
    s.u(paramab1, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramab1);
    AppMethodBeat.o(302536);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    AppMethodBeat.i(302551);
    s.u(paramab, "info");
    s.u(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramString);
    AppMethodBeat.o(302551);
  }
  
  public final boolean ddC()
  {
    return this.vKj;
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302527);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302527);
  }
  
  public final View getVideoView()
  {
    return this.vLR.vJg;
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  public final void show()
  {
    AppMethodBeat.i(302532);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(302532);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "articleContentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getArticleContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setArticleContentTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "articleTopTitleTv", "getArticleTopTitleTv", "setArticleTopTitleTv", "getContext", "()Landroid/content/Context;", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "digestOutLayout", "getDigestOutLayout", "setDigestOutLayout", "digetst", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/ViewGroup;", "getSlotView", "()Landroid/view/ViewGroup;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "titleLayout", "txtJumpLink", "Landroid/widget/TextView;", "viewClose", "Landroid/view/View;", "initFeedBack", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "initUI", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "loadFinish", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends ag
  {
    private final Context context;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
    final v vIN;
    private LinearLayout vIY;
    private LinearLayout vJA;
    private TextView vJB;
    private View vJC;
    private WeImageView vJD;
    private BizRecTagTextView vJE;
    private MMNeat7extView vJz;
    final ViewGroup vLV;
    private MMNeat7extView vLW;
    private LinearLayout vLX;
    private MMNeat7extView vLY;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(302455);
      this.vHY = paramContext;
      this.context = localObject;
      this$1 = View.inflate(this.context, d.f.biz_time_line_rec_feed_common_slot, null);
      if (ad.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(302455);
        throw ad.this;
      }
      this.vLV = ((ViewGroup)ad.this);
      this.vIN = new v();
      this.uoA = ((ViewGroup)this.vLV.findViewById(d.e.content_ll));
      this.vMn = ((MMNeat7extView)this.vLV.findViewById(d.e.title_neat_tv));
      this.vLY = ((MMNeat7extView)this.vLV.findViewById(d.e.top_title_tv));
      this.vJz = ((MMNeat7extView)this.vLV.findViewById(d.e.artitle_content_tv));
      this.vLW = ((MMNeat7extView)this.vLV.findViewById(d.e.chatting_item_rec_feed_digest_tv));
      this.vMp = this.vLV.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vLV.findViewById(d.e.cover_iv));
      this.vMs = ((ImageView)this.vLV.findViewById(d.e.play_icon));
      this.vMt = this.vLV.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vLV.findViewById(d.e.pic_cover_mask);
      this.vJB = ((TextView)this.vLV.findViewById(d.e.jump_link));
      this.vJA = ((LinearLayout)this.vLV.findViewById(d.e.chatting_item_rec_feed_digest_layout));
      this.vLX = ((LinearLayout)this.vLV.findViewById(d.e.chatting_item_rec_feed_digest_out_layout));
      this$1 = this.vLX;
      if (ad.this != null) {
        ad.this.setVisibility(0);
      }
      this.vJC = this.vLV.findViewById(d.e.close_layout);
      this.vJD = ((WeImageView)this.vLV.findViewById(d.e.close_iv));
      this.vJE = ((BizRecTagTextView)this.vLV.findViewById(d.e.rec_feed_tag));
      this.vIY = ((LinearLayout)this.vLV.findViewById(d.e.title_layout));
      AppMethodBeat.o(302455);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, int paramInt, View paramView)
    {
      AppMethodBeat.i(302460);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramab, "$info");
      ((h)new h(parama.context, paramab, parama.vHY, paramInt).mj((View)parama.vJD)).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302460);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, enp paramenp, int paramInt1, int paramInt2, View paramView)
    {
      AppMethodBeat.i(302471);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.cH(paramenp);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramab, "$info");
      s.u(paramenp, "$itemMsg");
      if ((paramenp == null) || (paramab.acFJ == null) || (paramenp.absd == null) || (paramenp.abse == null)) {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302471);
        return;
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(parama.context, paramab, paramenp);
        ad.this.a(paramab, "PAUSE_FOR_RESUME");
        parama.vHY.vFK.d(paramab, paramInt2, (int)(System.currentTimeMillis() / 1000L));
      }
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(302495);
      s.u(paramv, "item");
      if (paramv.type == 8)
      {
        this.vMt.setVisibility(0);
        if (paramBoolean)
        {
          this.vMu.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
          AppMethodBeat.o(302495);
          return;
        }
        this.vMu.setBackgroundResource(d.d.mm_trans);
        AppMethodBeat.o(302495);
        return;
      }
      this.vMt.setVisibility(8);
      AppMethodBeat.o(302495);
    }
    
    public final void a(final com.tencent.mm.storage.ab paramab, enp paramenp, final int paramInt)
    {
      AppMethodBeat.i(302492);
      s.u(paramab, "info");
      s.u(paramenp, "itemMsg");
      Object localObject1 = (Collection)paramab.acFJ.YVA;
      int i;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label383;
        }
        localObject1 = this.vJC;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      Object localObject2;
      int j;
      for (;;)
      {
        localObject1 = this.vJC;
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(new ad.a..ExternalSyntheticLambda0(this, paramab, paramInt));
        }
        if (com.tencent.mm.cd.a.getScaleSize(this.context) >= 1.125F)
        {
          localObject1 = com.tencent.mm.plugin.bizui.a.a.vtB;
          com.tencent.mm.plugin.bizui.a.a.r((View)this.vJD, com.tencent.mm.cd.a.fromDPToPix(this.context, 31), com.tencent.mm.cd.a.fromDPToPix(this.context, 21));
        }
        localObject2 = paramenp.abse;
        localObject3 = ((ddb)localObject2).hAP;
        localObject1 = ((ddb)localObject2).YQK;
        j = ((ddb)localObject2).nUA;
        if ((!com.tencent.mm.storage.ah.f(paramenp)) || (Util.isNullOrNil(((ddb)localObject2).YQI))) {
          break label1083;
        }
        this.vMn.setVisibility(8);
        localObject4 = this.vMn;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).aZ((CharSequence)"");
        }
        localObject4 = this.vLY;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).setVisibility(0);
        }
        localObject4 = this.vJz;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).setVisibility(0);
        }
        localObject4 = this.vLY;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).aZ((CharSequence)localObject3);
        }
        localObject3 = this.vJz;
        if (localObject3 != null) {
          ((MMNeat7extView)localObject3).aZ((CharSequence)((ddb)localObject2).YQI);
        }
        this.vLV.setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(this.context, 14));
        this.uoA.setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this.context, 4), 0, 0);
        localObject3 = this.vMp;
        localObject4 = this.vMp.getLayoutParams();
        if (localObject4 != null) {
          break label403;
        }
        paramab = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(302492);
        throw paramab;
        i = 0;
        break;
        label383:
        localObject1 = this.vJC;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      label403:
      Object localObject4 = (LinearLayout.LayoutParams)localObject4;
      ((LinearLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 4);
      kotlin.ah localah = kotlin.ah.aiuX;
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      Object localObject3 = this.vIY;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).setPadding(0, 0, 0, 0);
      }
      localObject3 = this.vIY;
      if ((localObject3 != null) && (((LinearLayout)localObject3).indexOfChild((View)this.vJA) == -1))
      {
        i = 1;
        if (i == 0)
        {
          localObject3 = this.vIY;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).removeView((View)this.vJA);
          }
          localObject3 = this.vLX;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).addView((View)this.vJA);
          }
        }
        label539:
        localObject3 = (CharSequence)paramenp.abrE;
        if ((localObject3 != null) && (!kotlin.n.n.bp((CharSequence)localObject3))) {
          break label1363;
        }
        i = 1;
        label564:
        if (i == 0) {
          break label1369;
        }
        localObject3 = this.vLW;
        if (localObject3 != null) {
          ((MMNeat7extView)localObject3).setVisibility(8);
        }
        label587:
        localObject3 = this.vJB;
        if (localObject3 != null)
        {
          localObject4 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(this.vHY.vFK, paramInt, paramab, paramenp, (TextView)localObject3, this.context);
        }
        localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramenp.abrF, this.vJE);
        localObject3 = (CharSequence)paramenp.abrE;
        if ((localObject3 != null) && (!kotlin.n.n.bp((CharSequence)localObject3))) {
          break label1412;
        }
        i = 1;
        label663:
        if (i == 0) {
          break label1430;
        }
        localObject3 = (CharSequence)paramenp.Zxr;
        if ((localObject3 != null) && (!kotlin.n.n.bp((CharSequence)localObject3))) {
          break label1418;
        }
        i = 1;
        label693:
        if (i == 0)
        {
          localObject3 = (CharSequence)paramenp.Zxq;
          if ((localObject3 != null) && (!kotlin.n.n.bp((CharSequence)localObject3))) {
            break label1424;
          }
          i = 1;
          label723:
          if (i == 0) {
            break label1430;
          }
        }
        localObject3 = this.vJA;
        if (localObject3 != null) {
          ((LinearLayout)localObject3).setVisibility(8);
        }
        label746:
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
        {
          localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
          com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vMn);
        }
        this.vLV.setOnClickListener(new ad.a..ExternalSyntheticLambda1(this, paramab, paramenp, paramInt, 0));
        if ((((c)com.tencent.mm.kernel.h.ax(c.class)).GV(1)) && (!Util.isNullOrNil((String)localObject1))) {
          ((c)com.tencent.mm.kernel.h.ax(c.class)).a((String)localObject1, j, 90, new Object[0]);
        }
        this.vIN.type = j;
        localObject3 = this.vIN;
        paramenp = (CharSequence)((ddb)localObject2).YQN;
        if ((paramenp != null) && (!kotlin.n.n.bp(paramenp))) {
          break label1450;
        }
        i = 1;
        label876:
        if (i == 0) {
          break label1456;
        }
        paramenp = ((ddb)localObject2).YQM;
        label887:
        ((v)localObject3).nUM = paramenp;
        this.vIN.url = ((String)localObject1);
        if (this.vIN.type != 5) {
          break label1465;
        }
        this.vMs.setVisibility(0);
        this.vMs.setImageResource(d.d.biz_time_line_item_video_play_selector);
        paramenp = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(this.vIN.url, this.vIN.type, "");
        label955:
        if (this.vIN.type != 8) {
          break label1477;
        }
        this.vMt.setVisibility(0);
      }
      for (;;)
      {
        d.ajs(paramab.getId());
        if (Util.isNullOrNil(this.vIN.nUM)) {
          break label1489;
        }
        this.vMp.setVisibility(0);
        long l = paramab.field_orderFlag;
        paramenp = this.vIN;
        localObject1 = this.vIN.nUM;
        localObject2 = this.vIK;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
        d.a(l, paramInt, paramenp, (String)localObject1, (ImageView)localObject2, i, i, false, (m.a)new a(this, paramab, paramInt), paramab.vMB + 1, 2.0F);
        AppMethodBeat.o(302492);
        return;
        i = 0;
        break;
        label1083:
        this.vMn.setVisibility(0);
        localObject4 = this.vLY;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).setVisibility(8);
        }
        localObject4 = this.vJz;
        if (localObject4 != null) {
          ((MMNeat7extView)localObject4).setVisibility(8);
        }
        this.vMn.aZ((CharSequence)localObject3);
        this.vLV.setPadding(0, 0, 0, 0);
        this.uoA.setPadding(0, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGg, 0, 0);
        localObject3 = this.vMp;
        localObject4 = this.vMp.getLayoutParams();
        if (localObject4 == null)
        {
          paramab = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(302492);
          throw paramab;
        }
        localObject4 = (LinearLayout.LayoutParams)localObject4;
        ((LinearLayout.LayoutParams)localObject4).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 4);
        ((LinearLayout.LayoutParams)localObject4).bottomMargin = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf;
        localah = kotlin.ah.aiuX;
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject3 = this.vIY;
        if (localObject3 != null) {
          ((LinearLayout)localObject3).setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(this.context, 14));
        }
        localObject3 = this.vLX;
        if ((localObject3 != null) && (((LinearLayout)localObject3).indexOfChild((View)this.vJA) == -1)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1361;
          }
          localObject3 = this.vLX;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).removeView((View)this.vJA);
          }
          localObject3 = this.vIY;
          if (localObject3 == null) {
            break;
          }
          ((LinearLayout)localObject3).addView((View)this.vJA);
          break;
        }
        label1361:
        break label539;
        label1363:
        i = 0;
        break label564;
        label1369:
        localObject3 = this.vLW;
        if (localObject3 != null) {
          ((MMNeat7extView)localObject3).setVisibility(0);
        }
        localObject3 = this.vLW;
        if (localObject3 == null) {
          break label587;
        }
        ((MMNeat7extView)localObject3).aZ((CharSequence)paramenp.abrE);
        break label587;
        label1412:
        i = 0;
        break label663;
        label1418:
        i = 0;
        break label693;
        label1424:
        i = 0;
        break label723;
        label1430:
        localObject3 = this.vJA;
        if (localObject3 == null) {
          break label746;
        }
        ((LinearLayout)localObject3).setVisibility(0);
        break label746;
        label1450:
        i = 0;
        break label876;
        label1456:
        paramenp = ((ddb)localObject2).YQN;
        break label887;
        label1465:
        this.vMs.setVisibility(8);
        break label955;
        label1477:
        this.vMt.setVisibility(8);
      }
      label1489:
      if (this.vIN.type == 5)
      {
        this.vMp.setVisibility(0);
        paramenp = d.d.chatting_item_biz_play_icon_bg;
        localObject1 = this.vIK;
        paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
        d.a(paramenp, (ImageView)localObject1, paramInt, paramInt, paramab.vMB + 1);
        AppMethodBeat.o(302492);
        return;
      }
      this.vMp.setVisibility(8);
      AppMethodBeat.o(302492);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$5", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(ad.a parama, com.tencent.mm.storage.ab paramab, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302554);
        this.vMa.a(this.vMa.vIN, true);
        AppMethodBeat.o(302554);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ad.a>
  {
    d(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
 * JD-Core Version:    0.7.0.1
 */