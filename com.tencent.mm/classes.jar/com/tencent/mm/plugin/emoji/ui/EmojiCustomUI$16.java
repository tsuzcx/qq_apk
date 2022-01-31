package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiCustomUI$16
  implements com.tencent.mm.as.a.c.d
{
  public final byte[] h(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs != null) && ((paramVarArgs instanceof EmojiInfo))) {
        return com.tencent.mm.plugin.emoji.e.d.aHc().a((EmojiInfo)paramVarArgs);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.16
 * JD-Core Version:    0.7.0.1
 */