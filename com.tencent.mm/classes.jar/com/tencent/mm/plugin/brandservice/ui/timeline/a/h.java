package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardNew;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "empty", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getEmpty", "()Landroid/widget/LinearLayout;", "newTipsLayout", "getNewTipsLayout", "topLayout", "getTopLayout", "viewBizContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "viewFinder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardFinder;", "viewOld", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld;", "viewParent", "Landroid/view/View;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "getClientShowType", "style", "getView", "showEmpty", "Companion", "plugin-brandservice_release"})
public final class h
{
  public static final h.a nCb;
  public final c nAv;
  public final e nBU;
  public final f nBV;
  public final i nBW;
  public final View nBX;
  public final LinearLayout nBY;
  public final LinearLayout nBZ;
  private final LinearLayout nCa;
  
  static
  {
    AppMethodBeat.i(198863);
    nCb = new h.a((byte)0);
    AppMethodBeat.o(198863);
  }
  
  public h(Context paramContext, c paramc)
  {
    AppMethodBeat.i(198862);
    this.nAv = paramc;
    this.nBU = new e(this.nAv, paramContext);
    this.nBV = new f(this.nAv, paramContext);
    this.nBW = new i(paramContext, this.nAv);
    paramContext = View.inflate(paramContext, 2131496143, null);
    k.g(paramContext, "View.inflate(context, R.…_line_rec_card_new, null)");
    this.nBX = paramContext;
    this.nBY = ((LinearLayout)this.nBX.findViewById(2131297356));
    this.nBZ = ((LinearLayout)this.nBX.findViewById(2131297346));
    this.nCa = ((LinearLayout)this.nBX.findViewById(2131307154));
    AppMethodBeat.o(198862);
  }
  
  public static int yK(int paramInt)
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
  
  public final void bKi()
  {
    AppMethodBeat.i(198861);
    LinearLayout localLinearLayout = this.nBY;
    k.g(localLinearLayout, "newTipsLayout");
    localLinearLayout.setVisibility(8);
    localLinearLayout = this.nBZ;
    k.g(localLinearLayout, "topLayout");
    localLinearLayout.setVisibility(8);
    this.nBU.hide();
    this.nBV.hide();
    this.nBW.hide();
    localLinearLayout = this.nCa;
    k.g(localLinearLayout, "empty");
    localLinearLayout.setVisibility(0);
    AppMethodBeat.o(198861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.h
 * JD-Core Version:    0.7.0.1
 */