package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import jcx;
import jdb;
import jdc;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, OverScrollViewListener
{
  static final byte jdField_a_of_type_Byte = 3;
  public static final int a = 1001;
  public static final String a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  static final byte jdField_b_of_type_Byte = 4;
  public static final int b = 0;
  static final String jdField_b_of_type_JavaLangString = "name";
  static final byte jdField_c_of_type_Byte = 5;
  public static final int c = 1;
  static final String jdField_c_of_type_JavaLangString = "callback";
  static final byte jdField_d_of_type_Byte = 6;
  static final String jdField_d_of_type_JavaLangString = "callback_url";
  static final String jdField_e_of_type_JavaLangString = "mode";
  static final String jdField_f_of_type_JavaLangString = "exclude";
  static final String g = "com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE";
  static final String h = "ret";
  static final String i = "uin";
  static final String j = "errMsg";
  static final String k = "openids";
  static final String l = "types";
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jcx(this);
  private View jdField_a_of_type_AndroidViewView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private jdc jdField_a_of_type_Jdc;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  protected String m = null;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  
  static
  {
    jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  }
  
  public UiApiPlugin()
  {
    this.jdField_d_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.b = false;
    this.c = false;
    this.f = -1;
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      i1 = paramJSONObject.getInt(paramString);
      return i1;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int i1 = Color.parseColor(paramJSONObject.getString(paramString));
        return i1;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfString.length;
    if ((i2 == 0) || (i2 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int i1 = 0;
    if (i1 < i2)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i3;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[i1], 10));
          i3 = paramArrayOfInt[i1];
          if (i3 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            i1 += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i3 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i3 != 3000) {
            break label213;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label213:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new jdb(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(String paramString)
  {
    int i1 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        if (paramString.equals(this.n))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = ActionSheet.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label283;
        }
        int i3 = ((JSONArray)localObject2).length();
        i2 = i3;
        if (i1 < i3)
        {
          ((ActionSheet)localObject1).c(((JSONArray)localObject2).getString(i1));
          i1 += 1;
          continue;
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ActionSheet)localObject1).d((CharSequence)localObject2);
        }
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).a(this);
        ((ActionSheet)localObject1).setOnCancelListener(this);
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject1);
        this.o = localJSONObject.optString("onclick");
        this.jdField_e_of_type_Int = i2;
        this.n = paramString;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label283:
      int i2 = 0;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int i1;
    String str1;
    String str2;
    String str3;
    boolean bool;
    int i2;
    do
    {
      return;
      i1 = paramJSONObject.optInt("iconID");
      str1 = paramJSONObject.optString("title");
      str2 = paramJSONObject.optString("callback");
      str3 = paramJSONObject.optString("color");
      bool = paramJSONObject.optBoolean("hidden");
      i2 = paramJSONObject.optInt("cornerID");
    } while (!(localActivity instanceof QQBrowserActivity));
    ((QQBrowserActivity)localActivity).a(str2, str1, str3, bool, i1, i2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  private void b(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    while (this.mRuntime.a() == null) {
      return;
    }
    label450:
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        String str = ((JSONObject)localObject).optString("url");
        JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("options");
        if ((TextUtils.isEmpty(str)) || (localJSONObject == null) || (!localJSONObject.has("style"))) {
          break;
        }
        paramString = localActivity.getIntent().getExtras();
        int i1;
        if (paramString == null)
        {
          paramString = new Bundle();
          i1 = localJSONObject.optInt("style");
          if (!Boolean.valueOf(((JSONObject)localObject).optBoolean("is_native", true)).booleanValue()) {
            continue;
          }
          PluginJumpManager.getInstance().updateConfig(this.mRuntime.a().getAccount());
          PluginJumpManager.getInstance().loadConfig();
          if (PluginJumpManager.getInstance().openView((BaseActivity)localActivity, str, String.valueOf(i1))) {
            break;
          }
          continue;
          localObject = new Intent(localActivity, localActivity.getClass());
          ((Intent)localObject).putExtras(paramString);
          ((Intent)localObject).putExtra("url", str);
          ((Intent)localObject).setFlags(0);
          localActivity.startActivityForResult((Intent)localObject, 100);
        }
        switch (localJSONObject.optInt("animation"))
        {
        case 0: 
        case 1: 
          localActivity.overridePendingTransition(0, 0);
          return;
          paramString.remove("title");
          paramString.remove("leftViewText");
          paramString.remove("post_data");
          paramString.remove("options");
          if (paramString.containsKey("startOpenPageTime"))
          {
            paramString.putLong("startOpenPageTime", System.currentTimeMillis());
            break label450;
            paramString.putBoolean("hide_more_button", false);
            paramString.putBoolean("hide_operation_bar", true);
            continue;
            paramString.putBoolean("hide_more_button", true);
            paramString.putBoolean("hide_operation_bar", true);
            continue;
            paramString.putBoolean("hide_more_button", false);
            paramString.putBoolean("hide_operation_bar", false);
            paramString.putString("webStyle", "");
            continue;
            paramString.putBoolean("hide_more_button", true);
            paramString.putBoolean("hide_operation_bar", false);
            paramString.putString("webStyle", "");
          }
          break;
        case 2: 
          localActivity.overridePendingTransition(2130968746, 0);
          return;
          switch (i1)
          {
          }
          break;
        default: 
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "0", Integer.toString(paramInt) });
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  void a()
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {}
    ViewParent localViewParent;
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
      localViewParent = ((View)localObject).getParent();
    } while (!(localViewParent instanceof ViewGroup));
    if (!this.b)
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(localActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838126);
      this.jdField_a_of_type_ComTencentWidgetXListView.setFadingEdgeLength(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new FrameLayout.LayoutParams((FrameLayout.LayoutParams)((View)localObject).getLayoutParams()));
      ((ViewGroup)localViewParent).removeView((View)localObject);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -2, 0));
      this.jdField_a_of_type_Jdc = new jdc((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Jdc);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(localActivity).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      ((ViewGroup)localViewParent).addView(this.jdField_a_of_type_ComTencentWidgetXListView, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollDistance(2147483647);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      this.jdField_d_of_type_Boolean = true;
      dispatchJsEvent("qbrowserPullDown", null, null);
    }
    return true;
  }
  
  void b()
  {
    if (this.b)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetXListView.C();
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollDistance(0);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Boolean = false;
      callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
    }
    for (;;)
    {
      return false;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_Boolean = true;
        callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
      }
      else if (paramInt == 14)
      {
        this.m = null;
      }
      else if ((paramInt == 12) || (paramInt == 13))
      {
        if (!TextUtils.isEmpty(this.m))
        {
          callJs(this.m, new String[] { "" });
          return true;
        }
        if (paramInt == 12)
        {
          if (this.f == -1)
          {
            this.f = 0;
            paramString = this.mRuntime.a();
            if ((paramString instanceof QQBrowserActivity))
            {
              Object localObject = paramString.getIntent();
              if (((((QQBrowserActivity)paramString).j & 0x200000) == 0L) && (!((Intent)localObject).getBooleanExtra("show_right_close_button", false)))
              {
                localObject = (TextView)paramString.findViewById(2131297360);
                if ((localObject == null) || (((TextView)localObject).getVisibility() != 0) || (!paramString.getString(2131367454).equals(((TextView)localObject).getText()))) {
                  break label216;
                }
              }
            }
          }
          while (this.f == 0)
          {
            return false;
            label216:
            if ((((QQBrowserActivity)paramString).j & 0x4) == 0L) {
              this.f = 1;
            }
          }
          paramString = paramMap.get("target");
          if (!(paramString instanceof Integer)) {
            return false;
          }
          paramInt = ((Integer)paramString).intValue();
          if ((paramInt != 1) && (paramInt != 3)) {
            return false;
          }
          paramString = this.mRuntime.a();
          if (paramString != null)
          {
            paramInt = paramString.copyBackForwardList().getCurrentIndex();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "web history current index:" + paramInt);
            }
            if (paramInt > 1) {
              a(true);
            } else {
              a(false);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 728
    //   3: aload_3
    //   4: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +3222 -> 3229
    //   10: ldc_w 730
    //   13: aload 4
    //   15: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +130 -> 148
    //   21: aload 5
    //   23: arraylength
    //   24: ifle +124 -> 148
    //   27: aload_0
    //   28: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   31: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   34: astore_1
    //   35: new 131	org/json/JSONObject
    //   38: dup
    //   39: aload 5
    //   41: iconst_0
    //   42: aaload
    //   43: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc_w 732
    //   51: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_2
    //   56: ldc_w 733
    //   59: invokevirtual 378	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   62: tableswitch	default:+3174 -> 3236, 0:+22->84, 1:+52->114
    //   85: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +3148 -> 3236
    //   91: aload_1
    //   92: aload_3
    //   93: iconst_0
    //   94: invokestatic 738	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   97: aload_1
    //   98: invokevirtual 744	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   101: ldc_w 745
    //   104: invokevirtual 751	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   107: invokevirtual 754	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   110: pop
    //   111: goto +3125 -> 3236
    //   114: aload_3
    //   115: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +3118 -> 3236
    //   121: aload_1
    //   122: iconst_0
    //   123: aload_3
    //   124: iconst_0
    //   125: invokestatic 757	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   128: iconst_0
    //   129: invokevirtual 759	com/tencent/mobileqq/widget/QQToast:a	(I)Landroid/widget/Toast;
    //   132: astore_1
    //   133: aload_1
    //   134: bipush 23
    //   136: iconst_0
    //   137: iconst_0
    //   138: invokevirtual 764	android/widget/Toast:setGravity	(III)V
    //   141: aload_1
    //   142: invokevirtual 765	android/widget/Toast:show	()V
    //   145: goto +3091 -> 3236
    //   148: ldc_w 767
    //   151: aload 4
    //   153: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifeq +50 -> 206
    //   159: new 131	org/json/JSONObject
    //   162: dup
    //   163: aload 5
    //   165: iconst_0
    //   166: aaload
    //   167: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   170: ldc_w 732
    //   173: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore_1
    //   177: aload_1
    //   178: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +3055 -> 3236
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   189: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   192: aload_1
    //   193: invokestatic 772	com/tencent/mobileqq/maproam/Utils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   196: putfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   199: goto +3037 -> 3236
    //   202: astore_1
    //   203: goto +3033 -> 3236
    //   206: ldc_w 776
    //   209: aload 4
    //   211: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifeq +45 -> 259
    //   217: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   220: invokevirtual 778	android/content/Context:getPackageName	()Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: new 131	org/json/JSONObject
    //   228: dup
    //   229: aload 5
    //   231: iconst_0
    //   232: aaload
    //   233: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: ldc 31
    //   238: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: iconst_1
    //   242: anewarray 286	java/lang/String
    //   245: dup
    //   246: iconst_0
    //   247: aload_1
    //   248: aastore
    //   249: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   252: goto +2984 -> 3236
    //   255: astore_1
    //   256: goto +2980 -> 3236
    //   259: ldc_w 780
    //   262: aload 4
    //   264: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   267: ifeq +52 -> 319
    //   270: aload_0
    //   271: getfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   274: ifnull +2962 -> 3236
    //   277: aload_0
    //   278: getfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   281: invokevirtual 783	android/app/ProgressDialog:isShowing	()Z
    //   284: ifeq +2952 -> 3236
    //   287: aload_0
    //   288: getfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   291: invokevirtual 784	android/app/ProgressDialog:dismiss	()V
    //   294: aload_0
    //   295: aconst_null
    //   296: putfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   299: goto +2937 -> 3236
    //   302: astore_1
    //   303: aload_0
    //   304: aconst_null
    //   305: putfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   308: goto +2928 -> 3236
    //   311: astore_1
    //   312: aload_0
    //   313: aconst_null
    //   314: putfield 774	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   317: aload_1
    //   318: athrow
    //   319: ldc_w 786
    //   322: aload 4
    //   324: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +21 -> 348
    //   330: aload 5
    //   332: arraylength
    //   333: iconst_1
    //   334: if_icmpne +14 -> 348
    //   337: aload_0
    //   338: aload 5
    //   340: iconst_0
    //   341: aaload
    //   342: invokespecial 788	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   345: goto +2891 -> 3236
    //   348: ldc_w 790
    //   351: aload 4
    //   353: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +17 -> 373
    //   359: aload_1
    //   360: aload_0
    //   361: getfield 99	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Boolean	Z
    //   364: invokestatic 438	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   367: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   370: goto +2866 -> 3236
    //   373: ldc_w 797
    //   376: aload 4
    //   378: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   381: ifeq +49 -> 430
    //   384: aload 5
    //   386: arraylength
    //   387: iconst_1
    //   388: if_icmpne +42 -> 430
    //   391: aload_0
    //   392: new 131	org/json/JSONObject
    //   395: dup
    //   396: aload 5
    //   398: iconst_0
    //   399: aaload
    //   400: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   403: invokespecial 799	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   406: goto +2830 -> 3236
    //   409: astore_1
    //   410: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +2823 -> 3236
    //   416: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   419: iconst_2
    //   420: ldc_w 801
    //   423: aload_1
    //   424: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   427: goto +2809 -> 3236
    //   430: ldc_w 806
    //   433: aload 4
    //   435: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifeq +145 -> 583
    //   441: aload 5
    //   443: arraylength
    //   444: iconst_1
    //   445: if_icmpne +138 -> 583
    //   448: aload_0
    //   449: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   452: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   455: astore_1
    //   456: aload_1
    //   457: ifnull +2785 -> 3242
    //   460: aload_1
    //   461: invokevirtual 546	android/app/Activity:isFinishing	()Z
    //   464: ifeq +6 -> 470
    //   467: goto +2775 -> 3242
    //   470: new 131	org/json/JSONObject
    //   473: dup
    //   474: aload 5
    //   476: iconst_0
    //   477: aaload
    //   478: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   481: astore_2
    //   482: aload_2
    //   483: ldc_w 808
    //   486: invokevirtual 811	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   489: astore_3
    //   490: aload_3
    //   491: ifnull +51 -> 542
    //   494: aload_3
    //   495: ldc_w 309
    //   498: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   501: astore 4
    //   503: aload 4
    //   505: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   508: ifne +24 -> 532
    //   511: aload_1
    //   512: ldc_w 812
    //   515: invokevirtual 684	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   518: checkcast 686	android/widget/TextView
    //   521: astore_1
    //   522: aload_1
    //   523: ifnull +9 -> 532
    //   526: aload_1
    //   527: aload 4
    //   529: invokevirtual 815	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   532: aload_0
    //   533: aload_3
    //   534: ldc 31
    //   536: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   539: putfield 101	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   542: aload_2
    //   543: ldc_w 817
    //   546: invokevirtual 811	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   549: astore_1
    //   550: aload_1
    //   551: ifnull +2685 -> 3236
    //   554: aload_0
    //   555: aload_1
    //   556: invokespecial 799	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   559: goto +2677 -> 3236
    //   562: astore_1
    //   563: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +2670 -> 3236
    //   569: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   572: iconst_2
    //   573: ldc_w 819
    //   576: aload_1
    //   577: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   580: goto +2656 -> 3236
    //   583: ldc_w 821
    //   586: aload 4
    //   588: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   591: ifeq +21 -> 612
    //   594: aload 5
    //   596: arraylength
    //   597: iconst_1
    //   598: if_icmpne +14 -> 612
    //   601: aload_0
    //   602: aload 5
    //   604: iconst_0
    //   605: aaload
    //   606: invokespecial 823	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   609: goto +2627 -> 3236
    //   612: ldc_w 825
    //   615: aload 4
    //   617: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   620: ifeq +147 -> 767
    //   623: aload 5
    //   625: arraylength
    //   626: iconst_1
    //   627: if_icmpne +140 -> 767
    //   630: new 131	org/json/JSONObject
    //   633: dup
    //   634: aload 5
    //   636: iconst_0
    //   637: aaload
    //   638: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   641: astore_2
    //   642: aload_2
    //   643: ldc 26
    //   645: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore_1
    //   649: aload_0
    //   650: aload_2
    //   651: ldc 31
    //   653: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   656: putfield 827	com/tencent/mobileqq/jsp/UiApiPlugin:p	Ljava/lang/String;
    //   659: aload_0
    //   660: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   663: invokevirtual 403	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   666: invokevirtual 832	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   669: astore_2
    //   670: new 154	android/content/Intent
    //   673: dup
    //   674: aload_0
    //   675: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   678: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   681: ldc_w 834
    //   684: invokespecial 474	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   687: ldc_w 835
    //   690: ldc_w 837
    //   693: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   696: astore_3
    //   697: aload_1
    //   698: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifeq +36 -> 737
    //   704: aload_0
    //   705: getfield 827	com/tencent/mobileqq/jsp/UiApiPlugin:p	Ljava/lang/String;
    //   708: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   711: ifeq +26 -> 737
    //   714: aload_3
    //   715: ldc_w 839
    //   718: iconst_1
    //   719: invokevirtual 842	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   722: pop
    //   723: aload_0
    //   724: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   727: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   730: aload_3
    //   731: invokevirtual 846	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   734: goto +2502 -> 3236
    //   737: aload_3
    //   738: ldc 26
    //   740: aload_1
    //   741: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   744: ldc 35
    //   746: aload_2
    //   747: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   750: ldc_w 848
    //   753: iconst_1
    //   754: invokevirtual 842	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   757: pop
    //   758: aload_0
    //   759: aload_3
    //   760: iconst_3
    //   761: invokevirtual 851	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   764: goto +2472 -> 3236
    //   767: ldc_w 853
    //   770: aload 4
    //   772: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   775: ifeq +41 -> 816
    //   778: aload 5
    //   780: arraylength
    //   781: iconst_1
    //   782: if_icmpne +34 -> 816
    //   785: aload_0
    //   786: new 131	org/json/JSONObject
    //   789: dup
    //   790: aload 5
    //   792: iconst_0
    //   793: aaload
    //   794: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   797: ldc 31
    //   799: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   802: putfield 101	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   805: goto +2431 -> 3236
    //   808: astore_1
    //   809: aload_1
    //   810: invokevirtual 856	org/json/JSONException:printStackTrace	()V
    //   813: goto +2423 -> 3236
    //   816: ldc_w 858
    //   819: aload 4
    //   821: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   824: ifeq +64 -> 888
    //   827: aload 5
    //   829: arraylength
    //   830: iconst_1
    //   831: if_icmpne +57 -> 888
    //   834: new 131	org/json/JSONObject
    //   837: dup
    //   838: aload 5
    //   840: iconst_0
    //   841: aaload
    //   842: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   845: ldc 31
    //   847: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   850: astore_1
    //   851: aload_0
    //   852: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   855: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   858: astore_2
    //   859: aload_2
    //   860: instanceof 390
    //   863: ifeq +2373 -> 3236
    //   866: aload_2
    //   867: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   870: invokevirtual 861	com/tencent/mobileqq/activity/QQBrowserActivity:a	()Lcom/tencent/biz/webviewplugin/Share;
    //   873: aload_1
    //   874: invokevirtual 864	com/tencent/biz/webviewplugin/Share:a	(Ljava/lang/String;)V
    //   877: goto +2359 -> 3236
    //   880: astore_1
    //   881: aload_1
    //   882: invokevirtual 856	org/json/JSONException:printStackTrace	()V
    //   885: goto +2351 -> 3236
    //   888: ldc_w 866
    //   891: aload 4
    //   893: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   896: ifeq +258 -> 1154
    //   899: aload 5
    //   901: arraylength
    //   902: iconst_1
    //   903: if_icmpne +251 -> 1154
    //   906: new 131	org/json/JSONObject
    //   909: dup
    //   910: aload 5
    //   912: iconst_0
    //   913: aaload
    //   914: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   917: astore 5
    //   919: aload_0
    //   920: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   923: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   926: astore 4
    //   928: aload 4
    //   930: ifnull +2318 -> 3248
    //   933: aload 4
    //   935: invokevirtual 546	android/app/Activity:isFinishing	()Z
    //   938: ifeq +6 -> 944
    //   941: goto +2307 -> 3248
    //   944: aload 5
    //   946: ldc_w 309
    //   949: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   952: astore_1
    //   953: aload 5
    //   955: ldc_w 732
    //   958: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   961: astore 13
    //   963: aload 5
    //   965: ldc_w 868
    //   968: iconst_1
    //   969: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   972: istore 8
    //   974: aload 5
    //   976: ldc_w 870
    //   979: iconst_1
    //   980: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   983: istore 9
    //   985: aload 5
    //   987: ldc_w 872
    //   990: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   993: astore_2
    //   994: aload 5
    //   996: ldc_w 874
    //   999: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1002: astore_3
    //   1003: aload 5
    //   1005: ldc 31
    //   1007: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1010: astore 5
    //   1012: aload 4
    //   1014: iconst_0
    //   1015: invokestatic 879	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1018: astore 12
    //   1020: aload 12
    //   1022: aload_1
    //   1023: invokevirtual 885	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1026: pop
    //   1027: aload 12
    //   1029: aload 13
    //   1031: invokevirtual 889	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1034: pop
    //   1035: new 891	jcy
    //   1038: dup
    //   1039: aload_0
    //   1040: aload 5
    //   1042: invokespecial 894	jcy:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   1045: astore 13
    //   1047: iload 9
    //   1049: ifeq +30 -> 1079
    //   1052: aload_3
    //   1053: astore_1
    //   1054: aload_3
    //   1055: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1058: ifeq +12 -> 1070
    //   1061: aload 4
    //   1063: ldc_w 895
    //   1066: invokevirtual 691	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1069: astore_1
    //   1070: aload 12
    //   1072: aload_1
    //   1073: aload 13
    //   1075: invokevirtual 899	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1078: pop
    //   1079: iload 8
    //   1081: ifeq +30 -> 1111
    //   1084: aload_2
    //   1085: astore_1
    //   1086: aload_2
    //   1087: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1090: ifeq +12 -> 1102
    //   1093: aload 4
    //   1095: ldc_w 900
    //   1098: invokevirtual 691	android/app/Activity:getString	(I)Ljava/lang/String;
    //   1101: astore_1
    //   1102: aload 12
    //   1104: aload_1
    //   1105: aload 13
    //   1107: invokevirtual 903	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1110: pop
    //   1111: aload 5
    //   1113: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne +18 -> 1134
    //   1119: aload 12
    //   1121: new 905	jcz
    //   1124: dup
    //   1125: aload_0
    //   1126: aload 5
    //   1128: invokespecial 906	jcz:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   1131: invokevirtual 907	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   1134: aload 12
    //   1136: invokevirtual 908	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1139: goto +2097 -> 3236
    //   1142: astore_1
    //   1143: goto +2093 -> 3236
    //   1146: astore_1
    //   1147: aload_1
    //   1148: invokevirtual 856	org/json/JSONException:printStackTrace	()V
    //   1151: goto +2085 -> 3236
    //   1154: ldc_w 910
    //   1157: aload 4
    //   1159: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifeq +233 -> 1395
    //   1165: aload 5
    //   1167: arraylength
    //   1168: iconst_1
    //   1169: if_icmpne +226 -> 1395
    //   1172: new 131	org/json/JSONObject
    //   1175: dup
    //   1176: aload 5
    //   1178: iconst_0
    //   1179: aaload
    //   1180: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1183: astore_3
    //   1184: aload_3
    //   1185: ldc_w 912
    //   1188: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1191: astore_2
    //   1192: aload_3
    //   1193: ldc_w 914
    //   1196: invokevirtual 811	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1199: astore_3
    //   1200: ldc_w 916
    //   1203: aload_2
    //   1204: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1207: ifeq +96 -> 1303
    //   1210: aload_3
    //   1211: ldc_w 918
    //   1214: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1217: astore_2
    //   1218: aload_2
    //   1219: invokestatic 923	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   1222: ifeq +56 -> 1278
    //   1225: new 154	android/content/Intent
    //   1228: dup
    //   1229: invokespecial 155	android/content/Intent:<init>	()V
    //   1232: astore_3
    //   1233: aload_3
    //   1234: getstatic 927	cooperation/troop/TroopProxyActivity:f	Ljava/lang/String;
    //   1237: aload_2
    //   1238: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1241: pop
    //   1242: aload_0
    //   1243: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1246: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1249: aload_3
    //   1250: invokestatic 930	cooperation/troop/TroopProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;)V
    //   1253: aload_1
    //   1254: ldc_w 932
    //   1257: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1260: goto +1976 -> 3236
    //   1263: astore_2
    //   1264: aload_2
    //   1265: invokevirtual 856	org/json/JSONException:printStackTrace	()V
    //   1268: aload_1
    //   1269: ldc_w 934
    //   1272: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1275: goto +1961 -> 3236
    //   1278: aload_1
    //   1279: ldc_w 934
    //   1282: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1285: goto +1951 -> 3236
    //   1288: astore_2
    //   1289: aload_2
    //   1290: invokevirtual 935	java/lang/Exception:printStackTrace	()V
    //   1293: aload_1
    //   1294: ldc_w 934
    //   1297: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1300: goto +1936 -> 3236
    //   1303: ldc_w 937
    //   1306: aload_2
    //   1307: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1310: ifeq +1926 -> 3236
    //   1313: aload_3
    //   1314: ldc_w 918
    //   1317: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1320: astore_2
    //   1321: aload_2
    //   1322: invokestatic 923	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   1325: ifeq +60 -> 1385
    //   1328: invokestatic 942	cooperation/qzone/QZoneHelper$UserInfo:a	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   1331: astore_3
    //   1332: aload_3
    //   1333: aload_0
    //   1334: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1337: invokevirtual 450	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1340: invokevirtual 944	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1343: putfield 945	cooperation/qzone/QZoneHelper$UserInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1346: aload_3
    //   1347: aload_0
    //   1348: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1351: invokevirtual 450	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1354: invokevirtual 948	com/tencent/common/app/AppInterface:getSid	()Ljava/lang/String;
    //   1357: putfield 950	cooperation/qzone/QZoneHelper$UserInfo:c	Ljava/lang/String;
    //   1360: aload_0
    //   1361: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1364: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1367: aload_3
    //   1368: aload_2
    //   1369: aconst_null
    //   1370: iconst_0
    //   1371: iconst_0
    //   1372: invokestatic 955	cooperation/qzone/QZoneHelper:b	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   1375: aload_1
    //   1376: ldc_w 932
    //   1379: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1382: goto +1854 -> 3236
    //   1385: aload_1
    //   1386: ldc_w 934
    //   1389: invokevirtual 795	com/tencent/mobileqq/webviewplugin/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1392: goto +1844 -> 3236
    //   1395: ldc_w 956
    //   1398: aload 4
    //   1400: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1403: ifeq +488 -> 1891
    //   1406: aload 5
    //   1408: arraylength
    //   1409: iconst_1
    //   1410: if_icmpne +481 -> 1891
    //   1413: aload_0
    //   1414: ldc_w 526
    //   1417: putfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   1420: new 131	org/json/JSONObject
    //   1423: dup
    //   1424: aload 5
    //   1426: iconst_0
    //   1427: aaload
    //   1428: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1431: astore_1
    //   1432: aload_1
    //   1433: ifnull +439 -> 1872
    //   1436: aload_0
    //   1437: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1440: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1443: astore_3
    //   1444: aload_1
    //   1445: ldc_w 960
    //   1448: ldc_w 962
    //   1451: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1454: astore 12
    //   1456: aload_1
    //   1457: ldc 26
    //   1459: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1462: astore 4
    //   1464: aload_1
    //   1465: ldc_w 407
    //   1468: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1471: astore 13
    //   1473: aload_1
    //   1474: ldc_w 967
    //   1477: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1480: astore 5
    //   1482: aload_1
    //   1483: ldc 31
    //   1485: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1488: astore_2
    //   1489: aload_1
    //   1490: ldc_w 488
    //   1493: iconst_m1
    //   1494: invokevirtual 970	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1497: istore 6
    //   1499: new 131	org/json/JSONObject
    //   1502: dup
    //   1503: aload 13
    //   1505: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1508: astore_1
    //   1509: aload_0
    //   1510: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1513: invokevirtual 403	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1516: astore 13
    //   1518: aload 13
    //   1520: ifnull +16 -> 1536
    //   1523: aload_1
    //   1524: ldc_w 972
    //   1527: aload 13
    //   1529: invokevirtual 973	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   1532: invokevirtual 977	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1535: pop
    //   1536: ldc_w 979
    //   1539: aload 12
    //   1541: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1544: ifeq +166 -> 1710
    //   1547: new 426	android/os/Bundle
    //   1550: dup
    //   1551: invokespecial 427	android/os/Bundle:<init>	()V
    //   1554: astore_2
    //   1555: aload_2
    //   1556: ldc_w 407
    //   1559: aload_1
    //   1560: invokevirtual 980	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1563: invokevirtual 530	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: aload_2
    //   1567: ldc_w 967
    //   1570: aload 5
    //   1572: invokevirtual 530	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1575: ldc_w 982
    //   1578: aload 4
    //   1580: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1583: ifeq +97 -> 1680
    //   1586: new 984	com/tencent/mobileqq/troop/activity/PublicCommentWindow
    //   1589: dup
    //   1590: aload_3
    //   1591: checkcast 461	com/tencent/mobileqq/app/BaseActivity
    //   1594: aload_2
    //   1595: invokespecial 987	com/tencent/mobileqq/troop/activity/PublicCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   1598: aload_3
    //   1599: invokevirtual 989	com/tencent/mobileqq/troop/activity/PublicCommentWindow:a	(Landroid/app/Activity;)V
    //   1602: goto +1634 -> 3236
    //   1605: astore_1
    //   1606: ldc_w 526
    //   1609: astore_2
    //   1610: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1613: ifeq +24 -> 1637
    //   1616: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1619: iconst_2
    //   1620: ldc_w 991
    //   1623: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1626: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1629: iconst_2
    //   1630: aload_1
    //   1631: invokestatic 995	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1634: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1637: aload_2
    //   1638: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1641: ifne +1595 -> 3236
    //   1644: aload_0
    //   1645: aload_2
    //   1646: iconst_1
    //   1647: anewarray 286	java/lang/String
    //   1650: dup
    //   1651: iconst_0
    //   1652: ldc_w 997
    //   1655: aastore
    //   1656: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1659: goto +1577 -> 3236
    //   1662: astore_1
    //   1663: aconst_null
    //   1664: astore_1
    //   1665: goto -233 -> 1432
    //   1668: astore_1
    //   1669: new 131	org/json/JSONObject
    //   1672: dup
    //   1673: invokespecial 998	org/json/JSONObject:<init>	()V
    //   1676: astore_1
    //   1677: goto -168 -> 1509
    //   1680: ldc_w 1000
    //   1683: aload 4
    //   1685: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1688: ifeq +1548 -> 3236
    //   1691: new 1002	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow
    //   1694: dup
    //   1695: aload_3
    //   1696: checkcast 461	com/tencent/mobileqq/app/BaseActivity
    //   1699: aload_2
    //   1700: invokespecial 1003	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   1703: aload_3
    //   1704: invokevirtual 1004	com/tencent/mobileqq/troop/activity/TroopBarCommentWindow:a	(Landroid/app/Activity;)V
    //   1707: goto +1529 -> 3236
    //   1710: ldc_w 962
    //   1713: aload 12
    //   1715: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1718: ifeq +1518 -> 3236
    //   1721: new 154	android/content/Intent
    //   1724: dup
    //   1725: invokespecial 155	android/content/Intent:<init>	()V
    //   1728: astore 12
    //   1730: aload 12
    //   1732: new 1006	android/content/ComponentName
    //   1735: dup
    //   1736: aload_3
    //   1737: aload 4
    //   1739: invokespecial 1009	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   1742: invokevirtual 1013	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   1745: pop
    //   1746: aload 12
    //   1748: ldc_w 407
    //   1751: aload_1
    //   1752: invokevirtual 980	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1755: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1758: pop
    //   1759: aload_0
    //   1760: aload 5
    //   1762: putfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   1765: aload 5
    //   1767: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1770: ifeq +57 -> 1827
    //   1773: aload_3
    //   1774: aload 12
    //   1776: invokevirtual 846	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1779: goto +1471 -> 3250
    //   1782: ldc_w 1015
    //   1785: invokevirtual 1018	java/lang/Class:getName	()Ljava/lang/String;
    //   1788: aload 4
    //   1790: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1793: ifeq +1443 -> 3236
    //   1796: aload_0
    //   1797: getfield 103	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1800: ifnonnull +17 -> 1817
    //   1803: aload_0
    //   1804: invokestatic 1023	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1807: putfield 103	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1810: aload_0
    //   1811: getfield 103	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1814: invokevirtual 1024	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   1817: aload_0
    //   1818: getfield 103	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1821: invokevirtual 1026	com/tencent/biz/troop/TroopMemberApiClient:c	()V
    //   1824: goto +1412 -> 3236
    //   1827: aload_0
    //   1828: aload 12
    //   1830: iconst_4
    //   1831: invokevirtual 851	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1834: aload_2
    //   1835: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1838: ifne +1412 -> 3250
    //   1841: aload_0
    //   1842: aload_2
    //   1843: iconst_1
    //   1844: anewarray 286	java/lang/String
    //   1847: dup
    //   1848: iconst_0
    //   1849: ldc_w 535
    //   1852: aastore
    //   1853: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1856: goto +1394 -> 3250
    //   1859: aload_3
    //   1860: ldc_w 1027
    //   1863: ldc_w 1028
    //   1866: invokevirtual 492	android/app/Activity:overridePendingTransition	(II)V
    //   1869: goto -87 -> 1782
    //   1872: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1875: ifeq +1361 -> 3236
    //   1878: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1881: iconst_2
    //   1882: ldc_w 1030
    //   1885: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1888: goto +1348 -> 3236
    //   1891: ldc_w 1032
    //   1894: aload 4
    //   1896: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1899: ifeq +382 -> 2281
    //   1902: aload 5
    //   1904: arraylength
    //   1905: iconst_1
    //   1906: if_icmpne +375 -> 2281
    //   1909: new 131	org/json/JSONObject
    //   1912: dup
    //   1913: aload 5
    //   1915: iconst_0
    //   1916: aaload
    //   1917: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1920: astore_1
    //   1921: aload_0
    //   1922: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1925: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1928: astore_2
    //   1929: aload_2
    //   1930: instanceof 390
    //   1933: ifne +5 -> 1938
    //   1936: iconst_1
    //   1937: ireturn
    //   1938: aload_1
    //   1939: ldc_w 1034
    //   1942: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1945: ifeq +70 -> 2015
    //   1948: aload_1
    //   1949: ldc_w 1034
    //   1952: invokevirtual 135	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1955: istore 6
    //   1957: aload_2
    //   1958: ldc_w 680
    //   1961: invokevirtual 684	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   1964: checkcast 686	android/widget/TextView
    //   1967: astore_3
    //   1968: aload_2
    //   1969: ldc_w 1035
    //   1972: invokevirtual 684	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   1975: checkcast 1037	android/widget/ImageView
    //   1978: astore 4
    //   1980: aload_3
    //   1981: ifnull +34 -> 2015
    //   1984: aload 4
    //   1986: ifnull +29 -> 2015
    //   1989: iload 6
    //   1991: iconst_1
    //   1992: if_icmpne +219 -> 2211
    //   1995: aload 4
    //   1997: invokevirtual 1041	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   2000: ifnull +196 -> 2196
    //   2003: aload 4
    //   2005: iconst_0
    //   2006: invokevirtual 1042	android/widget/ImageView:setVisibility	(I)V
    //   2009: aload_3
    //   2010: bipush 8
    //   2012: invokevirtual 1043	android/widget/TextView:setVisibility	(I)V
    //   2015: aload_1
    //   2016: ldc_w 1045
    //   2019: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2022: ifeq +37 -> 2059
    //   2025: aload_1
    //   2026: ldc_w 1045
    //   2029: invokestatic 1047	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   2032: istore 6
    //   2034: aload_2
    //   2035: ldc_w 1048
    //   2038: invokevirtual 684	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   2041: astore_3
    //   2042: aload_3
    //   2043: ifnull +16 -> 2059
    //   2046: iload 6
    //   2048: iconst_m1
    //   2049: if_icmpne +178 -> 2227
    //   2052: aload_3
    //   2053: ldc_w 1049
    //   2056: invokevirtual 1050	android/view/View:setBackgroundResource	(I)V
    //   2059: aload_1
    //   2060: ldc_w 1052
    //   2063: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2066: ifeq +25 -> 2091
    //   2069: aload_1
    //   2070: ldc_w 1052
    //   2073: invokestatic 1047	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   2076: istore 6
    //   2078: iload 6
    //   2080: iconst_m1
    //   2081: if_icmpne +164 -> 2245
    //   2084: aload_2
    //   2085: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2088: invokevirtual 1055	com/tencent/mobileqq/activity/QQBrowserActivity:u	()V
    //   2091: aload_1
    //   2092: ldc_w 1057
    //   2095: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2098: ifeq +21 -> 2119
    //   2101: aload_1
    //   2102: ldc_w 1057
    //   2105: invokevirtual 1060	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2108: istore 8
    //   2110: aload_2
    //   2111: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2114: iload 8
    //   2116: invokevirtual 1061	com/tencent/mobileqq/activity/QQBrowserActivity:a	(Z)V
    //   2119: aload_1
    //   2120: ldc_w 1063
    //   2123: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2126: ifeq +1110 -> 3236
    //   2129: aload_1
    //   2130: ldc_w 1063
    //   2133: invokevirtual 1060	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2136: ifeq +125 -> 2261
    //   2139: aload_2
    //   2140: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2143: astore_1
    //   2144: aload_1
    //   2145: aload_1
    //   2146: getfield 672	com/tencent/mobileqq/activity/QQBrowserActivity:j	J
    //   2149: ldc2_w 1064
    //   2152: land
    //   2153: putfield 672	com/tencent/mobileqq/activity/QQBrowserActivity:j	J
    //   2156: goto +1080 -> 3236
    //   2159: astore_1
    //   2160: invokestatic 1068	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2163: ifeq +1073 -> 3236
    //   2166: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2169: iconst_4
    //   2170: new 356	java/lang/StringBuilder
    //   2173: dup
    //   2174: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2177: ldc_w 1070
    //   2180: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: aload_1
    //   2184: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2187: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2190: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2193: goto +1043 -> 3236
    //   2196: aload 4
    //   2198: bipush 8
    //   2200: invokevirtual 1042	android/widget/ImageView:setVisibility	(I)V
    //   2203: aload_3
    //   2204: iconst_0
    //   2205: invokevirtual 1043	android/widget/TextView:setVisibility	(I)V
    //   2208: goto -193 -> 2015
    //   2211: aload_3
    //   2212: bipush 8
    //   2214: invokevirtual 1043	android/widget/TextView:setVisibility	(I)V
    //   2217: aload 4
    //   2219: bipush 8
    //   2221: invokevirtual 1042	android/widget/ImageView:setVisibility	(I)V
    //   2224: goto -209 -> 2015
    //   2227: aload_3
    //   2228: iconst_0
    //   2229: invokevirtual 1050	android/view/View:setBackgroundResource	(I)V
    //   2232: aload_3
    //   2233: iload 6
    //   2235: ldc_w 1074
    //   2238: ior
    //   2239: invokevirtual 1077	android/view/View:setBackgroundColor	(I)V
    //   2242: goto -183 -> 2059
    //   2245: aload_2
    //   2246: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2249: iload 6
    //   2251: ldc_w 1074
    //   2254: ior
    //   2255: invokevirtual 1079	com/tencent/mobileqq/activity/QQBrowserActivity:b	(I)V
    //   2258: goto -167 -> 2091
    //   2261: aload_2
    //   2262: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2265: astore_1
    //   2266: aload_1
    //   2267: aload_1
    //   2268: getfield 672	com/tencent/mobileqq/activity/QQBrowserActivity:j	J
    //   2271: ldc2_w 696
    //   2274: lor
    //   2275: putfield 672	com/tencent/mobileqq/activity/QQBrowserActivity:j	J
    //   2278: goto +958 -> 3236
    //   2281: ldc_w 1081
    //   2284: aload 4
    //   2286: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2289: ifeq +99 -> 2388
    //   2292: aload 5
    //   2294: arraylength
    //   2295: iconst_1
    //   2296: if_icmpgt +92 -> 2388
    //   2299: aload 5
    //   2301: arraylength
    //   2302: iconst_1
    //   2303: if_icmpne +22 -> 2325
    //   2306: new 131	org/json/JSONObject
    //   2309: dup
    //   2310: aload 5
    //   2312: iconst_0
    //   2313: aaload
    //   2314: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2317: ldc_w 1083
    //   2320: iconst_0
    //   2321: invokevirtual 970	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2324: pop
    //   2325: aload_0
    //   2326: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2329: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2332: astore_1
    //   2333: aload_1
    //   2334: instanceof 390
    //   2337: ifeq +899 -> 3236
    //   2340: aload_1
    //   2341: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2344: aconst_null
    //   2345: invokevirtual 1085	com/tencent/mobileqq/activity/QQBrowserActivity:a	(Landroid/view/View;)V
    //   2348: goto +888 -> 3236
    //   2351: astore_1
    //   2352: invokestatic 1068	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2355: ifeq +881 -> 3236
    //   2358: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2361: iconst_4
    //   2362: new 356	java/lang/StringBuilder
    //   2365: dup
    //   2366: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2369: ldc_w 1087
    //   2372: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: aload_1
    //   2376: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2379: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2382: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2385: goto +851 -> 3236
    //   2388: ldc_w 1089
    //   2391: aload 4
    //   2393: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2396: ifeq +122 -> 2518
    //   2399: aload 5
    //   2401: arraylength
    //   2402: iconst_1
    //   2403: if_icmpne +115 -> 2518
    //   2406: new 131	org/json/JSONObject
    //   2409: dup
    //   2410: aload 5
    //   2412: iconst_0
    //   2413: aaload
    //   2414: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2417: astore_1
    //   2418: aload_1
    //   2419: ldc 38
    //   2421: iconst_0
    //   2422: invokevirtual 970	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2425: istore 6
    //   2427: aload_1
    //   2428: ldc 41
    //   2430: iconst_0
    //   2431: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2434: istore 8
    //   2436: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   2439: new 154	android/content/Intent
    //   2442: dup
    //   2443: ldc 44
    //   2445: invokespecial 1090	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2448: ldc 38
    //   2450: iload 6
    //   2452: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2455: ldc 41
    //   2457: iload 8
    //   2459: invokevirtual 842	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2462: ldc_w 1092
    //   2465: aload_0
    //   2466: getfield 109	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   2469: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2472: ldc_w 1094
    //   2475: invokevirtual 1098	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2478: goto +758 -> 3236
    //   2481: astore_1
    //   2482: invokestatic 1068	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2485: ifeq +751 -> 3236
    //   2488: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2491: iconst_4
    //   2492: new 356	java/lang/StringBuilder
    //   2495: dup
    //   2496: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2499: ldc_w 1100
    //   2502: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: aload_1
    //   2506: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2509: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2512: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2515: goto +721 -> 3236
    //   2518: ldc_w 1102
    //   2521: aload 4
    //   2523: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2526: ifeq +237 -> 2763
    //   2529: aload 5
    //   2531: arraylength
    //   2532: iconst_1
    //   2533: if_icmpne +230 -> 2763
    //   2536: aload_0
    //   2537: aconst_null
    //   2538: putfield 1104	com/tencent/mobileqq/jsp/UiApiPlugin:r	Ljava/lang/String;
    //   2541: new 131	org/json/JSONObject
    //   2544: dup
    //   2545: aload 5
    //   2547: iconst_0
    //   2548: aaload
    //   2549: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2552: astore_3
    //   2553: aload_3
    //   2554: ldc_w 1105
    //   2557: invokevirtual 1109	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2560: lstore 10
    //   2562: aload_3
    //   2563: ldc_w 1111
    //   2566: bipush 13
    //   2568: invokevirtual 970	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2571: istore 6
    //   2573: aload_3
    //   2574: ldc 31
    //   2576: invokevirtual 139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2579: astore_1
    //   2580: aload_0
    //   2581: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2584: invokevirtual 450	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2587: astore_2
    //   2588: aload_2
    //   2589: ifnull +10 -> 2599
    //   2592: aload_2
    //   2593: invokevirtual 1114	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2596: ifne +20 -> 2616
    //   2599: aload_0
    //   2600: aload_1
    //   2601: iconst_1
    //   2602: anewarray 286	java/lang/String
    //   2605: dup
    //   2606: iconst_0
    //   2607: ldc_w 1116
    //   2610: aastore
    //   2611: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2614: iconst_1
    //   2615: ireturn
    //   2616: aload_3
    //   2617: ldc 50
    //   2619: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2622: astore_3
    //   2623: aload_3
    //   2624: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2627: ifne +31 -> 2658
    //   2630: aload_3
    //   2631: aload_2
    //   2632: invokevirtual 453	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2635: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2638: ifne +20 -> 2658
    //   2641: aload_0
    //   2642: aload_1
    //   2643: iconst_1
    //   2644: anewarray 286	java/lang/String
    //   2647: dup
    //   2648: iconst_0
    //   2649: ldc_w 1118
    //   2652: aastore
    //   2653: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2656: iconst_1
    //   2657: ireturn
    //   2658: aload_0
    //   2659: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2662: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2665: astore_2
    //   2666: aload_2
    //   2667: ifnull +569 -> 3236
    //   2670: aload_0
    //   2671: aload_1
    //   2672: putfield 1104	com/tencent/mobileqq/jsp/UiApiPlugin:r	Ljava/lang/String;
    //   2675: new 154	android/content/Intent
    //   2678: dup
    //   2679: aload_2
    //   2680: ldc_w 1120
    //   2683: invokespecial 474	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2686: astore_1
    //   2687: aload_1
    //   2688: ldc_w 1122
    //   2691: bipush 16
    //   2693: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2696: pop
    //   2697: aload_1
    //   2698: ldc_w 1111
    //   2701: iload 6
    //   2703: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2706: pop
    //   2707: aload_1
    //   2708: ldc_w 1105
    //   2711: lload 10
    //   2713: invokevirtual 1125	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2716: pop
    //   2717: aload_0
    //   2718: aload_1
    //   2719: iconst_5
    //   2720: invokevirtual 851	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2723: goto +513 -> 3236
    //   2726: astore_1
    //   2727: invokestatic 1068	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2730: ifeq +506 -> 3236
    //   2733: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2736: iconst_4
    //   2737: new 356	java/lang/StringBuilder
    //   2740: dup
    //   2741: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2744: ldc_w 1127
    //   2747: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: aload_1
    //   2751: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2754: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2757: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2760: goto +476 -> 3236
    //   2763: ldc_w 1129
    //   2766: aload 4
    //   2768: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2771: ifeq +257 -> 3028
    //   2774: aload 5
    //   2776: arraylength
    //   2777: iconst_1
    //   2778: if_icmpne +250 -> 3028
    //   2781: new 131	org/json/JSONObject
    //   2784: dup
    //   2785: aload 5
    //   2787: iconst_0
    //   2788: aaload
    //   2789: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2792: astore_1
    //   2793: aload_1
    //   2794: ldc_w 1131
    //   2797: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2800: ifeq +109 -> 2909
    //   2803: aload_1
    //   2804: ldc_w 1131
    //   2807: invokevirtual 1060	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2810: istore 8
    //   2812: iload 8
    //   2814: aload_0
    //   2815: getfield 120	com/tencent/mobileqq/jsp/UiApiPlugin:c	Z
    //   2818: if_icmpeq +418 -> 3236
    //   2821: iload 8
    //   2823: ifeq +79 -> 2902
    //   2826: aload_0
    //   2827: invokevirtual 1132	com/tencent/mobileqq/jsp/UiApiPlugin:a	()V
    //   2830: aload_0
    //   2831: iload 8
    //   2833: putfield 120	com/tencent/mobileqq/jsp/UiApiPlugin:c	Z
    //   2836: aload_0
    //   2837: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2840: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2843: instanceof 390
    //   2846: ifeq +390 -> 3236
    //   2849: aload_0
    //   2850: getfield 297	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   2853: invokevirtual 302	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2856: checkcast 390	com/tencent/mobileqq/activity/QQBrowserActivity
    //   2859: invokevirtual 1134	com/tencent/mobileqq/activity/QQBrowserActivity:g	()V
    //   2862: goto +374 -> 3236
    //   2865: astore_1
    //   2866: invokestatic 1068	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2869: ifeq +367 -> 3236
    //   2872: getstatic 84	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2875: iconst_4
    //   2876: new 356	java/lang/StringBuilder
    //   2879: dup
    //   2880: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   2883: ldc_w 1136
    //   2886: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: aload_1
    //   2890: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2893: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2896: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2899: goto +337 -> 3236
    //   2902: aload_0
    //   2903: invokevirtual 1138	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   2906: goto -76 -> 2830
    //   2909: aload_1
    //   2910: ldc_w 1140
    //   2913: invokevirtual 416	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2916: ifeq +320 -> 3236
    //   2919: aload_0
    //   2920: getfield 643	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Boolean	Z
    //   2923: ifeq +313 -> 3236
    //   2926: aload_0
    //   2927: iconst_0
    //   2928: putfield 643	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Boolean	Z
    //   2931: aload_1
    //   2932: ldc_w 1140
    //   2935: invokevirtual 1060	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   2938: istore 8
    //   2940: invokestatic 226	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   2943: invokevirtual 744	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   2946: astore_2
    //   2947: iload 8
    //   2949: ifeq +47 -> 2996
    //   2952: aload_0
    //   2953: getfield 626	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   2956: iconst_0
    //   2957: aload_1
    //   2958: ldc_w 732
    //   2961: aload_2
    //   2962: ldc_w 1141
    //   2965: invokevirtual 1142	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2968: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2971: invokevirtual 1145	com/tencent/mobileqq/widget/PullRefreshHeader:a	(ILjava/lang/String;)V
    //   2974: aload_0
    //   2975: getfield 147	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2978: new 1147	jda
    //   2981: dup
    //   2982: aload_0
    //   2983: invokespecial 1148	jda:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   2986: ldc2_w 1149
    //   2989: invokevirtual 1154	com/tencent/widget/XListView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   2992: pop
    //   2993: goto +243 -> 3236
    //   2996: aload_0
    //   2997: getfield 626	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   3000: iconst_1
    //   3001: aload_1
    //   3002: ldc_w 732
    //   3005: aload_2
    //   3006: ldc_w 1155
    //   3009: invokevirtual 1142	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3012: invokevirtual 965	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3015: invokevirtual 1145	com/tencent/mobileqq/widget/PullRefreshHeader:a	(ILjava/lang/String;)V
    //   3018: aload_0
    //   3019: getfield 147	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   3022: invokevirtual 1157	com/tencent/widget/XListView:B	()V
    //   3025: goto +211 -> 3236
    //   3028: ldc_w 1159
    //   3031: aload 4
    //   3033: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3036: ifeq +200 -> 3236
    //   3039: aload 5
    //   3041: arraylength
    //   3042: iconst_1
    //   3043: if_icmpne +193 -> 3236
    //   3046: new 131	org/json/JSONObject
    //   3049: dup
    //   3050: aload 5
    //   3052: iconst_0
    //   3053: aaload
    //   3054: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3057: astore_2
    //   3058: aload_2
    //   3059: ldc_w 1161
    //   3062: invokevirtual 378	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3065: istore 6
    //   3067: aload_2
    //   3068: ldc_w 405
    //   3071: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3074: astore_1
    //   3075: aload_2
    //   3076: ldc_w 1163
    //   3079: invokevirtual 378	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3082: istore 7
    //   3084: aload_0
    //   3085: aload_2
    //   3086: ldc 31
    //   3088: invokevirtual 312	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3091: putfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   3094: new 154	android/content/Intent
    //   3097: dup
    //   3098: getstatic 1166	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   3101: ldc_w 1168
    //   3104: invokespecial 474	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3107: astore_2
    //   3108: aload_2
    //   3109: ldc_w 1170
    //   3112: iload 6
    //   3114: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3117: pop
    //   3118: aload_2
    //   3119: ldc_w 1172
    //   3122: aload_1
    //   3123: invokevirtual 216	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3126: pop
    //   3127: aload_2
    //   3128: ldc_w 1174
    //   3131: iload 7
    //   3133: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3136: pop
    //   3137: aload_2
    //   3138: ldc_w 1176
    //   3141: bipush 6
    //   3143: invokevirtual 1179	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   3146: pop
    //   3147: aload_0
    //   3148: aload_2
    //   3149: bipush 6
    //   3151: invokevirtual 851	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   3154: goto +82 -> 3236
    //   3157: astore_1
    //   3158: aload_1
    //   3159: invokevirtual 856	org/json/JSONException:printStackTrace	()V
    //   3162: aload_0
    //   3163: getfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   3166: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3169: ifne +67 -> 3236
    //   3172: aload_0
    //   3173: aload_0
    //   3174: getfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   3177: iconst_1
    //   3178: anewarray 286	java/lang/String
    //   3181: dup
    //   3182: iconst_0
    //   3183: ldc_w 1181
    //   3186: aastore
    //   3187: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3190: goto +46 -> 3236
    //   3193: astore_1
    //   3194: aload_1
    //   3195: invokevirtual 935	java/lang/Exception:printStackTrace	()V
    //   3198: aload_0
    //   3199: getfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   3202: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3205: ifne +31 -> 3236
    //   3208: aload_0
    //   3209: aload_0
    //   3210: getfield 958	com/tencent/mobileqq/jsp/UiApiPlugin:q	Ljava/lang/String;
    //   3213: iconst_1
    //   3214: anewarray 286	java/lang/String
    //   3217: dup
    //   3218: iconst_0
    //   3219: ldc_w 1181
    //   3222: aastore
    //   3223: invokevirtual 543	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3226: goto +10 -> 3236
    //   3229: iconst_0
    //   3230: ireturn
    //   3231: astore 13
    //   3233: goto -1697 -> 1536
    //   3236: iconst_1
    //   3237: ireturn
    //   3238: astore_1
    //   3239: goto -3 -> 3236
    //   3242: iconst_1
    //   3243: ireturn
    //   3244: astore_1
    //   3245: goto -9 -> 3236
    //   3248: iconst_1
    //   3249: ireturn
    //   3250: iload 6
    //   3252: tableswitch	default:+20 -> 3272, 1001:+-1393->1859
    //   3273: <illegal opcode>
    //   3274: iaload
    //   3275: astore_1
    //   3276: goto -1666 -> 1610
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3279	0	this	UiApiPlugin
    //   0	3279	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	3279	2	paramString1	String
    //   0	3279	3	paramString2	String
    //   0	3279	4	paramString3	String
    //   0	3279	5	paramVarArgs	String[]
    //   1497	1754	6	i1	int
    //   3082	50	7	i2	int
    //   972	1976	8	bool1	boolean
    //   983	65	9	bool2	boolean
    //   2560	152	10	l1	long
    //   1018	811	12	localObject1	Object
    //   961	567	13	localObject2	Object
    //   3231	1	13	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   159	199	202	org/json/JSONException
    //   224	252	255	java/lang/Exception
    //   287	294	302	java/lang/Exception
    //   287	294	311	finally
    //   391	406	409	org/json/JSONException
    //   448	456	562	org/json/JSONException
    //   460	467	562	org/json/JSONException
    //   470	490	562	org/json/JSONException
    //   494	522	562	org/json/JSONException
    //   526	532	562	org/json/JSONException
    //   532	542	562	org/json/JSONException
    //   542	550	562	org/json/JSONException
    //   554	559	562	org/json/JSONException
    //   785	805	808	org/json/JSONException
    //   834	877	880	org/json/JSONException
    //   1134	1139	1142	java/lang/Exception
    //   906	928	1146	org/json/JSONException
    //   933	941	1146	org/json/JSONException
    //   944	1047	1146	org/json/JSONException
    //   1054	1070	1146	org/json/JSONException
    //   1070	1079	1146	org/json/JSONException
    //   1086	1102	1146	org/json/JSONException
    //   1102	1111	1146	org/json/JSONException
    //   1111	1134	1146	org/json/JSONException
    //   1134	1139	1146	org/json/JSONException
    //   1172	1260	1263	org/json/JSONException
    //   1278	1285	1263	org/json/JSONException
    //   1303	1382	1263	org/json/JSONException
    //   1385	1392	1263	org/json/JSONException
    //   1172	1260	1288	java/lang/Exception
    //   1278	1285	1288	java/lang/Exception
    //   1303	1382	1288	java/lang/Exception
    //   1385	1392	1288	java/lang/Exception
    //   1436	1499	1605	java/lang/Exception
    //   1499	1509	1605	java/lang/Exception
    //   1509	1518	1605	java/lang/Exception
    //   1523	1536	1605	java/lang/Exception
    //   1536	1602	1605	java/lang/Exception
    //   1669	1677	1605	java/lang/Exception
    //   1680	1707	1605	java/lang/Exception
    //   1710	1765	1605	java/lang/Exception
    //   1420	1432	1662	org/json/JSONException
    //   1499	1509	1668	org/json/JSONException
    //   1909	1936	2159	org/json/JSONException
    //   1938	1980	2159	org/json/JSONException
    //   1995	2015	2159	org/json/JSONException
    //   2015	2042	2159	org/json/JSONException
    //   2052	2059	2159	org/json/JSONException
    //   2059	2078	2159	org/json/JSONException
    //   2084	2091	2159	org/json/JSONException
    //   2091	2119	2159	org/json/JSONException
    //   2119	2156	2159	org/json/JSONException
    //   2196	2208	2159	org/json/JSONException
    //   2211	2224	2159	org/json/JSONException
    //   2227	2242	2159	org/json/JSONException
    //   2245	2258	2159	org/json/JSONException
    //   2261	2278	2159	org/json/JSONException
    //   2299	2325	2351	org/json/JSONException
    //   2325	2348	2351	org/json/JSONException
    //   2406	2478	2481	org/json/JSONException
    //   2536	2588	2726	org/json/JSONException
    //   2592	2599	2726	org/json/JSONException
    //   2599	2614	2726	org/json/JSONException
    //   2616	2656	2726	org/json/JSONException
    //   2658	2666	2726	org/json/JSONException
    //   2670	2723	2726	org/json/JSONException
    //   2781	2821	2865	org/json/JSONException
    //   2826	2830	2865	org/json/JSONException
    //   2830	2862	2865	org/json/JSONException
    //   2902	2906	2865	org/json/JSONException
    //   2909	2947	2865	org/json/JSONException
    //   2952	2993	2865	org/json/JSONException
    //   2996	3025	2865	org/json/JSONException
    //   3046	3154	3157	org/json/JSONException
    //   3046	3154	3193	java/lang/Exception
    //   1509	1518	3231	org/json/JSONException
    //   1523	1536	3231	org/json/JSONException
    //   27	84	3238	org/json/JSONException
    //   84	111	3238	org/json/JSONException
    //   114	145	3238	org/json/JSONException
    //   630	734	3244	org/json/JSONException
    //   737	764	3244	org/json/JSONException
    //   1765	1779	3275	java/lang/Exception
    //   1782	1817	3275	java/lang/Exception
    //   1817	1824	3275	java/lang/Exception
    //   1827	1856	3275	java/lang/Exception
    //   1859	1869	3275	java/lang/Exception
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 3) {
      if (paramIntent != null) {}
    }
    do
    {
      Object localObject1;
      Object localObject3;
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = paramIntent.getStringExtra("scanResult");
            if (!TextUtils.isEmpty(this.p)) {
              break;
            }
            localObject3 = paramIntent.getStringExtra("callback_url");
            localObject2 = paramIntent.getStringExtra("name");
          } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2)));
          localObject3 = ((String)localObject3).split("#");
          StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
          if (localObject3[0].contains("?")) {}
          for (paramIntent = "&";; paramIntent = "?")
          {
            paramIntent = localStringBuilder.append(paramIntent).append((String)localObject2).append("=").append(URLEncoder.encode((String)localObject1));
            if (localObject3.length > 1) {
              paramIntent.append("#").append(localObject3[1]);
            }
            this.mRuntime.a().loadUrl(paramIntent.toString());
            return;
          }
          localObject2 = this.p;
          if (localObject1 == null) {}
          for (paramIntent = "''";; paramIntent = Util.b((String)localObject1))
          {
            callJs((String)localObject2, new String[] { paramIntent });
            return;
          }
          if (paramByte != 4) {
            break;
          }
        } while (TextUtils.isEmpty(this.q));
        if (paramInt == -1)
        {
          if (paramIntent == null) {}
          for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
          {
            paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
            callJs(this.q, new String[] { paramIntent });
            return;
          }
        }
        callJs(this.q, new String[] { "{\"code\":-1}" });
        return;
        if (paramByte != 5) {
          break;
        }
      } while (TextUtils.isEmpty(this.r));
      if (paramInt == -1)
      {
        paramInt = paramIntent.getIntExtra("ret", 4);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact ret:" + paramInt);
        }
        localObject1 = new JSONObject();
        for (;;)
        {
          try
          {
            ((JSONObject)localObject1).put("ret", paramInt);
            if (paramInt == 0)
            {
              localObject2 = paramIntent.getStringArrayExtra("openids");
              paramIntent = paramIntent.getIntArrayExtra("types");
              int i1 = localObject2.length;
              localObject3 = new JSONArray();
              paramInt = 0;
              if (paramInt < i1)
              {
                ((JSONArray)localObject3).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject2[paramInt]));
                paramInt += 1;
                continue;
              }
              ((JSONObject)localObject1).put("contacts", localObject3);
              callJs(this.r, new String[] { ((JSONObject)localObject1).toString() });
              return;
            }
          }
          catch (JSONException paramIntent)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "select contact result json exception", paramIntent);
            }
            callJs(this.r, new String[] { "{\"ret\":4}" });
            return;
          }
          ((JSONObject)localObject1).put("errMsg", paramIntent.getStringExtra("errMsg"));
        }
      }
      callJs(this.r, new String[] { "{\"ret\":3}" });
      return;
    } while ((paramByte != 6) || (TextUtils.isEmpty(this.q)));
    if (paramInt == -1)
    {
      callJs(this.q, new String[] { "{'retcode' : 0}" });
      return;
    }
    paramInt = paramIntent.getIntExtra("retCode", -1);
    callJs(this.q, new String[] { "{'retcode' : " + paramInt + "}" });
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "1", Integer.toString(this.jdField_e_of_type_Int) });
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = this.mRuntime.a();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
  
  protected void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify2", null);
  }
  
  protected void onDestroy()
  {
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if (this.b)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader((View)null);
      this.jdField_a_of_type_Jdc = null;
    }
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.o)) {
      callJs(this.o, new String[] { "1", Integer.toString(this.jdField_e_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */