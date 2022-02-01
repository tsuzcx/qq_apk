package androidx.camera.core.impl;

import androidx.camera.core.ax;
import androidx.camera.core.ax.c;
import androidx.camera.core.i;
import androidx.camera.core.k;
import androidx.camera.core.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public abstract class t
  implements ax.c, i
{
  public void a(m paramm) {}
  
  public abstract void e(Collection<ax> paramCollection);
  
  public abstract void g(Collection<ax> paramCollection);
  
  public abstract s gK();
  
  public abstract p gO();
  
  public final k iF()
  {
    return gO();
  }
  
  public final n iG()
  {
    return gK();
  }
  
  public static enum a
  {
    final boolean LG;
    
    static
    {
      AppMethodBeat.i(198855);
      Lz = new a("PENDING_OPEN", 0, false);
      LA = new a("OPENING", 1, true);
      LB = new a("OPEN", 2, true);
      LC = new a("CLOSING", 3, true);
      LD = new a("CLOSED", 4, false);
      LE = new a("RELEASING", 5, true);
      LF = new a("RELEASED", 6, false);
      LH = new a[] { Lz, LA, LB, LC, LD, LE, LF };
      AppMethodBeat.o(198855);
    }
    
    private a(boolean paramBoolean)
    {
      this.LG = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.t
 * JD-Core Version:    0.7.0.1
 */