package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzrm
  extends zzf<zzrm>
{
  private Map<Integer, String> zzacV = new HashMap(4);
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzacV.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 9 + "dimension" + str, localEntry.getValue());
    }
    return zzj(localHashMap);
  }
  
  public final void zza(zzrm paramzzrm)
  {
    paramzzrm.zzacV.putAll(this.zzacV);
  }
  
  public final Map<Integer, String> zznh()
  {
    return Collections.unmodifiableMap(this.zzacV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzrm
 * JD-Core Version:    0.7.0.1
 */