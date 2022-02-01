package androidx.camera.core.a.a.a;

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
    AppMethodBeat.i(199161);
    ArrayList localArrayList = new ArrayList();
    if (b.load()) {
      localArrayList.add(new b());
    }
    if (e.load()) {
      localArrayList.add(new e());
    }
    FG = new az(localArrayList);
    AppMethodBeat.o(199161);
  }
  
  public static <T extends ay> T f(Class<T> paramClass)
  {
    AppMethodBeat.i(199152);
    paramClass = FG.f(paramClass);
    AppMethodBeat.o(199152);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */