package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b
{
  private static b iqe = new b()
  {
    public final d DG(String paramAnonymousString)
    {
      AppMethodBeat.i(140657);
      ab.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[] { paramAnonymousString });
      if (!h.DD(paramAnonymousString))
      {
        AppMethodBeat.o(140657);
        return null;
      }
      if ("aac".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new a();
        AppMethodBeat.o(140657);
        return paramAnonymousString;
      }
      if ("mp3".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new e();
        AppMethodBeat.o(140657);
        return paramAnonymousString;
      }
      if ("wav".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new g();
        AppMethodBeat.o(140657);
        return paramAnonymousString;
      }
      if ("pcm".equalsIgnoreCase(paramAnonymousString))
      {
        paramAnonymousString = new f();
        AppMethodBeat.o(140657);
        return paramAnonymousString;
      }
      AppMethodBeat.o(140657);
      return null;
    }
  };
  
  public static d DH(String paramString)
  {
    return iqe.DG(paramString);
  }
  
  public abstract d DG(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.b
 * JD-Core Version:    0.7.0.1
 */