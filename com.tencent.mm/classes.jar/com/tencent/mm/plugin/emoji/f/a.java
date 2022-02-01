package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a
  extends aw
{
  private static int pLQ;
  private static a pLR;
  private static q pLS;
  private static f pLT;
  
  static
  {
    AppMethodBeat.i(108667);
    pLQ = 0;
    pLT = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.cin().cip();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.cin().ay(50L, 50L);
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
  
  public static final a cin()
  {
    AppMethodBeat.i(108662);
    if (pLR == null) {}
    for (;;)
    {
      try
      {
        if (pLR == null) {
          pLR = new a();
        }
        a locala = pLR;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      pLR.stopTimer();
    }
  }
  
  public static void cio()
  {
    AppMethodBeat.i(108663);
    pLQ = 0;
    pLS = new q("com.tencent.xin.emoticon.tusiji", 1);
    g.ajQ().gDv.a(pLS, 0);
    g.ajQ().gDv.a(413, pLT);
    ae.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (pLS != null) {
      g.ajQ().gDv.a(pLS);
    }
    g.ajQ().gDv.b(413, pLT);
    ae.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void cip()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    k.cil().h(com.tencent.mm.plugin.emoji.h.a.ckp(), 3, pLQ, "");
    removeListener();
    AppMethodBeat.o(108664);
  }
  
  public static final class a
    implements aw.a
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
      if (a.pLQ >= 100)
      {
        a.access$002(0);
        ae.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        c localc = k.getEmojiStorageMgr().JfV;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.ckp();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        k.cil().h(com.tencent.mm.plugin.emoji.h.a.ckp(), 7, a.pLQ, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      k.cil().h(com.tencent.mm.plugin.emoji.h.a.ckp(), 6, a.pLQ, "");
      a.access$002(a.pLQ + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */