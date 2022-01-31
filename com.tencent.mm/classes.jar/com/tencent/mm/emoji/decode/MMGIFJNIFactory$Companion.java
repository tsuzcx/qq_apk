package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isValid", "", "decoder", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory$Companion
{
  public final b getDecoder(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63145);
    j.q(paramEmojiInfo, "emojiInfo");
    for (;;)
    {
      try
      {
        if ((paramEmojiInfo.getGroup() != EmojiGroupInfo.yPe) && (paramEmojiInfo.getGroup() != EmojiInfo.yPl) && (paramEmojiInfo.getGroup() != EmojiInfo.yPk)) {
          continue;
        }
        localObject = (b)new c(paramEmojiInfo.y(ah.getContext(), 300));
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      catch (MMGIFException localMMGIFException)
      {
        Object localObject;
        ab.w(MMGIFJNIFactory.access$getTAG$cp(), "decode error: " + localMMGIFException.getErrorCode());
        if (localMMGIFException.getErrorCode() != 103) {
          continue;
        }
        com.tencent.mm.kernel.b.a locala = g.G(PluginEmoji.class);
        j.p(locala, "MMKernel.plugin(PluginEmoji::class.java)");
        paramEmojiInfo = ((PluginEmoji)locala).getProvider().l(paramEmojiInfo);
        if (paramEmojiInfo == null) {
          continue;
        }
        paramEmojiInfo = (b)new c(paramEmojiInfo);
        continue;
        AppMethodBeat.o(63145);
        return paramEmojiInfo;
        paramEmojiInfo = null;
        continue;
      }
      if (paramEmojiInfo != null) {
        continue;
      }
      paramEmojiInfo = (b)new a();
      AppMethodBeat.o(63145);
      return paramEmojiInfo;
      if (paramEmojiInfo.dzq())
      {
        localObject = EmojiInfo.bI(ah.getContext(), paramEmojiInfo.getName());
        j.p(localObject, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
        localObject = (b)new d((InputStream)localObject);
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      else
      {
        localObject = g.G(PluginEmoji.class);
        j.p(localObject, "MMKernel.plugin(PluginEmoji::class.java)");
        localObject = ((PluginEmoji)localObject).getProvider().l(paramEmojiInfo);
        if (localObject == null) {
          continue;
        }
        if (r.bX((byte[])localObject))
        {
          localObject = (b)new e((byte[])localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        else
        {
          localObject = (b)new d((byte[])localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
      }
    }
  }
  
  public final boolean isValid(b paramb)
  {
    return (paramb != null) && (!(paramb instanceof a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion
 * JD-Core Version:    0.7.0.1
 */