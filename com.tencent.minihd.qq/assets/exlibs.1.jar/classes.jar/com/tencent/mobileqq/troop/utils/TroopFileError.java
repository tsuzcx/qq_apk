package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kma;
import kmb;
import kmd;
import kme;
import mqq.app.MobileQQ;

public class TroopFileError
{
  public static final int A = 305;
  public static final int B = 306;
  public static final int C = 307;
  public static final int D = 308;
  public static final int E = 309;
  public static final int F = 400;
  public static final int G = 401;
  public static final int H = 402;
  public static final int I = 403;
  public static final int J = 500;
  public static final int K = 501;
  public static final int L = 502;
  public static final int M = 503;
  public static final int N = 504;
  public static final int O = 505;
  public static final int P = 600;
  public static final int Q = 601;
  public static final int R = 602;
  public static final int S = 603;
  public static final int T = 700;
  public static final int U = 701;
  public static final int V = 702;
  public static final int W = 703;
  public static final int X = 704;
  public static final int Y = 705;
  public static final int Z = 706;
  public static final int a = 0;
  public static final String a;
  public static WeakReference a;
  public static final int aa = 801;
  public static final int ab = 802;
  public static final int b = 1;
  public static final int c = 100;
  public static final int d = 101;
  public static final int e = 102;
  public static final int f = 103;
  public static final int g = 104;
  public static final int h = 105;
  public static final int i = 106;
  public static final int j = 107;
  public static final int k = 200;
  public static final int l = 201;
  public static final int m = 202;
  public static final int n = 203;
  public static final int o = 204;
  public static final int p = 205;
  public static final int q = 206;
  public static final int r = 207;
  public static final int s = 208;
  public static final int t = 209;
  public static final int u = 210;
  public static final int v = 300;
  public static final int w = 301;
  public static final int x = 302;
  public static final int y = 303;
  public static final int z = 304;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopFileError.class.getSimpleName();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    kme localkme = new kme(paramLong);
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131363389), paramContext.getResources().getString(2131363390), 2131363325, 2131363326, localkme, localkme).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new kmb(paramContext, paramString1, paramString2, paramInt));
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.b(paramContext, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    localQQCustomDialog.setPositiveButton(paramContext.getResources().getString(paramInt), new kmd());
    localQQCustomDialog.show();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1;
    try
    {
      i1 = paramContext.getResources().getDimensionPixelSize(2131492923);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new kma(paramBoolean, paramContext, paramString, i1));
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(paramContext, 2, paramString, 0).b(i1);
      return;
    }
    QQToast.a(paramContext, 2130838254, paramString, 0).b(i1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    a(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong).append(",filename:").append(paramString).append(",status:").append(paramInt1).append(",errorCode:").append(paramInt2);
        QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(21);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if ((paramQQAppInterface == null) || (paramSimpleErrorInfo == null) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(21);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramSimpleErrorInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramQQAppInterface.c((BusinessObserver)jdField_a_of_type_JavaLangRefWeakReference.get());
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopFileErrorObserver);
    paramQQAppInterface.a(paramTroopFileErrorObserver);
  }
  
  public static void a(TroopFileError.SimpleErrorInfo paramSimpleErrorInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramSimpleErrorInfo == null) || (paramContext == null)) {
      return;
    }
    String str2 = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
    Object localObject = null;
    String str1 = null;
    int i2 = 2131365737;
    int i1 = 0;
    switch (paramSimpleErrorInfo.jdField_a_of_type_Int)
    {
    default: 
      paramQQAppInterface = (QQAppInterface)localObject;
    }
    for (;;)
    {
      if (i1 == 0) {
        break label1145;
      }
      localObject = (TroopFileError.TroopFileErrorObserver)jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject == null) || (localObject == null) || (((TroopFileError.TroopFileErrorObserver)localObject).jdField_a_of_type_Int == paramSimpleErrorInfo.jdField_a_of_type_Int)) {
        break;
      }
      ((TroopFileError.TroopFileErrorObserver)localObject).jdField_a_of_type_Int = paramSimpleErrorInfo.jdField_a_of_type_Int;
      a(paramContext, str1, paramQQAppInterface, i2);
      return;
      str1 = a(paramQQAppInterface, 2131363362);
      paramQQAppInterface = a(paramQQAppInterface, 2131363363);
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363364);
      continue;
      a(paramContext, paramLong);
      paramQQAppInterface = (QQAppInterface)localObject;
      continue;
      str1 = a(paramQQAppInterface, 2131363365);
      paramQQAppInterface = a(paramQQAppInterface, 2131363366, new Object[] { str2 });
      i1 = 1;
      continue;
      str1 = a(paramQQAppInterface, 2131363367);
      paramQQAppInterface = a(paramQQAppInterface, 2131363368, new Object[] { str2 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363369);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363370);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363374);
      continue;
      str1 = a(paramQQAppInterface, 2131363367);
      paramQQAppInterface = a(paramQQAppInterface, 2131363371, new Object[] { str2 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363372);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363373);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363388);
      continue;
      str1 = a(paramQQAppInterface, 2131363403);
      localObject = a(paramQQAppInterface, 2131363404);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i1 = 1;
      i2 = 2131363402;
      paramQQAppInterface = (QQAppInterface)localObject;
      continue;
      str1 = a(paramQQAppInterface, 2131363377);
      paramQQAppInterface = a(paramQQAppInterface, 2131363375, new Object[] { str2 });
      i1 = 1;
      continue;
      str1 = a(paramQQAppInterface, 2131363367);
      paramQQAppInterface = a(paramQQAppInterface, 2131363376, new Object[] { str2 });
      i1 = 1;
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363378, new Object[] { str2 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363379, new Object[] { str2 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363380, new Object[] { str2 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363363);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363381);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363382);
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363383, new Object[] { str2 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363384, new Object[] { str2 });
      continue;
      paramQQAppInterface = a(paramQQAppInterface, 2131363385, new Object[] { str2 });
      continue;
      if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int))
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131363386, new Object[] { str2 });
      }
      else
      {
        paramQQAppInterface = a(paramQQAppInterface, 2131363387, new Object[] { str2 });
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363388);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363393);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363394);
        continue;
        a(paramContext, a(paramQQAppInterface, 2131363395, new Object[] { str2 }), true);
        return;
        paramQQAppInterface = a(paramQQAppInterface, 2131363396);
        continue;
        paramQQAppInterface = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363397);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363399);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363400);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363401);
        continue;
        paramQQAppInterface = a(paramQQAppInterface, 2131363405);
      }
    }
    label1145:
    a(paramContext, paramQQAppInterface);
  }
  
  public static boolean a(TroopFileInfo paramTroopFileInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramTroopFileInfo == null) || (paramContext == null)) {
      return false;
    }
    a(new TroopFileError.SimpleErrorInfo(paramTroopFileInfo.c, paramLong, paramTroopFileInfo.g, paramTroopFileInfo.h), paramLong, paramQQAppInterface, paramContext);
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    paramQQAppInterface.c(paramTroopFileErrorObserver);
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == paramTroopFileErrorObserver)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError
 * JD-Core Version:    0.7.0.1
 */