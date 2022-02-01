package com.tencent.mm.plugin.emoji.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;

public final class a
  extends d
{
  private String uFI;
  private e uGZ;
  private boolean uGh;
  private com.tencent.mm.plugin.emoji.f.h uHa;
  
  public a(String paramString)
  {
    AppMethodBeat.i(108773);
    this.uGh = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.uFI = paramString;
    AppMethodBeat.o(108773);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.uGh = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.uFI = paramString;
    this.uGh = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(e parame)
  {
    this.uGZ = parame;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.uHa != null) && (!Util.isNullOrNil(this.uHa.lPn)))
    {
      f.bkg().Vz(this.uHa.lPn);
      Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.uHa.lPn });
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
      if ((!Util.isNullOrNil(this.uFI)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.uFI.equals(paramObject.getKey())))
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
    if (this.uFI == null) {
      return "";
    }
    return this.uFI;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.uGZ != null) {
      this.uGZ.auO(getKey());
    }
    for (;;)
    {
      localObject = p.getEmojiStorageMgr().VFI.dt(getKey(), true);
      if ((this.uGh) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new dr();
      ((dr)localObject).fzh.md5 = getKey();
      ((dr)localObject).fzh.fvK = 2;
      ((dr)localObject).fzh.success = true;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(108775);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.uHa = new com.tencent.mm.plugin.emoji.f.h(this.uFI);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.uHa, 0);
    Object localObject = new bud();
    l locall = p.getEmojiStorageMgr().VFL.bxT(this.uFI);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((bud)localObject).parseFrom(locall.field_content);
      if (((bud)localObject).VHU == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.m(this.uFI, 15);
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a.a
 * JD-Core Version:    0.7.0.1
 */