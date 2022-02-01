package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g
{
  Set<String> oxe;
  c<gj> oxf;
  private c.a oxg;
  
  public g()
  {
    AppMethodBeat.i(108591);
    this.oxf = new c() {};
    this.oxg = new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!bt.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (g.this.oxe.remove(paramAnonymousEmojiInfo.JS())))
        {
          ad.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.JS() });
          gj localgj = new gj();
          localgj.djz.dbV = 2;
          localgj.djz.djB = paramAnonymousEmojiInfo.field_designerID;
          localgj.djz.name = paramAnonymousEmojiInfo.field_name;
          localgj.djz.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgj.djz.djC = paramAnonymousEmojiInfo.field_encrypturl;
          localgj.djz.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgj.djz.md5 = paramAnonymousEmojiInfo.field_md5;
          localgj.djz.dft = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.gaa();
          EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().FyY.aJx(paramAnonymousEmojiInfo.JS());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl))
          {
            if (aj.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = q.B(new e(aj.getContext().getExternalCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramAnonymousEmojiInfo.JS().getBytes())).fhU());
            if ((i.eK((String)localObject)) && (!i.eK(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label315;
              }
              i.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgj.djA.path = paramAnonymousEmojiInfo;; localgj.djA.path = ((String)localObject))
          {
            a.ESL.a(localgj, Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label315:
            ad.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        ad.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.oxe = Collections.synchronizedSet(new HashSet());
    k.bUY().owM = this.oxg;
    this.oxf.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */