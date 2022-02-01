package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.emoji.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class l
{
  public static final l.a gmT;
  EmojiInfo glt;
  private final com.tencent.mm.pluginsdk.a.d gmR;
  b gmS;
  
  static
  {
    AppMethodBeat.i(105522);
    gmT = new l.a((byte)0);
    AppMethodBeat.o(105522);
  }
  
  public l(EmojiInfo paramEmojiInfo, b paramb)
  {
    AppMethodBeat.i(105521);
    this.glt = paramEmojiInfo;
    this.gmS = paramb;
    paramEmojiInfo = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    p.g(paramEmojiInfo, "plugin(IPluginEmoji::class.java)");
    this.gmR = ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr();
    int i;
    if (!o.fB(this.glt.fSQ()))
    {
      paramEmojiInfo = this.gmS;
      if (paramEmojiInfo != null) {
        paramEmojiInfo.x(10, null);
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
        paramEmojiInfo = h.gsA;
        h.a(this.glt, true, (d.a)new c(this));
      }
      AppMethodBeat.o(105521);
      return;
      if (o.aZR(this.glt.fSQ()) > this.gmR.d(this.glt, true))
      {
        paramEmojiInfo = this.gmS;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.x(2, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = j.gmz;
        if (j.afc())
        {
          if (this.glt.fxy() < 5)
          {
            this.glt.fxz();
            paramEmojiInfo = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(paramEmojiInfo, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr().updateEmojiInfo(this.glt);
            paramEmojiInfo = this.gmS;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.x(3, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.gmS;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.x(9, null);
            }
          }
        }
        i = 1;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void x(int paramInt, String paramString);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "gifMd5", "", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements d.a
  {
    c(l paraml) {}
    
    public final void y(int paramInt, String paramString)
    {
      AppMethodBeat.i(105520);
      if (paramInt == 0)
      {
        l.a(this.gmU, paramString);
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
        if (this.gmU.glt.fxy() < 5)
        {
          this.gmU.glt.fxz();
          paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().updateEmojiInfo(this.gmU.glt);
          if (paramInt == 3) {
            i = 3;
          }
        }
        break;
      }
      for (;;)
      {
        paramString = this.gmU.gmS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.l
 * JD-Core Version:    0.7.0.1
 */