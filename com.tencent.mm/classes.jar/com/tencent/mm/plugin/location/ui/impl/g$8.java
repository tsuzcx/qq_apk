package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.ui.i.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class g$8
  implements i.a
{
  g$8(g paramg) {}
  
  public final void Sh(String paramString)
  {
    AppMethodBeat.i(155627);
    Object localObject = (TrackPoint)this.ohw.ofo.ocA.getViewByItag(paramString);
    if (localObject != null)
    {
      ((TrackPoint)localObject).set2Top();
      this.ohw.ofo.ocA.invalidate();
      localObject = this.ohw.ohj;
      if (bo.isNullOrNil(paramString)) {
        break label234;
      }
      if ((((m)localObject).obk == null) || (!paramString.equals(((m)localObject).obk.Username))) {
        break label150;
      }
      paramString = new com.tencent.mm.plugin.location.model.d(((m)localObject).obk.xYw.wyO, ((m)localObject).obk.xYw.wyP);
    }
    for (;;)
    {
      if (paramString != null) {
        this.ohw.ofo.ocA.getIController().animateTo(paramString.nZV, paramString.nZW);
      }
      AppMethodBeat.o(155627);
      return;
      label150:
      if ((((m)localObject).oeo != null) && (((m)localObject).oeo.size() > 0))
      {
        localObject = ((m)localObject).oeo.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            cpm localcpm = (cpm)((Iterator)localObject).next();
            if (localcpm.Username.equals(paramString))
            {
              paramString = new com.tencent.mm.plugin.location.model.d(localcpm.xYw.wyO, localcpm.xYw.wyP);
              break;
            }
          }
        }
      }
      label234:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.8
 * JD-Core Version:    0.7.0.1
 */