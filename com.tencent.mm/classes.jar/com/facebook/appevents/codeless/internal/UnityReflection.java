package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class UnityReflection
{
  private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
  private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
  private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
  private static final String TAG;
  private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
  private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
  private static Class<?> unityPlayer;
  
  static
  {
    AppMethodBeat.i(72116);
    TAG = UnityReflection.class.getCanonicalName();
    AppMethodBeat.o(72116);
  }
  
  public static void captureViewHierarchy()
  {
    AppMethodBeat.i(72114);
    sendMessage("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    AppMethodBeat.o(72114);
  }
  
  public static void sendEventMapping(String paramString)
  {
    AppMethodBeat.i(72115);
    sendMessage("UnityFacebookSDKPlugin", "OnReceiveMapping", paramString);
    AppMethodBeat.o(72115);
  }
  
  public static void sendMessage(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72113);
    try
    {
      if (unityPlayer == null) {
        unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
      }
      unityPlayer.getMethod("UnitySendMessage", new Class[] { String.class, String.class, String.class }).invoke(unityPlayer, new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(72113);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(72113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.UnityReflection
 * JD-Core Version:    0.7.0.1
 */