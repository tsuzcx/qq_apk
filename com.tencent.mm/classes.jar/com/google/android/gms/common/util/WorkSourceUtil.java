package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil
{
  public static final String TAG = "WorkSourceUtil";
  private static final int zzaam;
  private static final Method zzaan;
  private static final Method zzaao;
  private static final Method zzaap;
  private static final Method zzaaq;
  private static final Method zzaar;
  private static final Method zzaas;
  private static final Method zzaat;
  
  static
  {
    AppMethodBeat.i(5318);
    zzaam = Process.myUid();
    zzaan = zzdf();
    zzaao = zzdg();
    zzaap = zzdh();
    zzaaq = zzdi();
    zzaar = zzdj();
    zzaas = zzdk();
    zzaat = zzdl();
    AppMethodBeat.o(5318);
  }
  
  public static void add(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    AppMethodBeat.i(5303);
    if (zzaao != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      try
      {
        zzaao.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        AppMethodBeat.o(5303);
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        AppMethodBeat.o(5303);
        return;
      }
    }
    if (zzaan != null) {
      try
      {
        zzaan.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(5303);
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    AppMethodBeat.o(5303);
  }
  
  public static WorkSource fromPackage(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5302);
    if ((paramContext == null) || (paramContext.getPackageManager() == null) || (paramString == null))
    {
      AppMethodBeat.o(5302);
      return null;
    }
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (paramContext != null) {
        break label124;
      }
      paramContext = String.valueOf(paramString);
      if (paramContext.length() == 0) {
        break label111;
      }
      "Could not get applicationInfo from package: ".concat(paramContext);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          "Could not find package: ".concat(paramContext);
        }
        for (;;)
        {
          AppMethodBeat.o(5302);
          return null;
          new String("Could not find package: ");
        }
        label111:
        new String("Could not get applicationInfo from package: ");
      }
      label124:
      paramContext = fromUidAndPackage(paramContext.uid, paramString);
      AppMethodBeat.o(5302);
    }
    AppMethodBeat.o(5302);
    return null;
    return paramContext;
  }
  
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5304);
    if ((paramContext == null) || (paramContext.getPackageManager() == null) || (paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(5304);
      return null;
    }
    int i = zzc(paramContext, paramString1);
    if (i < 0)
    {
      AppMethodBeat.o(5304);
      return null;
    }
    paramContext = new WorkSource();
    if ((zzaas == null) || (zzaat == null)) {
      add(paramContext, i, paramString1);
    }
    for (;;)
    {
      AppMethodBeat.o(5304);
      return paramContext;
      try
      {
        Object localObject = zzaas.invoke(paramContext, new Object[0]);
        if (i != zzaam) {
          zzaat.invoke(localObject, new Object[] { Integer.valueOf(i), paramString1 });
        }
        zzaat.invoke(localObject, new Object[] { Integer.valueOf(zzaam), paramString2 });
      }
      catch (Exception paramString1) {}
    }
  }
  
  public static WorkSource fromUidAndPackage(int paramInt, String paramString)
  {
    AppMethodBeat.i(5301);
    WorkSource localWorkSource = new WorkSource();
    add(localWorkSource, paramInt, paramString);
    AppMethodBeat.o(5301);
    return localWorkSource;
  }
  
  public static int get(WorkSource paramWorkSource, int paramInt)
  {
    AppMethodBeat.i(5306);
    if (zzaaq != null) {
      try
      {
        paramInt = ((Integer)zzaaq.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) })).intValue();
        AppMethodBeat.o(5306);
        return paramInt;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    AppMethodBeat.o(5306);
    return 0;
  }
  
  public static String getName(WorkSource paramWorkSource, int paramInt)
  {
    AppMethodBeat.i(5307);
    if (zzaar != null) {
      try
      {
        paramWorkSource = (String)zzaar.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(5307);
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    AppMethodBeat.o(5307);
    return null;
  }
  
  public static List<String> getNames(WorkSource paramWorkSource)
  {
    int j = 0;
    AppMethodBeat.i(5308);
    if (paramWorkSource == null) {}
    for (int i = 0; i == 0; i = size(paramWorkSource))
    {
      paramWorkSource = Collections.emptyList();
      AppMethodBeat.o(5308);
      return paramWorkSource;
    }
    ArrayList localArrayList = new ArrayList();
    while (j < i)
    {
      String str = getName(paramWorkSource, j);
      if (!Strings.isEmptyOrWhitespace(str)) {
        localArrayList.add(str);
      }
      j += 1;
    }
    AppMethodBeat.o(5308);
    return localArrayList;
  }
  
  public static boolean hasWorkSourcePermission(Context paramContext)
  {
    AppMethodBeat.i(5309);
    if (paramContext == null)
    {
      AppMethodBeat.o(5309);
      return false;
    }
    if (paramContext.getPackageManager() == null)
    {
      AppMethodBeat.o(5309);
      return false;
    }
    if (Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0)
    {
      AppMethodBeat.o(5309);
      return true;
    }
    AppMethodBeat.o(5309);
    return false;
  }
  
  public static int size(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(5305);
    if (zzaap != null) {
      try
      {
        int i = ((Integer)zzaap.invoke(paramWorkSource, new Object[0])).intValue();
        AppMethodBeat.o(5305);
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    AppMethodBeat.o(5305);
    return 0;
  }
  
  private static int zzc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5310);
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (paramContext != null) {
        break label101;
      }
      paramContext = String.valueOf(paramString);
      if (paramContext.length() == 0) {
        break label88;
      }
      "Could not get applicationInfo from package: ".concat(paramContext);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          "Could not find package: ".concat(paramContext);
        }
        for (;;)
        {
          AppMethodBeat.o(5310);
          return -1;
          new String("Could not find package: ");
        }
        new String("Could not get applicationInfo from package: ");
      }
      int i = paramContext.uid;
      AppMethodBeat.o(5310);
      return i;
    }
    AppMethodBeat.o(5310);
    return -1;
  }
  
  private static Method zzdf()
  {
    AppMethodBeat.i(5311);
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(5311);
    return localObject;
  }
  
  private static Method zzdg()
  {
    AppMethodBeat.i(5312);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      localObject1 = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
      AppMethodBeat.o(5312);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static Method zzdh()
  {
    AppMethodBeat.i(5313);
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    AppMethodBeat.o(5313);
    return localObject;
  }
  
  private static Method zzdi()
  {
    AppMethodBeat.i(5314);
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(5314);
    return localObject;
  }
  
  private static Method zzdj()
  {
    AppMethodBeat.i(5315);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      localObject1 = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
      AppMethodBeat.o(5315);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static final Method zzdk()
  {
    AppMethodBeat.i(5316);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (PlatformVersion.isAtLeastP()) {}
    try
    {
      localObject1 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
      AppMethodBeat.o(5316);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  @SuppressLint({"PrivateApi"})
  private static final Method zzdl()
  {
    AppMethodBeat.i(5317);
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (PlatformVersion.isAtLeastP()) {}
    try
    {
      localObject1 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[] { Integer.TYPE, String.class });
      AppMethodBeat.o(5317);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.WorkSourceUtil
 * JD-Core Version:    0.7.0.1
 */