package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$3
  implements c.a
{
  a$3(a parama) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(113591);
    ab.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[] { paramAddr.toString() });
    this.ofz.ofk = paramAddr;
    String str = paramAddr.agM();
    this.ofz.ofn.cDl = this.ofz.activity.getResources().getString(2131301088);
    if ((paramAddr.tag != null) && (paramAddr.tag.equals(this.ofz.ofn.nZU))) {
      this.ofz.ofn.nZY = str;
    }
    for (;;)
    {
      if ((paramAddr.tag != null) && (this.ofz.ofq.containsKey(paramAddr.tag)))
      {
        paramAddr = (c)this.ofz.ofq.get(paramAddr.tag);
        paramAddr.setText(paramAddr.getPreText() + str);
      }
      AppMethodBeat.o(113591);
      return;
      if (!bo.isNullOrNil(paramAddr.fBq)) {
        this.ofz.ofo.ofB.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.a.3
 * JD-Core Version:    0.7.0.1
 */