package com.tencent.mm.plugin.expt.hellhound.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String syW = "com.tencent.mm.ui.conversation.MainUI";
  public static String syX = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String syY = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String syZ = "com.tencent.mm.ui.MoreTabUI";
  public static String sza = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String szb = "MainUI";
  public static String szc = "AddressUIFragment";
  public static String szd = "FindMoreFriendsUI";
  public static String sze = "MoreTabUI";
  public static String szf = "ChattingUIFragment";
  
  public static float O(Activity paramActivity)
  {
    AppMethodBeat.i(220405);
    if (paramActivity == null)
    {
      AppMethodBeat.o(220405);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(2131166312);
    }
    AppMethodBeat.o(220405);
    return f1;
  }
  
  public static boolean aoA(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static boolean aoB(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean aoC(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean aoD(String paramString)
  {
    AppMethodBeat.i(169263);
    if ((paramString != null) && (paramString.startsWith("com.tencent.mm.splash.")))
    {
      AppMethodBeat.o(169263);
      return true;
    }
    AppMethodBeat.o(169263);
    return false;
  }
  
  public static String aoE(String paramString)
  {
    AppMethodBeat.i(121846);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121846);
      return null;
    }
    paramString = paramString.replace("/", ".");
    int i = paramString.lastIndexOf(".");
    if ((i < 0) || (i >= paramString.length() - 1))
    {
      AppMethodBeat.o(121846);
      return paramString;
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(121846);
    return paramString;
  }
  
  public static cbm aoF(String paramString)
  {
    AppMethodBeat.i(220401);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(220401);
      return null;
    }
    paramString = (cbm)paramString.get(paramString.size() - 1);
    AppMethodBeat.o(220401);
    return paramString;
  }
  
  public static boolean aoG(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean aoH(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean aoI(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean aoJ(String paramString)
  {
    AppMethodBeat.i(121851);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121851);
      return false;
    }
    boolean bool = Pattern.matches("^(" + "AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121851);
    return bool;
  }
  
  public static boolean aoK(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(aoE(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean aoL(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean aoM(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean aoN(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean aoO(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean aoP(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment aoQ(String paramString)
  {
    AppMethodBeat.i(121854);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.c(cNA());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment != null) && (localFragment.getClass().getSimpleName().equals(paramString)))
        {
          AppMethodBeat.o(121854);
          return localFragment;
        }
      }
    }
    AppMethodBeat.o(121854);
    return null;
  }
  
  public static boolean aoR(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean aoS(String paramString)
  {
    AppMethodBeat.i(220402);
    if (paramString == null)
    {
      AppMethodBeat.o(220402);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((syW.equals(paramString)) || (syX.equals(paramString)) || (syY.equals(paramString)) || (syZ.equals(paramString)) || (sza.equals(paramString)))
      {
        AppMethodBeat.o(220402);
        return true;
      }
      AppMethodBeat.o(220402);
      return false;
    }
    if ((szb.equals(paramString)) || (szc.equals(paramString)) || (szd.equals(paramString)) || (sze.equals(paramString)) || (szf.equals(paramString)))
    {
      AppMethodBeat.o(220402);
      return true;
    }
    AppMethodBeat.o(220402);
    return false;
  }
  
  public static boolean aoT(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((syW.equals(paramString)) || (syX.equals(paramString)) || (syY.equals(paramString)) || (syZ.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((szb.equals(paramString)) || (szc.equals(paramString)) || (szd.equals(paramString)) || (sze.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String aoU(String paramString)
  {
    AppMethodBeat.i(220406);
    if (paramString == null)
    {
      AppMethodBeat.o(220406);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(220406);
    return paramString;
  }
  
  public static void aoV(String paramString)
  {
    AppMethodBeat.i(220410);
    try
    {
      boolean bool = com.tencent.mm.kernel.g.aAc();
      if (!bool)
      {
        AppMethodBeat.o(220410);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(220410);
        return;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Onc, paramString);
      AppMethodBeat.o(220410);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramString, "setFinderCurTabContextId crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(220410);
    }
  }
  
  public static void aoW(String paramString)
  {
    AppMethodBeat.i(220413);
    try
    {
      boolean bool = com.tencent.mm.kernel.g.aAc();
      if (!bool)
      {
        AppMethodBeat.o(220413);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(220413);
        return;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.One, paramString);
      AppMethodBeat.o(220413);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(220413);
    }
  }
  
  public static String aoX(String paramString)
  {
    AppMethodBeat.i(220414);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(220414);
      return "";
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(220414);
        return paramString;
        if (paramString.equals("FinderFollowTabFragment"))
        {
          i = 0;
          continue;
          if (paramString.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment"))
          {
            i = 1;
            continue;
            if (paramString.equals("FinderFriendTabFragment"))
            {
              i = 2;
              continue;
              if (paramString.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"))
              {
                i = 3;
                continue;
                if (paramString.equals("FinderMachineTabFragment"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("FinderLbsTabFragment"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment")) {
                        i = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(220414);
    return "0";
    AppMethodBeat.o(220414);
    return "1";
    AppMethodBeat.o(220414);
    return "2";
    AppMethodBeat.o(220414);
    return "3";
  }
  
  public static String aoY(String paramString)
  {
    AppMethodBeat.i(220415);
    if (paramString == null)
    {
      AppMethodBeat.o(220415);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(220415);
    return paramString;
  }
  
  public static boolean aoZ(String paramString)
  {
    AppMethodBeat.i(220416);
    boolean bool = Util.isEqual(paramString, z.aUg());
    AppMethodBeat.o(220416);
    return bool;
  }
  
  public static boolean aoy(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean aoz(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static FragmentActivity cNA()
  {
    AppMethodBeat.i(121853);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getInstance", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (FragmentActivity)((Method)localObject).invoke(null, new Object[0]);
      AppMethodBeat.o(121853);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(121853);
    }
    return null;
  }
  
  public static String cNB()
  {
    AppMethodBeat.i(220409);
    try
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        AppMethodBeat.o(220409);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Onc, "");
      AppMethodBeat.o(220409);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(220409);
    }
    return "";
  }
  
  public static String cNC()
  {
    AppMethodBeat.i(220411);
    try
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        AppMethodBeat.o(220411);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ond, "");
      AppMethodBeat.o(220411);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(220411);
    }
    return "";
  }
  
  public static String cND()
  {
    AppMethodBeat.i(220412);
    try
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        AppMethodBeat.o(220412);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.One, "");
      AppMethodBeat.o(220412);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(220412);
    }
    return "";
  }
  
  public static String cNE()
  {
    if (com.tencent.mm.loader.j.a.ict == null) {
      return com.tencent.mm.loader.j.a.REV;
    }
    return com.tencent.mm.loader.j.a.ict;
  }
  
  public static String cNy()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GS(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNW();
      Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
      AppMethodBeat.o(121847);
      return localObject;
    }
    Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by key_pause: %s, %b, %s", new Object[] { ((com.tencent.mm.vending.j.b)localObject).get(0), ((com.tencent.mm.vending.j.c)localObject).get(1), ((com.tencent.mm.vending.j.d)localObject).get(2) });
    if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
    {
      localObject = (String)((com.tencent.mm.vending.j.d)localObject).get(2);
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static Pair<String, Integer> cNz()
  {
    AppMethodBeat.i(220400);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQr();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GS(105);
      if (localObject == null)
      {
        AppMethodBeat.o(220400);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = Pair.create(((com.tencent.mm.vending.j.d)localObject).get(2), Integer.valueOf(0));
        AppMethodBeat.o(220400);
        return localObject;
      }
      localObject = Pair.create(((com.tencent.mm.vending.j.b)localObject).get(0), Integer.valueOf(0));
      AppMethodBeat.o(220400);
      return localObject;
    }
    localObject = Pair.create(((cyh)localObject).dMl, Integer.valueOf(((cyh)localObject).aHK));
    AppMethodBeat.o(220400);
    return localObject;
  }
  
  public static Pair<Integer, Integer> dJ(View paramView)
  {
    AppMethodBeat.i(220407);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(220407);
    return paramView;
  }
  
  public static Pair<Float, Float> dK(View paramView)
  {
    AppMethodBeat.i(220408);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(220408);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.h.d.cRY();
    int i = com.tencent.mm.plugin.expt.h.d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(121855);
      return 0;
    }
    AppMethodBeat.o(121855);
    return i;
  }
  
  public static boolean isMMProcess()
  {
    AppMethodBeat.i(121845);
    Context localContext = MMApplicationContext.getContext();
    String str = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName;
    if (str == null)
    {
      AppMethodBeat.o(121845);
      return false;
    }
    boolean bool = localContext.getPackageName().equals(str);
    AppMethodBeat.o(121845);
    return bool;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(121856);
    if ((paramString != null) && (!"".equals(paramString.trim())) && (paramString.matches("^[0-9]*$")))
    {
      AppMethodBeat.o(121856);
      return true;
    }
    AppMethodBeat.o(121856);
    return false;
  }
  
  public static String toHexString(int paramInt)
  {
    AppMethodBeat.i(220403);
    if (paramInt == -1)
    {
      AppMethodBeat.o(220403);
      return "-1";
    }
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(220403);
    return str;
  }
  
  public static int u(Activity paramActivity)
  {
    AppMethodBeat.i(220404);
    if (paramActivity == null)
    {
      AppMethodBeat.o(220404);
      return 0;
    }
    try
    {
      if ((paramActivity instanceof AppCompatActivity))
      {
        paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
        if (paramActivity != null)
        {
          int i = paramActivity.getCustomView().getHeight();
          AppMethodBeat.o(220404);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(220404);
    }
    return 0;
  }
  
  public static String zs(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */