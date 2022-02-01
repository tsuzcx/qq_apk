package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class j
{
  private static volatile j hnf;
  Map<String, BaseIPCService> hng;
  
  private j()
  {
    AppMethodBeat.i(158752);
    this.hng = new HashMap();
    AppMethodBeat.o(158752);
  }
  
  public static j aya()
  {
    AppMethodBeat.i(158753);
    if (hnf == null) {}
    try
    {
      if (hnf == null) {
        hnf = new j();
      }
      j localj = hnf;
      AppMethodBeat.o(158753);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(158753);
    }
  }
  
  public final BaseIPCService Fs(String paramString)
  {
    AppMethodBeat.i(158754);
    paramString = (BaseIPCService)this.hng.get(paramString);
    AppMethodBeat.o(158754);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.j
 * JD-Core Version:    0.7.0.1
 */