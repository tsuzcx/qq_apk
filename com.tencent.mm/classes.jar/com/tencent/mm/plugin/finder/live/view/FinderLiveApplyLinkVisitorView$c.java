package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.bgh;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkVisitorView$loadApplyUserDescInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveApplyLinkVisitorView$c
  implements s.a
{
  FinderLiveApplyLinkVisitorView$c(FinderLiveApplyLinkVisitorView paramFinderLiveApplyLinkVisitorView, a<ah> parama) {}
  
  public final void a(int paramInt1, int paramInt2, bfp parambfp)
  {
    AppMethodBeat.i(357606);
    s.u(parambfp, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      parambfp = parambfp.ZPy;
      if (parambfp != null)
      {
        parambfp = (Iterable)parambfp;
        FinderLiveApplyLinkVisitorView localFinderLiveApplyLinkVisitorView = this.DLq;
        a locala = this.nBK;
        Iterator localIterator = parambfp.iterator();
        while (localIterator.hasNext())
        {
          bgh localbgh = (bgh)localIterator.next();
          parambfp = localbgh.contact;
          if (parambfp != null)
          {
            Object localObject = (CharSequence)parambfp.username;
            if ((localObject == null) || (((CharSequence)localObject).length() == 0))
            {
              paramInt1 = 1;
              label111:
              if (paramInt1 != 0) {
                break label193;
              }
              if (localbgh.ZJX == null) {
                break label195;
              }
              paramInt1 = 3;
            }
            for (;;)
            {
              Map localMap = (Map)FinderLiveApplyLinkVisitorView.c(localFinderLiveApplyLinkVisitorView);
              localObject = parambfp.username;
              parambfp = (bfp)localObject;
              if (localObject == null) {
                parambfp = "";
              }
              localMap.put(parambfp, new i(paramInt1, localbgh.ZJX));
              if (locala == null) {
                break;
              }
              locala.invoke();
              break;
              paramInt1 = 0;
              break label111;
              label193:
              break;
              label195:
              if (d.ee(localbgh.ZPS, 4)) {
                paramInt1 = 1;
              } else if (parambfp.followFlag == 1) {
                paramInt1 = 2;
              } else {
                paramInt1 = 0;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(357606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkVisitorView.c
 * JD-Core Version:    0.7.0.1
 */