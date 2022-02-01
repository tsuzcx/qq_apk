package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import kuk;
import org.json.JSONObject;

public class VipUtils
{
  public static final int a = 1;
  public static final String a = "vip";
  public static final int b = 2;
  public static final String b = "svip";
  public static final int c = 4;
  public static final String c = "0";
  public static final String d = "1";
  public static final String e = "2";
  private static final String f = "VipUtils";
  
  public static int a(AppInterface paramAppInterface, String paramString)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppInterface.a();
      }
      paramAppInterface = (FriendsManagerImp)paramAppInterface.getManager(8);
      if (paramAppInterface == null) {
        break label128;
      }
      paramAppInterface = paramAppInterface.c(str);
      if (paramAppInterface == null) {
        break label110;
      }
      if (!paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label100;
      }
      i = 1;
      if (!paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label105;
      }
      j = 2;
      label76:
      if (paramAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        k = 4;
      }
      i = k | j | 0x0 | i;
    }
    label100:
    label105:
    label110:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label128:
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = -1;
    int i = j;
    boolean bool2;
    if (paramQQAppInterface != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.a();
      }
      paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      if (paramQQAppInterface == null) {
        break label146;
      }
      paramQQAppInterface = paramQQAppInterface.c(str);
      if (paramQQAppInterface == null) {
        break label127;
      }
      boolean bool1 = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      i = paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP);
      bool2 = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      j = paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP);
      if (!bool1) {
        break label102;
      }
      if (i != 1) {
        break label97;
      }
      i = 4;
    }
    label97:
    label102:
    label127:
    do
    {
      for (;;)
      {
        return i;
        i = 2;
        continue;
        if (bool2)
        {
          if (j == 1) {
            i = 5;
          } else {
            i = 3;
          }
        }
        else
        {
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          }
          i = -1;
        }
      }
      i = j;
    } while (!QLog.isColorLevel());
    label146:
    QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
    return -1;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static void a(Activity paramActivity, kuk paramkuk)
  {
    if ((paramkuk == null) || (paramActivity == null) || (TextUtils.isEmpty(paramkuk.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramkuk.d)) || (TextUtils.isEmpty(paramkuk.e)) || (TextUtils.isEmpty(paramkuk.b)) || (TextUtils.isEmpty(paramkuk.c)) || (paramkuk.jdField_a_of_type_Int < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", paramkuk.b);
        ((JSONObject)localObject).put("aid", paramkuk.d);
        ((JSONObject)localObject).put("openMonth", String.valueOf(paramkuk.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("offerId", paramkuk.e);
        ((JSONObject)localObject).put("serviceName", paramkuk.c);
        ((JSONObject)localObject).put("userId", paramkuk.jdField_a_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        if (paramkuk.f == null) {
          break label210;
        }
        paramkuk = paramkuk.f;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, paramkuk);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label210:
      paramkuk = "";
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      kuk localkuk = new kuk();
      localkuk.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localkuk.d = paramString;
      localkuk.e = "1450000515";
      localkuk.b = "LTMCLUB";
      localkuk.c = paramBaseActivity.getString(2131369043);
      localkuk.jdField_a_of_type_Int = paramInt;
      localkuk.f = "vip";
      a(paramBaseActivity, localkuk);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "UNKNOWN";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      kuk localkuk = new kuk();
      localkuk.jdField_a_of_type_JavaLangString = paramBaseActivity.app.a();
      localkuk.d = paramString;
      localkuk.e = "1450000516";
      localkuk.b = "CJCLUBT";
      localkuk.c = paramBaseActivity.getString(2131369212);
      localkuk.jdField_a_of_type_Int = paramInt;
      localkuk.f = "svip";
      a(paramBaseActivity, localkuk);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */