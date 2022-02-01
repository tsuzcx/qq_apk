package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final boolean g(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105444);
    s.u(paramEmojiInfo, "emojiInfo");
    if ((!Util.isNullOrNil(paramEmojiInfo.field_tpurl)) && (!Util.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(105444);
      return true;
    }
    AppMethodBeat.o(105444);
    return false;
  }
  
  public static final boolean h(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105445);
    s.u(paramEmojiInfo, "emojiInfo");
    if ((o.aUU()) && (!Util.isNullOrNil(paramEmojiInfo.field_externUrl)) && (!Util.isNullOrNil(paramEmojiInfo.field_aeskey)))
    {
      AppMethodBeat.o(105445);
      return true;
    }
    AppMethodBeat.o(105445);
    return false;
  }
  
  public static final boolean i(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105446);
    s.u(paramEmojiInfo, "emojiInfo");
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
 * Qualified Name:     com.tencent.mm.emoji.b.c.h
 * JD-Core Version:    0.7.0.1
 */