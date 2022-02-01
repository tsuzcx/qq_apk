package com.tencent.av.config;

import android.content.Context;
import com.tencent.qav.QavSDK;

public class ConfigInfo
{
  private static final String TAG = "ConfigInfo";
  private static volatile ConfigInfo instance = null;
  
  private ConfigInfo()
  {
    try
    {
      init();
      cacheMethodIds();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static native void cacheMethodIds();
  
  public static String getSharpConfigPayloadFromFile(Context paramContext)
  {
    String str = "";
    Object localObject = Common.readFile(paramContext, "SharpConfigPayload");
    paramContext = str;
    if (localObject != null)
    {
      localObject = new String((byte[])localObject);
      int i = ((String)localObject).indexOf('|');
      paramContext = str;
      if (i != -1) {
        paramContext = ((String)localObject).substring(i + 1);
      }
    }
    return paramContext;
  }
  
  public static int getSharpConfigVersionFromFile(Context paramContext)
  {
    int j = 0;
    paramContext = Common.readFile(paramContext, "SharpConfigPayload");
    int i = j;
    if (paramContext != null)
    {
      paramContext = new String(paramContext);
      int k = paramContext.indexOf('|');
      i = j;
      if (k > 0) {
        paramContext = paramContext.substring(0, k);
      }
    }
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  private native void init();
  
  public static ConfigInfo instance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ConfigInfo();
      }
      return instance;
    }
    finally {}
  }
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.readFile(QavSDK.getInstance().getContext(), "VideoConfigInfo");
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    return getSharpConfigPayloadFromFile(QavSDK.getInstance().getContext());
  }
  
  public int getSharpConfigVersionFromFile()
  {
    return getSharpConfigVersionFromFile(QavSDK.getInstance().getContext());
  }
  
  public void writeConfigInfoToFile(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */