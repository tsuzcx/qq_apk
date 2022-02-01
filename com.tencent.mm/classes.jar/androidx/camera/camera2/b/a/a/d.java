package androidx.camera.camera2.b.a.a;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

class d
  extends c
{
  d(Surface paramSurface)
  {
    this(new a(new OutputConfiguration(paramSurface)));
    AppMethodBeat.i(198133);
    AppMethodBeat.o(198133);
  }
  
  d(Object paramObject)
  {
    super(paramObject);
  }
  
  public String hX()
  {
    return ((a)this.mObject).Fq;
  }
  
  public Object hY()
  {
    AppMethodBeat.i(198147);
    f.checkArgument(this.mObject instanceof a);
    OutputConfiguration localOutputConfiguration = ((a)this.mObject).Fp;
    AppMethodBeat.o(198147);
    return localOutputConfiguration;
  }
  
  static final class a
  {
    final OutputConfiguration Fp;
    String Fq;
    
    a(OutputConfiguration paramOutputConfiguration)
    {
      this.Fp = paramOutputConfiguration;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198162);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(198162);
        return false;
      }
      paramObject = (a)paramObject;
      if ((Objects.equals(this.Fp, paramObject.Fp)) && (Objects.equals(this.Fq, paramObject.Fq)))
      {
        AppMethodBeat.o(198162);
        return true;
      }
      AppMethodBeat.o(198162);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(198165);
      int j = this.Fp.hashCode() ^ 0x1F;
      if (this.Fq == null) {}
      for (int i = 0;; i = this.Fq.hashCode())
      {
        AppMethodBeat.o(198165);
        return i ^ (j << 5) - j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */