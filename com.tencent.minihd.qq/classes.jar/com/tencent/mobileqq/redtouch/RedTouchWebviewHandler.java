package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchWebviewHandler
  extends VasWebviewJsPlugin
{
  private static final String ERRMSG_EXCEPTION = "exception";
  private static final String ERRMSG_FAILED = "failed";
  private static final String ERRMSG_NO_DATA = "data not prepared or cannot find the path, try again.";
  private static final String ERRMSG_SUCCESS = "success";
  public static final int INTVALUE_UNKNOWN = -1;
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_ERROR_MSG = "errorMessage";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESULT = "ret";
  public static final String KEY_SRC_TYPE = "srcType";
  public static final String KEY_TYPE = "type";
  public static final int LEBA_ITEM_OFF = 0;
  public static final int LEBA_ITEM_ON = 1;
  public static final String METHOD_GET_LEBA_STATE = "getDynamicState";
  public static final String METHOD_SET_LEBA_STATE = "setDynamicState";
  private static final String OBJECT_NAME = "redpoint";
  public static final String REDBUFFERJSON_2722 = "2722";
  public static final String REDBUFFERJSON_PARAM = "param";
  public static String TAG = "RedTouchWebviewHandler";
  public static final int VALUE_EXCEPTION = -1;
  public static final int VALUE_FAILED = 1;
  public static final int VALUE_SUCCESS = 0;
  
  private void IPCItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(DataFactory.makeIPCRequestPacket("myIndividuationRedInfo", null, 0, localBundle), false, true);
  }
  
  private JSONObject getRedBufferJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("param");
        if (localJSONObject2 == null) {
          return null;
        }
        Iterator localIterator = localJSONObject2.keys();
        paramJSONObject = localJSONObject1;
        if (localIterator.hasNext())
        {
          paramJSONObject = localJSONObject2.getJSONObject((String)localIterator.next());
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  private void onReportRed(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      new RedTouchManager(this.mRuntime.a()).b(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void getAppInfo(String paramString)
  {
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).getString("callback");
        try
        {
          localObject2 = ((JSONObject)localObject2).getString("path");
          localObject2 = new RedTouchManager(this.mRuntime.a()).a((String)localObject2);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get() == -1)
          {
            localJSONObject.put("code", -3);
            localJSONObject.put("errorMessage", "appInfo not found");
            localObject1 = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getAppInfo:" + localJSONObject.toString());
              localObject1 = paramString;
            }
            callJs((String)localObject1, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          ((JSONObject)localObject1).put("appID", ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
          ((JSONObject)localObject1).put("iNewFlag", ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
          JSONArray localJSONArray = new JSONArray();
          int i = 0;
          if (i < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
          {
            localJSONArray.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(i));
            i += 1;
            continue;
          }
          ((JSONObject)localObject1).put("missions", localJSONArray);
          ((JSONObject)localObject1).put("type", ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
          ((JSONObject)localObject1).put("buffer", ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
          ((JSONObject)localObject1).put("path", ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
          ((JSONObject)localObject1).put("appset", ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.get());
          ((JSONObject)localObject1).put("modify_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
          ((JSONObject)localObject1).put("num", ((BusinessInfoCheckUpdate.AppInfo)localObject2).num.get());
          ((JSONObject)localObject1).put("push_red_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.get());
          localJSONObject.put("data", localObject1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void getDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", RedTouchManager.a(localObject.getString("path")));
        paramString = str;
        sendRemoteReq(DataFactory.makeIPCRequestPacket("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void getIndividuationType(String paramString)
  {
    String str1 = "0";
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str2 = new JSONObject(paramString).getString("callback");
      RedTouchManager localRedTouchManager = new RedTouchManager(this.mRuntime.a());
      Object localObject = localRedTouchManager.a("100005.100022");
      paramString = str1;
      if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
      {
        localObject = getRedBufferJson(new JSONObject(((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.get()));
        paramString = str1;
        if (localObject != null) {
          if (!((JSONObject)localObject).has("_red_ext_busi_")) {
            break label163;
          }
        }
      }
      label163:
      for (paramString = ((JSONObject)localObject).getString("_red_ext_busi_");; paramString = "0")
      {
        localJSONObject.put("result", paramString);
        onReportRed(localRedTouchManager.a("100005.100022"), 1002);
        IPCItemClick("100005.100022");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getRedPointShowInfo(String paramString)
  {
    int j = -1;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localRedTouchManager = new RedTouchManager(this.mRuntime.a());
          if (!((JSONObject)localObject).isNull("set"))
          {
            localObject = ((JSONObject)localObject).getString("set");
            try
            {
              i = Integer.parseInt((String)localObject);
              if ((i == 0) || (i == 1) || (i == 2)) {
                continue;
              }
              localJSONObject2.put("code", -3);
              localJSONObject2.put("errorMessage", "redPoint showInfo not found");
              callJs(paramString, new String[] { localJSONObject2.toString() });
              return;
            }
            catch (Exception localException1)
            {
              localJSONObject2.put("code", -3);
              localJSONObject2.put("errorMessage", "redPoint showInfo not found");
              callJs(paramString, new String[] { localJSONObject2.toString() });
              return;
            }
            localException2.printStackTrace();
          }
        }
        catch (Exception localException2) {}
      }
      catch (Exception localException3)
      {
        Object localObject;
        RedTouchManager localRedTouchManager;
        String str1;
        String str2;
        paramString = "callback";
        continue;
        int i = 0;
        continue;
      }
      try
      {
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
        continue;
      }
      callJs(str1, new String[] { localJSONObject2.toString() });
      return;
      localJSONObject2.put("code", 0);
      localObject = localRedTouchManager.a(Integer.parseInt((String)localObject));
      if (localObject == null) {
        continue;
      }
      j = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get();
      i = 1;
      str1.put("hintType", j);
      str1.put("number", 0);
      str1.put("isShow", i);
      localJSONObject2.put("data", str1);
      str1 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject2.toString());
        str1 = paramString;
        continue;
        if (!((JSONObject)localObject).isNull("path"))
        {
          localObject = localRedTouchManager.a(((JSONObject)localObject).getString("path"));
          if (localObject == null)
          {
            localJSONObject2.put("code", -1);
            localJSONObject2.put("errorMessage", "missing path");
            str1 = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject2.toString());
              str1 = paramString;
            }
          }
          else if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() == -1)
          {
            localJSONObject2.put("code", -3);
            localJSONObject2.put("errorMessage", "appInfo not found");
          }
          else
          {
            localJSONObject2.put("code", 0);
            str1.put("hintType", ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
            str1.put("number", ((BusinessInfoCheckUpdate.AppInfo)localObject).num.get());
            str1.put("isShow", ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get());
            localJSONObject2.put("data", str1);
          }
        }
        else
        {
          localJSONObject2.put("code", -1);
          localJSONObject2.put("errorMessage", "missing set and path");
          str1 = paramString;
        }
      }
    }
  }
  
  public void getServerTime(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getString("callback");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject1.put("time", NetConnInfoCenter.getServerTimeMillis());
          localJSONObject2.put("data", localJSONObject1);
          localJSONObject2.put("code", 0);
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception localException2)
        {
          break label79;
        }
        localException1 = localException1;
        paramString = "callback";
      }
      try
      {
        label79:
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return super.handleEvent(paramString, paramInt, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("redpoint"))) {
      return false;
    }
    paramJsBridgeListener = new ArrayList();
    while (i < paramVarArgs.length)
    {
      paramJsBridgeListener.add(paramVarArgs[i]);
      i += 1;
    }
    return call(paramString3, paramJsBridgeListener);
  }
  
  public void isEnterFromRedPoint(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getString("path");
          if (!new RedTouchManager(this.mRuntime.a()).a().equals(localObject))
          {
            localJSONObject.put("code", -3);
            localJSONObject.put("errorMessage", "last click is not this path");
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getAppInfo:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          localJSONObject.put("data", 1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle == null) {}
    String str2;
    String str1;
    label162:
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if ("leba_item_set".equals(str2))
      {
        if (paramBundle == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set leba item result: " + i);
          }
          paramBundle = new JSONObject();
        }
        for (;;)
        {
          try
          {
            paramBundle.put("ret", i);
            if (i != 0) {
              break label162;
            }
            paramBundle.put("errorMessage", "success");
            callJs(str1, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          i = paramBundle.getInt("ret");
          break;
          paramBundle.put("errorMessage", "failed");
        }
      }
    } while (!"leba_item_get".equals(str2));
    int j;
    if (paramBundle == null)
    {
      i = 1;
      if (i != 0) {
        break label317;
      }
      j = paramBundle.getInt("type", -1);
      label203:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "get leba item result: " + i + ", type: " + j);
      }
      paramBundle = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramBundle.put("ret", i);
        paramBundle.put("type", j);
        if (i != 0) {
          break label322;
        }
        paramBundle.put("errorMessage", "success");
        callJs(str1, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i = paramBundle.getInt("ret");
      break;
      label317:
      j = -1;
      break label203;
      label322:
      paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
    }
  }
  
  public void reportBusinessRedTouch(String paramString)
  {
    localObject2 = "callback";
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      Object localObject4 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject4).getString("callback");
      localObject1 = paramString;
      ((JSONObject)localObject4).remove("callback");
      localObject1 = paramString;
      Object localObject5 = ((JSONObject)localObject4).getString("path");
      localObject1 = paramString;
      ((JSONObject)localObject4).remove("path");
      localObject1 = paramString;
      Object localObject6 = new RedTouchManager(this.mRuntime.a()).a((String)localObject5);
      localObject1 = paramString;
      localObject2 = (QQBrowserActivity)this.mRuntime.a();
      localObject1 = paramString;
      Object localObject3 = new BusinessInfoCheckUpdate.ReportReqBody();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).uin.set(Long.parseLong(this.mRuntime.a().a()));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).clientver.set("5.9.3.3468");
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).platid.set(109);
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).appid.set(RedTouchManager.a((String)localObject5));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).platver.set(Build.VERSION.SDK_INT + "");
      localObject1 = paramString;
      if (((BusinessInfoCheckUpdate.AppInfo)localObject6).missions.has())
      {
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).missionid.set(((BusinessInfoCheckUpdate.AppInfo)localObject6).missions.get());
      }
      localObject1 = paramString;
      localObject5 = new ArrayList();
      localObject1 = paramString;
      localObject6 = ((JSONObject)localObject4).keys();
      for (;;)
      {
        localObject1 = paramString;
        if (!((Iterator)localObject6).hasNext()) {
          break;
        }
        localObject1 = paramString;
        String str = (String)((Iterator)localObject6).next();
        localObject1 = paramString;
        BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
        localObject1 = paramString;
        localReportStaticsData.key.set(str);
        localObject1 = paramString;
        localReportStaticsData.value.set(((JSONObject)localObject4).getString(str));
        localObject1 = paramString;
        ((List)localObject5).add(localReportStaticsData);
        localObject1 = paramString;
        System.out.println("key:" + localReportStaticsData.key.get() + "value:" + localReportStaticsData.value.get());
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        for (;;)
        {
          callJs((String)localObject1, new String[] { localJSONObject.toString() });
          return;
          localObject1 = paramString;
          localObject4 = new JSONObject();
          if (localObject4 != null)
          {
            localObject1 = paramString;
            ((JSONObject)localObject4).put("cmd", 5);
          }
          localObject1 = paramString;
          ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).buffer.set(((JSONObject)localObject4).toString());
          localObject1 = paramString;
          ((BusinessInfoCheckUpdate.ReportReqBody)localObject3).reportdata.set((List)localObject5);
          localObject1 = paramString;
          localObject4 = new ToServiceMsg("mobileqq.service", this.mRuntime.a().a(), "RedTouchSvc.ClientReport");
          localObject1 = paramString;
          ((ToServiceMsg)localObject4).putWupBuffer(((BusinessInfoCheckUpdate.ReportReqBody)localObject3).toByteArray());
          localObject1 = paramString;
          ((ToServiceMsg)localObject4).extraData.putBoolean("req_pb_protocol_flag", true);
          localObject1 = paramString;
          long l = ((ToServiceMsg)localObject4).getWupBuffer().length;
          localObject1 = paramString;
          localObject3 = new byte[(int)l + 4];
          localObject1 = paramString;
          PkgTools.a((byte[])localObject3, 0, 4L + l);
          localObject1 = paramString;
          PkgTools.a((byte[])localObject3, 4, ((ToServiceMsg)localObject4).getWupBuffer(), (int)l);
          localObject1 = paramString;
          ((ToServiceMsg)localObject4).putWupBuffer((byte[])localObject3);
          localObject1 = paramString;
          localObject3 = new NewIntent(((QQBrowserActivity)localObject2).getApplication(), TempServlet.class);
          localObject1 = paramString;
          ((NewIntent)localObject3).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject4);
          localObject1 = paramString;
          ((QQBrowserActivity)localObject2).getAppRuntime().startServlet((NewIntent)localObject3);
          localObject1 = paramString;
          localJSONObject.put("code", 0);
          localObject1 = paramString;
          if (QLog.isColorLevel())
          {
            localObject1 = paramString;
            QLog.i(TAG, 2, "reportBusinessRedTouch:" + localJSONObject.toString());
          }
          localObject1 = paramString;
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    new JSONObject();
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      Object localObject4 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject4).getString("callback");
      localObject1 = paramString;
      Object localObject3 = ((JSONObject)localObject4).getString("path");
      localObject1 = paramString;
      int i = ((JSONObject)localObject4).getInt("isWithRedPoint");
      localObject1 = paramString;
      localObject2 = (QQBrowserActivity)this.mRuntime.a();
      localObject1 = paramString;
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new RedTouchManager(this.mRuntime.a()).a((String)localObject3);
      localObject1 = paramString;
      localObject4 = new BusinessInfoCheckUpdate.ReportReqBody();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).uin.set(Long.parseLong(this.mRuntime.a().a()));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).clientver.set("5.9.3.3468");
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).platid.set(109);
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).appid.set(RedTouchManager.a((String)localObject3));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).platver.set(Build.VERSION.SDK_INT + "");
      localObject1 = paramString;
      if ((localAppInfo.missions.has()) && (i == 1))
      {
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).missionid.set(localAppInfo.missions.get());
      }
      localObject1 = paramString;
      localObject3 = new ToServiceMsg("mobileqq.service", this.mRuntime.a().a(), "RedTouchSvc.ClientReport");
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).putWupBuffer(((BusinessInfoCheckUpdate.ReportReqBody)localObject4).toByteArray());
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).extraData.putBoolean("req_pb_protocol_flag", true);
      localObject1 = paramString;
      long l = ((ToServiceMsg)localObject3).getWupBuffer().length;
      localObject1 = paramString;
      localObject4 = new byte[(int)l + 4];
      localObject1 = paramString;
      PkgTools.a((byte[])localObject4, 0, 4L + l);
      localObject1 = paramString;
      PkgTools.a((byte[])localObject4, 4, ((ToServiceMsg)localObject3).getWupBuffer(), (int)l);
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).putWupBuffer((byte[])localObject4);
      localObject1 = paramString;
      localObject4 = new NewIntent(((QQBrowserActivity)localObject2).getApplication(), TempServlet.class);
      localObject1 = paramString;
      ((NewIntent)localObject4).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject3);
      localObject1 = paramString;
      ((QQBrowserActivity)localObject2).getAppRuntime().startServlet((NewIntent)localObject4);
      localObject1 = paramString;
      localJSONObject.put("code", 0);
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = paramString;
        QLog.i(TAG, 2, "reportRedTouch:" + localJSONObject.toString());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
          paramString = (String)localObject1;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          paramString = (String)localObject1;
        }
      }
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  public void setAppInfo(String paramString)
  {
    new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getJSONObject("appInfo");
          RedTouchManager localRedTouchManager = new RedTouchManager(this.mRuntime.a());
          BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
          localAppInfo.uiAppId.set(((JSONObject)localObject).getInt("appID"));
          localAppInfo.iNewFlag.set(((JSONObject)localObject).getInt("iNewFlag"));
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("missions");
          int i = 0;
          if (i < localJSONArray.length())
          {
            localAppInfo.missions.add(localJSONArray.getString(i));
            i += 1;
            continue;
          }
          localAppInfo.type.set(((JSONObject)localObject).getInt("type"));
          localAppInfo.buffer.set(((JSONObject)localObject).getString("buffer"));
          localAppInfo.path.set(((JSONObject)localObject).getString("path"));
          localAppInfo.appset.set(((JSONObject)localObject).getInt("appset"));
          localAppInfo.modify_ts.set(((JSONObject)localObject).getInt("modify_ts"));
          localAppInfo.num.set(((JSONObject)localObject).getInt("num"));
          localAppInfo.push_red_ts.set(((JSONObject)localObject).getInt("push_red_ts"));
          i = localRedTouchManager.a(localAppInfo, false);
          localJSONObject.put("code", i);
          if (i == -3)
          {
            localJSONObject.put("errorMessage", "appInfo not found");
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "setAppInfo:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          if (i != -4) {
            continue;
          }
          localJSONObject.put("errorMessage", "failed to set appInfo");
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void setDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", RedTouchManager.a(localObject.getString("path")));
        paramString = str;
        localBundle.putInt("type", localObject.getInt("type"));
        paramString = str;
        sendRemoteReq(DataFactory.makeIPCRequestPacket("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */