package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.a.a.a;
import androidx.core.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static Menu a(Context paramContext, a parama)
  {
    AppMethodBeat.i(200897);
    paramContext = new r(paramContext, parama);
    AppMethodBeat.o(200897);
    return paramContext;
  }
  
  public static MenuItem a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(200914);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext = new l(paramContext, paramb);
      AppMethodBeat.o(200914);
      return paramContext;
    }
    paramContext = new k(paramContext, paramb);
    AppMethodBeat.o(200914);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.q
 * JD-Core Version:    0.7.0.1
 */