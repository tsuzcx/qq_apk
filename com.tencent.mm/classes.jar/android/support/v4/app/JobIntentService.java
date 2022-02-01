package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final HashMap<ComponentName, Object> GL = new HashMap();
  static final Object sLock = new Object();
  boolean GJ = false;
  final ArrayList<Object> GK;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.GK = null;
      return;
    }
    this.GK = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */