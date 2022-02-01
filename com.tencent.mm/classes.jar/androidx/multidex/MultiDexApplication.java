package androidx.multidex;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiDexApplication
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(201159);
    super.attachBaseContext(paramContext);
    a.am(this);
    AppMethodBeat.o(201159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.multidex.MultiDexApplication
 * JD-Core Version:    0.7.0.1
 */