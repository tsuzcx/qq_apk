package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "articleContentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getArticleContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setArticleContentTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "coverContainer", "getCoverContainer", "setCoverContainer", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverMaskIv", "getCoverMaskIv", "setCoverMaskIv", "digest", "getDigest", "setDigest", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "itemView", "getItemView", "setItemView", "pressMask", "getPressMask", "setPressMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "title", "getTitle", "setTitle", "txtJumpLink", "Landroid/widget/TextView;", "viewClose", "viewId", "getViewId", "setViewId", "width", "getWidth", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "getViewContainer", "gone", "inflate", "id", "initFeedBack", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "onAppMsgClick", "recommendItem", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "onInflate", "setCoverHeight", "view", "height", "shouldShowMe", "", "itemMsg", "plugin-brandservice_release"})
public abstract class n
{
  private View amk;
  final Context context;
  private int llp;
  private final v sCU;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  private ImageView sDJ;
  private ImageView sDK;
  private MMNeat7extView sDL;
  private MMNeat7extView sDM;
  private LinearLayout sDN;
  private TextView sDO;
  private View sDP;
  WeImageView sDQ;
  private BizRecTagTextView sDR;
  private View sDd;
  private MMNeat7extView sDe;
  private ImageView sDf;
  kotlin.g.a.a<x> sDm;
  View sDp;
  private int viewId;
  private final int width;
  
  public n(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.sCg = paramb;
    this.width = paramb.sAc.cBA();
    this.llp = -1;
    this.sCU = new v();
  }
  
  public static void X(View paramView, int paramInt)
  {
    if (paramView != null) {}
    for (ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();; localLayoutParams = null)
    {
      if (localLayoutParams != null) {
        localLayoutParams.height = paramInt;
      }
      if (paramView != null) {
        paramView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void a(cmo paramcmo)
  {
    p.k(paramcmo, "itemInfo");
    this.sCU.type = paramcmo.lpx;
    this.sCU.lpK = paramcmo.RTm;
    this.sCU.lqb = paramcmo.RTn;
    this.sCU.url = paramcmo.RTk;
  }
  
  public void a(final z paramz, final int paramInt, final View paramView1, View paramView2)
  {
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    int i = getViewId();
    p.k(paramView2, "parent");
    if (this.amk == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(i)).inflate();
      this.sDd = paramView1.findViewById(d.e.srC);
      this.sDf = ((ImageView)paramView1.findViewById(d.e.dRn));
      this.sDe = ((MMNeat7extView)paramView1.findViewById(d.e.srI));
      this.sDL = ((MMNeat7extView)paramView1.findViewById(d.e.srH));
      this.sDM = ((MMNeat7extView)paramView1.findViewById(d.e.srD));
      this.sDp = paramView2.findViewById(d.e.srE);
      this.sDJ = ((ImageView)paramView1.findViewById(d.e.cover));
      this.sDK = ((ImageView)paramView1.findViewById(d.e.dCV));
      this.sDO = ((TextView)paramView1.findViewById(d.e.srV));
      this.sDN = ((LinearLayout)paramView1.findViewById(d.e.srf));
      this.sDP = paramView1.findViewById(d.e.close_layout);
      this.sDQ = ((WeImageView)paramView1.findViewById(d.e.close_iv));
      this.sDR = ((BizRecTagTextView)paramView1.findViewById(d.e.ssF));
      this.amk = paramView1;
      cAz();
    }
    paramView1 = (Collection)paramz.Ven.RXF;
    if ((paramView1 == null) || (paramView1.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label594;
      }
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      label283:
      paramView1 = this.sDP;
      if (paramView1 != null) {
        paramView1.setOnClickListener((View.OnClickListener)new b(this, paramz, paramInt));
      }
      paramView1 = this.amk;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = (dur)paramz.Ven.UaA.get(0);
      paramView2 = paramView1.UaX;
      p.j(paramView2, "itemMsg.ItemInfo");
      a(paramView2);
      paramView2 = this.sDd;
      if (paramView2 != null) {
        paramView2.setOnClickListener((View.OnClickListener)new a(this, paramz, paramView1, paramInt));
      }
      paramView2 = (CharSequence)paramView1.UaC;
      if ((paramView2 != null) && (!kotlin.n.n.ba(paramView2))) {
        break label611;
      }
      i = 1;
      label413:
      if (i == 0) {
        break label617;
      }
      paramView2 = this.sDL;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      label436:
      paramView2 = this.sDO;
      if (paramView2 != null)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
        localObject = this.sCg.szZ;
        p.j(paramView1, "itemMsg");
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a((f)localObject, paramInt, paramz, paramView1, paramView2, this.context);
      }
      paramz = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView1.UaD, this.sDR);
      paramz = (CharSequence)paramView1.UaC;
      if ((paramz != null) && (!kotlin.n.n.ba(paramz))) {
        break label660;
      }
      paramInt = 1;
      label518:
      if (paramInt == 0) {
        break label675;
      }
      paramz = (CharSequence)paramView1.SwI;
      if ((paramz != null) && (!kotlin.n.n.ba(paramz))) {
        break label665;
      }
      paramInt = 1;
      label543:
      if (paramInt == 0)
      {
        paramz = (CharSequence)paramView1.SwH;
        if ((paramz != null) && (!kotlin.n.n.ba(paramz))) {
          break label670;
        }
        paramInt = 1;
        label568:
        if (paramInt == 0) {
          break label675;
        }
      }
      paramz = this.sDN;
      if (paramz != null) {
        paramz.setVisibility(8);
      }
    }
    label594:
    label611:
    label617:
    do
    {
      return;
      i = 0;
      break;
      paramView1 = this.sDP;
      if (paramView1 == null) {
        break label283;
      }
      paramView1.setVisibility(0);
      break label283;
      i = 0;
      break label413;
      paramView2 = this.sDL;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.sDL;
      if (paramView2 == null) {
        break label436;
      }
      paramView2.aL((CharSequence)paramView1.UaC);
      break label436;
      paramInt = 0;
      break label518;
      paramInt = 0;
      break label543;
      paramInt = 0;
      break label568;
      paramz = this.sDN;
    } while (paramz == null);
    label660:
    label665:
    label670:
    label675:
    paramz.setVisibility(0);
  }
  
