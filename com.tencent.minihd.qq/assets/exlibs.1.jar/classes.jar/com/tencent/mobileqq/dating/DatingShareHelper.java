package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import cooperation.qzone.QZoneShareManager;
import ibz;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DatingShareHelper
  implements DialogInterface.OnDismissListener, Handler.Callback, AdapterView.OnItemClickListener, WXShareHelper.WXShareListener, ActionSheet.OnButtonClickListener
{
  public static final String a = "mqqapi://dating/";
  private static final int b = 0;
  public static final String b = "https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?";
  private static final int c = 1;
  public static final String c = "bid=";
  public static final String d = "subject=";
  public static final String e = "mqqapi://dating/detail?src_type=internal&from_type=3&version=1&from=1&dating_id=%s&subject=%s";
  public static final String f = "mqqapi://dating/feed?src_type=internal&from_type=3&version=1&from=1";
  public static final String g = "web";
  public static final String h = "mqq";
  public static final String i = "https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?bid=%s&_wv=1025&adtag=%s&subject=%s";
  private static final String k = "约会 的分享";
  private static final String l = "约会";
  private static final String m = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_icon_small.png";
  private static final String n = "";
  private static final String o = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_dine_default.png";
  private static final String p = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_ktvt_default.png";
  private static final String q = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_movie_default.png";
  private static final String r = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_sport_default.png";
  private static final String s = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_travel_default.png";
  private static final String t = "qzone";
  private static final String u = "wx";
  private static final String v = "wx_circle";
  int jdField_a_of_type_Int = -1;
  Handler jdField_a_of_type_AndroidOsHandler;
  DatingInfo jdField_a_of_type_ComTencentMobileqqDataDatingInfo;
  DatingDetailActivity jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  ActionSheetAdapter jdField_a_of_type_ComTencentWidgetActionSheetAdapter = null;
  ibz jdField_a_of_type_Ibz;
  protected StringBuilder a;
  boolean jdField_a_of_type_Boolean = false;
  String j;
  
  public DatingShareHelper(DatingDetailActivity paramDatingDetailActivity)
  {
    this.jdField_a_of_type_JavaLangStringBuilder = null;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity = paramDatingDetailActivity;
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject1;
    if (paramString.startsWith("mqqapi://dating/detail?"))
    {
      int i3 = paramString.indexOf("src_type=");
      int i1 = -1;
      if (i3 > 0)
      {
        int i2 = paramString.indexOf('&', i3);
        i1 = i2;
        if (i2 < 0)
        {
          i1 = paramString.length();
          localObject2 = null;
          localObject1 = localObject2;
          if (i3 > 0)
          {
            localObject1 = localObject2;
            if (i3 < i1) {
              localObject1 = paramString.substring(i3, i1);
            }
          }
          if ("src_type=internal".equals(localObject1))
          {
            localObject1 = paramString;
            label91:
            localObject2 = localObject1;
            if (((String)localObject1).contains("from_type=3")) {}
          }
        }
      }
    }
    for (Object localObject2 = (String)localObject1 + "&" + "from_type=3";; localObject2 = paramString)
    {
      DatingUtil.a("dealDatingShareSchemaForNative", new Object[] { paramString, localObject2 });
      return localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = paramString.replace((CharSequence)localObject1, "src_type=internal");
        break label91;
      }
      localObject1 = paramString + "&" + "src_type=internal";
      break label91;
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if ((paramInt <= 0) || (paramInt > 5)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    if ((paramContext == null) || (paramString == null) || (!paramString.startsWith("https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?"))) {
      return false;
    }
    for (;;)
    {
      String str;
      try
      {
        i1 = "https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?".length();
        i2 = paramString.indexOf("bid=", i1);
        if (i2 < i1) {
          break label260;
        }
        i2 += "bid=".length();
        i3 = paramString.indexOf('&', i2);
        if (i3 < i2) {
          continue;
        }
        str = paramString.substring(i2, i3);
        i2 = paramString.indexOf("subject=", i1);
        localObject1 = localObject2;
        if (i2 >= i1)
        {
          i1 = "subject=".length() + i2;
          i2 = paramString.indexOf('&', i1);
          if (i2 < i1) {
            continue;
          }
          localObject1 = paramString.substring(i1, i2);
        }
        if (str == null) {
          break label258;
        }
        i1 = str.length();
        if (i1 <= 0) {
          break label258;
        }
        if (localObject1 != null) {
          continue;
        }
        paramString = "";
        try
        {
          paramString = String.format("mqqapi://dating/detail?src_type=internal&from_type=3&version=1&from=1&dating_id=%s&subject=%s", new Object[] { str, paramString });
          localObject1 = new Intent(paramContext, JumpActivity.class);
          ((Intent)localObject1).setData(Uri.parse(paramString));
          ((Intent)localObject1).putExtra("from", "webview");
          paramContext.startActivity((Intent)localObject1);
          return true;
        }
        catch (Exception paramContext) {}
      }
      catch (Exception paramContext)
      {
        int i1;
        int i2;
        int i3;
        Object localObject1;
        bool = false;
        continue;
      }
      paramContext.printStackTrace();
      return bool;
      if (i3 < 0)
      {
        str = paramString.substring(i2);
        continue;
        localObject1 = localObject2;
        if (i2 < 0)
        {
          localObject1 = paramString.substring(i1);
          continue;
          paramString = (String)localObject1;
          continue;
          label258:
          return false;
        }
      }
      else
      {
        label260:
        str = null;
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet == null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject)
        {
        default: 
          this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369681));
          label85:
          if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject == 5) {
            this.jdField_a_of_type_JavaLangStringBuilder.append(", ").append(DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo));
          }
          break;
        }
      }
      for (;;)
      {
        return this.jdField_a_of_type_JavaLangStringBuilder.toString();
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        break;
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369681));
        break label85;
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369684));
        break label85;
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369682));
        break label85;
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369683));
        break label85;
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131369685));
        break label85;
        this.jdField_a_of_type_JavaLangStringBuilder.append(", ").append(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyName);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyZone)) {
          this.jdField_a_of_type_JavaLangStringBuilder.append("(").append(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyZone).append(")");
        }
      }
    }
    return "";
  }
  
  protected String a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null)
    {
      Object localObject;
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        String str = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname;
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.owner == 1)
        {
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app;
            localObject = ContactUtils.m((QQAppInterface)localObject, ((QQAppInterface)localObject).a());
          }
        }
        if ((!paramBoolean) || (localObject == null) || (((String)localObject).length() <= 8)) {
          break label144;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append(((String)localObject).substring(0, 8)).append("...");
        label110:
        if (!paramBoolean) {
          break label160;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("发布了一个约会");
      }
      for (;;)
      {
        return this.jdField_a_of_type_JavaLangStringBuilder.toString();
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        break;
        label144:
        if (localObject == null) {
          break label110;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append((String)localObject);
        break label110;
        label160:
        this.jdField_a_of_type_JavaLangStringBuilder.append("发布了一个约会，快来QQ约会围观报名吧！");
      }
    }
    return "";
  }
  
  public void a()
  {
    WXShareHelper.a().b(this);
    if (this.jdField_a_of_type_Ibz != null)
    {
      ThreadManager.a().removeCallbacks(this.jdField_a_of_type_Ibz);
      this.jdField_a_of_type_Ibz.a();
      this.jdField_a_of_type_Ibz = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity = null;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
  }
  
  protected void a(int paramInt, Bitmap paramBitmap)
  {
    boolean bool;
    label30:
    Object localObject;
    label47:
    String str1;
    if (paramInt == 2)
    {
      bool = true;
      WXShareHelper.a().a(this);
      this.j = String.valueOf(System.currentTimeMillis());
      if (!bool) {
        break label147;
      }
      paramInt = 0;
      String str2 = a(bool);
      if (!bool) {
        break label152;
      }
      localObject = a();
      String str3 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId;
      if (!bool) {
        break label159;
      }
      str1 = "wx";
      label64:
      str1 = String.format("https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?bid=%s&_wv=1025&adtag=%s&subject=%s", new Object[] { str3, str1, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject) });
      WXShareHelper.a().a(this.j, str2, paramBitmap, (String)localObject, str1, paramInt);
      this.jdField_a_of_type_Int = -1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity;
      if (!bool) {
        break label166;
      }
    }
    label147:
    label152:
    label159:
    label166:
    for (paramBitmap = "0X8004C9E";; paramBitmap = "0X8004C9F")
    {
      ((DatingDetailActivity)localObject).b(paramBitmap);
      return;
      bool = false;
      break;
      paramInt = 1;
      break label30;
      localObject = "";
      break label47;
      str1 = "wx_circle";
      break label64;
    }
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.j == null) || (!this.j.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 1, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131367819), 0).b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getTitleBarHeight());
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 2, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(2131367818), 0).b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getTitleBarHeight());
    }
  }
  
  public void a(DatingInfo paramDatingInfo)
  {
    if (this.jdField_a_of_type_Ibz != null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
        this.jdField_a_of_type_Int = -1;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null);
      paramDatingInfo = new ArrayList();
      int i1 = 0;
      while (i1 <= 3)
      {
        paramDatingInfo.add(ActionSheetAdapter.a(i1));
        i1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a(paramDatingInfo);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, this, this, this, true);
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void a(String paramString)
  {
    String str1 = a(true);
    String str2 = a();
    String str3 = String.format("https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?bid=%s&_wv=1025&adtag=%s&subject=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, "mqq", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject) });
    String str4 = String.format("mqqapi://dating/detail?src_type=internal&from_type=3&version=1&from=1&dating_id=%s&subject=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject) });
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(140);
      localStringBuilder.append("web_share").append("").append(paramString).append(str1).append(str2).append("约会 的分享").append(str3).append("web").append(str4).append("").append("").append("plugin").append("").append("").append("https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_icon_small.png").append("约会").append("");
      DatingUtil.a("shareToQQ", new Object[] { Integer.valueOf(localStringBuilder.length()), Integer.valueOf(paramString.length()) });
    }
    ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, 1001, 44, "web_share", "", paramString, str1, str2, "约会 的分享", str3, "web", str4, "", "", "plugin", "mqqapi://dating/feed?src_type=internal&from_type=3&version=1&from=1", "", "", "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_icon_small.png", "约会", "");
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004C9C");
  }
  
  protected void b(String paramString)
  {
    Object localObject = a(false);
    String str = String.format("https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?bid=%s&_wv=1025&adtag=%s&subject=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingId, "qzone", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject) });
    Bundle localBundle = new Bundle();
    localBundle.putString("title", (String)localObject);
    localBundle.putString("desc", "");
    localBundle.putString("detail_url", str);
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramString);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putLong("req_share_id", 0L);
    if (!QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, localBundle, null)) {
      QRUtils.a(1, 2131367964);
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.b("0X8004C9D");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_Int != paramMessage.arg1);
      if (this.jdField_a_of_type_Ibz != null)
      {
        this.jdField_a_of_type_Ibz.a();
        this.jdField_a_of_type_Ibz = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      a(paramMessage.arg1, (Bitmap)paramMessage.obj);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.e();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    } while (this.jdField_a_of_type_Ibz == null);
    ThreadManager.a().removeCallbacks(this.jdField_a_of_type_Ibz);
    this.jdField_a_of_type_Ibz.a();
    this.jdField_a_of_type_Ibz = null;
    return true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.jdField_a_of_type_ComTencentWidgetActionSheet)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = null;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i1 = 2130840249;
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131367829;
      }
    }
    for (;;)
    {
      label309:
      Object localObject;
      if (paramInt != -1)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.getTitleBarHeight());
        this.jdField_a_of_type_Int = -1;
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131367830;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.dating", 2, "doShare, datingInfo is null");
          return;
        }
        this.jdField_a_of_type_Int = ((int)paramLong);
        if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject == 5) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.placePicUrl;
        }
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
        case 1: 
          paramAdapterView = paramView;
          if (TextUtils.isEmpty(paramView)) {
            switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject)
            {
            default: 
              paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_dine_default.png";
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Int != 0) {
              break label309;
            }
            a(paramAdapterView);
            return;
            paramView = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.addressCompanyPicUrl;
            break;
            paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_dine_default.png";
            continue;
            paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_movie_default.png";
            continue;
            paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_ktvt_default.png";
            continue;
            paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_sport_default.png";
            continue;
            paramAdapterView = "https://3gimg.qq.com/qq_product_operations/playqq/dating/image/qq_mqq_travel_default.png";
          }
          b(paramAdapterView);
          return;
        }
        localObject = null;
        paramInt = i1;
        switch (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.datingSubject)
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          paramAdapterView = localObject;
          if (!TextUtils.isEmpty(paramView)) {}
          try
          {
            paramAdapterView = AbsDownloader.a(paramView);
            if (paramAdapterView == null) {
              break;
            }
            paramAdapterView = paramAdapterView.getAbsolutePath();
          }
          catch (Exception paramAdapterView)
          {
            for (;;)
            {
              paramAdapterView.printStackTrace();
              paramAdapterView = localObject;
              continue;
              paramAdapterView = null;
            }
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.a(0, "正处理，请稍等...", 500);
          this.jdField_a_of_type_Ibz = new ibz(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsHandler, paramAdapterView, paramInt);
          ThreadManager.a().post(this.jdField_a_of_type_Ibz);
          return;
          paramInt = 2130840255;
          continue;
          paramInt = 2130840252;
          continue;
          paramInt = 2130840258;
          continue;
          paramInt = 2130840261;
        }
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingShareHelper
 * JD-Core Version:    0.7.0.1
 */