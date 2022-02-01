package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.jsapi.live.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class e
  extends q
  implements a
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private static void x(Bundle paramBundle)
  {
    AppMethodBeat.i(220657);
    if (paramBundle == null)
    {
      AppMethodBeat.o(220657);
      return;
    }
    if (!paramBundle.containsKey("canStartPlay"))
    {
      Log.i("TXLivePlayerJSAdapterV2SameLayerSupport", "canStartPlayWorkaround, put true");
      paramBundle.putBoolean("canStartPlay", true);
    }
    AppMethodBeat.o(220657);
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220670);
    x(paramBundle);
    paramTXCloudVideoView = super.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(220670);
    return paramTXCloudVideoView;
  }
  
  public final k atT()
  {
    AppMethodBeat.i(220707);
    if (this.sbr.isPlaying())
    {
      localk = d("pause", null);
      AppMethodBeat.o(220707);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(220707);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(220711);
    if (this.ezq != null) {
      this.ezq.onPlayEvent(6000, new Bundle());
    }
    AppMethodBeat.o(220711);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(220716);
    if (this.ezq != null) {
      this.ezq.onPlayEvent(6001, new Bundle());
    }
    AppMethodBeat.o(220716);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(220702);
    k localk = d("resume", null);
    AppMethodBeat.o(220702);
    return localk;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220694);
    k localk = new k(this.sbr.setSurfaceSize(paramInt1, paramInt2));
    AppMethodBeat.o(220694);
    return localk;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(220687);
    paramSurface = new k(this.sbr.setSurface(paramSurface));
    AppMethodBeat.o(220687);
    return paramSurface;
  }
  
  public final boolean isMuted()
  {
    AppMethodBeat.i(220722);
    boolean bool = this.sbr.isMuted();
    AppMethodBeat.o(220722);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(220718);
    boolean bool = this.sbr.isPlaying();
    AppMethodBeat.o(220718);
    return bool;
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(220663);
    this.sbr.setThreadHandler(paramHandler);
    AppMethodBeat.o(220663);
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(220677);
    x(paramBundle);
    paramBundle = new k(this.sbr.initLivePlayer(paramBundle));
    AppMethodBeat.o(220677);
    return paramBundle;
  }
  
  public final k v(Bundle paramBundle)
  {
    AppMethodBeat.i(220682);
    x(paramBundle);
    paramBundle = super.v(paramBundle);
    AppMethodBeat.o(220682);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.e
 * JD-Core Version:    0.7.0.1
 */