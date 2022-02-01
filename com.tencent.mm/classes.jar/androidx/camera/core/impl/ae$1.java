package androidx.camera.core.impl;

import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.core.impl.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

final class ae$1
  implements c<List<Surface>>
{
  ae$1(boolean paramBoolean, b.a parama, ScheduledFuture paramScheduledFuture) {}
  
  public final void onFailure(Throwable paramThrowable)
  {
    AppMethodBeat.i(198746);
    this.val$completer.ap(Collections.unmodifiableList(Collections.emptyList()));
    this.Mo.cancel(true);
    AppMethodBeat.o(198746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.ae.1
 * JD-Core Version:    0.7.0.1
 */