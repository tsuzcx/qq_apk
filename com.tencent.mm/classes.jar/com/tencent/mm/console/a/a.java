package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.w;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20169);
    k.getEmojiStorageMgr().Jgf.bdi();
    AppMethodBeat.o(20169);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.a
 * JD-Core Version:    0.7.0.1
 */