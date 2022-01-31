package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.h.a.fz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.Set;

final class g$2
  implements d.a
{
  g$2(g paramg) {}
  
  public final void j(EmojiInfo paramEmojiInfo)
  {
    if ((paramEmojiInfo != null) && (this.iYp.iYm.remove(paramEmojiInfo.Wv())))
    {
      y.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[] { paramEmojiInfo.Wv() });
      fz localfz = new fz();
      localfz.bNk.bHz = 2;
      localfz.bNk.bNm = paramEmojiInfo.field_designerID;
      localfz.bNk.name = paramEmojiInfo.field_name;
      localfz.bNk.aeskey = paramEmojiInfo.field_aeskey;
      localfz.bNk.bNn = paramEmojiInfo.field_encrypturl;
      localfz.bNk.thumbUrl = paramEmojiInfo.field_thumbUrl;
      localfz.bNk.bIW = paramEmojiInfo.field_md5;
      localfz.bNk.bJd = paramEmojiInfo.field_groupId;
      Object localObject = paramEmojiInfo.cwL();
      EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().uBb.acC(paramEmojiInfo.Wv());
      if ((localEmojiInfo != null) && ((localEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo))
      {
        paramEmojiInfo = j.n(new b(ae.getContext().getExternalCacheDir(), com.tencent.mm.a.g.o(paramEmojiInfo.Wv().getBytes())).cLr());
        if ((e.bK((String)localObject)) && (!e.bK(paramEmojiInfo)))
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localEmojiInfo);
          e.a(paramEmojiInfo, (byte[])localObject, localObject.length);
        }
      }
      for (localfz.bNl.path = paramEmojiInfo;; localfz.bNl.path = ((String)localObject))
      {
        a.udP.a(localfz, Looper.getMainLooper());
        return;
      }
    }
    y.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.g.2
 * JD-Core Version:    0.7.0.1
 */