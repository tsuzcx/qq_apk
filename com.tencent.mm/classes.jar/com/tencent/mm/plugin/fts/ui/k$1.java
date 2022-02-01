package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.aq;

final class k$1
  extends aq
{
  k$1(k paramk, Looper paramLooper)
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
      if ((!k.h(this.tKN)) && (this.tKN.getCount() > 0))
      {
        ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cVe();
        o.zsv.start();
        this.tKN.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.k.1
 * JD-Core Version:    0.7.0.1
 */