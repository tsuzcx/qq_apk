package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwm;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "setCard", "cardId", "", "getCardId", "()J", "setCardId", "(J)V", "endAction", "", "getEndAction", "()I", "setEndAction", "(I)V", "endActionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "getEndActionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "setEndActionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;)V", "endWording", "", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "position", "getPosition", "setPosition", "streamCardTitle", "getStreamCardTitle", "setStreamCardTitle", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  implements cc
{
  public bwm AYZ;
  public String AZa;
  public String AZb;
  public int position;
  
  public av(bwm parambwm)
  {
    AppMethodBeat.i(362943);
    this.AYZ = parambwm;
    this.AZa = "";
    this.position = -1;
    this.AZb = "";
    AppMethodBeat.o(362943);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(362967);
    s.u(paramk, "obj");
    if (((paramk instanceof bwa)) && (((bwa)paramk).ECY == this.AYZ.ZVF) && (((bwa)paramk).AYX == this.AYZ.style))
    {
      AppMethodBeat.o(362967);
      return 0;
    }
    AppMethodBeat.o(362967);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(362950);
    long l = s.X("FinderStreamCardTxtFeed#", Long.valueOf(this.AYZ.ZVF)).hashCode();
    AppMethodBeat.o(362950);
    return l;
  }
  
  public final int bZB()
  {
    return 2014;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.av
 * JD-Core Version:    0.7.0.1
 */