package com.tencent.mobileqq.activity.specialcare;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import haj;
import hbo;
import hbp;
import hbq;
import hbr;
import hbs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VipSpecialSoundWebViewPlugin
  extends VasWebviewJsPlugin
{
  public static final String a = "QVipSpecialSoundWebViewPlugin";
  private static final String b = "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json";
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = null;
  private MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = MediaPlayerHelper.a();
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN ERROR";
    case -1: 
      return "ERR_NO_NETWORK";
    case -2: 
      return "ERR_REQUEST_TIMEOUT";
    case -3: 
      return "ERR_ANDROID_ERROR";
    case 0: 
      return "SUCC";
    case 10001: 
      return "ERR_METHOD_NOT_SUPPORT";
    case 10002: 
      return "ERR_INVALID_ARGUMENT";
    case 10003: 
      return "ERR_SET_REMIND_ERROR";
    case 10004: 
      return "ERR_CLEAR_REMIND_ERROR";
    case 10005: 
      return "ERR_GET_CLUBINFO_ERROR";
    case 10010: 
      return "ERR_SET_QUOTA_LIMIT";
    case 11001: 
      return "ERR_PROTO_SERIAL_ERR";
    case 20001: 
      return "ERR_OIDB_INIT_ERR";
    case 20002: 
      return "ERR_OIDB_PB_SR_ERR";
    case 20003: 
      return "E_OIDB_PB_PACK_ERR";
    }
    return "E_OIDB_PB_UNPACK_ERR";
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QVipSpecialSoundWebViewPlugin", 2, paramString);
    }
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    a("-->onSetRingForFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", a(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      a("-->set ring failed, error:" + a(i));
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", a(i));
    }
    for (;;)
    {
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      a("-->set ring ok!");
      paramBundle.put("code", 0);
    }
  }
  
  private void a(String paramString, List paramList)
  {
    a("-->responseRingsList,callback:" + paramString + ",list:" + paramList);
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        if ((paramList == null) || (paramList.size() <= 0))
        {
          a("-->responseRingsList:list is empety");
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "rings not found");
          callJs(paramString, new String[] { localJSONObject1.toString() });
          return;
        }
        localJSONObject2 = new JSONObject();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        haj localhaj = (haj)paramList.next();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("id", localhaj.jdField_a_of_type_Int);
        localJSONObject3.put("soundName", localhaj.jdField_a_of_type_JavaLangString);
        localJSONObject3.put("type", localhaj.jdField_b_of_type_Int);
        localJSONObject3.put("soundVersion", localhaj.jdField_b_of_type_JavaLangString);
        localJSONObject3.put("soundUrl", localhaj.jdField_c_of_type_JavaLangString);
        localJSONObject3.put("whiteList", localhaj.jdField_d_of_type_JavaLangString);
        localJSONObject3.put("isShow", localhaj.jdField_c_of_type_Int);
        localJSONObject3.put("backgroundUrl", localhaj.jdField_e_of_type_JavaLangString);
        localJSONObject3.put("access", localhaj.jdField_f_of_type_JavaLangString);
        localJSONObject3.put("useNum", localhaj.jdField_d_of_type_Int);
        localJSONObject3.put("classify", localhaj.jdField_e_of_type_Int);
        localJSONObject3.put("classifyName", localhaj.g);
        localJSONObject3.put("isLimitFree", localhaj.jdField_f_of_type_Int);
        localJSONObject3.put("limitFreeStart", localhaj.h);
        localJSONObject3.put("limitFreeEnd", localhaj.i);
        localJSONObject3.put("bake1", localhaj.j);
        localJSONObject3.put("bake2", localhaj.k);
        localJSONObject3.put("bake3", localhaj.l);
        if ((localhaj.jdField_c_of_type_JavaLangString != null) && (!TextUtils.isEmpty(localhaj.jdField_c_of_type_JavaLangString)) && (e(localhaj.jdField_c_of_type_JavaLangString)))
        {
          localJSONObject3.put("isDownload", true);
          localJSONObject2.put(String.valueOf(localhaj.jdField_a_of_type_Int), localJSONObject3);
        }
        else
        {
          localJSONObject3.put("isDownload", false);
        }
      }
      catch (JSONException paramList)
      {
        a("-->json exception:" + paramList.toString() + ".Reload json...");
        b(paramString);
        return;
      }
    }
    paramList = new JSONObject();
    paramList.put("rings", localJSONObject2);
    localJSONObject1.put("code", 0);
    localJSONObject1.put("data", paramList);
    callJs(paramString, new String[] { localJSONObject1.toString() });
  }
  
  private boolean a(int paramInt, String paramString1, String paramString2)
  {
    a("-->handleSetRing,id=" + paramInt + ",uin=" + paramString1);
    if (!NetworkUtil.e(this.mRuntime.a().getApplicationContext()))
    {
      a("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", a(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    localBundle.putString("uin", paramString1);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("sepcial_care_delete_ring", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private boolean a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    a("-->handleSetRing,id=" + paramInt + ",uin=" + paramString1);
    if (paramBoolean)
    {
      this.mRuntime.a().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit().putInt("special_care_id_cache" + paramString1, paramInt).commit();
      paramString1 = new JSONObject();
      paramString1.put("code", 0);
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    if (!NetworkUtil.e(this.mRuntime.a().getApplicationContext()))
    {
      a("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", a(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    localBundle.putString("uin", paramString1);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("special_care_set_ring", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private boolean a(String paramString)
  {
    a("-->handleGetRingsInfo,callback=" + paramString);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new hbo(this, paramString));
    }
    for (;;)
    {
      return true;
      String str = "key_special_sound_list" + this.mRuntime.a().a();
      a(paramString, (List)QvipSpecialSoundManager.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    a("-->handleCancelDownload,url:" + paramString1 + ",callback:" + paramString2);
    paramString1 = new JSONObject();
    paramString1.put("code", 0);
    callJs(paramString2, new String[] { paramString1.toString() });
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    a("-->handleDownload,url:" + paramString1 + ",callback:" + paramString2 + ",completeCallback:" + paramString3);
    Object localObject = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), paramString1);
    if (((File)localObject).exists())
    {
      a("-->file already exists");
      paramString1 = new JSONObject();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("status", 0);
      paramString1.put("code", 0);
      paramString1.put("data", localObject);
      callJs(paramString3, new String[] { paramString1.toString() });
    }
    for (;;)
    {
      paramString1 = new JSONObject();
      paramString1.put("code", 0);
      callJs(paramString2, new String[] { paramString1.toString() });
      a("-->startDownload return");
      return true;
      hbs localhbs = new hbs(this);
      localhbs.jdField_a_of_type_JavaLangString = paramString3;
      localhbs.jdField_b_of_type_JavaLangString = paramString1;
      paramString3 = new hbq(this, localhbs, paramString3);
      localhbs.start();
      paramString1 = new DownloadTask(paramString1, (File)localObject);
      paramString1.a = 1;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString1, paramString3, null);
    }
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a("-->handleGetRing, uin=" + paramString1 + ",callback=" + paramString2);
    if (paramBoolean)
    {
      int i = this.mRuntime.a().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt("special_care_id_cache" + paramString1, 1);
      paramString1 = new JSONObject();
      paramString1.put("id", i);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", 0);
      ((JSONObject)localObject).put("data", paramString1);
      callJs(paramString2, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", paramString1);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("special_care_get_ring", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  private void b(String paramString)
  {
    File localFile = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json");
    if ((localFile.exists()) && (!localFile.delete())) {
      a("-->can't delete file!");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new hbp(this, paramString));
  }
  
  private void b(String paramString, Bundle paramBundle)
  {
    a("-->handleGetRingResponse, callback=" + paramString + ",bundle=" + paramBundle);
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("id");
    paramBundle = new JSONObject();
    paramBundle.put("id", i);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("code", 0);
    localJSONObject.put("data", paramBundle);
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private boolean b(String paramString)
  {
    a("-->handleGetFriendCount,callback=" + paramString);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("special_care_get_friend_count", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    a("-->handleIsSpecialCareFriend,friendUin:" + paramString1 + ",callback:" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("friendUin", paramString1);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("is_special_friend", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private boolean b(String paramString1, String paramString2, String paramString3)
  {
    a("-->handlePlay,url=" + paramString1 + ",finishCallback=" + paramString2 + ",callback=" + paramString3);
    JSONObject localJSONObject = new JSONObject();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d()) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.b();; bool1 = true)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(new hbr(this, paramString1, paramString2));
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(this.mRuntime.a().getApplicationContext(), paramString1);
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
      a("-->setDataSourceRes:" + bool2 + ",startRes:" + bool3 + ",stopRes:" + bool1);
      if ((!bool2) || (!bool3) || (!bool1))
      {
        a("-->play failed");
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "can't play");
      }
      for (;;)
      {
        callJs(paramString3, new String[] { localJSONObject.toString() });
        return true;
        localJSONObject.put("code", 0);
      }
    }
  }
  
  private void c(String paramString, Bundle paramBundle)
  {
    a("-->handleGetFriendCountResponse,callback=" + paramString + ",bundle=" + paramBundle);
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null)
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "id error");
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
      int i = paramBundle.getInt("count");
      localJSONObject.put("code", 0);
      paramBundle = new JSONObject();
      paramBundle.put("nums", i);
      localJSONObject.put("data", paramBundle);
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool;
    JSONObject localJSONObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())
    {
      bool = true;
      a("-->handleStopPlay,callback=" + paramString + ",res=" + bool);
      localJSONObject = new JSONObject();
      if (bool) {
        break label105;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "stop error");
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return true;
      bool = this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.b();
      break;
      label105:
      localJSONObject.put("code", 0);
    }
  }
  
  private void d(String paramString, Bundle paramBundle)
  {
    a("-->onDeleteSpecialSoundResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", a(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      a("-->delete ring failed");
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", a(i));
    }
    for (;;)
    {
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      a("-->delete ring ok!");
      paramBundle.put("code", 0);
    }
  }
  
  private boolean d(String paramString)
  {
    a("-->handleGetSpecialSoundSwitchState,callback:" + paramString);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("special_care_get_switch_state", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private void e(String paramString, Bundle paramBundle)
  {
    a("-->onSpecialSoundSwitchState,callback=" + paramString);
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "get state failed");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("state");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    JSONObject localJSONObject = new JSONObject();
    if (i == 1) {}
    for (i = 1;; i = 0)
    {
      localJSONObject.put("canPlay", i);
      paramBundle.put("data", localJSONObject);
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
  }
  
  private boolean e(String paramString)
  {
    paramString = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), paramString);
    if (paramString != null) {
      return paramString.exists();
    }
    return false;
  }
  
  private void f(String paramString, Bundle paramBundle)
  {
    a("-->isSpecialFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("isSpecialFriend");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("isSpecialFriend", i);
    paramBundle.put("data", localJSONObject);
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("specialRing"))) {
      a("-->handleJsRequest returned, pkgName=" + paramString2);
    }
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1 == null) {
          continue;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        try
        {
          paramJsBridgeListener = paramString1.getString("callback");
        }
        catch (Exception paramJsBridgeListener)
        {
          try
          {
            for (;;)
            {
              a("-->handleJsRequest:method:" + paramString3 + ",callback" + paramJsBridgeListener + ", json:" + paramString1.toString());
              if (!paramString3.equals("getRingsInfo")) {
                break;
              }
              bool1 = a(paramJsBridgeListener);
              return bool1;
              paramJsBridgeListener = paramJsBridgeListener;
              a("-->failed to parse json str,json=" + null);
              paramJsBridgeListener.printStackTrace();
              paramString1 = null;
            }
            if (paramString3.equals("cancelDownload"))
            {
              a(paramString1.getString("url"), paramJsBridgeListener);
            }
            else
            {
              if (paramString3.equals("downloadRing")) {
                return a(paramString1.getString("url"), paramJsBridgeListener, paramString1.getString("onDownloadComplete"));
              }
              if (paramString3.equals("queryDownloadInfo")) {
                return true;
              }
              boolean bool3 = paramString3.equals("setDefaultRing");
              if (!bool3) {}
            }
            label317:
            return true;
          }
          catch (Exception paramString1)
          {
            try
            {
              bool1 = paramString1.getBoolean("lazy");
              return a(paramString1.getInt("id"), paramString1.getString("uin"), bool1, paramJsBridgeListener);
              bool2 = paramString3.equals("getDefaultRing");
              if (bool2) {}
              try
              {
                bool2 = paramString1.getBoolean("lazy");
                bool1 = bool2;
              }
              catch (Exception paramString2)
              {
                break label317;
              }
              return a(paramString1.getString("uin"), paramJsBridgeListener, bool1);
              if (paramString3.equals("play")) {
                return b(paramString1.getString("url"), paramString1.getString("finishPlay"), paramJsBridgeListener);
              }
              if (paramString3.equals("stop")) {
                return c(paramJsBridgeListener);
              }
              if (paramString3.equals("getSpecialFriendsNum")) {
                return b(paramJsBridgeListener);
              }
              if (paramString3.equals("deleteSpecialSound")) {
                return a(paramString1.getInt("id"), paramString1.getString("uin"), paramJsBridgeListener);
              }
              if (paramString3.equals("canPlaySpecialSound")) {
                return d(paramJsBridgeListener);
              }
              if (paramString3.equals("isSpecialCareFriend"))
              {
                bool1 = b(paramString1.getString("friendUin"), paramJsBridgeListener);
                return bool1;
                paramString1 = paramString1;
                paramJsBridgeListener = null;
                for (;;)
                {
                  a("-->handleJsRequest exception:" + paramString1.toString());
                  try
                  {
                    paramString1 = new JSONObject();
                    paramString1.put("code", -1);
                    paramString1.put("errorMessage", "exception");
                    callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  }
                  catch (Exception paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                  paramString1 = paramString1;
                }
              }
            }
            catch (Exception paramString2)
            {
              for (;;)
              {
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this.mRuntime.a().getApplicationContext(), this.mRuntime.a());
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str1;
      String str2;
      try
      {
        if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
          return;
        }
        str1 = paramBundle.getString("cmd");
        str2 = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        a("-->onResponse,callback=" + str2 + ",cmd=" + str1 + ",respbundle=" + paramBundle);
        if (str1 == null) {
          return;
        }
        if ("special_care_get_ring".equals(str1))
        {
          b(str2, paramBundle);
          return;
        }
        if ("special_care_get_friend_count".equals(str1))
        {
          c(str2, paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        a("-->exception in onResponse," + paramBundle.toString());
        paramBundle.printStackTrace();
        return;
      }
      if ("special_care_set_ring".equals(str1))
      {
        a(str2, paramBundle);
        return;
      }
      if ("sepcial_care_delete_ring".equals(str1))
      {
        d(str2, paramBundle);
        return;
      }
      if ("special_care_get_switch_state".equals(str1))
      {
        e(str2, paramBundle);
        return;
      }
      if ("is_special_friend".equals(str1)) {
        f(str2, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */