package com.tencent.luggage.game.d.b;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class g$1
  implements Runnable
{
  g$1(g paramg, y paramy, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(130620);
    if (this.elY.isRunning())
    {
      localObject = this.elY.getCurrentPageView();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(130620);
      return;
    }
    Object localObject = a.cQ(((ad)localObject).getContentView());
    if (localObject != null)
    {
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
      int i = localWAGamePanelInputEditText.getMaxLength();
      Log.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
      if (!Util.isNullOrNil(this.enc)) {
        if (i > 0) {
          if (this.enc.length() > i)
          {
            localObject = this.enc.substring(0, i);
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
            label113:
            localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
          }
        }
      }
      for (;;)
      {
        this.elY.callback(this.elZ, this.ene.ZP("ok"));
        AppMethodBeat.o(130620);
        return;
        localObject = this.enc;
        break;
        localWAGamePanelInputEditText.setText(this.enc);
        break label113;
        localWAGamePanelInputEditText.setText("");
      }
    }
    this.elY.callback(this.elZ, this.ene.ZP("fail"));
    AppMethodBeat.o(130620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.g.1
 * JD-Core Version:    0.7.0.1
 */