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
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "coverContainer", "getCoverContainer", "setCoverContainer", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverMaskIv", "getCoverMaskIv", "setCoverMaskIv", "digest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "itemView", "getItemView", "setItemView", "pressMask", "getPressMask", "setPressMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "title", "getTitle", "setTitle", "txtJumpLink", "Landroid/widget/TextView;", "viewId", "getViewId", "setViewId", "width", "getWidth", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "getViewContainer", "gone", "inflate", "id", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "onAppMsgClick", "recommendItem", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "onInflate", "setCoverHeight", "view", "height", "plugin-brandservice_release"})
public abstract class n
{
  View aus;
  final Context context;
  private int iwc;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  final v ptH;
  private View ptQ;
  MMNeat7extView ptR;
  ImageView ptS;
  kotlin.g.a.a<x> ptZ;
  private TextView puA;
  View puc;
  ImageView puw;
  private ImageView pux;
  private MMNeat7extView puy;
  private LinearLayout puz;
  private int viewId;
  final int width;
  
  public n(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.psQ = paramb;
    this.width = (com.tencent.mm.cb.a.jn(paramContext) - com.tencent.mm.plugin.brandservice.ui.timeline.b.prw * 2);
    this.iwc = -1;
    this.ptH = new v();
  }
  
  public static void V(View paramView, int paramInt)
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
  
  public void a(cdu paramcdu)
  {
    p.h(paramcdu, "itemInfo");
    this.ptH.type = paramcdu.iAb;
    this.ptH.iAo = paramcdu.KSl;
    this.ptH.iAD = paramcdu.KSm;
    this.ptH.url = paramcdu.KSj;
  }
  
  public void a(final z paramz, final int paramInt, final View paramView1, View paramView2)
  {
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    int i = getViewId();
    p.h(paramView2, "parent");
    if (this.aus == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(i)).inflate();
      this.ptQ = paramView1.findViewById(2131298488);
      this.ptS = ((ImageView)paramView1.findViewById(2131306101));
      this.ptR = ((MMNeat7extView)paramView1.findViewById(2131298493));
      this.puy = ((MMNeat7extView)paramView1.findViewById(2131298491));
      this.puc = paramView2.findViewById(2131298489);
      this.puw = ((ImageView)paramView1.findViewById(2131299277));
      this.pux = ((ImageView)paramView1.findViewById(2131299291));
      this.puA = ((TextView)paramView1.findViewById(2131302933));
      this.puz = ((LinearLayout)paramView1.findViewById(2131297575));
      this.aus = paramView1;
      cmP();
    }
    paramView1 = this.aus;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = (dlb)paramz.NQr.MOG.get(0);
    paramView2 = paramView1.MOY;
    p.g(paramView2, "itemMsg.ItemInfo");
    a(paramView2);
    paramView2 = this.ptQ;
    if (paramView2 != null) {
      paramView2.setOnClickListener((View.OnClickListener)new a(this, paramz, paramView1, paramInt));
    }
    paramView2 = (CharSequence)paramView1.MOI;
    if ((paramView2 == null) || (kotlin.n.n.aL(paramView2)))
    {
      i = 1;
      if (i == 0) {
        break label445;
      }
      paramView2 = this.puy;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      label302:
      paramView2 = this.puA;
      if (paramView2 != null)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
        localObject = this.psQ.pqZ;
        p.g(paramView1, "itemMsg");
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a((f)localObject, paramInt, paramz, paramView1, paramView2, this.context);
      }
      paramz = (CharSequence)paramView1.MOI;
      if ((paramz != null) && (!kotlin.n.n.aL(paramz))) {
        break label488;
      }
      paramInt = 1;
      label369:
      if (paramInt == 0) {
        break label503;
      }
      paramz = (CharSequence)paramView1.Luk;
      if ((paramz != null) && (!kotlin.n.n.aL(paramz))) {
        break label493;
      }
      paramInt = 1;
      label394:
      if (paramInt == 0)
      {
        paramz = (CharSequence)paramView1.Luj;
        if ((paramz != null) && (!kotlin.n.n.aL(paramz))) {
          break label498;
        }
        paramInt = 1;
        label419:
        if (paramInt == 0) {
          break label503;
        }
      }
      paramz = this.puz;
      if (paramz != null) {
        paramz.setVisibility(8);
      }
    }
    label445:
    label488:
    label493:
    label498:
    label503:
    do
    {
      return;
      i = 0;
      break;
      paramView2 = this.puy;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.puy;
      if (paramView2 == null) {
        break label302;
      }
      paramView2.aw((CharSequence)paramView1.MOI);
      break label302;
      paramInt = 0;
      break label369;
      paramInt = 0;
      break label394;
      paramInt = 0;
      break label419;
      paramz = this.puz;
    } while (paramz == null);
    paramz.setVisibility(0);
  }
  
  public abstract void cmO();
  
  public void cmP() {}
  
  public int getItemShowType()
  {
    return this.iwc;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(n paramn, z paramz, dlb paramdlb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195306);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.puB.ptZ;
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = this.puB;
      localObject = paramz;
      dlb localdlb = paramView1;
      p.g(localdlb, "itemMsg");
      p.h(localObject, "info");
      p.h(localdlb, "recommendItem");
      if ((((z)localObject).NQr == null) || (localdlb.MOX == null) || (localdlb.MOY == null)) {
        Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195306);
        return;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView.context, (z)localObject, localdlb);
        paramView.psQ.pqZ.a((z)localObject, 0, (int)(System.currentTimeMillis() / 1000L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.n
 * JD-Core Version:    0.7.0.1
 */