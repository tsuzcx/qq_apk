package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  final OutputStream cZh;
  final ByteArrayOutputStream cZi = new ByteArrayOutputStream();
  int coW = 0;
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.cZh = paramOutputStream;
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
  
  public final void Td()
  {
    try
    {
      this.cZh.flush();
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
      this.cZh.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, (int)paramLong);
      this.cZh.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.cZh.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.cZh.write(localb.cZp);
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
      this.cZh.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt1);
      this.cZh.write(paramb1.cZp);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt2);
      this.cZh.write(paramb2.cZp);
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
      this.cZh.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, (int)paramLong);
      this.cZh.write(paramb1.cZp);
      this.cZh.write(paramb2.cZp);
      this.cZh.write(paramb3.cZp);
      this.cZh.write(paramb4.cZp);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt2);
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
      this.cZh.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.cZh, (int)paramLong);
      this.cZh.write(paramb.cZp);
      paramb = this.cZh;
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
    this.coW = paramInt;
    OutputStream localOutputStream = this.cZh;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.cZh, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.cZh, paramLong);
  }
  
  final class a
    extends b
  {
    private final int cZj;
    private final long cZk;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.cZj = paramInt2;
      this.cZk = paramLong;
    }
    
    public final void Td()
    {
      try
      {
        e.this.cZh.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZh, this.cZj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZh, e.this.cZi.size());
        e.this.cZh.write(e.this.cZi.toByteArray());
        e.this.cZi.reset();
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
        e.this.cZi.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt);
        e.this.cZi.write(paramb.cZp);
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
        e.this.cZi.write(paramInt1);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt3);
        e.this.cZi.write(paramInt4);
        paramInt1 = c.iu(paramInt4).getSize(e.this.coW);
        e.this.cZi.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.cZi.write(4);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt);
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
        e.this.cZi.write(2);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
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
        e.this.cZi.write(34);
        e.this.cZi.write(paramb1.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
        e.this.cZi.write(paramb2.cZp);
        paramInt1 = e.this.coW;
        e.this.cZi.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.cZi.write(32);
        e.this.cZi.write(paramb1.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        e.this.cZi.write(paramb2.cZp);
        e.this.cZi.write(paramb3.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, e.this.coW << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.cZi, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.cZi, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.cZi, paramb2.cZn);
        e.this.cZi.write(paramb2.cZm);
        paramb1 = e.this.cZi;
        paramb2 = paramb2.cZo;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.cZi, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.cZi, paramb1.cZn);
            e.this.cZi.write(paramb1.cZm);
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
        e.this.cZi.write(33);
        e.this.cZi.write(paramb1.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt);
        e.this.cZi.write(paramb2.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramArrayOfByte.length);
        e.this.cZi.write(paramArrayOfByte);
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
        e.this.cZi.write(paramInt);
        e.this.cZi.write(paramb.cZp);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.cZi, e.this.coW);
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
        e.this.cZi.write(6);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt);
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
        e.this.cZi.write(3);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
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
        e.this.cZi.write(8);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
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
        e.this.cZi.write(142);
        e.this.cZi.write(paramb.cZp);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cZi, paramInt2);
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