package com.tencent.map.tools.net;

import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NetResponse
{
  public String charset;
  public String contentEncoding;
  public byte[] data;
  public InputStream dataStream;
  public int errorCode;
  public byte[] errorData;
  public Exception exception;
  public long mRequestId;
  public final Map<String, String> respHeads;
  private Set<Processor> respProcessorSet;
  public int statusCode;
  
  public NetResponse()
  {
    AppMethodBeat.i(210984);
    this.errorCode = -1;
    this.charset = "GBK";
    this.respHeads = new HashMap();
    AppMethodBeat.o(210984);
  }
  
  public NetResponse(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(210989);
    this.errorCode = -1;
    this.charset = "GBK";
    this.respHeads = new HashMap();
    this.mRequestId = paramNetRequest.mRequestId;
    this.respProcessorSet = paramNetRequest.processors;
    AppMethodBeat.o(210989);
  }
  
  public boolean available()
  {
    return ((this.errorCode == 0) && (this.statusCode == 200)) || ((this.data != null) && (this.data.length > 0));
  }
  
  public void clone(NetResponse paramNetResponse)
  {
    if (paramNetResponse != null)
    {
      this.errorCode = paramNetResponse.errorCode;
      this.statusCode = paramNetResponse.statusCode;
      this.data = paramNetResponse.data;
      this.charset = paramNetResponse.charset;
      this.exception = paramNetResponse.exception;
      this.errorData = paramNetResponse.errorData;
    }
  }
  
  public void exception(Exception paramException)
  {
    this.exception = paramException;
    if ((paramException instanceof NetErrorException))
    {
      this.errorCode = ((NetErrorException)paramException).errorCode;
      this.statusCode = ((NetErrorException)paramException).statusCode;
    }
  }
  
  public String getData()
  {
    AppMethodBeat.i(211019);
    if (this.data != null)
    {
      String str = new String(this.data);
      AppMethodBeat.o(211019);
      return str;
    }
    AppMethodBeat.o(211019);
    return "";
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    AppMethodBeat.i(211021);
    String str;
    if (this.errorData != null)
    {
      str = new String(this.errorData);
      AppMethodBeat.o(211021);
      return str;
    }
    if (this.exception != null)
    {
      str = this.exception.getMessage();
      AppMethodBeat.o(211021);
      return str;
    }
    AppMethodBeat.o(211021);
    return "";
  }
  
  public String getHeaderField(String paramString)
  {
    AppMethodBeat.i(211024);
    paramString = (String)this.respHeads.get(paramString);
    AppMethodBeat.o(211024);
    return paramString;
  }
  
  public InputStream getInputStream()
  {
    return this.dataStream;
  }
  
  public Set<Processor> getProcessors()
  {
    return this.respProcessorSet;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String toHumanString()
  {
    AppMethodBeat.i(180922);
    String str;
    if (this.data != null)
    {
      str = "[DATA] " + this.data.length / 1024.0F + "KB " + new String(this.data, Charset.forName("utf-8"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.NetResponse
 * JD-Core Version:    0.7.0.1
 */