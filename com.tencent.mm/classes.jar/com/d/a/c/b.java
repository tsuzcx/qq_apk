package com.d.a.c;

import java.io.IOException;
import java.io.ObjectOutputStream;

final class b
  implements i, m, s, t
{
  private final ObjectOutputStream clH;
  IOException clI;
  
  b(ObjectOutputStream paramObjectOutputStream)
  {
    this.clH = paramObjectOutputStream;
  }
  
  public final boolean az(Object paramObject)
  {
    try
    {
      this.clH.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.clI = paramObject;
    }
    return false;
  }
  
  public final boolean c(long paramLong, Object paramObject)
  {
    try
    {
      this.clH.writeLong(paramLong);
      this.clH.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.clI = paramObject;
    }
    return false;
  }
  
  public final boolean g(int paramInt, Object paramObject)
  {
    try
    {
      this.clH.writeInt(paramInt);
      this.clH.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.clI = paramObject;
    }
    return false;
  }
  
  public final boolean o(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.clH.writeObject(paramObject1);
      this.clH.writeObject(paramObject2);
      return true;
    }
    catch (IOException paramObject1)
    {
      this.clI = paramObject1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */