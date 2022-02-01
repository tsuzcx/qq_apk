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

public class CDNDownloadServiceSlot
  extends Service
  implements a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b qmE;
  private static g.a qmQ;
  private final a.a qmP;
  
  static
  {
    AppMethodBeat.i(120809);
    qmQ = new CDNDownloadServiceSlot.2();
    AppMethodBeat.o(120809);
  }
  
  public CDNDownloadServiceSlot()
  {
    AppMethodBeat.i(120801);
    this.qmP = new CDNDownloadServiceSlot.1(this);
    AppMethodBeat.o(120801);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120802);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onBind");
    paramIntent = this.qmP;
    AppMethodBeat.o(120802);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120804);
    super.onCreate();
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onCreate");
    AppMethodBeat.o(120804);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120805);
    super.onDestroy();
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onDestroy");
    b.a.ayr().b(this);
    h.CyF.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120805);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120803);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120803);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot
 * JD-Core Version:    0.7.0.1
 */