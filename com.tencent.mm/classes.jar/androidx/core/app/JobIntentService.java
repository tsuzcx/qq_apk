package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService
  extends Service
{
  static final HashMap<ComponentName, Object> boa = new HashMap();
  static final Object sLock = new Object();
  boolean bnY = false;
  final ArrayList<Object> bnZ;
  boolean mDestroyed = false;
  boolean mStopped = false;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.bnZ = null;
      return;
    }
    this.bnZ = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */