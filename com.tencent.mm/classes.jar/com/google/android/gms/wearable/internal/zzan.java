package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzan
  implements DataItem
{
  private Uri mUri;
  private Map<String, DataItemAsset> zzbUv;
  private byte[] zzbeL;
  
  public zzan(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.zzbeL = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null) {
        localHashMap.put((String)localEntry.getKey(), (DataItemAsset)((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    this.zzbUv = Collections.unmodifiableMap(localHashMap);
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.zzbUv;
  }
  
  public byte[] getData()
  {
    return this.zzbeL;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    Object localObject1 = String.valueOf(this.mUri);
    localStringBuilder.append(String.valueOf(localObject1).length() + 4 + "uri=" + (String)localObject1);
    if (this.zzbeL == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(this.zzbeL.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = this.zzbUv.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!paramBoolean) || (this.zzbUv.isEmpty())) {
        break label325;
      }
      localStringBuilder.append(", assets=[");
      Iterator localIterator = this.zzbUv.entrySet().iterator();
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = ", ")
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = String.valueOf(((DataItemAsset)((Map.Entry)localObject2).getValue()).getId());
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject2).length() + (String)localObject1 + str + ": " + (String)localObject2);
      }
    }
    localStringBuilder.append("]");
    label325:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public DataItem zzUw()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzan
 * JD-Core Version:    0.7.0.1
 */