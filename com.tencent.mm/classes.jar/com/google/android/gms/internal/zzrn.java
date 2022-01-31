package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzrn
  extends zzf<zzrn>
{
  private Map<Integer, Double> zzacW = new HashMap(4);
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzacW.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 6 + "metric" + str, localEntry.getValue());
    }
    return zzj(localHashMap);
  }
  
  public final void zza(zzrn paramzzrn)
  {
    paramzzrn.zzacW.putAll(this.zzacW);
  }
  
  public final Map<Integer, Double> zzni()
  {
    return Collections.unmodifiableMap(this.zzacW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzrn
 * JD-Core Version:    0.7.0.1
 */