package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public final class t
{
  public d.c vQE;
  SparseArray<WeakReference<d.b>> vQF;
  private ap vQG;
  
  public t()
  {
    AppMethodBeat.i(89604);
    this.vQE = d.c.vPs;
    this.vQF = new SparseArray();
    this.vQG = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89602);
        if (257 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.c)paramAnonymousMessage.obj;
          int i = 0;
          while (i < t.this.vQF.size())
          {
            if ((d.b)((WeakReference)t.this.vQF.valueAt(i)).get() != null)
            {
              int[] arrayOfInt = t.2.vQI;
              paramAnonymousMessage.ordinal();
            }
            i += 1;
          }
          AppMethodBeat.o(89602);
          return;
        }
        if (258 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.b)paramAnonymousMessage.obj;
          if (paramAnonymousMessage == null)
          {
            AppMethodBeat.o(89602);
            return;
          }
          t.this.vQF.put(paramAnonymousMessage.hashCode(), new WeakReference(paramAnonymousMessage));
          AppMethodBeat.o(89602);
          return;
        }
        if (259 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.b)paramAnonymousMessage.obj;
          if (paramAnonymousMessage == null)
          {
            AppMethodBeat.o(89602);
            return;
          }
          t.this.vQF.remove(paramAnonymousMessage.hashCode());
        }
        AppMethodBeat.o(89602);
      }
    };
    AppMethodBeat.o(89604);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(89605);
    ad.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[] { paramc.toString() });
    this.vQE = paramc;
    this.vQG.sendMessage(this.vQG.obtainMessage(257, paramc));
    AppMethodBeat.o(89605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.t
 * JD-Core Version:    0.7.0.1
 */