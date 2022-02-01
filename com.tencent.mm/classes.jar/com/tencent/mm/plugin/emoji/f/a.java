package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class a
  extends MTimerHandler
{
  private static int uFo;
  private static a uFp;
  private static r uFq;
  private static i uFr;
  
  static
  {
    AppMethodBeat.i(108667);
    uFo = 0;
    uFr = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.cUV().cUX();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.cUV().startTimer(50L);
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
  
  public static final a cUV()
  {
    AppMethodBeat.i(108662);
    if (uFp == null) {}
    for (;;)
    {
      try
      {
        if (uFp == null) {
          uFp = new a();
        }
        a locala = uFp;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      uFp.stopTimer();
    }
  }
  
  public static void cUW()
  {
    AppMethodBeat.i(108663);
    uFo = 0;
    uFq = new r("com.tencent.xin.emoticon.tusiji", 1);
    h.aHF().kcd.a(uFq, 0);
    h.aHF().kcd.a(413, uFr);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (uFq != null) {
      h.aHF().kcd.a(uFq);
    }
    h.aHF().kcd.b(413, uFr);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void cUX()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    p.cUT().i(com.tencent.mm.plugin.emoji.i.a.cWZ(), 3, uFo, "");
    removeListener();
    AppMethodBeat.o(108664);
  }
  
  public static final class a
    implements MTimerHandler.CallBack
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
      if (a.uFo >= 100)
      {
        a.access$002(0);
        Log.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        com.tencent.mm.storage.emotion.c localc = p.getEmojiStorageMgr().VFI;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.i.a.cWZ();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.YCp;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        p.cUT().i(com.tencent.mm.plugin.emoji.i.a.cWZ(), 7, a.uFo, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      p.cUT().i(com.tencent.mm.plugin.emoji.i.a.cWZ(), 6, a.uFo, "");
      a.access$002(a.uFo + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */