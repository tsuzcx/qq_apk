package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class zzacp
  extends zza
  implements zzacs.zzb<String, Integer>
{
  public static final Parcelable.Creator<zzacp> CREATOR = new zzacq();
  private final HashMap<String, Integer> zzaGS;
  private final SparseArray<String> zzaGT;
  private final ArrayList<zzacp.zza> zzaGU;
  final int zzaiI;
  
  public zzacp()
  {
    this.zzaiI = 1;
    this.zzaGS = new HashMap();
    this.zzaGT = new SparseArray();
    this.zzaGU = null;
  }
  
  zzacp(int paramInt, ArrayList<zzacp.zza> paramArrayList)
  {
    this.zzaiI = paramInt;
    this.zzaGS = new HashMap();
    this.zzaGT = new SparseArray();
    this.zzaGU = null;
    zzh(paramArrayList);
  }
  
  private void zzh(ArrayList<zzacp.zza> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzacp.zza localzza = (zzacp.zza)paramArrayList.next();
      zzj(localzza.zzaGV, localzza.zzaGW);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacq.zza(this, paramParcel, paramInt);
  }
  
  public final String zzd(Integer paramInteger)
  {
    String str = (String)this.zzaGT.get(paramInteger.intValue());
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.zzaGS.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public final zzacp zzj(String paramString, int paramInt)
  {
    this.zzaGS.put(paramString, Integer.valueOf(paramInt));
    this.zzaGT.put(paramInt, paramString);
    return this;
  }
  
  final ArrayList<zzacp.zza> zzyq()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzaGS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzacp.zza(str, ((Integer)this.zzaGS.get(str)).intValue()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzacp
 * JD-Core Version:    0.7.0.1
 */