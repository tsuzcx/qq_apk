package midas.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.InputStream;
import java.util.Vector;

public class gm
{
  private static gm P = new gm();
  protected static Bitmap a;
  protected static Bitmap b;
  protected int A;
  protected int B = 0;
  protected byte[] C = new byte[256];
  protected int D = 0;
  protected int E = 0;
  protected int F = 0;
  protected boolean G = false;
  protected int H = 0;
  protected int I;
  protected short[] J;
  protected byte[] K;
  protected byte[] L;
  protected byte[] M;
  protected Vector<a> N;
  protected int O;
  protected int c;
  protected InputStream d;
  protected int e;
  protected int f;
  protected boolean g;
  protected int h;
  protected int i = 1;
  protected int[] j;
  protected int[] k;
  protected int[] l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected boolean q;
  protected boolean r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  protected int z;
  
  public static gm a()
  {
    return P;
  }
  
  public int a(InputStream paramInputStream)
  {
    h();
    if (paramInputStream != null)
    {
      this.d = paramInputStream;
      m();
      if (!g())
      {
        k();
        if (this.O < 0) {
          this.c = 1;
        }
      }
    }
    else
    {
      this.c = 2;
    }
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      label56:
      return this.c;
    }
    catch (Exception paramInputStream)
    {
      break label56;
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.O)) {
      return ((a)this.N.elementAt(paramInt)).a;
    }
    return null;
  }
  
  public int b()
  {
    return this.e;
  }
  
  protected int[] b(int paramInt)
  {
    int i2 = paramInt * 3;
    byte[] arrayOfByte = new byte[i2];
    int i3 = 0;
    try
    {
      i1 = this.d.read(arrayOfByte);
    }
    catch (Exception localException)
    {
      int i1;
      label25:
      int[] arrayOfInt;
      break label25;
    }
    i1 = 0;
    if (i1 < i2)
    {
      this.c = 1;
      return null;
    }
    arrayOfInt = new int[256];
    i2 = 0;
    i1 = i3;
    while (i1 < paramInt)
    {
      i3 = i2 + 1;
      i2 = arrayOfByte[i2];
      int i4 = i3 + 1;
      arrayOfInt[i1] = ((i2 & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[i3] & 0xFF) << 8 | arrayOfByte[i4] & 0xFF);
      i2 = i4 + 1;
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  public int c()
  {
    return this.f;
  }
  
  protected void d()
  {
    int[] arrayOfInt = new int[this.e * this.f];
    int i1 = this.F;
    int i4 = 0;
    int i2;
    if (i1 > 0)
    {
      if (this.F == 3)
      {
        i1 = this.O - 2;
        if (i1 > 0) {
          b = a(i1 - 1);
        } else {
          b = null;
        }
      }
      if (b != null)
      {
        b.getPixels(arrayOfInt, 0, this.e, 0, 0, this.e, this.f);
        if (this.F == 2)
        {
          if (!this.G) {
            i2 = this.o;
          } else {
            i2 = 0;
          }
          i3 = 0;
          while (i3 < this.A)
          {
            i5 = (this.y + i3) * this.e + this.x;
            i6 = this.z;
            i1 = i5;
            while (i1 < i6 + i5)
            {
              arrayOfInt[i1] = i2;
              i1 += 1;
            }
            i3 += 1;
          }
        }
      }
    }
    int i3 = 0;
    int i6 = 1;
    for (int i5 = 8; i4 < this.w; i5 = i2)
    {
      int i7;
      if (this.r)
      {
        i1 = i3;
        i7 = i6;
        i2 = i5;
        if (i3 >= this.w)
        {
          i7 = i6 + 1;
          switch (i7)
          {
          default: 
            i1 = i3;
            i2 = i5;
            break;
          case 4: 
            i1 = 1;
            i2 = 2;
            break;
          case 3: 
            i1 = 2;
            i2 = 4;
            break;
          case 2: 
            i1 = 4;
            i2 = i5;
          }
        }
        i5 = i1 + i2;
        i3 = i1;
        i6 = i7;
        i1 = i5;
      }
      else
      {
        i1 = i3;
        i3 = i4;
        i2 = i5;
      }
      i3 += this.u;
      if (i3 < this.f)
      {
        int i8 = i3 * this.e;
        i7 = this.t + i8;
        i5 = this.v + i7;
        i3 = i5;
        if (this.e + i8 < i5) {
          i3 = this.e + i8;
        }
        i5 = this.v * i4;
        while (i7 < i3)
        {
          i8 = this.M[i5];
          i8 = this.l[(i8 & 0xFF)];
          if (i8 != 0) {
            arrayOfInt[i7] = i8;
          }
          i7 += 1;
          i5 += 1;
        }
      }
      i4 += 1;
      i3 = i1;
    }
    a = Bitmap.createBitmap(arrayOfInt, this.e, this.f, Bitmap.Config.RGB_565);
  }
  
  public Bitmap e()
  {
    this.B += 1;
    if (this.B > this.N.size() - 1) {
      this.B = 0;
    }
    return ((a)this.N.elementAt(this.B)).a;
  }
  
  protected void f()
  {
    int i22 = this.v * this.w;
    if ((this.M == null) || (this.M.length < i22)) {
      this.M = new byte[i22];
    }
    if (this.J == null) {
      this.J = new short[4096];
    }
    if (this.K == null) {
      this.K = new byte[4096];
    }
    if (this.L == null) {
      this.L = new byte[4097];
    }
    int i2 = i();
    int i21 = 1 << i2;
    int i16 = i21 + 2;
    i2 += 1;
    int i17 = (1 << i2) - 1;
    int i3 = 0;
    while (i3 < i21)
    {
      this.J[i3] = 0;
      this.K[i3] = ((byte)i3);
      i3 += 1;
    }
    int i4 = i2;
    int i13 = i16;
    i3 = i17;
    int i5 = -1;
    int i18 = 0;
    int i6 = 0;
    int i8 = 0;
    int i11 = 0;
    int i9 = 0;
    int i12 = 0;
    int i14 = 0;
    int i10 = 0;
    int i7 = i21;
    label636:
    while (i18 < i22)
    {
      int i15;
      if (i6 == 0)
      {
        if (i8 < i4)
        {
          i15 = i11;
          if (i11 == 0)
          {
            i15 = j();
            if (i15 <= 0) {
              break;
            }
            i12 = 0;
          }
          i9 += ((this.C[i12] & 0xFF) << i8);
          i8 += 8;
          i12 += 1;
          i11 = i15 - 1;
          continue;
        }
        i15 = i9 & i3;
        i9 >>= i4;
        int i19 = i8 - i4;
        if ((i15 > i13) || (i15 == i21 + 1)) {
          break;
        }
        if (i15 == i7)
        {
          i4 = i2;
          i13 = i16;
          i3 = i17;
          i5 = -1;
          i8 = i19;
          break label636;
        }
        if (i5 == -1)
        {
          this.L[i6] = this.K[i15];
          i5 = i15;
          i14 = i5;
          i6 += 1;
          i8 = i19;
          break label636;
        }
        if (i15 == i13)
        {
          arrayOfByte = this.L;
          i20 = i6 + 1;
          arrayOfByte[i6] = ((byte)i14);
          i8 = i5;
          i6 = i20;
        }
        else
        {
          i8 = i15;
        }
        while (i8 > i7)
        {
          this.L[i6] = this.K[i8];
          i8 = this.J[i8];
          i6 += 1;
        }
        int i20 = i7;
        i14 = this.K[i8] & 0xFF;
        if (i13 >= 4096) {
          break;
        }
        byte[] arrayOfByte = this.L;
        i8 = i6 + 1;
        int i1 = (byte)i14;
        arrayOfByte[i6] = i1;
        this.J[i13] = ((short)i5);
        this.K[i13] = i1;
        i13 += 1;
        if ((i13 & i3) == 0)
        {
          i7 = i4;
          i6 = i3;
          if (i13 < 4096)
          {
            i7 = i4 + 1;
            i6 = i3 + i13;
          }
        }
        else
        {
          i6 = i3;
          i7 = i4;
        }
        i5 = i15;
        i15 = i8;
        i8 = i19;
        i4 = i7;
        i3 = i6;
        i7 = i20;
      }
      else
      {
        i15 = i6;
      }
      i6 = i15 - 1;
      this.M[i10] = this.L[i6];
      i18 += 1;
      i10 += 1;
    }
    while (i10 < i22)
    {
      this.M[i10] = 0;
      i10 += 1;
    }
  }
  
  protected boolean g()
  {
    return this.c != 0;
  }
  
  protected void h()
  {
    this.c = 0;
    this.O = 0;
    this.N = new Vector();
    this.j = null;
    this.k = null;
  }
  
  protected int i()
  {
    try
    {
      int i1 = this.d.read();
      return i1;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    this.c = 1;
    return 0;
  }
  
  protected int j()
  {
    this.D = i();
    int i3 = this.D;
    int i2 = 0;
    int i1 = 0;
    if (i3 > 0) {}
    try
    {
      while (i1 < this.D)
      {
        i2 = this.d.read(this.C, i1, this.D - i1);
        if (i2 == -1) {
          break;
        }
        i1 += i2;
      }
    }
    catch (Exception localException)
    {
      label63:
      break label63;
    }
    i2 = i1;
    if (i1 < this.D)
    {
      this.c = 1;
      i2 = i1;
    }
    return i2;
  }
  
  protected void k()
  {
    int i1 = 0;
    while ((i1 == 0) && (!g()))
    {
      int i2 = i();
      if (i2 != 0) {
        if (i2 != 33)
        {
          if (i2 != 44)
          {
            if (i2 != 59) {
              this.c = 1;
            } else {
              i1 = 1;
            }
          }
          else {
            n();
          }
        }
        else
        {
          i2 = i();
          if (i2 != 249)
          {
            if (i2 != 255)
            {
              s();
            }
            else
            {
              j();
              String str = "";
              i2 = 0;
              while (i2 < 11)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str);
                localStringBuilder.append((char)this.C[i2]);
                str = localStringBuilder.toString();
                i2 += 1;
              }
              if (str.equals("NETSCAPE2.0")) {
                p();
              } else {
                s();
              }
            }
          }
          else {
            l();
          }
        }
      }
    }
  }
  
  protected void l()
  {
    i();
    int i1 = i();
    this.E = ((i1 & 0x1C) >> 2);
    int i2 = this.E;
    boolean bool = true;
    if (i2 == 0) {
      this.E = 1;
    }
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    this.G = bool;
    this.H = (q() * 10);
    this.I = i();
    i();
  }
  
  protected void m()
  {
    int i2 = 0;
    String str = "";
    int i1 = 0;
    while (i1 < 6)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((char)i());
      str = localStringBuilder.toString();
      i1 += 1;
    }
    if (!str.startsWith("GIF"))
    {
      this.c = 1;
      return;
    }
    o();
    if ((this.g) && (!g()))
    {
      this.j = b(this.h);
      if (this.j == null) {
        i1 = i2;
      } else {
        i1 = this.j[this.m];
      }
      this.n = i1;
    }
  }
  
  protected void n()
  {
    this.t = q();
    this.u = q();
    this.v = q();
    this.w = q();
    int i1 = i();
    boolean bool;
    if ((i1 & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.q = bool;
    if ((i1 & 0x40) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.r = bool;
    this.s = (2 << (i1 & 0x7));
    if (this.q)
    {
      this.k = b(this.s);
      this.l = this.k;
    }
    else
    {
      this.l = this.j;
      if (this.m == this.I) {
        this.n = 0;
      }
    }
    if (this.l == null) {
      this.c = 1;
    }
    if (g()) {
      return;
    }
    if (this.G)
    {
      i1 = this.l[this.I];
      this.l[this.I] = 0;
    }
    else
    {
      i1 = 0;
    }
    f();
    s();
    if (g()) {
      return;
    }
    this.O += 1;
    a = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.RGB_565);
    d();
    this.N.addElement(new a(a, this.H));
    if (this.G) {
      this.l[this.I] = i1;
    }
    r();
  }
  
  protected void o()
  {
    this.e = q();
    this.f = q();
    int i1 = i();
    boolean bool;
    if ((i1 & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    this.h = (2 << (i1 & 0x7));
    this.m = i();
    this.p = i();
  }
  
  protected void p()
  {
    do
    {
      j();
      if (this.C[0] == 1) {
        this.i = (this.C[1] & 0xFF | (this.C[2] & 0xFF) << 8);
      }
    } while ((this.D > 0) && (!g()));
  }
  
  protected int q()
  {
    return i() | i() << 8;
  }
  
  protected void r()
  {
    this.F = this.E;
    this.x = this.t;
    this.y = this.u;
    this.z = this.v;
    this.A = this.w;
    b = a;
    this.o = this.n;
    this.E = 0;
    this.G = false;
    this.H = 0;
    this.k = null;
  }
  
  protected void s()
  {
    do
    {
      j();
    } while ((this.D > 0) && (!g()));
  }
  
  static class a
  {
    public Bitmap a;
    public int b;
    
    public a(Bitmap paramBitmap, int paramInt)
    {
      this.a = paramBitmap;
      this.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gm
 * JD-Core Version:    0.7.0.1
 */