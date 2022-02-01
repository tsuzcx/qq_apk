package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ao;

final class j$1
  extends ao
{
  j$1(j paramj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(111945);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111945);
      return;
      if ((!j.h(this.sDh)) && (this.sDh.getCount() > 0))
      {
        ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cKk();
        o.xMa.start();
        this.sDh.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j.1
 * JD-Core Version:    0.7.0.1
 */