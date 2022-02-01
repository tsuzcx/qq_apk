package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.e.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getCallback", "()Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "setCallback", "(Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "emojiMgr", "Lcom/tencent/mm/pluginsdk/defimpl/IEmojiMgr;", "kotlin.jvm.PlatformType", "dealSaveSuccess", "", "gifMd5", "", "doUpload", "preCheck", "", "Companion", "EmojiUploadCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n.a mia;
  private EmojiInfo mgK;
  private b mib;
  private final com.tencent.mm.pluginsdk.b.d mic;
  
  static
  {
    AppMethodBeat.i(105522);
    mia = new n.a((byte)0);
    AppMethodBeat.o(105522);
  }
  
  public n(EmojiInfo paramEmojiInfo, b paramb)
  {
    AppMethodBeat.i(105521);
    this.mgK = paramEmojiInfo;
    this.mib = paramb;
    this.mic = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr();
    int i;
    if (!y.ZC(this.mgK.kMn()))
    {
      paramEmojiInfo = this.mib;
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
        paramEmojiInfo = g.mok;
        g.a(this.mgK, true, new n..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(105521);
      return;
      if (y.bEl(this.mgK.kMn()) > this.mic.d(this.mgK, true))
      {
        paramEmojiInfo = this.mib;
        if (paramEmojiInfo != null) {
          paramEmojiInfo.A(2, null);
        }
        i = 0;
      }
      else
      {
        paramEmojiInfo = m.mhY;
        if (m.aUK())
        {
          if (this.mgK.field_captureUploadCounter < 5)
          {
            this.mgK.kMk();
            paramEmojiInfo = this.mib;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.A(3, null);
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramEmojiInfo = this.mib;
            if (paramEmojiInfo != null) {
              paramEmojiInfo.A(9, null);
            }
          }
        }
        i = 1;
      }
    }
  }
  
  private static final void a(n paramn, int paramInt, String paramString)
  {
    AppMethodBeat.i(242643);
    s.u(paramn, "this$0");
    if (paramInt == 0)
    {
      Log.i("MicroMsg.EmojiUploadLogic", s.X("deal success ", paramString));
      if ((paramString != null) && (!s.p(paramString, paramn.mgK.getMd5())))
      {
        EmojiInfo localEmojiInfo = paramn.mic.aof(paramString);
        s.s(localEmojiInfo, "emojiMgr.getEmojiByMd5(gifMd5)");
        paramn.mgK = localEmojiInfo;
      }
      paramn.mic.a(paramn.mgK, false);
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().t(paramn.mgK);
      paramn = paramn.mib;
      if (paramn != null) {
        paramn.A(0, paramString);
      }
      AppMethodBeat.o(242643);
      return;
    }
    int i = paramInt;
    switch (paramInt)
    {
    case 3: 
    case 9: 
    case 10: 
    default: 
      if (paramn.mgK.field_captureUploadCounter < 5)
      {
        paramn.mgK.kMk();
        ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(paramn.mgK);
        if (paramInt == 3) {
          i = 3;
        }
      }
      break;
    }
    for (;;)
    {
      paramn = paramn.mib;
      if (paramn != null) {
        paramn.A(i, null);
      }
      AppMethodBeat.o(242643);
      return;
      i = 1;
      continue;
      i = 9;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EmojiUploadLogic$EmojiUploadCallback;", "", "uploadCallback", "", "errorCode", "", "gifMd5", "", "activityId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void A(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.n
 * JD-Core Version:    0.7.0.1
 */