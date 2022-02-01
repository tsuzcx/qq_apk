package com.tencent.midas.comm.log;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.File;

public class APLogFileInfo
{
  public static String dirName = "";
  public static String fileName = "";
  public static String mmapName = "";
  
  private static String buildDirName()
  {
    AppMethodBeat.i(253965);
    APLogInfo localAPLogInfo = APLog.getLogInfo();
    if ((localAPLogInfo != null) && (localAPLogInfo.getLogPath() != null))
    {
      String str2 = localAPLogInfo.getLogPath();
      String str1 = str2;
      if (!str2.endsWith(File.separator)) {
        str1 = str2 + File.separator;
      }
      str2 = str1 + localAPLogInfo.getPkgName() + File.separator;
      str1 = str2;
      if (!TextUtils.isEmpty(localAPLogInfo.getProcessName())) {
        str1 = str2 + localAPLogInfo.getProcessName() + File.separator;
      }
      AppMethodBeat.o(253965);
      return str1;
    }
    AppMethodBeat.o(253965);
    return "";
  }
  
  private static String buildFileName(boolean paramBoolean)
  {
    AppMethodBeat.i(253970);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(dirName)) {
          localObject = new StringBuffer(dirName);
        }
        String str;
        Object localObject = null;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (!dirName.endsWith(File.separator)) {
            ((StringBuffer)localObject).append(File.separator);
          }
          str = APLogFileUtil.getLastLogFileName(dirName);
          if ((paramBoolean) && (!TextUtils.isEmpty(str)))
          {
            ((StringBuffer)localObject).append(str);
            str = ((StringBuffer)localObject).toString();
            AppMethodBeat.o(253970);
            return str;
          }
          ((StringBuffer)localObject).append(APLogFileUtil.getToday());
          ((StringBuffer)localObject).append("_");
          ((StringBuffer)localObject).append(buildFileNumber(str));
          ((StringBuffer)localObject).append(".txt");
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(253970);
          return "";
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        localThrowable1 = localThrowable1;
        localObject = null;
        new StringBuilder("create log file name error:").append(localThrowable1.toString());
        continue;
        localObject = ((StringBuffer)localObject).toString();
        AppMethodBeat.o(253970);
        return localObject;
      }
    }
  }
  
  private static int buildFileNumber(String paramString)
  {
    j = 1;
    AppMethodBeat.i(253967);
    i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = paramString.split(APLogFileUtil.getToday() + "_");
      i = j;
      if (paramString.length > 1)
      {
        i = Integer.parseInt(paramString[1].split(".txt")[0]);
        i += 1;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        new StringBuilder("build file number error: ").append(paramString.getMessage());
        i = j;
      }
    }
    AppMethodBeat.o(253967);
    return i;
  }
  
  private static String buildMmapName()
  {
    AppMethodBeat.i(253963);
    String str = dirName + File.separator + "MidasLog.mmap";
    AppMethodBeat.o(253963);
    return str;
  }
  
  public static void create()
  {
    AppMethodBeat.i(253961);
    try
    {
      dirName = buildDirName();
      fileName = buildFileName(true);
      mmapName = buildMmapName();
      new StringBuilder("log dir: ").append(dirName);
      new StringBuilder("log file: ").append(fileName);
      AppMethodBeat.o(253961);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("file info create error: ").append(localThrowable.toString());
      AppMethodBeat.o(253961);
    }
  }
  
  public static void updateFileName()
  {
    AppMethodBeat.i(253968);
    fileName = buildFileName(false);
    new StringBuilder("update file name: ").append(fileName);
    AppMethodBeat.o(253968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.log.APLogFileInfo
 * JD-Core Version:    0.7.0.1
 */