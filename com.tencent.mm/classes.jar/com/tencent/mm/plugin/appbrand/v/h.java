package com.tencent.mm.plugin.appbrand.v;

public final class h
{
  public static Boolean aY(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(true);
      }
      if ("false".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(false);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.h
 * JD-Core Version:    0.7.0.1
 */