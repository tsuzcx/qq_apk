package com.tencent.mm.plugin.finder.live;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.b;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReceiver;", "Landroid/webkit/ValueCallback;", "", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "appId", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getRPluginLayout", "()Ljava/lang/ref/WeakReference;", "setRPluginLayout", "(Ljava/lang/ref/WeakReference;)V", "onReceiveValue", "", "value", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements ValueCallback<String>
{
  private WeakReference<com.tencent.mm.plugin.finder.live.view.a> BxE;
  private final String TAG;
  private String appId;
  
  public m(com.tencent.mm.plugin.finder.live.view.a parama, String paramString)
  {
    AppMethodBeat.i(350587);
    this.TAG = "Finder.LiveMiniProgramReceiver";
    this.BxE = new WeakReference(parama);
    this.appId = paramString;
    AppMethodBeat.o(350587);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.view.a parama, m paramm, int paramInt, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(350603);
    s.u(paramm, "this$0");
    g localg = new g();
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = ((q)parama.getBuContext().business(q.class)).Eib;
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVk == paramLong)
          {
            i = 1;
            label165:
            if (i == 0) {
              break label374;
            }
            label170:
            localObject1 = (com.tencent.mm.plugin.finder.live.view.convert.k)localObject1;
            label177:
            localg.appId = paramString1;
            localg.qAF = paramString2;
            paramString1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
              break label388;
            }
          }
        }
      }
    }
    label388:
    for (int i = 1176;; i = 1177)
    {
      localg.scene = i;
      localg.hzx = paramString3;
      paramString1 = k.Bxu;
      localg.qAT = new HalfScreenConfig(true, k.bUw(), HalfScreenConfig.a.rae, false, null, false, null, HalfScreenConfig.c.rao, false, true, null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16776568);
      if (paramInt == 1)
      {
        Log.i(paramm.TAG, s.X("share item:", localObject1));
        if (localObject1 != null)
        {
          paramString1 = localg.qAT.ckQ();
          paramString2 = k.Bxu;
          localg.qAT = paramString1.a(k.a(parama.getBuContext(), (com.tencent.mm.plugin.finder.live.view.convert.k)localObject1)).ckR();
        }
      }
      paramString1 = parama.getFinderLiveAssistant();
      if (paramString1 == null) {
        break label396;
      }
      paramm = parama.getContext();
      s.s(paramm, "pluginLayout.context");
      paramString1.b(paramm, localg, parama);
      AppMethodBeat.o(350603);
      return;
      i = 0;
      break label165;
      label374:
      break;
      localObject1 = null;
      break label170;
      localObject1 = null;
      break label177;
    }
    label396:
    Log.i(paramm.TAG, "finderLiveAssistant is null!");
    AppMethodBeat.o(350603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.m
 * JD-Core Version:    0.7.0.1
 */