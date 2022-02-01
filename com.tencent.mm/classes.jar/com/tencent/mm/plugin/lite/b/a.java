package com.tencent.mm.plugin.lite.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import io.flutter.a.a.c;
import io.flutter.a.a.j;
import io.flutter.a.a.k;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import java.util.concurrent.LinkedBlockingQueue;

public final class a
{
  boolean bOR;
  k sNT;
  public k.c sNU;
  LinkedBlockingQueue<b> sNV;
  private k.c sNW;
  
  public a(c paramc, String paramString)
  {
    AppMethodBeat.i(146369);
    this.bOR = false;
    this.sNV = new LinkedBlockingQueue();
    this.sNW = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(146368);
        String str = paramAnonymousj.method;
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            if (a.this.sNU != null) {
              a.this.sNU.a(paramAnonymousj, paramAnonymousd);
            }
            AppMethodBeat.o(146368);
            return;
            if (str.equals("onDartChannelReady")) {
              i = 0;
            }
            break;
          }
        }
        ad.d("MicroMsg.AppLite.SafeMethodChannel", "onMethodCall onDartChannelReady");
        paramAnonymousj = a.this;
        paramAnonymousj.bOR = true;
        while (!paramAnonymousj.sNV.isEmpty())
        {
          paramAnonymousd = (b)paramAnonymousj.sNV.poll();
          if (paramAnonymousd != null)
          {
            paramAnonymousj.sNT.a(paramAnonymousd.method, paramAnonymousd.fTP, paramAnonymousd.sNY);
            ad.d("MicroMsg.AppLite.SafeMethodChannel", "notifyChannelReady doing invoke method %s", new Object[] { paramAnonymousd.method });
          }
        }
        AppMethodBeat.o(146368);
      }
    };
    this.sNT = new k(paramc, paramString);
    this.sNT.a(this.sNW);
    AppMethodBeat.o(146369);
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(146370);
    if (this.bOR)
    {
      this.sNT.a(paramString, paramObject, null);
      AppMethodBeat.o(146370);
      return;
    }
    this.sNV.offer(new b(paramString, paramObject, paramd));
    ad.d("MicroMsg.AppLite.SafeMethodChannel", "invokeMethod add invoke method %s", new Object[] { paramString });
    AppMethodBeat.o(146370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.a
 * JD-Core Version:    0.7.0.1
 */