package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/GetLuckMoneyCallback;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLuckyMoneyInfo$CallBack;", "pluginLayoutRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "activityRef", "Landroid/app/Activity;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetRedPacketInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements ae.a
{
  private final WeakReference<a> DPE;
  private final WeakReference<Activity> tey;
  
  public h(WeakReference<a> paramWeakReference, WeakReference<Activity> paramWeakReference1)
  {
    this.DPE = paramWeakReference;
    this.tey = paramWeakReference1;
  }
  
  public final void a(int paramInt1, int paramInt2, bid parambid)
  {
    ap localap = null;
    AppMethodBeat.i(358003);
    s.u(parambid, "resp");
    Object localObject1 = this.DPE;
    Object localObject2;
    label42:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = this.tey;
      if (localObject2 != null) {
        break label238;
      }
      localObject2 = null;
      if ((localObject1 != null) && (localObject2 != null))
      {
        localObject3 = a.Companion;
        Log.i(a.a.getTAG(), "[goGetLuckMoney] errType:" + paramInt1 + "  errCode:" + paramInt2 + ' ');
        if ((paramInt2 == 0) && (paramInt1 == 0))
        {
          localObject3 = parambid.ZRk;
          parambid = (Collection)localObject3;
          if ((parambid != null) && (!parambid.isEmpty())) {
            break label251;
          }
          paramInt1 = 1;
          label128:
          if (paramInt1 != 0) {
            break label256;
          }
        }
      }
    }
    label256:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      parambid = localap;
      if (paramInt1 != 0) {
        parambid = (bid)localObject3;
      }
      if (parambid != null)
      {
        localap = ((a)localObject1).getFinderLiveAssistant();
        if (localap != null)
        {
          localObject3 = parambid.get(0);
          s.s(localObject3, "it[0]");
          localap.a((Activity)localObject2, (bls)localObject3, (ResultReceiver)new GetLuckMoneyCallback.onCgiBack.1.2.1((a)localObject1, parambid, MMHandler.createFreeHandler(Looper.getMainLooper())), (b)new a((a)localObject1));
        }
      }
      AppMethodBeat.o(358003);
      return;
      localObject1 = (a)((WeakReference)localObject1).get();
      break;
      label238:
      localObject2 = (Activity)((WeakReference)localObject2).get();
      break label42;
      label251:
      paramInt1 = 0;
      break label128;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.h
 * JD-Core Version:    0.7.0.1
 */