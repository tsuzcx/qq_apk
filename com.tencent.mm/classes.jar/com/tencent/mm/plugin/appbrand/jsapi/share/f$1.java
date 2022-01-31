package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

final class f$1
  implements MMActivity.a
{
  f$1(f paramf, MMActivity paramMMActivity, String paramString1, String paramString2, c paramc, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131450);
    if (paramInt1 == 0)
    {
      if (paramInt2 == -1)
      {
        h.bO(this.cae, this.cae.getResources().getString(2131297076));
        f.b(this.val$appId, this.val$path, "", 1, paramInt2);
        ab.i("MicroMsg.JsApiShareTimeline", "result is success");
        this.hxC.h(this.bAX, this.hZM.j("success", null));
        AppMethodBeat.o(131450);
        return;
      }
      ab.i("MicroMsg.JsApiShareTimeline", "result is cancel");
      this.hxC.h(this.bAX, this.hZM.j("cancel", null));
      f.b(this.val$appId, this.val$path, "", 3, paramInt2);
    }
    AppMethodBeat.o(131450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f.1
 * JD-Core Version:    0.7.0.1
 */