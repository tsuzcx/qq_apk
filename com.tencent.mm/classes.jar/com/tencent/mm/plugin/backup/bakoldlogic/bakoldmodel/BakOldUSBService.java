package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakOldUSBService
  extends MMService
  implements com.tencent.mm.ai.f
{
  private boolean jEC = false;
  private int jGS = -1;
  
  private boolean aUS()
  {
    return (this.jGS == 0) || (this.jGS == 1);
  }
  
  public final IBinder It()
  {
    AppMethodBeat.i(17755);
    ab.i("MicroMsg.BakOldUSBService", "onBind()");
    AppMethodBeat.o(17755);
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BakOldUSBService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(17756);
    ab.i("MicroMsg.BakOldUSBService", "onCreate()");
    super.onCreate();
    aw.Rc().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(17756);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(17758);
    aw.Rc().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ab.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    AppMethodBeat.o(17758);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17759);
    String str;
    if (paramm == null)
    {
      str = "";
      ab.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str, Integer.valueOf(this.jGS) });
      if (!(paramm instanceof com.tencent.mm.plugin.backup.g.b)) {
        break label202;
      }
      ab.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(this.jGS) });
      if ((paramm.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        if (aUS()) {
          break label196;
        }
      }
    }
    label196:
    for (boolean bool = true;; bool = false)
    {
      paramString.putExtra("newPCBackup", bool);
      startActivity(paramString);
      stopSelf();
      AppMethodBeat.o(17759);
      return;
      str = paramm.getClass().getSimpleName();
      break;
    }
    label202:
    if ((paramm instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramm).aVn();
        a.aUU().jyF = paramString.ID;
        a.aUU().jyG = paramString.wtj;
        a.aUU().jyH = paramString.wtk;
        this.jGS = paramString.Scene;
        ab.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", new Object[] { Integer.valueOf(paramString.jKs), Integer.valueOf(paramString.Scene), Boolean.valueOf(this.jEC) });
        if ((!this.jEC) && (paramString.jKs == 1))
        {
          ab.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(17759);
          return;
        }
        if (aUS())
        {
          a.aUU().aUV().db(paramString.wtc, paramString.wtd);
          com.tencent.mm.plugin.backup.g.b.a(a.aUU().aUV());
          com.tencent.mm.plugin.backup.g.b.a(a.aUU().aUX());
          com.tencent.mm.plugin.backup.g.b.rg(1);
          a.aUU().aUX().e(paramString.jKs, paramString.wtb);
          AppMethodBeat.o(17759);
          return;
        }
        ab.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", new Object[] { Integer.valueOf(this.jGS) });
        AppMethodBeat.o(17759);
        return;
      }
      a.aUU().aUW().jHk = 2;
      a.aUU().aUW().abd();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label498;
      }
      ab.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
    }
    for (;;)
    {
      a.aUU().aUV();
      e.aVe();
      stopSelf();
      AppMethodBeat.o(17759);
      return;
      label498:
      ab.i("MicroMsg.BakOldUSBService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(17757);
    ab.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", new Object[] { Integer.valueOf(this.jGS) });
    if (paramIntent == null)
    {
      ab.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
      AppMethodBeat.o(17757);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(17757);
      return 2;
    }
    this.jEC = paramIntent.getBooleanExtra("isFromWifi", false);
    ab.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.jEC) });
    a.aUU().aUW().abd();
    paramIntent = a.aUU().aUW();
    if (this.jEC) {
      paramInt1 = 2;
    }
    paramIntent.jHj = paramInt1;
    if (!aw.aaB())
    {
      ab.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      startActivity(paramIntent);
      AppMethodBeat.o(17757);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    aw.Rc().a(paramIntent, 0);
    AppMethodBeat.o(17757);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService
 * JD-Core Version:    0.7.0.1
 */