package com.tencent.tmassistantsdk.internal.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;

public class a
{
  protected static int a = 0;
  
  public static int a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return -1;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    return IPCCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - "Request".length())).value();
  }
  
  public static JceStruct a(IPCResponse paramIPCResponse)
  {
    JceStruct localJceStruct = a(IPCCmd.convert(paramIPCResponse.head.cmdId).toString());
    if ((localJceStruct != null) && (paramIPCResponse.body.length > 0)) {
      try
      {
        paramIPCResponse = new JceInputStream(paramIPCResponse.body);
        paramIPCResponse.setServerEncoding("utf-8");
        localJceStruct.readFrom(paramIPCResponse);
        return localJceStruct;
      }
      catch (Exception paramIPCResponse)
      {
        paramIPCResponse.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private static JceStruct a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = a.class.getPackage().getName() + ".jce." + paramString;
    paramString = paramString + "Response";
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static IPCRequest a(JceStruct paramJceStruct, String paramString)
  {
    if (paramJceStruct == null) {
      return null;
    }
    IPCRequest localIPCRequest = new IPCRequest();
    IPCHead localIPCHead = new IPCHead();
    int i = a;
    a = i + 1;
    localIPCHead.requestId = i;
    localIPCHead.cmdId = a(paramJceStruct);
    localIPCHead.hostPackageName = f.b(f.a().b());
    localIPCHead.hostVersionCode = String.valueOf(f.c(f.a().b()));
    localIPCHead.traceId = paramString;
    localIPCRequest.head = localIPCHead;
    localIPCRequest.body = b(paramJceStruct);
    return localIPCRequest;
  }
  
  public static IPCResponse a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      IPCResponse localIPCResponse = new IPCResponse();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localIPCResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localIPCResponse;
        if (!TextUtils.isEmpty(localIPCResponse.head.hostPackageName))
        {
          localIPCResponse.body = com.tencent.tmassistant.common.a.b(localIPCResponse.body, "ji*9^&43U0X-~./(".getBytes());
          return localIPCResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] a(IPCRequest paramIPCRequest)
  {
    if (paramIPCRequest == null) {
      return null;
    }
    paramIPCRequest.body = com.tencent.tmassistant.common.a.a(paramIPCRequest.body, "ji*9^&43U0X-~./(".getBytes());
    return b(paramIPCRequest);
  }
  
  public static byte[] b(JceStruct paramJceStruct)
  {
    return com.tencent.tmassistant.common.a.c(paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.a
 * JD-Core Version:    0.7.0.1
 */