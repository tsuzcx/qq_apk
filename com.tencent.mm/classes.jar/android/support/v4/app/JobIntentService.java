package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final HashMap<ComponentName, Object> GB = new HashMap();
  static final Object sLock = new Object();
  final ArrayList<Object> GA;
  boolean Gz = false;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.GA = null;
      return;
    }
    this.GA = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */