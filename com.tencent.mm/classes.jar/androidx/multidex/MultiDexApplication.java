package androidx.multidex;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiDexApplication
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(260724);
    super.attachBaseContext(paramContext);
    a.W(this);
    AppMethodBeat.o(260724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.multidex.MultiDexApplication
 * JD-Core Version:    0.7.0.1
 */