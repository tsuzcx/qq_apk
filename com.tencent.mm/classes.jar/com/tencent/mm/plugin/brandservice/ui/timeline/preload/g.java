package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final g.a kbz;
  
  static
  {
    AppMethodBeat.i(14857);
    kbz = new g.a((byte)0);
    AppMethodBeat.o(14857);
  }
  
  public static final void uD()
  {
    AppMethodBeat.i(14858);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new g(), new String[] { "//mpfast" });
    AppMethodBeat.o(14858);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(14856);
    j.q(paramContext, "context");
    j.q(paramArrayOfString, "args");
    j.q(paramString, "username");
    if (j.e("//mpfast", paramArrayOfString[0]))
    {
      if (paramArrayOfString.length < 2)
      {
        AppMethodBeat.o(14856);
        return false;
      }
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(14856);
        return true;
        if (paramContext.equals("red"))
        {
          h.aSs().removeValueForKey("preload_tmpl_test_no_red");
          i.showToast("disable test not in red");
          continue;
          if (paramContext.equals("webview"))
          {
            if (paramArrayOfString.length <= 2)
            {
              h.aSs().putBoolean("preload_webview", true);
              i.showToast("use preload webview");
              continue;
              if (!paramContext.equals("nored")) {
                continue;
              }
              h.aSs().putBoolean("preload_tmpl_test_no_red", true);
              i.showToast("enable test not in red");
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
                    if (!j.e("0", paramArrayOfString[2])) {
                      break label1273;
                    }
                    h.aSs().remove("preload_tmpl_lowerbound");
                    i.showToast("clear tmpl lowerbound");
                    break;
                    if (!paramContext.equals("data")) {
                      break;
                    }
                    if (paramArrayOfString.length <= 2)
                    {
                      h.aSs().putBoolean("preload_data_null", false);
                      h.aSs().putBoolean("preload_data", true);
                      i.showToast("enable preload data");
                      break;
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      h.aSs().clear();
                      i.showToast("clear all commands");
                      break;
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      if (paramArrayOfString.length <= 2)
                      {
                        h.aSs().putBoolean("preload_use", true);
                        h.aSs().putInt("preload_type", 1);
                        i.showToast("tmpl webview");
                        break;
                        if (!paramContext.equals("false")) {
                          break;
                        }
                        h.aSs().putBoolean("preload_use", false);
                        i.showToast("not use tmpl webview");
                        break;
                        if (!paramContext.equals("save")) {
                          break;
                        }
                        if (paramArrayOfString.length > 2) {
                          break label1327;
                        }
                        h.aSs().putBoolean("preload_save_type", false);
                        i.showToast("save to data dir");
                        break;
                      }
                      h.aSs().putBoolean("preload_use", true);
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
                            h.aSs().putInt("preload_type", 1);
                            i.showToast("release can't use local tmpl, use online tmpl");
                            break;
                          } while (!paramContext.equals("server"));
                          h.aSs().putInt("preload_type", 2);
                          i.showToast("test server tmpl");
                          break;
                        } while (!paramContext.equals("online"));
                        h.aSs().putInt("preload_type", 1);
                        i.showToast("online tmpl");
                        break;
                      } while (!paramContext.equals("local"));
                      if ((!f.IS_FLAVOR_RED) && (!f.DEBUG)) {
                        break;
                      }
                      h.aSs().putInt("preload_type", 3);
                      i.showToast("local tmpl");
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
                        h.aSs().putBoolean("preload_tmpl_test_no_preload_next", true);
                        i.showToast("disable preload next webview");
                        break;
                      case 3377907: 
                        if (!paramContext.equals("next")) {
                          break;
                        }
                        h.aSs().remove("preload_tmpl_test_no_preload_next");
                        i.showToast("enable preload next webview");
                        break;
                      case 2127382617: 
                        if (!paramContext.equals("noredir")) {
                          break;
                        }
                        h.aSs().putBoolean("preload_tmpl_test_noredir", true);
                        i.showToast("disable re-direct");
                        break;
                      case 3569038: 
                        if (!paramContext.equals("true")) {
                          break;
                        }
                        h.aSs().putBoolean("preload_webview", true);
                        i.showToast("use preload webview");
                        break;
                      case 97196323: 
                        if (!paramContext.equals("false")) {
                          break;
                        }
                        h.aSs().putBoolean("preload_webview", false);
                        i.showToast("not use preload webview");
                        break;
                      case 108389754: 
                        if (!paramContext.equals("redir")) {
                          break;
                        }
                        h.aSs().remove("preload_tmpl_test_noredir");
                        i.showToast("enable re-direct");
                        break;
                      }
                    }
                    paramContext = paramArrayOfString[2];
                    switch (paramContext.hashCode())
                    {
                    default: 
                      break;
                    case -1289159393: 
                      if (!paramContext.equals("expire")) {
                        break;
                      }
                      h.aSs().remove("preload_data_noexpire");
                      i.showToast("enable data expire");
                      break;
                    case 3392903: 
                      if (!paramContext.equals("null")) {
                        break;
                      }
                      h.aSs().putBoolean("preload_data_null", true);
                      h.aSs().putBoolean("preload_data", false);
                      i.showToast("test preload null data");
                      break;
                    case 3569038: 
                      if (!paramContext.equals("true")) {
                        break;
                      }
                      h.aSs().putBoolean("preload_data_null", false);
                      h.aSs().putBoolean("preload_data", true);
                      i.showToast("enable preload data");
                      break;
                    case 97196323: 
                      if (!paramContext.equals("false")) {
                        break;
                      }
                      h.aSs().putBoolean("preload_data_null", false);
                      h.aSs().putBoolean("preload_data", false);
                      i.showToast("disable preload data");
                      break;
                    case 94746189: 
                      if (!paramContext.equals("clear")) {
                        break;
                      }
                      a.aXc();
                      i.showToast("clear all cached data");
                      break;
                    case 1170077216: 
                      if (!paramContext.equals("noexpire")) {
                        break;
                      }
                      h.aSs().putBoolean("preload_data_noexpire", true);
                      i.showToast("disable data expire");
                      break;
                    }
                  } while (!paramContext.equals("clear"));
                  com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.clear();
                  i.showToast("clear all tmpl info");
                  break;
                } while (!paramContext.equals("md5off"));
                h.aSs().remove("preload_tmpl_always_verify_md5");
                i.showToast("disable tmpl md5 verify");
                break;
              } while (!paramContext.equals("check"));
              h.aSs().putBoolean("preload_tmpl_always_check_tmpl_ver", true);
              i.showToast("enable tmpl always check");
              break;
            } while (!paramContext.equals("md5"));
            h.aSs().putBoolean("preload_tmpl_always_verify_md5", true);
            i.showToast("enable tmpl md5 verify");
            continue;
            label1273:
            paramContext = h.aSs();
            paramString = Integer.valueOf(paramArrayOfString[2]);
            j.p(paramString, "Integer.valueOf(args[2])");
            paramContext.putInt("preload_tmpl_lowerbound", paramString.intValue());
            i.showToast("tmpl lowerbound: " + paramArrayOfString[2]);
            continue;
            label1327:
            paramContext = paramArrayOfString[2];
            switch (paramContext.hashCode())
            {
            }
            do
            {
              h.aSs().putBoolean("preload_save_type", false);
              i.showToast("save to data dir");
              break;
            } while (!paramContext.equals("sd"));
            h.aSs().putBoolean("preload_save_type", true);
            i.showToast("save to sdcard dir");
          }
        }
      }
    }
    AppMethodBeat.o(14856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.g
 * JD-Core Version:    0.7.0.1
 */