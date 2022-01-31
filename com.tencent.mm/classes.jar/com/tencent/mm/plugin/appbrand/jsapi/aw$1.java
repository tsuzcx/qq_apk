package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class aw$1
  implements MMActivity.a
{
  aw$1(aw paramaw, r paramr) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130514);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.bAW.h(this.hzc.bxX, this.hzc.j("ok", null));
        ab.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
        AppMethodBeat.o(130514);
        return;
      }
      if (paramInt2 == 0)
      {
        this.bAW.h(this.hzc.bxX, this.hzc.j("cancel", null));
        ab.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
        AppMethodBeat.o(130514);
        return;
      }
      this.bAW.h(this.hzc.bxX, this.hzc.j("fail", null));
      ab.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
    }
    AppMethodBeat.o(130514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aw.1
 * JD-Core Version:    0.7.0.1
 */