package com.tencent.mm.app.plugin.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.us;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a
{
  public a cLA;
  private String cLB;
  public Map<String, Boolean> cLC;
  public boolean cLD;
  public com.tencent.mm.ui.chatting.d.a cLy;
  public b cLz;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(19771);
    ac.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.cLy = parama;
    this.cLD = true;
    if (this.cLz == null) {
      this.cLz = new b();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.cLz);
    if (this.cLA == null) {
      this.cLA = new a();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.cLA);
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
      paramc = paramc.bV(false);
      if ((paramc != null) && (paramc.Jh() != null) && (paramc.Jh().Jr()))
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
    if (this.cLy == null)
    {
      ac.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((w.wH(this.cLy.getTalkerUserName())) && (c(paramc))) {
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new el();
            ((el)localObject).dem.op = 0;
            ((el)localObject).dem.userName = a.this.cLy.getTalkerUserName();
            ((el)localObject).dem.context = a.this.cLy.HZF.getContext();
            com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
            if (a.this.cLy.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new us();
              ((us)localObject).dxs.action = 1;
              com.tencent.mm.sdk.b.a.GpY.a((b)localObject, new Executor()
              {
                public final void execute(Runnable paramAnonymous2Runnable)
                {
                  AppMethodBeat.i(179570);
                  h.JZN.aS(paramAnonymous2Runnable);
                  AppMethodBeat.o(179570);
                }
              });
            }
          }
          Object localObject = new ld();
          ((ld)localObject).dmW.opType = paramInt;
          ((ld)localObject).dmW.viewId = 1;
          ((ld)localObject).dmW.dmX = a.this.cLy.getTalkerUserName();
          com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
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
        ac.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.cLy == null) || (bs.isNullOrNil(paramString1)))
        {
          ac.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = f.dX(paramString1);
        if (!c(localc))
        {
          ac.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.cLC != null) {
          break label117;
        }
      }
      finally {}
      this.cLC = new HashMap();
      localMap = this.cLC;
      if (!paramString1.equals(this.cLB))
      {
        this.cLB = paramString1;
        localMap.clear();
      }
      if (localc.bV(false).Jh().cFY != 1) {
        break;
      }
      this.cLy.HZF.setMMSubTitle(null);
      AppMethodBeat.o(19772);
    }
    ac.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19772);
      break;
      this.cLy.HZF.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.cLy.HZF.setMMSubTitle(2131758534);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.cLy.HZF.setMMSubTitle(this.cLy.HZF.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        ac.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          ac.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.cLy.HZF.setMMSubTitle(this.cLy.HZF.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.cLy.HZF.setMMSubTitle(2131758533);
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dm>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = dm.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<nq>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = nq.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */