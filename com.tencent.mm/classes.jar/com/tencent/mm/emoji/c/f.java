package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;

public final class f
  extends d
{
  int fLB;
  long startTime;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104493);
    this.startTime = 0L;
    this.fLB = 0;
    ad.i("MicroMsg.EmojiUploadCDN", "prepare: %s", new Object[] { this.fLP.field_md5 });
    new e(this.fLP, this.fMY).auK().g(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(104493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */