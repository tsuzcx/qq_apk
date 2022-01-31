package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public final class l
{
  static ApplicationLike bXD;
  static String bYf = "";
  String bYg;
  String bYh;
  long bYi;
  long bYj;
  
  public l(ApplicationLike paramApplicationLike)
  {
    bXD = paramApplicationLike;
    b.bXD = paramApplicationLike;
  }
  
  static void a(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(115033);
    if (paramApplicationLike == null)
    {
      AppMethodBeat.o(115033);
      return;
    }
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null))
    {
      paramApplicationLike = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(115033);
      throw paramApplicationLike;
    }
    paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
    if ((paramApplicationLike != null) && (ShareIntentUtil.bc(paramApplicationLike) == 0)) {}
    for (paramApplicationLike = ShareIntentUtil.bi(paramApplicationLike);; paramApplicationLike = null)
    {
      if (paramApplicationLike != null)
      {
        a.eQt = (String)paramApplicationLike.get("patch.rev");
        ab.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s", new Object[] { a.eQt });
      }
      AppMethodBeat.o(115033);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.l
 * JD-Core Version:    0.7.0.1
 */