package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class it
  extends ie
{
  private static long G = 0L;
  private static final long b = 10L;
  static final int c = 0;
  static final int d = 1;
  static final int e = 0;
  static final int f = 1;
  static final int g = 2;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = -1;
  private static ThreadLocal<a> q;
  private static final ThreadLocal<ArrayList<it>> r;
  private static final ThreadLocal<ArrayList<it>> s;
  private static final ThreadLocal<ArrayList<it>> t;
  private static final ThreadLocal<ArrayList<it>> u;
  private static final ThreadLocal<ArrayList<it>> v;
  private static final Interpolator w;
  private boolean A = false;
  private long B;
  private boolean C = false;
  private boolean D = false;
  private long E = 300L;
  private long F = 0L;
  private int H = 0;
  private int I = 1;
  private Interpolator J = w;
  private ArrayList<it.b> K = null;
  long h;
  long i = -1L;
  int j = 0;
  ip[] k;
  HashMap<Integer, ip> l;
  protected ib m;
  private boolean x = false;
  private int y = 0;
  private float z = 0.0F;
  
  static
  {
    AppMethodBeat.i(223408);
    q = new ThreadLocal();
    r = new it.1();
    s = new it.2();
    t = new it.3();
    u = new it.4();
    v = new it.5();
    w = new LinearInterpolator();
    G = 10L;
    AppMethodBeat.o(223408);
  }
  
  public it(ib paramib)
  {
    this.m = paramib;
  }
  
  private static int A()
  {
    AppMethodBeat.i(223294);
    int i1 = ((ArrayList)r.get()).size();
    AppMethodBeat.o(223294);
    return i1;
  }
  
  private static void B()
  {
    AppMethodBeat.i(223302);
    ((ArrayList)r.get()).clear();
    ((ArrayList)s.get()).clear();
    ((ArrayList)t.get()).clear();
    AppMethodBeat.o(223302);
  }
  
  private static void C() {}
  
  private static it a(ib paramib, is<?> paramis, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(223106);
    paramib = new it(paramib);
    paramib.a(paramArrayOfObject);
    paramib.a(paramis);
    AppMethodBeat.o(223106);
    return paramib;
  }
  
  private static it a(ib paramib, int... paramVarArgs)
  {
    AppMethodBeat.i(223087);
    paramib = new it(paramib);
    paramib.a(paramVarArgs);
    AppMethodBeat.o(223087);
    return paramib;
  }
  
  private static it a(ib paramib, ip... paramVarArgs)
  {
    AppMethodBeat.i(223099);
    paramib = new it(paramib);
    paramib.a(paramVarArgs);
    AppMethodBeat.o(223099);
    return paramib;
  }
  
  private Object a(int paramInt)
  {
    AppMethodBeat.i(223148);
    Object localObject = (ip)this.l.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((ip)localObject).b();
      AppMethodBeat.o(223148);
      return localObject;
    }
    AppMethodBeat.o(223148);
    return null;
  }
  
  private void a(it.b paramb)
  {
    AppMethodBeat.i(223177);
    if (this.K == null) {
      this.K = new ArrayList();
    }
    this.K.add(paramb);
    AppMethodBeat.o(223177);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223213);
    this.x = paramBoolean;
    this.y = 0;
    this.j = 0;
    this.D = true;
    this.A = false;
    ((ArrayList)s.get()).add(this);
    if (this.F == 0L)
    {
      if (this.j == 0) {}
      for (long l1 = 0L;; l1 = SystemClock.uptimeMillis() - this.h)
      {
        long l2 = SystemClock.uptimeMillis();
        if (this.j != 1)
        {
          this.i = l1;
          this.j = 2;
        }
        this.h = (l2 - l1);
        c(l2);
        this.j = 0;
        this.C = true;
        if (this.a == null) {
          break;
        }
        localObject = (ArrayList)this.a.clone();
        int i2 = ((ArrayList)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((ie.a)((ArrayList)localObject).get(i1)).a(this);
          i1 += 1;
        }
      }
    }
    Object localObject = (a)q.get();
    if (localObject == null)
    {
      localObject = new a(Looper.getMainLooper());
      q.set(localObject);
    }
    for (;;)
    {
      ((a)localObject).sendEmptyMessage(0);
      AppMethodBeat.o(223213);
      return;
      ((a)localObject).removeMessages(0);
      ((a)localObject).removeMessages(1);
    }
  }
  
  public static it b(double... paramVarArgs)
  {
    AppMethodBeat.i(223093);
    it localit = new it(null);
    localit.a(paramVarArgs);
    AppMethodBeat.o(223093);
    return localit;
  }
  
  private void b(int paramInt)
  {
    this.H = paramInt;
  }
  
  private void b(it.b paramb)
  {
    AppMethodBeat.i(223194);
    if (this.K == null)
    {
      AppMethodBeat.o(223194);
      return;
    }
    this.K.remove(paramb);
    if (this.K.size() == 0) {
      this.K = null;
    }
    AppMethodBeat.o(223194);
  }
  
  private void c(int paramInt)
  {
    this.I = paramInt;
  }
  
  public static void d(long paramLong)
  {
    G = paramLong;
  }
  
  private void e(long paramLong)
  {
    AppMethodBeat.i(223118);
    long l1 = SystemClock.uptimeMillis();
    if (this.j != 1)
    {
      this.i = paramLong;
      this.j = 2;
    }
    this.h = (l1 - paramLong);
    c(l1);
    AppMethodBeat.o(223118);
  }
  
  private boolean f(long paramLong)
  {
    if (!this.A)
    {
      this.A = true;
      this.B = paramLong;
    }
    long l1;
    do
    {
      return false;
      l1 = paramLong - this.B;
    } while (l1 <= this.F);
    this.h = (paramLong - (l1 - this.F));
    this.j = 1;
    return true;
  }
  
  private ip[] o()
  {
    return this.k;
  }
  
  private long p()
  {
    AppMethodBeat.i(223122);
    if (this.j == 0)
    {
      AppMethodBeat.o(223122);
      return 0L;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.h;
    AppMethodBeat.o(223122);
    return l1 - l2;
  }
  
  private static long q()
  {
    return G;
  }
  
  private Object r()
  {
    AppMethodBeat.i(223139);
    if ((this.k != null) && (this.k.length > 0))
    {
      Object localObject = this.k[0].b();
      AppMethodBeat.o(223139);
      return localObject;
    }
    AppMethodBeat.o(223139);
    return null;
  }
  
  private int s()
  {
    return this.H;
  }
  
  private int t()
  {
    return this.I;
  }
  
  private void u()
  {
    AppMethodBeat.i(223186);
    if (this.K == null)
    {
      AppMethodBeat.o(223186);
      return;
    }
    this.K.clear();
    this.K = null;
    AppMethodBeat.o(223186);
  }
  
  private Interpolator v()
  {
    return this.J;
  }
  
  private void w()
  {
    AppMethodBeat.i(223244);
    if (!this.x) {}
    for (boolean bool = true;; bool = false)
    {
      this.x = bool;
      if (this.j != 1) {
        break;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.h;
      this.h = (l1 - (this.E - (l1 - l2)));
      AppMethodBeat.o(223244);
      return;
    }
    a(true);
    AppMethodBeat.o(223244);
  }
  
  private void x()
  {
    AppMethodBeat.i(223259);
    ((ArrayList)r.get()).remove(this);
    ((ArrayList)s.get()).remove(this);
    ((ArrayList)t.get()).remove(this);
    this.j = 0;
    if ((this.C) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ie.a)localArrayList.get(i1)).b(this);
        i1 += 1;
      }
    }
    this.C = false;
    this.D = false;
    AppMethodBeat.o(223259);
  }
  
  private void y()
  {
    AppMethodBeat.i(223272);
    ((ArrayList)r.get()).add(this);
    if ((this.F > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ie.a)localArrayList.get(i1)).a(this);
        i1 += 1;
      }
    }
    AppMethodBeat.o(223272);
  }
  
  private float z()
  {
    return this.z;
  }
  
  public final void a()
  {
    AppMethodBeat.i(223503);
    a(false);
    AppMethodBeat.o(223503);
  }
  
  protected void a(float paramFloat)
  {
    int i2 = 0;
    AppMethodBeat.i(223556);
    paramFloat = this.J.getInterpolation(paramFloat);
    this.z = paramFloat;
    int i3 = this.k.length;
    int i1 = 0;
    while (i1 < i3)
    {
      this.k[i1].a(paramFloat);
      if (this.m != null) {
        this.m.a(this.k[i1].a, this.k[i1].b());
      }
      i1 += 1;
    }
    if (this.K != null)
    {
      i3 = this.K.size();
      i1 = i2;
      while (i1 < i3)
      {
        this.K.get(i1);
        i1 += 1;
      }
    }
    AppMethodBeat.o(223556);
  }
  
  public final void a(long paramLong)
  {
    this.F = paramLong;
  }
  
  public final void a(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(223488);
    if (paramInterpolator != null)
    {
      this.J = paramInterpolator;
      AppMethodBeat.o(223488);
      return;
    }
    this.J = new LinearInterpolator();
    AppMethodBeat.o(223488);
  }
  
  public final void a(is<?> paramis)
  {
    AppMethodBeat.i(223496);
    if ((paramis != null) && (this.k != null) && (this.k.length > 0)) {
      this.k[0].a(paramis);
    }
    AppMethodBeat.o(223496);
  }
  
  public void a(double... paramVarArgs)
  {
    AppMethodBeat.i(223429);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(223429);
      return;
    }
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(0, paramVarArgs) });
      AppMethodBeat.o(223429);
      return;
    }
    this.k[0].a(paramVarArgs);
    AppMethodBeat.o(223429);
  }
  
  public void a(int... paramVarArgs)
  {
    AppMethodBeat.i(223419);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(223419);
      return;
    }
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(0, paramVarArgs) });
      AppMethodBeat.o(223419);
      return;
    }
    this.k[0].a(paramVarArgs);
    AppMethodBeat.o(223419);
  }
  
  public final void a(ip... paramVarArgs)
  {
    AppMethodBeat.i(223449);
    int i2 = paramVarArgs.length;
    this.k = paramVarArgs;
    this.l = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ip localip = paramVarArgs[i1];
      this.l.put(Integer.valueOf(localip.a), localip);
      i1 += 1;
    }
    AppMethodBeat.o(223449);
  }
  
  public void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(223436);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(223436);
      return;
    }
    if ((this.k == null) || (this.k.length == 0))
    {
      a(new ip[] { ip.a(0, paramVarArgs) });
      AppMethodBeat.o(223436);
      return;
    }
    this.k[0].a(paramVarArgs);
    AppMethodBeat.o(223436);
  }
  
  public ie b(long paramLong)
  {
    AppMethodBeat.i(223459);
    if (paramLong < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(223459);
      throw localIllegalArgumentException;
    }
    this.E = paramLong;
    AppMethodBeat.o(223459);
    return this;
  }
  
  public final void b()
  {
    AppMethodBeat.i(223511);
    if ((this.j != 0) || (((ArrayList)s.get()).contains(this)) || (((ArrayList)t.get()).contains(this)))
    {
      if ((this.C) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((ie.a)localIterator.next()).a();
        }
      }
      x();
    }
    AppMethodBeat.o(223511);
  }
  
  public final void c()
  {
    AppMethodBeat.i(223521);
    if ((!((ArrayList)r.get()).contains(this)) && (!((ArrayList)s.get()).contains(this)))
    {
      this.A = false;
      y();
    }
    if ((this.H > 0) && ((this.H & 0x1) == 1)) {
      a(0.0F);
    }
    for (;;)
    {
      x();
      AppMethodBeat.o(223521);
      return;
      a(1.0F);
    }
  }
  
  protected boolean c(long paramLong)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(223547);
    if (this.j == 0)
    {
      this.j = 1;
      if (this.i >= 0L) {
        break label77;
      }
      this.h = paramLong;
    }
    for (;;)
    {
      switch (this.j)
      {
      default: 
        AppMethodBeat.o(223547);
        return bool1;
        label77:
        this.h = (paramLong - this.i);
        this.i = -1L;
      }
    }
    if (this.E > 0L) {}
    for (float f2 = (float)(paramLong - this.h) / (float)this.E;; f2 = 1.0F)
    {
      bool1 = bool2;
      f1 = f2;
      if (f2 < 1.0F) {
        break label267;
      }
      if ((this.y >= this.H) && (this.H != -1)) {
        break label291;
      }
      if (this.a == null) {
        break;
      }
      int i2 = this.a.size();
      int i1 = 0;
      while (i1 < i2)
      {
        this.a.get(i1);
        i1 += 1;
      }
    }
    if (this.I == 2)
    {
      bool1 = bool3;
      if (this.x) {
        bool1 = false;
      }
      this.x = bool1;
    }
    this.y += (int)f2;
    this.h += this.E;
    float f1 = f2 % 1.0F;
    for (bool1 = bool2;; bool1 = true)
    {
      label267:
      f2 = f1;
      if (this.x) {
        f2 = 1.0F - f1;
      }
      a(f2);
      break;
      label291:
      f1 = Math.min(f2, 1.0F);
    }
  }
  
  public final long d()
  {
    return this.F;
  }
  
  public final long e()
  {
    return this.E;
  }
  
  public final boolean f()
  {
    return (this.j == 1) || (this.C);
  }
  
  public final boolean g()
  {
    return this.D;
  }
  
  public ie h()
  {
    int i2 = 0;
    AppMethodBeat.i(223565);
    it localit = (it)super.h();
    int i3;
    int i1;
    if (this.K != null)
    {
      localObject = this.K;
      localit.K = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localit.K.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localit.i = -1L;
    localit.x = false;
    localit.y = 0;
    localit.j = 0;
    localit.A = false;
    Object localObject = this.k;
    if (localObject != null)
    {
      i3 = localObject.length;
      localit.k = new ip[i3];
      localit.l = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        ip localip = localObject[i1].a();
        localit.k[i1] = localip;
        localit.l.put(Integer.valueOf(localip.a), localip);
        i1 += 1;
      }
    }
    AppMethodBeat.o(223565);
    return localit;
  }
  
  public String toString()
  {
    AppMethodBeat.i(223573);
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.k != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.k.length) {
          break;
        }
        str1 = str1 + "\n    " + this.k[i1].toString();
        i1 += 1;
      }
    }
    AppMethodBeat.o(223573);
    return str2;
  }
  
  static final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(222603);
      ArrayList localArrayList1 = (ArrayList)it.i().get();
      ArrayList localArrayList2 = (ArrayList)it.j().get();
      int i;
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(222603);
        return;
      case 0: 
        paramMessage = (ArrayList)it.k().get();
        if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
          i = 0;
        }
        break;
      }
      for (;;)
      {
        int j = i;
        Object localObject;
        int k;
        it localit;
        if (paramMessage.size() > 0)
        {
          localObject = (ArrayList)paramMessage.clone();
          paramMessage.clear();
          k = ((ArrayList)localObject).size();
          j = 0;
          if (j < k)
          {
            localit = (it)((ArrayList)localObject).get(j);
            if (it.a(localit) == 0L) {
              it.b(localit);
            }
            for (;;)
            {
              j += 1;
              break;
              localArrayList2.add(localit);
            }
            j = 1;
          }
        }
        else
        {
          long l = SystemClock.uptimeMillis();
          localObject = (ArrayList)it.l().get();
          paramMessage = (ArrayList)it.m().get();
          k = localArrayList2.size();
          i = 0;
          while (i < k)
          {
            localit = (it)localArrayList2.get(i);
            if (it.a(localit, l)) {
              ((ArrayList)localObject).add(localit);
            }
            i += 1;
          }
          k = ((ArrayList)localObject).size();
          if (k > 0)
          {
            i = 0;
            while (i < k)
            {
              localit = (it)((ArrayList)localObject).get(i);
              it.b(localit);
              it.c(localit);
              localArrayList2.remove(localit);
              i += 1;
            }
            ((ArrayList)localObject).clear();
          }
          k = localArrayList1.size();
          i = 0;
          while (i < k)
          {
            localObject = (it)localArrayList1.get(i);
            if (((it)localObject).c(l)) {
              paramMessage.add(localObject);
            }
            if (localArrayList1.size() == k)
            {
              i += 1;
            }
            else
            {
              k -= 1;
              paramMessage.remove(localObject);
            }
          }
          if (paramMessage.size() > 0)
          {
            i = 0;
            while (i < paramMessage.size())
            {
              it.d((it)paramMessage.get(i));
              i += 1;
            }
            paramMessage.clear();
          }
          if ((j == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
            break;
          }
          sendEmptyMessageDelayed(1, Math.max(0L, it.n() - (SystemClock.uptimeMillis() - l)));
          break;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.it
 * JD-Core Version:    0.7.0.1
 */