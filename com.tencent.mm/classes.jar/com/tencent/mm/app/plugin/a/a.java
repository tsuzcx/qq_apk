package com.tencent.mm.app.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public a.b caA;
  public a.a caB;
  private String caC;
  public Map<String, Boolean> caD;
  public boolean caE;
  public com.tencent.mm.ui.chatting.d.a caz;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(15727);
    ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.caz = parama;
    this.caE = true;
    if (this.caA == null) {
      this.caA = new a.b(this);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.caA);
    if (this.caB == null) {
      this.caB = new a.a(this);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.caB);
    AppMethodBeat.o(15727);
  }
  
  public static boolean a(com.tencent.mm.aj.d paramd)
  {
    AppMethodBeat.i(15730);
    if (paramd == null)
    {
      AppMethodBeat.o(15730);
      return false;
    }
    if (paramd != null)
    {
      paramd = paramd.cU(false);
      if ((paramd != null) && (paramd.aeA() != null) && (paramd.aeA().aeJ()))
      {
        AppMethodBeat.o(15730);
        return true;
      }
    }
    AppMethodBeat.o(15730);
    return false;
  }
  
  public final void a(final int paramInt, com.tencent.mm.aj.d paramd)
  {
    AppMethodBeat.i(15729);
    if (this.caz == null)
    {
      ab.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(15729);
      return;
    }
    if ((t.nU(this.caz.getTalkerUserName())) && (a(paramd))) {
      aw.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(15723);
          if (1 == paramInt)
          {
            localObject = new ee();
            ((ee)localObject).crV.op = 0;
            ((ee)localObject).crV.userName = a.this.caz.getTalkerUserName();
            ((ee)localObject).crV.context = a.this.caz.zJz.getContext();
            com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
            if (a.this.caz.getTalkerUserName().equals("gh_43f2581f6fd6"))
            {
              localObject = new sn();
              ((sn)localObject).cIP.action = 1;
              com.tencent.mm.sdk.b.a.ymk.a((b)localObject, com.tencent.mm.sdk.g.d.ysm.cjN());
            }
          }
          Object localObject = new jr();
          ((jr)localObject).czg.opType = paramInt;
          ((jr)localObject).czg.czi = 1;
          ((jr)localObject).czg.czh = a.this.caz.getTalkerUserName();
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
          AppMethodBeat.o(15723);
        }
      });
    }
    AppMethodBeat.o(15729);
  }
  
  final void d(int paramInt, String paramString1, String paramString2)
  {
    label117:
    Map localMap;
    for (;;)
    {
      com.tencent.mm.aj.d locald;
      try
      {
        AppMethodBeat.i(15728);
        ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[] { Integer.valueOf(paramInt) });
        if ((this.caz == null) || (bo.isNullOrNil(paramString1)))
        {
          ab.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(15728);
          return;
        }
        locald = f.rS(paramString1);
        if (!a(locald))
        {
          ab.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(15728);
          continue;
        }
        if (this.caD != null) {
          break label117;
        }
      }
      finally {}
      this.caD = new HashMap();
      localMap = this.caD;
      if (!paramString1.equals(this.caC))
      {
        this.caC = paramString1;
        localMap.clear();
      }
      if (locald.cU(false).aeA().fvI != 1) {
        break;
      }
      this.caz.zJz.setMMSubTitle(null);
      AppMethodBeat.o(15728);
    }
    ab.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[] { localMap, paramString2 });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(15728);
      break;
      this.caz.zJz.setMMSubTitle(null);
      AppMethodBeat.o(15728);
      break;
      if (localMap.size() == 0)
      {
        this.caz.zJz.setMMSubTitle(2131299406);
        AppMethodBeat.o(15728);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.caz.zJz.setMMSubTitle(this.caz.zJz.getString(2131299404, new Object[] { Integer.valueOf(localMap.size()) }));
        ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(15728);
        break;
        if (localMap.remove(paramString2) != null) {
          ab.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.caz.zJz.setMMSubTitle(this.caz.zJz.getString(2131299404, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(15728);
        break;
        if (localMap.size() == 0) {
          this.caz.zJz.setMMSubTitle(2131299405);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */