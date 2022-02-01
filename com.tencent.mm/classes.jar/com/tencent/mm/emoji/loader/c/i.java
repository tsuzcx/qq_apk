package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class i
{
  public static final boolean h(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105444);
    k.h(paramEmojiInfo, "emojiInfo");
    if (!bs.isNullOrNil(paramEmojiInfo.field_tpurl))
    {
      AppMethodBeat.o(105444);
      return true;
    }
    AppMethodBeat.o(105444);
    return false;
  }
  
  public static final boolean i(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105445);
    k.h(paramEmojiInfo, "emojiInfo");
    if ((m.acw()) && (!bs.isNullOrNil(paramEmojiInfo.field_externUrl)) && (!bs.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(105445);
      return true;
    }
    AppMethodBeat.o(105445);
    return false;
  }
  
  public static final boolean j(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105446);
    k.h(paramEmojiInfo, "emojiInfo");
    if ((!bs.isNullOrNil(paramEmojiInfo.field_encrypturl)) && (!bs.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(105446);
      return true;
    }
    AppMethodBeat.o(105446);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.i
 * JD-Core Version:    0.7.0.1
 */