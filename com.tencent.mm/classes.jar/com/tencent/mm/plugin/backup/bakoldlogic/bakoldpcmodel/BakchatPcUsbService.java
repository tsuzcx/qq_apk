package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements com.tencent.mm.al.f
{
  private boolean nyu = false;
  
  public final IBinder WQ()
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
    ba.aiU().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21916);
    ba.aiU().b(595, this);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
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
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramn).bJB();
        if (this.nyu)
        {
          ad.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.bJi().bJl().bJm();
        }
        if ((!this.nyu) && (paramString.nEf == 1))
        {
          ad.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21917);
          return;
        }
        a.bJi().nsB = paramString.ID;
        a.bJi().nsC = paramString.FAG;
        a.bJi().nsD = paramString.FAH;
        a.bJi().bJj().ex(paramString.FAz, paramString.FAA);
        com.tencent.mm.plugin.backup.g.b.a(a.bJi().bJj());
        com.tencent.mm.plugin.backup.g.b.a(a.bJi().bJl());
        com.tencent.mm.plugin.backup.g.b.xq(1);
        a.bJi().bJl().f(paramString.nEf, paramString.FAy);
        AppMethodBeat.o(21917);
        return;
      }
      a.bJi().bJk().nBa = 2;
      a.bJi().bJk().aCy();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label375;
      }
      ad.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.nyu) {}
    }
    for (;;)
    {
      a.bJi().bJj();
      e.bJs();
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
    this.nyu = paramIntent.getBooleanExtra("isFromWifi", false);
    ad.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.nyu) });
    a.bJi().bJk().aCy();
    paramIntent = a.bJi().bJk();
    if (this.nyu) {
      paramInt1 = 2;
    }
    paramIntent.nAZ = paramInt1;
    if (!ba.aBR())
    {
      ad.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(aj.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21915);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    ba.aiU().a(paramIntent, 0);
    AppMethodBeat.o(21915);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */