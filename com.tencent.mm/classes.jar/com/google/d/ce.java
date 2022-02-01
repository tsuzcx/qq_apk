package com.google.d;

public abstract interface ce
  extends cf
{
  public abstract cs<? extends ce> getParserForType();
  
  public abstract int getSerializedSize();
  
  public abstract a newBuilderForType();
  
  public abstract a toBuilder();
  
  public abstract byte[] toByteArray();
  
  public abstract h toByteString();
  
  public abstract void writeTo(k paramk);
  
  public static abstract interface a
    extends cf, Cloneable
  {
    public abstract ce build();
    
    public abstract ce buildPartial();
    
    public abstract a mergeFrom(ce paramce);
    
    public abstract a mergeFrom(i parami, at paramat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ce
 * JD-Core Version:    0.7.0.1
 */