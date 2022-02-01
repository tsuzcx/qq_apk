package com.tencent.mobileqq.highway.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.security.MessageDigest;

public class BdhUtils
{
  public static String APN_TYPE_3GNET = "3gnet";
  public static String APN_TYPE_3GWAP = "3gwap";
  public static String APN_TYPE_CMNET;
  public static String APN_TYPE_CMWAP;
  public static String APN_TYPE_CTNET;
  public static String APN_TYPE_CTWAP;
  public static String APN_TYPE_UNINET;
  public static String APN_TYPE_UNIWAP;
  private static Uri PREFERRED_APN_URI;
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  static
  {
    PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    APN_TYPE_CTNET = "ctnet";
    APN_TYPE_CTWAP = "ctwap";
    APN_TYPE_CMNET = "cmnet";
    APN_TYPE_CMWAP = "cmwap";
    APN_TYPE_UNINET = "uninet";
    APN_TYPE_UNIWAP = "uniwap";
  }
  
  public static void DWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static void copyData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String getApnType(Context paramContext)
  {
    str1 = "nomatch";
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localCursor = paramContext.getContentResolver().query(PREFERRED_APN_URI, null, null, null, null);
        if (localCursor == null)
        {
          if (localCursor != null) {
            localCursor.close();
          }
          return "nomatch";
        }
        localObject1 = localCursor;
        localObject2 = localCursor;
        localCursor.moveToFirst();
        localObject1 = localCursor;
        localObject2 = localCursor;
        str2 = localCursor.getString(localCursor.getColumnIndex("user")).toLowerCase();
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (!str2.startsWith(APN_TYPE_CTNET)) {
          continue;
        }
        localObject1 = localCursor;
        localObject2 = localCursor;
        paramContext = APN_TYPE_CTNET;
        localObject2 = paramContext;
        if (localCursor != null)
        {
          localCursor.close();
          localObject2 = paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Cursor localCursor;
        String str2;
        localObject2 = str1;
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        localObject2 = str1;
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      return localObject2;
      localObject1 = localCursor;
      localObject2 = localCursor;
      if (str2.startsWith(APN_TYPE_CTWAP))
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        paramContext = APN_TYPE_CTWAP;
      }
      else
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (str2.startsWith(APN_TYPE_CMNET))
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          paramContext = APN_TYPE_CMNET;
        }
        else
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (str2.startsWith(APN_TYPE_CMWAP))
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            paramContext = APN_TYPE_CMWAP;
          }
          else
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (str2.startsWith(APN_TYPE_UNINET))
            {
              localObject1 = localCursor;
              localObject2 = localCursor;
              paramContext = APN_TYPE_UNINET;
            }
            else
            {
              paramContext = str1;
              localObject1 = localCursor;
              localObject2 = localCursor;
              if (str2.startsWith(APN_TYPE_UNIWAP))
              {
                localObject1 = localCursor;
                localObject2 = localCursor;
                paramContext = APN_TYPE_UNIWAP;
              }
            }
          }
        }
      }
    }
  }
  
  public static String getApnType(String paramString)
  {
    String str2 = "nomatch";
    if (paramString == null) {
      return "nomatch";
    }
    String str1;
    try
    {
      if (paramString.startsWith(APN_TYPE_CTNET))
      {
        str1 = APN_TYPE_CTNET;
      }
      else if (paramString.startsWith(APN_TYPE_CTWAP))
      {
        str1 = APN_TYPE_CTWAP;
      }
      else if (paramString.startsWith(APN_TYPE_CMNET))
      {
        str1 = APN_TYPE_CMNET;
      }
      else if (paramString.startsWith(APN_TYPE_CMWAP))
      {
        str1 = APN_TYPE_CMWAP;
      }
      else if (paramString.startsWith(APN_TYPE_UNINET))
      {
        str1 = APN_TYPE_UNINET;
      }
      else if (paramString.startsWith(APN_TYPE_UNIWAP))
      {
        str1 = APN_TYPE_UNIWAP;
      }
      else if (paramString.startsWith(APN_TYPE_3GNET))
      {
        str1 = APN_TYPE_3GNET;
      }
      else
      {
        str1 = str2;
        if (paramString.startsWith(APN_TYPE_3GWAP)) {
          str1 = APN_TYPE_3GWAP;
        }
      }
    }
    catch (Exception paramString)
    {
      str1 = str2;
    }
    return str1;
  }
  
  public static long getLongData(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhUtils
 * JD-Core Version:    0.7.0.1
 */