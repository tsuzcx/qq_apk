package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int bWx = 0;
  final OutputStream czX;
  final ByteArrayOutputStream czY = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.czX = paramOutputStream;
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
  
  public final void HB()
  {
    try
    {
      this.czX.flush();
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
      this.czX.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.czX, (int)paramLong);
      this.czX.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.czX.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.czX, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.czX.write(localb.cAf);
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
      this.czX.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.czX, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt1);
      this.czX.write(paramb1.cAf);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt2);
      this.czX.write(paramb2.cAf);
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
      this.czX.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.czX, (int)paramLong);
      this.czX.write(paramb1.cAf);
      this.czX.write(paramb2.cAf);
      this.czX.write(paramb3.cAf);
      this.czX.write(paramb4.cAf);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt2);
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
      this.czX.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.czX, (int)paramLong);
      this.czX.write(paramb.cAf);
      paramb = this.czX;
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
    this.bWx = paramInt;
    OutputStream localOutputStream = this.czX;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.czX, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.czX, paramLong);
  }
  
  final class a
    extends b
  {
    private final long cAa;
    private final int czZ;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.czZ = paramInt2;
      this.cAa = paramLong;
    }
    
    public final void HB()
    {
      try
      {
        e.this.czX.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.czX, this.czZ);
        com.tencent.matrix.resource.c.b.a.b(e.this.czX, e.this.czY.size());
        e.this.czX.write(e.this.czY.toByteArray());
        e.this.czY.reset();
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
        e.this.czY.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt);
        e.this.czY.write(paramb.cAf);
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
        e.this.czY.write(paramInt1);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt3);
        e.this.czY.write(paramInt4);
        paramInt1 = c.hl(paramInt4).getSize(e.this.bWx);
        e.this.czY.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.czY.write(4);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt);
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
        e.this.czY.write(2);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
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
        e.this.czY.write(34);
        e.this.czY.write(paramb1.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
        e.this.czY.write(paramb2.cAf);
        paramInt1 = e.this.bWx;
        e.this.czY.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.czY.write(32);
        e.this.czY.write(paramb1.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        e.this.czY.write(paramb2.cAf);
        e.this.czY.write(paramb3.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, e.this.bWx << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.czY, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.czY, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.czY, paramb2.cAd);
        e.this.czY.write(paramb2.cAc);
        paramb1 = e.this.czY;
        paramb2 = paramb2.cAe;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.czY, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.czY, paramb1.cAd);
            e.this.czY.write(paramb1.cAc);
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
        e.this.czY.write(33);
        e.this.czY.write(paramb1.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt);
        e.this.czY.write(paramb2.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramArrayOfByte.length);
        e.this.czY.write(paramArrayOfByte);
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
        e.this.czY.write(paramInt);
        e.this.czY.write(paramb.cAf);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.czY, e.this.bWx);
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
        e.this.czY.write(6);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt);
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
        e.this.czY.write(3);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
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
        e.this.czY.write(8);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
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
        e.this.czY.write(142);
        e.this.czY.write(paramb.cAf);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.czY, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.c.e
 * JD-Core Version:    0.7.0.1
 */