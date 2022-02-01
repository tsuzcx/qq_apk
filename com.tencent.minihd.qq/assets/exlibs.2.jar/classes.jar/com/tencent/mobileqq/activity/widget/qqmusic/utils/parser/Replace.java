package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

import hes;
import java.util.ArrayList;

public class Replace
{
  private static ArrayList a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1)
  {
    Object localObject1 = null;
    int[] arrayOfInt = new int[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      Object localObject3;
      for (;;)
      {
        localObject3 = localObject1;
        if (j >= arrayOfInt.length) {
          break;
        }
        if ((paramArrayOfByte1[j] != null) && (paramArrayOfByte1[j].length > 0)) {
          if (paramArrayOfByte[i] == paramArrayOfByte1[j][arrayOfInt[j]])
          {
            arrayOfInt[j] += 1;
            if (arrayOfInt[j] >= paramArrayOfByte1[j].length)
            {
              Object localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ArrayList();
              }
              ((ArrayList)localObject2).add(new hes(i - paramArrayOfByte1[j].length + 1, j));
              j = 0;
              for (;;)
              {
                localObject3 = localObject2;
                if (j >= arrayOfInt.length) {
                  break;
                }
                arrayOfInt[j] = 0;
                j += 1;
              }
            }
          }
          else
          {
            arrayOfInt[j] = 0;
          }
        }
        j += 1;
      }
      i += 1;
      localObject1 = localObject3;
    }
    return localObject1;
  }
  
  public static byte[] a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramString == null) {
      return null;
    }
    return a(paramString.getBytes(), paramArrayOfString1, paramArrayOfString2);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length != paramArrayOfString2.length) || (paramArrayOfString1.length == 0)) {
      return paramArrayOfByte;
    }
    byte[][] arrayOfByte = new byte[paramArrayOfString1.length][];
    int i = 0;
    if (i < arrayOfByte.length)
    {
      if (paramArrayOfString1[i] == null) {}
      for (localObject = null;; localObject = paramArrayOfString1[i].getBytes())
      {
        arrayOfByte[i] = localObject;
        i += 1;
        break;
      }
    }
    Object localObject = new byte[paramArrayOfString2.length][];
    i = j;
    if (i < localObject.length)
    {
      if (paramArrayOfString2[i] == null) {}
      for (paramArrayOfString1 = null;; paramArrayOfString1 = paramArrayOfString2[i].getBytes())
      {
        localObject[i] = paramArrayOfString1;
        i += 1;
        break;
      }
    }
    return a(paramArrayOfByte, arrayOfByte, (byte[][])localObject);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    if (paramArrayOfByte == null) {
      arrayOfByte = null;
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return arrayOfByte;
                arrayOfByte = paramArrayOfByte;
              } while (paramArrayOfByte1 == null);
              arrayOfByte = paramArrayOfByte;
            } while (paramArrayOfByte2 == null);
            arrayOfByte = paramArrayOfByte;
          } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
          arrayOfByte = paramArrayOfByte;
        } while (paramArrayOfByte1.length == 0);
        localArrayList = a(paramArrayOfByte, paramArrayOfByte1);
        arrayOfByte = paramArrayOfByte;
      } while (localArrayList == null);
      arrayOfByte = paramArrayOfByte;
    } while (localArrayList.size() == 0);
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < localArrayList.size())
    {
      int m = ((hes)localArrayList.get(i)).b;
      if (paramArrayOfByte1[m] == null)
      {
        k = 0;
        label107:
        if (paramArrayOfByte2[m] != null) {
          break label144;
        }
      }
      label144:
      for (m = 0;; m = paramArrayOfByte2[m].length)
      {
        j += m - k;
        i += 1;
        break;
        k = paramArrayOfByte1[m].length;
        break label107;
      }
    }
    byte[] arrayOfByte = new byte[j];
    i = 0;
    j = 0;
    int k = 0;
    if (i < localArrayList.size())
    {
      hes localhes = (hes)localArrayList.get(i);
      if (paramArrayOfByte2[localhes.b] == null) {
        paramArrayOfByte2[localhes.b] = new byte[0];
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, k, localhes.a - j);
      k += localhes.a - j;
      if (paramArrayOfByte1[localhes.b] == null) {}
      for (j = 0;; j = paramArrayOfByte1[localhes.b].length)
      {
        System.arraycopy(paramArrayOfByte2[localhes.b], 0, arrayOfByte, k, paramArrayOfByte2[localhes.b].length);
        k += paramArrayOfByte2[localhes.b].length;
        j += localhes.a;
        i += 1;
        break;
      }
    }
    System.arraycopy(paramArrayOfByte, j, arrayOfByte, k, paramArrayOfByte.length - j);
    localArrayList.clear();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.Replace
 * JD-Core Version:    0.7.0.1
 */