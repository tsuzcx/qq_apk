package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WXAppLaunchData
{
  public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
  public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
  public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
  public int launchType;
  public String message;
  
  public static class Builder
  {
    public static WXAppLaunchData fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4032);
      WXAppLaunchData localWXAppLaunchData = new WXAppLaunchData();
      localWXAppLaunchData.launchType = paramBundle.getInt("_wxapplaunchdata_launchType");
      localWXAppLaunchData.message = paramBundle.getString("_wxapplaunchdata_message");
      AppMethodBeat.o(4032);
      return localWXAppLaunchData;
    }
    
    public static Bundle toBundle(WXAppLaunchData paramWXAppLaunchData)
    {
      AppMethodBeat.i(4033);
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxapplaunchdata_launchType", paramWXAppLaunchData.launchType);
      localBundle.putString("_wxapplaunchdata_message", paramWXAppLaunchData.message);
      AppMethodBeat.o(4033);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXAppLaunchData
 * JD-Core Version:    0.7.0.1
 */