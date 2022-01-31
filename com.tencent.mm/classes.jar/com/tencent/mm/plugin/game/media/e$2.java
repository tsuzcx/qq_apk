package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import java.util.Map;

final class e$2
  implements Runnable
{
  e$2(e parame, Map paramMap, b.a parama, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(151810);
    if (this.nld.containsKey("videoid")) {
      this.nld.put("videoid", com.tencent.mm.vfs.e.avP((String)this.nld.get("videoid")));
    }
    long l = System.currentTimeMillis();
    b.a(this.nle.ado(), new e.2.1(this, l));
    AppMethodBeat.o(151810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e.2
 * JD-Core Version:    0.7.0.1
 */