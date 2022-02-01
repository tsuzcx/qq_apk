package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public String cVh;
  public int drL;
  private JSONObject jsonObject;
  public SparseArray<byte[]> kIK;
  public List<ParcelUuid> kIL;
  public String kIM;
  public Map<ParcelUuid, byte[]> kIN;
  public String name;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    AppMethodBeat.i(144591);
    this.name = bu.nullAsNil(paramScanResultCompat.getDevice().getName());
    this.cVh = bu.nullAsNil(paramScanResultCompat.getDevice().getAddress());
    this.drL = paramScanResultCompat.kKi;
    this.kIK = paramScanResultCompat.kKh.kKc;
    this.kIL = paramScanResultCompat.kKh.kKb;
    this.kIM = bu.nullAsNil(paramScanResultCompat.kKh.mDeviceName);
    this.kIN = paramScanResultCompat.kKh.kKd;
    AppMethodBeat.o(144591);
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.cVh = paramString2;
  }
  
  public final JSONObject bji()
  {
    AppMethodBeat.i(144592);
    if (this.jsonObject == null)
    {
      this.jsonObject = new JSONObject();
      this.jsonObject.put("deviceId", this.cVh);
      this.jsonObject.put("name", this.name);
      this.jsonObject.put("RSSI", this.drL);
      localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      Object localObject2 = localObject1;
      if (this.kIK != null)
      {
        localObject2 = localObject1;
        if (this.kIK.size() >= 0)
        {
          int k = 0;
          while (k < this.kIK.size())
          {
            int m = this.kIK.keyAt(0);
            int i = (byte)(m & 0xFF);
            int j = (byte)(m >> 8 & 0xFF);
            byte[] arrayOfByte = (byte[])this.kIK.valueAt(k);
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
      if (this.kIL != null)
      {
        localObject2 = this.kIL.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.jsonObject.put("advertisServiceUUIDs", localObject1);
      this.jsonObject.put("localName", this.kIM);
      localObject1 = new JSONObject();
      if ((this.kIN != null) && (this.kIN.size() > 0))
      {
        localObject2 = this.kIN.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.kIN.get(localObject3), 2)));
        }
      }
      this.jsonObject.put("serviceData", localObject1);
    }
    Object localObject1 = this.jsonObject;
    AppMethodBeat.o(144592);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */