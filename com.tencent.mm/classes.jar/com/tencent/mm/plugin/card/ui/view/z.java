package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View oPl;
  
  public final void bYr()
  {
    AppMethodBeat.i(113720);
    if (this.oPl != null) {
      this.oPl.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.oPl == null) {
      this.oPl = ((ViewStub)findViewById(2131297905)).inflate();
    }
    aaf localaaf = this.oOB.bWl().bTO().FPu;
    if (this.oPl != null)
    {
      ((TextView)this.oPl.findViewById(2131305766)).setText(localaaf.title);
      ((TextView)this.oPl.findViewById(2131305765)).setText(localaaf.oxN);
      if ((!this.oOB.bWq().bXl()) || (!this.oOB.bWq().bXm())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.oPl).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.oPl).getLayoutParams()).bottomMargin = this.oOB.bWo().getResources().getDimensionPixelSize(2131165558);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */