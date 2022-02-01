package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a ndS;
  
  static
  {
    AppMethodBeat.i(6632);
    ndS = new a((byte)0);
    AppMethodBeat.o(6632);
  }
  
  public static final void Bu()
  {
    AppMethodBeat.i(6633);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new g(), new String[] { "//mpfast" });
    AppMethodBeat.o(6633);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(6631);
    k.h(paramContext, "context");
    k.h(paramArrayOfString, "args");
    k.h(paramString, "username");
    if (k.g("//mpfast", paramArrayOfString[0]))
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
          h.buO().removeValueForKey("preload_tmpl_test_no_red");
          l.showToast("disable test not in red");
          continue;
          if (paramContext.equals("webview"))
          {
            if (paramArrayOfString.length <= 2)
            {
              h.buO().putBoolean("preload_webview", true);
              l.showToast("use preload webview");
              continue;
              if (!paramContext.equals("nored")) {
                continue;
              }
              h.buO().putBoolean("preload_tmpl_test_no_red", true);
              l.showToast("enable test not in red");
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
                    if (!k.g("0", paramArrayOfString[2])) {
                      break label1387;
                    }
                    h.buO().remove("preload_tmpl_lowerbound");
                    l.showToast("clear tmpl lowerbound");
                    break;
                    if (!paramContext.equals("data")) {
                      break;
                    }
                    if (paramArrayOfString.length <= 2)
                    {
                      h.buO().putBoolean("preload_data_null", false);
                      h.buO().putBoolean("preload_data", true);
                      l.showToast("enable preload data");
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
                        h.buO().putBoolean("tencent_view_inews_prefix", true);
                        l.showToast("test news");
                        break;
                        if (!paramContext.equals("clear")) {
                          break;
                        }
                        h.buO().clear();
                        l.showToast("clear all commands");
                        break;
                        if (!paramContext.equals("true")) {
                          break;
                        }
                        if (paramArrayOfString.length <= 2)
                        {
                          h.buO().putBoolean("preload_use", true);
                          h.buO().putInt("preload_type", 1);
                          l.showToast("tmpl webview");
                          break;
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          h.buO().putBoolean("preload_use", false);
                          l.showToast("not use tmpl webview");
                          break;
                          if (!paramContext.equals("save")) {
                            break;
                          }
                          if (paramArrayOfString.length > 2) {
                            break label1441;
                          }
                          h.buO().putBoolean("preload_save_type", false);
                          l.showToast("save to data dir");
                          break;
                        }
                        h.buO().putBoolean("preload_use", true);
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
                              h.buO().putInt("preload_type", 1);
                              l.showToast("release can't use local tmpl, use online tmpl");
                              break;
                            } while (!paramContext.equals("server"));
                            h.buO().putInt("preload_type", 2);
                            l.showToast("test server tmpl");
                            break;
                          } while (!paramContext.equals("online"));
                          h.buO().putInt("preload_type", 1);
                          l.showToast("online tmpl");
                          break;
                        } while (!paramContext.equals("local"));
                        if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
                          break;
                        }
                        h.buO().putInt("preload_type", 3);
                        l.showToast("local tmpl");
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
                          h.buO().putBoolean("preload_tmpl_test_no_preload_next", true);
                          l.showToast("disable preload next webview");
                          break;
                        case 3377907: 
                          if (!paramContext.equals("next")) {
                            break;
                          }
                          h.buO().remove("preload_tmpl_test_no_preload_next");
                          l.showToast("enable preload next webview");
                          break;
                        case 2127382617: 
                          if (!paramContext.equals("noredir")) {
                            break;
                          }
                          h.buO().putBoolean("preload_tmpl_test_noredir", true);
                          l.showToast("disable re-direct");
                          break;
                        case 3569038: 
                          if (!paramContext.equals("true")) {
                            break;
                          }
                          h.buO().putBoolean("preload_webview", true);
                          l.showToast("use preload webview");
                          break;
                        case 97196323: 
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          h.buO().putBoolean("preload_webview", false);
                          l.showToast("not use preload webview");
                          break;
                        case 108389754: 
                          if (!paramContext.equals("redir")) {
                            break;
                          }
                          h.buO().remove("preload_tmpl_test_noredir");
                          l.showToast("enable re-direct");
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
                      d.aNr("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                      l.showToast("xweb cookie clear");
                      break;
                    case 3392903: 
                      if (!paramContext.equals("null")) {
                        break;
                      }
                      h.buO().putBoolean("preload_data_null", true);
                      h.buO().putBoolean("preload_data", false);
                      l.showToast("test preload null data");
                      break;
                    case -1289159393: 
                      if (!paramContext.equals("expire")) {
                        break;
                      }
                      h.buO().remove("preload_data_noexpire");
                      l.showToast("enable data expire");
                      break;
                    case 3569038: 
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      h.buO().putBoolean("preload_data_null", false);
                      h.buO().putBoolean("preload_data", true);
                      l.showToast("enable preload data");
                      break;
                    case 97196323: 
                      if (!paramContext.equals("false")) {
                        break;
                      }
                      h.buO().putBoolean("preload_data_null", false);
                      h.buO().putBoolean("preload_data", false);
                      l.showToast("disable preload data");
                      break;
                    case 94746189: 
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      a.bDf();
                      l.showToast("clear all cached data");
                      break;
                    case 1170077216: 
                      if (!paramContext.equals("noexpire")) {
                        break;
                      }
                      h.buO().putBoolean("preload_data_noexpire", true);
                      l.showToast("disable data expire");
                      break;
                    }
                  } while (!paramContext.equals("clear"));
                  com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
                  l.showToast("clear all tmpl info");
                  break;
                } while (!paramContext.equals("md5off"));
                h.buO().remove("preload_tmpl_always_verify_md5");
                l.showToast("disable tmpl md5 verify");
                break;
              } while (!paramContext.equals("check"));
              h.buO().putBoolean("preload_tmpl_always_check_tmpl_ver", true);
              l.showToast("enable tmpl always check");
              break;
            } while (!paramContext.equals("md5"));
            h.buO().putBoolean("preload_tmpl_always_verify_md5", true);
            l.showToast("enable tmpl md5 verify");
            continue;
            label1387:
            paramContext = h.buO();
            paramString = Integer.valueOf(paramArrayOfString[2]);
            k.g(paramString, "Integer.valueOf(args[2])");
            paramContext.putInt("preload_tmpl_lowerbound", paramString.intValue());
            l.showToast("tmpl lowerbound: " + paramArrayOfString[2]);
            continue;
            label1441:
            paramContext = paramArrayOfString[2];
            switch (paramContext.hashCode())
            {
            }
            do
            {
              h.buO().putBoolean("preload_save_type", false);
              l.showToast("save to data dir");
              break;
            } while (!paramContext.equals("sd"));
            h.buO().putBoolean("preload_save_type", true);
            l.showToast("save to sdcard dir");
          }
        }
      }
    }
    AppMethodBeat.o(6631);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_CHECK_TMPL_VER", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TENCENT_VIEW_INEWS_PREFIX", "TOOL", "TOOLMP", "UNKNOW", "alwaysCheckTmpl", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "viewInewsPrefix", "plugin-brandservice_release"})
  public static final class a
  {
    public static boolean bDA()
    {
      AppMethodBeat.i(6622);
      boolean bool = h.buO().getBoolean("preload_webview", true);
      if (!bool) {
        ad.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
      }
      AppMethodBeat.o(6622);
      return bool;
    }
    
    public static boolean bDB()
    {
      AppMethodBeat.i(6623);
      boolean bool = h.buO().getBoolean("preload_data", true);
      if (!bool) {
        ad.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
      }
      AppMethodBeat.o(6623);
      return bool;
    }
    
    public static boolean bDC()
    {
      AppMethodBeat.i(6624);
      boolean bool = h.buO().getBoolean("preload_data_null", false);
      if (!bool) {
        ad.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
      }
      AppMethodBeat.o(6624);
      return bool;
    }
    
    public static boolean bDD()
    {
      AppMethodBeat.i(6625);
      boolean bool = h.buO().getBoolean("preload_data_noexpire", false);
      AppMethodBeat.o(6625);
      return bool;
    }
    
    public static boolean bDE()
    {
      AppMethodBeat.i(6626);
      boolean bool = h.buO().getBoolean("preload_save_type", false);
      AppMethodBeat.o(6626);
      return bool;
    }
    
    public static int bDF()
    {
      AppMethodBeat.i(6627);
      int i = h.buO().getInt("preload_tmpl_lowerbound", -1);
      AppMethodBeat.o(6627);
      return i;
    }
    
    public static boolean bDG()
    {
      AppMethodBeat.i(6628);
      boolean bool = h.buO().getBoolean("preload_tmpl_test_noredir", false);
      AppMethodBeat.o(6628);
      return bool;
    }
    
    public static boolean bDH()
    {
      AppMethodBeat.i(6629);
      boolean bool = h.buO().getBoolean("preload_tmpl_test_no_preload_next", false);
      AppMethodBeat.o(6629);
      return bool;
    }
    
    public static boolean bDI()
    {
      AppMethodBeat.i(6630);
      boolean bool = h.buO().getBoolean("preload_tmpl_test_no_red", false);
      AppMethodBeat.o(6630);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.g
 * JD-Core Version:    0.7.0.1
 */