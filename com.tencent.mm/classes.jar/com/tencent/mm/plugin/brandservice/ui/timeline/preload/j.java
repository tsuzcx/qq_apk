package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class j
  implements a
{
  public static final a pCC;
  
  static
  {
    AppMethodBeat.i(6632);
    pCC = new a((byte)0);
    AppMethodBeat.o(6632);
  }
  
  public static final void LW()
  {
    AppMethodBeat.i(6633);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new j(), new String[] { "//mpfast" });
    AppMethodBeat.o(6633);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(6631);
    p.h(paramContext, "context");
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    if (p.j("//mpfast", paramArrayOfString[0]))
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
          k.cdi().removeValueForKey("preload_tmpl_test_no_red");
          o.showToast("disable test not in red");
          continue;
          if (paramContext.equals("webview"))
          {
            if (paramArrayOfString.length <= 2)
            {
              k.cdi().putBoolean("preload_webview", true);
              o.showToast("use preload webview");
              continue;
              if (!paramContext.equals("nored")) {
                continue;
              }
              k.cdi().putBoolean("preload_tmpl_test_no_red", true);
              o.showToast("enable test not in red");
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
                    if (!p.j("0", paramArrayOfString[2])) {
                      break label1387;
                    }
                    k.cdi().remove("preload_tmpl_lowerbound");
                    o.showToast("clear tmpl lowerbound");
                    break;
                    if (!paramContext.equals("data")) {
                      break;
                    }
                    if (paramArrayOfString.length <= 2)
                    {
                      k.cdi().putBoolean("preload_data_null", false);
                      k.cdi().putBoolean("preload_data", true);
                      o.showToast("enable preload data");
                      break;
                      if ((!paramContext.equals("test")) || (paramArrayOfString.length <= 2)) {
                        break;
                      }
                      paramContext = paramArrayOfString[2];
                      switch (paramContext.hashCode())
                      {
                      default: 
                        break;
                      case 3377875: 
                        if (!paramContext.equals("news")) {
                          break;
                        }
                        k.cdi().putBoolean("tencent_view_inews_prefix", true);
                        o.showToast("test news");
                        break;
                        if (!paramContext.equals("clear")) {
                          break;
                        }
                        k.cdi().clear();
                        o.showToast("clear all commands");
                        break;
                        if (!paramContext.equals("true")) {
                          break;
                        }
                        if (paramArrayOfString.length <= 2)
                        {
                          k.cdi().putBoolean("preload_use", true);
                          k.cdi().putInt("preload_type", 1);
                          o.showToast("tmpl webview");
                          break;
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          k.cdi().putBoolean("preload_use", false);
                          o.showToast("not use tmpl webview");
                          break;
                          if (!paramContext.equals("save")) {
                            break;
                          }
                          if (paramArrayOfString.length > 2) {
                            break label1441;
                          }
                          k.cdi().putBoolean("preload_save_type", false);
                          o.showToast("save to data dir");
                          break;
                        }
                        k.cdi().putBoolean("preload_use", true);
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
                              k.cdi().putInt("preload_type", 1);
                              o.showToast("release can't use local tmpl, use online tmpl");
                              break;
                            } while (!paramContext.equals("server"));
                            k.cdi().putInt("preload_type", 2);
                            o.showToast("test server tmpl");
                            break;
                          } while (!paramContext.equals("online"));
                          k.cdi().putInt("preload_type", 1);
                          o.showToast("online tmpl");
                          break;
                        } while (!paramContext.equals("local"));
                        if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
                          break;
                        }
                        k.cdi().putInt("preload_type", 3);
                        o.showToast("local tmpl");
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
                          k.cdi().putBoolean("preload_tmpl_test_no_preload_next", true);
                          o.showToast("disable preload next webview");
                          break;
                        case 3377907: 
                          if (!paramContext.equals("next")) {
                            break;
                          }
                          k.cdi().remove("preload_tmpl_test_no_preload_next");
                          o.showToast("enable preload next webview");
                          break;
                        case 2127382617: 
                          if (!paramContext.equals("noredir")) {
                            break;
                          }
                          k.cdi().putBoolean("preload_tmpl_test_noredir", true);
                          o.showToast("disable re-direct");
                          break;
                        case 3569038: 
                          if (!paramContext.equals("true")) {
                            break;
                          }
                          k.cdi().putBoolean("preload_webview", true);
                          o.showToast("use preload webview");
                          break;
                        case 97196323: 
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          k.cdi().putBoolean("preload_webview", false);
                          o.showToast("not use preload webview");
                          break;
                        case 108389754: 
                          if (!paramContext.equals("redir")) {
                            break;
                          }
                          k.cdi().remove("preload_tmpl_test_noredir");
                          o.showToast("enable re-direct");
                        }
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
                      d.bpG("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                      o.showToast("xweb cookie clear");
                      break;
                    case 3392903: 
                      if (!paramContext.equals("null")) {
                        break;
                      }
                      k.cdi().putBoolean("preload_data_null", true);
                      k.cdi().putBoolean("preload_data", false);
                      o.showToast("test preload null data");
                      break;
                    case -1289159393: 
                      if (!paramContext.equals("expire")) {
                        break;
                      }
                      k.cdi().remove("preload_data_noexpire");
                      o.showToast("enable data expire");
                      break;
                    case 3569038: 
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      k.cdi().putBoolean("preload_data_null", false);
                      k.cdi().putBoolean("preload_data", true);
                      o.showToast("enable preload data");
                      break;
                    case 97196323: 
                      if (!paramContext.equals("false")) {
                        break;
                      }
                      k.cdi().putBoolean("preload_data_null", false);
                      k.cdi().putBoolean("preload_data", false);
                      o.showToast("disable preload data");
                      break;
                    case 94746189: 
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      b.cnv();
                      o.showToast("clear all cached data");
                      break;
                    case 1170077216: 
                      if (!paramContext.equals("noexpire")) {
                        break;
                      }
                      k.cdi().putBoolean("preload_data_noexpire", true);
                      o.showToast("disable data expire");
                      break;
                    }
                  } while (!paramContext.equals("clear"));
                  com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
                  o.showToast("clear all tmpl info");
                  break;
                } while (!paramContext.equals("md5off"));
                k.cdi().remove("preload_tmpl_always_verify_md5");
                o.showToast("disable tmpl md5 verify");
                break;
              } while (!paramContext.equals("check"));
              k.cdi().putBoolean("preload_tmpl_always_check_tmpl_ver", true);
              o.showToast("enable tmpl always check");
              break;
            } while (!paramContext.equals("md5"));
            k.cdi().putBoolean("preload_tmpl_always_verify_md5", true);
            o.showToast("enable tmpl md5 verify");
            continue;
            label1387:
            paramContext = k.cdi();
            paramString = Integer.valueOf(paramArrayOfString[2]);
            p.g(paramString, "Integer.valueOf(args[2])");
            paramContext.putInt("preload_tmpl_lowerbound", paramString.intValue());
            o.showToast("tmpl lowerbound: " + paramArrayOfString[2]);
            continue;
            label1441:
            paramContext = paramArrayOfString[2];
            switch (paramContext.hashCode())
            {
            }
            do
            {
              k.cdi().putBoolean("preload_save_type", false);
              o.showToast("save to data dir");
              break;
            } while (!paramContext.equals("sd"));
            k.cdi().putBoolean("preload_save_type", true);
            o.showToast("save to sdcard dir");
          }
        }
      }
    }
    AppMethodBeat.o(6631);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_CHECK_TMPL_VER", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TENCENT_VIEW_INEWS_PREFIX", "TOOL", "TOOLMP", "UNKNOW", "alwaysCheckTmpl", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "viewInewsPrefix", "plugin-brandservice_release"})
  public static final class a
  {
    public static boolean cnU()
    {
      AppMethodBeat.i(6622);
      boolean bool = k.cdi().getBoolean("preload_webview", true);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
      }
      AppMethodBeat.o(6622);
      return bool;
    }
    
    public static boolean cnV()
    {
      AppMethodBeat.i(6623);
      boolean bool = k.cdi().getBoolean("preload_data", true);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
      }
      AppMethodBeat.o(6623);
      return bool;
    }
    
    public static boolean cnW()
    {
      AppMethodBeat.i(6624);
      boolean bool = k.cdi().getBoolean("preload_data_null", false);
      if (!bool) {
        Log.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
      }
      AppMethodBeat.o(6624);
      return bool;
    }
    
    public static boolean cnX()
    {
      AppMethodBeat.i(6625);
      boolean bool = k.cdi().getBoolean("preload_data_noexpire", false);
      AppMethodBeat.o(6625);
      return bool;
    }
    
    public static boolean cnY()
    {
      AppMethodBeat.i(6626);
      boolean bool = k.cdi().getBoolean("preload_save_type", false);
      AppMethodBeat.o(6626);
      return bool;
    }
    
    public static int cnZ()
    {
      AppMethodBeat.i(6627);
      int i = k.cdi().getInt("preload_tmpl_lowerbound", -1);
      AppMethodBeat.o(6627);
      return i;
    }
    
    public static boolean coa()
    {
      AppMethodBeat.i(6628);
      boolean bool = k.cdi().getBoolean("preload_tmpl_test_noredir", false);
      AppMethodBeat.o(6628);
      return bool;
    }
    
    public static boolean cob()
    {
      AppMethodBeat.i(6629);
      boolean bool = k.cdi().getBoolean("preload_tmpl_test_no_preload_next", false);
      AppMethodBeat.o(6629);
      return bool;
    }
    
    public static boolean coc()
    {
      AppMethodBeat.i(6630);
      boolean bool = k.cdi().getBoolean("preload_tmpl_test_no_red", false);
      AppMethodBeat.o(6630);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.j
 * JD-Core Version:    0.7.0.1
 */