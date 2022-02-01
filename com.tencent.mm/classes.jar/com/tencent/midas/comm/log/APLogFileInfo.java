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
    AppMethodBeat.i(217210);
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
      AppMethodBeat.o(217210);
      return str1;
    }
    AppMethodBeat.o(217210);
    return "";
  }
  
  private static String buildFileName(boolean paramBoolean)
  {
    AppMethodBeat.i(217245);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(dirName)) {
          localObject1 = new StringBuffer(dirName);
        }
        String str;
        Object localObject1 = null;
      }
      finally
      {
        try
        {
          if (!dirName.endsWith(File.separator)) {
            ((StringBuffer)localObject1).append(File.separator);
          }
          str = APLogFileUtil.getLastLogFileName(dirName);
          if ((paramBoolean) && (!TextUtils.isEmpty(str)))
          {
            ((StringBuffer)localObject1).append(str);
            str = ((StringBuffer)localObject1).toString();
            AppMethodBeat.o(217245);
            return str;
          }
          ((StringBuffer)localObject1).append(APLogFileUtil.getToday());
          ((StringBuffer)localObject1).append("_");
          ((StringBuffer)localObject1).append(buildFileNumber(str));
          ((StringBuffer)localObject1).append(".txt");
          if (localObject1 != null) {
            continue;
          }
          AppMethodBeat.o(217245);
          return "";
        }
        finally
        {
          continue;
        }
        localObject2 = finally;
        localObject1 = null;
        new StringBuilder("create log file name error:").append(localObject2.toString());
        continue;
        localObject1 = ((StringBuffer)localObject1).toString();
        AppMethodBeat.o(217245);
        return localObject1;
      }
    }
  }
  
  private static int buildFileNumber(String paramString)
  {
    j = 1;
    AppMethodBeat.i(217222);
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
    finally
    {
      for (;;)
      {
        new StringBuilder("build file number error: ").append(paramString.getMessage());
        i = j;
      }
    }
    AppMethodBeat.o(217222);
    return i;
  }
  
  private static String buildMmapName()
  {
    AppMethodBeat.i(217204);
    String str = dirName + File.separator + "MidasLog.mmap";
    AppMethodBeat.o(217204);
    return str;
  }
  
  public static void create()
  {
    AppMethodBeat.i(217196);
    try
    {
      dirName = buildDirName();
      fileName = buildFileName(true);
      mmapName = buildMmapName();
      new StringBuilder("log dir: ").append(dirName);
      return;
    }
    finally
    {
      new StringBuilder("file info create error: ").append(localObject.toString());
      AppMethodBeat.o(217196);
    }
  }
  
  public static void updateFileName()
  {
    AppMethodBeat.i(217229);
    fileName = buildFileName(false);
    new StringBuilder("update file name: ").append(fileName);
    AppMethodBeat.o(217229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.log.APLogFileInfo
 * JD-Core Version:    0.7.0.1
 */