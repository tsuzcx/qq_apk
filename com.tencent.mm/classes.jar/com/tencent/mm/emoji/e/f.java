package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.protocal.protobuf.fti;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;
import java.io.ByteArrayOutputStream;

public final class f
  extends d
{
  private int mgx;
  private String moi;
  private long startTime;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104493);
    this.startTime = 0L;
    this.mgx = 0;
    Log.i("MicroMsg.EmojiUploadCDN", "prepare: %s", new Object[] { this.mgK.field_md5 });
    new com.tencent.mm.emoji.c.f(this.mgK, this.mod).bFJ().g(new a() {});
    AppMethodBeat.o(104493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */