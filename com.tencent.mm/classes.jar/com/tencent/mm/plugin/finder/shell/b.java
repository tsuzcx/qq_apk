package com.tencent.mm.plugin.finder.shell;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/shell/FinderShellInit;", "", "()V", "TAG", "", "listener", "com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1;", "shells", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "", "createShell", "cmd", "shell", "setup", "plugin-finder_release"})
public final class b
{
  private static final HashMap<String, kotlin.g.a.b<Intent, x>> AdI;
  private static final a AdJ;
  public static final b AdK;
  
  static
  {
    AppMethodBeat.i(272607);
    AdK = new b();
    AdI = new HashMap();
    AdJ = new a();
    AppMethodBeat.o(272607);
  }
  
  public static void n(String paramString, kotlin.g.a.b<? super Intent, x> paramb)
  {
    AppMethodBeat.i(272605);
    p.k(paramString, "cmd");
    p.k(paramb, "shell");
    Map localMap = (Map)AdI;
    Locale localLocale = Locale.getDefault();
    p.j(localLocale, "Locale.getDefault()");
    paramString = paramString.toLowerCase(localLocale);
    p.j(paramString, "(this as java.lang.String).toLowerCase(locale)");
    localMap.put(paramString, paramb);
    AppMethodBeat.o(272605);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(272606);
    if (WeChatEnvironment.hasDebugger())
    {
      AdJ.alive();
      new a();
    }
    AppMethodBeat.o(272606);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/shell/FinderShellInit$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<vt>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shell.b
 * JD-Core Version:    0.7.0.1
 */