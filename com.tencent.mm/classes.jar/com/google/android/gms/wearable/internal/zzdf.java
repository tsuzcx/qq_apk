package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdf
  extends DataBufferRef
  implements DataItem
{
  private final int zzdl;
  
  public zzdf(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzdl = paramInt2;
  }
  
  public final Map<String, DataItemAsset> getAssets()
  {
    AppMethodBeat.i(101184);
    HashMap localHashMap = new HashMap(this.zzdl);
    int i = 0;
    while (i < this.zzdl)
    {
      zzdb localzzdb = new zzdb(this.mDataHolder, this.mDataRow + i);
      if (localzzdb.getDataItemKey() != null) {
        localHashMap.put(localzzdb.getDataItemKey(), localzzdb);
      }
      i += 1;
    }
    AppMethodBeat.o(101184);
    return localHashMap;
  }
  
  public final byte[] getData()
  {
    AppMethodBeat.i(101183);
    byte[] arrayOfByte = getByteArray("data");
    AppMethodBeat.o(101183);
    return arrayOfByte;
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(101182);
    Uri localUri = Uri.parse(getString("path"));
    AppMethodBeat.o(101182);
    return localUri;
  }
  
  public final DataItem setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101185);
    paramArrayOfByte = new UnsupportedOperationException();
    AppMethodBeat.o(101185);
    throw paramArrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101186);
    boolean bool = Log.isLoggable("DataItem", 3);
    Object localObject1 = getData();
    Object localObject2 = getAssets();
    StringBuilder localStringBuilder = new StringBuilder("DataItemRef{ ");
    String str = String.valueOf(getUri());
    localStringBuilder.append(String.valueOf(str).length() + 4 + "uri=" + str);
    if (localObject1 == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
    {
      localObject1 = String.valueOf(localObject1);
      localStringBuilder.append(String.valueOf(localObject1).length() + 9 + ", dataSz=" + (String)localObject1);
      int i = ((Map)localObject2).size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      if ((!bool) || (((Map)localObject2).isEmpty())) {
        break label336;
      }
      localStringBuilder.append(", assets=[");
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ", ")
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
        str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = ((DataItemAsset)((Map.Entry)localObject3).getValue()).getId();
        localStringBuilder.append(String.valueOf(localObject1).length() + 2 + String.valueOf(str).length() + String.valueOf(localObject3).length() + (String)localObject1 + str + ": " + (String)localObject3);
      }
    }
    localStringBuilder.append("]");
    label336:
    localStringBuilder.append(" }");
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(101186);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdf
 * JD-Core Version:    0.7.0.1
 */