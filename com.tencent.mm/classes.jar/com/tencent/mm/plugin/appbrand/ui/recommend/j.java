package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.d;

public final class j
{
  public static void b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(49313);
    if ((paramView instanceof LinearLayout))
    {
      paramView = (LinearLayout)paramView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      int i = paramContext.getResources().getDimensionPixelOffset(ba.d.app_brand_recommend_item_card_padding);
      if (localLayoutParams != null)
      {
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.topMargin = i;
        paramView.setLayoutParams(localLayoutParams);
        paramView.invalidate();
        paramView.requestLayout();
      }
    }
    AppMethodBeat.o(49313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.j
 * JD-Core Version:    0.7.0.1
 */