package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zza;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.google.android.gms.tagmanager.zzam;>;
import java.util.Set;

class zzcx
{
  private static final zzce<zzak.zza> zzbHG = new zzce(zzdl.zzRQ(), true);
  private final DataLayer zzbEZ;
  private final zzbjf.zzc zzbHH;
  private final zzaj zzbHI;
  private final Map<String, zzam> zzbHJ;
  private final Map<String, zzam> zzbHK;
  private final Map<String, zzam> zzbHL;
  private final zzl<zzbjf.zza, zzce<zzak.zza>> zzbHM;
  private final zzl<String, zzcx.zzb> zzbHN;
  private final Set<zzbjf.zze> zzbHO;
  private final Map<String, zzc> zzbHP;
  private volatile String zzbHQ;
  private int zzbHR;
  
  public zzcx(Context paramContext, zzbjf.zzc paramzzc, DataLayer paramDataLayer, zzu.zza paramzza1, zzu.zza paramzza2, zzaj paramzzaj)
  {
    if (paramzzc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.zzbHH = paramzzc;
    this.zzbHO = new HashSet(paramzzc.zzST());
    this.zzbEZ = paramDataLayer;
    this.zzbHI = paramzzaj;
    paramzzc = new zzcx.1(this);
    this.zzbHM = new zzm().zza(1048576, paramzzc);
    paramzzc = new zzcx.2(this);
    this.zzbHN = new zzm().zza(1048576, paramzzc);
    this.zzbHJ = new HashMap();
    zzb(new zzj(paramContext));
    zzb(new zzu(paramzza2));
    zzb(new zzy(paramDataLayer));
    zzb(new zzdm(paramContext, paramDataLayer));
    this.zzbHK = new HashMap();
    zzc(new zzs());
    zzc(new zzag());
    zzc(new zzah());
    zzc(new zzao());
    zzc(new zzap());
    zzc(new zzbk());
    zzc(new zzbl());
    zzc(new zzcn());
    zzc(new zzdf());
    this.zzbHL = new HashMap();
    zza(new zzb(paramContext));
    zza(new zzc(paramContext));
    zza(new zze(paramContext));
    zza(new zzf(paramContext));
    zza(new zzg(paramContext));
    zza(new zzh(paramContext));
    zza(new zzi(paramContext));
    zza(new zzn());
    zza(new zzr(this.zzbHH.getVersion()));
    zza(new zzu(paramzza1));
    zza(new zzw(paramDataLayer));
    zza(new zzab(paramContext));
    zza(new zzac());
    zza(new zzaf());
    zza(new zzak(this));
    zza(new zzaq());
    zza(new zzar());
    zza(new zzbe(paramContext));
    zza(new zzbg());
    zza(new zzbj());
    zza(new zzbq());
    zza(new zzbs(paramContext));
    zza(new zzcf());
    zza(new zzch());
    zza(new zzck());
    zza(new zzcm());
    zza(new zzco(paramContext));
    zza(new zzcy());
    zza(new zzcz());
    zza(new zzdh());
    zza(new zzdn());
    this.zzbHP = new HashMap();
    paramContext = this.zzbHO.iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (zzbjf.zze)paramContext.next();
      int i = 0;
      while (i < paramzzc.zzTB().size())
      {
        paramDataLayer = (zzbjf.zza)paramzzc.zzTB().get(i);
        paramzza1 = zzh(this.zzbHP, zza(paramDataLayer));
        paramzza1.zza(paramzzc);
        paramzza1.zza(paramzzc, paramDataLayer);
        paramzza1.zza(paramzzc, "Unknown");
        i += 1;
      }
      i = 0;
      while (i < paramzzc.zzTC().size())
      {
        paramDataLayer = (zzbjf.zza)paramzzc.zzTC().get(i);
        paramzza1 = zzh(this.zzbHP, zza(paramDataLayer));
        paramzza1.zza(paramzzc);
        paramzza1.zzb(paramzzc, paramDataLayer);
        paramzza1.zzb(paramzzc, "Unknown");
        i += 1;
      }
    }
    paramContext = this.zzbHH.zzTy().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramzzc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramzza1 = (zzbjf.zza)paramDataLayer.next();
        if (!zzdl.zzi((zzak.zza)paramzza1.zzSV().get(com.google.android.gms.internal.zzai.zzin.toString())).booleanValue()) {
          zzh(this.zzbHP, (String)paramzzc.getKey()).zzb(paramzza1);
        }
      }
    }
  }
  
  private String zzRo()
  {
    if (this.zzbHR <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.zzbHR));
    int i = 2;
    while (i < this.zzbHR)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  private zzce<zzak.zza> zza(zzak.zza paramzza, Set<String> paramSet, zzdo paramzzdo)
  {
    if (!paramzza.zzlD) {
      return new zzce(paramzza, true);
    }
    zzce localzzce1;
    switch (paramzza.type)
    {
    case 5: 
    case 6: 
    default: 
      i = paramzza.type;
      zzbo.e(25 + "Unknown type: " + i);
      return zzbHG;
    case 2: 
      localzza = zzbjf.zzm(paramzza);
      localzza.zzlu = new zzak.zza[paramzza.zzlu.length];
      i = 0;
      while (i < paramzza.zzlu.length)
      {
        localzzce1 = zza(paramzza.zzlu[i], paramSet, paramzzdo.zznC(i));
        if (localzzce1 == zzbHG) {
          return zzbHG;
        }
        localzza.zzlu[i] = ((zzak.zza)localzzce1.getObject());
        i += 1;
      }
      return new zzce(localzza, false);
    case 3: 
      localzza = zzbjf.zzm(paramzza);
      if (paramzza.zzlv.length != paramzza.zzlw.length)
      {
        paramzza = String.valueOf(paramzza.toString());
        if (paramzza.length() != 0) {}
        for (paramzza = "Invalid serving value: ".concat(paramzza);; paramzza = new String("Invalid serving value: "))
        {
          zzbo.e(paramzza);
          return zzbHG;
        }
      }
      localzza.zzlv = new zzak.zza[paramzza.zzlv.length];
      localzza.zzlw = new zzak.zza[paramzza.zzlv.length];
      i = 0;
      while (i < paramzza.zzlv.length)
      {
        localzzce1 = zza(paramzza.zzlv[i], paramSet, paramzzdo.zznD(i));
        zzce localzzce2 = zza(paramzza.zzlw[i], paramSet, paramzzdo.zznE(i));
        if ((localzzce1 == zzbHG) || (localzzce2 == zzbHG)) {
          return zzbHG;
        }
        localzza.zzlv[i] = ((zzak.zza)localzzce1.getObject());
        localzza.zzlw[i] = ((zzak.zza)localzzce2.getObject());
        i += 1;
      }
      return new zzce(localzza, false);
    case 4: 
      if (paramSet.contains(paramzza.zzlx))
      {
        paramzza = String.valueOf(paramzza.zzlx);
        paramSet = String.valueOf(paramSet.toString());
        zzbo.e(String.valueOf(paramzza).length() + 79 + String.valueOf(paramSet).length() + "Macro cycle detected.  Current macro reference: " + paramzza + ".  Previous macro references: " + paramSet + ".");
        return zzbHG;
      }
      paramSet.add(paramzza.zzlx);
      paramzzdo = zzdp.zza(zza(paramzza.zzlx, paramSet, paramzzdo.zzQX()), paramzza.zzlC);
      paramSet.remove(paramzza.zzlx);
      return paramzzdo;
    }
    zzak.zza localzza = zzbjf.zzm(paramzza);
    localzza.zzlB = new zzak.zza[paramzza.zzlB.length];
    int i = 0;
    while (i < paramzza.zzlB.length)
    {
      localzzce1 = zza(paramzza.zzlB[i], paramSet, paramzzdo.zznF(i));
      if (localzzce1 == zzbHG) {
        return zzbHG;
      }
      localzza.zzlB[i] = ((zzak.zza)localzzce1.getObject());
      i += 1;
    }
    return new zzce(localzza, false);
  }
  
  private zzce<zzak.zza> zza(String paramString, Set<String> paramSet, zzbr paramzzbr)
  {
    this.zzbHR += 1;
    Object localObject = (zzcx.zzb)this.zzbHN.get(paramString);
    if (localObject != null)
    {
      zza(((zzcx.zzb)localObject).zzRq(), paramSet);
      this.zzbHR -= 1;
      return ((zzcx.zzb)localObject).zzRp();
    }
    localObject = (zzc)this.zzbHP.get(paramString);
    if (localObject == null)
    {
      paramSet = String.valueOf(zzRo());
      zzbo.e(String.valueOf(paramSet).length() + 15 + String.valueOf(paramString).length() + paramSet + "Invalid macro: " + paramString);
      this.zzbHR -= 1;
      return zzbHG;
    }
    zzce localzzce = zza(paramString, ((zzc)localObject).zzRr(), ((zzc)localObject).zzRs(), ((zzc)localObject).zzRt(), ((zzc)localObject).zzRv(), ((zzc)localObject).zzRu(), paramSet, paramzzbr.zzQy());
    if (((Set)localzzce.getObject()).isEmpty()) {}
    for (localObject = ((zzc)localObject).zzRw(); localObject == null; localObject = (zzbjf.zza)((Set)localzzce.getObject()).iterator().next())
    {
      this.zzbHR -= 1;
      return zzbHG;
      if (((Set)localzzce.getObject()).size() > 1)
      {
        localObject = String.valueOf(zzRo());
        zzbo.zzbh(String.valueOf(localObject).length() + 37 + String.valueOf(paramString).length() + (String)localObject + "Multiple macros active for macroName " + paramString);
      }
    }
    paramzzbr = zza(this.zzbHL, (zzbjf.zza)localObject, paramSet, paramzzbr.zzQP());
    boolean bool;
    if ((localzzce.zzQY()) && (paramzzbr.zzQY()))
    {
      bool = true;
      if (paramzzbr != zzbHG) {
        break label429;
      }
    }
    label429:
    for (paramzzbr = zzbHG;; paramzzbr = new zzce((zzak.zza)paramzzbr.getObject(), bool))
    {
      localObject = ((zzbjf.zza)localObject).zzRq();
      if (paramzzbr.zzQY()) {
        this.zzbHN.zzh(paramString, new zzcx.zzb(paramzzbr, (zzak.zza)localObject));
      }
      zza((zzak.zza)localObject, paramSet);
      this.zzbHR -= 1;
      return paramzzbr;
      bool = false;
      break;
    }
  }
  
  private zzce<zzak.zza> zza(Map<String, zzam> paramMap, zzbjf.zza paramzza, Set<String> paramSet, zzcp paramzzcp)
  {
    boolean bool = true;
    Object localObject1 = (zzak.zza)paramzza.zzSV().get(com.google.android.gms.internal.zzai.zzhw.toString());
    if (localObject1 == null)
    {
      zzbo.e("No function id in properties");
      paramMap = zzbHG;
    }
    String str;
    zzam localzzam;
    do
    {
      return paramMap;
      str = ((zzak.zza)localObject1).zzly;
      localzzam = (zzam)paramMap.get(str);
      if (localzzam == null)
      {
        zzbo.e(String.valueOf(str).concat(" has no backing implementation."));
        return zzbHG;
      }
      localObject1 = (zzce)this.zzbHM.get(paramzza);
      paramMap = (Map<String, zzam>)localObject1;
    } while (localObject1 != null);
    paramMap = new HashMap();
    localObject1 = paramzza.zzSV().entrySet().iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = paramzzcp.zzhm((String)localEntry.getKey());
      localObject2 = zza((zzak.zza)localEntry.getValue(), paramSet, ((zzcr)localObject2).zzd((zzak.zza)localEntry.getValue()));
      if (localObject2 == zzbHG) {
        return zzbHG;
      }
      if (((zzce)localObject2).zzQY()) {
        paramzza.zza((String)localEntry.getKey(), (zzak.zza)((zzce)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put((String)localEntry.getKey(), (zzak.zza)((zzce)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localzzam.zzf(paramMap.keySet()))
    {
      paramzza = String.valueOf(localzzam.zzQL());
      paramMap = String.valueOf(paramMap.keySet());
      zzbo.e(String.valueOf(str).length() + 43 + String.valueOf(paramzza).length() + String.valueOf(paramMap).length() + "Incorrect keys for function " + str + " required " + paramzza + " had " + paramMap);
      return zzbHG;
    }
    if ((i != 0) && (localzzam.zzQa())) {}
    for (;;)
    {
      paramSet = new zzce(localzzam.zzZ(paramMap), bool);
      paramMap = paramSet;
      if (!bool) {
        break;
      }
      this.zzbHM.zzh(paramzza, paramSet);
      return paramSet;
      bool = false;
    }
  }
  
  private zzce<Set<zzbjf.zza>> zza(Set<zzbjf.zze> paramSet, Set<String> paramSet1, zza paramzza, zzcw paramzzcw)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      zzbjf.zze localzze = (zzbjf.zze)paramSet.next();
      zzcs localzzcs = paramzzcw.zzQW();
      zzce localzzce = zza(localzze, paramSet1, localzzcs);
      if (((Boolean)localzzce.getObject()).booleanValue()) {
        paramzza.zza(localzze, localHashSet1, localHashSet2, localzzcs);
      }
      if ((bool) && (localzzce.zzQY())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    return new zzce(localHashSet1, bool);
  }
  
  private static String zza(zzbjf.zza paramzza)
  {
    return zzdl.zze((zzak.zza)paramzza.zzSV().get(com.google.android.gms.internal.zzai.zzhI.toString()));
  }
  
  private void zza(zzak.zza paramzza, Set<String> paramSet)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      paramzza = zza(paramzza, paramSet, new zzcc());
      if (paramzza != zzbHG)
      {
        paramzza = zzdl.zzj((zzak.zza)paramzza.getObject());
        if ((paramzza instanceof Map))
        {
          paramzza = (Map)paramzza;
          this.zzbEZ.push(paramzza);
          return;
        }
        if (!(paramzza instanceof List)) {
          break;
        }
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          paramSet = paramzza.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.zzbEZ.push(paramSet);
          }
          else
          {
            zzbo.zzbh("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    zzbo.zzbh("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void zza(Map<String, zzam> paramMap, zzam paramzzam)
  {
    if (paramMap.containsKey(paramzzam.zzQK()))
    {
      paramMap = String.valueOf(paramzzam.zzQK());
      if (paramMap.length() != 0) {}
      for (paramMap = "Duplicate function type name: ".concat(paramMap);; paramMap = new String("Duplicate function type name: ")) {
        throw new IllegalArgumentException(paramMap);
      }
    }
    paramMap.put(paramzzam.zzQK(), paramzzam);
  }
  
  private static zzc zzh(Map<String, zzc> paramMap, String paramString)
  {
    zzc localzzc2 = (zzc)paramMap.get(paramString);
    zzc localzzc1 = localzzc2;
    if (localzzc2 == null)
    {
      localzzc1 = new zzc();
      paramMap.put(paramString, localzzc1);
    }
    return localzzc1;
  }
  
  public void zzQ(List<zzaj.zzi> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = (zzaj.zzi)paramList.next();
        if ((((zzaj.zzi)localObject).name == null) || (!((zzaj.zzi)localObject).name.startsWith("gaExperiment:")))
        {
          localObject = String.valueOf(localObject);
          zzbo.v(String.valueOf(localObject).length() + 22 + "Ignored supplemental: " + (String)localObject);
        }
        else
        {
          zzal.zza(this.zzbEZ, (zzaj.zzi)localObject);
        }
      }
      finally {}
    }
  }
  
  String zzRn()
  {
    try
    {
      String str = this.zzbHQ;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  zzce<Boolean> zza(zzbjf.zza paramzza, Set<String> paramSet, zzcp paramzzcp)
  {
    paramzza = zza(this.zzbHK, paramzza, paramSet, paramzzcp);
    paramSet = zzdl.zzi((zzak.zza)paramzza.getObject());
    zzdl.zzR(paramSet);
    return new zzce(paramSet, paramzza.zzQY());
  }
  
  zzce<Boolean> zza(zzbjf.zze paramzze, Set<String> paramSet, zzcs paramzzcs)
  {
    Object localObject = paramzze.zzSY().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      zzce localzzce = zza((zzbjf.zza)((Iterator)localObject).next(), paramSet, paramzzcs.zzQQ());
      if (((Boolean)localzzce.getObject()).booleanValue())
      {
        zzdl.zzR(Boolean.valueOf(false));
        return new zzce(Boolean.valueOf(false), localzzce.zzQY());
      }
      if ((bool) && (localzzce.zzQY())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramzze = paramzze.zzSX().iterator();
    while (paramzze.hasNext())
    {
      localObject = zza((zzbjf.zza)paramzze.next(), paramSet, paramzzcs.zzQR());
      if (!((Boolean)((zzce)localObject).getObject()).booleanValue())
      {
        zzdl.zzR(Boolean.valueOf(false));
        return new zzce(Boolean.valueOf(false), ((zzce)localObject).zzQY());
      }
      if ((bool) && (((zzce)localObject).zzQY())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    zzdl.zzR(Boolean.valueOf(true));
    return new zzce(Boolean.valueOf(true), bool);
  }
  
  zzce<Set<zzbjf.zza>> zza(String paramString, Set<zzbjf.zze> paramSet, final Map<zzbjf.zze, List<zzbjf.zza>> paramMap1, final Map<zzbjf.zze, List<String>> paramMap2, final Map<zzbjf.zze, List<zzbjf.zza>> paramMap3, final Map<zzbjf.zze, List<String>> paramMap4, Set<String> paramSet1, zzcw paramzzcw)
  {
    zza(paramSet, paramSet1, new zza()
    {
      public void zza(zzbjf.zze paramAnonymouszze, Set<zzbjf.zza> paramAnonymousSet1, Set<zzbjf.zza> paramAnonymousSet2, zzcs paramAnonymouszzcs)
      {
        List localList = (List)paramMap1.get(paramAnonymouszze);
        paramMap2.get(paramAnonymouszze);
        if (localList != null)
        {
          paramAnonymousSet1.addAll(localList);
          paramAnonymouszzcs.zzQS();
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouszze);
        paramMap4.get(paramAnonymouszze);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouszzcs.zzQT();
        }
      }
    }, paramzzcw);
  }
  
  zzce<Set<zzbjf.zza>> zza(Set<zzbjf.zze> paramSet, zzcw paramzzcw)
  {
    return zza(paramSet, new HashSet(), new zzcx.4(this), paramzzcw);
  }
  
  void zza(zzam paramzzam)
  {
    zza(this.zzbHL, paramzzam);
  }
  
  void zzb(zzam paramzzam)
  {
    zza(this.zzbHJ, paramzzam);
  }
  
  void zzc(zzam paramzzam)
  {
    zza(this.zzbHK, paramzzam);
  }
  
  public void zzgU(String paramString)
  {
    try
    {
      zzhr(paramString);
      paramString = this.zzbHI.zzhh(paramString).zzQJ();
      Iterator localIterator = ((Set)zza(this.zzbHO, paramString.zzQy()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        zzbjf.zza localzza = (zzbjf.zza)localIterator.next();
        zza(this.zzbHJ, localzza, new HashSet(), paramString.zzQx());
      }
      zzhr(null);
    }
    finally {}
  }
  
  public zzce<zzak.zza> zzhq(String paramString)
  {
    this.zzbHR = 0;
    zzai localzzai = this.zzbHI.zzhg(paramString);
    return zza(paramString, new HashSet(), localzzai.zzQI());
  }
  
  void zzhr(String paramString)
  {
    try
    {
      this.zzbHQ = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zza(zzbjf.zze paramzze, Set<zzbjf.zza> paramSet1, Set<zzbjf.zza> paramSet2, zzcs paramzzcs);
  }
  
  private static class zzc
  {
    private final Set<zzbjf.zze> zzbHO = new HashSet();
    private final Map<zzbjf.zze, List<zzbjf.zza>> zzbHY = new HashMap();
    private final Map<zzbjf.zze, List<zzbjf.zza>> zzbHZ = new HashMap();
    private final Map<zzbjf.zze, List<String>> zzbIa = new HashMap();
    private final Map<zzbjf.zze, List<String>> zzbIb = new HashMap();
    private zzbjf.zza zzbIc;
    
    public Set<zzbjf.zze> zzRr()
    {
      return this.zzbHO;
    }
    
    public Map<zzbjf.zze, List<zzbjf.zza>> zzRs()
    {
      return this.zzbHY;
    }
    
    public Map<zzbjf.zze, List<String>> zzRt()
    {
      return this.zzbIa;
    }
    
    public Map<zzbjf.zze, List<String>> zzRu()
    {
      return this.zzbIb;
    }
    
    public Map<zzbjf.zze, List<zzbjf.zza>> zzRv()
    {
      return this.zzbHZ;
    }
    
    public zzbjf.zza zzRw()
    {
      return this.zzbIc;
    }
    
    public void zza(zzbjf.zze paramzze)
    {
      this.zzbHO.add(paramzze);
    }
    
    public void zza(zzbjf.zze paramzze, zzbjf.zza paramzza)
    {
      List localList = (List)this.zzbHY.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbHY.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zza(zzbjf.zze paramzze, String paramString)
    {
      List localList = (List)this.zzbIa.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbIa.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void zzb(zzbjf.zza paramzza)
    {
      this.zzbIc = paramzza;
    }
    
    public void zzb(zzbjf.zze paramzze, zzbjf.zza paramzza)
    {
      List localList = (List)this.zzbHZ.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbHZ.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zzb(zzbjf.zze paramzze, String paramString)
    {
      List localList = (List)this.zzbIb.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbIb.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcx
 * JD-Core Version:    0.7.0.1
 */