package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class BakchatPcUsbService
  extends MMService
  implements com.tencent.mm.ai.f
{
  private boolean jEC = false;
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.BakchatPcUsbService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(17857);
    ab.i("MicroMsg.BakchatPcUsbService", "onCreate()");
    super.onCreate();
    aw.Rc().a(595, this);
    com.tencent.mm.plugin.backup.g.b.a(1, this);
    AppMethodBeat.o(17857);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(17859);
    aw.Rc().b(595, this);
    com.tencent.mm.plugin.backup.g.b.b(1, this);
    super.onDestroy();
    ab.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    AppMethodBeat.o(17859);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17860);
    if ((paramm instanceof com.tencent.mm.plugin.backup.g.b))
    {
      if ((paramm.getType() == 1) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        paramString.addFlags(335544320);
        paramString.putExtra("nofification_type", "back_to_pcmgr_notification");
        startActivity(paramString);
      }
      stopSelf();
      AppMethodBeat.o(17860);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f)paramm).aVn();
        if (this.jEC)
        {
          ab.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
          a.aUU().aUX().aUY();
        }
        if ((!this.jEC) && (paramString.jKs == 1))
        {
          ab.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
          stopSelf();
          AppMethodBeat.o(17860);
          return;
        }
        a.aUU().jyF = paramString.ID;
        a.aUU().jyG = paramString.wtj;
        a.aUU().jyH = paramString.wtk;
        a.aUU().aUV().db(paramString.wtc, paramString.wtd);
        com.tencent.mm.plugin.backup.g.b.a(a.aUU().aUV());
        com.tencent.mm.plugin.backup.g.b.a(a.aUU().aUX());
        com.tencent.mm.plugin.backup.g.b.rg(1);
        a.aUU().aUX().e(paramString.jKs, paramString.wtb);
        AppMethodBeat.o(17860);
        return;
      }
      a.aUU().aUW().jHk = 2;
      a.aUU().aUW().abd();
      if ((paramInt1 != 4) || (paramInt2 != -2011)) {
        break label319;
      }
      ab.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
      if (!this.jEC) {}
    }
    for (;;)
    {
      a.aUU().aUV();
      e.aVe();
      stopSelf();
      AppMethodBeat.o(17860);
      return;
      label319:
      ab.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(17858);
    ab.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
    if (paramIntent == null)
    {
      ab.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
      AppMethodBeat.o(17858);
      return 2;
    }
    String str = paramIntent.getStringExtra("url");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
      stopSelf();
      AppMethodBeat.o(17858);
      return 2;
    }
    this.jEC = paramIntent.getBooleanExtra("isFromWifi", false);
    ab.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", new Object[] { str, Boolean.valueOf(this.jEC) });
    a.aUU().aUW().abd();
    paramIntent = a.aUU().aUW();
    if (this.jEC) {
      paramInt1 = 2;
    }
    paramIntent.jHj = paramInt1;
    if (!aw.aaB())
    {
      ab.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
      paramIntent = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("nofification_type", "back_to_pcmgr_notification");
      startActivity(paramIntent);
      AppMethodBeat.o(17858);
      return 2;
    }
    paramIntent = new com.tencent.mm.plugin.backup.bakoldlogic.c.f(str);
    aw.Rc().a(paramIntent, 0);
    AppMethodBeat.o(17858);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService
 * JD-Core Version:    0.7.0.1
 */