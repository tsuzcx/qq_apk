package com.tencent.matrix.resource.d;

import com.tencent.matrix.resource.d.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e
  extends d
{
  int eaR = 0;
  final OutputStream fbT;
  final ByteArrayOutputStream fbU = new ByteArrayOutputStream();
  
  public e(OutputStream paramOutputStream)
  {
    super(null);
    this.fbT = paramOutputStream;
  }
  
  private a c(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      a locala = new a(paramInt1, paramInt2, paramLong);
      return locala;
    }
    finally {}
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    try
    {
      this.fbT.write(paramInt1);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt2);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, (int)paramLong);
      this.fbT.write(paramArrayOfByte, 0, (int)paramLong);
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.matrix.resource.d.a.b[] paramArrayOfb, int paramInt3, long paramLong)
  {
    try
    {
      this.fbT.write(5);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt3);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, (int)paramLong);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt1);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt2);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramArrayOfb.length);
      paramInt2 = paramArrayOfb.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        com.tencent.matrix.resource.d.a.b localb = paramArrayOfb[paramInt1];
        this.fbT.write(localb.fcb);
        paramInt1 += 1;
      }
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt1, com.tencent.matrix.resource.d.a.b paramb1, int paramInt2, com.tencent.matrix.resource.d.a.b paramb2, int paramInt3, long paramLong)
  {
    try
    {
      this.fbT.write(2);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt3);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, (int)paramLong);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt1);
      this.fbT.write(paramb1.fcb);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt2);
      this.fbT.write(paramb2.fcb);
      return;
    }
    finally {}
  }
  
  public final void a(com.tencent.matrix.resource.d.a.b paramb1, com.tencent.matrix.resource.d.a.b paramb2, com.tencent.matrix.resource.d.a.b paramb3, com.tencent.matrix.resource.d.a.b paramb4, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    try
    {
      this.fbT.write(4);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt3);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, (int)paramLong);
      this.fbT.write(paramb1.fcb);
      this.fbT.write(paramb2.fcb);
      this.fbT.write(paramb3.fcb);
      this.fbT.write(paramb4.fcb);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt1);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt2);
      return;
    }
    finally {}
  }
  
  public final void a(com.tencent.matrix.resource.d.a.b paramb, String paramString, int paramInt, long paramLong)
  {
    try
    {
      this.fbT.write(1);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt);
      com.tencent.matrix.resource.d.b.a.e(this.fbT, (int)paramLong);
      this.fbT.write(paramb.fcb);
      paramb = this.fbT;
      paramInt = paramString.length();
      paramb.write(paramString.getBytes(Charset.forName("UTF-8")), 0, paramInt);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, int paramInt, long paramLong)
  {
    if ((paramInt <= 0) || (paramInt >= 1073741823)) {
      try
      {
        throw new IOException("bad idSize: ".concat(String.valueOf(paramInt)));
      }
      finally {}
    }
    this.eaR = paramInt;
    OutputStream localOutputStream = this.fbT;
    localOutputStream.write(paramString.getBytes(Charset.forName("UTF-8")));
    localOutputStream.write(0);
    com.tencent.matrix.resource.d.b.a.e(this.fbT, paramInt);
    com.tencent.matrix.resource.d.b.a.d(this.fbT, paramLong);
  }
  
  public final void azp()
  {
    try
    {
      this.fbT.flush();
      return;
    }
    finally {}
  }
  
  final class a
    extends b
  {
    private final int fbV;
    private final int fbW;
    private final long fbX;
    
    a(int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.fbV = paramInt1;
      this.fbW = paramInt2;
      this.fbX = paramLong;
    }
    
    public final void a(int paramInt, com.tencent.matrix.resource.d.a.b paramb)
    {
      try
      {
        e.this.fbU.write(254);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt);
        e.this.fbU.write(paramb.fcb);
        return;
      }
      finally {}
    }
    
    public final void a(int paramInt1, com.tencent.matrix.resource.d.a.b paramb, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.fbU.write(paramInt1);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt3);
        e.this.fbU.write(paramInt4);
        paramInt1 = c.nu(paramInt4).nv(e.this.eaR);
        e.this.fbU.write(paramArrayOfByte, 0, paramInt1 * paramInt3);
        return;
      }
      finally {}
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb, int paramInt)
    {
      try
      {
        e.this.fbU.write(4);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt);
        return;
      }
      finally {}
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.fbU.write(2);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        return;
      }
      finally {}
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb1, int paramInt1, int paramInt2, com.tencent.matrix.resource.d.a.b paramb2, byte[] paramArrayOfByte)
    {
      try
      {
        e.this.fbU.write(34);
        e.this.fbU.write(paramb1.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        e.this.fbU.write(paramb2.fcb);
        paramInt1 = e.this.eaR;
        e.this.fbU.write(paramArrayOfByte, 0, paramInt1 * paramInt2);
        return;
      }
      finally {}
    }
    
    public final void a(com.tencent.matrix.resource.d.a.b paramb1, int paramInt1, com.tencent.matrix.resource.d.a.b paramb2, com.tencent.matrix.resource.d.a.b paramb3, int paramInt2, com.tencent.matrix.resource.d.a.a[] paramArrayOfa1, com.tencent.matrix.resource.d.a.a[] paramArrayOfa2)
    {
      try
      {
        e.this.fbU.write(32);
        e.this.fbU.write(paramb1.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        e.this.fbU.write(paramb2.fcb);
        e.this.fbU.write(paramb3.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, e.this.eaR << 2);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        com.tencent.matrix.resource.d.b.a.d(e.this.fbU, 0);
        com.tencent.matrix.resource.d.b.a.d(e.this.fbU, paramArrayOfa1.length);
        int i = paramArrayOfa1.length;
        paramInt1 = 0;
        if (paramInt1 >= i) {
          break label539;
        }
        paramb2 = paramArrayOfa1[paramInt1];
        com.tencent.matrix.resource.d.b.a.a(e.this.fbU, paramb2.fbZ);
        e.this.fbU.write(paramb2.typeId);
        paramb1 = e.this.fbU;
        paramb2 = paramb2.fca;
        if (paramb2 == null) {
          throw new IllegalArgumentException("value is null.");
        }
      }
      finally {}
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
          com.tencent.matrix.resource.d.b.a.d(paramb1, ((Character)paramb2).charValue());
        }
        else if (((paramb2 instanceof Float)) || (Float.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.e(paramb1, Float.floatToRawIntBits(((Float)paramb2).floatValue()));
        }
        else if (((paramb2 instanceof Double)) || (Double.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.d(paramb1, Double.doubleToRawLongBits(((Double)paramb2).doubleValue()));
        }
        else if (((paramb2 instanceof Byte)) || (Byte.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          paramb1.write(((Byte)paramb2).byteValue());
        }
        else if (((paramb2 instanceof Short)) || (Short.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.d(paramb1, ((Short)paramb2).shortValue());
        }
        else if (((paramb2 instanceof Integer)) || (Integer.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.e(paramb1, ((Integer)paramb2).intValue());
        }
        else if (((paramb2 instanceof Long)) || (Long.TYPE.isAssignableFrom(paramb2.getClass())))
        {
          com.tencent.matrix.resource.d.b.a.d(paramb1, ((Long)paramb2).longValue());
        }
        else
        {
          throw new IllegalArgumentException("bad value type: " + paramb2.getClass().getName());
          com.tencent.matrix.resource.d.b.a.d(e.this.fbU, paramArrayOfa2.length);
          paramInt2 = paramArrayOfa2.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramb1 = paramArrayOfa2[paramInt1];
            com.tencent.matrix.resource.d.b.a.a(e.this.fbU, paramb1.fbZ);
            e.this.fbU.write(paramb1.typeId);
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
        e.this.fbU.write(33);
        e.this.fbU.write(paramb1.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt);
        e.this.fbU.write(paramb2.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramArrayOfByte.length);
        e.this.fbU.write(paramArrayOfByte);
        return;
      }
      finally {}
    }
    
    public final void azp()
    {
      try
      {
        e.this.fbT.write(this.fbV);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbT, this.fbW);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbT, e.this.fbU.size());
        e.this.fbT.write(e.this.fbU.toByteArray());
        e.this.fbU.reset();
        return;
      }
      finally {}
    }
    
    public final void b(int paramInt, com.tencent.matrix.resource.d.a.b paramb)
    {
      try
      {
        e.this.fbU.write(paramInt);
        e.this.fbU.write(paramb.fcb);
        if (paramInt == 1) {
          com.tencent.matrix.resource.d.b.a.e(e.this.fbU, e.this.eaR);
        }
        return;
      }
      finally {}
    }
    
    public final void b(com.tencent.matrix.resource.d.a.b paramb, int paramInt)
    {
      try
      {
        e.this.fbU.write(6);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt);
        return;
      }
      finally {}
    }
    
    public final void b(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.fbU.write(3);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        return;
      }
      finally {}
    }
    
    public final void c(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.fbU.write(8);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        return;
      }
      finally {}
    }
    
    public final void d(com.tencent.matrix.resource.d.a.b paramb, int paramInt1, int paramInt2)
    {
      try
      {
        e.this.fbU.write(142);
        e.this.fbU.write(paramb.fcb);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt1);
        com.tencent.matrix.resource.d.b.a.e(e.this.fbU, paramInt2);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.e
 * JD-Core Version:    0.7.0.1
 */