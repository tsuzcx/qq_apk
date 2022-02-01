package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.b.m;
import com.tencent.mm.emoji.b.m.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class g
  extends d
{
  public g(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104496);
    new m(paramEmojiInfo, paramBoolean, paramEmojiInfo.field_attachedText, paramEmojiInfo.ifg(), paramEmojiInfo.field_imitateMd5).jIy = new m.b()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(104495);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          g.this.D(0, paramAnonymousString);
        }
        for (;;)
        {
          paramAnonymousString = l.jIq;
          l.aBO();
          AppMethodBeat.o(104495);
          return;
          if (paramAnonymousBoolean) {
            g.this.rP(2);
          } else {
            g.this.rP(paramAnonymousInt2);
          }
        }
      }
    };
    AppMethodBeat.o(104496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.d.g
 * JD-Core Version:    0.7.0.1
 */