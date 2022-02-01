package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.l;
import java.io.IOException;

public final class a
  extends com.tencent.mm.plugin.emoji.sync.c
{
  public String rcD;
  private d rdU;
  private h rdV;
  private boolean rdb;
  
  public a(String paramString)
  {
    AppMethodBeat.i(108773);
    this.rdb = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.rcD = paramString;
    AppMethodBeat.o(108773);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(108774);
    this.rdb = false;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
    }
    this.rcD = paramString;
    this.rdb = true;
    AppMethodBeat.o(108774);
  }
  
  public final void a(d paramd)
  {
    this.rdU = paramd;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108777);
    if ((this.rdV != null) && (!Util.isNullOrNil(this.rdV.iYT)))
    {
      f.baQ().Oc(this.rdV.iYT);
      Log.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[] { this.rdV.iYT });
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
      if ((!Util.isNullOrNil(this.rcD)) && (!Util.isNullOrNil(paramObject.getKey())) && (this.rcD.equals(paramObject.getKey())))
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
    if (this.rcD == null) {
      return "";
    }
    return this.rcD;
  }
  
  public final void run()
  {
    AppMethodBeat.i(108775);
    if (this.rdU != null) {
      this.rdU.amU(getKey());
    }
    for (;;)
    {
      localObject = k.getEmojiStorageMgr().OpO.di(getKey(), true);
      if ((this.rdb) || (localObject == null) || (((EmojiGroupInfo)localObject).field_sync != 2) || (((EmojiGroupInfo)localObject).field_status != 7)) {
        break;
      }
      localObject = new dm();
      ((dm)localObject).dGw.md5 = getKey();
      ((dm)localObject).dGw.dDe = 2;
      ((dm)localObject).dGw.success = true;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(108775);
      return;
      Log.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
    }
    this.rdV = new h(this.rcD);
    g.aAg().hqi.a(this.rdV, 0);
    Object localObject = new GetEmotionDetailResponse();
    l locall = k.getEmojiStorageMgr().OpR.blt(this.rcD);
    if ((locall != null) && (locall.field_content != null)) {}
    try
    {
      ((GetEmotionDetailResponse)localObject).parseFrom(locall.field_content);
      if (((GetEmotionDetailResponse)localObject).EmotionDetail == null)
      {
        localObject = new com.tencent.mm.plugin.emoji.f.m(this.rcD, 15);
        g.aAg().hqi.a((q)localObject, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a.a
 * JD-Core Version:    0.7.0.1
 */