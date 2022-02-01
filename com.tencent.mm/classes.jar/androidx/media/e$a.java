package androidx.media;

import android.text.TextUtils;
import androidx.core.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
  implements b.b
{
  private int bKf;
  private int bKg;
  private String mPackageName;
  
  e$a(String paramString, int paramInt1, int paramInt2)
  {
    this.mPackageName = paramString;
    this.bKf = paramInt1;
    this.bKg = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193022);
    if (this == paramObject)
    {
      AppMethodBeat.o(193022);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(193022);
      return false;
    }
    paramObject = (a)paramObject;
    if ((TextUtils.equals(this.mPackageName, paramObject.mPackageName)) && (this.bKf == paramObject.bKf) && (this.bKg == paramObject.bKg))
    {
      AppMethodBeat.o(193022);
      return true;
    }
    AppMethodBeat.o(193022);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193028);
    int i = c.hash(new Object[] { this.mPackageName, Integer.valueOf(this.bKf), Integer.valueOf(this.bKg) });
    AppMethodBeat.o(193028);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.e.a
 * JD-Core Version:    0.7.0.1
 */