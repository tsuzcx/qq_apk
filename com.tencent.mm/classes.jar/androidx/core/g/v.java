package androidx.core.g;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
{
  Object btx;
  
  private v(Object paramObject)
  {
    this.btx = paramObject;
  }
  
  public static v aj(Context paramContext)
  {
    AppMethodBeat.i(195678);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext = new v(PointerIcon.getSystemIcon(paramContext, 1002));
      AppMethodBeat.o(195678);
      return paramContext;
    }
    paramContext = new v(null);
    AppMethodBeat.o(195678);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.v
 * JD-Core Version:    0.7.0.1
 */