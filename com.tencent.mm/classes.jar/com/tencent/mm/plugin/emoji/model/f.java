package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class f
{
  Set<String> lhq;
  c<gc> lhr;
  private c.a lhs;
  
  public f()
  {
    AppMethodBeat.i(53052);
    this.lhr = new c() {};
    this.lhs = new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(53051);
        if ((paramAnonymousEmojiInfo != null) && (paramAnonymousBoolean) && (!bo.isNullOrNil(paramAnonymousEmojiInfo.field_md5)) && (f.this.lhq.remove(paramAnonymousEmojiInfo.Al())))
        {
          ab.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramAnonymousEmojiInfo.Al() });
          gc localgc = new gc();
          localgc.cuC.coO = 2;
          localgc.cuC.cuE = paramAnonymousEmojiInfo.field_designerID;
          localgc.cuC.name = paramAnonymousEmojiInfo.field_name;
          localgc.cuC.aeskey = paramAnonymousEmojiInfo.field_aeskey;
          localgc.cuC.cuF = paramAnonymousEmojiInfo.field_encrypturl;
          localgc.cuC.thumbUrl = paramAnonymousEmojiInfo.field_thumbUrl;
          localgc.cuC.cqq = paramAnonymousEmojiInfo.field_md5;
          localgc.cuC.cqx = paramAnonymousEmojiInfo.field_groupId;
          Object localObject = paramAnonymousEmojiInfo.dQB();
          EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(paramAnonymousEmojiInfo.Al());
          if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx))
          {
            File localFile = ah.getContext().getExternalCacheDir();
            if (localFile == null)
            {
              AppMethodBeat.o(53051);
              return;
            }
            paramAnonymousEmojiInfo = j.p(new b(localFile, com.tencent.mm.a.g.w(paramAnonymousEmojiInfo.Al().getBytes())).dQJ());
            if ((e.cN((String)localObject)) && (!e.cN(paramAnonymousEmojiInfo)))
            {
              localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(localEmojiInfo);
              e.a(paramAnonymousEmojiInfo, (byte[])localObject, localObject.length);
            }
          }
          for (localgc.cuD.path = paramAnonymousEmojiInfo;; localgc.cuD.path = ((String)localObject))
          {
            a.ymk.a(localgc, Looper.getMainLooper());
            AppMethodBeat.o(53051);
            return;
          }
        }
        ab.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
        AppMethodBeat.o(53051);
      }
    };
    this.lhq = Collections.synchronizedSet(new HashSet());
    i.blo().lhf = this.lhs;
    this.lhr.alive();
    AppMethodBeat.o(53052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.f
 * JD-Core Version:    0.7.0.1
 */