package android.support.v4.c;

import android.support.v4.e.m;
import android.util.Base64;
import java.util.List;

public final class a
{
  final String Nj;
  final String Nk;
  final String Nl;
  final List<List<byte[]>> Nm;
  final int Nn;
  final String No;
  
  public a(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.Nj = ((String)m.checkNotNull(paramString1));
    this.Nk = ((String)m.checkNotNull(paramString2));
    this.Nl = ((String)m.checkNotNull(paramString3));
    this.Nm = ((List)m.checkNotNull(paramList));
    this.Nn = 0;
    this.No = (this.Nj + "-" + this.Nk + "-" + this.Nl);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FontRequest {mProviderAuthority: " + this.Nj + ", mProviderPackage: " + this.Nk + ", mQuery: " + this.Nl + ", mCertificates:");
    int i = 0;
    while (i < this.Nm.size())
    {
      localStringBuilder.append(" [");
      List localList = (List)this.Nm.get(i);
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
    localStringBuilder.append("mCertificatesArray: " + this.Nn);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.a
 * JD-Core Version:    0.7.0.1
 */