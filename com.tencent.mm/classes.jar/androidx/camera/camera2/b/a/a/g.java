package androidx.camera.camera2.b.a.a;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class g
{
  public final c Fw;
  
  public g(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
  {
    AppMethodBeat.i(198158);
    if (Build.VERSION.SDK_INT < 28)
    {
      this.Fw = new b(0, paramList, paramExecutor, paramStateCallback);
      AppMethodBeat.o(198158);
      return;
    }
    this.Fw = new a(0, paramList, paramExecutor, paramStateCallback);
    AppMethodBeat.o(198158);
  }
  
  static List<b> D(List<OutputConfiguration> paramList)
  {
    AppMethodBeat.i(198163);
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = (OutputConfiguration)localIterator.next();
        if (paramList == null)
        {
          paramList = null;
          localArrayList.add(paramList);
        }
        else if (Build.VERSION.SDK_INT >= 28)
        {
          paramList = new e((OutputConfiguration)paramList);
        }
      }
    }
    for (;;)
    {
      if (paramList == null)
      {
        paramList = null;
        break;
        if (Build.VERSION.SDK_INT >= 26)
        {
          paramList = new d(new d.a((OutputConfiguration)paramList));
          continue;
        }
        if (Build.VERSION.SDK_INT < 24) {
          break label168;
        }
        paramList = new c(new c.a((OutputConfiguration)paramList));
        continue;
      }
      paramList = new b(paramList);
      break;
      AppMethodBeat.o(198163);
      return localArrayList;
      label168:
      paramList = null;
    }
  }
  
  public static List<OutputConfiguration> E(List<b> paramList)
  {
    AppMethodBeat.i(198167);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((OutputConfiguration)((b)paramList.next()).hV());
    }
    AppMethodBeat.o(198167);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198186);
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(198186);
      return false;
    }
    boolean bool = this.Fw.equals(((g)paramObject).Fw);
    AppMethodBeat.o(198186);
    return bool;
  }
  
  public final Executor hI()
  {
    AppMethodBeat.i(198179);
    Executor localExecutor = this.Fw.hI();
    AppMethodBeat.o(198179);
    return localExecutor;
  }
  
  public final int hZ()
  {
    AppMethodBeat.i(198171);
    int i = this.Fw.hZ();
    AppMethodBeat.o(198171);
    return i;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198189);
    int i = this.Fw.hashCode();
    AppMethodBeat.o(198189);
    return i;
  }
  
  public final List<b> ia()
  {
    AppMethodBeat.i(198173);
    List localList = this.Fw.ia();
    AppMethodBeat.o(198173);
    return localList;
  }
  
  public final CameraCaptureSession.StateCallback ib()
  {
    AppMethodBeat.i(198176);
    CameraCaptureSession.StateCallback localStateCallback = this.Fw.ib();
    AppMethodBeat.o(198176);
    return localStateCallback;
  }
  
  public final a ic()
  {
    AppMethodBeat.i(198184);
    a locala = this.Fw.ic();
    AppMethodBeat.o(198184);
    return locala;
  }
  
  static final class a
    implements g.c
  {
    private final SessionConfiguration Fx;
    private final List<b> Fy;
    
    a(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      this(new SessionConfiguration(paramInt, g.E(paramList), paramExecutor, paramStateCallback));
      AppMethodBeat.i(198115);
      AppMethodBeat.o(198115);
    }
    
    private a(Object paramObject)
    {
      AppMethodBeat.i(198112);
      this.Fx = ((SessionConfiguration)paramObject);
      this.Fy = Collections.unmodifiableList(g.D(((SessionConfiguration)paramObject).getOutputConfigurations()));
      AppMethodBeat.o(198112);
    }
    
    public final void b(CaptureRequest paramCaptureRequest)
    {
      AppMethodBeat.i(198136);
      this.Fx.setSessionParameters(paramCaptureRequest);
      AppMethodBeat.o(198136);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198145);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(198145);
        return false;
      }
      boolean bool = Objects.equals(this.Fx, ((a)paramObject).Fx);
      AppMethodBeat.o(198145);
      return bool;
    }
    
    public final Executor hI()
    {
      AppMethodBeat.i(198127);
      Executor localExecutor = this.Fx.getExecutor();
      AppMethodBeat.o(198127);
      return localExecutor;
    }
    
    public final int hZ()
    {
      AppMethodBeat.i(198118);
      int i = this.Fx.getSessionType();
      AppMethodBeat.o(198118);
      return i;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(198150);
      int i = this.Fx.hashCode();
      AppMethodBeat.o(198150);
      return i;
    }
    
    public final List<b> ia()
    {
      return this.Fy;
    }
    
    public final CameraCaptureSession.StateCallback ib()
    {
      AppMethodBeat.i(198124);
      CameraCaptureSession.StateCallback localStateCallback = this.Fx.getStateCallback();
      AppMethodBeat.o(198124);
      return localStateCallback;
    }
    
    public final a ic()
    {
      AppMethodBeat.i(198132);
      Object localObject = this.Fx.getInputConfiguration();
      if (localObject == null)
      {
        AppMethodBeat.o(198132);
        return null;
      }
      if (Build.VERSION.SDK_INT < 23)
      {
        AppMethodBeat.o(198132);
        return null;
      }
      localObject = new a(new a.a(localObject));
      AppMethodBeat.o(198132);
      return localObject;
    }
    
    public final Object ie()
    {
      return this.Fx;
    }
  }
  
  static final class b
    implements g.c
  {
    private int FA;
    private a FB;
    private CaptureRequest FC;
    private final List<b> Fy;
    private final CameraCaptureSession.StateCallback Fz;
    private final Executor mExecutor;
    
    b(int paramInt, List<b> paramList, Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      AppMethodBeat.i(198111);
      this.FB = null;
      this.FC = null;
      this.FA = paramInt;
      this.Fy = Collections.unmodifiableList(new ArrayList(paramList));
      this.Fz = paramStateCallback;
      this.mExecutor = paramExecutor;
      AppMethodBeat.o(198111);
    }
    
    public final void b(CaptureRequest paramCaptureRequest)
    {
      this.FC = paramCaptureRequest;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198137);
      if (this == paramObject)
      {
        AppMethodBeat.o(198137);
        return true;
      }
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!Objects.equals(this.FB, paramObject.FB)) || (this.FA != paramObject.FA) || (this.Fy.size() != paramObject.Fy.size()))
        {
          AppMethodBeat.o(198137);
          return false;
        }
        int i = 0;
        while (i < this.Fy.size())
        {
          if (!((b)this.Fy.get(i)).equals(paramObject.Fy.get(i)))
          {
            AppMethodBeat.o(198137);
            return false;
          }
          i += 1;
        }
        AppMethodBeat.o(198137);
        return true;
      }
      AppMethodBeat.o(198137);
      return false;
    }
    
    public final Executor hI()
    {
      return this.mExecutor;
    }
    
    public final int hZ()
    {
      return this.FA;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(198143);
      int j = this.Fy.hashCode() ^ 0x1F;
      if (this.FB == null) {}
      for (int i = 0;; i = this.FB.hashCode())
      {
        i ^= (j << 5) - j;
        j = this.FA;
        AppMethodBeat.o(198143);
        return (i << 5) - i ^ j;
      }
    }
    
    public final List<b> ia()
    {
      return this.Fy;
    }
    
    public final CameraCaptureSession.StateCallback ib()
    {
      return this.Fz;
    }
    
    public final a ic()
    {
      return this.FB;
    }
    
    public final Object ie()
    {
      return null;
    }
  }
  
  public static abstract interface c
  {
    public abstract void b(CaptureRequest paramCaptureRequest);
    
    public abstract Executor hI();
    
    public abstract int hZ();
    
    public abstract List<b> ia();
    
    public abstract CameraCaptureSession.StateCallback ib();
    
    public abstract a ic();
    
    public abstract Object ie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */