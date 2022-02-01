package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.l.c;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager$notifyPrefetch$1$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
public final class d$h$2
  implements l.c
{
  d$h$2(q paramq) {}
  
  public final boolean c(int paramInt1, int paramInt2, cqk paramcqk)
  {
    AppMethodBeat.i(178158);
    k.h(paramcqk, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramcqk instanceof aoe))
      {
        this.reJ.a(com.tencent.mm.loader.g.h.gLN);
        AppMethodBeat.o(178158);
        return true;
      }
      if (((aoe)paramcqk).EHk == 1)
      {
        ac.i("Finder.RedDotManager", "[isFetchConsume] forceChangePrefetchResult=" + ((aoe)paramcqk).EHk);
        AppMethodBeat.o(178158);
        return false;
      }
      Object localObject = b.qWt;
      paramcqk = ((aoe)paramcqk).object;
      k.g(paramcqk, "resp.`object`");
      paramcqk = (FinderObject)j.iP((List)paramcqk);
      boolean bool2;
      if (paramcqk != null)
      {
        paramcqk = paramcqk.contact;
        if (paramcqk != null)
        {
          paramcqk = paramcqk.username;
          bool2 = b.a.adk(paramcqk);
          paramcqk = this.reN.reD.adx("FinderEntrance");
          if (paramcqk == null) {
            break label308;
          }
          paramcqk = paramcqk.field_ctrInfo;
          if ((paramcqk == null) || (paramcqk.type != 3)) {
            break label308;
          }
        }
      }
      long l;
      label308:
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.i("Finder.RedDotManager", "[isFetchConsume] isFollow=" + bool2 + " hasShowFollowRedDot=" + bool1);
        l = ce.azJ();
        paramcqk = i.rfA;
        l -= i.cul();
        if (!bool2) {
          break label314;
        }
        paramcqk = i.rfA;
        if (l >= i.cub()) {
          break label314;
        }
        paramcqk = new StringBuilder("[notifyPrefetch] diffTime=").append(l).append(" newFollowTipsEnterInterval=");
        localObject = i.rfA;
        ac.w("Finder.RedDotManager", i.cub());
        this.reJ.a(com.tencent.mm.loader.g.h.gLN);
        AppMethodBeat.o(178158);
        return true;
        paramcqk = null;
        break;
      }
      label314:
      if (!bool2)
      {
        paramcqk = i.rfA;
        if (l < i.cuf())
        {
          paramcqk = new StringBuilder("[notifyPrefetch] diffTime=").append(l).append(" newFollowTipsEnterInterval=");
          localObject = i.rfA;
          ac.w("Finder.RedDotManager", i.cuf());
          this.reJ.a(com.tencent.mm.loader.g.h.gLN);
          AppMethodBeat.o(178158);
          return true;
        }
      }
      if ((!bool2) && (bool1))
      {
        ac.w("Finder.RedDotManager", "[notifyPrefetch] ignore this prefetch...");
        this.reJ.a(com.tencent.mm.loader.g.h.gLN);
        AppMethodBeat.o(178158);
        return true;
      }
    }
    AppMethodBeat.o(178158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d.h.2
 * JD-Core Version:    0.7.0.1
 */