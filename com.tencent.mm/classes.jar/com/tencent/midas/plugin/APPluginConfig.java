package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class APPluginConfig
{
  static final String KERNEL_FILE_NAME = "MidasPay.zip";
  static String PLUGIN_BACKUP_TEMP_DIR_NAME;
  public static String PLUGIN_DIR_NAME;
  static String PLUGIN_EMPTY_RES_DIR_NAME = "midasemptyRes";
  static String PLUGIN_LIB_DIR_NAME;
  static String PLUGIN_ODEX_DIR_NAME;
  static String PLUGIN_UPDATE_DIR_NAME;
  static String SIGN_FILE_NAME = "MidasSign.ini";
  static int libExtend = 0;
  
  static
  {
    PLUGIN_DIR_NAME = "midasplugins";
    PLUGIN_BACKUP_TEMP_DIR_NAME = "midaspluginsBKTemp";
    PLUGIN_ODEX_DIR_NAME = "midasodex";
    PLUGIN_LIB_DIR_NAME = "midaslib";
    PLUGIN_UPDATE_DIR_NAME = "midaspluginsTemp";
  }
  
  public static File getLibPath(Context paramContext)
  {
    AppMethodBeat.i(193035);
    paramContext = paramContext.getDir(PLUGIN_LIB_DIR_NAME + "_" + libExtend, 0);
    AppMethodBeat.o(193035);
    return paramContext;
  }
  
  static File getOptimizedDexPath(Context paramContext)
  {
    AppMethodBeat.i(193034);
    paramContext = paramContext.getDir(PLUGIN_ODEX_DIR_NAME, 0);
    AppMethodBeat.o(193034);
    return paramContext;
  }
  
  static File getPluginBackUpPath(Context paramContext)
  {
    AppMethodBeat.i(193033);
    paramContext = paramContext.getDir(PLUGIN_BACKUP_TEMP_DIR_NAME, 0);
    AppMethodBeat.o(193033);
    return paramContext;
  }
  
  static File getPluginEmptyResPath(Context paramContext)
  {
    AppMethodBeat.i(193037);
    paramContext = paramContext.getDir(PLUGIN_EMPTY_RES_DIR_NAME, 0);
    AppMethodBeat.o(193037);
    return paramContext;
  }
  
  public static File getPluginPath(Context paramContext)
  {
    AppMethodBeat.i(193032);
    paramContext = paramContext.getDir(PLUGIN_DIR_NAME, 0);
    AppMethodBeat.o(193032);
    return paramContext;
  }
  
  static File getPluginUpdatePath(Context paramContext)
  {
    AppMethodBeat.i(193036);
    paramContext = paramContext.getDir(PLUGIN_UPDATE_DIR_NAME, 0);
    AppMethodBeat.o(193036);
    return paramContext;
  }
  
  public static void setPluginDirName(String paramString)
  {
    AppMethodBeat.i(193031);
    if (!TextUtils.isEmpty(paramString)) {
      PLUGIN_DIR_NAME = paramString;
    }
    AppMethodBeat.o(193031);
  }
  
  public static void setSignFileName(String paramString)
  {
    AppMethodBeat.i(193030);
    if (!TextUtils.isEmpty(paramString)) {
      SIGN_FILE_NAME = paramString;
    }
    AppMethodBeat.o(193030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginConfig
 * JD-Core Version:    0.7.0.1
 */