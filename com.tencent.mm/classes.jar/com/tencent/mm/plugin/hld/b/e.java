package com.tencent.mm.plugin.hld.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/IPCOplogImeSetting;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements d<Bundle, Bundle>
{
  public static final a JoK;
  
  static
  {
    AppMethodBeat.i(312078);
    JoK = new a((byte)0);
    AppMethodBeat.o(312078);
  }
  
  private static final void a(e parame, com.tencent.mm.ipcinvoker.f paramf, LinkedList paramLinkedList1, LinkedList paramLinkedList2, ArrayList paramArrayList)
  {
    AppMethodBeat.i(312068);
    s.u(parame, "this$0");
    s.u(paramf, "$callback");
    s.s(paramLinkedList1, "rets");
    parame = ((Iterable)paramLinkedList1).iterator();
    if (parame.hasNext())
    {
      paramLinkedList1 = (Integer)parame.next();
      if (paramLinkedList1 != null) {}
    }
    label56:
    for (boolean bool = false;; bool = true)
    {
      parame = new Bundle();
      parame.putBoolean("success", bool);
      paramf.onCallback(parame);
      Log.i("WxIme.IPCOplogImeSetting", s.X("success:", Boolean.valueOf(bool)));
      AppMethodBeat.o(312068);
      return;
      if (paramLinkedList1.intValue() == 0) {
        break;
      }
      break label56;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/IPCOplogImeSetting$Companion;", "", "()V", "TAG", "", "handleBatchSet", "", "cmdIdList", "", "Lcom/tencent/mm/plugin/hld/model/IMESwitchCmdId;", "callback", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "handleImp", "bundle", "Landroid/os/Bundle;", "handleSet", "cmdId", "time", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static void a(Bundle paramBundle, f paramf)
    {
      AppMethodBeat.i(312088);
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramBundle, e.class, new e.a..ExternalSyntheticLambda0(paramf));
      AppMethodBeat.o(312088);
    }
    
    private static final void a(f paramf, Bundle paramBundle)
    {
      AppMethodBeat.i(312095);
      if (paramf != null) {
        paramf.wP(paramBundle.getBoolean("success"));
      }
      AppMethodBeat.o(312095);
    }
    
    public static void a(List<? extends b> paramList, f paramf)
    {
      boolean bool2 = true;
      AppMethodBeat.i(312069);
      s.u(paramList, "cmdIdList");
      Bundle localBundle = new Bundle();
      ArrayList localArrayList = new ArrayList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localArrayList.add(Integer.valueOf(((b)paramList.next()).value));
      }
      long l = cn.bDx();
      localBundle.putIntegerArrayList("settings", localArrayList);
      localBundle.putLong("time", l);
      if (paramf != null)
      {
        bool1 = true;
        localBundle.putBoolean("sync", bool1);
        paramList = new StringBuilder("result settings: ");
        l locall = l.JyV;
        paramList = paramList.append(l.iB((List)localArrayList)).append(' ').append(l).append(' ');
        if (paramf == null) {
          break label190;
        }
      }
      label190:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Log.i("WxIme.IPCOplogImeSetting", bool1);
        a(localBundle, paramf);
        AppMethodBeat.o(312069);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.e
 * JD-Core Version:    0.7.0.1
 */