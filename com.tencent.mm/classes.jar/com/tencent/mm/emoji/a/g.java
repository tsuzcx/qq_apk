package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedEmojiMD5", "", "", "imitateMd5", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getAttachedEmojiMD5", "()Ljava/util/List;", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "getImitateMd5", "()Ljava/lang/String;", "dealSaveSuccess", "", "gifMd5", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class g
{
  public static final g.a ewV;
  EmojiInfo evH;
  final String ewH;
  private final com.tencent.mm.pluginsdk.a.d ewS;
  final List<String> ewT;
  g.b ewU;
  
  static
  {
    AppMethodBeat.i(63248);
    ewV = new g.a((byte)0);
    AppMethodBeat.o(63248);
  }
  
  public g(EmojiInfo paramEmojiInfo, List<String> paramList, String paramString, g.b paramb)
  {
    AppMethodBeat.i(63247);
    this.evH = paramEmojiInfo;
    this.ewT = paramList;
    this.ewH = paramString;
    this.ewU = paramb;
    paramEmojiInfo = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(paramEmojiInfo, "plugin(IPluginEmoji::class.java)");
    this.ewS = ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr();
    int i;
    if (!com.tencent.mm.vfs.e.cN(this.evH.dQB()))
    {
      paramEmojiInfo = this.ewU;
      if (paramEmojiInfo != null) {
        paramEmojiInfo.f(10, null, null);
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ab.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
        com.tencent.mm.kernel.g.RO().ac((Runnable)new g.c(this));
      }
      AppMethodBeat.o(63247);
      return;
      if (com.tencent.mm.vfs.e.avI(this.evH.dQB()) > this.ewS.e(this.evH, true))
      {
        paramEmojiInfo = this.ewU;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.f(2, null, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = e.ewz;
        if (e.OD())
        {
          if (5 > this.evH.dzy())
          {
            this.evH.dzz();
            paramEmojiInfo = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
            j.p(paramEmojiInfo, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr().updateEmojiInfo(this.evH);
            paramEmojiInfo = this.ewU;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.f(3, null, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.ewU;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.f(9, null, null);
            }
          }
        }
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */