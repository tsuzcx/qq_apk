package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class l
{
  private static volatile l jYS;
  Map<String, BaseIPCService> jYT;
  
  private l()
  {
    AppMethodBeat.i(158752);
    this.jYT = new HashMap();
    AppMethodBeat.o(158752);
  }
  
  public static l aFs()
  {
    AppMethodBeat.i(158753);
    if (jYS == null) {}
    try
    {
      if (jYS == null) {
        jYS = new l();
      }
      l locall = jYS;
      AppMethodBeat.o(158753);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(158753);
    }
  }
  
  public final BaseIPCService Ms(String paramString)
  {
    AppMethodBeat.i(158754);
    paramString = (BaseIPCService)this.jYT.get(paramString);
    AppMethodBeat.o(158754);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.l
 * JD-Core Version:    0.7.0.1
 */