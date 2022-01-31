package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_CHECK_TMPL_VER", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TOOL", "TOOLMP", "UNKNOW", "alwaysCheckTmpl", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "plugin-brandservice_release"})
public final class g$a
{
  public static boolean aXA()
  {
    AppMethodBeat.i(14854);
    boolean bool = h.aSs().getBoolean("preload_tmpl_test_no_preload_next", false);
    AppMethodBeat.o(14854);
    return bool;
  }
  
  public static boolean aXB()
  {
    AppMethodBeat.i(14855);
    boolean bool = h.aSs().getBoolean("preload_tmpl_test_no_red", false);
    AppMethodBeat.o(14855);
    return bool;
  }
  
  public static boolean aXt()
  {
    AppMethodBeat.i(14847);
    boolean bool = h.aSs().getBoolean("preload_webview", true);
    if (!bool) {
      ab.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
    }
    AppMethodBeat.o(14847);
    return bool;
  }
  
  public static boolean aXu()
  {
    AppMethodBeat.i(14848);
    boolean bool = h.aSs().getBoolean("preload_data", true);
    if (!bool) {
      ab.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
    }
    AppMethodBeat.o(14848);
    return bool;
  }
  
  public static boolean aXv()
  {
    AppMethodBeat.i(14849);
    boolean bool = h.aSs().getBoolean("preload_data_null", false);
    if (!bool) {
      ab.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
    }
    AppMethodBeat.o(14849);
    return bool;
  }
  
  public static boolean aXw()
  {
    AppMethodBeat.i(14850);
    boolean bool = h.aSs().getBoolean("preload_data_noexpire", false);
    AppMethodBeat.o(14850);
    return bool;
  }
  
  public static boolean aXx()
  {
    AppMethodBeat.i(14851);
    boolean bool = h.aSs().getBoolean("preload_save_type", false);
    AppMethodBeat.o(14851);
    return bool;
  }
  
  public static int aXy()
  {
    AppMethodBeat.i(14852);
    int i = h.aSs().getInt("preload_tmpl_lowerbound", -1);
    AppMethodBeat.o(14852);
    return i;
  }
  
  public static boolean aXz()
  {
    AppMethodBeat.i(14853);
    boolean bool = h.aSs().getBoolean("preload_tmpl_test_noredir", false);
    AppMethodBeat.o(14853);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a
 * JD-Core Version:    0.7.0.1
 */