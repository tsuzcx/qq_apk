package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "amountCnt", "", "giftCnt", "", "wecoinHotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "(IJLcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;)V", "getAmountCnt", "()I", "setAmountCnt", "(I)V", "getGiftCnt", "()J", "setGiftCnt", "(J)V", "getWecoinHotInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  implements cc
{
  public int EDf;
  public long EDg;
  public final bmd EDh;
  
  public as(int paramInt, long paramLong, bmd parambmd)
  {
    AppMethodBeat.i(332076);
    this.EDf = paramInt;
    this.EDg = paramLong;
    this.EDh = parambmd;
    AppMethodBeat.o(332076);
  }
  
  public final int a(k paramk)
  {
    Object localObject = null;
    AppMethodBeat.i(332101);
    s.u(paramk, "obj");
    String str;
    if ((paramk instanceof boc))
    {
      paramk = (boc)paramk;
      if (paramk == null) {
        break label97;
      }
      str = paramk.username;
      paramk = this.EDh.Ddj;
      if (paramk != null) {
        break label68;
      }
      paramk = localObject;
    }
    for (;;)
    {
      if (!Util.isEqual(str, paramk)) {
        break label90;
      }
      AppMethodBeat.o(332101);
      return 0;
      paramk = null;
      break;
      label68:
      FinderContact localFinderContact = paramk.contact;
      paramk = localObject;
      if (localFinderContact != null) {
        paramk = localFinderContact.username;
      }
    }
    label90:
    AppMethodBeat.o(332101);
    return -1;
    label97:
    AppMethodBeat.o(332101);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332085);
    long l = hashCode();
    AppMethodBeat.o(332085);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332091);
    int i = as.class.hashCode();
    AppMethodBeat.o(332091);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.as
 * JD-Core Version:    0.7.0.1
 */