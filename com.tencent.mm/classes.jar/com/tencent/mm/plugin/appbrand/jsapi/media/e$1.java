package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class e$1
  implements a.a
{
  e$1(e parame, c paramc, int paramInt) {}
  
  public final void a(int paramInt, String paramString, ArrayList<MsgFile> paramArrayList)
  {
    AppMethodBeat.i(131215);
    d.i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramInt), paramArrayList });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131215);
      return;
      com.tencent.mm.plugin.appbrand.s.m.aNS().ac(new e.1.1(this, paramArrayList));
      AppMethodBeat.o(131215);
      return;
      if (bo.isNullOrNil(paramString))
      {
        this.hKB.h(this.bAX, this.hRk.j("fail", null));
        AppMethodBeat.o(131215);
        return;
      }
      this.hKB.h(this.bAX, this.hRk.j("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(131215);
      return;
      this.hKB.h(this.bAX, this.hRk.j("fail:cancel", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.e.1
 * JD-Core Version:    0.7.0.1
 */