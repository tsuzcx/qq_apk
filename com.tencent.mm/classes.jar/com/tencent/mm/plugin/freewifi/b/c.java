package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] spH = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] spI = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int spJ = 200;
  private int spK = 180;
  private long spL = 0L;
  
  private void a(fp paramfp, int paramInt, String paramString)
  {
    AppMethodBeat.i(24754);
    ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(spI);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(cIP()), Integer.valueOf(cIQ()) });
        paramfp.dfE.dfG = localMatrixCursor;
        paramfp.dfE.dfl = 1;
        if (paramfp.callback != null) {
          paramfp.callback.run();
        }
        AppMethodBeat.o(24754);
        return;
      }
      catch (Exception paramString)
      {
        MatrixCursor localMatrixCursor;
        break label124;
      }
      paramString = paramString;
      localMatrixCursor = null;
    }
    label124:
    localMatrixCursor.close();
    label134:
    ac.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
    paramfp.dfE.dfG = null;
    paramfp.dfE.dfl = 1;
    if (paramfp.callback != null) {
      paramfp.callback.run();
    }
    AppMethodBeat.o(24754);
  }
  
  public static c cIO()
  {
    AppMethodBeat.i(24752);
    c localc = a.cIS();
    AppMethodBeat.o(24752);
    return localc;
  }
  
  private long cIR()
  {
    try
    {
      long l = this.spL;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Fr(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24756);
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.spJ = paramInt;
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.spJ);
      AppMethodBeat.o(24756);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Fs(int paramInt)
  {
    try
    {
      this.spK = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final fp paramfp)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(24753);
        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + cIP() + "; reqIntervalSeconds=" + cIQ());
        localObject = paramfp.dfD.dfF;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramfp, 1101, "Args is empty.");
        AppMethodBeat.o(24753);
      }
      finally
      {
        try
        {
          StringBuilder localStringBuilder;
          i = Integer.valueOf(localObject[0]).intValue();
          if (i != 1) {
            break label714;
          }
          if (localObject.length == 3) {
            break label258;
          }
          a(paramfp, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException1)
        {
          a(paramfp, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(24753);
        }
        paramfp = finally;
      }
      return;
      localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < localObject.length)
      {
        localStringBuilder.append("args[" + i + "] = " + localObject[i]);
        i += 1;
      }
      else
      {
        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label258:
        final int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label322;
          }
          a(paramfp, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException2)
        {
          a(paramfp, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(24753);
        }
        continue;
        label322:
        if ((cIR() != 0L) && (System.currentTimeMillis() - cIR() < cIQ()) && (k == 2))
        {
          a(paramfp, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.spK + " seconds.");
          AppMethodBeat.o(24753);
        }
        else if (m.cX(localObject[1]))
        {
          a(paramfp, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(24753);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > cIP())
            {
              a(paramfp, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cIP() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramfp, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cIP() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              btj localbtj = new btj();
              localbtj.ssid = m.afk(localJSONObject.getString("ssid"));
              localbtj.bssid = localJSONObject.getString("bssid");
              localbtj.dfk = localJSONObject.getInt("rssi");
              localLinkedList.add(localbtj);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramfp, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(24753);
          }
          new j(localException3, k).c(new g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(24750);
              synchronized (c.this)
              {
                paramAnonymousn = ((j)paramAnonymousn).cJC();
                c.this.vs(System.currentTimeMillis());
                localObject1 = c.this;
                int i;
                if (paramAnonymousn.spK <= 0) {
                  i = 180;
                }
                for (;;)
                {
                  ((c)localObject1).Fs(i);
                  ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousn.spJ);
                  if (paramAnonymousn.spJ <= 0)
                  {
                    i = 200;
                    label99:
                    ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
                    c.this.Fr(i);
                    if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                      break label1021;
                    }
                    paramAnonymousString = paramAnonymousn.Fir;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousn = new MatrixCursor(c.aQx());
                    }
                    catch (Exception paramAnonymousString)
                    {
                      btk localbtk;
                      Object localObject2;
                      paramAnonymousn = (n)localObject1;
                      continue;
                      paramAnonymousInt1 += 1;
                      continue;
                    }
                    try
                    {
                      localObject1 = new HashMap();
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 < paramAnonymousString.size())
                      {
                        localbtk = (btk)paramAnonymousString.get(paramAnonymousInt1);
                        ((Map)localObject1).put(localbtk.ssid + "-" + localbtk.bssid, Integer.valueOf(paramAnonymousInt1));
                        paramAnonymousInt1 += 1;
                        continue;
                        i = paramAnonymousn.spK;
                        break;
                        i = paramAnonymousn.spJ;
                        break label99;
                      }
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 >= localException3.size()) {
                        continue;
                      }
                      localObject2 = (btj)localException3.get(paramAnonymousInt1);
                      localbtk = new btk();
                      localbtk.ssid = ((btj)localObject2).ssid;
                      localbtk.bssid = ((btj)localObject2).bssid;
                      localbtk.dfk = ((btj)localObject2).dfk;
                      localbtk.Fis = 0;
                      localbtk.Fit = null;
                      localbtk.soD = 0;
                      localbtk.dbq = null;
                      if (((Map)localObject1).get(localbtk.ssid + "-" + localbtk.bssid) != null)
                      {
                        localObject2 = (Integer)((Map)localObject1).get(localbtk.ssid + "-" + localbtk.bssid);
                        if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                        {
                          localbtk.Fis = ((btk)paramAnonymousString.get(((Integer)localObject2).intValue())).Fis;
                          localbtk.Fit = ((btk)paramAnonymousString.get(((Integer)localObject2).intValue())).Fit;
                          localbtk.soD = ((btk)paramAnonymousString.get(((Integer)localObject2).intValue())).soD;
                          localbtk.dbq = ((btk)paramAnonymousString.get(((Integer)localObject2).intValue())).dbq;
                        }
                      }
                      if ((localbtk.soD != 4) && (localbtk.soD != 31))
                      {
                        paramAnonymousn.addRow(new Object[] { localbtk.ssid, localbtk.bssid, Integer.valueOf(localbtk.dfk), Integer.valueOf(0), null, Integer.valueOf(c.this.cIP()), Integer.valueOf(c.this.cIQ()) });
                        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbtk.ssid, localbtk.bssid, Integer.valueOf(localbtk.dfk), Integer.valueOf(0), null, Integer.valueOf(c.this.cIP()), Integer.valueOf(c.this.cIQ()) });
                      }
                      else
                      {
                        paramAnonymousn.addRow(new Object[] { localbtk.ssid, localbtk.bssid, Integer.valueOf(localbtk.dfk), Integer.valueOf(localbtk.Fis), localbtk.Fit, Integer.valueOf(c.this.cIP()), Integer.valueOf(c.this.cIQ()) });
                        ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbtk.ssid, localbtk.bssid, Integer.valueOf(localbtk.dfk), Integer.valueOf(localbtk.Fis), localbtk.Fit, Integer.valueOf(c.this.cIP()), Integer.valueOf(c.this.cIQ()) });
                        if ((localbtk.Fis == 1) && (k == 1))
                        {
                          a.a.cIM().e(localbtk.ssid, localbtk.bssid, localbtk.dbq, localbtk.soD);
                          ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localbtk.ssid, localbtk.bssid, localbtk.dbq, Integer.valueOf(localbtk.soD) });
                        }
                      }
                    }
                    catch (Exception paramAnonymousString) {}
                  }
                }
                if (paramAnonymousn != null) {
                  paramAnonymousn.close();
                }
                ac.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramAnonymousString });
                c.a(c.this, paramfp, 1108, "cursor exception.");
                AppMethodBeat.o(24750);
                return;
                c.a(paramfp, paramAnonymousn);
                AppMethodBeat.o(24750);
                return;
                label1021:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramfp, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.cIP() + ".");
                  AppMethodBeat.o(24750);
                  return;
                }
                c.a(c.this, paramfp, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + m.afl(paramAnonymousString) + ".");
                AppMethodBeat.o(24750);
                return;
              }
            }
          });
          AppMethodBeat.o(24753);
          continue;
          label714:
          a(paramfp, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(24753);
        }
      }
    }
  }
  
  public final int cIP()
  {
    try
    {
      AppMethodBeat.i(24755);
      ac.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.spJ);
      int i = this.spJ;
      AppMethodBeat.o(24755);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cIQ()
  {
    try
    {
      int i = this.spK;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void vs(long paramLong)
  {
    try
    {
      this.spL = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
  {
    private static c spQ;
    
    static
    {
      AppMethodBeat.i(24751);
      spQ = new c((byte)0);
      AppMethodBeat.o(24751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */