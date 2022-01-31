package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class h
{
  public static final boolean f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63194);
    j.q(paramEmojiInfo, "emojiInfo");
    if (!bo.isNullOrNil(paramEmojiInfo.field_tpurl))
    {
      AppMethodBeat.o(63194);
      return true;
    }
    AppMethodBeat.o(63194);
    return false;
  }
  
  public static final boolean g(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63195);
    j.q(paramEmojiInfo, "emojiInfo");
    if ((com.tencent.mm.emoji.a.h.OO()) && (!bo.isNullOrNil(paramEmojiInfo.field_externUrl)) && (!bo.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(63195);
      return true;
    }
    AppMethodBeat.o(63195);
    return false;
  }
  
  public static final boolean h(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63196);
    j.q(paramEmojiInfo, "emojiInfo");
    if ((!bo.isNullOrNil(paramEmojiInfo.field_encrypturl)) && (!bo.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(63196);
      return true;
    }
    AppMethodBeat.o(63196);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.h
 * JD-Core Version:    0.7.0.1
 */