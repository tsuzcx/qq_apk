package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a
  extends av
{
  private static int pFm;
  private static a pFn;
  private static q pFo;
  private static f pFp;
  
  static
  {
    AppMethodBeat.i(108667);
    pFm = 0;
    pFp = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.cgX().cgZ();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.cgX().az(50L, 50L);
        AppMethodBeat.o(108659);
      }
    };
    AppMethodBeat.o(108667);
  }
  
  private a()
  {
    super(new a(), true);
    AppMethodBeat.i(108666);
    AppMethodBeat.o(108666);
  }
  
  public static final a cgX()
  {
    AppMethodBeat.i(108662);
    if (pFn == null) {}
    for (;;)
    {
      try
      {
        if (pFn == null) {
          pFn = new a();
        }
        a locala = pFn;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      pFn.stopTimer();
    }
  }
  
  public static void cgY()
  {
    AppMethodBeat.i(108663);
    pFm = 0;
    pFo = new q("com.tencent.xin.emoticon.tusiji", 1);
    g.ajB().gAO.a(pFo, 0);
    g.ajB().gAO.a(413, pFp);
    ad.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (pFo != null) {
      g.ajB().gAO.a(pFo);
    }
    g.ajB().gAO.b(413, pFp);
    ad.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void cgZ()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    k.cgV().h(com.tencent.mm.plugin.emoji.h.a.ciZ(), 3, pFm, "");
    removeListener();
    AppMethodBeat.o(108664);
  }
  
  public static final class a
    implements av.a
  {
    public a()
    {
      AppMethodBeat.i(108660);
      a.access$002(0);
      AppMethodBeat.o(108660);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(108661);
      if (a.pFm >= 100)
      {
        a.access$002(0);
        ad.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        c localc = k.getEmojiStorageMgr().ILo;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.ciZ();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        k.cgV().h(com.tencent.mm.plugin.emoji.h.a.ciZ(), 7, a.pFm, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      k.cgV().h(com.tencent.mm.plugin.emoji.h.a.ciZ(), 6, a.pFm, "");
      a.access$002(a.pFm + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */