package com.google.b;

import java.io.IOException;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  implements bw
{
  protected int bPa = 0;
  
  private String cr(String paramString)
  {
    return "Serializing " + getClass().getName() + " to a " + paramString + " threw an IOException (should never happen).";
  }
  
  cy Ae()
  {
    return new cy();
  }
  
  public final g Aj()
  {
    try
    {
      Object localObject = g.gx(Ad());
      a(((g.f)localObject).bPm);
      localObject = ((g.f)localObject).Au();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(cr("ByteString"), localIOException);
    }
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[Ad()];
      i locali = i.A(arrayOfByte);
      a(locali);
      locali.Bc();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(cr("byte array"), localIOException);
    }
  }
  
  public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    implements bw.a
  {
    public abstract BuilderType Ah();
    
    public BuilderType a(h paramh)
    {
      return b(paramh, ap.HJ());
    }
    
    public abstract BuilderType b(h paramh, ap paramap);
    
    public BuilderType n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        paramArrayOfByte = h.c(paramArrayOfByte, paramInt1, paramInt2, false);
        a(paramArrayOfByte);
        paramArrayOfByte.gy(0);
        return this;
      }
      catch (bf paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading " + getClass().getName() + " from a " + "byte array" + " threw an IOException (should never happen).", paramArrayOfByte);
      }
    }
    
    public BuilderType u(byte[] paramArrayOfByte)
    {
      return n(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.b
 * JD-Core Version:    0.7.0.1
 */