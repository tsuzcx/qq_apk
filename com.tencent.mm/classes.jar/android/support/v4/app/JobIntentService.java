package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final HashMap<ComponentName, Object> DM = new HashMap();
  static final Object sLock = new Object();
  boolean DK = false;
  final ArrayList<Object> DL;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.DL = null;
      return;
    }
    this.DL = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */