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
    AppMethodBeat.i(193405);
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
      AppMethodBeat.o(193405);
      return str1;
    }
    AppMethodBeat.o(193405);
    return "";
  }
  
  private static String buildFileName(boolean paramBoolean)
  {
    AppMethodBeat.i(193408);
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
            AppMethodBeat.o(193408);
            return str;
          }
          ((StringBuffer)localObject).append(APLogFileUtil.getToday());
          ((StringBuffer)localObject).append("_");
          ((StringBuffer)localObject).append(buildFileNumber(str));
          ((StringBuffer)localObject).append(".txt");
          if (localObject != null) {
            continue;
          }
          AppMethodBeat.o(193408);
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
        AppMethodBeat.o(193408);
        return localObject;
      }
    }
  }
  
  private static int buildFileNumber(String paramString)
  {
    j = 1;
    AppMethodBeat.i(193406);
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
    AppMethodBeat.o(193406);
    return i;
  }
  
  private static String buildMmapName()
  {
    AppMethodBeat.i(193404);
    String str = dirName + File.separator + "MidasLog.mmap";
    AppMethodBeat.o(193404);
    return str;
  }
  
  public static void create()
  {
    AppMethodBeat.i(193403);
    try
    {
      dirName = buildDirName();
      fileName = buildFileName(true);
      mmapName = buildMmapName();
      new StringBuilder("log dir: ").append(dirName);
      new StringBuilder("log file: ").append(fileName);
      AppMethodBeat.o(193403);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("file info create error: ").append(localThrowable.toString());
      AppMethodBeat.o(193403);
    }
  }
  
  public static void updateFileName()
  {
    AppMethodBeat.i(193407);
    fileName = buildFileName(false);
    new StringBuilder("update file name: ").append(fileName);
    AppMethodBeat.o(193407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.APLogFileInfo
 * JD-Core Version:    0.7.0.1
 */