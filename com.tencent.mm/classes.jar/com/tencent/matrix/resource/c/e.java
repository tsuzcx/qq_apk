package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int bUf = 0;
  final OutputStream cxg;
  final ByteArrayOutputStream cxh = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.cxg = paramOutputStream;
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
  
  public final void Hm()
  {
    try
    {
      this.cxg.flush();
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
      this.cxg.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, (int)paramLong);
      this.cxg.write(paramArrayOfByte, 0, (int)paramLong);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.matrix.resource.c.a.b[] paramArrayOfb, int paramInt3, long paramLong)
  {
    try
    {
      this.cxg.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.cxg.write(localb.cxo);
        paramInt1 += 1;
      }
      return;
    }
    catch (Throwable paramArrayOfb)
    {
      throw new RuntimeException(paramArrayOfb);
    }
  }
  
  public final void a(int paramInt1, com.tencent.matrix.resource.c.a.b paramb1, int paramInt2, com.tencent.matrix.resource.c.a.b paramb2, int paramInt3, long paramLong)
  {
    try
    {
      this.cxg.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt1);
      this.cxg.write(paramb1.cxo);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt2);
      this.cxg.write(paramb2.cxo);
      return;
    }
    catch (Throwable paramb1)
    {
      throw new RuntimeException(paramb1);
    }
  }
  
  public final void a(com.tencent.matrix.resource.c.a.b paramb1, com.tencent.matrix.resource.c.a.b paramb2, com.tencent.matrix.resource.c.a.b paramb3, com.tencent.matrix.resource.c.a.b paramb4, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      this.cxg.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, (int)paramLong);
      this.cxg.write(paramb1.cxo);
      this.cxg.write(paramb2.cxo);
      this.cxg.write(paramb3.cxo);
      this.cxg.write(paramb4.cxo);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt2);
      return;
    }
    catch (Throwable paramb1)
    {
      throw new RuntimeException(paramb1);
    }
  }
  
  public final void a(com.tencent.matrix.resource.c.a.b paramb, String paramString, int paramInt, long paramLong)
  {
    try
    {
      this.cxg.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.cxg, (int)paramLong);
      this.cxg.write(paramb.cxo);
      paramb = this.cxg;
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
    this.bUf = paramInt;
    OutputStream localOutputStream = this.cxg;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.cxg, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.cxg, paramLong);
  }
  
  final class a
    extends b
  {
    private final int cxi;
    private final long cxj;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.cxi = paramInt2;
      this.cxj = paramLong;
    }
    
    public final void Hm()
    {
      try
      {
        e.this.cxg.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxg, this.cxi);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxg, e.this.cxh.size());
        e.this.cxg.write(e.this.cxh.toByteArray());
        e.this.cxh.reset();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException(localThrowable);
      }
    }
    
    public final void a(int paramInt, com.tencent.matrix.resource.c.a.b paramb)
    {
      try
      {
        e.this.cxh.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt);
        e.this.cxh.write(paramb.cxo);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(int paramInt1, com.tencent.matrix.resource.c.a.b paramb, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.cxh.write(paramInt1);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt3);
        e.this.cxh.write(paramInt4);
        paramInt1 = c.gU(paramInt4).getSize(e.this.bUf);
        e.this.cxh.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.c.a.b paramb, int paramInt)
    {
      try
      {
        e.this.cxh.write(4);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.c.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.cxh.write(2);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void a(com.tencent.matrix.resource.c.a.b paramb1, int paramInt1, int paramInt2, com.tencent.matrix.resource.c.a.b paramb2, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.cxh.write(34);
        e.this.cxh.write(paramb1.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        e.this.cxh.write(paramb2.cxo);
        paramInt1 = e.this.bUf;
        e.this.cxh.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
        return;
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
    }
    
    public final void a(com.tencent.matrix.resource.c.a.b paramb1, int paramInt1, com.tencent.matrix.resource.c.a.b paramb2, com.tencent.matrix.resource.c.a.b paramb3, int paramInt2, com.tencent.matrix.resource.c.a.a[] paramArrayOfa1, com.tencent.matrix.resource.c.a.a[] paramArrayOfa2)
    {
      try
      {
        e.this.cxh.write(32);
        e.this.cxh.write(paramb1.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        e.this.cxh.write(paramb2.cxo);
        e.this.cxh.write(paramb3.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, e.this.bUf << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.cxh, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.cxh, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.cxh, paramb2.cxm);
        e.this.cxh.write(paramb2.cxl);
        paramb1 = e.this.cxh;
        paramb2 = paramb2.cxn;
        if (paramb2 == null) {
          throw new IllegalArgumentException("value is null.");
        }
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
      if ((paramb2 instanceof com.tencent.matrix.resource.c.a.b)) {
        com.tencent.matrix.resource.c.b.a.a(paramb1, (com.tencent.matrix.resource.c.a.b)paramb2);
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
          com.tencent.matrix.resource.c.b.a.a(paramb1, ((Character)paramb2).charValue());
        }
        else if (((paramb2 instanceof Float)) || (Float.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.c.b.a.b(paramb1, Float.floatToRawIntBits(((Float)paramb2).floatValue()));
        }
        else if (((paramb2 instanceof Double)) || (Double.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.c.b.a.a(paramb1, Double.doubleToRawLongBits(((Double)paramb2).doubleValue()));
        }
        else if (((paramb2 instanceof Byte)) || (Byte.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          paramb1.write(((Byte)paramb2).byteValue());
        }
        else if (((paramb2 instanceof Short)) || (Short.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.c.b.a.a(paramb1, ((Short)paramb2).shortValue());
        }
        else if (((paramb2 instanceof Integer)) || (Integer.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.c.b.a.b(paramb1, ((Integer)paramb2).intValue());
        }
        else if (((paramb2 instanceof Long)) || (Long.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.c.b.a.a(paramb1, ((Long)paramb2).longValue());
        }
        else
        {
          throw new IllegalArgumentException("bad value type: " + paramb2.getClass().getName());
          com.tencent.matrix.resource.c.b.a.a(e.this.cxh, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.cxh, paramb1.cxm);
            e.this.cxh.write(paramb1.cxl);
            paramInt1 += 1;
          }
          return;
        }
        paramInt1 += 1;
        break;
      }
    }
    
    public final void a(com.tencent.matrix.resource.c.a.b paramb1, int paramInt, com.tencent.matrix.resource.c.a.b paramb2, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.cxh.write(33);
        e.this.cxh.write(paramb1.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt);
        e.this.cxh.write(paramb2.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramArrayOfByte.length);
        e.this.cxh.write(paramArrayOfByte);
        return;
      }
      catch (Throwable paramb1)
      {
        throw new RuntimeException(paramb1);
      }
    }
    
    public final void b(int paramInt, com.tencent.matrix.resource.c.a.b paramb)
    {
      try
      {
        e.this.cxh.write(paramInt);
        e.this.cxh.write(paramb.cxo);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.cxh, e.this.bUf);
        }
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void b(com.tencent.matrix.resource.c.a.b paramb, int paramInt)
    {
      try
      {
        e.this.cxh.write(6);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void b(com.tencent.matrix.resource.c.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.cxh.write(3);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void c(com.tencent.matrix.resource.c.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.cxh.write(8);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void d(com.tencent.matrix.resource.c.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.cxh.write(142);
        e.this.cxh.write(paramb.cxo);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cxh, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.e
 * JD-Core Version:    0.7.0.1
 */