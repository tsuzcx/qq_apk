package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DataHolder$zza
{
  private final String[] zzaDP;
  private final ArrayList<HashMap<String, Object>> zzaDX;
  private final String zzaDY;
  private final HashMap<Object, Integer> zzaDZ;
  private boolean zzaEa;
  private String zzaEb;
  
  private DataHolder$zza(String[] paramArrayOfString, String paramString)
  {
    this.zzaDP = ((String[])zzac.zzw(paramArrayOfString));
    this.zzaDX = new ArrayList();
    this.zzaDY = paramString;
    this.zzaDZ = new HashMap();
    this.zzaEa = false;
    this.zzaEb = null;
  }
  
  private int zzb(HashMap<String, Object> paramHashMap)
  {
    if (this.zzaDY == null) {
      return -1;
    }
    paramHashMap = paramHashMap.get(this.zzaDY);
    if (paramHashMap == null) {
      return -1;
    }
    Integer localInteger = (Integer)this.zzaDZ.get(paramHashMap);
    if (localInteger == null)
    {
      this.zzaDZ.put(paramHashMap, Integer.valueOf(this.zzaDX.size()));
      return -1;
    }
    return localInteger.intValue();
  }
  
  public zza zza(ContentValues paramContentValues)
  {
    zzc.zzt(paramContentValues);
    HashMap localHashMap = new HashMap(paramContentValues.size());
    paramContentValues = paramContentValues.valueSet().iterator();
    while (paramContentValues.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContentValues.next();
      localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
    }
    return zza(localHashMap);
  }
  
  public zza zza(HashMap<String, Object> paramHashMap)
  {
    zzc.zzt(paramHashMap);
    int i = zzb(paramHashMap);
    if (i == -1) {
      this.zzaDX.add(paramHashMap);
    }
    for (;;)
    {
      this.zzaEa = false;
      return this;
      this.zzaDX.remove(i);
      this.zzaDX.add(i, paramHashMap);
    }
  }
  
  public DataHolder zzcK(int paramInt)
  {
    return new DataHolder(this, paramInt, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder.zza
 * JD-Core Version:    0.7.0.1
 */