package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.model.ah;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

public final class h$1
  extends ah
{
  public h$1(h paramh) {}
  
  public final String getTag()
  {
    return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt >= 637863936) && (paramInt <= 637863988);
  }
  
  public final void transfer(int paramInt)
  {
    if (!hJ(paramInt)) {}
    for (;;)
    {
      return;
      try
      {
        y.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
        Object localObject = e.aaP();
        if (localObject != null)
        {
          localObject = ((e)localObject).aaQ();
          e.aaT();
          ((com.tencent.mm.cf.h)localObject).gk("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[] { "WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo" }));
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.h.1
 * JD-Core Version:    0.7.0.1
 */