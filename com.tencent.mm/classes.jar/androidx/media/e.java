package androidx.media;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  static final boolean DEBUG;
  private static final Object sLock;
  
  static
  {
    AppMethodBeat.i(242833);
    DEBUG = Log.isLoggable("MediaSessionManager", 3);
    sLock = new Object();
    AppMethodBeat.o(242833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.media.e
 * JD-Core Version:    0.7.0.1
 */