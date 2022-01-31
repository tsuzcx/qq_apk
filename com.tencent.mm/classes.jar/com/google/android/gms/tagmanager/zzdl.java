package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdl
{
  private static final Object zzbIG = null;
  private static Long zzbIH = new Long(0L);
  private static Double zzbII = new Double(0.0D);
  private static zzdk zzbIJ = zzdk.zzaA(0L);
  private static String zzbIK = new String("");
  private static Boolean zzbIL = new Boolean(false);
  private static List<Object> zzbIM = new ArrayList(0);
  private static Map<Object, Object> zzbIN = new HashMap();
  private static zzak.zza zzbIO = zzR(zzbIK);
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    zzbo.e("getDouble received non-Number");
    return 0.0D;
  }
  
  public static String zzM(Object paramObject)
  {
    if (paramObject == null) {
      return zzbIK;
    }
    return paramObject.toString();
  }
  
  public static zzdk zzN(Object paramObject)
  {
    if ((paramObject instanceof zzdk)) {
      return (zzdk)paramObject;
    }
    if (zzT(paramObject)) {
      return zzdk.zzaA(zzU(paramObject));
    }
    if (zzS(paramObject)) {
      return zzdk.zza(Double.valueOf(getDouble(paramObject)));
    }
    return zzhx(zzM(paramObject));
  }
  
  public static Long zzO(Object paramObject)
  {
    if (zzT(paramObject)) {
      return Long.valueOf(zzU(paramObject));
    }
    return zzhy(zzM(paramObject));
  }
  
  public static Double zzP(Object paramObject)
  {
    if (zzS(paramObject)) {
      return Double.valueOf(getDouble(paramObject));
    }
    return zzhz(zzM(paramObject));
  }
  
  public static Boolean zzQ(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return zzhA(zzM(paramObject));
  }
  
  public static zzak.zza zzR(Object paramObject)
  {
    boolean bool = false;
    zzak.zza localzza1 = new zzak.zza();
    if ((paramObject instanceof zzak.zza)) {
      return (zzak.zza)paramObject;
    }
    if ((paramObject instanceof String))
    {
      localzza1.type = 1;
      localzza1.string = ((String)paramObject);
    }
    for (;;)
    {
      localzza1.zzlD = bool;
      return localzza1;
      Object localObject1;
      Object localObject2;
      if ((paramObject instanceof List))
      {
        localzza1.type = 2;
        localObject1 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        bool = false;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = zzR(((Iterator)localObject1).next());
          if (localObject2 == zzbIO) {
            return zzbIO;
          }
          if ((bool) || (((zzak.zza)localObject2).zzlD)) {}
          for (bool = true;; bool = false)
          {
            paramObject.add(localObject2);
            break;
          }
        }
        localzza1.zzlu = ((zzak.zza[])paramObject.toArray(new zzak.zza[0]));
      }
      else if ((paramObject instanceof Map))
      {
        localzza1.type = 3;
        localObject2 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject2).size());
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          zzak.zza localzza2 = zzR(((Map.Entry)localObject3).getKey());
          localObject3 = zzR(((Map.Entry)localObject3).getValue());
          if ((localzza2 == zzbIO) || (localObject3 == zzbIO)) {
            return zzbIO;
          }
          if ((bool) || (localzza2.zzlD) || (((zzak.zza)localObject3).zzlD)) {}
          for (bool = true;; bool = false)
          {
            paramObject.add(localzza2);
            ((List)localObject1).add(localObject3);
            break;
          }
        }
        localzza1.zzlv = ((zzak.zza[])paramObject.toArray(new zzak.zza[0]));
        localzza1.zzlw = ((zzak.zza[])((List)localObject1).toArray(new zzak.zza[0]));
      }
      else if (zzS(paramObject))
      {
        localzza1.type = 1;
        localzza1.string = paramObject.toString();
      }
      else if (zzT(paramObject))
      {
        localzza1.type = 6;
        localzza1.zzlz = zzU(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        localzza1.type = 8;
        localzza1.zzlA = ((Boolean)paramObject).booleanValue();
      }
    }
    if (paramObject == null)
    {
      paramObject = "null";
      paramObject = String.valueOf(paramObject);
      if (paramObject.length() == 0) {
        break label506;
      }
    }
    label506:
    for (paramObject = "Converting to Value from unknown object type: ".concat(paramObject);; paramObject = new String("Converting to Value from unknown object type: "))
    {
      zzbo.e(paramObject);
      return zzbIO;
      paramObject = paramObject.getClass().toString();
      break;
    }
  }
  
  public static Object zzRK()
  {
    return null;
  }
  
  public static Long zzRL()
  {
    return zzbIH;
  }
  
  public static Double zzRM()
  {
    return zzbII;
  }
  
  public static Boolean zzRN()
  {
    return zzbIL;
  }
  
  public static zzdk zzRO()
  {
    return zzbIJ;
  }
  
  public static String zzRP()
  {
    return zzbIK;
  }
  
  public static zzak.zza zzRQ()
  {
    return zzbIO;
  }
  
  private static boolean zzS(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzdk)) && (((zzdk)paramObject).zzRF()));
  }
  
  private static boolean zzT(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzdk)) && (((zzdk)paramObject).zzRG()));
  }
  
  private static long zzU(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    zzbo.e("getInt64 received non-Number");
    return 0L;
  }
  
  public static String zze(zzak.zza paramzza)
  {
    return zzM(zzj(paramzza));
  }
  
  public static zzdk zzf(zzak.zza paramzza)
  {
    return zzN(zzj(paramzza));
  }
  
  public static Long zzg(zzak.zza paramzza)
  {
    return zzO(zzj(paramzza));
  }
  
  public static Double zzh(zzak.zza paramzza)
  {
    return zzP(zzj(paramzza));
  }
  
  private static Boolean zzhA(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return zzbIL;
  }
  
  public static zzak.zza zzhw(String paramString)
  {
    zzak.zza localzza = new zzak.zza();
    localzza.type = 5;
    localzza.zzly = paramString;
    return localzza;
  }
  
  private static zzdk zzhx(String paramString)
  {
    try
    {
      zzdk localzzdk = zzdk.zzhv(paramString);
      return localzzdk;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzbo.e(String.valueOf(paramString).length() + 33 + "Failed to convert '" + paramString + "' to a number.");
    }
    return zzbIJ;
  }
  
  private static Long zzhy(String paramString)
  {
    paramString = zzhx(paramString);
    if (paramString == zzbIJ) {
      return zzbIH;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  private static Double zzhz(String paramString)
  {
    paramString = zzhx(paramString);
    if (paramString == zzbIJ) {
      return zzbII;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  public static Boolean zzi(zzak.zza paramzza)
  {
    return zzQ(zzj(paramzza));
  }
  
  public static Object zzj(zzak.zza paramzza)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramzza == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    switch (paramzza.type)
    {
    default: 
      i = paramzza.type;
      zzbo.e(46 + "Failed to convert a value of type: " + i);
      return null;
    case 1: 
      return paramzza.string;
    case 2: 
      localObject1 = new ArrayList(paramzza.zzlu.length);
      paramzza = paramzza.zzlu;
      j = paramzza.length;
      while (i < j)
      {
        localObject2 = zzj(paramzza[i]);
        if (localObject2 == null) {
          return null;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 3: 
      if (paramzza.zzlv.length != paramzza.zzlw.length)
      {
        paramzza = String.valueOf(paramzza.toString());
        if (paramzza.length() != 0) {}
        for (paramzza = "Converting an invalid value to object: ".concat(paramzza);; paramzza = new String("Converting an invalid value to object: "))
        {
          zzbo.e(paramzza);
          return null;
        }
      }
      localObject1 = new HashMap(paramzza.zzlw.length);
      i = k;
      while (i < paramzza.zzlv.length)
      {
        localObject2 = zzj(paramzza.zzlv[i]);
        Object localObject3 = zzj(paramzza.zzlw[i]);
        if ((localObject2 == null) || (localObject3 == null)) {
          return null;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      zzbo.e("Trying to convert a macro reference to object");
      return null;
    case 5: 
      zzbo.e("Trying to convert a function id to object");
      return null;
    case 6: 
      return Long.valueOf(paramzza.zzlz);
    case 7: 
      localObject1 = new StringBuffer();
      paramzza = paramzza.zzlB;
      k = paramzza.length;
      i = j;
      while (i < k)
      {
        localObject2 = zze(paramzza[i]);
        if (localObject2 == zzbIK) {
          return null;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramzza.zzlA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdl
 * JD-Core Version:    0.7.0.1
 */