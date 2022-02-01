package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/shell/FinderShellInit;", "", "()V", "TAG", "", "listener", "com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1;", "shells", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "", "createShell", "cmd", "shell", "setup", "plugin-finder_release"})
public final class b
{
  private static final HashMap<String, kotlin.g.a.b<Intent, x>> vwh;
  private static final a vwi;
  public static final b vwj;
  
  static
  {
    AppMethodBeat.i(251496);
    vwj = new b();
    vwh = new HashMap();
    vwi = new a();
    AppMethodBeat.o(251496);
  }
  
  public static void m(String paramString, kotlin.g.a.b<? super Intent, x> paramb)
  {
    AppMethodBeat.i(251494);
    p.h(paramString, "cmd");
    p.h(paramb, "shell");
    Map localMap = (Map)vwh;
    Locale localLocale = Locale.getDefault();
    p.g(localLocale, "Locale.getDefault()");
    paramString = paramString.toLowerCase(localLocale);
    p.g(paramString, "(this as java.lang.String).toLowerCase(locale)");
    localMap.put(paramString, paramb);
    AppMethodBeat.o(251494);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(251495);
    if (WeChatEnvironment.hasDebugger())
    {
      vwi.alive();
      new a();
    }
    AppMethodBeat.o(251495);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<uq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shell.b
 * JD-Core Version:    0.7.0.1
 */