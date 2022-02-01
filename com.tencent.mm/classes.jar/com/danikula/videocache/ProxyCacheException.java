package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProxyCacheException
  extends Exception
{
  private static final String LIBRARY_VERSION = ". Version: ";
  
  public ProxyCacheException(String paramString)
  {
    super(paramString + ". Version: ");
    AppMethodBeat.i(183611);
    AppMethodBeat.o(183611);
  }
  
  public ProxyCacheException(String paramString, Throwable paramThrowable)
  {
    super(paramString + ". Version: ", paramThrowable);
    AppMethodBeat.i(183612);
    AppMethodBeat.o(183612);
  }
  
  public ProxyCacheException(Throwable paramThrowable)
  {
    super("No explanation error. Version: ", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.ProxyCacheException
 * JD-Core Version:    0.7.0.1
 */