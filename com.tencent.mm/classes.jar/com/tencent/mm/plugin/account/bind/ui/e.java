package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nt;
import com.tencent.mm.f.a.nt.a;
import com.tencent.mm.sdk.event.IListener;

public final class e
  extends IListener<nt>
  implements f.a
{
  private nt mUL;
  
  public e()
  {
    AppMethodBeat.i(161741);
    this.__eventId = nt.class.getName().hashCode();
    AppMethodBeat.o(161741);
  }
  
  public final void bxO()
  {
    AppMethodBeat.i(110173);
    if ((this.mUL != null) && (this.mUL.fMj.fMl != null))
    {
      this.mUL.fMk.fyl = false;
      this.mUL.fMj.fMl.run();
      this.mUL = null;
    }
    AppMethodBeat.o(110173);
  }
  
  public final boolean eg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110172);
    if (this.mUL == null)
    {
      AppMethodBeat.o(110172);
      return false;
    }
    if (this.mUL.fMj.fMl == null)
    {
      this.mUL = null;
      AppMethodBeat.o(110172);
      return false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mUL.fMk.fyl = true;
      this.mUL.fMj.fMl.run();
      this.mUL = null;
      AppMethodBeat.o(110172);
      return true;
    }
    this.mUL.fMk.fyl = false;
    this.mUL.fMj.fMl.run();
    this.mUL = null;
    AppMethodBeat.o(110172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.e
 * JD-Core Version:    0.7.0.1
 */