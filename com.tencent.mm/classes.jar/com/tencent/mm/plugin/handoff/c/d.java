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
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aw;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handler", "com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1;", "add", "", "handOff", "apply", "commit", "del", "process", "message", "processAddRequest", "items", "", "processDelRequest", "Companion", "TryEnterFloatBallInternalTask", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a JlB;
  private static final String[] JlG;
  final Map<String, HandOff> JlC;
  final Map<String, HandOff> JlD;
  final Map<String, Boolean> JlE;
  final b JlF;
  
  static
  {
    AppMethodBeat.i(266235);
    JlB = new d.a((byte)0);
    JlG = new String[] { ToolsProcessIPCService.PROCESS_NAME, ToolsMpProcessIPCService.PROCESS_NAME };
    AppMethodBeat.o(266235);
  }
  
  public d(final Looper paramLooper)
  {
    AppMethodBeat.i(266196);
    this.JlC = ((Map)new LinkedHashMap());
    this.JlD = ((Map)new LinkedHashMap());
    this.JlE = ((Map)new LinkedHashMap());
    this.JlF = new b(this, paramLooper);
    AppMethodBeat.o(266196);
  }
  
  private static final void jl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266222);
    Log.i("MicroMsg.FloatBallService", "addBallInfo by handoff, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    AppMethodBeat.o(266222);
  }
  
  private static void x(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(266203);
    Object localObject;
    try
    {
      paramCollection = ((Iterable)paramCollection).iterator();
      while (paramCollection.hasNext())
      {
        localObject = (HandOff)paramCollection.next();
        localObject = ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aId(((HandOff)localObject).getId());
        if (localObject != null) {
          if (aw.isMultiTaskMode())
          {
            localObject = ((com.tencent.mm.plugin.multitask.d)h.az(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoById(((HandOff)localObject).getKey());
            if (localObject != null)
            {
              Log.i("HandOff.RequestProcessor", "processDelRequest multiTask");
              ((com.tencent.mm.plugin.multitask.d)h.az(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject).field_id);
              ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJK();
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
      Log.d("HandOff.RequestProcessor", s.X("delete handoff fail: ", paramCollection.getLocalizedMessage()));
      AppMethodBeat.o(266203);
      return;
    }
    for (;;)
    {
      localObject = ((b)h.ax(b.class)).h(new BallInfo(i, ((HandOff)localObject).getKey()));
      if (localObject == null) {
        break;
      }
      Log.i("HandOff.RequestProcessor", "processDelRequest ballInfo");
      ((b)h.ax(b.class)).l((BallInfo)localObject);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJK();
      break;
      int i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      AppMethodBeat.o(266203);
      return;
      i = 0;
    }
  }
  
  private static void y(Collection<? extends HandOff> paramCollection)
  {
    AppMethodBeat.i(266215);
    Object localObject;
    int i;
    r localr;
    for (;;)
    {
      try
      {
        paramCollection = ((Iterable)paramCollection).iterator();
        if (!paramCollection.hasNext()) {
          break label241;
        }
        localObject = (HandOff)paramCollection.next();
        i = a.fJP();
        if (i <= 0)
        {
          Log.i("HandOff.RequestProcessor", s.X("cannot add float ball, availableCount = ", Integer.valueOf(i)));
          FloatBallProxyUI.a(3, d..ExternalSyntheticLambda0.INSTANCE);
          continue;
        }
        if (!aw.isMultiTaskMode()) {
          break;
        }
      }
      catch (Exception paramCollection)
      {
        Log.d("HandOff.RequestProcessor", s.X("add handoff fail: ", paramCollection.getLocalizedMessage()));
        AppMethodBeat.o(266215);
        return;
      }
      localr = ((HandOff)localObject).createMultiTaskInfo();
      if (localr != null) {
        switch (((HandOff)localObject).getDataType())
        {
        }
      }
    }
    for (;;)
    {
      Log.i("HandOff.RequestProcessor", "processAddRequest multiTask");
      ((com.tencent.mm.plugin.multitask.d)h.az(com.tencent.mm.plugin.multitask.d.class)).addTaskInfo(((HandOff)localObject).getKey(), i, (drz)localr.bsC, (byte[])localr.bsD, null);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJK();
      break;
      localObject = ((HandOff)localObject).createBallInfo();
      if (localObject == null) {
        break;
      }
      Log.i("HandOff.RequestProcessor", "processAddRequest ballInfo");
      ((b)h.ax(b.class)).j((BallInfo)localObject);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJK();
      break;
      label241:
      AppMethodBeat.o(266215);
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(d paramd, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(266176);
      s.u(paramMessage, "msg");
      if (paramMessage.what == 1)
      {
        Log.d("HandOff.RequestProcessor", "handle commit message");
        d.a(this.JlH);
      }
      AppMethodBeat.o(266176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.d
 * JD-Core Version:    0.7.0.1
 */