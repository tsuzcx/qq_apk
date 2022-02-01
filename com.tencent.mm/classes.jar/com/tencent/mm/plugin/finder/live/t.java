package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReceiver;", "Landroid/webkit/ValueCallback;", "", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "appId", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getRPluginLayout", "()Ljava/lang/ref/WeakReference;", "setRPluginLayout", "(Ljava/lang/ref/WeakReference;)V", "onReceiveValue", "", "value", "plugin-finder_release"})
public final class t
  implements ValueCallback<String>
{
  final String TAG;
  private String appId;
  private WeakReference<com.tencent.mm.plugin.finder.live.view.a> xWM;
  
  public t(com.tencent.mm.plugin.finder.live.view.a parama, String paramString)
  {
    AppMethodBeat.i(231890);
    this.TAG = "Finder.LiveMiniProgramReceiver";
    this.xWM = new WeakReference(parama);
    this.appId = paramString;
    AppMethodBeat.o(231890);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/MiniProgramReceiver$onReceiveValue$1$3"})
  static final class a
    implements Runnable
  {
    a(String paramString1, String paramString2, String paramString3, t paramt, com.tencent.mm.plugin.finder.live.view.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(280730);
      g localg = new g();
      localg.appId = this.cBD;
      localg.nBq = this.pYx;
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {}
      for (int i = 1176;; i = 1177)
      {
        localg.scene = i;
        localg.fvd = this.xWN;
        localObject = r.xWC;
        localg.nBE = new HalfScreenConfig(true, r.dwO(), HalfScreenConfig.a.nZL, false, null, false, null, HalfScreenConfig.c.nZV, false, true, null, null, false, 7544);
        localObject = this.xWP.getFinderLiveAssistant();
        if (localObject == null) {
          break;
        }
        Context localContext = this.xWP.getContext();
        p.j(localContext, "pluginLayout.context");
        ((an)localObject).b(localContext, localg, this.xWP);
        AppMethodBeat.o(280730);
        return;
      }
      Log.i(this.xWO.TAG, "finderLiveAssistant is null!");
      AppMethodBeat.o(280730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.t
 * JD-Core Version:    0.7.0.1
 */