package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.kernel.g;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;

public final class a
  implements k.c, io.flutter.plugin.platform.c
{
  private final k wJr;
  private final EmojiStatusView wJs;
  
  a(Context paramContext, io.flutter.plugin.a.c paramc, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(240948);
    this.wJs = new EmojiStatusView(paramContext);
    paramContext = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amm(paramObject.toString());
    this.wJs.setEmojiInfo(paramContext);
    this.wJr = new k(paramc, "com.tencent.mm/emoji_preview_".concat(String.valueOf(paramInt)));
    this.wJr.a(this);
    AppMethodBeat.o(240948);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(240949);
    String str = paramj.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.dLv();
        AppMethodBeat.o(240949);
        return;
        if (str.equals("updateMd5")) {
          i = 0;
        }
        break;
      }
    }
    paramj = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amm(paramj.SxX.toString());
    this.wJs.setEmojiInfo(paramj);
    AppMethodBeat.o(240949);
  }
  
  public final View getView()
  {
    return this.wJs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.a
 * JD-Core Version:    0.7.0.1
 */