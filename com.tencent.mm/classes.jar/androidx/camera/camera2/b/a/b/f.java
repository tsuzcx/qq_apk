package androidx.camera.camera2.b.a.b;

import androidx.camera.camera2.b.a.h;
import androidx.camera.core.impl.az;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public static az d(h paramh)
  {
    AppMethodBeat.i(197960);
    ArrayList localArrayList = new ArrayList();
    if (a.c(paramh)) {
      localArrayList.add(new a(paramh));
    }
    if (b.c(paramh)) {
      localArrayList.add(new b());
    }
    if (m.il()) {
      localArrayList.add(new m());
    }
    if (d.c(paramh)) {
      localArrayList.add(new d(paramh));
    }
    if (l.c(paramh)) {
      localArrayList.add(new l());
    }
    if (e.c(paramh)) {
      localArrayList.add(new e());
    }
    if (s.il()) {
      localArrayList.add(new s());
    }
    if (c.c(paramh)) {
      localArrayList.add(new c());
    }
    paramh = new az(localArrayList);
    AppMethodBeat.o(197960);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.f
 * JD-Core Version:    0.7.0.1
 */