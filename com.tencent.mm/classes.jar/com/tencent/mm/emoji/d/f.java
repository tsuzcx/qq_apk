package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.g.a;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;

public final class f
  extends d
{
  int gVY;
  private String hdI;
  long startTime;
  
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104493);
    this.startTime = 0L;
    this.gVY = 0;
    Log.i("MicroMsg.EmojiUploadCDN", "prepare: %s", new Object[] { this.gWm.field_md5 });
    new com.tencent.mm.emoji.b.f(this.gWm, this.gXv).aYI().g(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(104493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.f
 * JD-Core Version:    0.7.0.1
 */