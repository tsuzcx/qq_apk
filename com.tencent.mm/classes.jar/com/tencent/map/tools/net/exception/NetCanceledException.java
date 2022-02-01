package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class NetCanceledException
  extends IOException
{
  private static final long serialVersionUID = -7835439581999472741L;
  
  public NetCanceledException() {}
  
  public NetCanceledException(String paramString)
  {
    super(paramString);
  }
  
  public NetCanceledException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(180938);
    initCause(paramThrowable);
    AppMethodBeat.o(180938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetCanceledException
 * JD-Core Version:    0.7.0.1
 */