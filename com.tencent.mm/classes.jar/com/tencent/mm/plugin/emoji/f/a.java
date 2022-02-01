package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a
  extends MTimerHandler
{
  private static int rcj;
  private static a rck;
  private static r rcl;
  private static i rcm;
  
  static
  {
    AppMethodBeat.i(108667);
    rcj = 0;
    rcm = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.cGm().cGo();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.cGm().startTimer(50L);
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
  
  public static final a cGm()
  {
    AppMethodBeat.i(108662);
    if (rck == null) {}
    for (;;)
    {
      try
      {
        if (rck == null) {
          rck = new a();
        }
        a locala = rck;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      rck.stopTimer();
    }
  }
  
  public static void cGn()
  {
    AppMethodBeat.i(108663);
    rcj = 0;
    rcl = new r("com.tencent.xin.emoticon.tusiji", 1);
    g.aAg().hqi.a(rcl, 0);
    g.aAg().hqi.a(413, rcm);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (rcl != null) {
      g.aAg().hqi.a(rcl);
    }
    g.aAg().hqi.b(413, rcm);
    Log.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void cGo()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 3, rcj, "");
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
      if (a.rcj >= 100)
      {
        a.access$002(0);
        Log.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        c localc = k.getEmojiStorageMgr().OpO;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.cIr();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 7, a.rcj, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 6, a.rcj, "");
      a.access$002(a.rcj + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */