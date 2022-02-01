package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static Fragment a(int paramInt, List<Fragment> paramList, FragmentActivity paramFragmentActivity)
  {
    Object localObject = null;
    AppMethodBeat.i(299982);
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      i = paramList.size();
      if (i <= 5) {}
    }
    else
    {
      AppMethodBeat.o(299982);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(299982);
      return null;
    }
    switch (paramInt)
    {
    default: 
      if (localObject != null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localObject = (Fragment)paramList.get(paramInt);
        Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-1: %s", new Object[] { localObject.getClass().getCanonicalName() });
        AppMethodBeat.o(299982);
        return localObject;
        localObject = w(b.zAQ, paramList);
        break;
        Fragment localFragment = w(b.zAS, paramList);
        localObject = localFragment;
        if (localFragment != null) {
          break;
        }
        localObject = w(b.zAR, paramList);
        break;
        localObject = w(b.zAT, paramList);
        break;
        localObject = w(b.zAU, paramList);
        break;
        localObject = w(b.zAV, paramList);
      }
      catch (Exception paramList)
      {
        localObject = c(paramFragmentActivity);
        Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-2: %s", new Object[] { localObject.getClass().getCanonicalName() });
        continue;
      }
      Log.i("HABBYGE-MALI.FragmentUtil", "_getFragmentByIndex: %s", new Object[] { localObject.getClass().getCanonicalName() });
    }
  }
  
  public static Fragment a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    AppMethodBeat.i(299964);
    List localList = b(paramFragmentActivity);
    if ((localList == null) || (localList.isEmpty()) || (paramInt < 0) || (paramInt >= localList.size()))
    {
      AppMethodBeat.o(299964);
      return null;
    }
    paramFragmentActivity = a(paramInt, localList, paramFragmentActivity);
    AppMethodBeat.o(299964);
    return paramFragmentActivity;
  }
  
  public static Fragment ak(Activity paramActivity)
  {
    AppMethodBeat.i(299991);
    if (paramActivity == null)
    {
      AppMethodBeat.o(299991);
      return null;
    }
    paramActivity = arq(paramActivity.getClass().getCanonicalName());
    AppMethodBeat.o(299991);
    return paramActivity;
  }
  
  public static Fragment arp(String paramString)
  {
    AppMethodBeat.i(299948);
    if (paramString == null)
    {
      AppMethodBeat.o(299948);
      return null;
    }
    FragmentActivity localFragmentActivity = b.dIW();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(299948);
      return null;
    }
    paramString = c(localFragmentActivity, paramString);
    AppMethodBeat.o(299948);
    return paramString;
  }
  
  public static Fragment arq(String paramString)
  {
    AppMethodBeat.i(299974);
    if (paramString == null)
    {
      AppMethodBeat.o(299974);
      return null;
    }
    if (!b.aqC(paramString))
    {
      AppMethodBeat.o(299974);
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getCurrentTabIndex", new Class[0]);
      paramString.setAccessible(true);
      int i = ((Integer)paramString.invoke(null, new Object[0])).intValue();
      Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, index: %d", new Object[] { Integer.valueOf(i) });
      paramString = b.dIW();
      if (paramString == null)
      {
        AppMethodBeat.o(299974);
        return null;
      }
      if (i <= 0)
      {
        paramString = c(paramString);
        AppMethodBeat.o(299974);
        return paramString;
      }
      List localList = paramString.getSupportFragmentManager().getFragments();
      if (localList == null)
      {
        Log.e("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, fragmentList NULL");
        AppMethodBeat.o(299974);
        return null;
      }
      paramString = a(i, localList, paramString);
      AppMethodBeat.o(299974);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(299974);
    }
    return null;
  }
  
  public static List<Fragment> b(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(299942);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299942);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299942);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    AppMethodBeat.o(299942);
    return paramFragmentActivity;
  }
  
  private static Fragment c(FragmentActivity paramFragmentActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(299999);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299999);
      return null;
    }
    Iterator localIterator;
    try
    {
      Object localObject1 = paramFragmentActivity.getClass().getDeclaredMethod("getCurrentFragmet", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Fragment)((Method)localObject1).invoke(paramFragmentActivity, new Object[0]);
      Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragment, 1: %s", new Object[] { localObject1.getClass().getCanonicalName() });
      if (localObject1 != null) {
        break label228;
      }
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
      if (paramFragmentActivity == null)
      {
        Log.e("HABBYGE-MALI.FragmentUtil", "getCurFragment, FragmentManager: NULL");
        AppMethodBeat.o(299999);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localIterator = null;
      }
      paramFragmentActivity = paramFragmentActivity.getFragments();
      if (paramFragmentActivity != null) {
        break label129;
      }
    }
    Log.e("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList NULL");
    paramFragmentActivity = localObject2;
    for (;;)
    {
      AppMethodBeat.o(299999);
      return paramFragmentActivity;
      label129:
      Log.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList: %d", new Object[] { Integer.valueOf(paramFragmentActivity.size()) });
      localIterator = paramFragmentActivity.iterator();
      while (localIterator.hasNext())
      {
        paramFragmentActivity = (Fragment)localIterator.next();
        if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded()) && (v(paramFragmentActivity).booleanValue())) {
          Log.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem: %s", new Object[] { paramFragmentActivity.getClass().getCanonicalName() });
        }
      }
      for (;;)
      {
        break;
        paramFragmentActivity = null;
      }
      label228:
      paramFragmentActivity = localIterator;
    }
  }
  
  public static Fragment c(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(299956);
    if ((paramFragmentActivity == null) || (paramString == null))
    {
      AppMethodBeat.o(299956);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299956);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299956);
      return null;
    }
    Iterator localIterator = paramFragmentActivity.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramFragmentActivity = (Fragment)localIterator.next();
    } while ((paramFragmentActivity == null) || (!paramString.equals(paramFragmentActivity.getClass().getCanonicalName())));
    for (;;)
    {
      AppMethodBeat.o(299956);
      return paramFragmentActivity;
      paramFragmentActivity = null;
    }
  }
  
  public static Fragment d(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(300013);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(300013);
      return null;
    }
    if (!b.aqC(paramFragmentActivity.getClass().getCanonicalName()))
    {
      AppMethodBeat.o(300013);
      return null;
    }
    for (;;)
    {
      try
      {
        Method localMethod = Class.forName(paramFragmentActivity.getClass().getCanonicalName()).getDeclaredMethod("getMainTabCurFragment", new Class[0]);
        localMethod.setAccessible(true);
        paramFragmentActivity = localMethod.invoke(paramFragmentActivity, new Object[0]);
        if ((paramFragmentActivity != null) && ((paramFragmentActivity instanceof Fragment)))
        {
          paramFragmentActivity = (Fragment)paramFragmentActivity;
          AppMethodBeat.o(300013);
          return paramFragmentActivity;
        }
      }
      catch (Exception paramFragmentActivity)
      {
        AppMethodBeat.o(300013);
        return null;
      }
      paramFragmentActivity = null;
    }
  }
  
  private static Boolean v(Fragment paramFragment)
  {
    AppMethodBeat.i(300005);
    try
    {
      Method localMethod = Fragment.class.getDeclaredMethod("isMenuVisible", new Class[0]);
      localMethod.setAccessible(true);
      paramFragment = (Boolean)localMethod.invoke(paramFragment, new Object[0]);
      AppMethodBeat.o(300005);
      return paramFragment;
    }
    finally
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentUtil", paramFragment, "isMenuVisible", new Object[0]);
      paramFragment = Boolean.FALSE;
      AppMethodBeat.o(300005);
    }
    return paramFragment;
  }
  
  private static Fragment w(String paramString, List<Fragment> paramList)
  {
    AppMethodBeat.i(299986);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Fragment localFragment = (Fragment)paramList.next();
      if ((localFragment != null) && (paramString.equals(localFragment.getClass().getCanonicalName())))
      {
        AppMethodBeat.o(299986);
        return localFragment;
      }
    }
    AppMethodBeat.o(299986);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.h
 * JD-Core Version:    0.7.0.1
 */