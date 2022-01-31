package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

final class g$4
  implements Runnable
{
  g$4(g paramg, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(151831);
    HashMap localHashMap = new HashMap();
    Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().PX(this.nlv);
    if (localObject != null)
    {
      localHashMap.put("type", Integer.valueOf(g.xa(((b)localObject).field_mediaType)));
      if (g.xa(((b)localObject).field_mediaType) == 2) {
        localHashMap.put("videoid", com.tencent.mm.vfs.e.avP(((b)localObject).field_filePath));
      }
    }
    localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().PY(g.j(this.nlu));
    if (localObject != null) {
      localHashMap.put("pushid", ((d)localObject).field_taskId);
    }
    for (int i = i.xc(((d)localObject).field_publishSource);; i = 0)
    {
      a.a(ah.getContext(), 8764, 0, 20, a.a(i, localHashMap));
      AppMethodBeat.o(151831);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g.4
 * JD-Core Version:    0.7.0.1
 */