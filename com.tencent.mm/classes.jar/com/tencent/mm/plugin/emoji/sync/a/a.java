package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.eb;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;

public final class a
  extends d
{
  private boolean xOL;
  private String xOk;
  private e xPF;
  private com.tencent.mm.plugin.emoji.e.h xPG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(108773);
    this.xOL = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.xOk = paramString;
    AppMethodBeat.o(108773);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.xOL = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.xOk = paramString;
    this.xOL = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(e parame)
  {
    this.xPF = parame;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.xPG != null) && (!Util.isNullOrNil(this.xPG.oHX)))
    {
      if (k.bHW().Nz(this.xPG.oHX))
      {
        Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.xPG.oHX });
        AppMethodBeat.o(108777);
        return;
      }
      Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack clientid:%s", new Object[] { this.xPG.oHX });
      AppMethodBeat.o(108777);
      return;
    }
    Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
    AppMethodBeat.o(108777);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108776);
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((!Util.isNullOrNil(this.xOk)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.xOk.equals(paramObject.getKey())))
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
    if (this.xOk == null) {
      return "";
    }
    return this.xOk;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.xPF != null) {
      this.xPF.aoN(getKey());
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.ec(getKey(), true);
      if ((this.xOL) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new eb();
      ((eb)localObject).hDQ.md5 = getKey();
      ((eb)localObject).hDQ.hAf = 2;
      ((eb)localObject).hDQ.success = true;
      ((eb)localObject).publish();
      AppMethodBeat.o(108775);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.xPG = new com.tencent.mm.plugin.emoji.e.h(this.xOk);
    com.tencent.mm.kernel.h.baD().mCm.a(this.xPG, 0);
    Object localObject = new goe();
    l locall = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjz.bzj(this.xOk);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((goe)localObject).parseFrom(locall.field_content);
      if (((goe)localObject).akkU == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.e.m(this.xOk, 15);
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      }
      AppMethodBeat.o(108775);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */