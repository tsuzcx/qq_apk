package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

final class a$5
  implements Runnable
{
  a$5(a parama, ComponentName paramComponentName) {}
  
  public final void run()
  {
    a.g(this.gyo);
    Intent localIntent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
    localIntent.putExtra("category", "payment");
    localIntent.putExtra("component", this.gyq);
    a.h(this.gyo).startActivityForResult(localIntent, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.5
 * JD-Core Version:    0.7.0.1
 */