package androidx.core.d;

import android.util.Base64;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
{
  final String Ll;
  final String Lm;
  final String Ln;
  final List<List<byte[]>> Lo;
  final int Lp;
  final String Lq;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    AppMethodBeat.i(251055);
    this.Ll = ((String)g.checkNotNull(paramString1));
    this.Lm = ((String)g.checkNotNull(paramString2));
    this.Ln = ((String)g.checkNotNull(paramString3));
    this.Lo = ((List)g.checkNotNull(paramList));
    this.Lp = 0;
    this.Lq = (this.Ll + "-" + this.Lm + "-" + this.Ln);
    AppMethodBeat.o(251055);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251057);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FontRequest {mProviderAuthority: " + this.Ll + ", mProviderPackage: " + this.Lm + ", mQuery: " + this.Ln + ", mCertificates:");
    int i = 0;
    while (i < this.Lo.size())
    {
      ((StringBuilder)localObject).append(" [");
      List localList = (List)this.Lo.get(i);
      int j = 0;
      while (j < localList.size())
      {
        ((StringBuilder)localObject).append(" \"");
        ((StringBuilder)localObject).append(Base64.encodeToString((byte[])localList.get(j), 0));
        ((StringBuilder)localObject).append("\"");
        j += 1;
      }
      ((StringBuilder)localObject).append(" ]");
      i += 1;
    }
    ((StringBuilder)localObject).append("}");
    ((StringBuilder)localObject).append("mCertificatesArray: " + this.Lp);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(251057);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.d.a
 * JD-Core Version:    0.7.0.1
 */