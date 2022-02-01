package com.tencent.midas.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APMidasPluginDownloadUtils
{
  private static final String TAG = "PDUtils";
  
  static boolean checkIniFileExist(File paramFile)
  {
    AppMethodBeat.i(193254);
    if (paramFile == null)
    {
      AppMethodBeat.o(193254);
      return false;
    }
    if (!paramFile.isDirectory())
    {
      AppMethodBeat.o(193254);
      return false;
    }
    boolean bool = new File(paramFile, "MidasSign.ini").exists();
    AppMethodBeat.o(193254);
    return bool;
  }
  
  private static JSONArray getPureH5UpdateJsAlertData(String paramString)
  {
    AppMethodBeat.i(193252);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("midassdk://")) && (paramString.length() > 11))
    {
      paramString = paramString.substring(11, paramString.length());
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("action")) && ("update".equalsIgnoreCase(paramString.getString("action"))) && (paramString.has("data")) && (!TextUtils.isEmpty(paramString.getString("data"))))
        {
          paramString = paramString.getJSONArray("data");
          AppMethodBeat.o(193252);
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(193252);
        return null;
      }
    }
    AppMethodBeat.o(193252);
    return null;
  }
  
  public static boolean handlePureH5UpdateJsAlertLogic(Context paramContext, final String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(193256);
    if (paramContext == null)
    {
      APLog.d("PDUtils", "Cannot handle h5 update logic! Null context!");
      AppMethodBeat.o(193256);
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      APLog.d("PDUtils", "Cannot handle h5 update logic! Empty alert message!");
      AppMethodBeat.o(193256);
      return false;
    }
    if (isPureH5UpdateJsAlert(paramString)) {
      bool = true;
    }
    paramString = getPureH5UpdateJsAlertData(paramString);
    if (paramString == null)
    {
      APLog.d("PDUtils", "Cannot handle h5 update logic! Not relevant message!");
      AppMethodBeat.o(193256);
      return bool;
    }
    APLog.d("PDUtils", "Got h5 update alert message!");
    paramString = parseDownJson(paramString);
    if (paramString == null)
    {
      APLog.d("PDUtils", "Got h5 update alert message! Cannot parse json to list!");
      AppMethodBeat.o(193256);
      return bool;
    }
    if (paramString.size() <= 0)
    {
      APLog.d("PDUtils", "Got h5 update alert message! Cannot parse json to list! Size error = " + paramString.size());
      AppMethodBeat.o(193256);
      return bool;
    }
    APLog.d("PDUtils", "Got h5 update alert message! Start down lists = " + paramString.toString());
    APMidasPluginDownloadManager.startDownload(paramContext, paramString, new IAPMidasPluginDownListener()
    {
      public final void onDownloadFail(int paramAnonymousInt) {}
      
      public final void onDownloadSuccess()
      {
        AppMethodBeat.i(193237);
        APLog.d("PDUtils", "Got h5 update alert message! List download success!");
        APMidasPluginDownloadUtils.access$000(this.val$context, paramString);
        AppMethodBeat.o(193237);
      }
    });
    AppMethodBeat.o(193256);
    return bool;
  }
  
  private static boolean isPureH5UpdateJsAlert(String paramString)
  {
    AppMethodBeat.i(193253);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("midassdk://")) && (paramString.length() > 11))
    {
      Object localObject = paramString.substring(11, paramString.length());
      try
      {
        localObject = new JSONObject((String)localObject);
        if ((((JSONObject)localObject).has("action")) && ("update".equalsIgnoreCase(((JSONObject)localObject).getString("action"))))
        {
          APLog.d("PDUtils", "isPureH5UpdateJsAlert msg = ".concat(String.valueOf(paramString)));
          APLog.d("PDUtils", "isPureH5UpdateJsAlert == true!");
          AppMethodBeat.o(193253);
          return true;
        }
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(193253);
        return false;
      }
    }
    AppMethodBeat.o(193253);
    return false;
  }
  
  private static ArrayList<APMidasPluginDownInfo> parseDownJson(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(193251);
    if (paramJSONArray == null)
    {
      APLog.e("PDUtils", "Cannot parse down json! jsonArray is null!");
      AppMethodBeat.o(193251);
      return null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      int i;
      APMidasPluginDownInfo localAPMidasPluginDownInfo;
      try
      {
        int j = paramJSONArray.length();
        if (j == 0)
        {
          APLog.e("PDUtils", "Cannot parse down json! jsonArray length is 0!");
          AppMethodBeat.o(193251);
          return null;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i >= j) {
          break;
        }
        localAPMidasPluginDownInfo = new APMidasPluginDownInfo();
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        localAPMidasPluginDownInfo.name = localJSONObject.getString("file_name");
        if (TextUtils.isEmpty(localAPMidasPluginDownInfo.name))
        {
          APLog.e("PDUtils", "Cannot parse down json! item's name is empty!");
          AppMethodBeat.o(193251);
          return null;
        }
        localAPMidasPluginDownInfo.new_md5_encode = localJSONObject.getString("update_md5");
        if (TextUtils.isEmpty(localAPMidasPluginDownInfo.new_md5_encode))
        {
          APLog.e("PDUtils", "Cannot parse down json! item's new encode md5 is empty!");
          AppMethodBeat.o(193251);
          return null;
        }
        try
        {
          String str = localAPMidasPluginDownInfo.new_md5_encode;
          str = new APMidasRSATools().deCodeKey(str);
          localAPMidasPluginDownInfo.new_md5_decode = str.substring(str.length() - 32);
          APLog.d("PDUtils", "Parse down json! name = " + localAPMidasPluginDownInfo.name + " decode md5 success!");
          if (TextUtils.isEmpty(localAPMidasPluginDownInfo.new_md5_decode))
          {
            APLog.e("PDUtils", "Cannot parse down json! item's new decode md5 is empty!");
            AppMethodBeat.o(193251);
            return null;
          }
        }
        catch (Exception localException)
        {
          APLog.e("PDUtils", "Cannot parse down json, decode md5 got exception = ".concat(String.valueOf(localException)));
          continue;
        }
        localAPMidasPluginDownInfo.full_url = localJSONObject.getString("full_download_url");
      }
      catch (Exception paramJSONArray)
      {
        APLog.e("PDUtils", "Cannot parse down json! exception = ".concat(String.valueOf(paramJSONArray)));
        AppMethodBeat.o(193251);
        return null;
      }
      if (TextUtils.isEmpty(localAPMidasPluginDownInfo.full_url))
      {
        APLog.e("PDUtils", "Cannot parse down json! item's full url is empty!");
        AppMethodBeat.o(193251);
        return null;
      }
      localArrayList.add(localAPMidasPluginDownInfo);
      i += 1;
    }
    AppMethodBeat.o(193251);
    return localArrayList;
  }
  
  private static void writeMidasSignFile(Context paramContext, ArrayList<APMidasPluginDownInfo> paramArrayList)
  {
    AppMethodBeat.i(193255);
    if (paramContext == null)
    {
      APLog.e("PDUtils", "Cannot write MidasSign.ini! null context!");
      AppMethodBeat.o(193255);
      return;
    }
    if (paramArrayList == null)
    {
      APLog.e("PDUtils", "Cannot write MidasSign.ini! null list!");
      AppMethodBeat.o(193255);
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      APLog.e("PDUtils", "Cannot write MidasSign.ini! list size error = " + paramArrayList.size());
      AppMethodBeat.o(193255);
      return;
    }
    Object localObject = new File(paramContext.getApplicationContext().getDir("midaspluginsTemp", 0), "MidasSign.ini");
    if ((((File)localObject).exists()) && (!((File)localObject).delete()))
    {
      APLog.e("PDUtils", "Cannot delete old MidasSign.ini file!");
      AppMethodBeat.o(193255);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayList.size();
    int i = 0;
    if (i < j)
    {
      paramContext = ((APMidasPluginDownInfo)paramArrayList.get(i)).name;
      if (TextUtils.isEmpty(paramContext))
      {
        APLog.e("PDUtils", "Cannot write MidasSign.ini! item name empty!");
        AppMethodBeat.o(193255);
        return;
      }
      if (paramContext.endsWith(".apk")) {
        break label368;
      }
      paramContext = paramContext + ".apk";
    }
    label368:
    for (;;)
    {
      String str = ((APMidasPluginDownInfo)paramArrayList.get(i)).new_md5_encode;
      if (TextUtils.isEmpty(str))
      {
        APLog.e("PDUtils", "Cannot write MidasSign.ini! item md5 empty!");
        AppMethodBeat.o(193255);
        return;
      }
      localStringBuilder.append(paramContext + ":" + str);
      localStringBuilder.append("\r\n");
      i += 1;
      break;
      paramContext = localStringBuilder.toString();
      try
      {
        paramArrayList = new FileWriter((File)localObject);
        localObject = new BufferedWriter(paramArrayList);
        ((BufferedWriter)localObject).write(paramContext);
        ((BufferedWriter)localObject).close();
        paramArrayList.close();
        APLog.d("PDUtils", "Write MidasSign.ini success!");
        AppMethodBeat.o(193255);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          APLog.e("PDUtils", "Write MidasSign.ini got exception = ".concat(String.valueOf(paramContext)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.download.APMidasPluginDownloadUtils
 * JD-Core Version:    0.7.0.1
 */