package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KLogService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class KLogServiceImpl
  implements KLogService
{
  public void debug(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144308);
    ab.d(paramString1, paramString2);
    AppMethodBeat.o(144308);
  }
  
  public void error(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144311);
    ab.e(paramString1, paramString2);
    AppMethodBeat.o(144311);
  }
  
  public void info(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144309);
    ab.i(paramString1, paramString2);
    AppMethodBeat.o(144309);
  }
  
  public void verbose(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144307);
    ab.v(paramString1, paramString2);
    AppMethodBeat.o(144307);
  }
  
  public void warning(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144310);
    ab.w(paramString1, paramString2);
    AppMethodBeat.o(144310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KLogServiceImpl
 * JD-Core Version:    0.7.0.1
 */