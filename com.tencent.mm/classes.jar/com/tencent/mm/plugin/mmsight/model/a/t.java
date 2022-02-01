package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;

public final class t
{
  public d.c wcI;
  SparseArray<WeakReference<d.b>> wcJ;
  private aq wcK;
  
  public t()
  {
    AppMethodBeat.i(89604);
    this.wcI = d.c.wbv;
    this.wcJ = new SparseArray();
    this.wcK = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89602);
        if (257 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.c)paramAnonymousMessage.obj;
          int i = 0;
          while (i < t.this.wcJ.size())
          {
            if ((d.b)((WeakReference)t.this.wcJ.valueAt(i)).get() != null)
            {
              int[] arrayOfInt = t.2.wcM;
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
          t.this.wcJ.put(paramAnonymousMessage.hashCode(), new WeakReference(paramAnonymousMessage));
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
          t.this.wcJ.remove(paramAnonymousMessage.hashCode());
        }
        AppMethodBeat.o(89602);
      }
    };
    AppMethodBeat.o(89604);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(89605);
    ae.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[] { paramc.toString() });
    this.wcI = paramc;
    this.wcK.sendMessage(this.wcK.obtainMessage(257, paramc));
    AppMethodBeat.o(89605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.t
 * JD-Core Version:    0.7.0.1
 */