package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class h
{
  private static volatile h eEo;
  Map<String, BaseIPCService> eEp;
  
  private h()
  {
    AppMethodBeat.i(114042);
    this.eEp = new HashMap();
    AppMethodBeat.o(114042);
  }
  
  public static h PN()
  {
    AppMethodBeat.i(114043);
    if (eEo == null) {}
    try
    {
      if (eEo == null) {
        eEo = new h();
      }
      h localh = eEo;
      AppMethodBeat.o(114043);
      return localh;
    }
    finally
    {
      AppMethodBeat.o(114043);
    }
  }
  
  public final BaseIPCService mc(String paramString)
  {
    AppMethodBeat.i(114044);
    paramString = (BaseIPCService)this.eEp.get(paramString);
    AppMethodBeat.o(114044);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h
 * JD-Core Version:    0.7.0.1
 */