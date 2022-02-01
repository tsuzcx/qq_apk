package androidx.camera.camera2.b.a.a;

import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public final a Fo;
  
  public b(Surface paramSurface)
  {
    AppMethodBeat.i(198138);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Fo = new e(paramSurface);
      AppMethodBeat.o(198138);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.Fo = new d(paramSurface);
      AppMethodBeat.o(198138);
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Fo = new c(paramSurface);
      AppMethodBeat.o(198138);
      return;
    }
    this.Fo = new f(paramSurface);
    AppMethodBeat.o(198138);
  }
  
  b(a parama)
  {
    this.Fo = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198154);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(198154);
      return false;
    }
    boolean bool = this.Fo.equals(((b)paramObject).Fo);
    AppMethodBeat.o(198154);
    return bool;
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(198148);
    Surface localSurface = this.Fo.getSurface();
    AppMethodBeat.o(198148);
    return localSurface;
  }
  
  public final Object hV()
  {
    AppMethodBeat.i(198160);
    Object localObject = this.Fo.hY();
    AppMethodBeat.o(198160);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198156);
    int i = this.Fo.hashCode();
    AppMethodBeat.o(198156);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract Surface getSurface();
    
    public abstract String hX();
    
    public abstract Object hY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */