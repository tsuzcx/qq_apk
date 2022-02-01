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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View olQ;
  
  public final void bTM()
  {
    AppMethodBeat.i(113720);
    if (this.olQ != null) {
      this.olQ.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.olQ == null) {
      this.olQ = ((ViewStub)findViewById(2131297905)).inflate();
    }
    yg localyg = this.olg.bRG().bPj().Eik;
    if (this.olQ != null)
    {
      ((TextView)this.olQ.findViewById(2131305766)).setText(localyg.title);
      ((TextView)this.olQ.findViewById(2131305765)).setText(localyg.nUs);
      if ((!this.olg.bRL().bSG()) || (!this.olg.bRL().bSH())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.olQ).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.olQ).getLayoutParams()).bottomMargin = this.olg.bRJ().getResources().getDimensionPixelSize(2131165558);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */