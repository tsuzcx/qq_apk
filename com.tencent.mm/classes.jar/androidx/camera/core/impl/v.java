package androidx.camera.core.impl;

import androidx.camera.core.al;
import androidx.camera.core.i;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class v
{
  private final StringBuilder LL;
  private final int LM;
  public final Map<i, a> LN;
  private int LO;
  public final Object mLock;
  
  public v()
  {
    AppMethodBeat.i(198666);
    this.LL = new StringBuilder();
    this.mLock = new Object();
    this.LN = new HashMap();
    this.LM = 1;
    try
    {
      this.LO = this.LM;
      return;
    }
    finally
    {
      AppMethodBeat.o(198666);
    }
  }
  
  private static boolean a(t.a parama)
  {
    return (parama != null) && (parama.LG);
  }
  
  private void jX()
  {
    AppMethodBeat.i(198695);
    if (al.N("CameraStateRegistry"))
    {
      this.LL.setLength(0);
      this.LL.append("Recalculating open cameras:\n");
      this.LL.append(String.format(Locale.US, "%-45s%-22s\n", new Object[] { "Camera", "State" }));
      this.LL.append("-------------------------------------------------------------------\n");
    }
    Iterator localIterator = this.LN.entrySet().iterator();
    int i = 0;
    String str;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (al.N("CameraStateRegistry"))
      {
        if (((a)localEntry.getValue()).LP != null)
        {
          str = ((a)localEntry.getValue()).LP.toString();
          label149:
          this.LL.append(String.format(Locale.US, "%-45s%-22s\n", new Object[] { ((i)localEntry.getKey()).toString(), str }));
        }
      }
      else
      {
        if (!a(((a)localEntry.getValue()).LP)) {
          break label301;
        }
        i += 1;
      }
    }
    label301:
    for (;;)
    {
      break;
      str = "UNKNOWN";
      break label149;
      if (al.N("CameraStateRegistry"))
      {
        this.LL.append("-------------------------------------------------------------------\n");
        this.LL.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(this.LM) }));
        al.O("CameraStateRegistry");
      }
      this.LO = Math.max(this.LM - i, 0);
      AppMethodBeat.o(198695);
      return;
    }
  }
  
  public final void a(i parami, t.a parama, boolean paramBoolean)
  {
    Map.Entry localEntry = null;
    AppMethodBeat.i(198731);
    int i;
    Object localObject1;
    boolean bool;
    for (;;)
    {
      synchronized (this.mLock)
      {
        i = this.LO;
        if (parama == t.a.LF)
        {
          localObject1 = (a)this.LN.remove(parami);
          if (localObject1 != null)
          {
            jX();
            localObject1 = ((a)localObject1).LP;
            if (localObject1 != parama) {
              break;
            }
            AppMethodBeat.o(198731);
            return;
          }
          localObject1 = null;
          continue;
        }
        t.a locala = ((a)f.checkNotNull((a)this.LN.get(parami), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).b(parama);
        if (parama == t.a.LA)
        {
          if (a(parama)) {
            break label410;
          }
          if (locala == t.a.LA)
          {
            break label410;
            f.b(bool, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
          }
        }
        else
        {
          localObject1 = locala;
          if (locala == parama) {
            continue;
          }
          jX();
          localObject1 = locala;
        }
      }
      bool = false;
    }
    if ((i <= 0) && (this.LO > 0))
    {
      localObject1 = new HashMap();
      parama = this.LN.entrySet().iterator();
      while (parama.hasNext())
      {
        localEntry = (Map.Entry)parama.next();
        if (((a)localEntry.getValue()).LP == t.a.Lz) {
          ((Map)localObject1).put((i)localEntry.getKey(), (a)localEntry.getValue());
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (!paramBoolean)) {
        ((Map)localObject1).remove(parami);
      }
      if (localObject1 != null)
      {
        parami = ((Map)localObject1).values().iterator();
        for (;;)
        {
          if (parami.hasNext())
          {
            ((a)parami.next()).jZ();
            continue;
            localObject1 = localEntry;
            if (parama != t.a.Lz) {
              break;
            }
            localObject1 = localEntry;
            if (this.LO <= 0) {
              break;
            }
            localObject1 = new HashMap();
            ((Map)localObject1).put(parami, (a)this.LN.get(parami));
            break;
          }
        }
      }
      AppMethodBeat.o(198731);
      return;
      label410:
      bool = true;
      break;
    }
  }
  
  public final boolean a(i parami)
  {
    boolean bool = false;
    AppMethodBeat.i(198708);
    synchronized (this.mLock)
    {
      Object localObject2 = (a)f.checkNotNull((a)this.LN.get(parami), "Camera must first be registered with registerCamera()");
      if (al.N("CameraStateRegistry"))
      {
        this.LL.setLength(0);
        this.LL.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", new Object[] { parami, Integer.valueOf(this.LO), Boolean.valueOf(a(((a)localObject2).LP)), ((a)localObject2).LP }));
      }
      if ((this.LO > 0) || (a(((a)localObject2).LP)))
      {
        ((a)localObject2).b(t.a.LA);
        bool = true;
      }
      if (al.N("CameraStateRegistry"))
      {
        localObject2 = this.LL;
        Locale localLocale = Locale.US;
        if (bool)
        {
          parami = "SUCCESS";
          ((StringBuilder)localObject2).append(String.format(localLocale, " --> %s", new Object[] { parami }));
          al.O("CameraStateRegistry");
        }
      }
      else
      {
        if (bool) {
          jX();
        }
        AppMethodBeat.o(198708);
        return bool;
      }
      parami = "FAIL";
    }
  }
  
  public final boolean jY()
  {
    AppMethodBeat.i(198741);
    synchronized (this.mLock)
    {
      Iterator localIterator = this.LN.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((a)((Map.Entry)localIterator.next()).getValue()).LP == t.a.LC)
        {
          AppMethodBeat.o(198741);
          return true;
        }
      }
      AppMethodBeat.o(198741);
      return false;
    }
  }
  
  public static final class a
  {
    t.a LP = null;
    private final Executor LR;
    private final v.b LS;
    
    public a(Executor paramExecutor, v.b paramb)
    {
      this.LR = paramExecutor;
      this.LS = paramb;
    }
    
    final t.a b(t.a parama)
    {
      t.a locala = this.LP;
      this.LP = parama;
      return locala;
    }
    
    final void jZ()
    {
      AppMethodBeat.i(198801);
      try
      {
        Executor localExecutor = this.LR;
        v.b localb = this.LS;
        Objects.requireNonNull(localb);
        localExecutor.execute(new v.a..ExternalSyntheticLambda0(localb));
        AppMethodBeat.o(198801);
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        al.U("CameraStateRegistry");
        AppMethodBeat.o(198801);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void gP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.v
 * JD-Core Version:    0.7.0.1
 */