package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.go;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g
{
  Set<String> pKS;
  c<go> pKT;
  private c.a pKU;
  
  public g()
  {
    AppMethodBeat.i(108591);
    this.pKT = new c() {};
    this.pKU = new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(108590);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!bu.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (g.this.pKS.remove(paramAnonymousEmojiInfo.Lj())))
        {
          ae.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.Lj() });
          go localgo = new go();
          localgo.dty.dlO = 2;
          localgo.dty.dtA = paramAnonymousEmojiInfo.field_designerID;
          localgo.dty.name = paramAnonymousEmojiInfo.field_name;
          localgo.dty.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgo.dty.dtB = paramAnonymousEmojiInfo.field_encrypturl;
          localgo.dty.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgo.dty.md5 = paramAnonymousEmojiInfo.field_md5;
          localgo.dty.dpp = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.fSQ();
          EmojiInfo localEmojiInfo = k.getEmojiStorageMgr().JfU.aWl(paramAnonymousEmojiInfo.Lj());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp))
          {
            if (ak.getContext().getExternalCacheDir() == null)
            {
              AppMethodBeat.o(108590);
              return;
            }
            paramAnonymousEmojiInfo = w.B(new com.tencent.mm.vfs.k(ak.getContext().getExternalCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramAnonymousEmojiInfo.Lj().getBytes())).fTh());
            if ((o.fB((String)localObject)) && (!o.fB(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
              if (localObject == null) {
                break label315;
              }
              o.e(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgo.dtz.path = paramAnonymousEmojiInfo;; localgo.dtz.path = ((String)localObject))
          {
            a.IvT.a(localgo, Looper.getMainLooper());
            AppMethodBeat.o(108590);
            return;
            label315:
            ae.w("MicroMsg.FTS.FTSEmojiLogic", "onDownload: decrypt failed");
            break;
          }
        }
        ae.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(108590);
      }
    };
    this.pKS = Collections.synchronizedSet(new HashSet());
    k.cif().pKA = this.pKU;
    this.pKT.alive();
    AppMethodBeat.o(108591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g
 * JD-Core Version:    0.7.0.1
 */