package com.tencent.mm.booter;

import android.content.Intent;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;

public class NotifyReceiver$NotifyReceiverService
  extends MMService
{
  public final void onCreate()
  {
    AppMethodBeat.i(131904);
    super.onCreate();
    Log.i("MicroMsg.NotifyReceiverService", "onCreate()");
    AppMethodBeat.o(131904);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(131906);
    super.onDestroy();
    AppMethodBeat.o(131906);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131905);
    final ArrayList localArrayList = new ArrayList();
    NotifyReceiver.a(MMApplicationContext.getContext(), paramIntent, localArrayList);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238918);
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(1042);
        localIDKey.SetKey(63);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
        f.Ozc.b(localArrayList, false);
        AppMethodBeat.o(238918);
      }
    }, "MicroMsg.NotifyReceiverService");
    Log.i("MicroMsg.NotifyReceiverService", "onStartCommand()");
    AppMethodBeat.o(131905);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyReceiverService
 * JD-Core Version:    0.7.0.1
 */