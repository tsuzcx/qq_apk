package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final Object sLock = new Object();
  static final HashMap<ComponentName, Object> xg = new HashMap();
  boolean mStopped = false;
  boolean vF = false;
  boolean xe = false;
  final ArrayList<Object> xf;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.xf = null;
      return;
    }
    this.xf = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */