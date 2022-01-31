package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzacw$zza
  extends zza
{
  public static final Parcelable.Creator<zza> CREATOR = new zzacy();
  final String className;
  final int versionCode;
  final ArrayList<zzacw.zzb> zzaHk;
  
  zzacw$zza(int paramInt, String paramString, ArrayList<zzacw.zzb> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zzaHk = paramArrayList;
  }
  
  zzacw$zza(String paramString, Map<String, zzacs.zza<?, ?>> paramMap)
  {
    this.versionCode = 1;
    this.className = paramString;
    this.zzaHk = zzX(paramMap);
  }
  
  private static ArrayList<zzacw.zzb> zzX(Map<String, zzacs.zza<?, ?>> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzacw.zzb(str, (zzacs.zza)paramMap.get(str)));
    }
    return localArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacy.zza(this, paramParcel, paramInt);
  }
  
  HashMap<String, zzacs.zza<?, ?>> zzyG()
  {
    HashMap localHashMap = new HashMap();
    int j = this.zzaHk.size();
    int i = 0;
    while (i < j)
    {
      zzacw.zzb localzzb = (zzacw.zzb)this.zzaHk.get(i);
      localHashMap.put(localzzb.zzaB, localzzb.zzaHl);
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw.zza
 * JD-Core Version:    0.7.0.1
 */