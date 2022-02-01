package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.q.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.aza;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$loadApplyUserDescInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder_release"})
public final class FinderLiveApplyLinkVisitorView$c
  implements q.a
{
  FinderLiveApplyLinkVisitorView$c(a parama) {}
  
  public final void a(int paramInt1, int paramInt2, ayo paramayo)
  {
    AppMethodBeat.i(273068);
    p.k(paramayo, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramayo = paramayo.SKF;
      if (paramayo != null)
      {
        Iterator localIterator = ((Iterable)paramayo).iterator();
        while (localIterator.hasNext())
        {
          aza localaza = (aza)localIterator.next();
          paramayo = localaza.contact;
          if (paramayo != null)
          {
            Object localObject = (CharSequence)paramayo.username;
            if ((localObject == null) || (((CharSequence)localObject).length() == 0))
            {
              paramInt1 = 1;
              label97:
              if (paramInt1 != 0) {
                break label184;
              }
              if (localaza.SHb == null) {
                break label186;
              }
              paramInt1 = 3;
            }
            for (;;)
            {
              Map localMap = (Map)FinderLiveApplyLinkVisitorView.f(this.ySX);
              localObject = paramayo.username;
              paramayo = (ayo)localObject;
              if (localObject == null) {
                paramayo = "";
              }
              localMap.put(paramayo, new i(paramInt1, localaza.SHb));
              paramayo = this.kWs;
              if (paramayo == null) {
                break;
              }
              paramayo.invoke();
              break;
              paramInt1 = 0;
              break label97;
              label184:
              break;
              label186:
              if (d.dr(localaza.SKT, 4)) {
                paramInt1 = 1;
              } else if (paramayo.followFlag == 1) {
                paramInt1 = 2;
              } else {
                paramInt1 = 0;
              }
            }
          }
        }
        AppMethodBeat.o(273068);
        return;
      }
    }
    AppMethodBeat.o(273068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.c
 * JD-Core Version:    0.7.0.1
 */