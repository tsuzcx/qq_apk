package com.google.b;

import java.io.Serializable;

public abstract class ax
  extends a
  implements Serializable
{
  protected static boolean bXS = false;
  protected da bVW = da.Jk();
  
  protected Object writeReplace()
  {
    return new az.c(this);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    private da bVW = da.Jk();
    private ax.b bXT = null;
    
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
 * Qualified Name:     com.google.b.ax
 * JD-Core Version:    0.7.0.1
 */