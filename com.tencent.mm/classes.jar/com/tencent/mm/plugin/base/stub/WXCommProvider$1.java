package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.pluginsdk.model.app.ar;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.y;

public class WXCommProvider$1
  extends BroadcastReceiver
{
  WXCommProvider$1(WXCommProvider paramWXCommProvider) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (System.currentTimeMillis() - ar.rVB >= 600000L) {
      y.e("MicroMsg.AppUtil", "hy: get comm model time expired");
    }
    for (paramContext = null;; paramContext = ar.rVA)
    {
      if (paramContext != null)
      {
        y.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
        paramContext = this.hSr.a(paramContext.uri, paramContext.projection, paramContext.selection, paramContext.selectionArgs, paramContext.rVy, paramContext.code, paramContext.rVz);
        if (paramContext != null) {
          paramContext.close();
        }
        p.ckW();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.1
 * JD-Core Version:    0.7.0.1
 */