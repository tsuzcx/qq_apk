package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "emojiGifRoot", "getEmojiGifRoot", "()Ljava/lang/String;", "emojiSystemRoot", "kotlin.jvm.PlatformType", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long fSL = 62914560L;
  private static final String fSM;
  private static final String fSN;
  private static final String fSO;
  private static final String fSP;
  private static final String fSQ = "_cover";
  public static final a fSR;
  
  static
  {
    AppMethodBeat.i(177058);
    fSR = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    fSL = 62914560L;
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.ad(d.class);
    k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    k.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    fSM = (String)localObject1;
    fSN = (String)localObject1;
    fSO = fSM;
    fSP = fSM + "/temp/";
    fSQ = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String acD()
  {
    return fSN;
  }
  
  public static String acE()
  {
    return fSP;
  }
  
  public static void acF()
  {
    AppMethodBeat.i(177057);
    Object localObject = h.abj().di(true);
    k.g(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (bt.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        k.g(localEmojiInfo, "it");
        i.deleteFile(localEmojiInfo.gab());
      }
    }
    AppMethodBeat.o(177057);
  }
  
  public static String pY(String paramString)
  {
    AppMethodBeat.i(177056);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = fSO + paramString + fSQ;
    AppMethodBeat.o(177056);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.d.a
 * JD-Core Version:    0.7.0.1
 */