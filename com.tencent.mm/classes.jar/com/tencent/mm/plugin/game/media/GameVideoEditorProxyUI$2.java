package com.tencent.mm.plugin.game.media;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class GameVideoEditorProxyUI$2
  implements Runnable
{
  GameVideoEditorProxyUI$2(GameVideoEditorProxyUI paramGameVideoEditorProxyUI, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(151873);
    String str = this.val$data.getStringExtra("key_video_info");
    str = GameVideoEditorProxyUI.a(this.nlN, str);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    d.b(GameVideoEditorProxyUI.d(this.nlN), "webview", ".ui.tools.WebViewUI", localIntent, 131);
    AppMethodBeat.o(151873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.2
 * JD-Core Version:    0.7.0.1
 */