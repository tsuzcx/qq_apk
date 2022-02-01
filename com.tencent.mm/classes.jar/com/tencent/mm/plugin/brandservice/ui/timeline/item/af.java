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
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "headerTagLayout", "Landroid/view/View;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "jumpLinkTv", "Landroid/widget/TextView;", "jumpMore", "recReasonTv", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "viewClose", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "clearSlotView", "", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "initJumpContent", "show", "BizRecFeedTagCommonSlot", "plugin-brandservice_release"})
public final class af
  extends ad
{
  final Context context;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  private View pve;
  private WeImageView pvf;
  private TextView pxg;
  private View pxh;
  private TextView pxi;
  private View pxj;
  private int style;
  
  public af(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(195499);
    this.psQ = paramb;
    this.context = paramContext;
    this.puQ = new LinkedList();
    this.style = 2002;
    this.puR = new i((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(195499);
  }
  
  public final void a(final z paramz, final int paramInt, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(195496);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    p.h(paramView2, "parent");
    if (this.puO == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(2131309878)).inflate();
      this.pve = paramView1.findViewById(2131298783);
      this.pvf = ((WeImageView)paramView1.findViewById(2131298782));
      this.pxg = ((TextView)paramView1.findViewById(2131302933));
      this.pxi = ((TextView)paramView1.findViewById(2131306604));
      this.pxj = paramView1.findViewById(2131304888);
      this.puP = ((LinearLayout)paramView1.findViewById(2131297501));
      this.pxh = paramView1.findViewById(2131306603);
      this.puO = paramView1;
    }
    paramView1 = paramz.NQr;
    p.g(paramView1, "info.recFeed");
    paramView1 = (Collection)paramView1.KWr;
    if ((paramView1 == null) || (paramView1.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label285;
      }
      paramView1 = this.pve;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView1 = this.pve;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new b(this, paramz, paramInt));
      }
      paramView1 = this.puP;
      if (paramView1 != null) {
        paramView1.removeAllViews();
      }
      paramView1 = ((Iterable)this.puQ).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        this.puR.da(paramView2);
      }
      i = 0;
      break;
      label285:
      paramView1 = this.pve;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
    }
    this.puQ.clear();
    paramView1 = paramz.NQr.MOG;
    p.g(paramView1, "info.recFeed.RecommendItem");
    paramView1 = (Iterable)paramView1;
    int i = 0;
    paramView2 = paramView1.iterator();
    label339:
    while (paramView2.hasNext())
    {
      paramView1 = paramView2.next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      Object localObject3 = (dlb)paramView1;
      Object localObject1 = (a)this.puR.get();
      paramView1 = this.puP;
      if (paramView1 != null) {
        paramView1.addView(((a)localObject1).puS);
      }
      this.puQ.add(localObject1);
      p.g(localObject3, "item");
      p.h(paramz, "info");
      p.h(localObject3, "itemMsg");
      paramView1 = ((dlb)localObject3).MOY;
      Object localObject4 = paramView1.Title;
      Object localObject2 = paramView1.KSj;
      int k = paramView1.iAb;
      ((a)localObject1).pxp.aw((CharSequence)localObject4);
      localObject4 = ((a)localObject1).pxa;
      if (localObject4 != null) {
        ((MMNeat7extView)localObject4).setVisibility(8);
      }
      ((a)localObject1).pxo.setPadding(0, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, 0, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry);
      localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
      if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
      {
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.c(((a)localObject1).pxp);
      }
      ((a)localObject1).puS.setOnClickListener((View.OnClickListener)new af.a.a((a)localObject1, paramz, (dlb)localObject3, paramInt, i));
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil((String)localObject2))) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject2, k, 90, new Object[0]);
      }
      ((a)localObject1).ptH.type = k;
      localObject3 = ((a)localObject1).ptH;
      localObject4 = (CharSequence)paramView1.KSm;
      if ((localObject4 == null) || (n.aL((CharSequence)localObject4)))
      {
        k = 1;
        if (k == 0) {
          break label979;
        }
        paramView1 = paramView1.KSl;
        ((v)localObject3).iAo = paramView1;
        ((a)localObject1).ptH.url = ((String)localObject2);
        if (((a)localObject1).ptH.type != 5) {
          break label987;
        }
        paramView1 = ((a)localObject1).pxu;
        p.g(paramView1, "playIcon");
        paramView1.setVisibility(0);
        ((a)localObject1).pxu.setImageResource(2131231330);
        paramView1 = e.pAN;
        e.F(((a)localObject1).ptH.url, ((a)localObject1).ptH.type, "");
        label746:
        if (((a)localObject1).ptH.type != 8) {
          break label1009;
        }
        paramView1 = ((a)localObject1).pxv;
        p.g(paramView1, "coverMaskLayout");
        paramView1.setVisibility(0);
        if (Util.isNullOrNil(((a)localObject1).ptH.iAo)) {
          break label1031;
        }
        paramView1 = ((a)localObject1).pxr;
        p.g(paramView1, "coverArea");
        paramView1.setVisibility(0);
        paramView1 = ((a)localObject1).psQ.prc;
        long l = paramz.field_msgId;
        localObject2 = ((a)localObject1).ptH;
        localObject3 = ((a)localObject1).ptH.iAo;
        localObject4 = ((a)localObject1).ptE;
        k = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
        paramView1.a(l, paramInt, (v)localObject2, (String)localObject3, (ImageView)localObject4, k, k, false, (m.a)new af.a.b((a)localObject1, paramz, paramInt), paramz.pxD + 1, 2.0F);
      }
      for (;;)
      {
        paramView1 = ((a)localObject1).jBI;
        p.g(paramView1, "topLine");
        paramView1.setVisibility(0);
        paramView1 = (m)af.a.c.pxm;
        switch (i)
        {
        default: 
          localObject1 = ((a)localObject1).jBI;
          p.g(localObject1, "topLine");
          paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
          i = j;
          break label339;
          k = 0;
          break label653;
          paramView1 = paramView1.KSm;
          break label663;
          label987:
          paramView1 = ((a)localObject1).pxu;
          p.g(paramView1, "playIcon");
          paramView1.setVisibility(8);
          break label746;
          label1009:
          paramView1 = ((a)localObject1).pxv;
          p.g(paramView1, "coverMaskLayout");
          paramView1.setVisibility(8);
          break label777;
          if (((a)localObject1).ptH.type == 5)
          {
            paramView1 = ((a)localObject1).pxr;
            p.g(paramView1, "coverArea");
            paramView1.setVisibility(0);
            paramView1 = ((a)localObject1).psQ.prc;
            localObject2 = ((a)localObject1).ptE;
            k = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
            paramView1.a("2131231740", (ImageView)localObject2, k, k, paramz.pxD + 1);
          }
          else
          {
            paramView1 = ((a)localObject1).pxr;
            p.g(paramView1, "coverArea");
            paramView1.setVisibility(8);
          }
          break;
        }
      }
      localObject1 = ((a)localObject1).jBI;
      p.g(localObject1, "topLine");
      paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC * 2));
      i = j;
    }
    label653:
    label663:
    label979:
    paramView1 = paramz.NQr;
    label777:
    paramView2 = this.pxg;
    label1031:
    if (paramView2 != null) {
      paramView2.setText((CharSequence)paramView1.Luk);
    }
    paramView2 = this.pxi;
    if (paramView2 != null) {
      paramView2.setText((CharSequence)paramView1.MOI);
    }
    paramView2 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
    com.tencent.mm.plugin.brandservice.ui.b.d.i(this.pxg);
    paramz = (kotlin.g.a.b)new f(this, paramView1, paramz, paramInt);
    paramView1 = this.pxg;
    if (paramView1 != null) {
      paramView1.setOnClickListener((View.OnClickListener)new af.c(paramz));
    }
    paramView1 = this.pxh;
    if (paramView1 != null) {
      paramView1.setOnClickListener((View.OnClickListener)new af.d(paramz));
    }
    paramView1 = this.pxj;
    if (paramView1 != null)
    {
      paramView1.setOnClickListener((View.OnClickListener)new af.e(paramz));
      AppMethodBeat.o(195496);
      return;
    }
    AppMethodBeat.o(195496);
  }
  
  public final void cmO()
  {
    AppMethodBeat.i(195497);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195497);
      return;
    }
    AppMethodBeat.o(195497);
  }
  
  public final int getStyle()
  {
    return this.style;
  }
  
  public final void show()
  {
    AppMethodBeat.i(195498);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(195498);
      return;
    }
    AppMethodBeat.o(195498);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digetst", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "setLinePaddingMargin", "realIndex", "plugin-brandservice_release"})
  public final class a
    extends ah
  {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    final v ptH;
    final View puS;
    MMNeat7extView pxa;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(195489);
      this.psQ = paramContext;
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493281, null);
      this.ptH = new v();
      this.jBI = this.puS.findViewById(2131309322);
      this.pxo = this.puS.findViewById(2131299208);
      this.pxp = ((MMNeat7extView)this.puS.findViewById(2131309237));
      this.pxa = ((MMNeat7extView)this.puS.findViewById(2131298491));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      AppMethodBeat.o(195489);
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(195488);
      p.h(paramv, "item");
      if (paramv.type == 8)
      {
        paramv = this.pxv;
        p.g(paramv, "coverMaskLayout");
        paramv.setVisibility(0);
        if (paramBoolean)
        {
          this.pxw.setBackgroundResource(2131231342);
          AppMethodBeat.o(195488);
          return;
        }
        this.pxw.setBackgroundResource(2131233974);
        AppMethodBeat.o(195488);
        return;
      }
      paramv = this.pxv;
      p.g(paramv, "coverMaskLayout");
      paramv.setVisibility(8);
      AppMethodBeat.o(195488);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(af.a parama, z paramz, dlb paramdlb, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195484);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = this.pxl;
        localObject = this.prL;
        dlb localdlb = this.puC;
        int i = this.puW;
        if ((localdlb == null) || (((z)localObject).NQr == null) || (localdlb.MOX == null) || (localdlb.MOY == null)) {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195484);
          return;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdlb);
          paramView.pxk.a((z)localObject, "PAUSE_FOR_RESUME");
          paramView.psQ.pqZ.a((z)localObject, i, (int)(System.currentTimeMillis() / 1000L));
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195485);
        this.pxl.a(this.pxl.ptH, true);
        AppMethodBeat.o(195485);
      }
      
      public final void onStart() {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(af paramaf, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195490);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((h)new h(this.pxk.context, paramz, this.pxk.psQ, paramInt).hw((View)af.a(this.pxk))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195490);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "opType", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    f(af paramaf, dkr paramdkr, z paramz, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<af.a>
  {
    g(af paramaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af
 * JD-Core Version:    0.7.0.1
 */