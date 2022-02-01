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
import com.tencent.mm.plugin.fav.a.b;

public class FavCapacityPanel
  extends LinearLayout
{
  private View.OnClickListener cEO;
  private LinearLayout qlu;
  public long qlv;
  public TextView qlw;
  public int qlx;
  public long qly;
  
  public FavCapacityPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107504);
    this.qlx = 0;
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107503);
        paramAnonymousView = new Intent();
        if (FavCapacityPanel.this.qlx == 0) {
          paramAnonymousView.putExtra("key_enter_fav_cleanui_from", 1);
        }
        for (;;)
        {
          b.b(FavCapacityPanel.this.getContext(), ".ui.FavCleanUI", paramAnonymousView);
          AppMethodBeat.o(107503);
          return;
          paramAnonymousView.putExtra("key_enter_fav_cleanui_from", 2);
        }
      }
    };
    this.qlu = this;
    paramContext = View.inflate(getContext(), 2131493979, null);
    paramContext.measure(-2, -2);
    paramAttributeSet = paramContext.findViewById(2131299765);
    View localView = paramContext.findViewById(2131299766);
    this.qlw = ((TextView)paramContext.findViewById(2131299763));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAttributeSet.getLayoutParams();
    localLayoutParams.width = paramContext.getMeasuredWidth();
    paramAttributeSet.setLayoutParams(localLayoutParams);
    localView.setOnClickListener(this.cEO);
    paramAttributeSet = new LinearLayout.LayoutParams(0, -2);
    paramAttributeSet.weight = 1.0F;
    this.qlu.addView(paramContext, paramAttributeSet);
    this.qlv = (b.chr() / 1048576L);
    this.qly = (b.chs() / 1048576L);
    paramContext = this.qlw;
    paramAttributeSet = this.qlw.getContext();
    if (this.qly - this.qlv > 0L) {}
    for (long l = this.qly - this.qlv;; l = 0L)
    {
      paramContext.setText(paramAttributeSet.getString(2131758820, new Object[] { Long.valueOf(l), Long.valueOf(this.qlv) }));
      AppMethodBeat.o(107504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel
 * JD-Core Version:    0.7.0.1
 */