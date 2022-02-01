package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.game.LauchGameAppListHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webviewplugin.WebViewPluginConfig;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.UpScrollHideView;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import dlg;
import dli;
import dlk;
import dll;
import dlm;
import dln;
import dlo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils
{
  public static final long a = 55901189L;
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  private static QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public static QQToastNotifier a;
  public static final String a = "ChatActivityUtils";
  private static LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final long b = 2274034950L;
  public static final String b = "https://m.qzone.com";
  public static final long c = 2223703302L;
  public static final String c = "https://mobile.qzone.qq.com";
  public static final long d = 274201605L;
  public static final String d = "https://gamecenter.qq.com";
  public static final long e = 440495416L;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903137, null);
    View localView = paramContext.findViewById(2131297039);
    ((TextView)paramContext.findViewById(2131297041)).setOnClickListener(paramOnClickListener);
    localView.setOnClickListener(paramOnClickListener);
    localView.setFocusable(true);
    return paramContext;
  }
  
  public static View a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener, UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903164, null);
    UpScrollHideView localUpScrollHideView = (UpScrollHideView)paramContext.findViewById(2131297039);
    TextView localTextView = (TextView)localUpScrollHideView.findViewById(2131297041);
    Button localButton = (Button)localUpScrollHideView.findViewById(2131297168);
    if (paramString1 != null) {
      localTextView.setText(paramString1);
    }
    if (paramString2 != null) {
      localButton.setText(paramString2);
    }
    localButton.setOnClickListener(paramOnClickListener);
    localUpScrollHideView.setOnViewHideListener(paramonViewHideListener);
    localUpScrollHideView.setFocusable(true);
    return paramContext;
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    MessageRecord localMessageRecord;
    if ((i == -1003) || (i == -1031) || (i == -1032) || (i == -3001)) {
      localMessageRecord = null;
    }
    do
    {
      return localMessageRecord;
      localMessageRecord = paramMessageRecord;
    } while (!((FriendManager)paramQQAppInterface.getManager(8)).b(paramMessageRecord.frienduin));
    return null;
  }
  
  public static MessageRecord a(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if ((paramSessionInfo.isSend()) || (MsgProxyUtils.g(paramSessionInfo.msgtype))) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (MessageUtils.a(paramMessageRecord.msgtype))) {
        break label512;
      }
      if (1000 == i)
      {
        paramQQAppInterface = ContactUtils.k(paramQQAppInterface, (String)localObject1);
        localObject1 = String.format(paramContext.getString(2131368299), new Object[] { paramSessionInfo.d, paramQQAppInterface });
      }
    }
    else
    {
      return localObject1;
    }
    if (1020 == i)
    {
      localObject1 = ((FriendManager)paramQQAppInterface.getManager(8)).b((String)localObject1);
      if (localObject1 != null)
      {
        paramQQAppInterface = ((OpenTroopInfo)localObject1).troopName;
        paramQQAppInterface = String.format(paramContext.getString(2131368299), new Object[] { paramSessionInfo.d, paramQQAppInterface });
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(58)).b(paramMessageRecord.senderuin);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.name;
        paramQQAppInterface = String.format(paramContext.getString(2131368300), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        continue;
        if (1004 == i)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject1, 3000);
          return String.format(paramContext.getString(2131368301), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        }
        if (1001 == i) {
          return String.format(paramContext.getString(2131368302), new Object[] { paramSessionInfo.d });
        }
        if (1006 == i) {
          return String.format(paramContext.getString(2131368303), new Object[] { paramSessionInfo.d });
        }
        if (1009 == i) {
          return String.format(paramContext.getString(2131368305), new Object[] { paramSessionInfo.d });
        }
        if (1005 == i) {
          return String.format(paramContext.getString(2131368306), new Object[] { paramSessionInfo.d });
        }
        if (1021 == i) {
          return String.format(paramContext.getString(2131368307), new Object[] { paramSessionInfo.d });
        }
        if (1022 == i) {
          return String.format(paramContext.getString(2131368308), new Object[] { paramSessionInfo.d });
        }
        if (1023 == i) {
          return String.format(paramContext.getString(2131368309), new Object[] { paramSessionInfo.d });
        }
        if (1010 == i) {
          return ((DatingManager)paramQQAppInterface.getManager(67)).a(paramSessionInfo.d);
        }
        localObject1 = localObject2;
        if (1025 != i) {
          break;
        }
        return String.format(paramContext.getString(2131368312), new Object[] { paramSessionInfo.d });
        label512:
        localObject1 = localObject2;
        if (1006 != i) {
          break;
        }
        paramSessionInfo = String.format(paramContext.getString(2131368304), new Object[] { paramSessionInfo.d });
        paramQQAppInterface = paramContext.getString(2131368310);
        if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
          jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131427483));
        }
        i = paramSessionInfo.lastIndexOf(paramQQAppInterface);
        paramContext = new SpannableStringBuilder(paramSessionInfo);
        paramContext.setSpan(jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan, i, paramQQAppInterface.length() + i, 33);
        return paramContext;
      }
      paramQQAppInterface = null;
    }
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return (Integer)jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1 + paramString2);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 1000: 
      return "2";
    }
    return "3";
  }
  
  public static String a(Context paramContext)
  {
    String str = paramContext.getString(2131366294);
    switch (paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      return str;
    case 1: 
      return paramContext.getString(2131366295);
    case 2: 
      return paramContext.getString(2131366296);
    }
    return paramContext.getString(2131366297);
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(50)).a(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131368313);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.troopname)) {
        return paramContext.getString(2131368313);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131368314), new Object[] { paramQQAppInterface.troopname });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131368313);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord != null) {}
    switch (paramMessageRecord.istroop)
    {
    case 1002: 
    case 1003: 
    case 1007: 
    case 1008: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1024: 
    default: 
      paramMessageRecord = null;
    }
    do
    {
      do
      {
        return paramMessageRecord;
        try
        {
          paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(50);
          paramMessageRecord = paramQQAppInterface.a(paramQQAppInterface.d(paramMessageRecord.senderuin));
          if (paramMessageRecord == null) {
            return paramContext.getString(2131368313);
          }
          if (TextUtils.isEmpty(paramMessageRecord.troopname)) {
            return paramContext.getString(2131368313);
          }
          paramMessageRecord = String.format(paramContext.getString(2131368314), new Object[] { paramMessageRecord.troopname });
          return paramMessageRecord;
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramContext = paramContext.getString(2131368313);
          paramMessageRecord = paramContext;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatActivityUtils", 2, "UIN_TYPE_OPEN_TROOP_MEMBER_STRANGER or UIN_TYPE_GROUP_MEMBER_STRANGER error");
      return paramContext;
      return paramContext.getString(2131368316);
      return paramContext.getString(2131368317);
      return paramContext.getString(2131368318);
      return paramContext.getString(2131368319);
      return paramContext.getString(2131368320);
      return paramContext.getString(2131368321);
      return paramContext.getString(2131368322);
      return paramContext.getString(2131368323);
      return paramContext.getString(2131368324);
      paramQQAppInterface = ((BaseActivity)paramContext).getAppRuntime();
      if (!(paramQQAppInterface instanceof QQAppInterface)) {
        break;
      }
      paramQQAppInterface = ((QQAppInterface)paramQQAppInterface).a().a(paramMessageRecord.frienduin);
      paramMessageRecord = paramQQAppInterface;
    } while (TextUtils.isEmpty(paramQQAppInterface));
    return String.format(paramContext.getString(2131368325), new Object[] { paramQQAppInterface });
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      paramString = a(arrayOfByte, a(paramQQAppInterface.a() + "MasPlay", 32).getBytes("UTF-8"));
      paramQQAppInterface = localObject;
      if (paramString != null) {
        paramQQAppInterface = new String(paramString, "UTF-8").replace("$", "");
      }
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    if (paramInt == 16) {
      return a(localMessageDigest.digest(paramString.getBytes("utf-8"))).substring(8, 24);
    }
    return a(localMessageDigest.digest(paramString.getBytes("utf-8")));
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j >>> 4)]);
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j % 16)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492923));
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131366988);
        }
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    int i = 3008;
    int k = 0;
    int j = k;
    ChatActivity localChatActivity;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i = 10004;
      j = k;
    case 1005: 
    case 1023: 
      if ((i == 3007) && ((paramActivity instanceof ChatActivity)))
      {
        localChatActivity = (ChatActivity)paramActivity;
        if (LBSHandler.a(localChatActivity.a(), paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label298;
        }
        localChatActivity.a().g(localChatActivity.getString(2131369575));
      }
      break;
    }
    label298:
    do
    {
      return;
      i = 3007;
      j = k;
      break;
      i = 3013;
      j = k;
      break;
      i = 3006;
      j = k;
      break;
      i = 3004;
      j = k;
      break;
      i = 3005;
      j = k;
      break;
      i = 3003;
      j = 2;
      break;
      i = 3019;
      j = k;
      break;
      if ((i == 3019) && ((paramActivity instanceof ChatActivity)))
      {
        localChatActivity = (ChatActivity)paramActivity;
        if (!DatingUtil.a(localChatActivity.a(), paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localChatActivity.a().g(localChatActivity.getString(2131369575));
          return;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
        break label354;
      }
    } while ((paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString.length() <= 0));
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, i, j, paramSessionInfo.d, null, null, paramString));
    return;
    label354:
    if (paramBoolean)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, null, i, j, paramSessionInfo.d, null, AddContactsActivity.class.getName(), paramString));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, i, j, paramSessionInfo.d, null, null, paramString), 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131367041, 1);
      return;
    }
    b(paramActivity, 2131367040, 1);
  }
  
  public static void a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131366106));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131427485), paramContext.getResources().getColor(2131427486)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(paramContext, paramContext.getString(2131366105), localSpannableString, 0, 2131366373, null, null, new dlm(paramContext)).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(paramContext);
    }
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt, paramContext.getResources().getDimensionPixelSize(2131492923), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131492923));
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, ChatBackgroundMarketActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("url", VasWebviewConstants.CHAT_BACKGROUND_URL);
    String str = String.valueOf(33554432L);
    if (WebViewPluginConfig.a.containsKey(str)) {
      localIntent.putExtra("insertPluginsArray", new String[] { str });
    }
    localIntent.putExtra("business", 33554432L);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("friendUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.a().a(AppShareIDUtil.a(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (PackageUtil.a(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = AppShareIDUtil.b(paramLong);
      Object localObject1 = paramQQAppInterface.a().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        PackageUtil.a(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("https://gamecenter.qq.com")))) {
          break label205;
        }
      }
      label205:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
        }
        return;
        localObject1 = ((OpenID)localObject1).openID;
        break;
      }
    }
    a(paramContext, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "appShareOnClick action:" + paramString + ",appShareId:" + paramLong + "mixType:" + paramInt);
    }
    String str = paramString.trim();
    if ((paramInt == -3005) || (paramInt == -3004) || (str.startsWith("https://gamecenter.qq.com"))) {}
    for (paramInt = 1; 55901189L == paramLong; paramInt = 0)
    {
      paramString = QZoneHelper.UserInfo.a();
      paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      paramString.b = paramQQAppInterface.c();
      paramString.c = paramQQAppInterface.getSid();
      QZoneHelper.a((Activity)paramContext, paramString, str, "mqqChat", -1);
      if (paramInt == 0) {
        break label416;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      return;
    }
    int i;
    label211:
    label224:
    Intent localIntent;
    if ((str.startsWith("https://m.qzone.com")) || (str.startsWith("https://mobile.qzone.qq.com")))
    {
      i = 1;
      if ((paramInt == 0) && (i == 0)) {
        break label410;
      }
      i = 1;
      localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = HtmlOffline.a(str, "from=androidqq");
      if (i == 0) {
        break label444;
      }
      paramString = HtmlOffline.a(str, "sid=" + paramQQAppInterface.getSid());
    }
    label410:
    label416:
    label444:
    for (;;)
    {
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        paramString = HtmlOffline.a(str, "platformId=qq_m");
      }
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("url", paramString.trim());
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", paramLong);
      paramString = paramString.toString();
      if (paramString.startsWith("https://browserApp.p.qq.com/"))
      {
        localIntent.putExtra("url", paramString);
        localIntent.setClass(paramContext, PublicAccountBrowser.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
      }
      paramContext.startActivity(localIntent);
      break;
      i = 0;
      break label211;
      i = 0;
      break label224;
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(AppShareIDUtil.b(paramLong)));
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    Dialog localDialog = new Dialog(paramContext, 2131558955);
    Handler localHandler = new Handler();
    View localView = LayoutInflater.from(paramContext).inflate(2130903087, null);
    dli localdli = new dli(localDialog);
    localView.setOnClickListener(new dlk(localHandler, localdli));
    TextView localTextView = (TextView)localView.findViewById(2131296765);
    ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).topMargin = paramContext.getResources().getDimensionPixelSize(2131492923);
    localTextView.setText(paramString);
    paramContext = new AlphaAnimation(0.1F, 0.9F);
    paramContext.setDuration(500L);
    paramContext.setAnimationListener(new dll(localHandler, localdli, paramLong));
    localTextView.startAnimation(paramContext);
    localDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    if ((paramIntent != null) && (paramSessionInfo != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {}
      }
    }
    label277:
    label289:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
      try
      {
        l = Long.parseLong(paramString1);
        if (l > 0L)
        {
          if (!paramBoolean)
          {
            paramBoolean = bool;
            paramQQAppInterface.a(l, paramBoolean);
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          l = 0L;
          continue;
          paramBoolean = false;
        }
      }
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
      String str = paramString1;
      if (localShieldMsgManger != null)
      {
        str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 != null) {}
        }
      }
      for (;;)
      {
        try
        {
          str = ContactUtils.d(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean)
          {
            paramString1 = str;
            localShieldMsgManger.b(paramInt, paramString2);
            i = 1;
            if (paramInt == 1001)
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean) {
                  break label277;
                }
                paramQQAppInterface.a().b(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label289;
            }
            a(paramActivity);
            return;
          }
          paramString1 = str;
          localShieldMsgManger.a(paramInt, paramString2);
          continue;
          int i = 0;
        }
        catch (NumberFormatException paramString2)
        {
          str = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.e("ChatActivityUtils", 2, "shieldMsg", paramString2);
            str = paramString1;
          }
        }
        continue;
        paramQQAppInterface.a().a(str);
      }
      if (paramBoolean)
      {
        b(paramActivity, 2131367041, 1);
        return;
      }
      b(paramActivity, 2131367040, 1);
      return;
    }
    b(paramActivity, 2131365730, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    LauchGameAppListHelper.a(paramQQAppInterface, paramActivity, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, Intent paramIntent, String paramString)
  {
    paramQQAppInterface = null;
    paramIntent = null;
    if (paramInt == 1)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      paramQQAppInterface = paramIntent;
      if (!((String)localObject).equalsIgnoreCase(""))
      {
        com.tencent.mobileqq.activity.aio.PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
        paramQQAppInterface = Uri.fromFile(new File((String)localObject));
      }
      PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
      if (paramQQAppInterface == null) {
        return;
      }
      paramIntent = ImageUtil.c(paramActivity, paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "enterPhotoPreivew str =  " + paramIntent);
      }
      ImageUtil.a(paramActivity, paramIntent);
      if (paramIntent != null)
      {
        if (!FileUtils.e(paramIntent))
        {
          QQToast.a(paramActivity, paramActivity.getString(2131367034), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
          return;
        }
        paramQQAppInterface = paramIntent;
        if (!new File(paramIntent).exists()) {
          QQToast.a(paramActivity, paramActivity.getString(2131367035), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
        }
      }
      else
      {
        QQToast.a(paramActivity, paramActivity.getString(2131367035), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
        return;
      }
    }
    paramIntent = new Intent();
    Object localObject = new ArrayList();
    paramIntent.setClass(paramActivity, CameraPreviewActivity.class);
    ((ArrayList)localObject).add(paramQQAppInterface);
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    if (paramSessionInfo.jdField_a_of_type_Int == 9501)
    {
      paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      paramIntent.putExtra(AlbumConstants.i, 82);
      paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      if ((paramString != null) && (paramString.equals("callFromFastImage"))) {
        paramIntent.putExtra("callFromFastImage", true);
      }
      paramActivity.startActivity(paramIntent);
      return;
      paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent, int paramInt)
  {
    Uri localUri = paramIntent.getData();
    if (paramIntent.getExtras() != null) {}
    for (boolean bool = paramIntent.getExtras().getBoolean("normal");; bool = false)
    {
      if ((!bool) && (localUri != null) && ("http".equals(localUri.getScheme())))
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("https://fwd.3g.qq.com:8080/forward.jsp?bid=681&srctype=42");
        paramSessionInfo.append("&uin=" + paramQQAppInterface.a());
        paramSessionInfo.append("&sid=" + paramQQAppInterface.getSid());
      }
      try
      {
        paramSessionInfo.append("&jumpurl=" + URLEncoder.encode(localUri.toString(), "utf-8"));
        paramIntent.setData(Uri.parse(paramSessionInfo.toString()));
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramActivity.startActivityForResult(paramIntent, paramInt);
            return;
          }
          catch (ActivityNotFoundException paramQQAppInterface)
          {
            if (paramInt != 2001) {
              continue;
            }
            QQToast.a(paramActivity, 2131366063, 0).b(paramActivity.getResources().getDimensionPixelSize(2131492923));
            paramQQAppInterface.printStackTrace();
            return;
          }
          paramQQAppInterface = paramQQAppInterface;
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map paramMap, boolean paramBoolean2) {}
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, ChatActivity paramChatActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick().");
    }
    if ((paramChatActivity != null) && (paramChatActivity.getCurrentFocus() != null)) {}
    Context localContext;
    ChatMessage localChatMessage;
    do
    {
      ((InputMethodManager)paramChatActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramChatActivity.getCurrentFocus().getWindowToken(), 0);
      for (;;)
      {
        localContext = paramView.getContext();
        if (localContext != null) {
          break;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "chatActivity current focus is null");
        }
      }
      localChatMessage = AIOUtils.a(paramView);
    } while (localChatMessage == null);
    if ((localChatMessage instanceof MessageForLongMsg)) {
      paramView = ((MessageForLongMsg)localChatMessage).msg;
    }
    for (;;)
    {
      if ((localChatMessage instanceof MessageForMixedMsg)) {
        paramView = ((MessageForMixedMsg)localChatMessage).msg;
      }
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick() CharSequence null.");
        return;
        if (!(localChatMessage instanceof MessageForText)) {
          break label369;
        }
        paramView = (MessageForText)localChatMessage;
        if (!(paramView.sb instanceof QQText)) {
          break label364;
        }
      }
      label364:
      for (paramView = ((QQText)paramView.sb).g;; paramView = null)
      {
        if (localChatMessage.msgtype != -2008) {
          break label367;
        }
        if (localChatMessage.isSend())
        {
          paramView = localContext.getString(2131368542);
          break;
        }
        paramView = localContext.getString(2131368541);
        break;
        Intent localIntent = new Intent(localContext, TextPreviewActivity.class);
        localIntent.putExtra("peeruin", localChatMessage.frienduin);
        localIntent.putExtra("uin_type", localChatMessage.istroop);
        localIntent.putExtra("content", paramView);
        localIntent.putExtra("uniseq", localChatMessage.uniseq);
        localIntent.putExtra("bubbleId", localChatMessage.vipBubbleID);
        localIntent.putExtra("senderuin", localChatMessage.senderuin);
        paramChatActivity.startActivity(localIntent);
        ((Activity)localContext).overridePendingTransition(2130968597, 0);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "long_msg", "long_msg_double", 0, 0, "", "", "", "");
        return;
      }
      label367:
      continue;
      label369:
      paramView = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a()))) {}
    do
    {
      do
      {
        return;
      } while ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0));
      jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString + paramQQAppInterface.a(), paramInteger);
    } while (paramInteger.intValue() != -1);
    paramInteger = (FriendManager)paramQQAppInterface.getManager(8);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.a(paramString);
      if (paramInteger != null)
      {
        String str = paramQQAppInterface.a();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramInteger.Administrator))) {
          if ((str.equals(paramInteger.Administrator)) || (paramInteger.Administrator.contains(str))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramInteger = "0";; paramInteger = "1")
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025) || (paramInt == 1010);
  }
  
  public static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "single friend list: " + paramContext);
      }
      try
      {
        paramContext = new JSONArray(paramContext);
        int i = 0;
        while (i < paramContext.length())
        {
          Object localObject = paramContext.getJSONObject(i);
          if ((((JSONObject)localObject).has("type")) && (((JSONObject)localObject).has("uin")))
          {
            int j = ((JSONObject)localObject).getInt("type");
            localObject = ((JSONObject)localObject).getString("uin");
            if (j == paramSessionInfo.jdField_a_of_type_Int)
            {
              boolean bool = ((String)localObject).equals(MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString));
              if (bool) {
                return true;
              }
            }
          }
          i += 1;
        }
        return true;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        localObject = new JSONArray();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((!localJSONObject.has("type")) || (!localJSONObject.has("uin"))) {
            break label216;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(MsgProxyUtils.a(paramString)))) {
            break label216;
          }
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("single_way_friend_list", ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label216:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((FriendManager)paramQQAppInterface.getManager(8)).g(paramString1)) {
        break label242;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if (paramInt == 1001)
      {
        paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString1);
        if (paramQQAppInterface == null)
        {
          bool1 = bool2;
          if (localShieldMsgManger != null) {
            bool1 = localShieldMsgManger.a(paramString1);
          }
        }
        else
        {
          bool1 = bool2;
          if (paramQQAppInterface.groupid == -1002) {
            bool1 = true;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramInt != 1011)
        {
          bool1 = bool2;
          if (localShieldMsgManger != null)
          {
            String str = paramString1;
            if (paramInt == 1006)
            {
              str = paramString1;
              if (paramString1 == null) {
                str = ContactUtils.d(paramQQAppInterface, paramString2);
              }
            }
            bool1 = bool2;
            if (!TextUtils.isEmpty(str))
            {
              bool1 = localShieldMsgManger.a(str);
              continue;
              label242:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, Handler.Callback paramCallback, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramCallback, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, Handler.Callback paramCallback, String paramString5, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4 + ", checkShieldMsg: " + paramBoolean2 + ", checkWifi: " + paramBoolean3 + ", from: " + paramString5);
    }
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramCallback, paramString5, paramMap, true, true, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, Handler.Callback paramCallback, String paramString5, Map paramMap, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    if (Build.VERSION.SDK_INT < 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo sdk not support!");
      }
      QQToast.a(paramContext, 2131362824, 1).b(paramContext.getResources().getDimensionPixelSize(2131492923));
      return true;
    }
    if (!NetworkUtil.e(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo network not support!");
      }
      QQToast.a(paramContext, 2131365730, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
      return true;
    }
    paramQQAppInterface = (SplashActivity)SplashActivity.a();
    if ((!paramQQAppInterface.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!paramQQAppInterface.permissionManager.checkPermission("android.permission.CAMERA"))) {
      paramQQAppInterface.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new dlg(paramContext, paramString1, paramBoolean1, paramQQAppInterface));
    }
    for (;;)
    {
      return true;
      paramQQAppInterface = new Intent(paramContext, QavChatActivity.class);
      paramQQAppInterface.addFlags(262144);
      paramQQAppInterface.putExtra("key_peer_uin", paramString1);
      paramQQAppInterface.putExtra("key_only_audio", paramBoolean1);
      paramContext.startActivity(paramQQAppInterface);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((1024 == paramSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
    return (paramSessionInfo.jdField_a_of_type_Int == 0) && (!paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((FriendManager)paramQQAppInterface.getManager(8)).b(paramString);
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramTroopMemberInfo.alias == null) || (paramTroopMemberInfo.alias.length() <= 0))
    {
      bool1 = bool2;
      if (paramTroopMemberInfo.memberuin != null)
      {
        bool1 = bool2;
        if (paramTroopMemberInfo.memberuin.trim().length() > 0)
        {
          bool1 = bool2;
          if (paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase(String.valueOf(0))) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.trim().length() > 0)
      {
        bool1 = bool2;
        if (!paramString.trim().equals(String.valueOf(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = BaseApplication.getContext();
        } while (localObject == null);
        localSharedPreferences = ((Context)localObject).getSharedPreferences("secondHandSharePre", 0);
      } while (localSharedPreferences == null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1).append(paramString2).append(paramString3);
    } while (localSharedPreferences.contains(((StringBuilder)localObject).toString()));
    paramString1 = localSharedPreferences.edit();
    paramString1.putInt(((StringBuilder)localObject).toString(), 0);
    paramString1.commit();
    return true;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, paramJSONObject.toString() + "");
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("url"))
        {
          localObject1 = paramJSONObject.getString("url");
          if (!paramJSONObject.has("picture")) {
            break label589;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label595;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label601;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label607;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label613;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label618;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label624;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label630;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label636;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label642;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label648;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label654;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label660;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label666;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(41).a((String)localObject2).a(7);
            if (paramJSONObject == "") {
              break label673;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((AbsShareMsg.Builder)localObject2).b(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).d((String)localObject1).a();
            localObject1 = StructMsgElementFactory.a(i);
            ((AbsStructMsgItem)localObject1).a(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((AbsStructMsgElement)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(1).a((String)localObject2).e((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = StructMsgElementFactory.a(2);
          ((AbsStructMsgItem)localObject1).a(str1, str2, str3);
          paramJSONObject.addItem((AbsStructMsgElement)localObject1);
          paramJSONObject = paramJSONObject.getBytes();
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
        }
        return null;
      }
      Object localObject1 = null;
      continue;
      label589:
      String str1 = null;
      continue;
      label595:
      String str2 = null;
      continue;
      label601:
      String str3 = null;
      continue;
      label607:
      Object localObject2 = null;
      continue;
      label613:
      int i = 2;
      continue;
      label618:
      String str4 = null;
      continue;
      label624:
      String str5 = null;
      continue;
      label630:
      String str6 = null;
      continue;
      label636:
      String str7 = null;
      continue;
      label642:
      String str8 = null;
      continue;
      label648:
      String str9 = null;
      continue;
      label654:
      String str10 = null;
      continue;
      label660:
      String str11 = null;
      continue;
      label666:
      paramJSONObject = "";
      continue;
      label673:
      long l = -1L;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    try
    {
      localObject = new byte[16];
      i = 0;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    paramArrayOfByte2 = new SecretKeySpec((byte[])localObject, "AES");
    Object localObject = Cipher.getInstance("AES/ECB/NoPadding");
    ((Cipher)localObject).init(2, paramArrayOfByte2);
    paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
    return paramArrayOfByte1;
    while (i < 16)
    {
      localObject[i] = paramArrayOfByte2[i];
      i += 1;
    }
  }
  
  public static MessageRecord b(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if (MsgProxyUtils.g(paramSessionInfo.msgtype)) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static String b(int paramInt)
  {
    int i = 999;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return String.valueOf(paramInt);
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 2;
      continue;
      paramInt = 4;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      return;
    }
    jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void b(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131366107), paramContext.getString(2131366108), new dln(), null).show();
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131492923), 0, paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {}
    for (paramQQAppInterface = new Intent(paramActivity, ChatHistoryForC2C.class);; paramQQAppInterface = new Intent(paramActivity, ChatHistory.class))
    {
      paramQQAppInterface.addFlags(536870912);
      paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramQQAppInterface.putExtra("FriendNick", paramSessionInfo.d);
      paramActivity.startActivityForResult(paramQQAppInterface, 0);
      return;
    }
  }
  
  public static boolean b(Context paramContext, SessionInfo paramSessionInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramSessionInfo.jdField_a_of_type_Int);
      localJSONObject.put("uin", MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramSessionInfo = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
      if (!TextUtils.isEmpty(paramSessionInfo)) {}
      for (paramSessionInfo = new JSONArray(paramSessionInfo);; paramSessionInfo = new JSONArray())
      {
        paramSessionInfo.put(localJSONObject);
        paramSessionInfo = paramSessionInfo.toString();
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString("single_way_friend_list", paramSessionInfo);
        return paramContext.commit();
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1006) || (i == 1021) || (i == 1010) || (i == 1001) || (i == 1025);
  }
  
  public static void c(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131366107), paramContext.getString(2131366109), new dlo(), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */