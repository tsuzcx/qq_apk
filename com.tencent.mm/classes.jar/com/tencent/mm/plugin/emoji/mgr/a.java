package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public final class a
{
  static void aob(String paramString)
  {
    AppMethodBeat.i(108393);
    paramString = paramString.replace("delete", "").trim().split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aof(str).kMa();
      i += 1;
    }
    AppMethodBeat.o(108393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.a
 * JD-Core Version:    0.7.0.1
 */