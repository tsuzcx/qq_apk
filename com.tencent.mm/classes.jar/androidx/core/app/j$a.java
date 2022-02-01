package androidx.core.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class j$a
{
  public final String bpK;
  public CharSequence bpL;
  public CharSequence[] bpM;
  public boolean bpN;
  public int bpO;
  public final Set<String> bpP;
  public final Bundle mExtras;
  
  public j$a(String paramString)
  {
    AppMethodBeat.i(196433);
    this.bpP = new HashSet();
    this.mExtras = new Bundle();
    this.bpN = true;
    this.bpO = 0;
    this.bpK = paramString;
    AppMethodBeat.o(196433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.app.j.a
 * JD-Core Version:    0.7.0.1
 */