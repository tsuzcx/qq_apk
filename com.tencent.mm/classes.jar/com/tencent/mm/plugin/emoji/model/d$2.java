package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.j.f.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;

final class d$2
  implements f.a
{
  d$2(d paramd, as paramas, EmojiInfo paramEmojiInfo, long paramLong) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0)) {
      this.iYc.iXU.a(true, new Object[] { this.iYd, this.iWy, Integer.valueOf(103), Long.valueOf(this.byn) });
    }
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d.2
 * JD-Core Version:    0.7.0.1
 */