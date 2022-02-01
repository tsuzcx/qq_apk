package com.eclipsesource.v8.utils;

public abstract interface TypeAdapter
{
  public static final Object DEFAULT = new Object();
  
  public abstract Object adapt(int paramInt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.TypeAdapter
 * JD-Core Version:    0.7.0.1
 */