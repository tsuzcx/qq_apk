package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;

public final class s
{
  public d.c uNv;
  SparseArray<WeakReference<d.b>> uNw;
  private ao uNx;
  
  public s()
  {
    AppMethodBeat.i(89604);
    this.uNv = d.c.uMm;
    this.uNw = new SparseArray();
    this.uNx = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89602);
        if (257 == paramAnonymousMessage.what)
        {
          paramAnonymousMessage = (d.c)paramAnonymousMessage.obj;
          int i = 0;
          while (i < s.this.uNw.size())
          {
            if ((d.b)((WeakReference)s.this.uNw.valueAt(i)).get() != null)
            {
              int[] arrayOfInt = s.2.uNz;
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
          s.this.uNw.put(paramAnonymousMessage.hashCode(), new WeakReference(paramAnonymousMessage));
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
          s.this.uNw.remove(paramAnonymousMessage.hashCode());
        }
        AppMethodBeat.o(89602);
      }
    };
    AppMethodBeat.o(89604);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(89605);
    ac.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[] { paramc.toString() });
    this.uNv = paramc;
    this.uNx.sendMessage(this.uNx.obtainMessage(257, paramc));
    AppMethodBeat.o(89605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s
 * JD-Core Version:    0.7.0.1
 */