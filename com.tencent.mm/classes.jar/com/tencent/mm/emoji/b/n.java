package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class n
{
  public static final n.a jIK;
  EmojiInfo jHh;
  private final com.tencent.mm.pluginsdk.b.d jII;
  b jIJ;
  
  static
  {
    AppMethodBeat.i(105522);
    jIK = new n.a((byte)0);
    AppMethodBeat.o(105522);
  }
  
  public n(EmojiInfo paramEmojiInfo, b paramb)
  {
    AppMethodBeat.i(105521);
    this.jHh = paramEmojiInfo;
    this.jIJ = paramb;
    paramEmojiInfo = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramEmojiInfo, "plugin(IPluginEmoji::class.java)");
    this.jII = ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr();
    int i;
    if (!u.agG(this.jHh.ifh()))
    {
      paramEmojiInfo = this.jIJ;
      if (paramEmojiInfo != null) {
        paramEmojiInfo.A(10, null);
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
        paramEmojiInfo = com.tencent.mm.emoji.d.h.jPr;
        com.tencent.mm.emoji.d.h.a(this.jHh, true, (d.a)new c(this));
      }
      AppMethodBeat.o(105521);
      return;
      if (u.bBQ(this.jHh.ifh()) > this.jII.d(this.jHh, true))
      {
        paramEmojiInfo = this.jIJ;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.A(2, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = l.jIq;
        if (l.aBM())
        {
          if (this.jHh.hBC() < 5)
          {
            this.jHh.hBD();
            paramEmojiInfo = this.jIJ;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.A(3, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.jIJ;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.A(9, null);
            }
          }
        }
        i = 1;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void A(int paramInt, String paramString);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "gifMd5", "", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements d.a
  {
    c(n paramn) {}
    
    public final void B(int paramInt, String paramString)
    {
      AppMethodBeat.i(105520);
      if (paramInt == 0)
      {
        n.a(this.jIL, paramString);
        AppMethodBeat.o(105520);
        return;
      }
      int i = paramInt;
      switch (paramInt)
      {
      case 3: 
      case 9: 
      case 10: 
      default: 
        if (this.jIL.jHh.hBC() < 5)
        {
          this.jIL.jHh.hBD();
          paramString = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
          p.j(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().updateEmojiInfo(this.jIL.jHh);
          if (paramInt == 3) {
            i = 3;
          }
        }
        break;
      }
      for (;;)
      {
        paramString = this.jIL.jIJ;
        if (paramString == null) {
          break;
        }
        paramString.A(i, null);
        AppMethodBeat.o(105520);
        return;
        i = 1;
        continue;
        i = 9;
      }
      AppMethodBeat.o(105520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.n
 * JD-Core Version:    0.7.0.1
 */