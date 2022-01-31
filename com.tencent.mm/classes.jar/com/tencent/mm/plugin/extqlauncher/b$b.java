package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.h.a.mi;
import com.tencent.mm.h.a.mi.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$b
  extends c<mi>
{
  private b$b(b paramb)
  {
    this.udX = mi.class.getName().hashCode();
  }
  
  private boolean a(mi parammi)
  {
    if (!b.a(this.jMb)) {
      y.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
    }
    for (;;)
    {
      return false;
      if (ae.getContext() == null)
      {
        y.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
        return false;
      }
      y.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[] { Integer.valueOf(parammi.bVB.bcw), parammi.bVB.scanResult });
      try
      {
        switch (parammi.bVB.bcw)
        {
        case 0: 
          if ((!bk.bl(parammi.bVB.scanResult)) && (parammi.bVB.scanResult.startsWith("qlauncher://")))
          {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
            localIntent.setData(Uri.parse(parammi.bVB.scanResult));
            localIntent.setFlags(268435456);
            ae.getContext().startActivity(localIntent);
            parammi.bVC.ret = 1;
            return true;
          }
          break;
        }
      }
      catch (Exception parammi)
      {
        y.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[] { parammi.getMessage() });
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.b
 * JD-Core Version:    0.7.0.1
 */