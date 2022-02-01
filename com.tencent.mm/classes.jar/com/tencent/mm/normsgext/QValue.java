package com.tencent.mm.normsgext;

public final class QValue<TValue>
{
  public TValue value;
  
  public final TValue getValue(TValue paramTValue)
  {
    if (this.value != null) {
      paramTValue = this.value;
    }
    return paramTValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.normsgext.QValue
 * JD-Core Version:    0.7.0.1
 */