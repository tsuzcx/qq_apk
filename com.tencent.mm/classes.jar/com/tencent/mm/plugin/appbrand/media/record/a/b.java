package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class b
{
  private static b nee = new b()
  {
    public final d acK(String paramAnonymousString)
    {
      AppMethodBeat.i(146341);
      Log.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[] { paramAnonymousString });
      if (!h.acH(paramAnonymousString))
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
  
  public static d acL(String paramString)
  {
    return nee.acK(paramString);
  }
  
  public abstract d acK(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.b
 * JD-Core Version:    0.7.0.1
 */