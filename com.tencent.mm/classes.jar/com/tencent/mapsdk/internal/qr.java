package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class qr
  extends Thread
{
  public static final String b = "UTF-8";
  private static final String h = "rttserverex";
  private static final String i = "getRtt";
  private static final String j = "info";
  private static final String k = "req";
  private static final int l = 30000;
  public List<qp> a;
  private mk c;
  private lc d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public qr(mk parammk, lc paramlc)
  {
    AppMethodBeat.i(226206);
    this.c = null;
    this.d = null;
    this.e = true;
    this.f = false;
    this.g = false;
    setName("tms-traffic-refresh");
    this.c = parammk;
    this.d = paramlc;
    this.a = new ArrayList();
    AppMethodBeat.o(226206);
  }
  
  private a a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(226264);
    paramDouble1 = (180.0D + paramDouble1) / 360.0D;
    paramDouble2 = Math.sin(3.1415926D * paramDouble2 / 180.0D);
    paramDouble2 = (180.0D - Math.log((1.0D + paramDouble2) / (1.0D - paramDouble2)) * 180.0D / 6.2831852D) / 360.0D;
    a locala = new a((byte)0);
    locala.a = ((int)(paramDouble1 * 268435456.0D + 0.5D));
    locala.b = ((int)(0.5D + paramDouble2 * 268435456.0D));
    AppMethodBeat.o(226264);
    return locala;
  }
  
  private void a(qp paramqp)
  {
    AppMethodBeat.i(226219);
    if ((this.a == null) || (paramqp == null))
    {
      AppMethodBeat.o(226219);
      return;
    }
    this.a.add(paramqp);
    AppMethodBeat.o(226219);
  }
  
  private static byte[] a(RttRequest paramRttRequest)
  {
    AppMethodBeat.i(226258);
    user_login_t localuser_login_t = new user_login_t();
    localuser_login_t.pf = "android_sdk";
    localuser_login_t.is_login = false;
    localuser_login_t.channel = gw.k();
    localuser_login_t.imei = gw.d();
    f localf = new f();
    localf.c("rttserverex");
    localf.d("getRtt");
    localf.a("info", localuser_login_t);
    localf.a("req", paramRttRequest);
    paramRttRequest = localf.f();
    AppMethodBeat.o(226258);
    return paramRttRequest;
  }
  
  private void b(qp paramqp)
  {
    AppMethodBeat.i(226228);
    if ((this.a == null) || (paramqp == null))
    {
      AppMethodBeat.o(226228);
      return;
    }
    this.a.remove(paramqp);
    AppMethodBeat.o(226228);
  }
  
  private void d()
  {
    AppMethodBeat.i(226241);
    if (this.c == null)
    {
      AppMethodBeat.o(226241);
      return;
    }
    label586:
    label590:
    for (;;)
    {
      try
      {
        int m = this.c.i.A.b.q;
        localObject1 = this.c.i.q();
        double d1 = ((Rect)localObject1).left / 1000000.0F;
        double d2 = ((Rect)localObject1).bottom / 1000000.0F;
        double d3 = ((Rect)localObject1).right / 1000000.0F;
        double d4 = ((Rect)localObject1).top / 1000000.0F;
        localObject1 = a(d1, d2);
        localObject3 = a(d3, d4);
        localObject4 = this.c.g;
        ((sc)localObject4).b(new sc.2((sc)localObject4, m, Math.min(((a)localObject1).a, ((a)localObject3).a), Math.min(((a)localObject1).b, ((a)localObject3).b), Math.max(((a)localObject3).a, ((a)localObject1).a), Math.max(((a)localObject3).b, ((a)localObject1).b)));
        if (this.c == null)
        {
          localObject1 = null;
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            localObject3 = this.c.g;
            ((Integer)((sc)localObject3).a(new sc.159((sc)localObject3, (byte[])localObject1, localObject1.length), Integer.valueOf(-1))).intValue();
          }
          AppMethodBeat.o(226241);
          return;
        }
        if (this.c == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = this.c.g;
          localObject3 = (qq[])((sc)localObject1).a(new sc.24((sc)localObject1), null);
          if ((localObject3 == null) || (localObject3.length == 0)) {
            break label586;
          }
          localObject1 = new RttRequest();
          localObject4 = new ArrayList();
          int n = localObject3.length;
          m = 0;
          if (m < n)
          {
            localf = localObject3[m];
            ((ArrayList)localObject4).add(Integer.valueOf(localf.d));
            ((ArrayList)localObject4).add(Integer.valueOf(localf.c));
            ((ArrayList)localObject4).add(Integer.valueOf(localf.f));
            ((ArrayList)localObject4).add(Integer.valueOf(localf.e));
            ((ArrayList)localObject4).add(Integer.valueOf(localf.g));
            m += 1;
            continue;
          }
          ((RttRequest)localObject1).bounds = ((ArrayList)localObject4);
          ((RttRequest)localObject1).zip = 1;
          ((RttRequest)localObject1).zoom = ((short)localObject3[0].a);
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        f localf;
        kh.b("refreshTrafficData error", localThrowable);
        AppMethodBeat.o(226241);
        return;
      }
      localObject3 = this.d;
      localObject4 = new user_login_t();
      ((user_login_t)localObject4).pf = "android_sdk";
      ((user_login_t)localObject4).is_login = false;
      ((user_login_t)localObject4).channel = gw.k();
      ((user_login_t)localObject4).imei = gw.d();
      localf = new f();
      localf.c("rttserverex");
      localf.d("getRtt");
      localf.a("info", localObject4);
      localf.a("req", localObject1);
      localObject1 = ((lc)localObject3).a(localf.f());
      continue;
      for (;;)
      {
        if (localThrowable != null) {
          break label590;
        }
        Object localObject2 = null;
        break;
        localObject2 = null;
      }
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(226248);
    int m = this.c.i.A.b.q;
    Object localObject = this.c.i.q();
    double d1 = ((Rect)localObject).left / 1000000.0F;
    double d2 = ((Rect)localObject).bottom / 1000000.0F;
    double d3 = ((Rect)localObject).right / 1000000.0F;
    double d4 = ((Rect)localObject).top / 1000000.0F;
    localObject = a(d1, d2);
    a locala = a(d3, d4);
    sc localsc = this.c.g;
    localsc.b(new sc.2(localsc, m, Math.min(((a)localObject).a, locala.a), Math.min(((a)localObject).b, locala.b), Math.max(locala.a, ((a)localObject).a), Math.max(locala.b, ((a)localObject).b)));
    AppMethodBeat.o(226248);
  }
  
  private byte[] f()
  {
    AppMethodBeat.i(226254);
    if (this.c == null)
    {
      AppMethodBeat.o(226254);
      return null;
    }
    if (this.c == null) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(226254);
      return null;
      localObject1 = this.c.g;
      localObject2 = (qq[])((sc)localObject1).a(new sc.24((sc)localObject1), null);
      if ((localObject2 == null) || (localObject2.length == 0))
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = new RttRequest();
        localObject3 = new ArrayList();
        int n = localObject2.length;
        int m = 0;
        while (m < n)
        {
          localf = localObject2[m];
          ((ArrayList)localObject3).add(Integer.valueOf(localf.d));
          ((ArrayList)localObject3).add(Integer.valueOf(localf.c));
          ((ArrayList)localObject3).add(Integer.valueOf(localf.f));
          ((ArrayList)localObject3).add(Integer.valueOf(localf.e));
          ((ArrayList)localObject3).add(Integer.valueOf(localf.g));
          m += 1;
        }
        ((RttRequest)localObject1).bounds = ((ArrayList)localObject3);
        ((RttRequest)localObject1).zip = 1;
        ((RttRequest)localObject1).zoom = ((short)localObject2[0].a);
      }
    }
    Object localObject2 = this.d;
    Object localObject3 = new user_login_t();
    ((user_login_t)localObject3).pf = "android_sdk";
    ((user_login_t)localObject3).is_login = false;
    ((user_login_t)localObject3).channel = gw.k();
    ((user_login_t)localObject3).imei = gw.d();
    f localf = new f();
    localf.c("rttserverex");
    localf.d("getRtt");
    localf.a("info", localObject3);
    localf.a("req", localObject1);
    Object localObject1 = ((lc)localObject2).a(localf.f());
    AppMethodBeat.o(226254);
    return localObject1;
  }
  
  private RttRequest g()
  {
    AppMethodBeat.i(226261);
    if (this.c == null)
    {
      AppMethodBeat.o(226261);
      return null;
    }
    Object localObject1 = this.c.g;
    localObject1 = (qq[])((sc)localObject1).a(new sc.24((sc)localObject1), null);
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      AppMethodBeat.o(226261);
      return null;
    }
    RttRequest localRttRequest = new RttRequest();
    ArrayList localArrayList = new ArrayList();
    int n = localObject1.length;
    int m = 0;
    while (m < n)
    {
      Object localObject2 = localObject1[m];
      localArrayList.add(Integer.valueOf(localObject2.d));
      localArrayList.add(Integer.valueOf(localObject2.c));
      localArrayList.add(Integer.valueOf(localObject2.f));
      localArrayList.add(Integer.valueOf(localObject2.e));
      localArrayList.add(Integer.valueOf(localObject2.g));
      m += 1;
    }
    localRttRequest.bounds = localArrayList;
    localRttRequest.zip = 1;
    localRttRequest.zoom = ((short)localObject1[0].a);
    AppMethodBeat.o(226261);
    return localRttRequest;
  }
  
  public final void a()
  {
    AppMethodBeat.i(226271);
    this.f = true;
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(226271);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(226273);
    this.f = false;
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(226273);
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(226275);
    this.g = true;
    try
    {
      notifyAll();
      interrupt();
      AppMethodBeat.o(226275);
      return;
    }
    finally
    {
      AppMethodBeat.o(226275);
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(226268);
    super.run();
    for (;;)
    {
      if (!this.g) {
        if (!this.f)
        {
          if (this.c == null)
          {
            AppMethodBeat.o(226268);
            return;
          }
          if (this.c == null) {}
        }
      }
      try
      {
        m = this.c.i.A.b.q;
        Object localObject1 = this.c.i.q();
        double d1 = ((Rect)localObject1).left / 1000000.0F;
        double d2 = ((Rect)localObject1).bottom / 1000000.0F;
        double d3 = ((Rect)localObject1).right / 1000000.0F;
        double d4 = ((Rect)localObject1).top / 1000000.0F;
        localObject1 = a(d1, d2);
        localObject5 = a(d3, d4);
        localObject6 = this.c.g;
        ((sc)localObject6).b(new sc.2((sc)localObject6, m, Math.min(((a)localObject1).a, ((a)localObject5).a), Math.min(((a)localObject1).b, ((a)localObject5).b), Math.max(((a)localObject5).a, ((a)localObject1).a), Math.max(((a)localObject5).b, ((a)localObject1).b)));
        if (this.c != null) {
          break label338;
        }
        localObject1 = null;
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject5 = this.c.g;
          ((Integer)((sc)localObject5).a(new sc.159((sc)localObject5, (byte[])localObject1, localObject1.length), Integer.valueOf(-1))).intValue();
        }
      }
      finally
      {
        for (;;)
        {
          int m;
          Object localObject5;
          Object localObject6;
          Object localObject3;
          int n;
          f localf;
          kh.b("refreshTrafficData error", localThrowable);
          continue;
          wait(30000L);
        }
      }
      this.c.v = true;
      try
      {
        try
        {
          if (!this.e) {
            break label655;
          }
          wait(500L);
          this.e = false;
          continue;
        }
        finally
        {
          AppMethodBeat.o(226268);
        }
        AppMethodBeat.o(226268);
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
    return;
    label338:
    if (this.c == null)
    {
      localObject3 = null;
    }
    else
    {
      localObject3 = this.c.g;
      localObject5 = (qq[])((sc)localObject3).a(new sc.24((sc)localObject3), null);
      if ((localObject5 == null) || (localObject5.length == 0)) {
        break label676;
      }
      localObject3 = new RttRequest();
      localObject6 = new ArrayList();
      n = localObject5.length;
      m = 0;
      while (m < n)
      {
        localf = localObject5[m];
        ((ArrayList)localObject6).add(Integer.valueOf(localf.d));
        ((ArrayList)localObject6).add(Integer.valueOf(localf.c));
        ((ArrayList)localObject6).add(Integer.valueOf(localf.f));
        ((ArrayList)localObject6).add(Integer.valueOf(localf.e));
        ((ArrayList)localObject6).add(Integer.valueOf(localf.g));
        m += 1;
      }
      ((RttRequest)localObject3).bounds = ((ArrayList)localObject6);
      ((RttRequest)localObject3).zip = 1;
      ((RttRequest)localObject3).zoom = ((short)localObject5[0].a);
    }
    label655:
    label676:
    label680:
    for (;;)
    {
      localObject5 = this.d;
      localObject6 = new user_login_t();
      ((user_login_t)localObject6).pf = "android_sdk";
      ((user_login_t)localObject6).is_login = false;
      ((user_login_t)localObject6).channel = gw.k();
      ((user_login_t)localObject6).imei = gw.d();
      localf = new f();
      localf.c("rttserverex");
      localf.d("getRtt");
      localf.a("info", localObject6);
      localf.a("req", localObject3);
      localObject3 = ((lc)localObject5).a(localf.f());
      break;
      for (;;)
      {
        if (localThrowable != null) {
          break label680;
        }
        Object localObject4 = null;
        break;
        localObject4 = null;
      }
    }
  }
  
  final class a
  {
    public int a;
    public int b;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qr
 * JD-Core Version:    0.7.0.1
 */