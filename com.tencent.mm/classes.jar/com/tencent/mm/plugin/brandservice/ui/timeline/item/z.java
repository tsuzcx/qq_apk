package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "viewSubscribe", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class z
  extends a
{
  public static final z.a pwC;
  public final b psQ;
  public final LinearLayout pwA;
  private final LinearLayout pwB;
  public final s pwr;
  public final v pws;
  public final aa pwt;
  public final t pwu;
  public final u pwv;
  public final y pww;
  public final ac pwx;
  public final View pwy;
  public final LinearLayout pwz;
  
  static
  {
    AppMethodBeat.i(195444);
    pwC = new z.a((byte)0);
    AppMethodBeat.o(195444);
  }
  
  public z(Context paramContext, b paramb)
  {
    AppMethodBeat.i(195443);
    this.psQ = paramb;
    this.pwr = new s(this.psQ, paramContext);
    this.pws = new v(this.psQ, paramContext);
    this.pwt = new aa(paramContext, this.psQ);
    this.pwu = new t(this.psQ, paramContext);
    this.pwv = new u(this.psQ);
    this.pww = new y(this.psQ, paramContext);
    this.pwx = new ac(this.psQ, paramContext);
    paramContext = View.inflate(paramContext, 2131493275, null);
    p.g(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.pwy = paramContext;
    this.pwz = ((LinearLayout)this.pwy.findViewById(2131297567));
    this.pwA = ((LinearLayout)this.pwy.findViewById(2131297557));
    this.pwB = ((LinearLayout)this.pwy.findViewById(2131297487));
    AppMethodBeat.o(195443);
  }
  
  public static int Di(int paramInt)
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
  
  public final void cnd()
  {
    AppMethodBeat.i(195442);
    LinearLayout localLinearLayout = this.pwz;
    p.g(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.pwA;
    p.g(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.pwr.hide();
    this.pws.hide();
    this.pwt.hide();
    this.pwu.hide();
    this.pwv.hide();
    this.pww.hide();
    this.pwx.hide();
    localLinearLayout = this.pwB;
    p.g(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(195442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.z
 * JD-Core Version:    0.7.0.1
 */