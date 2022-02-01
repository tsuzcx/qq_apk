package androidx.media;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  e.b acu;
  
  public e$a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242829);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.acu = new g.a(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(242829);
      return;
    }
    this.acu = new h.a(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(242829);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242830);
    if (this == paramObject)
    {
      AppMethodBeat.o(242830);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(242830);
      return false;
    }
    boolean bool = this.acu.equals(((a)paramObject).acu);
    AppMethodBeat.o(242830);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(242832);
    int i = this.acu.hashCode();
    AppMethodBeat.o(242832);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.e.a
 * JD-Core Version:    0.7.0.1
 */