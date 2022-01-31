package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.d;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiCustomUI$16
  implements d
{
  public final byte[] i(Object... paramVarArgs)
  {
    AppMethodBeat.i(53315);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof EmojiInfo)))
      {
        paramVarArgs = f.bkQ().l((EmojiInfo)paramVarArgs);
        AppMethodBeat.o(53315);
        return paramVarArgs;
      }
    }
    AppMethodBeat.o(53315);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.16
 * JD-Core Version:    0.7.0.1
 */