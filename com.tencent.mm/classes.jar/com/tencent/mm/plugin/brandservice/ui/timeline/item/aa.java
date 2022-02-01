package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "viewSubscribe", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class aa
  extends a
{
  public static final aa.a sFY;
  public final b sCg;
  public final t sFN;
  public final w sFO;
  public final ab sFP;
  public final u sFQ;
  public final v sFR;
  public final z sFS;
  public final ad sFT;
  public final View sFU;
  public final LinearLayout sFV;
  public final LinearLayout sFW;
  private final LinearLayout sFX;
  
  static
  {
    AppMethodBeat.i(257572);
    sFY = new aa.a((byte)0);
    AppMethodBeat.o(257572);
  }
  
  public aa(Context paramContext, b paramb)
  {
    AppMethodBeat.i(257570);
    this.sCg = paramb;
    this.sFN = new t(this.sCg, paramContext);
    this.sFO = new w(this.sCg, paramContext);
    this.sFP = new ab(paramContext, this.sCg);
    this.sFQ = new u(this.sCg, paramContext);
    this.sFR = new v(this.sCg);
    this.sFS = new z(this.sCg, paramContext);
    this.sFT = new ad(this.sCg, paramContext);
    paramContext = View.inflate(paramContext, d.f.stU, null);
    p.j(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.sFU = paramContext;
    this.sFV = ((LinearLayout)this.sFU.findViewById(d.e.sqY));
    this.sFW = ((LinearLayout)this.sFU.findViewById(d.e.sqO));
    this.sFX = ((LinearLayout)this.sFU.findViewById(d.e.spW));
    AppMethodBeat.o(257570);
  }
  
  public static int GO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 3: 
      return 2;
    case 5: 
      return 3;
    case 101: 
      return 4;
    case 1001: 
      return 5;
    case 102: 
      return 6;
    }
    return 7;
  }
  
  public final void cAP()
  {
    AppMethodBeat.i(257568);
    LinearLayout localLinearLayout = this.sFV;
    p.j(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.sFW;
    p.j(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.sFN.hide();
    this.sFO.hide();
    this.sFP.hide();
    this.sFQ.hide();
    this.sFR.hide();
    this.sFS.hide();
    this.sFT.hide();
    localLinearLayout = this.sFX;
    p.j(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(257568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aa
 * JD-Core Version:    0.7.0.1
 */