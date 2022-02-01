package com.tencent.map.tools;

public abstract class Condition<T>
  implements ReturnCallback<Boolean, T>
{
  public final Boolean callback(T paramT)
  {
    return Boolean.valueOf(condition(paramT));
  }
  
  public abstract boolean condition(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.Condition
 * JD-Core Version:    0.7.0.1
 */