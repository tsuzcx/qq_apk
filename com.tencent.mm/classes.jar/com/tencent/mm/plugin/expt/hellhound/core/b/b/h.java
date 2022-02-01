package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static String KD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "-1";
    case 0: 
      return "ff000001";
    case 1: 
      return "ff000002";
    case 2: 
      return "ff000003";
    }
    return "ff000004";
  }
  
  private static Fragment a(int paramInt, List<Fragment> paramList, FragmentActivity paramFragmentActivity)
  {
    Fragment localFragment = null;
    AppMethodBeat.i(250882);
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      i = paramList.size();
      if (i <= 5) {}
    }
    else
    {
      AppMethodBeat.o(250882);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(250882);
      return null;
    }
    switch (paramInt)
    {
    default: 
      if (localFragment != null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localFragment = (Fragment)paramList.get(paramInt);
        Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-1: %s", new Object[] { localFragment.getClass().getCanonicalName() });
        AppMethodBeat.o(250882);
        return localFragment;
        localFragment = q(b.weS, paramList);
        break;
        localFragment = q(b.weT, paramList);
        break;
        localFragment = q(b.weU, paramList);
        break;
        localFragment = q(b.weV, paramList);
        break;
        localFragment = q(b.weW, paramList);
      }
      catch (Exception paramList)
      {
        localFragment = d(paramFragmentActivity);
        Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-2: %s", new Object[] { localFragment.getClass().getCanonicalName() });
        continue;
      }
      Log.i("HABBYGE-MALI.FragmentUtil", "_getFragmentByIndex: %s", new Object[] { localFragment.getClass().getCanonicalName() });
    }
  }
  
  public static Fragment a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    AppMethodBeat.i(250876);
    List localList = c(paramFragmentActivity);
    if ((localList == null) || (localList.isEmpty()) || (paramInt < 0) || (paramInt >= localList.size()))
    {
      AppMethodBeat.o(250876);
      return null;
    }
    paramFragmentActivity = a(paramInt, localList, paramFragmentActivity);
    AppMethodBeat.o(250876);
    return paramFragmentActivity;
  }
  
  public static Fragment ab(Activity paramActivity)
  {
    AppMethodBeat.i(250884);
    if (paramActivity == null)
    {
      AppMethodBeat.o(250884);
      return null;
    }
    paramActivity = axm(paramActivity.getClass().getCanonicalName());
    AppMethodBeat.o(250884);
    return paramActivity;
  }
  
  public static Fragment ac(Activity paramActivity)
  {
    AppMethodBeat.i(250889);
    paramActivity = k.ac(paramActivity);
    AppMethodBeat.o(250889);
    return paramActivity;
  }
  
  public static Fragment axl(String paramString)
  {
    AppMethodBeat.i(250874);
    if (paramString == null)
    {
      AppMethodBeat.o(250874);
      return null;
    }
    FragmentActivity localFragmentActivity = b.dcs();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(250874);
      return null;
    }
    paramString = c(localFragmentActivity, paramString);
    AppMethodBeat.o(250874);
    return paramString;
  }
  
  public static Fragment axm(String paramString)
  {
    AppMethodBeat.i(250879);
    if (paramString == null)
    {
      AppMethodBeat.o(250879);
      return null;
    }
    if (!b.awy(paramString))
    {
      AppMethodBeat.o(250879);
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getCurrentTabIndex", new Class[0]);
      paramString.setAccessible(true);
      int i = ((Integer)paramString.invoke(null, new Object[0])).intValue();
      Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, index: %d", new Object[] { Integer.valueOf(i) });
      paramString = b.dcs();
      if (paramString == null)
      {
        AppMethodBeat.o(250879);
        return null;
      }
      if (i <= 0)
      {
        paramString = d(paramString);
        AppMethodBeat.o(250879);
        return paramString;
      }
      List localList = paramString.getSupportFragmentManager().getFragments();
      if (localList == null)
      {
        Log.e("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, fragmentList NULL");
        AppMethodBeat.o(250879);
        return null;
      }
      paramString = a(i, localList, paramString);
      AppMethodBeat.o(250879);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(250879);
    }
    return null;
  }
  
  public static Fragment c(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(250875);
    if ((paramFragmentActivity == null) || (paramString == null))
    {
      AppMethodBeat.o(250875);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(250875);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(250875);
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
      AppMethodBeat.o(250875);
      return paramFragmentActivity;
      paramFragmentActivity = null;
    }
  }
  
  public static List<Fragment> c(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(250873);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(250873);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(250873);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    AppMethodBeat.o(250873);
    return paramFragmentActivity;
  }
  
  private static Fragment d(FragmentActivity paramFragmentActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(250885);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(250885);
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
        AppMethodBeat.o(250885);
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
      AppMethodBeat.o(250885);
      return paramFragmentActivity;
      label129:
      Log.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList: %d", new Object[] { Integer.valueOf(paramFragmentActivity.size()) });
      localIterator = paramFragmentActivity.iterator();
      while (localIterator.hasNext())
      {
        paramFragmentActivity = (Fragment)localIterator.next();
        if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded()) && (f(paramFragmentActivity).booleanValue())) {
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
  
  public static Fragment ddc()
  {
    AppMethodBeat.i(250888);
    Fragment localFragment = k.ddc();
    AppMethodBeat.o(250888);
    return localFragment;
  }
  
  private static Boolean f(Fragment paramFragment)
  {
    AppMethodBeat.i(250886);
    try
    {
      Method localMethod = Fragment.class.getDeclaredMethod("isMenuVisible", new Class[0]);
      localMethod.setAccessible(true);
      paramFragment = (Boolean)localMethod.invoke(paramFragment, new Object[0]);
      AppMethodBeat.o(250886);
      return paramFragment;
    }
    catch (Throwable paramFragment)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentUtil", paramFragment, "isMenuVisible", new Object[0]);
      paramFragment = Boolean.FALSE;
      AppMethodBeat.o(250886);
    }
    return paramFragment;
  }
  
  private static Fragment q(String paramString, List<Fragment> paramList)
  {
    AppMethodBeat.i(250883);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Fragment localFragment = (Fragment)paramList.next();
      if ((localFragment != null) && (paramString.equals(localFragment.getClass().getCanonicalName())))
      {
        AppMethodBeat.o(250883);
        return localFragment;
      }
    }
    AppMethodBeat.o(250883);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.h
 * JD-Core Version:    0.7.0.1
 */