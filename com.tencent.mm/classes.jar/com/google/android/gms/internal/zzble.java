package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzble
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri zzbVR = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern zzbVS = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzbVT = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean zzbVU = new AtomicBoolean();
  static HashMap<String, String> zzbVV;
  private static Object zzbVW;
  private static boolean zzbVX;
  static String[] zzbVY = new String[0];
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    long l = paramLong;
    if (paramContentResolver != null) {}
    try
    {
      l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (NumberFormatException paramContentResolver) {}
    return paramLong;
  }
  
  @Deprecated
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return zza(paramContentResolver, paramString, null);
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      try
      {
        zza(paramContentResolver);
        localObject2 = zzbVW;
        if (zzbVV.containsKey(paramString1))
        {
          paramContentResolver = (String)zzbVV.get(paramString1);
          if (paramContentResolver != null) {
            paramString2 = paramContentResolver;
          }
          return paramString2;
        }
        localObject1 = zzbVY;
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label138;
        }
        if (!paramString1.startsWith(localObject1[i])) {
          break label277;
        }
        if ((!zzbVX) || (zzbVV.isEmpty()))
        {
          zzc(paramContentResolver, zzbVY);
          if (zzbVV.containsKey(paramString1))
          {
            paramContentResolver = (String)zzbVV.get(paramString1);
            if (paramContentResolver != null) {
              paramString2 = paramContentResolver;
            }
            return paramString2;
          }
        }
      }
      finally {}
      return paramString2;
      label138:
      Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
      if (localCursor != null) {}
      try
      {
        if (!localCursor.moveToFirst())
        {
          zza(localObject2, paramString1, null);
          paramContentResolver = paramString2;
          return paramString2;
        }
        localObject1 = localCursor.getString(1);
        paramContentResolver = (ContentResolver)localObject1;
        if (localObject1 != null)
        {
          paramContentResolver = (ContentResolver)localObject1;
          if (((String)localObject1).equals(paramString2)) {
            paramContentResolver = paramString2;
          }
        }
        zza(localObject2, paramString1, paramContentResolver);
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        paramContentResolver = paramString2;
        return paramString2;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      return paramContentResolver;
      label277:
      i += 1;
    }
  }
  
  public static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(zzbVR, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      if (paramContentResolver.moveToNext()) {
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      return paramVarArgs;
    }
    finally
    {
      paramContentResolver.close();
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    if (zzbVV == null)
    {
      zzbVU.set(false);
      zzbVV = new HashMap();
      zzbVW = new Object();
      zzbVX = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzble.1(null));
    }
    while (!zzbVU.getAndSet(false)) {
      return;
    }
    zzbVV.clear();
    zzbVW = new Object();
    zzbVX = false;
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzbVW) {
        zzbVV.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public static void zzb(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        zza(paramContentResolver);
        paramVarArgs = zzk(paramVarArgs);
        if ((!zzbVX) || (zzbVV.isEmpty()))
        {
          zzc(paramContentResolver, zzbVY);
          return;
        }
      }
      finally {}
      if (paramVarArgs.length != 0) {
        zzc(paramContentResolver, paramVarArgs);
      }
    }
  }
  
  private static void zzc(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    zzbVV.putAll(zza(paramContentResolver, paramArrayOfString));
    zzbVX = true;
  }
  
  private static String[] zzk(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet((zzbVY.length + paramArrayOfString.length) * 4 / 3 + 1);
    localHashSet.addAll(Arrays.asList(zzbVY));
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (localHashSet.add(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      return new String[0];
    }
    zzbVY = (String[])localHashSet.toArray(new String[localHashSet.size()]);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzble
 * JD-Core Version:    0.7.0.1
 */