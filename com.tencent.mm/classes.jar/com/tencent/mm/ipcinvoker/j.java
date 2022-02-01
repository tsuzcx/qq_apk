package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class j
{
  private static volatile j fZt;
  Map<String, BaseIPCService> fZu;
  
  private j()
  {
    AppMethodBeat.i(158752);
    this.fZu = new HashMap();
    AppMethodBeat.o(158752);
  }
  
  public static j adw()
  {
    AppMethodBeat.i(158753);
    if (fZt == null) {}
    try
    {
      if (fZt == null) {
        fZt = new j();
      }
      j localj = fZt;
      AppMethodBeat.o(158753);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(158753);
    }
  }
  
  public final BaseIPCService qs(String paramString)
  {
    AppMethodBeat.i(158754);
    paramString = (BaseIPCService)this.fZu.get(paramString);
    AppMethodBeat.o(158754);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.j
 * JD-Core Version:    0.7.0.1
 */