package com.qq.taf.jce.dynamic;

public abstract class NumberField
  extends JceField
{
  NumberField(int paramInt)
  {
    super(paramInt);
  }
  
  public byte byteValue()
  {
    return getNumber().byteValue();
  }
  
  public double doubleValue()
  {
    return getNumber().doubleValue();
  }
  
  public float floatValue()
  {
    return getNumber().floatValue();
  }
  
  public abstract Number getNumber();
  
  public int intValue()
  {
    return getNumber().intValue();
  }
  
  public long longValue()
  {
    return getNumber().longValue();
  }
  
  public short shortValue()
  {
    return getNumber().shortValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.NumberField
 * JD-Core Version:    0.7.0.1
 */