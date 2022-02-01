package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View tGD;
  
  public final void cKY()
  {
    AppMethodBeat.i(113720);
    if (this.tGD != null) {
      this.tGD.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.tGD == null) {
      this.tGD = ((ViewStub)findViewById(a.d.tdC)).inflate();
    }
    acg localacg = this.tFT.cIS().cGt().SdJ;
    if (this.tGD != null)
    {
      ((TextView)this.tGD.findViewById(a.d.tgZ)).setText(localacg.title);
      ((TextView)this.tGD.findViewById(a.d.tgY)).setText(localacg.tnY);
      if ((!this.tFT.cIX().cJS()) || (!this.tFT.cIX().cJT())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.tGD).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.tGD).getLayoutParams()).bottomMargin = this.tFT.cIV().getResources().getDimensionPixelSize(a.b.SettingCatalogPadding);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */