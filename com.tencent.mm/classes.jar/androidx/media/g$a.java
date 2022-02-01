package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import androidx.core.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$a
  implements e.b
{
  final MediaSessionManager.RemoteUserInfo acv;
  
  g$a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242835);
    this.acv = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(242835);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242837);
    if (this == paramObject)
    {
      AppMethodBeat.o(242837);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(242837);
      return false;
    }
    paramObject = (a)paramObject;
    boolean bool = this.acv.equals(paramObject.acv);
    AppMethodBeat.o(242837);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(242836);
    int i = d.hash(new Object[] { this.acv });
    AppMethodBeat.o(242836);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.g.a
 * JD-Core Version:    0.7.0.1
 */