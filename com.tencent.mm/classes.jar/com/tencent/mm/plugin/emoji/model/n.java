package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hj;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class n
{
  Set<String> xMZ;
  IListener<hj> xNa;
  private i.a xNb;
  
  public n()
  {
    AppMethodBeat.i(108591);
    this.xNa = new FTSEmojiLogic.1(this, com.tencent.mm.app.f.hfK);
    this.xNb = new i.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!Util.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (n.this.xMZ.remove(paramAnonymousEmojiInfo.getMd5())))
        {
          Log.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.getMd5() });
          hj localhj = new hj();
          localhj.hIm.hAf = 2;
          localhj.hIm.hIo = paramAnonymousEmojiInfo.field_designerID;
          localhj.hIm.name = paramAnonymousEmojiInfo.field_name;
          localhj.hIm.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localhj.hIm.hIp = paramAnonymousEmojiInfo.field_encrypturl;
          localhj.hIm.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localhj.hIm.md5 = paramAnonymousEmojiInfo.field_md5;
          localhj.hIm.productId = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.kMn();
          EmojiInfo localEmojiInfo = s.getEmojiStorageMgr().adju.bza(paramAnonymousEmojiInfo.getMd5());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb))
          {
            if (MMApplicationContext.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = ah.v(new u(MMApplicationContext.getContext().getExternalCacheDir(), g.getMessageDigest(paramAnonymousEmojiInfo.getMd5().getBytes())).jKT());
            if ((y.ZC((String)localObject)) && (!y.ZC(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label312;
              }
              y.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localhj.hIn.path = paramAnonymousEmojiInfo;; localhj.hIn.path = ((String)localObject))
          {
            localhj.asyncPublish(Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label312:
            Log.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        Log.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.xMZ = Collections.synchronizedSet(new HashSet());
    s.dAj().xMB = this.xNb;
    this.xNa.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.n
 * JD-Core Version:    0.7.0.1
 */