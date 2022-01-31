package com.tencent.mm.emoji.loader.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/emoji/loader/fetcher/EmojiCoverFetcher$fetch$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"})
public final class b$b
  implements h.a
{
  public b$b(EmojiInfo paramEmojiInfo, a.f.a.b paramb) {}
  
  public final void cd(boolean paramBoolean)
  {
    AppMethodBeat.i(63177);
    ab.i("MicroMsg.EmojiCoverFetcher", "onResult: " + this.evz.Al() + ", " + paramBoolean);
    if (paramBoolean)
    {
      localObject = b.evy;
      if (b.a.d(this.evz))
      {
        localObject = this.evA;
        if (localObject != null)
        {
          ((a.f.a.b)localObject).S(Boolean.TRUE);
          AppMethodBeat.o(63177);
          return;
        }
        AppMethodBeat.o(63177);
        return;
      }
      localObject = this.evA;
      if (localObject != null)
      {
        ((a.f.a.b)localObject).S(Boolean.FALSE);
        AppMethodBeat.o(63177);
        return;
      }
      AppMethodBeat.o(63177);
      return;
    }
    Object localObject = this.evA;
    if (localObject != null)
    {
      ((a.f.a.b)localObject).S(Boolean.FALSE);
      AppMethodBeat.o(63177);
      return;
    }
    AppMethodBeat.o(63177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.b.b
 * JD-Core Version:    0.7.0.1
 */