package com.tencent.mm.accessibility;

import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(118627);
    try
    {
      Field localField1 = AccessibilityRecord.class.getDeclaredField("mSourceNodeId");
      try
      {
        localField1.setAccessible(true);
        l = ((Long)localField1.get(this.mEvent)).longValue();
        i = (int)l;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        for (;;)
        {
          Object localObject2;
          AccessibilityIdNotFoundException localAccessibilityIdNotFoundException;
          try
          {
            Field localField2;
            Object localObject1 = AccessibilityNodeInfo.class.getDeclaredField("mSourceNodeId");
            localObject2 = AccessibilityRecord.class.getDeclaredField("mSealed");
            ((Field)localObject2).setAccessible(true);
            ((Field)localObject2).set(this.mEvent, Boolean.TRUE);
            localObject2 = this.mEvent.getSource();
            if (localObject2 == null)
            {
              localObject1 = new AccessibilityIdNotFoundException();
              AppMethodBeat.o(118627);
              throw ((Throwable)localObject1);
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException3)
          {
            localAccessibilityIdNotFoundException = new AccessibilityIdNotFoundException(localNoSuchFieldException3);
            AppMethodBeat.o(118627);
            throw localAccessibilityIdNotFoundException;
          }
          localAccessibilityIdNotFoundException.setAccessible(true);
          long l = ((Long)localAccessibilityIdNotFoundException.get(localObject2)).longValue();
          int i = (int)l;
        }
      }
      AppMethodBeat.o(118627);
      return i;
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      for (;;)
      {
        localField2 = AccessibilityRecord.class.getDeclaredField("mSourceViewId");
      }
    }
  }
  
  private View searchViewByAccessibilityId(int paramInt)
  {
    AppMethodBeat.i(118629);
    try
    {
      Object localObject = new ViewSearchTool().findView(new AccessibilityCapture.ViewSearchTask.1(this, paramInt));
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (View)((List)localObject).get(0);
        AppMethodBeat.o(118629);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "exception when find root", new Object[] { localException });
      AppMethodBeat.o(118629);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label78:
      break label78;
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(118628);
    if (this.mEvent == null)
    {
      AppMethodBeat.o(118628);
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
        AppMethodBeat.o(118628);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[] { localThrowable1 });
        AppMethodBeat.o(118628);
        return;
      }
      try
      {
        this.mEvent.recycle();
        AppMethodBeat.o(118628);
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
        AppMethodBeat.o(118628);
        return;
      }
      catch (Throwable localThrowable3)
      {
        AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[] { localThrowable3 });
        AppMethodBeat.o(118628);
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