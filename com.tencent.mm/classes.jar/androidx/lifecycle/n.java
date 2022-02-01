package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class n
{
  private static AtomicBoolean bHo;
  
  static
  {
    AppMethodBeat.i(194368);
    bHo = new AtomicBoolean(false);
    AppMethodBeat.o(194368);
  }
  
  static void init(Context paramContext)
  {
    AppMethodBeat.i(194362);
    if (bHo.getAndSet(true))
    {
      AppMethodBeat.o(194362);
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    AppMethodBeat.o(194362);
  }
  
  static final class a
    extends f
  {
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(194363);
      ab.j(paramActivity);
      AppMethodBeat.o(194363);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.lifecycle.n
 * JD-Core Version:    0.7.0.1
 */