package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] wOg = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] wOh = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int wOi = 200;
  private int wOj = 180;
  private long wOk = 0L;
  
  private void a(fw paramfw, int paramInt, String paramString)
  {
    AppMethodBeat.i(24754);
    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(wOh);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(dMS()), Integer.valueOf(dMT()) });
        paramfw.dJr.dJt = localMatrixCursor;
        paramfw.dJr.dIY = 1;
        if (paramfw.callback != null) {
          paramfw.callback.run();
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
    Log.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
    paramfw.dJr.dJt = null;
    paramfw.dJr.dIY = 1;
    if (paramfw.callback != null) {
      paramfw.callback.run();
    }
    AppMethodBeat.o(24754);
  }
  
  public static c dMR()
  {
    AppMethodBeat.i(24752);
    c localc = a.dMV();
    AppMethodBeat.o(24752);
    return localc;
  }
  
  private long dMU()
  {
    try
    {
      long l = this.wOk;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void GB(long paramLong)
  {
    try
    {
      this.wOk = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Nc(int paramInt)
  {
    try
    {
      AppMethodBeat.i(24756);
      Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.wOi = paramInt;
      Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.wOi);
      AppMethodBeat.o(24756);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Nd(int paramInt)
  {
    try
    {
      this.wOj = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final fw paramfw)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(24753);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + dMS() + "; reqIntervalSeconds=" + dMT());
        localObject = paramfw.dJq.dJs;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramfw, 1101, "Args is empty.");
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
          a(paramfw, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException1)
        {
          a(paramfw, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(24753);
        }
        paramfw = finally;
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
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label258:
        final int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label322;
          }
          a(paramfw, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(24753);
        }
        catch (Exception localException2)
        {
          a(paramfw, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(24753);
        }
        continue;
        label322:
        if ((dMU() != 0L) && (System.currentTimeMillis() - dMU() < dMT()) && (k == 2))
        {
          a(paramfw, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.wOj + " seconds.");
          AppMethodBeat.o(24753);
        }
        else if (m.eP(localObject[1]))
        {
          a(paramfw, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(24753);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > dMS())
            {
              a(paramfw, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + dMS() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramfw, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + dMS() + ".");
              AppMethodBeat.o(24753);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              cmj localcmj = new cmj();
              localcmj.ssid = m.removeSsidQuote(localJSONObject.getString("ssid"));
              localcmj.bssid = localJSONObject.getString("bssid");
              localcmj.dIX = localJSONObject.getInt("rssi");
              localLinkedList.add(localcmj);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramfw, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(24753);
          }
          new j(localException3, k).c(new i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
            {
              AppMethodBeat.i(24750);
              synchronized (c.this)
              {
                paramAnonymousq = ((j)paramAnonymousq).dNF();
                c.this.GB(System.currentTimeMillis());
                localObject1 = c.this;
                int i;
                if (paramAnonymousq.wOj <= 0) {
                  i = 180;
                }
                for (;;)
                {
                  ((c)localObject1).Nd(i);
                  Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousq.wOi);
                  if (paramAnonymousq.wOi <= 0)
                  {
                    i = 200;
                    label99:
                    Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = ".concat(String.valueOf(i)));
                    c.this.Nc(i);
                    if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                      break label1021;
                    }
                    paramAnonymousString = paramAnonymousq.MrF;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousq = new MatrixCursor(c.wOg);
                    }
                    catch (Exception paramAnonymousString)
                    {
                      cmk localcmk;
                      Object localObject2;
                      paramAnonymousq = (q)localObject1;
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
                        localcmk = (cmk)paramAnonymousString.get(paramAnonymousInt1);
                        ((Map)localObject1).put(localcmk.ssid + "-" + localcmk.bssid, Integer.valueOf(paramAnonymousInt1));
                        paramAnonymousInt1 += 1;
                        continue;
                        i = paramAnonymousq.wOj;
                        break;
                        i = paramAnonymousq.wOi;
                        break label99;
                      }
                      paramAnonymousInt1 = 0;
                      if (paramAnonymousInt1 >= localException3.size()) {
                        continue;
                      }
                      localObject2 = (cmj)localException3.get(paramAnonymousInt1);
                      localcmk = new cmk();
                      localcmk.ssid = ((cmj)localObject2).ssid;
                      localcmk.bssid = ((cmj)localObject2).bssid;
                      localcmk.dIX = ((cmj)localObject2).dIX;
                      localcmk.MrG = 0;
                      localcmk.MrH = null;
                      localcmk.wNc = 0;
                      localcmk.dFd = null;
                      if (((Map)localObject1).get(localcmk.ssid + "-" + localcmk.bssid) != null)
                      {
                        localObject2 = (Integer)((Map)localObject1).get(localcmk.ssid + "-" + localcmk.bssid);
                        if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                        {
                          localcmk.MrG = ((cmk)paramAnonymousString.get(((Integer)localObject2).intValue())).MrG;
                          localcmk.MrH = ((cmk)paramAnonymousString.get(((Integer)localObject2).intValue())).MrH;
                          localcmk.wNc = ((cmk)paramAnonymousString.get(((Integer)localObject2).intValue())).wNc;
                          localcmk.dFd = ((cmk)paramAnonymousString.get(((Integer)localObject2).intValue())).dFd;
                        }
                      }
                      if ((localcmk.wNc != 4) && (localcmk.wNc != 31))
                      {
                        paramAnonymousq.addRow(new Object[] { localcmk.ssid, localcmk.bssid, Integer.valueOf(localcmk.dIX), Integer.valueOf(0), null, Integer.valueOf(c.this.dMS()), Integer.valueOf(c.this.dMT()) });
                        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localcmk.ssid, localcmk.bssid, Integer.valueOf(localcmk.dIX), Integer.valueOf(0), null, Integer.valueOf(c.this.dMS()), Integer.valueOf(c.this.dMT()) });
                      }
                      else
                      {
                        paramAnonymousq.addRow(new Object[] { localcmk.ssid, localcmk.bssid, Integer.valueOf(localcmk.dIX), Integer.valueOf(localcmk.MrG), localcmk.MrH, Integer.valueOf(c.this.dMS()), Integer.valueOf(c.this.dMT()) });
                        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localcmk.ssid, localcmk.bssid, Integer.valueOf(localcmk.dIX), Integer.valueOf(localcmk.MrG), localcmk.MrH, Integer.valueOf(c.this.dMS()), Integer.valueOf(c.this.dMT()) });
                        if ((localcmk.MrG == 1) && (k == 1))
                        {
                          a.a.dMP().g(localcmk.ssid, localcmk.bssid, localcmk.dFd, localcmk.wNc);
                          Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localcmk.ssid, localcmk.bssid, localcmk.dFd, Integer.valueOf(localcmk.wNc) });
                        }
                      }
                    }
                    catch (Exception paramAnonymousString) {}
                  }
                }
                if (paramAnonymousq != null) {
                  paramAnonymousq.close();
                }
                Log.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramAnonymousString });
                c.a(c.this, paramfw, 1108, "cursor exception.");
                AppMethodBeat.o(24750);
                return;
                c.a(paramfw, paramAnonymousq);
                AppMethodBeat.o(24750);
                return;
                label1021:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramfw, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.dMS() + ".");
                  AppMethodBeat.o(24750);
                  return;
                }
                c.a(c.this, paramfw, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + m.axL(paramAnonymousString) + ".");
                AppMethodBeat.o(24750);
                return;
              }
            }
          });
          AppMethodBeat.o(24753);
          continue;
          label714:
          a(paramfw, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(24753);
        }
      }
    }
  }
  
  public final int dMS()
  {
    try
    {
      AppMethodBeat.i(24755);
      Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.wOi);
      int i = this.wOi;
      AppMethodBeat.o(24755);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int dMT()
  {
    try
    {
      int i = this.wOj;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
  {
    private static c wOp;
    
    static
    {
      AppMethodBeat.i(24751);
      wOp = new c((byte)0);
      AppMethodBeat.o(24751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */