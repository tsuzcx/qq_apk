package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.gy;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class m
{
  Set<String> uEC;
  IListener<gy> uED;
  private i.a uEE;
  
  public m()
  {
    AppMethodBeat.i(108591);
    this.uED = new IListener() {};
    this.uEE = new i.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!Util.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (m.this.uEC.remove(paramAnonymousEmojiInfo.getMd5())))
        {
          Log.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.getMd5() });
          gy localgy = new gy();
          localgy.fDw.fvK = 2;
          localgy.fDw.fDy = paramAnonymousEmojiInfo.field_designerID;
          localgy.fDw.name = paramAnonymousEmojiInfo.field_name;
          localgy.fDw.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgy.fDw.fDz = paramAnonymousEmojiInfo.field_encrypturl;
          localgy.fDw.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgy.fDw.md5 = paramAnonymousEmojiInfo.field_md5;
          localgy.fDw.productId = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.ifh();
          EmojiInfo localEmojiInfo = p.getEmojiStorageMgr().VFH.bxK(paramAnonymousEmojiInfo.getMd5());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM))
          {
            if (MMApplicationContext.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = new q(MMApplicationContext.getContext().getExternalCacheDir(), g.getMessageDigest(paramAnonymousEmojiInfo.getMd5().getBytes())).bOF();
            if ((u.agG((String)localObject)) && (!u.agG(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label309;
              }
              u.F(paramAnonymousEmojiInfo, (byte[])localObject);
            }
          }
          for (localgy.fDx.path = paramAnonymousEmojiInfo;; localgy.fDx.path = ((String)localObject))
          {
            EventCenter.instance.asyncPublish(localgy, Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label309:
            Log.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        Log.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.uEC = Collections.synchronizedSet(new HashSet());
    p.cUM().uEk = this.uEE;
    this.uED.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.m
 * JD-Core Version:    0.7.0.1
 */