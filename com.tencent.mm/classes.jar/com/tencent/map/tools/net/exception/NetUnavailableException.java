package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetUnavailableException
  extends NetErrorException
{
  private static final long serialVersionUID = 2783283891376573878L;
  
  public NetUnavailableException() {}
  
  public NetUnavailableException(String paramString)
  {
    super(paramString);
  }
  
  public NetUnavailableException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(172937);
    initCause(paramThrowable);
    AppMethodBeat.o(172937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetUnavailableException
 * JD-Core Version:    0.7.0.1
 */