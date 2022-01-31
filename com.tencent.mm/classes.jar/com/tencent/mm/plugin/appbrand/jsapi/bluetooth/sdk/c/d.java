package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public String bYu;
  public int csT;
  public SparseArray<byte[]> hGI;
  public List<ParcelUuid> hGJ;
  public String hGK;
  public Map<ParcelUuid, byte[]> hGL;
  private JSONObject jsonObject;
  public String name;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    AppMethodBeat.i(94279);
    this.name = bo.nullAsNil(paramScanResultCompat.getDevice().getName());
    this.bYu = bo.nullAsNil(paramScanResultCompat.getDevice().getAddress());
    this.csT = paramScanResultCompat.hIe;
    this.hGI = paramScanResultCompat.hId.hHZ;
    this.hGJ = paramScanResultCompat.hId.hHY;
    this.hGK = bo.nullAsNil(paramScanResultCompat.hId.mDeviceName);
    this.hGL = paramScanResultCompat.hId.hIa;
    AppMethodBeat.o(94279);
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.bYu = paramString2;
  }
  
  public final JSONObject aBI()
  {
    AppMethodBeat.i(94280);
    if (this.jsonObject == null)
    {
      this.jsonObject = new JSONObject();
      this.jsonObject.put("deviceId", this.bYu);
      this.jsonObject.put("name", this.name);
      this.jsonObject.put("RSSI", this.csT);
      localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      Object localObject2 = localObject1;
      if (this.hGI != null)
      {
        localObject2 = localObject1;
        if (this.hGI.size() >= 0)
        {
          int k = 0;
          while (k < this.hGI.size())
          {
            int m = this.hGI.keyAt(0);
            int i = (byte)(m & 0xFF);
            int j = (byte)(m >> 8 & 0xFF);
            byte[] arrayOfByte = (byte[])this.hGI.valueAt(k);
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
      if (this.hGJ != null)
      {
        localObject2 = this.hGJ.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.jsonObject.put("advertisServiceUUIDs", localObject1);
      this.jsonObject.put("localName", this.hGK);
      localObject1 = new JSONObject();
      if ((this.hGL != null) && (this.hGL.size() > 0))
      {
        localObject2 = this.hGL.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.hGL.get(localObject3), 2)));
        }
      }
      this.jsonObject.put("serviceData", localObject1);
    }
    Object localObject1 = this.jsonObject;
    AppMethodBeat.o(94280);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */