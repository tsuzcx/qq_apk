package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class InternalSettings
{
  private static final String UNITY_PREFIX = "Unity.";
  private static volatile String mCustomUserAgent;
  
  public static String getCustomUserAgent()
  {
    return mCustomUserAgent;
  }
  
  public static boolean isUnityApp()
  {
    AppMethodBeat.i(72399);
    if ((mCustomUserAgent != null) && (mCustomUserAgent.startsWith("Unity.")))
    {
      AppMethodBeat.o(72399);
      return true;
    }
    AppMethodBeat.o(72399);
    return false;
  }
  
  public static void setCustomUserAgent(String paramString)
  {
    mCustomUserAgent = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.InternalSettings
 * JD-Core Version:    0.7.0.1
 */