package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class i
{
  public static final boolean h(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105444);
    p.k(paramEmojiInfo, "emojiInfo");
    if ((!Util.isNullOrNil(paramEmojiInfo.field_tpurl)) && (!Util.isNullOrNil(paramEmojiInfo.field_aeskey)))
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
    p.k(paramEmojiInfo, "emojiInfo");
    if ((o.aBX()) && (!Util.isNullOrNil(paramEmojiInfo.field_externUrl)) && (!Util.isNullOrNil(paramEmojiInfo.field_aeskey)))
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
    p.k(paramEmojiInfo, "emojiInfo");
    if ((!Util.isNullOrNil(paramEmojiInfo.field_encrypturl)) && (!Util.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(105446);
      return true;
    }
    AppMethodBeat.o(105446);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.i
 * JD-Core Version:    0.7.0.1
 */