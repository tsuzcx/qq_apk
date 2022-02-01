package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.df;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.io.IOException;

public final class b
  extends com.tencent.mm.plugin.emoji.sync.c
{
  public String pbW;
  private boolean pct;
  private d pdl;
  private com.tencent.mm.plugin.emoji.f.g pdv;
  
  public b(String paramString)
  {
    AppMethodBeat.i(108773);
    this.pct = false;
    if (bs.isNullOrNil(paramString)) {
      ac.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pbW = paramString;
    AppMethodBeat.o(108773);
  }
  
  public b(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.pct = false;
    if (bs.isNullOrNil(paramString)) {
      ac.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pbW = paramString;
    this.pct = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(d paramd)
  {
    this.pdl = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.pdv != null) && (!bs.isNullOrNil(this.pdv.hIq)))
    {
      f.aDD().BR(this.pdv.hIq);
      ac.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.pdv.hIq });
      AppMethodBeat.o(108777);
      return;
    }
    ac.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(108777);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108776);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!bs.isNullOrNil(this.pbW)) && (!bs.isNullOrNil(paramObject.getKey())) && (this.pbW.equals(paramObject.getKey())))
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
    if (this.pbW == null) {
      return "";
    }
    return this.pbW;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.pdl != null) {
      this.pdl.Yq(getKey());
    }
    for (;;)
    {
      localObject = k.getEmojiStorageMgr().GYa.cE(getKey(), true);
      if ((this.pct) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new df();
      ((df)localObject).dcH.md5 = getKey();
      ((df)localObject).dcH.cZu = 2;
      ((df)localObject).dcH.success = true;
      a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(108775);
      return;
      ac.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.pdv = new com.tencent.mm.plugin.emoji.f.g(this.pbW);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.pdv, 0);
    Object localObject = new GetEmotionDetailResponse();
    com.tencent.mm.storage.emotion.l locall = k.getEmojiStorageMgr().GYd.aPc(this.pbW);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(locall.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.l(this.pbW, 15);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
      }
      AppMethodBeat.o(108775);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bs.m(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */