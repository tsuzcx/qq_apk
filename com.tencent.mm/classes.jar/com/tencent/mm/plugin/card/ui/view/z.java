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
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View nIQ;
  
  public final void bMB()
  {
    AppMethodBeat.i(113720);
    if (this.nIQ != null) {
      this.nIQ.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.nIQ == null) {
      this.nIQ = ((ViewStub)findViewById(2131297905)).inflate();
    }
    xo localxo = this.nIg.bKt().bHW().CPz;
    if (this.nIQ != null)
    {
      ((TextView)this.nIQ.findViewById(2131305766)).setText(localxo.title);
      ((TextView)this.nIQ.findViewById(2131305765)).setText(localxo.nrs);
      if ((!this.nIg.bKy().bLt()) || (!this.nIg.bKy().bLu())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.nIQ).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.nIQ).getLayoutParams()).bottomMargin = this.nIg.bKw().getResources().getDimensionPixelSize(2131165558);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */