package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.i.a;
import com.tencent.mm.plugin.finder.utils.aq;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doCreateLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
public final class e$h
  implements i.a
{
  e$h(u paramu) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, art paramart)
  {
    AppMethodBeat.i(291242);
    p.k(paramart, "resp");
    Object localObject3;
    Boolean localBoolean1;
    Boolean localBoolean2;
    Object localObject1;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.i(this.ydI.TAG, "launch live room failed");
      if (paramInt2 == -200008)
      {
        localObject3 = this.ydM;
        if (localObject3 != null)
        {
          localBoolean1 = Boolean.FALSE;
          localBoolean2 = Boolean.TRUE;
          localObject2 = paramart.SFg;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (paramString != null) {
            break label291;
          }
        }
      }
    }
    label282:
    label291:
    for (Object localObject2 = "";; localObject2 = paramString)
    {
      ((u)localObject3).a(localBoolean1, localBoolean2, localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject2, paramart);
      do
      {
        paramart = aq.AIJ;
        localObject1 = aq.efK();
        paramart = paramString;
        if (paramString == null) {
          paramart = "";
        }
        e.a(this.ydI);
        aq.hw((String)localObject1, paramart);
        AppMethodBeat.o(291242);
        return;
        localObject2 = this.ydM;
      } while (localObject2 == null);
      localObject3 = Boolean.FALSE;
      if (paramString == null) {}
      for (localObject1 = "";; localObject1 = paramString)
      {
        ((u)localObject2).a(localObject3, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1, paramart);
        break;
        e.a(this.ydI, paramart);
        localObject1 = this.ydM;
        if (localObject1 != null)
        {
          localObject2 = Boolean.TRUE;
          localObject3 = Boolean.FALSE;
          if (paramString != null) {
            break label282;
          }
          paramString = "";
        }
        for (;;)
        {
          ((u)localObject1).a(localObject2, localObject3, "", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramart);
          AppMethodBeat.o(291242);
          return;
          AppMethodBeat.o(291242);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e.h
 * JD-Core Version:    0.7.0.1
 */