package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "dataEmojiRoot", "getDataEmojiRoot", "()Ljava/lang/String;", "emojiGifRoot", "getEmojiGifRoot", "emojiResAnim", "getEmojiResAnim", "emojiResEgg", "getEmojiResEgg", "emojiResNewEmoji", "getEmojiResNewEmoji", "emojiResPanel", "getEmojiResPanel", "emojiSystemRoot", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiFileUtil";
  private static final long hdP = 62914560L;
  private static final String hdQ;
  private static final String hdR;
  private static final String hdS = "_cover";
  public static final a hdT;
  
  static
  {
    AppMethodBeat.i(177058);
    hdT = new a();
    TAG = "MicroMsg.EmojiFileUtil";
    hdP = 62914560L;
    hdQ = awt();
    hdR = awt() + "/temp/";
    hdS = "_cover";
    AppMethodBeat.o(177058);
  }
  
  public static String EX(String paramString)
  {
    AppMethodBeat.i(177056);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177056);
      return null;
    }
    paramString = hdQ + paramString + hdS;
    AppMethodBeat.o(177056);
    return paramString;
  }
  
  public static String awt()
  {
    AppMethodBeat.i(200004);
    Object localObject1 = new StringBuilder();
    Object localObject2 = g.ah(d.class);
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject2 = ((d)localObject2).getProvider();
    p.g(localObject2, "MMKernel.plugin(IPluginEmoji::class.java).provider");
    localObject1 = ((e)localObject2).getAccPath() + "emoji/";
    AppMethodBeat.o(200004);
    return localObject1;
  }
  
  public static String awu()
  {
    return hdR;
  }
  
  public static String awv()
  {
    AppMethodBeat.i(200005);
    String str = b.aKC() + "emoji/";
    AppMethodBeat.o(200005);
    return str;
  }
  
  public static String aww()
  {
    AppMethodBeat.i(200006);
    String str = awv() + "emoji_anim/";
    AppMethodBeat.o(200006);
    return str;
  }
  
  public static void awx()
  {
    AppMethodBeat.i(177057);
    Object localObject = j.auL().dT(true);
    p.g(localObject, "emojiList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
      if (Util.isNullOrNil(localEmojiInfo.field_thumbUrl))
      {
        p.g(localEmojiInfo, "it");
        s.deleteFile(localEmojiInfo.hRN());
      }
    }
    AppMethodBeat.o(177057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */