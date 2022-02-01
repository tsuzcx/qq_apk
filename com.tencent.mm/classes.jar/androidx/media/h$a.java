package androidx.media;

import android.text.TextUtils;
import androidx.core.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$a
  implements e.b
{
  private int acw;
  private int acx;
  private String mPackageName;
  
  h$a(String paramString, int paramInt1, int paramInt2)
  {
    this.mPackageName = paramString;
    this.acw = paramInt1;
    this.acx = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242841);
    if (this == paramObject)
    {
      AppMethodBeat.o(242841);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(242841);
      return false;
    }
    paramObject = (a)paramObject;
    if ((TextUtils.equals(this.mPackageName, paramObject.mPackageName)) && (this.acw == paramObject.acw) && (this.acx == paramObject.acx))
    {
      AppMethodBeat.o(242841);
      return true;
    }
    AppMethodBeat.o(242841);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(242842);
    int i = d.hash(new Object[] { this.mPackageName, Integer.valueOf(this.acw), Integer.valueOf(this.acx) });
    AppMethodBeat.o(242842);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.h.a
 * JD-Core Version:    0.7.0.1
 */