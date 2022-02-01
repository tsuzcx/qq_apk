package com.tencent.beacon.heatmap;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.d;
import com.tencent.beacon.d.a;
import com.tencent.beacon.event.UserAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static c a = null;
  private static String e = "";
  private static String f = "";
  private boolean b = false;
  private int c = 25;
  private List<b> d;
  private Runnable g = new Runnable()
  {
    public final void run()
    {
      if ((c.a(c.this) != null) && (c.a(c.this).size() > 10)) {
        c.b(c.this);
      }
    }
  };
  
  private c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.b = paramBoolean;
    this.c = paramInt1;
    this.d = Collections.synchronizedList(new ArrayList());
    if (this.b) {
      d.a().a(109, this.g, 180000L, paramInt2 * 1000);
    }
  }
  
  public static c a()
  {
    try
    {
      c localc = a;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (a == null) {
        a = new c(paramBoolean, paramInt1, paramInt2);
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      a.d("getDisplayMetrics but context == null!", new Object[0]);
      return;
    }
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      e = localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels;
      return;
    }
    catch (Throwable paramContext)
    {
      a.d("getDisplayMetrics error!", new Object[0]);
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Context paramContext)
  {
    i = 160;
    if (paramContext == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        f1 = localDisplayMetrics.density;
        if (f1 != 1.0F) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        DisplayMetrics localDisplayMetrics;
        float f1;
        paramContext.printStackTrace();
        continue;
        i = 160;
        continue;
      }
      f = String.valueOf(i);
      return;
      if (localDisplayMetrics.density <= 0.75D)
      {
        i = 120;
      }
      else if (localDisplayMetrics.density == 1.5D)
      {
        i = 240;
      }
      else
      {
        f1 = localDisplayMetrics.density;
        if (f1 != 2.0D) {
          continue;
        }
        i = 320;
      }
    }
  }
  
  private void c()
  {
    Object localObject2;
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext()) {
        localStringBuffer.append(((b)((Iterator)localObject2).next()).toString()).append(";");
      }
      localObject2 = new HashMap(4);
    }
    finally {}
    ((Map)localObject2).put("A17", e);
    ((Map)localObject2).put("A52", f);
    ((Map)localObject2).put("A81", localObject1.toString());
    if (UserAction.onUserAction("rqd_heatmap", true, 0L, 0L, (Map)localObject2, false)) {
      this.d.clear();
    }
  }
  
  public final void a(b paramb)
  {
    try
    {
      if (this.d != null)
      {
        if (this.d.contains(paramb))
        {
          int i = this.d.indexOf(paramb);
          b localb = (b)this.d.get(i);
          int j = paramb.a;
          localb.a += j;
          this.d.remove(i);
        }
        this.d.add(paramb);
        if (this.d.size() >= this.c) {
          c();
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.heatmap.c
 * JD-Core Version:    0.7.0.1
 */