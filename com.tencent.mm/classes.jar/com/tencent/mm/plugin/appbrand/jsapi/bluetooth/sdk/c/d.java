package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public String cLR;
  public int dhP;
  public SparseArray<byte[]> jJV;
  public List<ParcelUuid> jJW;
  public String jJX;
  public Map<ParcelUuid, byte[]> jJY;
  private JSONObject jsonObject;
  public String name;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    AppMethodBeat.i(144591);
    this.name = bt.nullAsNil(paramScanResultCompat.getDevice().getName());
    this.cLR = bt.nullAsNil(paramScanResultCompat.getDevice().getAddress());
    this.dhP = paramScanResultCompat.jLs;
    this.jJV = paramScanResultCompat.jLr.jLm;
    this.jJW = paramScanResultCompat.jLr.jLl;
    this.jJX = bt.nullAsNil(paramScanResultCompat.jLr.mDeviceName);
    this.jJY = paramScanResultCompat.jLr.jLn;
    AppMethodBeat.o(144591);
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.cLR = paramString2;
  }
  
  public final JSONObject aXY()
  {
    AppMethodBeat.i(144592);
    if (this.jsonObject == null)
    {
      this.jsonObject = new JSONObject();
      this.jsonObject.put("deviceId", this.cLR);
      this.jsonObject.put("name", this.name);
      this.jsonObject.put("RSSI", this.dhP);
      localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      Object localObject2 = localObject1;
      if (this.jJV != null)
      {
        localObject2 = localObject1;
        if (this.jJV.size() >= 0)
        {
          int k = 0;
          while (k < this.jJV.size())
          {
            int m = this.jJV.keyAt(0);
            int i = (byte)(m & 0xFF);
            int j = (byte)(m >> 8 & 0xFF);
            byte[] arrayOfByte = (byte[])this.jJV.valueAt(k);
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
      this.jsonObject.put("advertisData", localObject3);
      localObject1 = new JSONArray();
      if (this.jJW != null)
      {
        localObject2 = this.jJW.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.jsonObject.put("advertisServiceUUIDs", localObject1);
      this.jsonObject.put("localName", this.jJX);
      localObject1 = new JSONObject();
      if ((this.jJY != null) && (this.jJY.size() > 0))
      {
        localObject2 = this.jJY.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.jJY.get(localObject3), 2)));
        }
      }
      this.jsonObject.put("serviceData", localObject1);
    }
    Object localObject1 = this.jsonObject;
    AppMethodBeat.o(144592);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */