package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class i
{
  public static final boolean h(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105444);
    p.h(paramEmojiInfo, "emojiInfo");
    if ((!bu.isNullOrNil(paramEmojiInfo.field_tpurl)) && (!bu.isNullOrNil(paramEmojiInfo.field_aeskey)))
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
    p.h(paramEmojiInfo, "emojiInfo");
    if ((m.afo()) && (!bu.isNullOrNil(paramEmojiInfo.field_externUrl)) && (!bu.isNullOrNil(paramEmojiInfo.field_aeskey)))
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
    p.h(paramEmojiInfo, "emojiInfo");
    if ((!bu.isNullOrNil(paramEmojiInfo.field_encrypturl)) && (!bu.isNullOrNil(paramEmojiInfo.field_aeskey)))
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