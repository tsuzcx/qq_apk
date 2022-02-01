package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cji;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountBrowser
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final long a = 100298324L;
  private static final String a = "PublicAccountBrowser";
  protected static final WebSettings.TextSize[] a;
  protected static int b = 0;
  protected static int c = 0;
  public static final String c = "2632129500";
  protected static final int d = 9;
  public static final String d = "hideRightButton";
  protected static final int e = 3;
  public static final String e = "url";
  public static final String f = "hide_operation_bar";
  public static final String g = "puin";
  public static final String h = "assignBackText";
  public static final String i = "uin";
  public static final String j = "uin_name";
  public static final String k = "uin_type";
  public static final String l = "openid";
  public static final String m = "token";
  public static final String n = "https://s.p.qq.com/pub/msg";
  public static final String o = "https://s.p.qq.com/pub/show";
  public static final String p = "https://s.p.qq.com/pub/history";
  public static final String q = "https://s.p.qq.com/pub/jump";
  public static final String r = "https://browserApp.p.qq.com/";
  public static final String u = "mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s";
  public static final String v = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1";
  public static final String w = "https://url.cn/JS8oE7";
  public static final String x = "source_name";
  protected Bundle a;
  public View.OnClickListener a;
  protected PopupWindow a;
  protected ArrayList a;
  protected boolean b;
  protected boolean c;
  protected boolean d = false;
  protected boolean e = false;
  protected int f;
  protected boolean f;
  public String s = null;
  protected String t = null;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_ArrayOfComTencentSmttSdkWebSettings$TextSize = new WebSettings.TextSize[] { WebSettings.TextSize.SMALLER, WebSettings.TextSize.NORMAL, WebSettings.TextSize.LARGER, WebSettings.TextSize.LARGEST };
  }
  
  public PublicAccountBrowser()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cji(this);
  }
  
  private void a()
  {
    boolean bool2 = false;
    Intent localIntent = super.getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
    this.N = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.t = this.jdField_a_of_type_AndroidOsBundle.getString("uin_name");
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uin_type");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("token");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountBrowser", 2, "url not found, use \"\" default");
      }
      localObject1 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountBrowser", 2, "get a url:" + Util.b((String)localObject1, new String[0]));
    }
    localObject2 = localObject1;
    if (((String)localObject1).startsWith("https://browserApp.p.qq.com/"))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("?")) {
        localObject2 = (String)localObject1 + "?";
      }
      localObject2 = (String)localObject2 + "&openid=" + str1 + "&token=" + str2;
      localIntent.putExtra("url", (String)localObject2);
    }
    if (localObject2 != null)
    {
      localObject1 = Uri.parse((String)localObject2);
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()))
      {
        localObject1 = ((Uri)localObject1).getQueryParameter("_wv");
        if (localObject1 == null) {}
      }
    }
    try
    {
      this.j = Long.parseLong(((String)localObject1).trim());
      this.s = this.jdField_a_of_type_AndroidOsBundle.getString("puin");
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hide_operation_bar"))
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        if ((!((String)localObject2).startsWith("https://s.p.qq.com/pub/msg")) && (!((String)localObject2).startsWith("https://s.p.qq.com/pub/show"))) {
          break label530;
        }
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("hide_operation_bar"))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label535;
          }
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_c_of_type_Boolean) {
            break label543;
          }
          bool1 = true;
          localIntent.putExtra("hide_operation_bar", bool1);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("webStyle");
        if ((localObject1 != null) && (((String)localObject1).equals("noBottomBar"))) {
          this.jdField_c_of_type_Boolean = false;
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("disableshare");
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("hideRightButton", false))
        {
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (!((String)localObject1).equals("true")) {}
          }
        }
        else
        {
          bool1 = true;
        }
        this.jdField_f_of_type_Boolean = bool1;
        if ((!this.jdField_f_of_type_Boolean) && ((this.j & 0x23F8) == 9208L)) {
          this.jdField_f_of_type_Boolean = true;
        }
        localIntent.putExtra("url", (String)localObject2);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
          continue;
          bool1 = false;
          continue;
          label530:
          bool1 = false;
          continue;
          label535:
          this.jdField_c_of_type_Boolean = true;
          continue;
          label543:
          bool1 = false;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    c(jdField_b_of_type_Int);
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApplication(), 2131365941, 0).b(super.getTitleBarHeight());
    }
    if (!this.g)
    {
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("assignBackText");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.leftView.setText(paramBundle);
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        this.rightViewText.setText("");
        this.rightViewImg.setImageResource(2130838104);
        this.rightViewImg.setContentDescription(super.getText(2131367260));
      }
    }
    else
    {
      return;
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    int i1 = (int)DisplayUtils.a(this, 8.0F);
    ((RelativeLayout.LayoutParams)this.centerView.getLayoutParams()).setMargins(i1, 0, i1, 0);
  }
  
  private void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.s;
    }
    if (str != null)
    {
      paramString = new Intent(this, AccountDetailActivity.class);
      paramString.putExtra("uin", str);
      super.startActivity(paramString);
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (this.k)) {
      return;
    }
    jdField_c_of_type_Int = paramInt;
    WebSettings.TextSize localTextSize = jdField_a_of_type_ArrayOfComTencentSmttSdkWebSettings$TextSize[paramInt];
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().setTextSize(localTextSize);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      View localView = super.getLayoutInflater().inflate(2130903301, null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131297608);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297609);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297610);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      localLinearLayout = (LinearLayout)localView.findViewById(2131297611);
      this.jdField_a_of_type_JavaUtilArrayList.add(localLinearLayout);
      localLinearLayout.setOnClickListener(this);
      ((LinearLayout)localView.findViewById(2131297612)).setOnClickListener(this);
    }
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, 83, 0, 0);
    }
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public String a()
  {
    return "PA";
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == -8) {
      QRUtils.a(1, 2131363618);
    }
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    c(jdField_c_of_type_Int);
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("file://"))) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "shouldOverride: " + Util.b(paramString, new String[0]));
      }
      c(jdField_b_of_type_Int);
      paramWebView = paramWebView.getUrl();
      if ((TextUtils.isEmpty(paramWebView)) || (paramWebView.startsWith("https://s.p.qq.com/pub/jump"))) {}
      for (int i1 = 1; (this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (i1 != 0); i1 = 0)
      {
        this.e = false;
        return false;
      }
    } while (this.d);
    paramWebView = new Intent(this, PublicAccountBrowser.class);
    paramWebView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a());
    paramWebView.putExtra("url", paramString);
    super.startActivity(paramWebView);
    return true;
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.j & 0x8) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363654);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130837971;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.j & 0x10) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363660);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130837972;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.j & 0x200) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363659);
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130839264;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.j & 0x100) == 0L)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131363658);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2130839262;
      ((PublicAccountBrowser.ActionSheetItem)localObject).m = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    if ((!TextUtils.isEmpty(this.s)) && ((this.j & 0x40) == 0L))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363663);
      localActionSheetItem.l = 2130839261;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.m = 8;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.j & 0x2000) == 0L)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363668);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 2130839610;
      localActionSheetItem.m = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.j & 0x80) == 0L)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363655);
      localActionSheetItem.l = 2130839263;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.m = 7;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.j & 0x20) == 0L)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363656);
      localActionSheetItem.l = 2130837969;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.m = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131363657);
    localActionSheetItem.l = 2130839251;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.m = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public String b()
  {
    return this.s;
  }
  
  protected void c()
  {
    if ((this.M != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig != null) && (!TextUtils.isEmpty(this.s)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(this.M)))) {
      this.M = Uri.parse(this.M).buildUpon().appendQueryParameter("puin", this.s).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getAccount()).toString();
    }
  }
  
  protected void d()
  {
    onBackEvent();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("url");
    this.o = false;
    if ((str != null) && (str.contains("iyouxi.vip.qq.com/vipcenter")))
    {
      super.doOnCreate(paramBundle);
      VasWebviewUtil.a(this, str, 16L, localIntent, false, -1);
      finish();
      return false;
    }
    if ((str != null) && (str.indexOf("history.mp.qq") > 0)) {
      jdField_b_of_type_Int = 0;
    }
    if (getIntent().getIntExtra("reqType", -1) == 5)
    {
      super.doOnCreate(paramBundle);
      if (!this.g)
      {
        this.leftView.setOnClickListener(this);
        this.rightViewText.setText(2131365845);
        this.rightViewText.setOnClickListener(this);
      }
    }
    for (;;)
    {
      return true;
      a();
      super.doOnCreate(paramBundle);
      a(paramBundle);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131297612: 
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    case 2131297608: 
      c(0);
      return;
    case 2131297609: 
      c(1);
      return;
    case 2131297610: 
      c(2);
      return;
    }
    c(3);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof PublicAccountBrowser.ActionSheetItemViewHolder)) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "Item clicked but tag not found");
      }
    }
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)localObject).a.m;
      if (i1 == 7)
      {
        w();
        return;
      }
      if (i1 == 8)
      {
        a(this.s);
        return;
      }
      super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      if ((i1 == 2) || (i1 == 3))
      {
        ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
        return;
      }
    } while (i1 != 6);
    ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser
 * JD-Core Version:    0.7.0.1
 */