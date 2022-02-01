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
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.ui.MMActivity;

public final class z
  extends i
{
  private View wKc;
  
  public final void doE()
  {
    AppMethodBeat.i(113720);
    if (this.wKc != null) {
      this.wKc.setVisibility(8);
    }
    AppMethodBeat.o(113720);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113719);
    if (this.wKc == null) {
      this.wKc = ((ViewStub)findViewById(a.d.whQ)).inflate();
    }
    aek localaek = this.wJs.dmk().djL().ZbD;
    if (this.wKc != null)
    {
      ((TextView)this.wKc.findViewById(a.d.wlz)).setText(localaek.title);
      ((TextView)this.wKc.findViewById(a.d.wly)).setText(localaek.wsz);
      if ((!this.wJs.dmp().dni()) || (!this.wJs.dmp().dnj())) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((LinearLayout.LayoutParams)((LinearLayout)this.wKc).getLayoutParams()).bottomMargin = 0;
        AppMethodBeat.o(113719);
        return;
      }
      ((LinearLayout.LayoutParams)((LinearLayout)this.wKc).getLayoutParams()).bottomMargin = this.wJs.dmn().getResources().getDimensionPixelSize(a.b.SettingCatalogPadding);
    }
    AppMethodBeat.o(113719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.z
 * JD-Core Version:    0.7.0.1
 */