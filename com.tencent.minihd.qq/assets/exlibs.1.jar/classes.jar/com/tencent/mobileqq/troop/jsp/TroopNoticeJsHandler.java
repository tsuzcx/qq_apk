package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import klb;
import klc;
import kld;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNoticeJsHandler
  extends WebViewPlugin
{
  public static final byte a = 100;
  public static final String a = "troopNotice";
  public static final String b = "showPicture";
  public static final String c = "sendPicture";
  public static final String d = "sendBatchPicture";
  protected String e;
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = 5381;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return Integer.toString(0x7FFFFFFF & j);
  }
  
  protected void a(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      this.e = ((JSONObject)localObject1).optString("callback");
      Object localObject2 = ((JSONObject)localObject1).optJSONArray("imageIDs");
      int j = ((JSONObject)localObject1).optInt("index");
      paramString = ((JSONObject)localObject1).optString("srcID");
      boolean bool = ((JSONObject)localObject1).optBoolean("isNotShowIndex", true);
      if (localObject2 != null)
      {
        if (((JSONArray)localObject2).length() == 0) {
          return;
        }
        if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null))
        {
          Object localObject3 = this.mRuntime.a();
          if (localObject3 != null)
          {
            localObject1 = new ArrayList();
            int k = ((JSONArray)localObject2).length();
            while (i < k)
            {
              ((ArrayList)localObject1).add(((JSONArray)localObject2).get(i).toString());
              i += 1;
            }
            localObject2 = new Intent((Context)localObject3, TroopAvatarWallPreviewActivity.class);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("index", j);
            ((Bundle)localObject3).putStringArrayList("seqNum", (ArrayList)localObject1);
            ((Bundle)localObject3).putBoolean("IS_EDIT", false);
            ((Bundle)localObject3).putBoolean("is_use_path", true);
            ((Bundle)localObject3).putBoolean("is_show_action", true);
            ((Bundle)localObject3).putBoolean("is_not_show_index", bool);
            if (!TextUtils.isEmpty(paramString)) {
              ((Bundle)localObject3).putString("src_id", paramString);
            }
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            startActivityForResult((Intent)localObject2, (byte)100);
            return;
          }
        }
      }
    }
    catch (JSONException paramString) {}
  }
  
  protected void b(String paramString)
  {
    new Thread(new klb(this, paramString)).start();
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject3 = new JSONObject(paramString);
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {
        return;
      }
      Object localObject2 = this.mRuntime.a();
      if (localObject2 != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null)
        {
          String str1 = ((JSONObject)localObject3).optString("callback");
          String str2 = ((JSONObject)localObject3).optString("cgiURL");
          paramString = ((JSONObject)localObject3).optString("imageID");
          Object localObject1 = ((JSONObject)localObject3).optString("headFields");
          Object localObject4 = ((JSONObject)localObject3).optString("postParams");
          localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
          int i = ((BitmapFactory.Options)localObject3).outHeight;
          int j = ((BitmapFactory.Options)localObject3).outWidth;
          int k = ((BitmapFactory.Options)localObject3).outHeight * 640 / ((BitmapFactory.Options)localObject3).outWidth;
          ((BitmapFactory.Options)localObject3).outWidth = 640;
          ((BitmapFactory.Options)localObject3).outHeight = k;
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inInputShareable = true;
          ((BitmapFactory.Options)localObject3).inSampleSize = (((BitmapFactory.Options)localObject3).outWidth / 640);
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.ARGB_4444;
          paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject3);
          if ((i < 640) && (j < 640)) {}
          Iterator localIterator;
          String str3;
          for (;;)
          {
            localObject5 = AppConstants.aS + "tempNotice.png";
            ImageUtil.a(paramString, new File((String)localObject5));
            paramString.recycle();
            paramString = new HashMap();
            localObject3 = LoginHelper.a((AppInterface)localObject2);
            paramString.put("bkn", a((String)localObject3));
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break;
            }
            localObject4 = new JSONObject((String)localObject4);
            localIterator = ((JSONObject)localObject4).keys();
            while (localIterator.hasNext())
            {
              str3 = (String)localIterator.next();
              paramString.put(str3, ((JSONObject)localObject4).get(str3).toString());
            }
            paramString = ImageUtil.b(paramString, 640);
          }
          localObject4 = new HashMap();
          ((Map)localObject4).put("pic_up", localObject5);
          Object localObject5 = ((AppInterface)localObject2).getAccount();
          j = ((String)localObject5).length();
          localObject2 = new StringBuffer("o");
          i = 0;
          while (i < 10 - j)
          {
            ((StringBuffer)localObject2).append("0");
            i += 1;
          }
          ((StringBuffer)localObject2).append((String)localObject5);
          localObject5 = new HashMap();
          ((Map)localObject5).put("Referer", new URL(str2).getRef());
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            localIterator = ((JSONObject)localObject1).keys();
            while (localIterator.hasNext())
            {
              str3 = (String)localIterator.next();
              ((Map)localObject5).put(str3, ((JSONObject)localObject1).get(str3).toString());
            }
          }
          localActivity.runOnUiThread(new klc(this, localCustomWebView, str1, HttpUtil.a(str2, ((StringBuffer)localObject2).toString(), (String)localObject3, paramString, (Map)localObject4, (Map)localObject5)));
          return;
        }
      }
    }
    catch (IOException paramString) {}catch (InterruptedException paramString) {}catch (JSONException paramString) {}
  }
  
  protected void d(String paramString)
  {
    new Thread(new kld(this, paramString)).start();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if ((!"showPicture".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label36;
      }
      a(paramVarArgs[0]);
    }
    label36:
    do
    {
      return false;
      if (("sendPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        b(paramVarArgs[0]);
        return false;
      }
    } while ((!"sendBatchPicture".equals(paramString3)) || (paramVarArgs.length != 1));
    d(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    CustomWebView localCustomWebView;
    if (paramByte == 100)
    {
      localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra("DeletedList")));
      paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    localCustomWebView.loadUrl("javascript: " + this.e + "([])");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler
 * JD-Core Version:    0.7.0.1
 */