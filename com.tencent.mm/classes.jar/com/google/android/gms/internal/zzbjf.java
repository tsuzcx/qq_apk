package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbo;
import com.google.android.gms.tagmanager.zzdl;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzbjf
{
  private static zzak.zza zza(int paramInt, zzaj.zzf paramzzf, zzak.zza[] paramArrayOfzza, Set<Integer> paramSet)
  {
    if (paramSet.contains(Integer.valueOf(paramInt)))
    {
      localObject = String.valueOf(paramSet);
      zzhS(String.valueOf(localObject).length() + 90 + "Value cycle detected.  Current value reference: " + paramInt + ".  Previous value references: " + (String)localObject + ".");
    }
    zzak.zza localzza1 = (zzak.zza)zza(paramzzf.zzkF, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null) {
      return paramArrayOfzza[paramInt];
    }
    Object localObject = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localzza1.type)
    {
    }
    for (;;)
    {
      if (localObject == null)
      {
        paramzzf = String.valueOf(localzza1);
        zzhS(String.valueOf(paramzzf).length() + 15 + "Invalid value: " + paramzzf);
      }
      paramArrayOfzza[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return localObject;
      localObject = zzn(localzza1);
      zzak.zza localzza2 = zzm(localzza1);
      localzza2.zzlu = new zzak.zza[((zzaj.zzh)localObject).zzlg.length];
      int[] arrayOfInt = ((zzaj.zzh)localObject).zzlg;
      int k = arrayOfInt.length;
      int j = 0;
      int i = 0;
      int m;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzlu[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localzza2 = zzm(localzza1);
      localObject = zzn(localzza1);
      if (((zzaj.zzh)localObject).zzlh.length != ((zzaj.zzh)localObject).zzli.length)
      {
        i = ((zzaj.zzh)localObject).zzlh.length;
        j = ((zzaj.zzh)localObject).zzli.length;
        zzhS(58 + "Uneven map keys (" + i + ") and map values (" + j + ")");
      }
      localzza2.zzlv = new zzak.zza[((zzaj.zzh)localObject).zzlh.length];
      localzza2.zzlw = new zzak.zza[((zzaj.zzh)localObject).zzlh.length];
      arrayOfInt = ((zzaj.zzh)localObject).zzlh;
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < k)
      {
        m = arrayOfInt[j];
        localzza2.zzlv[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((zzaj.zzh)localObject).zzli;
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzlw[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = zzm(localzza1);
      ((zzak.zza)localObject).zzlx = zzdl.zze(zza(zzn(localzza1).zzll, paramzzf, paramArrayOfzza, paramSet));
      continue;
      localzza2 = zzm(localzza1);
      localObject = zzn(localzza1);
      localzza2.zzlB = new zzak.zza[((zzaj.zzh)localObject).zzlk.length];
      arrayOfInt = ((zzaj.zzh)localObject).zzlk;
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzlB[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = localzza1;
    }
  }
  
  private static zzbjf.zza zza(zzaj.zzb paramzzb, zzaj.zzf paramzzf, zzak.zza[] paramArrayOfzza, int paramInt)
  {
    zzbjf.zzb localzzb = zzbjf.zza.zzTv();
    paramzzb = paramzzb.zzkq;
    int i = paramzzb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramzzb[paramInt];
      Object localObject = (zzaj.zze)zza(paramzzf.zzkG, Integer.valueOf(j).intValue(), "properties");
      String str = (String)zza(paramzzf.zzkE, ((zzaj.zze)localObject).key, "keys");
      localObject = (zzak.zza)zza(paramArrayOfzza, ((zzaj.zze)localObject).value, "values");
      if (zzai.zziP.toString().equals(str)) {
        localzzb.zzo((zzak.zza)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localzzb.zzb(str, (zzak.zza)localObject);
      }
    }
    return localzzb.zzTw();
  }
  
  private static zzbjf.zze zza(zzaj.zzg paramzzg, List<zzbjf.zza> paramList1, List<zzbjf.zza> paramList2, List<zzbjf.zza> paramList3, zzaj.zzf paramzzf)
  {
    zzbjf.zzf localzzf = zzbjf.zze.zzTA();
    int[] arrayOfInt = paramzzg.zzkU;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localzzf.zzd((zzbjf.zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramzzg.zzkV;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localzzf.zze((zzbjf.zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zzkW;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzf((zzbjf.zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zzkY;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localzzf.zzii(paramzzf.zzkF[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList3 = paramzzg.zzkX;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzg((zzbjf.zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zzkZ;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzij(paramzzf.zzkF[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList1 = paramzzg.zzla;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzh((zzbjf.zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zzlc;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzik(paramzzf.zzkF[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList1 = paramzzg.zzlb;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzi((zzbjf.zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramzzg = paramzzg.zzld;
    j = paramzzg.length;
    i = 0;
    while (i < j)
    {
      k = paramzzg[i];
      localzzf.zzil(paramzzf.zzkF[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    return localzzf.zzTD();
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzhS(String.valueOf(paramString).length() + 45 + "Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static zzbjf.zzc zzb(zzaj.zzf paramzzf)
  {
    int j = 0;
    Object localObject = new zzak.zza[paramzzf.zzkF.length];
    int i = 0;
    while (i < paramzzf.zzkF.length)
    {
      zza(i, paramzzf, (zzak.zza[])localObject, new HashSet(0));
      i += 1;
    }
    zzbjf.zzd localzzd = zzbjf.zzc.zzTx();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkI.length)
    {
      localArrayList1.add(zza(paramzzf.zzkI[i], paramzzf, (zzak.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkJ.length)
    {
      localArrayList2.add(zza(paramzzf.zzkJ[i], paramzzf, (zzak.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkH.length)
    {
      zzbjf.zza localzza = zza(paramzzf.zzkH[i], paramzzf, (zzak.zza[])localObject, i);
      localzzd.zzc(localzza);
      localArrayList3.add(localzza);
      i += 1;
    }
    localObject = paramzzf.zzkK;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      localzzd.zzb(zza(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramzzf));
      i += 1;
    }
    localzzd.zzih(paramzzf.version);
    localzzd.zznO(paramzzf.zzkS);
    return localzzd.zzTz();
  }
  
  public static void zzc(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void zzhS(String paramString)
  {
    zzbo.e(paramString);
    throw new zzbjf.zzg(paramString);
  }
  
  public static zzak.zza zzm(zzak.zza paramzza)
  {
    zzak.zza localzza = new zzak.zza();
    localzza.type = paramzza.type;
    localzza.zzlC = ((int[])paramzza.zzlC.clone());
    if (paramzza.zzlD) {
      localzza.zzlD = paramzza.zzlD;
    }
    return localzza;
  }
  
  private static zzaj.zzh zzn(zzak.zza paramzza)
  {
    if ((zzaj.zzh)paramzza.zza(zzaj.zzh.zzle) == null)
    {
      String str = String.valueOf(paramzza);
      zzhS(String.valueOf(str).length() + 54 + "Expected a ServingValue and didn't get one. Value is: " + str);
    }
    return (zzaj.zzh)paramzza.zza(zzaj.zzh.zzle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf
 * JD-Core Version:    0.7.0.1
 */