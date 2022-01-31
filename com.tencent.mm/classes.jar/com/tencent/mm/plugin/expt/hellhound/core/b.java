package com.tencent.mm.plugin.expt.hellhound.core;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.expt.hellhound.core.v2.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String Mb(String paramString)
  {
    AppMethodBeat.i(152253);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152253);
      return null;
    }
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(152253);
      return paramString;
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(152253);
    return paramString;
  }
  
  public static boolean Mc(String paramString)
  {
    AppMethodBeat.i(73346);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(73346);
    return bool;
  }
  
  public static boolean Md(String paramString)
  {
    AppMethodBeat.i(152254);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152254);
      return false;
    }
    boolean bool = Pattern.matches("^(" + "AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(152254);
    return bool;
  }
  
  public static boolean Me(String paramString)
  {
    AppMethodBeat.i(152255);
    boolean bool = "AppBrandLauncherUI".equals(Mb(paramString));
    AppMethodBeat.o(152255);
    return bool;
  }
  
  public static Fragment Mf(String paramString)
  {
    AppMethodBeat.i(152257);
    Object localObject = f.a(bru());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment != null) && (localFragment.getClass().getSimpleName().equals(paramString)))
        {
          AppMethodBeat.o(152257);
          return localFragment;
        }
      }
    }
    AppMethodBeat.o(152257);
    return null;
  }
  
  public static boolean brt()
  {
    AppMethodBeat.i(73345);
    Context localContext = ah.getContext();
    String str = ((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName;
    if (str == null)
    {
      AppMethodBeat.o(73345);
      return false;
    }
    boolean bool = localContext.getPackageName().equals(str);
    AppMethodBeat.o(73345);
    return bool;
  }
  
  public static FragmentActivity bru()
  {
    AppMethodBeat.i(152256);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getInstance", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (FragmentActivity)((Method)localObject).invoke(null, new Object[0]);
      AppMethodBeat.o(152256);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(152256);
    }
    return null;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(152258);
    int i = a.QW();
    if (i == 0)
    {
      AppMethodBeat.o(152258);
      return 0;
    }
    AppMethodBeat.o(152258);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */