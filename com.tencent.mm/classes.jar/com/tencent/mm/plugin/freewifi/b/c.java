package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.ff;
import com.tencent.mm.h.a.ff.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] knW = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] knX = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int knY = 200;
  private int knZ = 180;
  private long koa = 0L;
  
  private void a(ff paramff, int paramInt, String paramString)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    label112:
    label122:
    do
    {
      try
      {
        localMatrixCursor = new MatrixCursor(knX);
        if (localMatrixCursor == null) {
          break label122;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(aTL()), Integer.valueOf(aTM()) });
          paramff.bLU.bLW = localMatrixCursor;
          paramff.bLU.bLA = 1;
          if (paramff.bFJ != null) {
            paramff.bFJ.run();
          }
          return;
        }
        catch (Exception paramString)
        {
          MatrixCursor localMatrixCursor;
          break label112;
        }
        paramString = paramString;
        localMatrixCursor = null;
      }
      localMatrixCursor.close();
      y.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
      paramff.bLU.bLW = null;
      paramff.bLU.bLA = 1;
    } while (paramff.bFJ == null);
    paramff.bFJ.run();
  }
  
  public static c aTK()
  {
    return c.a.aTP();
  }
  
  private long aTN()
  {
    try
    {
      long l = this.koa;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final ff paramff)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + aTL() + "; reqIntervalSeconds=" + aTM());
        localObject = paramff.bLT.bLV;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramff, 1101, "Args is empty.");
      }
      finally
      {
        try
        {
          StringBuilder localStringBuilder;
          i = Integer.valueOf(localObject[0]).intValue();
          if (i != 1) {
            break label641;
          }
          if (localObject.length == 3) {
            break label234;
          }
          a(paramff, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
        }
        catch (Exception localException1)
        {
          a(paramff, 1102, "Args[0] is not an integer.");
        }
        paramff = finally;
      }
      return;
      localStringBuilder = new StringBuilder();
      int i = 0;
      label641:
      if (i < localObject.length)
      {
        localStringBuilder.append("args[" + i + "] = " + localObject[i]);
        i += 1;
      }
      else
      {
        y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label234:
        final int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label286;
          }
          a(paramff, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
        }
        catch (Exception localException2)
        {
          a(paramff, 1107, "Args[2] is not a valid int value.");
        }
        continue;
        label286:
        if ((aTN() != 0L) && (System.currentTimeMillis() - aTN() < aTM()) && (k == 2))
        {
          a(paramff, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.knZ + " seconds.");
        }
        else if (com.tencent.mm.plugin.freewifi.m.isEmpty(localObject[1]))
        {
          a(paramff, 1105, "Args[1] should be an ap list json string, but now it is empty.");
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() <= aTL()) {
              break label473;
            }
            a(paramff, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aTL() + ".");
          }
          catch (Exception localException3)
          {
            a(paramff, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
          }
          continue;
          label473:
          i = j;
          if (((JSONArray)localObject).length() == 0)
          {
            a(paramff, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aTL() + ".");
          }
          else
          {
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              avu localavu = new avu();
              localavu.ssid = com.tencent.mm.plugin.freewifi.m.Dm(localJSONObject.getString("ssid"));
              localavu.bssid = localJSONObject.getString("bssid");
              localavu.bLz = localJSONObject.getInt("rssi");
              localException3.add(localavu);
              i += 1;
            }
            new j(localException3, k).b(new f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm)
              {
                synchronized (c.this)
                {
                  paramAnonymousm = ((j)paramAnonymousm).aUC();
                  c.this.eN(System.currentTimeMillis());
                  localObject1 = c.this;
                  int i;
                  if (paramAnonymousm.knZ <= 0) {
                    i = 180;
                  }
                  for (;;)
                  {
                    ((c)localObject1).rq(i);
                    y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + paramAnonymousm.knY);
                    if (paramAnonymousm.knY <= 0)
                    {
                      i = 200;
                      label93:
                      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = " + i);
                      c.this.rp(i);
                      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
                        break label1016;
                      }
                      paramAnonymousString = paramAnonymousm.tro;
                      localObject1 = null;
                    }
                    for (;;)
                    {
                      try
                      {
                        paramAnonymousm = new MatrixCursor(c.aTO());
                      }
                      catch (Exception paramAnonymousString)
                      {
                        avv localavv;
                        Object localObject2;
                        paramAnonymousm = (com.tencent.mm.ah.m)localObject1;
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
                          localavv = (avv)paramAnonymousString.get(paramAnonymousInt1);
                          ((Map)localObject1).put(localavv.ssid + "-" + localavv.bssid, Integer.valueOf(paramAnonymousInt1));
                          paramAnonymousInt1 += 1;
                          continue;
                          i = paramAnonymousm.knZ;
                          break;
                          i = paramAnonymousm.knY;
                          break label93;
                        }
                        paramAnonymousInt1 = 0;
                        if (paramAnonymousInt1 >= localException3.size()) {
                          continue;
                        }
                        localObject2 = (avu)localException3.get(paramAnonymousInt1);
                        localavv = new avv();
                        localavv.ssid = ((avu)localObject2).ssid;
                        localavv.bssid = ((avu)localObject2).bssid;
                        localavv.bLz = ((avu)localObject2).bLz;
                        localavv.trp = 0;
                        localavv.trq = null;
                        localavv.kmR = 0;
                        localavv.bHI = null;
                        if (((Map)localObject1).get(localavv.ssid + "-" + localavv.bssid) != null)
                        {
                          localObject2 = (Integer)((Map)localObject1).get(localavv.ssid + "-" + localavv.bssid);
                          if (paramAnonymousString.get(((Integer)localObject2).intValue()) != null)
                          {
                            localavv.trp = ((avv)paramAnonymousString.get(((Integer)localObject2).intValue())).trp;
                            localavv.trq = ((avv)paramAnonymousString.get(((Integer)localObject2).intValue())).trq;
                            localavv.kmR = ((avv)paramAnonymousString.get(((Integer)localObject2).intValue())).kmR;
                            localavv.bHI = ((avv)paramAnonymousString.get(((Integer)localObject2).intValue())).bHI;
                          }
                        }
                        if ((localavv.kmR != 4) && (localavv.kmR != 31))
                        {
                          paramAnonymousm.addRow(new Object[] { localavv.ssid, localavv.bssid, Integer.valueOf(localavv.bLz), Integer.valueOf(0), null, Integer.valueOf(c.this.aTL()), Integer.valueOf(c.this.aTM()) });
                          y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localavv.ssid, localavv.bssid, Integer.valueOf(localavv.bLz), Integer.valueOf(0), null, Integer.valueOf(c.this.aTL()), Integer.valueOf(c.this.aTM()) });
                        }
                        else
                        {
                          paramAnonymousm.addRow(new Object[] { localavv.ssid, localavv.bssid, Integer.valueOf(localavv.bLz), Integer.valueOf(localavv.trp), localavv.trq, Integer.valueOf(c.this.aTL()), Integer.valueOf(c.this.aTM()) });
                          y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[] { localavv.ssid, localavv.bssid, Integer.valueOf(localavv.bLz), Integer.valueOf(localavv.trp), localavv.trq, Integer.valueOf(c.this.aTL()), Integer.valueOf(c.this.aTM()) });
                          if ((localavv.trp == 1) && (k == 1))
                          {
                            a.a.aTI().e(localavv.ssid, localavv.bssid, localavv.bHI, localavv.kmR);
                            y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[] { localavv.ssid, localavv.bssid, localavv.bHI, Integer.valueOf(localavv.kmR) });
                          }
                        }
                      }
                      catch (Exception paramAnonymousString) {}
                    }
                  }
                  if (paramAnonymousm != null) {
                    paramAnonymousm.close();
                  }
                  y.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramAnonymousString });
                  c.a(c.this, paramff, 1108, "cursor exception.");
                  return;
                  c.a(paramff, paramAnonymousm);
                  return;
                }
                label1016:
                if (paramAnonymousInt2 == -30035)
                {
                  c.a(c.this, paramff, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + c.this.aTL() + ".");
                  return;
                }
                c.a(c.this, paramff, 1121, "Server returns errtype= " + paramAnonymousInt1 + ", errcode=" + paramAnonymousInt2 + ", errMsg=" + com.tencent.mm.plugin.freewifi.m.Dn(paramAnonymousString) + ".");
              }
            });
            continue;
            a(paramff, 1103, "Wechant installed currently only supports version 1.");
          }
        }
      }
    }
  }
  
  public final int aTL()
  {
    try
    {
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.knY);
      int i = this.knY;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int aTM()
  {
    try
    {
      int i = this.knZ;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void eN(long paramLong)
  {
    try
    {
      this.koa = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void rp(int paramInt)
  {
    try
    {
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = " + paramInt);
      this.knY = paramInt;
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.knY);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void rq(int paramInt)
  {
    try
    {
      this.knZ = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */