package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;

public class p
  implements c
{
  MsfCore a;
  
  public p(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws Exception
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    this.a.sender.c(arrayOfByte);
  }
  
  public byte[] a(d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.p
 * JD-Core Version:    0.7.0.1
 */