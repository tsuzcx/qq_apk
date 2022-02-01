package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bjy;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "setCard", "cardId", "", "getCardId", "()J", "setCardId", "(J)V", "endAction", "", "getEndAction", "()I", "setEndAction", "(I)V", "endActionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "getEndActionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "setEndActionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;)V", "endWording", "", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "position", "getPosition", "setPosition", "streamCardTitle", "getStreamCardTitle", "setStreamCardTitle", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ao
  implements bu
{
  public int position;
  public bjq xBJ;
  public int xBK;
  public String xBL;
  public String xBM;
  public long xBN;
  public bjy xBO;
  
  public ao(bjy parambjy)
  {
    AppMethodBeat.i(235870);
    this.xBO = parambjy;
    this.xBL = "";
    this.position = -1;
    this.xBM = "";
    AppMethodBeat.o(235870);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(235868);
    p.k(paramk, "obj");
    if (((paramk instanceof bjp)) && (((bjp)paramk).zAO == this.xBO.SUS) && (((bjp)paramk).xBI == this.xBO.style))
    {
      AppMethodBeat.o(235868);
      return 0;
    }
    AppMethodBeat.o(235868);
    return -1;
  }
  
  public final int bAQ()
  {
    return 2014;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(235866);
    long l = ("FinderStreamCardTxtFeed#" + this.xBO.SUS).hashCode();
    AppMethodBeat.o(235866);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ao
 * JD-Core Version:    0.7.0.1
 */