package com.google.d;

public abstract interface cb
  extends ce, ch
{
  public abstract a newBuilderForType();
  
  public abstract a toBuilder();
  
  public static abstract interface a
    extends ce.a, ch
  {
    public abstract a addRepeatedField(am.f paramf, Object paramObject);
    
    public abstract cb build();
    
    public abstract cb buildPartial();
    
    public abstract a clearField(am.f paramf);
    
    public abstract am.a getDescriptorForType();
    
    public abstract a mergeFrom(cb paramcb);
    
    public abstract a newBuilderForField(am.f paramf);
    
    public abstract a setField(am.f paramf, Object paramObject);
    
    public abstract a setUnknownFields(dn paramdn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cb
 * JD-Core Version:    0.7.0.1
 */