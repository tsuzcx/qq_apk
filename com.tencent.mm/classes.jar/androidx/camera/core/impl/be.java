package androidx.camera.core.impl;

import androidx.camera.core.af;
import androidx.camera.core.ag;
import androidx.camera.core.impl.a.b.e;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class be
  implements am
{
  private final int Nn;
  public final ag No;
  
  public be(ag paramag, String paramString)
  {
    AppMethodBeat.i(198805);
    af localaf = paramag.it();
    if (localaf == null)
    {
      paramag = new IllegalArgumentException("ImageProxy has no associated ImageInfo");
      AppMethodBeat.o(198805);
      throw paramag;
    }
    paramString = (Integer)localaf.go().getTag(paramString);
    if (paramString == null)
    {
      paramag = new IllegalArgumentException("ImageProxy has no associated tag");
      AppMethodBeat.o(198805);
      throw paramag;
    }
    this.Nn = paramString.intValue();
    this.No = paramag;
    AppMethodBeat.o(198805);
  }
  
  public final f<ag> aV(int paramInt)
  {
    AppMethodBeat.i(198810);
    if (paramInt != this.Nn)
    {
      localf = e.i(new IllegalArgumentException("Capture id does not exist in the bundle"));
      AppMethodBeat.o(198810);
      return localf;
    }
    f localf = e.v(this.No);
    AppMethodBeat.o(198810);
    return localf;
  }
  
  public final List<Integer> js()
  {
    AppMethodBeat.i(198820);
    List localList = Collections.singletonList(Integer.valueOf(this.Nn));
    AppMethodBeat.o(198820);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.be
 * JD-Core Version:    0.7.0.1
 */