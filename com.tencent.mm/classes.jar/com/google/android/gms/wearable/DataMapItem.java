package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.internal.zzblc;
import com.google.android.gms.internal.zzblc.zza;
import com.google.android.gms.internal.zzbld;
import com.google.android.gms.internal.zzbxs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final Uri mUri;
  private final DataMap zzbSX;
  
  private DataMapItem(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.zzbSX = zza((DataItem)paramDataItem.freeze());
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new DataMapItem(paramDataItem);
  }
  
  private DataMap zza(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {
      return new DataMap();
    }
    try
    {
      localObject1 = new ArrayList();
      j = paramDataItem.getAssets().size();
      i = 0;
    }
    catch (zzbxs localzzbxs)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject2 = String.valueOf(paramDataItem.getUri());
        String str = String.valueOf(Base64.encodeToString(paramDataItem.getData(), 0));
        new StringBuilder(String.valueOf(localObject2).length() + 50 + String.valueOf(str).length()).append("Unable to parse datamap from dataItem. uri=").append((String)localObject2).append(", data=").append(str);
        paramDataItem = String.valueOf(paramDataItem.getUri());
        throw new IllegalStateException(String.valueOf(paramDataItem).length() + 44 + "Unable to parse datamap from dataItem.  uri=" + paramDataItem, localzzbxs);
        localzzbxs.add(Asset.createFromRef(((DataItemAsset)localObject2).getId()));
        i += 1;
      }
      DataMap localDataMap = zzblc.zza(new zzblc.zza(zzbld.zzS(paramDataItem.getData()), localzzbxs));
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label159;
    }
    if (i < j)
    {
      localObject2 = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
      if (localObject2 == null)
      {
        localObject1 = String.valueOf(paramDataItem);
        throw new IllegalStateException(String.valueOf(localObject1).length() + 64 + "Cannot find DataItemAsset referenced in data at " + i + " for " + (String)localObject1);
      }
    }
  }
  
  public DataMap getDataMap()
  {
    return this.zzbSX;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * JD-Core Version:    0.7.0.1
 */