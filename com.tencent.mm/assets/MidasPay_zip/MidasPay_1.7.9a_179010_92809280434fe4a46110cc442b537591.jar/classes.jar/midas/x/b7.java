package midas.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.InputStream;
import java.util.Vector;

public class b7
{
  public static Bitmap L;
  public static Bitmap M;
  public static b7 N = new b7();
  public int A = 0;
  public int B = 0;
  public boolean C = false;
  public int D = 0;
  public int E;
  public short[] F;
  public byte[] G;
  public byte[] H;
  public byte[] I;
  public Vector<a> J;
  public int K;
  public int a;
  public InputStream b;
  public int c;
  public int d;
  public boolean e;
  public int f;
  public int[] g;
  public int[] h;
  public int[] i;
  public int j;
  public int k;
  public int l;
  public boolean m;
  public boolean n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  public int x = 0;
  public byte[] y = new byte[256];
  public int z = 0;
  
  public static b7 s()
  {
    return N;
  }
  
  public int a(InputStream paramInputStream)
  {
    e();
    if (paramInputStream != null)
    {
      this.b = paramInputStream;
      k();
      if (!b())
      {
        i();
        if (this.K < 0) {
          this.a = 1;
        }
      }
    }
    else
    {
      this.a = 2;
    }
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      label56:
      return this.a;
    }
    catch (Exception paramInputStream)
    {
      break label56;
    }
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.K)) {
      return ((a)this.J.elementAt(paramInt)).a;
    }
    return null;
  }
  
  public void a()
  {
    int i23 = this.r * this.s;
    byte[] arrayOfByte1 = this.I;
    if ((arrayOfByte1 == null) || (arrayOfByte1.length < i23)) {
      this.I = new byte[i23];
    }
    if (this.F == null) {
      this.F = new short[4096];
    }
    if (this.G == null) {
      this.G = new byte[4096];
    }
    if (this.H == null) {
      this.H = new byte[4097];
    }
    int i2 = g();
    int i7 = 1 << i2;
    int i18 = i7 + 1;
    int i16 = i7 + 2;
    i2 += 1;
    int i17 = (1 << i2) - 1;
    int i3 = 0;
    while (i3 < i7)
    {
      this.F[i3] = 0;
      this.G[i3] = ((byte)i3);
      i3 += 1;
    }
    int i5 = i2;
    int i14 = i16;
    int i4 = i17;
    int i6 = -1;
    int i19 = 0;
    i3 = 0;
    int i9 = 0;
    int i10 = 0;
    int i12 = 0;
    int i13 = 0;
    int i8 = 0;
    int i11 = 0;
    while (i19 < i23)
    {
      label367:
      int i21;
      if (i3 == 0)
      {
        if (i9 < i5)
        {
          i15 = i12;
          if (i12 == 0)
          {
            i15 = h();
            if (i15 <= 0) {
              break;
            }
            i13 = 0;
          }
          i10 += ((this.y[i13] & 0xFF) << i9);
          i9 += 8;
          i13 += 1;
          i12 = i15 - 1;
          continue;
        }
        i15 = i10 & i4;
        i10 >>= i5;
        i9 -= i5;
        if ((i15 > i14) || (i15 == i18)) {
          break;
        }
        if (i15 == i7)
        {
          i5 = i2;
          i14 = i16;
          i4 = i17;
          i6 = -1;
        }
        for (;;)
        {
          break;
          if (i6 != -1) {
            break label367;
          }
          this.H[i3] = this.G[i15];
          i6 = i15;
          i8 = i6;
          i3 += 1;
        }
        if (i15 == i14)
        {
          arrayOfByte1 = this.H;
          i20 = i3 + 1;
          arrayOfByte1[i3] = ((byte)i8);
          i8 = i6;
          i3 = i20;
        }
        else
        {
          i8 = i15;
        }
        while (i8 > i7)
        {
          this.H[i3] = this.G[i8];
          i8 = this.F[i8];
          i3 += 1;
        }
        i20 = i7;
        arrayOfByte1 = this.G;
        int i22 = arrayOfByte1[i8] & 0xFF;
        if (i14 >= 4096) {
          break;
        }
        byte[] arrayOfByte2 = this.H;
        i21 = i3 + 1;
        int i1 = (byte)i22;
        arrayOfByte2[i3] = i1;
        this.F[i14] = ((short)i6);
        arrayOfByte1[i14] = i1;
        i14 += 1;
        i7 = i5;
        i6 = i4;
        if ((i14 & i4) == 0)
        {
          i7 = i5;
          i6 = i4;
          if (i14 < 4096)
          {
            i7 = i5 + 1;
            i6 = i4 + i14;
          }
        }
        i8 = i15;
        i3 = i22;
        i5 = i7;
        i4 = i6;
        i7 = i20;
      }
      else
      {
        i15 = i8;
        i21 = i3;
        i8 = i6;
        i3 = i15;
      }
      int i20 = i21 - 1;
      this.I[i11] = this.H[i20];
      i19 += 1;
      int i15 = i11 + 1;
      i11 = i3;
      i6 = i8;
      i3 = i20;
      i8 = i11;
      i11 = i15;
    }
    while (i11 < i23)
    {
      this.I[i11] = 0;
      i11 += 1;
    }
  }
  
  public boolean b()
  {
    return this.a != 0;
  }
  
  public int[] b(int paramInt)
  {
    int i2 = paramInt * 3;
    byte[] arrayOfByte = new byte[i2];
    int i3 = 0;
    try
    {
      i1 = this.b.read(arrayOfByte);
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
      this.a = 1;
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
    return this.d;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void e()
  {
    this.a = 0;
    this.K = 0;
    this.J = new Vector();
    this.g = null;
    this.h = null;
  }
  
  public Bitmap f()
  {
    this.x += 1;
    if (this.x > this.J.size() - 1) {
      this.x = 0;
    }
    return ((a)this.J.elementAt(this.x)).a;
  }
  
  public int g()
  {
    try
    {
      int i1 = this.b.read();
      return i1;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    this.a = 1;
    return 0;
  }
  
  public int h()
  {
    this.z = g();
    int i3 = this.z;
    int i2 = 0;
    int i1 = 0;
    if (i3 > 0) {}
    try
    {
      while (i1 < this.z)
      {
        i2 = this.b.read(this.y, i1, this.z - i1);
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
    if (i1 < this.z)
    {
      this.a = 1;
      i2 = i1;
    }
    return i2;
  }
  
  public void i()
  {
    int i1 = 0;
    while ((i1 == 0) && (!b()))
    {
      int i2 = g();
      if (i2 != 0) {
        if (i2 != 33)
        {
          if (i2 != 44)
          {
            if (i2 != 59) {
              this.a = 1;
            } else {
              i1 = 1;
            }
          }
          else {
            l();
          }
        }
        else
        {
          i2 = g();
          if (i2 != 249)
          {
            if (i2 != 255)
            {
              r();
            }
            else
            {
              h();
              String str = "";
              i2 = 0;
              while (i2 < 11)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str);
                localStringBuilder.append((char)this.y[i2]);
                str = localStringBuilder.toString();
                i2 += 1;
              }
              if (str.equals("NETSCAPE2.0")) {
                n();
              } else {
                r();
              }
            }
          }
          else {
            j();
          }
        }
      }
    }
  }
  
  public void j()
  {
    g();
    int i1 = g();
    this.A = ((i1 & 0x1C) >> 2);
    int i2 = this.A;
    boolean bool = true;
    if (i2 == 0) {
      this.A = 1;
    }
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    this.C = bool;
    this.D = (o() * 10);
    this.E = g();
    g();
  }
  
  public void k()
  {
    int i2 = 0;
    Object localObject = "";
    int i1 = 0;
    while (i1 < 6)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append((char)g());
      localObject = localStringBuilder.toString();
      i1 += 1;
    }
    if (!((String)localObject).startsWith("GIF"))
    {
      this.a = 1;
      return;
    }
    m();
    if ((this.e) && (!b()))
    {
      this.g = b(this.f);
      localObject = this.g;
      if (localObject == null) {
        i1 = i2;
      } else {
        i1 = localObject[this.j];
      }
      this.k = i1;
    }
  }
  
  public void l()
  {
    this.p = o();
    this.q = o();
    this.r = o();
    this.s = o();
    int i2 = g();
    int i1 = 0;
    boolean bool;
    if ((i2 & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    if ((i2 & 0x40) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.n = bool;
    this.o = (2 << (i2 & 0x7));
    if (this.m)
    {
      this.h = b(this.o);
      this.i = this.h;
    }
    else
    {
      this.i = this.g;
      if (this.j == this.E) {
        this.k = 0;
      }
    }
    if (this.i == null) {
      this.a = 1;
    }
    if (b()) {
      return;
    }
    if (this.C)
    {
      int[] arrayOfInt = this.i;
      i2 = this.E;
      i1 = arrayOfInt[i2];
      arrayOfInt[i2] = 0;
    }
    a();
    r();
    if (b()) {
      return;
    }
    this.K += 1;
    L = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.RGB_565);
    q();
    this.J.addElement(new a(L, this.D));
    if (this.C) {
      this.i[this.E] = i1;
    }
    p();
  }
  
  public void m()
  {
    this.c = o();
    this.d = o();
    int i1 = g();
    boolean bool;
    if ((i1 & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.f = (2 << (i1 & 0x7));
    this.j = g();
    g();
  }
  
  public void n()
  {
    do
    {
      h();
      byte[] arrayOfByte = this.y;
      if (arrayOfByte[0] == 1)
      {
        int i1 = arrayOfByte[1];
        i1 = arrayOfByte[2];
      }
    } while ((this.z > 0) && (!b()));
  }
  
  public int o()
  {
    return g() | g() << 8;
  }
  
  public void p()
  {
    this.B = this.A;
    this.t = this.p;
    this.u = this.q;
    this.v = this.r;
    this.w = this.s;
    M = L;
    this.l = this.k;
    this.A = 0;
    this.C = false;
    this.D = 0;
    this.h = null;
  }
  
  public void q()
  {
    int[] arrayOfInt = new int[this.c * this.d];
    int i1 = this.B;
    int i4 = 0;
    int i2;
    if (i1 > 0)
    {
      if (i1 == 3)
      {
        i1 = this.K - 2;
        if (i1 > 0) {
          M = a(i1 - 1);
        } else {
          M = null;
        }
      }
      Bitmap localBitmap = M;
      if (localBitmap != null)
      {
        i1 = this.c;
        localBitmap.getPixels(arrayOfInt, 0, i1, 0, 0, i1, this.d);
        if (this.B == 2)
        {
          if (!this.C) {
            i2 = this.l;
          } else {
            i2 = 0;
          }
          i3 = 0;
          while (i3 < this.w)
          {
            i5 = (this.u + i3) * this.c + this.t;
            i6 = this.v;
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
    for (int i5 = 8;; i5 = i2)
    {
      int i8 = this.s;
      if (i4 >= i8) {
        break;
      }
      int i7;
      if (this.n)
      {
        i1 = i3;
        i7 = i6;
        i2 = i5;
        if (i3 >= i8)
        {
          i7 = i6 + 1;
          if (i7 != 2)
          {
            if (i7 != 3)
            {
              if (i7 != 4)
              {
                i1 = i3;
                i2 = i5;
              }
              else
              {
                i1 = 1;
                i2 = 2;
              }
            }
            else
            {
              i1 = 2;
              i2 = 4;
            }
          }
          else
          {
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
      i3 += this.q;
      if (i3 < this.d)
      {
        i8 = this.c;
        int i9 = i3 * i8;
        i7 = this.p + i9;
        i5 = this.r + i7;
        i3 = i5;
        if (i9 + i8 < i5) {
          i3 = i9 + i8;
        }
        i5 = this.r * i4;
        while (i7 < i3)
        {
          i8 = this.I[i5];
          i8 = this.i[(i8 & 0xFF)];
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
    L = Bitmap.createBitmap(arrayOfInt, this.c, this.d, Bitmap.Config.RGB_565);
  }
  
  public void r()
  {
    do
    {
      h();
    } while ((this.z > 0) && (!b()));
  }
  
  public static class a
  {
    public Bitmap a;
    
    public a(Bitmap paramBitmap, int paramInt)
    {
      this.a = paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b7
 * JD-Core Version:    0.7.0.1
 */