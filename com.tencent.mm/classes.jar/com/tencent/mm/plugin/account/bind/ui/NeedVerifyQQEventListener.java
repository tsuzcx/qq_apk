package com.tencent.mm.plugin.account.bind.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pb;
import com.tencent.mm.autogen.a.pb.a;
import com.tencent.mm.sdk.event.IListener;

public class NeedVerifyQQEventListener
  extends IListener<pb>
  implements e.a
{
  private pb pRs;
  
  public NeedVerifyQQEventListener(q paramq)
  {
    super(paramq);
    AppMethodBeat.i(304892);
    this.__eventId = pb.class.getName().hashCode();
    AppMethodBeat.o(304892);
  }
  
  public final void bWD()
  {
    AppMethodBeat.i(110173);
    if ((this.pRs != null) && (this.pRs.hRT.hRV != null))
    {
      this.pRs.hRU.hCQ = false;
      this.pRs.hRT.hRV.run();
      this.pRs = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.pRs == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.pRs.hRT.hRV == null)
    {
      this.pRs = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.pRs.hRU.hCQ = true;
      this.pRs.hRT.hRV.run();
      this.pRs = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.pRs.hRU.hCQ = false;
    this.pRs.hRT.hRV.run();
    this.pRs = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.NeedVerifyQQEventListener
 * JD-Core Version:    0.7.0.1
 */