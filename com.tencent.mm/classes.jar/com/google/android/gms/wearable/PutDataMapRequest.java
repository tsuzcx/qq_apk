package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzblc;
import com.google.android.gms.internal.zzblc.zza;
import com.google.android.gms.internal.zzbxt;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap zzbSX;
  private final PutDataRequest zzbSY;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.zzbSY = paramPutDataRequest;
    this.zzbSX = new DataMap();
    if (paramDataMap != null) {
      this.zzbSX.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.zzy(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    Object localObject = zzblc.zza(this.zzbSX);
    this.zzbSY.setData(zzbxt.zzf(((zzblc.zza)localObject).zzbVw));
    int j = ((zzblc.zza)localObject).zzbVx.size();
    int i = 0;
    while (i < j)
    {
      String str1 = Integer.toString(i);
      Asset localAsset = (Asset)((zzblc.zza)localObject).zzbVx.get(i);
      if (str1 == null)
      {
        localObject = String.valueOf(localAsset);
        throw new IllegalStateException(String.valueOf(localObject).length() + 26 + "asset key cannot be null: " + (String)localObject);
      }
      if (localAsset == null)
      {
        localObject = String.valueOf(str1);
        if (((String)localObject).length() != 0) {}
        for (localObject = "asset cannot be null: key=".concat((String)localObject);; localObject = new String("asset cannot be null: key=")) {
          throw new IllegalStateException((String)localObject);
        }
      }
      if (Log.isLoggable("DataMap", 3))
      {
        String str2 = String.valueOf(localAsset);
        new StringBuilder(String.valueOf(str1).length() + 33 + String.valueOf(str2).length()).append("asPutDataRequest: adding asset: ").append(str1).append(" ").append(str2);
      }
      this.zzbSY.putAsset(str1, localAsset);
      i += 1;
    }
    return this.zzbSY;
  }
  
  public DataMap getDataMap()
  {
    return this.zzbSX;
  }
  
  public Uri getUri()
  {
    return this.zzbSY.getUri();
  }
  
  public boolean isUrgent()
  {
    return this.zzbSY.isUrgent();
  }
  
  public PutDataMapRequest setUrgent()
  {
    this.zzbSY.setUrgent();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataMapRequest
 * JD-Core Version:    0.7.0.1
 */