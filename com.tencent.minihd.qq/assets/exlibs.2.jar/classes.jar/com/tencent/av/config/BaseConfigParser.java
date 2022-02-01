package com.tencent.av.config;

import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qav.log.AVLog;

public final class BaseConfigParser
{
  private static final String DEFAULT_VALUE = "unknown";
  private static final String TAG = "BaseConfigParser";
  private String mData;
  
  public BaseConfigParser(String paramString)
  {
    this.mData = paramString;
  }
  
  public int getIntValue(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      paramString = getIntValues(paramString);
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[0];
  }
  
  public int[] getIntValues(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      paramString = GraphicRenderMgr.getInstance().findConfigValue(this.mData, paramString, "unknown");
      localObject1 = paramString;
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          AVLog.e("BaseConfigParser", "getIntValues fail.", paramString);
        }
        arrayOfString = ((String)localObject1).split(",");
        paramString = localObject2;
      } while (arrayOfString == null);
      j = arrayOfString.length;
      localObject1 = new int[j];
      i = 0;
    }
    paramString = localObject2;
    if (localObject1 != null)
    {
      if (((String)localObject1).equalsIgnoreCase("unknown")) {
        paramString = localObject2;
      }
    }
    else {
      return paramString;
    }
    for (;;)
    {
      String[] arrayOfString;
      int j;
      int i;
      paramString = (String)localObject1;
      if (i >= j) {
        break;
      }
      try
      {
        localObject1[i] = Integer.parseInt(arrayOfString[i].trim());
        i += 1;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          localObject1[i] = 0;
        }
      }
    }
  }
  
  public String getStringValue(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      paramString1 = getStringValues(paramString1);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    return paramString1[0];
  }
  
  public String[] getStringValues(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = GraphicRenderMgr.getInstance().findConfigValue(this.mData, paramString, "unknown");
      if ((paramString == null) || (paramString.equalsIgnoreCase("unknown"))) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        AVLog.e("BaseConfigParser", "getStringValues fail.", paramString);
        paramString = localObject;
      }
    }
    return paramString.trim().split(",");
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.BaseConfigParser
 * JD-Core Version:    0.7.0.1
 */