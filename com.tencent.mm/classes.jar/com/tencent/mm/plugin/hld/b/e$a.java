package com.tencent.mm.plugin.hld.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.hld.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/IPCOplogImeSetting$Companion;", "", "()V", "TAG", "", "handleBatchSet", "", "cmdIdList", "", "Lcom/tencent/mm/plugin/hld/model/IMESwitchCmdId;", "callback", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "handleImp", "bundle", "Landroid/os/Bundle;", "handleSet", "cmdId", "time", "", "plugin-hld_release"})
public final class e$a
{
  private static void a(Bundle paramBundle, f paramf)
  {
    AppMethodBeat.i(209750);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBundle, e.class, (com.tencent.mm.ipcinvoker.f)new a(paramf));
    AppMethodBeat.o(209750);
  }
  
  public static void a(List<? extends b> paramList, f paramf)
  {
    boolean bool2 = true;
    AppMethodBeat.i(209746);
    p.k(paramList, "cmdIdList");
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((b)paramList.next()).value));
    }
    long l = cm.bfG();
    localBundle.putIntegerArrayList("settings", localArrayList);
    localBundle.putLong("time", l);
    if (paramf != null)
    {
      bool1 = true;
      localBundle.putBoolean("sync", bool1);
      paramList = new StringBuilder("result settings: ");
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      paramList = paramList.append(com.tencent.mm.plugin.hld.f.l.fE((List)localArrayList)).append(' ').append(l).append(' ');
      if (paramf == null) {
        break label190;
      }
    }
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("WxIme.IPCOplogImeSetting", bool1);
      a(localBundle, paramf);
      AppMethodBeat.o(209746);
      return;
      bool1 = false;
      break;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    a(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.e.a
 * JD-Core Version:    0.7.0.1
 */