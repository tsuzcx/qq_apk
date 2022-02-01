package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static String CV(int paramInt)
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
        localFragment = p(b.qQH, paramList);
        break;
        localFragment = p(b.qQI, paramList);
        break;
        localFragment = p(b.qQJ, paramList);
        break;
        localFragment = p(b.qQK, paramList);
        break;
        localFragment = p(b.qQL, paramList);
      }
      catch (Exception paramList)
      {
        localFragment = d(paramFragmentActivity);
        ad.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-2: %s", new Object[] { localFragment.getClass().getCanonicalName() });
        continue;
      }
      ad.i("HABBYGE-MALI.FragmentUtil", "_getFragmentByIndex: %s", new Object[] { localFragment.getClass().getCanonicalName() });
    }
  }
  
  public static Fragment a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    AppMethodBeat.i(210356);
    List localList = c(paramFragmentActivity);
    if ((localList == null) || (localList.isEmpty()) || (paramInt < 0) || (paramInt >= localList.size()))
    {
      AppMethodBeat.o(210356);
      return null;
    }
    paramFragmentActivity = a(paramInt, localList, paramFragmentActivity);
    AppMethodBeat.o(210356);
    return paramFragmentActivity;
  }
  
  public static Fragment ab(Activity paramActivity)
  {
    AppMethodBeat.i(184335);
    if (paramActivity == null)
    {
      AppMethodBeat.o(184335);
      return null;
    }
    paramActivity = aec(paramActivity.getClass().getCanonicalName());
    AppMethodBeat.o(184335);
    return paramActivity;
  }
  
  public static Fragment ac(Activity paramActivity)
  {
    AppMethodBeat.i(210358);
    paramActivity = j.ac(paramActivity);
    AppMethodBeat.o(210358);
    return paramActivity;
  }
  
  public static Fragment aeb(String paramString)
  {
    AppMethodBeat.i(210355);
    if (paramString == null)
    {
      AppMethodBeat.o(210355);
      return null;
    }
    FragmentActivity localFragmentActivity = b.cnF();
    if (localFragmentActivity == null)
    {
      AppMethodBeat.o(210355);
      return null;
    }
    paramString = c(localFragmentActivity, paramString);
    AppMethodBeat.o(210355);
    return paramString;
  }
  
  public static Fragment aec(String paramString)
  {
    AppMethodBeat.i(184332);
    if (paramString == null)
    {
      AppMethodBeat.o(184332);
      return null;
    }
    if (!b.ads(paramString))
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
      paramString = b.cnF();
      if (paramString == null)
      {
        AppMethodBeat.o(184332);
        return null;
      }
      if (i <= 0)
      {
        paramString = d(paramString);
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
  
  public static List<Fragment> c(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(210354);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(210354);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(210354);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    AppMethodBeat.o(210354);
    return paramFragmentActivity;
  }
  
  public static Fragment cop()
  {
    AppMethodBeat.i(210357);
    Fragment localFragment = j.cop();
    AppMethodBeat.o(210357);
    return localFragment;
  }
  
  private static Fragment d(FragmentActivity paramFragmentActivity)
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
        if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded()) && (e(paramFragmentActivity).booleanValue())) {
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
  
  private static Boolean e(Fragment paramFragment)
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
  
  private static Fragment p(String paramString, List<Fragment> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.h
 * JD-Core Version:    0.7.0.1
 */