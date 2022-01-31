package com.tencent.mm.app;

import com.tencent.mm.loader.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public final class j
{
  static ApplicationLike applicationLike;
  static String bwx = "";
  long bwA;
  long bwB;
  String bwy;
  String bwz;
  
  public j(ApplicationLike paramApplicationLike)
  {
    applicationLike = paramApplicationLike;
    b.applicationLike = paramApplicationLike;
  }
  
  static void a(ApplicationLike paramApplicationLike)
  {
    if (paramApplicationLike == null) {}
    for (;;)
    {
      return;
      if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
        throw new TinkerRuntimeException("tinkerApplication is null");
      }
      paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
      if ((paramApplicationLike != null) && (ShareIntentUtil.aA(paramApplicationLike) == 0)) {}
      for (paramApplicationLike = ShareIntentUtil.aG(paramApplicationLike); paramApplicationLike != null; paramApplicationLike = null)
      {
        a.dON = (String)paramApplicationLike.get("patch.rev");
        y.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s", new Object[] { a.dON });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */