package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "emojiGifRoot", "getEmojiGifRoot", "()Ljava/lang/String;", "emojiSystemRoot", "kotlin.jvm.PlatformType", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long gsE = 62914560L;
  private static final String gsF;
  private static final String gsG;
  private static final String gsH = "_cover";
  public static final a gsI;
  
  static
  {
    AppMethodBeat.i(177058);
    gsI = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    gsE = 62914560L;
    gsF = agD();
    gsG = agD() + "/temp/";
    gsH = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String agD()
  {
    AppMethodBeat.i(188606);
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.ad(d.class);
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    AppMethodBeat.o(188606);
    return localObject1;
  }
  
  public static String agE()
  {
    return gsG;
  }
  
  public static void agF()
  {
    AppMethodBeat.i(177057);
    Object localObject = i.aeX().dj(true);
    p.g(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (bu.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        p.g(localEmojiInfo, "it");
        o.deleteFile(localEmojiInfo.fSR());
      }
    }
    AppMethodBeat.o(177057);
  }
  
  public static String wI(String paramString)
  {
    AppMethodBeat.i(177056);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = gsF + paramString + gsH;
    AppMethodBeat.o(177056);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.a
 * JD-Core Version:    0.7.0.1
 */