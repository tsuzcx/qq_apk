package android.support.v4.c;

import android.support.v4.e.l;
import android.util.Base64;
import java.util.List;

public final class a
{
  final String DI;
  final String DJ;
  final String DK;
  final List<List<byte[]>> DL;
  final int DM;
  final String DN;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.DI = ((String)l.checkNotNull(paramString1));
    this.DJ = ((String)l.checkNotNull(paramString2));
    this.DK = ((String)l.checkNotNull(paramString3));
    this.DL = ((List)l.checkNotNull(paramList));
    this.DM = 0;
    this.DN = (this.DI + "-" + this.DJ + "-" + this.DK);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.DI + ", mProviderPackage: " + this.DJ + ", mQuery: " + this.DK + ", mCertificates:");
    int i = 0;
    while (i < this.DL.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.DL.get(i);
      int j = 0;
      while (j < localList.size())
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])localList.get(j), 0));
        localStringBuilder.append("\"");
        j += 1;
      }
      localStringBuilder.append(" ]");
      i += 1;
    }
    localStringBuilder.append("}");
    localStringBuilder.append("mCertificatesArray: " + this.DM);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.7.0.1
 */