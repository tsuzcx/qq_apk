package com.tencent.mm.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.c;

public class FirstCrashUploadBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(202465);
    Log.i("MicroMsg.FirstCrashUploadBroadcastReceiver", "onReceive()");
    paramIntent.setClassName(paramContext, MMApplicationContext.getSourcePackageName() + ".crash.CrashUploaderService");
    c.a(paramIntent, "cuploader", true, new Intent().setClassName(paramContext, MMApplicationContext.getSourcePackageName() + ".crash.CuploaderProcessServicer"));
    AppMethodBeat.o(202465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.crash.FirstCrashUploadBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */