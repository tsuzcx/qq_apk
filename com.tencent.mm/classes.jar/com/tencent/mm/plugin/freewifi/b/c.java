package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fo.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] rgP = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] rgQ = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int rgR = 200;
  private int rgS = 180;
  private long rgT = 0L;
  
  private void a(fo paramfo, int paramInt, String paramString)
  {
    AppMethodBeat.i(24754);
    ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(rgQ);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(cvD()), Integer.valueOf(cvE()) });
        paramfo.dij.dil = localMatrixCursor;
        paramfo.dij.dhQ = 1;
        if (paramfo.callback != null) {
          paramfo.callback.run();
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
    ad.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
    paramfo.dij.dil = null;
    paramfo.dij.dhQ = 1;
    if (paramfo.callback != null) {
      paramfo.callback.run();
    }
    AppMethodBeat.o(24754);
  }
  
  public static c cvC()
  {
    AppMethodBeat.i(24752);
    c localc = a.cvG();
    AppMethodBeat.o(24752);
    return localc;
  }
  
  private long cvF()
  {
    try
    {
      long l = this.rgT;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Dv(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24756);
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.rgR = paramInt;
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.rgR);
      AppMethodBeat.o(24756);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Dw(int paramInt)
  {
    try
    {
      this.rgS = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final fo paramfo)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(24753);
        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + cvD() + "; reqIntervalSeconds=" + cvE());
        localObject = paramfo.dii.dik;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramfo, 1101, "Args is empty.");
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
          a(paramfo, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException1)
        {
          a(paramfo, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(24753);
        }
        paramfo = finally;
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
        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label258:
        final int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label322;
          }
          a(paramfo, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException2)
        {
          a(paramfo, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(24753);
        }
        continue;
        label322:
        if ((cvF() != 0L) && (System.currentTimeMillis() - cvF() < cvE()) && (k == 2))
        {
          a(paramfo, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.rgS + " seconds.");
          AppMethodBeat.o(24753);
        }
        else if (m.dq(localObject[1]))
        {
          a(paramfo, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(24753);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > cvD())
            {
              a(paramfo, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cvD() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramfo, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cvD() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              bot localbot = new bot();
              localbot.ssid = m.aas(localJSONObject.getString("ssid"));
              localbot.bssid = localJSONObject.getString("bssid");
              localbot.dhP = localJSONObject.getInt("rssi");
              localLinkedList.add(localbot);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramfo, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(24753);
          }
          new j(localException3, k).c(new g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(24750);
              synchronized (c.this)
              {
                paramAnonymousn = ((j)paramAnonymousn).cwq();
                c.this.qP(System.currentTimeMillis());
                localObject1 = c.this;
                int i;
                if (paramAnonymousn.rgS <= 0) {
                  i = 180;
                }
                for (;;)
                {
                  ((c)localObject1).Dw(i);
                  ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousn.rgR);
                  if (paramAnonymousn.rgR <= 0)
                  {
                    i = 200;
                    label99:
                    ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
                    c.this.Dv(i);
                    if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                      break label1021;
                    }
                    paramAnonymousString = paramAnonymousn.DMc;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousn = new MatrixCursor(c.aJG());
                    }
                    catch (Exception paramAnonymousString)
                    {
                      bou localbou;
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
                        localbou = (bou)paramAnonymousString.get(paramAnonymousInt1);
                        ((Map)localObject1).put(localbou.ssid + "-" + localbou.bssid, Integer.valueOf(paramAnonymousInt1));
                        paramAnonymousInt1 += 1;
                        continue;
                        i = paramAnonymousn.rgS;
                        break;
                        i = paramAnonymousn.rgR;
                        break label99;
                      }
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 >= localException3.size()) {
                        continue;
                      }
                      localObject2 = (bot)localException3.get(paramAnonymousInt1);
                      localbou = new bou();
                      localbou.ssid = ((bot)localObject2).ssid;
                      localbou.bssid = ((bot)localObject2).bssid;
                      localbou.dhP = ((bot)localObject2).dhP;
                      localbou.DMd = 0;
                      localbou.DMe = null;
                      localbou.rfL = 0;
                      localbou.ddU = null;
                      if (((Map)localObject1).get(localbou.ssid + "-" + localbou.bssid) != null)
                      {
                        localObject2 = (Integer)((Map)localObject1).get(localbou.ssid + "-" + localbou.bssid);
                        if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                        {
                          localbou.DMd = ((bou)paramAnonymousString.get(((Integer)localObject2).intValue())).DMd;
                          localbou.DMe = ((bou)paramAnonymousString.get(((Integer)localObject2).intValue())).DMe;
                          localbou.rfL = ((bou)paramAnonymousString.get(((Integer)localObject2).intValue())).rfL;
                          localbou.ddU = ((bou)paramAnonymousString.get(((Integer)localObject2).intValue())).ddU;
                        }
                      }
                      if ((localbou.rfL != 4) && (localbou.rfL != 31))
                      {
                        paramAnonymousn.addRow(new Object[] { localbou.ssid, localbou.bssid, Integer.valueOf(localbou.dhP), Integer.valueOf(0), null, Integer.valueOf(c.this.cvD()), Integer.valueOf(c.this.cvE()) });
                        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbou.ssid, localbou.bssid, Integer.valueOf(localbou.dhP), Integer.valueOf(0), null, Integer.valueOf(c.this.cvD()), Integer.valueOf(c.this.cvE()) });
                      }
                      else
                      {
                        paramAnonymousn.addRow(new Object[] { localbou.ssid, localbou.bssid, Integer.valueOf(localbou.dhP), Integer.valueOf(localbou.DMd), localbou.DMe, Integer.valueOf(c.this.cvD()), Integer.valueOf(c.this.cvE()) });
                        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbou.ssid, localbou.bssid, Integer.valueOf(localbou.dhP), Integer.valueOf(localbou.DMd), localbou.DMe, Integer.valueOf(c.this.cvD()), Integer.valueOf(c.this.cvE()) });
                        if ((localbou.DMd == 1) && (k == 1))
                        {
                          a.a.cvA().e(localbou.ssid, localbou.bssid, localbou.ddU, localbou.rfL);
                          ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localbou.ssid, localbou.bssid, localbou.ddU, Integer.valueOf(localbou.rfL) });
                        }
                      }
                    }
                    catch (Exception paramAnonymousString) {}
                  }
                }
                if (paramAnonymousn != null) {
                  paramAnonymousn.close();
                }
                ad.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramAnonymousString });
                c.a(c.this, paramfo, 1108, "cursor exception.");
                AppMethodBeat.o(24750);
                return;
                c.a(paramfo, paramAnonymousn);
                AppMethodBeat.o(24750);
                return;
                label1021:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramfo, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.cvD() + ".");
                  AppMethodBeat.o(24750);
                  return;
                }
                c.a(c.this, paramfo, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + m.aat(paramAnonymousString) + ".");
                AppMethodBeat.o(24750);
                return;
              }
            }
          });
          AppMethodBeat.o(24753);
          continue;
          label714:
          a(paramfo, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(24753);
        }
      }
    }
  }
  
  public final int cvD()
  {
    try
    {
      AppMethodBeat.i(24755);
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.rgR);
      int i = this.rgR;
      AppMethodBeat.o(24755);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cvE()
  {
    try
    {
      int i = this.rgS;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void qP(long paramLong)
  {
    try
    {
      this.rgT = paramLong;
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
    private static c rgY;
    
    static
    {
      AppMethodBeat.i(24751);
      rgY = new c((byte)0);
      AppMethodBeat.o(24751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */