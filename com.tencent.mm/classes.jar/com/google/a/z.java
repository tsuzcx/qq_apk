package com.google.a;

import java.io.Serializable;

public abstract class z
  extends a
  implements Serializable
{
  protected static boolean bVU = false;
  protected cc bTW = cc.HK();
  
  protected Object writeReplace()
  {
    return new ab.f(this);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    private cc bTW = cc.HK();
    private z.b bVV = null;
    
    protected a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
  }
  
  protected static abstract interface b
    extends a.b
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.z
 * JD-Core Version:    0.7.0.1
 */