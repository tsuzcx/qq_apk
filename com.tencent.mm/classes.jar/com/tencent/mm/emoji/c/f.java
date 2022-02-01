package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;

public final class f
  extends d
{
  int fPn;
  long startTime;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104493);
    this.startTime = 0L;
    this.fPn = 0;
    ac.i("MicroMsg.EmojiUploadCDN", "prepare: %s", new Object[] { this.fPB.field_md5 });
    new com.tencent.mm.emoji.a.f(this.fPB, this.fQJ).aBB().g(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(104493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */