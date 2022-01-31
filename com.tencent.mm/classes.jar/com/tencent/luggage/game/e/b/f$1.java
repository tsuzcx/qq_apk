package com.tencent.luggage.game.e.b;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$1
  implements Runnable
{
  f$1(f paramf, r paramr, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(140482);
    if (this.bAW.isRunning())
    {
      localObject = this.bAW.getCurrentPageView();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(140482);
      return;
    }
    Object localObject = a.cf(((v)localObject).hmw);
    if (localObject != null)
    {
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
      int i = localWAGamePanelInputEditText.getMaxLength();
      ab.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
      if (!bo.isNullOrNil(this.bBG)) {
        if (i > 0) {
          if (this.bBG.length() > i)
          {
            localObject = this.bBG.substring(0, i);
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
            label113:
            localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
          }
        }
      }
      for (;;)
      {
        this.bAW.h(this.bAX, this.bBH.j("ok", null));
        AppMethodBeat.o(140482);
        return;
        localObject = this.bBG;
        break;
        localWAGamePanelInputEditText.setText(this.bBG);
        break label113;
        localWAGamePanelInputEditText.setText("");
      }
    }
    this.bAW.h(this.bAX, this.bBH.j("fail", null));
    AppMethodBeat.o(140482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.f.1
 * JD-Core Version:    0.7.0.1
 */