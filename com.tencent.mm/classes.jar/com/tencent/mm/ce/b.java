package com.tencent.mm.ce;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class b
{
  public static String aclA;
  public static String aclB;
  public static String aclC;
  private static Boolean aclD = null;
  public static String aclz = "caremode_setting_succeed";
  private static boolean epk;
  private static boolean mrc;
  
  static
  {
    aclA = "care_mode";
    aclB = "care_mode_font_size";
    aclC = "care_mode_change";
    epk = false;
    mrc = false;
  }
  
  public static void Km(boolean paramBoolean)
  {
    AppMethodBeat.i(233110);
    getKV().edit().putBoolean(aclC, paramBoolean).commit();
    Log.i("MicroMsg.MMCareModeManager", "setCareModeChange:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(233110);
  }
  
  public static void Kn(boolean paramBoolean)
  {
    AppMethodBeat.i(233142);
    boolean bool = Util.nullAsFalse(Boolean.valueOf(h.baE().ban().getBoolean(at.a.acQy, false)));
    if ((paramBoolean) && (bool != epk))
    {
      Km(true);
      Log.i("MicroMsg.MMCareModeManager", "care mode state change, before:%s, now:%s", new Object[] { Boolean.valueOf(epk), Boolean.valueOf(bool) });
    }
    epk = bool;
    AppMethodBeat.o(233142);
  }
  
  public static void axU(int paramInt)
  {
    AppMethodBeat.i(233089);
    getKV().edit().putInt(aclB, paramInt).commit();
    Log.i("MicroMsg.MMCareModeManager", "setCareModeFontSize:%s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(233089);
  }
  
  private static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(233075);
    Log.d("MicroMsg.MMCareModeManager", "getKV, uin:%s", new Object[] { Integer.valueOf(com.tencent.mm.kernel.b.aZP()) });
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(aclA + "_" + com.tencent.mm.kernel.b.aZP());
    AppMethodBeat.o(233075);
    return localMultiProcessMMKV;
  }
  
  public static int iRn()
  {
    AppMethodBeat.i(233100);
    int i = getKV().getInt(aclB, 0);
    Log.i("MicroMsg.MMCareModeManager", "getCareModeFontSize:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(233100);
    return i;
  }
  
  public static boolean iRo()
  {
    AppMethodBeat.i(233120);
    boolean bool = getKV().getBoolean(aclC, false);
    Log.i("MicroMsg.MMCareModeManager", "getCareModeChange:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(233120);
    return bool;
  }
  
  public static boolean iRp()
  {
    AppMethodBeat.i(233132);
    if (!MMApplicationContext.isMainProcess())
    {
      Log.w("MicroMsg.MMCareModeManager", "not main process!!");
      AppMethodBeat.o(233132);
      return false;
    }
    if (!h.baz())
    {
      Log.w("MicroMsg.MMCareModeManager", "accout not ready");
      AppMethodBeat.o(233132);
      return false;
    }
    if (!mrc)
    {
      epk = Util.nullAsFalse(Boolean.valueOf(h.baE().ban().getBoolean(at.a.acQy, false)));
      mrc = true;
    }
    boolean bool = epk;
    AppMethodBeat.o(233132);
    return bool;
  }
  
  public static boolean iRq()
  {
    AppMethodBeat.i(233154);
    if (!iRr())
    {
      AppMethodBeat.o(233154);
      return true;
    }
    String str = ((a)h.ax(a.class)).aRC().getValue("DisableCareModeEntry");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.MMCareModeManager", "isHideCareModeEntrance, ShowCareMode is null");
      AppMethodBeat.o(233154);
      return false;
    }
    int i = Integer.parseInt(str);
    Log.i("MicroMsg.MMCareModeManager", "isHideCareModeEntrance, val is %s", new Object[] { Integer.valueOf(i) });
    if ((str != null) && (i > 0))
    {
      AppMethodBeat.o(233154);
      return true;
    }
    AppMethodBeat.o(233154);
    return false;
  }
  
  private static boolean iRr()
  {
    AppMethodBeat.i(233164);
    if (aclD == null) {}
    try
    {
      if (Util.getInt(d.dNI().a("clicfg_care_mode_switch", "1", false, true), 1) > 0) {
        Log.i("MicroMsg.MMCareModeManager", "openCareModeEntrance!!");
      }
      for (aclD = Boolean.TRUE;; aclD = Boolean.FALSE)
      {
        boolean bool = aclD.booleanValue();
        AppMethodBeat.o(233164);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMCareModeManager", localException, "closeCareModeEntrance", new Object[0]);
        aclD = Boolean.FALSE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.b
 * JD-Core Version:    0.7.0.1
 */