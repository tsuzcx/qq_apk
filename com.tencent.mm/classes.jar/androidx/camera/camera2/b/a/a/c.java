package androidx.camera.camera2.b.a.a;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

class c
  extends f
{
  c(Surface paramSurface)
  {
    this(new a(new OutputConfiguration(paramSurface)));
    AppMethodBeat.i(198130);
    AppMethodBeat.o(198130);
  }
  
  c(Object paramObject)
  {
    super(paramObject);
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(198141);
    Surface localSurface = ((OutputConfiguration)hY()).getSurface();
    AppMethodBeat.o(198141);
    return localSurface;
  }
  
  public String hX()
  {
    return ((a)this.mObject).Fq;
  }
  
  public Object hY()
  {
    AppMethodBeat.i(198149);
    androidx.core.f.f.checkArgument(this.mObject instanceof a);
    OutputConfiguration localOutputConfiguration = ((a)this.mObject).Fp;
    AppMethodBeat.o(198149);
    return localOutputConfiguration;
  }
  
  static final class a
  {
    final OutputConfiguration Fp;
    String Fq;
    boolean Fr;
    
    a(OutputConfiguration paramOutputConfiguration)
    {
      this.Fp = paramOutputConfiguration;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198116);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(198116);
        return false;
      }
      paramObject = (a)paramObject;
      if ((Objects.equals(this.Fp, paramObject.Fp)) && (this.Fr == paramObject.Fr) && (Objects.equals(this.Fq, paramObject.Fq)))
      {
        AppMethodBeat.o(198116);
        return true;
      }
      AppMethodBeat.o(198116);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(198120);
      int k = this.Fp.hashCode() ^ 0x1F;
      if (this.Fr)
      {
        i = 1;
        k = i ^ (k << 5) - k;
        if (this.Fq != null) {
          break label62;
        }
      }
      label62:
      for (int i = j;; i = this.Fq.hashCode())
      {
        AppMethodBeat.o(198120);
        return (k << 5) - k ^ i;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */