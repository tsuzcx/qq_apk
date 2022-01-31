package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.emoji.e.d;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import java.util.List;

public final class a$a
  extends com.tencent.mm.ah.a<va>
{
  public a$a(EmojiInfo paramEmojiInfo, a.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
  {
    paramEmojiInfo = new uz();
    cat localcat = new cat();
    localcat.sRE = paramc.Wv();
    localcat.ndg = paramBoolean1.start;
    localcat.ndf = paramc.field_size;
    localcat.tPT = paramBoolean2;
    localcat.jnN = paramList;
    Object localObject;
    localcat.tPV = localObject;
    if (paramString2 != null) {
      localcat.tPU.addAll(paramString2);
    }
    paramEmojiInfo.sRL.add(localcat);
    paramEmojiInfo.sRN = paramString1;
    localcat.tPS = new b(a(paramc, paramBoolean1.start, paramBoolean1.bvi));
    paramc = new b.a();
    paramc.ecH = paramEmojiInfo;
    paramc.ecI = new va();
    paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramc.ecG = 703;
    this.dmK = paramc.Kt();
  }
  
  private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
    {
      localObject = d.aHc().a(paramEmojiInfo);
      if (!bk.bE((byte[])localObject))
      {
        paramEmojiInfo = new byte[paramInt2];
        y.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
        System.arraycopy(localObject, paramInt1, paramEmojiInfo, 0, paramInt2);
      }
    }
    for (;;)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo == null) {
        localObject = new byte[0];
      }
      return localObject;
      y.w("CgiEmojiUpload", "buffer is null.");
      paramEmojiInfo = new byte[0];
      continue;
      synchronized (a.b(this.iZj))
      {
        paramEmojiInfo.field_start = paramInt1;
        localObject = paramEmojiInfo.fh(paramInt1, paramInt2);
        paramEmojiInfo.field_start = 0;
        paramEmojiInfo = (EmojiInfo)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.a.a
 * JD-Core Version:    0.7.0.1
 */