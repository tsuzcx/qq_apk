package androidx.camera.extensions;

import androidx.c.a.b.a;
import androidx.camera.core.al;
import androidx.camera.core.p;
import androidx.camera.extensions.impl.InitializerImpl.OnExtensionsDeinitializedCallback;
import androidx.camera.extensions.impl.InitializerImpl.OnExtensionsInitializedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ExtensionsManager
{
  private static final Object QA;
  private static ExtensionsManager QB;
  private final ExtensionsManager.ExtensionsAvailability QC;
  private final a QD;
  
  static
  {
    AppMethodBeat.i(198226);
    QA = new Object();
    AppMethodBeat.o(198226);
  }
  
  private ExtensionsManager(ExtensionsManager.ExtensionsAvailability paramExtensionsAvailability, p paramp)
  {
    AppMethodBeat.i(198220);
    this.QC = paramExtensionsAvailability;
    this.QD = new a(paramp);
    AppMethodBeat.o(198220);
  }
  
  static ExtensionsManager a(ExtensionsManager.ExtensionsAvailability paramExtensionsAvailability, p paramp)
  {
    AppMethodBeat.i(198212);
    synchronized (QA)
    {
      if (QB != null)
      {
        paramExtensionsAvailability = QB;
        AppMethodBeat.o(198212);
        return paramExtensionsAvailability;
      }
      paramExtensionsAvailability = new ExtensionsManager(paramExtensionsAvailability, paramp);
      QB = paramExtensionsAvailability;
      AppMethodBeat.o(198212);
      return paramExtensionsAvailability;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.extensions.ExtensionsManager
 * JD-Core Version:    0.7.0.1
 */