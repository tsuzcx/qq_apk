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
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  public static String zAQ = "com.tencent.mm.ui.conversation.MainUI";
  public static String zAR = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
  public static String zAS = "com.tencent.mm.ui.contact.address.MvvmAddressUIFragment";
  public static String zAT = "com.tencent.mm.ui.FindMoreFriendsUI";
  public static String zAU = "com.tencent.mm.ui.MoreTabUI";
  public static String zAV = "com.tencent.mm.ui.chatting.ChattingUIFragment";
  public static String zAW = "MainUI";
  public static String zAX = "AddressUIFragment";
  public static String zAY = "MvvmAddressUIFragment";
  public static String zAZ = "FindMoreFriendsUI";
  public static String zBa = "MoreTabUI";
  public static String zBb = "ChattingUIFragment";
  
  public static String Lx(int paramInt)
  {
    AppMethodBeat.i(300030);
    if (paramInt == -1)
    {
      AppMethodBeat.o(300030);
      return "-1";
    }
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(300030);
    return str;
  }
  
  public static float Y(Activity paramActivity)
  {
    AppMethodBeat.i(300040);
    if (paramActivity == null)
    {
      AppMethodBeat.o(300040);
      return 0.0F;
    }
    paramActivity = paramActivity.getResources();
    float f2 = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("status_bar_height", "dimen", "android"));
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramActivity.getDimensionPixelSize(b.b.expt_sns_statusbar_height);
    }
    AppMethodBeat.o(300040);
    return f1;
  }
  
  public static boolean aqA(String paramString)
  {
    AppMethodBeat.i(169258);
    boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(paramString);
    AppMethodBeat.o(169258);
    return bool;
  }
  
  public static boolean aqB(String paramString)
  {
    AppMethodBeat.i(299929);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(299929);
      return false;
    }
    boolean bool = paramString.contains(".plugin.finder.");
    AppMethodBeat.o(299929);
    return bool;
  }
  
  public static boolean aqC(String paramString)
  {
    AppMethodBeat.i(169259);
    boolean bool = "com.tencent.mm.ui.LauncherUI".equals(paramString);
    AppMethodBeat.o(169259);
    return bool;
  }
  
  public static boolean aqD(String paramString)
  {
    AppMethodBeat.i(169260);
    boolean bool = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(paramString);
    AppMethodBeat.o(169260);
    return bool;
  }
  
  public static boolean aqE(String paramString)
  {
    AppMethodBeat.i(169261);
    boolean bool = "com.tencent.mm.ui.contact.SelectContactUI".equals(paramString);
    AppMethodBeat.o(169261);
    return bool;
  }
  
  public static boolean aqF(String paramString)
  {
    AppMethodBeat.i(169262);
    boolean bool = "com.tencent.mm.app.WeChatSplashActivity".equals(paramString);
    AppMethodBeat.o(169262);
    return bool;
  }
  
  public static boolean aqG(String paramString)
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
  
  public static String aqH(String paramString)
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
  
  public static czu aqI(String paramString)
  {
    AppMethodBeat.i(299970);
    paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.asW(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(299970);
      return null;
    }
    paramString = (czu)paramString.get(paramString.size() - 1);
    AppMethodBeat.o(299970);
    return paramString;
  }
  
  public static boolean aqJ(String paramString)
  {
    AppMethodBeat.i(169264);
    boolean bool = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(paramString);
    AppMethodBeat.o(169264);
    return bool;
  }
  
  public static boolean aqK(String paramString)
  {
    AppMethodBeat.i(169265);
    boolean bool = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString);
    AppMethodBeat.o(169265);
    return bool;
  }
  
  public static boolean aqL(String paramString)
  {
    AppMethodBeat.i(121850);
    boolean bool = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", paramString);
    AppMethodBeat.o(121850);
    return bool;
  }
  
  public static boolean aqM(String paramString)
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
  
  public static boolean aqN(String paramString)
  {
    AppMethodBeat.i(121852);
    boolean bool = "AppBrandLauncherUI".equals(aqH(paramString));
    AppMethodBeat.o(121852);
    return bool;
  }
  
  public static boolean aqO(String paramString)
  {
    AppMethodBeat.i(169266);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(paramString);
    AppMethodBeat.o(169266);
    return bool;
  }
  
  public static boolean aqP(String paramString)
  {
    AppMethodBeat.i(169267);
    boolean bool = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString);
    AppMethodBeat.o(169267);
    return bool;
  }
  
  public static boolean aqQ(String paramString)
  {
    AppMethodBeat.i(169268);
    boolean bool = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(paramString);
    AppMethodBeat.o(169268);
    return bool;
  }
  
  public static boolean aqR(String paramString)
  {
    AppMethodBeat.i(169269);
    boolean bool = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString);
    AppMethodBeat.o(169269);
    return bool;
  }
  
  public static boolean aqS(String paramString)
  {
    AppMethodBeat.i(169270);
    boolean bool = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString);
    AppMethodBeat.o(169270);
    return bool;
  }
  
  public static Fragment aqT(String paramString)
  {
    AppMethodBeat.i(300010);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.b(dIW());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment != null) && (localFragment.getClass().getSimpleName().equals(paramString)))
        {
          AppMethodBeat.o(300010);
          return localFragment;
        }
      }
    }
    AppMethodBeat.o(300010);
    return null;
  }
  
  public static boolean aqU(String paramString)
  {
    AppMethodBeat.i(169271);
    boolean bool = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(paramString);
    AppMethodBeat.o(169271);
    return bool;
  }
  
  public static boolean aqV(String paramString)
  {
    AppMethodBeat.i(300021);
    if (paramString == null)
    {
      AppMethodBeat.o(300021);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((zAQ.equals(paramString)) || (zAR.equals(paramString)) || (zAS.equals(paramString)) || (zAT.equals(paramString)) || (zAU.equals(paramString)) || (zAV.equals(paramString)))
      {
        AppMethodBeat.o(300021);
        return true;
      }
      AppMethodBeat.o(300021);
      return false;
    }
    if ((zAW.equals(paramString)) || (zAX.equals(paramString)) || (zAY.equals(paramString)) || (zAZ.equals(paramString)) || (zBa.equals(paramString)) || (zBb.equals(paramString)))
    {
      AppMethodBeat.o(300021);
      return true;
    }
    AppMethodBeat.o(300021);
    return false;
  }
  
  public static boolean aqW(String paramString)
  {
    AppMethodBeat.i(177356);
    if (paramString == null)
    {
      AppMethodBeat.o(177356);
      return false;
    }
    if (paramString.contains("."))
    {
      if ((zAQ.equals(paramString)) || (zAR.equals(paramString)) || (zAS.equals(paramString)) || (zAT.equals(paramString)) || (zAU.equals(paramString)))
      {
        AppMethodBeat.o(177356);
        return true;
      }
      AppMethodBeat.o(177356);
      return false;
    }
    if ((zAW.equals(paramString)) || (zAX.equals(paramString)) || (zAY.equals(paramString)) || (zAZ.equals(paramString)) || (zBa.equals(paramString)))
    {
      AppMethodBeat.o(177356);
      return true;
    }
    AppMethodBeat.o(177356);
    return false;
  }
  
  public static String aqX(String paramString)
  {
    AppMethodBeat.i(300043);
    if (paramString == null)
    {
      AppMethodBeat.o(300043);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(300043);
    return paramString;
  }
  
  public static void aqY(String paramString)
  {
    AppMethodBeat.i(300060);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.baz();
      if (!bool)
      {
        AppMethodBeat.o(300060);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(300060);
        return;
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeW, paramString);
      AppMethodBeat.o(300060);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramString, "setFinderCurTabContextId crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(300060);
    }
  }
  
  public static void aqZ(String paramString)
  {
    AppMethodBeat.i(300076);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.baz();
      if (!bool)
      {
        AppMethodBeat.o(300076);
        return;
      }
      bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(300076);
        return;
      }
      Log.i("HABBYGE-MALI.HellhoundUtil", "setFinderContextId USERINFO_FINDER_CONTEXT_ID_STRING:".concat(String.valueOf(paramString)));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adeY, paramString);
      AppMethodBeat.o(300076);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(300076);
    }
  }
  
  public static String ara(String paramString)
  {
    AppMethodBeat.i(300081);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(300081);
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
        AppMethodBeat.o(300081);
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
    AppMethodBeat.o(300081);
    return "0";
    AppMethodBeat.o(300081);
    return "1";
    AppMethodBeat.o(300081);
    return "2";
    AppMethodBeat.o(300081);
    return "3";
  }
  
  public static String arb(String paramString)
  {
    AppMethodBeat.i(300082);
    if (paramString == null)
    {
      AppMethodBeat.o(300082);
      return null;
    }
    paramString = paramString.replace(",", ".");
    AppMethodBeat.o(300082);
    return paramString;
  }
  
  public static boolean arc(String paramString)
  {
    AppMethodBeat.i(300086);
    boolean bool = Util.isEqual(paramString, z.bAW());
    AppMethodBeat.o(300086);
    return bool;
  }
  
  public static String bys()
  {
    AppMethodBeat.i(300071);
    try
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(300071);
        return "";
      }
      Log.i("HABBYGE-MALI.HellhoundUtil", "getFinderContextId USERINFO_FINDER_CONTEXT_ID_STRING:" + (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adeY, ""));
      String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adeY, "");
      AppMethodBeat.o(300071);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(300071);
    }
    return "";
  }
  
  public static String dIU()
  {
    AppMethodBeat.i(121847);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LC(106);
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs().zBL.dJq();
      Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", new Object[] { localObject });
      if (localObject != null)
      {
        AppMethodBeat.o(121847);
        return localObject;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dJH();
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
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dJH();
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    if (localObject != null)
    {
      AppMethodBeat.o(121847);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dJH();
    AppMethodBeat.o(121847);
    return localObject;
  }
  
  public static Pair<String, Integer> dIV()
  {
    AppMethodBeat.i(299966);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLZ();
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LC(105);
      if (localObject == null)
      {
        AppMethodBeat.o(299966);
        return null;
      }
      if (((Boolean)((com.tencent.mm.vending.j.c)localObject).get(1)).booleanValue())
      {
        localObject = Pair.create((String)((com.tencent.mm.vending.j.d)localObject).get(2), Integer.valueOf(0));
        AppMethodBeat.o(299966);
        return localObject;
      }
      localObject = Pair.create((String)((com.tencent.mm.vending.j.b)localObject).get(0), Integer.valueOf(0));
      AppMethodBeat.o(299966);
      return localObject;
    }
    localObject = Pair.create(((ead)localObject).hJW, Integer.valueOf(((ead)localObject).cHb));
    AppMethodBeat.o(299966);
    return localObject;
  }
  
  public static FragmentActivity dIW()
  {
    AppMethodBeat.i(300007);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getInstance", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (FragmentActivity)((Method)localObject).invoke(null, new Object[0]);
      AppMethodBeat.o(300007);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(300007);
    }
    return null;
  }
  
  public static String dIX()
  {
    AppMethodBeat.i(300055);
    try
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(300055);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adeW, "");
      AppMethodBeat.o(300055);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderCurTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(300055);
    }
    return "";
  }
  
  public static String dIY()
  {
    AppMethodBeat.i(300067);
    try
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(300067);
        return "";
      }
      String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adeX, "");
      AppMethodBeat.o(300067);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", localException, "getFinderReportTabContextId crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(300067);
    }
    return "";
  }
  
  public static Pair<Integer, Integer> fb(View paramView)
  {
    AppMethodBeat.i(300046);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = Pair.create(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
    AppMethodBeat.o(300046);
    return paramView;
  }
  
  public static Pair<Float, Float> fc(View paramView)
  {
    AppMethodBeat.i(300050);
    int i = paramView.getMeasuredWidth();
    float f1 = paramView.getWidth();
    int j = paramView.getMeasuredHeight();
    float f2 = paramView.getHeight();
    paramView = Pair.create(Float.valueOf(Math.max(i, f1)), Float.valueOf(Math.max(j, f2)));
    AppMethodBeat.o(300050);
    return paramView;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(121855);
    com.tencent.mm.plugin.expt.e.d.dNI();
    int i = com.tencent.mm.plugin.expt.e.d.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(121855);
      return 0;
    }
    AppMethodBeat.o(121855);
    return i;
  }
  
  public static String hF(long paramLong)
  {
    AppMethodBeat.i(169272);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(169272);
    return str;
  }
  
  public static boolean isMMProcess()
  {
    AppMethodBeat.i(121845);
    Context localContext = MMApplicationContext.getContext();
    String str = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName;
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
  
  public static int v(Activity paramActivity)
  {
    AppMethodBeat.i(300035);
    if (paramActivity == null)
    {
      AppMethodBeat.o(300035);
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
          AppMethodBeat.o(300035);
          return i;
        }
      }
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(300035);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b
 * JD-Core Version:    0.7.0.1
 */