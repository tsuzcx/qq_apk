package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements g
{
  private boolean mvW = false;
  private int myl = -1;
  
  private boolean byb()
  {
    return (this.myl == 0) || (this.myl == 1);
  }
  
  public final IBinder TF()
  {
    AppMethodBeat.i(21812);
    ad.i("MicroMsg.BakOldUSBService", "onBind()");
    AppMethodBeat.o(21812);
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BakOldUSBService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(21813);
    ad.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    az.aeS().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21813);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21815);
    az.aeS().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ad.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(21815);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21816);
    String str;
    if (paramn == null)
    {
      str = "";
      ad.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.myl) });
      if (!(paramn instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label257;
      }
      ad.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(this.myl) });
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (byb()) {
          break label251;
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      str = paramn.getClass().getSimpleName();
      break;
    }
    label257:
    if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramn).byw();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().mqb = paramString.ID;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().mqc = paramString.CCO;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().mqd = paramString.CCP;
        this.myl = paramString.Scene;
        ad.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.mBH), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.mvW) });
        if ((!this.mvW) && (paramString.mBH == 1))
        {
          ad.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21816);
          return;
        }
        if (byb())
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().ec(paramString.CCH, paramString.CCI);
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye());
          com.tencent.mm.plugin.backup.g.b.a(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byg());
          com.tencent.mm.plugin.backup.g.b.vT(1);
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byg().f(paramString.mBH, paramString.CCG);
          AppMethodBeat.o(21816);
          return;
        }
        ad.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.myl) });
        AppMethodBeat.o(21816);
        return;
      }
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byf().myC = 2;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byf().asE();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label554;
      }
      ad.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye();
      e.byn();
      stopSelf();
      AppMethodBeat.o(21816);
      return;
      label554:
      ad.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21814);
    ad.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.myl) });
    if (paramIntent == null)
    {
      ad.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(21814);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21814);
      return 2;
    }
    this.mvW = paramIntent.getBooleanExtra("isFromWifi", false);
    ad.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.mvW) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byf().asE();
    paramIntent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().byf();
    if (this.mvW) {
      paramInt1 = 2;
    }
    paramIntent.myB = paramInt1;
    if (!az.arW())
    {
      ad.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21814);
      return 2;
    }
    paramIntent = new f(str);
    az.aeS().a(paramIntent, 0);
    AppMethodBeat.o(21814);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */