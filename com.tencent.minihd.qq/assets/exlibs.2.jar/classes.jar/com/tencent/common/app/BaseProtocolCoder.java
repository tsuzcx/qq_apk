package com.tencent.common.app;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public abstract class BaseProtocolCoder
{
  public HashMap a = new HashMap();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return null;
  }
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  public void a() {}
  
  public abstract void a(ToServiceMsg paramToServiceMsg);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket);
  
  public byte[] a(ToServiceMsg paramToServiceMsg)
  {
    return null;
  }
  
  public abstract String[] a();
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseProtocolCoder
 * JD-Core Version:    0.7.0.1
 */