package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class a$3
  implements b.a
{
  a$3(a parama) {}
  
  public final void b(Addr paramAddr)
  {
    y.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAddr.toString() });
    this.lIm.lHX = paramAddr;
    String str = paramAddr.elb;
    str = paramAddr.NY();
    this.lIm.lIa.bVA = this.lIm.activity.getResources().getString(a.h.location_conversation);
    if ((paramAddr.tag != null) && (paramAddr.tag.equals(this.lIm.lIa.lCI))) {
      this.lIm.lIa.lCM = str;
    }
    for (;;)
    {
      if ((paramAddr.tag != null) && (this.lIm.lId.containsKey(paramAddr.tag)))
      {
        c localc = (c)this.lIm.lId.get(paramAddr.tag);
        localc.setText(localc.getPreText() + str);
      }
      float f = paramAddr.ell;
      f = paramAddr.elk;
      return;
      if (!bk.bl(paramAddr.ekZ)) {
        this.lIm.lIb.lIo.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.3
 * JD-Core Version:    0.7.0.1
 */