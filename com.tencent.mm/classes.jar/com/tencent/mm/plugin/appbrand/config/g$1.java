package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

public final class g$1
  extends ai
{
  public g$1(g paramg) {}
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt >= 637863936) && (paramInt <= 637863988);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(129842);
    if (!kv(paramInt))
    {
      AppMethodBeat.o(129842);
      return;
    }
    try
    {
      ab.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
      Object localObject = com.tencent.mm.plugin.appbrand.app.g.auC();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.app.g)localObject).auD();
        com.tencent.mm.plugin.appbrand.app.g.auF();
        ((h)localObject).execSQL("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[] { "WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo" }));
        AppMethodBeat.o(129842);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", new Object[] { localException });
      AppMethodBeat.o(129842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g.1
 * JD-Core Version:    0.7.0.1
 */