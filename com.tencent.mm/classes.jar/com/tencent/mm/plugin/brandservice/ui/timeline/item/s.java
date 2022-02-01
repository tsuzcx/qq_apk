package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "viewSubscribe", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class s
{
  public static final s.a okD;
  public final b ohs;
  public final LinearLayout okA;
  public final LinearLayout okB;
  private final LinearLayout okC;
  public final l oks;
  public final o okt;
  public final t oku;
  public final m okv;
  public final n okw;
  public final r okx;
  public final u oky;
  public final View okz;
  
  static
  {
    AppMethodBeat.i(208784);
    okD = new s.a((byte)0);
    AppMethodBeat.o(208784);
  }
  
  public s(Context paramContext, b paramb)
  {
    AppMethodBeat.i(208783);
    this.ohs = paramb;
    this.oks = new l(this.ohs, paramContext);
    this.okt = new o(this.ohs, paramContext);
    this.oku = new t(paramContext, this.ohs);
    this.okv = new m(this.ohs, paramContext);
    this.okw = new n(this.ohs);
    this.okx = new r(this.ohs, paramContext);
    this.oky = new u(this.ohs, paramContext);
    paramContext = View.inflate(paramContext, 2131496143, null);
    p.g(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.okz = paramContext;
    this.okA = ((LinearLayout)this.okz.findViewById(2131297356));
    this.okB = ((LinearLayout)this.okz.findViewById(2131297346));
    this.okC = ((LinearLayout)this.okz.findViewById(2131307154));
    AppMethodBeat.o(208783);
  }
  
  public static int zD(int paramInt)
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
  
  public final void bPI()
  {
    AppMethodBeat.i(208782);
    LinearLayout localLinearLayout = this.okA;
    p.g(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.okB;
    p.g(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.oks.hide();
    this.okt.hide();
    this.oku.hide();
    this.okv.hide();
    this.okw.hide();
    this.okx.hide();
    this.oky.hide();
    localLinearLayout = this.okC;
    p.g(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(208782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.s
 * JD-Core Version:    0.7.0.1
 */