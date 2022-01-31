package com.tencent.mm.plugin.downloader_app.e;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

final class a$5
  implements Runnable
{
  a$5(a parama, boolean paramBoolean, ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(136321);
    boolean bool = this.ldm;
    int i = r.Zy();
    bmq localbmq;
    if (bool)
    {
      i &= 0xF7FFFFFF;
      g.RL().Ru().set(34, Integer.valueOf(i));
      localbmq = new bmq();
      localbmq.wmt = 134217728;
      if (!bool) {
        break label152;
      }
    }
    label152:
    for (i = 0;; i = 1)
    {
      localbmq.xBb = i;
      ((j)g.E(j.class)).Yz().c(new j.a(39, localbmq));
      if (!this.ldm)
      {
        bf.pz("downloaderapp");
        ((j)g.E(j.class)).YF().arF("downloaderapp");
      }
      al.p(new a.5.1(this), 1000L);
      AppMethodBeat.o(136321);
      return;
      i |= 0x8000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.e.a.5
 * JD-Core Version:    0.7.0.1
 */