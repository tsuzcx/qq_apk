package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.w;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/GameStorageServiceImpl;", "Lcom/tencent/mm/plugin/game/api/IGameStorageService;", "()V", "getFromGamePbCacheStorage", "", "key", "", "saveToGamePbCacheStorage", "", "value", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.plugin.game.api.g
{
  public final byte[] aFm(String paramString)
  {
    AppMethodBeat.i(275288);
    if (paramString == null)
    {
      AppMethodBeat.o(275288);
      return null;
    }
    paramString = ((f)h.ax(f.class)).fCi().aFI(paramString);
    AppMethodBeat.o(275288);
    return paramString;
  }
  
  public final void w(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275286);
    if (paramString != null) {
      ((f)h.ax(f.class)).fCi().y(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(275286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.g
 * JD-Core Version:    0.7.0.1
 */