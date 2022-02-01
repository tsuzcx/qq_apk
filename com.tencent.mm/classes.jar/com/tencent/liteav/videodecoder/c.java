package com.tencent.liteav.videodecoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

class c
{
  protected a a;
  int b;
  private InputStream c;
  private int d;
  private int e;
  private final OutputStream f;
  private int[] g;
  private int h;
  
  public c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(229894);
    this.a = new a(50);
    this.g = new int[8];
    this.c = paramInputStream;
    this.f = paramOutputStream;
    this.d = paramInputStream.read();
    this.e = paramInputStream.read();
    AppMethodBeat.o(229894);
  }
  
  private void a(String paramString1, String paramString2) {}
  
  private void d()
  {
    AppMethodBeat.i(229898);
    this.d = this.e;
    this.e = this.c.read();
    this.b = 0;
    AppMethodBeat.o(229898);
  }
  
  private int e()
  {
    int j = 0;
    AppMethodBeat.i(229902);
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = a(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(229902);
    return j;
  }
  
  private void f()
  {
    AppMethodBeat.i(229909);
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      b(i);
    }
    AppMethodBeat.o(229909);
  }
  
  private void g()
  {
    AppMethodBeat.i(229915);
    int i = this.g[0];
    int j = this.g[1];
    int k = this.g[2];
    int m = this.g[3];
    int n = this.g[4];
    int i1 = this.g[5];
    int i2 = this.g[6];
    int i3 = this.g[7];
    this.f.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(229915);
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(229971);
    int i = e();
    a(paramString, String.valueOf(i));
    AppMethodBeat.o(229971);
    return i;
  }
  
  public long a(int paramInt)
  {
    AppMethodBeat.i(229944);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
      AppMethodBeat.o(229944);
      throw localIllegalArgumentException;
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | b(true);
      i += 1;
    }
    AppMethodBeat.o(229944);
    return l;
  }
  
  public long a(int paramInt, String paramString)
  {
    AppMethodBeat.i(229955);
    long l = a(paramInt);
    a(paramString, String.valueOf(l));
    AppMethodBeat.o(229955);
    return l;
  }
  
  public long a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(229938);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
      AppMethodBeat.o(229938);
      throw localIllegalArgumentException;
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | b(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(229938);
    return l;
  }
  
  public void a()
  {
    AppMethodBeat.i(229998);
    int i = this.h;
    while (i < 8)
    {
      this.g[i] = 0;
      i += 1;
    }
    this.h = 0;
    g();
    AppMethodBeat.o(229998);
  }
  
  public void a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(230008);
    int i = 0;
    while (i < paramInt)
    {
      d((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(230008);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(230028);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d(i);
      AppMethodBeat.o(230028);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(229927);
    if (b(paramBoolean) == 1)
    {
      AppMethodBeat.o(229927);
      return true;
    }
    AppMethodBeat.o(229927);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(229932);
    if (this.b == 8)
    {
      d();
      if (this.d == -1)
      {
        AppMethodBeat.o(229932);
        return -1;
      }
    }
    int i = this.d >> 7 - this.b & 0x1;
    this.b += 1;
    if ((paramBoolean) && (this.f != null)) {
      d(i);
    }
    AppMethodBeat.o(229932);
    return i;
  }
  
  public void b()
  {
    AppMethodBeat.i(230013);
    a(0L, 8 - this.h);
    AppMethodBeat.o(230013);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(229950);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
      AppMethodBeat.o(229950);
      throw localIllegalArgumentException;
    }
    int i = 0;
    while (i < paramInt)
    {
      b(true);
      i += 1;
    }
    AppMethodBeat.o(229950);
  }
  
  public void b(int paramInt, String paramString)
  {
    AppMethodBeat.i(229960);
    b(paramInt);
    a(paramString, "skip NBits");
    AppMethodBeat.o(229960);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(229976);
    f();
    a(paramString, "skip UE");
    AppMethodBeat.o(229976);
  }
  
  public int c(String paramString)
  {
    AppMethodBeat.i(229981);
    int i = e();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    a(paramString, String.valueOf(i));
    AppMethodBeat.o(229981);
    return i;
  }
  
  public int c(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(229967);
    int i = 0;
    while (b(paramBoolean) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = a(i, paramBoolean);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(229967);
    return j;
  }
  
  public void c()
  {
    AppMethodBeat.i(230032);
    d(1);
    b();
    a();
    AppMethodBeat.o(230032);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(229992);
    int[] arrayOfInt = new int[paramInt];
    int k = 0;
    int m = 8;
    int j = 8;
    if (k < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (c("deltaScale") + j + 256) % 256;
      }
      if (i == 0) {}
      for (;;)
      {
        arrayOfInt[k] = j;
        j = arrayOfInt[k];
        k += 1;
        m = i;
        break;
        j = i;
      }
    }
    AppMethodBeat.o(229992);
  }
  
  public void c(int paramInt, String paramString)
  {
    AppMethodBeat.i(230023);
    e(paramInt);
    AppMethodBeat.o(230023);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(230002);
    if (this.h == 8)
    {
      this.h = 0;
      g();
    }
    int[] arrayOfInt = this.g;
    int i = this.h;
    this.h = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(230002);
  }
  
  public boolean d(String paramString)
  {
    AppMethodBeat.i(229984);
    boolean bool = a(true);
    if (bool) {}
    for (String str = "1";; str = "0")
    {
      a(paramString, str);
      AppMethodBeat.o(229984);
      return bool;
    }
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(230018);
    int i = 0;
    int j = 0;
    if (i < 15) {
      if (paramInt >= (1 << i) + j) {}
    }
    for (;;)
    {
      a(0L, i);
      d(1);
      a(paramInt - j, i);
      AppMethodBeat.o(230018);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  public boolean e(String paramString)
  {
    AppMethodBeat.i(229988);
    boolean bool = a(false);
    if (bool) {}
    for (String str = "1";; str = "0")
    {
      a(paramString, str);
      AppMethodBeat.o(229988);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.c
 * JD-Core Version:    0.7.0.1
 */