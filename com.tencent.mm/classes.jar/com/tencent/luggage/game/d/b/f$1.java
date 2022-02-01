package com.tencent.luggage.game.d.b;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class f$1
  implements Runnable
{
  f$1(f paramf, r paramr, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(130620);
    if (this.cjR.isRunning())
    {
      localObject = this.cjR.getCurrentPageView();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(130620);
      return;
    }
    Object localObject = a.co(((z)localObject).kfr);
    if (localObject != null)
    {
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
      int i = localWAGamePanelInputEditText.getMaxLength();
      ae.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
      if (!bu.isNullOrNil(this.ckK)) {
        if (i > 0) {
          if (this.ckK.length() > i)
          {
            localObject = this.ckK.substring(0, i);
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
            label113:
            localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
          }
        }
      }
      for (;;)
      {
        this.cjR.h(this.cjS, this.ckL.e("ok", null));
        AppMethodBeat.o(130620);
        return;
        localObject = this.ckK;
        break;
        localWAGamePanelInputEditText.setText(this.ckK);
        break label113;
        localWAGamePanelInputEditText.setText("");
      }
    }
    this.cjR.h(this.cjS, this.ckL.e("fail", null));
    AppMethodBeat.o(130620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.f.1
 * JD-Core Version:    0.7.0.1
 */