package com.tencent.mm.plugin.finder.replay;

import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.replay.model.d;
import com.tencent.mm.plugin.finder.replay.model.e;
import com.tencent.mm.plugin.finder.replay.viewmodel.c;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess;", "", "curLiveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "scene", "", "msgCallBack", "Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetCallback;", "processCallback", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess$LiveMsgOffsetProcess;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;ILcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetCallback;Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess$LiveMsgOffsetProcess;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCurLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getScene", "()I", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "dropMsg", "", "offset", "selectLiveMsg", "liveId", "", "startReplayMsg", "fromFloat", "", "trackMessage", "validCheck", "msg", "LiveMsgOffsetProcess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CDN;
  private final d FjN;
  private final a FjO;
  private final String TAG;
  private final int scene;
  
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt, d paramd, a parama1)
  {
    AppMethodBeat.i(332644);
    this.CDN = parama;
    this.scene = paramInt;
    this.FjN = paramd;
    this.FjO = parama1;
    this.TAG = "FinderLiveMsgOffsetProcess";
    parama = (com.tencent.mm.plugin.finder.replay.viewmodel.a)business(com.tencent.mm.plugin.finder.replay.viewmodel.a.class);
    if (parama != null)
    {
      paramInt = this.scene;
      parama.scene = paramInt;
      Log.i("LiveMsgOffsetSlice", s.X("init scene:", Integer.valueOf(paramInt)));
    }
    AppMethodBeat.o(332644);
  }
  
  private <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(332649);
    s.u(paramClass, "bu");
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.CDN;
    if (locala == null)
    {
      AppMethodBeat.o(332649);
      return null;
    }
    paramClass = locala.business(paramClass);
    AppMethodBeat.o(332649);
    return paramClass;
  }
  
  public final void ap(int paramInt, long paramLong)
  {
    AppMethodBeat.i(332669);
    Object localObject1 = (f)business(f.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).liveInfo;
      if ((localObject1 != null) && (paramLong == ((bip)localObject1).liveId))
      {
        i = 1;
        if (i != 0) {
          break label170;
        }
        localObject2 = this.TAG;
        localObject3 = new StringBuilder().append("selectLiveMsg").append(" remote liveId:").append(paramLong).append(",local liveId:");
        localObject1 = (f)business(f.class);
        if (localObject1 != null) {
          break label139;
        }
        localObject1 = null;
        label104:
        Log.e((String)localObject2, localObject1);
      }
    }
    label139:
    label170:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label176;
      }
      AppMethodBeat.o(332669);
      return;
      i = 0;
      break;
      localObject1 = ((f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label104;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break label104;
    }
    label176:
    localObject1 = this.FjO;
    if (localObject1 != null) {
      ((a)localObject1).RJ(paramInt);
    }
    localObject1 = (c)business(c.class);
    if (localObject1 == null)
    {
      i = 0;
      localObject3 = new e(paramLong, paramInt, i, true);
      localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.a)business(com.tencent.mm.plugin.finder.replay.viewmodel.a.class);
      if (localObject1 != null)
      {
        localObject2 = this.FjN;
        s.u(localObject3, "msgParams");
        paramLong = ((e)localObject3).liveId;
        if (paramLong == ((f)((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).business(f.class)).liveInfo.liveId) {
          break label467;
        }
        Log.e("LiveMsgOffsetSlice", "trackMessage" + " error, remote liveId:" + paramLong + ",local liveId" + ((f)((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).business(f.class)).liveInfo.liveId);
        paramInt = 0;
        label339:
        if (paramInt != 0)
        {
          ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmA = ((e)localObject3);
          ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmB = ((d)localObject2);
          localObject3 = new StringBuilder("trackMessage msgParams:").append(localObject3).append(",startOffsetSec:").append(((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmD).append(", callback:");
          if (localObject2 == null) {
            break label472;
          }
        }
      }
    }
    label467:
    label472:
    for (paramInt = localObject2.hashCode();; paramInt = 0)
    {
      Log.i("LiveMsgOffsetSlice", paramInt);
      ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmC.clear();
      ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).aI(((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmA.FlV + ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmD, ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).FmA.FlX);
      AppMethodBeat.o(332669);
      return;
      i = ((c)localObject1).total;
      break;
      paramInt = 1;
      break label339;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess$LiveMsgOffsetProcess;", "", "dropMsg", "", "offset", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void RJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.b
 * JD-Core Version:    0.7.0.1
 */