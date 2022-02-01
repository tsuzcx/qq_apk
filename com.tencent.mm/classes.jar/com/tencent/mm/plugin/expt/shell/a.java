package com.tencent.mm.plugin.expt.shell;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/shell/ExptServiceShell;", "", "()V", "ACTION_DISPATCH", "", "ACTION_RESET", "ExptKey", "", "ExptVal", "KEY_ACTION", "KEY_CONFIG_PATH", "TAG", "exptMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isInExptTest", "", "()Z", "listener", "com/tencent/mm/plugin/expt/shell/ExptServiceShell$listener$1", "Lcom/tencent/mm/plugin/expt/shell/ExptServiceShell$listener$1;", "destroy", "", "dispatchConfig", "intent", "Landroid/content/Intent;", "exec", "resetConfig", "setup", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zNo;
  private static final HashMap<String, String> zNp;
  private static final ExptServiceShell.listener.1 zNq;
  
  static
  {
    AppMethodBeat.i(299465);
    zNo = new a();
    zNp = new HashMap();
    zNq = new ExptServiceShell.listener.1(f.hfK);
    AppMethodBeat.o(299465);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(299451);
    Log.i("MicroMsg.ExptServiceShell", "destroy");
    zNq.dead();
    zNp.clear();
    AppMethodBeat.o(299451);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(299448);
    zNp.clear();
    if (WeChatEnvironment.hasDebugger())
    {
      Log.i("MicroMsg.ExptServiceShell", "setup");
      zNq.alive();
    }
    AppMethodBeat.o(299448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.shell.a
 * JD-Core Version:    0.7.0.1
 */