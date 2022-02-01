package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class l
  implements Iterable<Intent>
{
  public final ArrayList<Intent> JS;
  public final Context JT;
  
  private l(Context paramContext)
  {
    AppMethodBeat.i(250478);
    this.JS = new ArrayList();
    this.JT = paramContext;
    AppMethodBeat.o(250478);
  }
  
  public static l O(Context paramContext)
  {
    AppMethodBeat.i(250480);
    paramContext = new l(paramContext);
    AppMethodBeat.o(250480);
    return paramContext;
  }
  
  public final l b(ComponentName paramComponentName)
  {
    AppMethodBeat.i(250481);
    int i = this.JS.size();
    try
    {
      for (paramComponentName = c.a(this.JT, paramComponentName); paramComponentName != null; paramComponentName = c.a(this.JT, paramComponentName.getComponent())) {
        this.JS.add(i, paramComponentName);
      }
      AppMethodBeat.o(250481);
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      paramComponentName = new IllegalArgumentException(paramComponentName);
      AppMethodBeat.o(250481);
      throw paramComponentName;
    }
    return this;
  }
  
  @Deprecated
  public final Iterator<Intent> iterator()
  {
    AppMethodBeat.i(250482);
    Iterator localIterator = this.JS.iterator();
    AppMethodBeat.o(250482);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.app.l
 * JD-Core Version:    0.7.0.1
 */