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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View oVN;
  
  public final void bZG()
  {
    AppMethodBeat.i(113720);
    if (this.oVN != null) {
      this.oVN.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.oVN == null) {
      this.oVN = ((ViewStub)findViewById(2131297905)).inflate();
    }
    aai localaai = this.oVd.bXA().bVd().GhT;
    if (this.oVN != null)
    {
      ((TextView)this.oVN.findViewById(2131305766)).setText(localaai.title);
      ((TextView)this.oVN.findViewById(2131305765)).setText(localaai.oEp);
      if ((!this.oVd.bXF().bYA()) || (!this.oVd.bXF().bYB())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.oVN).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.oVN).getLayoutParams()).bottomMargin = this.oVd.bXD().getResources().getDimensionPixelSize(2131165558);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */