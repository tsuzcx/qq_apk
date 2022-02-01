package com.tencent.mm.app.plugin.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a
{
  public com.tencent.mm.ui.chatting.e.a cWM;
  public b cWN;
  public a cWO;
  private String cWP;
  public Map<String, Boolean> cWQ;
  public boolean cWR;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(19771);
    ad.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.cWM = parama;
    this.cWR = true;
    if (this.cWN == null) {
      this.cWN = new b();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.cWN);
    if (this.cWO == null) {
      this.cWO = new a();
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.cWO);
    AppMethodBeat.o(19771);
  }
  
  public static boolean c(com.tencent.mm.api.c paramc)
  {
    AppMethodBeat.i(19774);
    if (paramc == null)
    {
      AppMethodBeat.o(19774);
      return false;
    }
    if (paramc != null)
    {
      paramc = paramc.bX(false);
      if ((paramc != null) && (paramc.KH() != null) && (paramc.KH().KQ()))
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
    if (this.cWM == null)
    {
      ad.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((w.zE(this.cWM.getTalkerUserName())) && (c(paramc))) {
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new eo();
            ((eo)localObject).dpI.op = 0;
            ((eo)localObject).dpI.userName = a.this.cWM.getTalkerUserName();
            ((eo)localObject).dpI.context = a.this.cWM.JOR.getContext();
            com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
            if (a.this.cWM.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new vl();
              ((vl)localObject).dJE.action = 1;
              com.tencent.mm.sdk.b.a.IbL.a((b)localObject, new Executor()
              {
                public final void execute(Runnable paramAnonymous2Runnable)
                {
                  AppMethodBeat.i(179570);
                  h.LTJ.aR(paramAnonymous2Runnable);
                  AppMethodBeat.o(179570);
                }
              });
            }
          }
          Object localObject = new lm();
          ((lm)localObject).dyK.opType = paramInt;
          ((lm)localObject).dyK.viewId = 1;
          ((lm)localObject).dyK.dyL = a.this.cWM.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
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
        ad.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.cWM == null) || (bt.isNullOrNil(paramString1)))
        {
          ad.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = g.eS(paramString1);
        if (!c(localc))
        {
          ad.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.cWQ != null) {
          break label117;
        }
      }
      finally {}
      this.cWQ = new HashMap();
      localMap = this.cWQ;
      if (!paramString1.equals(this.cWP))
      {
        this.cWP = paramString1;
        localMap.clear();
      }
      if (localc.bX(false).KH().cRd != 1) {
        break;
      }
      this.cWM.JOR.setMMSubTitle(null);
      AppMethodBeat.o(19772);
    }
    ad.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19772);
      break;
      this.cWM.JOR.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.cWM.JOR.setMMSubTitle(2131758534);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.cWM.JOR.setMMSubTitle(this.cWM.JOR.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        ad.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          ad.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.cWM.JOR.setMMSubTitle(this.cWM.JOR.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.cWM.JOR.setMMSubTitle(2131758533);
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dp>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = dp.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<ny>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = ny.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */