package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class b
{
  private static String a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15441);
    int i = paramDataInputStream.readUnsignedByte();
    if ((i & 0xC0) == 192)
    {
      i = ((i & 0x3F) << 8) + paramDataInputStream.readUnsignedByte();
      paramDataInputStream = new HashSet();
      paramDataInputStream.add(Integer.valueOf(i));
      paramDataInputStream = a(paramArrayOfByte, i, paramDataInputStream);
      AppMethodBeat.o(15441);
      return paramDataInputStream;
    }
    if (i == 0)
    {
      AppMethodBeat.o(15441);
      return "";
    }
    Object localObject = new byte[i];
    paramDataInputStream.readFully((byte[])localObject);
    localObject = IDN.toUnicode(new String((byte[])localObject));
    paramArrayOfByte = a(paramDataInputStream, paramArrayOfByte);
    paramDataInputStream = (DataInputStream)localObject;
    if (paramArrayOfByte.length() > 0) {
      paramDataInputStream = (String)localObject + "." + paramArrayOfByte;
    }
    AppMethodBeat.o(15441);
    return paramDataInputStream;
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt, HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(15442);
    int i;
    for (;;)
    {
      i = paramArrayOfByte[paramInt] & 0xFF;
      if ((i & 0xC0) != 192) {
        break;
      }
      paramInt = ((i & 0x3F) << 8) + (paramArrayOfByte[(paramInt + 1)] & 0xFF);
      if (paramHashSet.contains(Integer.valueOf(paramInt)))
      {
        paramArrayOfByte = new com.tencent.liteav.network.a.a("", "Cyclic offsets detected.");
        AppMethodBeat.o(15442);
        throw paramArrayOfByte;
      }
      paramHashSet.add(Integer.valueOf(paramInt));
    }
    if (i == 0)
    {
      AppMethodBeat.o(15442);
      return "";
    }
    String str = new String(paramArrayOfByte, paramInt + 1, i);
    paramHashSet = a(paramArrayOfByte, i + (paramInt + 1), paramHashSet);
    paramArrayOfByte = str;
    if (paramHashSet.length() > 0) {
      paramArrayOfByte = str + "." + paramHashSet;
    }
    AppMethodBeat.o(15442);
    return paramArrayOfByte;
  }
  
  private static void a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(15443);
    while (paramInt > 0)
    {
      a(paramDataInputStream, paramArrayOfByte);
      paramDataInputStream.readUnsignedShort();
      paramDataInputStream.readUnsignedShort();
      paramInt -= 1;
    }
    AppMethodBeat.o(15443);
  }
  
  private static void a(OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(15438);
    paramString = paramString.split("[.。．｡]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      byte[] arrayOfByte = IDN.toASCII(paramString[i]).getBytes();
      paramOutputStream.write(arrayOfByte.length);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      i += 1;
    }
    paramOutputStream.write(0);
    AppMethodBeat.o(15438);
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    AppMethodBeat.i(15437);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    com.tencent.liteav.network.a.b.a locala = new com.tencent.liteav.network.a.b.a();
    locala.a(8);
    paramInt = (short)paramInt;
    try
    {
      localDataOutputStream.writeShort(paramInt);
      localDataOutputStream.writeShort((short)locala.a());
      localDataOutputStream.writeShort(1);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.flush();
      b(localByteArrayOutputStream, paramString);
      paramString = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(15437);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(15437);
      throw paramString;
    }
  }
  
  public static e[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(15440);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    int j = localDataInputStream.readUnsignedShort();
    if (j != paramInt)
    {
      paramArrayOfByte = new com.tencent.liteav.network.a.a(paramString, "the answer id " + j + " is not match " + paramInt);
      AppMethodBeat.o(15440);
      throw paramArrayOfByte;
    }
    j = localDataInputStream.readUnsignedShort();
    if ((j >> 8 & 0x1) == 1)
    {
      paramInt = 1;
      if ((j >> 7 & 0x1) != 1) {
        break label144;
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramInt != 0)) {
        break label149;
      }
      paramArrayOfByte = new com.tencent.liteav.network.a.a(paramString, "the dns server cant support recursion ");
      AppMethodBeat.o(15440);
      throw paramArrayOfByte;
      paramInt = 0;
      break;
      label144:
      i = 0;
    }
    label149:
    paramInt = localDataInputStream.readUnsignedShort();
    i = localDataInputStream.readUnsignedShort();
    localDataInputStream.readUnsignedShort();
    localDataInputStream.readUnsignedShort();
    a(localDataInputStream, paramArrayOfByte, paramInt);
    paramArrayOfByte = b(localDataInputStream, paramArrayOfByte, i);
    AppMethodBeat.o(15440);
    return paramArrayOfByte;
  }
  
  private static e b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15445);
    a(paramDataInputStream, paramArrayOfByte);
    int j = paramDataInputStream.readUnsignedShort();
    paramDataInputStream.readUnsignedShort();
    long l1 = paramDataInputStream.readUnsignedShort();
    long l2 = paramDataInputStream.readUnsignedShort();
    int k = paramDataInputStream.readUnsignedShort();
    switch (j)
    {
    default: 
      Object localObject = null;
      int i = 0;
      for (;;)
      {
        paramArrayOfByte = localObject;
        if (i >= k) {
          break;
        }
        paramDataInputStream.readByte();
        i += 1;
      }
    case 1: 
      paramArrayOfByte = new byte[4];
      paramDataInputStream.readFully(paramArrayOfByte);
    }
    for (paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte).getHostAddress(); paramArrayOfByte == null; paramArrayOfByte = a(paramDataInputStream, paramArrayOfByte))
    {
      paramDataInputStream = new UnknownHostException("no record");
      AppMethodBeat.o(15445);
      throw paramDataInputStream;
    }
    paramDataInputStream = new e(paramArrayOfByte, j, (int)(l2 + (l1 << 16)), System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(15445);
    return paramDataInputStream;
  }
  
  private static void b(OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(15439);
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    a(paramOutputStream, paramString);
    localDataOutputStream.writeShort(1);
    localDataOutputStream.writeShort(1);
    AppMethodBeat.o(15439);
  }
  
  private static e[] b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(15444);
    int i = 0;
    e[] arrayOfe = new e[paramInt];
    while (paramInt > 0)
    {
      arrayOfe[i] = b(paramDataInputStream, paramArrayOfByte);
      i += 1;
      paramInt -= 1;
    }
    AppMethodBeat.o(15444);
    return arrayOfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.b
 * JD-Core Version:    0.7.0.1
 */