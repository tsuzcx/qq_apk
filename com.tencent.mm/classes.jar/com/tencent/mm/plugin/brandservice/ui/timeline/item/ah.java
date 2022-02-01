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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.model.w;
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
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "headerTagLayout", "Landroid/view/View;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "jumpLinkTv", "Landroid/widget/TextView;", "jumpMore", "recReasonTv", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "topCoverIv", "Landroid/widget/ImageView;", "topLine", "viewClose", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "wowIconsLayout", "clearSlotView", "", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "initJumpContent", "initTopSlot", "setCoverHeight", "view", "height", "show", "BizRecFeedTagCommonSlot", "plugin-brandservice_release"})
public final class ah
  extends ae
{
  final Context context;
  private View mrE;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private View sDP;
  private WeImageView sDQ;
  private BizRecTagTextView sDR;
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  private TextView sGF;
  private View sGG;
  private TextView sGH;
  private View sGI;
  private ImageView sGJ;
  private LinearLayout sGK;
  private int style;
  
  public ah(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(266018);
    this.sCg = paramb;
    this.context = paramContext;
    this.sEk = new LinkedList();
    this.style = 2002;
    this.sEl = new i((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(266018);
  }
  
  public final void a(final z paramz, final int paramInt, final View paramView1, View paramView2)
  {
    AppMethodBeat.i(266015);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    p.k(paramView2, "parent");
    if (this.sEi == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(d.e.stt)).inflate();
      this.sDP = paramView1.findViewById(d.e.close_layout);
      this.sGJ = ((ImageView)paramView1.findViewById(d.e.stj));
      this.sDR = ((BizRecTagTextView)paramView1.findViewById(d.e.ssF));
      this.sGK = ((LinearLayout)paramView1.findViewById(d.e.ssI));
      this.mrE = paramView1.findViewById(d.e.top_line);
      this.sDQ = ((WeImageView)paramView1.findViewById(d.e.close_iv));
      this.sGF = ((TextView)paramView1.findViewById(d.e.srV));
      this.sGH = ((TextView)paramView1.findViewById(d.e.ssH));
      this.sGI = paramView1.findViewById(d.e.more_layout);
      this.sEj = ((LinearLayout)paramView1.findViewById(d.e.sqk));
      this.sGG = paramView1.findViewById(d.e.ssG);
      this.sEi = paramView1;
    }
    paramView1 = paramz.Ven;
    p.j(paramView1, "info.recFeed");
    paramView1 = (Collection)paramView1.RXF;
    int i;
    if ((paramView1 == null) || (paramView1.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label346;
      }
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new b(this, paramz, paramInt));
      }
      paramView1 = this.sEj;
      if (paramView1 != null) {
        paramView1.removeAllViews();
      }
      paramView1 = ((Iterable)this.sEk).iterator();
      while (paramView1.hasNext())
      {
        paramView2 = (a)paramView1.next();
        this.sEl.cX(paramView2);
      }
      i = 0;
      break;
      label346:
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
    }
    this.sEk.clear();
    paramView1 = paramz.Ven;
    p.j(paramView1, "info.recFeed");
    int j;
    Object localObject1;
    if (af.a(paramView1))
    {
      paramView1 = this.sGI;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.mrE;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.sEj;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.sGJ;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAp;
      paramView2 = (View)this.sGJ;
      if (paramView2 != null)
      {
        paramView1 = paramView2.getLayoutParams();
        if (paramView1 != null) {
          paramView1.height = j;
        }
        if (paramView2 != null) {
          paramView2.setLayoutParams(paramView1);
        }
        paramView1 = ((dur)paramz.Ven.UaA.get(0)).UaX;
        paramView2 = new v();
        paramView2.type = paramView1.lpx;
        paramView2.lpK = paramView1.RTm;
        paramView2.url = paramView1.RTk;
        localObject1 = (CharSequence)paramView1.RTo;
        if ((localObject1 != null) && (!n.ba((CharSequence)localObject1))) {
          break label817;
        }
        i = 1;
        label572:
        if (i == 0) {
          break label823;
        }
        paramView1 = paramView1.RTm;
        label582:
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.apR(paramz.getId());
        i = this.sCg.sAc.cBA();
        this.sCg.sAc.a(paramz.field_orderFlag, 0, paramView2, paramView1, this.sGJ, i, j, false, (m.a)new g(), false, paramz.sHe);
      }
    }
    label1803:
    for (;;)
    {
      paramView1 = paramz.Ven;
      paramView2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(this.sGF, paramView1.SwI, paramView1.SvY);
      paramView2 = this.sGH;
      if (paramView2 != null) {
        paramView2.setText((CharSequence)paramView1.UaC);
      }
      paramView2 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.l(this.sGF);
      paramView2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView1.UaD, this.sDR);
      paramz = (kotlin.g.a.b)new f(this, paramView1, paramz, paramInt);
      paramView1 = this.sGF;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new ah.c(paramz));
      }
      paramView1 = this.sGG;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new ah.d(paramz));
      }
      paramView1 = this.sGI;
      if (paramView1 == null) {
        break label2009;
      }
      paramView1.setOnClickListener((View.OnClickListener)new ah.e(paramz));
      AppMethodBeat.o(266015);
      return;
      paramView1 = null;
      break;
      label817:
      i = 0;
      break label572;
      label823:
      paramView1 = paramView1.RTo;
      break label582;
      paramView1 = this.sGI;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.mrE;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.sEj;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = this.sGJ;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      paramView1 = this.sGK;
      Object localObject2;
      if (paramView1 != null)
      {
        paramView1.removeAllViews();
        paramView1 = (Collection)paramz.Ven.UaE;
        if ((paramView1 == null) || (paramView1.isEmpty())) {}
        for (i = 1; (i == 0) && (this.sGH != null); i = 0)
        {
          paramView1 = paramz.Ven.UaE;
          p.j(paramView1, "info.recFeed.FriendSeenHeadImgUrl");
          paramView1 = ((Iterable)paramView1).iterator();
          while (paramView1.hasNext())
          {
            localObject1 = (String)paramView1.next();
            paramView2 = new ImageView(this.context);
            localObject2 = this.sGH;
            if (localObject2 == null) {
              p.iCn();
            }
            i = (int)(((TextView)localObject2).getTextSize() * 1.2F);
            com.tencent.mm.ay.q.bml().a((String)localObject1, paramView2, new c.a().wy(d.d.default_avatar).bmJ().aw(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAz).bmF().Wq(w.bpO((String)localObject1)).dO(i, i).bmL());
            localObject1 = new LinearLayout.LayoutParams(i, i);
            ((LinearLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAz;
            paramView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = this.sGK;
            if (localObject1 != null) {
              ((LinearLayout)localObject1).addView((View)paramView2);
            }
          }
        }
      }
      paramView1 = paramz.Ven.UaA;
      p.j(paramView1, "info.recFeed.RecommendItem");
      paramView1 = (Iterable)paramView1;
      i = 0;
      paramView2 = paramView1.iterator();
      label1170:
      while (paramView2.hasNext())
      {
        paramView1 = paramView2.next();
        j = i + 1;
        if (i < 0) {
          j.iBO();
        }
        Object localObject3 = (dur)paramView1;
        localObject1 = (a)this.sEl.get();
        paramView1 = this.sEj;
        if (paramView1 != null) {
          paramView1.addView(((a)localObject1).sEm);
        }
        this.sEk.add(localObject1);
        p.j(localObject3, "item");
        p.k(paramz, "info");
        p.k(localObject3, "itemMsg");
        paramView1 = ((dur)localObject3).UaX;
        Object localObject4 = paramView1.fwr;
        localObject2 = paramView1.RTk;
        int k = paramView1.lpx;
        ((a)localObject1).sGQ.aL((CharSequence)localObject4);
        localObject4 = ((a)localObject1).sGL;
        if (localObject4 != null) {
          ((LinearLayout)localObject4).setVisibility(8);
        }
        localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
        {
          localObject4 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
          com.tencent.mm.plugin.brandservice.ui.b.d.e(((a)localObject1).sGQ);
        }
        ((a)localObject1).sEm.setOnClickListener((View.OnClickListener)new ah.a.a((a)localObject1, paramz, (dur)localObject3, paramInt, i));
        if ((((c)com.tencent.mm.kernel.h.ae(c.class)).Gw(1)) && (!Util.isNullOrNil((String)localObject2))) {
          ((c)com.tencent.mm.kernel.h.ae(c.class)).a((String)localObject2, k, 90, new Object[0]);
        }
        ((a)localObject1).sCU.type = k;
        localObject3 = ((a)localObject1).sCU;
        localObject4 = (CharSequence)paramView1.RTn;
        if ((localObject4 == null) || (n.ba((CharSequence)localObject4)))
        {
          k = 1;
          label1468:
          if (k == 0) {
            break label1803;
          }
          paramView1 = paramView1.RTm;
          label1478:
          ((v)localObject3).lpK = paramView1;
          ((a)localObject1).sCU.url = ((String)localObject2);
          if (((a)localObject1).sCU.type != 5) {
            break label1811;
          }
          paramView1 = ((a)localObject1).sGV;
          p.j(paramView1, "playIcon");
          paramView1.setVisibility(0);
          ((a)localObject1).sGV.setImageResource(d.d.dmx);
          paramView1 = e.sKW;
          e.G(((a)localObject1).sCU.url, ((a)localObject1).sCU.type, "");
          label1561:
          if (((a)localObject1).sCU.type != 8) {
            break label1833;
          }
          paramView1 = ((a)localObject1).sGW;
          p.j(paramView1, "coverMaskLayout");
          paramView1.setVisibility(0);
          label1592:
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.apR(paramz.getId());
          if (Util.isNullOrNil(((a)localObject1).sCU.lpK)) {
            break label1855;
          }
          paramView1 = ((a)localObject1).sGS;
          p.j(paramView1, "coverArea");
          paramView1.setVisibility(0);
          paramView1 = ((a)localObject1).sCg.sAc;
          long l = paramz.field_orderFlag;
          localObject2 = ((a)localObject1).sCU;
          localObject3 = ((a)localObject1).sCU.lpK;
          localObject4 = ((a)localObject1).sCR;
          k = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
          paramView1.a(l, paramInt, (v)localObject2, (String)localObject3, (ImageView)localObject4, k, k, false, (m.a)new ah.a.b((a)localObject1, paramz, paramInt), paramz.sHe + 1, 2.0F);
        }
        for (;;)
        {
          paramView1 = ((a)localObject1).mrE;
          p.j(paramView1, "topLine");
          paramView1.setVisibility(0);
          paramView1 = (m)ah.a.c.sGO;
          switch (i)
          {
          default: 
            localObject1 = ((a)localObject1).mrE;
            p.j(localObject1, "topLine");
            paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx));
            i = j;
            break label1170;
            k = 0;
            break label1468;
            paramView1 = paramView1.RTn;
            break label1478;
            label1811:
            paramView1 = ((a)localObject1).sGV;
            p.j(paramView1, "playIcon");
            paramView1.setVisibility(8);
            break label1561;
            label1833:
            paramView1 = ((a)localObject1).sGW;
            p.j(paramView1, "coverMaskLayout");
            paramView1.setVisibility(8);
            break label1592;
            label1855:
            if (((a)localObject1).sCU.type == 5)
            {
              paramView1 = ((a)localObject1).sGS;
              p.j(paramView1, "coverArea");
              paramView1.setVisibility(0);
              paramView1 = ((a)localObject1).sCg.sAc;
              localObject2 = String.valueOf(d.d.chatting_item_biz_play_icon_bg);
              localObject3 = ((a)localObject1).sCR;
              k = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
              paramView1.a((String)localObject2, (ImageView)localObject3, k, k, paramz.sHe + 1);
            }
            else
            {
              paramView1 = ((a)localObject1).sGS;
              p.j(paramView1, "coverArea");
              paramView1.setVisibility(8);
            }
            break;
          }
        }
        localObject1 = ((a)localObject1).mrE;
        p.j(localObject1, "topLine");
        paramView1.invoke(localObject1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAA * 2));
        i = j;
      }
    }
    label2009:
    AppMethodBeat.o(266015);
  }
  
  public final void cAv()
  {
    AppMethodBeat.i(266016);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(266016);
      return;
    }
    AppMethodBeat.o(266016);
  }
  
  public final void show()
  {
    AppMethodBeat.i(266017);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(0);
      AppMethodBeat.o(266017);
      return;
    }
    AppMethodBeat.o(266017);
  }
  
  public final int uv()
  {
    return this.style;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digetstLayout", "Landroid/widget/LinearLayout;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", "index", "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "setLinePaddingMargin", "realIndex", "plugin-brandservice_release"})
  public final class a
    extends aj
  {
    final Context context;
    final v sCU;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
    final View sEm;
    LinearLayout sGL;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(266266);
      this.sCg = paramContext;
      this.context = localObject;
      this.sEm = View.inflate(this.context, d.f.stX, null);
      this.sCU = new v();
      this.mrE = this.sEm.findViewById(d.e.top_line);
      this.rgA = ((ViewGroup)this.sEm.findViewById(d.e.content_ll));
      this.sGQ = ((MMNeat7extView)this.sEm.findViewById(d.e.stf));
      this.sGL = ((LinearLayout)this.sEm.findViewById(d.e.srF));
      this.sGS = this.sEm.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sEm.findViewById(d.e.cover_iv));
      this.sGV = ((ImageView)this.sEm.findViewById(d.e.play_icon));
      this.sGW = this.sEm.findViewById(d.e.ssl);
      this.sGX = this.sEm.findViewById(d.e.ssk);
      AppMethodBeat.o(266266);
    }
    
    public final void a(v paramv, boolean paramBoolean)
    {
      AppMethodBeat.i(266263);
      p.k(paramv, "item");
      if (paramv.type == 8)
      {
        paramv = this.sGW;
        p.j(paramv, "coverMaskLayout");
        paramv.setVisibility(0);
        if (paramBoolean)
        {
          this.sGX.setBackgroundResource(d.d.dmA);
          AppMethodBeat.o(266263);
          return;
        }
        this.sGX.setBackgroundResource(d.d.mm_trans);
        AppMethodBeat.o(266263);
        return;
      }
      paramv = this.sGW;
      p.j(paramv, "coverMaskLayout");
      paramv.setVisibility(8);
      AppMethodBeat.o(266263);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(ah.a parama, z paramz, dur paramdur, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(266835);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = this.sGN;
        localObject = this.sAV;
        dur localdur = this.sDT;
        int i = this.nmX;
        if ((localdur == null) || (((z)localObject).Ven == null) || (localdur.UaW == null) || (localdur.UaX == null)) {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266835);
          return;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdur);
          paramView.sGM.a((z)localObject, "PAUSE_FOR_RESUME");
          paramView.sCg.szZ.a((z)localObject, i, (int)(System.currentTimeMillis() / 1000L));
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(266568);
        this.sGN.a(this.sGN.sCU, true);
        AppMethodBeat.o(266568);
      }
      
      public final void onStart() {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ah paramah, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(259671);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ((h)new h(this.sGM.context, paramz, this.sGM.sCg, paramInt).iM((View)ah.a(this.sGM))).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(259671);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "opType", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    f(ah paramah, dug paramdug, z paramz, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initTopSlot$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
  public static final class g
    implements m.a
  {
    public final void onFinish() {}
    
    public final void onStart() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ah.a>
  {
    h(ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
 * JD-Core Version:    0.7.0.1
 */