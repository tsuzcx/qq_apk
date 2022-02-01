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
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.model.y;
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
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "headerTagLayout", "Landroid/view/View;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "jumpLinkTv", "Landroid/widget/TextView;", "jumpMore", "recReasonTv", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "topCoverIv", "Landroid/widget/ImageView;", "topLine", "viewClose", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "wowIconsLayout", "clearSlotView", "", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "initJumpContent", "initTopSlot", "setCoverHeight", "view", "height", "show", "BizRecFeedTagCommonSlot", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends ab
{
  final Context context;
  private View plj;
  private int style;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private View vJC;
  private WeImageView vJD;
  private BizRecTagTextView vJE;
  private View vJU;
  private LinearLayout vJV;
  private LinkedList<a> vJW;
  private final i<a> vJX;
  private TextView vMc;
  private View vMd;
  private TextView vMe;
  private View vMf;
  private ImageView vMg;
  private LinearLayout vMh;
  
  public ae(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(302511);
    this.vHY = paramb;
    this.context = paramContext;
    this.vJW = new LinkedList();
    this.style = 2002;
    this.vJX = new i((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(302511);
  }
  
  private static final void a(ae paramae, com.tencent.mm.storage.ab paramab, int paramInt, View paramView)
  {
    AppMethodBeat.i(302517);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramab);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramae, "this$0");
    s.u(paramab, "$info");
    ((h)new h(paramae.context, paramab, paramae.vHY, paramInt).mj((View)paramae.vJD)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302517);
  }
  
  private static final void e(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302525);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(24));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302525);
  }
  
  private static final void f(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302529);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(24));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302529);
  }
  
  private static final void g(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(302535);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$funJump");
    paramb.invoke(Integer.valueOf(25));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302535);
  }
  
  public final int TY()
  {
    return this.style;
  }
  
  public final void a(final com.tencent.mm.storage.ab paramab, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302575);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    s.u(paramView2, "parent");
    if (this.vJU == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.viewstub_feed_tag)).inflate();
      this.vJC = paramView1.findViewById(d.e.close_layout);
      this.vMg = ((ImageView)paramView1.findViewById(d.e.top_cover_iv));
      this.vJE = ((BizRecTagTextView)paramView1.findViewById(d.e.rec_feed_tag));
      this.vMh = ((LinearLayout)paramView1.findViewById(d.e.rec_feed_tag_wow_icon_layout));
      this.plj = paramView1.findViewById(d.e.top_line);
      this.vJD = ((WeImageView)paramView1.findViewById(d.e.close_iv));
      this.vMc = ((TextView)paramView1.findViewById(d.e.jump_link));
      this.vMe = ((TextView)paramView1.findViewById(d.e.rec_feed_tag_rec_reason_tv));
      this.vMf = paramView1.findViewById(d.e.more_layout);
      this.vJV = ((LinearLayout)paramView1.findViewById(d.e.biz_rec_feed_common_slot));
      this.vMd = paramView1.findViewById(d.e.rec_feed_tag_layout);
      paramView2 = kotlin.ah.aiuX;
      this.vJU = paramView1;
    }
    paramView1 = paramab.acFJ;
    s.s(paramView1, "info.recFeed");
    paramView1 = (Collection)paramView1.YVA;
    int i;
    if ((paramView1 == null) || (paramView1.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label395;
      }
      paramView1 = this.vJC;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView1 = this.vJC;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new ae..ExternalSyntheticLambda0(this, paramab, paramInt));
      }
      if (com.tencent.mm.cd.a.getScaleSize(this.context) >= 1.125F)
      {
        paramView1 = com.tencent.mm.plugin.bizui.a.a.vtB;
        com.tencent.mm.plugin.bizui.a.a.r((View)this.vJD, com.tencent.mm.cd.a.fromDPToPix(this.context, 31), com.tencent.mm.cd.a.fromDPToPix(this.context, 21));
      }
      paramView1 = this.vJV;
      if (paramView1 != null) {
        paramView1.removeAllViews();
      }
      paramView1 = ((Iterable)this.vJW).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        this.vJX.et(paramView2);
      }
      i = 0;
      break;
      label395:
      paramView1 = this.vJC;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
    }
    this.vJW.clear();
    paramView1 = paramab.acFJ;
    s.s(paramView1, "info.recFeed");
    Object localObject1;
    if (com.tencent.mm.storage.ah.a(paramView1))
    {
      paramView1 = this.vMf;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.plj;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.vJV;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.vMg;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGb;
      paramView2 = (View)this.vMg;
      if (paramView2 == null)
      {
        paramView1 = null;
        if (paramView1 != null) {
          paramView1.height = j;
        }
        if (paramView2 != null) {
          paramView2.setLayoutParams(paramView1);
        }
        paramView1 = ((enp)paramab.acFJ.abrC.get(0)).abse;
        paramView2 = new v();
        paramView2.type = paramView1.nUA;
        paramView2.nUM = paramView1.YQM;
        paramView2.url = paramView1.YQK;
        localObject1 = (CharSequence)paramView1.YQO;
        if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
          break label858;
        }
        i = 1;
        label618:
        if (i == 0) {
          break label864;
        }
        paramView1 = paramView1.YQM;
        label628:
        d.ajs(paramab.getId());
        i = this.vHY.vFN.deL();
        this.vHY.vFN.a(paramab.field_orderFlag, 0, paramView2, paramView1, this.vMg, i, j, false, (m.a)new c(), false, paramab.vMB);
      }
    }
    for (;;)
    {
      paramView1 = paramab.acFJ;
      paramView2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(this.vMc, paramView1.Zxr, paramView1.Zwh);
      paramView2 = this.vMe;
      if (paramView2 != null) {
        paramView2.setText((CharSequence)paramView1.abrE);
      }
      paramView2 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(this.vMc);
      paramView2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView1.abrF, this.vJE);
      paramab = (kotlin.g.a.b)new b(paramView1, this, paramab, paramInt);
      paramView1 = this.vMc;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new ae..ExternalSyntheticLambda3(paramab));
      }
      paramView1 = this.vMd;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new ae..ExternalSyntheticLambda2(paramab));
      }
      paramView1 = this.vMf;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new ae..ExternalSyntheticLambda1(paramab));
      }
      AppMethodBeat.o(302575);
      return;
      paramView1 = paramView2.getLayoutParams();
      break;
      label858:
      i = 0;
      break label618;
      label864:
      paramView1 = paramView1.YQO;
      break label628;
      paramView1 = this.vMf;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.plj;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.vJV;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.vMg;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.vMh;
      Object localObject2;
      if (paramView1 != null)
      {
        paramView1.removeAllViews();
        paramView1 = (Collection)paramab.acFJ.abrG;
        if ((paramView1 == null) || (paramView1.isEmpty())) {}
        for (i = 1; (i == 0) && (this.vMe != null); i = 0)
        {
          paramView1 = paramab.acFJ.abrG;
          s.s(paramView1, "info.recFeed.FriendSeenHeadImgUrl");
          paramView1 = ((Iterable)paramView1).iterator();
          while (paramView1.hasNext())
          {
            localObject1 = (String)paramView1.next();
            paramView2 = new ImageView(this.context);
            localObject2 = this.vMe;
            s.checkNotNull(localObject2);
            i = (int)(((TextView)localObject2).getTextSize() * 1.2F);
            localObject2 = r.bKe();
            c.a locala = new c.a();
            locala.oKB = d.d.default_avatar;
            locala.nrc = true;
            locala.oKI = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGl;
            locala.oKp = true;
            locala.fullPath = y.bpF((String)localObject1);
            ((com.tencent.mm.modelimage.loader.a)localObject2).a((String)localObject1, paramView2, locala.eG(i, i).bKx());
            localObject1 = new LinearLayout.LayoutParams(i, i);
            ((LinearLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGl;
            localObject2 = kotlin.ah.aiuX;
            paramView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = this.vMh;
            if (localObject1 != null) {
              ((LinearLayout)localObject1).addView((View)paramView2);
            }
          }
        }
      }
      paramView1 = paramab.acFJ.abrC;
      s.s(paramView1, "info.recFeed.RecommendItem");
      paramView1 = ((Iterable)paramView1).iterator();
      i = 0;
      while (paramView1.hasNext())
      {
        paramView2 = paramView1.next();
        if (i < 0) {
          p.kkW();
        }
        paramView2 = (enp)paramView2;
        localObject1 = (a)this.vJX.get();
        localObject2 = this.vJV;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).addView(((a)localObject1).vJY);
        }
        this.vJW.add(localObject1);
        s.s(paramView2, "item");
        ((a)localObject1).a(paramab, paramView2, paramInt, i);
        i += 1;
      }
    }
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(302578);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(302578);
  }
  
  public final void show()
  {
    AppMethodBeat.i(302581);
    View localView = this.vJU;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(302581);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digetstLayout", "Landroid/widget/LinearLayout;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "setLinePaddingMargin", "realIndex", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends ag
  {
    private final Context context;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
    final v vIN;
    final View vJY;
    private LinearLayout vMi;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(302617);
      this.vHY = paramContext;
      this.context = localObject;
      this.vJY = View.inflate(this.context, d.f.biz_time_line_rec_feed_common_tag_slot, null);
      this.vIN = new v();
      this.plj = this.vJY.findViewById(d.e.top_line);
      this.uoA = ((ViewGroup)this.vJY.findViewById(d.e.content_ll));
      this.vMn = ((MMNeat7extView)this.vJY.findViewById(d.e.title_neat_tv));
      this.vMi = ((LinearLayout)this.vJY.findViewById(d.e.chatting_item_rec_feed_digest_layout));
      this.vMp = this.vJY.findViewById(d.e.cover_area);
      this.vIK = ((ImageView)this.vJY.findViewById(d.e.cover_iv));
      this.vMs = ((ImageView)this.vJY.findViewById(d.e.play_icon));
      this.vMt = this.vJY.findViewById(d.e.pic_cover_mask_layout);
      this.vMu = this.vJY.findViewById(d.e.pic_cover_mask);
      AppMethodBeat.o(302617);
    }
    
    private static final void a(a parama, com.tencent.mm.storage.ab paramab, enp paramenp, int paramInt1, int paramInt2, View paramView)
    {
      AppMethodBeat.i(302625);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramab);
      localb.cH(paramenp);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramab, "$info");
      s.u(paramenp, "$itemMsg");
      if ((paramenp == null) || (paramab.acFJ == null) || (paramenp.absd == null) || (paramenp.abse == null)) {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(302625);
        return;
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(parama.context, paramab, paramenp);
        ae.this.a(paramab, "PAUSE_FOR_RESUME");
        parama.vHY.vFK.d(paramab, paramInt2, (int)(System.currentTimeMillis() / 1000L));
      }
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(302640);
      s.u(paramv, "item");
      if (paramv.type == 8)
      {
        this.vMt.setVisibility(0);
        if (paramBoolean)
        {
          this.vMu.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
          AppMethodBeat.o(302640);
          return;
        }
        this.vMu.setBackgroundResource(d.d.mm_trans);
        AppMethodBeat.o(302640);
        return;
      }
      this.vMt.setVisibility(8);
      AppMethodBeat.o(302640);
    }
    
    public final void a(final com.tencent.mm.storage.ab paramab, enp paramenp, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(302637);
      s.u(paramab, "info");
      s.u(paramenp, "itemMsg");
      Object localObject2 = paramenp.abse;
      Object localObject3 = ((ddb)localObject2).hAP;
      Object localObject1 = ((ddb)localObject2).YQK;
      int i = ((ddb)localObject2).nUA;
      this.vMn.aZ((CharSequence)localObject3);
      localObject3 = this.vMi;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).setVisibility(8);
      }
      localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.e(this.vMn);
      }
      this.vJY.setOnClickListener(new ae.a..ExternalSyntheticLambda0(this, paramab, paramenp, paramInt1, paramInt2));
      if ((((c)com.tencent.mm.kernel.h.ax(c.class)).GV(1)) && (!Util.isNullOrNil((String)localObject1))) {
        ((c)com.tencent.mm.kernel.h.ax(c.class)).a((String)localObject1, i, 90, new Object[0]);
      }
      this.vIN.type = i;
      localObject3 = this.vIN;
      paramenp = (CharSequence)((ddb)localObject2).YQN;
      if ((paramenp == null) || (n.bp(paramenp)))
      {
        i = 1;
        if (i == 0) {
          break label463;
        }
        paramenp = ((ddb)localObject2).YQM;
        label219:
        ((v)localObject3).nUM = paramenp;
        this.vIN.url = ((String)localObject1);
        if (this.vIN.type != 5) {
          break label472;
        }
        this.vMs.setVisibility(0);
        this.vMs.setImageResource(d.d.biz_time_line_item_video_play_selector);
        paramenp = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(this.vIN.url, this.vIN.type, "");
        label287:
        if (this.vIN.type != 8) {
          break label484;
        }
        this.vMt.setVisibility(0);
        label307:
        d.ajs(paramab.getId());
        if (Util.isNullOrNil(this.vIN.nUM)) {
          break label496;
        }
        this.vMp.setVisibility(0);
        long l = paramab.field_orderFlag;
        paramenp = this.vIN;
        localObject1 = this.vIN.nUM;
        localObject2 = this.vIK;
        i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
        d.a(l, paramInt1, paramenp, (String)localObject1, (ImageView)localObject2, i, i, false, (m.a)new a(this, paramab, paramInt1), paramab.vMB + 1, 2.0F);
      }
      for (;;)
      {
        this.plj.setVisibility(0);
        paramab = (m)ae.a.b.vMl;
        if (paramInt2 != 0) {
          break label571;
        }
        paramenp = this.plj;
        s.s(paramenp, "topLine");
        paramab.invoke(paramenp, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGm * 2));
        AppMethodBeat.o(302637);
        return;
        i = 0;
        break;
        label463:
        paramenp = ((ddb)localObject2).YQN;
        break label219;
        label472:
        this.vMs.setVisibility(8);
        break label287;
        label484:
        this.vMt.setVisibility(8);
        break label307;
        label496:
        if (this.vIN.type == 5)
        {
          this.vMp.setVisibility(0);
          paramenp = d.d.chatting_item_biz_play_icon_bg;
          localObject1 = this.vIK;
          paramInt1 = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
          d.a(paramenp, (ImageView)localObject1, paramInt1, paramInt1, paramab.vMB + 1);
        }
        else
        {
          this.vMp.setVisibility(8);
        }
      }
      label571:
      paramenp = this.plj;
      s.s(paramenp, "topLine");
      paramab.invoke(paramenp, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj));
      AppMethodBeat.o(302637);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements m.a
    {
      a(ae.a parama, com.tencent.mm.storage.ab paramab, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(302838);
        this.vMk.a(this.vMk.vIN, true);
        AppMethodBeat.o(302838);
      }
      
      public final void onStart() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "opType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, kotlin.ah>
  {
    b(ene paramene, ae paramae, com.tencent.mm.storage.ab paramab, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initTopSlot$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ae.a>
  {
    d(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ae
 * JD-Core Version:    0.7.0.1
 */