package com.tencent.mm.plugin.fts.ui.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ak;

final class n$1
  extends ak
{
  n$1(n paramn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(152179);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152179);
      return;
      if (paramMessage.obj.equals(Long.valueOf(this.naM.naI)))
      {
        d.i("MicroMsg.FTS.FTSWeAppSearchUIUnit", "cancel Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.naM.mWI) });
        this.naM.mTx.a(this.naM, this.naM.query);
        this.naM.bCd();
        this.naM.clearData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.n.1
 * JD-Core Version:    0.7.0.1
 */