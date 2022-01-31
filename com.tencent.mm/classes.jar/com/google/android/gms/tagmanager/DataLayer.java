package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  static final String[] zzbFF = "gtm.lifetime".toString().split("\\.");
  private static final Pattern zzbFG = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<DataLayer.zzb, Integer> zzbFH;
  private final Map<String, Object> zzbFI;
  private final ReentrantLock zzbFJ;
  private final LinkedList<Map<String, Object>> zzbFK;
  private final zzc zzbFL;
  private final CountDownLatch zzbFM;
  
  DataLayer()
  {
    this(new zzc()
    {
      public void zza(DataLayer.zzc.zza paramAnonymouszza)
      {
        paramAnonymouszza.zzM(new ArrayList());
      }
      
      public void zza(List<DataLayer.zza> paramAnonymousList, long paramAnonymousLong) {}
      
      public void zzhc(String paramAnonymousString) {}
    });
  }
  
  DataLayer(zzc paramzzc)
  {
    this.zzbFL = paramzzc;
    this.zzbFH = new ConcurrentHashMap();
    this.zzbFI = new HashMap();
    this.zzbFJ = new ReentrantLock();
    this.zzbFK = new LinkedList();
    this.zzbFM = new CountDownLatch(1);
    zzQv();
  }
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("expected even number of key-value pairs");
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!(paramVarArgs[i] instanceof String))
      {
        paramVarArgs = String.valueOf(paramVarArgs[i]);
        throw new IllegalArgumentException(String.valueOf(paramVarArgs).length() + 21 + "key is not a string: " + paramVarArgs);
      }
      localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  private void zzQv()
  {
    this.zzbFL.zza(new DataLayer.2(this));
  }
  
  private void zzQw()
  {
    int i = 0;
    for (;;)
    {
      Map localMap = (Map)this.zzbFK.poll();
      if (localMap != null)
      {
        zzah(localMap);
        i += 1;
        if (i > 500)
        {
          this.zzbFK.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private void zza(Map<String, Object> paramMap, String paramString, Collection<DataLayer.zza> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.length() == 0) {}
      for (paramMap = "";; paramMap = ".")
      {
        String str = (String)localEntry.getKey();
        paramMap = String.valueOf(paramString).length() + String.valueOf(paramMap).length() + String.valueOf(str).length() + paramString + paramMap + str;
        if (!(localEntry.getValue() instanceof Map)) {
          break label143;
        }
        zza((Map)localEntry.getValue(), paramMap, paramCollection);
        break;
      }
      label143:
      if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new DataLayer.zza(paramMap, localEntry.getValue()));
      }
    }
  }
  
  private void zzac(Map<String, Object> paramMap)
  {
    this.zzbFJ.lock();
    try
    {
      this.zzbFK.offer(paramMap);
      if (this.zzbFJ.getHoldCount() == 1) {
        zzQw();
      }
      zzad(paramMap);
      return;
    }
    finally
    {
      this.zzbFJ.unlock();
    }
  }
  
  private void zzad(Map<String, Object> paramMap)
  {
    Long localLong = zzae(paramMap);
    if (localLong == null) {
      return;
    }
    paramMap = zzag(paramMap);
    this.zzbFL.zza(paramMap, localLong.longValue());
  }
  
  private Long zzae(Map<String, Object> paramMap)
  {
    paramMap = zzaf(paramMap);
    if (paramMap == null) {
      return null;
    }
    return zzhb(paramMap.toString());
  }
  
  private Object zzaf(Map<String, Object> paramMap)
  {
    String[] arrayOfString = zzbFF;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject = paramMap;
      if (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramMap instanceof Map)) {
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      paramMap = ((Map)paramMap).get(localObject);
      i += 1;
    }
  }
  
  private List<DataLayer.zza> zzag(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    zza(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void zzah(Map<String, Object> paramMap)
  {
    synchronized (this.zzbFI)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zzd(zzo(str, paramMap.get(str)), this.zzbFI);
      }
    }
    zzai(paramMap);
  }
  
  private void zzai(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.zzbFH.keySet().iterator();
    while (localIterator.hasNext()) {
      ((DataLayer.zzb)localIterator.next()).zzaa(paramMap);
    }
  }
  
  static Long zzhb(String paramString)
  {
    Matcher localMatcher = zzbFG.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "unknown _lifetime: ".concat(paramString);; paramString = new String("unknown _lifetime: "))
      {
        zzbo.zzbg(paramString);
        return null;
      }
    }
    long l;
    try
    {
      l = Long.parseLong(localMatcher.group(1));
      if (l <= 0L)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          paramString = "non-positive _lifetime: ".concat(paramString);
          zzbo.zzbg(paramString);
          return null;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        str = String.valueOf(paramString);
        if (str.length() != 0) {}
        for (str = "illegal number in _lifetime value: ".concat(str);; str = new String("illegal number in _lifetime value: "))
        {
          zzbo.zzbh(str);
          l = 0L;
          break;
        }
        paramString = new String("non-positive _lifetime: ");
      }
      String str = localMatcher.group(2);
      if (str.length() == 0) {
        return Long.valueOf(l);
      }
      switch (str.charAt(0))
      {
      default: 
        paramString = String.valueOf(paramString);
        if (paramString.length() == 0) {}
        break;
      }
    }
    for (paramString = "unknown units in _lifetime: ".concat(paramString);; paramString = new String("unknown units in _lifetime: "))
    {
      zzbo.zzbh(paramString);
      return null;
      return Long.valueOf(l * 1000L);
      return Long.valueOf(l * 1000L * 60L);
      return Long.valueOf(l * 1000L * 60L * 60L);
      return Long.valueOf(l * 1000L * 60L * 60L * 24L);
    }
  }
  
  public Object get(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (this.zzbFI)
      {
        Map localMap1 = this.zzbFI;
        String[] arrayOfString = paramString.split("\\.");
        int j = arrayOfString.length;
        i = 0;
        paramString = localMap1;
        if (i < j)
        {
          localMap1 = arrayOfString[i];
          if (!(paramString instanceof Map)) {
            return null;
          }
          paramString = ((Map)paramString).get(localMap1);
          if (paramString == null) {
            return null;
          }
        }
        else
        {
          return paramString;
        }
      }
      i += 1;
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(zzo(paramString, paramObject));
  }
  
  public void push(Map<String, Object> paramMap)
  {
    try
    {
      this.zzbFM.await();
      zzac(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        zzbo.zzbh("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  public void pushEvent(String paramString, Map<String, Object> paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap.put("event", paramString);
    push(paramMap);
  }
  
  public String toString()
  {
    synchronized (this.zzbFI)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.zzbFI.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
      }
    }
    String str = localObject.toString();
    return str;
  }
  
  void zza(DataLayer.zzb paramzzb)
  {
    this.zzbFH.put(paramzzb, Integer.valueOf(0));
  }
  
  void zzb(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    if (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        zzb((List)localObject, (List)paramList2.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(i) instanceof Map)) {
            paramList2.set(i, new HashMap());
          }
          zzd((Map)localObject, (Map)paramList2.get(i));
        }
        else if (localObject != OBJECT_NOT_PRESENT)
        {
          paramList2.set(i, localObject);
        }
      }
    }
  }
  
  void zzd(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        zzb((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        zzd((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  void zzha(String paramString)
  {
    push(paramString, null);
    this.zzbFL.zzhc(paramString);
  }
  
  Map<String, Object> zzo(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap2;
    for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2)
    {
      localHashMap2 = new HashMap();
      paramString.put(arrayOfString[i], localHashMap2);
      i += 1;
    }
    paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
    return localHashMap1;
  }
  
  static abstract interface zzc
  {
    public abstract void zza(DataLayer.zzc.zza paramzza);
    
    public abstract void zza(List<DataLayer.zza> paramList, long paramLong);
    
    public abstract void zzhc(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.DataLayer
 * JD-Core Version:    0.7.0.1
 */