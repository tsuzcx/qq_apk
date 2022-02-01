package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.de;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private boolean oyT;
  public String oyw;
  private d ozL;
  private com.tencent.mm.plugin.emoji.f.g ozV;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108773);
    this.oyT = false;
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.oyw = paramString;
    AppMethodBeat.o(108773);
  }
  
  public b(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.oyT = false;
    if (bt.isNullOrNil(paramString)) {
      ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.oyw = paramString;
    this.oyT = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(d paramd)
  {
    this.ozL = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.ozV != null) && (!bt.isNullOrNil(this.ozV.hhN)))
    {
      f.awL().xL(this.ozV.hhN);
      ad.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.ozV.hhN });
      AppMethodBeat.o(108777);
      return;
    }
    ad.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(108777);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108776);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!bt.isNullOrNil(this.oyw)) && (!bt.isNullOrNil(paramObject.getKey())) && (this.oyw.equals(paramObject.getKey())))
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
    if (this.oyw == null) {
      return "";
    }
    return this.oyw;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.ozL != null) {
      this.ozL.Ue(getKey());
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ.cy(getKey(), true);
      if ((this.oyT) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new de();
      ((de)localObject).dfm.md5 = getKey();
      ((de)localObject).dfm.dbV = 2;
      ((de)localObject).dfm.success = true;
      a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(108775);
      return;
      ad.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.ozV = new com.tencent.mm.plugin.emoji.f.g(this.oyw);
    com.tencent.mm.kernel.g.afA().gcy.a(this.ozV, 0);
    Object localObject = new GetEmotionDetailResponse();
    com.tencent.mm.storage.emotion.k localk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzc.aJE(this.oyw);
    if ((localk != null) && (localk.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(localk.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.l(this.oyw, 15);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
      }
      AppMethodBeat.o(108775);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bt.m(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */