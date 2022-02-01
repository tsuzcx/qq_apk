package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public String hEl;
  public String name;
  public SparseArray<byte[]> rNt;
  public List<ParcelUuid> rNu;
  public String rNv;
  public Map<ParcelUuid, byte[]> rNw;
  public Boolean rNx;
  public int rssi;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    AppMethodBeat.i(144591);
    this.name = Util.nullAsNil(paramScanResultCompat.crn().getName());
    this.hEl = Util.nullAsNil(paramScanResultCompat.crn().getAddress());
    this.rssi = paramScanResultCompat.rPb;
    this.rNx = paramScanResultCompat.rNx;
    i locali = paramScanResultCompat.rPa;
    if (locali != null)
    {
      if (a.cqY().rMo) {}
      for (paramScanResultCompat = locali.rOY;; paramScanResultCompat = locali.rOU)
      {
        this.rNt = paramScanResultCompat;
        this.rNu = locali.rOT;
        this.rNv = Util.nullAsNil(locali.mDeviceName);
        this.rNw = locali.rOV;
        AppMethodBeat.o(144591);
        return;
      }
    }
    this.rNv = "";
    AppMethodBeat.o(144591);
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.hEl = paramString2;
    this.rNx = null;
  }
  
  public final JSONObject cqc()
  {
    AppMethodBeat.i(144592);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("deviceId", this.hEl);
    localJSONObject.put("name", this.name);
    localJSONObject.put("RSSI", this.rssi);
    if (this.rNx != null) {
      localJSONObject.put("connectable", this.rNx);
    }
    Object localObject1 = new byte[0];
    Object localObject3 = new StringBuilder();
    Object localObject2 = localObject1;
    if (this.rNt != null)
    {
      localObject2 = localObject1;
      if (this.rNt.size() >= 0)
      {
        int k = 0;
        while (k < this.rNt.size())
        {
          int m = this.rNt.keyAt(k);
          int i = (byte)(m & 0xFF);
          int j = (byte)(m >> 8 & 0xFF);
          byte[] arrayOfByte = (byte[])this.rNt.valueAt(k);
          localObject2 = new byte[localObject1.length + 2 + arrayOfByte.length];
          System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
          m = localObject1.length;
          System.arraycopy(new byte[] { i, j }, 0, localObject2, m, 2);
          System.arraycopy(arrayOfByte, 0, localObject2, localObject1.length + 2, arrayOfByte.length);
          k += 1;
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
      }
    }
    ((StringBuilder)localObject3).append(new String(Base64.encode((byte[])localObject2, 2)));
    localJSONObject.put("advertisData", localObject3);
    localObject1 = new JSONArray();
    if (this.rNu != null)
    {
      localObject2 = this.rNu.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
      }
    }
    localJSONObject.put("advertisServiceUUIDs", localObject1);
    localJSONObject.put("localName", this.rNv);
    localObject1 = new JSONObject();
    if ((this.rNw != null) && (this.rNw.size() > 0))
    {
      localObject2 = this.rNw.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ParcelUuid)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.rNw.get(localObject3), 2)));
      }
    }
    localJSONObject.put("serviceData", localObject1);
    AppMethodBeat.o(144592);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */