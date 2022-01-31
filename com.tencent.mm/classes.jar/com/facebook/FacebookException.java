package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookException
  extends RuntimeException
{
  static final long serialVersionUID = 1L;
  
  public FacebookException() {}
  
  public FacebookException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookException(String paramString, Object... paramVarArgs)
  {
    this(String.format(paramString, paramVarArgs));
    AppMethodBeat.i(71579);
    AppMethodBeat.o(71579);
  }
  
  public FacebookException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public String toString()
  {
    AppMethodBeat.i(71580);
    String str = getMessage();
    AppMethodBeat.o(71580);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.FacebookException
 * JD-Core Version:    0.7.0.1
 */