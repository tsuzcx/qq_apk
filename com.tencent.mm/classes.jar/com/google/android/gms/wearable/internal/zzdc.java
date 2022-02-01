package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdc
  implements DataItem
{
  private byte[] data;
  private Uri uri;
  private Map<String, DataItemAsset> zzdo;
  
  public zzdc(DataItem paramDataItem)
  {
    AppMethodBeat.i(101174);
    this.uri = paramDataItem.getUri();
    this.data = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null) {
        localHashMap.put((String)localEntry.getKey(), (DataItemAsset)((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    this.zzdo = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(101174);
  }
  
  public final Map<String, DataItemAsset> getAssets()
  {
    return this.zzdo;
  }
  
  public final byte[] getData()
  {
    return this.data;
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final boolean isDataValid()
  {
    return true;
  }
  
  public final DataItem setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101175);
    paramArrayOfByte = new UnsupportedOperationException();
    AppMethodBeat.o(101175);
    throw paramArrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101176);
    boolean bool = Log.isLoggable("DataItem", 3);
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    Object localObject1 = String.valueOf(this.uri);
    localStringBuilder.append(String.valueOf(localObject1).length() + 4 + "uri=" + (String)localObject1);
    if (this.data == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(this.data.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = this.zzdo.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (this.zzdo.isEmpty())) {
        break label334;
      }
      localStringBuilder.append(", assets=[");
      Iterator localIterator = this.zzdo.entrySet().iterator();
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = ", ")
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((DataItemAsset)((Map.Entry)localObject2).getValue()).getId();
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject2).length() + (String)localObject1 + str + ": " + (String)localObject2);
      }
    }
    localStringBuilder.append("]");
    label334:
    localStringBuilder.append(" }");
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(101176);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdc
 * JD-Core Version:    0.7.0.1
 */