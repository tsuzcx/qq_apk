package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class i
{
  private static AtomicBoolean ZU;
  
  static
  {
    AppMethodBeat.i(191184);
    ZU = new AtomicBoolean(false);
    AppMethodBeat.o(191184);
  }
  
  static void init(Context paramContext)
  {
    AppMethodBeat.i(191182);
    if (ZU.getAndSet(true))
    {
      AppMethodBeat.o(191182);
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    AppMethodBeat.o(191182);
  }
  
  static final class a
    extends d
  {
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(191177);
      v.h(paramActivity);
      AppMethodBeat.o(191177);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.lifecycle.i
 * JD-Core Version:    0.7.0.1
 */