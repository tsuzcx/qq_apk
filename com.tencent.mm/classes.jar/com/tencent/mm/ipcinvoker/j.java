package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class j
{
  private static volatile j gxJ;
  Map<String, BaseIPCService> gxK;
  
  private j()
  {
    AppMethodBeat.i(158752);
    this.gxK = new HashMap();
    AppMethodBeat.o(158752);
  }
  
  public static j ahy()
  {
    AppMethodBeat.i(158753);
    if (gxJ == null) {}
    try
    {
      if (gxJ == null) {
        gxJ = new j();
      }
      j localj = gxJ;
      AppMethodBeat.o(158753);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(158753);
    }
  }
  
  public final BaseIPCService wx(String paramString)
  {
    AppMethodBeat.i(158754);
    paramString = (BaseIPCService)this.gxK.get(paramString);
    AppMethodBeat.o(158754);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.j
 * JD-Core Version:    0.7.0.1
 */