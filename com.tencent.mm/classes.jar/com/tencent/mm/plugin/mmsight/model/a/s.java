package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class s
{
  public d.c oJP;
  SparseArray<WeakReference<d.b>> oJQ;
  private ak oJR;
  
  public s()
  {
    AppMethodBeat.i(76689);
    this.oJP = d.c.oIJ;
    this.oJQ = new SparseArray();
    this.oJR = new s.1(this, Looper.getMainLooper());
    AppMethodBeat.o(76689);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(76690);
    ab.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[] { paramc.toString() });
    this.oJP = paramc;
    this.oJR.sendMessage(this.oJR.obtainMessage(257, paramc));
    AppMethodBeat.o(76690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */