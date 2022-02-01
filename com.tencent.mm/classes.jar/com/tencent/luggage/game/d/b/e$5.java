package com.tencent.luggage.game.d.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr, boolean paramBoolean, com.tencent.luggage.game.widget.input.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(130615);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/jsapi/keyboard/WAGameJsApiShowKeyboard$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.ckG.ckA.a(this.ckH.getEditableText().toString(), this.cjR);
    this.ckG.cky.a(this.ckH.getEditableText().toString(), this.cjR);
    if (!this.ckE) {
      this.ckI.hide();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/jsapi/keyboard/WAGameJsApiShowKeyboard$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(130615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e.5
 * JD-Core Version:    0.7.0.1
 */