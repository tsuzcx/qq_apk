package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "dataEmojiRoot", "getDataEmojiRoot", "()Ljava/lang/String;", "emojiGifRoot", "getEmojiGifRoot", "emojiResAnim", "getEmojiResAnim", "emojiResEgg", "getEmojiResEgg", "emojiResNewEmoji", "getEmojiResNewEmoji", "emojiResPanel", "getEmojiResPanel", "emojiSystemRoot", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long jPv = 62914560L;
  private static final String jPw;
  private static final String jPx;
  private static final String jPy = "_cover";
  public static final a jPz;
  
  static
  {
    AppMethodBeat.i(177058);
    jPz = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    jPv = 62914560L;
    jPw = aDB();
    jPx = aDB() + "/temp/";
    jPy = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String LQ(String paramString)
  {
    AppMethodBeat.i(177056);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = jPw + paramString + jPy;
    AppMethodBeat.o(177056);
    return paramString;
  }
  
  public static String aDB()
  {
    AppMethodBeat.i(228684);
    Object localObject1 = new StringBuilder();
    Object localObject2 = h.ag(d.class);
    p.j(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    p.j(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    AppMethodBeat.o(228684);
    return localObject1;
  }
  
  public static String aDC()
  {
    return jPx;
  }
  
  public static String aDD()
  {
    AppMethodBeat.i(228688);
    String str = b.aSE() + "emoji/";
    AppMethodBeat.o(228688);
    return str;
  }
  
  public static String aDE()
  {
    AppMethodBeat.i(228691);
    String str = aDD() + "emoji_anim/";
    AppMethodBeat.o(228691);
    return str;
  }
  
  public static void aDF()
  {
    AppMethodBeat.i(177057);
    Object localObject = k.aBH().aBK();
    p.j(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (Util.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        p.j(localEmojiInfo, "it");
        u.deleteFile(localEmojiInfo.ifi());
      }
    }
    AppMethodBeat.o(177057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */