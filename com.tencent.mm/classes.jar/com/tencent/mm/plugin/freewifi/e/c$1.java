package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.model.f.a;
import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c$1
  implements com.tencent.mm.ai.f
{
  public c$1(String paramString, f.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20803);
    int i = this.mLa;
    Object localObject = this.mLb;
    i += 1;
    ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ??? });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Matcher localMatcher;
      synchronized (f.a.bAG())
      {
        if (this.mLc != f.a.bAG().bAE())
        {
          AppMethodBeat.o(20803);
          return;
        }
        f.a.bAG().bAF();
        ??? = ((g)paramm).bAZ();
        paramm = this.mLb;
        paramInt1 = i + 1;
        ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] gets response. schemaUrl=%s", new Object[] { paramm, Integer.valueOf(paramInt1), ??? });
        if (!com.tencent.mm.plugin.freewifi.m.isEmpty(???))
        {
          localMatcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(???);
          if (localMatcher.find()) {
            localObject = localMatcher.group(1);
          }
        }
      }
    }
    if (paramInt2 == -30020) {
      synchronized (f.a.bAG())
      {
        if (this.mLc != f.a.bAG().bAE())
        {
          AppMethodBeat.o(20803);
          return;
        }
        f.a.bAG().bAF();
        AppMethodBeat.o(20803);
        return;
      }
    }
    AppMethodBeat.o(20803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.c.1
 * JD-Core Version:    0.7.0.1
 */