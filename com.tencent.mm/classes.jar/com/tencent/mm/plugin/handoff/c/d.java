package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handler", "com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1;", "add", "", "handOff", "apply", "commit", "del", "process", "message", "processAddRequest", "items", "", "processDelRequest", "Companion", "TryEnterFloatBallInternalTask", "plugin-handoff_release"})
public final class d
{
  private static final String[] yhY;
  public static final d.a yhZ;
  final Map<String, HandOff> yhU;
  final Map<String, HandOff> yhV;
  final Map<String, Boolean> yhW;
  final b yhX;
  
  static
  {
    AppMethodBeat.i(199164);
    yhZ = new d.a((byte)0);
    yhY = new String[] { ToolsProcessIPCService.dkO, ToolsMpProcessIPCService.dkO };
    AppMethodBeat.o(199164);
  }
  
  public d(final Looper paramLooper)
  {
    AppMethodBeat.i(199163);
    this.yhU = ((Map)new LinkedHashMap());
    this.yhV = ((Map)new LinkedHashMap());
    this.yhW = ((Map)new LinkedHashMap());
    this.yhX = new b(this, paramLooper, paramLooper);
    AppMethodBeat.o(199163);
  }
  
  private static void j(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(199161);
    Object localObject;
    try
    {
      paramCollection = ((Iterable)paramCollection).iterator();
      while (paramCollection.hasNext())
      {
        localObject = (HandOff)paramCollection.next();
        localObject = ((com.tencent.mm.plugin.handoff.a.a)g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBy(((HandOff)localObject).getId());
        if (localObject != null) {
          if (ao.isMultiTaskMode())
          {
            localObject = ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoById(((HandOff)localObject).getKey());
            if (localObject != null) {
              ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject).field_id);
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
      AppMethodBeat.o(199161);
      return;
    }
    for (;;)
    {
      localObject = ((b)g.af(b.class)).h(new BallInfo(i, ((HandOff)localObject).getKey()));
      if (localObject == null) {
        break;
      }
      ((b)g.af(b.class)).l((BallInfo)localObject);
      break;
      int i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      AppMethodBeat.o(199161);
      return;
      i = 0;
    }
  }
  
  private static void k(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(199162);
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
        i = a.dYp();
        if (i <= 0)
        {
          Log.i("HandOff.RequestProcessor", "cannot add float ball, availableCount = ".concat(String.valueOf(i)));
          FloatBallProxyUI.a(3, (FloatBallProxyUI.a)c.yic);
          continue;
        }
        if (!ao.isMultiTaskMode()) {
          break;
        }
      }
      catch (Exception paramCollection)
      {
        Log.d("HandOff.RequestProcessor", "add handoff fail: " + paramCollection.getLocalizedMessage());
        AppMethodBeat.o(199162);
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
      ((com.tencent.mm.plugin.multitask.d)g.ah(com.tencent.mm.plugin.multitask.d.class)).addTaskInfo(((HandOff)localObject).getKey(), i, (cru)localo.first, (byte[])localo.second, null);
      break;
      localObject = ((HandOff)localObject).createBallInfo();
      if (localObject == null) {
        break;
      }
      ((b)g.af(b.class)).j((BallInfo)localObject);
      break;
      label211:
      AppMethodBeat.o(199162);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  public static final class b
    extends MMHandler
  {
    b(Looper paramLooper1, Looper paramLooper2)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(199158);
      p.h(paramMessage, "msg");
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(199158);
        return;
        Log.d("HandOff.RequestProcessor", "handle commit message");
        d.a(this.yia);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "proxyMode", "", "result", "onCallback"})
  static final class c
    implements FloatBallProxyUI.a
  {
    public static final c yic;
    
    static
    {
      AppMethodBeat.i(199160);
      yic = new c();
      AppMethodBeat.o(199160);
    }
    
    public final void eU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199159);
      Log.i("MicroMsg.FloatBallService", "addBallInfo by handoff, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(199159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.d
 * JD-Core Version:    0.7.0.1
 */