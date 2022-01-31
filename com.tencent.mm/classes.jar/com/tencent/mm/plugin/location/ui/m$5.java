package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.y;

final class m$5
  implements i.a
{
  m$5(m paramm) {}
  
  public final void u(double paramDouble)
  {
    if (m.d(this.lHu) != null)
    {
      y.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramDouble) });
      m.d(this.lHu).v(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.5
 * JD-Core Version:    0.7.0.1
 */