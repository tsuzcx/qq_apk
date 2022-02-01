package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.io.InputStream;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class MMGIFJNIFactory
{
  public static final Companion Companion;
  private static final String TAG = "MicroMsg.MMGIFJNIFactory";
  
  static
  {
    AppMethodBeat.i(105375);
    Companion = new Companion(null);
    TAG = "MicroMsg.MMGIFJNIFactory";
    AppMethodBeat.o(105375);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "decodeThumb", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "isValid", "", "decoder", "plugin-emojisdk_release"})
  public static final class Companion
  {
    public final Bitmap decodeThumb(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(177050);
      p.h(paramEmojiInfo, "emojiInfo");
      paramEmojiInfo = ((Companion)this).getDecoder(paramEmojiInfo);
      if (((Companion)this).isValid(paramEmojiInfo))
      {
        paramEmojiInfo.aeu();
        Bitmap localBitmap = paramEmojiInfo.aev();
        paramEmojiInfo.destroy();
        AppMethodBeat.o(177050);
        return localBitmap;
      }
      AppMethodBeat.o(177050);
      return null;
    }
    
    public final d getDecoder(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(105374);
      p.h(paramEmojiInfo, "emojiInfo");
      for (;;)
      {
        try
        {
          if ((paramEmojiInfo.getGroup() != EmojiGroupInfo.OeL) && (paramEmojiInfo.getGroup() != EmojiInfo.OeS) && (paramEmojiInfo.getGroup() != EmojiInfo.OeR)) {
            continue;
          }
          localObject = (d)new e(paramEmojiInfo.z(aj.getContext(), 300));
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        catch (MMGIFException localMMGIFException)
        {
          Object localObject;
          ad.w(MMGIFJNIFactory.access$getTAG$cp(), "decode error: " + localMMGIFException.getErrorCode());
          if (localMMGIFException.getErrorCode() != 103) {
            continue;
          }
          a locala = com.tencent.mm.kernel.g.ad(PluginEmoji.class);
          p.g(locala, "MMKernel.plugin(PluginEmoji::class.java)");
          paramEmojiInfo = ((PluginEmoji)locala).getProvider().a(paramEmojiInfo);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo = (d)new e(paramEmojiInfo);
          continue;
          AppMethodBeat.o(105374);
          return paramEmojiInfo;
          paramEmojiInfo = null;
          continue;
        }
        if (paramEmojiInfo != null) {
          continue;
        }
        paramEmojiInfo = (d)new b();
        AppMethodBeat.o(105374);
        return paramEmojiInfo;
        if (paramEmojiInfo.fOy())
        {
          localObject = EmojiInfo.q(aj.getContext(), paramEmojiInfo.getName());
          p.g(localObject, "EmojiInfo.getEmojiFile(M…ontext(), emojiInfo.name)");
          localObject = (d)new f((InputStream)localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        else
        {
          localObject = com.tencent.mm.kernel.g.ad(PluginEmoji.class);
          p.g(localObject, "MMKernel.plugin(PluginEmoji::class.java)");
          localObject = ((PluginEmoji)localObject).getProvider().a(paramEmojiInfo);
          if (localObject == null) {
            continue;
          }
          if (t.cv((byte[])localObject))
          {
            localObject = (d)new g((byte[])localObject);
            paramEmojiInfo = (EmojiInfo)localObject;
          }
          else
          {
            localObject = (d)new f((byte[])localObject);
            paramEmojiInfo = (EmojiInfo)localObject;
          }
        }
      }
    }
    
    public final boolean isValid(d paramd)
    {
      return (paramd != null) && (!(paramd instanceof b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.MMGIFJNIFactory
 * JD-Core Version:    0.7.0.1
 */