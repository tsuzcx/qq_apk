package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.wx_extension.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public class CDNDownloadService
  extends Service
  implements a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b qmE;
  private static g.a qmQ;
  private final a.a qmP;
  
  static
  {
    AppMethodBeat.i(120789);
    qmQ = new CDNDownloadService.2();
    AppMethodBeat.o(120789);
  }
  
  public CDNDownloadService()
  {
    AppMethodBeat.i(120781);
    this.qmP = new CDNDownloadService.1(this);
    AppMethodBeat.o(120781);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120782);
    Log.i("MicroMsg.CDNDownloadService", "onBind");
    paramIntent = this.qmP;
    AppMethodBeat.o(120782);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120784);
    super.onCreate();
    Log.i("MicroMsg.CDNDownloadService", "onCreate");
    AppMethodBeat.o(120784);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120785);
    super.onDestroy();
    Log.i("MicroMsg.CDNDownloadService", "onDestroy");
    b.a.ayr().b(this);
    h.CyF.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120785);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120783);
    Log.i("MicroMsg.CDNDownloadService", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120783);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService
 * JD-Core Version:    0.7.0.1
 */