package com.tencent.liteav.screencapture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$7
  extends BroadcastReceiver
{
  b$7(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(66764);
    if ((paramIntent != null) && (paramIntent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult"))) {
      b.a(this.a, paramIntent.getIntExtra("TXScreenCapture.RequestCode", 0), paramIntent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent)paramIntent.getParcelableExtra("TXScreenCapture.ResultData"));
    }
    AppMethodBeat.o(66764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b.7
 * JD-Core Version:    0.7.0.1
 */