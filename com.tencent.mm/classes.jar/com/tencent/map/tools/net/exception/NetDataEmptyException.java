package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetDataEmptyException
  extends Exception
{
  private static final long serialVersionUID = -5614711401833110994L;
  
  public NetDataEmptyException() {}
  
  public NetDataEmptyException(String paramString)
  {
    super(paramString);
  }
  
  public NetDataEmptyException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(180939);
    initCause(paramThrowable);
    AppMethodBeat.o(180939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetDataEmptyException
 * JD-Core Version:    0.7.0.1
 */