package androidx.camera.extensions.a.a.a;

import androidx.camera.core.impl.ay;
import androidx.camera.core.impl.az;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static final az FG;
  
  static
  {
    AppMethodBeat.i(198221);
    ArrayList localArrayList = new ArrayList();
    if (b.load()) {
      localArrayList.add(new b());
    }
    FG = new az(localArrayList);
    AppMethodBeat.o(198221);
  }
  
  public static <T extends ay> T f(Class<T> paramClass)
  {
    AppMethodBeat.i(198210);
    paramClass = FG.f(paramClass);
    AppMethodBeat.o(198210);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.extensions.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */