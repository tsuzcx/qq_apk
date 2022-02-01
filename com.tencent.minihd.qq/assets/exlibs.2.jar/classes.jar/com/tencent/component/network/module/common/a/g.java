package com.tencent.component.network.module.common.a;

import cvh;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class g
{
  private String a = "";
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  public InetAddress[] a(String paramString, long paramLong)
  {
    InetAddress[] arrayOfInetAddress = null;
    h localh = new h(paramString);
    Object localObject1 = localh.a();
    if (localObject1 == null) {
      localObject1 = arrayOfInetAddress;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = new cvh();
        ((cvh)localObject2).a(paramLong);
        localObject2 = ((cvh)localObject2).a(this.a, (byte[])localObject1);
        localObject1 = arrayOfInetAddress;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = new i(new d((byte[])localObject2), paramString);
        localObject1 = arrayOfInetAddress;
        if (((i)localObject2).a() != localh.a()) {
          continue;
        }
        arrayOfInetAddress = ((i)localObject2).a();
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress == null) {
          continue;
        }
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress.length <= 0) {
          continue;
        }
        f.a().a(paramString, arrayOfInetAddress, ((i)localObject2).a());
        return arrayOfInetAddress;
      }
      catch (k paramString)
      {
        throw paramString;
      }
      catch (SocketTimeoutException paramString)
      {
        throw paramString;
      }
      catch (IOException paramString)
      {
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.g
 * JD-Core Version:    0.7.0.1
 */