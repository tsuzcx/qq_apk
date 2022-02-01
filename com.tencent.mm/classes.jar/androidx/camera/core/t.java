package androidx.camera.core;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.a.d;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.core.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

public final class t
{
  private static final Object GO;
  private static final SparseArray<Integer> GP;
  public final androidx.camera.core.impl.u GA;
  private final Object GC;
  private final u GD;
  private final Executor GE;
  private final Handler GF;
  private final HandlerThread GG;
  private r GH;
  public q GI;
  public bl GJ;
  public final com.google.b.b.a.f<Void> GK;
  private a GL;
  private com.google.b.b.a.f<Void> GM;
  private final Integer GN;
  private Context mAppContext;
  
  static
  {
    AppMethodBeat.i(198612);
    GO = new Object();
    GP = new SparseArray();
    AppMethodBeat.o(198612);
  }
  
  public t(Context paramContext, u.b paramb)
  {
    AppMethodBeat.i(198553);
    this.GA = new androidx.camera.core.impl.u();
    this.GC = new Object();
    this.GL = a.GQ;
    this.GM = e.v(null);
    Object localObject = paramb;
    if (paramb == null)
    {
      paramb = P(paramContext);
      localObject = paramb;
      if (paramb == null)
      {
        paramContext = new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
        AppMethodBeat.o(198553);
        throw paramContext;
      }
    }
    this.GD = ((u.b)localObject).getCameraXConfig();
    localObject = (Executor)this.GD.Hd.b(u.GZ, null);
    Handler localHandler = (Handler)this.GD.Hd.b(u.Ha, null);
    paramb = (u.b)localObject;
    if (localObject == null) {
      paramb = new l();
    }
    this.GE = paramb;
    if (localHandler == null)
    {
      this.GG = new HandlerThread("CameraX-scheduler", 10);
      this.GG.start();
    }
    for (this.GF = c.b(this.GG.getLooper());; this.GF = localHandler)
    {
      this.GN = ((Integer)this.GD.b(u.Hb, null));
      localObject = this.GN;
      paramb = GO;
      if (localObject != null) {
        break;
      }
      this.GK = Q(paramContext);
      AppMethodBeat.o(198553);
      return;
      this.GG = null;
    }
    for (;;)
    {
      try
      {
        androidx.core.f.f.b(((Integer)localObject).intValue(), 3, 6, "minLogLevel");
        int i = 1;
        if (GP.get(((Integer)localObject).intValue()) != null) {
          i = ((Integer)GP.get(((Integer)localObject).intValue())).intValue() + 1;
        }
        GP.put(((Integer)localObject).intValue(), Integer.valueOf(i));
        if (GP.size() == 0)
        {
          al.jg();
          break;
        }
      }
      finally
      {
        AppMethodBeat.o(198553);
      }
      if (GP.get(3) != null) {
        al.aT(3);
      } else if (GP.get(4) != null) {
        al.aT(4);
      } else if (GP.get(5) != null) {
        al.aT(5);
      } else if (GP.get(6) != null) {
        al.aT(6);
      }
    }
  }
  
  private static u.b P(Context paramContext)
  {
    AppMethodBeat.i(198561);
    paramContext = d.S(paramContext);
    if ((paramContext instanceof u.b)) {
      paramContext = (u.b)paramContext;
    }
    for (;;)
    {
      AppMethodBeat.o(198561);
      return paramContext;
      try
      {
        paramContext = (u.b)Class.forName("androidx.camera.camera2.Camera2Config$DefaultProvider").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      }
      catch (ClassNotFoundException paramContext)
      {
        al.U("CameraX");
        paramContext = null;
      }
      catch (NullPointerException paramContext)
      {
        break label56;
      }
      catch (InstantiationException paramContext)
      {
        break label56;
      }
      catch (IllegalAccessException paramContext)
      {
        break label56;
      }
      catch (NoSuchMethodException paramContext)
      {
        break label56;
      }
      catch (InvocationTargetException paramContext)
      {
        break label56;
      }
      catch (Resources.NotFoundException paramContext)
      {
        label56:
        break label56;
      }
    }
  }
  
  private com.google.b.b.a.f<Void> Q(Context paramContext)
  {
    AppMethodBeat.i(198570);
    synchronized (this.GC)
    {
      if (this.GL == a.GQ)
      {
        bool = true;
        androidx.core.f.f.b(bool, "CameraX.initInternal() should only be called once per instance");
        this.GL = a.GR;
        paramContext = b.a(new t..ExternalSyntheticLambda0(this, paramContext));
        AppMethodBeat.o(198570);
        return paramContext;
      }
      boolean bool = false;
    }
  }
  
  private void a(Executor paramExecutor, long paramLong, Context paramContext, b.a<Void> parama)
  {
    AppMethodBeat.i(198578);
    paramExecutor.execute(new t..ExternalSyntheticLambda1(this, paramContext, paramExecutor, parama, paramLong));
    AppMethodBeat.o(198578);
  }
  
  private void iK()
  {
    synchronized (this.GC)
    {
      this.GL = a.GT;
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(198428);
      GQ = new a("UNINITIALIZED", 0);
      GR = new a("INITIALIZING", 1);
      GS = new a("INITIALIZING_ERROR", 2);
      GT = new a("INITIALIZED", 3);
      GU = new a("SHUTDOWN", 4);
      GV = new a[] { GQ, GR, GS, GT, GU };
      AppMethodBeat.o(198428);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.t
 * JD-Core Version:    0.7.0.1
 */