package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/shell/FinderShellInit;", "", "()V", "TAG", "", "listener", "com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1;", "shells", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "", "createShell", "cmd", "shell", "setup", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b FAb;
  private static final HashMap<String, kotlin.g.a.b<Intent, ah>> FAc;
  private static final FinderShellInit.listener.1 FAd;
  
  static
  {
    AppMethodBeat.i(330446);
    FAb = new b();
    FAc = new HashMap();
    FAd = new FinderShellInit.listener.1(f.hfK);
    AppMethodBeat.o(330446);
  }
  
  public static void s(String paramString, kotlin.g.a.b<? super Intent, ah> paramb)
  {
    AppMethodBeat.i(330421);
    s.u(paramString, "cmd");
    s.u(paramb, "shell");
    Map localMap = (Map)FAc;
    Locale localLocale = Locale.getDefault();
    s.s(localLocale, "getDefault()");
    paramString = paramString.toLowerCase(localLocale);
    s.s(paramString, "(this as java.lang.String).toLowerCase(locale)");
    localMap.put(paramString, paramb);
    AppMethodBeat.o(330421);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(330429);
    if (WeChatEnvironment.hasDebugger())
    {
      FAd.alive();
      new a();
    }
    AppMethodBeat.o(330429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shell.b
 * JD-Core Version:    0.7.0.1
 */