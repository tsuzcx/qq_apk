package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ct$1
  extends BroadcastReceiver
{
  ct$1(ct paramct) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramIntent.getBooleanExtra("noConnectivity", false))
        {
          ct.a(ct.a(this.a), 2000L);
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.ct.1
 * JD-Core Version:    0.7.0.1
 */