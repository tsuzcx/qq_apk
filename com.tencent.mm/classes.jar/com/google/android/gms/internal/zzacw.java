package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzacw
  extends zza
{
  public static final Parcelable.Creator<zzacw> CREATOR = new zzacx();
  private final HashMap<String, Map<String, zzacs.zza<?, ?>>> zzaHh;
  private final ArrayList<zzacw.zza> zzaHi;
  private final String zzaHj;
  final int zzaiI;
  
  zzacw(int paramInt, ArrayList<zzacw.zza> paramArrayList, String paramString)
  {
    this.zzaiI = paramInt;
    this.zzaHi = null;
    this.zzaHh = zzi(paramArrayList);
    this.zzaHj = ((String)zzac.zzw(paramString));
    zzyD();
  }
  
  private static HashMap<String, Map<String, zzacs.zza<?, ?>>> zzi(ArrayList<zzacw.zza> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      zzacw.zza localzza = (zzacw.zza)paramArrayList.get(i);
      localHashMap.put(localzza.className, localzza.zzyG());
      i += 1;
    }
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.zzaHh.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)this.zzaHh.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacx.zza(this, paramParcel, paramInt);
  }
  
  public Map<String, zzacs.zza<?, ?>> zzdw(String paramString)
  {
    return (Map)this.zzaHh.get(paramString);
  }
  
  public void zzyD()
  {
    Iterator localIterator1 = this.zzaHh.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.zzaHh.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((zzacs.zza)((Map)localObject).get((String)localIterator2.next())).zza(this);
      }
    }
  }
  
  ArrayList<zzacw.zza> zzyE()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzaHh.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzacw.zza(str, (Map)this.zzaHh.get(str)));
    }
    return localArrayList;
  }
  
  public String zzyF()
  {
    return this.zzaHj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw
 * JD-Core Version:    0.7.0.1
 */