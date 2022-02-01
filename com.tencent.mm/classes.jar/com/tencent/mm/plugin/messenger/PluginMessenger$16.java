package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.c;

final class PluginMessenger$16
  implements f.c
{
  PluginMessenger$16(PluginMessenger paramPluginMessenger, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(203905);
    if ((paramBoolean) && (af.aHH(this.gXD)))
    {
      paramString = new bi();
      paramString.ib(this.hzx);
      paramString.dPx = 1L;
      paramString.ic(this.kTn);
      paramString.dPy = 1L;
      paramString.dPA = 2L;
      paramString.aBj();
      PluginMessenger.access$202(this.txs, new com.tencent.mm.openim.b.q(this.gXD, this.rlf));
      PluginMessenger.access$200(this.txs).hNR = this.kTn;
      g.aeS().a(PluginMessenger.access$200(this.txs), 0);
      paramString = this.txs;
      Context localContext = this.val$context;
      this.val$context.getString(2131755906);
      PluginMessenger.access$302(paramString, h.b(localContext, this.val$context.getString(2131761820), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(203904);
          g.aeS().a(PluginMessenger.access$200(PluginMessenger.16.this.txs));
          AppMethodBeat.o(203904);
        }
      }));
    }
    AppMethodBeat.o(203905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.16
 * JD-Core Version:    0.7.0.1
 */