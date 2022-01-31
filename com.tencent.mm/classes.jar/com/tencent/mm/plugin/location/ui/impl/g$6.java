package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.plugin.location.ui.i.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

final class g$6
  implements i.a
{
  g$6(g paramg) {}
  
  public final void GE(String paramString)
  {
    Object localObject = (TrackPoint)this.lKi.lIb.lFm.getViewByItag(paramString);
    if (localObject != null)
    {
      ((TrackPoint)localObject).set2Top();
      this.lKi.lIb.lFm.invalidate();
      localObject = this.lKi.lJV;
      if (bk.bl(paramString)) {
        break label224;
      }
      if ((((m)localObject).lDX == null) || (!paramString.equals(((m)localObject).lDX.sxM))) {
        break label140;
      }
      paramString = new com.tencent.mm.plugin.location.model.d(((m)localObject).lDX.tRA.sDm, ((m)localObject).lDX.tRA.sDn);
    }
    for (;;)
    {
      if (paramString != null) {
        this.lKi.lIb.lFm.getIController().animateTo(paramString.lCJ, paramString.lCK);
      }
      return;
      label140:
      if ((((m)localObject).lHb != null) && (((m)localObject).lHb.size() > 0))
      {
        localObject = ((m)localObject).lHb.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ccg localccg = (ccg)((Iterator)localObject).next();
            if (localccg.sxM.equals(paramString))
            {
              paramString = new com.tencent.mm.plugin.location.model.d(localccg.tRA.sDm, localccg.tRA.sDn);
              break;
            }
          }
        }
      }
      label224:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.6
 * JD-Core Version:    0.7.0.1
 */