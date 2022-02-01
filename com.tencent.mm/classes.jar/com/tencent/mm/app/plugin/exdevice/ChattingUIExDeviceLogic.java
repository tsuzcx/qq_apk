package com.tencent.mm.app.plugin.exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ek;
import com.tencent.mm.autogen.a.rb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.util.HashMap;
import java.util.Map;

public final class ChattingUIExDeviceLogic
{
  public a hlc;
  public OpFromExDeviceEventListener hld;
  public ExDeviceChattingUIStateEventListener hle;
  private String hlf;
  public Map<String, Boolean> hlg;
  public boolean hlh;
  
  public ChattingUIExDeviceLogic(a parama)
  {
    AppMethodBeat.i(19771);
    Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
    this.hlc = parama;
    this.hlh = true;
    if (this.hld == null) {
      this.hld = new OpFromExDeviceEventListener();
    }
    this.hld.alive();
    if (this.hle == null) {
      this.hle = new ExDeviceChattingUIStateEventListener();
    }
    this.hle.alive();
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
      paramc = paramc.dO(false);
      if ((paramc != null) && (paramc.aBj() != null) && (paramc.aBj().aBs()))
      {
        AppMethodBeat.o(19774);
        return true;
      }
    }
    AppMethodBeat.o(19774);
    return false;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(19773);
    if (this.hlc == null)
    {
      Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
      AppMethodBeat.o(19773);
      return;
    }
    if ((ab.IS(this.hlc.getTalkerUserName())) && (d(paramc))) {
      bh.baH().postToWorker(new ChattingUIExDeviceLogic.1(this, paramInt));
    }
    AppMethodBeat.o(19773);
  }
  
  final void f(int paramInt, String paramString1, String paramString2)
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
        if ((this.hlc == null) || (Util.isNullOrNil(paramString1)))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
          AppMethodBeat.o(19772);
          return;
        }
        localc = g.hU(paramString1);
        if (!d(localc))
        {
          Log.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[] { paramString1 });
          AppMethodBeat.o(19772);
          continue;
        }
        if (this.hlg != null) {
          break label117;
        }
      }
      finally {}
      this.hlg = new HashMap();
      localMap = this.hlg;
      if (!paramString1.equals(this.hlf))
      {
        this.hlf = paramString1;
        localMap.clear();
      }
      if (localc.dO(false).aBj().hdn != 1) {
        break;
      }
      this.hlc.aezO.setMMSubTitle(null);
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
      this.hlc.aezO.setMMSubTitle(null);
      AppMethodBeat.o(19772);
      break;
      if (localMap.size() == 0)
      {
        this.hlc.aezO.setMMSubTitle(R.l.gGj);
        AppMethodBeat.o(19772);
        break;
        localMap.put(paramString2, Boolean.TRUE);
        this.hlc.aezO.setMMSubTitle(this.hlc.aezO.getString(R.l.gGh, new Object[] { Integer.valueOf(localMap.size()) }));
        Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[] { paramString2 });
        AppMethodBeat.o(19772);
        break;
        if (localMap.remove(paramString2) != null) {
          Log.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[] { paramString2 });
        }
        this.hlc.aezO.setMMSubTitle(this.hlc.aezO.getString(R.l.gGh, new Object[] { Integer.valueOf(localMap.size()) }));
        AppMethodBeat.o(19772);
        break;
        if (localMap.size() == 0) {
          this.hlc.aezO.setMMSubTitle(R.l.gGi);
        }
      }
    }
  }
  
  public class ExDeviceChattingUIStateEventListener
    extends IListener<ek>
  {
    public ExDeviceChattingUIStateEventListener()
    {
      super();
      AppMethodBeat.i(161258);
      this.__eventId = ek.class.getName().hashCode();
      AppMethodBeat.o(161258);
    }
  }
  
  public class OpFromExDeviceEventListener
    extends IListener<rb>
  {
    public OpFromExDeviceEventListener()
    {
      super();
      AppMethodBeat.i(161259);
      this.__eventId = rb.class.getName().hashCode();
      AppMethodBeat.o(161259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic
 * JD-Core Version:    0.7.0.1
 */