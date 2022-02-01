package androidx.core.d;

import android.net.Uri;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$b
{
  public final int bqg;
  public final boolean bqh;
  public final int bqj;
  public final int mResultCode;
  public final Uri mUri;
  
  @Deprecated
  public e$b(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(196249);
    this.mUri = ((Uri)f.checkNotNull(paramUri));
    this.bqj = paramInt1;
    this.bqg = paramInt2;
    this.bqh = paramBoolean;
    this.mResultCode = paramInt3;
    AppMethodBeat.o(196249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.e.b
 * JD-Core Version:    0.7.0.1
 */