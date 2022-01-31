package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.j;
import java.io.IOException;

public final class b
  extends c
{
  private boolean liQ;
  private String liu;
  private d ljD;
  private com.tencent.mm.plugin.emoji.f.g ljN;
  
  public b(String paramString)
  {
    AppMethodBeat.i(53202);
    this.liQ = false;
    if (bo.isNullOrNil(paramString)) {
      ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.liu = paramString;
    AppMethodBeat.o(53202);
  }
  
  public b(String paramString, byte paramByte)
  {
    AppMethodBeat.i(53203);
    this.liQ = false;
    if (bo.isNullOrNil(paramString)) {
      ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.liu = paramString;
    this.liQ = true;
    AppMethodBeat.o(53203);
  }
  
  public final void a(d paramd)
  {
    this.ljD = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(53206);
    if ((this.ljN != null) && (!bo.isNullOrNil(this.ljN.fFo)))
    {
      f.afO().sJ(this.ljN.fFo);
      ab.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.ljN.fFo });
      AppMethodBeat.o(53206);
      return;
    }
    ab.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(53206);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(53205);
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((!bo.isNullOrNil(this.liu)) && (!bo.isNullOrNil(paramObject.getKey())) && (this.liu.equals(paramObject.getKey())))
      {
        AppMethodBeat.o(53205);
        return true;
      }
    }
    AppMethodBeat.o(53205);
    return false;
  }
  
  public final String getKey()
  {
    if (this.liu == null) {
      return "";
    }
    return this.liu;
  }
  
  public final void run()
  {
    AppMethodBeat.i(53204);
    if (this.ljD != null) {
      this.ljD.KX(getKey());
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNo.cg(getKey(), true);
      if ((this.liQ) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new cy();
      ((cy)localObject).cqp.cqq = getKey();
      ((cy)localObject).cqp.coO = 2;
      ((cy)localObject).cqp.success = true;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(53204);
      return;
      ab.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.ljN = new com.tencent.mm.plugin.emoji.f.g(this.liu);
    com.tencent.mm.kernel.g.RK().eHt.a(this.ljN, 0);
    Object localObject = new GetEmotionDetailResponse();
    com.tencent.mm.storage.emotion.i locali = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNr.asW(this.liu);
    if ((locali != null) && (locali.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(locali.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new l(this.liu, 15);
        com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
      }
      AppMethodBeat.o(53204);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { bo.l(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.b
 * JD-Core Version:    0.7.0.1
 */