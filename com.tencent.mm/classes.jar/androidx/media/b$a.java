package androidx.media;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  b.b bKd;
  
  public b$a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193078);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.bKd = new d.a(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(193078);
      return;
    }
    this.bKd = new e.a(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(193078);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193084);
    if (this == paramObject)
    {
      AppMethodBeat.o(193084);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(193084);
      return false;
    }
    boolean bool = this.bKd.equals(((a)paramObject).bKd);
    AppMethodBeat.o(193084);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193094);
    int i = this.bKd.hashCode();
    AppMethodBeat.o(193094);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.b.a
 * JD-Core Version:    0.7.0.1
 */