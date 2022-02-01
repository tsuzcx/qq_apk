package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vending.c.a;

public final class e
  extends d
{
  public e(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104489);
    new f(paramEmojiInfo, paramBoolean, new d.a()
    {
      public final void A(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(104487);
        if (paramAnonymousInt == 0)
        {
          e.a(e.this, paramAnonymousString);
          AppMethodBeat.o(104487);
          return;
        }
        e.this.pt(paramAnonymousInt);
        AppMethodBeat.o(104487);
      }
    });
    AppMethodBeat.o(104489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.e
 * JD-Core Version:    0.7.0.1
 */