package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaq
  extends zzc
  implements DataItem
{
  private final int zzaZk;
  
  public zzaq(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzaZk = paramInt2;
  }
  
  public final Map<String, DataItemAsset> getAssets()
  {
    HashMap localHashMap = new HashMap(this.zzaZk);
    int i = 0;
    while (i < this.zzaZk)
    {
      zzam localzzam = new zzam(this.zzaBi, this.zzaDL + i);
      if (localzzam.getDataItemKey() != null) {
        localHashMap.put(localzzam.getDataItemKey(), localzzam);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public final byte[] getData()
  {
    return getByteArray("data");
  }
  
  public final Uri getUri()
  {
    return Uri.parse(getString("path"));
  }
  
  public final DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public final String toString(boolean paramBoolean)
  {
    Object localObject1 = getData();
    Object localObject2 = getAssets();
    StringBuilder localStringBuilder = new StringBuilder("DataItemInternal{ ");
    String str = String.valueOf(getUri());
    localStringBuilder.append(String.valueOf(str).length() + 4 + "uri=" + str);
    if (localObject1 == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = ((Map)localObject2).size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!paramBoolean) || (((Map)localObject2).isEmpty())) {
        break label327;
      }
      localStringBuilder.append(", assets=[");
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ", ")
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = String.valueOf(((DataItemAsset)((Map.Entry)localObject3).getValue()).getId());
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject3).length() + (String)localObject1 + str + ": " + (String)localObject3);
      }
    }
    localStringBuilder.append("]");
    label327:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public final DataItem zzUw()
  {
    return new zzan(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaq
 * JD-Core Version:    0.7.0.1
 */