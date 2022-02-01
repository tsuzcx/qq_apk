package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bdb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "setCard", "cardId", "", "getCardId", "()J", "setCardId", "(J)V", "endAction", "", "getEndAction", "()I", "setEndAction", "(I)V", "endActionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "getEndActionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "setEndActionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;)V", "endWording", "", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "position", "getPosition", "setPosition", "streamCardTitle", "getStreamCardTitle", "setStreamCardTitle", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ah
  implements bo
{
  public int position;
  public bcv tQS;
  public int tQT;
  public String tQU;
  public String tQV;
  public long tQW;
  public bdb tQX;
  
  public ah(bdb parambdb)
  {
    AppMethodBeat.i(244175);
    this.tQX = parambdb;
    this.tQU = "";
    this.position = -1;
    this.tQV = "";
    AppMethodBeat.o(244175);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(244174);
    p.h(parami, "obj");
    if (((parami instanceof bcu)) && (((bcu)parami).uOx == this.tQX.LMP) && (((bcu)parami).tQR == this.tQX.style))
    {
      AppMethodBeat.o(244174);
      return 0;
    }
    AppMethodBeat.o(244174);
    return -1;
  }
  
  public final int cxn()
  {
    return 2014;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(244173);
    long l = ("FinderStreamCardTxtFeed#" + this.tQX.LMP).hashCode();
    AppMethodBeat.o(244173);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ah
 * JD-Core Version:    0.7.0.1
 */