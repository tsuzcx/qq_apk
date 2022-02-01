package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;

public class APApkFileParser
{
  public static Drawable getAPKIcon(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217487);
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject1 != null)
      {
        localObject2 = ((PackageInfo)localObject1).applicationInfo;
        if (localObject2 != null) {}
      }
      else
      {
        return null;
      }
      localObject1 = ((PackageInfo)localObject1).applicationInfo;
      Class localClass = Class.forName("android.content.res.AssetManager");
      Object localObject2 = (AssetManager)localClass.getConstructor(null).newInstance(null);
      localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = new DisplayMetrics();
      paramString.setToDefaults();
      paramContext = new Resources((AssetManager)localObject2, paramString, paramContext.getResources().getConfiguration());
      if (((ApplicationInfo)localObject1).icon != 0)
      {
        paramContext = paramContext.getDrawable(((ApplicationInfo)localObject1).icon);
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(217487);
    }
    return null;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(217475);
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, paramInt);
      AppMethodBeat.o(217475);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static boolean isApkFileBroken(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217494);
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    if ((paramContext == null) || (paramContext.applicationInfo == null))
    {
      AppMethodBeat.o(217494);
      return true;
    }
    AppMethodBeat.o(217494);
    return false;
  }
  
  public static boolean isSignaturesSame(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    AppMethodBeat.i(217465);
    if (paramArrayOfSignature1 == null)
    {
      AppMethodBeat.o(217465);
      return true;
    }
    if (paramArrayOfSignature2 == null)
    {
      AppMethodBeat.o(217465);
      return true;
    }
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfSignature1.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramArrayOfSignature1[i]);
      i += 1;
    }
    paramArrayOfSignature1 = new HashSet();
    j = paramArrayOfSignature2.length;
    i = 0;
    while (i < j)
    {
      paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
      i += 1;
    }
    boolean bool = localHashSet.equals(paramArrayOfSignature1);
    AppMethodBeat.o(217465);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APApkFileParser
 * JD-Core Version:    0.7.0.1
 */