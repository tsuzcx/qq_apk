package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.mr;
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
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "nickNameTv", "Landroid/widget/TextView;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "viewClose", "viewHead", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "viewPic", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewText", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "clearSlotView", "", "clickCard", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "BizRecFeedCommonSlot", "plugin-brandservice_release"})
public final class ae
  extends ad
{
  final Context context;
  private TextView kcZ;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  private View pvb;
  private View pve;
  private WeImageView pvf;
  private boolean pvi;
  private m pwV;
  private q pwW;
  private o pwX;
  private p pwY;
  private final n[] pwZ;
  private int style;
  
  public ae(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(195483);
    this.psQ = paramb;
    this.context = paramContext;
    this.puQ = new LinkedList();
    this.pwV = new m(this.context, this.psQ);
    this.pwW = new q(this.context, this.psQ);
    this.pwX = new o(this.context, this.psQ);
    this.pwY = new p(this.context, this.psQ);
    this.style = 2001;
    this.puR = new i((kotlin.g.a.a)new e(this));
    this.pwZ = new n[] { (n)this.pwV, (n)this.pwW, (n)this.pwX, (n)this.pwY };
    AppMethodBeat.o(195483);
  }
  
  public final void a(final z paramz, final int paramInt, final View paramView1, final View paramView2)
  {
    AppMethodBeat.i(195478);
    kotlin.g.b.p.h(paramz, "info");
    kotlin.g.b.p.h(paramView1, "convertView");
    kotlin.g.b.p.h(paramView2, "parent");
    kotlin.g.b.p.h(paramView2, "parent");
    if (this.puO == null)
    {
      localObject1 = ((ViewStub)paramView2.findViewById(2131309877)).inflate();
      this.pve = ((View)localObject1).findViewById(2131298783);
      this.pvf = ((WeImageView)((View)localObject1).findViewById(2131298782));
      this.puP = ((LinearLayout)((View)localObject1).findViewById(2131297501));
      this.pvb = ((View)localObject1).findViewById(2131306602);
      this.kcZ = ((TextView)((View)localObject1).findViewById(2131305433));
      this.puO = ((View)localObject1);
    }
    Object localObject1 = paramz.NQr;
    kotlin.g.b.p.g(localObject1, "info.recFeed");
    Object localObject2 = this.kcZ;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)((dlb)((dkr)localObject1).MOG.get(0)).MOX.oUJ);
    }
    localObject1 = (Collection)((dkr)localObject1).KWr;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label329;
      }
      localObject1 = this.pve;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.pve;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this, paramz, paramInt));
      }
      this.pvi = false;
      localObject1 = this.puP;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).removeAllViews();
      }
      localObject1 = ((Iterable)this.puQ).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        this.puR.da(localObject2);
      }
      i = 0;
      break;
      label329:
      localObject1 = this.pve;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    this.puQ.clear();
    localObject1 = paramz.NQr;
    kotlin.g.b.p.g(localObject1, "info.recFeed");
    if (af.a((dkr)localObject1))
    {
      localObject1 = this.pwZ;
      j = localObject1.length;
      i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (((dlb)paramz.NQr.MOG.get(0)).MOY.iAb != ((n)localObject2).getItemShowType()) {
          ((n)localObject2).cmO();
        }
        for (;;)
        {
          i += 1;
          break;
          ((n)localObject2).a(paramz, paramInt, paramView1, paramView2);
          if ((localObject2 instanceof q))
          {
            this.pvi = true;
            a(paramz, (ad)this);
            localObject2 = MPVideoPreviewMgr.pJz;
            MPVideoPreviewMgr.q(paramz);
            this.pwW.ptZ = ((kotlin.g.a.a)new b(this, paramz, paramInt, paramView1, paramView2));
          }
          else
          {
            this.pwW.ptZ = ((kotlin.g.a.a)new c(this, paramz, paramInt, paramView1, paramView2));
          }
        }
      }
      AppMethodBeat.o(195478);
      return;
    }
    paramView1 = this.pwZ;
    int j = paramView1.length;
    int i = 0;
    while (i < j)
    {
      paramView1[i].cmO();
      i += 1;
    }
    paramView2 = (a)this.puR.get();
    paramView1 = this.puP;
    if (paramView1 != null) {
      paramView1.addView(paramView2.puS);
    }
    this.puQ.add(paramView2);
    paramView1 = paramz.NQr.MOG.get(0);
    kotlin.g.b.p.g(paramView1, "info.recFeed.RecommendItem[0]");
    localObject2 = (dlb)paramView1;
    kotlin.g.b.p.h(paramz, "info");
    kotlin.g.b.p.h(localObject2, "itemMsg");
    paramView1 = ((dlb)localObject2).MOY;
    Object localObject3 = paramView1.Title;
    localObject1 = paramView1.KSj;
    j = paramView1.iAb;
    paramView2.pxp.aw((CharSequence)localObject3);
    localObject3 = (CharSequence)((dlb)localObject2).MOI;
    if ((localObject3 == null) || (kotlin.n.n.aL((CharSequence)localObject3)))
    {
      i = 1;
      if (i == 0) {
        break label1307;
      }
      localObject3 = paramView2.pxa;
      if (localObject3 != null) {
        ((MMNeat7extView)localObject3).setVisibility(8);
      }
      label747:
      paramView2.pxo.setPadding(0, com.tencent.mm.plugin.brandservice.ui.timeline.b.prC, 0, com.tencent.mm.plugin.brandservice.ui.timeline.b.prC * 2);
      localObject3 = paramView2.puA;
      if (localObject3 != null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView2.psQ.pqZ, paramInt, paramz, (dlb)localObject2, (TextView)localObject3, paramView2.context);
      }
      localObject3 = (CharSequence)((dlb)localObject2).MOI;
      if ((localObject3 != null) && (!kotlin.n.n.aL((CharSequence)localObject3))) {
        break label1353;
      }
      i = 1;
      label830:
      if (i == 0) {
        break label1371;
      }
      localObject3 = (CharSequence)((dlb)localObject2).Luk;
      if ((localObject3 != null) && (!kotlin.n.n.aL((CharSequence)localObject3))) {
        break label1359;
      }
      i = 1;
      label861:
      if (i == 0)
      {
        localObject3 = (CharSequence)((dlb)localObject2).Luj;
        if ((localObject3 != null) && (!kotlin.n.n.aL((CharSequence)localObject3))) {
          break label1365;
        }
        i = 1;
        label892:
        if (i == 0) {
          break label1371;
        }
      }
      localObject3 = paramView2.puz;
      if (localObject3 != null) {
        ((LinearLayout)localObject3).setVisibility(8);
      }
      label916:
      localObject3 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
      {
        localObject3 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.c(paramView2.pxp);
      }
      paramView2.puS.setOnClickListener((View.OnClickListener)new ae.a.a(paramView2, paramz, (dlb)localObject2, paramInt));
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil((String)localObject1))) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject1, j, 90, new Object[0]);
      }
      paramView2.ptH.type = j;
      localObject2 = paramView2.ptH;
      localObject3 = (CharSequence)paramView1.KSm;
      if ((localObject3 != null) && (!kotlin.n.n.aL((CharSequence)localObject3))) {
        break label1392;
      }
      i = 1;
      label1056:
      if (i == 0) {
        break label1398;
      }
      paramView1 = paramView1.KSl;
      label1066:
      ((v)localObject2).iAo = paramView1;
      paramView2.ptH.url = ((String)localObject1);
      if (paramView2.ptH.type != 5) {
        break label1406;
      }
      paramView1 = paramView2.pxu;
      kotlin.g.b.p.g(paramView1, "playIcon");
      paramView1.setVisibility(0);
      paramView2.pxu.setImageResource(2131231330);
      paramView1 = e.pAN;
      e.F(paramView2.ptH.url, paramView2.ptH.type, "");
      label1149:
      if (paramView2.ptH.type != 8) {
        break label1428;
      }
      paramView1 = paramView2.pxv;
      kotlin.g.b.p.g(paramView1, "coverMaskLayout");
      paramView1.setVisibility(0);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramView2.ptH.iAo)) {
        break label1450;
      }
      paramView1 = paramView2.pxr;
      kotlin.g.b.p.g(paramView1, "coverArea");
      paramView1.setVisibility(0);
      paramView1 = paramView2.psQ.prc;
      long l = paramz.field_msgId;
      localObject1 = paramView2.ptH;
      localObject2 = paramView2.ptH.iAo;
      localObject3 = paramView2.ptE;
      i = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
      paramView1.a(l, paramInt, (v)localObject1, (String)localObject2, (ImageView)localObject3, i, i, false, (m.a)new ae.a.b(paramView2, paramz, paramInt), paramz.pxD + 1, 2.0F);
      AppMethodBeat.o(195478);
      return;
      i = 0;
      break;
      label1307:
      localObject3 = paramView2.pxa;
      if (localObject3 != null) {
        ((MMNeat7extView)localObject3).setVisibility(0);
      }
      localObject3 = paramView2.pxa;
      if (localObject3 == null) {
        break label747;
      }
      ((MMNeat7extView)localObject3).aw((CharSequence)((dlb)localObject2).MOI);
      break label747;
      label1353:
      i = 0;
      break label830;
      label1359:
      i = 0;
      break label861;
      label1365:
      i = 0;
      break label892;
      label1371:
      localObject3 = paramView2.puz;
      if (localObject3 == null) {
        break label916;
      }
      ((LinearLayout)localObject3).setVisibility(0);
      break label916;
      label1392:
      i = 0;
      break label1056;
      label1398:
      paramView1 = paramView1.KSm;
      break label1066;
      label1406:
      paramView1 = paramView2.pxu;
      kotlin.g.b.p.g(paramView1, "playIcon");
      paramView1.setVisibility(8);
      break label1149;
      label1428:
      paramView1 = paramView2.pxv;
      kotlin.g.b.p.g(paramView1, "coverMaskLayout");
      paramView1.setVisibility(8);
    }
    label1450:
    if (paramView2.ptH.type == 5)
    {
      paramView1 = paramView2.pxr;
      kotlin.g.b.p.g(paramView1, "coverArea");
      paramView1.setVisibility(0);
      paramView1 = paramView2.psQ.prc;
      paramView2 = paramView2.ptE;
      paramInt = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
      paramView1.a("2131231740", paramView2, paramInt, paramInt, paramz.pxD + 1);
      AppMethodBeat.o(195478);
      return;
    }
    paramz = paramView2.pxr;
    kotlin.g.b.p.g(paramz, "coverArea");
    paramz.setVisibility(8);
    AppMethodBeat.o(195478);
  }
  
  public final void a(z paramz, ad paramad)
  {
    AppMethodBeat.i(195481);
    kotlin.g.b.p.h(paramz, "info");
    kotlin.g.b.p.h(paramad, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramad);
    AppMethodBeat.o(195481);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(195482);
    kotlin.g.b.p.h(paramz, "info");
    kotlin.g.b.p.h(paramString, "extra");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramString);
    AppMethodBeat.o(195482);
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195479);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195479);
      return;
    }
    AppMethodBeat.o(195479);
  }
  
  public final boolean cmS()
  {
    return this.pvi;
  }
  
  public final int getStyle()
  {
    return this.style;
  }
  
  public final View getVideoView()
  {
    return this.pwW.puc;
  }
  
  public final void setVideoStatus(int paramInt) {}
  
  public final void show()
  {
    AppMethodBeat.i(195480);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(195480);
      return;
    }
    AppMethodBeat.o(195480);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "digetst", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "txtJumpLink", "Landroid/widget/TextView;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "plugin-brandservice_release"})
  public final class a
    extends ah
  {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    final v ptH;
    TextView puA;
    final View puS;
    LinearLayout puz;
    MMNeat7extView pxa;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(195473);
      this.psQ = paramContext;
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493281, null);
      this.ptH = new v();
      this.pxo = this.puS.findViewById(2131299208);
      this.pxp = ((MMNeat7extView)this.puS.findViewById(2131309237));
      this.pxa = ((MMNeat7extView)this.puS.findViewById(2131298491));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      this.puA = ((TextView)this.puS.findViewById(2131302933));
      this.puz = ((LinearLayout)this.puS.findViewById(2131297575));
      AppMethodBeat.o(195473);
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(195472);
      kotlin.g.b.p.h(paramv, "item");
      if (paramv.type == 8)
      {
        paramv = this.pxv;
        kotlin.g.b.p.g(paramv, "coverMaskLayout");
        paramv.setVisibility(0);
        if (paramBoolean)
        {
          this.pxw.setBackgroundResource(2131231342);
          AppMethodBeat.o(195472);
          return;
        }
        this.pxw.setBackgroundResource(2131233974);
        AppMethodBeat.o(195472);
        return;
      }
      paramv = this.pxv;
      kotlin.g.b.p.g(paramv, "coverMaskLayout");
      paramv.setVisibility(8);
      AppMethodBeat.o(195472);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ae.a parama, z paramz, dlb paramdlb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195470);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = this.pxc;
        localObject = this.prL;
        dlb localdlb = this.puC;
        int i = this.puW;
        if ((localdlb == null) || (((z)localObject).NQr == null) || (localdlb.MOX == null) || (localdlb.MOY == null)) {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195470);
          return;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdlb);
          paramView.pxb.a((z)localObject, "PAUSE_FOR_RESUME");
          paramView.psQ.pqZ.a((z)localObject, i, (int)(System.currentTimeMillis() / 1000L));
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$3", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195471);
        this.pxc.a(this.pxc.ptH, true);
        AppMethodBeat.o(195471);
      }
      
      public final void onStart() {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(ae paramae, z paramz, int paramInt, View paramView1, View paramView2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$2"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(ae paramae, z paramz, int paramInt, View paramView1, View paramView2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ae paramae, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195476);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((h)new h(this.pxb.context, paramz, this.pxb.psQ, paramInt).hw((View)ae.a(this.pxb))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195476);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ae.a>
  {
    e(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ae
 * JD-Core Version:    0.7.0.1
 */