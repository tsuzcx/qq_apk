package com.tencent.mm.plugin.messenger;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.e.c;

final class PluginMessenger$5
  implements e.c
{
  PluginMessenger$5(PluginMessenger paramPluginMessenger, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(136880);
    if ((paramBoolean) && (ad.arf(this.fwC)))
    {
      paramString = new x();
      paramString.fs(this.fWL);
      paramString.cTL = 1L;
      paramString.ft(this.irs);
      paramString.cTM = 1L;
      paramString.cTO = 2L;
      paramString.ake();
      PluginMessenger.access$202(this.oCK, new q(this.fwC, this.mOn));
      PluginMessenger.access$200(this.oCK).gfV = this.irs;
      g.Rc().a(PluginMessenger.access$200(this.oCK), 0);
      paramString = this.oCK;
      Context localContext = this.val$context;
      this.val$context.getString(2131297087);
      PluginMessenger.access$302(paramString, h.b(localContext, this.val$context.getString(2131302035), true, new PluginMessenger.5.1(this)));
    }
    AppMethodBeat.o(136880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.5
 * JD-Core Version:    0.7.0.1
 */