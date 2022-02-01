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
  
  private static void s(Bundle paramBundle)
  {
    AppMethodBeat.i(221995);
    if (paramBundle == null)
    {
      AppMethodBeat.o(221995);
      return;
    }
    if (!paramBundle.containsKey("canStartPlay"))
    {
      Log.i("TXLivePlayerJSAdapterV2SameLayerSupport", "canStartPlayWorkaround, put true");
      paramBundle.putBoolean("canStartPlay", true);
    }
    AppMethodBeat.o(221995);
  }
  
  public final k To()
  {
    AppMethodBeat.i(221983);
    if (this.oVT.isPlaying())
    {
      localk = d("pause", null);
      AppMethodBeat.o(221983);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(221983);
    return localk;
  }
  
  public final void Tp()
  {
    AppMethodBeat.i(221986);
    if (this.cGc != null) {
      this.cGc.onPlayEvent(6000, new Bundle());
    }
    AppMethodBeat.o(221986);
  }
  
  public final void Tq()
  {
    AppMethodBeat.i(221989);
    if (this.cGc != null) {
      this.cGc.onPlayEvent(6001, new Bundle());
    }
    AppMethodBeat.o(221989);
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(221980);
    k localk = d("resume", null);
    AppMethodBeat.o(221980);
    return localk;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(221968);
    s(paramBundle);
    paramTXCloudVideoView = super.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(221968);
    return paramTXCloudVideoView;
  }
  
  public final k cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221979);
    k localk = new k(this.oVT.setSurfaceSize(paramInt1, paramInt2));
    AppMethodBeat.o(221979);
    return localk;
  }
  
  public final k e(Surface paramSurface)
  {
    AppMethodBeat.i(221976);
    paramSurface = new k(this.oVT.setSurface(paramSurface));
    AppMethodBeat.o(221976);
    return paramSurface;
  }
  
  public final boolean isMuted()
  {
    AppMethodBeat.i(221993);
    boolean bool = this.oVT.isMuted();
    AppMethodBeat.o(221993);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(221991);
    boolean bool = this.oVT.isPlaying();
    AppMethodBeat.o(221991);
    return bool;
  }
  
  public final k p(Bundle paramBundle)
  {
    AppMethodBeat.i(221972);
    s(paramBundle);
    paramBundle = new k(this.oVT.initLivePlayer(paramBundle));
    AppMethodBeat.o(221972);
    return paramBundle;
  }
  
  public final k q(Bundle paramBundle)
  {
    AppMethodBeat.i(221975);
    s(paramBundle);
    paramBundle = super.q(paramBundle);
    AppMethodBeat.o(221975);
    return paramBundle;
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(221963);
    this.oVT.setThreadHandler(paramHandler);
    AppMethodBeat.o(221963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.e
 * JD-Core Version:    0.7.0.1
 */