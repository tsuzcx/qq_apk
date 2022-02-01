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
    AppMethodBeat.i(207490);
    this.observerMap = new HashMap();
    AppMethodBeat.o(207490);
  }
  
  public static APHttpHandle getIntanceHandel()
  {
    AppMethodBeat.i(207498);
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
        AppMethodBeat.o(207498);
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
    AppMethodBeat.i(207505);
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
          AppMethodBeat.o(207505);
          return;
        }
        unregister(str);
        switch (i)
        {
        default: 
          AppMethodBeat.o(207505);
          return;
        }
      }
      catch (Exception paramMessage)
      {
        AppMethodBeat.o(207505);
        return;
      }
      localIAPHttpAnsObserver.onFinish(paramMessage);
      AppMethodBeat.o(207505);
      return;
      localIAPHttpAnsObserver.onError(paramMessage);
      AppMethodBeat.o(207505);
      return;
      localIAPHttpAnsObserver.onStop(paramMessage);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(207533);
    runObserverOnMainThread(paramMessage);
    AppMethodBeat.o(207533);
  }
  
  public void register(String paramString, IAPHttpAnsObserver paramIAPHttpAnsObserver)
  {
    AppMethodBeat.i(207521);
    if (this.observerMap != null) {
      this.observerMap.put(paramString, paramIAPHttpAnsObserver);
    }
    AppMethodBeat.o(207521);
  }
  
  public void release()
  {
    handle = null;
  }
  
  public void unregister(String paramString)
  {
    AppMethodBeat.i(207527);
    if (this.observerMap != null) {
      this.observerMap.remove(paramString);
    }
    AppMethodBeat.o(207527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.http.APHttpHandle
 * JD-Core Version:    0.7.0.1
 */