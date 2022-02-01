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
    AppMethodBeat.i(222613);
    this.a = new a(50);
    this.g = new int[8];
    this.c = paramInputStream;
    this.f = paramOutputStream;
    this.d = paramInputStream.read();
    this.e = paramInputStream.read();
    AppMethodBeat.o(222613);
  }
  
  private void a(String paramString1, String paramString2) {}
  
  private void d()
  {
    AppMethodBeat.i(222618);
    this.d = this.e;
    this.e = this.c.read();
    this.b = 0;
    AppMethodBeat.o(222618);
  }
  
  private int e()
  {
    int j = 0;
    AppMethodBeat.i(222621);
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = a(i);
      j = (int)((1 << i) - 1 + l);
    }
    AppMethodBeat.o(222621);
    return j;
  }
  
  private void f()
  {
    AppMethodBeat.i(222622);
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      b(i);
    }
    AppMethodBeat.o(222622);
  }
  
  private void g()
  {
    AppMethodBeat.i(222630);
    int i = this.g[0];
    int j = this.g[1];
    int k = this.g[2];
    int m = this.g[3];
    int n = this.g[4];
    int i1 = this.g[5];
    int i2 = this.g[6];
    int i3 = this.g[7];
    this.f.write(i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1 | i3);
    AppMethodBeat.o(222630);
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(222623);
    int i = e();
    a(paramString, String.valueOf(i));
    AppMethodBeat.o(222623);
    return i;
  }
  
  public long a(int paramInt)
  {
    AppMethodBeat.i(222616);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
      AppMethodBeat.o(222616);
      throw localIllegalArgumentException;
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l = l << 1 | b(true);
      i += 1;
    }
    AppMethodBeat.o(222616);
    return l;
  }
  
  public long a(int paramInt, String paramString)
  {
    AppMethodBeat.i(222619);
    long l = a(paramInt);
    a(paramString, String.valueOf(l));
    AppMethodBeat.o(222619);
    return l;
  }
  
  public void a()
  {
    AppMethodBeat.i(222629);
    int i = this.h;
    while (i < 8)
    {
      this.g[i] = 0;
      i += 1;
    }
    this.h = 0;
    g();
    AppMethodBeat.o(222629);
  }
  
  public void a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(222632);
    int i = 0;
    while (i < paramInt)
    {
      d((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
    AppMethodBeat.o(222632);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(222636);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      d(i);
      AppMethodBeat.o(222636);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(222614);
    if (b(paramBoolean) == 1)
    {
      AppMethodBeat.o(222614);
      return true;
    }
    AppMethodBeat.o(222614);
    return false;
  }
  
  public int b(boolean paramBoolean)
  {
    AppMethodBeat.i(222615);
    if (this.b == 8)
    {
      d();
      if (this.d == -1)
      {
        AppMethodBeat.o(222615);
        return -1;
      }
    }
    int i = this.d >> 7 - this.b & 0x1;
    this.b += 1;
    if ((paramBoolean) && (this.f != null)) {
      d(i);
    }
    AppMethodBeat.o(222615);
    return i;
  }
  
  public void b()
  {
    AppMethodBeat.i(222633);
    a(0L, 8 - this.h);
    AppMethodBeat.o(222633);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(222617);
    if (paramInt > 64)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
      AppMethodBeat.o(222617);
      throw localIllegalArgumentException;
    }
    int i = 0;
    while (i < paramInt)
    {
      b(true);
      i += 1;
    }
    AppMethodBeat.o(222617);
  }
  
  public void b(int paramInt, String paramString)
  {
    AppMethodBeat.i(222620);
    b(paramInt);
    a(paramString, "skip NBits");
    AppMethodBeat.o(222620);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(222624);
    f();
    a(paramString, "skip UE");
    AppMethodBeat.o(222624);
  }
  
  public int c(String paramString)
  {
    AppMethodBeat.i(222625);
    int i = e();
    i = ((i & 0x1) + (i >> 1)) * (((i & 0x1) << 1) - 1);
    a(paramString, String.valueOf(i));
    AppMethodBeat.o(222625);
    return i;
  }
  
  public void c()
  {
    AppMethodBeat.i(222637);
    d(1);
    b();
    a();
    AppMethodBeat.o(222637);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(222628);
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
    AppMethodBeat.o(222628);
  }
  
  public void c(int paramInt, String paramString)
  {
    AppMethodBeat.i(222635);
    e(paramInt);
    AppMethodBeat.o(222635);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(222631);
    if (this.h == 8)
    {
      this.h = 0;
      g();
    }
    int[] arrayOfInt = this.g;
    int i = this.h;
    this.h = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(222631);
  }
  
  public boolean d(String paramString)
  {
    AppMethodBeat.i(222626);
    boolean bool = a(true);
    if (bool) {}
    for (String str = "1";; str = "0")
    {
      a(paramString, str);
      AppMethodBeat.o(222626);
      return bool;
    }
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(222634);
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
      AppMethodBeat.o(222634);
      return;
      j += (1 << i);
      i += 1;
      break;
      i = 0;
    }
  }
  
  public boolean e(String paramString)
  {
    AppMethodBeat.i(222627);
    boolean bool = a(false);
    if (bool) {}
    for (String str = "1";; str = "0")
    {
      a(paramString, str);
      AppMethodBeat.o(222627);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.c
 * JD-Core Version:    0.7.0.1
 */