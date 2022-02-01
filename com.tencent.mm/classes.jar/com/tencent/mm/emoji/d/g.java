package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.b.l.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class g
  extends d
{
  public g(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    super(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.i(104496);
    new l(paramEmojiInfo, paramBoolean, paramEmojiInfo.field_attachedText, paramEmojiInfo.hRL(), paramEmojiInfo.field_imitateMd5).gXA = new l.b()
    {
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(104495);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          g.this.C(0, paramAnonymousString);
          AppMethodBeat.o(104495);
          return;
        }
        if (paramAnonymousBoolean)
        {
          g.this.pt(2);
          AppMethodBeat.o(104495);
          return;
        }
        g.this.pt(paramAnonymousInt2);
        AppMethodBeat.o(104495);
      }
    };
    AppMethodBeat.o(104496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.g
 * JD-Core Version:    0.7.0.1
 */