package com.tencent.mm.plugin.game.media;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.game.api.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.b;

final class GameVideoDownloadUI$6
  implements h.a
{
  GameVideoDownloadUI$6(GameVideoDownloadUI paramGameVideoDownloadUI, long paramLong, String paramString1, String paramString2, f.a parama) {}
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(151854);
    ab.i("MicroMsg.GameVideoDownloadUI", "download video mediaId:%s, rawMediaId:%s", new Object[] { paramString, GameVideoDownloadUI.a(this.nlB) });
    if (GameVideoDownloadUI.a(this.nlB).equals(paramString))
    {
      ab.i("MicroMsg.GameVideoDownloadUI", "download video cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.fET) });
      if (paramInt == 0) {
        ab.i("MicroMsg.GameVideoDownloadUI", "download video[%s] success", new Object[] { this.mAj });
      }
      while ((paramInt == 0) && (!TextUtils.isEmpty(this.val$filePath)))
      {
        paramString = new b(this.val$filePath);
        if (!paramString.exists()) {
          break;
        }
        ab.i("MicroMsg.GameVideoDownloadUI", "download file size:%d", new Object[] { Long.valueOf(paramString.length()) });
        this.nlH.ah(this.val$filePath, 0, 0);
        AppMethodBeat.o(151854);
        return;
        ab.i("MicroMsg.GameVideoDownloadUI", "download video[%s] fail, ret:%d", new Object[] { this.mAj, Integer.valueOf(paramInt) });
      }
      t.makeText(GameVideoDownloadUI.b(this.nlB), 2131300471, 1).show();
      if (this.nlH != null) {
        this.nlH.ah(this.val$filePath, 2, paramInt);
      }
    }
    AppMethodBeat.o(151854);
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2) {}
  
  public final void m(String paramString, int paramInt1, int paramInt2) {}
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151853);
    ab.d("MicroMsg.GameVideoDownloadUI", "download video offset:%d, total:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((GameVideoDownloadUI.a(this.nlB).equals(paramString)) && (paramInt2 != 0)) {
      al.d(new GameVideoDownloadUI.6.1(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(151853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI.6
 * JD-Core Version:    0.7.0.1
 */