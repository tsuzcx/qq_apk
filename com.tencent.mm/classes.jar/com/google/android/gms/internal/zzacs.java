package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.util.zzr;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzacs
{
  private void zza(StringBuilder paramStringBuilder, zzacs.zza paramzza, Object paramObject)
  {
    if (paramzza.zzys() == 11)
    {
      paramStringBuilder.append(((zzacs)paramzza.zzyy().cast(paramObject)).toString());
      return;
    }
    if (paramzza.zzys() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(zzq.zzdy((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void zza(StringBuilder paramStringBuilder, zzacs.zza paramzza, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        zza(paramStringBuilder, paramzza, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public String toString()
  {
    Map localMap = zzyr();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zzacs.zza localzza = (zzacs.zza)localMap.get(str);
      if (zza(localzza))
      {
        Object localObject = zza(localzza, zzb(localzza));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label139;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label139:
        switch (localzza.zzyu())
        {
        default: 
          if (localzza.zzyt()) {
            zza(localStringBuilder, localzza, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(zzc.zzq((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(zzc.zzr((byte[])localObject)).append("\"");
          break;
        case 10: 
          zzr.zza(localStringBuilder, (HashMap)localObject);
          continue;
          zza(localStringBuilder, localzza, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  protected <O, I> I zza(zzacs.zza<I, O> paramzza, Object paramObject)
  {
    Object localObject = paramObject;
    if (zzacs.zza.zzc(paramzza) != null) {
      localObject = paramzza.convertBack(paramObject);
    }
    return localObject;
  }
  
  protected boolean zza(zzacs.zza paramzza)
  {
    if (paramzza.zzyu() == 11)
    {
      if (paramzza.zzyv()) {
        return zzdv(paramzza.zzyw());
      }
      return zzdu(paramzza.zzyw());
    }
    return zzdt(paramzza.zzyw());
  }
  
  protected Object zzb(zzacs.zza paramzza)
  {
    String str = paramzza.zzyw();
    if (paramzza.zzyy() != null)
    {
      zzds(paramzza.zzyw());
      zzac.zza(true, "Concrete field shouldn't be value object: %s", new Object[] { paramzza.zzyw() });
      paramzza.zzyv();
      try
      {
        char c = Character.toUpperCase(str.charAt(0));
        paramzza = String.valueOf(str.substring(1));
        paramzza = String.valueOf(paramzza).length() + 4 + "get" + c + paramzza;
        paramzza = getClass().getMethod(paramzza, new Class[0]).invoke(this, new Object[0]);
        return paramzza;
      }
      catch (Exception paramzza)
      {
        throw new RuntimeException(paramzza);
      }
    }
    return zzds(paramzza.zzyw());
  }
  
  protected abstract Object zzds(String paramString);
  
  protected abstract boolean zzdt(String paramString);
  
  protected boolean zzdu(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean zzdv(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  public abstract Map<String, zzacs.zza<?, ?>> zzyr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzacs
 * JD-Core Version:    0.7.0.1
 */