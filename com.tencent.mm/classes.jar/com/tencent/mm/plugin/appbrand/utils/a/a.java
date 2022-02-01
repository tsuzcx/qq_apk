package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, g.a
{
  public static final c mPC;
  private final e mPD;
  private final AtomicBoolean mPE;
  
  static
  {
    AppMethodBeat.i(137930);
    mPB = new a("INST");
    mPF = new a[] { mPB };
    mPC = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.mPE = new AtomicBoolean(false);
    this.mPD = new b();
    AppMethodBeat.o(137924);
  }
  
  public final void bBs()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final c bBz()
  {
    AppMethodBeat.i(137927);
    c localc = this.mPD.bBz();
    AppMethodBeat.o(137927);
    return localc;
  }
  
  public final void dQ(Context paramContext)
  {
    AppMethodBeat.i(137928);
    init(paramContext);
    AppMethodBeat.o(137928);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(137925);
    if (!this.mPE.getAndSet(true)) {
      this.mPD.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.mPD.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */