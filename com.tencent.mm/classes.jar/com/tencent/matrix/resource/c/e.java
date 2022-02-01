package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  final OutputStream cIb;
  final ByteArrayOutputStream cIc = new ByteArrayOutputStream();
  int ces = 0;
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.cIb = paramOutputStream;
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
  
  public final void IH()
  {
    try
    {
      this.cIb.flush();
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
      this.cIb.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, (int)paramLong);
      this.cIb.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.cIb.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.cIb.write(localb.cIj);
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
      this.cIb.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt1);
      this.cIb.write(paramb1.cIj);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt2);
      this.cIb.write(paramb2.cIj);
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
      this.cIb.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, (int)paramLong);
      this.cIb.write(paramb1.cIj);
      this.cIb.write(paramb2.cIj);
      this.cIb.write(paramb3.cIj);
      this.cIb.write(paramb4.cIj);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt2);
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
      this.cIb.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.cIb, (int)paramLong);
      this.cIb.write(paramb.cIj);
      paramb = this.cIb;
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
    OutputStream localOutputStream = this.cIb;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.c.b.a.b(this.cIb, paramInt);
    com.tencent.matrix.resource.c.b.a.a(this.cIb, paramLong);
  }
  
  final class a
    extends b
  {
    private final int cId;
    private final long cIe;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.cId = paramInt2;
      this.cIe = paramLong;
    }
    
    public final void IH()
    {
      try
      {
        e.this.cIb.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIb, this.cId);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIb, e.this.cIc.size());
        e.this.cIb.write(e.this.cIc.toByteArray());
        e.this.cIc.reset();
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
        e.this.cIc.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt);
        e.this.cIc.write(paramb.cIj);
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
        e.this.cIc.write(paramInt1);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt3);
        e.this.cIc.write(paramInt4);
        paramInt1 = c.gZ(paramInt4).getSize(e.this.ces);
        e.this.cIc.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.cIc.write(4);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt);
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
        e.this.cIc.write(2);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
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
        e.this.cIc.write(34);
        e.this.cIc.write(paramb1.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
        e.this.cIc.write(paramb2.cIj);
        paramInt1 = e.this.ces;
        e.this.cIc.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.cIc.write(32);
        e.this.cIc.write(paramb1.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        e.this.cIc.write(paramb2.cIj);
        e.this.cIc.write(paramb3.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, e.this.ces << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.cIc, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.cIc, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.cIc, paramb2.cIh);
        e.this.cIc.write(paramb2.cIg);
        paramb1 = e.this.cIc;
        paramb2 = paramb2.cIi;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.cIc, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.cIc, paramb1.cIh);
            e.this.cIc.write(paramb1.cIg);
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
        e.this.cIc.write(33);
        e.this.cIc.write(paramb1.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt);
        e.this.cIc.write(paramb2.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramArrayOfByte.length);
        e.this.cIc.write(paramArrayOfByte);
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
        e.this.cIc.write(paramInt);
        e.this.cIc.write(paramb.cIj);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.cIc, e.this.ces);
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
        e.this.cIc.write(6);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt);
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
        e.this.cIc.write(3);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
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
        e.this.cIc.write(8);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
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
        e.this.cIc.write(142);
        e.this.cIc.write(paramb.cIj);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.cIc, paramInt2);
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