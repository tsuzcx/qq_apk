package com.tencent.mm.booter;

import android.content.Intent;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.service.MMService;
import java.util.ArrayList;

public class NotifyReceiver$NotifyReceiverService
  extends MMService
{
  public final void onCreate()
  {
    AppMethodBeat.i(131904);
    super.onCreate();
    ac.i("MicroMsg.NotifyReceiverService", "onCreate()");
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
    ArrayList localArrayList = new ArrayList();
    NotifyReceiver.a(ai.getContext(), paramIntent, localArrayList);
    paramIntent = new IDKey();
    paramIntent.SetID(1042);
    paramIntent.SetKey(63);
    paramIntent.SetValue(1L);
    localArrayList.add(paramIntent);
    e.wTc.b(localArrayList, false);
    ac.i("MicroMsg.NotifyReceiverService", "onStartCommand()");
    AppMethodBeat.o(131905);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyReceiverService
 * JD-Core Version:    0.7.0.1
 */