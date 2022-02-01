package com.google.a;

import java.io.IOException;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  implements aw
{
  protected int bNb = 0;
  
  private String bW(String paramString)
  {
    return "Serializing " + getClass().getName() + " to a " + paramString + " threw an IOException (should never happen).";
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[yC()];
      i locali = i.C(arrayOfByte);
      a(locali);
      locali.zA();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(bW("byte array"), localIOException);
    }
  }
  
  ca yD()
  {
    return new ca();
  }
  
  public final g yI()
  {
    try
    {
      Object localObject = g.fE(yC());
      a(((g.f)localObject).bNn);
      localObject = ((g.f)localObject).yS();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(bW("ByteString"), localIOException);
    }
  }
  
  public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    implements aw.a
  {
    private String bX(String paramString)
    {
      return "Reading " + getClass().getName() + " from a " + paramString + " threw an IOException (should never happen).";
    }
    
    protected abstract BuilderType a(MessageType paramMessageType);
    
    public BuilderType a(h paramh)
    {
      return b(paramh, r.Gd());
    }
    
    public BuilderType b(g paramg, r paramr)
    {
      try
      {
        paramg = paramg.yQ();
        b(paramg, paramr);
        paramg.fF(0);
        return this;
      }
      catch (af paramg)
      {
        throw paramg;
      }
      catch (IOException paramg)
      {
        throw new RuntimeException(bX("ByteString"), paramg);
      }
    }
    
    public abstract BuilderType b(h paramh, r paramr);
    
    public BuilderType n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        paramArrayOfByte = h.c(paramArrayOfByte, paramInt1, paramInt2, false);
        a(paramArrayOfByte);
        paramArrayOfByte.fF(0);
        return this;
      }
      catch (af paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException(bX("byte array"), paramArrayOfByte);
      }
    }
    
    public BuilderType w(byte[] paramArrayOfByte)
    {
      return n(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public abstract BuilderType yG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.b
 * JD-Core Version:    0.7.0.1
 */