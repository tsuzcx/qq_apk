package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int bpi = 0;
  final OutputStream bpu;
  final ByteArrayOutputStream bpv = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.bpu = paramOutputStream;
  }
  
  private a b(int paramInt1, int paramInt2, long paramLong)
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
      this.bpu.write(paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, (int)paramLong);
      this.bpu.write(paramArrayOfByte, 0, (int)paramLong);
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
      this.bpu.write(5);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt2);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.c.a.b localb = paramArrayOfb[paramInt1];
        this.bpu.write(localb.bpC);
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
      this.bpu.write(2);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, (int)paramLong);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt1);
      this.bpu.write(paramb1.bpC);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt2);
      this.bpu.write(paramb2.bpC);
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
      this.bpu.write(4);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt3);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, (int)paramLong);
      this.bpu.write(paramb1.bpC);
      this.bpu.write(paramb2.bpC);
      this.bpu.write(paramb3.bpC);
      this.bpu.write(paramb4.bpC);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt1);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt2);
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
      this.bpu.write(1);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, (int)paramLong);
      this.bpu.write(paramb.bpC);
      paramb = this.bpu;
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
    try
    {
      this.bpi = paramInt;
      OutputStream localOutputStream = this.bpu;
      localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
      localOutputStream.write(0);
      com.tencent.matrix.resource.c.b.a.b(this.bpu, paramInt);
      com.tencent.matrix.resource.c.b.a.a(this.bpu, paramLong);
      return;
    }
    catch (Throwable paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public final void rh()
  {
    try
    {
      this.bpu.flush();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }
  
  private final class a
    extends b
  {
    private final int bpw;
    private final long bpx;
    private final int mTag;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.mTag = paramInt1;
      this.bpw = paramInt2;
      this.bpx = paramLong;
    }
    
    public final void a(int paramInt, com.tencent.matrix.resource.c.a.b paramb)
    {
      try
      {
        e.this.bpv.write(254);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt);
        e.this.bpv.write(paramb.bpC);
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
        e.this.bpv.write(paramInt1);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt3);
        e.this.bpv.write(paramInt4);
        paramInt1 = c.ef(paramInt4).getSize(e.this.bpi);
        e.this.bpv.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
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
        e.this.bpv.write(4);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt);
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
        e.this.bpv.write(2);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
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
        e.this.bpv.write(34);
        e.this.bpv.write(paramb1.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
        e.this.bpv.write(paramb2.bpC);
        paramInt1 = e.this.bpi;
        e.this.bpv.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
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
        e.this.bpv.write(32);
        e.this.bpv.write(paramb1.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        e.this.bpv.write(paramb2.bpC);
        e.this.bpv.write(paramb3.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, e.this.bpi << 2);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
        com.tencent.matrix.resource.c.b.a.a(e.this.bpv, 0);
        com.tencent.matrix.resource.c.b.a.a(e.this.bpv, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.c.b.a.a(e.this.bpv, paramb2.bpA);
        e.this.bpv.write(paramb2.bpz);
        paramb1 = e.this.bpv;
        paramb2 = paramb2.bpB;
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
          com.tencent.matrix.resource.c.b.a.a(e.this.bpv, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.c.b.a.a(e.this.bpv, paramb1.bpA);
            e.this.bpv.write(paramb1.bpz);
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
        e.this.bpv.write(33);
        e.this.bpv.write(paramb1.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt);
        e.this.bpv.write(paramb2.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramArrayOfByte.length);
        e.this.bpv.write(paramArrayOfByte);
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
        e.this.bpv.write(paramInt);
        e.this.bpv.write(paramb.bpC);
        if (paramInt == 1) {
          com.tencent.matrix.resource.c.b.a.b(e.this.bpv, e.this.bpi);
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
        e.this.bpv.write(6);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt);
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
        e.this.bpv.write(3);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
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
        e.this.bpv.write(8);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
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
        e.this.bpv.write(142);
        e.this.bpv.write(paramb.bpC);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt1);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpv, paramInt2);
        return;
      }
      catch (Throwable paramb)
      {
        throw new RuntimeException(paramb);
      }
    }
    
    public final void rh()
    {
      try
      {
        e.this.bpu.write(this.mTag);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpu, this.bpw);
        com.tencent.matrix.resource.c.b.a.b(e.this.bpu, e.this.bpv.size());
        e.this.bpu.write(e.this.bpv.toByteArray());
        e.this.bpv.reset();
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