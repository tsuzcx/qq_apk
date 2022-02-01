package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.pay.api.APPayResponse;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class z5
{
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().getResources().getIdentifier(paramString, "anim", paramContext.getApplicationContext().getPackageName());
  }
  
  public static String a()
  {
    String str2 = "";
    try
    {
      Context localContext = a.r().d;
      String str1 = str2;
      if (localContext != null)
      {
        PackageManager localPackageManager = localContext.getPackageManager();
        str1 = str2;
        if (localPackageManager != null) {
          str1 = localPackageManager.getPackageInfo(localContext.getPackageName(), 0).packageName;
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    DecimalFormat localDecimalFormat = (DecimalFormat)DecimalFormat.getInstance();
    if (paramInt == 0) {
      localDecimalFormat.applyPattern("0");
    } else if (paramInt == 1) {
      localDecimalFormat.applyPattern("0.0");
    } else if (paramInt == 2) {
      localDecimalFormat.applyPattern("0.00");
    }
    try
    {
      paramString = localDecimalFormat.format(Float.valueOf(APTools.j(paramString)).floatValue() / 100.0F);
      return paramString;
    }
    catch (Exception paramString)
    {
      label66:
      break label66;
    }
    return "";
  }
  
  public static String a(HashMap<String, String> paramHashMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
      localStringBuffer.append("&");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(0, 0, paramInt1, paramInt2, paramInt3, "", "");
    e();
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    if ((a.r().e.resultCode == 0) && (paramInt1 != 0)) {
      return;
    }
    a.r().e.resultCode = paramInt1;
    a.r().e.resultInerCode = paramInt2;
    try
    {
      a.r().e.realSaveNum = Integer.valueOf(p4.p().e().f.g).intValue();
      label64:
      a.r().e.payChannel = paramInt3;
      a.r().e.payState = paramInt4;
      a.r().e.provideState = paramInt5;
      a.r().e.payReserve3 = paramString2;
      a.r().e.resultMsg = paramString1;
      return;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    a(0, 0, paramInt1, paramInt2, paramInt3, paramString, "");
    e();
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    a(paramInt1, paramInt2, -1, -1, -1, paramString, "");
    e();
  }
  
  public static void a(int paramInt, String paramString)
  {
    APUICommonMethod.f();
    a(paramInt, 0, -1, -1, -1, paramString, "");
    e();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, 0, -1, -1, -1, paramString1, paramString2);
    e();
  }
  
  public static void a(String paramString, List<String> paramList)
  {
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    paramList.clear();
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() != 0)
      {
        paramString = paramString.split(",");
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          paramList.add(paramString[i]);
          i += 1;
        }
      }
    }
  }
  
  public static void a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() == 0)
      {
        paramList1.clear();
        paramList2.clear();
        return;
      }
      paramString = paramString.split(",");
      j = paramString.length;
      if ((j > 0) && (j % 2 == 0))
      {
        paramList1.clear();
        paramList2.clear();
        i = 0;
        while (i < j / 2)
        {
          int k = i * 2;
          Object localObject1 = paramString[k];
          Object localObject2 = paramString[(k + 1)];
          paramList1.add(localObject1);
          paramList2.add(localObject2);
          i += 1;
        }
      }
    }
  }
  
  public static void a(String paramString, TreeMap<String, String> paramTreeMap)
  {
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() == 0)
      {
        paramTreeMap.clear();
        return;
      }
      paramString = paramString.split(",");
      j = paramString.length;
      if ((j > 0) && (j % 2 == 0))
      {
        paramTreeMap.clear();
        i = 0;
        while (i < j / 2)
        {
          int k = i * 2;
          paramTreeMap.put(paramString[k], paramString[(k + 1)]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(APBaseRequest paramAPBaseRequest)
  {
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("hfPointConvert"))) && ("midasPay".equals((String)paramAPBaseRequest.get("hfPointConvert")))) {
        return true;
      }
    }
    return false;
  }
  
  public static byte[] a(int paramInt)
  {
    if ((paramInt <= 0) && (a.r().d != null)) {
      return null;
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a.r().d.getResources(), paramInt);
      if (localBitmap == null) {
        return null;
      }
      Object localObject = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      localBitmap.recycle();
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      APLog.e("BitmapResIdToByteArrary", localOutOfMemoryError.toString());
    }
    return null;
  }
  
  public static String[] a(float paramFloat)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("0.00");
    return localDecimalFormat.format(paramFloat).split("\\.");
  }
  
  public static String b()
  {
    try
    {
      String str = a.r().d.getPackageManager().getPackageInfo(a.r().d.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static boolean b(APBaseRequest paramAPBaseRequest)
  {
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("wechatpayscoretype"))) && ("sign".equals((String)paramAPBaseRequest.get("wechatpayscoretype")))) {
        return true;
      }
    }
    return false;
  }
  
  public static String c()
  {
    if (a().equals("com.tencent.unipay")) {
      return b();
    }
    return "1.7.9a";
  }
  
  public static boolean c(APBaseRequest paramAPBaseRequest)
  {
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      if (paramAPBaseRequest != null) {
        if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("wechattype")))
        {
          paramAPBaseRequest = (String)paramAPBaseRequest.get("wechattype");
          if ("sign".equals(paramAPBaseRequest)) {
            return true;
          }
          if ("unsign".equals(paramAPBaseRequest)) {
            return true;
          }
        }
        else if (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("qqtype")))
        {
          paramAPBaseRequest = (String)paramAPBaseRequest.get("qqtype");
          if ("sign".equals(paramAPBaseRequest)) {
            return true;
          }
          if ("unsign".equals(paramAPBaseRequest)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean d()
  {
    String str = p4.p().e().b.mpInfo.payChannel;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toAssignPayChannel:");
    localStringBuilder.append(str);
    APLog.e("BuyPage", localStringBuilder.toString());
    if (TextUtils.isEmpty(p4.p().e().b.saveValue)) {
      return false;
    }
    return (!TextUtils.isEmpty(str)) && (("bank".equals(str)) || ("wechat".equals(str)) || ("wechat_quickpass".equals(str)) || ("wechat_payscore".equals(str)) || ("qqwallet".equals(str)));
  }
  
  public static void e()
  {
    APPayResponse localAPPayResponse = new APPayResponse();
    localAPPayResponse.resultCode = a.r().e.resultCode;
    localAPPayResponse.realSaveNum = a.r().e.realSaveNum;
    localAPPayResponse.resultInerCode = a.r().e.resultInerCode;
    localAPPayResponse.payChannel = a.r().e.payChannel;
    localAPPayResponse.payState = a.r().e.payState;
    localAPPayResponse.provideState = a.r().e.provideState;
    localAPPayResponse.extendInfo = a.r().e.extendInfo;
    localAPPayResponse.resultMsg = a.r().e.resultMsg;
    localAPPayResponse.payReserve1 = a.r().e.payReserve1;
    localAPPayResponse.payReserve2 = a.r().e.payReserve2;
    localAPPayResponse.payReserve3 = a.r().e.payReserve3;
    localAPPayResponse.mAPPurchase = a.r().e.mAPPurchase;
    APLog.w("payCallback", localAPPayResponse.toString());
    for (;;)
    {
      int i;
      try
      {
        a.r().e.reset();
        i = p4.p().e().b.saveType;
        if ((i != 0) && (i != 1) && (i != 4))
        {
          if (i != 5) {
            break label291;
          }
          continue;
          a.r().a(localAPPayResponse);
          return;
          if (i != a.r().g.b.saveType)
          {
            localAPPayResponse.resultCode = 2;
            localAPPayResponse.realSaveNum = 0;
            localAPPayResponse.payState = 1;
            localAPPayResponse.provideState = -1;
          }
          a.r().a(localAPPayResponse);
          return;
        }
        a.r().a(localAPPayResponse);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.r().a(localAPPayResponse);
        return;
      }
      label291:
      if (i != 2) {
        if (i != 3) {}
      }
    }
  }
  
  public static void f()
  {
    APUICommonMethod.f();
    a.r().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z5
 * JD-Core Version:    0.7.0.1
 */