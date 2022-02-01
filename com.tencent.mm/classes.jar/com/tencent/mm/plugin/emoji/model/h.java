package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class h
{
  private d.a rbA;
  Set<String> rby;
  IListener<gr> rbz;
  
  public h()
  {
    AppMethodBeat.i(108591);
    this.rbz = new IListener() {};
    this.rbA = new d.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!Util.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (h.this.rby.remove(paramAnonymousEmojiInfo.getMd5())))
        {
          Log.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.getMd5() });
          gr localgr = new gr();
          localgr.dKH.dDe = 2;
          localgr.dKH.dKJ = paramAnonymousEmojiInfo.field_designerID;
          localgr.dKH.name = paramAnonymousEmojiInfo.field_name;
          localgr.dKH.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgr.dKH.dKK = paramAnonymousEmojiInfo.field_encrypturl;
          localgr.dKH.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgr.dKH.md5 = paramAnonymousEmojiInfo.field_md5;
          localgr.dKH.productId = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.hRM();
          EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().OpN.blk(paramAnonymousEmojiInfo.getMd5());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK))
          {
            if (MMApplicationContext.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = aa.z(new o(MMApplicationContext.getContext().getExternalCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramAnonymousEmojiInfo.getMd5().getBytes())).her());
            if ((s.YS((String)localObject)) && (!s.YS(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label315;
              }
              s.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgr.dKI.path = paramAnonymousEmojiInfo;; localgr.dKI.path = ((String)localObject))
          {
            EventCenter.instance.asyncPublish(localgr, Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label315:
            Log.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        Log.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.rby = Collections.synchronizedSet(new HashSet());
    k.cGd().rbg = this.rbA;
    this.rbz.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */