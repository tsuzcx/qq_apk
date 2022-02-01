package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements i
{
  private boolean oOM = false;
  
  public final IBinder akL()
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
    Log.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    bg.azz().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(21914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21916);
    bg.azz().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    Log.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    AppMethodBeat.o(21916);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(21917);
    if ((paramq instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramq.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      stopSelf();
      AppMethodBeat.o(21917);
      return;
    }
    if ((paramq instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramq).chs();
        if (this.oOM)
        {
          Log.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.cgZ().chc().chd();
        }
        if ((!this.oOM) && (paramString.oUv == 1))
        {
          Log.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(21917);
          return;
        }
        a.cgZ().oIU = paramString.ID;
        a.cgZ().oIV = paramString.KML;
        a.cgZ().oIW = paramString.KMM;
        a.cgZ().cha().eR(paramString.KME, paramString.KMF);
        com.tencent.mm.plugin.backup.g.b.a(a.cgZ().cha());
        com.tencent.mm.plugin.backup.g.b.a(a.cgZ().chc());
        com.tencent.mm.plugin.backup.g.b.Bb(1);
        a.cgZ().chc().f(paramString.oUv, paramString.KMD);
        AppMethodBeat.o(21917);
        return;
      }
      a.cgZ().chb().oRs = 2;
      a.cgZ().chb().aWm();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label375;
      }
      Log.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.oOM) {}
    }
    for (;;)
    {
      a.cgZ().cha();
      e.chj();
      stopSelf();
      AppMethodBeat.o(21917);
      return;
      label375:
      Log.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(21915);
    Log.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      Log.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      AppMethodBeat.o(21915);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(21915);
      return 2;
    }
    this.oOM = paramIntent.getBooleanExtra("isFromWifi", false);
    Log.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.oOM) });
    a.cgZ().chb().aWm();
    paramIntent = a.cgZ().chb();
    if (this.oOM) {
      paramInt1 = 2;
    }
    paramIntent.oRr = paramInt1;
    if (!bg.aVG())
    {
      Log.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(21915);
      return 2;
    }
    paramIntent = new f(str);
    bg.azz().a(paramIntent, 0);
    AppMethodBeat.o(21915);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */