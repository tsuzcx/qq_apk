package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

class BaseWXApiImplV10$2
  implements PendingIntent.OnFinished
{
  BaseWXApiImplV10$2(BaseWXApiImplV10 paramBaseWXApiImplV10)
  {
    AppMethodBeat.i(196928);
    AppMethodBeat.o(196928);
  }
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(196929);
    Log.d("MicroMsg.SDK.WXApiImplV10", "onSendFinished resultCode: " + paramInt + ", resultData: " + paramString);
    AppMethodBeat.o(196929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.2
 * JD-Core Version:    0.7.0.1
 */