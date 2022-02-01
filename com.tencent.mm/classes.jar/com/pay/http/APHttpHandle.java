package com.pay.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class APHttpHandle
  extends Handler
{
  private static APHttpHandle handle;
  private static byte[] lock = new byte[0];
  private HashMap<String, IAPHttpAnsObserver> observerMap;
  
  private APHttpHandle()
  {
    AppMethodBeat.i(193278);
    this.observerMap = new HashMap();
    AppMethodBeat.o(193278);
  }
  
  public static APHttpHandle getIntanceHandel()
  {
    AppMethodBeat.i(193279);
    synchronized (lock)
    {
      APHttpHandle localAPHttpHandle = handle;
      if (localAPHttpHandle == null) {}
      try
      {
        if ((Thread.currentThread() != Looper.getMainLooper().getThread()) && (Looper.myLooper() == null)) {
          Looper.prepare();
        }
        handle = new APHttpHandle();
        ??? = handle;
        AppMethodBeat.o(193279);
        return ???;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          APLog.i("APHttpHandle", localException.toString());
        }
      }
    }
  }
  
  private void runObserverOnMainThread(Message paramMessage)
  {
    AppMethodBeat.i(193283);
    for (;;)
    {
      IAPHttpAnsObserver localIAPHttpAnsObserver;
      try
      {
        int i = paramMessage.what;
        paramMessage = (APBaseHttpAns)paramMessage.obj;
        String str = paramMessage.getHttpReqKey();
        localIAPHttpAnsObserver = (IAPHttpAnsObserver)this.observerMap.get(str);
        if (localIAPHttpAnsObserver == null)
        {
          AppMethodBeat.o(193283);
          return;
        }
        unregister(str);
        switch (i)
        {
        default: 
          AppMethodBeat.o(193283);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        AppMethodBeat.o(193283);
        return;
      }
      localIAPHttpAnsObserver.onFinish(paramMessage);
      AppMethodBeat.o(193283);
      return;
      localIAPHttpAnsObserver.onError(paramMessage);
      AppMethodBeat.o(193283);
      return;
      localIAPHttpAnsObserver.onStop(paramMessage);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(193282);
    runObserverOnMainThread(paramMessage);
    AppMethodBeat.o(193282);
  }
  
  public void register(String paramString, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(193280);
    if (this.observerMap != null) {
      this.observerMap.put(paramString, paramIAPHttpAnsObserver);
    }
    AppMethodBeat.o(193280);
  }
  
  public void release()
  {
    handle = null;
  }
  
  public void unregister(String paramString)
  {
    AppMethodBeat.i(193281);
    if (this.observerMap != null) {
      this.observerMap.remove(paramString);
    }
    AppMethodBeat.o(193281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.http.APHttpHandle
 * JD-Core Version:    0.7.0.1
 */