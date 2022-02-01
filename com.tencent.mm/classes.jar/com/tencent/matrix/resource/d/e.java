package com.tencent.matrix.resource.d;

import com.tencent.matrix.resource.d.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int ckw = 0;
  final OutputStream ddr;
  final ByteArrayOutputStream dds = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.ddr = paramOutputStream;
  }
  
  private a c(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      a locala = new a(paramInt1, paramInt2, paramLong);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }
  
  public final void XJ()
  {
    try
    {
      this.ddr.flush();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    try
    {
      this.ddr.write(paramInt1);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt2);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, (int)paramLong);
      this.ddr.write(paramArrayOfByte, 0, (int)paramLong);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.matrix.resource.d.a.b[] paramArrayOfb, int paramInt3, long paramLong)
  {
    try
    {
      this.ddr.write(5);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt3);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, (int)paramLong);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt1);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt2);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.d.a.b localb = paramArrayOfb[paramInt1];
        this.ddr.write(localb.ddA);
        paramInt1 += 1;
      }
      return;
    }
    catch (Throwable paramArrayOfb)
    {
      throw new RuntimeException(paramArrayOfb);
    }
  }
  
  public final void a(int paramInt1, com.tencent.matrix.resource.d.a.b paramb1, int paramInt2, com.tencent.matrix.resource.d.a.b paramb2, int paramInt3, long paramLong)
  {
    try
    {
      this.ddr.write(2);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt3);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, (int)paramLong);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt1);
      this.ddr.write(paramb1.ddA);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt2);
      this.ddr.write(paramb2.ddA);
      return;
    }
    catch (Throwable paramb1)
    {
      throw new RuntimeException(paramb1);
    }
  }
  
  public final void a(com.tencent.matrix.resource.d.a.b paramb1, com.tencent.matrix.resource.d.a.b paramb2, com.tencent.matrix.resource.d.a.b paramb3, com.tencent.matrix.resource.d.a.b paramb4, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      this.ddr.write(4);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt3);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, (int)paramLong);
      this.ddr.write(paramb1.ddA);
      this.ddr.write(paramb2.ddA);
      this.ddr.write(paramb3.ddA);
      this.ddr.write(paramb4.ddA);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt1);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt2);
      return;
    }
    catch (Throwable paramb1)
    {
      throw new RuntimeException(paramb1);
    }
  }
  
  public final void a(com.tencent.matrix.resource.d.a.b paramb, String paramString, int paramInt, long paramLong)
  {
    try
    {
      this.ddr.write(1);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt);
      com.tencent.matrix.resource.d.b.a.b(this.ddr, (int)paramLong);
      this.ddr.write(paramb.ddA);
      paramb = this.ddr;
      paramInt = paramString.length();
      paramb.write(paramString.getBytes(Charset.forName("UTF-8")), 0, paramInt);
      return;
    }
    catch (Throwable paramb)
    {
      throw new RuntimeException(paramb);
    }
  }
  
  public final void a(String paramString, int paramInt, long paramLong)
  {
    if ((paramInt <= 0) || (paramInt >= 1073741823)) {
      try
      {
        throw new IOException("bad idSize: ".concat(String.valueOf(paramInt)));
      }
      catch (Throwable paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    this.ckw = paramInt;
    OutputStream localOutputStream = this.ddr;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.d.b.a.b(this.ddr, paramInt);
    com.tencent.matrix.resource.d.b.a.c(this.ddr, paramLong);
  }
  
  final class a
    extends b
  {
    private final int ddt;
    private final int ddu;
    private final long ddv;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.ddt = paramInt1;
      this.ddu = paramInt2;
      this.ddv = paramLong;
    }
    
    public final void XJ()
    {
      try
      {
        e.this.ddr.write(this.ddt);
        com.tencent.matrix.resource.d.b.a.b(e.this.ddr, this.ddu);
        com.tencent.matrix.resource.d.b.a.b(e.this.ddr, e.this.dds.size());
        e.this.ddr.write(e.this.dds.toByteArray());
        e.this.dds.reset();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException(localThrowable);
      }
    }
    
    public final void a(int paramInt, com.tencent.matrix.resource.d.a.b paramb)
    {
      try
      {
        e.this.dds.write(254);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt);
        e.this.dds.write(paramb.ddA);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(int paramInt1, com.tencent.matrix.resource.d.a.b paramb, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.dds.write(paramInt1);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt3);
        e.this.dds.write(paramInt4);
        paramInt1 = c.jF(paramInt4).jG(e.this.ckw);
        e.this.dds.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb, int paramInt)
    {
      try
      {
        e.this.dds.write(4);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.dds.write(2);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb1, int paramInt1, int paramInt2, com.tencent.matrix.resource.d.a.b paramb2, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.dds.write(34);
        e.this.dds.write(paramb1.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        e.this.dds.write(paramb2.ddA);
        paramInt1 = e.this.ckw;
        e.this.dds.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
        return;
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb1, int paramInt1, com.tencent.matrix.resource.d.a.b paramb2, com.tencent.matrix.resource.d.a.b paramb3, int paramInt2, com.tencent.matrix.resource.d.a.a[] paramArrayOfa1, com.tencent.matrix.resource.d.a.a[] paramArrayOfa2)
    {
      try
      {
        e.this.dds.write(32);
        e.this.dds.write(paramb1.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        e.this.dds.write(paramb2.ddA);
        e.this.dds.write(paramb3.ddA);
        com.tencent.matrix.resource.d.b.a.d(e.this.dds, e.this.ckw << 2);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        com.tencent.matrix.resource.d.b.a.a(e.this.dds, 0);
        com.tencent.matrix.resource.d.b.a.a(e.this.dds, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.d.b.a.a(e.this.dds, paramb2.ddy);
        e.this.dds.write(paramb2.ddx);
        paramb1 = e.this.dds;
        paramb2 = paramb2.ddz;
        if (paramb2 == null) {
          throw new IllegalArgumentException("value is null.");
        }
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
      if ((paramb2 instanceof com.tencent.matrix.resource.d.a.b)) {
        com.tencent.matrix.resource.d.b.a.a(paramb1, (com.tencent.matrix.resource.d.a.b)paramb2);
      } else if (((paramb2 instanceof Boolean)) || (Boolean.TYPE.isAssignableFrom(paramb2.getClass()))) {
        if (!((Boolean)paramb2).booleanValue()) {
          break label613;
        }
      }
      label539:
      label606:
      label613:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        paramb1.write(paramInt2);
        break label606;
        if (((paramb2 instanceof Character)) || (Character.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.a(paramb1, ((Character)paramb2).charValue());
        }
        else if (((paramb2 instanceof Float)) || (Float.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.b(paramb1, Float.floatToRawIntBits(((Float)paramb2).floatValue()));
        }
        else if (((paramb2 instanceof Double)) || (Double.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.c(paramb1, Double.doubleToRawLongBits(((Double)paramb2).doubleValue()));
        }
        else if (((paramb2 instanceof Byte)) || (Byte.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          paramb1.write(((Byte)paramb2).byteValue());
        }
        else if (((paramb2 instanceof Short)) || (Short.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.a(paramb1, ((Short)paramb2).shortValue());
        }
        else if (((paramb2 instanceof Integer)) || (Integer.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.b(paramb1, ((Integer)paramb2).intValue());
        }
        else if (((paramb2 instanceof Long)) || (Long.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.c(paramb1, ((Long)paramb2).longValue());
        }
        else
        {
          throw new IllegalArgumentException("bad value type: " + paramb2.getClass().getName());
          com.tencent.matrix.resource.d.b.a.a(e.this.dds, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.d.b.a.a(e.this.dds, paramb1.ddy);
            e.this.dds.write(paramb1.ddx);
            paramInt1 += 1;
          }
          return;
        }
        paramInt1 += 1;
        break;
      }
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb1, int paramInt, com.tencent.matrix.resource.d.a.b paramb2, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.dds.write(33);
        e.this.dds.write(paramb1.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt);
        e.this.dds.write(paramb2.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramArrayOfByte.length);
        e.this.dds.write(paramArrayOfByte);
        return;
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
    }
    
    public final void b(int paramInt, com.tencent.matrix.resource.d.a.b paramb)
    {
      try
      {
        e.this.dds.write(paramInt);
        e.this.dds.write(paramb.ddA);
        if (paramInt == 1) {
          com.tencent.matrix.resource.d.b.a.d(e.this.dds, e.this.ckw);
        }
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void b(com.tencent.matrix.resource.d.a.b paramb, int paramInt)
    {
      try
      {
        e.this.dds.write(6);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void b(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.dds.write(3);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void c(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.dds.write(8);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void d(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.dds.write(142);
        e.this.dds.write(paramb.ddA);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt1);
        com.tencent.matrix.resource.d.b.a.b(e.this.dds, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.d.e
 * JD-Core Version:    0.7.0.1
 */