package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.p;

final class e$5
  implements View.OnClickListener
{
  e$5(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, p paramp, boolean paramBoolean, a parama) {}
  
  public final void onClick(View paramView)
  {
    this.gcl.gcf.a(this.gcm.getEditableText().toString(), this.gbW);
    this.gcl.gcd.a(this.gcm.getEditableText().toString(), this.gbW);
    if (!this.gcj) {
      this.gcn.hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.e.5
 * JD-Core Version:    0.7.0.1
 */