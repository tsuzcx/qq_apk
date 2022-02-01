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
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String qYF = "com.tencent.mm.ui.conversation.MainUI";
  public static String qYG = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String qYH = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String qYI = "com.tencent.mm.ui.MoreTabUI";
  public static String qYJ = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String qYK = "MainUI";
  public static String qYL = "AddressUIFragment";
  public static String qYM = "FindMoreFriendsUI";
  public static String qYN = "MoreTabUI";
  public static String qYO = "ChattingUIFragment";
  
  public static float Q(Activity paramActivity)
  {
    AppMethodBeat.i(195978);
    if (paramActivity == null)
    {
      AppMethodBeat.o(195978);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(2131166269);
    }
    AppMethodBeat.o(195978);
    return f1;
  }
  
  public static boolean aeA(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean aeB(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean aeC(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment aeD(String paramString)
  {
    AppMethodBeat.i(121854);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.c(cph());
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
  
  public static boolean aeE(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean aeF(String paramString)
  {
    AppMethodBeat.i(195975);
    if (paramString == null)
    {
      AppMethodBeat.o(195975);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qYF.equals(paramString)) || (qYG.equals(paramString)) || (qYH.equals(paramString)) || (qYI.equals(paramString)) || (qYJ.equals(paramString)))
      {
        AppMethodBeat.o(195975);
        return true;
      }
      AppMethodBeat.o(195975);
      return false;
    }
    if ((qYK.equals(paramString)) || (qYL.equals(paramString)) || (qYM.equals(paramString)) || (qYN.equals(paramString)) || (qYO.equals(paramString)))
    {
      AppMethodBeat.o(195975);
      return true;
    }
    AppMethodBeat.o(195975);
    return false;
  }
  
  public static boolean aeG(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((qYF.equals(paramString)) || (qYG.equals(paramString)) || (qYH.equals(paramString)) || (qYI.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((qYK.equals(paramString)) || (qYL.equals(paramString)) || (qYM.equals(paramString)) || (qYN.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String aeH(String paramString)
  {
    AppMethodBeat.i(195979);
    if (paramString == null)
    {
      AppMethodBeat.o(195979);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(195979);
    return paramString;
  }
  
  public static String aeI(String paramString)
  {
    AppMethodBeat.i(195985);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195985);
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
        AppMethodBeat.o(195985);
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
    AppMethodBeat.o(195985);
    return "0";
    AppMethodBeat.o(195985);
    return "1";
    AppMethodBeat.o(195985);
    return "2";
    AppMethodBeat.o(195985);
    return "3";
  }
  
  public static String aeJ(String paramString)
  {
    AppMethodBeat.i(195986);
    if (paramString == null)
    {
      AppMethodBeat.o(195986);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(195986);
    return paramString;
  }
  
  public static boolean ael(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean aem(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static boolean aen(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static boolean aeo(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean aep(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean aeq(String paramString)
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
  
  public static String aer(String paramString)
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
  
  public static bou aes(String paramString)
  {
    AppMethodBeat.i(195974);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.agf(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(195974);
      return null;
    }
    paramString = (bou)paramString.get(paramString.size() - 1);
    AppMethodBeat.o(195974);
    return paramString;
  }
  
  public static boolean aet(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean aeu(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean aev(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean aew(String paramString)
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
  
  public static boolean aex(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(aer(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean aey(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean aez(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean cpe()
  {
    AppMethodBeat.i(121845);
    Context localContext = ak.getContext();
    String str = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName;
    if (str == null)
    {
      AppMethodBeat.o(121845);
      return false;
    }
    boolean bool = localContext.getPackageName().equals(str);
    AppMethodBeat.o(121845);
    return bool;
  }
  
  public static String cpf()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dh(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().qZz.cpD();
      ae.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cpP();
      AppMethodBeat.o(121847);
      return localObject;
    }
    ae.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by key_pause: %s, %b, %s", new Object[] { ((com.tencent.mm.vending.j.b)localObject).get(0), ((com.tencent.mm.vending.j.c)localObject).get(1), ((com.tencent.mm.vending.j.d)localObject).get(2) });
    if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
    {
      localObject = (String)((com.tencent.mm.vending.j.d)localObject).get(2);
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cpP();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cpP();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static Pair<String, Integer> cpg()
  {
    AppMethodBeat.i(195973);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crJ();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dh(105);
      if (localObject == null)
      {
        AppMethodBeat.o(195973);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = Pair.create(((com.tencent.mm.vending.j.d)localObject).get(2), Integer.valueOf(0));
        AppMethodBeat.o(195973);
        return localObject;
      }
      localObject = Pair.create(((com.tencent.mm.vending.j.b)localObject).get(0), Integer.valueOf(0));
      AppMethodBeat.o(195973);
      return localObject;
    }
    localObject = Pair.create(((cia)localObject).duQ, Integer.valueOf(((cia)localObject).aHQ));
    AppMethodBeat.o(195973);
    return localObject;
  }
  
  public static FragmentActivity cph()
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
  
  public static String cpi()
  {
    AppMethodBeat.i(195982);
    try
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        AppMethodBeat.o(195982);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.Jdz, "");
      AppMethodBeat.o(195982);
      return str;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(195982);
    }
    return "";
  }
  
  public static String cpj()
  {
    AppMethodBeat.i(195983);
    try
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        AppMethodBeat.o(195983);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JdA, "");
      AppMethodBeat.o(195983);
      return str;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(195983);
    }
    return "";
  }
  
  public static String cpk()
  {
    AppMethodBeat.i(195984);
    try
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        AppMethodBeat.o(195984);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JdB, "");
      AppMethodBeat.o(195984);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(195984);
    }
    return "";
  }
  
  public static String cpl()
  {
    if (com.tencent.mm.loader.j.a.hjw == null) {
      return com.tencent.mm.loader.j.a.REV;
    }
    return com.tencent.mm.loader.j.a.hjw;
  }
  
  public static Pair<Integer, Integer> dR(View paramView)
  {
    AppMethodBeat.i(195980);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(195980);
    return paramView;
  }
  
  public static Pair<Float, Float> dS(View paramView)
  {
    AppMethodBeat.i(195981);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(195981);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.h.d.ctr();
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
  
  public static String rp(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
  
  public static String toHexString(int paramInt)
  {
    AppMethodBeat.i(195976);
    if (paramInt == -1)
    {
      AppMethodBeat.o(195976);
      return "-1";
    }
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(195976);
    return str;
  }
  
  public static int u(Activity paramActivity)
  {
    AppMethodBeat.i(195977);
    if (paramActivity == null)
    {
      AppMethodBeat.o(195977);
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
          AppMethodBeat.o(195977);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(195977);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */