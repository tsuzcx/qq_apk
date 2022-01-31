package c.t.m.g;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cf
  implements bb, bi
{
  private static cf c = new cf();
  public Map<String, bc> a = new ConcurrentHashMap();
  public cc b;
  private Runnable d = new ch(this);
  private Runnable e = new ci(this);
  
  private cf()
  {
    Object localObject = new bh();
    this.a.put(((bc)localObject).b(), localObject);
    localObject = new bf();
    this.a.put(((bc)localObject).b(), localObject);
    localObject = new bd();
    this.a.put(((bc)localObject).b(), localObject);
    localObject = this.d;
    if ((!m.f()) && (m.e))
    {
      ae.a().a((Runnable)localObject);
      ae.a().a((Runnable)localObject, true, 30000L);
    }
    localObject = this.e;
    if ((!m.f()) && (m.e))
    {
      ae.a().a((Runnable)localObject);
      ae.a().a((Runnable)localObject, true, 30000L);
    }
  }
  
  public static cf d()
  {
    return c;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(int paramInt)
  {
    m.i().post(new cg(this, paramInt));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = x.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!m.f()) && (m.e))
    {
      ae.a().a((Runnable)localObject);
      ae.a().a((Runnable)localObject, true, l);
    }
    localObject = this.a.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bc)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = x.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!m.f()) && (m.e))
    {
      ae.a().a((Runnable)localObject);
      ae.a().a((Runnable)localObject, true, l);
    }
    localObject = this.a.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bc)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void b()
  {
    this.b.b();
  }
  
  public final void c()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bc)localIterator.next()).c();
    }
  }
  
  public final w e()
  {
    return (w)this.a.get("accessscheduler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.cf
 * JD-Core Version:    0.7.0.1
 */