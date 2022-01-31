package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@VisibleForTesting
public class PutDataMapRequest
{
  private final DataMap zzr;
  private final PutDataRequest zzs;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    AppMethodBeat.i(70865);
    this.zzs = paramPutDataRequest;
    this.zzr = new DataMap();
    if (paramDataMap != null) {
      this.zzr.putAll(paramDataMap);
    }
    AppMethodBeat.o(70865);
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    AppMethodBeat.i(70868);
    Asserts.checkNotNull(paramString, "path must not be null");
    paramString = new PutDataMapRequest(PutDataRequest.create(paramString), null);
    AppMethodBeat.o(70868);
    return paramString;
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    AppMethodBeat.i(70866);
    Asserts.checkNotNull(paramDataMapItem, "source must not be null");
    paramDataMapItem = new PutDataMapRequest(PutDataRequest.zza(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
    AppMethodBeat.o(70866);
    return paramDataMapItem;
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    AppMethodBeat.i(70867);
    Asserts.checkNotNull(paramString, "pathPrefix must not be null");
    paramString = new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
    AppMethodBeat.o(70867);
    return paramString;
  }
  
  public PutDataRequest asPutDataRequest()
  {
    AppMethodBeat.i(70872);
    Object localObject = zze.zza(this.zzr);
    this.zzs.setData(zzt.zzb(((zzf)localObject).zzfw));
    int j = ((zzf)localObject).zzfx.size();
    int i = 0;
    while (i < j)
    {
      String str1 = Integer.toString(i);
      Asset localAsset = (Asset)((zzf)localObject).zzfx.get(i);
      if (str1 == null)
      {
        localObject = String.valueOf(localAsset);
        localObject = new IllegalStateException(String.valueOf(localObject).length() + 26 + "asset key cannot be null: " + (String)localObject);
        AppMethodBeat.o(70872);
        throw ((Throwable)localObject);
      }
      if (localAsset == null)
      {
        localObject = String.valueOf(str1);
        if (((String)localObject).length() != 0) {}
        for (localObject = "asset cannot be null: key=".concat((String)localObject);; localObject = new String("asset cannot be null: key="))
        {
          localObject = new IllegalStateException((String)localObject);
          AppMethodBeat.o(70872);
          throw ((Throwable)localObject);
        }
      }
      if (Log.isLoggable("DataMap", 3))
      {
        String str2 = String.valueOf(localAsset);
        new StringBuilder(String.valueOf(str1).length() + 33 + String.valueOf(str2).length()).append("asPutDataRequest: adding asset: ").append(str1).append(" ").append(str2);
      }
      this.zzs.putAsset(str1, localAsset);
      i += 1;
    }
    localObject = this.zzs;
    AppMethodBeat.o(70872);
    return localObject;
  }
  
  public DataMap getDataMap()
  {
    return this.zzr;
  }
  
  public Uri getUri()
  {
    AppMethodBeat.i(70869);
    Uri localUri = this.zzs.getUri();
    AppMethodBeat.o(70869);
    return localUri;
  }
  
  public boolean isUrgent()
  {
    AppMethodBeat.i(70871);
    boolean bool = this.zzs.isUrgent();
    AppMethodBeat.o(70871);
    return bool;
  }
  
  public PutDataMapRequest setUrgent()
  {
    AppMethodBeat.i(70870);
    this.zzs.setUrgent();
    AppMethodBeat.o(70870);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataMapRequest
 * JD-Core Version:    0.7.0.1
 */