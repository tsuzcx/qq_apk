package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

final class am$1
  implements MMActivity.a
{
  am$1(am paramam, o paramo) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.gcp.C(this.ggG.bhx, this.ggG.h("ok", null));
        y.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
      }
    }
    else {
      return;
    }
    if (paramInt2 == 0)
    {
      this.gcp.C(this.ggG.bhx, this.ggG.h("cancel", null));
      y.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
      return;
    }
    this.gcp.C(this.ggG.bhx, this.ggG.h("fail", null));
    y.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.am.1
 * JD-Core Version:    0.7.0.1
 */