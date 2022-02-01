package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.emoji.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class k
{
  public static final a fNo;
  EmojiInfo fLP;
  private final com.tencent.mm.pluginsdk.a.d fNm;
  b fNn;
  
  static
  {
    AppMethodBeat.i(105522);
    fNo = new a((byte)0);
    AppMethodBeat.o(105522);
  }
  
  public k(EmojiInfo paramEmojiInfo, b paramb)
  {
    AppMethodBeat.i(105521);
    this.fLP = paramEmojiInfo;
    this.fNn = paramb;
    paramEmojiInfo = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    d.g.b.k.g(paramEmojiInfo, "plugin(IPluginEmoji::class.java)");
    this.fNm = ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr();
    int i;
    if (!com.tencent.mm.vfs.i.eK(this.fLP.gaa()))
    {
      paramEmojiInfo = this.fNn;
      if (paramEmojiInfo != null) {
        paramEmojiInfo.x(10, null);
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
        paramEmojiInfo = h.fSH;
        h.a(this.fLP, true, (d.a)new c(this));
      }
      AppMethodBeat.o(105521);
      return;
      if (com.tencent.mm.vfs.i.aMN(this.fLP.gaa()) > this.fNm.d(this.fLP, true))
      {
        paramEmojiInfo = this.fNn;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.x(2, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = i.fMT;
        if (i.abm())
        {
          if (this.fLP.fZW() < 5)
          {
            this.fLP.fZX();
            paramEmojiInfo = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
            d.g.b.k.g(paramEmojiInfo, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr().updateEmojiInfo(this.fLP);
            paramEmojiInfo = this.fNn;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.x(3, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.fNn;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.x(9, null);
            }
          }
        }
        i = 1;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$Companion;", "", "()V", "CAPTURE_EMOJI_UPLOAD_MAX_COUNT", "", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void x(int paramInt, String paramString);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "gifMd5", "", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements d.a
  {
    c(k paramk) {}
    
    public final void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(105520);
      if (paramInt == 0)
      {
        k.a(this.fNp, paramString);
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
        if (this.fNp.fLP.fZW() < 5)
        {
          this.fNp.fLP.fZX();
          paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          d.g.b.k.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().updateEmojiInfo(this.fNp.fLP);
          if (paramInt == 3) {
            i = 3;
          }
        }
        break;
      }
      for (;;)
      {
        paramString = this.fNp.fNn;
        if (paramString == null) {
          break;
        }
        paramString.x(i, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.k
 * JD-Core Version:    0.7.0.1
 */