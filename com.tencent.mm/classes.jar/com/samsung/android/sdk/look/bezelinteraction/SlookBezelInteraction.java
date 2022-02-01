package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;
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
  private final CopyOnWriteArrayList<BezelListenerDelegate> mListenerDelegates;
  
  public SlookBezelInteraction(Context paramContext)
  {
    AppMethodBeat.i(76246);
    this.mListenerDelegates = new CopyOnWriteArrayList();
    mContext = paramContext;
    getService();
    AppMethodBeat.o(76246);
  }
  
  /* Error */
  private IBezelManager getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 60
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 33	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   10: ifnonnull +27 -> 37
    //   13: ldc 17
    //   15: invokestatic 65	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   18: invokestatic 71	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   21: putstatic 33	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   24: getstatic 33	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   27: astore_1
    //   28: ldc 60
    //   30: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: getstatic 33	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   40: invokeinterface 77 1 0
    //   45: invokeinterface 83 1 0
    //   50: ifne -26 -> 24
    //   53: ldc 17
    //   55: invokestatic 65	android/os/ServiceManager:getService	(Ljava/lang/String;)Landroid/os/IBinder;
    //   58: invokestatic 71	com/samsung/android/bezelinteraction/IBezelManager$Stub:asInterface	(Landroid/os/IBinder;)Lcom/samsung/android/bezelinteraction/IBezelManager;
    //   61: putstatic 33	com/samsung/android/sdk/look/bezelinteraction/SlookBezelInteraction:mService	Lcom/samsung/android/bezelinteraction/IBezelManager;
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
    AppMethodBeat.i(76250);
    try
    {
      IBezelManager localIBezelManager = getService();
      if (localIBezelManager != null) {
        localIBezelManager.enableBezelInteraction(paramBoolean);
      }
      AppMethodBeat.o(76250);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(76250);
    }
  }
  
  public final void registerListener(BezelListener paramBezelListener)
  {
    AppMethodBeat.i(76248);
    if (paramBezelListener == null)
    {
      AppMethodBeat.o(76248);
      return;
    }
    for (;;)
    {
      synchronized (this.mListenerDelegates)
      {
        Object localObject = this.mListenerDelegates.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localBezelListenerDelegate = (BezelListenerDelegate)((Iterator)localObject).next();
          if (!localBezelListenerDelegate.getListener().equals(paramBezelListener)) {
            continue;
          }
          localObject = localBezelListenerDelegate;
          if (localBezelListenerDelegate == null)
          {
            localObject = new BezelListenerDelegate(paramBezelListener, null);
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
          AppMethodBeat.o(76248);
          return;
        }
      }
      BezelListenerDelegate localBezelListenerDelegate = null;
    }
  }
  
  public final void unregisterListener(BezelListener paramBezelListener)
  {
    AppMethodBeat.i(76249);
    if (paramBezelListener == null)
    {
      AppMethodBeat.o(76249);
      return;
    }
    for (;;)
    {
      synchronized (this.mListenerDelegates)
      {
        Iterator localIterator = this.mListenerDelegates.iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (BezelListenerDelegate)localIterator.next();
          if (!((BezelListenerDelegate)localObject).getListener().equals(paramBezelListener)) {
            continue;
          }
          paramBezelListener = (BezelListener)localObject;
          if (paramBezelListener == null)
          {
            AppMethodBeat.o(76249);
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
          AppMethodBeat.o(76249);
          return;
        }
      }
      paramBezelListener = null;
    }
  }
  
  public static abstract interface BezelListener
  {
    public abstract void onItemSelected(BezelEvent paramBezelEvent);
  }
  
  static class BezelListenerDelegate
    extends IBezelCallback.Stub
  {
    public Handler mHandler;
    public SlookBezelInteraction.BezelListener mListener;
    
    BezelListenerDelegate(SlookBezelInteraction.BezelListener paramBezelListener, Handler paramHandler)
    {
      AppMethodBeat.i(76251);
      this.mListener = paramBezelListener;
      if (paramHandler == null) {}
      for (paramBezelListener = SlookBezelInteraction.mContext.getMainLooper();; paramBezelListener = paramHandler.getLooper())
      {
        this.mHandler = new ListenerHandler(paramBezelListener, this.mListener);
        AppMethodBeat.o(76251);
        return;
      }
    }
    
    public SlookBezelInteraction.BezelListener getListener()
    {
      return this.mListener;
    }
    
    public String getListenerInfo()
    {
      AppMethodBeat.i(76253);
      String str = this.mListener.toString();
      AppMethodBeat.o(76253);
      return str;
    }
    
    public void onBezelCallback(BezelEvent paramBezelEvent)
    {
      AppMethodBeat.i(76252);
      Message localMessage = Message.obtain();
      localMessage.what = 0;
      localMessage.obj = paramBezelEvent;
      this.mHandler.sendMessage(localMessage);
      AppMethodBeat.o(76252);
    }
    
    static class ListenerHandler
      extends Handler
    {
      public SlookBezelInteraction.BezelListener mListener = null;
      
      public ListenerHandler(Looper paramLooper, SlookBezelInteraction.BezelListener paramBezelListener)
      {
        super();
        this.mListener = paramBezelListener;
      }
      
      public void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(76254);
        if (this.mListener != null)
        {
          paramMessage = (BezelEvent)paramMessage.obj;
          if (paramMessage != null) {
            this.mListener.onItemSelected(paramMessage);
          }
        }
        AppMethodBeat.o(76254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.look.bezelinteraction.SlookBezelInteraction
 * JD-Core Version:    0.7.0.1
 */