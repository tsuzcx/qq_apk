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
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String qQH = "com.tencent.mm.ui.conversation.MainUI";
  public static String qQI = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String qQJ = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String qQK = "com.tencent.mm.ui.MoreTabUI";
  public static String qQL = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String qQM = "MainUI";
  public static String qQN = "AddressUIFragment";
  public static String qQO = "FindMoreFriendsUI";
  public static String qQP = "MoreTabUI";
  public static String qQQ = "ChattingUIFragment";
  
  public static float P(Activity paramActivity)
  {
    AppMethodBeat.i(210318);
    if (paramActivity == null)
    {
      AppMethodBeat.o(210318);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(210318);
    return f1;
  }
  
  public static boolean adA(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean adB(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean adC(String paramString)
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
  
  public static boolean adD(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(adx(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean adE(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean adF(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean adG(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean adH(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean adI(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment adJ(String paramString)
  {
    AppMethodBeat.i(121854);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.c(cnF());
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
  
  public static boolean adK(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean adL(String paramString)
  {
    AppMethodBeat.i(210315);
    if (paramString == null)
    {
      AppMethodBeat.o(210315);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qQH.equals(paramString)) || (qQI.equals(paramString)) || (qQJ.equals(paramString)) || (qQK.equals(paramString)) || (qQL.equals(paramString)))
      {
        AppMethodBeat.o(210315);
        return true;
      }
      AppMethodBeat.o(210315);
      return false;
    }
    if ((qQM.equals(paramString)) || (qQN.equals(paramString)) || (qQO.equals(paramString)) || (qQP.equals(paramString)) || (qQQ.equals(paramString)))
    {
      AppMethodBeat.o(210315);
      return true;
    }
    AppMethodBeat.o(210315);
    return false;
  }
  
  public static boolean adM(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qQH.equals(paramString)) || (qQI.equals(paramString)) || (qQJ.equals(paramString)) || (qQK.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((qQM.equals(paramString)) || (qQN.equals(paramString)) || (qQO.equals(paramString)) || (qQP.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String adN(String paramString)
  {
    AppMethodBeat.i(210319);
    if (paramString == null)
    {
      AppMethodBeat.o(210319);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(210319);
    return paramString;
  }
  
  public static String adO(String paramString)
  {
    AppMethodBeat.i(210325);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(210325);
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
        AppMethodBeat.o(210325);
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
    AppMethodBeat.o(210325);
    return "0";
    AppMethodBeat.o(210325);
    return "1";
    AppMethodBeat.o(210325);
    return "2";
    AppMethodBeat.o(210325);
    return "3";
  }
  
  public static String adP(String paramString)
  {
    AppMethodBeat.i(210326);
    if (paramString == null)
    {
      AppMethodBeat.o(210326);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(210326);
    return paramString;
  }
  
  public static boolean adr(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean ads(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static boolean adt(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static boolean adu(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean adv(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean adw(String paramString)
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
  
  public static String adx(String paramString)
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
  
  public static boc ady(String paramString)
  {
    AppMethodBeat.i(210314);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.afj(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(210314);
      return null;
    }
    paramString = (boc)paramString.get(paramString.size() - 1);
    AppMethodBeat.o(210314);
    return paramString;
  }
  
  public static boolean adz(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean cnC()
  {
    AppMethodBeat.i(121845);
    Context localContext = aj.getContext();
    String str = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName;
    if (str == null)
    {
      AppMethodBeat.o(121845);
      return false;
    }
    boolean bool = localContext.getPackageName().equals(str);
    AppMethodBeat.o(121845);
    return bool;
  }
  
  public static String cnD()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CU(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.cob();
      ad.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.con();
      AppMethodBeat.o(121847);
      return localObject;
    }
    ad.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by key_pause: %s, %b, %s", new Object[] { ((com.tencent.mm.vending.j.b)localObject).get(0), ((com.tencent.mm.vending.j.c)localObject).get(1), ((com.tencent.mm.vending.j.d)localObject).get(2) });
    if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
    {
      localObject = (String)((com.tencent.mm.vending.j.d)localObject).get(2);
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.con();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.con();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static Pair<String, Integer> cnE()
  {
    AppMethodBeat.i(210313);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqh();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CU(105);
      if (localObject == null)
      {
        AppMethodBeat.o(210313);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = Pair.create(((com.tencent.mm.vending.j.d)localObject).get(2), Integer.valueOf(0));
        AppMethodBeat.o(210313);
        return localObject;
      }
      localObject = Pair.create(((com.tencent.mm.vending.j.b)localObject).get(0), Integer.valueOf(0));
      AppMethodBeat.o(210313);
      return localObject;
    }
    localObject = Pair.create(((chg)localObject).dtL, Integer.valueOf(((chg)localObject).aHQ));
    AppMethodBeat.o(210313);
    return localObject;
  }
  
  public static FragmentActivity cnF()
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
  
  public static String cnG()
  {
    AppMethodBeat.i(210322);
    try
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        AppMethodBeat.o(210322);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IIT, "");
      AppMethodBeat.o(210322);
      return str;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(210322);
    }
    return "";
  }
  
  public static String cnH()
  {
    AppMethodBeat.i(210323);
    try
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        AppMethodBeat.o(210323);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IIU, "");
      AppMethodBeat.o(210323);
      return str;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(210323);
    }
    return "";
  }
  
  public static String cnI()
  {
    AppMethodBeat.i(210324);
    try
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        AppMethodBeat.o(210324);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IIV, "");
      AppMethodBeat.o(210324);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(210324);
    }
    return "";
  }
  
  public static String cnJ()
  {
    if (com.tencent.mm.loader.j.a.hgI == null) {
      return com.tencent.mm.loader.j.a.REV;
    }
    return com.tencent.mm.loader.j.a.hgI;
  }
  
  public static Pair<Integer, Integer> dR(View paramView)
  {
    AppMethodBeat.i(210320);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(210320);
    return paramView;
  }
  
  public static Pair<Float, Float> dS(View paramView)
  {
    AppMethodBeat.i(210321);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(210321);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.h.d.crP();
    int i = com.tencent.mm.plugin.expt.h.d.getUin();
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
  
  public static String rc(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
  
  public static String toHexString(int paramInt)
  {
    AppMethodBeat.i(210316);
    if (paramInt == -1)
    {
      AppMethodBeat.o(210316);
      return "-1";
    }
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(210316);
    return str;
  }
  
  public static int u(Activity paramActivity)
  {
    AppMethodBeat.i(210317);
    if (paramActivity == null)
    {
      AppMethodBeat.o(210317);
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
          AppMethodBeat.o(210317);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(210317);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */