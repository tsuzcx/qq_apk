package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handler", "com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1;", "add", "", "handOff", "apply", "commit", "del", "process", "message", "processAddRequest", "items", "", "processDelRequest", "Companion", "TryEnterFloatBallInternalTask", "plugin-handoff_release"})
public final class d
{
  private static final String[] Dsa;
  public static final d.a Dsb;
  final Map<String, HandOff> DrW;
  final Map<String, HandOff> DrX;
  final Map<String, Boolean> DrY;
  final b DrZ;
  
  static
  {
    AppMethodBeat.i(248423);
    Dsb = new d.a((byte)0);
    Dsa = new String[] { ToolsProcessIPCService.PROCESS_NAME, ToolsMpProcessIPCService.PROCESS_NAME };
    AppMethodBeat.o(248423);
  }
  
  public d(final Looper paramLooper)
  {
    AppMethodBeat.i(248420);
    this.DrW = ((Map)new LinkedHashMap());
    this.DrX = ((Map)new LinkedHashMap());
    this.DrY = ((Map)new LinkedHashMap());
    this.DrZ = new b(this, paramLooper, paramLooper);
    AppMethodBeat.o(248420);
  }
  
  private static void i(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(248412);
    Object localObject;
    try
    {
      paramCollection = ((Iterable)paramCollection).iterator();
      while (paramCollection.hasNext())
      {
        localObject = (HandOff)paramCollection.next();
        localObject = ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLm(((HandOff)localObject).getId());
        if (localObject != null) {
          if (ar.isMultiTaskMode())
          {
            localObject = ((com.tencent.mm.plugin.multitask.d)h.ag(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoById(((HandOff)localObject).getKey());
            if (localObject != null) {
              ((com.tencent.mm.plugin.multitask.d)h.ag(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject).field_id);
            }
          }
          else
          {
            switch (((HandOff)localObject).getDataType())
            {
            }
          }
        }
      }
    }
    catch (Exception paramCollection)
    {
      Log.d("HandOff.RequestProcessor", "delete handoff fail: " + paramCollection.getLocalizedMessage());
      AppMethodBeat.o(248412);
      return;
    }
    for (;;)
    {
      localObject = ((b)h.ae(b.class)).h(new BallInfo(i, ((HandOff)localObject).getKey()));
      if (localObject == null) {
        break;
      }
      ((b)h.ae(b.class)).l((BallInfo)localObject);
      break;
      int i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      AppMethodBeat.o(248412);
      return;
      i = 0;
    }
  }
  
  private static void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(248416);
    Object localObject;
    int i;
    o localo;
    for (;;)
    {
      try
      {
        paramCollection = ((Iterable)paramCollection).iterator();
        if (!paramCollection.hasNext()) {
          break label211;
        }
        localObject = (HandOff)paramCollection.next();
        i = a.eBN();
        if (i <= 0)
        {
          Log.i("HandOff.RequestProcessor", "cannot add float ball, availableCount = ".concat(String.valueOf(i)));
          FloatBallProxyUI.a(3, (FloatBallProxyUI.a)c.Dse);
          continue;
        }
        if (!ar.isMultiTaskMode()) {
          break;
        }
      }
      catch (Exception paramCollection)
      {
        Log.d("HandOff.RequestProcessor", "add handoff fail: " + paramCollection.getLocalizedMessage());
        AppMethodBeat.o(248416);
        return;
      }
      localo = ((HandOff)localObject).createMultiTaskInfo();
      if (localo != null) {
        switch (((HandOff)localObject).getDataType())
        {
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.multitask.d)h.ag(com.tencent.mm.plugin.multitask.d.class)).addTaskInfo(((HandOff)localObject).getKey(), i, (dar)localo.Mx, (byte[])localo.My, null);
      break;
      localObject = ((HandOff)localObject).createBallInfo();
      if (localObject == null) {
        break;
      }
      ((b)h.ae(b.class)).j((BallInfo)localObject);
      break;
      label211:
      AppMethodBeat.o(248416);
      return;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper1, Looper paramLooper2)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(248398);
      p.k(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(248398);
        return;
        Log.d("HandOff.RequestProcessor", "handle commit message");
        d.a(this.Dsc);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "proxyMode", "", "result", "onCallback"})
  static final class c
    implements FloatBallProxyUI.a
  {
    public static final c Dse;
    
    static
    {
      AppMethodBeat.i(248046);
      Dse = new c();
      AppMethodBeat.o(248046);
    }
    
    public final void ft(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(248043);
      Log.i("MicroMsg.FloatBallService", "addBallInfo by handoff, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(248043);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.d
 * JD-Core Version:    0.7.0.1
 */