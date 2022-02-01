package com.tencent.matrix.a.b;

import android.app.Notification;
import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static boolean eTs;
  private static n.b eTt = new n.b()
  {
    public final Object a(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      Object localObject1 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      int i = 0;
      if ("createNotificationChannels".equals(paramAnonymousMethod.getName()))
      {
        if (paramAnonymousArrayOfObject != null)
        {
          j = paramAnonymousArrayOfObject.length;
          i = 0;
          paramAnonymousMethod = (Method)localObject3;
          for (;;)
          {
            localObject1 = paramAnonymousMethod;
            if (i < j)
            {
              localObject1 = paramAnonymousArrayOfObject[i];
              if ((localObject1 != null) && (localObject1.getClass().getName().equals("android.content.pm.ParceledListSlice"))) {
                try
                {
                  localObject3 = localObject1.getClass().getDeclaredMethod("getList", new Class[0]);
                  if (localObject3 != null)
                  {
                    localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
                    if ((localObject1 instanceof Iterable))
                    {
                      localObject3 = ((Iterable)localObject1).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject1 = ((Iterator)localObject3).next();
                        if (localObject1 != null)
                        {
                          bool = localObject1.getClass().getName().equals("android.app.NotificationChannel");
                          if (bool) {
                            paramAnonymousMethod = (Method)localObject1;
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                  }
                }
                catch (Exception localException)
                {
                  c.w("Matrix.battery.NotificationHooker", "try parse args fail: " + localException.getMessage(), new Object[0]);
                }
              }
            }
          }
        }
        h.co(localException);
      }
      while (!"enqueueNotificationWithTag".equals(paramAnonymousMethod.getName()))
      {
        boolean bool;
        return;
      }
      int k = paramAnonymousArrayOfObject.length;
      int j = -1;
      paramAnonymousMethod = localObject4;
      Object localObject2;
      if (i < k)
      {
        localObject2 = paramAnonymousArrayOfObject[i];
        if ((localObject2 instanceof Integer))
        {
          if (j != -1) {
            break label310;
          }
          j = ((Integer)localObject2).intValue();
        }
      }
      label310:
      for (;;)
      {
        i += 1;
        break;
        if ((localObject2 instanceof Notification))
        {
          paramAnonymousMethod = (Notification)localObject2;
          continue;
          h.b(j, paramAnonymousMethod);
          return;
        }
      }
    }
  };
  private static n eTu = new n("notification", "android.app.INotificationManager", eTt);
  private static List<a> eTv = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(parama)) {
          continue;
        }
        eTv.add(parama);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.NotificationHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
      }
      finally {}
    }
  }
  
  public static void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        eTv.remove(parama);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.NotificationHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, Notification paramNotification);
    
    public abstract void cj(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.h
 * JD-Core Version:    0.7.0.1
 */