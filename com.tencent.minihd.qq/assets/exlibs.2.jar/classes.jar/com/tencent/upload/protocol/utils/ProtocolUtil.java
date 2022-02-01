package com.tencent.upload.protocol.utils;

import com.qq.jce.wup.UniPacket;
import com.tencent.upload.common.UploadLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.PatternSyntaxException;

public class ProtocolUtil
{
  private static final AtomicInteger REQUEST_SEQUENCE = new AtomicInteger(0);
  
  public static final int[] fromProtocolSequence(String paramString)
  {
    int[] arrayOfInt = new int[2];
    if ((paramString == null) || (paramString.length() == 0))
    {
      UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence protocolSequence == null || len == 0");
      return arrayOfInt;
    }
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      if ((arrayOfString == null) || (arrayOfString.length != 2))
      {
        UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence:" + paramString + " results == null || results.length != 2" + paramString);
        return arrayOfInt;
      }
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence:" + paramString + " " + localPatternSyntaxException);
      return arrayOfInt;
    }
    try
    {
      arrayOfInt[0] = Integer.parseInt(localPatternSyntaxException[0]);
      arrayOfInt[1] = Integer.parseInt(localPatternSyntaxException[1]);
      return arrayOfInt;
    }
    catch (NumberFormatException paramString)
    {
      UploadLog.w(ProtocolUtil.class.getSimpleName(), "toProtocolSequence " + paramString);
    }
    return arrayOfInt;
  }
  
  public static final int nextRequestSequence()
  {
    return REQUEST_SEQUENCE.incrementAndGet();
  }
  
  public static final byte[] pack(String paramString, Object paramObject)
    throws Exception
  {
    if ((paramString == null) || (paramObject == null)) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.setRequestId(0);
    localUniPacket.setFuncName("FuncName");
    localUniPacket.setServantName("ServantName");
    localUniPacket.put(paramString, paramObject);
    paramString = localUniPacket.encode();
    localUniPacket.clearCacheData();
    return paramString;
  }
  
  public static final String toProtocolSequence(int paramInt1, int paramInt2)
  {
    return paramInt1 + "|" + paramInt2;
  }
  
  public static final Object unpack(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.decode(paramArrayOfByte);
    paramString = localUniPacket.get(paramString);
    localUniPacket.clearCacheData();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.protocol.utils.ProtocolUtil
 * JD-Core Version:    0.7.0.1
 */