package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
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
  Set<String> pEo;
  c<gn> pEp;
  private c.a pEq;
  
  public g()
  {
    AppMethodBeat.i(108591);
    this.pEp = new c() {};
    this.pEq = new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!bt.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (g.this.pEo.remove(paramAnonymousEmojiInfo.Lb())))
        {
          ad.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.Lb() });
          gn localgn = new gn();
          localgn.dsr.dkM = 2;
          localgn.dsr.dsu = paramAnonymousEmojiInfo.field_designerID;
          localgn.dsr.name = paramAnonymousEmojiInfo.field_name;
          localgn.dsr.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgn.dsr.dsv = paramAnonymousEmojiInfo.field_encrypturl;
          localgn.dsr.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgn.dsr.md5 = paramAnonymousEmojiInfo.field_md5;
          localgn.dsr.dok = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.gzQ();
          EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().ILn.aUK(paramAnonymousEmojiInfo.Lb());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi))
          {
            if (aj.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = q.B(new e(aj.getContext().getExternalCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramAnonymousEmojiInfo.Lb().getBytes())).fOK());
            if ((i.fv((String)localObject)) && (!i.fv(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label315;
              }
              i.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgn.dss.path = paramAnonymousEmojiInfo;; localgn.dss.path = ((String)localObject))
          {
            a.IbL.a(localgn, Looper.getMainLooper());
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
    this.pEo = Collections.synchronizedSet(new HashSet());
    k.cgP().pDW = this.pEq;
    this.pEp.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */