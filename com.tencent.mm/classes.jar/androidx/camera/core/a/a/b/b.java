package androidx.camera.core.a.a.b;

import android.media.MediaCodec;
import androidx.camera.core.a.a.a.a;
import androidx.camera.core.a.a.a.e;
import androidx.camera.core.ap;
import androidx.camera.core.ay;
import androidx.camera.core.impl.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
{
  private final boolean Qx;
  
  public b()
  {
    AppMethodBeat.i(199144);
    if (a.f(e.class) != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.Qx = bool;
      AppMethodBeat.o(199144);
      return;
    }
  }
  
  private static int d(ad paramad)
  {
    if ((paramad.Mm == MediaCodec.class) || (paramad.Mm == ay.class)) {
      return 2;
    }
    if (paramad.Mm == ap.class) {
      return 0;
    }
    return 1;
  }
  
  public final void N(List<ad> paramList)
  {
    AppMethodBeat.i(199162);
    if (!this.Qx)
    {
      AppMethodBeat.o(199162);
      return;
    }
    Collections.sort(paramList, new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(199162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */