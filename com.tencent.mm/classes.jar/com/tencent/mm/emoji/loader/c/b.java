package com.tencent.mm.emoji.loader.c;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher;", "", "()V", "fetch", "Lcom/tencent/mm/emoji/loader/request/Request;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "readFromCache", "Companion", "plugin-emojisdk_release"})
public final class b
{
  public static final a evy;
  
  static
  {
    AppMethodBeat.i(63178);
    evy = new a((byte)0);
    AppMethodBeat.o(63178);
  }
  
  public static final boolean d(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63179);
    boolean bool = a.d(paramEmojiInfo);
    AppMethodBeat.o(63179);
    return bool;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$Companion;", "", "()V", "ThumbSize", "", "createThumb", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean d(EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(63176);
      j.q(paramEmojiInfo, "emojiInfo");
      ab.i("MicroMsg.EmojiCoverFetcher", "createThumb: " + paramEmojiInfo.Al());
      Object localObject2 = MMGIFJNIFactory.Companion.getDecoder(paramEmojiInfo);
      if (!MMGIFJNIFactory.Companion.isValid((com.tencent.mm.emoji.decode.b)localObject2))
      {
        ab.w("MicroMsg.EmojiCoverFetcher", "createThumb: invalid decoder");
        ((com.tencent.mm.emoji.decode.b)localObject2).destroy();
        AppMethodBeat.o(63176);
        return false;
      }
      Object localObject1;
      if (((localObject2 instanceof com.tencent.mm.emoji.decode.e)) && (((com.tencent.mm.emoji.decode.b)localObject2).Oo() == 1))
      {
        ((com.tencent.mm.emoji.decode.b)localObject2).destroy();
        localObject1 = g.G(PluginEmoji.class);
        j.p(localObject1, "MMKernel.plugin(PluginEmoji::class.java)");
        localObject1 = ((PluginEmoji)localObject1).getProvider().l(paramEmojiInfo);
        if (localObject1 == null) {
          break label290;
        }
        localObject1 = ((c)g.E(c.class)).aF((byte[])localObject1);
        if (localObject1 == null) {
          break label290;
        }
        localObject1 = d.bT((byte[])localObject1);
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          ab.e("MicroMsg.EmojiCoverFetcher", "bitmap is null");
          AppMethodBeat.o(63176);
          return false;
          ((com.tencent.mm.emoji.decode.b)localObject2).Om();
          localObject1 = ((com.tencent.mm.emoji.decode.b)localObject2).On();
          ((com.tencent.mm.emoji.decode.b)localObject2).destroy();
        }
        else
        {
          try
          {
            d.a((Bitmap)localObject1, 100, Bitmap.CompressFormat.PNG, paramEmojiInfo.dQC(), false);
            if (((Bitmap)localObject1).getWidth() <= 120)
            {
              localObject2 = localObject1;
              if (((Bitmap)localObject1).getHeight() <= 120) {}
            }
            else
            {
              localObject1 = d.a((Bitmap)localObject1, 120, 120, false, true);
              localObject2 = localObject1;
              if (localObject1 == null)
              {
                AppMethodBeat.o(63176);
                return false;
              }
            }
            localObject1 = com.tencent.mm.emoji.loader.a.b.evt;
            com.tencent.mm.emoji.loader.a.b.c(paramEmojiInfo.Al(), (Bitmap)localObject2);
            AppMethodBeat.o(63176);
            return true;
          }
          catch (IOException paramEmojiInfo)
          {
            ab.printErrStackTrace("MicroMsg.EmojiCoverFetcher", (Throwable)paramEmojiInfo, "saveBitmapToImage failed", new Object[0]);
            AppMethodBeat.o(63176);
            return false;
          }
          label290:
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b
 * JD-Core Version:    0.7.0.1
 */