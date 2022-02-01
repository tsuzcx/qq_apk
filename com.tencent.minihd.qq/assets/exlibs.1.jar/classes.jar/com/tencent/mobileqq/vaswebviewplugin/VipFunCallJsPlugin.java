package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipFunCallJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "funCall";
  public static final String CALLBACK = "callback";
  public static final String CURRENTID = "currentId";
  public static final String DATA = "data";
  public static final int DOWNLOAD_DONE = 3;
  public static final int DOWNLOAD_PROGRESS = 2;
  public static final int DOWNLOAD_START = 1;
  public static final String IMAGE_URL = "image_url";
  public static final String MESSAGE = "message";
  public static final String Method_downloadFunCallMedia = "downloadFunCallMedia";
  public static final String Method_getFunCallMedia = "getFunCallMedia";
  public static final String Method_getFunCallMediaList = "getFunCallMediaList";
  public static final String Method_openPreview = "openPreview";
  public static final String Method_queryDownloadInfo = "queryDownloadInfo";
  public static final String Method_setFunCallMedia = "setFunCallMedia";
  public static final String RESULT = "result";
  public static final String Tag = "FunCallJsPlugin";
  private String SetFuncallCallBack = "";
  private SparseArray down_bgprogress = new SparseArray();
  private SparseArray down_bgstatus = new SparseArray();
  private SparseArray down_progress = new SparseArray();
  private SparseArray down_status = new SparseArray();
  private QQBrowserActivity mBrowserActivity;
  private BrowserAppInterface mBrowserApp;
  
  private boolean checkLocalHasRes(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (VipFunCallManager.a(paramInt, VipFunCallManager.a()))
    {
      bool1 = bool2;
      if (VipFunCallManager.a(paramInt, VipFunCallManager.d)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void downloadFunCallMedia(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!Utils.e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunCallJsPlugin", 2, "SDCard not available.");
      }
      try
      {
        localJSONObject.put("code", VipFunCallManager.k);
        localJSONObject.put("errorMessage", "no sdcard");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    long l = Utils.b();
    if (l < 1048576)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunCallJsPlugin", 2, "Insufficient SDCard space, required: reserved:" + 1048576 + "|available:" + l);
      }
      try
      {
        localJSONObject.put("code", VipFunCallManager.j);
        localJSONObject.put("errorMessage", "SDCard is full");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    this.down_progress.put(paramInt, Integer.valueOf(0));
    this.down_status.put(paramInt, Integer.valueOf(1));
    this.down_bgprogress.put(paramInt, Integer.valueOf(0));
    this.down_bgstatus.put(paramInt, Integer.valueOf(1));
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("funcall_download", paramString, this.mOnRemoteResp.key, localBundle), false, false);
    try
    {
      localJSONObject.put("code", 0);
      localJSONObject.put("errorMessage", "id is downloading");
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void getFunCallMedia(String paramString)
  {
    int i = 0;
    int j = VipFunCallManager.b();
    JSONObject localJSONObject1 = new JSONObject();
    if (j == 0) {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("id", j);
        ((JSONObject)localObject).put("url", "https://imgcache.gtimg.cn/club/client/funCall/release/img/funcalldefault.jpg");
        ((JSONObject)localObject).put("name", "默认来电");
        localJSONObject1.put("code", 0);
        localJSONObject1.put("errorMessage", "sucess");
        localJSONObject1.put("data", localObject);
        callJs(paramString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    Object localObject = VipFunCallManager.a();
    if (localObject == null) {
      try
      {
        localJSONObject1.put("code", -1);
        localJSONObject1.put("errorMessage", "load list failed");
        callJs(paramString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    new JSONArray();
    for (;;)
    {
      try
      {
        localObject = ((JSONObject)localObject).getJSONArray("items");
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject2 = ((JSONArray)localObject).getJSONObject(i);
        if ((localJSONObject2 != null) && (localJSONObject2.getInt("id") == j))
        {
          localJSONObject1.put("code", 0);
          localJSONObject1.put("errorMessage", "sucess");
          localJSONObject1.put("data", localJSONObject2);
          callJs(paramString, new String[] { localJSONObject1.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void getFunCallMediaList(String paramString)
  {
    int i = 0;
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = VipFunCallManager.a();
    if (localObject == null) {
      try
      {
        localJSONObject1.put("code", -1);
        localJSONObject1.put("errorMessage", "load list failed");
        callJs(paramString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        localObject = ((JSONObject)localObject).getJSONArray("items");
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject2 = ((JSONArray)localObject).getJSONObject(i);
          if (localJSONObject2 != null) {
            localJSONArray.put(localJSONObject2);
          }
        }
        else
        {
          localJSONObject1.put("code", 0);
          localJSONObject1.put("errorMessage", "");
          localJSONObject1.put("data", localJSONArray);
          callJs(paramString, new String[] { localJSONObject1.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private void openPreview(int paramInt)
  {
    Intent localIntent = new Intent(this.mBrowserActivity, VipFunCallPreviewActivity.class);
    localIntent.putExtra("key_to_uin", this.mRuntime.a().getAccount());
    localIntent.putExtra("key_fun_call_id", paramInt);
    this.mBrowserActivity.startActivity(localIntent);
  }
  
  private void queryDownloadInfo(int paramInt, String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (checkLocalHasRes(paramInt)) {
      try
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("onProgress", 100);
        localJSONObject1.put("code", 0);
        localJSONObject1.put("errorMessage", "local has download");
        localJSONObject1.put("data", localJSONObject2);
        callJs(paramString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    if (this.down_status.get(paramInt) != null) {
      for (;;)
      {
        try
        {
          if ((((Integer)this.down_progress.get(paramInt)).intValue() == 0) && (((Integer)this.down_bgprogress.get(paramInt)).intValue() == 0))
          {
            localJSONObject2.put("status", 1);
            localJSONObject2.put("onProgress", 0);
            localJSONObject1.put("code", 0);
            localJSONObject1.put("errorMessage", "sucess");
            localJSONObject1.put("data", localJSONObject2);
            callJs(paramString, new String[] { localJSONObject1.toString() });
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        if ((((Integer)this.down_status.get(paramInt)).intValue() == 3) && (((Integer)this.down_bgstatus.get(paramInt)).intValue() == 3))
        {
          localJSONObject2.put("status", 3);
          localJSONObject2.put("onProgress", 100);
          if (checkLocalHasRes(paramInt)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FunCallJsPlugin", 2, "download 100, bug file do not find, id=" + paramInt);
          }
          try
          {
            localJSONObject1.put("code", VipFunCallManager.l);
            localJSONObject1.put("errorMessage", "download file err");
            callJs(paramString, new String[] { localJSONObject1.toString() });
            return;
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
        int i = ((Integer)this.down_progress.get(paramInt)).intValue();
        paramInt = (((Integer)this.down_bgprogress.get(paramInt)).intValue() * 3 + i * 7) / 10;
        localJSONObject2.put("status", 2);
        localJSONObject2.put("onProgress", paramInt);
      }
    }
    try
    {
      localJSONObject1.put("code", -1);
      localJSONObject1.put("errorMessage", "id res not find");
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void setFunCallMedia(int paramInt, String paramString)
  {
    this.SetFuncallCallBack = paramString;
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("funcall_set", paramString, this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FunCallJsPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected long getPluginBusiness()
  {
    return 2148007936L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FunCallJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"funCall".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    int j;
    try
    {
      j = paramString1.indexOf("=");
      if ((j != -1) && (j + 1 <= paramString1.length() - 1)) {
        break label101;
      }
      throw new Exception("Invalid Url Parameters");
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    return true;
    label101:
    paramString1 = new JSONObject(URLDecoder.decode(paramString1.substring(j + 1), "UTF-8"));
    if (paramString1.has("callback")) {}
    for (paramJsBridgeListener = paramString1.getString("callback");; paramJsBridgeListener = "")
    {
      if (paramString1.has("id")) {
        i = paramString1.getInt("id");
      }
      if (paramString1.has("status")) {
        paramString1.getInt("status");
      }
      if ("openPreview".equals(paramString3))
      {
        openPreview(i);
        break;
      }
      if ("setFunCallMedia".equals(paramString3))
      {
        setFunCallMedia(i, paramJsBridgeListener);
        break;
      }
      if ("downloadFunCallMedia".equals(paramString3))
      {
        downloadFunCallMedia(i, paramJsBridgeListener);
        break;
      }
      if ("queryDownloadInfo".equals(paramString3))
      {
        queryDownloadInfo(i, paramJsBridgeListener);
        break;
      }
      if ("getFunCallMedia".equals(paramString3))
      {
        getFunCallMedia(paramJsBridgeListener);
        break;
      }
      if ("getFunCallMediaList".equals(paramString3))
      {
        getFunCallMediaList(paramJsBridgeListener);
        break;
      }
      throw new Exception("No Such Method:" + paramString3);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i;
      int j;
      String str;
      int k;
      int m;
      try
      {
        i = paramBundle.getInt("srcType");
        if (i != 6) {
          break label746;
        }
        j = paramBundle.getInt("resourceType");
        if (j != VipFunCallManager.a) {
          break label389;
        }
        str = paramBundle.getString("status");
        if ("onProgress".equals(str))
        {
          k = paramBundle.getInt("id");
          this.down_progress.put(k, Integer.valueOf(paramBundle.getInt("progress")));
          this.down_status.put(k, Integer.valueOf(2));
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("FunCallJsPlugin", 2, "onProgress, id=" + k + ",srcType=" + i + ",resourceType=" + j + ",progress=" + this.down_progress.get(k));
          return;
        }
        if ("onDone".equals(str))
        {
          k = paramBundle.getInt("id");
          m = paramBundle.getInt("result");
          this.down_progress.put(k, Integer.valueOf(100));
          this.down_status.put(k, Integer.valueOf(3));
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("FunCallJsPlugin", 2, "onDone, id=" + k + ",srcType=" + i + ",resourceType=" + j + ",result=" + m);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("onStart".equals(str))
      {
        k = paramBundle.getInt("id");
        this.down_progress.put(k, Integer.valueOf(0));
        this.down_status.put(k, Integer.valueOf(1));
        if (QLog.isColorLevel())
        {
          QLog.d("FunCallJsPlugin", 2, "onStart, id=" + k + ",srcType=" + i + ",resourceType=" + j);
          return;
          label389:
          if (j == VipFunCallManager.d)
          {
            str = paramBundle.getString("status");
            if ("onProgress".equals(str))
            {
              k = paramBundle.getInt("id");
              this.down_bgprogress.put(k, Integer.valueOf(paramBundle.getInt("progress")));
              this.down_bgstatus.put(k, Integer.valueOf(2));
              if (QLog.isColorLevel()) {
                QLog.d("FunCallJsPlugin", 2, "onProgress, id=" + k + ",srcType=" + i + ",resourceType=" + j + ",progress=" + this.down_progress.get(k));
              }
            }
            else if ("onDone".equals(str))
            {
              k = paramBundle.getInt("id");
              m = paramBundle.getInt("result");
              this.down_bgprogress.put(k, Integer.valueOf(100));
              this.down_bgstatus.put(k, Integer.valueOf(3));
              if (QLog.isColorLevel()) {
                QLog.d("FunCallJsPlugin", 2, "onDone, id=" + k + ",srcType=" + i + ",resourceType=" + j + ",result=" + m);
              }
            }
            else if ("onStart".equals(str))
            {
              k = paramBundle.getInt("id");
              this.down_bgprogress.put(k, Integer.valueOf(0));
              this.down_bgstatus.put(k, Integer.valueOf(1));
              if (QLog.isColorLevel())
              {
                QLog.d("FunCallJsPlugin", 2, "onStart, id=" + k + ",srcType=" + i + ",resourceType=" + j);
                return;
                label746:
                if (i == 7)
                {
                  i = paramBundle.getInt("isSuccess");
                  if (QLog.isColorLevel()) {
                    QLog.d("FunCallJsPlugin", 2, "setMedia, result=" + i);
                  }
                  paramBundle = new JSONObject();
                  if (i == 0) {}
                  for (;;)
                  {
                    try
                    {
                      paramBundle.put("code", i);
                      paramBundle.put("errorMessage", "sucess");
                      callJs(this.SetFuncallCallBack, new String[] { paramBundle.toString() });
                      return;
                    }
                    catch (JSONException paramBundle)
                    {
                      paramBundle.printStackTrace();
                      return;
                    }
                    paramBundle.put("code", i);
                    paramBundle.put("errorMessage", "set funcall err");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin
 * JD-Core Version:    0.7.0.1
 */