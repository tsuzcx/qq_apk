package com.tencent.mm.app.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.f.a.ea;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.mu;
import com.tencent.mm.f.a.po;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public com.tencent.mm.ui.chatting.e.a fgR;
  public b fgS;
  public a fgT;
  private String fgU;
  public Map<String, Boolean> fgV;
  public boolean fgW;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(19771);
    Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.fgR = parama;
    this.fgW = true;
    if (this.fgS == null) {
      this.fgS = new b();
    }
    EventCenter.instance.addListener(this.fgS);
    if (this.fgT == null) {
      this.fgT = new a();
    }
    EventCenter.instance.addListener(this.fgT);
    AppMethodBeat.o(19771);
  }
  
  public static boolean d(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(19774);
    if (paramc == null)
    {
      AppMethodBeat.o(19774);
      return false;
    }
    if (paramc != null)
    {
      paramc = paramc.dc(false);
      if ((paramc != null) && (paramc.Zr() != null) && (paramc.Zr().ZA()))
      {
        AppMethodBeat.o(19774);
        return true;
      }
    }
    AppMethodBeat.o(19774);
    return false;
  }
  
  public final void a(final int paramInt, com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(19773);
    if (this.fgR == null)
    {
      Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((ab.Qm(this.fgR.getTalkerUserName())) && (d(paramc))) {
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new ez();
            ((ez)localObject).fAR.op = 0;
            ((ez)localObject).fAR.userName = a.this.fgR.getTalkerUserName();
            ((ez)localObject).fAR.context = a.this.fgR.WQv.getContext();
            EventCenter.instance.publish((IEvent)localObject);
            if (a.this.fgR.getTalkerUserName().equals("gh_43f2581f6fd6")) {
              ((com.tencent.mm.plugin.sport.a.c)LifecycleEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(1));
            }
          }
          Object localObject = new mu();
          ((mu)localObject).fKS.opType = paramInt;
          ((mu)localObject).fKS.viewId = 1;
          ((mu)localObject).fKS.fKT = a.this.fgR.getTalkerUserName();
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(19769);
        }
      });
    }
    AppMethodBeat.o(19773);
  }
  
  final void e(int paramInt, String paramString1, String paramString2)
  {
    label117:
    Map localMap;
    for (;;)
    {
      com.tencent.mm.api.c localc;
      try
      {
        AppMethodBeat.i(19772);
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.fgR == null) || (Util.isNullOrNil(paramString1)))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = g.gu(paramString1);
        if (!d(localc))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.fgV != null) {
          break label117;
        }
      }
      finally {}
      this.fgV = new HashMap();
      localMap = this.fgV;
      if (!paramString1.equals(this.fgU))
      {
        this.fgU = paramString1;
        localMap.clear();
      }
      if (localc.dc(false).Zr().eZN != 1) {
        break;
      }
      this.fgR.WQv.setMMSubTitle(null);
      AppMethodBeat.o(19772);
    }
    Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19772);
      break;
      this.fgR.WQv.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.fgR.WQv.setMMSubTitle(R.l.eDv);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.fgR.WQv.setMMSubTitle(this.fgR.WQv.getString(R.l.eDt, new Object[] { Integer.valueOf(localMap.size()) }));
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.fgR.WQv.setMMSubTitle(this.fgR.WQv.getString(R.l.eDt, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.fgR.WQv.setMMSubTitle(R.l.eDu);
        }
      }
    }
  }
  
  final class a
    extends IListener<ea>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = ea.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends IListener<po>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = po.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */