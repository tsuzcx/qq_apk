package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.io.IOException;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  public String pFG;
  private d pGW;
  private com.tencent.mm.plugin.emoji.f.g pGX;
  private boolean pGd;
  
  public a(String paramString)
  {
    AppMethodBeat.i(108773);
    this.pGd = false;
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pFG = paramString;
    AppMethodBeat.o(108773);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.pGd = false;
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pFG = paramString;
    this.pGd = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(d paramd)
  {
    this.pGW = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.pGX != null) && (!bt.isNullOrNil(this.pGX.ibe)))
    {
      f.aGI().EQ(this.pGX.ibe);
      ad.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.pGX.ibe });
      AppMethodBeat.o(108777);
      return;
    }
    ad.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(108777);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108776);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bt.isNullOrNil(this.pFG)) && (!bt.isNullOrNil(paramObject.getKey())) && (this.pFG.equals(paramObject.getKey())))
      {
        AppMethodBeat.o(108776);
        return true;
      }
    }
    AppMethodBeat.o(108776);
    return false;
  }
  
  public final String getKey()
  {
    if (this.pFG == null) {
      return "";
    }
    return this.pFG;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.pGW != null) {
      this.pGW.abW(getKey());
    }
    for (;;)
    {
      localObject = k.getEmojiStorageMgr().ILo.cJ(getKey(), true);
      if ((this.pGd) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new di();
      ((di)localObject).dod.md5 = getKey();
      ((di)localObject).dod.dkM = 2;
      ((di)localObject).dod.success = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(108775);
      return;
      ad.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.pGX = new com.tencent.mm.plugin.emoji.f.g(this.pFG);
    com.tencent.mm.kernel.g.ajB().gAO.a(this.pGX, 0);
    Object localObject = new GetEmotionDetailResponse();
    com.tencent.mm.storage.emotion.l locall = k.getEmojiStorageMgr().ILr.aUT(this.pFG);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(locall.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.l(this.pFG, 15);
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
      }
      AppMethodBeat.o(108775);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bt.n(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */