package com.tencent.theme;

import java.io.IOException;
import java.nio.ByteBuffer;

public class k
{
  private int[] a;
  private String[] b;
  private int[] c;
  private int[] d;
  private int e;
  private ByteBuffer f;
  
  public static k a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    c.a(paramByteBuffer, 1835009);
    int j = paramByteBuffer.getInt();
    int m = paramByteBuffer.getInt();
    int i = paramByteBuffer.getInt();
    int n = paramByteBuffer.getInt();
    int i1 = paramByteBuffer.getInt();
    int k = paramByteBuffer.getInt();
    k localk = new k();
    localk.a = c.c(paramByteBuffer, m);
    if (i != 0) {
      localk.c = c.c(paramByteBuffer, i);
    }
    int i2 = paramByteBuffer.position();
    localk.e = n;
    if (k == 0) {}
    for (i = j;; i = k)
    {
      i -= i1;
      if (i % 4 == 0) {
        break;
      }
      throw new IOException("String data size is not multiple of 4 (" + i + ").");
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramByteBuffer.array(), i2, i);
    localByteBuffer.order(paramByteBuffer.order());
    localk.f = localByteBuffer;
    localk.b = new String[m];
    c.b(paramByteBuffer, i);
    if ((n != 0) && (n != 256)) {
      throw new IOException("Unknow version xml file: version: " + n);
    }
    if (k != 0)
    {
      i = j - k;
      if (i % 4 != 0) {
        throw new IOException("Style data size is not multiple of 4 (" + i + ").");
      }
      localk.d = c.c(paramByteBuffer, i / 4);
    }
    return localk;
  }
  
  public int a(String paramString)
  {
    int j;
    if (paramString == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.b.length) {
        break label61;
      }
      String str2 = this.b[i];
      String str1 = str2;
      if (str2 == null) {
        str1 = a(i);
      }
      j = i;
      if (paramString.equals(str1)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (this.a == null) || (paramInt >= this.a.length)) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = this.b[paramInt];
      localObject = str;
    } while (str != null);
    int i = this.a[paramInt];
    this.f.mark();
    c.b(this.f, i);
    if (this.e == 0)
    {
      localObject = new char[this.f.getShort()];
      i = 0;
      while (i < localObject.length)
      {
        localObject[i] = this.f.getChar();
        i += 1;
      }
    }
    for (Object localObject = new String((char[])localObject);; localObject = new String(c.d(this.f, i)))
    {
      this.b[paramInt] = localObject;
      this.f.reset();
      return localObject;
      i = this.f.get();
      this.f.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.k
 * JD-Core Version:    0.7.0.1
 */