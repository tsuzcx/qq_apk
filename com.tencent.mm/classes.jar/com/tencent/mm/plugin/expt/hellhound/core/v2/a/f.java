package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.a;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static List<Fragment> a(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(152304);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(152304);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(152304);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    AppMethodBeat.o(152304);
    return paramFragmentActivity;
  }
  
  public static Fragment b(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(152306);
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(152306);
      return null;
    }
    Object localObject3;
    try
    {
      Object localObject1 = paramFragmentActivity.getClass().getDeclaredMethod("getCurrentFragmet", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Fragment)((Method)localObject1).invoke(paramFragmentActivity, new Object[0]);
      ab.i("FragmentUtil", "habbyge-mali, getCurFragment, 1: " + localObject1.getClass().getCanonicalName());
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
        if (paramFragmentActivity == null)
        {
          ab.e("FragmentUtil", "habbyge-mali, getCurFragment, FragmentManager: NULL");
          AppMethodBeat.o(152306);
          return null;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("FragmentUtil", "habbyge-mali, getCurFragment, 1-crash: NULL");
        Object localObject2 = null;
      }
      paramFragmentActivity = c(paramFragmentActivity);
      localObject3 = paramFragmentActivity;
      if (paramFragmentActivity != null)
      {
        ab.i("FragmentUtil", "habbyge-mali, getCurFragment, 2: " + paramFragmentActivity.getClass().getCanonicalName());
        localObject3 = paramFragmentActivity;
      }
      AppMethodBeat.o(152306);
    }
    return localObject3;
  }
  
  public static String brS()
  {
    AppMethodBeat.i(152309);
    Object localObject = a.bsj();
    if (localObject == null)
    {
      ab.e("FragmentUtil", "HABBYGE-MALI, ChatUIFragmentProxy, getCurSid == null");
      AppMethodBeat.o(152309);
      return null;
    }
    localObject = b.Mv(((bki)localObject).czq);
    AppMethodBeat.o(152309);
    return localObject;
  }
  
  private static Fragment c(g paramg)
  {
    AppMethodBeat.i(152307);
    paramg = paramg.getFragments();
    if (paramg == null)
    {
      ab.e("FragmentUtil", "habbyge-mali, _getCurrentFragmentFromSystem, fragmentList NULL");
      AppMethodBeat.o(152307);
      return null;
    }
    ab.i("FragmentUtil", "habbyge-mali, _getCurrentFragmentFromSystem, fragmentList: " + paramg.size());
    Iterator localIterator = paramg.iterator();
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramg = (Fragment)localIterator.next();
      } while (paramg == null);
      ab.i("FragmentUtil", "habbyge-mali, _getCurrentFragmentFromSystem, fragment: " + paramg.getClass().getName());
    } while ((!paramg.isAdded()) || (!f(paramg).booleanValue()));
    for (;;)
    {
      AppMethodBeat.o(152307);
      return paramg;
      paramg = null;
    }
  }
  
  public static Fragment e(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(152305);
    if ((paramFragmentActivity == null) || (paramString == null))
    {
      AppMethodBeat.o(152305);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(152305);
      return null;
    }
    paramFragmentActivity = paramFragmentActivity.getFragments();
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(152305);
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
      AppMethodBeat.o(152305);
      return paramFragmentActivity;
      paramFragmentActivity = null;
    }
  }
  
  private static Boolean f(Fragment paramFragment)
  {
    AppMethodBeat.i(152308);
    try
    {
      Method localMethod = Fragment.class.getDeclaredMethod("isMenuVisible", new Class[0]);
      localMethod.setAccessible(true);
      paramFragment = (Boolean)localMethod.invoke(paramFragment, new Object[0]);
      AppMethodBeat.o(152308);
      return paramFragment;
    }
    catch (Throwable paramFragment)
    {
      ab.printErrStackTrace("FragmentUtil", paramFragment, "habbyge-mali, isMenuVisible", new Object[0]);
      paramFragment = Boolean.FALSE;
      AppMethodBeat.o(152308);
    }
    return paramFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.f
 * JD-Core Version:    0.7.0.1
 */