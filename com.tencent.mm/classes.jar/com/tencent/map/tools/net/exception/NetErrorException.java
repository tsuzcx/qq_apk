package com.tencent.map.tools.net.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class NetErrorException
  extends IOException
{
  public int errorCode;
  public int statusCode;
  
  public NetErrorException() {}
  
  public NetErrorException(String paramString)
  {
    super(paramString);
  }
  
  public NetErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(180940);
    initCause(paramThrowable);
    AppMethodBeat.o(180940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.tools.net.exception.NetErrorException
 * JD-Core Version:    0.7.0.1
 */