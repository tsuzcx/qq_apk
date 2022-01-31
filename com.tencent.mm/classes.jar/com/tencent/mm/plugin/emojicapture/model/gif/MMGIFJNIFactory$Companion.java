package com.tencent.mm.plugin.emojicapture.model.gif;

import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class MMGIFJNIFactory$Companion
{
  public final a getDecoder(EmojiInfo paramEmojiInfo)
  {
    a.d.b.g.k(paramEmojiInfo, "emojiInfo");
    if (paramEmojiInfo.cwC())
    {
      paramEmojiInfo = EmojiInfo.bv(ae.getContext(), paramEmojiInfo.getName());
      a.d.b.g.j(paramEmojiInfo, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
      return (a)new b(paramEmojiInfo);
    }
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.t(PluginEmoji.class);
    a.d.b.g.j(locala, "MMKernel.plugin(PluginEmoji::class.java)");
    paramEmojiInfo = ((PluginEmoji)locala).getProvider().a(paramEmojiInfo);
    if (o.bz(paramEmojiInfo))
    {
      a.d.b.g.j(paramEmojiInfo, "byteArray");
      return (a)new c(paramEmojiInfo);
    }
    a.d.b.g.j(paramEmojiInfo, "byteArray");
    return (a)new b(paramEmojiInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.gif.MMGIFJNIFactory.Companion
 * JD-Core Version:    0.7.0.1
 */