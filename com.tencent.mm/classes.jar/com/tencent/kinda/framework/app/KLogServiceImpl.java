package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KLogService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class KLogServiceImpl
  implements KLogService
{
  public void debug(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18343);
    ac.d(paramString1, paramString2);
    AppMethodBeat.o(18343);
  }
  
  public void error(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18346);
    ac.e(paramString1, paramString2);
    AppMethodBeat.o(18346);
  }
  
  public void info(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18344);
    ac.i(paramString1, paramString2);
    AppMethodBeat.o(18344);
  }
  
  public void verbose(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18342);
    ac.v(paramString1, paramString2);
    AppMethodBeat.o(18342);
  }
  
  public void warning(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18345);
    ac.w(paramString1, paramString2);
    AppMethodBeat.o(18345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KLogServiceImpl
 * JD-Core Version:    0.7.0.1
 */