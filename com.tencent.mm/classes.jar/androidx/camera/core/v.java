package androidx.camera.core;

import androidx.camera.core.impl.ab;
import androidx.camera.core.impl.ab.a;
import androidx.camera.core.impl.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class v
{
  static y G(List<ab> paramList)
  {
    AppMethodBeat.i(198556);
    paramList = new a(paramList);
    AppMethodBeat.o(198556);
    return paramList;
  }
  
  static y iL()
  {
    AppMethodBeat.i(198545);
    a locala = new a(Arrays.asList(new ab[] { new ab.a() }));
    AppMethodBeat.o(198545);
    return locala;
  }
  
  static final class a
    implements y
  {
    final List<ab> Hf;
    
    a(List<ab> paramList)
    {
      AppMethodBeat.i(198318);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.Hf = Collections.unmodifiableList(new ArrayList(paramList));
        AppMethodBeat.o(198318);
        return;
      }
      paramList = new IllegalArgumentException("Cannot set an empty CaptureStage list.");
      AppMethodBeat.o(198318);
      throw paramList;
    }
    
    public final List<ab> iM()
    {
      return this.Hf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.camera.core.v
 * JD-Core Version:    0.7.0.1
 */