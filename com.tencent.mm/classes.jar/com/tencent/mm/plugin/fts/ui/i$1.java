package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class i$1
  extends ak
{
  i$1(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(61835);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(61835);
      return;
      ab.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
      if ((!i.a(this.mXl)) && (this.mXl.getCount() > 0))
      {
        ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().bBL();
        com.tencent.mm.plugin.sns.b.n.raQ.start();
        this.mXl.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i.1
 * JD-Core Version:    0.7.0.1
 */