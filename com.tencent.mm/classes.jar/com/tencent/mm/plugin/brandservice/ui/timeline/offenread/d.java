package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class d
{
  static bxp ihH;
  
  public static bxp ayg()
  {
    if (ihH != null) {
      return ihH;
    }
    Object localObject = (String)g.DP().Dz().get(ac.a.uzr, "");
    if (bk.bl((String)localObject)) {
      return null;
    }
    bxp localbxp = new bxp();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localbxp.aH((byte[])localObject);
      return localbxp;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d
 * JD-Core Version:    0.7.0.1
 */