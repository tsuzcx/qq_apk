package androidx.camera.extensions;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum ExtensionsManager$ExtensionsAvailability
{
  static
  {
    AppMethodBeat.i(198205);
    LIBRARY_AVAILABLE = new ExtensionsAvailability("LIBRARY_AVAILABLE", 0);
    LIBRARY_UNAVAILABLE_ERROR_LOADING = new ExtensionsAvailability("LIBRARY_UNAVAILABLE_ERROR_LOADING", 1);
    LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION = new ExtensionsAvailability("LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION", 2);
    NONE = new ExtensionsAvailability("NONE", 3);
    $VALUES = new ExtensionsAvailability[] { LIBRARY_AVAILABLE, LIBRARY_UNAVAILABLE_ERROR_LOADING, LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION, NONE };
    AppMethodBeat.o(198205);
  }
  
  private ExtensionsManager$ExtensionsAvailability() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.camera.extensions.ExtensionsManager.ExtensionsAvailability
 * JD-Core Version:    0.7.0.1
 */