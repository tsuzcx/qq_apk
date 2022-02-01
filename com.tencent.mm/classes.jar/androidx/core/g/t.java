package androidx.core.g;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  Object Nt;
  
  private t(Object paramObject)
  {
    this.Nt = paramObject;
  }
  
  public static t U(Context paramContext)
  {
    AppMethodBeat.i(251556);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext = new t(PointerIcon.getSystemIcon(paramContext, 1002));
      AppMethodBeat.o(251556);
      return paramContext;
    }
    paramContext = new t(null);
    AppMethodBeat.o(251556);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.t
 * JD-Core Version:    0.7.0.1
 */