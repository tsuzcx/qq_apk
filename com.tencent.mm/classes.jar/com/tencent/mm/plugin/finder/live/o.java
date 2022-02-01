package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.utils.ah;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.findersdk.a.ci;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramUICallback;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "halfScreenChangeListener", "Lcom/tencent/mm/plugin/findersdk/api/IMiniProgramHalfScreenStatusChangeListener;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/findersdk/api/IMiniProgramHalfScreenStatusChangeListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "onTriggerHalfScreenShare", "token", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements i
{
  private final a BxG;
  private final ci BxH;
  private final String TAG;
  
  public o(a parama, ci paramci)
  {
    this.BxG = parama;
    this.BxH = paramci;
    this.TAG = "MiniProgramUICallback";
  }
  
  public final void UP(String paramString)
  {
    AppMethodBeat.i(350666);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject1 = this.BxG;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, localObject1 + " onTriggerHalfScreenShare " + paramString);
      localObject1 = (CharSequence)paramString;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label199;
      }
    }
    label199:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = ah.Ghp;
        localObject2 = ah.aBB(paramString);
        if (localObject2 != null)
        {
          paramString = an.GhR;
          paramString = MMApplicationContext.getContext();
          s.s(paramString, "getContext()");
          an.a.a(paramString, (bth)localObject2);
          paramString = ah.Ghp;
          paramString = ah.Ghp;
          localObject1 = ((bth)localObject2).productId;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = "";
          }
          ah.a((bth)localObject2, "share_commodity", ah.aBC(paramString));
        }
      }
      AppMethodBeat.o(350666);
      return;
      localObject1 = (f)((a)localObject1).business(f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public final void ceq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(350625);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject1 = this.BxG;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " luanchMiniProgram error!");
      localObject1 = this.BxG;
      if (localObject1 != null) {
        break label122;
      }
    }
    label122:
    for (localObject1 = localObject2;; localObject1 = (q)((a)localObject1).business(q.class))
    {
      if (localObject1 != null) {
        ((q)localObject1).Eij = false;
      }
      AppMethodBeat.o(350625);
      return;
      localObject1 = (f)((a)localObject1).business(f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public final void cer()
  {
    Object localObject2 = null;
    AppMethodBeat.i(350635);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject1 = this.BxG;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " onAppBrandUIEnter!");
      localObject1 = this.BxG;
      if (localObject1 != null) {
        break label122;
      }
    }
    label122:
    for (localObject1 = localObject2;; localObject1 = (q)((a)localObject1).business(q.class))
    {
      if (localObject1 != null) {
        ((q)localObject1).Eij = true;
      }
      AppMethodBeat.o(350635);
      return;
      localObject1 = (f)((a)localObject1).business(f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public final void ces()
  {
    Object localObject2 = null;
    AppMethodBeat.i(350651);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject1 = this.BxG;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " onAppBrandProcessDied!");
      localObject1 = this.BxG;
      if (localObject1 != null) {
        break label122;
      }
    }
    label122:
    for (localObject1 = localObject2;; localObject1 = (q)((a)localObject1).business(q.class))
    {
      if (localObject1 != null) {
        ((q)localObject1).Eij = false;
      }
      AppMethodBeat.o(350651);
      return;
      localObject1 = (f)((a)localObject1).business(f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
  
  public final void ie(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350642);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject1 = this.BxG;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " onAppBrandUIExit isFinish:" + paramBoolean + '!');
      localObject1 = this.BxG;
      if (localObject1 != null) {
        break label148;
      }
    }
    label148:
    for (localObject1 = localObject2;; localObject1 = (q)((a)localObject1).business(q.class))
    {
      if (localObject1 != null) {
        ((q)localObject1).Eij = false;
      }
      localObject1 = this.BxH;
      if (localObject1 != null) {
        ((ci)localObject1).ehf();
      }
      AppMethodBeat.o(350642);
      return;
      localObject1 = (f)((a)localObject1).business(f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.o
 * JD-Core Version:    0.7.0.1
 */