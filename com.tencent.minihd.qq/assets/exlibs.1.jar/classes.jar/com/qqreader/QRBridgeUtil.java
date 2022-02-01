package com.qqreader;

import android.os.Handler.Callback;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;
import om;

public class QRBridgeUtil
{
  public static final int MESSAGE_TICKET_FAILED = 1001;
  public static final int MESSAGE_TICKET_OK = 1000;
  
  public static String getSKey(String paramString)
  {
    paramString = ((WtloginManager)PluginRuntime.getRuntime().getManager(1)).GetLocalSig(paramString, 16L);
    if (paramString != null) {
      return new String(WtloginHelper.GetTicketSig(paramString, 4096));
    }
    return "";
  }
  
  public static String getSid(String paramString)
  {
    paramString = ((WtloginManager)PluginRuntime.getRuntime().getManager(1)).GetLocalSig(paramString, 16L);
    if (paramString != null) {
      return new String(WtloginHelper.GetTicketSig(paramString, 524288));
    }
    return "";
  }
  
  public static String getVkey(String paramString)
  {
    paramString = ((WtloginManager)PluginRuntime.getRuntime().getManager(1)).GetLocalSig(paramString, 16L);
    if (paramString != null) {
      return new String(WtloginHelper.GetTicketSig(paramString, 131072));
    }
    return "";
  }
  
  public static boolean recreateTicket(String paramString, Handler.Callback paramCallback)
  {
    WtloginManager localWtloginManager = (WtloginManager)PluginRuntime.getRuntime().getManager(1);
    if (!localWtloginManager.IsNeedLoginWithPasswd(paramString, 16))
    {
      localWtloginManager.GetStWithoutPasswd(paramString, 16L, 16L, new om(paramCallback));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRBridgeUtil
 * JD-Core Version:    0.7.0.1
 */