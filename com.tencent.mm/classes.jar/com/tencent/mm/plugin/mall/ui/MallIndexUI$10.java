package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class MallIndexUI$10
  implements View.OnClickListener
{
  MallIndexUI$10(MallIndexUI paramMallIndexUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66107);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicorMsg.MallIndexUI", "click settings btn");
    c.ai(this.KMe.getContext(), "mall", ".ui.MallFunctionSettingsUI");
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.10
 * JD-Core Version:    0.7.0.1
 */