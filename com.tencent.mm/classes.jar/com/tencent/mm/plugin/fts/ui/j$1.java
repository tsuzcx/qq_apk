package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

final class j$1
  extends aq
{
  j$1(j paramj, Looper paramLooper)
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
      ae.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
      if ((!j.a(this.tKz)) && (this.tKz.getCount() > 0))
      {
        ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader().cVe();
        o.zsv.start();
        this.tKz.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j.1
 * JD-Core Version:    0.7.0.1
 */