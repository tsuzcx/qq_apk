package com.tencent.biz.eqq;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import cei;
import cej;
import cek;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class CrmUtils
{
  public static final int A = -26;
  public static final int B = -27;
  public static final int C = -28;
  public static final int D = -29;
  public static final int E = -1;
  public static final int a = 0;
  public static final long a = 256L;
  public static final String a = "QQ语音";
  public static final Pattern a;
  public static final boolean a;
  public static final int b = -1;
  public static final String b = "seq";
  public static final int c = -2;
  static final String c = "CrmUtils";
  public static final int d = -3;
  static final String d = "IVR_TS_CrmUtils";
  public static final int e = -4;
  public static final int f = -5;
  public static final int g = -6;
  public static final int h = -7;
  public static final int i = -8;
  public static final int j = -9;
  public static final int k = -10;
  public static final int l = -11;
  public static final int m = -12;
  public static final int n = -13;
  public static final int o = -14;
  public static final int p = -15;
  public static final int q = -16;
  public static final int r = -17;
  public static final int s = -18;
  public static final int t = -19;
  public static final int u = -20;
  public static final int v = -21;
  public static final int w = -22;
  public static final int x = -23;
  public static final int y = -24;
  public static final int z = -25;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("QQ语音");
    jdField_a_of_type_Boolean = a();
  }
  
  public static InputStream a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramQQAppInterface.getManager(54);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).b(paramString);
        if (localObject != null) {
          paramQQAppInterface = ((PublicAccountInfo)localObject).name;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          paramQQAppInterface = paramQQAppInterface.getManager(65);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
            if (paramQQAppInterface != null) {}
            for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = "")
            {
              return paramQQAppInterface;
              if (QLog.isColorLevel()) {
                QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
              }
            }
          }
          paramQQAppInterface = str;
        } while (!QLog.isColorLevel());
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        return "";
        paramQQAppInterface = str;
      } while (!QLog.isColorLevel());
      QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
      return "";
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("CrmUtils", 2, "We can't get name, because uin is null");
    return "";
  }
  
  private static void a(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    b(paramInt, paramQQProgressDialog);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if ((!jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
      QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, PublicAccountInfo paramPublicAccountInfo, EqqDetail paramEqqDetail, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio3(), ts=" + System.currentTimeMillis());
    }
    boolean bool;
    int i1;
    if (paramPublicAccountInfo != null)
    {
      bool = paramPublicAccountInfo.hasIvrAbility();
      i1 = 1;
      if (bool)
      {
        if (i1 != 0) {
          break label286;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("IVR_TS_CrmUtils", 4, ">>>begin follow, ts=" + System.currentTimeMillis());
        }
        paramPublicAccountInfo = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131492923));
        paramPublicAccountInfo.setCanceledOnTouchOutside(true);
        NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
        localNewIntent.putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(paramEqqDetail.uin));
        localFollowRequest.account_type.set(2);
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        localNewIntent.setObserver(new cek(paramContext, paramPublicAccountInfo, paramEqqDetail, paramQQAppInterface, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet(localNewIntent);
        a(2131363614, paramPublicAccountInfo);
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, "follow exit");
        }
      }
    }
    do
    {
      return;
      if (paramEqqDetail != null)
      {
        bool = paramEqqDetail.hasIvrAbility();
        if (paramEqqDetail.followType != 0)
        {
          i1 = 1;
          break;
        }
        i1 = 0;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("CrmUtils", 2, "Both PublicAccountInfo and EqqDetail is NULL!");
    return;
    label286:
    c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio2(), ts=" + System.currentTimeMillis());
    }
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
    NewIntent localNewIntent;
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null)
      {
        localObject = (EqqDetailDataManager)paramQQAppInterface.getManager(65);
        if (localObject != null)
        {
          localObject = ((EqqDetailDataManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("IVR_TS_CrmUtils", 4, ">>>begin getDetail, ts=" + System.currentTimeMillis());
            }
            localObject = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131492923));
            ((QQProgressDialog)localObject).setCanceledOnTouchOutside(true);
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, "sendDetailInfoRequest");
            }
            localNewIntent = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
            localNewIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
            localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
            localGetEqqDetailInfoRequest.version.set(2);
            localGetEqqDetailInfoRequest.seqno.set(0);
          }
        }
      }
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
      label243:
      localNewIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new cej(paramContext, (QQProgressDialog)localObject, paramQQAppInterface, paramSessionInfo, paramString));
      paramQQAppInterface.startServlet(localNewIntent);
      a(2131363614, (QQProgressDialog)localObject);
      return;
      a(paramQQAppInterface, paramContext, paramSessionInfo, null, (EqqDetail)localObject, paramString);
      return;
      a(paramContext, 2131363617);
      return;
      a(paramQQAppInterface, paramContext, paramSessionInfo, (PublicAccountInfo)localObject, null, paramString);
      return;
      a(paramContext, 2131363617);
      return;
    }
    catch (Exception localException)
    {
      break label243;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (!a(paramQQAppInterface, paramString, paramInt))
    {
      paramContext = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
      paramContext.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(2);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramString));
      label75:
      paramContext.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      paramContext.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception paramString)
    {
      break label75;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString2;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    a(paramQQAppInterface, paramContext, localSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>ivrAudio1(), ts=" + System.currentTimeMillis());
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = 1024;
    localSessionInfo.d = paramString1;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString2;
    a(paramQQAppInterface, paramContext, localSessionInfo, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    ThreadManager.a().post(new cei(paramQQAppInterface, paramEqqDetail));
  }
  
  public static boolean a()
  {
    int i1 = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Manager localManager = paramQQAppInterface.getManager(54);
      if (localManager != null)
      {
        if (((PublicAccountDataManager)localManager).b(paramString) != null) {}
        for (bool1 = true;; bool1 = true)
        {
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CrmUtils", 2, String.format("Check %s isContainUinInfo end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(65);
          if (paramQQAppInterface == null) {
            break label187;
          }
          if (((EqqDetailDataManager)paramQQAppInterface).a(paramString) == null) {
            break label157;
          }
        }
        label157:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label187:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
  
  public static boolean a(EqqDetail paramEqqDetail)
  {
    return (paramEqqDetail != null) && (paramEqqDetail.followType == 1);
  }
  
  public static boolean a(PublicAccountInfo paramPublicAccountInfo)
  {
    return (paramPublicAccountInfo != null) && (paramPublicAccountInfo.extendType == 2);
  }
  
  public static boolean a(String paramString)
  {
    if (!BmqqSegmentUtil.a(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        if ((l1 >= 2852000000L) && (l1 <= 2852199999L)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (NumberFormatException paramString) {}
    }
    return false;
  }
  
  private static void b(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    if (paramQQProgressDialog != null)
    {
      paramQQProgressDialog.b(paramInt);
      paramQQProgressDialog.show();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache");
    }
    Object localObject = (EqqDetailDataManager)paramQQAppInterface.getManager(65);
    if (localObject != null) {
      ((EqqDetailDataManager)localObject).a(paramEqqDetail);
    }
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
      if (localObject != null)
      {
        ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        PubAccountAssistantManager.a().a(paramQQAppInterface, ((PublicAccountDataManager)localObject).a());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache exit");
    }
  }
  
  private static void b(QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return false;
    }
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).b(paramString);
      if ((localObject != null) && (((PublicAccountInfo)localObject).extendType == 2)) {
        return true;
      }
    }
    paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(65);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(paramString) != null);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>hasIvrAbility(), ts=" + l1);
    }
    boolean bool2;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "app is null or uin is empty");
      }
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    if (paramInt == 1024)
    {
      Object localObject = paramQQAppInterface.getManager(54);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).b(paramString);
        if (localObject != null) {}
        for (bool1 = ((PublicAccountInfo)localObject).hasIvrAbility();; bool1 = paramQQAppInterface.hasIvrAbility())
        {
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("Check %s hasIvrAbility end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool1) }));
          }
          long l2 = System.currentTimeMillis();
          bool2 = bool1;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("IVR_TS_CrmUtils", 4, "<<<hasIvrAbility(), ts=" + l2);
          QLog.d("IVR_TS_CrmUtils", 4, String.format("hasIvrAbility(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          return bool1;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(65);
          if (paramQQAppInterface == null) {
            break label306;
          }
          paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
          if (paramQQAppInterface == null) {
            break label275;
          }
        }
        label275:
        if (QLog.isColorLevel()) {
          QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
        }
      }
    }
    for (;;)
    {
      bool1 = false;
      break;
      label306:
      if (QLog.isColorLevel())
      {
        QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
          }
        }
      }
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_CrmUtils", 4, ">>>startVideo(), ts=" + System.currentTimeMillis());
    }
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo.jdField_a_of_type_Int = 1024;
    PlusPanelUtils.a(paramQQAppInterface, paramContext, paramSessionInfo, true, paramString);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!BmqqSegmentUtil.a(paramString)) {
      return false;
    }
    Friends localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).a(paramString);
    boolean bool;
    if ((localFriends == null) || (-1 == localFriends.cSpecialFlag))
    {
      ((ContactFacade)paramQQAppInterface.getManager(52)).a().b(paramString);
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (1 == localFriends.cSpecialFlag) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils
 * JD-Core Version:    0.7.0.1
 */