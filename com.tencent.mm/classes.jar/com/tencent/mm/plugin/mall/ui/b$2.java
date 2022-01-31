package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb, int paramInt, MallFunction paramMallFunction) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43136);
    ab.v("MicroMsg.FunctionListAdapter", "on Click");
    if (b.c(this.oyC) != null) {
      b.c(this.oyC).a(this.oyD, this.oyE);
    }
    AppMethodBeat.o(43136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b.2
 * JD-Core Version:    0.7.0.1
 */