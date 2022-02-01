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
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String qiH = "com.tencent.mm.ui.conversation.MainUI";
  public static String qiI = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String qiJ = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String qiK = "com.tencent.mm.ui.MoreTabUI";
  public static String qiL = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String qiM = "MainUI";
  public static String qiN = "AddressUIFragment";
  public static String qiO = "FindMoreFriendsUI";
  public static String qiP = "MoreTabUI";
  public static String qiQ = "ChattingUIFragment";
  
  public static float P(Activity paramActivity)
  {
    AppMethodBeat.i(195199);
    if (paramActivity == null)
    {
      AppMethodBeat.o(195199);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(195199);
    return f1;
  }
  
  public static boolean ZE(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean ZF(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static boolean ZG(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static boolean ZH(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean ZI(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean ZJ(String paramString)
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
  
  public static String ZK(String paramString)
  {
    AppMethodBeat.i(121846);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121846);
      return null;
    }
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
  
  public static String ZL(String paramString)
  {
    AppMethodBeat.i(121849);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.abw(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(121849);
      return null;
    }
    paramString = ((bju)paramString.get(paramString.size() - 1)).qoi;
    AppMethodBeat.o(121849);
    return paramString;
  }
  
  public static boolean ZM(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean ZN(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean ZO(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean ZP(String paramString)
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
  
  public static boolean ZQ(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(ZK(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean ZR(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean ZS(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean ZT(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean ZU(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean ZV(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment ZW(String paramString)
  {
    AppMethodBeat.i(121854);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.c(ciH());
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
  
  public static boolean ZX(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean ZY(String paramString)
  {
    AppMethodBeat.i(195197);
    if (paramString == null)
    {
      AppMethodBeat.o(195197);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qiH.equals(paramString)) || (qiI.equals(paramString)) || (qiJ.equals(paramString)) || (qiK.equals(paramString)) || (qiL.equals(paramString)))
      {
        AppMethodBeat.o(195197);
        return true;
      }
      AppMethodBeat.o(195197);
      return false;
    }
    if ((qiM.equals(paramString)) || (qiN.equals(paramString)) || (qiO.equals(paramString)) || (qiP.equals(paramString)) || (qiQ.equals(paramString)))
    {
      AppMethodBeat.o(195197);
      return true;
    }
    AppMethodBeat.o(195197);
    return false;
  }
  
  public static boolean ZZ(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qiH.equals(paramString)) || (qiI.equals(paramString)) || (qiJ.equals(paramString)) || (qiK.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((qiM.equals(paramString)) || (qiN.equals(paramString)) || (qiO.equals(paramString)) || (qiP.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String aaa(String paramString)
  {
    AppMethodBeat.i(195200);
    if (paramString == null)
    {
      AppMethodBeat.o(195200);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(195200);
    return paramString;
  }
  
  public static String aab(String paramString)
  {
    AppMethodBeat.i(195205);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195205);
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
        AppMethodBeat.o(195205);
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
    AppMethodBeat.o(195205);
    return "0";
    AppMethodBeat.o(195205);
    return "1";
    AppMethodBeat.o(195205);
    return "2";
    AppMethodBeat.o(195205);
    return "3";
  }
  
  public static String aac(String paramString)
  {
    AppMethodBeat.i(195206);
    if (paramString == null)
    {
      AppMethodBeat.o(195206);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(195206);
    return paramString;
  }
  
  public static boolean ciE()
  {
    AppMethodBeat.i(121845);
    Context localContext = ai.getContext();
    String str = ((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName;
    if (str == null)
    {
      AppMethodBeat.o(121845);
      return false;
    }
    boolean bool = localContext.getPackageName().equals(str);
    AppMethodBeat.o(121845);
    return bool;
  }
  
  public static String ciF()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Cj(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().qjB.cjb();
      ac.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cjg();
      AppMethodBeat.o(121847);
      return localObject;
    }
    ac.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by key_pause: %s, %b, %s", new Object[] { ((com.tencent.mm.vending.j.b)localObject).get(0), ((com.tencent.mm.vending.j.c)localObject).get(1), ((com.tencent.mm.vending.j.d)localObject).get(2) });
    if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
    {
      localObject = (String)((com.tencent.mm.vending.j.d)localObject).get(2);
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cjg();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cjg();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static String ciG()
  {
    AppMethodBeat.i(121848);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckS();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Cj(105);
      if (localObject == null)
      {
        AppMethodBeat.o(121848);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = (String)((com.tencent.mm.vending.j.d)localObject).get(2);
        AppMethodBeat.o(121848);
        return localObject;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
      AppMethodBeat.o(121848);
      return localObject;
    }
    localObject = ((cco)localObject).qoi;
    AppMethodBeat.o(121848);
    return localObject;
  }
  
  public static FragmentActivity ciH()
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
  
  public static String ciI()
  {
    AppMethodBeat.i(195203);
    try
    {
      if (!com.tencent.mm.kernel.g.agM())
      {
        AppMethodBeat.o(195203);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GVY, "");
      AppMethodBeat.o(195203);
      return str;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(195203);
    }
    return "";
  }
  
  public static String ciJ()
  {
    AppMethodBeat.i(195204);
    try
    {
      if (!com.tencent.mm.kernel.g.agM())
      {
        AppMethodBeat.o(195204);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GVZ, "");
      AppMethodBeat.o(195204);
      return str;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(195204);
    }
    return "";
  }
  
  public static Pair<Integer, Integer> dO(View paramView)
  {
    AppMethodBeat.i(195201);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(195201);
    return paramView;
  }
  
  public static Pair<Float, Float> dP(View paramView)
  {
    AppMethodBeat.i(195202);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(195202);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.e.b.cmk();
    int i = com.tencent.mm.plugin.expt.e.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(121855);
      return 0;
    }
    AppMethodBeat.o(121855);
    return i;
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
  
  public static String pb(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
  
  public static int u(Activity paramActivity)
  {
    AppMethodBeat.i(195198);
    if (paramActivity == null)
    {
      AppMethodBeat.o(195198);
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
          AppMethodBeat.o(195198);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      ac.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(195198);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */