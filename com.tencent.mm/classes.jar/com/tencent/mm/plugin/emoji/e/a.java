package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class a
  extends MTimerHandler
{
  private static int xNQ;
  private static a xNR;
  private static s xNS;
  private static com.tencent.mm.am.h xNT;
  
  static
  {
    AppMethodBeat.i(108667);
    xNQ = 0;
    xNT = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.dAs().dAu();
          AppMethodBeat.o(108659);
          return;
        }
        a.dAv();
        a.dAs().startTimer(50L);
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
  
  public static final a dAs()
  {
    AppMethodBeat.i(108662);
    if (xNR == null) {}
    for (;;)
    {
      try
      {
        if (xNR == null) {
          xNR = new a();
        }
        a locala = xNR;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      xNR.stopTimer();
    }
  }
  
  public static void dAt()
  {
    AppMethodBeat.i(108663);
    xNQ = 0;
    xNS = new s("com.tencent.xin.emoticon.tusiji", 1);
    com.tencent.mm.kernel.h.baD().mCm.a(xNS, 0);
    com.tencent.mm.kernel.h.baD().mCm.a(413, xNT);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (xNS != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(xNS);
    }
    com.tencent.mm.kernel.h.baD().mCm.b(413, xNT);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void dAu()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    com.tencent.mm.plugin.emoji.model.s.dAq().i(com.tencent.mm.plugin.emoji.g.c.dDt(), 3, xNQ, "");
    removeListener();
    AppMethodBeat.o(108664);
  }
  
  public static final class a
    implements MTimerHandler.CallBack
  {
    public a()
    {
      AppMethodBeat.i(108660);
      a.dAv();
      AppMethodBeat.o(108660);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(108661);
      if (a.xNQ >= 100)
      {
        a.dAv();
        Log.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        com.tencent.mm.storage.emotion.c localc = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.g.c.dDt();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.akly;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.b(localEmojiGroupInfo);
        com.tencent.mm.plugin.emoji.model.s.dAq().i(com.tencent.mm.plugin.emoji.g.c.dDt(), 7, a.xNQ, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      com.tencent.mm.plugin.emoji.model.s.dAq().i(com.tencent.mm.plugin.emoji.g.c.dDt(), 6, a.xNQ, "");
      a.dAw();
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a
 * JD-Core Version:    0.7.0.1
 */