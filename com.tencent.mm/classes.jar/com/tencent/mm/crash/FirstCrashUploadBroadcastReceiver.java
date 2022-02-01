package com.tencent.mm.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.service.c;

public class FirstCrashUploadBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(194030);
    ae.i("MicroMsg.FirstCrashUploadBroadcastReceiver", "onReceive()");
    paramIntent.setClassName(paramContext, paramContext.getPackageName() + ".crash.CrashUploaderService");
    c.a(paramIntent, "cuploader", true, new Intent().setClassName(paramContext, paramContext.getPackageName() + ".crash.CuploaderProcessServicer"));
    AppMethodBeat.o(194030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.crash.FirstCrashUploadBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */