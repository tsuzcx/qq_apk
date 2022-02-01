package com.tencent.mars.comm;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ao;

public class PlatformComm
{
  public static final int EMobile = 2;
  public static final int ENoNet = -1;
  public static final int EOtherNet = 3;
  public static final int EWifi = 1;
  private static final boolean IS_PROXY_ON = false;
  public static final int NETTYPE_2G = 3;
  public static final int NETTYPE_3G = 4;
  public static final int NETTYPE_4G = 5;
  public static final int NETTYPE_5G = 7;
  public static final int NETTYPE_NON = -1;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_UNKNOWN = 6;
  public static final int NETTYPE_WAP = 2;
  public static final int NETTYPE_WIFI = 1;
  private static final String TAG = "PlatformComm";
  private static Context context = null;
  private static ao handler = null;
  public static IReportCrash reportCrashImp;
  public static IResetProcess resetprocessimp = null;
  
  static
  {
    reportCrashImp = null;
  }
  
  public static void init(Context paramContext, ao paramao)
  {
    context = paramContext;
    handler = paramao;
    NetworkSignalUtil.InitNetworkSignalUtil(paramContext);
  }
  
  public static abstract interface IReportCrash
  {
    public abstract void reportIdkey();
  }
  
  public static abstract interface IResetProcess
  {
    public abstract void restartProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm
 * JD-Core Version:    0.7.0.1
 */