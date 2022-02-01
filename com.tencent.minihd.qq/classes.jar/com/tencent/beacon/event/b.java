package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.g;
import com.tencent.beacon.c.d.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends com.tencent.beacon.upload.a
{
  private Context e = null;
  private Long[] f = null;
  private List<Long> g = null;
  private byte[] h = null;
  private boolean i = false;
  
  public b(Context paramContext)
  {
    super(paramContext, 1, 4);
    this.e = paramContext;
  }
  
  private com.tencent.beacon.c.a.a a(List<i> paramList)
  {
    int k = 1;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Object localObject1 = new ArrayList(5);
    ArrayList localArrayList1 = new ArrayList(5);
    ArrayList localArrayList2 = new ArrayList(5);
    Object localObject2 = new ArrayList();
    int m = paramList.size();
    this.g = new ArrayList();
    int j = 0;
    i locali;
    Object localObject3;
    if (j < m) {
      try
      {
        locali = (i)paramList.get(j);
        localObject3 = locali.e();
        com.tencent.beacon.d.a.a(" bean.getTP: " + locali.b(), new Object[0]);
        if (localObject3 != null) {
          if ("IP".equals(locali.b()))
          {
            localObject3 = a.b(locali);
            if (localObject3 != null) {
              ((ArrayList)localObject1).add(localObject3);
            } else {
              this.g.add(Long.valueOf(locali.a()));
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        com.tencent.beacon.d.a.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        paramList = new c();
        j = k;
        if (localArrayList2.size() > 0)
        {
          paramList.c = localArrayList2;
          j = 0;
        }
        if (localArrayList1.size() > 0)
        {
          paramList.b = localArrayList1;
          j = 0;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break label747;
        }
        paramList.a = ((ArrayList)localObject1);
        j = 0;
      }
      catch (Exception paramList)
      {
        label266:
        paramList.printStackTrace();
        com.tencent.beacon.d.a.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
        b();
        return null;
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = new com.tencent.beacon.c.b.b();
        ((com.tencent.beacon.c.b.b)localObject1).a = ((ArrayList)localObject2);
        if ((paramList == null) && (localObject1 == null))
        {
          return null;
          if ("DN".equals(locali.b()))
          {
            localObject3 = a.c(locali);
            if (localObject3 != null) {
              localArrayList1.add(localObject3);
            } else {
              this.g.add(Long.valueOf(locali.a()));
            }
          }
          else if ("HO".equals(locali.b()))
          {
            localObject3 = a.d(locali);
            if (localObject3 != null) {
              localArrayList2.add(localObject3);
            } else {
              this.g.add(Long.valueOf(locali.a()));
            }
          }
          else if ("UA".equals(locali.b()))
          {
            com.tencent.beacon.d.a.f(" Pack2Upload eventName:}%s ", new Object[] { locali.d() });
            localObject3 = a.e(locali);
            if (localObject3 != null)
            {
              ((ArrayList)localObject2).add(localObject3);
            }
            else
            {
              this.g.add(Long.valueOf(locali.a()));
              break label740;
              if (this.g.size() > 0) {
                g.a(this.e, (Long[])this.g.toArray(new Long[this.g.size()]));
              }
              com.tencent.beacon.d.a.b(" up hmList:" + localArrayList2.size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up dmList:" + localArrayList1.size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up ipList:" + ((ArrayList)localObject1).size(), new Object[0]);
              com.tencent.beacon.d.a.b(" up erList:" + ((ArrayList)localObject2).size(), new Object[0]);
            }
          }
        }
        else
        {
          localObject2 = new HashMap();
          if (paramList != null) {
            ((Map)localObject2).put(Integer.valueOf(3), paramList.a());
          }
          if (localObject1 != null) {
            ((Map)localObject2).put(Integer.valueOf(1), ((com.tencent.beacon.c.b.b)localObject1).a());
          }
          paramList = new com.tencent.beacon.c.a.a();
          paramList.a = ((Map)localObject2);
          return paramList;
        }
      }
      else
      {
        localObject1 = null;
        continue;
      }
      label740:
      label747:
      while (j == 0)
      {
        break label266;
        j += 1;
        break;
      }
      paramList = null;
    }
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.beacon.c.a.b a()
  {
    Object localObject9 = null;
    int k = 0;
    Object localObject6;
    try
    {
      Object localObject1 = n.d();
      if ((localObject1 == null) || (!((n)localObject1).g()))
      {
        com.tencent.beacon.d.a.c(" imposiable! ua not ready!", new Object[0]);
        localObject1 = localObject9;
      }
      for (;;)
      {
        return localObject1;
        localObject6 = ((n)localObject1).i();
        if (localObject6 == null)
        {
          com.tencent.beacon.d.a.c(" imposiable! ua S not ready!", new Object[0]);
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            if (f())
            {
              localObject7 = com.tencent.beacon.a.a.a.a(this.e);
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                localObject3 = (byte[])((List)localObject7).get(3);
                this.d = String.valueOf(((List)localObject7).get(1));
                if (localObject3 != null)
                {
                  localObject3 = a(this.c, this.a, (byte[])localObject3);
                  continue;
                }
                m = ((e)localObject6).e();
                j = m;
                if (com.tencent.beacon.d.b.a(this.e)) {
                  j = m / 2;
                }
                if (j >= 0)
                {
                  localObject6 = g.a(this.e, null, j);
                  if ((localObject6 == null) || (((List)localObject6).size() <= 0))
                  {
                    com.tencent.beacon.d.a.h(" no up datas", new Object[0]);
                    localObject3 = localObject9;
                  }
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            com.tencent.beacon.d.a.d(" get req datas error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject9;
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      Object localObject7;
      Object localObject3;
      int m;
      break;
      int j = ((List)localObject6).size();
      com.tencent.beacon.d.a.h(" size:%d", new Object[] { Integer.valueOf(j) });
      Object localObject8;
      try
      {
        localObject7 = a((List)localObject6);
        this.f = new Long[j];
        j = k;
        while (j < this.f.length)
        {
          this.f[j] = Long.valueOf(((i)((List)localObject6).get(j)).a());
          j += 1;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          b();
          localObject8 = null;
        }
        ((List)localObject6).clear();
        if (localObject8 == null) {
          break label456;
        }
      }
      Object localObject4 = localObject8.a();
      label456:
      for (;;)
      {
        for (;;)
        {
          this.h = new byte[localObject4.length];
          System.arraycopy(localObject4, 0, this.h, 0, localObject4.length);
          this.d = com.tencent.beacon.b.a.a(this.c, 4);
          com.tencent.beacon.d.a.a("comm rid:%s", new Object[] { this.d });
          try
          {
            localObject4 = a(this.c, this.a, (byte[])localObject4);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              b();
              localObject5 = null;
            }
          }
        }
      }
      localObject6 = null;
      continue;
      Object localObject5 = null;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      com.tencent.beacon.d.a.c(" encode failed, clear db data", new Object[0]);
      if ((this.f != null) && (this.f.length > 0))
      {
        int j = g.a(this.e, this.f);
        com.tencent.beacon.d.a.b(" remove num :" + j, new Object[0]);
        this.f = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   6: ifnull +47 -> 53
    //   9: aload_0
    //   10: getfield 24	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   13: arraylength
    //   14: ifle +39 -> 53
    //   17: aload_0
    //   18: getfield 22	com/tencent/beacon/event/b:e	Landroid/content/Context;
    //   21: aload_0
    //   22: getfield 24	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   25: invokestatic 166	com/tencent/beacon/a/g:a	(Landroid/content/Context;[Ljava/lang/Long;)I
    //   28: istore_2
    //   29: new 62	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 297
    //   36: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: iload_2
    //   40: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_0
    //   47: anewarray 80	java/lang/Object
    //   50: invokestatic 173	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 24	com/tencent/beacon/event/b:f	[Ljava/lang/Long;
    //   58: iload_1
    //   59: ifeq +30 -> 89
    //   62: aload_0
    //   63: invokespecial 230	com/tencent/beacon/event/b:f	()Z
    //   66: ifeq +23 -> 89
    //   69: aload_0
    //   70: getfield 22	com/tencent/beacon/event/b:e	Landroid/content/Context;
    //   73: aload_0
    //   74: getfield 242	com/tencent/beacon/event/b:d	Ljava/lang/String;
    //   77: invokestatic 300	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   80: pop
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 28	com/tencent/beacon/event/b:h	[B
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: iload_1
    //   90: ifne -9 -> 81
    //   93: aload_0
    //   94: getfield 28	com/tencent/beacon/event/b:h	[B
    //   97: ifnull -16 -> 81
    //   100: ldc_w 302
    //   103: iconst_1
    //   104: anewarray 80	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_0
    //   110: getfield 242	com/tencent/beacon/event/b:d	Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 85	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: getfield 22	com/tencent/beacon/event/b:e	Landroid/content/Context;
    //   121: aload_0
    //   122: getfield 28	com/tencent/beacon/event/b:h	[B
    //   125: aload_0
    //   126: getfield 242	com/tencent/beacon/event/b:d	Ljava/lang/String;
    //   129: invokestatic 305	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;[BLjava/lang/String;)Z
    //   132: pop
    //   133: goto -52 -> 81
    //   136: astore_3
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_3
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	b
    //   0	141	1	paramBoolean	boolean
    //   28	12	2	j	int
    //   136	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	136	finally
    //   53	58	136	finally
    //   62	81	136	finally
    //   81	86	136	finally
    //   93	133	136	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */