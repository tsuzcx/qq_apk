package com.tencent.mm.app.plugin.a;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a
{
  public com.tencent.mm.ui.chatting.e.a dom;
  public b don;
  public a doo;
  private String dop;
  public Map<String, Boolean> doq;
  public boolean dor;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(19771);
    Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.dom = parama;
    this.dor = true;
    if (this.don == null) {
      this.don = new b();
    }
    EventCenter.instance.addListener(this.don);
    if (this.doo == null) {
      this.doo = new a();
    }
    EventCenter.instance.addListener(this.doo);
    AppMethodBeat.o(19771);
  }
  
  public static boolean d(c paramc)
  {
    AppMethodBeat.i(19774);
    if (paramc == null)
    {
      AppMethodBeat.o(19774);
      return false;
    }
    if (paramc != null)
    {
      paramc = paramc.cG(false);
      if ((paramc != null) && (paramc.UZ() != null) && (paramc.UZ().Vi()))
      {
        AppMethodBeat.o(19774);
        return true;
      }
    }
    AppMethodBeat.o(19774);
    return false;
  }
  
  public final void a(final int paramInt, c paramc)
  {
    AppMethodBeat.i(19773);
    if (this.dom == null)
    {
      Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((ab.IT(this.dom.getTalkerUserName())) && (d(paramc))) {
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new es();
            ((es)localObject).dIa.op = 0;
            ((es)localObject).dIa.userName = a.this.dom.getTalkerUserName();
            ((es)localObject).dIa.context = a.this.dom.Pwc.getContext();
            EventCenter.instance.publish((IEvent)localObject);
            if (a.this.dom.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new wp();
              ((wp)localObject).ecH.action = 1;
              EventCenter.instance.asyncPublish((IEvent)localObject, new Executor()
              {
                public final void execute(Runnable paramAnonymous2Runnable)
                {
                  AppMethodBeat.i(179570);
                  h.RTc.aX(paramAnonymous2Runnable);
                  AppMethodBeat.o(179570);
                }
              });
            }
          }
          Object localObject = new md();
          ((md)localObject).dRC.opType = paramInt;
          ((md)localObject).dRC.viewId = 1;
          ((md)localObject).dRC.dRD = a.this.dom.getTalkerUserName();
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
      c localc;
      try
      {
        AppMethodBeat.i(19772);
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.dom == null) || (Util.isNullOrNil(paramString1)))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = g.fJ(paramString1);
        if (!d(localc))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.doq != null) {
          break label117;
        }
      }
      finally {}
      this.doq = new HashMap();
      localMap = this.doq;
      if (!paramString1.equals(this.dop))
      {
        this.dop = paramString1;
        localMap.clear();
      }
      if (localc.cG(false).UZ().dig != 1) {
        break;
      }
      this.dom.Pwc.setMMSubTitle(null);
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
      this.dom.Pwc.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.dom.Pwc.setMMSubTitle(2131758833);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.dom.Pwc.setMMSubTitle(this.dom.Pwc.getString(2131758831, new Object[] { Integer.valueOf(localMap.size()) }));
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.dom.Pwc.setMMSubTitle(this.dom.Pwc.getString(2131758831, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.dom.Pwc.setMMSubTitle(2131758832);
        }
      }
    }
  }
  
  final class a
    extends IListener<dt>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = dt.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends IListener<or>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = or.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */