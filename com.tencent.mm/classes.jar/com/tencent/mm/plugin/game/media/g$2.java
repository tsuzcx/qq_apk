package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Set;

final class g$2
  implements d.b
{
  g$2(g paramg) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(151829);
    if (!g.h(this.nlu).contains(paramString1))
    {
      ab.i("MicroMsg.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramString1 });
      AppMethodBeat.o(151829);
      return;
    }
    g.h(this.nlu).remove(paramString1);
    long l = System.currentTimeMillis() - bo.a((Long)g.i(this.nlu).remove(paramString1), System.currentTimeMillis());
    ab.i("MicroMsg.GameUploadMediaEngine", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString1, paramString2, paramString3, Long.valueOf(l) });
    if (g.a(this.nlu))
    {
      ab.i("MicroMsg.GameUploadMediaEngine", "uploadMediaFile, has cancel");
      AppMethodBeat.o(151829);
      return;
    }
    a.post(new g.2.1(this, paramString1, l, paramBoolean, paramString3, paramString4, paramInt));
    AppMethodBeat.o(151829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g.2
 * JD-Core Version:    0.7.0.1
 */