package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import com.tencent.mm.emoji.a.a.a;
import com.tencent.mm.plugin.emojicapture.model.c.c;
import com.tencent.mm.plugin.emojicapture.model.c.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"checkStickerValid", "", "item", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "plugin-emojicapture_release"})
public final class d
{
  public static final boolean a(c paramc)
  {
    AppMethodBeat.i(2646);
    j.q(paramc, "item");
    Object localObject = e.luf;
    localObject = e.uI(paramc.lvl);
    h localh = new h();
    a.a locala = a.ewm;
    a.a.a((String)localObject, (a)localh);
    if (localh.lvE >= paramc.lvn)
    {
      AppMethodBeat.o(2646);
      return true;
    }
    AppMethodBeat.o(2646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.d
 * JD-Core Version:    0.7.0.1
 */