package com.tencent.mm.plugin.expt.hellhound.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dht;
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
  public static String weS = "com.tencent.mm.ui.conversation.MainUI";
  public static String weT = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String weU = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String weV = "com.tencent.mm.ui.MoreTabUI";
  public static String weW = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String weX = "MainUI";
  public static String weY = "AddressUIFragment";
  public static String weZ = "FindMoreFriendsUI";
  public static String wfa = "MoreTabUI";
  public static String wfb = "ChattingUIFragment";
  
  public static String Fw(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
  
  public static String Kx(int paramInt)
  {
    AppMethodBeat.i(255723);
    if (paramInt == -1)
    {
      AppMethodBeat.o(255723);
      return "-1";
    }
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(255723);
    return str;
  }
  
  public static float P(Activity paramActivity)
  {
    AppMethodBeat.i(255726);
    if (paramActivity == null)
    {
      AppMethodBeat.o(255726);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
    }
    AppMethodBeat.o(255726);
    return f1;
  }
  
  public static boolean awA(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean awB(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean awC(String paramString)
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
  
  public static String awD(String paramString)
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
  
  public static cjp awE(String paramString)
  {
    AppMethodBeat.i(255710);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ayR(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(255710);
      return null;
    }
    paramString = (cjp)paramString.get(paramString.size() - 1);
    AppMethodBeat.o(255710);
    return paramString;
  }
  
  public static boolean awF(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean awG(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean awH(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean awI(String paramString)
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
  
  public static boolean awJ(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(awD(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean awK(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean awL(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean awM(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean awN(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean awO(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment awP(String paramString)
  {
    AppMethodBeat.i(255718);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.c(dcs());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment != null) && (localFragment.getClass().getSimpleName().equals(paramString)))
        {
          AppMethodBeat.o(255718);
          return localFragment;
        }
      }
    }
    AppMethodBeat.o(255718);
    return null;
  }
  
  public static boolean awQ(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean awR(String paramString)
  {
    AppMethodBeat.i(255721);
    if (paramString == null)
    {
      AppMethodBeat.o(255721);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((weS.equals(paramString)) || (weT.equals(paramString)) || (weU.equals(paramString)) || (weV.equals(paramString)) || (weW.equals(paramString)))
      {
        AppMethodBeat.o(255721);
        return true;
      }
      AppMethodBeat.o(255721);
      return false;
    }
    if ((weX.equals(paramString)) || (weY.equals(paramString)) || (weZ.equals(paramString)) || (wfa.equals(paramString)) || (wfb.equals(paramString)))
    {
      AppMethodBeat.o(255721);
      return true;
    }
    AppMethodBeat.o(255721);
    return false;
  }
  
  public static boolean awS(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((weS.equals(paramString)) || (weT.equals(paramString)) || (weU.equals(paramString)) || (weV.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((weX.equals(paramString)) || (weY.equals(paramString)) || (weZ.equals(paramString)) || (wfa.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String awT(String paramString)
  {
    AppMethodBeat.i(255729);
    if (paramString == null)
    {
      AppMethodBeat.o(255729);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(255729);
    return paramString;
  }
  
  public static void awU(String paramString)
  {
    AppMethodBeat.i(255736);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.aHB();
      if (!bool)
      {
        AppMethodBeat.o(255736);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(255736);
        return;
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCi, paramString);
      AppMethodBeat.o(255736);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramString, "setFinderCurTabContextId crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(255736);
    }
  }
  
  public static void awV(String paramString)
  {
    AppMethodBeat.i(255739);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.aHB();
      if (!bool)
      {
        AppMethodBeat.o(255739);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(255739);
        return;
      }
      Log.i("HABBYGE-MALI.HellhoundUtil", "setFinderContextId USERINFO_FINDER_CONTEXT_ID_STRING:".concat(String.valueOf(paramString)));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCk, paramString);
      AppMethodBeat.o(255739);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(255739);
    }
  }
  
  public static String awW(String paramString)
  {
    AppMethodBeat.i(255740);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(255740);
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
        AppMethodBeat.o(255740);
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
    AppMethodBeat.o(255740);
    return "0";
    AppMethodBeat.o(255740);
    return "1";
    AppMethodBeat.o(255740);
    return "2";
    AppMethodBeat.o(255740);
    return "3";
  }
  
  public static String awX(String paramString)
  {
    AppMethodBeat.i(255741);
    if (paramString == null)
    {
      AppMethodBeat.o(255741);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(255741);
    return paramString;
  }
  
  public static boolean awY(String paramString)
  {
    AppMethodBeat.i(255742);
    boolean bool = Util.isEqual(paramString, z.bdh());
    AppMethodBeat.o(255742);
    return bool;
  }
  
  public static boolean awx(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean awy(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static boolean awz(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static String dcq()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KC(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.dcO();
      Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dda();
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
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dda();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dda();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static Pair<String, Integer> dcr()
  {
    AppMethodBeat.i(255707);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfl();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KC(105);
      if (localObject == null)
      {
        AppMethodBeat.o(255707);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = Pair.create(((com.tencent.mm.vending.j.d)localObject).get(2), Integer.valueOf(0));
        AppMethodBeat.o(255707);
        return localObject;
      }
      localObject = Pair.create(((com.tencent.mm.vending.j.b)localObject).get(0), Integer.valueOf(0));
      AppMethodBeat.o(255707);
      return localObject;
    }
    localObject = Pair.create(((dht)localObject).fFe, Integer.valueOf(((dht)localObject).aNf));
    AppMethodBeat.o(255707);
    return localObject;
  }
  
  public static FragmentActivity dcs()
  {
    AppMethodBeat.i(255716);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getInstance", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (FragmentActivity)((Method)localObject).invoke(null, new Object[0]);
      AppMethodBeat.o(255716);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(255716);
    }
    return null;
  }
  
  public static String dct()
  {
    AppMethodBeat.i(255734);
    try
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(255734);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCi, "");
      AppMethodBeat.o(255734);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(255734);
    }
    return "";
  }
  
  public static String dcu()
  {
    AppMethodBeat.i(255737);
    try
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(255737);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCj, "");
      AppMethodBeat.o(255737);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(255737);
    }
    return "";
  }
  
  public static String dcv()
  {
    AppMethodBeat.i(255738);
    try
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(255738);
        return "";
      }
      Log.i("HABBYGE-MALI.HellhoundUtil", "getFinderContextId USERINFO_FINDER_CONTEXT_ID_STRING:" + (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCk, ""));
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCk, "");
      AppMethodBeat.o(255738);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(255738);
    }
    return "";
  }
  
  public static String dcw()
  {
    if (com.tencent.mm.loader.j.a.kRa == null) {
      return com.tencent.mm.loader.j.a.REV;
    }
    return com.tencent.mm.loader.j.a.kRa;
  }
  
  public static Pair<Integer, Integer> eh(View paramView)
  {
    AppMethodBeat.i(255731);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(255731);
    return paramView;
  }
  
  public static Pair<Float, Float> ei(View paramView)
  {
    AppMethodBeat.i(255733);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(255733);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.h.d.dgX();
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
    String str = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName;
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
  
  public static int t(Activity paramActivity)
  {
    AppMethodBeat.i(255724);
    if (paramActivity == null)
    {
      AppMethodBeat.o(255724);
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
          AppMethodBeat.o(255724);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(255724);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */