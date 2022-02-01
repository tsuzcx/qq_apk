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
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.i;

public class FavCapacityPanel
  extends LinearLayout
{
  private LinearLayout Api;
  public long Apj;
  public TextView Apk;
  public int Apl;
  public long Apm;
  private View.OnClickListener fhU;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.Apl = 0;
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.Apl == 0) {
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
    this.Api = this;
    paramContext = View.inflate(getContext(), q.f.fav_tag_panel_footview, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(q.e.fav_capacity_foot_line);
    View localView = paramContext.findViewById(q.e.fav_capacity_foot_linear);
    this.Apk = ((TextView)paramContext.findViewById(q.e.fav_capacity_foot_desc));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.fhU);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.Api.addView(paramContext, paramAttributeSet);
    this.Apj = (com.tencent.mm.plugin.fav.a.b.dPY() / 1048576L);
    this.Apm = (com.tencent.mm.plugin.fav.a.b.dPZ() / 1048576L);
    paramContext = this.Apk;
    paramAttributeSet = this.Apk.getContext();
    int i = q.i.fav_capacity_info;
    if (this.Apm - this.Apj > 0L) {}
    for (long l = this.Apm - this.Apj;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(i, new Object[] { Long.valueOf(l), Long.valueOf(this.Apj) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */