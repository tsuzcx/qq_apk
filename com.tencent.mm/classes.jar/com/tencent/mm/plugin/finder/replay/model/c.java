package com.tencent.mm.plugin.finder.replay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/FinderReplayLiveData;", "", "()V", "baseData", "Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;", "getBaseData", "()Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;", "setBaseData", "(Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;)V", "curLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getCurLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setCurLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "value", "", "curPos", "getCurPos", "()I", "setCurPos", "(I)V", "fromFloatInfo", "Lkotlin/Pair;", "", "", "getFromFloatInfo", "()Lkotlin/Pair;", "setFromFloatInfo", "(Lkotlin/Pair;)V", "liveDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLiveDataList", "()Ljava/util/ArrayList;", "setLiveDataList", "(Ljava/util/ArrayList;)V", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a FlS;
  public int CEY;
  public ArrayList<f> Ebx;
  public bug FlT;
  public r<Long, Boolean> FlU;
  
  static
  {
    AppMethodBeat.i(332766);
    FlS = new a((byte)0);
    AppMethodBeat.o(332766);
  }
  
  public c()
  {
    AppMethodBeat.i(332751);
    this.FlT = new bug();
    this.CEY = this.FlT.aabZ;
    this.Ebx = new ArrayList();
    AppMethodBeat.o(332751);
  }
  
  private f exW()
  {
    int j = 0;
    AppMethodBeat.i(332762);
    int k = this.Ebx.size();
    int m = this.CEY;
    int i = j;
    if (m >= 0)
    {
      i = j;
      if (m < k) {
        i = 1;
      }
    }
    if (i != 0)
    {
      f localf = (f)this.Ebx.get(this.CEY);
      AppMethodBeat.o(332762);
      return localf;
    }
    AppMethodBeat.o(332762);
    return null;
  }
  
  public final void PV(int paramInt)
  {
    com.tencent.mm.plugin.finder.replay.viewmodel.c localc = null;
    AppMethodBeat.i(332779);
    Log.i("FinderReplayLiveData", s.X("set curPos:", Integer.valueOf(paramInt)));
    Object localObject = exW();
    if (localObject == null) {}
    for (;;)
    {
      if (localc != null) {
        localc.CEY = paramInt;
      }
      this.CEY = paramInt;
      AppMethodBeat.o(332779);
      return;
      localObject = ((f)localObject).BxG;
      if (localObject != null) {
        localc = (com.tencent.mm.plugin.finder.replay.viewmodel.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      }
    }
  }
  
  public final void a(bug parambug)
  {
    AppMethodBeat.i(332771);
    s.u(parambug, "<set-?>");
    this.FlT = parambug;
    AppMethodBeat.o(332771);
  }
  
  public final void an(ArrayList<f> paramArrayList)
  {
    AppMethodBeat.i(332784);
    s.u(paramArrayList, "<set-?>");
    this.Ebx = paramArrayList;
    AppMethodBeat.o(332784);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/FinderReplayLiveData$Companion;", "", "()V", "TAG", "", "parseBaseData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/ArrayList;", "baseData", "Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;", "curLiveId", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ArrayList<f> b(bug parambug)
    {
      AppMethodBeat.i(332780);
      s.u(parambug, "baseData");
      ArrayList localArrayList = new ArrayList();
      parambug = parambug.ZIQ;
      s.s(parambug, "baseData.objects");
      parambug = ((Iterable)parambug).iterator();
      while (parambug.hasNext())
      {
        Object localObject2 = (FinderObject)parambug.next();
        Object localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.k((FinderObject)localObject2);
        if (localObject1 != null)
        {
          localObject2 = ((FinderObject)localObject2).liveInfo;
          if (localObject2 != null)
          {
            localObject2 = ((bip)localObject2).ZSm;
            if (localObject2 != null)
            {
              int i = ((blz)localObject2).ZUJ;
              ((com.tencent.mm.plugin.finder.replay.viewmodel.c)((f)localObject1).BxG.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).a(i, Boolean.TRUE);
            }
          }
          localArrayList.add(localObject1);
        }
      }
      AppMethodBeat.o(332780);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.model.c
 * JD-Core Version:    0.7.0.1
 */