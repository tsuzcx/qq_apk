package androidx.camera.core.impl.a;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static Context R(Context paramContext)
  {
    AppMethodBeat.i(198982);
    Context localContext = paramContext.getApplicationContext();
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramContext = a.T(paramContext);
      if (paramContext != null)
      {
        paramContext = a.f(localContext, paramContext);
        AppMethodBeat.o(198982);
        return paramContext;
      }
    }
    AppMethodBeat.o(198982);
    return localContext;
  }
  
  public static Application S(Context paramContext)
  {
    AppMethodBeat.i(198997);
    paramContext = R(paramContext);
    if ((paramContext instanceof ContextWrapper)) {
      if (!(paramContext instanceof Application)) {}
    }
    for (paramContext = (Application)paramContext;; paramContext = null)
    {
      AppMethodBeat.o(198997);
      return paramContext;
      paramContext = a((ContextWrapper)paramContext);
      break;
    }
  }
  
  private static Context a(ContextWrapper paramContextWrapper)
  {
    AppMethodBeat.i(198990);
    Context localContext = paramContextWrapper.getBaseContext();
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramContextWrapper = a.T(paramContextWrapper);
      if (paramContextWrapper != null)
      {
        paramContextWrapper = a.f(localContext, paramContextWrapper);
        AppMethodBeat.o(198990);
        return paramContextWrapper;
      }
    }
    AppMethodBeat.o(198990);
    return localContext;
  }
  
  static final class a
  {
    static String T(Context paramContext)
    {
      AppMethodBeat.i(198966);
      paramContext = paramContext.getAttributionTag();
      AppMethodBeat.o(198966);
      return paramContext;
    }
    
    static Context f(Context paramContext, String paramString)
    {
      AppMethodBeat.i(198959);
      paramContext = paramContext.createAttributionContext(paramString);
      AppMethodBeat.o(198959);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.d
 * JD-Core Version:    0.7.0.1
 */