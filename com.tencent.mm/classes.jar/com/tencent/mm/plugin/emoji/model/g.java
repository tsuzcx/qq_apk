package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
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
  Set<String> paE;
  c<gk> paF;
  private c.a paG;
  
  public g()
  {
    AppMethodBeat.i(108591);
    this.paF = new c() {};
    this.paG = new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!bs.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (g.this.paE.remove(paramAnonymousEmojiInfo.JC())))
        {
          ac.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.JC() });
          gk localgk = new gk();
          localgk.dgU.cZu = 2;
          localgk.dgU.dgW = paramAnonymousEmojiInfo.field_designerID;
          localgk.dgU.name = paramAnonymousEmojiInfo.field_name;
          localgk.dgU.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgk.dgU.dgX = paramAnonymousEmojiInfo.field_encrypturl;
          localgk.dgU.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgk.dgU.md5 = paramAnonymousEmojiInfo.field_md5;
          localgk.dgU.dcO = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.ghd();
          EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().GXZ.aOT(paramAnonymousEmojiInfo.JC());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm))
          {
            if (ai.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = q.B(new e(ai.getContext().getExternalCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramAnonymousEmojiInfo.JC().getBytes())).fxV());
            if ((i.eA((String)localObject)) && (!i.eA(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label315;
              }
              i.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgk.dgV.path = paramAnonymousEmojiInfo;; localgk.dgV.path = ((String)localObject))
          {
            a.GpY.a(localgk, Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label315:
            ac.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        ac.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.paE = Collections.synchronizedSet(new HashSet());
    k.ccl().pam = this.paG;
    this.paF.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */