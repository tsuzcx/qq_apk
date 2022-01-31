package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import java.util.List;

public final class f$a
  extends a<zo>
{
  public f$a(EmojiInfo paramEmojiInfo, f.c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(62242);
    paramEmojiInfo = new zn();
    cnz localcnz = new cnz();
    localcnz.wQr = paramc.Al();
    localcnz.pIy = paramBoolean1.start;
    localcnz.pIx = paramc.field_size;
    localcnz.xWO = paramBoolean2;
    localcnz.wQh = paramList;
    Object localObject;
    localcnz.xWQ = localObject;
    localcnz.wQj = paramc.field_lensId;
    localcnz.wQi = paramc.field_attachTextColor;
    if (paramString2 != null) {
      localcnz.xWP.addAll(paramString2);
    }
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      paramEmojiInfo.wsX = i;
      paramEmojiInfo.wQy.add(localcnz);
      paramEmojiInfo.wQA = paramString1;
      localcnz.xWN = new b(a(paramc, paramBoolean1.start, paramBoolean1.bWt));
      paramc = new b.a();
      paramc.fsX = paramEmojiInfo;
      paramc.fsY = new zo();
      paramc.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
      paramc.funcId = 703;
      this.rr = paramc.ado();
      AppMethodBeat.o(62242);
      return;
    }
  }
  
  private byte[] a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62243);
    Object localObject;
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
    {
      localObject = ((d)g.G(d.class)).getProvider().l(paramEmojiInfo);
      if (!bo.ce((byte[])localObject))
      {
        paramEmojiInfo = new byte[paramInt2];
        ab.d("CgiEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(paramInt2) });
        System.arraycopy(localObject, paramInt1, paramEmojiInfo, 0, paramInt2);
      }
    }
    for (;;)
    {
      localObject = paramEmojiInfo;
      if (paramEmojiInfo == null) {
        localObject = new byte[0];
      }
      AppMethodBeat.o(62243);
      return localObject;
      ab.w("CgiEmojiUpload", "buffer is null.");
      paramEmojiInfo = new byte[0];
      continue;
      synchronized (f.b(this.ewQ))
      {
        paramEmojiInfo.field_start = paramInt1;
        localObject = paramEmojiInfo.ho(paramInt1, paramInt2);
        paramEmojiInfo.field_start = 0;
        paramEmojiInfo = (EmojiInfo)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f.a
 * JD-Core Version:    0.7.0.1
 */