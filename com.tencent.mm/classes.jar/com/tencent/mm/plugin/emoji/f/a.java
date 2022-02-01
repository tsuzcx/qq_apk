package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a
  extends au
{
  private static int pbC;
  private static a pbD;
  private static q pbE;
  private static com.tencent.mm.ak.g pbF;
  
  static
  {
    AppMethodBeat.i(108667);
    pbC = 0;
    pbF = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.cct().ccv();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.cct().au(50L, 50L);
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
  
  public static final a cct()
  {
    AppMethodBeat.i(108662);
    if (pbD == null) {}
    for (;;)
    {
      try
      {
        if (pbD == null) {
          pbD = new a();
        }
        a locala = pbD;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      pbD.stopTimer();
    }
  }
  
  public static void ccu()
  {
    AppMethodBeat.i(108663);
    pbC = 0;
    pbE = new q("com.tencent.xin.emoticon.tusiji", 1);
    com.tencent.mm.kernel.g.agQ().ghe.a(pbE, 0);
    com.tencent.mm.kernel.g.agQ().ghe.a(413, pbF);
    ac.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (pbE != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(pbE);
    }
    com.tencent.mm.kernel.g.agQ().ghe.b(413, pbF);
    ac.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void ccv()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    k.ccr().h(com.tencent.mm.plugin.emoji.h.a.cew(), 3, pbC, "");
    removeListener();
    AppMethodBeat.o(108664);
  }
  
  public static final class a
    implements au.a
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
      if (a.pbC >= 100)
      {
        a.access$002(0);
        ac.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        c localc = k.getEmojiStorageMgr().GYa;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.cew();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        k.ccr().h(com.tencent.mm.plugin.emoji.h.a.cew(), 7, a.pbC, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      k.ccr().h(com.tencent.mm.plugin.emoji.h.a.cew(), 6, a.pbC, "");
      a.access$002(a.pbC + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */