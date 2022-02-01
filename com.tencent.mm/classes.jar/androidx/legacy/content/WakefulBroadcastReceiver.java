package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;
import com.tencent.mm.hellhoundlib.b.c;

@Deprecated
public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
  private static int mNextId = 1;
  private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = new SparseArray();
  private byte _hellAccFlag_;
  
  public static boolean completeWakefulIntent(Intent arg0)
  {
    int i = ???.getIntExtra("androidx.contentpager.content.wakelockid", 0);
    if (i == 0) {
      return false;
    }
    synchronized (sActiveWakeLocks)
    {
      PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)sActiveWakeLocks.get(i);
      if (localWakeLock != null)
      {
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "androidx/legacy/content/WakefulBroadcastReceiver", "completeWakefulIntent", "(Landroid/content/Intent;)Z", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "androidx/legacy/content/WakefulBroadcastReceiver", "completeWakefulIntent", "(Landroid/content/Intent;)Z", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        sActiveWakeLocks.remove(i);
        return true;
      }
      return true;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (sActiveWakeLocks)
    {
      int i = mNextId;
      int j = mNextId + 1;
      mNextId = j;
      if (j <= 0) {
        mNextId = 1;
      }
      paramIntent.putExtra("androidx.contentpager.content.wakelockid", i);
      paramIntent = paramContext.startService(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      paramContext = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + paramIntent.flattenToShortString());
      paramContext.setReferenceCounted(false);
      com.tencent.mm.hellhoundlib.b.a locala = c.a(60000L, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, locala.aYi(), "androidx/legacy/content/WakefulBroadcastReceiver", "startWakefulService", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
      long l = ((Long)c.a(locala).sb(0)).longValue();
      c.aYk();
      paramContext.acquire(l);
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "androidx/legacy/content/WakefulBroadcastReceiver", "startWakefulService", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
      sActiveWakeLocks.put(i, paramContext);
      return paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.legacy.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */