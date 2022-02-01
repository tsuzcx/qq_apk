package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCVideoServerConfig
{
  private static final String KEY_ENABLE_DEC_VUI = "enable_hw_vui";
  private static final String VIDEO_SERVER_CONFIG = "trtc_video_server_config";
  public boolean enableHWVUI = true;
  
  public static TRTCVideoServerConfig loadFromSharedPreferences(Context paramContext)
  {
    AppMethodBeat.i(222576);
    try
    {
      TRTCVideoServerConfig localTRTCVideoServerConfig = new TRTCVideoServerConfig();
      localTRTCVideoServerConfig.enableHWVUI = paramContext.getSharedPreferences("trtc_video_server_config", 0).getBoolean("enable_hw_vui", true);
      return localTRTCVideoServerConfig;
    }
    finally
    {
      AppMethodBeat.o(222576);
    }
  }
  
  public static void saveToSharedPreferences(Context paramContext, TRTCVideoServerConfig paramTRTCVideoServerConfig)
  {
    AppMethodBeat.i(222575);
    try
    {
      paramContext = paramContext.getSharedPreferences("trtc_video_server_config", 0).edit();
      paramContext.putBoolean("enable_hw_vui", paramTRTCVideoServerConfig.enableHWVUI);
      paramContext.apply();
      return;
    }
    finally
    {
      AppMethodBeat.o(222575);
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(222574);
    String str = "enableHWVUI: " + this.enableHWVUI;
    AppMethodBeat.o(222574);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCVideoServerConfig
 * JD-Core Version:    0.7.0.1
 */