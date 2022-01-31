package com.tencent.mm.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

final class c$a
{
  Properties bvv = new Properties();
  byte[] bvw;
  
  final byte[] ss()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Iterator localIterator;
    if (this.bvv.size() > 0)
    {
      localByteArrayOutputStream.write(c.sq().getBytes());
      localIterator = this.bvv.keySet().iterator();
    }
    Object localObject2;
    for (Object localObject1 = "";; localObject1 = localObject1 + localObject2 + "=" + this.bvv.getProperty((String)localObject2) + "\r\n")
    {
      if (!localIterator.hasNext())
      {
        localObject1 = ((String)localObject1).getBytes();
        localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
        localByteArrayOutputStream.write((byte[])localObject1);
        if ((this.bvw != null) && (this.bvw.length > 0))
        {
          localByteArrayOutputStream.write(c.sr().getBytes());
          localByteArrayOutputStream.write(new l(this.bvw.length).getBytes());
          localByteArrayOutputStream.write(this.bvw);
        }
        return localByteArrayOutputStream.toByteArray();
      }
      localObject2 = localIterator.next();
    }
  }
  
  final void u(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    ByteBuffer localByteBuffer;
    byte[] arrayOfByte;
    int i;
    do
    {
      do
      {
        return;
        localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
        c.sq().getBytes();
        arrayOfByte = new byte[4];
        localByteBuffer.get(arrayOfByte);
        System.out.println("securityPart: " + new k(arrayOfByte).value);
        if (!c.sq().equals(new k(arrayOfByte))) {
          break;
        }
        if (paramArrayOfByte.length - 4 <= 2)
        {
          System.err.println("data.length - securityMarkLength <= 2");
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        i = new l(arrayOfByte).value;
        if (paramArrayOfByte.length - 4 - 2 < i)
        {
          System.err.println("data.length - securityMarkLength - 2 < len");
          System.err.println("exit");
          return;
        }
        arrayOfByte = new byte[i];
        localByteBuffer.get(arrayOfByte);
        this.bvv.load(new ByteArrayInputStream(arrayOfByte));
        i = paramArrayOfByte.length - 4 - i - 2;
      } while (i <= 0);
      c.sr().getBytes();
      paramArrayOfByte = new byte[4];
      localByteBuffer.get(paramArrayOfByte);
    } while (!c.sr().equals(new k(paramArrayOfByte)));
    if (i - 4 <= 2)
    {
      System.err.println("data.length - oriMarkLength <= 2");
      return;
    }
    paramArrayOfByte = new byte[2];
    localByteBuffer.get(paramArrayOfByte);
    int j = new l(paramArrayOfByte).value;
    if (i - 4 - 2 < j)
    {
      System.err.println("data.length - oriMarkLength - 2 < len");
      System.err.println("exit");
      return;
    }
    this.bvw = new byte[j];
    localByteBuffer.get(this.bvw);
    return;
    if (c.sr().equals(new k(arrayOfByte)))
    {
      c.sr().getBytes();
      if (paramArrayOfByte.length - 4 <= 2)
      {
        System.err.println("data.length - oriMarkLength <= 2");
        return;
      }
      arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      i = new l(arrayOfByte).value;
      if (paramArrayOfByte.length - 4 - 2 < i)
      {
        System.err.println("data.length - oriMarkLength - 2 < len");
        System.err.println("exit");
        return;
      }
      this.bvw = new byte[i];
      localByteBuffer.get(this.bvw);
      return;
    }
    throw new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.c.c.a
 * JD-Core Version:    0.7.0.1
 */