package androidx.camera.camera2.b.a.b;

import androidx.camera.core.impl.ay;
import androidx.camera.core.impl.az;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private static final az FG;
  
  static
  {
    AppMethodBeat.i(197992);
    ArrayList localArrayList = new ArrayList();
    if (k.load()) {
      localArrayList.add(new k());
    }
    if (p.load()) {
      localArrayList.add(new p());
    }
    if (n.load()) {
      localArrayList.add(new n());
    }
    if (i.load()) {
      localArrayList.add(new i());
    }
    if (g.load()) {
      localArrayList.add(new g());
    }
    if (o.load()) {
      localArrayList.add(new o());
    }
    if (q.load()) {
      localArrayList.add(new q());
    }
    if (j.load()) {
      localArrayList.add(new j());
    }
    FG = new az(localArrayList);
    AppMethodBeat.o(197992);
  }
  
  public static <T extends ay> T f(Class<T> paramClass)
  {
    AppMethodBeat.i(197981);
    paramClass = FG.f(paramClass);
    AppMethodBeat.o(197981);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.h
 * JD-Core Version:    0.7.0.1
 */