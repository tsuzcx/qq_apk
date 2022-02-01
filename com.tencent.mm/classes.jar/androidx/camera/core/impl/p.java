package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.k;
import androidx.camera.core.y;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public abstract interface p
  extends k
{
  public static final p Lx = new p()
  {
    public final f<androidx.camera.core.z> a(y paramAnonymousy)
    {
      AppMethodBeat.i(198629);
      paramAnonymousy = e.v(new androidx.camera.core.z(false));
      AppMethodBeat.o(198629);
      return paramAnonymousy;
    }
    
    public final f<List<Void>> a(List<z> paramAnonymousList, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      AppMethodBeat.i(198625);
      paramAnonymousList = e.v(Collections.emptyList());
      AppMethodBeat.o(198625);
      return paramAnonymousList;
    }
    
    public final void b(ac paramAnonymousac) {}
    
    public final void gs() {}
    
    public final ac gt()
    {
      return null;
    }
    
    public final Rect gx()
    {
      AppMethodBeat.i(198627);
      Rect localRect = new Rect();
      AppMethodBeat.o(198627);
      return localRect;
    }
    
    public final f<Void> h(float paramAnonymousFloat)
    {
      AppMethodBeat.i(198630);
      f localf = e.v(null);
      AppMethodBeat.o(198630);
      return localf;
    }
    
    public final void setFlashMode(int paramAnonymousInt) {}
  };
  
  public abstract f<List<Void>> a(List<z> paramList, int paramInt1, int paramInt2);
  
  public abstract void b(ac paramac);
  
  public abstract void gs();
  
  public abstract ac gt();
  
  public abstract Rect gx();
  
  public abstract void setFlashMode(int paramInt);
  
  public static final class a
    extends Exception
  {
    private j Ly;
    
    public a(j paramj)
    {
      this.Ly = paramj;
    }
  }
  
  public static abstract interface b
  {
    public abstract void gQ();
    
    public abstract void o(List<z> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.p
 * JD-Core Version:    0.7.0.1
 */