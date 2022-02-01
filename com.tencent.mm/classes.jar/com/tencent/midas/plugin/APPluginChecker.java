package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.HashMap;

public class APPluginChecker
{
  private static final String TAG = "APPluginChecker";
  
  private static boolean isAllPluginValid(File paramFile)
  {
    AppMethodBeat.i(217497);
    if (paramFile == null)
    {
      APLog.e("APPluginChecker", "Cannot check all plugin valid, pluginPath is null!");
      AppMethodBeat.o(217497);
      return false;
    }
    APLog.d("APPluginChecker", "Check all plugin valid, parameter ok!");
    for (;;)
    {
      HashMap localHashMap;
      int j;
      int i;
      try
      {
        File localFile = new File(paramFile.getCanonicalPath() + File.separator + APPluginConfig.SIGN_FILE_NAME);
        if (!localFile.exists())
        {
          APLog.e("APPluginChecker", "Check all plugin valid, sign file is not found");
          AppMethodBeat.o(217497);
          return false;
        }
        APLog.d("APPluginChecker", "Check all plugin valid, sign file exist!");
        localHashMap = new HashMap();
        APPluginUtils.readSingInfo(localHashMap, localFile);
        paramFile = paramFile.listFiles();
        j = 0;
        i = 0;
        if (j < paramFile.length)
        {
          localFile = paramFile[j];
          String str1 = localFile.getName();
          APLog.d("APPluginChecker", "Check all plugin valid, current check file = ".concat(String.valueOf(str1)));
          if ((str1.startsWith("MidasSign")) || (!str1.startsWith("Midas")))
          {
            APLog.d("APPluginChecker", "Check all plugin valid, ignore = ".concat(String.valueOf(str1)));
          }
          else
          {
            String str2 = (String)localHashMap.get(str1.split("\\_")[0]);
            if (!TextUtils.isEmpty(str2)) {
              if (!APPluginUtils.checkFileMD5(localFile.getCanonicalPath(), str2))
              {
                APLog.d("APPluginChecker", "Check all plugin valid, current check file = " + str1 + ", MD5 not OK");
                localFile.delete();
              }
              else
              {
                i += 1;
                APLog.d("APPluginChecker", "Check all plugin valid, current check file = " + str1 + ", MD5 OK");
              }
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        AppMethodBeat.o(217497);
        return false;
      }
      if ((i != localHashMap.size()) || (i < 2))
      {
        APLog.e("APPluginChecker", "Check all plugin valid, all valid file num = " + i + ", but sign file size = " + localHashMap.size() + ", check fail!");
        AppMethodBeat.o(217497);
        return false;
      }
      APLog.d("APPluginChecker", "Check all plugin valid, all valid file num = " + i + ", sign file size = " + localHashMap.size() + ", check success!");
      AppMethodBeat.o(217497);
      return true;
      j += 1;
    }
  }
  
  public static boolean isPluginValid(Context paramContext)
  {
    AppMethodBeat.i(217478);
    APLog.d("APPluginChecker", "Calling into isPluginValid " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    boolean bool = isAllPluginValid(APPluginConfig.getPluginPath(paramContext));
    AppMethodBeat.o(217478);
    return bool;
  }
  
  public static boolean isPluginValid(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217506);
    if (TextUtils.isEmpty(paramString1))
    {
      APLog.e("APPluginChecker", "Cannot check plugin valid, pluginPath is null!");
      AppMethodBeat.o(217506);
      return false;
    }
    APLog.d("APPluginChecker", "Check plugin valid, parameter ok!");
    try
    {
      Object localObject = new File(paramString1.substring(0, paramString1.lastIndexOf("/")));
      File localFile = new File(((File)localObject).getCanonicalPath() + File.separator + APPluginConfig.SIGN_FILE_NAME);
      if (!localFile.exists())
      {
        APLog.e("APPluginChecker", "Check plugin valid, sign file is not found");
        AppMethodBeat.o(217506);
        return false;
      }
      APLog.d("APPluginChecker", "Check plugin valid, sign file exist!");
      localObject = new HashMap();
      APPluginUtils.readSingInfo((HashMap)localObject, localFile);
      paramString1 = new File(paramString1).getName();
      APLog.d("APPluginChecker", "Check plugin valid, current check file = ".concat(String.valueOf(paramString1)));
      if (paramString2.equals((String)((HashMap)localObject).get(paramString1.split("\\_")[0])))
      {
        APLog.d("APPluginChecker", "Check plugin valid, current check file = " + paramString1 + ", MD5 OK");
        AppMethodBeat.o(217506);
        return true;
      }
      APLog.d("APPluginChecker", "Check plugin valid, current check file = " + paramString1 + ", MD5 not OK");
      AppMethodBeat.o(217506);
      return false;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(217506);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginChecker
 * JD-Core Version:    0.7.0.1
 */