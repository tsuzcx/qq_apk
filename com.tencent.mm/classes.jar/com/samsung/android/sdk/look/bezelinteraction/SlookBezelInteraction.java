package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.samsung.android.bezelinteraction.IBezelManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction
{
  public static final String SERVICE_NAME = "BezelInteractionService";
  private static final String TAG = "SlookBezelInteraction";
  private static Context mContext = null;
  private static IBezelManager mService = null;
  private final CopyOnWriteArrayList<SlookBezelInteraction.BezelListenerDelegate> mListenerDelegates;
  
  public SlookBezelInteraction(Context paramContext)
  {
    AppMethodBeat.i(117204);
    this.mListenerDelegates = new CopyOnWriteArrayList();
    mContext = paramContext;
    getService();
    AppMethodBeat.o(117204);
  }
  
  /* Error */
  private IBezelManager getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 55
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 28	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   10: ifnonnull +27 -> 37
    //   13: ldc 12
    //   15: invokestatic 60	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   18: invokestatic 66	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   21: putstatic 28	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   24: getstatic 28	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   27: astore_1
    //   28: ldc 55
    //   30: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: getstatic 28	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   40: invokeinterface 72 1 0
    //   45: invokeinterface 78 1 0
    //   50: ifne -26 -> 24
    //   53: ldc 12
    //   55: invokestatic 60	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   58: invokestatic 66	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   61: putstatic 28	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   64: goto -40 -> 24
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	SlookBezelInteraction
    //   27	9	1	localIBezelManager	IBezelManager
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	67	finally
    //   24	33	67	finally
    //   37	64	67	finally
  }
  
  public final void enableBezelInteraction(boolean paramBoolean)
  {
    AppMethodBeat.i(117208);
    try
    {
      IBezelManager localIBezelManager = getService();
      if (localIBezelManager != null) {
        localIBezelManager.enableBezelInteraction(paramBoolean);
      }
      AppMethodBeat.o(117208);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(117208);
    }
  }
  
  public final void registerListener(SlookBezelInteraction.BezelListener paramBezelListener)
  {
    AppMethodBeat.i(117206);
    if (paramBezelListener == null)
    {
      AppMethodBeat.o(117206);
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
          AppMethodBeat.o(117206);
          return;
        }
      }
      SlookBezelInteraction.BezelListenerDelegate localBezelListenerDelegate = null;
    }
  }
  
  public final void unregisterListener(SlookBezelInteraction.BezelListener paramBezelListener)
  {
    AppMethodBeat.i(117207);
    if (paramBezelListener == null)
    {
      AppMethodBeat.o(117207);
      return;
    }
    for (;;)
    {
      synchronized (this.mListenerDelegates)
      {
        Iterator localIterator = this.mListenerDelegates.iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (SlookBezelInteraction.BezelListenerDelegate)localIterator.next();
          if (!((SlookBezelInteraction.BezelListenerDelegate)localObject).getListener().equals(paramBezelListener)) {
            continue;
          }
          paramBezelListener = (SlookBezelInteraction.BezelListener)localObject;
          if (paramBezelListener == null)
          {
            AppMethodBeat.o(117207);
            return;
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
            continue;
          }
          AppMethodBeat.o(117207);
          return;
        }
      }
      paramBezelListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction
 * JD-Core Version:    0.7.0.1
 */