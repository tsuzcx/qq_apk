package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class h
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a oph;
  
  static
  {
    AppMethodBeat.i(6632);
    oph = new a((byte)0);
    AppMethodBeat.o(6632);
  }
  
  public static final void CA()
  {
    AppMethodBeat.i(6633);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//mpfast" });
    AppMethodBeat.o(6633);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(6631);
    p.h(paramContext, "context");
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    if (p.i("//mpfast", paramArrayOfString[0]))
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
          i.bGK().removeValueForKey("preload_tmpl_test_no_red");
          m.showToast("disable test not in red");
          continue;
          if (paramContext.equals("webview"))
          {
            if (paramArrayOfString.length <= 2)
            {
              i.bGK().putBoolean("preload_webview", true);
              m.showToast("use preload webview");
              continue;
              if (!paramContext.equals("nored")) {
                continue;
              }
              i.bGK().putBoolean("preload_tmpl_test_no_red", true);
              m.showToast("enable test not in red");
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
                    if (!p.i("0", paramArrayOfString[2])) {
                      break label1387;
                    }
                    i.bGK().remove("preload_tmpl_lowerbound");
                    m.showToast("clear tmpl lowerbound");
                    break;
                    if (!paramContext.equals("data")) {
                      break;
                    }
                    if (paramArrayOfString.length <= 2)
                    {
                      i.bGK().putBoolean("preload_data_null", false);
                      i.bGK().putBoolean("preload_data", true);
                      m.showToast("enable preload data");
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
                        i.bGK().putBoolean("tencent_view_inews_prefix", true);
                        m.showToast("test news");
                        break;
                        if (!paramContext.equals("clear")) {
                          break;
                        }
                        i.bGK().clear();
                        m.showToast("clear all commands");
                        break;
                        if (!paramContext.equals("true")) {
                          break;
                        }
                        if (paramArrayOfString.length <= 2)
                        {
                          i.bGK().putBoolean("preload_use", true);
                          i.bGK().putInt("preload_type", 1);
                          m.showToast("tmpl webview");
                          break;
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          i.bGK().putBoolean("preload_use", false);
                          m.showToast("not use tmpl webview");
                          break;
                          if (!paramContext.equals("save")) {
                            break;
                          }
                          if (paramArrayOfString.length > 2) {
                            break label1441;
                          }
                          i.bGK().putBoolean("preload_save_type", false);
                          m.showToast("save to data dir");
                          break;
                        }
                        i.bGK().putBoolean("preload_use", true);
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
                              i.bGK().putInt("preload_type", 1);
                              m.showToast("release can't use local tmpl, use online tmpl");
                              break;
                            } while (!paramContext.equals("server"));
                            i.bGK().putInt("preload_type", 2);
                            m.showToast("test server tmpl");
                            break;
                          } while (!paramContext.equals("online"));
                          i.bGK().putInt("preload_type", 1);
                          m.showToast("online tmpl");
                          break;
                        } while (!paramContext.equals("local"));
                        if ((!j.IS_FLAVOR_RED) && (!j.DEBUG)) {
                          break;
                        }
                        i.bGK().putInt("preload_type", 3);
                        m.showToast("local tmpl");
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
                          i.bGK().putBoolean("preload_tmpl_test_no_preload_next", true);
                          m.showToast("disable preload next webview");
                          break;
                        case 3377907: 
                          if (!paramContext.equals("next")) {
                            break;
                          }
                          i.bGK().remove("preload_tmpl_test_no_preload_next");
                          m.showToast("enable preload next webview");
                          break;
                        case 2127382617: 
                          if (!paramContext.equals("noredir")) {
                            break;
                          }
                          i.bGK().putBoolean("preload_tmpl_test_noredir", true);
                          m.showToast("disable re-direct");
                          break;
                        case 3569038: 
                          if (!paramContext.equals("true")) {
                            break;
                          }
                          i.bGK().putBoolean("preload_webview", true);
                          m.showToast("use preload webview");
                          break;
                        case 97196323: 
                          if (!paramContext.equals("false")) {
                            break;
                          }
                          i.bGK().putBoolean("preload_webview", false);
                          m.showToast("not use preload webview");
                          break;
                        case 108389754: 
                          if (!paramContext.equals("redir")) {
                            break;
                          }
                          i.bGK().remove("preload_tmpl_test_noredir");
                          m.showToast("enable re-direct");
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
                      d.bax("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
                      m.showToast("xweb cookie clear");
                      break;
                    case 3392903: 
                      if (!paramContext.equals("null")) {
                        break;
                      }
                      i.bGK().putBoolean("preload_data_null", true);
                      i.bGK().putBoolean("preload_data", false);
                      m.showToast("test preload null data");
                      break;
                    case -1289159393: 
                      if (!paramContext.equals("expire")) {
                        break;
                      }
                      i.bGK().remove("preload_data_noexpire");
                      m.showToast("enable data expire");
                      break;
                    case 3569038: 
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      i.bGK().putBoolean("preload_data_null", false);
                      i.bGK().putBoolean("preload_data", true);
                      m.showToast("enable preload data");
                      break;
                    case 97196323: 
                      if (!paramContext.equals("false")) {
                        break;
                      }
                      i.bGK().putBoolean("preload_data_null", false);
                      i.bGK().putBoolean("preload_data", false);
                      m.showToast("disable preload data");
                      break;
                    case 94746189: 
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      a.bPR();
                      m.showToast("clear all cached data");
                      break;
                    case 1170077216: 
                      if (!paramContext.equals("noexpire")) {
                        break;
                      }
                      i.bGK().putBoolean("preload_data_noexpire", true);
                      m.showToast("disable data expire");
                      break;
                    }
                  } while (!paramContext.equals("clear"));
                  com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
                  m.showToast("clear all tmpl info");
                  break;
                } while (!paramContext.equals("md5off"));
                i.bGK().remove("preload_tmpl_always_verify_md5");
                m.showToast("disable tmpl md5 verify");
                break;
              } while (!paramContext.equals("check"));
              i.bGK().putBoolean("preload_tmpl_always_check_tmpl_ver", true);
              m.showToast("enable tmpl always check");
              break;
            } while (!paramContext.equals("md5"));
            i.bGK().putBoolean("preload_tmpl_always_verify_md5", true);
            m.showToast("enable tmpl md5 verify");
            continue;
            label1387:
            paramContext = i.bGK();
            paramString = Integer.valueOf(paramArrayOfString[2]);
            p.g(paramString, "Integer.valueOf(args[2])");
            paramContext.putInt("preload_tmpl_lowerbound", paramString.intValue());
            m.showToast("tmpl lowerbound: " + paramArrayOfString[2]);
            continue;
            label1441:
            paramContext = paramArrayOfString[2];
            switch (paramContext.hashCode())
            {
            }
            do
            {
              i.bGK().putBoolean("preload_save_type", false);
              m.showToast("save to data dir");
              break;
            } while (!paramContext.equals("sd"));
            i.bGK().putBoolean("preload_save_type", true);
            m.showToast("save to sdcard dir");
          }
        }
      }
    }
    AppMethodBeat.o(6631);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_CHECK_TMPL_VER", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TENCENT_VIEW_INEWS_PREFIX", "TOOL", "TOOLMP", "UNKNOW", "alwaysCheckTmpl", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "viewInewsPrefix", "plugin-brandservice_release"})
  public static final class a
  {
    public static boolean bQm()
    {
      AppMethodBeat.i(6622);
      boolean bool = i.bGK().getBoolean("preload_webview", true);
      if (!bool) {
        ae.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
      }
      AppMethodBeat.o(6622);
      return bool;
    }
    
    public static boolean bQn()
    {
      AppMethodBeat.i(6623);
      boolean bool = i.bGK().getBoolean("preload_data", true);
      if (!bool) {
        ae.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
      }
      AppMethodBeat.o(6623);
      return bool;
    }
    
    public static boolean bQo()
    {
      AppMethodBeat.i(6624);
      boolean bool = i.bGK().getBoolean("preload_data_null", false);
      if (!bool) {
        ae.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
      }
      AppMethodBeat.o(6624);
      return bool;
    }
    
    public static boolean bQp()
    {
      AppMethodBeat.i(6625);
      boolean bool = i.bGK().getBoolean("preload_data_noexpire", false);
      AppMethodBeat.o(6625);
      return bool;
    }
    
    public static boolean bQq()
    {
      AppMethodBeat.i(6626);
      boolean bool = i.bGK().getBoolean("preload_save_type", false);
      AppMethodBeat.o(6626);
      return bool;
    }
    
    public static int bQr()
    {
      AppMethodBeat.i(6627);
      int i = i.bGK().getInt("preload_tmpl_lowerbound", -1);
      AppMethodBeat.o(6627);
      return i;
    }
    
    public static boolean bQs()
    {
      AppMethodBeat.i(6628);
      boolean bool = i.bGK().getBoolean("preload_tmpl_test_noredir", false);
      AppMethodBeat.o(6628);
      return bool;
    }
    
    public static boolean bQt()
    {
      AppMethodBeat.i(6629);
      boolean bool = i.bGK().getBoolean("preload_tmpl_test_no_preload_next", false);
      AppMethodBeat.o(6629);
      return bool;
    }
    
    public static boolean bQu()
    {
      AppMethodBeat.i(6630);
      boolean bool = i.bGK().getBoolean("preload_tmpl_test_no_red", false);
      AppMethodBeat.o(6630);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.h
 * JD-Core Version:    0.7.0.1
 */