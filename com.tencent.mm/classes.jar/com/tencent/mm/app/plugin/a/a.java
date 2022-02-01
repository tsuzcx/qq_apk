package com.tencent.mm.app.plugin.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a
{
  public com.tencent.mm.ui.chatting.e.a cXJ;
  public b cXK;
  public a cXL;
  private String cXM;
  public Map<String, Boolean> cXN;
  public boolean cXO;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(19771);
    ae.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.cXJ = parama;
    this.cXO = true;
    if (this.cXK == null) {
      this.cXK = new b();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.cXK);
    if (this.cXL == null) {
      this.cXL = new a();
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.cXL);
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
      if ((paramc != null) && (paramc.KP() != null) && (paramc.KP().KY()))
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
    if (this.cXJ == null)
    {
      ae.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((x.Ao(this.cXJ.getTalkerUserName())) && (c(paramc))) {
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new ep();
            ((ep)localObject).dqN.op = 0;
            ((ep)localObject).dqN.userName = a.this.cXJ.getTalkerUserName();
            ((ep)localObject).dqN.context = a.this.cXJ.Kkd.getContext();
            com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
            if (a.this.cXJ.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new vp();
              ((vp)localObject).dKS.action = 1;
              com.tencent.mm.sdk.b.a.IvT.a((b)localObject, new Executor()
              {
                public final void execute(Runnable paramAnonymous2Runnable)
                {
                  AppMethodBeat.i(179570);
                  h.MqF.aO(paramAnonymous2Runnable);
                  AppMethodBeat.o(179570);
                }
              });
            }
          }
          Object localObject = new ln();
          ((ln)localObject).dzP.opType = paramInt;
          ((ln)localObject).dzP.viewId = 1;
          ((ln)localObject).dzP.dzQ = a.this.cXJ.getTalkerUserName();
          com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
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
        ae.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.cXJ == null) || (bu.isNullOrNil(paramString1)))
        {
          ae.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = g.eX(paramString1);
        if (!c(localc))
        {
          ae.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.cXN != null) {
          break label117;
        }
      }
      finally {}
      this.cXN = new HashMap();
      localMap = this.cXN;
      if (!paramString1.equals(this.cXM))
      {
        this.cXM = paramString1;
        localMap.clear();
      }
      if (localc.bX(false).KP().cRN != 1) {
        break;
      }
      this.cXJ.Kkd.setMMSubTitle(null);
      AppMethodBeat.o(19772);
    }
    ae.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19772);
      break;
      this.cXJ.Kkd.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.cXJ.Kkd.setMMSubTitle(2131758534);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.cXJ.Kkd.setMMSubTitle(this.cXJ.Kkd.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        ae.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          ae.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.cXJ.Kkd.setMMSubTitle(this.cXJ.Kkd.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.cXJ.Kkd.setMMSubTitle(2131758533);
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dq>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = dq.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<nz>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = nz.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */