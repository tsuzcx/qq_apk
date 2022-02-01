package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public String cIZ;
  public int dfk;
  private JSONObject jsonObject;
  public SparseArray<byte[]> kkv;
  public List<ParcelUuid> kkw;
  public String kkx;
  public Map<ParcelUuid, byte[]> kky;
  public String name;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    AppMethodBeat.i(144591);
    this.name = bs.nullAsNil(paramScanResultCompat.getDevice().getName());
    this.cIZ = bs.nullAsNil(paramScanResultCompat.getDevice().getAddress());
    this.dfk = paramScanResultCompat.klT;
    this.kkv = paramScanResultCompat.klS.klN;
    this.kkw = paramScanResultCompat.klS.klM;
    this.kkx = bs.nullAsNil(paramScanResultCompat.klS.mDeviceName);
    this.kky = paramScanResultCompat.klS.klO;
    AppMethodBeat.o(144591);
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.cIZ = paramString2;
  }
  
  public final JSONObject beV()
  {
    AppMethodBeat.i(144592);
    if (this.jsonObject == null)
    {
      this.jsonObject = new JSONObject();
      this.jsonObject.put("deviceId", this.cIZ);
      this.jsonObject.put("name", this.name);
      this.jsonObject.put("RSSI", this.dfk);
      localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      Object localObject2 = localObject1;
      if (this.kkv != null)
      {
        localObject2 = localObject1;
        if (this.kkv.size() >= 0)
        {
          int k = 0;
          while (k < this.kkv.size())
          {
            int m = this.kkv.keyAt(0);
            int i = (byte)(m & 0xFF);
            int j = (byte)(m >> 8 & 0xFF);
            byte[] arrayOfByte = (byte[])this.kkv.valueAt(k);
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
      if (this.kkw != null)
      {
        localObject2 = this.kkw.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.jsonObject.put("advertisServiceUUIDs", localObject1);
      this.jsonObject.put("localName", this.kkx);
      localObject1 = new JSONObject();
      if ((this.kky != null) && (this.kky.size() > 0))
      {
        localObject2 = this.kky.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.kky.get(localObject3), 2)));
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