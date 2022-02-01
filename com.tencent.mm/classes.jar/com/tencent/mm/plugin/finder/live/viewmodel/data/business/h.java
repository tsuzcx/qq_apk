package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d;
import com.tencent.mm.plugin.finder.live.model.ao;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "bulletCommetList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "kotlin.jvm.PlatformType", "", "getBulletCommetList", "()Ljava/util/List;", "setBulletCommetList", "(Ljava/util/List;)V", "commentReachLastOnViewDettach", "", "getCommentReachLastOnViewDettach", "()Z", "setCommentReachLastOnViewDettach", "(Z)V", "commentReadCount", "", "getCommentReadCount", "()J", "setCommentReadCount", "(J)V", "curVisiableFirstPosition", "", "getCurVisiableFirstPosition", "()I", "setCurVisiableFirstPosition", "(I)V", "curVisiableLastPosition", "getCurVisiableLastPosition", "setCurVisiableLastPosition", "highLightCheerList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "getHighLightCheerList", "setHighLightCheerList", "msgList", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "getMsgList", "setMsgList", "topMsgList", "getTopMsgList", "setTopMsgList", "addLiveRoomCommentMsg", "", "liveRoomComment", "addLiveRoomLikeMsg", "liveRoomLike", "onCleared", "updateLiveMsgCommentState", "Ljava/util/LinkedList;", "Companion", "plugin-finder-base_release"})
public final class h
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a ziy;
  public List<ao> ziq;
  public List<bbd> zir;
  public List<bbd> zis;
  public List<axe> zit;
  public int ziu;
  public int ziv;
  public boolean ziw;
  public long zix;
  
  static
  {
    AppMethodBeat.i(261138);
    ziy = new a((byte)0);
    AppMethodBeat.o(261138);
  }
  
  public h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(261136);
    this.ziq = Collections.synchronizedList((List)new ArrayList());
    this.zir = Collections.synchronizedList((List)new ArrayList());
    this.zis = Collections.synchronizedList((List)new ArrayList());
    this.zit = Collections.synchronizedList((List)new ArrayList());
    this.ziu = -1;
    this.ziv = -1;
    this.ziw = true;
    AppMethodBeat.o(261136);
  }
  
  public final void aH(LinkedList<bbd> paramLinkedList)
  {
    AppMethodBeat.i(261132);
    p.k(paramLinkedList, "msgList");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    if (paramLinkedList.hasNext())
    {
      bbd localbbd = (bbd)paramLinkedList.next();
      switch (localbbd.type)
      {
      }
      for (;;)
      {
        break;
        i = localbbd.type;
        ((b)business(b.class)).zfc = true;
        break;
        i = localbbd.type;
        ((b)business(b.class)).zfc = false;
      }
    }
    if (i == 10007) {
      ((d)com.tencent.mm.kernel.h.ae(d.class)).bvU();
    }
    Log.i("MMFinder.LiveMsgSlice", "updateLiveMsg commentType:".concat(String.valueOf(i)));
    AppMethodBeat.o(261132);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(261133);
    this.ziq.clear();
    this.zir.clear();
    this.zis.clear();
    this.zit.clear();
    this.ziw = true;
    this.zix = 0L;
    AppMethodBeat.o(261133);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.h
 * JD-Core Version:    0.7.0.1
 */