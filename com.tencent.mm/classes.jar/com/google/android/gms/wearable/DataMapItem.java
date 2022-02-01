package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public class DataMapItem
{
  private final Uri uri;
  private final DataMap zzr;
  
  private DataMapItem(DataItem paramDataItem)
  {
    AppMethodBeat.i(100846);
    this.uri = paramDataItem.getUri();
    this.zzr = zza((DataItem)paramDataItem.freeze());
    AppMethodBeat.o(100846);
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    AppMethodBeat.i(100845);
    Asserts.checkNotNull(paramDataItem, "dataItem must not be null");
    paramDataItem = new DataMapItem(paramDataItem);
    AppMethodBeat.o(100845);
    return paramDataItem;
  }
  
  private static DataMap zza(DataItem paramDataItem)
  {
    AppMethodBeat.i(100847);
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0))
    {
      paramDataItem = new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
      AppMethodBeat.o(100847);
      throw paramDataItem;
    }
    if (paramDataItem.getData() == null)
    {
      paramDataItem = new DataMap();
      AppMethodBeat.o(100847);
      return paramDataItem;
    }
    try
    {
      localObject1 = new ArrayList();
      j = paramDataItem.getAssets().size();
      i = 0;
    }
    catch (zzs localzzs)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject2 = String.valueOf(paramDataItem.getUri());
        String str = Base64.encodeToString(paramDataItem.getData(), 0);
        new StringBuilder(String.valueOf(localObject2).length() + 50 + String.valueOf(str).length()).append("Unable to parse datamap from dataItem. uri=").append((String)localObject2).append(", data=").append(str);
        paramDataItem = String.valueOf(paramDataItem.getUri());
        paramDataItem = new IllegalStateException(String.valueOf(paramDataItem).length() + 44 + "Unable to parse datamap from dataItem.  uri=" + paramDataItem, localzzs);
        AppMethodBeat.o(100847);
        throw paramDataItem;
        localzzs.add(Asset.createFromRef(((DataItemAsset)localObject2).getId()));
        i += 1;
      }
      DataMap localDataMap = zze.zza(new zzf(zzg.zza(paramDataItem.getData()), localzzs));
      AppMethodBeat.o(100847);
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label180;
    }
    if (i < j)
    {
      localObject2 = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
      if (localObject2 == null)
      {
        localObject1 = String.valueOf(paramDataItem);
        localObject1 = new IllegalStateException(String.valueOf(localObject1).length() + 64 + "Cannot find DataItemAsset referenced in data at " + i + " for " + (String)localObject1);
        AppMethodBeat.o(100847);
        throw ((Throwable)localObject1);
      }
    }
  }
  
  public DataMap getDataMap()
  {
    return this.zzr;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * JD-Core Version:    0.7.0.1
 */