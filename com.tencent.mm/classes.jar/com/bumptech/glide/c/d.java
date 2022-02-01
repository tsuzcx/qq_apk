package com.bumptech.glide.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public final class d
{
  private final Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static b T(String paramString)
  {
    AppMethodBeat.i(77596);
    Class localClass;
    try
    {
      localClass = Class.forName(paramString);
      paramString = null;
    }
    catch (ClassNotFoundException paramString)
    {
      Object localObject;
      label30:
      paramString = new IllegalArgumentException("Unable to find GlideModule implementation", paramString);
      AppMethodBeat.o(77596);
      throw paramString;
    }
    try
    {
      localObject = localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      paramString = localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      a(localClass, localInstantiationException);
      break label30;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      a(localClass, localIllegalAccessException);
      break label30;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      a(localClass, localNoSuchMethodException);
      break label30;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      a(localClass, localInvocationTargetException);
      break label30;
      paramString = (b)paramString;
      AppMethodBeat.o(77596);
    }
    if (!(paramString instanceof b))
    {
      paramString = new RuntimeException("Expected instanceof GlideModule, but found: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(77596);
      throw paramString;
    }
    return paramString;
  }
  
  private static void a(Class<?> paramClass, Exception paramException)
  {
    AppMethodBeat.i(77597);
    paramClass = new RuntimeException("Unable to instantiate GlideModule implementation for ".concat(String.valueOf(paramClass)), paramException);
    AppMethodBeat.o(77597);
    throw paramClass;
  }
  
  public final List<b> pU()
  {
    AppMethodBeat.i(77595);
    Log.isLoggable("ManifestParser", 3);
    ArrayList localArrayList = new ArrayList();
    RuntimeException localRuntimeException;
    try
    {
      ApplicationInfo localApplicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
      if (localApplicationInfo.metaData == null)
      {
        Log.isLoggable("ManifestParser", 3);
        AppMethodBeat.o(77595);
        return localArrayList;
      }
      if (Log.isLoggable("ManifestParser", 2)) {
        new StringBuilder("Got app info metadata: ").append(localApplicationInfo.metaData);
      }
      Iterator localIterator = localApplicationInfo.metaData.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("GlideModule".equals(localApplicationInfo.metaData.get(str)))
        {
          localArrayList.add(T(str));
          Log.isLoggable("ManifestParser", 3);
        }
      }
      Log.isLoggable("ManifestParser", 3);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localRuntimeException = new RuntimeException("Unable to find metadata to parse GlideModules", localNameNotFoundException);
      AppMethodBeat.o(77595);
      throw localRuntimeException;
    }
    AppMethodBeat.o(77595);
    return localRuntimeException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d
 * JD-Core Version:    0.7.0.1
 */