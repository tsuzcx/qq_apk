package com.tencent.tmassistant;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.a.h;
import java.util.ArrayList;
import java.util.Iterator;

public class d
  extends Handler
{
  protected static d a = null;
  protected static HandlerThread b = null;
  
  private d(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static d a()
  {
    try
    {
      if (a == null)
      {
        b = new HandlerThread("TMAssistantDownloadSDKMessageThread");
        b.start();
        a = new d(b.getLooper());
      }
      d locald = a;
      return locald;
    }
    finally {}
  }
  
  public void a(b paramb, a parama)
  {
    if ((parama == null) || (paramb == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new h(paramb, parama);
    localMessage.sendToTarget();
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new h(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject2 = (h)paramMessage.obj;
      Object localObject1 = (b)((h)localObject2).a;
      localObject2 = (a)((h)localObject2).b;
      Object localObject3 = paramMessage.getData();
      paramMessage = ((Bundle)localObject3).getString("url");
      int i = ((Bundle)localObject3).getInt("state");
      int j = ((Bundle)localObject3).getInt("errorCode");
      localObject3 = ((Bundle)localObject3).getString("errorMsg");
      if (localObject2 != null)
      {
        ((a)localObject2).a((b)localObject1, paramMessage, i, j, (String)localObject3);
        return;
        localObject2 = (h)paramMessage.obj;
        localObject1 = (b)((h)localObject2).a;
        localObject2 = (a)((h)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        long l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null)
        {
          ((a)localObject2).a((b)localObject1, (String)localObject3, l1, l2);
          return;
          localObject1 = (h)paramMessage.obj;
          paramMessage = (b)((h)localObject1).a;
          localObject1 = (a)((h)localObject1).b;
          if (localObject1 != null)
          {
            ((a)localObject1).a(paramMessage);
            return;
            localObject1 = (h)paramMessage.obj;
            paramMessage = (byte[])((h)localObject1).a;
            localObject1 = (ArrayList)((h)localObject1).b;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (com.tencent.tmassistantsdk.internal.b.a)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((com.tencent.tmassistantsdk.internal.b.a)localObject2).a(paramMessage);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.d
 * JD-Core Version:    0.7.0.1
 */