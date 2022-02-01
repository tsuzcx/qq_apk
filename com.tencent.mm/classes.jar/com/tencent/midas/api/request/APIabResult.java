package com.tencent.midas.api.request;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APIabResult
{
  String mMessage;
  int mResponse;
  
  public APIabResult(int paramInt, String paramString)
  {
    AppMethodBeat.i(192932);
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = getResponseDesc(paramInt);
      AppMethodBeat.o(192932);
      return;
    }
    this.mMessage = (paramString + " (response: " + getResponseDesc(paramInt) + ")");
    AppMethodBeat.o(192932);
  }
  
  public static String getResponseDesc(int paramInt)
  {
    return "";
  }
  
  public String getMessage()
  {
    return this.mMessage;
  }
  
  public int getResponse()
  {
    return this.mResponse;
  }
  
  public boolean isFailure()
  {
    AppMethodBeat.i(192933);
    if (!isSuccess())
    {
      AppMethodBeat.o(192933);
      return true;
    }
    AppMethodBeat.o(192933);
    return false;
  }
  
  public boolean isPendig()
  {
    return this.mResponse == 101;
  }
  
  public boolean isSuccess()
  {
    return this.mResponse == 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192934);
    String str = "IabResult: " + getMessage();
    AppMethodBeat.o(192934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.midas.api.request.APIabResult
 * JD-Core Version:    0.7.0.1
 */