package com.tencent.liteav.screencapture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b$3
  extends BroadcastReceiver
{
  b$3(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult"))) {
      b.a(this.a, paramIntent.getIntExtra("TXScreenCapture.RequestCode", 0), paramIntent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent)paramIntent.getParcelableExtra("TXScreenCapture.ResultData"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b.3
 * JD-Core Version:    0.7.0.1
 */