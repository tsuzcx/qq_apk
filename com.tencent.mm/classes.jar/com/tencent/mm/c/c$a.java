package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  Properties bWG;
  byte[] bWH;
  
  private c$a()
  {
    AppMethodBeat.i(125710);
    this.bWG = new Properties();
    AppMethodBeat.o(125710);
  }
  
  final byte[] AJ()
  {
    AppMethodBeat.i(125712);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Iterator localIterator;
    if (this.bWG.size() > 0)
    {
      localByteArrayOutputStream.write(c.AH().getBytes());
      localIterator = this.bWG.keySet().iterator();
    }
    Object localObject2;
    for (Object localObject1 = "";; localObject1 = localObject1 + localObject2 + "=" + this.bWG.getProperty((String)localObject2) + "\r\n")
    {
      if (!localIterator.hasNext())
      {
        localObject1 = ((String)localObject1).getBytes();
        localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
        localByteArrayOutputStream.write((byte[])localObject1);
        if ((this.bWH != null) && (this.bWH.length > 0))
        {
          localByteArrayOutputStream.write(c.AI().getBytes());
          localByteArrayOutputStream.write(new l(this.bWH.length).getBytes());
          localByteArrayOutputStream.write(this.bWH);
        }
        localObject1 = localByteArrayOutputStream.toByteArray();
        AppMethodBeat.o(125712);
        return localObject1;
      }
      localObject2 = localIterator.next();
    }
  }
  
  final void D(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125711);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(125711);
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    c.AH();
    byte[] arrayOfByte = new byte[4];
    localByteBuffer.get(arrayOfByte);
    System.out.println("securityPart: " + new k(arrayOfByte).value);
    int i;
    if (c.AH().equals(new k(arrayOfByte)))
    {
      if (paramArrayOfByte.length - 4 <= 2)
      {
        System.err.println("data.length - securityMarkLength <= 2");
        AppMethodBeat.o(125711);
        return;
      }
      arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      i = new l(arrayOfByte).value;
      if (paramArrayOfByte.length - 4 - 2 < i)
      {
        System.err.println("data.length - securityMarkLength - 2 < len");
        System.err.println("exit");
        AppMethodBeat.o(125711);
        return;
      }
      arrayOfByte = new byte[i];
      localByteBuffer.get(arrayOfByte);
      this.bWG.load(new ByteArrayInputStream(arrayOfByte));
      i = paramArrayOfByte.length - 4 - i - 2;
      if (i > 0)
      {
        c.AI();
        paramArrayOfByte = new byte[4];
        localByteBuffer.get(paramArrayOfByte);
        if (c.AI().equals(new k(paramArrayOfByte)))
        {
          if (i - 4 <= 2)
          {
            System.err.println("data.length - oriMarkLength <= 2");
            AppMethodBeat.o(125711);
            return;
          }
          paramArrayOfByte = new byte[2];
          localByteBuffer.get(paramArrayOfByte);
          int j = new l(paramArrayOfByte).value;
          if (i - 4 - 2 < j)
          {
            System.err.println("data.length - oriMarkLength - 2 < len");
            System.err.println("exit");
            AppMethodBeat.o(125711);
            return;
          }
          this.bWH = new byte[j];
          localByteBuffer.get(this.bWH);
          AppMethodBeat.o(125711);
        }
      }
    }
    else
    {
      if (c.AI().equals(new k(arrayOfByte)))
      {
        c.AI();
        if (paramArrayOfByte.length - 4 <= 2)
        {
          System.err.println("data.length - oriMarkLength <= 2");
          AppMethodBeat.o(125711);
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        i = new l(arrayOfByte).value;
        if (paramArrayOfByte.length - 4 - 2 < i)
        {
          System.err.println("data.length - oriMarkLength - 2 < len");
          System.err.println("exit");
          AppMethodBeat.o(125711);
          return;
        }
        this.bWH = new byte[i];
        localByteBuffer.get(this.bWH);
        AppMethodBeat.o(125711);
        return;
      }
      paramArrayOfByte = new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
      AppMethodBeat.o(125711);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(125711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.c.c.a
 * JD-Core Version:    0.7.0.1
 */