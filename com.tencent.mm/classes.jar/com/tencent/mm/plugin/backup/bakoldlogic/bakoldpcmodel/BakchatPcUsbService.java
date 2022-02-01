package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements g
{
  private boolean mvW = false;
  
  public final IBinder TF()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BakchatPcUsbService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(21914);
    ad.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    az.aeS().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21916);
    az.aeS().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ad.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    AppMethodBeat.o(21916);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21917);
    if ((paramn instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      stopSelf();
      AppMethodBeat.o(21917);
      return;
    }
    if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramn).byw();
        if (this.mvW)
        {
          ad.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.byd().byg().byh();
        }
        if ((!this.mvW) && (paramString.mBH == 1))
        {
          ad.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21917);
          return;
        }
        a.byd().mqb = paramString.ID;
        a.byd().mqc = paramString.CCO;
        a.byd().mqd = paramString.CCP;
        a.byd().bye().ec(paramString.CCH, paramString.CCI);
        com.tencent.mm.plugin.backup.g.b.a(a.byd().bye());
        com.tencent.mm.plugin.backup.g.b.a(a.byd().byg());
        com.tencent.mm.plugin.backup.g.b.vT(1);
        a.byd().byg().f(paramString.mBH, paramString.CCG);
        AppMethodBeat.o(21917);
        return;
      }
      a.byd().byf().myC = 2;
      a.byd().byf().asE();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label375;
      }
      ad.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.mvW) {}
    }
    for (;;)
    {
      a.byd().bye();
      e.byn();
      stopSelf();
      AppMethodBeat.o(21917);
      return;
      label375:
      ad.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21915);
    ad.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      ad.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      AppMethodBeat.o(21915);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21915);
      return 2;
    }
    this.mvW = paramIntent.getBooleanExtra("isFromWifi", false);
    ad.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.mvW) });
    a.byd().byf().asE();
    paramIntent = a.byd().byf();
    if (this.mvW) {
      paramInt1 = 2;
    }
    paramIntent.myB = paramInt1;
    if (!az.arW())
    {
      ad.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21915);
      return 2;
    }
    paramIntent = new f(str);
    az.aeS().a(paramIntent, 0);
    AppMethodBeat.o(21915);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */