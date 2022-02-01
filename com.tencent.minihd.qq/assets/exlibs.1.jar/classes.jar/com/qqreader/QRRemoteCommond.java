package com.qqreader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QRRemoteCommond
  extends RemoteCommand
{
  public static final int a = 1;
  public static final String a = "qqreader_plugin_cmd";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  
  public QRRemoteCommond()
  {
    super("qqreader_plugin_cmd");
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Bundle localBundle = new Bundle();
    paramOnInvokeFinishLinstener = (PublicAccountDataManager)a().getManager(54);
    switch (paramBundle.getInt("CommondType"))
    {
    default: 
      return null;
    case 1: 
      if (paramBundle == null) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("uin"); paramOnInvokeFinishLinstener != null; paramBundle = null)
    {
      if (paramOnInvokeFinishLinstener.a(paramBundle) != null) {
        localBundle.putBoolean("get_publicaccountinfo", true);
      }
      for (;;)
      {
        return localBundle;
        localBundle.putBoolean("get_publicaccountinfo", false);
      }
      if (paramBundle != null) {
        paramBundle.getString("uin");
      }
      return localBundle;
      int i = paramBundle.getInt("sharetype");
      paramOnInvokeFinishLinstener = paramBundle.getString("url");
      Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("cover");
      Object localObject3 = paramBundle.getString("title");
      Object localObject1 = paramBundle.getString("detail");
      Object localObject2 = paramBundle.getString("imgUrl");
      switch (i)
      {
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          return localBundle;
          paramBundle = new Bundle();
          paramBundle.putString("title", (String)localObject3);
          paramBundle.putString("desc", (String)localObject1);
          paramBundle.putString("detail_url", paramOnInvokeFinishLinstener);
          paramOnInvokeFinishLinstener = new ArrayList(1);
          paramOnInvokeFinishLinstener.add(localObject2);
          paramBundle.putStringArrayList("image_url", paramOnInvokeFinishLinstener);
          QZoneShareManager.a(a(), a().getApplication().getApplicationContext(), paramBundle, null);
          continue;
          localObject2 = WXShareHelper.a();
          l = System.currentTimeMillis();
          if (TextUtils.isEmpty(paramBundle.getString("detail"))) {
            localObject1 = paramOnInvokeFinishLinstener;
          }
          ((WXShareHelper)localObject2).d(String.valueOf(l), (String)localObject3, localBitmap, (String)localObject1, paramOnInvokeFinishLinstener);
        }
      }
      localObject2 = WXShareHelper.a();
      long l = System.currentTimeMillis();
      localObject3 = new StringBuilder().append((String)localObject3).append(":");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (paramBundle = paramOnInvokeFinishLinstener;; paramBundle = (Bundle)localObject1)
      {
        localObject3 = paramBundle;
        paramBundle = (Bundle)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramBundle = paramOnInvokeFinishLinstener;
        }
        ((WXShareHelper)localObject2).c(String.valueOf(l), (String)localObject3, localBitmap, paramBundle, paramOnInvokeFinishLinstener);
        break;
      }
      if ((WXShareHelper.a().a()) && (WXShareHelper.a().b())) {
        localBundle.putBoolean("is_wx_supported", true);
      }
      for (;;)
      {
        return localBundle;
        localBundle.putBoolean("is_wx_supported", false);
      }
      paramBundle = paramBundle.getString("url");
      paramBundle = new Intent(a().getApplication().getApplicationContext(), QQBrowserActivity.class).putExtra("url", paramBundle);
      paramBundle.putExtra("uin", a().a());
      paramBundle.putExtra("vkey", a().d());
      paramBundle.setFlags(268435456);
      a().getApplication().getApplicationContext().startActivity(paramBundle);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRRemoteCommond
 * JD-Core Version:    0.7.0.1
 */