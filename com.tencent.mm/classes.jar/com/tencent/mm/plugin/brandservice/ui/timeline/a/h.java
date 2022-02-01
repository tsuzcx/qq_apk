package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class h
{
  public static final h.a mZD;
  public final c mXW;
  public final LinearLayout mZA;
  public final LinearLayout mZB;
  private final LinearLayout mZC;
  public final e mZw;
  public final f mZx;
  public final i mZy;
  public final View mZz;
  
  static
  {
    AppMethodBeat.i(193069);
    mZD = new h.a((byte)0);
    AppMethodBeat.o(193069);
  }
  
  public h(Context paramContext, c paramc)
  {
    AppMethodBeat.i(193068);
    this.mXW = paramc;
    this.mZw = new e(this.mXW, paramContext);
    this.mZx = new f(this.mXW, paramContext);
    this.mZy = new i(paramContext, this.mXW);
    paramContext = View.inflate(paramContext, 2131496143, null);
    k.g(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.mZz = paramContext;
    this.mZA = ((LinearLayout)this.mZz.findViewById(2131297356));
    this.mZB = ((LinearLayout)this.mZz.findViewById(2131297346));
    this.mZC = ((LinearLayout)this.mZz.findViewById(2131307154));
    AppMethodBeat.o(193068);
  }
  
  public static int xT(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public final void bCZ()
  {
    AppMethodBeat.i(193067);
    LinearLayout localLinearLayout = this.mZA;
    k.g(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.mZB;
    k.g(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.mZw.hide();
    this.mZx.hide();
    this.mZy.hide();
    localLinearLayout = this.mZC;
    k.g(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(193067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.h
 * JD-Core Version:    0.7.0.1
 */