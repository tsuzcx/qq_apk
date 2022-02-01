package com.tencent.beacon.event;

import android.content.Context;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements Runnable
{
  private Context a;
  private int b;
  private int c = -1;
  private Map<String, String> d = new HashMap(2);
  private int e = 0;
  
  public f(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.e = Calendar.getInstance().get(5);
    this.d.put("A63", "N");
    this.d.put("A66", "F");
  }
  
  public final void run()
  {
    boolean bool;
    if (this.b > 0)
    {
      bool = com.tencent.beacon.a.a.g(this.a);
      int i = Calendar.getInstance().get(5);
      if (i != this.e)
      {
        this.e = i;
        new g(this.a, bool).a(true);
      }
      if (this.c == -1) {
        break label123;
      }
      if ((this.c != 0) || (!bool)) {
        break label105;
      }
      n.a("rqd_applaunched", true, 0L, 0L, this.d, true);
      com.tencent.beacon.d.a.a(" create a applaunched event", new Object[0]);
      this.c = 1;
      n.c(true);
    }
    label105:
    while ((bool) || (this.c != 1)) {
      return;
    }
    label123:
    while (!bool)
    {
      this.c = 0;
      return;
    }
    this.c = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.f
 * JD-Core Version:    0.7.0.1
 */