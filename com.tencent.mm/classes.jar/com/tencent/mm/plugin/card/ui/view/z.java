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
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View kBR;
  
  public final void bfq()
  {
    AppMethodBeat.i(88793);
    if (this.kBR != null) {
      this.kBR.setVisibility(8);
    }
    AppMethodBeat.o(88793);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88792);
    if (this.kBR == null) {
      this.kBR = ((ViewStub)findViewById(2131822090)).inflate();
    }
    uo localuo = this.kBh.bdv().bbe().wDY;
    if (this.kBR != null)
    {
      ((TextView)this.kBR.findViewById(2131822383)).setText(localuo.title);
      ((TextView)this.kBR.findViewById(2131822384)).setText(localuo.kmn);
      if ((!this.kBh.bdA().bex()) || (!this.kBh.bdA().bey())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.kBR).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(88792);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.kBR).getLayoutParams()).bottomMargin = this.kBh.bdy().getResources().getDimensionPixelSize(2131427844);
    }
    AppMethodBeat.o(88792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */