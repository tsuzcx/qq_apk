package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public int bLz;
  public String bwK;
  private JSONObject gmI;
  public SparseArray<byte[]> gmJ;
  public List<ParcelUuid> gmK;
  public String gmL;
  public Map<ParcelUuid, byte[]> gmM;
  public String name;
  
  public d(ScanResultCompat paramScanResultCompat)
  {
    this.name = bk.pm(paramScanResultCompat.getDevice().getName());
    this.bwK = bk.pm(paramScanResultCompat.getDevice().getAddress());
    this.bLz = paramScanResultCompat.goh;
    this.gmJ = paramScanResultCompat.gog.goc;
    this.gmK = paramScanResultCompat.gog.gob;
    this.gmL = bk.pm(paramScanResultCompat.gog.gnO);
    this.gmM = paramScanResultCompat.gog.god;
  }
  
  public d(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.bwK = paramString2;
  }
  
  public final JSONObject ahT()
  {
    if (this.gmI == null)
    {
      this.gmI = new JSONObject();
      this.gmI.put("deviceId", this.bwK);
      this.gmI.put("name", this.name);
      this.gmI.put("RSSI", this.bLz);
      Object localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      Object localObject2 = localObject1;
      if (this.gmJ != null)
      {
        localObject2 = localObject1;
        if (this.gmJ.size() >= 0)
        {
          int k = 0;
          while (k < this.gmJ.size())
          {
            int m = this.gmJ.keyAt(0);
            int i = (byte)(m & 0xFF);
            int j = (byte)(m >> 8 & 0xFF);
            byte[] arrayOfByte = (byte[])this.gmJ.valueAt(k);
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
      this.gmI.put("advertisData", localObject3);
      localObject1 = new JSONArray();
      if (this.gmK != null)
      {
        localObject2 = this.gmK.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.gmI.put("advertisServiceUUIDs", localObject1);
      this.gmI.put("localName", this.gmL);
      localObject1 = new JSONObject();
      if ((this.gmM != null) && (this.gmM.size() > 0))
      {
        localObject2 = this.gmM.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.gmM.get(localObject3), 2)));
        }
      }
      this.gmI.put("serviceData", localObject1);
    }
    return this.gmI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */