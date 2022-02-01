package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class s
{
  public static final s.a oeK;
  public final b obC;
  public final l oeA;
  public final o oeB;
  public final t oeC;
  public final m oeD;
  public final n oeE;
  public final r oeF;
  public final View oeG;
  public final LinearLayout oeH;
  public final LinearLayout oeI;
  private final LinearLayout oeJ;
  
  static
  {
    AppMethodBeat.i(209808);
    oeK = new s.a((byte)0);
    AppMethodBeat.o(209808);
  }
  
  public s(Context paramContext, b paramb)
  {
    AppMethodBeat.i(209807);
    this.obC = paramb;
    this.oeA = new l(this.obC, paramContext);
    this.oeB = new o(this.obC, paramContext);
    this.oeC = new t(paramContext, this.obC);
    this.oeD = new m(this.obC, paramContext);
    this.oeE = new n(this.obC);
    this.oeF = new r(this.obC, paramContext);
    paramContext = View.inflate(paramContext, 2131496143, null);
    p.g(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.oeG = paramContext;
    this.oeH = ((LinearLayout)this.oeG.findViewById(2131297356));
    this.oeI = ((LinearLayout)this.oeG.findViewById(2131297346));
    this.oeJ = ((LinearLayout)this.oeG.findViewById(2131307154));
    AppMethodBeat.o(209807);
  }
  
  public static int zu(int paramInt)
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
    }
    return 6;
  }
  
  public final void bOK()
  {
    AppMethodBeat.i(209806);
    LinearLayout localLinearLayout = this.oeH;
    p.g(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.oeI;
    p.g(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.oeA.hide();
    this.oeB.hide();
    this.oeC.hide();
    this.oeD.hide();
    this.oeE.hide();
    this.oeF.hide();
    localLinearLayout = this.oeJ;
    p.g(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(209806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.s
 * JD-Core Version:    0.7.0.1
 */