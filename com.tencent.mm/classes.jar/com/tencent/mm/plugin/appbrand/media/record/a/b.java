package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class b
{
  private static b lSb = new b()
  {
    public final d Sx(String paramAnonymousString)
    {
      AppMethodBeat.i(146341);
      ad.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[] { paramAnonymousString });
      if (!h.Su(paramAnonymousString))
      {
        AppMethodBeat.o(146341);
        return null;
      }
      if ("aac".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new a();
        AppMethodBeat.o(146341);
        return paramAnonymousString;
      }
      if ("mp3".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new e();
        AppMethodBeat.o(146341);
        return paramAnonymousString;
      }
      if ("wav".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new g();
        AppMethodBeat.o(146341);
        return paramAnonymousString;
      }
      if ("pcm".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new f();
        AppMethodBeat.o(146341);
        return paramAnonymousString;
      }
      AppMethodBeat.o(146341);
      return null;
    }
  };
  
  public static d Sy(String paramString)
  {
    return lSb.Sx(paramString);
  }
  
  public abstract d Sx(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.b
 * JD-Core Version:    0.7.0.1
 */