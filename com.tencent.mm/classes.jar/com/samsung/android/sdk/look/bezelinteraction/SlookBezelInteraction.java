package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction
{
  public static final String SERVICE_NAME = "BezelInteractionService";
  private static final String TAG = "SlookBezelInteraction";
  private static Context mContext = null;
  private static IBezelManager mService = null;
  private final CopyOnWriteArrayList<SlookBezelInteraction.BezelListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList();
  
  public SlookBezelInteraction(Context paramContext)
  {
    mContext = paramContext;
    getService();
  }
  
  /* Error */
  private IBezelManager getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 29	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   5: ifnonnull +22 -> 27
    //   8: ldc 13
    //   10: invokestatic 50	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   13: invokestatic 56	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   16: putstatic 29	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   19: getstatic 29	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: getstatic 29	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   30: invokeinterface 62 1 0
    //   35: invokeinterface 68 1 0
    //   40: ifne -21 -> 19
    //   43: ldc 13
    //   45: invokestatic 50	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   48: invokestatic 56	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   51: putstatic 29	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   54: goto -35 -> 19
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	SlookBezelInteraction
    //   22	4	1	localIBezelManager	IBezelManager
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	57	finally
    //   19	23	57	finally
    //   27	54	57	finally
  }
  
  public final void enableBezelInteraction(boolean paramBoolean)
  {
    try
    {
      IBezelManager localIBezelManager = getService();
      if (localIBezelManager != null) {
        localIBezelManager.enableBezelInteraction(paramBoolean);
      }
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final void registerListener(BezelListener paramBezelListener)
  {
    if (paramBezelListener == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.mListenerDelegates)
      {
        Object localObject = this.mListenerDelegates.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localBezelListenerDelegate = (SlookBezelInteraction.BezelListenerDelegate)((Iterator)localObject).next();
          if (!localBezelListenerDelegate.getListener().equals(paramBezelListener)) {
            continue;
          }
          localObject = localBezelListenerDelegate;
          if (localBezelListenerDelegate == null)
          {
            localObject = new SlookBezelInteraction.BezelListenerDelegate(paramBezelListener, null);
            this.mListenerDelegates.add(localObject);
          }
          try
          {
            paramBezelListener = getService();
            if (paramBezelListener != null) {
              paramBezelListener.registerCallback((IBinder)localObject, new ComponentName(mContext.getPackageName(), mContext.getClass().getCanonicalName()));
            }
          }
          catch (RemoteException paramBezelListener)
          {
            continue;
          }
          return;
        }
      }
      SlookBezelInteraction.BezelListenerDelegate localBezelListenerDelegate = null;
    }
  }
  
  public final void unregisterListener(BezelListener paramBezelListener)
  {
    if (paramBezelListener == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.mListenerDelegates)
      {
        Iterator localIterator = this.mListenerDelegates.iterator();
        if (!localIterator.hasNext()) {
          break label112;
        }
        localObject = (SlookBezelInteraction.BezelListenerDelegate)localIterator.next();
        if (!((SlookBezelInteraction.BezelListenerDelegate)localObject).getListener().equals(paramBezelListener)) {
          continue;
        }
        paramBezelListener = (BezelListener)localObject;
        if (paramBezelListener == null) {
          return;
        }
      }
      try
      {
        localObject = getService();
        if ((localObject != null) && (((IBezelManager)localObject).unregisterCallback(paramBezelListener)))
        {
          this.mListenerDelegates.remove(paramBezelListener);
          paramBezelListener.mHandler = null;
          paramBezelListener.mListener = null;
        }
      }
      catch (RemoteException paramBezelListener)
      {
        label105:
        break label105;
      }
      return;
      label112:
      paramBezelListener = null;
    }
  }
  
  public static abstract interface BezelListener
  {
    public abstract void onItemSelected(BezelEvent paramBezelEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction
 * JD-Core Version:    0.7.0.1
 */