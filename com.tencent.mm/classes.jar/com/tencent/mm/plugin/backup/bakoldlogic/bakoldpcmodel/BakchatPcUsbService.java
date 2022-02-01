package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements g
{
  private boolean mXX = false;
  
  public final IBinder Uz()
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
    ac.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    az.agi().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21916);
    az.agi().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ac.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    AppMethodBeat.o(21916);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(21917);
    if ((paramn instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramn.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
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
        paramString = ((f)paramn).bFs();
        if (this.mXX)
        {
          ac.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.bEZ().bFc().bFd();
        }
        if ((!this.mXX) && (paramString.ndI == 1))
        {
          ac.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21917);
          return;
        }
        a.bEZ().mSc = paramString.ID;
        a.bEZ().mSd = paramString.DVl;
        a.bEZ().mSe = paramString.DVm;
        a.bEZ().bFa().eo(paramString.DVe, paramString.DVf);
        com.tencent.mm.plugin.backup.g.b.a(a.bEZ().bFa());
        com.tencent.mm.plugin.backup.g.b.a(a.bEZ().bFc());
        com.tencent.mm.plugin.backup.g.b.wK(1);
        a.bEZ().bFc().f(paramString.ndI, paramString.DVd);
        AppMethodBeat.o(21917);
        return;
      }
      a.bEZ().bFb().naD = 2;
      a.bEZ().bFb().azv();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label375;
      }
      ac.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.mXX) {}
    }
    for (;;)
    {
      a.bEZ().bFa();
      e.bFj();
      stopSelf();
      AppMethodBeat.o(21917);
      return;
      label375:
      ac.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21915);
    ac.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      ac.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      AppMethodBeat.o(21915);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21915);
      return 2;
    }
    this.mXX = paramIntent.getBooleanExtra("isFromWifi", false);
    ac.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.mXX) });
    a.bEZ().bFb().azv();
    paramIntent = a.bEZ().bFb();
    if (this.mXX) {
      paramInt1 = 2;
    }
    paramIntent.naC = paramInt1;
    if (!az.ayN())
    {
      ac.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ai.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21915);
      return 2;
    }
    paramIntent = new f(str);
    az.agi().a(paramIntent, 0);
    AppMethodBeat.o(21915);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */