package com.tencent.mm.plugin.finder.profile.uic;

import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.live.view.convert.a;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayLiveUIC$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileReplayLiveUIC$feedChangeListener$1
  extends IListener<if>
{
  FinderProfileReplayLiveUIC$feedChangeListener$1(k paramk, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(348753);
    AppMethodBeat.o(348753);
  }
  
  private static final void a(DataBuffer paramDataBuffer, k paramk, long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(348762);
    s.u(paramDataBuffer, "$dataList");
    s.u(paramk, "this$0");
    Iterator localIterator = ((List)paramDataBuffer).iterator();
    int i = 0;
    Object localObject;
    label71:
    int j;
    if (localIterator.hasNext())
    {
      localObject = (cc)localIterator.next();
      if ((localObject instanceof ap))
      {
        localObject = (ap)localObject;
        if (localObject == null) {
          break label242;
        }
        localObject = ((ap)localObject).EDa;
        if (localObject == null) {
          break label242;
        }
        localObject = ((FinderObject)localObject).liveInfo;
        if ((localObject == null) || (((bip)localObject).liveId != paramLong)) {
          break label242;
        }
        j = 1;
        label113:
        if (j == 0) {
          break label248;
        }
        label118:
        j = k;
        if (i >= 0)
        {
          j = k;
          if (i < paramDataBuffer.size()) {
            j = 1;
          }
        }
        if (j == 0) {
          break label276;
        }
        paramDataBuffer = paramDataBuffer.remove(i);
        s.s(paramDataBuffer, "dataList.removeAt(deleteIndex)");
        paramDataBuffer = (cc)paramDataBuffer;
        localObject = k.c(paramk).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).fX(i);
        }
        localObject = a.DUC;
        if (!(paramDataBuffer instanceof ap)) {
          break label263;
        }
        paramDataBuffer = (ap)paramDataBuffer;
        label204:
        if (paramDataBuffer != null) {
          break label268;
        }
        paramDataBuffer = null;
      }
    }
    label210:
    for (paramDataBuffer = a.d(paramDataBuffer, i);; paramDataBuffer = "fail,live:" + paramLong + ",pos:" + i)
    {
      Log.i(paramk.TAG, s.X("delete replay ", paramDataBuffer));
      AppMethodBeat.o(348762);
      return;
      localObject = null;
      break label71;
      label242:
      j = 0;
      break label113;
      label248:
      i += 1;
      break;
      i = -1;
      break label118;
      paramDataBuffer = null;
      break label204;
      paramDataBuffer = paramDataBuffer.EDa;
      break label210;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileReplayLiveUIC.feedChangeListener.1
 * JD-Core Version:    0.7.0.1
 */