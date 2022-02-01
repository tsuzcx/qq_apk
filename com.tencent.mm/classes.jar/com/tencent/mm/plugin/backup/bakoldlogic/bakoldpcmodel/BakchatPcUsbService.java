package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements com.tencent.mm.ak.f
{
  private boolean nDP = false;
  
  public final IBinder WY()
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
    ae.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    bc.ajj().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21916);
    bc.ajj().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ae.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    AppMethodBeat.o(21916);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21917);
    if ((paramn instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      stopSelf();
      AppMethodBeat.o(21917);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramn).bKz();
        if (this.nDP)
        {
          ae.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.bKg().bKj().bKk();
        }
        if ((!this.nDP) && (paramString.nJA == 1))
        {
          ae.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21917);
          return;
        }
        a.bKg().nxW = paramString.ID;
        a.bKg().nxX = paramString.FTc;
        a.bKg().nxY = paramString.FTd;
        a.bKg().bKh().eA(paramString.FSV, paramString.FSW);
        com.tencent.mm.plugin.backup.g.b.a(a.bKg().bKh());
        com.tencent.mm.plugin.backup.g.b.a(a.bKg().bKj());
        com.tencent.mm.plugin.backup.g.b.xv(1);
        a.bKg().bKj().f(paramString.nJA, paramString.FSU);
        AppMethodBeat.o(21917);
        return;
      }
      a.bKg().bKi().nGv = 2;
      a.bKg().bKi().aCO();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label375;
      }
      ae.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.nDP) {}
    }
    for (;;)
    {
      a.bKg().bKh();
      e.bKq();
      stopSelf();
      AppMethodBeat.o(21917);
      return;
      label375:
      ae.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21915);
    ae.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      ae.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      AppMethodBeat.o(21915);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21915);
      return 2;
    }
    this.nDP = paramIntent.getBooleanExtra("isFromWifi", false);
    ae.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.nDP) });
    a.bKg().bKi().aCO();
    paramIntent = a.bKg().bKi();
    if (this.nDP) {
      paramInt1 = 2;
    }
    paramIntent.nGu = paramInt1;
    if (!bc.aCh())
    {
      ae.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ak.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21915);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    bc.ajj().a(paramIntent, 0);
    AppMethodBeat.o(21915);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */