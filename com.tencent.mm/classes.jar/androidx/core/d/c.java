package androidx.core.d;

import android.util.Base64;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
{
  final String brB;
  final String brC;
  final String brD;
  final List<List<byte[]>> brE;
  final int brF;
  final String brG;
  
  public c(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    AppMethodBeat.i(196285);
    this.brB = ((String)f.checkNotNull(paramString1));
    this.brC = ((String)f.checkNotNull(paramString2));
    this.brD = ((String)f.checkNotNull(paramString3));
    this.brE = ((List)f.checkNotNull(paramList));
    this.brF = 0;
    this.brG = (paramString1 + "-" + paramString2 + "-" + paramString3);
    AppMethodBeat.o(196285);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196295);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FontRequest {mProviderAuthority: " + this.brB + ", mProviderPackage: " + this.brC + ", mQuery: " + this.brD + ", mCertificates:");
    int i = 0;
    while (i < this.brE.size())
    {
      ((StringBuilder)localObject).append(" [");
      List localList = (List)this.brE.get(i);
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
    ((StringBuilder)localObject).append("mCertificatesArray: " + this.brF);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(196295);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.c
 * JD-Core Version:    0.7.0.1
 */