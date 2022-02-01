package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BaseBizTimeViewHolder;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewBizContentUnfollow", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "viewBizMultiAccount", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardMultiAccount;", "viewCanvas", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvas;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "viewSubscribe", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends a
{
  public static final x.a vLn;
  public final b vHY;
  public final s vLo;
  public final v vLp;
  public final y vLq;
  public final t vLr;
  public final u vLs;
  public final w vLt;
  public final aa vLu;
  public final View vLv;
  public final LinearLayout vLw;
  public final LinearLayout vLx;
  private final LinearLayout vLy;
  
  static
  {
    AppMethodBeat.i(302714);
    vLn = new x.a((byte)0);
    AppMethodBeat.o(302714);
  }
  
  public x(Context paramContext, b paramb)
  {
    AppMethodBeat.i(302698);
    this.vHY = paramb;
    this.vLo = new s(this.vHY, paramContext);
    this.vLp = new v(this.vHY, paramContext);
    this.vLq = new y(paramContext, this.vHY);
    this.vLr = new t(this.vHY, paramContext);
    this.vLs = new u(this.vHY);
    this.vLt = new w(this.vHY, paramContext);
    this.vLu = new aa(this.vHY, paramContext);
    paramContext = View.inflate(paramContext, d.f.biz_time_line_rec_card_new, null);
    kotlin.g.b.s.s(paramContext, "inflate(context, R.layou…_line_rec_card_new, null)");
    this.vLv = paramContext;
    this.vLw = ((LinearLayout)this.vLv.findViewById(d.e.biz_time_line_new_tips_layout));
    this.vLx = ((LinearLayout)this.vLv.findViewById(d.e.biz_time_line_item_top));
    this.vLy = ((LinearLayout)this.vLv.findViewById(d.e.biz_rec_card_empty));
    AppMethodBeat.o(302698);
  }
  
  public static int Ho(int paramInt)
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
  
  public final void ddT()
  {
    AppMethodBeat.i(302720);
    this.vLw.setVisibility(8);
    this.vLx.setVisibility(8);
    this.vLo.hide();
    this.vLp.hide();
    this.vLq.hide();
    this.vLr.hide();
    this.vLs.hide();
    this.vLt.hide();
    this.vLu.hide();
    this.vLy.setVisibility(0);
    AppMethodBeat.o(302720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x
 * JD-Core Version:    0.7.0.1
 */