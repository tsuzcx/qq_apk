package com.tencent.mm.accessibility;

import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.util.List;

public class AccessibilityCapture$ViewSearchTask
  implements Runnable
{
  private long elapsedTime = 0L;
  private final AccessibilityEvent mEvent;
  
  public AccessibilityCapture$ViewSearchTask(AccessibilityEvent paramAccessibilityEvent, long paramLong)
  {
    this.mEvent = paramAccessibilityEvent;
    this.elapsedTime = paramLong;
  }
  
  private int findAccessibilityId()
  {
    try
    {
      localField1 = AccessibilityRecord.class.getDeclaredField("mSourceNodeId");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      for (;;)
      {
        try
        {
          Field localField1;
          localField1.setAccessible(true);
          return (int)((Long)localField1.get(this.mEvent)).longValue();
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          Object localObject;
          try
          {
            Field localField2;
            Field localField3 = AccessibilityNodeInfo.class.getDeclaredField("mSourceNodeId");
            localObject = AccessibilityRecord.class.getDeclaredField("mSealed");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.mEvent, Boolean.valueOf(true));
            localObject = this.mEvent.getSource();
            if (localObject == null) {
              throw new AccessibilityIdNotFoundException();
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException3)
          {
            throw new AccessibilityIdNotFoundException(localNoSuchFieldException3);
          }
          localNoSuchFieldException3.setAccessible(true);
          long l = ((Long)localNoSuchFieldException3.get(localObject)).longValue();
          return (int)l;
        }
        localNoSuchFieldException1 = localNoSuchFieldException1;
        localField2 = AccessibilityRecord.class.getDeclaredField("mSourceViewId");
      }
    }
  }
  
  private View searchViewByAccessibilityId(int paramInt)
  {
    try
    {
      Object localObject = new ViewSearchTool().findView(new AccessibilityCapture.ViewSearchTask.1(this, paramInt));
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (View)((List)localObject).get(0);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "exception when find root", new Object[] { localException });
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label68:
      break label68;
    }
  }
  
  public void run()
  {
    if (this.mEvent == null) {
      return;
    }
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      View localView = searchViewByAccessibilityId(findAccessibilityId());
      AccessibilityCapture.access$800(this.mEvent, localView, this.elapsedTime);
      long l2 = SystemClock.elapsedRealtime();
      AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "analysis event %s, cost %dms", new Object[] { AccessibilityEvent.eventTypeToString(this.mEvent.getEventType()), Long.valueOf(l2 - l1) });
      try
      {
        this.mEvent.recycle();
        return;
      }
      catch (Throwable localThrowable1)
      {
        AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[] { localThrowable1 });
        return;
      }
      try
      {
        this.mEvent.recycle();
        throw localObject;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[] { localThrowable4 });
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2 = localThrowable2;
      AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "unable get node id", new Object[] { localThrowable2 });
      try
      {
        this.mEvent.recycle();
        return;
      }
      catch (Throwable localThrowable3)
      {
        AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[] { localThrowable3 });
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.ViewSearchTask
 * JD-Core Version:    0.7.0.1
 */