  public boolean a(dur paramdur)
  {
    if (paramdur == null) {}
    do
    {
      do
      {
        return false;
      } while (af.b(paramdur));
      paramdur = paramdur.UaX;
    } while ((paramdur == null) || (paramdur.lpx != getItemShowType()));
    return true;
  }
  
  public abstract void cAv();
  
  public final MMNeat7extView cAw()
  {
    return this.sDe;
  }
  
  public final MMNeat7extView cAx()
  {
    return this.sDM;
  }
  
  public final v cAy()
  {
    return this.sCU;
  }
  
  public void cAz() {}
  
  public final ImageView getCoverIv()
  {
    return this.sDJ;
  }
  
  public int getItemShowType()
  {
    return this.llp;
  }
  
  public final View getItemView()
  {
    return this.amk;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(n paramn, z paramz, dur paramdur, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(266364);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.sDS.sDm;
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = this.sDS;
      localObject = paramz;
      dur localdur = paramView1;
      p.j(localdur, "itemMsg");
      p.k(localObject, "info");
      p.k(localdur, "recommendItem");
      if ((((z)localObject).Ven == null) || (localdur.UaW == null) || (localdur.UaX == null)) {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266364);
        return;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.sIu;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdur);
        paramView.sCg.szZ.a((z)localObject, 0, (int)(System.currentTimeMillis() / 1000L));
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265148);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$initFeedBack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ((h)new h(this.sDS.context, paramz, this.sDS.sCg, paramInt).iM((View)this.sDS.sDQ)).show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$initFeedBack$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.n
 * JD-Core Version:    0.7.0.1
 */