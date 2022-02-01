package androidx.core.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class i$a
{
  public final String JH;
  public CharSequence JI;
  public CharSequence[] JJ;
  public boolean JK;
  public int JL;
  public final Set<String> JM;
  public final Bundle mExtras;
  
  public i$a(String paramString)
  {
    AppMethodBeat.i(250459);
    this.JM = new HashSet();
    this.mExtras = new Bundle();
    this.JK = true;
    this.JL = 0;
    this.JH = paramString;
    AppMethodBeat.o(250459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.core.app.i.a
 * JD-Core Version:    0.7.0.1
 */