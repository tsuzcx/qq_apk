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
import midas.x.af;
import midas.x.ag;
import midas.x.aj;
import midas.x.ak;
import midas.x.bs;
import midas.x.ec;
import midas.x.ed;
import midas.x.eq;
import midas.x.er;
import midas.x.fm;
import midas.x.ga;
import midas.x.jw;
import midas.x.kl;

public class APDataReportManager
{
  private static volatile APDataReportManager a;
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("login_from_version");
    localStringBuffer.append("=");
    localStringBuffer.append(APAppDataInterface.singleton().A());
    localStringBuffer.append("&");
    localStringBuffer.append("appv");
    localStringBuffer.append("=");
    localStringBuffer.append(APAppDataInterface.singleton().D());
    localStringBuffer.append("&");
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  private String a(String paramString, long paramLong)
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
  
  private StringBuffer a(ak paramak)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("3=");
    localStringBuilder.append(paramak.c);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append("|7=0");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|13=");
    localStringBuilder.append(paramak.b);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|24=");
    localStringBuilder.append(paramak.h);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramak.d))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|4=");
      localStringBuilder.append(paramak.d);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramak.s))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|55=");
      localStringBuilder.append(paramak.s);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|21=");
    localStringBuilder.append(paramak.g);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|26=");
    localStringBuilder.append(paramak.i);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramak.r))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|56=");
      localStringBuilder.append(paramak.r);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramak.e))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|8=");
      localStringBuilder.append(paramak.e);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramak.f))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|20=");
      localStringBuilder.append(paramak.f);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramak.q))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|47=");
      localStringBuilder.append(paramak.q);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|29=");
    localStringBuilder.append(paramak.j);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|31=");
    localStringBuilder.append(paramak.k);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|38=");
    localStringBuilder.append(paramak.o);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|34=");
    localStringBuilder.append(paramak.l);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|35=");
    localStringBuilder.append(paramak.m);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|37=");
    localStringBuilder.append(paramak.n);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("|43=");
    localStringBuilder.append(paramak.p);
    localStringBuffer.append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramak.t))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|54=");
      localStringBuilder.append(paramak.t);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramak.u))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|53=");
      localStringBuilder.append(paramak.u);
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer;
  }
  
  private void b(final ga paramga)
  {
    ag.a(a.a().d).a(new ga()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt1 <= 0)
        {
          paramga.a(0, 0, 0, null, null);
          return;
        }
        if (paramAnonymousInt1 % 50 == 0) {
          paramAnonymousInt1 /= 50;
        }
        for (;;)
        {
          break;
          paramAnonymousInt1 = paramAnonymousInt1 / 50 + 1;
        }
        paramga.a(paramAnonymousInt1, 0, 0, null, null);
      }
    });
  }
  
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
    for (;;)
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
          if (TextUtils.isEmpty(ed.b().f()))
          {
            APLog.e("DataReprotManager", "Cannot insert report data without offer id!");
            return;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("format", paramString2);
          localHashMap.put("times", String.valueOf(System.currentTimeMillis()));
          localHashMap.put("VipFlags", APPluginReportParams.getInstance().a());
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
            localHashMap.put("extend", APTools.a(paramString1, 3));
          }
          paramString1 = ed.b().n();
          if (a.a().j())
          {
            localHashMap.put("payid", paramString1.e.a);
            if (paramString1.d.e) {
              localHashMap.put("isBindQQ", "true");
            } else {
              localHashMap.put("isBindQQ", "false");
            }
          }
          localHashMap.put("pf", paramString1.a.pf);
          localHashMap.put("sessionToken", paramString1.e.l);
          localHashMap.put("uinTypeFromSvr", paramString1.d.l);
          localHashMap.put("uinFromSvr", paramString1.d.k);
          localHashMap.put("sessionId", paramString1.a.sessionId);
          localHashMap.put("sessionType", paramString1.a.sessionType);
          switch (paramInt)
          {
          case 5: 
            localHashMap.put("buytype", "subscribe");
            break;
          case 4: 
            localHashMap.put("buytype", "month");
            break;
          case 2: 
          case 3: 
            localHashMap.put("buytype", "acct");
            break;
          case 1: 
            localHashMap.put("buytype", "goods");
            break;
          case 0: 
            localHashMap.put("buytype", "game");
            continue;
            localHashMap.put("buytype", "game");
            paramString1 = ag.a(a.a().d);
            new ak();
            paramString2 = a(localHashMap);
            if (paramBoolean) {
              paramString1.a(paramString2);
            } else {
              paramString1.b(paramString2);
            }
            break;
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
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1;
  }
  
  public ak a(HashMap<String, String> paramHashMap)
  {
    try
    {
      ak localak = new ak();
      localak.g = ((String)paramHashMap.get("format"));
      localak.o = ((String)paramHashMap.get("times"));
      localak.r = ((String)paramHashMap.get("sToken"));
      localak.f = ((String)paramHashMap.get("from"));
      localak.e = ((String)paramHashMap.get("extend"));
      localak.d = ((String)paramHashMap.get("payid"));
      localak.s = ((String)paramHashMap.get("isBindQQ"));
      localak.i = ((String)paramHashMap.get("pf"));
      localak.j = ((String)paramHashMap.get("sessionToken"));
      localak.l = ((String)paramHashMap.get("uinTypeFromSvr"));
      localak.m = ((String)paramHashMap.get("uinFromSvr"));
      localak.n = ((String)paramHashMap.get("sessionId"));
      localak.p = ((String)paramHashMap.get("sessionType"));
      localak.q = ((String)paramHashMap.get("buytype"));
      localak.h = ed.b().n().a.offerId;
      localak.b = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android_v");
      localStringBuilder.append(fm.c());
      localak.k = localStringBuilder.toString();
      localak.t = ((String)paramHashMap.get("PayLevel"));
      localak.u = ((String)paramHashMap.get("VipFlags"));
      localak.c = ed.b().n().a.openId;
      localak.v = APTools.h();
      return localak;
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
      insertData(true, APPluginReportParams.getInstance().c(), paramString1, paramInt, null, paramString2, paramString3, paramString4);
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
      String str = APPluginReportParams.getInstance().c();
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
      if ((ed.b().n() != null) && (ed.b().n().a != null)) {
        insertData(paramString1, "sdk.apk.time", ed.b().n().a.saveType, "", "", paramString3, paramString2);
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
      boolean bool = TextUtils.isEmpty(ed.b().n().a.offerId);
      if (bool) {
        return;
      }
      final ak localak = new ak();
      ec localec = ed.b().n();
      localak.u = APPluginReportParams.getInstance().a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android_v");
      localStringBuilder.append(fm.c());
      localak.k = localStringBuilder.toString();
      localak.c = localec.a.openId;
      localak.b = af.a();
      localak.g = paramString1;
      localak.f = paramString2;
      localak.h = ed.b().n().a.offerId;
      localak.i = localec.a.pf;
      if (a.a().j())
      {
        localak.d = localec.e.a;
        if (localec.d.e) {
          localak.s = "true";
        } else {
          localak.s = "false";
        }
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localak.e = APTools.a(paramString3, 3);
      }
      switch (ed.b().n().a.saveType)
      {
      default: 
        localak.q = "game";
        break;
      case 5: 
        localak.q = "subscribe";
        break;
      case 4: 
        localak.q = "month";
        break;
      case 2: 
      case 3: 
        localak.q = "acct";
        break;
      case 1: 
        localak.q = "goods";
        break;
      case 0: 
        localak.q = "game";
      }
      localak.j = ed.b().n().e.l;
      localak.o = String.valueOf(System.currentTimeMillis());
      localak.l = localec.d.l;
      localak.m = localec.d.k;
      localak.n = localec.a.sessionId;
      localak.p = localec.a.sessionType;
      localak.v = APTools.h();
      paramString1 = new StringBuffer();
      paramString1.append("num=1&");
      paramString2 = new StringBuilder();
      paramString2.append("record");
      paramString2.append(0);
      paramString2.append("=");
      paramString1.append(paramString2.toString());
      paramString1.append(a(localak));
      paramString1.append("&");
      if (paramString1.length() > 0) {
        paramString1.deleteCharAt(paramString1.length() - 1);
      }
      paramString1 = paramString1.toString();
      bs.a().f(paramString1, new kl()
      {
        public void a(jw paramAnonymousjw) {}
        
        public void b(jw paramAnonymousjw)
        {
          ag.a(a.a().d).b(localak);
        }
        
        public void c(jw paramAnonymousjw)
        {
          ag.a(a.a().d).b(localak);
        }
      });
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
      label573:
      break label573;
    }
  }
  
  public void a(final ga paramga)
  {
    final ag localag = ag.a(a.a().d);
    localag.a(new ga()
    {
      public void a(final int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, final Object paramAnonymousObject, Bundle paramAnonymousBundle)
      {
        paramAnonymousObject = new ArrayList();
        if (paramAnonymousInt1 <= 0)
        {
          paramga.a(-1, 0, 0, null, null);
          return;
        }
        APDataReportManager.a(APDataReportManager.this, new ga()
        {
          public void a(final int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, Object paramAnonymous2Object, Bundle paramAnonymous2Bundle)
          {
            if (paramAnonymous2Int1 <= 0) {
              return;
            }
            APDataReportManager.2.this.b.b(new ga()
            {
              public void a(int paramAnonymous3Int1, int paramAnonymous3Int2, int paramAnonymous3Int3, Object paramAnonymous3Object, Bundle paramAnonymous3Bundle)
              {
                paramAnonymous3Object = (ArrayList)paramAnonymous3Object;
                if (paramAnonymous3Object == null)
                {
                  APDataReportManager.2.this.a.a(-1, 0, 0, null, null);
                  return;
                }
                paramAnonymous3Bundle = new StringBuffer();
                paramAnonymous3Int1 = 0;
                while (paramAnonymous3Int1 < paramAnonymous2Int1)
                {
                  ArrayList localArrayList = new ArrayList();
                  paramAnonymous3Int2 = 0;
                  paramAnonymous3Int3 = 0;
                  while ((paramAnonymous3Int2 < 50) && (paramAnonymous3Int2 < paramAnonymous3Object.size()))
                  {
                    int i = paramAnonymous3Int1 * 50 + paramAnonymous3Int2;
                    if ((i >= paramAnonymous2Int1) || (i >= paramAnonymous3Object.size())) {
                      break;
                    }
                    paramAnonymous3Int3 += 1;
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("record");
                    ((StringBuilder)localObject).append(paramAnonymous3Int2);
                    ((StringBuilder)localObject).append("=");
                    paramAnonymous3Bundle.append(((StringBuilder)localObject).toString());
                    paramAnonymous3Bundle.append(APDataReportManager.a(APDataReportManager.this, (ak)paramAnonymous3Object.get(i)));
                    paramAnonymous3Bundle.append("&");
                    localArrayList.add(paramAnonymous3Object.get(i));
                    paramAnonymous3Int2 += 1;
                  }
                  if (paramAnonymous3Bundle.length() > 0) {
                    paramAnonymous3Bundle.deleteCharAt(paramAnonymous3Bundle.length() - 1);
                  }
                  Object localObject = new StringBuffer();
                  ((StringBuffer)localObject).append("num=");
                  ((StringBuffer)localObject).append(paramAnonymous3Int3);
                  ((StringBuffer)localObject).append("&");
                  ((StringBuffer)localObject).append(paramAnonymous3Bundle.toString());
                  aj localaj = new aj();
                  localaj.a = ((StringBuffer)localObject).toString();
                  localaj.b = localArrayList;
                  APDataReportManager.2.1.this.b.add(localaj);
                  paramAnonymous3Bundle.setLength(0);
                  paramAnonymous3Int1 += 1;
                }
                APDataReportManager.2.this.a.a(0, 0, 0, APDataReportManager.2.1.this.b, null);
              }
            });
          }
        });
      }
    });
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
      insertData(APPluginReportParams.getInstance().c(), paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.data.report.APDataReportManager
 * JD-Core Version:    0.7.0.1
 */