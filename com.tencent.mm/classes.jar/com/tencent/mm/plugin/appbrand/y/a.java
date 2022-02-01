package com.tencent.mm.plugin.appbrand.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a
{
  public static boolean ciz()
  {
    AppMethodBeat.i(48237);
    c localc = com.tencent.mm.model.c.d.bgB().Mu("100159");
    if ((localc.isValid()) && ("1".equals(localc.hvz().get("isCloseWeappSearch")))) {}
    for (int i = 1; (i == 0) && ((!((b)h.ae(b.class)).ZM()) || (((b)h.ae(b.class)).gks() == 1)); i = 0)
    {
      AppMethodBeat.o(48237);
      return true;
    }
    AppMethodBeat.o(48237);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.a
 * JD-Core Version:    0.7.0.1
 */