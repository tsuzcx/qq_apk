package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Set;

final class g$3
  implements d.a
{
  g$3(g paramg) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151830);
    if (!g.h(this.nlu).contains(paramString1))
    {
      ab.i("MicroMsg.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramString1 });
      AppMethodBeat.o(151830);
      return;
    }
    paramInt1 = g.n(this.nlu).size();
    int i = g.h(this.nlu).size() + g.e(this.nlu).size();
    float f = 0.95F * ((paramInt1 - i) / paramInt1 + 1.0F / paramInt1 * (paramInt2 / 100.0F));
    ab.i("MicroMsg.GameUploadMediaEngine", "onProgress, localId : %s, percent : %d, initSize : %d, uploadingSize : %d, uploadProgress : %f", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i), Float.valueOf(f) });
    g.a(this.nlu, f);
    AppMethodBeat.o(151830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g.3
 * JD-Core Version:    0.7.0.1
 */