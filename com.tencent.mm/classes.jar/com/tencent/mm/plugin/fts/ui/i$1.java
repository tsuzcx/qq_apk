package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

final class i$1
  extends ao
{
  i$1(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(111930);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111930);
      return;
      ac.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
      if ((!i.a(this.sCT)) && (this.sCT.getCount() > 0))
      {
        ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cKk();
        o.xMa.start();
        this.sCT.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i.1
 * JD-Core Version:    0.7.0.1
 */