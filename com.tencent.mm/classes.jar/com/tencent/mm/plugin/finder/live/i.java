package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReceiver;", "Landroid/webkit/ValueCallback;", "", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "appId", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getRPluginLayout", "()Ljava/lang/ref/WeakReference;", "setRPluginLayout", "(Ljava/lang/ref/WeakReference;)V", "onReceiveValue", "", "value", "plugin-finder_release"})
public final class i
  implements ValueCallback<String>
{
  final String TAG;
  private String appId;
  private WeakReference<FinderBaseLivePluginLayout> ugd;
  
  public i(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout, String paramString)
  {
    AppMethodBeat.i(245881);
    this.TAG = "Finder.LiveMiniProgramReceiver";
    this.ugd = new WeakReference(paramFinderBaseLivePluginLayout);
    this.appId = paramString;
    AppMethodBeat.o(245881);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/MiniProgramReceiver$onReceiveValue$1$2"})
  static final class a
    implements Runnable
  {
    a(String paramString1, String paramString2, i parami, FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(245879);
      g localg = new g();
      localg.appId = this.kPQ;
      localg.kHw = this.mXY;
      Object localObject = m.vVH;
      if (m.dBP()) {}
      for (int i = 1176;; i = 1177)
      {
        localg.scene = i;
        localObject = this.ugf.getFinderLiveAssistant();
        if (localObject == null) {
          break;
        }
        Context localContext = this.ugf.getContext();
        p.g(localContext, "pluginLayout.context");
        ((s)localObject).a(localContext, localg, false);
        AppMethodBeat.o(245879);
        return;
      }
      Log.i(this.uge.TAG, "finderLiveAssistant is null!");
      AppMethodBeat.o(245879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.i
 * JD-Core Version:    0.7.0.1
 */