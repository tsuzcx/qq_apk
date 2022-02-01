package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kqj;
import kqk;

public class QQSettingUtil
{
  public static int a = 0;
  public static final String a = "Setting_Quit";
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getApplicationContext().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("mywallet_flag", 1);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt)
  {
    if (paramResources == null) {
      return new SpannableString("");
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = new SpannableString("*");
      paramInt = (int)paramResources.getDimension(2131493009);
      paramResources = paramResources.getDrawable(2130840535);
      paramResources.setBounds(0, 0, paramInt, paramInt);
      ((SpannableString)localObject).setSpan(new ImageSpan(paramResources), 0, 1, 33);
      return localObject;
    }
    int k = paramInt / 64;
    paramInt %= 64;
    int m = paramInt / 16;
    int i1 = paramInt % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt = 0;
      localObject = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt = k;
        continue;
        localObject = "@";
        paramInt = m;
        continue;
        localObject = "#";
        paramInt = n;
        continue;
        localObject = "%";
        paramInt = i1 % 4;
      }
      i += 1;
    }
    if ((a > 1) && (str1.length() > a))
    {
      localObject = str1.substring(0, a - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      i = (int)paramResources.getDimension(2131493009);
      paramInt = 0;
      if (paramInt < str1.length())
      {
        String str2 = str1.substring(paramInt, paramInt + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130840533);
          label345:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label494;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt, paramInt + 1, 33);
          paramInt += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130840537);
            break label345;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130840534);
            break label345;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130840536);
            break label345;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130842127);
            break label345;
          }
          localObject = null;
          break label345;
          label494:
          ((Drawable)localObject).setBounds(0, 0, i, i);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseQQLevel, sLevel = " + str1 + ", span = " + localSpannableString);
      }
      return localSpannableString;
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4)
  {
    WeakReference localWeakReference = new WeakReference(paramView);
    SpannableString localSpannableString = new SpannableString("");
    paramView = null;
    int i = (int)paramResources.getDimension(2131493009);
    Drawable localDrawable;
    if ((paramBoolean1) && (paramInt > 0))
    {
      localSpannableString = new SpannableString("sb");
      paramView = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/svip_" + paramInt + ".png";
      localDrawable = paramResources.getDrawable(2130840538);
      paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
      paramView.setBounds(0, 0, (int)(68.0D * (i / 24.0D)), i);
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.mutate();
        ((URLDrawable)paramView).setURLDrawableListener(new kqk(localWeakReference));
        localSpannableString.setSpan(new ImageSpan(paramView), 0, 1, 33);
        paramView = paramResources.getDrawable(2130840540);
        paramView.setBounds(0, 0, (int)paramResources.getDimension(2131493010), i);
        localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseClubLevel, bSuperVipOpen=" + paramBoolean1 + ", bQQVipOpen=" + paramBoolean2 + ",iVipLevel=" + paramInt);
      }
      return localSpannableString;
      if ((paramBoolean2) && (paramInt > 0))
      {
        localSpannableString = new SpannableString("vb");
        paramView = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/vip_" + paramInt + ".png";
        localDrawable = paramResources.getDrawable(2130840539);
        paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
        paramView.setBounds(0, 0, (int)(58.0D * (i / 24.0D)), i);
      }
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 11L) {
      return "在线";
    }
    if (paramLong == 41L) {
      return "隐身";
    }
    if (paramLong == 31L) {
      return "离线";
    }
    return "";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    if (paramBoolean)
    {
      paramBoolean = false;
      localIntent.putExtra("tab_index", 1);
    }
    for (;;)
    {
      paramQQAppInterface.logout(paramBoolean);
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.evictAll();
      }
      int i = a(paramActivity, paramQQAppInterface.a());
      a(paramActivity, paramQQAppInterface.a(), i + 1);
      paramActivity.startActivityForResult(localIntent, 1000);
      if (QQPlayerService.a())
      {
        paramQQAppInterface = new Intent();
        paramQQAppInterface.setAction("qqplayer_exit_action");
        paramActivity.sendBroadcast(paramQQAppInterface);
      }
      return;
      paramBoolean = true;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt("setting_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(ImageView paramImageView, long paramLong)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "online status = " + paramLong);
      }
      if (paramLong == 11L)
      {
        paramImageView.setImageResource(2130841980);
        return;
      }
      if (paramLong == 41L)
      {
        paramImageView.setImageResource(2130841976);
        return;
      }
    } while (paramLong != 31L);
    paramImageView.setImageResource(2130841978);
  }
  
  public static void a(TextView paramTextView, BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag != null) && (paramAppInfo.iNewFlag.get() != 0)) {}
    int j;
    int i;
    switch (paramAppInfo.type.get())
    {
    case 3: 
    default: 
      j = 0;
      i = 0;
      paramAppInfo = localObject;
    }
    for (;;)
    {
      if (i == 1)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130840888, 0, 0, 0);
        paramTextView.setVisibility(0);
        paramTextView.setText("");
        paramTextView.setBackgroundResource(0);
        paramTextView.setPadding(0, 0, 0, 0);
        return;
        i = 2;
        j = 0;
        paramAppInfo = localObject;
        continue;
        j = 0;
        i = 1;
        paramAppInfo = localObject;
        continue;
        if (paramAppInfo.num != null) {}
        for (j = paramAppInfo.num.get();; j = 0)
        {
          if (j <= 0) {
            break label205;
          }
          i = 3;
          paramAppInfo = localObject;
          break;
        }
        paramQQAppInterface = (RedTouchManager)paramQQAppInterface.getManager(35);
        i = 5;
        paramAppInfo = paramQQAppInterface.a(paramAppInfo);
        j = 0;
      }
      else
      {
        CustomWidgetUtil.a(paramTextView, i, j, 0, 99, paramAppInfo);
        return;
        label205:
        i = 0;
        paramAppInfo = localObject;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a(new kqj(paramQQAppInterface));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramQQAppInterface.a();
    boolean bool = SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131366260), "qqsetting_auto_receive_pic_key", true);
    int i;
    Object localObject3;
    if (bool)
    {
      i = 1;
      ((Map)localObject1).put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject3 = (StatusManager)paramQQAppInterface.getManager(14);
      if (localObject3 != null)
      {
        bool = ((StatusManager)localObject3).b();
        if (!bool) {
          break label1102;
        }
        i = 1;
        label81:
        ((Map)localObject1).put("Clk_signature_qzone", Integer.valueOf(i));
        if (!ConfigHandler.a(paramQQAppInterface, false)) {
          break label1107;
        }
        i = 1;
        label105:
        ((Map)localObject1).put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131368414), "qqsetting_notify_icon_key", false)) {
          break label1112;
        }
        i = 1;
        label142:
        ((Map)localObject1).put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, paramQQAppInterface.a().getString(2131366308), "qqsetting_enter_sendmsg_key", false)) {
          break label1117;
        }
        i = 1;
        label181:
        ((Map)localObject1).put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, paramQQAppInterface.a(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label1122;
        }
        i = 1;
        label216:
        ((Map)localObject1).put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.p()) {
          break label1127;
        }
        i = 1;
        label239:
        ((Map)localObject1).put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.r()) {
          break label1132;
        }
        i = 1;
        label262:
        ((Map)localObject1).put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.b(true)) {
          break label1137;
        }
        i = 1;
        label286:
        ((Map)localObject1).put("Search_number", Integer.valueOf(i));
        if (!paramQQAppInterface.o()) {
          break label1142;
        }
        i = 1;
        label309:
        ((Map)localObject1).put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.q()) {
          break label1147;
        }
        i = 1;
        label332:
        ((Map)localObject1).put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.f() != 0) {
          break label1152;
        }
        i = 0;
        label355:
        if (i == 0) {
          break label1157;
        }
        i = 1;
        label361:
        ((Map)localObject1).put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.a()) != 2) {
          break label1162;
        }
        i = 1;
        label390:
        if (i == 0) {
          break label1167;
        }
        i = 1;
        label396:
        ((Map)localObject1).put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label1172;
        }
        i = 1;
        label430:
        ((Map)localObject1).put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.a()) != 2) {
          break label1177;
        }
        i = 1;
        label459:
        if (i == 0) {
          break label1182;
        }
        i = 1;
        label465:
        ((Map)localObject1).put("Setting_Gesture_password", Integer.valueOf(i));
        if (!TroopAssistantManager.a().a()) {
          break label1187;
        }
        i = 1;
        label490:
        ((Map)localObject1).put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!TroopAssistantManager.a().b()) {
          break label1192;
        }
        i = 1;
        label515:
        ((Map)localObject1).put("Clk_grp_heper_top", Integer.valueOf(i));
        localObject2 = ((Map)localObject1).keySet();
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", (String)localObject3, 0, 0, String.valueOf(((Map)localObject1).get(localObject3)), "", "", "");
          continue;
        }
        if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), null, paramQQAppInterface.a().getString(2131366269), "qqsetting_screenshot_key", false)) {
          break label1197;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.c(false)) {
          break label1202;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf(i), "", "", "");
        localObject1 = ((FriendsManager)paramQQAppInterface.getManager(49)).a(paramQQAppInterface.a());
        if (localObject1 != null)
        {
          if (!((Card)localObject1).allowPeopleSee) {
            break label1207;
          }
          i = 1;
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf(i), "", "", "");
        }
        if (!((DatingManager)paramQQAppInterface.getManager(67)).b()) {
          break label1212;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004956", "0X8004956", 0, 0, String.valueOf(i), "", "", "");
        if (!HotChatManager.b(paramQQAppInterface)) {
          break label1217;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004B1E", "0X8004B1E", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.d(false)) {
          break label1222;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.e(false)) {
          break label1227;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf(i), "", "", "");
        localObject3 = (FriendsManager)paramQQAppInterface.getManager(49);
        i = ((FriendsManager)localObject3).e();
        if (i <= 0) {
          break label1232;
        }
        localObject1 = "1";
        if (i > 0)
        {
          localObject2 = String.valueOf(i);
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, (String)localObject1, (String)localObject2, String.valueOf(((FriendsManager)localObject3).d()), "");
          if (((ActivateFriendsManager)paramQQAppInterface.getManager(80)).a(false))
          {
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, i, String.valueOf(i), "", "", "");
            if (!paramQQAppInterface.n) {
              continue;
            }
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf(i), "", "", "");
          }
        }
        else
        {
          localObject2 = "";
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      i = 0;
      break;
      label1102:
      i = 0;
      break label81;
      label1107:
      i = 0;
      break label105;
      label1112:
      i = 0;
      break label142;
      label1117:
      i = 0;
      break label181;
      label1122:
      i = 0;
      break label216;
      label1127:
      i = 0;
      break label239;
      label1132:
      i = 0;
      break label262;
      label1137:
      i = 0;
      break label286;
      label1142:
      i = 0;
      break label309;
      label1147:
      i = 0;
      break label332;
      label1152:
      i = 1;
      break label355;
      label1157:
      i = 0;
      break label361;
      label1162:
      i = 0;
      break label390;
      label1167:
      i = 0;
      break label396;
      label1172:
      i = 0;
      break label430;
      label1177:
      i = 0;
      break label459;
      label1182:
      i = 0;
      break label465;
      label1187:
      i = 0;
      break label490;
      label1192:
      i = 0;
      break label515;
      label1197:
      i = 0;
      continue;
      label1202:
      i = 0;
      continue;
      label1207:
      i = 0;
      continue;
      label1212:
      i = 0;
      continue;
      label1217:
      i = 0;
      continue;
      label1222:
      i = 0;
      continue;
      label1227:
      i = 0;
      continue;
      label1232:
      localObject1 = "0";
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.a()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      StatisticCollector.a(null).d(paramQQAppInterface, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil
 * JD-Core Version:    0.7.0.1
 */