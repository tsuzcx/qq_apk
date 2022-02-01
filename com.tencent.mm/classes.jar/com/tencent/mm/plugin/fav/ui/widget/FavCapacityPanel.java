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
  private View.OnClickListener dec;
  private LinearLayout tmh;
  public long tmi;
  public TextView tmj;
  public int tmk;
  public long tml;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.tmk = 0;
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.tmk == 0) {
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
    this.tmh = this;
    paramContext = View.inflate(getContext(), 2131494149, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(2131300436);
    View localView = paramContext.findViewById(2131300437);
    this.tmj = ((TextView)paramContext.findViewById(2131300434));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.dec);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.tmh.addView(paramContext, paramAttributeSet);
    this.tmi = (com.tencent.mm.plugin.fav.a.b.cUh() / 1048576L);
    this.tml = (com.tencent.mm.plugin.fav.a.b.cUi() / 1048576L);
    paramContext = this.tmj;
    paramAttributeSet = this.tmj.getContext();
    if (this.tml - this.tmi > 0L) {}
    for (long l = this.tml - this.tmi;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(2131759143, new Object[] { Long.valueOf(l), Long.valueOf(this.tmi) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */