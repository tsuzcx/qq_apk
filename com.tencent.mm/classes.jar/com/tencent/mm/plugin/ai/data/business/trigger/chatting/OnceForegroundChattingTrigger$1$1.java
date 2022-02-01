package com.tencent.mm.plugin.ai.data.business.trigger.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xwebutil.c;

final class OnceForegroundChattingTrigger$1$1
  implements Runnable
{
  OnceForegroundChattingTrigger$1$1(OnceForegroundChattingTrigger.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(267665);
    if ((!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")) || (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp"))) {
      c.jQE();
    }
    AppMethodBeat.o(267665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.chatting.OnceForegroundChattingTrigger.1.1
 * JD-Core Version:    0.7.0.1
 */