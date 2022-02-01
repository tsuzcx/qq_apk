package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.d.a;
import com.tencent.mm.emoji.d.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"})
public final class m
{
  public static final m.a gXL;
  EmojiInfo gWm;
  private final com.tencent.mm.pluginsdk.a.d gXJ;
  b gXK;
  
  static
  {
    AppMethodBeat.i(105522);
    gXL = new m.a((byte)0);
    AppMethodBeat.o(105522);
  }
  
  public m(EmojiInfo paramEmojiInfo, b paramb)
  {
    AppMethodBeat.i(105521);
    this.gWm = paramEmojiInfo;
    this.gXK = paramb;
    paramEmojiInfo = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
    p.g(paramEmojiInfo, "plugin(IPluginEmoji::class.java)");
    this.gXJ = ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr();
    int i;
    if (!s.YS(this.gWm.hRM()))
    {
      paramEmojiInfo = this.gXK;
      if (paramEmojiInfo != null) {
        paramEmojiInfo.z(10, null);
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.EmojiUploadLogic", "start upload emoji");
        paramEmojiInfo = h.hdL;
        h.a(this.gWm, true, (d.a)new c(this));
      }
      AppMethodBeat.o(105521);
      return;
      if (s.boW(this.gWm.hRM()) > this.gXJ.d(this.gWm, true))
      {
        paramEmojiInfo = this.gXK;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.z(2, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = k.gXr;
        if (k.auQ())
        {
          if (this.gWm.hRI() < 5)
          {
            this.gWm.hRJ();
            paramEmojiInfo = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(paramEmojiInfo, "MMKernel.plugin(IPluginEmoji::class.java)");
            ((com.tencent.mm.plugin.emoji.b.d)paramEmojiInfo).getEmojiMgr().updateEmojiInfo(this.gWm);
            paramEmojiInfo = this.gXK;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.z(3, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.gXK;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.z(9, null);
            }
          }
        }
        i = 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void z(int paramInt, String paramString);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "gifMd5", "", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements d.a
  {
    c(m paramm) {}
    
    public final void A(int paramInt, String paramString)
    {
      AppMethodBeat.i(105520);
      if (paramInt == 0)
      {
        m.a(this.gXM, paramString);
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
        if (this.gXM.gWm.hRI() < 5)
        {
          this.gXM.gWm.hRJ();
          paramString = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().updateEmojiInfo(this.gXM.gWm);
          if (paramInt == 3) {
            i = 3;
          }
        }
        break;
      }
      for (;;)
      {
        paramString = this.gXM.gXK;
        if (paramString == null) {
          break;
        }
        paramString.z(i, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.m
 * JD-Core Version:    0.7.0.1
 */