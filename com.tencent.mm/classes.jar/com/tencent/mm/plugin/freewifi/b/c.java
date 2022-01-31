package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fi.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private static final String[] mJJ = { "ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds" };
  private static final String[] mJK = { "errcode", "errmsg", "maxApCount", "intervalSeconds" };
  private int mJL = 200;
  private int mJM = 180;
  private long mJN = 0L;
  
  private void a(fi paramfi, int paramInt, String paramString)
  {
    AppMethodBeat.i(20677);
    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    try
    {
      localMatrixCursor = new MatrixCursor(mJK);
      if (localMatrixCursor == null) {
        break label134;
      }
    }
    catch (Exception paramString)
    {
      try
      {
        localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(bAp()), Integer.valueOf(bAq()) });
        paramfi.cto.ctq = localMatrixCursor;
        paramfi.cto.csU = 1;
        if (paramfi.callback != null) {
          paramfi.callback.run();
        }
        AppMethodBeat.o(20677);
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
    ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[] { paramString });
    paramfi.cto.ctq = null;
    paramfi.cto.csU = 1;
    if (paramfi.callback != null) {
      paramfi.callback.run();
    }
    AppMethodBeat.o(20677);
  }
  
  public static c bAo()
  {
    AppMethodBeat.i(20675);
    c localc = c.a.bAs();
    AppMethodBeat.o(20675);
    return localc;
  }
  
  private long bAr()
  {
    try
    {
      long l = this.mJN;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(fi paramfi)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(20676);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + bAp() + "; reqIntervalSeconds=" + bAq());
        localObject = paramfi.ctn.ctp;
        if ((localObject != null) && (localObject.length != 0)) {
          continue;
        }
        a(paramfi, 1101, "Args is empty.");
        AppMethodBeat.o(20676);
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
          a(paramfi, 1104, "Args.length should be 3, but now it is " + localObject.length + ".");
          AppMethodBeat.o(20676);
        }
        catch (Exception localException1)
        {
          a(paramfi, 1102, "Args[0] is not an integer.");
          AppMethodBeat.o(20676);
        }
        paramfi = finally;
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
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + localStringBuilder.toString());
        continue;
        label258:
        int k;
        try
        {
          k = Integer.valueOf(localObject[2]).intValue();
          if ((k == 1) || (k == 2)) {
            break label322;
          }
          a(paramfi, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
          AppMethodBeat.o(20676);
        }
        catch (Exception localException2)
        {
          a(paramfi, 1107, "Args[2] is not a valid int value.");
          AppMethodBeat.o(20676);
        }
        continue;
        label322:
        if ((bAr() != 0L) && (System.currentTimeMillis() - bAr() < bAq()) && (k == 2))
        {
          a(paramfi, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.mJM + " seconds.");
          AppMethodBeat.o(20676);
        }
        else if (m.isEmpty(localObject[1]))
        {
          a(paramfi, 1105, "Args[1] should be an ap list json string, but now it is empty.");
          AppMethodBeat.o(20676);
        }
        else
        {
          LinkedList localLinkedList = new LinkedList();
          try
          {
            localObject = new JSONArray(localObject[1]);
            if (((JSONArray)localObject).length() > bAp())
            {
              a(paramfi, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + bAp() + ".");
              AppMethodBeat.o(20676);
              continue;
            }
            i = j;
            if (((JSONArray)localObject).length() == 0)
            {
              a(paramfi, 1110, "jsonArray.length()=" + ((JSONArray)localObject).length() + ". Too many ap. The number of ap requested per time should be between 1 and " + bAp() + ".");
              AppMethodBeat.o(20676);
              continue;
            }
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              bci localbci = new bci();
              localbci.ssid = m.Ou(localJSONObject.getString("ssid"));
              localbci.bssid = localJSONObject.getString("bssid");
              localbci.csT = localJSONObject.getInt("rssi");
              localLinkedList.add(localbci);
              i += 1;
            }
          }
          catch (Exception localException3)
          {
            a(paramfi, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
            AppMethodBeat.o(20676);
          }
          new j(localException3, k).c(new c.1(this, localException3, k, paramfi));
          AppMethodBeat.o(20676);
          continue;
          label714:
          a(paramfi, 1103, "Wechant installed currently only supports version 1.");
          AppMethodBeat.o(20676);
        }
      }
    }
  }
  
  public final int bAp()
  {
    try
    {
      AppMethodBeat.i(20678);
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.mJL);
      int i = this.mJL;
      AppMethodBeat.o(20678);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bAq()
  {
    try
    {
      int i = this.mJM;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void kj(long paramLong)
  {
    try
    {
      this.mJN = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void wj(int paramInt)
  {
    try
    {
      AppMethodBeat.i(20679);
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(paramInt)));
      this.mJL = paramInt;
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.mJL);
      AppMethodBeat.o(20679);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void wk(int paramInt)
  {
    try
    {
      this.mJM = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.c
 * JD-Core Version:    0.7.0.1
 */