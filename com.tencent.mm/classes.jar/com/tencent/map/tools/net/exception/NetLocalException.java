package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class NetLocalException
  extends IOException
{
  private static final long serialVersionUID = -7835439581999472641L;
  
  public NetLocalException() {}
  
  public NetLocalException(String paramString)
  {
    super(paramString);
  }
  
  public NetLocalException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(180941);
    initCause(paramThrowable);
    AppMethodBeat.o(180941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetLocalException
 * JD-Core Version:    0.7.0.1
 */