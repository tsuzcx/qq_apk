package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;

public class FavCapacityPanel
  extends LinearLayout
{
  private View.OnClickListener dig;
  private LinearLayout wSF;
  public long wSG;
  public TextView wSH;
  public int wSI;
  public long wSJ;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.wSI = 0;
    this.dig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.wSI == 0) {
          paramAnonymousView.putExtra("key_enter_fav_cleanui_from", 1);
        }
        for (;;)
        {
          com.tencent.mm.plugin.fav.a.b.b(FavCapacityPanel.this.getContext(), ".ui.FavCleanUI", paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107503);
          return;
          paramAnonymousView.putExtra("key_enter_fav_cleanui_from", 2);
        }
      }
    };
    this.wSF = this;
    paramContext = View.inflate(getContext(), s.f.fav_tag_panel_footview, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(s.e.fav_capacity_foot_line);
    View localView = paramContext.findViewById(s.e.fav_capacity_foot_linear);
    this.wSH = ((TextView)paramContext.findViewById(s.e.fav_capacity_foot_desc));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.dig);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.wSF.addView(paramContext, paramAttributeSet);
    this.wSG = (com.tencent.mm.plugin.fav.a.b.djn() / 1048576L);
    this.wSJ = (com.tencent.mm.plugin.fav.a.b.djo() / 1048576L);
    paramContext = this.wSH;
    paramAttributeSet = this.wSH.getContext();
    int i = s.i.fav_capacity_info;
    if (this.wSJ - this.wSG > 0L) {}
    for (long l = this.wSJ - this.wSG;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(this.wSG) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */