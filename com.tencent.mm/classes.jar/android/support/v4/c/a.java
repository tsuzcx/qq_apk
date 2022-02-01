package android.support.v4.c;

import android.support.v4.e.m;
import android.util.Base64;
import java.util.List;

public final class a
{
  final int KA;
  final String KB;
  final String Kw;
  final String Kx;
  final String Ky;
  final List<List<byte[]>> Kz;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.Kw = ((String)m.checkNotNull(paramString1));
    this.Kx = ((String)m.checkNotNull(paramString2));
    this.Ky = ((String)m.checkNotNull(paramString3));
    this.Kz = ((List)m.checkNotNull(paramList));
    this.KA = 0;
    this.KB = (this.Kw + "-" + this.Kx + "-" + this.Ky);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.Kw + ", mProviderPackage: " + this.Kx + ", mQuery: " + this.Ky + ", mCertificates:");
    int i = 0;
    while (i < this.Kz.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.Kz.get(i);
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
    localStringBuilder.append("mCertificatesArray: " + this.KA);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.7.0.1
 */