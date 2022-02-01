package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bke;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "bulletCommetList", "", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "kotlin.jvm.PlatformType", "", "getBulletCommetList", "()Ljava/util/List;", "setBulletCommetList", "(Ljava/util/List;)V", "commentReachLastOnViewDettach", "", "getCommentReachLastOnViewDettach", "()Z", "setCommentReachLastOnViewDettach", "(Z)V", "commentReadCount", "", "getCommentReadCount", "()J", "setCommentReadCount", "(J)V", "curVisiableFirstPosition", "", "getCurVisiableFirstPosition", "()I", "setCurVisiableFirstPosition", "(I)V", "curVisiableLastPosition", "getCurVisiableLastPosition", "setCurVisiableLastPosition", "descFoldingState", "", "getDescFoldingState", "()Ljava/util/Map;", "hasUnReadAtWxMeMsg", "getHasUnReadAtWxMeMsg", "setHasUnReadAtWxMeMsg", "highLightCheerList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "getHighLightCheerList", "setHighLightCheerList", "msgList", "getMsgList", "setMsgList", "showedMsgCache", "", "getShowedMsgCache", "()Ljava/util/Set;", "topMsgList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "getTopMsgList", "setTopMsgList", "addLiveRoomCommentMsg", "", "liveRoomComment", "addLiveRoomLikeMsg", "liveRoomLike", "addVisitorAnonymousMsg", "isAnonymous", "dropMsgToOffset", "lastOffset", "isDescFolding", "msgPos", "markDescFold", "isFolding", "onCleared", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c<a>
{
  public static final l.a EgD;
  public List<aq> EgE;
  public List<aq> EgF;
  public List<bke> EgG;
  public List<bdm> EgH;
  public int EgI;
  public int EgJ;
  public boolean EgK;
  public long EgL;
  public boolean EgM;
  public final Set<Integer> EgN;
  public final Map<Integer, Boolean> EgO;
  
  static
  {
    AppMethodBeat.i(356729);
    EgD = new l.a((byte)0);
    AppMethodBeat.o(356729);
  }
  
  public l(a parama)
  {
    super(parama);
    AppMethodBeat.i(356723);
    this.EgE = Collections.synchronizedList((List)new ArrayList());
    this.EgF = Collections.synchronizedList((List)new ArrayList());
    this.EgG = Collections.synchronizedList((List)new ArrayList());
    this.EgH = Collections.synchronizedList((List)new ArrayList());
    this.EgI = -1;
    this.EgJ = -1;
    this.EgK = true;
    this.EgN = ((Set)new LinkedHashSet());
    this.EgO = ((Map)new LinkedHashMap());
    AppMethodBeat.o(356723);
  }
  
  public final void P(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(356736);
    this.EgO.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(356736);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356743);
    this.EgE.clear();
    this.EgF.clear();
    this.EgG.clear();
    this.EgH.clear();
    this.EgN.clear();
    this.EgO.clear();
    this.EgK = true;
    this.EgL = 0L;
    AppMethodBeat.o(356743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.l
 * JD-Core Version:    0.7.0.1
 */