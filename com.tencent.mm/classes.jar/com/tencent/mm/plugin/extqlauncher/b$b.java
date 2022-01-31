package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nc.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class b$b
  extends c<nc>
{
  private b$b(b paramb)
  {
    AppMethodBeat.i(20479);
    this.__eventId = nc.class.getName().hashCode();
    AppMethodBeat.o(20479);
  }
  
  private boolean a(nc paramnc)
  {
    AppMethodBeat.i(20480);
    if (!b.a(this.mgf))
    {
      ab.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
      AppMethodBeat.o(20480);
      return false;
    }
    if (ah.getContext() == null)
    {
      ab.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
      AppMethodBeat.o(20480);
      return false;
    }
    ab.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(paramnc.cDm.bsY), paramnc.cDm.scanResult });
    do
    {
      try
      {
        int i = paramnc.cDm.bsY;
        switch (i)
        {
        }
      }
      catch (Exception paramnc)
      {
        for (;;)
        {
          Intent localIntent;
          ab.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { paramnc.getMessage() });
        }
      }
      AppMethodBeat.o(20480);
      return false;
    } while ((bo.isNullOrNil(paramnc.cDm.scanResult)) || (!paramnc.cDm.scanResult.startsWith("qlauncher://")));
    localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
    localIntent.setData(Uri.parse(paramnc.cDm.scanResult));
    localIntent.setFlags(268435456);
    ah.getContext().startActivity(localIntent);
    paramnc.cDn.ret = 1;
    AppMethodBeat.o(20480);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.b
 * JD-Core Version:    0.7.0.1
 */