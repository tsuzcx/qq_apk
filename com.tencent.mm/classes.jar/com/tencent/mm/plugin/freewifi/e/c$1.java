package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.f.a;
import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c$1
  implements com.tencent.mm.ak.f
{
  public c$1(String paramString, f.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, n paramn)
  {
    AppMethodBeat.i(24873);
    int i = this.tyr;
    Object localObject = this.pfw;
    i += 1;
    ae.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Matcher localMatcher;
      synchronized (f.a.cUa())
      {
        if (this.tys != f.a.cUa().cTY())
        {
          AppMethodBeat.o(24873);
          return;
        }
        f.a.cUa().cTZ();
        ??? = ((g)paramn).cUt();
        paramn = this.pfw;
        paramInt1 = i + 1;
        ae.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] gets response. schemaUrl=%s", new Object[] { paramn, Integer.valueOf(paramInt1), ??? });
        if (!m.ef(???))
        {
          localMatcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(???);
          if (localMatcher.find()) {
            localObject = localMatcher.group(1);
          }
        }
      }
    }
    if (paramInt2 == -30020) {
      synchronized (f.a.cUa())
      {
        if (this.tys != f.a.cUa().cTY())
        {
          AppMethodBeat.o(24873);
          return;
        }
        f.a.cUa().cTZ();
        AppMethodBeat.o(24873);
        return;
      }
    }
    AppMethodBeat.o(24873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.c.1
 * JD-Core Version:    0.7.0.1
 */