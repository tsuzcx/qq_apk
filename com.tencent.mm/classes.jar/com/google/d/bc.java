package com.google.d;

import java.io.Serializable;

public abstract class bc
  extends a
  implements Serializable
{
  protected static boolean alwaysUseFieldBuilders = false;
  protected dn unknownFields = dn.ajF();
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    private bc.b dRG = null;
    private dn unknownFields = dn.ajF();
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bc
 * JD-Core Version:    0.7.0.1
 */