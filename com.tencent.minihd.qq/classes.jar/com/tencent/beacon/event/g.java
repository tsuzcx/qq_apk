package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.d;
import com.tencent.beacon.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private i a;
  private Context b;
  private int c = 20000;
  private int d = 0;
  private Runnable e = new Runnable()
  {
    public final void run()
    {
      try
      {
        g.this.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  };
  
  public g(Context paramContext)
  {
    this.b = paramContext;
    paramContext = new HashMap(2);
    if (com.tencent.beacon.a.a.g(this.b)) {
      paramContext.put("A66", "F");
    }
    for (;;)
    {
      paramContext.put("A68", com.tencent.beacon.a.a.h(this.b));
      this.a = a.a(this.b, "rqd_heartbeat", true, 0L, 0L, paramContext);
      return;
      paramContext.put("A66", "B");
    }
  }
  
  public g(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    paramContext = new HashMap(2);
    if (paramBoolean) {
      paramContext.put("A66", "F");
    }
    for (;;)
    {
      paramContext.put("A68", com.tencent.beacon.a.a.h(this.b));
      this.a = a.a(this.b, "rqd_heartbeat", true, 0L, 0L, paramContext);
      return;
      paramContext.put("A66", "B");
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int b()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (!b.b(this.b)) {}
    do
    {
      return;
      com.tencent.beacon.upload.g localg = n.d().h();
      if (localg != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        localg.a(new j.a(this.b, localArrayList));
      }
      a(b() + 1);
    } while (b() % 10 != 0);
    d.a().a(108, this.e, 600000L, this.c);
    a(0);
  }
  
  public final void a(boolean paramBoolean)
  {
    String str = com.tencent.beacon.a.a.b(this.b, "HEART_DENGTA", "");
    if (com.tencent.beacon.b.a.g().equals(str))
    {
      com.tencent.beacon.d.a.a("heartbeat has been uploaded today!", new Object[0]);
      return;
    }
    if (paramBoolean) {}
    for (int i = (int)(Math.random() * 60.0D) * 1000;; i = 0)
    {
      d.a().a(108, this.e, i, this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.g
 * JD-Core Version:    0.7.0.1
 */