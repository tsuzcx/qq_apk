package com.tencent.av.utils;

import java.util.List;

public class ArrayUtils
{
  public static <T> boolean contains(List<T> paramList, T paramT)
  {
    if (paramList == null) {}
    while (paramList.indexOf(paramT) < 0) {
      return false;
    }
    return true;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt) != -1;
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject) != -1;
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt)
  {
    return indexOf(paramArrayOfInt, paramInt, 0);
  }
  
  public static int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      i = -1;
      return i;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    for (;;)
    {
      if (paramInt2 >= paramArrayOfInt.length) {
        break label40;
      }
      i = paramInt2;
      if (paramInt1 == paramArrayOfInt[paramInt2]) {
        break;
      }
      paramInt2 += 1;
    }
    label40:
    return -1;
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return indexOf(paramArrayOfObject, paramObject, 0);
  }
  
  public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      paramInt = -1;
      return paramInt;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (paramObject == null) {
      for (;;)
      {
        if (i >= paramArrayOfObject.length) {
          break label80;
        }
        paramInt = i;
        if (paramArrayOfObject[i] == null) {
          break;
        }
        i += 1;
      }
    }
    if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
      for (;;)
      {
        if (i >= paramArrayOfObject.length) {
          break label80;
        }
        paramInt = i;
        if (paramObject.equals(paramArrayOfObject[i])) {
          break;
        }
        i += 1;
      }
    }
    label80:
    return -1;
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    return lastIndexOf(paramArrayOfObject, paramObject, 2147483647);
  }
  
  public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0) {
      return -1;
    }
    int i = paramInt;
    if (paramInt >= paramArrayOfObject.length) {
      i = paramArrayOfObject.length - 1;
    }
    if (paramObject == null) {
      for (;;)
      {
        if (i < 0) {
          break label87;
        }
        paramInt = i;
        if (paramArrayOfObject[i] == null) {
          break;
        }
        i -= 1;
      }
    }
    if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
      for (;;)
      {
        if (i < 0) {
          break label87;
        }
        paramInt = i;
        if (paramObject.equals(paramArrayOfObject[i])) {
          break;
        }
        i -= 1;
      }
    }
    label87:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */