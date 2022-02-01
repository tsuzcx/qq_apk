package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fs.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] tmk = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] tml = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int tmm = 200;
  private int tmn = 180;
  private long tmo = 0L;
  
  private void a(fs paramfs, int paramInt, String paramString)
  {
    AppMethodBeat.i(24754);
    ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(tml);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(cRe()), Integer.valueOf(cRf()) });
        paramfs.dra.drc = localMatrixCursor;
        paramfs.dra.dqH = 1;
        if (paramfs.callback != null) {
          paramfs.callback.run();
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
    paramfs.dra.drc = null;
    paramfs.dra.dqH = 1;
    if (paramfs.callback != null) {
      paramfs.callback.run();
    }
    AppMethodBeat.o(24754);
  }
  
  public static c cRd()
  {
    AppMethodBeat.i(24752);
    c localc = a.cRh();
    AppMethodBeat.o(24752);
    return localc;
  }
  
  private long cRg()
  {
    try
    {
      long l = this.tmo;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void GG(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24756);
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.tmm = paramInt;
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.tmm);
      AppMethodBeat.o(24756);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void GH(int paramInt)
  {
    try
    {
      this.tmn = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final fs paramfs)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(24753);
        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + cRe() + "; reqIntervalSeconds=" + cRf());
        localObject = paramfs.dqZ.drb;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramfs, 1101, "Args is empty.");
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
          a(paramfs, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException1)
        {
          a(paramfs, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(24753);
        }
        paramfs = finally;
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
          a(paramfs, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException2)
        {
          a(paramfs, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(24753);
        }
        continue;
        label322:
        if ((cRg() != 0L) && (System.currentTimeMillis() - cRg() < cRf()) && (k == 2))
        {
          a(paramfs, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.tmn + " seconds.");
          AppMethodBeat.o(24753);
        }
        else if (m.ea(localObject[1]))
        {
          a(paramfs, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(24753);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > cRe())
            {
              a(paramfs, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cRe() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramfs, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cRe() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              bxx localbxx = new bxx();
              localbxx.ssid = m.ajI(localJSONObject.getString("ssid"));
              localbxx.bssid = localJSONObject.getString("bssid");
              localbxx.dqG = localJSONObject.getInt("rssi");
              localLinkedList.add(localbxx);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramfs, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(24753);
          }
          new j(localException3, k).c(new f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(24750);
              synchronized (c.this)
              {
                paramAnonymousn = ((j)paramAnonymousn).cRR();
                c.this.xy(System.currentTimeMillis());
                localObject1 = c.this;
                int i;
                if (paramAnonymousn.tmn <= 0) {
                  i = 180;
                }
                for (;;)
                {
                  ((c)localObject1).GH(i);
                  ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousn.tmm);
                  if (paramAnonymousn.tmm <= 0)
                  {
                    i = 200;
                    label99:
                    ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
                    c.this.GG(i);
                    if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                      break label1021;
                    }
                    paramAnonymousString = paramAnonymousn.GRS;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousn = new MatrixCursor(c.aTJ());
                    }
                    catch (Exception paramAnonymousString)
                    {
                      bxy localbxy;
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
                        localbxy = (bxy)paramAnonymousString.get(paramAnonymousInt1);
                        ((Map)localObject1).put(localbxy.ssid + "-" + localbxy.bssid, Integer.valueOf(paramAnonymousInt1));
                        paramAnonymousInt1 += 1;
                        continue;
                        i = paramAnonymousn.tmn;
                        break;
                        i = paramAnonymousn.tmm;
                        break label99;
                      }
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 >= localException3.size()) {
                        continue;
                      }
                      localObject2 = (bxx)localException3.get(paramAnonymousInt1);
                      localbxy = new bxy();
                      localbxy.ssid = ((bxx)localObject2).ssid;
                      localbxy.bssid = ((bxx)localObject2).bssid;
                      localbxy.dqG = ((bxx)localObject2).dqG;
                      localbxy.GRT = 0;
                      localbxy.GRU = null;
                      localbxy.tlg = 0;
                      localbxy.dmM = null;
                      if (((Map)localObject1).get(localbxy.ssid + "-" + localbxy.bssid) != null)
                      {
                        localObject2 = (Integer)((Map)localObject1).get(localbxy.ssid + "-" + localbxy.bssid);
                        if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                        {
                          localbxy.GRT = ((bxy)paramAnonymousString.get(((Integer)localObject2).intValue())).GRT;
                          localbxy.GRU = ((bxy)paramAnonymousString.get(((Integer)localObject2).intValue())).GRU;
                          localbxy.tlg = ((bxy)paramAnonymousString.get(((Integer)localObject2).intValue())).tlg;
                          localbxy.dmM = ((bxy)paramAnonymousString.get(((Integer)localObject2).intValue())).dmM;
                        }
                      }
                      if ((localbxy.tlg != 4) && (localbxy.tlg != 31))
                      {
                        paramAnonymousn.addRow(new Object[] { localbxy.ssid, localbxy.bssid, Integer.valueOf(localbxy.dqG), Integer.valueOf(0), null, Integer.valueOf(c.this.cRe()), Integer.valueOf(c.this.cRf()) });
                        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbxy.ssid, localbxy.bssid, Integer.valueOf(localbxy.dqG), Integer.valueOf(0), null, Integer.valueOf(c.this.cRe()), Integer.valueOf(c.this.cRf()) });
                      }
                      else
                      {
                        paramAnonymousn.addRow(new Object[] { localbxy.ssid, localbxy.bssid, Integer.valueOf(localbxy.dqG), Integer.valueOf(localbxy.GRT), localbxy.GRU, Integer.valueOf(c.this.cRe()), Integer.valueOf(c.this.cRf()) });
                        ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbxy.ssid, localbxy.bssid, Integer.valueOf(localbxy.dqG), Integer.valueOf(localbxy.GRT), localbxy.GRU, Integer.valueOf(c.this.cRe()), Integer.valueOf(c.this.cRf()) });
                        if ((localbxy.GRT == 1) && (k == 1))
                        {
                          a.a.cRb().e(localbxy.ssid, localbxy.bssid, localbxy.dmM, localbxy.tlg);
                          ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localbxy.ssid, localbxy.bssid, localbxy.dmM, Integer.valueOf(localbxy.tlg) });
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
                c.a(c.this, paramfs, 1108, "cursor exception.");
                AppMethodBeat.o(24750);
                return;
                c.a(paramfs, paramAnonymousn);
                AppMethodBeat.o(24750);
                return;
                label1021:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramfs, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.cRe() + ".");
                  AppMethodBeat.o(24750);
                  return;
                }
                c.a(c.this, paramfs, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + m.ajJ(paramAnonymousString) + ".");
                AppMethodBeat.o(24750);
                return;
              }
            }
          });
          AppMethodBeat.o(24753);
          continue;
          label714:
          a(paramfs, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(24753);
        }
      }
    }
  }
  
  public final int cRe()
  {
    try
    {
      AppMethodBeat.i(24755);
      ad.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.tmm);
      int i = this.tmm;
      AppMethodBeat.o(24755);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cRf()
  {
    try
    {
      int i = this.tmn;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void xy(long paramLong)
  {
    try
    {
      this.tmo = paramLong;
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
    private static c tmt;
    
    static
    {
      AppMethodBeat.i(24751);
      tmt = new c((byte)0);
      AppMethodBeat.o(24751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */