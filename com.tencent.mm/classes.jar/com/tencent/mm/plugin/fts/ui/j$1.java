package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.sdk.platformtools.ah;

final class j$1
  extends ah
{
  j$1(j paramj, Looper paramLooper)
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
    } while ((j.f(this.kBG)) || (this.kBG.getCount() <= 0));
    ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().aVm();
    com.tencent.mm.plugin.sns.b.n.omC.start();
    this.kBG.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.j.1
 * JD-Core Version:    0.7.0.1
 */