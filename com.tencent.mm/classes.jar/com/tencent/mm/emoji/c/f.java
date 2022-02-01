package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;

public final class f
  extends d
{
  int giN;
  long startTime;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104493);
    this.startTime = 0L;
    this.giN = 0;
    ad.i("MicroMsg.EmojiUploadCDN", "prepare: %s", new Object[] { this.gjb.field_md5 });
    new com.tencent.mm.emoji.a.f(this.gjb, this.gkj).aED().g(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(104493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */