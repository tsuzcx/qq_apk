package com.pay.data.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import midas.x.a;
import midas.x.c5;
import midas.x.d5;
import midas.x.fc;
import midas.x.g0;
import midas.x.h0;
import midas.x.k0;
import midas.x.l0;
import midas.x.o4;
import midas.x.o6;
import midas.x.ob;
import midas.x.p4;
import midas.x.z1;
import midas.x.z5;

public class APDataReportManager
{
  public static volatile APDataReportManager a;
  
  public static APDataReportManager getInstance()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new APDataReportManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void insertData(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      insertData(false, paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void insertData(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      paramString1 = new StringBuilder();
      paramString1.append("insertData format = ");
      paramString1.append(paramString2);
      APLog.d("DataReprotManager", paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append("insertData sExtend = ");
      paramString1.append(paramString6);
      APLog.d("DataReprotManager", paramString1.toString());
      try
      {
        if (TextUtils.isEmpty(p4.p().c()))
        {
          APLog.e("DataReprotManager", "Cannot insert report data without offer id!");
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("format", paramString2);
        localHashMap.put("times", String.valueOf(System.currentTimeMillis()));
        localHashMap.put("VipFlags", APPluginReportParams.getInstance().e());
        if (!TextUtils.isEmpty(paramString3)) {
          localHashMap.put("PayLevel", paramString3);
        }
        if (!TextUtils.isEmpty(paramString4)) {
          localHashMap.put("token", paramString4);
        }
        if (!TextUtils.isEmpty(paramString5)) {
          localHashMap.put("from", paramString5);
        }
        paramString1 = paramString6;
        if (TextUtils.isEmpty(paramString6)) {
          paramString1 = "";
        }
        paramString1 = a(paramString1);
        if (!TextUtils.isEmpty(paramString1)) {
          localHashMap.put("extend", APTools.b(paramString1, 3));
        }
        paramString1 = p4.p().e();
        if (a.r().e())
        {
          localHashMap.put("payid", paramString1.f.a);
          if (paramString1.e.e) {
            localHashMap.put("isBindQQ", "true");
          } else {
            localHashMap.put("isBindQQ", "false");
          }
        }
        localHashMap.put("pf", paramString1.b.pf);
        localHashMap.put("sessionToken", paramString1.f.k);
        localHashMap.put("uinTypeFromSvr", paramString1.e.j);
        localHashMap.put("uinFromSvr", paramString1.e.i);
        localHashMap.put("sessionId", paramString1.b.sessionId);
        localHashMap.put("sessionType", paramString1.b.sessionType);
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if ((paramInt != 2) && (paramInt != 3))
            {
              if (paramInt != 4)
              {
                if (paramInt != 5) {
                  localHashMap.put("buytype", "game");
                } else {
                  localHashMap.put("buytype", "subscribe");
                }
              }
              else {
                localHashMap.put("buytype", "month");
              }
            }
            else {
              localHashMap.put("buytype", "acct");
            }
          }
          else {
            localHashMap.put("buytype", "goods");
          }
        }
        else {
          localHashMap.put("buytype", "game");
        }
        paramString1 = h0.a(a.r().d);
        new l0();
        paramString2 = a(localHashMap);
        if (paramBoolean) {
          paramString1.b(paramString2);
        } else {
          paramString1.a(paramString2);
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1;
  }
  
  public final String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("login_from_version");
    localStringBuffer.append("=");
    localStringBuffer.append(APAppDataInterface.singleton().p());
    localStringBuffer.append("&");
    localStringBuffer.append("appv");
    localStringBuffer.append("=");
    localStringBuffer.append(APAppDataInterface.singleton().d());
    localStringBuffer.append("&");
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  public final String a(String paramString, long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name=");
    localStringBuffer.append(paramString);
    localStringBuffer.append("&");
    localStringBuffer.append("times=");
    localStringBuffer.append(paramLong);
    localStringBuffer.append("&");
    return localStringBuffer.toString();
  }
  
  public final StringBuffer a(l0 paraml0)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("3=");
    localStringBuilder.append(paraml0.b);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append("|7=0");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|13=");
    localStringBuilder.append(paraml0.a);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|24=");
    localStringBuilder.append(paraml0.g);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paraml0.c))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|4=");
      localStringBuilder.append(paraml0.c);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paraml0.r))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|55=");
      localStringBuilder.append(paraml0.r);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|21=");
    localStringBuilder.append(paraml0.f);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|26=");
    localStringBuilder.append(paraml0.h);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paraml0.q))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|56=");
      localStringBuilder.append(paraml0.q);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paraml0.d))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|8=");
      localStringBuilder.append(paraml0.d);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paraml0.e))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|20=");
      localStringBuilder.append(paraml0.e);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paraml0.p))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|47=");
      localStringBuilder.append(paraml0.p);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|29=");
    localStringBuilder.append(paraml0.i);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|31=");
    localStringBuilder.append(paraml0.j);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|38=");
    localStringBuilder.append(paraml0.n);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|34=");
    localStringBuilder.append(paraml0.k);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|35=");
    localStringBuilder.append(paraml0.l);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|37=");
    localStringBuilder.append(paraml0.m);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|43=");
    localStringBuilder.append(paraml0.o);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paraml0.s))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|54=");
      localStringBuilder.append(paraml0.s);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paraml0.t))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|53=");
      localStringBuilder.append(paraml0.t);
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer;
  }
  
  public l0 a(HashMap<String, String> paramHashMap)
  {
    try
    {
      l0 locall0 = new l0();
      locall0.f = ((String)paramHashMap.get("format"));
      locall0.n = ((String)paramHashMap.get("times"));
      locall0.q = ((String)paramHashMap.get("sToken"));
      locall0.e = ((String)paramHashMap.get("from"));
      locall0.d = ((String)paramHashMap.get("extend"));
      locall0.c = ((String)paramHashMap.get("payid"));
      locall0.r = ((String)paramHashMap.get("isBindQQ"));
      locall0.h = ((String)paramHashMap.get("pf"));
      locall0.i = ((String)paramHashMap.get("sessionToken"));
      locall0.k = ((String)paramHashMap.get("uinTypeFromSvr"));
      locall0.l = ((String)paramHashMap.get("uinFromSvr"));
      locall0.m = ((String)paramHashMap.get("sessionId"));
      locall0.o = ((String)paramHashMap.get("sessionType"));
      locall0.p = ((String)paramHashMap.get("buytype"));
      locall0.g = p4.p().e().b.offerId;
      locall0.a = g0.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android_v");
      localStringBuilder.append(z5.c());
      locall0.j = localStringBuilder.toString();
      locall0.s = ((String)paramHashMap.get("PayLevel"));
      locall0.t = ((String)paramHashMap.get("VipFlags"));
      locall0.b = p4.p().e().b.openId;
      locall0.u = APTools.j();
      return locall0;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      insertData(true, APPluginReportParams.getInstance().a(), paramString1, paramInt, null, paramString2, paramString3, paramString4);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    try
    {
      String str = APPluginReportParams.getInstance().a();
      paramLong = a(paramLong, System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeName:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",time:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("; action:");
      localStringBuilder.append(paramString2);
      APLog.i("shihao", localStringBuilder.toString());
      a(str, paramString1, paramLong, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, "", paramString2);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    try
    {
      APLog.i("insertTimeData interfaceName=", paramString1);
      APLog.i("insertTimeData timeName=", paramString2);
      APLog.i("insertTimeData time=", String.valueOf(paramLong));
      paramString2 = a(paramString2, paramLong);
      if ((p4.p().e() != null) && (p4.p().e().b != null)) {
        insertData(paramString1, "sdk.apk.time", p4.p().e().b.saveType, "", "", paramString3, paramString2);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(p4.p().e().b.offerId);
      if (bool) {
        return;
      }
      final l0 locall0 = new l0();
      o4 localo4 = p4.p().e();
      locall0.t = APPluginReportParams.getInstance().e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android_v");
      localStringBuilder.append(z5.c());
      locall0.j = localStringBuilder.toString();
      locall0.b = localo4.b.openId;
      locall0.a = g0.a();
      locall0.f = paramString1;
      locall0.e = paramString2;
      locall0.g = p4.p().e().b.offerId;
      locall0.h = localo4.b.pf;
      if (a.r().e())
      {
        locall0.c = localo4.f.a;
        if (localo4.e.e) {
          locall0.r = "true";
        } else {
          locall0.r = "false";
        }
      }
      if (!TextUtils.isEmpty(paramString3)) {
        locall0.d = APTools.b(paramString3, 3);
      }
      int i = p4.p().e().b.saveType;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if (i != 4)
            {
              if (i != 5) {
                locall0.p = "game";
              } else {
                locall0.p = "subscribe";
              }
            }
            else {
              locall0.p = "month";
            }
          }
          else {
            locall0.p = "acct";
          }
        }
        else {
          locall0.p = "goods";
        }
      }
      else {
        locall0.p = "game";
      }
      locall0.i = p4.p().e().f.k;
      locall0.n = String.valueOf(System.currentTimeMillis());
      paramString1 = localo4.e;
      locall0.k = paramString1.j;
      locall0.l = paramString1.i;
      paramString1 = localo4.b;
      locall0.m = paramString1.sessionId;
      locall0.o = paramString1.sessionType;
      locall0.u = APTools.j();
      paramString1 = new StringBuffer();
      paramString1.append("num=1&");
      paramString2 = new StringBuilder();
      paramString2.append("record");
      paramString2.append(0);
      paramString2.append("=");
      paramString1.append(paramString2.toString());
      paramString1.append(a(locall0));
      paramString1.append("&");
      if (paramString1.length() > 0) {
        paramString1.deleteCharAt(paramString1.length() - 1);
      }
      paramString1 = paramString1.toString();
      z1.d().a(paramString1, new c(locall0));
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportOneRecord exception:");
      paramString2.append(paramString1.toString());
      APLog.w("APDataReportManager", paramString2.toString());
      return;
      APLog.w("APDataReportManager", "reportOneRecord request or offerid is null");
      return;
    }
    catch (NullPointerException paramString1)
    {
      label559:
      break label559;
    }
  }
  
  public void a(final o6 paramo6)
  {
    final h0 localh0 = h0.a(a.r().d);
    localh0.a(new b(paramo6, localh0));
  }
  
  public final void b(final o6 paramo6)
  {
    h0.a(a.r().d).a(new a(paramo6));
  }
  
  public void insertData(String paramString, int paramInt)
  {
    try
    {
      insertData(paramString, paramInt, null, null, null, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void insertData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      insertData(paramString1, paramInt, null, paramString2, paramString3, paramString4);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void insertData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      insertData(APPluginReportParams.getInstance().a(), paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public class a
    implements o6
  {
    public a(o6 paramo6) {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      if (paramInt1 <= 0)
      {
        paramo6.a(0, 0, 0, null, null);
        return;
      }
      if (paramInt1 % 50 == 0) {
        paramInt1 /= 50;
      } else {
        paramInt1 = paramInt1 / 50 + 1;
      }
      paramo6.a(paramInt1, 0, 0, null, null);
    }
  }
  
  public class b
    implements o6
  {
    public b(o6 paramo6, h0 paramh0) {}
    
    public void a(final int paramInt1, int paramInt2, int paramInt3, final Object paramObject, Bundle paramBundle)
    {
      paramObject = new ArrayList();
      if (paramInt1 <= 0)
      {
        paramo6.a(-1, 0, 0, null, null);
        return;
      }
      APDataReportManager.a(APDataReportManager.this, new a(paramInt1, paramObject));
    }
    
    public class a
      implements o6
    {
      public a(int paramInt, ArrayList paramArrayList) {}
      
      public void a(final int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
      {
        if (paramInt1 <= 0) {
          return;
        }
        APDataReportManager.b.this.b.b(new a(paramInt1));
      }
      
      public class a
        implements o6
      {
        public a(int paramInt) {}
        
        public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
        {
          paramObject = (ArrayList)paramObject;
          if (paramObject == null)
          {
            APDataReportManager.b.this.a.a(-1, 0, 0, null, null);
            return;
          }
          paramBundle = new StringBuffer();
          paramInt1 = 0;
          while (paramInt1 < paramInt1)
          {
            ArrayList localArrayList = new ArrayList();
            paramInt2 = 0;
            paramInt3 = 0;
            while ((paramInt2 < 50) && (paramInt2 < paramObject.size()))
            {
              int i = paramInt1 * 50 + paramInt2;
              if ((i >= paramInt1) || (i >= paramObject.size())) {
                break;
              }
              paramInt3 += 1;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("record");
              ((StringBuilder)localObject).append(paramInt2);
              ((StringBuilder)localObject).append("=");
              paramBundle.append(((StringBuilder)localObject).toString());
              paramBundle.append(APDataReportManager.a(APDataReportManager.this, (l0)paramObject.get(i)));
              paramBundle.append("&");
              localArrayList.add(paramObject.get(i));
              paramInt2 += 1;
            }
            if (paramBundle.length() > 0) {
              paramBundle.deleteCharAt(paramBundle.length() - 1);
            }
            Object localObject = new StringBuffer();
            ((StringBuffer)localObject).append("num=");
            ((StringBuffer)localObject).append(paramInt3);
            ((StringBuffer)localObject).append("&");
            ((StringBuffer)localObject).append(paramBundle.toString());
            k0 localk0 = new k0();
            localk0.a = ((StringBuffer)localObject).toString();
            localk0.b = localArrayList;
            APDataReportManager.b.a.this.b.add(localk0);
            paramBundle.setLength(0);
            paramInt1 += 1;
          }
          paramObject = APDataReportManager.b.a.this;
          paramObject.c.a.a(0, 0, 0, paramObject.b, null);
        }
      }
    }
  }
  
  public class c
    implements fc
  {
    public c(l0 paraml0) {}
    
    public void a(ob paramob) {}
    
    public void b(ob paramob)
    {
      h0.a(a.r().d).a(locall0);
    }
    
    public void c(ob paramob)
    {
      h0.a(a.r().d).a(locall0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.data.report.APDataReportManager
 * JD-Core Version:    0.7.0.1
 */