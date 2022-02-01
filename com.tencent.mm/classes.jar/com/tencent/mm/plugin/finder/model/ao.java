package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "amountCnt", "", "giftCnt", "", "wecoinHotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "(IJLcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;)V", "getAmountCnt", "()I", "setAmountCnt", "(I)V", "getGiftCnt", "()J", "setGiftCnt", "(J)V", "getWecoinHotInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ao
  implements bu
{
  public int zAQ;
  public long zAR;
  public final bcc zAS;
  
  public ao(int paramInt, long paramLong, bcc parambcc)
  {
    AppMethodBeat.i(277217);
    this.zAQ = paramInt;
    this.zAR = paramLong;
    this.zAS = parambcc;
    AppMethodBeat.o(277217);
  }
  
  public final int a(k paramk)
  {
    Object localObject1 = null;
    AppMethodBeat.i(277215);
    p.k(paramk, "obj");
    if (!(paramk instanceof bdj)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (bdj)paramk;
      if (paramk != null)
      {
        String str = paramk.username;
        Object localObject2 = this.zAS.yYy;
        paramk = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((aza)localObject2).contact;
          paramk = localObject1;
          if (localObject2 != null) {
            paramk = ((FinderContact)localObject2).username;
          }
        }
        if (Util.isEqual(str, paramk))
        {
          AppMethodBeat.o(277215);
          return 0;
        }
        AppMethodBeat.o(277215);
        return -1;
      }
      AppMethodBeat.o(277215);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(277214);
    int i = ao.class.hashCode();
    AppMethodBeat.o(277214);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(277213);
    long l = hashCode();
    AppMethodBeat.o(277213);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ao
 * JD-Core Version:    0.7.0.1
 */