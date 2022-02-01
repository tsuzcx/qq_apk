package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  final OutputStream cIK;
  final ByteArrayOutputStream cIL = new ByteArrayOutputStream();
  int ces = 0;
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.cIK = paramOutputStream;
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
  
  public final void IP()
  {
    try
    {
      this.cIK.flush();
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
      this.cIK.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, (int)paramLong);
      this.cIK.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.cIK.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.cIK.write(localb.cIS);
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
      this.cIK.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt1);
      this.cIK.write(paramb1.cIS);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt2);
      this.cIK.write(paramb2.cIS);
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
      this.cIK.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, (int)paramLong);
      this.cIK.write(paramb1.cIS);
      this.cIK.write(paramb2.cIS);
      this.cIK.write(paramb3.cIS);
      this.cIK.write(paramb4.cIS);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt2);
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
      this.cIK.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.cIK, (int)paramLong);
      this.cIK.write(paramb.cIS);
      paramb = this.cIK;
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
    this.ces = paramInt;
    OutputStream localOutputStream = this.cIK;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.cIK, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.cIK, paramLong);
  }
  
  final class a
    extends b
  {
    private final int cIM;
    private final long cIN;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.cIM = paramInt2;
      this.cIN = paramLong;
    }
    
    public final void IP()
    {
      try
      {
        e.this.cIK.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIK, this.cIM);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIK, e.this.cIL.size());
        e.this.cIK.write(e.this.cIL.toByteArray());
        e.this.cIL.reset();
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
        e.this.cIL.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt);
        e.this.cIL.write(paramb.cIS);
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
        e.this.cIL.write(paramInt1);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt3);
        e.this.cIL.write(paramInt4);
        paramInt1 = c.ha(paramInt4).getSize(e.this.ces);
        e.this.cIL.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.cIL.write(4);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt);
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
        e.this.cIL.write(2);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
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
        e.this.cIL.write(34);
        e.this.cIL.write(paramb1.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
        e.this.cIL.write(paramb2.cIS);
        paramInt1 = e.this.ces;
        e.this.cIL.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.cIL.write(32);
        e.this.cIL.write(paramb1.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        e.this.cIL.write(paramb2.cIS);
        e.this.cIL.write(paramb3.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, e.this.ces << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.cIL, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.cIL, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.cIL, paramb2.cIQ);
        e.this.cIL.write(paramb2.cIP);
        paramb1 = e.this.cIL;
        paramb2 = paramb2.cIR;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.cIL, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.cIL, paramb1.cIQ);
            e.this.cIL.write(paramb1.cIP);
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
        e.this.cIL.write(33);
        e.this.cIL.write(paramb1.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt);
        e.this.cIL.write(paramb2.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramArrayOfByte.length);
        e.this.cIL.write(paramArrayOfByte);
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
        e.this.cIL.write(paramInt);
        e.this.cIL.write(paramb.cIS);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.cIL, e.this.ces);
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
        e.this.cIL.write(6);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt);
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
        e.this.cIL.write(3);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
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
        e.this.cIL.write(8);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
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
        e.this.cIL.write(142);
        e.this.cIL.write(paramb.cIS);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIL, paramInt2);
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