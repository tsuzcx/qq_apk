package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "emojiGifRoot", "getEmojiGifRoot", "()Ljava/lang/String;", "emojiSystemRoot", "kotlin.jvm.PlatformType", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long gqj = 62914560L;
  private static final String gqk;
  private static final String gql;
  private static final String gqm = "_cover";
  public static final a gqn;
  
  static
  {
    AppMethodBeat.i(177058);
    gqn = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    gqj = 62914560L;
    gqk = agp();
    gql = agp() + "/temp/";
    gqm = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String agp()
  {
    AppMethodBeat.i(218992);
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.ad(d.class);
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    AppMethodBeat.o(218992);
    return localObject1;
  }
  
  public static String agq()
  {
    return gql;
  }
  
  public static void agr()
  {
    AppMethodBeat.i(177057);
    Object localObject = com.tencent.mm.emoji.a.i.aeL().dj(true);
    p.g(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (bt.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        p.g(localEmojiInfo, "it");
        com.tencent.mm.vfs.i.deleteFile(localEmojiInfo.gzR());
      }
    }
    AppMethodBeat.o(177057);
  }
  
  public static String wb(String paramString)
  {
    AppMethodBeat.i(177056);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = gqk + paramString + gqm;
    AppMethodBeat.o(177056);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.d.a
 * JD-Core Version:    0.7.0.1
 */