package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import androidx.core.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  implements b.b
{
  final MediaSessionManager.RemoteUserInfo bKe;
  
  d$a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193087);
    this.bKe = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(193087);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193106);
    if (this == paramObject)
    {
      AppMethodBeat.o(193106);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(193106);
      return false;
    }
    paramObject = (a)paramObject;
    boolean bool = this.bKe.equals(paramObject.bKe);
    AppMethodBeat.o(193106);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193097);
    int i = c.hash(new Object[] { this.bKe });
    AppMethodBeat.o(193097);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.d.a
 * JD-Core Version:    0.7.0.1
 */