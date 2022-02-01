package com.tencent.mm.app.plugin.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.model.az;
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
  public com.tencent.mm.ui.chatting.d.a cOd;
  public b cOe;
  public a cOf;
  private String cOg;
  public Map<String, Boolean> cOh;
  public boolean cOi;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(19771);
    ad.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.cOd = parama;
    this.cOi = true;
    if (this.cOe == null) {
      this.cOe = new b();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.cOe);
    if (this.cOf == null) {
      this.cOf = new a();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.cOf);
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
      paramc = paramc.bU(false);
      if ((paramc != null) && (paramc.Jy() != null) && (paramc.Jy().JI()))
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
    if (this.cOd == null)
    {
      ad.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((w.sE(this.cOd.getTalkerUserName())) && (c(paramc))) {
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19769);
          if (1 == paramInt)
          {
            localObject = new ek();
            ((ek)localObject).dgR.op = 0;
            ((ek)localObject).dgR.userName = a.this.cOd.getTalkerUserName();
            ((ek)localObject).dgR.context = a.this.cOd.GzJ.getContext();
            com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
            if (a.this.cOd.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new ui();
              ((ui)localObject).dzG.action = 1;
              com.tencent.mm.sdk.b.a.ESL.a((b)localObject, new Executor()
              {
                public final void execute(Runnable paramAnonymous2Runnable)
                {
                  AppMethodBeat.i(179570);
                  h.Iye.aP(paramAnonymous2Runnable);
                  AppMethodBeat.o(179570);
                }
              });
            }
          }
          Object localObject = new ku();
          ((ku)localObject).dpm.opType = paramInt;
          ((ku)localObject).dpm.dpo = 1;
          ((ku)localObject).dpm.dpn = a.this.cOd.getTalkerUserName();
          com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
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
        if ((this.cOd == null) || (bt.isNullOrNil(paramString1)))
        {
          ad.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = f.ei(paramString1);
        if (!c(localc))
        {
          ad.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.cOh != null) {
          break label117;
        }
      }
      finally {}
      this.cOh = new HashMap();
      localMap = this.cOh;
      if (!paramString1.equals(this.cOg))
      {
        this.cOg = paramString1;
        localMap.clear();
      }
      if (localc.bU(false).Jy().cIR != 1) {
        break;
      }
      this.cOd.GzJ.setMMSubTitle(null);
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
      this.cOd.GzJ.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.cOd.GzJ.setMMSubTitle(2131758534);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.cOd.GzJ.setMMSubTitle(this.cOd.GzJ.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        ad.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          ad.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.cOd.GzJ.setMMSubTitle(this.cOd.GzJ.getString(2131758532, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.cOd.GzJ.setMMSubTitle(2131758533);
        }
      }
    }
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<dl>
  {
    a()
    {
      AppMethodBeat.i(161258);
      this.__eventId = dl.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<nh>
  {
    b()
    {
      AppMethodBeat.i(161259);
      this.__eventId = nh.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */