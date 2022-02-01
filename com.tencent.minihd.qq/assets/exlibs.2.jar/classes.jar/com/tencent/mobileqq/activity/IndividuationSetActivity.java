package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.ADViewIndividuation;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eeq;
import eer;
import eet;
import eeu;
import eev;
import eew;
import eex;
import eey;
import eez;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationSetActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  private static final int jdField_i_of_type_Int = 1;
  private static final int jdField_j_of_type_Int = 2;
  private static final int jdField_k_of_type_Int = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static final int p = 6;
  private static final int q = 7;
  private static final int r = 8;
  private static final int s = 9;
  private static final int t = 10;
  private static final int u = 11;
  private static final int v = 0;
  private static final int w = 1;
  public float a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new eeq(this);
  private SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new eer(this);
  private UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  RedTouch jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_d_of_type_Boolean = false;
  View jdField_e_of_type_AndroidViewView;
  RedTouch jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_e_of_type_Boolean = false;
  View jdField_f_of_type_AndroidViewView;
  RedTouch jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_f_of_type_Boolean = false;
  View jdField_g_of_type_AndroidViewView;
  RedTouch jdField_g_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_g_of_type_Boolean = false;
  View jdField_h_of_type_AndroidViewView;
  RedTouch jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_h_of_type_Boolean = false;
  private View jdField_i_of_type_AndroidViewView;
  RedTouch jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_i_of_type_Boolean = false;
  RedTouch jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch;
  boolean jdField_j_of_type_Boolean = false;
  RedTouch jdField_k_of_type_ComTencentMobileqqRedtouchRedTouch;
  private boolean jdField_k_of_type_Boolean = false;
  
  private int a(int paramInt)
  {
    if (this.app == null) {
      return -1;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("100005.");
    if (paramInt == 1) {
      localStringBuilder.append(100002);
    }
    for (;;)
    {
      return localGameCenterManagerImp.a(localStringBuilder.toString());
      if (paramInt == 3) {
        localStringBuilder.append(100003);
      } else if (paramInt == 4) {
        localStringBuilder.append(100006);
      } else if (paramInt == 5) {
        localStringBuilder.append(100011);
      } else if (paramInt == 6) {
        localStringBuilder.append(100012);
      } else if (paramInt == 7) {
        localStringBuilder.append(100018);
      } else if (paramInt == 8) {
        localStringBuilder.append(100020);
      } else if (paramInt == 9) {
        localStringBuilder.append(100021);
      } else if (paramInt == 10) {
        localStringBuilder.append(100019);
      }
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return 1;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1.length < 3) || (paramString2.length < 3));
    int i2 = paramString1.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label93;
      }
      int i3 = Integer.valueOf(paramString1[i1]).intValue();
      int i4 = Integer.valueOf(paramString2[i1]).intValue();
      if (i3 > i4) {
        break;
      }
      if (i3 < i4) {
        return -1;
      }
      i1 += 1;
    }
    label93:
    return 0;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(int paramInt)
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.app.getManager(35)).a("100005." + paramInt);
      return localAppInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramInt = paramView.getId();
    }
    paramView = (RedTouchManager)this.app.getManager(35);
    if (paramInt == 2131297868)
    {
      paramView.b("100005.100002");
      if (!BaseApplicationImpl.jdField_a_of_type_Boolean) {
        Toast.makeText(this, getString(2131366715), 0).show();
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_theme_mall", 0, 0, "", "", "", "");
        return;
        if (Utils.e())
        {
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("updateFlag", this.jdField_a_of_type_Boolean);
          paramInt = b(6);
          if (paramInt != 0)
          {
            paramView.putExtra("updateFlag", true);
            paramView.putExtra("updateId", paramInt);
          }
          paramView.putExtra("individuation_url_type", 100);
          VasWebviewUtil.a(this, "https://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramView, true, 2);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Boolean = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a();
          a(a(100002), 1002);
        }
        else
        {
          Toast.makeText(this, getString(2131367289), 0).show();
        }
      }
    }
    if (paramInt == 2131297815)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006279", "0X8006279", 0, 0, "0", "", "", "");
      ChatBackground.a(this, this.app.getAccount(), true);
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370018, new eey(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370019, new eez(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(this.jdField_f_of_type_AndroidViewView, 0, 0, 0);
      return;
    }
    Object localObject;
    if (paramInt == 2131297823)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("updateFlag", this.jdField_c_of_type_Boolean);
      ((Intent)localObject).putExtra("individuation_url_type", 100);
      paramInt = b(2);
      if (paramInt != 0)
      {
        ((Intent)localObject).putExtra("updateFlag", true);
        ((Intent)localObject).putExtra("updateId", paramInt);
      }
      VasWebviewUtil.a(this, "https://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, (Intent)localObject, false, -1);
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = false;
      }
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100003), 1002);
      paramView.b("100005.100003");
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_bubble_mall", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131297840)
    {
      super.startActivity(new Intent(this, ChatTextSizeSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_font_size", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131297808)
    {
      paramView.b("100005.100001");
      a(a(100001), 1002);
      this.jdField_b_of_type_Boolean = false;
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_ep_mall", 52, 0, "", "", "", "");
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.app.getAccount(), 3, this.app.getSid());
      return;
    }
    if (paramInt == 2131297844)
    {
      if (!Utils.e())
      {
        Toast.makeText(super.getApplicationContext(), getString(2131367289), 0).show();
        return;
      }
      paramView.b("100005.100006");
      paramView = new Intent(this, AvatarPendantMarketActivity.class);
      paramView.putExtra("individuation_url_type", 100);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        paramView.putExtra("key_update_flag", true);
      }
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100006), 1002);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramInt = b(4);
      if (paramInt != 0)
      {
        paramView.putExtra("updateFlag", true);
        paramView.putExtra("updateId", paramInt);
      }
      paramView.putExtra("url", VasWebviewConstants.AVATAR_PENDANT_URL);
      paramView.putExtra("business", 512L);
      VasWebviewUtil.a(512L, paramView);
      paramView.putExtra("isShowAd", false);
      super.startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "AvatarClick", "TabClick", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "NativeEntrance", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131297831)
    {
      paramView.b("100005.100011");
      this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100011), 1002);
      paramView = new Intent(this, QQBrowserActivity.class);
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        paramView.putExtra("updateFlag", true);
      }
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("individuation_url_type", 100);
      paramInt = b(3);
      if (paramInt != 0)
      {
        paramView.putExtra("updateFlag", true);
        paramView.putExtra("updateId", paramInt);
      }
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.a(this, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, paramView, false, -1);
      ReportController.b(this.app, "CliOper", "", "", "Font_Mall", "enter_mall", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131297876)
    {
      paramView.b("100005.100012");
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100012), 1002);
      paramView = this.app.a();
      localObject = this.app.getSid();
      if (this.jdField_f_of_type_Boolean) {}
      for (paramInt = 0;; paramInt = 1)
      {
        ProfileCardUtil.a(this, paramView, "inside.myIndividuation", (String)localObject, paramInt, 2, 1);
        return;
      }
    }
    if (paramInt == 2131297884)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("hide_left_button", false);
      ((Intent)localObject).putExtra("show_right_close_button", false);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("individuation_url_type", 100);
      paramInt = b(8);
      if (paramInt != 0)
      {
        ((Intent)localObject).putExtra("updateFlag", true);
        ((Intent)localObject).putExtra("updateId", paramInt);
      }
      VasWebviewUtil.a(this, VasWebviewConstants.PERSONALITY_QQ_SUIT_URL, 262144L, (Intent)localObject, false, -1);
      paramView.b("100005.100020");
      this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100020), 1002);
      ReportController.b(this.app, "CliOper", "", "", "gxsuit", "Enter_gxsuit_tab", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131297852)
    {
      paramView.b("100005.100018");
      this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      a(a(100018), 1002);
      paramInt = ((SVIPHandler)this.app.a(12)).f();
      if (paramInt == 2) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramView = new Intent(this, QQBrowserActivity.class);
      if (this.jdField_g_of_type_Boolean)
      {
        paramView.putExtra("updateFlag", true);
        this.jdField_g_of_type_Boolean = false;
      }
      paramView.putExtra("individuation_url_type", 100);
      VasWebviewUtil.a(this, VasWebviewConstants.PERSONALITY_QQ_COLOR_RING_URL, 4194304L, paramView, true, -1);
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1E", "0X8004A1E", 0, 0, "" + paramInt, "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004FFF", "0X8004FFF", 0, 0, "" + paramInt, "", "", "");
      return;
      if (paramInt == 3)
      {
        paramInt = 2;
        continue;
        if (paramInt != 2131297860) {
          break;
        }
        paramView.b("100005.100019");
        this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch.a();
        a(a(100019), 1002);
        paramInt = ((SVIPHandler)this.app.a(12)).f();
        if (paramInt == 2) {}
        for (;;)
        {
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("hide_left_button", false);
          paramView.putExtra("show_right_close_button", false);
          paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramView.putExtra("individuation_url_type", 100);
          VasWebviewUtil.a(this, VasWebviewConstants.PERSONALITY_FUNCALL_URL.replace("[src]", String.valueOf(1)).replace("[uin]", this.app.a()), 524288L, paramView, false, -1);
          VipUtils.a(this.app, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 1, 0, new String[0]);
          return;
          if (paramInt != 3) {}
        }
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      ((RedTouchManager)this.app.getManager(35)).b(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840888);
      }
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
      if (localURLDrawable != null)
      {
        int i1 = (int)(35.0F * this.jdField_a_of_type_Float);
        localURLDrawable.setBounds(0, 0, i1, i1);
        paramImageView.setImageDrawable(localURLDrawable);
        paramImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "red icon load fail, iconUrl=" + paramString);
      }
      paramImageView.setImageDrawable(getResources().getDrawable(2130840888));
      paramImageView.setVisibility(0);
      localException.printStackTrace();
    }
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return 0;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramInt == ((Bundle)this.jdField_a_of_type_JavaUtilList.get(i1)).getInt("bizType")) {
          return ((Bundle)this.jdField_a_of_type_JavaUtilList.get(i1)).getInt("newId");
        }
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    JSONArray localJSONArray = ClubContentJsonTask.a(this.app.getApplication().getApplicationContext());
    int i2;
    int i1;
    int i3;
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      Drawable localDrawable = super.getResources().getDrawable(2130838176);
      localDrawable.mutate().setAlpha(0);
      ADViewIndividuation localADViewIndividuation = (ADViewIndividuation)super.findViewById(2131297804);
      localADViewIndividuation.setCircle(false);
      i2 = 0;
      i1 = 0;
      if (i2 < localJSONArray.length()) {
        for (;;)
        {
          Object localObject2;
          try
          {
            JSONObject localJSONObject = (JSONObject)localJSONArray.get(i2);
            if (localJSONObject == null) {
              break;
            }
            if ((localJSONObject.has("verStart")) && (localJSONObject.has("verEnd")))
            {
              i3 = i1;
              if (a("5.9.3", localJSONObject.getString("verStart")) < 0) {
                break label623;
              }
              if (a("5.9.3", localJSONObject.getString("verEnd")) > 0)
              {
                i3 = i1;
                break label623;
              }
            }
            Object localObject1 = AppConstants.bX + localJSONObject.getString("img");
            Object localObject3 = URLDrawable.getDrawable(new URL("profile_img_icon", ClubContentJsonTask.b.c + localJSONObject.getString("img"), (String)localObject1), localDrawable, localDrawable);
            localObject1 = (FrameLayout)getLayoutInflater().inflate(2130904085, null);
            localObject2 = (URLImageView)((FrameLayout)localObject1).findViewById(2131298166);
            ((URLImageView)localObject2).setContentDescription(localJSONObject.getString("title"));
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setImageDrawable((Drawable)localObject3);
            if (((URLDrawable)localObject3).getStatus() == 1)
            {
              localObject2 = (FrameLayout.LayoutParams)((URLImageView)localObject2).getLayoutParams();
              float f1 = ((URLDrawable)localObject3).getIntrinsicHeight() / ((URLDrawable)localObject3).getIntrinsicWidth();
              localObject3 = new DisplayMetrics();
              getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
              ((FrameLayout.LayoutParams)localObject2).height = ((int)(f1 * ((DisplayMetrics)localObject3).widthPixels + 0.5F));
              localJSONObject.put("bannerId", String.valueOf(i1));
              localObject2 = (ImageView)((FrameLayout)localObject1).findViewById(2131298167);
              ((ImageView)localObject2).setTag(localJSONObject);
              ((ImageView)localObject2).setOnClickListener(new eev(this));
              localADViewIndividuation.a((View)localObject1, i1);
              i1 += 1;
              break;
            }
            if (i1 > 0)
            {
              localObject3 = new ProgressBar(this);
              ((ProgressBar)localObject3).setId(2131296320);
              ((ProgressBar)localObject3).setIndeterminateDrawable(getResources().getDrawable(2130838130));
              i3 = AIOUtils.a(16.0F, getResources());
              FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i3, i3);
              localLayoutParams.gravity = 17;
              ((FrameLayout)localObject1).addView((View)localObject3, localLayoutParams);
              ((URLImageView)localObject2).setTag(localObject3);
              ((URLImageView)localObject2).setURLDrawableDownListener(new eeu(this));
              continue;
            }
            ((FrameLayout.LayoutParams)((URLImageView)localObject2).getLayoutParams()).height = 1;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("IndividualShowBanner", 2, "IndividualShowBanner error:" + localException.getMessage());
            }
            localException.printStackTrace();
            i3 = i1;
          }
          localADViewIndividuation.setNavVisible(-1, true);
          ((URLImageView)localObject2).setTag(localADViewIndividuation);
        }
      }
    }
    a();
    return;
    for (;;)
    {
      label623:
      i2 += 1;
      i1 = i3;
      break;
      i3 = i1;
    }
  }
  
  private void d()
  {
    a(1);
    a(3);
    a(2);
    a(4);
    a(5);
    a(6);
    a(7);
    a(8);
    a(9);
    a(10);
    a(11);
  }
  
  private void e()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
    if (localGameCenterManagerImp != null) {}
    for (int i1 = localGameCenterManagerImp.a("100005");; i1 = -1)
    {
      if (i1 != -1) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          BusinessInfoCheckUpdateItem.a(this.app, "100005", false);
        }
        return;
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    int i2;
    do
    {
      return;
      i2 = 0;
    } while (i2 >= this.jdField_a_of_type_JavaUtilList.size());
    int i1;
    switch (((Bundle)this.jdField_a_of_type_JavaUtilList.get(i2)).getInt("bizType"))
    {
    default: 
      i1 = -1;
    }
    for (;;)
    {
      if (i1 != -1)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(i1);
        ImageView localImageView = new ImageView(this);
        localImageView.setImageDrawable(getResources().getDrawable(2130840717));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(10, -1);
        localRelativeLayout.addView(localImageView, localLayoutParams);
      }
      i2 += 1;
      break;
      i1 = 2131297808;
      continue;
      i1 = 2131297823;
      continue;
      i1 = 2131297831;
      continue;
      i1 = 2131297844;
      continue;
      i1 = 2131297815;
      continue;
      i1 = 2131297868;
      continue;
      i1 = 2131297876;
      continue;
      i1 = 2131297884;
    }
  }
  
  public void a()
  {
    TextView localTextView = (TextView)super.findViewById(2131297806);
    Button localButton = (Button)super.findViewById(2131297807);
    String str4 = this.app.a();
    Object localObject = getSharedPreferences("uniPaySp_" + str4, 0);
    String str5 = ((SharedPreferences)localObject).getString("sUin", "");
    int i1 = ((SharedPreferences)localObject).getInt("isShowOpen", 0);
    int i2 = ((SharedPreferences)localObject).getInt("iUinpPayType", 0);
    QQAppInterface localQQAppInterface = (QQAppInterface)super.getAppRuntime();
    String str2 = "LTMCLUB";
    String str1 = "QQ会员";
    int i3 = Integer.valueOf(((SharedPreferences)localObject).getString("open_month", "3")).intValue();
    String str3 = str1;
    localObject = str2;
    if (str5 != null)
    {
      str3 = str1;
      localObject = str2;
      if (str4 != null)
      {
        str3 = str1;
        localObject = str2;
        if (str5.equals(str4))
        {
          if (i1 != 1) {
            break label529;
          }
          localButton.setVisibility(0);
          switch (i2)
          {
          default: 
            localButton.setVisibility(8);
          }
        }
      }
    }
    for (;;)
    {
      a(localTextView, localButton);
      localObject = str2;
      str3 = str1;
      localButton.setOnClickListener(new eew(this, localQQAppInterface, i3, str3, (String)localObject));
      return;
      localButton.setText(2131369067);
      localTextView.setText(2131368592);
      continue;
      localButton.setText(2131367660);
      localTextView.setText(2131368592);
      continue;
      localButton.setText(2131369068);
      localTextView.setText(2131368593);
      str2 = "CJCLUBT";
      str1 = "超级会员";
      continue;
      localButton.setText(2131367661);
      localTextView.setText(2131368593);
      str2 = "CJCLUBT";
      str1 = "超级会员";
      continue;
      localButton.setText(2131367663);
      localTextView.setText(2131368596);
      str2 = "CJCLUBT";
      str1 = "超级会员";
      continue;
      localButton.setText(2131367666);
      localTextView.setText(2131368596);
      str2 = "CJCLUBT";
      str1 = "超级会员";
      continue;
      localButton.setText(2131367664);
      localTextView.setText(2131368593);
      str2 = "CJCLUBT";
      str1 = "超级会员";
      continue;
      localButton.setText(2131367662);
      localTextView.setText(2131368595);
      str2 = "LTMCLUB";
      str1 = "QQ会员";
      continue;
      localButton.setText(2131367665);
      localTextView.setText(2131368595);
      str2 = "LTMCLUB";
      str1 = "QQ会员";
      continue;
      label529:
      localButton.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.app.a();
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    ((FriendsManagerImp)this.app.getManager(8)).a((String)localObject);
    if (paramInt != 2) {
      a(paramInt);
    }
    if (paramInt == 1)
    {
      localObject = a(100002);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
      a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = a(100001);
          this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
          a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
          return;
        }
        if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.e();
          localObject = (BubbleManager)this.app.getManager(43);
          localObject = a(100003);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
          a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
          return;
        }
        if (paramInt == 4)
        {
          localObject = a(100006);
          this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
          a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
          return;
        }
      } while (paramInt == 5);
      if (paramInt == 6)
      {
        localObject = a(100012);
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
        return;
      }
      if (paramInt == 7)
      {
        localObject = a(100018);
        this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
        return;
      }
      if (paramInt == 8)
      {
        localObject = a(100020);
        this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
        return;
      }
      if (paramInt == 10)
      {
        localObject = a(100019);
        this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
        return;
      }
    } while ((paramInt == 9) || (paramInt != 11));
    localObject = a(100022);
    this.jdField_k_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
    a((BusinessInfoCheckUpdate.AppInfo)localObject, 1001);
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(55 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void b()
  {
    c();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131297876));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131297868));
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131297815);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297823);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297840));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297808);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297884);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131297844);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131297852);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131297831);
    this.jdField_h_of_type_AndroidViewView = super.findViewById(2131297860);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidViewView.setContentDescription("趣味来电");
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_AndroidViewViewGroup).d(40).a();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    int i1 = (int)getResources().getDimension(2131493518);
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidViewView, false).c(i1).a();
    this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidViewViewGroup, false).c(i1).a();
    this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_AndroidViewView, false).c(i1).a();
    this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_d_of_type_AndroidViewView, false).c(i1).a();
    this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_e_of_type_AndroidViewView).d(40).a();
    this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    this.jdField_g_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_f_of_type_AndroidViewView).d(40).a();
    this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidViewView).d(40).a();
    this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_g_of_type_AndroidViewView).d(40).a();
    this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_h_of_type_AndroidViewView).d(40).a();
    this.jdField_j_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    this.jdField_k_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.rightViewText).a(53).a();
    this.jdField_k_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
    this.jdField_i_of_type_AndroidViewView = super.findViewById(2131297817);
    f();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = -1;
    if (paramInt1 == 4001) {
      EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.app.a(), paramIntent);
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) && (paramInt1 != 2)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
      a(1);
      return;
    } while ((paramInt1 != 4) || (paramIntent == null) || (!"IndividuationVIP".equals(paramIntent.getStringExtra("callbackSn"))));
    paramIntent = paramIntent.getStringExtra("result");
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramIntent);
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          try
          {
            paramInt2 = Integer.parseInt(localJSONObject.getString("resultCode"));
          }
          catch (JSONException paramIntent)
          {
            JSONObject localJSONObject;
            int i2;
            paramInt1 = -1;
            paramInt2 = -1;
            continue;
          }
          try
          {
            paramInt1 = Integer.parseInt(localJSONObject.getString("payState"));
          }
          catch (JSONException paramIntent)
          {
            paramInt1 = -1;
            continue;
          }
          try
          {
            i2 = Integer.parseInt(localJSONObject.getString("provideState"));
            i1 = i2;
            if ((localJSONObject == null) || (paramInt2 != 0) || (paramInt1 != 0) || (i1 != 0)) {
              break;
            }
            ((UniPayHandler)this.app.a(46)).a("");
            return;
          }
          catch (JSONException paramIntent) {}
        }
        paramIntent = paramIntent;
        paramInt2 = -1;
        localJSONObject = null;
        paramInt1 = -1;
      }
      paramIntent.printStackTrace();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    super.setContentView(2130903348);
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.a(12));
    this.jdField_a_of_type_JavaUtilList = ClubContentJsonTask.a(this.app.getApplication().getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.a(46));
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
    b();
    super.setTitle(2131366556);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d();
    this.jdField_k_of_type_Boolean = false;
    Object localObject;
    if (this.app != null)
    {
      localObject = (WebProcessManager)this.app.getManager(12);
      if ((localObject != null) && (!WebProcessManager.c()))
      {
        this.jdField_k_of_type_Boolean = true;
        ((WebProcessManager)localObject).e();
        ThreadManager.b(new eet(this));
      }
      localObject = (TextView)findViewById(2131297125);
      if (localObject != null)
      {
        if (!ChatBackground.a(this, this.app.getAccount(), null)) {
          break label138;
        }
        i1 = 2131370020;
        ((TextView)localObject).setText(i1);
      }
      if (this.jdField_i_of_type_AndroidViewView != null)
      {
        localObject = this.jdField_i_of_type_AndroidViewView;
        if (!ChatBackground.a(this, this.app.getAccount(), true)) {
          break label145;
        }
      }
    }
    label138:
    label145:
    for (int i1 = 8;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      return;
      i1 = 2131370018;
      break;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_k_of_type_Boolean) && (this.app != null) && ((WebProcessManager)this.app.getManager(12) != null) && (WebProcessManager.c())) {
      ThreadManager.b(new eex(this));
    }
    a(paramView, -1);
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131366374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.IndividuationSetActivity
 * JD-Core Version:    0.7.0.1
 */