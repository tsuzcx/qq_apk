package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class s$1
  extends ak
{
  s$1(s params, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76687);
    if (257 == paramMessage.what)
    {
      paramMessage = (d.c)paramMessage.obj;
      int i = 0;
      while (i < this.oJS.oJQ.size())
      {
        if ((d.b)((WeakReference)this.oJS.oJQ.valueAt(i)).get() != null)
        {
          int[] arrayOfInt = s.2.oJT;
          paramMessage.ordinal();
        }
        i += 1;
      }
      AppMethodBeat.o(76687);
      return;
    }
    if (258 == paramMessage.what)
    {
      paramMessage = (d.b)paramMessage.obj;
      if (paramMessage == null)
      {
        AppMethodBeat.o(76687);
        return;
      }
      this.oJS.oJQ.put(paramMessage.hashCode(), new WeakReference(paramMessage));
      AppMethodBeat.o(76687);
      return;
    }
    if (259 == paramMessage.what)
    {
      paramMessage = (d.b)paramMessage.obj;
      if (paramMessage == null)
      {
        AppMethodBeat.o(76687);
        return;
      }
      this.oJS.oJQ.remove(paramMessage.hashCode());
    }
    AppMethodBeat.o(76687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.s.1
 * JD-Core Version:    0.7.0.1
 */