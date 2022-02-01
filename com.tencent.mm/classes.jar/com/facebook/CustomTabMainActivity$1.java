package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class CustomTabMainActivity$1
  extends BroadcastReceiver
{
  private byte _hellAccFlag_;
  
  CustomTabMainActivity$1(CustomTabMainActivity paramCustomTabMainActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(7605);
    paramContext = new Intent(this.this$0, CustomTabMainActivity.class);
    paramContext.setAction(CustomTabMainActivity.REFRESH_ACTION);
    paramContext.putExtra(CustomTabMainActivity.EXTRA_URL, paramIntent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
    paramContext.addFlags(603979776);
    paramIntent = this.this$0;
    paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
    com.tencent.mm.hellhoundlib.a.a.a(paramIntent, paramContext.ahp(), "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramIntent.startActivity((Intent)paramContext.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramIntent, "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(7605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.CustomTabMainActivity.1
 * JD-Core Version:    0.7.0.1
 */