package com.tencent.mm.plugin.lite;

import android.content.Context;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.c;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c
{
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(146363);
    this.mContext = paramContext;
    setJsExceptionHandler(new h()
    {
      public final void t(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146361);
        ad.e("MicroMsg.J2V8_Console", "Js Exception:" + paramAnonymousString1 + "," + paramAnonymousString2);
        AppMethodBeat.o(146361);
      }
    });
    AppMethodBeat.o(146363);
  }
  
  public final void a(final LuggageNativeViewJni paramLuggageNativeViewJni)
  {
    AppMethodBeat.i(146364);
    q localq = (q)P(q.class);
    if (localq != null) {
      localq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146362);
          v localv = (v)b.this.P(v.class);
          paramLuggageNativeViewJni.s(localv.getIsolatePtr(), localv.LU());
          AppMethodBeat.o(146362);
        }
      });
    }
    AppMethodBeat.o(146364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */