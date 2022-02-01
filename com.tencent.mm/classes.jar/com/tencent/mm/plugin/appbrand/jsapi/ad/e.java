package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.plugin.appbrand.utils.ak.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class e
  extends ab<f>
{
  public static final int CTRL_INDEX = 472;
  public static final String NAME = "enableDeviceOrientationChangeListening";
  private boolean str;
  protected ak sts;
  
  public e()
  {
    AppMethodBeat.i(137634);
    this.str = false;
    AppMethodBeat.o(137634);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137635);
    if (paramJSONObject.optBoolean("enable", false))
    {
      h.F(paramf);
      if (!this.str)
      {
        this.sts = new ak(paramf.getContext(), new a(paramf.getAppId()));
        this.sts.enable();
        this.str = true;
      }
    }
    for (;;)
    {
      paramf = ZP("ok");
      AppMethodBeat.o(137635);
      return paramf;
      h.G(paramf);
      if (this.str)
      {
        this.sts.disable();
        this.sts = null;
        this.str = false;
      }
    }
  }
  
  static final class a
    implements ak.b
  {
    private final String appId;
    
    public a(String paramString)
    {
      this.appId = paramString;
    }
    
    public final void onFourOrientationsChange(ak.a parama1, final ak.a parama2)
    {
      AppMethodBeat.i(329493);
      Log.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + parama1.name() + "; newOrientation:" + parama2.name());
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329489);
          h localh = h.aG(e.a.a(e.a.this), false);
          if (localh != null)
          {
            ak.a locala = parama2;
            localh.stB = locala;
            if ((localh.mEnable) && (localh.stC == ak.a.urF) && ((locala == ak.a.urH) || (locala == ak.a.urF)))
            {
              localh.c(locala);
              Log.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + localh.stz + "; mOrientation:" + locala.name());
            }
          }
          AppMethodBeat.o(329489);
        }
      }, 500L);
      AppMethodBeat.o(329493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e
 * JD-Core Version:    0.7.0.1
 */