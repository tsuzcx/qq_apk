package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int bPk = 0;
  final OutputStream bPv;
  final ByteArrayOutputStream bPw = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.bPv = paramOutputStream;
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
  
  public final void a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    try
    {
      this.bPv.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, (int)paramLong);
      this.bPv.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.bPv.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.bPv.write(localb.bPD);
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
      this.bPv.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt1);
      this.bPv.write(paramb1.bPD);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt2);
      this.bPv.write(paramb2.bPD);
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
      this.bPv.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, (int)paramLong);
      this.bPv.write(paramb1.bPD);
      this.bPv.write(paramb2.bPD);
      this.bPv.write(paramb3.bPD);
      this.bPv.write(paramb4.bPD);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt2);
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
      this.bPv.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.bPv, (int)paramLong);
      this.bPv.write(paramb.bPD);
      paramb = this.bPv;
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
    this.bPk = paramInt;
    OutputStream localOutputStream = this.bPv;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.bPv, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.bPv, paramLong);
  }
  
  public final void zi()
  {
    try
    {
      this.bPv.flush();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }
  
  final class a
    extends b
  {
    private final int bPx;
    private final long bPy;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.bPx = paramInt2;
      this.bPy = paramLong;
    }
    
    public final void a(int paramInt, com.tencent.matrix.resource.c.a.b paramb)
    {
      try
      {
        e.this.bPw.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt);
        e.this.bPw.write(paramb.bPD);
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
        e.this.bPw.write(paramInt1);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt3);
        e.this.bPw.write(paramInt4);
        paramInt1 = c.fP(paramInt4).getSize(e.this.bPk);
        e.this.bPw.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.bPw.write(4);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt);
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
        e.this.bPw.write(2);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
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
        e.this.bPw.write(34);
        e.this.bPw.write(paramb1.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
        e.this.bPw.write(paramb2.bPD);
        paramInt1 = e.this.bPk;
        e.this.bPw.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.bPw.write(32);
        e.this.bPw.write(paramb1.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        e.this.bPw.write(paramb2.bPD);
        e.this.bPw.write(paramb3.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, e.this.bPk << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.bPw, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.bPw, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.bPw, paramb2.bPB);
        e.this.bPw.write(paramb2.bPA);
        paramb1 = e.this.bPw;
        paramb2 = paramb2.bPC;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.bPw, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.bPw, paramb1.bPB);
            e.this.bPw.write(paramb1.bPA);
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
        e.this.bPw.write(33);
        e.this.bPw.write(paramb1.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt);
        e.this.bPw.write(paramb2.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramArrayOfByte.length);
        e.this.bPw.write(paramArrayOfByte);
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
        e.this.bPw.write(paramInt);
        e.this.bPw.write(paramb.bPD);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.bPw, e.this.bPk);
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
        e.this.bPw.write(6);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt);
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
        e.this.bPw.write(3);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
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
        e.this.bPw.write(8);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
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
        e.this.bPw.write(142);
        e.this.bPw.write(paramb.bPD);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPw, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void zi()
    {
      try
      {
        e.this.bPv.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPv, this.bPx);
        com.tencent.matrix.resource.c.b.a.b(e.this.bPv, e.this.bPw.size());
        e.this.bPv.write(e.this.bPw.toByteArray());
        e.this.bPw.reset();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw new RuntimeException(localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.e
 * JD-Core Version:    0.7.0.1
 */