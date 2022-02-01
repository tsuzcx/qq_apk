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
  private View.OnClickListener cNE;
  private LinearLayout rMv;
  public long rMw;
  public TextView rMx;
  public int rMy;
  public long rMz;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.rMy = 0;
    this.cNE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.rMy == 0) {
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
    this.rMv = this;
    paramContext = View.inflate(getContext(), 2131493979, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(2131299765);
    View localView = paramContext.findViewById(2131299766);
    this.rMx = ((TextView)paramContext.findViewById(2131299763));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.cNE);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.rMv.addView(paramContext, paramAttributeSet);
    this.rMw = (com.tencent.mm.plugin.fav.a.b.cwe() / 1048576L);
    this.rMz = (com.tencent.mm.plugin.fav.a.b.cwf() / 1048576L);
    paramContext = this.rMx;
    paramAttributeSet = this.rMx.getContext();
    if (this.rMz - this.rMw > 0L) {}
    for (long l = this.rMz - this.rMw;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(this.rMw) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */