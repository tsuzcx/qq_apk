package com.tencent.mm.model;

public final class cc
{
  public static boolean ax(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      try
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        return bool;
      }
      catch (Exception paramObject) {}
    }
    return false;
  }
  
  public static String e(Object paramObject, String paramString)
  {
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = (String)paramObject;
        return paramObject;
      }
      catch (Exception paramObject) {}
    }
    return paramString;
  }
  
  public static int getInt(Object paramObject, int paramInt)
  {
    int i = paramInt;
    if ((paramObject instanceof Integer)) {}
    try
    {
      i = ((Integer)paramObject).intValue();
      return i;
    }
    catch (Exception paramObject) {}
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */