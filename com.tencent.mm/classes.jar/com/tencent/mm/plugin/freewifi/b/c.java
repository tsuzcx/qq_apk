package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] txc = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] txd = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int txe = 200;
  private int txf = 180;
  private long txg = 0L;
  
  private void a(ft paramft, int paramInt, String paramString)
  {
    AppMethodBeat.i(24754);
    ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(txd);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(cTJ()), Integer.valueOf(cTK()) });
        paramft.dsf.dsh = localMatrixCursor;
        paramft.dsf.drM = 1;
        if (paramft.callback != null) {
          paramft.callback.run();
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
    ae.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
    paramft.dsf.dsh = null;
    paramft.dsf.drM = 1;
    if (paramft.callback != null) {
      paramft.callback.run();
    }
    AppMethodBeat.o(24754);
  }
  
  public static c cTI()
  {
    AppMethodBeat.i(24752);
    c localc = a.cTM();
    AppMethodBeat.o(24752);
    return localc;
  }
  
  private long cTL()
  {
    try
    {
      long l = this.txg;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Hd(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24756);
      ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.txe = paramInt;
      ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.txe);
      AppMethodBeat.o(24756);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void He(int paramInt)
  {
    try
    {
      this.txf = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final ft paramft)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(24753);
        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + cTJ() + "; reqIntervalSeconds=" + cTK());
        localObject = paramft.dse.dsg;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramft, 1101, "Args is empty.");
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
          a(paramft, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException1)
        {
          a(paramft, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(24753);
        }
        paramft = finally;
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
        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label258:
        final int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label322;
          }
          a(paramft, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException2)
        {
          a(paramft, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(24753);
        }
        continue;
        label322:
        if ((cTL() != 0L) && (System.currentTimeMillis() - cTL() < cTK()) && (k == 2))
        {
          a(paramft, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.txf + " seconds.");
          AppMethodBeat.o(24753);
        }
        else if (m.ef(localObject[1]))
        {
          a(paramft, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(24753);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > cTJ())
            {
              a(paramft, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cTJ() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramft, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + cTJ() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              byr localbyr = new byr();
              localbyr.ssid = m.akG(localJSONObject.getString("ssid"));
              localbyr.bssid = localJSONObject.getString("bssid");
              localbyr.drL = localJSONObject.getInt("rssi");
              localLinkedList.add(localbyr);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramft, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(24753);
          }
          new j(localException3, k).c(new f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(24750);
              synchronized (c.this)
              {
                paramAnonymousn = ((j)paramAnonymousn).cUw();
                c.this.xS(System.currentTimeMillis());
                localObject1 = c.this;
                int i;
                if (paramAnonymousn.txf <= 0) {
                  i = 180;
                }
                for (;;)
                {
                  ((c)localObject1).He(i);
                  ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousn.txe);
                  if (paramAnonymousn.txe <= 0)
                  {
                    i = 200;
                    label99:
                    ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
                    c.this.Hd(i);
                    if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                      break label1021;
                    }
                    paramAnonymousString = paramAnonymousn.Hlt;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousn = new MatrixCursor(c.aUi());
                    }
                    catch (Exception paramAnonymousString)
                    {
                      bys localbys;
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
                        localbys = (bys)paramAnonymousString.get(paramAnonymousInt1);
                        ((Map)localObject1).put(localbys.ssid + "-" + localbys.bssid, Integer.valueOf(paramAnonymousInt1));
                        paramAnonymousInt1 += 1;
                        continue;
                        i = paramAnonymousn.txf;
                        break;
                        i = paramAnonymousn.txe;
                        break label99;
                      }
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 >= localException3.size()) {
                        continue;
                      }
                      localObject2 = (byr)localException3.get(paramAnonymousInt1);
                      localbys = new bys();
                      localbys.ssid = ((byr)localObject2).ssid;
                      localbys.bssid = ((byr)localObject2).bssid;
                      localbys.drL = ((byr)localObject2).drL;
                      localbys.Hlu = 0;
                      localbys.Hlv = null;
                      localbys.tvY = 0;
                      localbys.dnO = null;
                      if (((Map)localObject1).get(localbys.ssid + "-" + localbys.bssid) != null)
                      {
                        localObject2 = (Integer)((Map)localObject1).get(localbys.ssid + "-" + localbys.bssid);
                        if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                        {
                          localbys.Hlu = ((bys)paramAnonymousString.get(((Integer)localObject2).intValue())).Hlu;
                          localbys.Hlv = ((bys)paramAnonymousString.get(((Integer)localObject2).intValue())).Hlv;
                          localbys.tvY = ((bys)paramAnonymousString.get(((Integer)localObject2).intValue())).tvY;
                          localbys.dnO = ((bys)paramAnonymousString.get(((Integer)localObject2).intValue())).dnO;
                        }
                      }
                      if ((localbys.tvY != 4) && (localbys.tvY != 31))
                      {
                        paramAnonymousn.addRow(new Object[] { localbys.ssid, localbys.bssid, Integer.valueOf(localbys.drL), Integer.valueOf(0), null, Integer.valueOf(c.this.cTJ()), Integer.valueOf(c.this.cTK()) });
                        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbys.ssid, localbys.bssid, Integer.valueOf(localbys.drL), Integer.valueOf(0), null, Integer.valueOf(c.this.cTJ()), Integer.valueOf(c.this.cTK()) });
                      }
                      else
                      {
                        paramAnonymousn.addRow(new Object[] { localbys.ssid, localbys.bssid, Integer.valueOf(localbys.drL), Integer.valueOf(localbys.Hlu), localbys.Hlv, Integer.valueOf(c.this.cTJ()), Integer.valueOf(c.this.cTK()) });
                        ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localbys.ssid, localbys.bssid, Integer.valueOf(localbys.drL), Integer.valueOf(localbys.Hlu), localbys.Hlv, Integer.valueOf(c.this.cTJ()), Integer.valueOf(c.this.cTK()) });
                        if ((localbys.Hlu == 1) && (k == 1))
                        {
                          a.a.cTG().e(localbys.ssid, localbys.bssid, localbys.dnO, localbys.tvY);
                          ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localbys.ssid, localbys.bssid, localbys.dnO, Integer.valueOf(localbys.tvY) });
                        }
                      }
                    }
                    catch (Exception paramAnonymousString) {}
                  }
                }
                if (paramAnonymousn != null) {
                  paramAnonymousn.close();
                }
                ae.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramAnonymousString });
                c.a(c.this, paramft, 1108, "cursor exception.");
                AppMethodBeat.o(24750);
                return;
                c.a(paramft, paramAnonymousn);
                AppMethodBeat.o(24750);
                return;
                label1021:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramft, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.cTJ() + ".");
                  AppMethodBeat.o(24750);
                  return;
                }
                c.a(c.this, paramft, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + m.akH(paramAnonymousString) + ".");
                AppMethodBeat.o(24750);
                return;
              }
            }
          });
          AppMethodBeat.o(24753);
          continue;
          label714:
          a(paramft, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(24753);
        }
      }
    }
  }
  
  public final int cTJ()
  {
    try
    {
      AppMethodBeat.i(24755);
      ae.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.txe);
      int i = this.txe;
      AppMethodBeat.o(24755);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int cTK()
  {
    try
    {
      int i = this.txf;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void xS(long paramLong)
  {
    try
    {
      this.txg = paramLong;
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
    private static c txl;
    
    static
    {
      AppMethodBeat.i(24751);
      txl = new c((byte)0);
      AppMethodBeat.o(24751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */