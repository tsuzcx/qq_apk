package com.tencent.luggage.game.d.b;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class f$1
  implements Runnable
{
  f$1(f paramf, q paramq, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(130620);
    if (this.cjP.isRunning())
    {
      localObject = this.cjP.getCurrentPageView();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(130620);
      return;
    }
    Object localObject = a.co(((aa)localObject).kca);
    if (localObject != null)
    {
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
      int i = localWAGamePanelInputEditText.getMaxLength();
      ad.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
      if (!bt.isNullOrNil(this.ckI)) {
        if (i > 0) {
          if (this.ckI.length() > i)
          {
            localObject = this.ckI.substring(0, i);
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
            label113:
            localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
          }
        }
      }
      for (;;)
      {
        this.cjP.h(this.cjQ, this.ckJ.e("ok", null));
        AppMethodBeat.o(130620);
        return;
        localObject = this.ckI;
        break;
        localWAGamePanelInputEditText.setText(this.ckI);
        break label113;
        localWAGamePanelInputEditText.setText("");
      }
    }
    this.cjP.h(this.cjQ, this.ckJ.e("fail", null));
    AppMethodBeat.o(130620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.f.1
 * JD-Core Version:    0.7.0.1
 */