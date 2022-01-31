package com.facebook.login;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum LoginClient$Result$Code
{
  private final String loggingValue;
  
  static
  {
    AppMethodBeat.i(96806);
    SUCCESS = new Code("SUCCESS", 0, "success");
    CANCEL = new Code("CANCEL", 1, "cancel");
    ERROR = new Code("ERROR", 2, "error");
    $VALUES = new Code[] { SUCCESS, CANCEL, ERROR };
    AppMethodBeat.o(96806);
  }
  
  private LoginClient$Result$Code(String paramString)
  {
    this.loggingValue = paramString;
  }
  
  final String getLoggingValue()
  {
    return this.loggingValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.LoginClient.Result.Code
 * JD-Core Version:    0.7.0.1
 */