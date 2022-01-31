package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  extends ah
{
  i$1(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      y.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
    } while ((i.a(this.kBt)) || (this.kBt.getCount() <= 0));
    ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVm();
    com.tencent.mm.plugin.sns.b.n.omC.start();
    this.kBt.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i.1
 * JD-Core Version:    0.7.0.1
 */