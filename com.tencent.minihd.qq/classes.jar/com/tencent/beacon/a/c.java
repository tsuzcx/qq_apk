package com.tencent.beacon.a;

import android.content.Context;
import com.tencent.beacon.a.a.e;
import com.tencent.beacon.event.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public final class c
  implements Runnable
{
  private Context a;
  private int b;
  private int c;
  private Runnable d;
  private boolean e;
  private boolean f;
  private boolean g;
  private int h = 0;
  
  public c(Context paramContext, int paramInt1, int paramInt2, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramRunnable;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
  }
  
  public final void run()
  {
    boolean bool = a.g(this.a);
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = "F";
      localObject1 = g.a(this.a);
      if ((this.b > 0) && (this.f))
      {
        if (!this.f) {
          break label867;
        }
        localObject1 = ((g)localObject1).f();
        if ((localObject1 == null) || (((String)localObject1).equals(""))) {
          break label864;
        }
        localObject1 = (String)localObject3 + "," + (String)localObject1;
      }
    }
    for (;;)
    {
      Object localObject4;
      if (this.g)
      {
        localObject4 = g.g();
        if ((localObject4 != null) && (!((String)localObject4).equals(""))) {
          localObject3 = (String)localObject3 + "," + (String)localObject4;
        }
      }
      for (;;)
      {
        try
        {
          localObject4 = a.b(this.a, "app_mem_info", "");
          localObject5 = a.b(this.a, "app_cpu_info", "");
          if (((this.h != 0) || ("".equals(localObject4))) && (this.h < this.c / this.b)) {
            continue;
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("A78", (String)localObject4 + ";" + (String)localObject1);
          if (localObject3 != null) {
            localHashMap.put("A77", (String)localObject5 + ";" + (String)localObject3);
          }
          if (!n.a("rqd_res_occ", true, 0L, 0L, localHashMap, true)) {
            continue;
          }
          a.a(this.a, "app_mem_info", "");
          if (localObject3 != null) {
            a.a(this.a, "app_cpu_info", "");
          }
          this.h = 0;
        }
        catch (Exception localException)
        {
          long l;
          com.tencent.beacon.d.a.c("get resinfo from sp failed! ", new Object[0]);
          continue;
          if (!"".equals(localObject4)) {
            continue;
          }
          a.a(this.a, "app_mem_info", localException);
          if (localObject3 == null) {
            continue;
          }
          if (!"".equals(localObject5)) {
            continue;
          }
          a.a(this.a, "app_cpu_info", (String)localObject3);
          this.h += 1;
          continue;
          a.a(this.a, "app_mem_info", (String)localObject4 + ";" + localException);
          continue;
          a.a(this.a, "app_cpu_info", (String)localObject5 + ";" + (String)localObject3);
          continue;
          localObject4 = new ArrayList();
          Object localObject5 = new com.tencent.beacon.a.a.a(8, 0, localException.d(), com.tencent.beacon.b.a.a(localException));
          ((com.tencent.beacon.a.a.a)localObject5).a(localException.e());
          ((List)localObject4).add(localObject5);
          com.tencent.beacon.a.a.a.b((Context)localObject3, (List)localObject4);
          continue;
          continue;
        }
        if ((this.b > 0) && (this.e))
        {
          l = new Date().getTime();
          localObject1 = g.o(this.a);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = new e();
          ((e)localObject1).c(l);
          ((e)localObject1).d(l);
          ((e)localObject1).b(0L);
          ((e)localObject1).a(0L);
          ((e)localObject1).a(((e)localObject1).a() + this.b / 60);
          if (bool) {
            ((e)localObject1).b(((e)localObject1).b() + this.b / 60);
          }
          ((e)localObject1).d(l);
          localObject3 = this.a;
          if ((localObject3 != null) && (localObject1 != null)) {
            continue;
          }
          com.tencent.beacon.d.a.e(" used:%d  seen:%d  next:%d", new Object[] { Long.valueOf(((e)localObject1).a()), Long.valueOf(((e)localObject1).b()), Integer.valueOf(this.b) });
          if (((e)localObject1).a() >= this.c) {
            d.a().a(this.d);
          }
        }
        return;
        localObject3 = "B";
        break;
        a.a(this.a, "app_mem_info", (String)localObject4 + ";" + (String)localObject1);
        if (localObject3 != null) {
          a.a(this.a, "app_cpu_info", (String)localObject5 + ";" + (String)localObject3);
        }
        this.h += 1;
        continue;
        localObject3 = localObject4;
        continue;
        localObject3 = null;
      }
      label864:
      continue;
      label867:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c
 * JD-Core Version:    0.7.0.1
 */