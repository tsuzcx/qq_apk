package com.tencent.mm.plugin.luckymoney.story;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

final class EnvelopeStoryVideoManager$10
  implements g.b
{
  EnvelopeStoryVideoManager$10(String paramString, long paramLong) {}
  
  public final void b(String paramString, d paramd)
  {
    AppMethodBeat.i(182468);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "preload complete: %s %s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
    EnvelopeStoryVideoManager.cGZ().remove(paramString);
    h.OAn.b(19228, new Object[] { this.val$url, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf((SystemClock.elapsedRealtime() - this.xbx) / 1000L), Integer.valueOf(0) });
    AppMethodBeat.o(182468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager.10
 * JD-Core Version:    0.7.0.1
 */