package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class g$2$1
  implements Runnable
{
  g$2$1(g.2 param2, String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(151828);
    Object localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().PX(this.nlv);
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localHashMap.put("type", Integer.valueOf(g.xa(((b)localObject).field_mediaType)));
      if (g.xa(((b)localObject).field_mediaType) == 2) {
        localHashMap.put("videoid", com.tencent.mm.vfs.e.avP(((b)localObject).field_filePath));
      }
    }
    localHashMap.put("costtime", Long.valueOf(this.nlw));
    localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().PY(g.j(this.nly.nlu));
    if (localObject != null) {
      localHashMap.put("pushid", ((d)localObject).field_taskId);
    }
    for (int i = i.xc(((d)localObject).field_publishSource);; i = 0)
    {
      if (this.egM)
      {
        g.e(this.nly.nlu).remove(this.nlv);
        localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW();
        String str = this.nlv;
        str = String.format("update %s set %s=\"%s\", %s=\"%s\", %s=%d where %s=\"%s\"", new Object[] { "GameHaowanMedia", "mediaUrl", this.nlx, "thumbPicUrl", this.fEW, "uploadState", Integer.valueOf(2), "localId", str });
        ab.i("MicroMsg.GameHaowanPublishStorage", "updateMediaUrl, sql: ".concat(String.valueOf(str)));
        ((c)localObject).execSQL("GameHaowanMedia", str);
        a.a(ah.getContext(), 8764, 0, 48, a.a(i, localHashMap));
      }
      for (;;)
      {
        ab.i("MicroMsg.GameUploadMediaEngine", "upload list size : %d, hasPushAllUpload: %b", new Object[] { Integer.valueOf(g.h(this.nly.nlu).size()), Boolean.valueOf(g.k(this.nly.nlu)) });
        if ((!g.h(this.nly.nlu).isEmpty()) || (!g.k(this.nly.nlu))) {
          break label507;
        }
        if (g.e(this.nly.nlu).isEmpty()) {
          break;
        }
        com.tencent.mm.sdk.g.d.ysm.r(g.l(this.nly.nlu), 60000L);
        AppMethodBeat.o(151828);
        return;
        if (this.val$errCode != -21006)
        {
          g.e(this.nly.nlu).add(this.nlv);
          localHashMap.put("failid", Integer.valueOf(this.val$errCode));
          a.a(ah.getContext(), 8764, 0, 56, a.a(i, localHashMap));
        }
      }
      g.m(this.nly.nlu);
      label507:
      AppMethodBeat.o(151828);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g.2.1
 * JD-Core Version:    0.7.0.1
 */