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

public class FavCapacityPanel
  extends LinearLayout
{
  private View.OnClickListener cMV;
  private LinearLayout rEk;
  public long rEl;
  public TextView rEm;
  public int rEn;
  public long rEo;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.rEn = 0;
    this.cMV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.rEn == 0) {
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
    this.rEk = this;
    paramContext = View.inflate(getContext(), 2131493979, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(2131299765);
    View localView = paramContext.findViewById(2131299766);
    this.rEm = ((TextView)paramContext.findViewById(2131299763));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.cMV);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.rEk.addView(paramContext, paramAttributeSet);
    this.rEl = (com.tencent.mm.plugin.fav.a.b.cuD() / 1048576L);
    this.rEo = (com.tencent.mm.plugin.fav.a.b.cuE() / 1048576L);
    paramContext = this.rEm;
    paramAttributeSet = this.rEm.getContext();
    if (this.rEo - this.rEl > 0L) {}
    for (long l = this.rEo - this.rEl;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(this.rEl) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */