package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "amountCnt", "", "wecoinHotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;)V", "getAmountCnt", "()I", "setAmountCnt", "(I)V", "getWecoinHotInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class am
  implements bo
{
  public final axa uOA;
  public int uOz;
  
  public am(int paramInt, axa paramaxa)
  {
    AppMethodBeat.i(248779);
    this.uOz = paramInt;
    this.uOA = paramaxa;
    AppMethodBeat.o(248779);
  }
  
  public final int a(i parami)
  {
    Object localObject1 = null;
    AppMethodBeat.i(248778);
    p.h(parami, "obj");
    if (!(parami instanceof axs)) {
      parami = null;
    }
    for (;;)
    {
      parami = (axs)parami;
      if (parami != null)
      {
        String str = parami.username;
        Object localObject2 = this.uOA.uBm;
        parami = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((avn)localObject2).contact;
          parami = localObject1;
          if (localObject2 != null) {
            parami = ((FinderContact)localObject2).username;
          }
        }
        if (Util.isEqual(str, parami))
        {
          AppMethodBeat.o(248778);
          return 0;
        }
        AppMethodBeat.o(248778);
        return -1;
      }
      AppMethodBeat.o(248778);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248777);
    int i = am.class.hashCode();
    AppMethodBeat.o(248777);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248776);
    long l = hashCode();
    AppMethodBeat.o(248776);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.am
 * JD-Core Version:    0.7.0.1
 */