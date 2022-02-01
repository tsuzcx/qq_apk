package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a
  extends av
{
  private static int oyc;
  private static a oyd;
  private static q oye;
  private static com.tencent.mm.al.g oyf;
  
  static
  {
    AppMethodBeat.i(108667);
    oyc = 0;
    oyf = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(108659);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          a.bVg().bVi();
          AppMethodBeat.o(108659);
          return;
        }
        a.access$002(0);
        a.bVg().av(50L, 50L);
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
  
  public static final a bVg()
  {
    AppMethodBeat.i(108662);
    if (oyd == null) {}
    for (;;)
    {
      try
      {
        if (oyd == null) {
          oyd = new a();
        }
        a locala = oyd;
        AppMethodBeat.o(108662);
        return locala;
      }
      finally
      {
        AppMethodBeat.o(108662);
      }
      oyd.stopTimer();
    }
  }
  
  public static void bVh()
  {
    AppMethodBeat.i(108663);
    oyc = 0;
    oye = new q("com.tencent.xin.emoticon.tusiji", 1);
    com.tencent.mm.kernel.g.afA().gcy.a(oye, 0);
    com.tencent.mm.kernel.g.afA().gcy.a(413, oyf);
    ad.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    AppMethodBeat.o(108663);
  }
  
  public static void removeListener()
  {
    AppMethodBeat.i(108665);
    if (oye != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(oye);
    }
    com.tencent.mm.kernel.g.afA().gcy.b(413, oyf);
    ad.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    AppMethodBeat.o(108665);
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(108664);
    stopTimer();
    k.bVe().g(com.tencent.mm.plugin.emoji.h.a.bXj(), 3, oyc, "");
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
      if (a.oyc >= 100)
      {
        a.access$002(0);
        ad.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
        c localc = k.getEmojiStorageMgr().FyZ;
        EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
        localEmojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.bXj();
        localEmojiGroupInfo.field_packName = "emoji_custom_all";
        localEmojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
        localEmojiGroupInfo.field_sort = 1;
        localEmojiGroupInfo.field_idx = 0;
        localEmojiGroupInfo.field_packType = 4;
        localEmojiGroupInfo.field_packFlag = 1;
        localEmojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        localc.c(localEmojiGroupInfo);
        k.bVe().g(com.tencent.mm.plugin.emoji.h.a.bXj(), 7, a.oyc, "");
        a.removeListener();
        AppMethodBeat.o(108661);
        return false;
      }
      k.bVe().g(com.tencent.mm.plugin.emoji.h.a.bXj(), 6, a.oyc, "");
      a.access$002(a.oyc + 2);
      AppMethodBeat.o(108661);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a
 * JD-Core Version:    0.7.0.1
 */