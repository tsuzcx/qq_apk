package com.tencent.map.tools.net;

import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetResponse
{
  public String charset;
  public byte[] data;
  public int errorCode;
  public byte[] errorData;
  public Exception exception;
  public int statusCode;
  
  public NetResponse()
  {
    this.errorCode = -1;
    this.charset = "GBK";
  }
  
  public NetResponse(Exception paramException)
  {
    AppMethodBeat.i(172928);
    this.errorCode = -1;
    this.charset = "GBK";
    this.exception = paramException;
    if ((paramException instanceof NetErrorException))
    {
      this.errorCode = ((NetErrorException)paramException).errorCode;
      this.statusCode = ((NetErrorException)paramException).statusCode;
    }
    AppMethodBeat.o(172928);
  }
  
  public boolean available()
  {
    return ((this.errorCode == 0) && (this.statusCode == 200)) || ((this.data != null) && (this.data.length > 0));
  }
  
  public String toHumanString()
  {
    AppMethodBeat.i(180922);
    String str;
    if (this.data != null)
    {
      str = "[DATA] " + new String(this.data);
      AppMethodBeat.o(180922);
      return str;
    }
    if (this.errorData != null)
    {
      str = "[ERROR] " + new String(this.errorData);
      AppMethodBeat.o(180922);
      return str;
    }
    AppMethodBeat.o(180922);
    return "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(172929);
    try
    {
      if (this.data != null)
      {
        String str = new String(this.data, this.charset);
        AppMethodBeat.o(172929);
        return str;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(172929);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.tools.net.NetResponse
 * JD-Core Version:    0.7.0.1
 */