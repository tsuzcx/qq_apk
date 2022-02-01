package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public final class s
{
  public d.c tFa;
  SparseArray<WeakReference<d.b>> tFb;
  private ap tFc;
  
  public s()
  {
    AppMethodBeat.i(89604);
    this.tFa = d.c.tDR;
    this.tFb = new SparseArray();
    this.tFc = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89602);
        if (257 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.c)paramAnonymousMessage.obj;
          int i = 0;
          while (i < s.this.tFb.size())
          {
            if ((d.b)((WeakReference)s.this.tFb.valueAt(i)).get() != null)
            {
              int[] arrayOfInt = s.2.tFe;
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
          s.this.tFb.put(paramAnonymousMessage.hashCode(), new WeakReference(paramAnonymousMessage));
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
          s.this.tFb.remove(paramAnonymousMessage.hashCode());
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
    this.tFa = paramc;
    this.tFc.sendMessage(this.tFc.obtainMessage(257, paramc));
    AppMethodBeat.o(89605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */