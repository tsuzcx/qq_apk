package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "emojiGifRoot", "getEmojiGifRoot", "()Ljava/lang/String;", "emojiSystemRoot", "kotlin.jvm.PlatformType", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long fWG = 62914560L;
  private static final String fWH;
  private static final String fWI;
  private static final String fWJ;
  private static final String fWK;
  private static final String fWL = "_cover";
  public static final a fWM;
  
  static
  {
    AppMethodBeat.i(177058);
    fWM = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    fWG = 62914560L;
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.ad(d.class);
    k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    fWH = (String)localObject1;
    fWI = (String)localObject1;
    fWJ = fWH;
    fWK = fWH + "/temp/";
    fWL = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String adJ()
  {
    return fWI;
  }
  
  public static String adK()
  {
    return fWK;
  }
  
  public static void adL()
  {
    AppMethodBeat.i(177057);
    Object localObject = com.tencent.mm.emoji.a.i.ach().dh(true);
    k.g(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (bs.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        k.g(localEmojiInfo, "it");
        com.tencent.mm.vfs.i.deleteFile(localEmojiInfo.ghe());
      }
    }
    AppMethodBeat.o(177057);
  }
  
  public static String tl(String paramString)
  {
    AppMethodBeat.i(177056);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = fWJ + paramString + fWL;
    AppMethodBeat.o(177056);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.d.a
 * JD-Core Version:    0.7.0.1
 */