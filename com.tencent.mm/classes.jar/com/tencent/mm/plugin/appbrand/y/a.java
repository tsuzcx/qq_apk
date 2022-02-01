package com.tencent.mm.plugin.appbrand.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a
{
  public static boolean bVo()
  {
    AppMethodBeat.i(48237);
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100159");
    if ((localc.isValid()) && ("1".equals(localc.gzz().get("isCloseWeappSearch")))) {}
    for (int i = 1; (i == 0) && ((!((b)g.af(b.class)).Vt()) || (((b)g.af(b.class)).fvp() == 1)); i = 0)
    {
      AppMethodBeat.o(48237);
      return true;
    }
    AppMethodBeat.o(48237);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.a
 * JD-Core Version:    0.7.0.1
 */