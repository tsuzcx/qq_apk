package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(104487);
        if (paramAnonymousInt == 0)
        {
          e.a(e.this, paramAnonymousString);
          AppMethodBeat.o(104487);
          return;
        }
        e.this.mg(paramAnonymousInt);
        AppMethodBeat.o(104487);
      }
    });
    AppMethodBeat.o(104489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.e
 * JD-Core Version:    0.7.0.1
 */