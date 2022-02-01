package com.tencent.mobileqq.vipav;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kvv;
import kvw;
import kvx;
import kvy;
import kvz;
import kwa;
import kwb;
import kwc;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipFunCallManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static int b;
  public static String b;
  public static int c;
  public static int d;
  public static int e = 1005012;
  public static int f = 1005011;
  public static int g = -3;
  public static int h = 1005016;
  public static int i = -5;
  public static int j = -6;
  public static int k = -7;
  public static int l = -8;
  public static int m = 17;
  public static int n = 0;
  public static int o = 1;
  public static int p = 2;
  public Handler a;
  MediaController jdField_a_of_type_AndroidWidgetMediaController;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new kvv(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  DownloadListener b;
  DownloadListener c;
  DownloadListener d;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipFunCallManager.class.getSimpleName();
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_b_of_type_JavaLangString = "Vip_FunCall";
  }
  
  public VipFunCallManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new kvw(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
    this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener = new kvx(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
    this.jdField_d_of_type_ComTencentMobileqqVipDownloadListener = new kvy(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
    paramQQAppInterface = new File(VipFunCallConstants.jdField_a_of_type_JavaLangString + File.separator);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "<<need to copy a default config file.");
      }
      paramQQAppInterface = localInputStream;
    }
    for (;;)
    {
      try
      {
        localInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getAssets().open("funcall/vipfuncall_config.json");
        paramQQAppInterface = localInputStream;
        localObject = localInputStream;
        FileUtils.a(VipFunCallConstants.jdField_a_of_type_JavaLangString + File.separator, new StringBuffer("config.json"), localInputStream);
      }
      catch (IOException localIOException)
      {
        localObject = paramQQAppInterface;
        localIOException.printStackTrace();
        if (paramQQAppInterface == null) {
          continue;
        }
        try
        {
          paramQQAppInterface.close();
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject == null) {
          break label272;
        }
      }
      try
      {
        localInputStream.close();
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label272:
      throw paramQQAppInterface;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Build.MODEL=[" + Build.MODEL + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
    }
    Object localObject = a();
    if (localObject == null) {
      return jdField_a_of_type_Int;
    }
    try
    {
      localObject = ((JSONObject)localObject).getString("apiforimage").split(",");
      int i1 = 0;
      while (i1 < localObject.length)
      {
        if ((localObject[i1] != null) && ((localObject[i1].equalsIgnoreCase(Build.VERSION.SDK_INT + "")) || (localObject[i1].equalsIgnoreCase(Build.MODEL))))
        {
          i1 = jdField_b_of_type_Int;
          return i1;
        }
        i1 += 1;
      }
      return jdField_a_of_type_Int;
    }
    catch (Exception localException) {}
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i1 = new JSONObject(paramString).optInt("id");
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static BitmapDrawable a(String paramString)
  {
    paramString = BitmapManager.a(paramString);
    if (paramString != null) {
      return new BitmapDrawable(paramString);
    }
    return null;
  }
  
  public static VipFullScreenVideoView a(Activity paramActivity, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramRelativeLayout == null)) {}
    View localView;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return null;
      localView = paramActivity.getLayoutInflater().inflate(2130904513, null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
    } while (paramActivity.isFinishing());
    paramRelativeLayout.addView(localView, 0, localLayoutParams);
    return (VipFullScreenVideoView)localView.findViewById(2131302397);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a();
    if (localObject1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject1 = ((JSONObject)localObject1).getJSONArray("items");
        int i1 = 0;
        while (i1 < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
          if ((localObject2 != null) && (((JSONObject)localObject2).getInt("id") == paramInt1))
          {
            localObject1 = "";
            if (paramInt2 == jdField_a_of_type_Int) {
              localObject1 = ((JSONObject)localObject2).getString("media_url");
            }
            for (;;)
            {
              localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
              localObject2 = VipFunCallConstants.jdField_a_of_type_JavaLangString + File.separator + paramInt1 + File.separator;
              File localFile = new File((String)localObject2);
              if (!localFile.exists()) {
                localFile.mkdirs();
              }
              return (String)localObject2 + (String)localObject1;
              if (paramInt2 == jdField_b_of_type_Int) {
                localObject1 = ((JSONObject)localObject2).getString("image_url");
              } else if (paramInt2 == jdField_c_of_type_Int) {
                localObject1 = ((JSONObject)localObject2).getString("thumb_nail_url");
              } else if (paramInt2 == jdField_d_of_type_Int) {
                localObject1 = ((JSONObject)localObject2).getString("fuzz_image_url");
              }
            }
          }
          i1 += 1;
        }
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static JSONObject a()
  {
    Object localObject = new File(VipFunCallConstants.jdField_b_of_type_JavaLangString);
    try
    {
      localObject = FileUtils.a((File)localObject);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static boolean a()
  {
    return new File(VipFunCallConstants.jdField_b_of_type_JavaLangString).exists();
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    return (str != null) && (new File(str).exists());
  }
  
  public static boolean a(Context paramContext, VideoView paramVideoView, String paramString, int paramInt1, VipFunCallMediaListener paramVipFunCallMediaListener, int paramInt2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramVideoView == null) || (paramString == null)) {
      return false;
    }
    paramContext = new File(paramString);
    if ((paramContext.exists()) && (!paramVideoView.isPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "playing");
      }
      if (paramInt1 == jdField_a_of_type_Int)
      {
        paramVideoView.setOnTouchListener(new kvz());
        paramVideoView.setVideoPath(paramContext.getAbsolutePath());
        paramVideoView.requestFocus();
        paramVideoView.setVisibility(0);
        paramVideoView.setOnPreparedListener(new kwa(paramVipFunCallMediaListener));
        paramVideoView.setOnCompletionListener(new kwb(paramVideoView));
        paramVideoView.setOnErrorListener(new kwc(paramInt2, paramVipFunCallMediaListener, paramVideoView, paramBoolean));
        return true;
      }
      if (paramInt1 == jdField_b_of_type_Int)
      {
        paramContext = a(paramString);
        if (paramContext != null)
        {
          paramVideoView = (RelativeLayout)paramVideoView.getParent();
          if (paramVideoView != null)
          {
            if (paramVipFunCallMediaListener != null) {
              paramVipFunCallMediaListener.a();
            }
            paramVideoView.setBackgroundDrawable(paramContext);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static int b()
  {
    return a(BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", ""));
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    Object localObject = a();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject = ((JSONObject)localObject).getJSONArray("items");
        int i1 = 0;
        while (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
          if ((localJSONObject != null) && (localJSONObject.getInt("id") == paramInt1))
          {
            if (paramInt2 == jdField_a_of_type_Int) {
              return localJSONObject.getString("media_url");
            }
            if (paramInt2 == jdField_b_of_type_Int) {
              return localJSONObject.getString("image_url");
            }
            if (paramInt2 == jdField_c_of_type_Int) {
              return localJSONObject.getString("thumb_nail_url");
            }
            if (paramInt2 == jdField_d_of_type_Int)
            {
              localObject = localJSONObject.getString("fuzz_image_url");
              return localObject;
            }
          }
          i1 += 1;
        }
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a(int paramInt)
  {
    Object localObject = a();
    if (localObject == null) {
      return i;
    }
    if (paramInt == 0) {
      return 0;
    }
    int i2;
    label205:
    label213:
    do
    {
      int i3;
      do
      {
        try
        {
          localObject = ((JSONObject)localObject).getJSONArray("items");
          int i1 = 0;
          while (i1 < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
            if ((localJSONObject != null) && (localJSONObject.getInt("id") == paramInt))
            {
              i2 = localJSONObject.getInt("vip_type");
              long l1 = localJSONObject.getLong("trialstartday");
              long l2 = localJSONObject.getLong("trialendday");
              i3 = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).f();
              long l3 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
              if ((l3 < l1) || (l3 > l2)) {
                break label205;
              }
              i2 = n;
              break label205;
              if ((i3 != 1) || (o < i2)) {
                break label213;
              }
              return 0;
              if (i2 == o) {
                return e;
              }
              if (i2 == p)
              {
                paramInt = f;
                return paramInt;
              }
            }
            i1 += 1;
          }
          return g;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return i;
        }
      } while (i3 != 3);
      return 0;
    } while (i2 != 0);
    return 0;
  }
  
  public String a()
  {
    return BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_conf_url", "");
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, ">>startDownload, id=" + paramInt1);
    }
    Object localObject1;
    if (paramInt2 == jdField_a_of_type_Int)
    {
      localObject1 = a(paramInt1, jdField_b_of_type_Int);
      if (localObject1 != null) {}
    }
    do
    {
      do
      {
        return;
        localObject1 = new File((String)localObject1);
        localObject1 = new DownloadTask(b(paramInt1, jdField_b_of_type_Int), (File)localObject1);
        ((DownloadTask)localObject1).a = 1;
        ((DownloadTask)localObject1).e = 5242880L;
        ((DownloadTask)localObject1).d = jdField_b_of_type_JavaLangString;
        ((DownloadTask)localObject1).b = true;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("id", paramInt1);
        ((Bundle)localObject2).putInt("resourceType", jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, null, (Bundle)localObject2);
        localObject1 = a(paramInt1, paramInt2);
      } while (localObject1 == null);
      localObject2 = new File((String)localObject1 + ".tmp");
      localObject1 = b(paramInt1, paramInt2);
    } while ((localObject1 == null) || (localObject2 == null));
    Object localObject2 = new DownloadTask((String)localObject1, (File)localObject2);
    ((DownloadTask)localObject2).a = 1;
    ((DownloadTask)localObject2).e = 5242880L;
    ((DownloadTask)localObject2).d = jdField_b_of_type_JavaLangString;
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt1);
    localBundle.putBoolean("isIPC", paramBoolean);
    localBundle.putInt("resourceType", paramInt2);
    if (paramBoolean) {
      localBundle.putInt("srcType", paramInt3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject2, this.jdField_d_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "<<startDownload, id=" + paramInt1 + ",url=" + (String)localObject1);
      return;
      ((DownloadTask)localObject2).b = true;
    }
  }
  
  public void a(int paramInt, Handler paramHandler)
  {
    Object localObject1 = a(paramInt, jdField_c_of_type_Int);
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        localObject1 = new File((String)localObject1 + ".tmp");
        localObject2 = b(paramInt, jdField_c_of_type_Int);
      } while ((localObject2 == null) || (localObject1 == null));
      localObject1 = new DownloadTask((String)localObject2, (File)localObject1);
      ((DownloadTask)localObject1).a = 1;
      ((DownloadTask)localObject1).e = 5242880L;
      ((DownloadTask)localObject1).b = true;
      ((DownloadTask)localObject1).d = "Vip_FunCall";
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("id", paramInt);
      this.jdField_a_of_type_AndroidOsHandler = paramHandler;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("setFunCallthumbnail", 2, "<<startDownload conf, id=" + paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new File(VipFunCallConstants.jdField_b_of_type_JavaLangString + ".tmp");
    String str = a();
    if ((str == null) || (localObject == null)) {}
    do
    {
      return;
      localObject = new DownloadTask(str, (File)localObject);
      ((DownloadTask)localObject).a = 1;
      ((DownloadTask)localObject).e = 5242880L;
      ((DownloadTask)localObject).b = true;
      ((DownloadTask)localObject).d = jdField_b_of_type_JavaLangString;
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      localBundle.putString("version", paramString);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "<<startDownload conf, id=" + paramInt + ",url=" + str);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, ">>startDownload, id=" + paramInt1);
    }
    String str = a(paramInt1, jdField_d_of_type_Int);
    if (str == null) {}
    do
    {
      return;
      localObject = new File(str + ".tmp");
      str = b(paramInt1, jdField_d_of_type_Int);
    } while ((str == null) || (localObject == null));
    Object localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).a = 1;
    ((DownloadTask)localObject).e = 5242880L;
    ((DownloadTask)localObject).d = jdField_b_of_type_JavaLangString;
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt1);
    localBundle.putBoolean("isIPC", paramBoolean);
    if (paramBoolean) {
      localBundle.putInt("srcType", paramInt2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "<<startDownload, id=" + paramInt1 + ",url=" + str);
      return;
      ((DownloadTask)localObject).b = true;
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4);
    Object localObject = localSharedPreferences.getString("key_fun_call_buff", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "{\"id\":" + paramInt + "}";
    }
    for (;;)
    {
      return localSharedPreferences.edit().putString("key_fun_call_buff", (String)localObject).commit();
      try
      {
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("id", paramInt);
        localObject = ((JSONObject)localObject).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        String str = "{\"id\":" + paramInt + "}";
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManager
 * JD-Core Version:    0.7.0.1
 */