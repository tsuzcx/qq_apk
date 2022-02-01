package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.content.Intent;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class i$1
  implements e.b
{
  i$1(i parami, c paramc, int paramInt) {}
  
  public final void a(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(163988);
    if (paramInt == -1)
    {
      this.kzs.h(this.cjS, a.a("", 0, new JSONObject()));
      AppMethodBeat.o(163988);
      return;
    }
    this.kzs.h(this.cjS, a.a("", 1, new JSONObject()));
    AppMethodBeat.o(163988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.i.1
 * JD-Core Version:    0.7.0.1
 */