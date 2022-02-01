package com.tencent.mm.plugin.finder.live.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.iz;
import com.tencent.mm.autogen.a.iz.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$checkDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLiveStateActionEvent;", "callback", "", "event", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveService$checkDeviceLsn$1
  extends IListener<iz>
{
  FinderLiveService$checkDeviceLsn$1(com.tencent.mm.app.f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(360014);
    AppMethodBeat.o(360014);
  }
  
  private static boolean a(iz paramiz)
  {
    Object localObject1 = null;
    AppMethodBeat.i(360027);
    s.u(paramiz, "event");
    Object localObject2 = paramiz.hKB;
    if (localObject2 != null) {
      ((iz.a)localObject2).isStart = false;
    }
    localObject2 = paramiz.hKB;
    if (localObject2 != null) {
      ((iz.a)localObject2).hKC = false;
    }
    localObject2 = paramiz.hKB;
    if (localObject2 != null) {
      ((iz.a)localObject2).hKE = false;
    }
    localObject2 = paramiz.hKB;
    if (localObject2 != null) {
      ((iz.a)localObject2).hKD = false;
    }
    localObject2 = aj.CGT;
    localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    Object localObject3;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo.liveId != 0L) && (!((e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).business(e.class)).eyA()))
    {
      localObject2 = paramiz.hKB;
      if (localObject2 != null)
      {
        localObject3 = aj.CGT;
        ((iz.a)localObject2).hKC = aj.bUB();
      }
      localObject2 = paramiz.hKB;
      if (localObject2 != null) {
        ((iz.a)localObject2).isStart = true;
      }
      localObject2 = aj.CGT;
      localObject2 = (j)aj.business(j.class);
      if (localObject2 != null) {
        break label212;
      }
      if (localObject1 != null)
      {
        if (((h)localObject1).mXM != 2) {
          break label346;
        }
        localObject1 = paramiz.hKB;
        if (localObject1 != null) {
          ((iz.a)localObject1).hKE = true;
        }
        paramiz = paramiz.hKB;
        if (paramiz != null) {
          paramiz.hKD = true;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(360027);
        return true;
        label212:
        localObject2 = ((j)localObject2).Efw;
        if (localObject2 == null) {
          break;
        }
        synchronized ((Iterable)localObject2)
        {
          Iterator localIterator = ???.iterator();
          label239:
          if (localIterator.hasNext())
          {
            localObject2 = localIterator.next();
            String str = ((h)localObject2).mXL;
            localObject1 = aj.CGT;
            localObject1 = (e)aj.business(e.class);
            if (localObject1 == null) {
              localObject1 = "";
            }
            for (;;)
            {
              boolean bool = Util.isEqual(str, (String)localObject1);
              if (!bool) {
                break label239;
              }
              localObject1 = localObject2;
              localObject1 = (h)localObject1;
              break;
              localObject3 = ((e)localObject1).eyF();
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
            }
          }
          localObject1 = null;
        }
      }
      label346:
      if (((h)localObject1).mXM == 1)
      {
        localObject1 = paramiz.hKB;
        if (localObject1 != null) {
          ((iz.a)localObject1).hKE = false;
        }
        paramiz = paramiz.hKB;
        if (paramiz != null) {
          paramiz.hKD = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.FinderLiveService.checkDeviceLsn.1
 * JD-Core Version:    0.7.0.1
 */