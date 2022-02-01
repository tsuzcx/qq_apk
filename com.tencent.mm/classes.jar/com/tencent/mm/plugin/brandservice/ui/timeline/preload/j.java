package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.xwebutil.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements a
{
  public static final a vSB;
  
  static
  {
    AppMethodBeat.i(6632);
    vSB = new a((byte)0);
    AppMethodBeat.o(6632);
  }
  
  public static final void aoW()
  {
    AppMethodBeat.i(6633);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new j(), new String[] { "//mpfast" });
    AppMethodBeat.o(6633);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(6631);
    s.u(paramContext, "context");
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    if (s.p("//mpfast", paramArrayOfString[0]))
    {
      if (paramArrayOfString.length < 2)
      {
        AppMethodBeat.o(6631);
        return false;
      }
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(6631);
        return true;
        if (paramContext.equals("red"))
        {
          k.cTb().removeValueForKey("preload_tmpl_test_no_red");
          o.fQ("MicroMsg.PreloadUtil", "disable test not in red");
          continue;
          if (paramContext.equals("webview"))
          {
            if (paramArrayOfString.length <= 2)
            {
              k.cTb().putBoolean("preload_webview", true);
              o.fQ("MicroMsg.PreloadUtil", "use preload webview");
              continue;
              if (!paramContext.equals("nored")) {
                continue;
              }
              k.cTb().putBoolean("preload_tmpl_test_no_red", true);
              o.fQ("MicroMsg.PreloadUtil", "enable test not in red");
              continue;
              if ((!paramContext.equals("tmpl")) || (paramArrayOfString.length <= 2)) {
                continue;
              }
              paramContext = paramArrayOfString[2];
              switch (paramContext.hashCode())
              {
              }
            }
            do
            {
              do
              {
                do
                {
                  do
                  {
                    if (!Pattern.compile("[0-9]+").matcher((CharSequence)paramArrayOfString[2]).matches()) {
                      break;
                    }
                    if (!s.p("0", paramArrayOfString[2])) {
                      break label1424;
                    }
                    k.cTb().remove("preload_tmpl_lowerbound");
                    o.fQ("MicroMsg.PreloadUtil", "clear tmpl lowerbound");
                    break;
                    if (!paramContext.equals("data")) {
                      break;
                    }
                    if (paramArrayOfString.length <= 2)
                    {
                      k.cTb().putBoolean("preload_data_null", false);
                      k.cTb().putBoolean("preload_data", true);
                      o.fQ("MicroMsg.PreloadUtil", "enable preload data");
                      break;
                      if ((!paramContext.equals("test")) || (paramArrayOfString.length <= 2) || (!s.p(paramArrayOfString[2], "news"))) {
                        break;
                      }
                      k.cTb().putBoolean("tencent_view_inews_prefix", true);
                      o.fQ("MicroMsg.PreloadUtil", "test news");
                      break;
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      k.cTb().clear();
                      o.fQ("MicroMsg.PreloadUtil", "clear all commands");
                      break;
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      if (paramArrayOfString.length <= 2)
                      {
                        k.cTb().putBoolean("preload_use", true);
                        k.cTb().putInt("preload_type", 1);
                        o.fQ("MicroMsg.PreloadUtil", "tmpl webview");
                        break;
                        if (!paramContext.equals("false")) {
                          break;
                        }
                        k.cTb().putBoolean("preload_use", false);
                        o.fQ("MicroMsg.PreloadUtil", "not use tmpl webview");
                        break;
                        if (!paramContext.equals("save")) {
                          break;
                        }
                        if (paramArrayOfString.length > 2) {
                          break label1473;
                        }
                        k.cTb().putBoolean("preload_save_type", false);
                        o.fQ("MicroMsg.PreloadUtil", "save to data dir");
                        break;
                      }
                      k.cTb().putBoolean("preload_use", true);
                      paramContext = paramArrayOfString[2];
                      switch (paramContext.hashCode())
                      {
                      }
                      do
                      {
                        do
                        {
                          do
                          {
                            k.cTb().putInt("preload_type", 1);
                            o.fQ("MicroMsg.PreloadUtil", "release can't use local tmpl, use online tmpl");
                            break;
                          } while (!paramContext.equals("server"));
                          k.cTb().putInt("preload_type", 2);
                          o.fQ("MicroMsg.PreloadUtil", "test server tmpl");
                          break;
                        } while (!paramContext.equals("online"));
                        k.cTb().putInt("preload_type", 1);
                        o.fQ("MicroMsg.PreloadUtil", "online tmpl");
                        break;
                      } while (!paramContext.equals("local"));
                      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
                        break;
                      }
                      k.cTb().putInt("preload_type", 3);
                      o.fQ("MicroMsg.PreloadUtil", "local tmpl");
                      break;
                      paramContext = paramArrayOfString[2];
                      switch (paramContext.hashCode())
                      {
                      default: 
                        break;
                      case -1039871948: 
                        if (!paramContext.equals("nonext")) {
                          break;
                        }
                        k.cTb().putBoolean("preload_tmpl_test_no_preload_next", true);
                        o.fQ("MicroMsg.PreloadUtil", "disable preload next webview");
                        break;
                      case 3377907: 
                        if (!paramContext.equals("next")) {
                          break;
                        }
                        k.cTb().remove("preload_tmpl_test_no_preload_next");
                        o.fQ("MicroMsg.PreloadUtil", "enable preload next webview");
                        break;
                      case 2127382617: 
                        if (!paramContext.equals("noredir")) {
                          break;
                        }
                        k.cTb().putBoolean("preload_tmpl_test_noredir", true);
                        o.fQ("MicroMsg.PreloadUtil", "disable re-direct");
                        break;
                      case 3569038: 
                        if (!paramContext.equals("true")) {
                          break;
                        }
                        k.cTb().putBoolean("preload_webview", true);
                        o.fQ("MicroMsg.PreloadUtil", "use preload webview");
                        break;
                      case 97196323: 
                        if (!paramContext.equals("false")) {
                          break;
                        }
                        k.cTb().putBoolean("preload_webview", false);
                        o.fQ("MicroMsg.PreloadUtil", "not use preload webview");
                        break;
                      case 108389754: 
                        if (!paramContext.equals("redir")) {
                          break;
                        }
                        k.cTb().remove("preload_tmpl_test_noredir");
                        o.fQ("MicroMsg.PreloadUtil", "enable re-direct");
                        break;
                      }
                    }
                    paramContext = paramArrayOfString[2];
                    switch (paramContext.hashCode())
                    {
                    default: 
                      break;
                    case -1354757532: 
                      if (!paramContext.equals("cookie")) {
                        break;
                      }
                      c.bFh("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                      o.fQ("MicroMsg.PreloadUtil", "xweb cookie clear");
                      break;
                    case 3392903: 
                      if (!paramContext.equals("null")) {
                        break;
                      }
                      k.cTb().putBoolean("preload_data_null", true);
                      k.cTb().putBoolean("preload_data", false);
                      o.fQ("MicroMsg.PreloadUtil", "test preload null data");
                      break;
                    case -1289159393: 
                      if (!paramContext.equals("expire")) {
                        break;
                      }
                      k.cTb().remove("preload_data_noexpire");
                      o.fQ("MicroMsg.PreloadUtil", "enable data expire");
                      break;
                    case 3569038: 
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      k.cTb().putBoolean("preload_data_null", false);
                      k.cTb().putBoolean("preload_data", true);
                      o.fQ("MicroMsg.PreloadUtil", "enable preload data");
                      break;
                    case 97196323: 
                      if (!paramContext.equals("false")) {
                        break;
                      }
                      k.cTb().putBoolean("preload_data_null", false);
                      k.cTb().putBoolean("preload_data", false);
                      o.fQ("MicroMsg.PreloadUtil", "disable preload data");
                      break;
                    case 94746189: 
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      b.deH();
                      o.fQ("MicroMsg.PreloadUtil", "clear all cached data");
                      break;
                    case 1170077216: 
                      if (!paramContext.equals("noexpire")) {
                        break;
                      }
                      k.cTb().putBoolean("preload_data_noexpire", true);
                      o.fQ("MicroMsg.PreloadUtil", "disable data expire");
                      break;
                    }
                  } while (!paramContext.equals("clear"));
                  com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b.clear();
                  o.fQ("MicroMsg.PreloadUtil", "clear all tmpl info");
                  break;
                } while (!paramContext.equals("md5off"));
                k.cTb().remove("preload_tmpl_always_verify_md5");
                o.fQ("MicroMsg.PreloadUtil", "disable tmpl md5 verify");
                break;
              } while (!paramContext.equals("check"));
              k.cTb().putBoolean("preload_tmpl_always_check_tmpl_ver", true);
              o.fQ("MicroMsg.PreloadUtil", "enable tmpl always check");
              break;
            } while (!paramContext.equals("md5"));
            k.cTb().putBoolean("preload_tmpl_always_verify_md5", true);
            o.fQ("MicroMsg.PreloadUtil", "enable tmpl md5 verify");
            continue;
            label1424:
            paramContext = k.cTb();
            paramString = Integer.valueOf(paramArrayOfString[2]);
            s.s(paramString, "valueOf(args[2])");
            paramContext.putInt("preload_tmpl_lowerbound", ((Number)paramString).intValue());
            o.fQ("MicroMsg.PreloadUtil", s.X("tmpl lowerbound: ", paramArrayOfString[2]));
            continue;
            label1473:
            if (s.p(paramArrayOfString[2], "sd"))
            {
              k.cTb().putBoolean("preload_save_type", true);
              o.fQ("MicroMsg.PreloadUtil", "save to sdcard dir");
            }
            else
            {
              k.cTb().putBoolean("preload_save_type", false);
              o.fQ("MicroMsg.PreloadUtil", "save to data dir");
            }
          }
        }
      }
    }
    AppMethodBeat.o(6631);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_CHECK_TMPL_VER", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TENCENT_VIEW_INEWS_PREFIX", "TOOL", "TOOLMP", "UNKNOW", "alwaysCheckTmpl", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "viewInewsPrefix", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean dfl()
    {
      AppMethodBeat.i(6622);
      boolean bool = k.cTb().getBoolean("preload_webview", true);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
      }
      AppMethodBeat.o(6622);
      return bool;
    }
    
    public static boolean dfm()
    {
      AppMethodBeat.i(6623);
      boolean bool = k.cTb().getBoolean("preload_data", true);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
      }
      AppMethodBeat.o(6623);
      return bool;
    }
    
    public static boolean dfn()
    {
      AppMethodBeat.i(6624);
      boolean bool = k.cTb().getBoolean("preload_data_null", false);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
      }
      AppMethodBeat.o(6624);
      return bool;
    }
    
    public static boolean dfo()
    {
      AppMethodBeat.i(6625);
      boolean bool = k.cTb().getBoolean("preload_data_noexpire", false);
      AppMethodBeat.o(6625);
      return bool;
    }
    
    public static boolean dfp()
    {
      AppMethodBeat.i(6626);
      boolean bool = k.cTb().getBoolean("preload_save_type", false);
      AppMethodBeat.o(6626);
      return bool;
    }
    
    public static int dfq()
    {
      AppMethodBeat.i(6627);
      int i = k.cTb().getInt("preload_tmpl_lowerbound", -1);
      AppMethodBeat.o(6627);
      return i;
    }
    
    public static boolean dfr()
    {
      AppMethodBeat.i(302972);
      boolean bool = k.cTb().getBoolean("preload_tmpl_always_check_tmpl_ver", false);
      AppMethodBeat.o(302972);
      return bool;
    }
    
    public static boolean dfs()
    {
      AppMethodBeat.i(6628);
      boolean bool = k.cTb().getBoolean("preload_tmpl_test_noredir", false);
      AppMethodBeat.o(6628);
      return bool;
    }
    
    public static boolean dft()
    {
      AppMethodBeat.i(6629);
      boolean bool = k.cTb().getBoolean("preload_tmpl_test_no_preload_next", false);
      AppMethodBeat.o(6629);
      return bool;
    }
    
    public static boolean dfu()
    {
      AppMethodBeat.i(6630);
      boolean bool = k.cTb().getBoolean("preload_tmpl_test_no_red", false);
      AppMethodBeat.o(6630);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */