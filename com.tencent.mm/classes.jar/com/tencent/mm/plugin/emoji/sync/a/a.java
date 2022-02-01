package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import java.io.IOException;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  private boolean pMH;
  public String pMk;
  private d pNA;
  private com.tencent.mm.plugin.emoji.f.g pNB;
  
  public a(String paramString)
  {
    AppMethodBeat.i(108773);
    this.pMH = false;
    if (bu.isNullOrNil(paramString)) {
      ae.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pMk = paramString;
    AppMethodBeat.o(108773);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.pMH = false;
    if (bu.isNullOrNil(paramString)) {
      ae.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.pMk = paramString;
    this.pMH = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(d paramd)
  {
    this.pNA = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.pNB != null) && (!bu.isNullOrNil(this.pNB.idX)))
    {
      f.aGZ().Fs(this.pNB.idX);
      ae.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.pNB.idX });
      AppMethodBeat.o(108777);
      return;
    }
    ae.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(108777);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108776);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!bu.isNullOrNil(this.pMk)) && (!bu.isNullOrNil(paramObject.getKey())) && (this.pMk.equals(paramObject.getKey())))
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
    if (this.pMk == null) {
      return "";
    }
    return this.pMk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.pNA != null) {
      this.pNA.acN(getKey());
    }
    for (;;)
    {
      localObject = k.getEmojiStorageMgr().JfV.cN(getKey(), true);
      if ((this.pMH) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new dj();
      ((dj)localObject).dpi.md5 = getKey();
      ((dj)localObject).dpi.dlO = 2;
      ((dj)localObject).dpi.success = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(108775);
      return;
      ae.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.pNB = new com.tencent.mm.plugin.emoji.f.g(this.pMk);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pNB, 0);
    Object localObject = new GetEmotionDetailResponse();
    com.tencent.mm.storage.emotion.l locall = k.getEmojiStorageMgr().JfY.aWu(this.pMk);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(locall.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.l(this.pMk, 15);
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
      }
      AppMethodBeat.o(108775);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bu.o(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */