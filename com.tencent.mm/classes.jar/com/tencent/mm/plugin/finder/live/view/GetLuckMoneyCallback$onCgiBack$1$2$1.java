package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/GetLuckMoneyCallback$onCgiBack$1$2$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GetLuckMoneyCallback$onCgiBack$1$2$1
  extends ResultReceiver
{
  GetLuckMoneyCallback$onCgiBack$1$2$1(a parama, LinkedList<bls> paramLinkedList, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    a locala = null;
    AppMethodBeat.i(357631);
    Object localObject1 = a.Companion;
    Log.i(a.a.getTAG(), s.X("openLuckyMoney result:", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(357631);
      return;
    case -1: 
      localObject1 = this.CHC.getFinderLiveAssistant();
      if (localObject1 != null)
      {
        long l1 = ((f)this.CHC.business(f.class)).liveInfo.liveId;
        long l2 = ((f)this.CHC.business(f.class)).hKN;
        localObject2 = ((f)this.CHC.business(f.class)).nonceId;
        localObject3 = ((f)this.CHC.business(f.class)).mZp;
        paramBundle = (bls)this.DPF.get(0);
        if (paramBundle == null)
        {
          paramBundle = null;
          ((ap)localObject1).a(l1, l2, (String)localObject2, (byte[])localObject3, paramBundle);
        }
      }
      else
      {
        localObject1 = this.CHC;
        localObject2 = b.c.neL;
        localObject3 = new Bundle();
        paramBundle = (bls)this.DPF.get(0);
        if (paramBundle != null) {
          break label253;
        }
      }
      for (paramBundle = locala;; paramBundle = paramBundle.ZOX)
      {
        ((Bundle)localObject3).putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", paramBundle);
        paramBundle = ah.aiuX;
        ((a)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        AppMethodBeat.o(357631);
        return;
        paramBundle = paramBundle.ZOX;
        break;
      }
    case 0: 
      label253:
      AppMethodBeat.o(357631);
      return;
    }
    locala = this.CHC;
    localObject1 = b.c.neL;
    Object localObject2 = new Bundle();
    Object localObject3 = (bls)this.DPF.get(0);
    if (localObject3 == null) {}
    for (;;)
    {
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", paramBundle);
      paramBundle = ah.aiuX;
      locala.statusChange((b.c)localObject1, (Bundle)localObject2);
      break;
      paramBundle = ((bls)localObject3).ZOX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.GetLuckMoneyCallback.onCgiBack.1.2.1
 * JD-Core Version:    0.7.0.1
 */