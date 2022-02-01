package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public static Fragment VZ(String paramString)
  {
    AppMethodBeat.i(184332);
    if (paramString == null)
    {
      AppMethodBeat.o(184332);
      return null;
    }
    if (!b.Vt(paramString))
    {
      AppMethodBeat.o(184332);
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getCurrentTabIndex", new Class[0]);
      paramString.setAccessible(true);
      int i = ((Integer)paramString.invoke(null, new Object[0])).intValue();
      ad.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, index: %d", new Object[] { Integer.valueOf(i) });
      paramString = b.cby();
      if (paramString == null)
      {
        AppMethodBeat.o(184332);
        return null;
      }
      if (i <= 0)
      {
        paramString = c(paramString);
        AppMethodBeat.o(184332);
        return paramString;
      }
      List localList = paramString.getSupportFragmentManager().getFragments();
      if (localList == null)
      {
        ad.e("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, fragmentList NULL");
        AppMethodBeat.o(184332);
        return null;
      }
      paramString = a(i, localList, paramString);
      AppMethodBeat.o(184332);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(184332);
    }
    return null;
  }
  
  private static Fragment a(int paramInt, List<Fragment> paramList, FragmentActivity paramFragmentActivity)
  {
    Fragment localFragment = null;
    AppMethodBeat.i(184333);
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      i = paramList.size();
      if (i <= 5) {}
    }
    else
    {
      AppMethodBeat.o(184333);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= i))
    {
      AppMethodBeat.o(184333);
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
        ad.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-1: %s", new Object[] { localFragment.getClass().getCanonicalName() });
        AppMethodBeat.o(184333);
        return localFragment;
        localFragment = q(b.pDU, paramList);
        break;
        localFragment = q(b.pDV, paramList);
        break;
        localFragment = q(b.pDW, paramList);
        break;
        localFragment = q(b.pDX, paramList);
        break;
        localFragment = q(b.pDY, paramList);
      }
      catch (Exception paramList)
      {
        localFragment = c(paramFragmentActivity);
        ad.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-2: %s", new Object[] { localFragment.getClass().getCanonicalName() });
        continue;
      }
      ad.i("HABBYGE-MALI.FragmentUtil", "_getFragmentByIndex: %s", new Object[] { localFragment.getClass().getCanonicalName() });
    }
  }
  
  public static Fragment a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    AppMethodBeat.i(205377);
    List localList = e(paramFragmentActivity);
    if ((localList == null) || (localList.isEmpty()) || (paramInt < 0) || (paramInt >= localList.size()))
    {
      AppMethodBeat.o(205377);
      return null;
    }
    paramFragmentActivity = a(paramInt, localList, paramFragmentActivity);
    AppMethodBeat.o(205377);
    return paramFragmentActivity;
  }
  
  public static Fragment aa(Activity paramActivity)
  {
    AppMethodBeat.i(184335);
    if (paramActivity == null)
    {
      AppMethodBeat.o(184335);
      return null;
    }
    paramActivity = VZ(paramActivity.getClass().getCanonicalName());
    AppMethodBeat.o(184335);
    return paramActivity;
  }
  
  public static Fragment bt(Activity paramActivity)
  {
    AppMethodBeat.i(205379);
    paramActivity = j.bt(paramActivity);
    AppMethodBeat.o(205379);
    return paramActivity;
  }
  
  private static Fragment c(FragmentActivity paramFragmentActivity)
  {
    Object localObject2 = null;
    AppMethodBeat.i(122017);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(122017);
      return null;
    }
    Iterator localIterator;
    try
    {
      Object localObject1 = paramFragmentActivity.getClass().getDeclaredMethod("getCurrentFragmet", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Fragment)((Method)localObject1).invoke(paramFragmentActivity, new Object[0]);
      ad.i("HABBYGE-MALI.FragmentUtil", "getCurFragment, 1: %s", new Object[] { localObject1.getClass().getCanonicalName() });
      if (localObject1 != null) {
        break label228;
      }
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
      if (paramFragmentActivity == null)
      {
        ad.e("HABBYGE-MALI.FragmentUtil", "getCurFragment, FragmentManager: NULL");
        AppMethodBeat.o(122017);
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
    ad.e("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList NULL");
    paramFragmentActivity = localObject2;
    for (;;)
    {
      AppMethodBeat.o(122017);
      return paramFragmentActivity;
      label129:
      ad.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList: %d", new Object[] { Integer.valueOf(paramFragmentActivity.size()) });
      localIterator = paramFragmentActivity.iterator();
      while (localIterator.hasNext())
      {
        paramFragmentActivity = (Fragment)localIterator.next();
        if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded()) && (f(paramFragmentActivity).booleanValue())) {
          ad.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem: %s", new Object[] { paramFragmentActivity.getClass().getCanonicalName() });
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
    AppMethodBeat.i(122015);
    if ((paramFragmentActivity == null) || (paramString == null))
    {
      AppMethodBeat.o(122015);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(122015);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(122015);
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
      AppMethodBeat.o(122015);
      return paramFragmentActivity;
      paramFragmentActivity = null;
    }
  }
  
  public static List<Fragment> e(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(205376);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(205376);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(205376);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    AppMethodBeat.o(205376);
    return paramFragmentActivity;
  }
  
  private static Boolean f(Fragment paramFragment)
  {
    AppMethodBeat.i(122018);
    try
    {
      Method localMethod = Fragment.class.getDeclaredMethod("isMenuVisible", new Class[0]);
      localMethod.setAccessible(true);
      paramFragment = (Boolean)localMethod.invoke(paramFragment, new Object[0]);
      AppMethodBeat.o(122018);
      return paramFragment;
    }
    catch (Throwable paramFragment)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FragmentUtil", paramFragment, "isMenuVisible", new Object[0]);
      paramFragment = Boolean.FALSE;
      AppMethodBeat.o(122018);
    }
    return paramFragment;
  }
  
  public static Fragment fRo()
  {
    AppMethodBeat.i(205378);
    Fragment localFragment = j.fRo();
    AppMethodBeat.o(205378);
    return localFragment;
  }
  
  private static Fragment q(String paramString, List<Fragment> paramList)
  {
    AppMethodBeat.i(184334);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Fragment localFragment = (Fragment)paramList.next();
      if ((localFragment != null) && (paramString.equals(localFragment.getClass().getCanonicalName())))
      {
        AppMethodBeat.o(184334);
        return localFragment;
      }
    }
    AppMethodBeat.o(184334);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.g
 * JD-Core Version:    0.7.0.1
 */