package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sy;
import com.tencent.mm.autogen.a.sy.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class RcptGetAddrEventListener
  extends IListener<sy>
  implements h
{
  private sy qhJ;
  private c qhK;
  
  public RcptGetAddrEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161286);
    this.__eventId = sy.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private boolean a(sy paramsy)
  {
    AppMethodBeat.i(20793);
    if ((paramsy instanceof sy))
    {
      this.qhJ = paramsy;
      bh.aZW().a(417, this);
      paramsy = new e(this.qhJ.hWr.url, this.qhJ.hWr.appId, 1);
      bh.aZW().a(paramsy, 0);
    }
    AppMethodBeat.o(20793);
    return true;
  }
  
  private void ab(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    Log.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.qhJ.hWs.errCode = paramInt;
    if (paramInt != 0) {
      this.qhJ.hWs.hWt = false;
    }
    for (;;)
    {
      if (this.qhJ.callback != null) {
        this.qhJ.callback.run();
      }
      this.qhJ = null;
      bh.aZW().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        g.l(this.qhK);
        this.qhJ.hWs.hWt = false;
      }
      else
      {
        g.k(this.qhK);
        this.qhJ.hWs.hWt = true;
        com.tencent.mm.plugin.address.a.a.bZe();
        com.tencent.mm.plugin.address.d.a locala = com.tencent.mm.plugin.address.a.a.bZg().qhS;
        if (locala.qib.size() > 0)
        {
          b localb = (b)locala.qib.getFirst();
          this.qhJ.hWs.hWu = localb.qik;
          this.qhJ.hWs.userName = localb.qii;
          this.qhJ.hWs.hWv = localb.qij;
          this.qhJ.hWs.hWw = localb.qig;
          this.qhJ.hWs.hWx = localb.qid;
          this.qhJ.hWs.hWy = localb.qie;
          this.qhJ.hWs.hWz = localb.qif;
          this.qhJ.hWs.hWA = localb.qil;
          this.qhJ.hWs.hWB = localb.qih;
          this.qhJ.hWs.hWC = locala.qib;
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(20794);
    Log.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramp instanceof e))
    {
      if (paramInt2 == 0)
      {
        ab(paramInt2, true);
        AppMethodBeat.o(20794);
        return;
      }
      ab(paramInt2, false);
    }
    AppMethodBeat.o(20794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.RcptGetAddrEventListener
 * JD-Core Version:    0.7.0.1
 */