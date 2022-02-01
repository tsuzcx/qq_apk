package androidx.camera.camera2.c;

import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.ba;
import androidx.camera.core.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  implements ba
{
  public final ac Dp;
  
  public c(ac paramac)
  {
    this.Dp = paramac;
  }
  
  public final ac hx()
  {
    return this.Dp;
  }
  
  public static final class a
    implements x<c>
  {
    private final at zH;
    
    public a()
    {
      AppMethodBeat.i(197299);
      this.zH = at.ku();
      AppMethodBeat.o(197299);
    }
    
    public static a c(ac paramac)
    {
      AppMethodBeat.i(197302);
      a locala = new a();
      paramac.a("camera2.captureRequest.option.", new c.a..ExternalSyntheticLambda0(locala, paramac));
      AppMethodBeat.o(197302);
      return locala;
    }
    
    public final as fU()
    {
      return this.zH;
    }
    
    public final c ir()
    {
      AppMethodBeat.i(197312);
      c localc = new c(av.l(this.zH));
      AppMethodBeat.o(197312);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.c.c
 * JD-Core Version:    0.7.0.1
 */